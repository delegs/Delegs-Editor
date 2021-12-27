package de.signWritingEditor.client.model.material.positionedMovementSymbols;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import de.signWritingEditor.shared.model.domainValue.Symbol;
import de.signWritingEditor.shared.model.material.MovementBaseSymbol;
import de.signWritingEditor.shared.model.material.PositionedMovementSymbol;
import de.signWritingEditor.shared.model.material.SymbolFactory;

public class CurvesParallelFloorPlaneMovementSymbolTest implements PositionedMovementSymbolTestInterface {

	private PositionedMovementSymbol curveFloorPlaneSmall;
	private PositionedMovementSymbol curveFloorPlaneSmallEmptyArrowhead;
	private PositionedMovementSymbol curveFloorPlaneSmallSchemaArrowhead;
	private PositionedMovementSymbol curveFloorPlaneSmallMirrored;
	private PositionedMovementSymbol curveFloorPlaneSmallEmptyArrowheadMirrored;
	private PositionedMovementSymbol curveFloorPlaneSmallSchemaArrowheadMirrored;

	private PositionedMovementSymbol curveFloorPlaneMedium1;
	private PositionedMovementSymbol curveFloorPlaneMedium1EmptyArrowhead;
	private PositionedMovementSymbol curveFloorPlaneMedium1SchemaArrowhead;
	private PositionedMovementSymbol curveFloorPlaneMedium1Mirrored;
	private PositionedMovementSymbol curveFloorPlaneMedium1EmptyArrowheadMirrored;
	private PositionedMovementSymbol curveFloorPlaneMedium1SchemaArrowheadMirrored;

	private PositionedMovementSymbol curveFloorPlaneMedium2;
	private PositionedMovementSymbol curveFloorPlaneMedium2EmptyArrowhead;
	private PositionedMovementSymbol curveFloorPlaneMedium2SchemaArrowhead;
	private PositionedMovementSymbol curveFloorPlaneMedium2Mirrored;
	private PositionedMovementSymbol curveFloorPlaneMedium2EmptyArrowheadMirrored;
	private PositionedMovementSymbol curveFloorPlaneMedium2SchemaArrowheadMirrored;

	private PositionedMovementSymbol curveFloorPlaneLarge;
	private PositionedMovementSymbol curveFloorPlaneLargeEmptyArrowhead;
	private PositionedMovementSymbol curveFloorPlaneLargeSchemaArrowhead;
	private PositionedMovementSymbol curveFloorPlaneLargeMirrored;
	private PositionedMovementSymbol curveFloorPlaneLargeEmptyArrowheadMirrored;
	private PositionedMovementSymbol curveFloorPlaneLargeSchemaArrowheadMirrored;

	private PositionedMovementSymbol curveFloorPlaneCombined;
	private PositionedMovementSymbol curveFloorPlaneCombinedEmptyArrowhead;
	private PositionedMovementSymbol curveFloorPlaneCombinedSchemaArrowhead;
	private PositionedMovementSymbol curveFloorPlaneCombinedMirrored;
	private PositionedMovementSymbol curveFloorPlaneCombinedEmptyArrowheadMirrored;
	private PositionedMovementSymbol curveFloorPlaneCombinedSchemaArrowheadMirrored;

	private PositionedMovementSymbol humpFloorPlaneSmall;
	private PositionedMovementSymbol humpFloorPlaneSmallEmptyArrowhead;
	private PositionedMovementSymbol humpFloorPlaneSmallSchemaArrowhead;
	private PositionedMovementSymbol humpFloorPlaneSmallMirrored;
	private PositionedMovementSymbol humpFloorPlaneSmallEmptyArrowheadMirrored;
	private PositionedMovementSymbol humpFloorPlaneSmallSchemaArrowheadMirrored;

	private PositionedMovementSymbol loopFloorPlaneSmall;
	private PositionedMovementSymbol loopFloorPlaneSmallEmptyArrowhead;
	private PositionedMovementSymbol loopFloorPlaneSmallSchemaArrowhead;
	private PositionedMovementSymbol loopFloorPlaneSmallMirrored;
	private PositionedMovementSymbol loopFloorPlaneSmallEmptyArrowheadMirrored;
	private PositionedMovementSymbol loopFloorPlaneSmallSchemaArrowheadMirrored;

	private PositionedMovementSymbol waveFloorPlaneSnake;
	private PositionedMovementSymbol waveFloorPlaneSnakeEmptyArrowhead;
	private PositionedMovementSymbol waveFloorPlaneSnakeSchemaArrowhead;
	private PositionedMovementSymbol waveFloorPlaneSnakeMirrored;
	private PositionedMovementSymbol waveFloorPlaneSnakeEmptyArrowheadMirrored;
	private PositionedMovementSymbol waveFloorPlaneSnakeSchemaArrowheadMirrored;

	private PositionedMovementSymbol waveFloorPlaneSmall;
	private PositionedMovementSymbol waveFloorPlaneSmallEmptyArrowhead;
	private PositionedMovementSymbol waveFloorPlaneSmallSchemaArrowhead;
	private PositionedMovementSymbol waveFloorPlaneSmallMirrored;
	private PositionedMovementSymbol waveFloorPlaneSmallEmptyArrowheadMirrored;
	private PositionedMovementSymbol waveFloorPlaneSmallSchemaArrowheadMirrored;

	private PositionedMovementSymbol waveFloorPlaneLarge;
	private PositionedMovementSymbol waveFloorPlaneLargeEmptyArrowhead;
	private PositionedMovementSymbol waveFloorPlaneLargeSchemaArrowhead;
	private PositionedMovementSymbol waveFloorPlaneLargeMirrored;
	private PositionedMovementSymbol waveFloorPlaneLargeEmptyArrowheadMirrored;
	private PositionedMovementSymbol waveFloorPlaneLargeSchemaArrowheadMirrored;

	private PositionedMovementSymbol rotationSingleFloorPlane;
	private PositionedMovementSymbol rotationSingleFloorPlaneEmptyArrowhead;
	private PositionedMovementSymbol rotationSingleFloorPlaneSchemaArrowhead;
	private PositionedMovementSymbol rotationSingleFloorPlaneMirrored;
	private PositionedMovementSymbol rotationSingleFloorPlaneEmptyArrowheadMirrored;
	private PositionedMovementSymbol rotationSingleFloorPlaneSchemaArrowheadMirrored;

	private PositionedMovementSymbol rotationDoubleFloorPlane;
	private PositionedMovementSymbol rotationDoubleFloorPlaneEmptyArrowhead;
	private PositionedMovementSymbol rotationDoubleFloorPlaneSchemaArrowhead;
	private PositionedMovementSymbol rotationDoubleFloorPlaneMirrored;
	private PositionedMovementSymbol rotationDoubleFloorPlaneEmptyArrowheadMirrored;
	private PositionedMovementSymbol rotationDoubleFloorPlaneSchemaArrowheadMirrored;

	private PositionedMovementSymbol rotationAlternatingFloorPlane;
	private PositionedMovementSymbol rotationAlternatingFloorPlaneEmptyArrowhead;
	private PositionedMovementSymbol rotationAlternatingFloorPlaneSchemaArrowhead;
	private PositionedMovementSymbol rotationAlternatingFloorPlaneMirrored;
	private PositionedMovementSymbol rotationAlternatingFloorPlaneEmptyArrowheadMirrored;
	private PositionedMovementSymbol rotationAlternatingFloorPlaneSchemaArrowheadMirrored;

	private PositionedMovementSymbol shakingParallelFloor;
	private PositionedMovementSymbol shakingParallelFloorEmptyArrowhead;
	private PositionedMovementSymbol shakingParallelFloorSchemaArrowhead;
	private PositionedMovementSymbol shakingParallelFloorMirrored;
	private PositionedMovementSymbol shakingParallelFloorEmptyArrowheadMirrored;
	private PositionedMovementSymbol shakingParallelFloorSchemaArrowheadMirrored;

	private SymbolFactory symbolFactory;

	@Override
	public void setUp(SymbolFactory symbolFactory) {

		this.symbolFactory = symbolFactory;

		curveFloorPlaneSmall = new PositionedMovementSymbol(MovementBaseSymbol.CURVE_FLOOR_PLANE_SMALL.getIswaSymbol(),
				0, 0, 2, symbolFactory.getAllRotationsAndFillsFor(
						MovementBaseSymbol.CURVE_FLOOR_PLANE_SMALL.getIswaSymbol().getBaseSymbol()));
		Symbol curveFloorPlaneSmallEmptyArrowheadSymbol = symbolFactory.createSymbol("02-09-001-01-02-01");
		curveFloorPlaneSmallEmptyArrowhead = new PositionedMovementSymbol(curveFloorPlaneSmallEmptyArrowheadSymbol, 0,
				0, 2,
				symbolFactory.getAllRotationsAndFillsFor(curveFloorPlaneSmallEmptyArrowheadSymbol.getBaseSymbol()));
		Symbol curveFloorPlaneSmallSchemaArrowheadSymbol = symbolFactory.createSymbol("02-09-001-01-03-01");
		curveFloorPlaneSmallSchemaArrowhead = new PositionedMovementSymbol(curveFloorPlaneSmallSchemaArrowheadSymbol, 0,
				0, 2,
				symbolFactory.getAllRotationsAndFillsFor(curveFloorPlaneSmallSchemaArrowheadSymbol.getBaseSymbol()));
		Symbol curveFloorPlaneSmallMirroredSymbol = symbolFactory.createSymbol("02-09-001-01-01-09");
		curveFloorPlaneSmallMirrored = new PositionedMovementSymbol(curveFloorPlaneSmallMirroredSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(curveFloorPlaneSmallMirroredSymbol.getBaseSymbol()));
		Symbol curveFloorPlaneSmallEmptyArrowheadMirroredSymbol = symbolFactory.createSymbol("02-09-001-01-02-09");
		curveFloorPlaneSmallEmptyArrowheadMirrored = new PositionedMovementSymbol(
				curveFloorPlaneSmallEmptyArrowheadMirroredSymbol, 0, 0, 2, symbolFactory
						.getAllRotationsAndFillsFor(curveFloorPlaneSmallEmptyArrowheadMirroredSymbol.getBaseSymbol()));
		Symbol curveFloorPlaneSmallSchemaArrowheadMirroredSymbol = symbolFactory.createSymbol("02-09-001-01-03-09");
		curveFloorPlaneSmallSchemaArrowheadMirrored = new PositionedMovementSymbol(
				curveFloorPlaneSmallSchemaArrowheadMirroredSymbol, 0, 0, 2, symbolFactory
						.getAllRotationsAndFillsFor(curveFloorPlaneSmallSchemaArrowheadMirroredSymbol.getBaseSymbol()));

		curveFloorPlaneMedium1 = new PositionedMovementSymbol(
				MovementBaseSymbol.CURVE_FLOOR_PLANE_MEDIUM_1.getIswaSymbol(), 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						MovementBaseSymbol.CURVE_FLOOR_PLANE_MEDIUM_1.getIswaSymbol().getBaseSymbol()));
		Symbol curveFloorPlaneMedium1EmptyArrowheadSymbol = symbolFactory.createSymbol("02-09-001-02-02-01");
		curveFloorPlaneMedium1EmptyArrowhead = new PositionedMovementSymbol(curveFloorPlaneMedium1EmptyArrowheadSymbol,
				0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(curveFloorPlaneMedium1EmptyArrowheadSymbol.getBaseSymbol()));
		Symbol curveFloorPlaneMedium1SchemaArrowheadSymbol = symbolFactory.createSymbol("02-09-001-02-03-01");
		curveFloorPlaneMedium1SchemaArrowhead = new PositionedMovementSymbol(
				curveFloorPlaneMedium1SchemaArrowheadSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(curveFloorPlaneMedium1SchemaArrowheadSymbol.getBaseSymbol()));
		Symbol curveFloorPlaneMedium1MirroredSymbol = symbolFactory.createSymbol("02-09-001-02-01-09");
		curveFloorPlaneMedium1Mirrored = new PositionedMovementSymbol(curveFloorPlaneMedium1MirroredSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(curveFloorPlaneMedium1MirroredSymbol.getBaseSymbol()));
		Symbol curveFloorPlaneMedium1EmptyArrowheadMirroredSymbol = symbolFactory.createSymbol("02-09-001-02-02-09");
		curveFloorPlaneMedium1EmptyArrowheadMirrored = new PositionedMovementSymbol(
				curveFloorPlaneMedium1EmptyArrowheadMirroredSymbol, 0, 0, 2, symbolFactory.getAllRotationsAndFillsFor(
						curveFloorPlaneMedium1EmptyArrowheadMirroredSymbol.getBaseSymbol()));
		Symbol curveFloorPlaneMedium1SchemaArrowheadMirroredSymbol = symbolFactory.createSymbol("02-09-001-02-03-09");
		curveFloorPlaneMedium1SchemaArrowheadMirrored = new PositionedMovementSymbol(
				curveFloorPlaneMedium1SchemaArrowheadMirroredSymbol, 0, 0, 2, symbolFactory.getAllRotationsAndFillsFor(
						curveFloorPlaneMedium1SchemaArrowheadMirroredSymbol.getBaseSymbol()));

		curveFloorPlaneMedium2 = new PositionedMovementSymbol(
				MovementBaseSymbol.CURVE_FLOOR_PLANE_MEDIUM_2.getIswaSymbol(), 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						MovementBaseSymbol.CURVE_FLOOR_PLANE_MEDIUM_2.getIswaSymbol().getBaseSymbol()));
		Symbol curveFloorPlaneMedium2EmptyArrowheadSymbol = symbolFactory.createSymbol("02-09-001-03-02-01");
		curveFloorPlaneMedium2EmptyArrowhead = new PositionedMovementSymbol(curveFloorPlaneMedium2EmptyArrowheadSymbol,
				0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(curveFloorPlaneMedium2EmptyArrowheadSymbol.getBaseSymbol()));
		Symbol curveFloorPlaneMedium2SchemaArrowheadSymbol = symbolFactory.createSymbol("02-09-001-03-03-01");
		curveFloorPlaneMedium2SchemaArrowhead = new PositionedMovementSymbol(
				curveFloorPlaneMedium2SchemaArrowheadSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(curveFloorPlaneMedium2SchemaArrowheadSymbol.getBaseSymbol()));
		Symbol curveFloorPlaneMedium2MirroredSymbol = symbolFactory.createSymbol("02-09-001-03-01-09");
		curveFloorPlaneMedium2Mirrored = new PositionedMovementSymbol(curveFloorPlaneMedium2MirroredSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(curveFloorPlaneMedium2MirroredSymbol.getBaseSymbol()));
		Symbol curveFloorPlaneMedium2EmptyArrowheadMirroredSymbol = symbolFactory.createSymbol("02-09-001-03-02-09");
		curveFloorPlaneMedium2EmptyArrowheadMirrored = new PositionedMovementSymbol(
				curveFloorPlaneMedium2EmptyArrowheadMirroredSymbol, 0, 0, 2, symbolFactory.getAllRotationsAndFillsFor(
						curveFloorPlaneMedium2EmptyArrowheadMirroredSymbol.getBaseSymbol()));
		Symbol curveFloorPlaneMedium2SchemaArrowheadMirroredSymbol = symbolFactory.createSymbol("02-09-001-03-03-09");
		curveFloorPlaneMedium2SchemaArrowheadMirrored = new PositionedMovementSymbol(
				curveFloorPlaneMedium2SchemaArrowheadMirroredSymbol, 0, 0, 2, symbolFactory.getAllRotationsAndFillsFor(
						curveFloorPlaneMedium2SchemaArrowheadMirroredSymbol.getBaseSymbol()));

		curveFloorPlaneLarge = new PositionedMovementSymbol(MovementBaseSymbol.CURVE_FLOOR_PLANE_LARGE.getIswaSymbol(),
				0, 0, 2, symbolFactory.getAllRotationsAndFillsFor(
						MovementBaseSymbol.CURVE_FLOOR_PLANE_LARGE.getIswaSymbol().getBaseSymbol()));
		Symbol curveFloorPlaneLargeEmptyArrowheadSymbol = symbolFactory.createSymbol("02-09-001-04-02-01");
		curveFloorPlaneLargeEmptyArrowhead = new PositionedMovementSymbol(curveFloorPlaneLargeEmptyArrowheadSymbol, 0,
				0, 2,
				symbolFactory.getAllRotationsAndFillsFor(curveFloorPlaneLargeEmptyArrowheadSymbol.getBaseSymbol()));
		Symbol curveFloorPlaneLargeSchemaArrowheadSymbol = symbolFactory.createSymbol("02-09-001-04-03-01");
		curveFloorPlaneLargeSchemaArrowhead = new PositionedMovementSymbol(curveFloorPlaneLargeSchemaArrowheadSymbol, 0,
				0, 2,
				symbolFactory.getAllRotationsAndFillsFor(curveFloorPlaneLargeSchemaArrowheadSymbol.getBaseSymbol()));
		Symbol curveFloorPlaneLargeMirroredSymbol = symbolFactory.createSymbol("02-09-001-04-01-09");
		curveFloorPlaneLargeMirrored = new PositionedMovementSymbol(curveFloorPlaneLargeMirroredSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(curveFloorPlaneLargeMirroredSymbol.getBaseSymbol()));
		Symbol curveFloorPlaneLargeEmptyArrowheadMirroredSymbol = symbolFactory.createSymbol("02-09-001-04-02-09");
		curveFloorPlaneLargeEmptyArrowheadMirrored = new PositionedMovementSymbol(
				curveFloorPlaneLargeEmptyArrowheadMirroredSymbol, 0, 0, 2, symbolFactory
						.getAllRotationsAndFillsFor(curveFloorPlaneLargeEmptyArrowheadMirroredSymbol.getBaseSymbol()));
		Symbol curveFloorPlaneLargeSchemaArrowheadMirroredSymbol = symbolFactory.createSymbol("02-09-001-04-03-09");
		curveFloorPlaneLargeSchemaArrowheadMirrored = new PositionedMovementSymbol(
				curveFloorPlaneLargeSchemaArrowheadMirroredSymbol, 0, 0, 2, symbolFactory
						.getAllRotationsAndFillsFor(curveFloorPlaneLargeSchemaArrowheadMirroredSymbol.getBaseSymbol()));

		curveFloorPlaneCombined = new PositionedMovementSymbol(
				MovementBaseSymbol.CURVE_FLOOR_PLANE_COMBINED.getIswaSymbol(), 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						MovementBaseSymbol.CURVE_FLOOR_PLANE_COMBINED.getIswaSymbol().getBaseSymbol()));
		Symbol curveFloorPlaneCombinedEmptyArrowheadSymbol = symbolFactory.createSymbol("02-09-001-05-02-01");
		curveFloorPlaneCombinedEmptyArrowhead = new PositionedMovementSymbol(
				curveFloorPlaneCombinedEmptyArrowheadSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(curveFloorPlaneCombinedEmptyArrowheadSymbol.getBaseSymbol()));
		Symbol curveFloorPlaneCombinedSchemaArrowheadSymbol = symbolFactory.createSymbol("02-09-001-05-03-01");
		curveFloorPlaneCombinedSchemaArrowhead = new PositionedMovementSymbol(
				curveFloorPlaneCombinedSchemaArrowheadSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(curveFloorPlaneCombinedSchemaArrowheadSymbol.getBaseSymbol()));
		Symbol curveFloorPlaneCombinedMirroredSymbol = symbolFactory.createSymbol("02-09-001-05-01-09");
		curveFloorPlaneCombinedMirrored = new PositionedMovementSymbol(curveFloorPlaneCombinedMirroredSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(curveFloorPlaneCombinedMirroredSymbol.getBaseSymbol()));
		Symbol curveFloorPlaneCombinedEmptyArrowheadMirroredSymbol = symbolFactory.createSymbol("02-09-001-05-02-09");
		curveFloorPlaneCombinedEmptyArrowheadMirrored = new PositionedMovementSymbol(
				curveFloorPlaneCombinedEmptyArrowheadMirroredSymbol, 0, 0, 2, symbolFactory.getAllRotationsAndFillsFor(
						curveFloorPlaneCombinedEmptyArrowheadMirroredSymbol.getBaseSymbol()));
		Symbol curveFloorPlaneCombinedSchemaArrowheadMirroredSymbol = symbolFactory.createSymbol("02-09-001-05-03-09");
		curveFloorPlaneCombinedSchemaArrowheadMirrored = new PositionedMovementSymbol(
				curveFloorPlaneCombinedSchemaArrowheadMirroredSymbol, 0, 0, 2, symbolFactory.getAllRotationsAndFillsFor(
						curveFloorPlaneCombinedSchemaArrowheadMirroredSymbol.getBaseSymbol()));

		humpFloorPlaneSmall = new PositionedMovementSymbol(MovementBaseSymbol.HUMP_FLOOR_PLANE_SMALL.getIswaSymbol(), 0,
				0, 2, symbolFactory.getAllRotationsAndFillsFor(
						MovementBaseSymbol.HUMP_FLOOR_PLANE_SMALL.getIswaSymbol().getBaseSymbol()));
		Symbol humpFloorPlaneSmallEmptyArrowheadSymbol = symbolFactory.createSymbol("02-09-002-01-02-01");
		humpFloorPlaneSmallEmptyArrowhead = new PositionedMovementSymbol(humpFloorPlaneSmallEmptyArrowheadSymbol, 0, 0,
				2, symbolFactory.getAllRotationsAndFillsFor(humpFloorPlaneSmallEmptyArrowheadSymbol.getBaseSymbol()));
		Symbol humpFloorPlaneSmallSchemaArrowheadSymbol = symbolFactory.createSymbol("02-09-002-01-03-01");
		humpFloorPlaneSmallSchemaArrowhead = new PositionedMovementSymbol(humpFloorPlaneSmallSchemaArrowheadSymbol, 0,
				0, 2,
				symbolFactory.getAllRotationsAndFillsFor(humpFloorPlaneSmallSchemaArrowheadSymbol.getBaseSymbol()));
		Symbol humpFloorPlaneSmallMirroredSymbol = symbolFactory.createSymbol("02-09-002-01-01-09");
		humpFloorPlaneSmallMirrored = new PositionedMovementSymbol(humpFloorPlaneSmallMirroredSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(humpFloorPlaneSmallMirroredSymbol.getBaseSymbol()));
		Symbol humpFloorPlaneSmallEmptyArrowheadMirroredSymbol = symbolFactory.createSymbol("02-09-002-01-02-09");
		humpFloorPlaneSmallEmptyArrowheadMirrored = new PositionedMovementSymbol(
				humpFloorPlaneSmallEmptyArrowheadMirroredSymbol, 0, 0, 2, symbolFactory
						.getAllRotationsAndFillsFor(humpFloorPlaneSmallEmptyArrowheadMirroredSymbol.getBaseSymbol()));
		Symbol humpFloorPlaneSmallSchemaArrowheadMirroredSymbol = symbolFactory.createSymbol("02-09-002-01-03-09");
		humpFloorPlaneSmallSchemaArrowheadMirrored = new PositionedMovementSymbol(
				humpFloorPlaneSmallSchemaArrowheadMirroredSymbol, 0, 0, 2, symbolFactory
						.getAllRotationsAndFillsFor(humpFloorPlaneSmallSchemaArrowheadMirroredSymbol.getBaseSymbol()));

		loopFloorPlaneSmall = new PositionedMovementSymbol(MovementBaseSymbol.LOOP_FLOOR_PLANE_SMALL.getIswaSymbol(), 0,
				0, 2, symbolFactory.getAllRotationsAndFillsFor(
						MovementBaseSymbol.LOOP_FLOOR_PLANE_SMALL.getIswaSymbol().getBaseSymbol()));
		Symbol loopFloorPlaneSmallEmptyArrowheadSymbol = symbolFactory.createSymbol("02-09-003-01-02-01");
		loopFloorPlaneSmallEmptyArrowhead = new PositionedMovementSymbol(loopFloorPlaneSmallEmptyArrowheadSymbol, 0, 0,
				2, symbolFactory.getAllRotationsAndFillsFor(loopFloorPlaneSmallEmptyArrowheadSymbol.getBaseSymbol()));
		Symbol loopFloorPlaneSmallSchemaArrowheadSymbol = symbolFactory.createSymbol("02-09-003-01-03-01");
		loopFloorPlaneSmallSchemaArrowhead = new PositionedMovementSymbol(loopFloorPlaneSmallSchemaArrowheadSymbol, 0,
				0, 2,
				symbolFactory.getAllRotationsAndFillsFor(loopFloorPlaneSmallSchemaArrowheadSymbol.getBaseSymbol()));
		Symbol loopFloorPlaneSmallMirroredSymbol = symbolFactory.createSymbol("02-09-003-01-01-09");
		loopFloorPlaneSmallMirrored = new PositionedMovementSymbol(loopFloorPlaneSmallMirroredSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(loopFloorPlaneSmallMirroredSymbol.getBaseSymbol()));
		Symbol loopFloorPlaneSmallEmptyArrowheadMirroredSymbol = symbolFactory.createSymbol("02-09-003-01-02-09");
		loopFloorPlaneSmallEmptyArrowheadMirrored = new PositionedMovementSymbol(
				loopFloorPlaneSmallEmptyArrowheadMirroredSymbol, 0, 0, 2, symbolFactory
						.getAllRotationsAndFillsFor(loopFloorPlaneSmallEmptyArrowheadMirroredSymbol.getBaseSymbol()));
		Symbol loopFloorPlaneSmallSchemaArrowheadMirroredSymbol = symbolFactory.createSymbol("02-09-003-01-03-09");
		loopFloorPlaneSmallSchemaArrowheadMirrored = new PositionedMovementSymbol(
				loopFloorPlaneSmallSchemaArrowheadMirroredSymbol, 0, 0, 2, symbolFactory
						.getAllRotationsAndFillsFor(loopFloorPlaneSmallSchemaArrowheadMirroredSymbol.getBaseSymbol()));

		waveFloorPlaneSnake = new PositionedMovementSymbol(MovementBaseSymbol.WAVE_FLOOR_PLANE_SNAKE.getIswaSymbol(), 0,
				0, 2, symbolFactory.getAllRotationsAndFillsFor(
						MovementBaseSymbol.WAVE_FLOOR_PLANE_SNAKE.getIswaSymbol().getBaseSymbol()));
		Symbol waveFloorPlaneSnakeEmptyArrowheadSymbol = symbolFactory.createSymbol("02-09-004-01-02-01");
		waveFloorPlaneSnakeEmptyArrowhead = new PositionedMovementSymbol(waveFloorPlaneSnakeEmptyArrowheadSymbol, 0, 0,
				2, symbolFactory.getAllRotationsAndFillsFor(waveFloorPlaneSnakeEmptyArrowheadSymbol.getBaseSymbol()));
		Symbol waveFloorPlaneSnakeSchemaArrowheadSymbol = symbolFactory.createSymbol("02-09-004-01-03-01");
		waveFloorPlaneSnakeSchemaArrowhead = new PositionedMovementSymbol(waveFloorPlaneSnakeSchemaArrowheadSymbol, 0,
				0, 2,
				symbolFactory.getAllRotationsAndFillsFor(waveFloorPlaneSnakeSchemaArrowheadSymbol.getBaseSymbol()));
		Symbol waveFloorPlaneSnakeMirroredSymbol = symbolFactory.createSymbol("02-09-004-01-01-09");
		waveFloorPlaneSnakeMirrored = new PositionedMovementSymbol(waveFloorPlaneSnakeMirroredSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(waveFloorPlaneSnakeMirroredSymbol.getBaseSymbol()));
		Symbol waveFloorPlaneSnakeEmptyArrowheadMirroredSymbol = symbolFactory.createSymbol("02-09-004-01-02-09");
		waveFloorPlaneSnakeEmptyArrowheadMirrored = new PositionedMovementSymbol(
				waveFloorPlaneSnakeEmptyArrowheadMirroredSymbol, 0, 0, 2, symbolFactory
						.getAllRotationsAndFillsFor(waveFloorPlaneSnakeEmptyArrowheadMirroredSymbol.getBaseSymbol()));
		Symbol waveFloorPlaneSnakeSchemaArrowheadMirroredSymbol = symbolFactory.createSymbol("02-09-004-01-03-09");
		waveFloorPlaneSnakeSchemaArrowheadMirrored = new PositionedMovementSymbol(
				waveFloorPlaneSnakeSchemaArrowheadMirroredSymbol, 0, 0, 2, symbolFactory
						.getAllRotationsAndFillsFor(waveFloorPlaneSnakeSchemaArrowheadMirroredSymbol.getBaseSymbol()));

		waveFloorPlaneSmall = new PositionedMovementSymbol(MovementBaseSymbol.WAVE_FLOOR_PLANE_SMALL.getIswaSymbol(), 0,
				0, 2, symbolFactory.getAllRotationsAndFillsFor(
						MovementBaseSymbol.WAVE_FLOOR_PLANE_SMALL.getIswaSymbol().getBaseSymbol()));
		Symbol waveFloorPlaneSmallEmptyArrowheadSymbol = symbolFactory.createSymbol("02-09-004-02-02-01");
		waveFloorPlaneSmallEmptyArrowhead = new PositionedMovementSymbol(waveFloorPlaneSmallEmptyArrowheadSymbol, 0, 0,
				2, symbolFactory.getAllRotationsAndFillsFor(waveFloorPlaneSmallEmptyArrowheadSymbol.getBaseSymbol()));
		Symbol waveFloorPlaneSmallSchemaArrowheadSymbol = symbolFactory.createSymbol("02-09-004-02-03-01");
		waveFloorPlaneSmallSchemaArrowhead = new PositionedMovementSymbol(waveFloorPlaneSmallSchemaArrowheadSymbol, 0,
				0, 2,
				symbolFactory.getAllRotationsAndFillsFor(waveFloorPlaneSmallSchemaArrowheadSymbol.getBaseSymbol()));
		Symbol waveFloorPlaneSmallMirroredSymbol = symbolFactory.createSymbol("02-09-004-02-01-09");
		waveFloorPlaneSmallMirrored = new PositionedMovementSymbol(waveFloorPlaneSmallMirroredSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(waveFloorPlaneSmallMirroredSymbol.getBaseSymbol()));
		Symbol waveFloorPlaneSmallEmptyArrowheadMirroredSymbol = symbolFactory.createSymbol("02-09-004-02-02-09");
		waveFloorPlaneSmallEmptyArrowheadMirrored = new PositionedMovementSymbol(
				waveFloorPlaneSmallEmptyArrowheadMirroredSymbol, 0, 0, 2, symbolFactory
						.getAllRotationsAndFillsFor(waveFloorPlaneSmallEmptyArrowheadMirroredSymbol.getBaseSymbol()));
		Symbol waveFloorPlaneSmallSchemaArrowheadMirroredSymbol = symbolFactory.createSymbol("02-09-004-02-03-09");
		waveFloorPlaneSmallSchemaArrowheadMirrored = new PositionedMovementSymbol(
				waveFloorPlaneSmallSchemaArrowheadMirroredSymbol, 0, 0, 2, symbolFactory
						.getAllRotationsAndFillsFor(waveFloorPlaneSmallSchemaArrowheadMirroredSymbol.getBaseSymbol()));

		waveFloorPlaneLarge = new PositionedMovementSymbol(MovementBaseSymbol.WAVE_FLOOR_PLANE_LARGE.getIswaSymbol(), 0,
				0, 2, symbolFactory.getAllRotationsAndFillsFor(
						MovementBaseSymbol.WAVE_FLOOR_PLANE_LARGE.getIswaSymbol().getBaseSymbol()));
		Symbol waveFloorPlaneLargeEmptyArrowheadSymbol = symbolFactory.createSymbol("02-09-004-03-02-01");
		waveFloorPlaneLargeEmptyArrowhead = new PositionedMovementSymbol(waveFloorPlaneLargeEmptyArrowheadSymbol, 0, 0,
				2, symbolFactory.getAllRotationsAndFillsFor(waveFloorPlaneLargeEmptyArrowheadSymbol.getBaseSymbol()));
		Symbol waveFloorPlaneLargeSchemaArrowheadSymbol = symbolFactory.createSymbol("02-09-004-03-03-01");
		waveFloorPlaneLargeSchemaArrowhead = new PositionedMovementSymbol(waveFloorPlaneLargeSchemaArrowheadSymbol, 0,
				0, 2,
				symbolFactory.getAllRotationsAndFillsFor(waveFloorPlaneLargeSchemaArrowheadSymbol.getBaseSymbol()));
		Symbol waveFloorPlaneLargeMirroredSymbol = symbolFactory.createSymbol("02-09-004-03-01-09");
		waveFloorPlaneLargeMirrored = new PositionedMovementSymbol(waveFloorPlaneLargeMirroredSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(waveFloorPlaneLargeMirroredSymbol.getBaseSymbol()));
		Symbol waveFloorPlaneLargeEmptyArrowheadMirroredSymbol = symbolFactory.createSymbol("02-09-004-03-02-09");
		waveFloorPlaneLargeEmptyArrowheadMirrored = new PositionedMovementSymbol(
				waveFloorPlaneLargeEmptyArrowheadMirroredSymbol, 0, 0, 2, symbolFactory
						.getAllRotationsAndFillsFor(waveFloorPlaneLargeEmptyArrowheadMirroredSymbol.getBaseSymbol()));
		Symbol waveFloorPlaneLargeSchemaArrowheadMirroredSymbol = symbolFactory.createSymbol("02-09-004-03-03-09");
		waveFloorPlaneLargeSchemaArrowheadMirrored = new PositionedMovementSymbol(
				waveFloorPlaneLargeSchemaArrowheadMirroredSymbol, 0, 0, 2, symbolFactory
						.getAllRotationsAndFillsFor(waveFloorPlaneLargeSchemaArrowheadMirroredSymbol.getBaseSymbol()));

		rotationSingleFloorPlane = new PositionedMovementSymbol(
				MovementBaseSymbol.ROTATION_SINGLE_FLOOR_PLANE.getIswaSymbol(), 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						MovementBaseSymbol.ROTATION_SINGLE_FLOOR_PLANE.getIswaSymbol().getBaseSymbol()));
		Symbol rotationSingleFLoorPlaneEmptyArrowheadSymbol = symbolFactory.createSymbol("02-09-005-01-02-01");
		rotationSingleFloorPlaneEmptyArrowhead = new PositionedMovementSymbol(
				rotationSingleFLoorPlaneEmptyArrowheadSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(rotationSingleFLoorPlaneEmptyArrowheadSymbol.getBaseSymbol()));
		Symbol rotationSingleFLoorPlaneSchemaArrowheadSymbol = symbolFactory.createSymbol("02-09-005-01-03-01");
		rotationSingleFloorPlaneSchemaArrowhead = new PositionedMovementSymbol(
				rotationSingleFLoorPlaneSchemaArrowheadSymbol, 0, 0, 2, symbolFactory
						.getAllRotationsAndFillsFor(rotationSingleFLoorPlaneSchemaArrowheadSymbol.getBaseSymbol()));
		Symbol rotationSingleFLoorPlaneMirroredSymbol = symbolFactory.createSymbol("02-09-005-01-01-09");
		rotationSingleFloorPlaneMirrored = new PositionedMovementSymbol(rotationSingleFLoorPlaneMirroredSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(rotationSingleFLoorPlaneMirroredSymbol.getBaseSymbol()));
		Symbol rotationSingleFLoorPlaneEmptyArrowheadMirroredSymbol = symbolFactory.createSymbol("02-09-005-01-02-09");
		rotationSingleFloorPlaneEmptyArrowheadMirrored = new PositionedMovementSymbol(
				rotationSingleFLoorPlaneEmptyArrowheadMirroredSymbol, 0, 0, 2, symbolFactory.getAllRotationsAndFillsFor(
						rotationSingleFLoorPlaneEmptyArrowheadMirroredSymbol.getBaseSymbol()));
		Symbol rotationSingleFLoorPlaneSchemaArrowheadMirroredSymbol = symbolFactory.createSymbol("02-09-005-01-03-09");
		rotationSingleFloorPlaneSchemaArrowheadMirrored = new PositionedMovementSymbol(
				rotationSingleFLoorPlaneSchemaArrowheadMirroredSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						rotationSingleFLoorPlaneSchemaArrowheadMirroredSymbol.getBaseSymbol()));

		rotationDoubleFloorPlane = new PositionedMovementSymbol(
				MovementBaseSymbol.ROTATION_DOUBLE_FLOOR_PLANE.getIswaSymbol(), 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						MovementBaseSymbol.ROTATION_DOUBLE_FLOOR_PLANE.getIswaSymbol().getBaseSymbol()));
		Symbol rotationDoubleFLoorPlaneEmptyArrowheadSymbol = symbolFactory.createSymbol("02-09-006-01-02-01");
		rotationDoubleFloorPlaneEmptyArrowhead = new PositionedMovementSymbol(
				rotationDoubleFLoorPlaneEmptyArrowheadSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(rotationDoubleFLoorPlaneEmptyArrowheadSymbol.getBaseSymbol()));
		Symbol rotationDoubleFLoorPlaneSchemaArrowheadSymbol = symbolFactory.createSymbol("02-09-006-01-03-01");
		rotationDoubleFloorPlaneSchemaArrowhead = new PositionedMovementSymbol(
				rotationDoubleFLoorPlaneSchemaArrowheadSymbol, 0, 0, 2, symbolFactory
						.getAllRotationsAndFillsFor(rotationDoubleFLoorPlaneSchemaArrowheadSymbol.getBaseSymbol()));
		Symbol rotationDoubleFLoorPlaneMirroredSymbol = symbolFactory.createSymbol("02-09-006-01-01-09");
		rotationDoubleFloorPlaneMirrored = new PositionedMovementSymbol(rotationDoubleFLoorPlaneMirroredSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(rotationDoubleFLoorPlaneMirroredSymbol.getBaseSymbol()));
		Symbol rotationDoubleFLoorPlaneEmptyArrowheadMirroredSymbol = symbolFactory.createSymbol("02-09-006-01-02-09");
		rotationDoubleFloorPlaneEmptyArrowheadMirrored = new PositionedMovementSymbol(
				rotationDoubleFLoorPlaneEmptyArrowheadMirroredSymbol, 0, 0, 2, symbolFactory.getAllRotationsAndFillsFor(
						rotationDoubleFLoorPlaneEmptyArrowheadMirroredSymbol.getBaseSymbol()));
		Symbol rotationDoubleFLoorPlaneSchemaArrowheadMirroredSymbol = symbolFactory.createSymbol("02-09-006-01-03-09");
		rotationDoubleFloorPlaneSchemaArrowheadMirrored = new PositionedMovementSymbol(
				rotationDoubleFLoorPlaneSchemaArrowheadMirroredSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						rotationDoubleFLoorPlaneSchemaArrowheadMirroredSymbol.getBaseSymbol()));

		rotationAlternatingFloorPlane = new PositionedMovementSymbol(
				MovementBaseSymbol.ROTATION_ALTERNATING_FLOOR_PLANE.getIswaSymbol(), 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						MovementBaseSymbol.ROTATION_ALTERNATING_FLOOR_PLANE.getIswaSymbol().getBaseSymbol()));
		Symbol rotationAlternatingFLoorPlaneEmptyArrowheadSymbol = symbolFactory.createSymbol("02-09-007-01-02-01");
		rotationAlternatingFloorPlaneEmptyArrowhead = new PositionedMovementSymbol(
				rotationAlternatingFLoorPlaneEmptyArrowheadSymbol, 0, 0, 2, symbolFactory
						.getAllRotationsAndFillsFor(rotationAlternatingFLoorPlaneEmptyArrowheadSymbol.getBaseSymbol()));
		Symbol rotationAlternatingFLoorPlaneSchemaArrowheadSymbol = symbolFactory.createSymbol("02-09-007-01-03-01");
		rotationAlternatingFloorPlaneSchemaArrowhead = new PositionedMovementSymbol(
				rotationAlternatingFLoorPlaneSchemaArrowheadSymbol, 0, 0, 2, symbolFactory.getAllRotationsAndFillsFor(
						rotationAlternatingFLoorPlaneSchemaArrowheadSymbol.getBaseSymbol()));
		Symbol rotationAlternatingFLoorPlaneMirroredSymbol = symbolFactory.createSymbol("02-09-007-01-01-09");
		rotationAlternatingFloorPlaneMirrored = new PositionedMovementSymbol(
				rotationAlternatingFLoorPlaneMirroredSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(rotationAlternatingFLoorPlaneMirroredSymbol.getBaseSymbol()));
		Symbol rotationAlternatingFLoorPlaneEmptyArrowheadMirroredSymbol = symbolFactory
				.createSymbol("02-09-007-01-02-09");
		rotationAlternatingFloorPlaneEmptyArrowheadMirrored = new PositionedMovementSymbol(
				rotationAlternatingFLoorPlaneEmptyArrowheadMirroredSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						rotationAlternatingFLoorPlaneEmptyArrowheadMirroredSymbol.getBaseSymbol()));
		Symbol rotationAlternatingFLoorPlaneSchemaArrowheadMirroredSymbol = symbolFactory
				.createSymbol("02-09-007-01-03-09");
		rotationAlternatingFloorPlaneSchemaArrowheadMirrored = new PositionedMovementSymbol(
				rotationAlternatingFLoorPlaneSchemaArrowheadMirroredSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						rotationAlternatingFLoorPlaneSchemaArrowheadMirroredSymbol.getBaseSymbol()));

		shakingParallelFloor = new PositionedMovementSymbol(MovementBaseSymbol.SHAKING_PARALLEL_FLOOR.getIswaSymbol(),
				0, 0, 2, symbolFactory.getAllRotationsAndFillsFor(
						MovementBaseSymbol.SHAKING_PARALLEL_FLOOR.getIswaSymbol().getBaseSymbol()));
		Symbol shakingParallelFloorEmptyArrowheadSymbol = symbolFactory.createSymbol("02-09-008-01-02-01");
		shakingParallelFloorEmptyArrowhead = new PositionedMovementSymbol(shakingParallelFloorEmptyArrowheadSymbol, 0,
				0, 2,
				symbolFactory.getAllRotationsAndFillsFor(shakingParallelFloorEmptyArrowheadSymbol.getBaseSymbol()));
		Symbol shakingParallelFloorSchemaArrowheadSymbol = symbolFactory.createSymbol("02-09-008-01-03-01");
		shakingParallelFloorSchemaArrowhead = new PositionedMovementSymbol(shakingParallelFloorSchemaArrowheadSymbol, 0,
				0, 2,
				symbolFactory.getAllRotationsAndFillsFor(shakingParallelFloorSchemaArrowheadSymbol.getBaseSymbol()));
		Symbol shakingParallelFloorMirroredSymbol = symbolFactory.createSymbol("02-09-008-01-01-09");
		shakingParallelFloorMirrored = new PositionedMovementSymbol(shakingParallelFloorMirroredSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(shakingParallelFloorMirroredSymbol.getBaseSymbol()));
		Symbol shakingParallelFloorEmptyArrowheadMirroredSymbol = symbolFactory.createSymbol("02-09-008-01-02-09");
		shakingParallelFloorEmptyArrowheadMirrored = new PositionedMovementSymbol(
				shakingParallelFloorEmptyArrowheadMirroredSymbol, 0, 0, 2, symbolFactory
						.getAllRotationsAndFillsFor(shakingParallelFloorEmptyArrowheadMirroredSymbol.getBaseSymbol()));
		Symbol shakingParallelFloorSchemaArrowheadMirroredSymbol = symbolFactory.createSymbol("02-09-008-01-03-09");
		shakingParallelFloorSchemaArrowheadMirrored = new PositionedMovementSymbol(
				shakingParallelFloorSchemaArrowheadMirroredSymbol, 0, 0, 2, symbolFactory
						.getAllRotationsAndFillsFor(shakingParallelFloorSchemaArrowheadMirroredSymbol.getBaseSymbol()));
	}

	@Override
	public void testCanIncrease() {

		assertFalse(curveFloorPlaneSmall.canIncrease());
		assertFalse(curveFloorPlaneSmallEmptyArrowhead.canIncrease());
		assertFalse(curveFloorPlaneSmallSchemaArrowhead.canIncrease());
		assertFalse(curveFloorPlaneSmallMirrored.canIncrease());
		assertFalse(curveFloorPlaneSmallEmptyArrowheadMirrored.canIncrease());
		assertFalse(curveFloorPlaneSmallSchemaArrowheadMirrored.canIncrease());

		assertFalse(curveFloorPlaneMedium1.canIncrease());
		assertFalse(curveFloorPlaneMedium1EmptyArrowhead.canIncrease());
		assertFalse(curveFloorPlaneMedium1SchemaArrowhead.canIncrease());
		assertFalse(curveFloorPlaneMedium1Mirrored.canIncrease());
		assertFalse(curveFloorPlaneMedium1EmptyArrowheadMirrored.canIncrease());
		assertFalse(curveFloorPlaneMedium1SchemaArrowheadMirrored.canIncrease());

		assertFalse(curveFloorPlaneMedium2.canIncrease());
		assertFalse(curveFloorPlaneMedium2EmptyArrowhead.canIncrease());
		assertFalse(curveFloorPlaneMedium2SchemaArrowhead.canIncrease());
		assertFalse(curveFloorPlaneMedium2Mirrored.canIncrease());
		assertFalse(curveFloorPlaneMedium2EmptyArrowheadMirrored.canIncrease());
		assertFalse(curveFloorPlaneMedium2SchemaArrowheadMirrored.canIncrease());

		assertFalse(curveFloorPlaneLarge.canIncrease());
		assertFalse(curveFloorPlaneLargeEmptyArrowhead.canIncrease());
		assertFalse(curveFloorPlaneLargeSchemaArrowhead.canIncrease());
		assertFalse(curveFloorPlaneLargeMirrored.canIncrease());
		assertFalse(curveFloorPlaneLargeEmptyArrowheadMirrored.canIncrease());
		assertFalse(curveFloorPlaneLargeSchemaArrowheadMirrored.canIncrease());

		assertFalse(curveFloorPlaneCombined.canIncrease());
		assertFalse(curveFloorPlaneCombinedEmptyArrowhead.canIncrease());
		assertFalse(curveFloorPlaneCombinedSchemaArrowhead.canIncrease());
		assertFalse(curveFloorPlaneCombinedMirrored.canIncrease());
		assertFalse(curveFloorPlaneCombinedEmptyArrowheadMirrored.canIncrease());
		assertFalse(curveFloorPlaneCombinedSchemaArrowheadMirrored.canIncrease());

		assertFalse(humpFloorPlaneSmall.canIncrease());
		assertFalse(humpFloorPlaneSmallEmptyArrowhead.canIncrease());
		assertFalse(humpFloorPlaneSmallSchemaArrowhead.canIncrease());
		assertFalse(humpFloorPlaneSmallMirrored.canIncrease());
		assertFalse(humpFloorPlaneSmallEmptyArrowheadMirrored.canIncrease());
		assertFalse(humpFloorPlaneSmallSchemaArrowheadMirrored.canIncrease());

		assertFalse(loopFloorPlaneSmall.canIncrease());
		assertFalse(loopFloorPlaneSmallEmptyArrowhead.canIncrease());
		assertFalse(loopFloorPlaneSmallSchemaArrowhead.canIncrease());
		assertFalse(loopFloorPlaneSmallMirrored.canIncrease());
		assertFalse(loopFloorPlaneSmallEmptyArrowheadMirrored.canIncrease());
		assertFalse(loopFloorPlaneSmallSchemaArrowheadMirrored.canIncrease());

		assertFalse(waveFloorPlaneSnake.canIncrease());
		assertFalse(waveFloorPlaneSnakeEmptyArrowhead.canIncrease());
		assertFalse(waveFloorPlaneSnakeSchemaArrowhead.canIncrease());
		assertFalse(waveFloorPlaneSnakeMirrored.canIncrease());
		assertFalse(waveFloorPlaneSnakeEmptyArrowheadMirrored.canIncrease());
		assertFalse(waveFloorPlaneSnakeSchemaArrowheadMirrored.canIncrease());

		assertFalse(waveFloorPlaneSmall.canIncrease());
		assertFalse(waveFloorPlaneSmallEmptyArrowhead.canIncrease());
		assertFalse(waveFloorPlaneSmallSchemaArrowhead.canIncrease());
		assertFalse(waveFloorPlaneSmallMirrored.canIncrease());
		assertFalse(waveFloorPlaneSmallEmptyArrowheadMirrored.canIncrease());
		assertFalse(waveFloorPlaneSmallSchemaArrowheadMirrored.canIncrease());

		assertFalse(waveFloorPlaneLarge.canIncrease());
		assertFalse(waveFloorPlaneLargeEmptyArrowhead.canIncrease());
		assertFalse(waveFloorPlaneLargeSchemaArrowhead.canIncrease());
		assertFalse(waveFloorPlaneLargeMirrored.canIncrease());
		assertFalse(waveFloorPlaneLargeEmptyArrowheadMirrored.canIncrease());
		assertFalse(waveFloorPlaneLargeSchemaArrowheadMirrored.canIncrease());

		assertTrue(rotationSingleFloorPlane.canIncrease());
		assertTrue(rotationSingleFloorPlaneEmptyArrowhead.canIncrease());
		assertTrue(rotationSingleFloorPlaneSchemaArrowhead.canIncrease());
		assertTrue(rotationSingleFloorPlaneMirrored.canIncrease());
		assertTrue(rotationSingleFloorPlaneEmptyArrowheadMirrored.canIncrease());
		assertTrue(rotationSingleFloorPlaneSchemaArrowheadMirrored.canIncrease());

		assertFalse(rotationDoubleFloorPlane.canIncrease());
		assertFalse(rotationDoubleFloorPlaneEmptyArrowhead.canIncrease());
		assertFalse(rotationDoubleFloorPlaneSchemaArrowhead.canIncrease());
		assertFalse(rotationDoubleFloorPlaneMirrored.canIncrease());
		assertFalse(rotationDoubleFloorPlaneEmptyArrowheadMirrored.canIncrease());
		assertFalse(rotationDoubleFloorPlaneSchemaArrowheadMirrored.canIncrease());

		assertFalse(rotationAlternatingFloorPlane.canIncrease());
		assertFalse(rotationAlternatingFloorPlaneEmptyArrowhead.canIncrease());
		assertFalse(rotationAlternatingFloorPlaneSchemaArrowhead.canIncrease());
		assertFalse(rotationAlternatingFloorPlaneMirrored.canIncrease());
		assertFalse(rotationAlternatingFloorPlaneEmptyArrowheadMirrored.canIncrease());
		assertFalse(rotationAlternatingFloorPlaneSchemaArrowheadMirrored.canIncrease());

		assertFalse(shakingParallelFloor.canIncrease());
		assertFalse(shakingParallelFloorEmptyArrowhead.canIncrease());
		assertFalse(shakingParallelFloorSchemaArrowhead.canIncrease());
		assertFalse(shakingParallelFloorMirrored.canIncrease());
		assertFalse(shakingParallelFloorEmptyArrowheadMirrored.canIncrease());
		assertFalse(shakingParallelFloorSchemaArrowheadMirrored.canIncrease());

	}

	@Override
	public void testIncrease() {

		rotationSingleFloorPlane.increase();
		assertEquals(rotationDoubleFloorPlane.getSymbol(), rotationSingleFloorPlane.getSymbol());
		rotationSingleFloorPlaneEmptyArrowhead.increase();
		assertEquals(rotationDoubleFloorPlaneEmptyArrowhead.getSymbol(),
				rotationSingleFloorPlaneEmptyArrowhead.getSymbol());
		rotationSingleFloorPlaneSchemaArrowhead.increase();
		assertEquals(rotationDoubleFloorPlaneSchemaArrowhead.getSymbol(),
				rotationSingleFloorPlaneSchemaArrowhead.getSymbol());
		rotationSingleFloorPlaneMirrored.increase();
		assertEquals(rotationDoubleFloorPlaneMirrored.getSymbol(), rotationSingleFloorPlaneMirrored.getSymbol());
		rotationSingleFloorPlaneEmptyArrowheadMirrored.increase();
		assertEquals(rotationDoubleFloorPlaneEmptyArrowheadMirrored.getSymbol(),
				rotationSingleFloorPlaneEmptyArrowheadMirrored.getSymbol());
		rotationSingleFloorPlaneSchemaArrowheadMirrored.increase();
		assertEquals(rotationDoubleFloorPlaneSchemaArrowheadMirrored.getSymbol(),
				rotationSingleFloorPlaneSchemaArrowheadMirrored.getSymbol());

	}

	@Override
	public void testCanDecrease() {

		assertFalse(curveFloorPlaneSmall.canDecrease());
		assertFalse(curveFloorPlaneSmallEmptyArrowhead.canDecrease());
		assertFalse(curveFloorPlaneSmallSchemaArrowhead.canDecrease());
		assertFalse(curveFloorPlaneSmallMirrored.canDecrease());
		assertFalse(curveFloorPlaneSmallEmptyArrowheadMirrored.canDecrease());
		assertFalse(curveFloorPlaneSmallSchemaArrowheadMirrored.canDecrease());

		assertFalse(curveFloorPlaneMedium1.canDecrease());
		assertFalse(curveFloorPlaneMedium1EmptyArrowhead.canDecrease());
		assertFalse(curveFloorPlaneMedium1SchemaArrowhead.canDecrease());
		assertFalse(curveFloorPlaneMedium1Mirrored.canDecrease());
		assertFalse(curveFloorPlaneMedium1EmptyArrowheadMirrored.canDecrease());
		assertFalse(curveFloorPlaneMedium1SchemaArrowheadMirrored.canDecrease());

		assertFalse(curveFloorPlaneMedium2.canDecrease());
		assertFalse(curveFloorPlaneMedium2EmptyArrowhead.canDecrease());
		assertFalse(curveFloorPlaneMedium2SchemaArrowhead.canDecrease());
		assertFalse(curveFloorPlaneMedium2Mirrored.canDecrease());
		assertFalse(curveFloorPlaneMedium2EmptyArrowheadMirrored.canDecrease());
		assertFalse(curveFloorPlaneMedium2SchemaArrowheadMirrored.canDecrease());

		assertFalse(curveFloorPlaneLarge.canDecrease());
		assertFalse(curveFloorPlaneLargeEmptyArrowhead.canDecrease());
		assertFalse(curveFloorPlaneLargeSchemaArrowhead.canDecrease());
		assertFalse(curveFloorPlaneLargeMirrored.canDecrease());
		assertFalse(curveFloorPlaneLargeEmptyArrowheadMirrored.canDecrease());
		assertFalse(curveFloorPlaneLargeSchemaArrowheadMirrored.canDecrease());

		assertFalse(curveFloorPlaneCombined.canDecrease());
		assertFalse(curveFloorPlaneCombinedEmptyArrowhead.canDecrease());
		assertFalse(curveFloorPlaneCombinedSchemaArrowhead.canDecrease());
		assertFalse(curveFloorPlaneCombinedMirrored.canDecrease());
		assertFalse(curveFloorPlaneCombinedEmptyArrowheadMirrored.canDecrease());
		assertFalse(curveFloorPlaneCombinedSchemaArrowheadMirrored.canDecrease());

		assertFalse(humpFloorPlaneSmall.canDecrease());
		assertFalse(humpFloorPlaneSmallEmptyArrowhead.canDecrease());
		assertFalse(humpFloorPlaneSmallSchemaArrowhead.canDecrease());
		assertFalse(humpFloorPlaneSmallMirrored.canDecrease());
		assertFalse(humpFloorPlaneSmallEmptyArrowheadMirrored.canDecrease());
		assertFalse(humpFloorPlaneSmallSchemaArrowheadMirrored.canDecrease());

		assertFalse(loopFloorPlaneSmall.canDecrease());
		assertFalse(loopFloorPlaneSmallEmptyArrowhead.canDecrease());
		assertFalse(loopFloorPlaneSmallSchemaArrowhead.canDecrease());
		assertFalse(loopFloorPlaneSmallMirrored.canDecrease());
		assertFalse(loopFloorPlaneSmallEmptyArrowheadMirrored.canDecrease());
		assertFalse(loopFloorPlaneSmallSchemaArrowheadMirrored.canDecrease());

		assertFalse(waveFloorPlaneSnake.canDecrease());
		assertFalse(waveFloorPlaneSnakeEmptyArrowhead.canDecrease());
		assertFalse(waveFloorPlaneSnakeSchemaArrowhead.canDecrease());
		assertFalse(waveFloorPlaneSnakeMirrored.canDecrease());
		assertFalse(waveFloorPlaneSnakeEmptyArrowheadMirrored.canDecrease());
		assertFalse(waveFloorPlaneSnakeSchemaArrowheadMirrored.canDecrease());

		assertFalse(waveFloorPlaneSmall.canDecrease());
		assertFalse(waveFloorPlaneSmallEmptyArrowhead.canDecrease());
		assertFalse(waveFloorPlaneSmallSchemaArrowhead.canDecrease());
		assertFalse(waveFloorPlaneSmallMirrored.canDecrease());
		assertFalse(waveFloorPlaneSmallEmptyArrowheadMirrored.canDecrease());
		assertFalse(waveFloorPlaneSmallSchemaArrowheadMirrored.canDecrease());

		assertFalse(waveFloorPlaneLarge.canDecrease());
		assertFalse(waveFloorPlaneLargeEmptyArrowhead.canDecrease());
		assertFalse(waveFloorPlaneLargeSchemaArrowhead.canDecrease());
		assertFalse(waveFloorPlaneLargeMirrored.canDecrease());
		assertFalse(waveFloorPlaneLargeEmptyArrowheadMirrored.canDecrease());
		assertFalse(waveFloorPlaneLargeSchemaArrowheadMirrored.canDecrease());

		assertFalse(rotationSingleFloorPlane.canDecrease());
		assertFalse(rotationSingleFloorPlaneEmptyArrowhead.canDecrease());
		assertFalse(rotationSingleFloorPlaneSchemaArrowhead.canDecrease());
		assertFalse(rotationSingleFloorPlaneMirrored.canDecrease());
		assertFalse(rotationSingleFloorPlaneEmptyArrowheadMirrored.canDecrease());
		assertFalse(rotationSingleFloorPlaneSchemaArrowheadMirrored.canDecrease());

		assertTrue(rotationDoubleFloorPlane.canDecrease());
		assertTrue(rotationDoubleFloorPlaneEmptyArrowhead.canDecrease());
		assertTrue(rotationDoubleFloorPlaneSchemaArrowhead.canDecrease());
		assertTrue(rotationDoubleFloorPlaneMirrored.canDecrease());
		assertTrue(rotationDoubleFloorPlaneEmptyArrowheadMirrored.canDecrease());
		assertTrue(rotationDoubleFloorPlaneSchemaArrowheadMirrored.canDecrease());

		assertFalse(rotationAlternatingFloorPlane.canDecrease());
		assertFalse(rotationAlternatingFloorPlaneEmptyArrowhead.canDecrease());
		assertFalse(rotationAlternatingFloorPlaneSchemaArrowhead.canDecrease());
		assertFalse(rotationAlternatingFloorPlaneMirrored.canDecrease());
		assertFalse(rotationAlternatingFloorPlaneEmptyArrowheadMirrored.canDecrease());
		assertFalse(rotationAlternatingFloorPlaneSchemaArrowheadMirrored.canDecrease());

		assertFalse(shakingParallelFloor.canDecrease());
		assertFalse(shakingParallelFloorEmptyArrowhead.canDecrease());
		assertFalse(shakingParallelFloorSchemaArrowhead.canDecrease());
		assertFalse(shakingParallelFloorMirrored.canDecrease());
		assertFalse(shakingParallelFloorEmptyArrowheadMirrored.canDecrease());
		assertFalse(shakingParallelFloorSchemaArrowheadMirrored.canDecrease());

	}

	@Override
	public void testDecrease() {

		rotationDoubleFloorPlane.decrease();
		assertEquals(rotationSingleFloorPlane.getSymbol(), rotationDoubleFloorPlane.getSymbol());
		rotationDoubleFloorPlaneEmptyArrowhead.decrease();
		assertEquals(rotationSingleFloorPlaneEmptyArrowhead.getSymbol(),
				rotationDoubleFloorPlaneEmptyArrowhead.getSymbol());
		rotationDoubleFloorPlaneSchemaArrowhead.decrease();
		assertEquals(rotationSingleFloorPlaneSchemaArrowhead.getSymbol(),
				rotationDoubleFloorPlaneSchemaArrowhead.getSymbol());
		rotationDoubleFloorPlaneMirrored.decrease();
		assertEquals(rotationSingleFloorPlaneMirrored.getSymbol(), rotationDoubleFloorPlaneMirrored.getSymbol());
		rotationDoubleFloorPlaneEmptyArrowheadMirrored.decrease();
		assertEquals(rotationSingleFloorPlaneEmptyArrowheadMirrored.getSymbol(),
				rotationDoubleFloorPlaneEmptyArrowheadMirrored.getSymbol());
		rotationDoubleFloorPlaneSchemaArrowheadMirrored.decrease();
		assertEquals(rotationSingleFloorPlaneSchemaArrowheadMirrored.getSymbol(),
				rotationDoubleFloorPlaneSchemaArrowheadMirrored.getSymbol());

	}

	@Override
	public void testCanRotate() {

		assertTrue(curveFloorPlaneSmall.canRotate());
		assertTrue(curveFloorPlaneSmallEmptyArrowhead.canRotate());
		assertTrue(curveFloorPlaneSmallSchemaArrowhead.canRotate());
		assertTrue(curveFloorPlaneSmallMirrored.canRotate());
		assertTrue(curveFloorPlaneSmallEmptyArrowheadMirrored.canRotate());
		assertTrue(curveFloorPlaneSmallSchemaArrowheadMirrored.canRotate());

		assertTrue(curveFloorPlaneMedium1.canRotate());
		assertTrue(curveFloorPlaneMedium1EmptyArrowhead.canRotate());
		assertTrue(curveFloorPlaneMedium1SchemaArrowhead.canRotate());
		assertTrue(curveFloorPlaneMedium1Mirrored.canRotate());
		assertTrue(curveFloorPlaneMedium1EmptyArrowheadMirrored.canRotate());
		assertTrue(curveFloorPlaneMedium1SchemaArrowheadMirrored.canRotate());

		assertTrue(curveFloorPlaneMedium2.canRotate());
		assertTrue(curveFloorPlaneMedium2EmptyArrowhead.canRotate());
		assertTrue(curveFloorPlaneMedium2SchemaArrowhead.canRotate());
		assertTrue(curveFloorPlaneMedium2Mirrored.canRotate());
		assertTrue(curveFloorPlaneMedium2EmptyArrowheadMirrored.canRotate());
		assertTrue(curveFloorPlaneMedium2SchemaArrowheadMirrored.canRotate());

		assertTrue(curveFloorPlaneLarge.canRotate());
		assertTrue(curveFloorPlaneLargeEmptyArrowhead.canRotate());
		assertTrue(curveFloorPlaneLargeSchemaArrowhead.canRotate());
		assertTrue(curveFloorPlaneLargeMirrored.canRotate());
		assertTrue(curveFloorPlaneLargeEmptyArrowheadMirrored.canRotate());
		assertTrue(curveFloorPlaneLargeSchemaArrowheadMirrored.canRotate());

		assertTrue(curveFloorPlaneCombined.canRotate());
		assertTrue(curveFloorPlaneCombinedEmptyArrowhead.canRotate());
		assertTrue(curveFloorPlaneCombinedSchemaArrowhead.canRotate());
		assertTrue(curveFloorPlaneCombinedMirrored.canRotate());
		assertTrue(curveFloorPlaneCombinedEmptyArrowheadMirrored.canRotate());
		assertTrue(curveFloorPlaneCombinedSchemaArrowheadMirrored.canRotate());

		assertTrue(humpFloorPlaneSmall.canRotate());
		assertTrue(humpFloorPlaneSmallEmptyArrowhead.canRotate());
		assertTrue(humpFloorPlaneSmallSchemaArrowhead.canRotate());
		assertTrue(humpFloorPlaneSmallMirrored.canRotate());
		assertTrue(humpFloorPlaneSmallEmptyArrowheadMirrored.canRotate());
		assertTrue(humpFloorPlaneSmallSchemaArrowheadMirrored.canRotate());

		assertTrue(loopFloorPlaneSmall.canRotate());
		assertTrue(loopFloorPlaneSmallEmptyArrowhead.canRotate());
		assertTrue(loopFloorPlaneSmallSchemaArrowhead.canRotate());
		assertTrue(loopFloorPlaneSmallMirrored.canRotate());
		assertTrue(loopFloorPlaneSmallEmptyArrowheadMirrored.canRotate());
		assertTrue(loopFloorPlaneSmallSchemaArrowheadMirrored.canRotate());

		assertTrue(waveFloorPlaneSnake.canRotate());
		assertTrue(waveFloorPlaneSnakeEmptyArrowhead.canRotate());
		assertTrue(waveFloorPlaneSnakeSchemaArrowhead.canRotate());
		assertTrue(waveFloorPlaneSnakeMirrored.canRotate());
		assertTrue(waveFloorPlaneSnakeEmptyArrowheadMirrored.canRotate());
		assertTrue(waveFloorPlaneSnakeSchemaArrowheadMirrored.canRotate());

		assertTrue(waveFloorPlaneSmall.canRotate());
		assertTrue(waveFloorPlaneSmallEmptyArrowhead.canRotate());
		assertTrue(waveFloorPlaneSmallSchemaArrowhead.canRotate());
		assertTrue(waveFloorPlaneSmallMirrored.canRotate());
		assertTrue(waveFloorPlaneSmallEmptyArrowheadMirrored.canRotate());
		assertTrue(waveFloorPlaneSmallSchemaArrowheadMirrored.canRotate());

		assertTrue(waveFloorPlaneLarge.canRotate());
		assertTrue(waveFloorPlaneLargeEmptyArrowhead.canRotate());
		assertTrue(waveFloorPlaneLargeSchemaArrowhead.canRotate());
		assertTrue(waveFloorPlaneLargeMirrored.canRotate());
		assertTrue(waveFloorPlaneLargeEmptyArrowheadMirrored.canRotate());
		assertTrue(waveFloorPlaneLargeSchemaArrowheadMirrored.canRotate());

		assertTrue(rotationSingleFloorPlane.canRotate());
		assertTrue(rotationSingleFloorPlaneEmptyArrowhead.canRotate());
		assertTrue(rotationSingleFloorPlaneSchemaArrowhead.canRotate());
		assertTrue(rotationSingleFloorPlaneMirrored.canRotate());
		assertTrue(rotationSingleFloorPlaneEmptyArrowheadMirrored.canRotate());
		assertTrue(rotationSingleFloorPlaneSchemaArrowheadMirrored.canRotate());

		assertTrue(rotationDoubleFloorPlane.canRotate());
		assertTrue(rotationDoubleFloorPlaneEmptyArrowhead.canRotate());
		assertTrue(rotationDoubleFloorPlaneSchemaArrowhead.canRotate());
		assertTrue(rotationDoubleFloorPlaneMirrored.canRotate());
		assertTrue(rotationDoubleFloorPlaneEmptyArrowheadMirrored.canRotate());
		assertTrue(rotationDoubleFloorPlaneSchemaArrowheadMirrored.canRotate());

		assertTrue(rotationAlternatingFloorPlane.canRotate());
		assertTrue(rotationAlternatingFloorPlaneEmptyArrowhead.canRotate());
		assertTrue(rotationAlternatingFloorPlaneSchemaArrowhead.canRotate());
		assertTrue(rotationAlternatingFloorPlaneMirrored.canRotate());
		assertTrue(rotationAlternatingFloorPlaneEmptyArrowheadMirrored.canRotate());
		assertTrue(rotationAlternatingFloorPlaneSchemaArrowheadMirrored.canRotate());

		assertTrue(shakingParallelFloor.canRotate());
		assertTrue(shakingParallelFloorEmptyArrowhead.canRotate());
		assertTrue(shakingParallelFloorSchemaArrowhead.canRotate());
		assertTrue(shakingParallelFloorMirrored.canRotate());
		assertTrue(shakingParallelFloorEmptyArrowheadMirrored.canRotate());
		assertTrue(shakingParallelFloorSchemaArrowheadMirrored.canRotate());

	}

	@Override
	public void testRotateClockwise() {

		curveFloorPlaneSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-01-01-08"), curveFloorPlaneSmall.getSymbol());
		curveFloorPlaneSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-01-01-07"), curveFloorPlaneSmall.getSymbol());
		curveFloorPlaneSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-01-01-06"), curveFloorPlaneSmall.getSymbol());
		curveFloorPlaneSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-01-01-05"), curveFloorPlaneSmall.getSymbol());
		curveFloorPlaneSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-01-01-04"), curveFloorPlaneSmall.getSymbol());
		curveFloorPlaneSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-01-01-03"), curveFloorPlaneSmall.getSymbol());
		curveFloorPlaneSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-01-01-02"), curveFloorPlaneSmall.getSymbol());
		curveFloorPlaneSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-01-01-01"), curveFloorPlaneSmall.getSymbol());

		curveFloorPlaneSmallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-01-02-08"), curveFloorPlaneSmallEmptyArrowhead.getSymbol());
		curveFloorPlaneSmallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-01-02-07"), curveFloorPlaneSmallEmptyArrowhead.getSymbol());
		curveFloorPlaneSmallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-01-02-06"), curveFloorPlaneSmallEmptyArrowhead.getSymbol());
		curveFloorPlaneSmallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-01-02-05"), curveFloorPlaneSmallEmptyArrowhead.getSymbol());
		curveFloorPlaneSmallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-01-02-04"), curveFloorPlaneSmallEmptyArrowhead.getSymbol());
		curveFloorPlaneSmallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-01-02-03"), curveFloorPlaneSmallEmptyArrowhead.getSymbol());
		curveFloorPlaneSmallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-01-02-02"), curveFloorPlaneSmallEmptyArrowhead.getSymbol());
		curveFloorPlaneSmallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-01-02-01"), curveFloorPlaneSmallEmptyArrowhead.getSymbol());

		curveFloorPlaneSmallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-01-03-08"), curveFloorPlaneSmallSchemaArrowhead.getSymbol());
		curveFloorPlaneSmallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-01-03-07"), curveFloorPlaneSmallSchemaArrowhead.getSymbol());
		curveFloorPlaneSmallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-01-03-06"), curveFloorPlaneSmallSchemaArrowhead.getSymbol());
		curveFloorPlaneSmallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-01-03-05"), curveFloorPlaneSmallSchemaArrowhead.getSymbol());
		curveFloorPlaneSmallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-01-03-04"), curveFloorPlaneSmallSchemaArrowhead.getSymbol());
		curveFloorPlaneSmallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-01-03-03"), curveFloorPlaneSmallSchemaArrowhead.getSymbol());
		curveFloorPlaneSmallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-01-03-02"), curveFloorPlaneSmallSchemaArrowhead.getSymbol());
		curveFloorPlaneSmallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-01-03-01"), curveFloorPlaneSmallSchemaArrowhead.getSymbol());

		curveFloorPlaneSmallMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-01-01-10"), curveFloorPlaneSmallMirrored.getSymbol());
		curveFloorPlaneSmallMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-01-01-11"), curveFloorPlaneSmallMirrored.getSymbol());
		curveFloorPlaneSmallMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-01-01-12"), curveFloorPlaneSmallMirrored.getSymbol());
		curveFloorPlaneSmallMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-01-01-13"), curveFloorPlaneSmallMirrored.getSymbol());
		curveFloorPlaneSmallMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-01-01-14"), curveFloorPlaneSmallMirrored.getSymbol());
		curveFloorPlaneSmallMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-01-01-15"), curveFloorPlaneSmallMirrored.getSymbol());
		curveFloorPlaneSmallMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-01-01-16"), curveFloorPlaneSmallMirrored.getSymbol());
		curveFloorPlaneSmallMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-01-01-09"), curveFloorPlaneSmallMirrored.getSymbol());

		curveFloorPlaneSmallEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-01-02-10"),
				curveFloorPlaneSmallEmptyArrowheadMirrored.getSymbol());
		curveFloorPlaneSmallEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-01-02-11"),
				curveFloorPlaneSmallEmptyArrowheadMirrored.getSymbol());
		curveFloorPlaneSmallEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-01-02-12"),
				curveFloorPlaneSmallEmptyArrowheadMirrored.getSymbol());
		curveFloorPlaneSmallEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-01-02-13"),
				curveFloorPlaneSmallEmptyArrowheadMirrored.getSymbol());
		curveFloorPlaneSmallEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-01-02-14"),
				curveFloorPlaneSmallEmptyArrowheadMirrored.getSymbol());
		curveFloorPlaneSmallEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-01-02-15"),
				curveFloorPlaneSmallEmptyArrowheadMirrored.getSymbol());
		curveFloorPlaneSmallEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-01-02-16"),
				curveFloorPlaneSmallEmptyArrowheadMirrored.getSymbol());
		curveFloorPlaneSmallEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-01-02-09"),
				curveFloorPlaneSmallEmptyArrowheadMirrored.getSymbol());

		curveFloorPlaneSmallSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-01-03-10"),
				curveFloorPlaneSmallSchemaArrowheadMirrored.getSymbol());
		curveFloorPlaneSmallSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-01-03-11"),
				curveFloorPlaneSmallSchemaArrowheadMirrored.getSymbol());
		curveFloorPlaneSmallSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-01-03-12"),
				curveFloorPlaneSmallSchemaArrowheadMirrored.getSymbol());
		curveFloorPlaneSmallSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-01-03-13"),
				curveFloorPlaneSmallSchemaArrowheadMirrored.getSymbol());
		curveFloorPlaneSmallSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-01-03-14"),
				curveFloorPlaneSmallSchemaArrowheadMirrored.getSymbol());
		curveFloorPlaneSmallSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-01-03-15"),
				curveFloorPlaneSmallSchemaArrowheadMirrored.getSymbol());
		curveFloorPlaneSmallSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-01-03-16"),
				curveFloorPlaneSmallSchemaArrowheadMirrored.getSymbol());
		curveFloorPlaneSmallSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-01-03-09"),
				curveFloorPlaneSmallSchemaArrowheadMirrored.getSymbol());

		curveFloorPlaneMedium1.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-02-01-08"), curveFloorPlaneMedium1.getSymbol());
		curveFloorPlaneMedium1.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-02-01-07"), curveFloorPlaneMedium1.getSymbol());
		curveFloorPlaneMedium1.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-02-01-06"), curveFloorPlaneMedium1.getSymbol());
		curveFloorPlaneMedium1.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-02-01-05"), curveFloorPlaneMedium1.getSymbol());
		curveFloorPlaneMedium1.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-02-01-04"), curveFloorPlaneMedium1.getSymbol());
		curveFloorPlaneMedium1.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-02-01-03"), curveFloorPlaneMedium1.getSymbol());
		curveFloorPlaneMedium1.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-02-01-02"), curveFloorPlaneMedium1.getSymbol());
		curveFloorPlaneMedium1.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-02-01-01"), curveFloorPlaneMedium1.getSymbol());

		curveFloorPlaneMedium1EmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-02-02-08"),
				curveFloorPlaneMedium1EmptyArrowhead.getSymbol());
		curveFloorPlaneMedium1EmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-02-02-07"),
				curveFloorPlaneMedium1EmptyArrowhead.getSymbol());
		curveFloorPlaneMedium1EmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-02-02-06"),
				curveFloorPlaneMedium1EmptyArrowhead.getSymbol());
		curveFloorPlaneMedium1EmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-02-02-05"),
				curveFloorPlaneMedium1EmptyArrowhead.getSymbol());
		curveFloorPlaneMedium1EmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-02-02-04"),
				curveFloorPlaneMedium1EmptyArrowhead.getSymbol());
		curveFloorPlaneMedium1EmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-02-02-03"),
				curveFloorPlaneMedium1EmptyArrowhead.getSymbol());
		curveFloorPlaneMedium1EmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-02-02-02"),
				curveFloorPlaneMedium1EmptyArrowhead.getSymbol());
		curveFloorPlaneMedium1EmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-02-02-01"),
				curveFloorPlaneMedium1EmptyArrowhead.getSymbol());

		curveFloorPlaneMedium1SchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-02-03-08"),
				curveFloorPlaneMedium1SchemaArrowhead.getSymbol());
		curveFloorPlaneMedium1SchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-02-03-07"),
				curveFloorPlaneMedium1SchemaArrowhead.getSymbol());
		curveFloorPlaneMedium1SchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-02-03-06"),
				curveFloorPlaneMedium1SchemaArrowhead.getSymbol());
		curveFloorPlaneMedium1SchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-02-03-05"),
				curveFloorPlaneMedium1SchemaArrowhead.getSymbol());
		curveFloorPlaneMedium1SchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-02-03-04"),
				curveFloorPlaneMedium1SchemaArrowhead.getSymbol());
		curveFloorPlaneMedium1SchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-02-03-03"),
				curveFloorPlaneMedium1SchemaArrowhead.getSymbol());
		curveFloorPlaneMedium1SchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-02-03-02"),
				curveFloorPlaneMedium1SchemaArrowhead.getSymbol());
		curveFloorPlaneMedium1SchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-02-03-01"),
				curveFloorPlaneMedium1SchemaArrowhead.getSymbol());

		curveFloorPlaneMedium1Mirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-02-01-10"), curveFloorPlaneMedium1Mirrored.getSymbol());
		curveFloorPlaneMedium1Mirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-02-01-11"), curveFloorPlaneMedium1Mirrored.getSymbol());
		curveFloorPlaneMedium1Mirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-02-01-12"), curveFloorPlaneMedium1Mirrored.getSymbol());
		curveFloorPlaneMedium1Mirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-02-01-13"), curveFloorPlaneMedium1Mirrored.getSymbol());
		curveFloorPlaneMedium1Mirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-02-01-14"), curveFloorPlaneMedium1Mirrored.getSymbol());
		curveFloorPlaneMedium1Mirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-02-01-15"), curveFloorPlaneMedium1Mirrored.getSymbol());
		curveFloorPlaneMedium1Mirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-02-01-16"), curveFloorPlaneMedium1Mirrored.getSymbol());
		curveFloorPlaneMedium1Mirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-02-01-09"), curveFloorPlaneMedium1Mirrored.getSymbol());

		curveFloorPlaneMedium1EmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-02-02-10"),
				curveFloorPlaneMedium1EmptyArrowheadMirrored.getSymbol());
		curveFloorPlaneMedium1EmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-02-02-11"),
				curveFloorPlaneMedium1EmptyArrowheadMirrored.getSymbol());
		curveFloorPlaneMedium1EmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-02-02-12"),
				curveFloorPlaneMedium1EmptyArrowheadMirrored.getSymbol());
		curveFloorPlaneMedium1EmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-02-02-13"),
				curveFloorPlaneMedium1EmptyArrowheadMirrored.getSymbol());
		curveFloorPlaneMedium1EmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-02-02-14"),
				curveFloorPlaneMedium1EmptyArrowheadMirrored.getSymbol());
		curveFloorPlaneMedium1EmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-02-02-15"),
				curveFloorPlaneMedium1EmptyArrowheadMirrored.getSymbol());
		curveFloorPlaneMedium1EmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-02-02-16"),
				curveFloorPlaneMedium1EmptyArrowheadMirrored.getSymbol());
		curveFloorPlaneMedium1EmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-02-02-09"),
				curveFloorPlaneMedium1EmptyArrowheadMirrored.getSymbol());

		curveFloorPlaneMedium1SchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-02-03-10"),
				curveFloorPlaneMedium1SchemaArrowheadMirrored.getSymbol());
		curveFloorPlaneMedium1SchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-02-03-11"),
				curveFloorPlaneMedium1SchemaArrowheadMirrored.getSymbol());
		curveFloorPlaneMedium1SchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-02-03-12"),
				curveFloorPlaneMedium1SchemaArrowheadMirrored.getSymbol());
		curveFloorPlaneMedium1SchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-02-03-13"),
				curveFloorPlaneMedium1SchemaArrowheadMirrored.getSymbol());
		curveFloorPlaneMedium1SchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-02-03-14"),
				curveFloorPlaneMedium1SchemaArrowheadMirrored.getSymbol());
		curveFloorPlaneMedium1SchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-02-03-15"),
				curveFloorPlaneMedium1SchemaArrowheadMirrored.getSymbol());
		curveFloorPlaneMedium1SchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-02-03-16"),
				curveFloorPlaneMedium1SchemaArrowheadMirrored.getSymbol());
		curveFloorPlaneMedium1SchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-02-03-09"),
				curveFloorPlaneMedium1SchemaArrowheadMirrored.getSymbol());

		curveFloorPlaneMedium2.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-03-01-08"), curveFloorPlaneMedium2.getSymbol());
		curveFloorPlaneMedium2.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-03-01-07"), curveFloorPlaneMedium2.getSymbol());
		curveFloorPlaneMedium2.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-03-01-06"), curveFloorPlaneMedium2.getSymbol());
		curveFloorPlaneMedium2.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-03-01-05"), curveFloorPlaneMedium2.getSymbol());
		curveFloorPlaneMedium2.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-03-01-04"), curveFloorPlaneMedium2.getSymbol());
		curveFloorPlaneMedium2.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-03-01-03"), curveFloorPlaneMedium2.getSymbol());
		curveFloorPlaneMedium2.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-03-01-02"), curveFloorPlaneMedium2.getSymbol());
		curveFloorPlaneMedium2.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-03-01-01"), curveFloorPlaneMedium2.getSymbol());

		curveFloorPlaneMedium2EmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-03-02-08"),
				curveFloorPlaneMedium2EmptyArrowhead.getSymbol());
		curveFloorPlaneMedium2EmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-03-02-07"),
				curveFloorPlaneMedium2EmptyArrowhead.getSymbol());
		curveFloorPlaneMedium2EmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-03-02-06"),
				curveFloorPlaneMedium2EmptyArrowhead.getSymbol());
		curveFloorPlaneMedium2EmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-03-02-05"),
				curveFloorPlaneMedium2EmptyArrowhead.getSymbol());
		curveFloorPlaneMedium2EmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-03-02-04"),
				curveFloorPlaneMedium2EmptyArrowhead.getSymbol());
		curveFloorPlaneMedium2EmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-03-02-03"),
				curveFloorPlaneMedium2EmptyArrowhead.getSymbol());
		curveFloorPlaneMedium2EmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-03-02-02"),
				curveFloorPlaneMedium2EmptyArrowhead.getSymbol());
		curveFloorPlaneMedium2EmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-03-02-01"),
				curveFloorPlaneMedium2EmptyArrowhead.getSymbol());

		curveFloorPlaneMedium2SchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-03-03-08"),
				curveFloorPlaneMedium2SchemaArrowhead.getSymbol());
		curveFloorPlaneMedium2SchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-03-03-07"),
				curveFloorPlaneMedium2SchemaArrowhead.getSymbol());
		curveFloorPlaneMedium2SchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-03-03-06"),
				curveFloorPlaneMedium2SchemaArrowhead.getSymbol());
		curveFloorPlaneMedium2SchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-03-03-05"),
				curveFloorPlaneMedium2SchemaArrowhead.getSymbol());
		curveFloorPlaneMedium2SchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-03-03-04"),
				curveFloorPlaneMedium2SchemaArrowhead.getSymbol());
		curveFloorPlaneMedium2SchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-03-03-03"),
				curveFloorPlaneMedium2SchemaArrowhead.getSymbol());
		curveFloorPlaneMedium2SchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-03-03-02"),
				curveFloorPlaneMedium2SchemaArrowhead.getSymbol());
		curveFloorPlaneMedium2SchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-03-03-01"),
				curveFloorPlaneMedium2SchemaArrowhead.getSymbol());

		curveFloorPlaneMedium2Mirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-03-01-10"), curveFloorPlaneMedium2Mirrored.getSymbol());
		curveFloorPlaneMedium2Mirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-03-01-11"), curveFloorPlaneMedium2Mirrored.getSymbol());
		curveFloorPlaneMedium2Mirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-03-01-12"), curveFloorPlaneMedium2Mirrored.getSymbol());
		curveFloorPlaneMedium2Mirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-03-01-13"), curveFloorPlaneMedium2Mirrored.getSymbol());
		curveFloorPlaneMedium2Mirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-03-01-14"), curveFloorPlaneMedium2Mirrored.getSymbol());
		curveFloorPlaneMedium2Mirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-03-01-15"), curveFloorPlaneMedium2Mirrored.getSymbol());
		curveFloorPlaneMedium2Mirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-03-01-16"), curveFloorPlaneMedium2Mirrored.getSymbol());
		curveFloorPlaneMedium2Mirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-03-01-09"), curveFloorPlaneMedium2Mirrored.getSymbol());

		curveFloorPlaneMedium2EmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-03-02-10"),
				curveFloorPlaneMedium2EmptyArrowheadMirrored.getSymbol());
		curveFloorPlaneMedium2EmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-03-02-11"),
				curveFloorPlaneMedium2EmptyArrowheadMirrored.getSymbol());
		curveFloorPlaneMedium2EmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-03-02-12"),
				curveFloorPlaneMedium2EmptyArrowheadMirrored.getSymbol());
		curveFloorPlaneMedium2EmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-03-02-13"),
				curveFloorPlaneMedium2EmptyArrowheadMirrored.getSymbol());
		curveFloorPlaneMedium2EmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-03-02-14"),
				curveFloorPlaneMedium2EmptyArrowheadMirrored.getSymbol());
		curveFloorPlaneMedium2EmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-03-02-15"),
				curveFloorPlaneMedium2EmptyArrowheadMirrored.getSymbol());
		curveFloorPlaneMedium2EmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-03-02-16"),
				curveFloorPlaneMedium2EmptyArrowheadMirrored.getSymbol());
		curveFloorPlaneMedium2EmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-03-02-09"),
				curveFloorPlaneMedium2EmptyArrowheadMirrored.getSymbol());

		curveFloorPlaneMedium2SchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-03-03-10"),
				curveFloorPlaneMedium2SchemaArrowheadMirrored.getSymbol());
		curveFloorPlaneMedium2SchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-03-03-11"),
				curveFloorPlaneMedium2SchemaArrowheadMirrored.getSymbol());
		curveFloorPlaneMedium2SchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-03-03-12"),
				curveFloorPlaneMedium2SchemaArrowheadMirrored.getSymbol());
		curveFloorPlaneMedium2SchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-03-03-13"),
				curveFloorPlaneMedium2SchemaArrowheadMirrored.getSymbol());
		curveFloorPlaneMedium2SchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-03-03-14"),
				curveFloorPlaneMedium2SchemaArrowheadMirrored.getSymbol());
		curveFloorPlaneMedium2SchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-03-03-15"),
				curveFloorPlaneMedium2SchemaArrowheadMirrored.getSymbol());
		curveFloorPlaneMedium2SchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-03-03-16"),
				curveFloorPlaneMedium2SchemaArrowheadMirrored.getSymbol());
		curveFloorPlaneMedium2SchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-03-03-09"),
				curveFloorPlaneMedium2SchemaArrowheadMirrored.getSymbol());

		curveFloorPlaneLarge.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-04-01-08"), curveFloorPlaneLarge.getSymbol());
		curveFloorPlaneLarge.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-04-01-07"), curveFloorPlaneLarge.getSymbol());
		curveFloorPlaneLarge.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-04-01-06"), curveFloorPlaneLarge.getSymbol());
		curveFloorPlaneLarge.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-04-01-05"), curveFloorPlaneLarge.getSymbol());
		curveFloorPlaneLarge.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-04-01-04"), curveFloorPlaneLarge.getSymbol());
		curveFloorPlaneLarge.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-04-01-03"), curveFloorPlaneLarge.getSymbol());
		curveFloorPlaneLarge.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-04-01-02"), curveFloorPlaneLarge.getSymbol());
		curveFloorPlaneLarge.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-04-01-01"), curveFloorPlaneLarge.getSymbol());

		curveFloorPlaneLargeEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-04-02-08"), curveFloorPlaneLargeEmptyArrowhead.getSymbol());
		curveFloorPlaneLargeEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-04-02-07"), curveFloorPlaneLargeEmptyArrowhead.getSymbol());
		curveFloorPlaneLargeEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-04-02-06"), curveFloorPlaneLargeEmptyArrowhead.getSymbol());
		curveFloorPlaneLargeEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-04-02-05"), curveFloorPlaneLargeEmptyArrowhead.getSymbol());
		curveFloorPlaneLargeEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-04-02-04"), curveFloorPlaneLargeEmptyArrowhead.getSymbol());
		curveFloorPlaneLargeEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-04-02-03"), curveFloorPlaneLargeEmptyArrowhead.getSymbol());
		curveFloorPlaneLargeEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-04-02-02"), curveFloorPlaneLargeEmptyArrowhead.getSymbol());
		curveFloorPlaneLargeEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-04-02-01"), curveFloorPlaneLargeEmptyArrowhead.getSymbol());

		curveFloorPlaneLargeSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-04-03-08"), curveFloorPlaneLargeSchemaArrowhead.getSymbol());
		curveFloorPlaneLargeSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-04-03-07"), curveFloorPlaneLargeSchemaArrowhead.getSymbol());
		curveFloorPlaneLargeSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-04-03-06"), curveFloorPlaneLargeSchemaArrowhead.getSymbol());
		curveFloorPlaneLargeSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-04-03-05"), curveFloorPlaneLargeSchemaArrowhead.getSymbol());
		curveFloorPlaneLargeSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-04-03-04"), curveFloorPlaneLargeSchemaArrowhead.getSymbol());
		curveFloorPlaneLargeSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-04-03-03"), curveFloorPlaneLargeSchemaArrowhead.getSymbol());
		curveFloorPlaneLargeSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-04-03-02"), curveFloorPlaneLargeSchemaArrowhead.getSymbol());
		curveFloorPlaneLargeSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-04-03-01"), curveFloorPlaneLargeSchemaArrowhead.getSymbol());

		curveFloorPlaneLargeMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-04-01-10"), curveFloorPlaneLargeMirrored.getSymbol());
		curveFloorPlaneLargeMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-04-01-11"), curveFloorPlaneLargeMirrored.getSymbol());
		curveFloorPlaneLargeMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-04-01-12"), curveFloorPlaneLargeMirrored.getSymbol());
		curveFloorPlaneLargeMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-04-01-13"), curveFloorPlaneLargeMirrored.getSymbol());
		curveFloorPlaneLargeMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-04-01-14"), curveFloorPlaneLargeMirrored.getSymbol());
		curveFloorPlaneLargeMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-04-01-15"), curveFloorPlaneLargeMirrored.getSymbol());
		curveFloorPlaneLargeMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-04-01-16"), curveFloorPlaneLargeMirrored.getSymbol());
		curveFloorPlaneLargeMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-04-01-09"), curveFloorPlaneLargeMirrored.getSymbol());

		curveFloorPlaneLargeEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-04-02-10"),
				curveFloorPlaneLargeEmptyArrowheadMirrored.getSymbol());
		curveFloorPlaneLargeEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-04-02-11"),
				curveFloorPlaneLargeEmptyArrowheadMirrored.getSymbol());
		curveFloorPlaneLargeEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-04-02-12"),
				curveFloorPlaneLargeEmptyArrowheadMirrored.getSymbol());
		curveFloorPlaneLargeEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-04-02-13"),
				curveFloorPlaneLargeEmptyArrowheadMirrored.getSymbol());
		curveFloorPlaneLargeEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-04-02-14"),
				curveFloorPlaneLargeEmptyArrowheadMirrored.getSymbol());
		curveFloorPlaneLargeEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-04-02-15"),
				curveFloorPlaneLargeEmptyArrowheadMirrored.getSymbol());
		curveFloorPlaneLargeEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-04-02-16"),
				curveFloorPlaneLargeEmptyArrowheadMirrored.getSymbol());
		curveFloorPlaneLargeEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-04-02-09"),
				curveFloorPlaneLargeEmptyArrowheadMirrored.getSymbol());

		curveFloorPlaneLargeSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-04-03-10"),
				curveFloorPlaneLargeSchemaArrowheadMirrored.getSymbol());
		curveFloorPlaneLargeSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-04-03-11"),
				curveFloorPlaneLargeSchemaArrowheadMirrored.getSymbol());
		curveFloorPlaneLargeSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-04-03-12"),
				curveFloorPlaneLargeSchemaArrowheadMirrored.getSymbol());
		curveFloorPlaneLargeSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-04-03-13"),
				curveFloorPlaneLargeSchemaArrowheadMirrored.getSymbol());
		curveFloorPlaneLargeSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-04-03-14"),
				curveFloorPlaneLargeSchemaArrowheadMirrored.getSymbol());
		curveFloorPlaneLargeSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-04-03-15"),
				curveFloorPlaneLargeSchemaArrowheadMirrored.getSymbol());
		curveFloorPlaneLargeSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-04-03-16"),
				curveFloorPlaneLargeSchemaArrowheadMirrored.getSymbol());
		curveFloorPlaneLargeSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-04-03-09"),
				curveFloorPlaneLargeSchemaArrowheadMirrored.getSymbol());

		curveFloorPlaneCombined.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-05-01-08"), curveFloorPlaneCombined.getSymbol());
		curveFloorPlaneCombined.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-05-01-07"), curveFloorPlaneCombined.getSymbol());
		curveFloorPlaneCombined.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-05-01-06"), curveFloorPlaneCombined.getSymbol());
		curveFloorPlaneCombined.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-05-01-05"), curveFloorPlaneCombined.getSymbol());
		curveFloorPlaneCombined.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-05-01-04"), curveFloorPlaneCombined.getSymbol());
		curveFloorPlaneCombined.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-05-01-03"), curveFloorPlaneCombined.getSymbol());
		curveFloorPlaneCombined.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-05-01-02"), curveFloorPlaneCombined.getSymbol());
		curveFloorPlaneCombined.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-05-01-01"), curveFloorPlaneCombined.getSymbol());

		curveFloorPlaneCombinedEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-05-02-08"),
				curveFloorPlaneCombinedEmptyArrowhead.getSymbol());
		curveFloorPlaneCombinedEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-05-02-07"),
				curveFloorPlaneCombinedEmptyArrowhead.getSymbol());
		curveFloorPlaneCombinedEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-05-02-06"),
				curveFloorPlaneCombinedEmptyArrowhead.getSymbol());
		curveFloorPlaneCombinedEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-05-02-05"),
				curveFloorPlaneCombinedEmptyArrowhead.getSymbol());
		curveFloorPlaneCombinedEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-05-02-04"),
				curveFloorPlaneCombinedEmptyArrowhead.getSymbol());
		curveFloorPlaneCombinedEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-05-02-03"),
				curveFloorPlaneCombinedEmptyArrowhead.getSymbol());
		curveFloorPlaneCombinedEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-05-02-02"),
				curveFloorPlaneCombinedEmptyArrowhead.getSymbol());
		curveFloorPlaneCombinedEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-05-02-01"),
				curveFloorPlaneCombinedEmptyArrowhead.getSymbol());

		curveFloorPlaneCombinedSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-05-03-08"),
				curveFloorPlaneCombinedSchemaArrowhead.getSymbol());
		curveFloorPlaneCombinedSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-05-03-07"),
				curveFloorPlaneCombinedSchemaArrowhead.getSymbol());
		curveFloorPlaneCombinedSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-05-03-06"),
				curveFloorPlaneCombinedSchemaArrowhead.getSymbol());
		curveFloorPlaneCombinedSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-05-03-05"),
				curveFloorPlaneCombinedSchemaArrowhead.getSymbol());
		curveFloorPlaneCombinedSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-05-03-04"),
				curveFloorPlaneCombinedSchemaArrowhead.getSymbol());
		curveFloorPlaneCombinedSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-05-03-03"),
				curveFloorPlaneCombinedSchemaArrowhead.getSymbol());
		curveFloorPlaneCombinedSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-05-03-02"),
				curveFloorPlaneCombinedSchemaArrowhead.getSymbol());
		curveFloorPlaneCombinedSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-05-03-01"),
				curveFloorPlaneCombinedSchemaArrowhead.getSymbol());

		curveFloorPlaneCombinedMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-05-01-10"), curveFloorPlaneCombinedMirrored.getSymbol());
		curveFloorPlaneCombinedMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-05-01-11"), curveFloorPlaneCombinedMirrored.getSymbol());
		curveFloorPlaneCombinedMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-05-01-12"), curveFloorPlaneCombinedMirrored.getSymbol());
		curveFloorPlaneCombinedMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-05-01-13"), curveFloorPlaneCombinedMirrored.getSymbol());
		curveFloorPlaneCombinedMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-05-01-14"), curveFloorPlaneCombinedMirrored.getSymbol());
		curveFloorPlaneCombinedMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-05-01-15"), curveFloorPlaneCombinedMirrored.getSymbol());
		curveFloorPlaneCombinedMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-05-01-16"), curveFloorPlaneCombinedMirrored.getSymbol());
		curveFloorPlaneCombinedMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-05-01-09"), curveFloorPlaneCombinedMirrored.getSymbol());

		curveFloorPlaneCombinedEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-05-02-10"),
				curveFloorPlaneCombinedEmptyArrowheadMirrored.getSymbol());
		curveFloorPlaneCombinedEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-05-02-11"),
				curveFloorPlaneCombinedEmptyArrowheadMirrored.getSymbol());
		curveFloorPlaneCombinedEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-05-02-12"),
				curveFloorPlaneCombinedEmptyArrowheadMirrored.getSymbol());
		curveFloorPlaneCombinedEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-05-02-13"),
				curveFloorPlaneCombinedEmptyArrowheadMirrored.getSymbol());
		curveFloorPlaneCombinedEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-05-02-14"),
				curveFloorPlaneCombinedEmptyArrowheadMirrored.getSymbol());
		curveFloorPlaneCombinedEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-05-02-15"),
				curveFloorPlaneCombinedEmptyArrowheadMirrored.getSymbol());
		curveFloorPlaneCombinedEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-05-02-16"),
				curveFloorPlaneCombinedEmptyArrowheadMirrored.getSymbol());
		curveFloorPlaneCombinedEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-05-02-09"),
				curveFloorPlaneCombinedEmptyArrowheadMirrored.getSymbol());

		curveFloorPlaneCombinedSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-05-03-10"),
				curveFloorPlaneCombinedSchemaArrowheadMirrored.getSymbol());
		curveFloorPlaneCombinedSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-05-03-11"),
				curveFloorPlaneCombinedSchemaArrowheadMirrored.getSymbol());
		curveFloorPlaneCombinedSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-05-03-12"),
				curveFloorPlaneCombinedSchemaArrowheadMirrored.getSymbol());
		curveFloorPlaneCombinedSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-05-03-13"),
				curveFloorPlaneCombinedSchemaArrowheadMirrored.getSymbol());
		curveFloorPlaneCombinedSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-05-03-14"),
				curveFloorPlaneCombinedSchemaArrowheadMirrored.getSymbol());
		curveFloorPlaneCombinedSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-05-03-15"),
				curveFloorPlaneCombinedSchemaArrowheadMirrored.getSymbol());
		curveFloorPlaneCombinedSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-05-03-16"),
				curveFloorPlaneCombinedSchemaArrowheadMirrored.getSymbol());
		curveFloorPlaneCombinedSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-05-03-09"),
				curveFloorPlaneCombinedSchemaArrowheadMirrored.getSymbol());

		humpFloorPlaneSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-002-01-01-08"), humpFloorPlaneSmall.getSymbol());
		humpFloorPlaneSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-002-01-01-07"), humpFloorPlaneSmall.getSymbol());
		humpFloorPlaneSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-002-01-01-06"), humpFloorPlaneSmall.getSymbol());
		humpFloorPlaneSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-002-01-01-05"), humpFloorPlaneSmall.getSymbol());
		humpFloorPlaneSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-002-01-01-04"), humpFloorPlaneSmall.getSymbol());
		humpFloorPlaneSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-002-01-01-03"), humpFloorPlaneSmall.getSymbol());
		humpFloorPlaneSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-002-01-01-02"), humpFloorPlaneSmall.getSymbol());
		humpFloorPlaneSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-002-01-01-01"), humpFloorPlaneSmall.getSymbol());

		humpFloorPlaneSmallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-002-01-02-08"), humpFloorPlaneSmallEmptyArrowhead.getSymbol());
		humpFloorPlaneSmallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-002-01-02-07"), humpFloorPlaneSmallEmptyArrowhead.getSymbol());
		humpFloorPlaneSmallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-002-01-02-06"), humpFloorPlaneSmallEmptyArrowhead.getSymbol());
		humpFloorPlaneSmallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-002-01-02-05"), humpFloorPlaneSmallEmptyArrowhead.getSymbol());
		humpFloorPlaneSmallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-002-01-02-04"), humpFloorPlaneSmallEmptyArrowhead.getSymbol());
		humpFloorPlaneSmallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-002-01-02-03"), humpFloorPlaneSmallEmptyArrowhead.getSymbol());
		humpFloorPlaneSmallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-002-01-02-02"), humpFloorPlaneSmallEmptyArrowhead.getSymbol());
		humpFloorPlaneSmallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-002-01-02-01"), humpFloorPlaneSmallEmptyArrowhead.getSymbol());

		humpFloorPlaneSmallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-002-01-03-08"), humpFloorPlaneSmallSchemaArrowhead.getSymbol());
		humpFloorPlaneSmallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-002-01-03-07"), humpFloorPlaneSmallSchemaArrowhead.getSymbol());
		humpFloorPlaneSmallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-002-01-03-06"), humpFloorPlaneSmallSchemaArrowhead.getSymbol());
		humpFloorPlaneSmallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-002-01-03-05"), humpFloorPlaneSmallSchemaArrowhead.getSymbol());
		humpFloorPlaneSmallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-002-01-03-04"), humpFloorPlaneSmallSchemaArrowhead.getSymbol());
		humpFloorPlaneSmallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-002-01-03-03"), humpFloorPlaneSmallSchemaArrowhead.getSymbol());
		humpFloorPlaneSmallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-002-01-03-02"), humpFloorPlaneSmallSchemaArrowhead.getSymbol());
		humpFloorPlaneSmallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-002-01-03-01"), humpFloorPlaneSmallSchemaArrowhead.getSymbol());

		humpFloorPlaneSmallMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-002-01-01-10"), humpFloorPlaneSmallMirrored.getSymbol());
		humpFloorPlaneSmallMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-002-01-01-11"), humpFloorPlaneSmallMirrored.getSymbol());
		humpFloorPlaneSmallMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-002-01-01-12"), humpFloorPlaneSmallMirrored.getSymbol());
		humpFloorPlaneSmallMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-002-01-01-13"), humpFloorPlaneSmallMirrored.getSymbol());
		humpFloorPlaneSmallMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-002-01-01-14"), humpFloorPlaneSmallMirrored.getSymbol());
		humpFloorPlaneSmallMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-002-01-01-15"), humpFloorPlaneSmallMirrored.getSymbol());
		humpFloorPlaneSmallMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-002-01-01-16"), humpFloorPlaneSmallMirrored.getSymbol());
		humpFloorPlaneSmallMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-002-01-01-09"), humpFloorPlaneSmallMirrored.getSymbol());

		humpFloorPlaneSmallEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-002-01-02-10"),
				humpFloorPlaneSmallEmptyArrowheadMirrored.getSymbol());
		humpFloorPlaneSmallEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-002-01-02-11"),
				humpFloorPlaneSmallEmptyArrowheadMirrored.getSymbol());
		humpFloorPlaneSmallEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-002-01-02-12"),
				humpFloorPlaneSmallEmptyArrowheadMirrored.getSymbol());
		humpFloorPlaneSmallEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-002-01-02-13"),
				humpFloorPlaneSmallEmptyArrowheadMirrored.getSymbol());
		humpFloorPlaneSmallEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-002-01-02-14"),
				humpFloorPlaneSmallEmptyArrowheadMirrored.getSymbol());
		humpFloorPlaneSmallEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-002-01-02-15"),
				humpFloorPlaneSmallEmptyArrowheadMirrored.getSymbol());
		humpFloorPlaneSmallEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-002-01-02-16"),
				humpFloorPlaneSmallEmptyArrowheadMirrored.getSymbol());
		humpFloorPlaneSmallEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-002-01-02-09"),
				humpFloorPlaneSmallEmptyArrowheadMirrored.getSymbol());

		humpFloorPlaneSmallSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-002-01-03-10"),
				humpFloorPlaneSmallSchemaArrowheadMirrored.getSymbol());
		humpFloorPlaneSmallSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-002-01-03-11"),
				humpFloorPlaneSmallSchemaArrowheadMirrored.getSymbol());
		humpFloorPlaneSmallSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-002-01-03-12"),
				humpFloorPlaneSmallSchemaArrowheadMirrored.getSymbol());
		humpFloorPlaneSmallSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-002-01-03-13"),
				humpFloorPlaneSmallSchemaArrowheadMirrored.getSymbol());
		humpFloorPlaneSmallSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-002-01-03-14"),
				humpFloorPlaneSmallSchemaArrowheadMirrored.getSymbol());
		humpFloorPlaneSmallSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-002-01-03-15"),
				humpFloorPlaneSmallSchemaArrowheadMirrored.getSymbol());
		humpFloorPlaneSmallSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-002-01-03-16"),
				humpFloorPlaneSmallSchemaArrowheadMirrored.getSymbol());
		humpFloorPlaneSmallSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-002-01-03-09"),
				humpFloorPlaneSmallSchemaArrowheadMirrored.getSymbol());

		loopFloorPlaneSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-003-01-01-08"), loopFloorPlaneSmall.getSymbol());
		loopFloorPlaneSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-003-01-01-07"), loopFloorPlaneSmall.getSymbol());
		loopFloorPlaneSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-003-01-01-06"), loopFloorPlaneSmall.getSymbol());
		loopFloorPlaneSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-003-01-01-05"), loopFloorPlaneSmall.getSymbol());
		loopFloorPlaneSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-003-01-01-04"), loopFloorPlaneSmall.getSymbol());
		loopFloorPlaneSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-003-01-01-03"), loopFloorPlaneSmall.getSymbol());
		loopFloorPlaneSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-003-01-01-02"), loopFloorPlaneSmall.getSymbol());
		loopFloorPlaneSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-003-01-01-01"), loopFloorPlaneSmall.getSymbol());

		loopFloorPlaneSmallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-003-01-02-08"), loopFloorPlaneSmallEmptyArrowhead.getSymbol());
		loopFloorPlaneSmallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-003-01-02-07"), loopFloorPlaneSmallEmptyArrowhead.getSymbol());
		loopFloorPlaneSmallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-003-01-02-06"), loopFloorPlaneSmallEmptyArrowhead.getSymbol());
		loopFloorPlaneSmallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-003-01-02-05"), loopFloorPlaneSmallEmptyArrowhead.getSymbol());
		loopFloorPlaneSmallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-003-01-02-04"), loopFloorPlaneSmallEmptyArrowhead.getSymbol());
		loopFloorPlaneSmallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-003-01-02-03"), loopFloorPlaneSmallEmptyArrowhead.getSymbol());
		loopFloorPlaneSmallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-003-01-02-02"), loopFloorPlaneSmallEmptyArrowhead.getSymbol());
		loopFloorPlaneSmallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-003-01-02-01"), loopFloorPlaneSmallEmptyArrowhead.getSymbol());

		loopFloorPlaneSmallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-003-01-03-08"), loopFloorPlaneSmallSchemaArrowhead.getSymbol());
		loopFloorPlaneSmallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-003-01-03-07"), loopFloorPlaneSmallSchemaArrowhead.getSymbol());
		loopFloorPlaneSmallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-003-01-03-06"), loopFloorPlaneSmallSchemaArrowhead.getSymbol());
		loopFloorPlaneSmallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-003-01-03-05"), loopFloorPlaneSmallSchemaArrowhead.getSymbol());
		loopFloorPlaneSmallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-003-01-03-04"), loopFloorPlaneSmallSchemaArrowhead.getSymbol());
		loopFloorPlaneSmallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-003-01-03-03"), loopFloorPlaneSmallSchemaArrowhead.getSymbol());
		loopFloorPlaneSmallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-003-01-03-02"), loopFloorPlaneSmallSchemaArrowhead.getSymbol());
		loopFloorPlaneSmallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-003-01-03-01"), loopFloorPlaneSmallSchemaArrowhead.getSymbol());

		loopFloorPlaneSmallMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-003-01-01-10"), loopFloorPlaneSmallMirrored.getSymbol());
		loopFloorPlaneSmallMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-003-01-01-11"), loopFloorPlaneSmallMirrored.getSymbol());
		loopFloorPlaneSmallMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-003-01-01-12"), loopFloorPlaneSmallMirrored.getSymbol());
		loopFloorPlaneSmallMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-003-01-01-13"), loopFloorPlaneSmallMirrored.getSymbol());
		loopFloorPlaneSmallMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-003-01-01-14"), loopFloorPlaneSmallMirrored.getSymbol());
		loopFloorPlaneSmallMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-003-01-01-15"), loopFloorPlaneSmallMirrored.getSymbol());
		loopFloorPlaneSmallMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-003-01-01-16"), loopFloorPlaneSmallMirrored.getSymbol());
		loopFloorPlaneSmallMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-003-01-01-09"), loopFloorPlaneSmallMirrored.getSymbol());

		loopFloorPlaneSmallEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-003-01-02-10"),
				loopFloorPlaneSmallEmptyArrowheadMirrored.getSymbol());
		loopFloorPlaneSmallEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-003-01-02-11"),
				loopFloorPlaneSmallEmptyArrowheadMirrored.getSymbol());
		loopFloorPlaneSmallEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-003-01-02-12"),
				loopFloorPlaneSmallEmptyArrowheadMirrored.getSymbol());
		loopFloorPlaneSmallEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-003-01-02-13"),
				loopFloorPlaneSmallEmptyArrowheadMirrored.getSymbol());
		loopFloorPlaneSmallEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-003-01-02-14"),
				loopFloorPlaneSmallEmptyArrowheadMirrored.getSymbol());
		loopFloorPlaneSmallEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-003-01-02-15"),
				loopFloorPlaneSmallEmptyArrowheadMirrored.getSymbol());
		loopFloorPlaneSmallEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-003-01-02-16"),
				loopFloorPlaneSmallEmptyArrowheadMirrored.getSymbol());
		loopFloorPlaneSmallEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-003-01-02-09"),
				loopFloorPlaneSmallEmptyArrowheadMirrored.getSymbol());

		loopFloorPlaneSmallSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-003-01-03-10"),
				loopFloorPlaneSmallSchemaArrowheadMirrored.getSymbol());
		loopFloorPlaneSmallSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-003-01-03-11"),
				loopFloorPlaneSmallSchemaArrowheadMirrored.getSymbol());
		loopFloorPlaneSmallSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-003-01-03-12"),
				loopFloorPlaneSmallSchemaArrowheadMirrored.getSymbol());
		loopFloorPlaneSmallSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-003-01-03-13"),
				loopFloorPlaneSmallSchemaArrowheadMirrored.getSymbol());
		loopFloorPlaneSmallSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-003-01-03-14"),
				loopFloorPlaneSmallSchemaArrowheadMirrored.getSymbol());
		loopFloorPlaneSmallSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-003-01-03-15"),
				loopFloorPlaneSmallSchemaArrowheadMirrored.getSymbol());
		loopFloorPlaneSmallSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-003-01-03-16"),
				loopFloorPlaneSmallSchemaArrowheadMirrored.getSymbol());
		loopFloorPlaneSmallSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-003-01-03-09"),
				loopFloorPlaneSmallSchemaArrowheadMirrored.getSymbol());

		waveFloorPlaneSnake.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-01-01-08"), waveFloorPlaneSnake.getSymbol());
		waveFloorPlaneSnake.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-01-01-07"), waveFloorPlaneSnake.getSymbol());
		waveFloorPlaneSnake.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-01-01-06"), waveFloorPlaneSnake.getSymbol());
		waveFloorPlaneSnake.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-01-01-05"), waveFloorPlaneSnake.getSymbol());
		waveFloorPlaneSnake.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-01-01-04"), waveFloorPlaneSnake.getSymbol());
		waveFloorPlaneSnake.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-01-01-03"), waveFloorPlaneSnake.getSymbol());
		waveFloorPlaneSnake.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-01-01-02"), waveFloorPlaneSnake.getSymbol());
		waveFloorPlaneSnake.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-01-01-01"), waveFloorPlaneSnake.getSymbol());

		waveFloorPlaneSnakeEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-01-02-08"), waveFloorPlaneSnakeEmptyArrowhead.getSymbol());
		waveFloorPlaneSnakeEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-01-02-07"), waveFloorPlaneSnakeEmptyArrowhead.getSymbol());
		waveFloorPlaneSnakeEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-01-02-06"), waveFloorPlaneSnakeEmptyArrowhead.getSymbol());
		waveFloorPlaneSnakeEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-01-02-05"), waveFloorPlaneSnakeEmptyArrowhead.getSymbol());
		waveFloorPlaneSnakeEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-01-02-04"), waveFloorPlaneSnakeEmptyArrowhead.getSymbol());
		waveFloorPlaneSnakeEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-01-02-03"), waveFloorPlaneSnakeEmptyArrowhead.getSymbol());
		waveFloorPlaneSnakeEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-01-02-02"), waveFloorPlaneSnakeEmptyArrowhead.getSymbol());
		waveFloorPlaneSnakeEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-01-02-01"), waveFloorPlaneSnakeEmptyArrowhead.getSymbol());

		waveFloorPlaneSnakeSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-01-03-08"), waveFloorPlaneSnakeSchemaArrowhead.getSymbol());
		waveFloorPlaneSnakeSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-01-03-07"), waveFloorPlaneSnakeSchemaArrowhead.getSymbol());
		waveFloorPlaneSnakeSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-01-03-06"), waveFloorPlaneSnakeSchemaArrowhead.getSymbol());
		waveFloorPlaneSnakeSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-01-03-05"), waveFloorPlaneSnakeSchemaArrowhead.getSymbol());
		waveFloorPlaneSnakeSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-01-03-04"), waveFloorPlaneSnakeSchemaArrowhead.getSymbol());
		waveFloorPlaneSnakeSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-01-03-03"), waveFloorPlaneSnakeSchemaArrowhead.getSymbol());
		waveFloorPlaneSnakeSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-01-03-02"), waveFloorPlaneSnakeSchemaArrowhead.getSymbol());
		waveFloorPlaneSnakeSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-01-03-01"), waveFloorPlaneSnakeSchemaArrowhead.getSymbol());

		waveFloorPlaneSnakeMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-01-01-10"), waveFloorPlaneSnakeMirrored.getSymbol());
		waveFloorPlaneSnakeMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-01-01-11"), waveFloorPlaneSnakeMirrored.getSymbol());
		waveFloorPlaneSnakeMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-01-01-12"), waveFloorPlaneSnakeMirrored.getSymbol());
		waveFloorPlaneSnakeMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-01-01-13"), waveFloorPlaneSnakeMirrored.getSymbol());
		waveFloorPlaneSnakeMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-01-01-14"), waveFloorPlaneSnakeMirrored.getSymbol());
		waveFloorPlaneSnakeMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-01-01-15"), waveFloorPlaneSnakeMirrored.getSymbol());
		waveFloorPlaneSnakeMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-01-01-16"), waveFloorPlaneSnakeMirrored.getSymbol());
		waveFloorPlaneSnakeMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-01-01-09"), waveFloorPlaneSnakeMirrored.getSymbol());

		waveFloorPlaneSnakeEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-01-02-10"),
				waveFloorPlaneSnakeEmptyArrowheadMirrored.getSymbol());
		waveFloorPlaneSnakeEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-01-02-11"),
				waveFloorPlaneSnakeEmptyArrowheadMirrored.getSymbol());
		waveFloorPlaneSnakeEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-01-02-12"),
				waveFloorPlaneSnakeEmptyArrowheadMirrored.getSymbol());
		waveFloorPlaneSnakeEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-01-02-13"),
				waveFloorPlaneSnakeEmptyArrowheadMirrored.getSymbol());
		waveFloorPlaneSnakeEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-01-02-14"),
				waveFloorPlaneSnakeEmptyArrowheadMirrored.getSymbol());
		waveFloorPlaneSnakeEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-01-02-15"),
				waveFloorPlaneSnakeEmptyArrowheadMirrored.getSymbol());
		waveFloorPlaneSnakeEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-01-02-16"),
				waveFloorPlaneSnakeEmptyArrowheadMirrored.getSymbol());
		waveFloorPlaneSnakeEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-01-02-09"),
				waveFloorPlaneSnakeEmptyArrowheadMirrored.getSymbol());

		waveFloorPlaneSnakeSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-01-03-10"),
				waveFloorPlaneSnakeSchemaArrowheadMirrored.getSymbol());
		waveFloorPlaneSnakeSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-01-03-11"),
				waveFloorPlaneSnakeSchemaArrowheadMirrored.getSymbol());
		waveFloorPlaneSnakeSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-01-03-12"),
				waveFloorPlaneSnakeSchemaArrowheadMirrored.getSymbol());
		waveFloorPlaneSnakeSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-01-03-13"),
				waveFloorPlaneSnakeSchemaArrowheadMirrored.getSymbol());
		waveFloorPlaneSnakeSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-01-03-14"),
				waveFloorPlaneSnakeSchemaArrowheadMirrored.getSymbol());
		waveFloorPlaneSnakeSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-01-03-15"),
				waveFloorPlaneSnakeSchemaArrowheadMirrored.getSymbol());
		waveFloorPlaneSnakeSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-01-03-16"),
				waveFloorPlaneSnakeSchemaArrowheadMirrored.getSymbol());
		waveFloorPlaneSnakeSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-01-03-09"),
				waveFloorPlaneSnakeSchemaArrowheadMirrored.getSymbol());

		waveFloorPlaneSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-02-01-08"), waveFloorPlaneSmall.getSymbol());
		waveFloorPlaneSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-02-01-07"), waveFloorPlaneSmall.getSymbol());
		waveFloorPlaneSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-02-01-06"), waveFloorPlaneSmall.getSymbol());
		waveFloorPlaneSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-02-01-05"), waveFloorPlaneSmall.getSymbol());
		waveFloorPlaneSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-02-01-04"), waveFloorPlaneSmall.getSymbol());
		waveFloorPlaneSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-02-01-03"), waveFloorPlaneSmall.getSymbol());
		waveFloorPlaneSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-02-01-02"), waveFloorPlaneSmall.getSymbol());
		waveFloorPlaneSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-02-01-01"), waveFloorPlaneSmall.getSymbol());

		waveFloorPlaneSmallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-02-02-08"), waveFloorPlaneSmallEmptyArrowhead.getSymbol());
		waveFloorPlaneSmallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-02-02-07"), waveFloorPlaneSmallEmptyArrowhead.getSymbol());
		waveFloorPlaneSmallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-02-02-06"), waveFloorPlaneSmallEmptyArrowhead.getSymbol());
		waveFloorPlaneSmallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-02-02-05"), waveFloorPlaneSmallEmptyArrowhead.getSymbol());
		waveFloorPlaneSmallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-02-02-04"), waveFloorPlaneSmallEmptyArrowhead.getSymbol());
		waveFloorPlaneSmallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-02-02-03"), waveFloorPlaneSmallEmptyArrowhead.getSymbol());
		waveFloorPlaneSmallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-02-02-02"), waveFloorPlaneSmallEmptyArrowhead.getSymbol());
		waveFloorPlaneSmallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-02-02-01"), waveFloorPlaneSmallEmptyArrowhead.getSymbol());

		waveFloorPlaneSmallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-02-03-08"), waveFloorPlaneSmallSchemaArrowhead.getSymbol());
		waveFloorPlaneSmallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-02-03-07"), waveFloorPlaneSmallSchemaArrowhead.getSymbol());
		waveFloorPlaneSmallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-02-03-06"), waveFloorPlaneSmallSchemaArrowhead.getSymbol());
		waveFloorPlaneSmallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-02-03-05"), waveFloorPlaneSmallSchemaArrowhead.getSymbol());
		waveFloorPlaneSmallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-02-03-04"), waveFloorPlaneSmallSchemaArrowhead.getSymbol());
		waveFloorPlaneSmallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-02-03-03"), waveFloorPlaneSmallSchemaArrowhead.getSymbol());
		waveFloorPlaneSmallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-02-03-02"), waveFloorPlaneSmallSchemaArrowhead.getSymbol());
		waveFloorPlaneSmallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-02-03-01"), waveFloorPlaneSmallSchemaArrowhead.getSymbol());

		waveFloorPlaneSmallMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-02-01-10"), waveFloorPlaneSmallMirrored.getSymbol());
		waveFloorPlaneSmallMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-02-01-11"), waveFloorPlaneSmallMirrored.getSymbol());
		waveFloorPlaneSmallMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-02-01-12"), waveFloorPlaneSmallMirrored.getSymbol());
		waveFloorPlaneSmallMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-02-01-13"), waveFloorPlaneSmallMirrored.getSymbol());
		waveFloorPlaneSmallMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-02-01-14"), waveFloorPlaneSmallMirrored.getSymbol());
		waveFloorPlaneSmallMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-02-01-15"), waveFloorPlaneSmallMirrored.getSymbol());
		waveFloorPlaneSmallMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-02-01-16"), waveFloorPlaneSmallMirrored.getSymbol());
		waveFloorPlaneSmallMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-02-01-09"), waveFloorPlaneSmallMirrored.getSymbol());

		waveFloorPlaneSmallEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-02-02-10"),
				waveFloorPlaneSmallEmptyArrowheadMirrored.getSymbol());
		waveFloorPlaneSmallEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-02-02-11"),
				waveFloorPlaneSmallEmptyArrowheadMirrored.getSymbol());
		waveFloorPlaneSmallEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-02-02-12"),
				waveFloorPlaneSmallEmptyArrowheadMirrored.getSymbol());
		waveFloorPlaneSmallEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-02-02-13"),
				waveFloorPlaneSmallEmptyArrowheadMirrored.getSymbol());
		waveFloorPlaneSmallEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-02-02-14"),
				waveFloorPlaneSmallEmptyArrowheadMirrored.getSymbol());
		waveFloorPlaneSmallEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-02-02-15"),
				waveFloorPlaneSmallEmptyArrowheadMirrored.getSymbol());
		waveFloorPlaneSmallEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-02-02-16"),
				waveFloorPlaneSmallEmptyArrowheadMirrored.getSymbol());
		waveFloorPlaneSmallEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-02-02-09"),
				waveFloorPlaneSmallEmptyArrowheadMirrored.getSymbol());

		waveFloorPlaneSmallSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-02-03-10"),
				waveFloorPlaneSmallSchemaArrowheadMirrored.getSymbol());
		waveFloorPlaneSmallSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-02-03-11"),
				waveFloorPlaneSmallSchemaArrowheadMirrored.getSymbol());
		waveFloorPlaneSmallSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-02-03-12"),
				waveFloorPlaneSmallSchemaArrowheadMirrored.getSymbol());
		waveFloorPlaneSmallSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-02-03-13"),
				waveFloorPlaneSmallSchemaArrowheadMirrored.getSymbol());
		waveFloorPlaneSmallSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-02-03-14"),
				waveFloorPlaneSmallSchemaArrowheadMirrored.getSymbol());
		waveFloorPlaneSmallSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-02-03-15"),
				waveFloorPlaneSmallSchemaArrowheadMirrored.getSymbol());
		waveFloorPlaneSmallSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-02-03-16"),
				waveFloorPlaneSmallSchemaArrowheadMirrored.getSymbol());
		waveFloorPlaneSmallSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-02-03-09"),
				waveFloorPlaneSmallSchemaArrowheadMirrored.getSymbol());

		waveFloorPlaneLarge.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-03-01-08"), waveFloorPlaneLarge.getSymbol());
		waveFloorPlaneLarge.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-03-01-07"), waveFloorPlaneLarge.getSymbol());
		waveFloorPlaneLarge.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-03-01-06"), waveFloorPlaneLarge.getSymbol());
		waveFloorPlaneLarge.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-03-01-05"), waveFloorPlaneLarge.getSymbol());
		waveFloorPlaneLarge.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-03-01-04"), waveFloorPlaneLarge.getSymbol());
		waveFloorPlaneLarge.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-03-01-03"), waveFloorPlaneLarge.getSymbol());
		waveFloorPlaneLarge.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-03-01-02"), waveFloorPlaneLarge.getSymbol());
		waveFloorPlaneLarge.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-03-01-01"), waveFloorPlaneLarge.getSymbol());

		waveFloorPlaneLargeEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-03-02-08"), waveFloorPlaneLargeEmptyArrowhead.getSymbol());
		waveFloorPlaneLargeEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-03-02-07"), waveFloorPlaneLargeEmptyArrowhead.getSymbol());
		waveFloorPlaneLargeEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-03-02-06"), waveFloorPlaneLargeEmptyArrowhead.getSymbol());
		waveFloorPlaneLargeEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-03-02-05"), waveFloorPlaneLargeEmptyArrowhead.getSymbol());
		waveFloorPlaneLargeEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-03-02-04"), waveFloorPlaneLargeEmptyArrowhead.getSymbol());
		waveFloorPlaneLargeEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-03-02-03"), waveFloorPlaneLargeEmptyArrowhead.getSymbol());
		waveFloorPlaneLargeEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-03-02-02"), waveFloorPlaneLargeEmptyArrowhead.getSymbol());
		waveFloorPlaneLargeEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-03-02-01"), waveFloorPlaneLargeEmptyArrowhead.getSymbol());

		waveFloorPlaneLargeSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-03-03-08"), waveFloorPlaneLargeSchemaArrowhead.getSymbol());
		waveFloorPlaneLargeSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-03-03-07"), waveFloorPlaneLargeSchemaArrowhead.getSymbol());
		waveFloorPlaneLargeSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-03-03-06"), waveFloorPlaneLargeSchemaArrowhead.getSymbol());
		waveFloorPlaneLargeSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-03-03-05"), waveFloorPlaneLargeSchemaArrowhead.getSymbol());
		waveFloorPlaneLargeSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-03-03-04"), waveFloorPlaneLargeSchemaArrowhead.getSymbol());
		waveFloorPlaneLargeSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-03-03-03"), waveFloorPlaneLargeSchemaArrowhead.getSymbol());
		waveFloorPlaneLargeSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-03-03-02"), waveFloorPlaneLargeSchemaArrowhead.getSymbol());
		waveFloorPlaneLargeSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-03-03-01"), waveFloorPlaneLargeSchemaArrowhead.getSymbol());

		waveFloorPlaneLargeMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-03-01-10"), waveFloorPlaneLargeMirrored.getSymbol());
		waveFloorPlaneLargeMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-03-01-11"), waveFloorPlaneLargeMirrored.getSymbol());
		waveFloorPlaneLargeMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-03-01-12"), waveFloorPlaneLargeMirrored.getSymbol());
		waveFloorPlaneLargeMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-03-01-13"), waveFloorPlaneLargeMirrored.getSymbol());
		waveFloorPlaneLargeMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-03-01-14"), waveFloorPlaneLargeMirrored.getSymbol());
		waveFloorPlaneLargeMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-03-01-15"), waveFloorPlaneLargeMirrored.getSymbol());
		waveFloorPlaneLargeMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-03-01-16"), waveFloorPlaneLargeMirrored.getSymbol());
		waveFloorPlaneLargeMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-03-01-09"), waveFloorPlaneLargeMirrored.getSymbol());

		waveFloorPlaneLargeEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-03-02-10"),
				waveFloorPlaneLargeEmptyArrowheadMirrored.getSymbol());
		waveFloorPlaneLargeEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-03-02-11"),
				waveFloorPlaneLargeEmptyArrowheadMirrored.getSymbol());
		waveFloorPlaneLargeEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-03-02-12"),
				waveFloorPlaneLargeEmptyArrowheadMirrored.getSymbol());
		waveFloorPlaneLargeEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-03-02-13"),
				waveFloorPlaneLargeEmptyArrowheadMirrored.getSymbol());
		waveFloorPlaneLargeEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-03-02-14"),
				waveFloorPlaneLargeEmptyArrowheadMirrored.getSymbol());
		waveFloorPlaneLargeEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-03-02-15"),
				waveFloorPlaneLargeEmptyArrowheadMirrored.getSymbol());
		waveFloorPlaneLargeEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-03-02-16"),
				waveFloorPlaneLargeEmptyArrowheadMirrored.getSymbol());
		waveFloorPlaneLargeEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-03-02-09"),
				waveFloorPlaneLargeEmptyArrowheadMirrored.getSymbol());

		waveFloorPlaneLargeSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-03-03-10"),
				waveFloorPlaneLargeSchemaArrowheadMirrored.getSymbol());
		waveFloorPlaneLargeSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-03-03-11"),
				waveFloorPlaneLargeSchemaArrowheadMirrored.getSymbol());
		waveFloorPlaneLargeSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-03-03-12"),
				waveFloorPlaneLargeSchemaArrowheadMirrored.getSymbol());
		waveFloorPlaneLargeSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-03-03-13"),
				waveFloorPlaneLargeSchemaArrowheadMirrored.getSymbol());
		waveFloorPlaneLargeSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-03-03-14"),
				waveFloorPlaneLargeSchemaArrowheadMirrored.getSymbol());
		waveFloorPlaneLargeSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-03-03-15"),
				waveFloorPlaneLargeSchemaArrowheadMirrored.getSymbol());
		waveFloorPlaneLargeSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-03-03-16"),
				waveFloorPlaneLargeSchemaArrowheadMirrored.getSymbol());
		waveFloorPlaneLargeSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-03-03-09"),
				waveFloorPlaneLargeSchemaArrowheadMirrored.getSymbol());

		rotationSingleFloorPlane.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-005-01-01-08"), rotationSingleFloorPlane.getSymbol());
		rotationSingleFloorPlane.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-005-01-01-07"), rotationSingleFloorPlane.getSymbol());
		rotationSingleFloorPlane.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-005-01-01-06"), rotationSingleFloorPlane.getSymbol());
		rotationSingleFloorPlane.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-005-01-01-05"), rotationSingleFloorPlane.getSymbol());
		rotationSingleFloorPlane.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-005-01-01-04"), rotationSingleFloorPlane.getSymbol());
		rotationSingleFloorPlane.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-005-01-01-03"), rotationSingleFloorPlane.getSymbol());
		rotationSingleFloorPlane.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-005-01-01-02"), rotationSingleFloorPlane.getSymbol());
		rotationSingleFloorPlane.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-005-01-01-01"), rotationSingleFloorPlane.getSymbol());

		rotationSingleFloorPlaneEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-005-01-02-08"),
				rotationSingleFloorPlaneEmptyArrowhead.getSymbol());
		rotationSingleFloorPlaneEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-005-01-02-07"),
				rotationSingleFloorPlaneEmptyArrowhead.getSymbol());
		rotationSingleFloorPlaneEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-005-01-02-06"),
				rotationSingleFloorPlaneEmptyArrowhead.getSymbol());
		rotationSingleFloorPlaneEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-005-01-02-05"),
				rotationSingleFloorPlaneEmptyArrowhead.getSymbol());
		rotationSingleFloorPlaneEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-005-01-02-04"),
				rotationSingleFloorPlaneEmptyArrowhead.getSymbol());
		rotationSingleFloorPlaneEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-005-01-02-03"),
				rotationSingleFloorPlaneEmptyArrowhead.getSymbol());
		rotationSingleFloorPlaneEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-005-01-02-02"),
				rotationSingleFloorPlaneEmptyArrowhead.getSymbol());
		rotationSingleFloorPlaneEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-005-01-02-01"),
				rotationSingleFloorPlaneEmptyArrowhead.getSymbol());

		rotationSingleFloorPlaneSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-005-01-03-08"),
				rotationSingleFloorPlaneSchemaArrowhead.getSymbol());
		rotationSingleFloorPlaneSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-005-01-03-07"),
				rotationSingleFloorPlaneSchemaArrowhead.getSymbol());
		rotationSingleFloorPlaneSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-005-01-03-06"),
				rotationSingleFloorPlaneSchemaArrowhead.getSymbol());
		rotationSingleFloorPlaneSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-005-01-03-05"),
				rotationSingleFloorPlaneSchemaArrowhead.getSymbol());
		rotationSingleFloorPlaneSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-005-01-03-04"),
				rotationSingleFloorPlaneSchemaArrowhead.getSymbol());
		rotationSingleFloorPlaneSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-005-01-03-03"),
				rotationSingleFloorPlaneSchemaArrowhead.getSymbol());
		rotationSingleFloorPlaneSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-005-01-03-02"),
				rotationSingleFloorPlaneSchemaArrowhead.getSymbol());
		rotationSingleFloorPlaneSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-005-01-03-01"),
				rotationSingleFloorPlaneSchemaArrowhead.getSymbol());

		rotationSingleFloorPlaneMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-005-01-01-10"), rotationSingleFloorPlaneMirrored.getSymbol());
		rotationSingleFloorPlaneMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-005-01-01-11"), rotationSingleFloorPlaneMirrored.getSymbol());
		rotationSingleFloorPlaneMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-005-01-01-12"), rotationSingleFloorPlaneMirrored.getSymbol());
		rotationSingleFloorPlaneMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-005-01-01-13"), rotationSingleFloorPlaneMirrored.getSymbol());
		rotationSingleFloorPlaneMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-005-01-01-14"), rotationSingleFloorPlaneMirrored.getSymbol());
		rotationSingleFloorPlaneMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-005-01-01-15"), rotationSingleFloorPlaneMirrored.getSymbol());
		rotationSingleFloorPlaneMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-005-01-01-16"), rotationSingleFloorPlaneMirrored.getSymbol());
		rotationSingleFloorPlaneMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-005-01-01-09"), rotationSingleFloorPlaneMirrored.getSymbol());

		rotationSingleFloorPlaneEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-005-01-02-10"),
				rotationSingleFloorPlaneEmptyArrowheadMirrored.getSymbol());
		rotationSingleFloorPlaneEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-005-01-02-11"),
				rotationSingleFloorPlaneEmptyArrowheadMirrored.getSymbol());
		rotationSingleFloorPlaneEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-005-01-02-12"),
				rotationSingleFloorPlaneEmptyArrowheadMirrored.getSymbol());
		rotationSingleFloorPlaneEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-005-01-02-13"),
				rotationSingleFloorPlaneEmptyArrowheadMirrored.getSymbol());
		rotationSingleFloorPlaneEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-005-01-02-14"),
				rotationSingleFloorPlaneEmptyArrowheadMirrored.getSymbol());
		rotationSingleFloorPlaneEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-005-01-02-15"),
				rotationSingleFloorPlaneEmptyArrowheadMirrored.getSymbol());
		rotationSingleFloorPlaneEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-005-01-02-16"),
				rotationSingleFloorPlaneEmptyArrowheadMirrored.getSymbol());
		rotationSingleFloorPlaneEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-005-01-02-09"),
				rotationSingleFloorPlaneEmptyArrowheadMirrored.getSymbol());

		rotationSingleFloorPlaneSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-005-01-03-10"),
				rotationSingleFloorPlaneSchemaArrowheadMirrored.getSymbol());
		rotationSingleFloorPlaneSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-005-01-03-11"),
				rotationSingleFloorPlaneSchemaArrowheadMirrored.getSymbol());
		rotationSingleFloorPlaneSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-005-01-03-12"),
				rotationSingleFloorPlaneSchemaArrowheadMirrored.getSymbol());
		rotationSingleFloorPlaneSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-005-01-03-13"),
				rotationSingleFloorPlaneSchemaArrowheadMirrored.getSymbol());
		rotationSingleFloorPlaneSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-005-01-03-14"),
				rotationSingleFloorPlaneSchemaArrowheadMirrored.getSymbol());
		rotationSingleFloorPlaneSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-005-01-03-15"),
				rotationSingleFloorPlaneSchemaArrowheadMirrored.getSymbol());
		rotationSingleFloorPlaneSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-005-01-03-16"),
				rotationSingleFloorPlaneSchemaArrowheadMirrored.getSymbol());
		rotationSingleFloorPlaneSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-005-01-03-09"),
				rotationSingleFloorPlaneSchemaArrowheadMirrored.getSymbol());

		rotationDoubleFloorPlane.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-006-01-01-08"), rotationDoubleFloorPlane.getSymbol());
		rotationDoubleFloorPlane.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-006-01-01-07"), rotationDoubleFloorPlane.getSymbol());
		rotationDoubleFloorPlane.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-006-01-01-06"), rotationDoubleFloorPlane.getSymbol());
		rotationDoubleFloorPlane.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-006-01-01-05"), rotationDoubleFloorPlane.getSymbol());
		rotationDoubleFloorPlane.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-006-01-01-04"), rotationDoubleFloorPlane.getSymbol());
		rotationDoubleFloorPlane.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-006-01-01-03"), rotationDoubleFloorPlane.getSymbol());
		rotationDoubleFloorPlane.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-006-01-01-02"), rotationDoubleFloorPlane.getSymbol());
		rotationDoubleFloorPlane.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-006-01-01-01"), rotationDoubleFloorPlane.getSymbol());

		rotationDoubleFloorPlaneEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-006-01-02-08"),
				rotationDoubleFloorPlaneEmptyArrowhead.getSymbol());
		rotationDoubleFloorPlaneEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-006-01-02-07"),
				rotationDoubleFloorPlaneEmptyArrowhead.getSymbol());
		rotationDoubleFloorPlaneEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-006-01-02-06"),
				rotationDoubleFloorPlaneEmptyArrowhead.getSymbol());
		rotationDoubleFloorPlaneEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-006-01-02-05"),
				rotationDoubleFloorPlaneEmptyArrowhead.getSymbol());
		rotationDoubleFloorPlaneEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-006-01-02-04"),
				rotationDoubleFloorPlaneEmptyArrowhead.getSymbol());
		rotationDoubleFloorPlaneEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-006-01-02-03"),
				rotationDoubleFloorPlaneEmptyArrowhead.getSymbol());
		rotationDoubleFloorPlaneEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-006-01-02-02"),
				rotationDoubleFloorPlaneEmptyArrowhead.getSymbol());
		rotationDoubleFloorPlaneEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-006-01-02-01"),
				rotationDoubleFloorPlaneEmptyArrowhead.getSymbol());

		rotationDoubleFloorPlaneSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-006-01-03-08"),
				rotationDoubleFloorPlaneSchemaArrowhead.getSymbol());
		rotationDoubleFloorPlaneSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-006-01-03-07"),
				rotationDoubleFloorPlaneSchemaArrowhead.getSymbol());
		rotationDoubleFloorPlaneSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-006-01-03-06"),
				rotationDoubleFloorPlaneSchemaArrowhead.getSymbol());
		rotationDoubleFloorPlaneSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-006-01-03-05"),
				rotationDoubleFloorPlaneSchemaArrowhead.getSymbol());
		rotationDoubleFloorPlaneSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-006-01-03-04"),
				rotationDoubleFloorPlaneSchemaArrowhead.getSymbol());
		rotationDoubleFloorPlaneSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-006-01-03-03"),
				rotationDoubleFloorPlaneSchemaArrowhead.getSymbol());
		rotationDoubleFloorPlaneSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-006-01-03-02"),
				rotationDoubleFloorPlaneSchemaArrowhead.getSymbol());
		rotationDoubleFloorPlaneSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-006-01-03-01"),
				rotationDoubleFloorPlaneSchemaArrowhead.getSymbol());

		rotationDoubleFloorPlaneMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-006-01-01-10"), rotationDoubleFloorPlaneMirrored.getSymbol());
		rotationDoubleFloorPlaneMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-006-01-01-11"), rotationDoubleFloorPlaneMirrored.getSymbol());
		rotationDoubleFloorPlaneMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-006-01-01-12"), rotationDoubleFloorPlaneMirrored.getSymbol());
		rotationDoubleFloorPlaneMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-006-01-01-13"), rotationDoubleFloorPlaneMirrored.getSymbol());
		rotationDoubleFloorPlaneMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-006-01-01-14"), rotationDoubleFloorPlaneMirrored.getSymbol());
		rotationDoubleFloorPlaneMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-006-01-01-15"), rotationDoubleFloorPlaneMirrored.getSymbol());
		rotationDoubleFloorPlaneMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-006-01-01-16"), rotationDoubleFloorPlaneMirrored.getSymbol());
		rotationDoubleFloorPlaneMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-006-01-01-09"), rotationDoubleFloorPlaneMirrored.getSymbol());

		rotationDoubleFloorPlaneEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-006-01-02-10"),
				rotationDoubleFloorPlaneEmptyArrowheadMirrored.getSymbol());
		rotationDoubleFloorPlaneEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-006-01-02-11"),
				rotationDoubleFloorPlaneEmptyArrowheadMirrored.getSymbol());
		rotationDoubleFloorPlaneEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-006-01-02-12"),
				rotationDoubleFloorPlaneEmptyArrowheadMirrored.getSymbol());
		rotationDoubleFloorPlaneEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-006-01-02-13"),
				rotationDoubleFloorPlaneEmptyArrowheadMirrored.getSymbol());
		rotationDoubleFloorPlaneEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-006-01-02-14"),
				rotationDoubleFloorPlaneEmptyArrowheadMirrored.getSymbol());
		rotationDoubleFloorPlaneEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-006-01-02-15"),
				rotationDoubleFloorPlaneEmptyArrowheadMirrored.getSymbol());
		rotationDoubleFloorPlaneEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-006-01-02-16"),
				rotationDoubleFloorPlaneEmptyArrowheadMirrored.getSymbol());
		rotationDoubleFloorPlaneEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-006-01-02-09"),
				rotationDoubleFloorPlaneEmptyArrowheadMirrored.getSymbol());

		rotationDoubleFloorPlaneSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-006-01-03-10"),
				rotationDoubleFloorPlaneSchemaArrowheadMirrored.getSymbol());
		rotationDoubleFloorPlaneSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-006-01-03-11"),
				rotationDoubleFloorPlaneSchemaArrowheadMirrored.getSymbol());
		rotationDoubleFloorPlaneSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-006-01-03-12"),
				rotationDoubleFloorPlaneSchemaArrowheadMirrored.getSymbol());
		rotationDoubleFloorPlaneSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-006-01-03-13"),
				rotationDoubleFloorPlaneSchemaArrowheadMirrored.getSymbol());
		rotationDoubleFloorPlaneSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-006-01-03-14"),
				rotationDoubleFloorPlaneSchemaArrowheadMirrored.getSymbol());
		rotationDoubleFloorPlaneSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-006-01-03-15"),
				rotationDoubleFloorPlaneSchemaArrowheadMirrored.getSymbol());
		rotationDoubleFloorPlaneSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-006-01-03-16"),
				rotationDoubleFloorPlaneSchemaArrowheadMirrored.getSymbol());
		rotationDoubleFloorPlaneSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-006-01-03-09"),
				rotationDoubleFloorPlaneSchemaArrowheadMirrored.getSymbol());

		rotationAlternatingFloorPlane.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-007-01-01-08"), rotationAlternatingFloorPlane.getSymbol());
		rotationAlternatingFloorPlane.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-007-01-01-07"), rotationAlternatingFloorPlane.getSymbol());
		rotationAlternatingFloorPlane.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-007-01-01-06"), rotationAlternatingFloorPlane.getSymbol());
		rotationAlternatingFloorPlane.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-007-01-01-05"), rotationAlternatingFloorPlane.getSymbol());
		rotationAlternatingFloorPlane.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-007-01-01-04"), rotationAlternatingFloorPlane.getSymbol());
		rotationAlternatingFloorPlane.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-007-01-01-03"), rotationAlternatingFloorPlane.getSymbol());
		rotationAlternatingFloorPlane.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-007-01-01-02"), rotationAlternatingFloorPlane.getSymbol());
		rotationAlternatingFloorPlane.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-007-01-01-01"), rotationAlternatingFloorPlane.getSymbol());

		rotationAlternatingFloorPlaneEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-007-01-02-08"),
				rotationAlternatingFloorPlaneEmptyArrowhead.getSymbol());
		rotationAlternatingFloorPlaneEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-007-01-02-07"),
				rotationAlternatingFloorPlaneEmptyArrowhead.getSymbol());
		rotationAlternatingFloorPlaneEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-007-01-02-06"),
				rotationAlternatingFloorPlaneEmptyArrowhead.getSymbol());
		rotationAlternatingFloorPlaneEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-007-01-02-05"),
				rotationAlternatingFloorPlaneEmptyArrowhead.getSymbol());
		rotationAlternatingFloorPlaneEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-007-01-02-04"),
				rotationAlternatingFloorPlaneEmptyArrowhead.getSymbol());
		rotationAlternatingFloorPlaneEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-007-01-02-03"),
				rotationAlternatingFloorPlaneEmptyArrowhead.getSymbol());
		rotationAlternatingFloorPlaneEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-007-01-02-02"),
				rotationAlternatingFloorPlaneEmptyArrowhead.getSymbol());
		rotationAlternatingFloorPlaneEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-007-01-02-01"),
				rotationAlternatingFloorPlaneEmptyArrowhead.getSymbol());

		rotationAlternatingFloorPlaneSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-007-01-03-08"),
				rotationAlternatingFloorPlaneSchemaArrowhead.getSymbol());
		rotationAlternatingFloorPlaneSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-007-01-03-07"),
				rotationAlternatingFloorPlaneSchemaArrowhead.getSymbol());
		rotationAlternatingFloorPlaneSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-007-01-03-06"),
				rotationAlternatingFloorPlaneSchemaArrowhead.getSymbol());
		rotationAlternatingFloorPlaneSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-007-01-03-05"),
				rotationAlternatingFloorPlaneSchemaArrowhead.getSymbol());
		rotationAlternatingFloorPlaneSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-007-01-03-04"),
				rotationAlternatingFloorPlaneSchemaArrowhead.getSymbol());
		rotationAlternatingFloorPlaneSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-007-01-03-03"),
				rotationAlternatingFloorPlaneSchemaArrowhead.getSymbol());
		rotationAlternatingFloorPlaneSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-007-01-03-02"),
				rotationAlternatingFloorPlaneSchemaArrowhead.getSymbol());
		rotationAlternatingFloorPlaneSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-007-01-03-01"),
				rotationAlternatingFloorPlaneSchemaArrowhead.getSymbol());

		rotationAlternatingFloorPlaneMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-007-01-01-10"),
				rotationAlternatingFloorPlaneMirrored.getSymbol());
		rotationAlternatingFloorPlaneMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-007-01-01-11"),
				rotationAlternatingFloorPlaneMirrored.getSymbol());
		rotationAlternatingFloorPlaneMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-007-01-01-12"),
				rotationAlternatingFloorPlaneMirrored.getSymbol());
		rotationAlternatingFloorPlaneMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-007-01-01-13"),
				rotationAlternatingFloorPlaneMirrored.getSymbol());
		rotationAlternatingFloorPlaneMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-007-01-01-14"),
				rotationAlternatingFloorPlaneMirrored.getSymbol());
		rotationAlternatingFloorPlaneMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-007-01-01-15"),
				rotationAlternatingFloorPlaneMirrored.getSymbol());
		rotationAlternatingFloorPlaneMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-007-01-01-16"),
				rotationAlternatingFloorPlaneMirrored.getSymbol());
		rotationAlternatingFloorPlaneMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-007-01-01-09"),
				rotationAlternatingFloorPlaneMirrored.getSymbol());

		rotationAlternatingFloorPlaneEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-007-01-02-10"),
				rotationAlternatingFloorPlaneEmptyArrowheadMirrored.getSymbol());
		rotationAlternatingFloorPlaneEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-007-01-02-11"),
				rotationAlternatingFloorPlaneEmptyArrowheadMirrored.getSymbol());
		rotationAlternatingFloorPlaneEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-007-01-02-12"),
				rotationAlternatingFloorPlaneEmptyArrowheadMirrored.getSymbol());
		rotationAlternatingFloorPlaneEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-007-01-02-13"),
				rotationAlternatingFloorPlaneEmptyArrowheadMirrored.getSymbol());
		rotationAlternatingFloorPlaneEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-007-01-02-14"),
				rotationAlternatingFloorPlaneEmptyArrowheadMirrored.getSymbol());
		rotationAlternatingFloorPlaneEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-007-01-02-15"),
				rotationAlternatingFloorPlaneEmptyArrowheadMirrored.getSymbol());
		rotationAlternatingFloorPlaneEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-007-01-02-16"),
				rotationAlternatingFloorPlaneEmptyArrowheadMirrored.getSymbol());
		rotationAlternatingFloorPlaneEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-007-01-02-09"),
				rotationAlternatingFloorPlaneEmptyArrowheadMirrored.getSymbol());

		rotationAlternatingFloorPlaneSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-007-01-03-10"),
				rotationAlternatingFloorPlaneSchemaArrowheadMirrored.getSymbol());
		rotationAlternatingFloorPlaneSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-007-01-03-11"),
				rotationAlternatingFloorPlaneSchemaArrowheadMirrored.getSymbol());
		rotationAlternatingFloorPlaneSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-007-01-03-12"),
				rotationAlternatingFloorPlaneSchemaArrowheadMirrored.getSymbol());
		rotationAlternatingFloorPlaneSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-007-01-03-13"),
				rotationAlternatingFloorPlaneSchemaArrowheadMirrored.getSymbol());
		rotationAlternatingFloorPlaneSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-007-01-03-14"),
				rotationAlternatingFloorPlaneSchemaArrowheadMirrored.getSymbol());
		rotationAlternatingFloorPlaneSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-007-01-03-15"),
				rotationAlternatingFloorPlaneSchemaArrowheadMirrored.getSymbol());
		rotationAlternatingFloorPlaneSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-007-01-03-16"),
				rotationAlternatingFloorPlaneSchemaArrowheadMirrored.getSymbol());
		rotationAlternatingFloorPlaneSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-007-01-03-09"),
				rotationAlternatingFloorPlaneSchemaArrowheadMirrored.getSymbol());

		shakingParallelFloor.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-008-01-01-08"), shakingParallelFloor.getSymbol());
		shakingParallelFloor.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-008-01-01-07"), shakingParallelFloor.getSymbol());
		shakingParallelFloor.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-008-01-01-06"), shakingParallelFloor.getSymbol());
		shakingParallelFloor.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-008-01-01-05"), shakingParallelFloor.getSymbol());
		shakingParallelFloor.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-008-01-01-04"), shakingParallelFloor.getSymbol());
		shakingParallelFloor.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-008-01-01-03"), shakingParallelFloor.getSymbol());
		shakingParallelFloor.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-008-01-01-02"), shakingParallelFloor.getSymbol());
		shakingParallelFloor.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-008-01-01-01"), shakingParallelFloor.getSymbol());

		shakingParallelFloorEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-008-01-02-08"), shakingParallelFloorEmptyArrowhead.getSymbol());
		shakingParallelFloorEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-008-01-02-07"), shakingParallelFloorEmptyArrowhead.getSymbol());
		shakingParallelFloorEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-008-01-02-06"), shakingParallelFloorEmptyArrowhead.getSymbol());
		shakingParallelFloorEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-008-01-02-05"), shakingParallelFloorEmptyArrowhead.getSymbol());
		shakingParallelFloorEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-008-01-02-04"), shakingParallelFloorEmptyArrowhead.getSymbol());
		shakingParallelFloorEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-008-01-02-03"), shakingParallelFloorEmptyArrowhead.getSymbol());
		shakingParallelFloorEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-008-01-02-02"), shakingParallelFloorEmptyArrowhead.getSymbol());
		shakingParallelFloorEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-008-01-02-01"), shakingParallelFloorEmptyArrowhead.getSymbol());

		shakingParallelFloorSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-008-01-03-08"), shakingParallelFloorSchemaArrowhead.getSymbol());
		shakingParallelFloorSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-008-01-03-07"), shakingParallelFloorSchemaArrowhead.getSymbol());
		shakingParallelFloorSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-008-01-03-06"), shakingParallelFloorSchemaArrowhead.getSymbol());
		shakingParallelFloorSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-008-01-03-05"), shakingParallelFloorSchemaArrowhead.getSymbol());
		shakingParallelFloorSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-008-01-03-04"), shakingParallelFloorSchemaArrowhead.getSymbol());
		shakingParallelFloorSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-008-01-03-03"), shakingParallelFloorSchemaArrowhead.getSymbol());
		shakingParallelFloorSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-008-01-03-02"), shakingParallelFloorSchemaArrowhead.getSymbol());
		shakingParallelFloorSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-008-01-03-01"), shakingParallelFloorSchemaArrowhead.getSymbol());

		shakingParallelFloorMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-008-01-01-10"), shakingParallelFloorMirrored.getSymbol());
		shakingParallelFloorMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-008-01-01-11"), shakingParallelFloorMirrored.getSymbol());
		shakingParallelFloorMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-008-01-01-12"), shakingParallelFloorMirrored.getSymbol());
		shakingParallelFloorMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-008-01-01-13"), shakingParallelFloorMirrored.getSymbol());
		shakingParallelFloorMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-008-01-01-14"), shakingParallelFloorMirrored.getSymbol());
		shakingParallelFloorMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-008-01-01-15"), shakingParallelFloorMirrored.getSymbol());
		shakingParallelFloorMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-008-01-01-16"), shakingParallelFloorMirrored.getSymbol());
		shakingParallelFloorMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-008-01-01-09"), shakingParallelFloorMirrored.getSymbol());

		shakingParallelFloorEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-008-01-02-10"),
				shakingParallelFloorEmptyArrowheadMirrored.getSymbol());
		shakingParallelFloorEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-008-01-02-11"),
				shakingParallelFloorEmptyArrowheadMirrored.getSymbol());
		shakingParallelFloorEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-008-01-02-12"),
				shakingParallelFloorEmptyArrowheadMirrored.getSymbol());
		shakingParallelFloorEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-008-01-02-13"),
				shakingParallelFloorEmptyArrowheadMirrored.getSymbol());
		shakingParallelFloorEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-008-01-02-14"),
				shakingParallelFloorEmptyArrowheadMirrored.getSymbol());
		shakingParallelFloorEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-008-01-02-15"),
				shakingParallelFloorEmptyArrowheadMirrored.getSymbol());
		shakingParallelFloorEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-008-01-02-16"),
				shakingParallelFloorEmptyArrowheadMirrored.getSymbol());
		shakingParallelFloorEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-008-01-02-09"),
				shakingParallelFloorEmptyArrowheadMirrored.getSymbol());

		shakingParallelFloorSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-008-01-03-10"),
				shakingParallelFloorSchemaArrowheadMirrored.getSymbol());
		shakingParallelFloorSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-008-01-03-11"),
				shakingParallelFloorSchemaArrowheadMirrored.getSymbol());
		shakingParallelFloorSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-008-01-03-12"),
				shakingParallelFloorSchemaArrowheadMirrored.getSymbol());
		shakingParallelFloorSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-008-01-03-13"),
				shakingParallelFloorSchemaArrowheadMirrored.getSymbol());
		shakingParallelFloorSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-008-01-03-14"),
				shakingParallelFloorSchemaArrowheadMirrored.getSymbol());
		shakingParallelFloorSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-008-01-03-15"),
				shakingParallelFloorSchemaArrowheadMirrored.getSymbol());
		shakingParallelFloorSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-008-01-03-16"),
				shakingParallelFloorSchemaArrowheadMirrored.getSymbol());
		shakingParallelFloorSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-008-01-03-09"),
				shakingParallelFloorSchemaArrowheadMirrored.getSymbol());

	}

	@Override
	public void testRotateCounterClockwise() {

		curveFloorPlaneSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-01-01-02"), curveFloorPlaneSmall.getSymbol());
		curveFloorPlaneSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-01-01-03"), curveFloorPlaneSmall.getSymbol());
		curveFloorPlaneSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-01-01-04"), curveFloorPlaneSmall.getSymbol());
		curveFloorPlaneSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-01-01-05"), curveFloorPlaneSmall.getSymbol());
		curveFloorPlaneSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-01-01-06"), curveFloorPlaneSmall.getSymbol());
		curveFloorPlaneSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-01-01-07"), curveFloorPlaneSmall.getSymbol());
		curveFloorPlaneSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-01-01-08"), curveFloorPlaneSmall.getSymbol());
		curveFloorPlaneSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-01-01-01"), curveFloorPlaneSmall.getSymbol());

		curveFloorPlaneSmallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-01-02-02"), curveFloorPlaneSmallEmptyArrowhead.getSymbol());
		curveFloorPlaneSmallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-01-02-03"), curveFloorPlaneSmallEmptyArrowhead.getSymbol());
		curveFloorPlaneSmallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-01-02-04"), curveFloorPlaneSmallEmptyArrowhead.getSymbol());
		curveFloorPlaneSmallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-01-02-05"), curveFloorPlaneSmallEmptyArrowhead.getSymbol());
		curveFloorPlaneSmallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-01-02-06"), curveFloorPlaneSmallEmptyArrowhead.getSymbol());
		curveFloorPlaneSmallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-01-02-07"), curveFloorPlaneSmallEmptyArrowhead.getSymbol());
		curveFloorPlaneSmallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-01-02-08"), curveFloorPlaneSmallEmptyArrowhead.getSymbol());
		curveFloorPlaneSmallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-01-02-01"), curveFloorPlaneSmallEmptyArrowhead.getSymbol());

		curveFloorPlaneSmallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-01-03-02"), curveFloorPlaneSmallSchemaArrowhead.getSymbol());
		curveFloorPlaneSmallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-01-03-03"), curveFloorPlaneSmallSchemaArrowhead.getSymbol());
		curveFloorPlaneSmallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-01-03-04"), curveFloorPlaneSmallSchemaArrowhead.getSymbol());
		curveFloorPlaneSmallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-01-03-05"), curveFloorPlaneSmallSchemaArrowhead.getSymbol());
		curveFloorPlaneSmallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-01-03-06"), curveFloorPlaneSmallSchemaArrowhead.getSymbol());
		curveFloorPlaneSmallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-01-03-07"), curveFloorPlaneSmallSchemaArrowhead.getSymbol());
		curveFloorPlaneSmallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-01-03-08"), curveFloorPlaneSmallSchemaArrowhead.getSymbol());
		curveFloorPlaneSmallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-01-03-01"), curveFloorPlaneSmallSchemaArrowhead.getSymbol());

		curveFloorPlaneSmallMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-01-01-16"), curveFloorPlaneSmallMirrored.getSymbol());
		curveFloorPlaneSmallMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-01-01-15"), curveFloorPlaneSmallMirrored.getSymbol());
		curveFloorPlaneSmallMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-01-01-14"), curveFloorPlaneSmallMirrored.getSymbol());
		curveFloorPlaneSmallMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-01-01-13"), curveFloorPlaneSmallMirrored.getSymbol());
		curveFloorPlaneSmallMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-01-01-12"), curveFloorPlaneSmallMirrored.getSymbol());
		curveFloorPlaneSmallMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-01-01-11"), curveFloorPlaneSmallMirrored.getSymbol());
		curveFloorPlaneSmallMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-01-01-10"), curveFloorPlaneSmallMirrored.getSymbol());
		curveFloorPlaneSmallMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-01-01-09"), curveFloorPlaneSmallMirrored.getSymbol());

		curveFloorPlaneSmallEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-01-02-16"),
				curveFloorPlaneSmallEmptyArrowheadMirrored.getSymbol());
		curveFloorPlaneSmallEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-01-02-15"),
				curveFloorPlaneSmallEmptyArrowheadMirrored.getSymbol());
		curveFloorPlaneSmallEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-01-02-14"),
				curveFloorPlaneSmallEmptyArrowheadMirrored.getSymbol());
		curveFloorPlaneSmallEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-01-02-13"),
				curveFloorPlaneSmallEmptyArrowheadMirrored.getSymbol());
		curveFloorPlaneSmallEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-01-02-12"),
				curveFloorPlaneSmallEmptyArrowheadMirrored.getSymbol());
		curveFloorPlaneSmallEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-01-02-11"),
				curveFloorPlaneSmallEmptyArrowheadMirrored.getSymbol());
		curveFloorPlaneSmallEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-01-02-10"),
				curveFloorPlaneSmallEmptyArrowheadMirrored.getSymbol());
		curveFloorPlaneSmallEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-01-02-09"),
				curveFloorPlaneSmallEmptyArrowheadMirrored.getSymbol());

		curveFloorPlaneSmallSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-01-03-16"),
				curveFloorPlaneSmallSchemaArrowheadMirrored.getSymbol());
		curveFloorPlaneSmallSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-01-03-15"),
				curveFloorPlaneSmallSchemaArrowheadMirrored.getSymbol());
		curveFloorPlaneSmallSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-01-03-14"),
				curveFloorPlaneSmallSchemaArrowheadMirrored.getSymbol());
		curveFloorPlaneSmallSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-01-03-13"),
				curveFloorPlaneSmallSchemaArrowheadMirrored.getSymbol());
		curveFloorPlaneSmallSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-01-03-12"),
				curveFloorPlaneSmallSchemaArrowheadMirrored.getSymbol());
		curveFloorPlaneSmallSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-01-03-11"),
				curveFloorPlaneSmallSchemaArrowheadMirrored.getSymbol());
		curveFloorPlaneSmallSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-01-03-10"),
				curveFloorPlaneSmallSchemaArrowheadMirrored.getSymbol());
		curveFloorPlaneSmallSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-01-03-09"),
				curveFloorPlaneSmallSchemaArrowheadMirrored.getSymbol());

		curveFloorPlaneMedium1.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-02-01-02"), curveFloorPlaneMedium1.getSymbol());
		curveFloorPlaneMedium1.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-02-01-03"), curveFloorPlaneMedium1.getSymbol());
		curveFloorPlaneMedium1.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-02-01-04"), curveFloorPlaneMedium1.getSymbol());
		curveFloorPlaneMedium1.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-02-01-05"), curveFloorPlaneMedium1.getSymbol());
		curveFloorPlaneMedium1.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-02-01-06"), curveFloorPlaneMedium1.getSymbol());
		curveFloorPlaneMedium1.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-02-01-07"), curveFloorPlaneMedium1.getSymbol());
		curveFloorPlaneMedium1.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-02-01-08"), curveFloorPlaneMedium1.getSymbol());
		curveFloorPlaneMedium1.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-02-01-01"), curveFloorPlaneMedium1.getSymbol());

		curveFloorPlaneMedium1EmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-02-02-02"),
				curveFloorPlaneMedium1EmptyArrowhead.getSymbol());
		curveFloorPlaneMedium1EmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-02-02-03"),
				curveFloorPlaneMedium1EmptyArrowhead.getSymbol());
		curveFloorPlaneMedium1EmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-02-02-04"),
				curveFloorPlaneMedium1EmptyArrowhead.getSymbol());
		curveFloorPlaneMedium1EmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-02-02-05"),
				curveFloorPlaneMedium1EmptyArrowhead.getSymbol());
		curveFloorPlaneMedium1EmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-02-02-06"),
				curveFloorPlaneMedium1EmptyArrowhead.getSymbol());
		curveFloorPlaneMedium1EmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-02-02-07"),
				curveFloorPlaneMedium1EmptyArrowhead.getSymbol());
		curveFloorPlaneMedium1EmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-02-02-08"),
				curveFloorPlaneMedium1EmptyArrowhead.getSymbol());
		curveFloorPlaneMedium1EmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-02-02-01"),
				curveFloorPlaneMedium1EmptyArrowhead.getSymbol());

		curveFloorPlaneMedium1SchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-02-03-02"),
				curveFloorPlaneMedium1SchemaArrowhead.getSymbol());
		curveFloorPlaneMedium1SchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-02-03-03"),
				curveFloorPlaneMedium1SchemaArrowhead.getSymbol());
		curveFloorPlaneMedium1SchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-02-03-04"),
				curveFloorPlaneMedium1SchemaArrowhead.getSymbol());
		curveFloorPlaneMedium1SchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-02-03-05"),
				curveFloorPlaneMedium1SchemaArrowhead.getSymbol());
		curveFloorPlaneMedium1SchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-02-03-06"),
				curveFloorPlaneMedium1SchemaArrowhead.getSymbol());
		curveFloorPlaneMedium1SchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-02-03-07"),
				curveFloorPlaneMedium1SchemaArrowhead.getSymbol());
		curveFloorPlaneMedium1SchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-02-03-08"),
				curveFloorPlaneMedium1SchemaArrowhead.getSymbol());
		curveFloorPlaneMedium1SchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-02-03-01"),
				curveFloorPlaneMedium1SchemaArrowhead.getSymbol());

		curveFloorPlaneMedium1Mirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-02-01-16"), curveFloorPlaneMedium1Mirrored.getSymbol());
		curveFloorPlaneMedium1Mirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-02-01-15"), curveFloorPlaneMedium1Mirrored.getSymbol());
		curveFloorPlaneMedium1Mirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-02-01-14"), curveFloorPlaneMedium1Mirrored.getSymbol());
		curveFloorPlaneMedium1Mirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-02-01-13"), curveFloorPlaneMedium1Mirrored.getSymbol());
		curveFloorPlaneMedium1Mirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-02-01-12"), curveFloorPlaneMedium1Mirrored.getSymbol());
		curveFloorPlaneMedium1Mirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-02-01-11"), curveFloorPlaneMedium1Mirrored.getSymbol());
		curveFloorPlaneMedium1Mirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-02-01-10"), curveFloorPlaneMedium1Mirrored.getSymbol());
		curveFloorPlaneMedium1Mirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-02-01-09"), curveFloorPlaneMedium1Mirrored.getSymbol());

		curveFloorPlaneMedium1EmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-02-02-16"),
				curveFloorPlaneMedium1EmptyArrowheadMirrored.getSymbol());
		curveFloorPlaneMedium1EmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-02-02-15"),
				curveFloorPlaneMedium1EmptyArrowheadMirrored.getSymbol());
		curveFloorPlaneMedium1EmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-02-02-14"),
				curveFloorPlaneMedium1EmptyArrowheadMirrored.getSymbol());
		curveFloorPlaneMedium1EmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-02-02-13"),
				curveFloorPlaneMedium1EmptyArrowheadMirrored.getSymbol());
		curveFloorPlaneMedium1EmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-02-02-12"),
				curveFloorPlaneMedium1EmptyArrowheadMirrored.getSymbol());
		curveFloorPlaneMedium1EmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-02-02-11"),
				curveFloorPlaneMedium1EmptyArrowheadMirrored.getSymbol());
		curveFloorPlaneMedium1EmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-02-02-10"),
				curveFloorPlaneMedium1EmptyArrowheadMirrored.getSymbol());
		curveFloorPlaneMedium1EmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-02-02-09"),
				curveFloorPlaneMedium1EmptyArrowheadMirrored.getSymbol());

		curveFloorPlaneMedium1SchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-02-03-16"),
				curveFloorPlaneMedium1SchemaArrowheadMirrored.getSymbol());
		curveFloorPlaneMedium1SchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-02-03-15"),
				curveFloorPlaneMedium1SchemaArrowheadMirrored.getSymbol());
		curveFloorPlaneMedium1SchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-02-03-14"),
				curveFloorPlaneMedium1SchemaArrowheadMirrored.getSymbol());
		curveFloorPlaneMedium1SchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-02-03-13"),
				curveFloorPlaneMedium1SchemaArrowheadMirrored.getSymbol());
		curveFloorPlaneMedium1SchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-02-03-12"),
				curveFloorPlaneMedium1SchemaArrowheadMirrored.getSymbol());
		curveFloorPlaneMedium1SchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-02-03-11"),
				curveFloorPlaneMedium1SchemaArrowheadMirrored.getSymbol());
		curveFloorPlaneMedium1SchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-02-03-10"),
				curveFloorPlaneMedium1SchemaArrowheadMirrored.getSymbol());
		curveFloorPlaneMedium1SchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-02-03-09"),
				curveFloorPlaneMedium1SchemaArrowheadMirrored.getSymbol());

		curveFloorPlaneMedium2.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-03-01-02"), curveFloorPlaneMedium2.getSymbol());
		curveFloorPlaneMedium2.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-03-01-03"), curveFloorPlaneMedium2.getSymbol());
		curveFloorPlaneMedium2.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-03-01-04"), curveFloorPlaneMedium2.getSymbol());
		curveFloorPlaneMedium2.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-03-01-05"), curveFloorPlaneMedium2.getSymbol());
		curveFloorPlaneMedium2.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-03-01-06"), curveFloorPlaneMedium2.getSymbol());
		curveFloorPlaneMedium2.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-03-01-07"), curveFloorPlaneMedium2.getSymbol());
		curveFloorPlaneMedium2.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-03-01-08"), curveFloorPlaneMedium2.getSymbol());
		curveFloorPlaneMedium2.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-03-01-01"), curveFloorPlaneMedium2.getSymbol());

		curveFloorPlaneMedium2EmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-03-02-02"),
				curveFloorPlaneMedium2EmptyArrowhead.getSymbol());
		curveFloorPlaneMedium2EmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-03-02-03"),
				curveFloorPlaneMedium2EmptyArrowhead.getSymbol());
		curveFloorPlaneMedium2EmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-03-02-04"),
				curveFloorPlaneMedium2EmptyArrowhead.getSymbol());
		curveFloorPlaneMedium2EmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-03-02-05"),
				curveFloorPlaneMedium2EmptyArrowhead.getSymbol());
		curveFloorPlaneMedium2EmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-03-02-06"),
				curveFloorPlaneMedium2EmptyArrowhead.getSymbol());
		curveFloorPlaneMedium2EmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-03-02-07"),
				curveFloorPlaneMedium2EmptyArrowhead.getSymbol());
		curveFloorPlaneMedium2EmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-03-02-08"),
				curveFloorPlaneMedium2EmptyArrowhead.getSymbol());
		curveFloorPlaneMedium2EmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-03-02-01"),
				curveFloorPlaneMedium2EmptyArrowhead.getSymbol());

		curveFloorPlaneMedium2SchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-03-03-02"),
				curveFloorPlaneMedium2SchemaArrowhead.getSymbol());
		curveFloorPlaneMedium2SchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-03-03-03"),
				curveFloorPlaneMedium2SchemaArrowhead.getSymbol());
		curveFloorPlaneMedium2SchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-03-03-04"),
				curveFloorPlaneMedium2SchemaArrowhead.getSymbol());
		curveFloorPlaneMedium2SchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-03-03-05"),
				curveFloorPlaneMedium2SchemaArrowhead.getSymbol());
		curveFloorPlaneMedium2SchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-03-03-06"),
				curveFloorPlaneMedium2SchemaArrowhead.getSymbol());
		curveFloorPlaneMedium2SchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-03-03-07"),
				curveFloorPlaneMedium2SchemaArrowhead.getSymbol());
		curveFloorPlaneMedium2SchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-03-03-08"),
				curveFloorPlaneMedium2SchemaArrowhead.getSymbol());
		curveFloorPlaneMedium2SchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-03-03-01"),
				curveFloorPlaneMedium2SchemaArrowhead.getSymbol());

		curveFloorPlaneMedium2Mirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-03-01-16"), curveFloorPlaneMedium2Mirrored.getSymbol());
		curveFloorPlaneMedium2Mirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-03-01-15"), curveFloorPlaneMedium2Mirrored.getSymbol());
		curveFloorPlaneMedium2Mirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-03-01-14"), curveFloorPlaneMedium2Mirrored.getSymbol());
		curveFloorPlaneMedium2Mirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-03-01-13"), curveFloorPlaneMedium2Mirrored.getSymbol());
		curveFloorPlaneMedium2Mirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-03-01-12"), curveFloorPlaneMedium2Mirrored.getSymbol());
		curveFloorPlaneMedium2Mirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-03-01-11"), curveFloorPlaneMedium2Mirrored.getSymbol());
		curveFloorPlaneMedium2Mirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-03-01-10"), curveFloorPlaneMedium2Mirrored.getSymbol());
		curveFloorPlaneMedium2Mirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-03-01-09"), curveFloorPlaneMedium2Mirrored.getSymbol());

		curveFloorPlaneMedium2EmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-03-02-16"),
				curveFloorPlaneMedium2EmptyArrowheadMirrored.getSymbol());
		curveFloorPlaneMedium2EmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-03-02-15"),
				curveFloorPlaneMedium2EmptyArrowheadMirrored.getSymbol());
		curveFloorPlaneMedium2EmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-03-02-14"),
				curveFloorPlaneMedium2EmptyArrowheadMirrored.getSymbol());
		curveFloorPlaneMedium2EmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-03-02-13"),
				curveFloorPlaneMedium2EmptyArrowheadMirrored.getSymbol());
		curveFloorPlaneMedium2EmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-03-02-12"),
				curveFloorPlaneMedium2EmptyArrowheadMirrored.getSymbol());
		curveFloorPlaneMedium2EmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-03-02-11"),
				curveFloorPlaneMedium2EmptyArrowheadMirrored.getSymbol());
		curveFloorPlaneMedium2EmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-03-02-10"),
				curveFloorPlaneMedium2EmptyArrowheadMirrored.getSymbol());
		curveFloorPlaneMedium2EmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-03-02-09"),
				curveFloorPlaneMedium2EmptyArrowheadMirrored.getSymbol());

		curveFloorPlaneMedium2SchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-03-03-16"),
				curveFloorPlaneMedium2SchemaArrowheadMirrored.getSymbol());
		curveFloorPlaneMedium2SchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-03-03-15"),
				curveFloorPlaneMedium2SchemaArrowheadMirrored.getSymbol());
		curveFloorPlaneMedium2SchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-03-03-14"),
				curveFloorPlaneMedium2SchemaArrowheadMirrored.getSymbol());
		curveFloorPlaneMedium2SchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-03-03-13"),
				curveFloorPlaneMedium2SchemaArrowheadMirrored.getSymbol());
		curveFloorPlaneMedium2SchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-03-03-12"),
				curveFloorPlaneMedium2SchemaArrowheadMirrored.getSymbol());
		curveFloorPlaneMedium2SchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-03-03-11"),
				curveFloorPlaneMedium2SchemaArrowheadMirrored.getSymbol());
		curveFloorPlaneMedium2SchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-03-03-10"),
				curveFloorPlaneMedium2SchemaArrowheadMirrored.getSymbol());
		curveFloorPlaneMedium2SchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-03-03-09"),
				curveFloorPlaneMedium2SchemaArrowheadMirrored.getSymbol());

		curveFloorPlaneLarge.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-04-01-02"), curveFloorPlaneLarge.getSymbol());
		curveFloorPlaneLarge.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-04-01-03"), curveFloorPlaneLarge.getSymbol());
		curveFloorPlaneLarge.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-04-01-04"), curveFloorPlaneLarge.getSymbol());
		curveFloorPlaneLarge.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-04-01-05"), curveFloorPlaneLarge.getSymbol());
		curveFloorPlaneLarge.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-04-01-06"), curveFloorPlaneLarge.getSymbol());
		curveFloorPlaneLarge.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-04-01-07"), curveFloorPlaneLarge.getSymbol());
		curveFloorPlaneLarge.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-04-01-08"), curveFloorPlaneLarge.getSymbol());
		curveFloorPlaneLarge.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-04-01-01"), curveFloorPlaneLarge.getSymbol());

		curveFloorPlaneLargeEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-04-02-02"), curveFloorPlaneLargeEmptyArrowhead.getSymbol());
		curveFloorPlaneLargeEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-04-02-03"), curveFloorPlaneLargeEmptyArrowhead.getSymbol());
		curveFloorPlaneLargeEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-04-02-04"), curveFloorPlaneLargeEmptyArrowhead.getSymbol());
		curveFloorPlaneLargeEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-04-02-05"), curveFloorPlaneLargeEmptyArrowhead.getSymbol());
		curveFloorPlaneLargeEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-04-02-06"), curveFloorPlaneLargeEmptyArrowhead.getSymbol());
		curveFloorPlaneLargeEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-04-02-07"), curveFloorPlaneLargeEmptyArrowhead.getSymbol());
		curveFloorPlaneLargeEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-04-02-08"), curveFloorPlaneLargeEmptyArrowhead.getSymbol());
		curveFloorPlaneLargeEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-04-02-01"), curveFloorPlaneLargeEmptyArrowhead.getSymbol());

		curveFloorPlaneLargeSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-04-03-02"), curveFloorPlaneLargeSchemaArrowhead.getSymbol());
		curveFloorPlaneLargeSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-04-03-03"), curveFloorPlaneLargeSchemaArrowhead.getSymbol());
		curveFloorPlaneLargeSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-04-03-04"), curveFloorPlaneLargeSchemaArrowhead.getSymbol());
		curveFloorPlaneLargeSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-04-03-05"), curveFloorPlaneLargeSchemaArrowhead.getSymbol());
		curveFloorPlaneLargeSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-04-03-06"), curveFloorPlaneLargeSchemaArrowhead.getSymbol());
		curveFloorPlaneLargeSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-04-03-07"), curveFloorPlaneLargeSchemaArrowhead.getSymbol());
		curveFloorPlaneLargeSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-04-03-08"), curveFloorPlaneLargeSchemaArrowhead.getSymbol());
		curveFloorPlaneLargeSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-04-03-01"), curveFloorPlaneLargeSchemaArrowhead.getSymbol());

		curveFloorPlaneLargeMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-04-01-16"), curveFloorPlaneLargeMirrored.getSymbol());
		curveFloorPlaneLargeMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-04-01-15"), curveFloorPlaneLargeMirrored.getSymbol());
		curveFloorPlaneLargeMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-04-01-14"), curveFloorPlaneLargeMirrored.getSymbol());
		curveFloorPlaneLargeMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-04-01-13"), curveFloorPlaneLargeMirrored.getSymbol());
		curveFloorPlaneLargeMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-04-01-12"), curveFloorPlaneLargeMirrored.getSymbol());
		curveFloorPlaneLargeMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-04-01-11"), curveFloorPlaneLargeMirrored.getSymbol());
		curveFloorPlaneLargeMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-04-01-10"), curveFloorPlaneLargeMirrored.getSymbol());
		curveFloorPlaneLargeMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-04-01-09"), curveFloorPlaneLargeMirrored.getSymbol());

		curveFloorPlaneLargeEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-04-02-16"),
				curveFloorPlaneLargeEmptyArrowheadMirrored.getSymbol());
		curveFloorPlaneLargeEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-04-02-15"),
				curveFloorPlaneLargeEmptyArrowheadMirrored.getSymbol());
		curveFloorPlaneLargeEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-04-02-14"),
				curveFloorPlaneLargeEmptyArrowheadMirrored.getSymbol());
		curveFloorPlaneLargeEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-04-02-13"),
				curveFloorPlaneLargeEmptyArrowheadMirrored.getSymbol());
		curveFloorPlaneLargeEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-04-02-12"),
				curveFloorPlaneLargeEmptyArrowheadMirrored.getSymbol());
		curveFloorPlaneLargeEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-04-02-11"),
				curveFloorPlaneLargeEmptyArrowheadMirrored.getSymbol());
		curveFloorPlaneLargeEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-04-02-10"),
				curveFloorPlaneLargeEmptyArrowheadMirrored.getSymbol());
		curveFloorPlaneLargeEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-04-02-09"),
				curveFloorPlaneLargeEmptyArrowheadMirrored.getSymbol());

		curveFloorPlaneLargeSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-04-03-16"),
				curveFloorPlaneLargeSchemaArrowheadMirrored.getSymbol());
		curveFloorPlaneLargeSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-04-03-15"),
				curveFloorPlaneLargeSchemaArrowheadMirrored.getSymbol());
		curveFloorPlaneLargeSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-04-03-14"),
				curveFloorPlaneLargeSchemaArrowheadMirrored.getSymbol());
		curveFloorPlaneLargeSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-04-03-13"),
				curveFloorPlaneLargeSchemaArrowheadMirrored.getSymbol());
		curveFloorPlaneLargeSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-04-03-12"),
				curveFloorPlaneLargeSchemaArrowheadMirrored.getSymbol());
		curveFloorPlaneLargeSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-04-03-11"),
				curveFloorPlaneLargeSchemaArrowheadMirrored.getSymbol());
		curveFloorPlaneLargeSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-04-03-10"),
				curveFloorPlaneLargeSchemaArrowheadMirrored.getSymbol());
		curveFloorPlaneLargeSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-04-03-09"),
				curveFloorPlaneLargeSchemaArrowheadMirrored.getSymbol());

		curveFloorPlaneCombined.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-05-01-02"), curveFloorPlaneCombined.getSymbol());
		curveFloorPlaneCombined.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-05-01-03"), curveFloorPlaneCombined.getSymbol());
		curveFloorPlaneCombined.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-05-01-04"), curveFloorPlaneCombined.getSymbol());
		curveFloorPlaneCombined.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-05-01-05"), curveFloorPlaneCombined.getSymbol());
		curveFloorPlaneCombined.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-05-01-06"), curveFloorPlaneCombined.getSymbol());
		curveFloorPlaneCombined.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-05-01-07"), curveFloorPlaneCombined.getSymbol());
		curveFloorPlaneCombined.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-05-01-08"), curveFloorPlaneCombined.getSymbol());
		curveFloorPlaneCombined.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-05-01-01"), curveFloorPlaneCombined.getSymbol());

		curveFloorPlaneCombinedEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-05-02-02"),
				curveFloorPlaneCombinedEmptyArrowhead.getSymbol());
		curveFloorPlaneCombinedEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-05-02-03"),
				curveFloorPlaneCombinedEmptyArrowhead.getSymbol());
		curveFloorPlaneCombinedEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-05-02-04"),
				curveFloorPlaneCombinedEmptyArrowhead.getSymbol());
		curveFloorPlaneCombinedEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-05-02-05"),
				curveFloorPlaneCombinedEmptyArrowhead.getSymbol());
		curveFloorPlaneCombinedEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-05-02-06"),
				curveFloorPlaneCombinedEmptyArrowhead.getSymbol());
		curveFloorPlaneCombinedEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-05-02-07"),
				curveFloorPlaneCombinedEmptyArrowhead.getSymbol());
		curveFloorPlaneCombinedEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-05-02-08"),
				curveFloorPlaneCombinedEmptyArrowhead.getSymbol());
		curveFloorPlaneCombinedEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-05-02-01"),
				curveFloorPlaneCombinedEmptyArrowhead.getSymbol());

		curveFloorPlaneCombinedSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-05-03-02"),
				curveFloorPlaneCombinedSchemaArrowhead.getSymbol());
		curveFloorPlaneCombinedSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-05-03-03"),
				curveFloorPlaneCombinedSchemaArrowhead.getSymbol());
		curveFloorPlaneCombinedSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-05-03-04"),
				curveFloorPlaneCombinedSchemaArrowhead.getSymbol());
		curveFloorPlaneCombinedSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-05-03-05"),
				curveFloorPlaneCombinedSchemaArrowhead.getSymbol());
		curveFloorPlaneCombinedSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-05-03-06"),
				curveFloorPlaneCombinedSchemaArrowhead.getSymbol());
		curveFloorPlaneCombinedSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-05-03-07"),
				curveFloorPlaneCombinedSchemaArrowhead.getSymbol());
		curveFloorPlaneCombinedSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-05-03-08"),
				curveFloorPlaneCombinedSchemaArrowhead.getSymbol());
		curveFloorPlaneCombinedSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-05-03-01"),
				curveFloorPlaneCombinedSchemaArrowhead.getSymbol());

		curveFloorPlaneCombinedMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-05-01-16"), curveFloorPlaneCombinedMirrored.getSymbol());
		curveFloorPlaneCombinedMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-05-01-15"), curveFloorPlaneCombinedMirrored.getSymbol());
		curveFloorPlaneCombinedMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-05-01-14"), curveFloorPlaneCombinedMirrored.getSymbol());
		curveFloorPlaneCombinedMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-05-01-13"), curveFloorPlaneCombinedMirrored.getSymbol());
		curveFloorPlaneCombinedMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-05-01-12"), curveFloorPlaneCombinedMirrored.getSymbol());
		curveFloorPlaneCombinedMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-05-01-11"), curveFloorPlaneCombinedMirrored.getSymbol());
		curveFloorPlaneCombinedMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-05-01-10"), curveFloorPlaneCombinedMirrored.getSymbol());
		curveFloorPlaneCombinedMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-05-01-09"), curveFloorPlaneCombinedMirrored.getSymbol());

		curveFloorPlaneCombinedEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-05-02-16"),
				curveFloorPlaneCombinedEmptyArrowheadMirrored.getSymbol());
		curveFloorPlaneCombinedEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-05-02-15"),
				curveFloorPlaneCombinedEmptyArrowheadMirrored.getSymbol());
		curveFloorPlaneCombinedEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-05-02-14"),
				curveFloorPlaneCombinedEmptyArrowheadMirrored.getSymbol());
		curveFloorPlaneCombinedEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-05-02-13"),
				curveFloorPlaneCombinedEmptyArrowheadMirrored.getSymbol());
		curveFloorPlaneCombinedEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-05-02-12"),
				curveFloorPlaneCombinedEmptyArrowheadMirrored.getSymbol());
		curveFloorPlaneCombinedEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-05-02-11"),
				curveFloorPlaneCombinedEmptyArrowheadMirrored.getSymbol());
		curveFloorPlaneCombinedEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-05-02-10"),
				curveFloorPlaneCombinedEmptyArrowheadMirrored.getSymbol());
		curveFloorPlaneCombinedEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-05-02-09"),
				curveFloorPlaneCombinedEmptyArrowheadMirrored.getSymbol());

		curveFloorPlaneCombinedSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-05-03-16"),
				curveFloorPlaneCombinedSchemaArrowheadMirrored.getSymbol());
		curveFloorPlaneCombinedSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-05-03-15"),
				curveFloorPlaneCombinedSchemaArrowheadMirrored.getSymbol());
		curveFloorPlaneCombinedSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-05-03-14"),
				curveFloorPlaneCombinedSchemaArrowheadMirrored.getSymbol());
		curveFloorPlaneCombinedSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-05-03-13"),
				curveFloorPlaneCombinedSchemaArrowheadMirrored.getSymbol());
		curveFloorPlaneCombinedSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-05-03-12"),
				curveFloorPlaneCombinedSchemaArrowheadMirrored.getSymbol());
		curveFloorPlaneCombinedSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-05-03-11"),
				curveFloorPlaneCombinedSchemaArrowheadMirrored.getSymbol());
		curveFloorPlaneCombinedSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-05-03-10"),
				curveFloorPlaneCombinedSchemaArrowheadMirrored.getSymbol());
		curveFloorPlaneCombinedSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-001-05-03-09"),
				curveFloorPlaneCombinedSchemaArrowheadMirrored.getSymbol());

		humpFloorPlaneSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-002-01-01-02"), humpFloorPlaneSmall.getSymbol());
		humpFloorPlaneSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-002-01-01-03"), humpFloorPlaneSmall.getSymbol());
		humpFloorPlaneSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-002-01-01-04"), humpFloorPlaneSmall.getSymbol());
		humpFloorPlaneSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-002-01-01-05"), humpFloorPlaneSmall.getSymbol());
		humpFloorPlaneSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-002-01-01-06"), humpFloorPlaneSmall.getSymbol());
		humpFloorPlaneSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-002-01-01-07"), humpFloorPlaneSmall.getSymbol());
		humpFloorPlaneSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-002-01-01-08"), humpFloorPlaneSmall.getSymbol());
		humpFloorPlaneSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-002-01-01-01"), humpFloorPlaneSmall.getSymbol());

		humpFloorPlaneSmallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-002-01-02-02"), humpFloorPlaneSmallEmptyArrowhead.getSymbol());
		humpFloorPlaneSmallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-002-01-02-03"), humpFloorPlaneSmallEmptyArrowhead.getSymbol());
		humpFloorPlaneSmallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-002-01-02-04"), humpFloorPlaneSmallEmptyArrowhead.getSymbol());
		humpFloorPlaneSmallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-002-01-02-05"), humpFloorPlaneSmallEmptyArrowhead.getSymbol());
		humpFloorPlaneSmallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-002-01-02-06"), humpFloorPlaneSmallEmptyArrowhead.getSymbol());
		humpFloorPlaneSmallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-002-01-02-07"), humpFloorPlaneSmallEmptyArrowhead.getSymbol());
		humpFloorPlaneSmallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-002-01-02-08"), humpFloorPlaneSmallEmptyArrowhead.getSymbol());
		humpFloorPlaneSmallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-002-01-02-01"), humpFloorPlaneSmallEmptyArrowhead.getSymbol());

		humpFloorPlaneSmallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-002-01-03-02"), humpFloorPlaneSmallSchemaArrowhead.getSymbol());
		humpFloorPlaneSmallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-002-01-03-03"), humpFloorPlaneSmallSchemaArrowhead.getSymbol());
		humpFloorPlaneSmallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-002-01-03-04"), humpFloorPlaneSmallSchemaArrowhead.getSymbol());
		humpFloorPlaneSmallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-002-01-03-05"), humpFloorPlaneSmallSchemaArrowhead.getSymbol());
		humpFloorPlaneSmallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-002-01-03-06"), humpFloorPlaneSmallSchemaArrowhead.getSymbol());
		humpFloorPlaneSmallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-002-01-03-07"), humpFloorPlaneSmallSchemaArrowhead.getSymbol());
		humpFloorPlaneSmallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-002-01-03-08"), humpFloorPlaneSmallSchemaArrowhead.getSymbol());
		humpFloorPlaneSmallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-002-01-03-01"), humpFloorPlaneSmallSchemaArrowhead.getSymbol());

		humpFloorPlaneSmallMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-002-01-01-16"), humpFloorPlaneSmallMirrored.getSymbol());
		humpFloorPlaneSmallMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-002-01-01-15"), humpFloorPlaneSmallMirrored.getSymbol());
		humpFloorPlaneSmallMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-002-01-01-14"), humpFloorPlaneSmallMirrored.getSymbol());
		humpFloorPlaneSmallMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-002-01-01-13"), humpFloorPlaneSmallMirrored.getSymbol());
		humpFloorPlaneSmallMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-002-01-01-12"), humpFloorPlaneSmallMirrored.getSymbol());
		humpFloorPlaneSmallMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-002-01-01-11"), humpFloorPlaneSmallMirrored.getSymbol());
		humpFloorPlaneSmallMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-002-01-01-10"), humpFloorPlaneSmallMirrored.getSymbol());
		humpFloorPlaneSmallMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-002-01-01-09"), humpFloorPlaneSmallMirrored.getSymbol());

		humpFloorPlaneSmallEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-002-01-02-16"),
				humpFloorPlaneSmallEmptyArrowheadMirrored.getSymbol());
		humpFloorPlaneSmallEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-002-01-02-15"),
				humpFloorPlaneSmallEmptyArrowheadMirrored.getSymbol());
		humpFloorPlaneSmallEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-002-01-02-14"),
				humpFloorPlaneSmallEmptyArrowheadMirrored.getSymbol());
		humpFloorPlaneSmallEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-002-01-02-13"),
				humpFloorPlaneSmallEmptyArrowheadMirrored.getSymbol());
		humpFloorPlaneSmallEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-002-01-02-12"),
				humpFloorPlaneSmallEmptyArrowheadMirrored.getSymbol());
		humpFloorPlaneSmallEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-002-01-02-11"),
				humpFloorPlaneSmallEmptyArrowheadMirrored.getSymbol());
		humpFloorPlaneSmallEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-002-01-02-10"),
				humpFloorPlaneSmallEmptyArrowheadMirrored.getSymbol());
		humpFloorPlaneSmallEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-002-01-02-09"),
				humpFloorPlaneSmallEmptyArrowheadMirrored.getSymbol());

		humpFloorPlaneSmallSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-002-01-03-16"),
				humpFloorPlaneSmallSchemaArrowheadMirrored.getSymbol());
		humpFloorPlaneSmallSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-002-01-03-15"),
				humpFloorPlaneSmallSchemaArrowheadMirrored.getSymbol());
		humpFloorPlaneSmallSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-002-01-03-14"),
				humpFloorPlaneSmallSchemaArrowheadMirrored.getSymbol());
		humpFloorPlaneSmallSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-002-01-03-13"),
				humpFloorPlaneSmallSchemaArrowheadMirrored.getSymbol());
		humpFloorPlaneSmallSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-002-01-03-12"),
				humpFloorPlaneSmallSchemaArrowheadMirrored.getSymbol());
		humpFloorPlaneSmallSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-002-01-03-11"),
				humpFloorPlaneSmallSchemaArrowheadMirrored.getSymbol());
		humpFloorPlaneSmallSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-002-01-03-10"),
				humpFloorPlaneSmallSchemaArrowheadMirrored.getSymbol());
		humpFloorPlaneSmallSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-002-01-03-09"),
				humpFloorPlaneSmallSchemaArrowheadMirrored.getSymbol());

		loopFloorPlaneSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-003-01-01-02"), loopFloorPlaneSmall.getSymbol());
		loopFloorPlaneSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-003-01-01-03"), loopFloorPlaneSmall.getSymbol());
		loopFloorPlaneSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-003-01-01-04"), loopFloorPlaneSmall.getSymbol());
		loopFloorPlaneSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-003-01-01-05"), loopFloorPlaneSmall.getSymbol());
		loopFloorPlaneSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-003-01-01-06"), loopFloorPlaneSmall.getSymbol());
		loopFloorPlaneSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-003-01-01-07"), loopFloorPlaneSmall.getSymbol());
		loopFloorPlaneSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-003-01-01-08"), loopFloorPlaneSmall.getSymbol());
		loopFloorPlaneSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-003-01-01-01"), loopFloorPlaneSmall.getSymbol());

		loopFloorPlaneSmallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-003-01-02-02"), loopFloorPlaneSmallEmptyArrowhead.getSymbol());
		loopFloorPlaneSmallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-003-01-02-03"), loopFloorPlaneSmallEmptyArrowhead.getSymbol());
		loopFloorPlaneSmallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-003-01-02-04"), loopFloorPlaneSmallEmptyArrowhead.getSymbol());
		loopFloorPlaneSmallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-003-01-02-05"), loopFloorPlaneSmallEmptyArrowhead.getSymbol());
		loopFloorPlaneSmallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-003-01-02-06"), loopFloorPlaneSmallEmptyArrowhead.getSymbol());
		loopFloorPlaneSmallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-003-01-02-07"), loopFloorPlaneSmallEmptyArrowhead.getSymbol());
		loopFloorPlaneSmallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-003-01-02-08"), loopFloorPlaneSmallEmptyArrowhead.getSymbol());
		loopFloorPlaneSmallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-003-01-02-01"), loopFloorPlaneSmallEmptyArrowhead.getSymbol());

		loopFloorPlaneSmallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-003-01-03-02"), loopFloorPlaneSmallSchemaArrowhead.getSymbol());
		loopFloorPlaneSmallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-003-01-03-03"), loopFloorPlaneSmallSchemaArrowhead.getSymbol());
		loopFloorPlaneSmallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-003-01-03-04"), loopFloorPlaneSmallSchemaArrowhead.getSymbol());
		loopFloorPlaneSmallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-003-01-03-05"), loopFloorPlaneSmallSchemaArrowhead.getSymbol());
		loopFloorPlaneSmallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-003-01-03-06"), loopFloorPlaneSmallSchemaArrowhead.getSymbol());
		loopFloorPlaneSmallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-003-01-03-07"), loopFloorPlaneSmallSchemaArrowhead.getSymbol());
		loopFloorPlaneSmallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-003-01-03-08"), loopFloorPlaneSmallSchemaArrowhead.getSymbol());
		loopFloorPlaneSmallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-003-01-03-01"), loopFloorPlaneSmallSchemaArrowhead.getSymbol());

		loopFloorPlaneSmallMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-003-01-01-16"), loopFloorPlaneSmallMirrored.getSymbol());
		loopFloorPlaneSmallMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-003-01-01-15"), loopFloorPlaneSmallMirrored.getSymbol());
		loopFloorPlaneSmallMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-003-01-01-14"), loopFloorPlaneSmallMirrored.getSymbol());
		loopFloorPlaneSmallMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-003-01-01-13"), loopFloorPlaneSmallMirrored.getSymbol());
		loopFloorPlaneSmallMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-003-01-01-12"), loopFloorPlaneSmallMirrored.getSymbol());
		loopFloorPlaneSmallMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-003-01-01-11"), loopFloorPlaneSmallMirrored.getSymbol());
		loopFloorPlaneSmallMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-003-01-01-10"), loopFloorPlaneSmallMirrored.getSymbol());
		loopFloorPlaneSmallMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-003-01-01-09"), loopFloorPlaneSmallMirrored.getSymbol());

		loopFloorPlaneSmallEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-003-01-02-16"),
				loopFloorPlaneSmallEmptyArrowheadMirrored.getSymbol());
		loopFloorPlaneSmallEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-003-01-02-15"),
				loopFloorPlaneSmallEmptyArrowheadMirrored.getSymbol());
		loopFloorPlaneSmallEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-003-01-02-14"),
				loopFloorPlaneSmallEmptyArrowheadMirrored.getSymbol());
		loopFloorPlaneSmallEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-003-01-02-13"),
				loopFloorPlaneSmallEmptyArrowheadMirrored.getSymbol());
		loopFloorPlaneSmallEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-003-01-02-12"),
				loopFloorPlaneSmallEmptyArrowheadMirrored.getSymbol());
		loopFloorPlaneSmallEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-003-01-02-11"),
				loopFloorPlaneSmallEmptyArrowheadMirrored.getSymbol());
		loopFloorPlaneSmallEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-003-01-02-10"),
				loopFloorPlaneSmallEmptyArrowheadMirrored.getSymbol());
		loopFloorPlaneSmallEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-003-01-02-09"),
				loopFloorPlaneSmallEmptyArrowheadMirrored.getSymbol());

		loopFloorPlaneSmallSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-003-01-03-16"),
				loopFloorPlaneSmallSchemaArrowheadMirrored.getSymbol());
		loopFloorPlaneSmallSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-003-01-03-15"),
				loopFloorPlaneSmallSchemaArrowheadMirrored.getSymbol());
		loopFloorPlaneSmallSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-003-01-03-14"),
				loopFloorPlaneSmallSchemaArrowheadMirrored.getSymbol());
		loopFloorPlaneSmallSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-003-01-03-13"),
				loopFloorPlaneSmallSchemaArrowheadMirrored.getSymbol());
		loopFloorPlaneSmallSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-003-01-03-12"),
				loopFloorPlaneSmallSchemaArrowheadMirrored.getSymbol());
		loopFloorPlaneSmallSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-003-01-03-11"),
				loopFloorPlaneSmallSchemaArrowheadMirrored.getSymbol());
		loopFloorPlaneSmallSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-003-01-03-10"),
				loopFloorPlaneSmallSchemaArrowheadMirrored.getSymbol());
		loopFloorPlaneSmallSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-003-01-03-09"),
				loopFloorPlaneSmallSchemaArrowheadMirrored.getSymbol());

		waveFloorPlaneSnake.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-01-01-02"), waveFloorPlaneSnake.getSymbol());
		waveFloorPlaneSnake.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-01-01-03"), waveFloorPlaneSnake.getSymbol());
		waveFloorPlaneSnake.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-01-01-04"), waveFloorPlaneSnake.getSymbol());
		waveFloorPlaneSnake.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-01-01-05"), waveFloorPlaneSnake.getSymbol());
		waveFloorPlaneSnake.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-01-01-06"), waveFloorPlaneSnake.getSymbol());
		waveFloorPlaneSnake.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-01-01-07"), waveFloorPlaneSnake.getSymbol());
		waveFloorPlaneSnake.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-01-01-08"), waveFloorPlaneSnake.getSymbol());
		waveFloorPlaneSnake.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-01-01-01"), waveFloorPlaneSnake.getSymbol());

		waveFloorPlaneSnakeEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-01-02-02"), waveFloorPlaneSnakeEmptyArrowhead.getSymbol());
		waveFloorPlaneSnakeEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-01-02-03"), waveFloorPlaneSnakeEmptyArrowhead.getSymbol());
		waveFloorPlaneSnakeEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-01-02-04"), waveFloorPlaneSnakeEmptyArrowhead.getSymbol());
		waveFloorPlaneSnakeEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-01-02-05"), waveFloorPlaneSnakeEmptyArrowhead.getSymbol());
		waveFloorPlaneSnakeEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-01-02-06"), waveFloorPlaneSnakeEmptyArrowhead.getSymbol());
		waveFloorPlaneSnakeEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-01-02-07"), waveFloorPlaneSnakeEmptyArrowhead.getSymbol());
		waveFloorPlaneSnakeEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-01-02-08"), waveFloorPlaneSnakeEmptyArrowhead.getSymbol());
		waveFloorPlaneSnakeEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-01-02-01"), waveFloorPlaneSnakeEmptyArrowhead.getSymbol());

		waveFloorPlaneSnakeSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-01-03-02"), waveFloorPlaneSnakeSchemaArrowhead.getSymbol());
		waveFloorPlaneSnakeSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-01-03-03"), waveFloorPlaneSnakeSchemaArrowhead.getSymbol());
		waveFloorPlaneSnakeSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-01-03-04"), waveFloorPlaneSnakeSchemaArrowhead.getSymbol());
		waveFloorPlaneSnakeSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-01-03-05"), waveFloorPlaneSnakeSchemaArrowhead.getSymbol());
		waveFloorPlaneSnakeSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-01-03-06"), waveFloorPlaneSnakeSchemaArrowhead.getSymbol());
		waveFloorPlaneSnakeSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-01-03-07"), waveFloorPlaneSnakeSchemaArrowhead.getSymbol());
		waveFloorPlaneSnakeSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-01-03-08"), waveFloorPlaneSnakeSchemaArrowhead.getSymbol());
		waveFloorPlaneSnakeSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-01-03-01"), waveFloorPlaneSnakeSchemaArrowhead.getSymbol());

		waveFloorPlaneSnakeMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-01-01-16"), waveFloorPlaneSnakeMirrored.getSymbol());
		waveFloorPlaneSnakeMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-01-01-15"), waveFloorPlaneSnakeMirrored.getSymbol());
		waveFloorPlaneSnakeMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-01-01-14"), waveFloorPlaneSnakeMirrored.getSymbol());
		waveFloorPlaneSnakeMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-01-01-13"), waveFloorPlaneSnakeMirrored.getSymbol());
		waveFloorPlaneSnakeMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-01-01-12"), waveFloorPlaneSnakeMirrored.getSymbol());
		waveFloorPlaneSnakeMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-01-01-11"), waveFloorPlaneSnakeMirrored.getSymbol());
		waveFloorPlaneSnakeMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-01-01-10"), waveFloorPlaneSnakeMirrored.getSymbol());
		waveFloorPlaneSnakeMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-01-01-09"), waveFloorPlaneSnakeMirrored.getSymbol());

		waveFloorPlaneSnakeEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-01-02-16"),
				waveFloorPlaneSnakeEmptyArrowheadMirrored.getSymbol());
		waveFloorPlaneSnakeEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-01-02-15"),
				waveFloorPlaneSnakeEmptyArrowheadMirrored.getSymbol());
		waveFloorPlaneSnakeEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-01-02-14"),
				waveFloorPlaneSnakeEmptyArrowheadMirrored.getSymbol());
		waveFloorPlaneSnakeEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-01-02-13"),
				waveFloorPlaneSnakeEmptyArrowheadMirrored.getSymbol());
		waveFloorPlaneSnakeEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-01-02-12"),
				waveFloorPlaneSnakeEmptyArrowheadMirrored.getSymbol());
		waveFloorPlaneSnakeEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-01-02-11"),
				waveFloorPlaneSnakeEmptyArrowheadMirrored.getSymbol());
		waveFloorPlaneSnakeEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-01-02-10"),
				waveFloorPlaneSnakeEmptyArrowheadMirrored.getSymbol());
		waveFloorPlaneSnakeEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-01-02-09"),
				waveFloorPlaneSnakeEmptyArrowheadMirrored.getSymbol());

		waveFloorPlaneSnakeSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-01-03-16"),
				waveFloorPlaneSnakeSchemaArrowheadMirrored.getSymbol());
		waveFloorPlaneSnakeSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-01-03-15"),
				waveFloorPlaneSnakeSchemaArrowheadMirrored.getSymbol());
		waveFloorPlaneSnakeSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-01-03-14"),
				waveFloorPlaneSnakeSchemaArrowheadMirrored.getSymbol());
		waveFloorPlaneSnakeSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-01-03-13"),
				waveFloorPlaneSnakeSchemaArrowheadMirrored.getSymbol());
		waveFloorPlaneSnakeSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-01-03-12"),
				waveFloorPlaneSnakeSchemaArrowheadMirrored.getSymbol());
		waveFloorPlaneSnakeSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-01-03-11"),
				waveFloorPlaneSnakeSchemaArrowheadMirrored.getSymbol());
		waveFloorPlaneSnakeSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-01-03-10"),
				waveFloorPlaneSnakeSchemaArrowheadMirrored.getSymbol());
		waveFloorPlaneSnakeSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-01-03-09"),
				waveFloorPlaneSnakeSchemaArrowheadMirrored.getSymbol());

		waveFloorPlaneSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-02-01-02"), waveFloorPlaneSmall.getSymbol());
		waveFloorPlaneSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-02-01-03"), waveFloorPlaneSmall.getSymbol());
		waveFloorPlaneSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-02-01-04"), waveFloorPlaneSmall.getSymbol());
		waveFloorPlaneSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-02-01-05"), waveFloorPlaneSmall.getSymbol());
		waveFloorPlaneSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-02-01-06"), waveFloorPlaneSmall.getSymbol());
		waveFloorPlaneSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-02-01-07"), waveFloorPlaneSmall.getSymbol());
		waveFloorPlaneSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-02-01-08"), waveFloorPlaneSmall.getSymbol());
		waveFloorPlaneSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-02-01-01"), waveFloorPlaneSmall.getSymbol());

		waveFloorPlaneSmallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-02-02-02"), waveFloorPlaneSmallEmptyArrowhead.getSymbol());
		waveFloorPlaneSmallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-02-02-03"), waveFloorPlaneSmallEmptyArrowhead.getSymbol());
		waveFloorPlaneSmallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-02-02-04"), waveFloorPlaneSmallEmptyArrowhead.getSymbol());
		waveFloorPlaneSmallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-02-02-05"), waveFloorPlaneSmallEmptyArrowhead.getSymbol());
		waveFloorPlaneSmallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-02-02-06"), waveFloorPlaneSmallEmptyArrowhead.getSymbol());
		waveFloorPlaneSmallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-02-02-07"), waveFloorPlaneSmallEmptyArrowhead.getSymbol());
		waveFloorPlaneSmallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-02-02-08"), waveFloorPlaneSmallEmptyArrowhead.getSymbol());
		waveFloorPlaneSmallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-02-02-01"), waveFloorPlaneSmallEmptyArrowhead.getSymbol());

		waveFloorPlaneSmallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-02-03-02"), waveFloorPlaneSmallSchemaArrowhead.getSymbol());
		waveFloorPlaneSmallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-02-03-03"), waveFloorPlaneSmallSchemaArrowhead.getSymbol());
		waveFloorPlaneSmallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-02-03-04"), waveFloorPlaneSmallSchemaArrowhead.getSymbol());
		waveFloorPlaneSmallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-02-03-05"), waveFloorPlaneSmallSchemaArrowhead.getSymbol());
		waveFloorPlaneSmallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-02-03-06"), waveFloorPlaneSmallSchemaArrowhead.getSymbol());
		waveFloorPlaneSmallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-02-03-07"), waveFloorPlaneSmallSchemaArrowhead.getSymbol());
		waveFloorPlaneSmallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-02-03-08"), waveFloorPlaneSmallSchemaArrowhead.getSymbol());
		waveFloorPlaneSmallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-02-03-01"), waveFloorPlaneSmallSchemaArrowhead.getSymbol());

		waveFloorPlaneSmallMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-02-01-16"), waveFloorPlaneSmallMirrored.getSymbol());
		waveFloorPlaneSmallMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-02-01-15"), waveFloorPlaneSmallMirrored.getSymbol());
		waveFloorPlaneSmallMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-02-01-14"), waveFloorPlaneSmallMirrored.getSymbol());
		waveFloorPlaneSmallMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-02-01-13"), waveFloorPlaneSmallMirrored.getSymbol());
		waveFloorPlaneSmallMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-02-01-12"), waveFloorPlaneSmallMirrored.getSymbol());
		waveFloorPlaneSmallMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-02-01-11"), waveFloorPlaneSmallMirrored.getSymbol());
		waveFloorPlaneSmallMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-02-01-10"), waveFloorPlaneSmallMirrored.getSymbol());
		waveFloorPlaneSmallMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-02-01-09"), waveFloorPlaneSmallMirrored.getSymbol());

		waveFloorPlaneSmallEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-02-02-16"),
				waveFloorPlaneSmallEmptyArrowheadMirrored.getSymbol());
		waveFloorPlaneSmallEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-02-02-15"),
				waveFloorPlaneSmallEmptyArrowheadMirrored.getSymbol());
		waveFloorPlaneSmallEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-02-02-14"),
				waveFloorPlaneSmallEmptyArrowheadMirrored.getSymbol());
		waveFloorPlaneSmallEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-02-02-13"),
				waveFloorPlaneSmallEmptyArrowheadMirrored.getSymbol());
		waveFloorPlaneSmallEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-02-02-12"),
				waveFloorPlaneSmallEmptyArrowheadMirrored.getSymbol());
		waveFloorPlaneSmallEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-02-02-11"),
				waveFloorPlaneSmallEmptyArrowheadMirrored.getSymbol());
		waveFloorPlaneSmallEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-02-02-10"),
				waveFloorPlaneSmallEmptyArrowheadMirrored.getSymbol());
		waveFloorPlaneSmallEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-02-02-09"),
				waveFloorPlaneSmallEmptyArrowheadMirrored.getSymbol());

		waveFloorPlaneSmallSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-02-03-16"),
				waveFloorPlaneSmallSchemaArrowheadMirrored.getSymbol());
		waveFloorPlaneSmallSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-02-03-15"),
				waveFloorPlaneSmallSchemaArrowheadMirrored.getSymbol());
		waveFloorPlaneSmallSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-02-03-14"),
				waveFloorPlaneSmallSchemaArrowheadMirrored.getSymbol());
		waveFloorPlaneSmallSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-02-03-13"),
				waveFloorPlaneSmallSchemaArrowheadMirrored.getSymbol());
		waveFloorPlaneSmallSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-02-03-12"),
				waveFloorPlaneSmallSchemaArrowheadMirrored.getSymbol());
		waveFloorPlaneSmallSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-02-03-11"),
				waveFloorPlaneSmallSchemaArrowheadMirrored.getSymbol());
		waveFloorPlaneSmallSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-02-03-10"),
				waveFloorPlaneSmallSchemaArrowheadMirrored.getSymbol());
		waveFloorPlaneSmallSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-02-03-09"),
				waveFloorPlaneSmallSchemaArrowheadMirrored.getSymbol());

		waveFloorPlaneLarge.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-03-01-02"), waveFloorPlaneLarge.getSymbol());
		waveFloorPlaneLarge.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-03-01-03"), waveFloorPlaneLarge.getSymbol());
		waveFloorPlaneLarge.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-03-01-04"), waveFloorPlaneLarge.getSymbol());
		waveFloorPlaneLarge.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-03-01-05"), waveFloorPlaneLarge.getSymbol());
		waveFloorPlaneLarge.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-03-01-06"), waveFloorPlaneLarge.getSymbol());
		waveFloorPlaneLarge.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-03-01-07"), waveFloorPlaneLarge.getSymbol());
		waveFloorPlaneLarge.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-03-01-08"), waveFloorPlaneLarge.getSymbol());
		waveFloorPlaneLarge.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-03-01-01"), waveFloorPlaneLarge.getSymbol());

		waveFloorPlaneLargeEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-03-02-02"), waveFloorPlaneLargeEmptyArrowhead.getSymbol());
		waveFloorPlaneLargeEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-03-02-03"), waveFloorPlaneLargeEmptyArrowhead.getSymbol());
		waveFloorPlaneLargeEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-03-02-04"), waveFloorPlaneLargeEmptyArrowhead.getSymbol());
		waveFloorPlaneLargeEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-03-02-05"), waveFloorPlaneLargeEmptyArrowhead.getSymbol());
		waveFloorPlaneLargeEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-03-02-06"), waveFloorPlaneLargeEmptyArrowhead.getSymbol());
		waveFloorPlaneLargeEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-03-02-07"), waveFloorPlaneLargeEmptyArrowhead.getSymbol());
		waveFloorPlaneLargeEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-03-02-08"), waveFloorPlaneLargeEmptyArrowhead.getSymbol());
		waveFloorPlaneLargeEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-03-02-01"), waveFloorPlaneLargeEmptyArrowhead.getSymbol());

		waveFloorPlaneLargeSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-03-03-02"), waveFloorPlaneLargeSchemaArrowhead.getSymbol());
		waveFloorPlaneLargeSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-03-03-03"), waveFloorPlaneLargeSchemaArrowhead.getSymbol());
		waveFloorPlaneLargeSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-03-03-04"), waveFloorPlaneLargeSchemaArrowhead.getSymbol());
		waveFloorPlaneLargeSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-03-03-05"), waveFloorPlaneLargeSchemaArrowhead.getSymbol());
		waveFloorPlaneLargeSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-03-03-06"), waveFloorPlaneLargeSchemaArrowhead.getSymbol());
		waveFloorPlaneLargeSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-03-03-07"), waveFloorPlaneLargeSchemaArrowhead.getSymbol());
		waveFloorPlaneLargeSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-03-03-08"), waveFloorPlaneLargeSchemaArrowhead.getSymbol());
		waveFloorPlaneLargeSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-03-03-01"), waveFloorPlaneLargeSchemaArrowhead.getSymbol());

		waveFloorPlaneLargeMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-03-01-16"), waveFloorPlaneLargeMirrored.getSymbol());
		waveFloorPlaneLargeMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-03-01-15"), waveFloorPlaneLargeMirrored.getSymbol());
		waveFloorPlaneLargeMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-03-01-14"), waveFloorPlaneLargeMirrored.getSymbol());
		waveFloorPlaneLargeMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-03-01-13"), waveFloorPlaneLargeMirrored.getSymbol());
		waveFloorPlaneLargeMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-03-01-12"), waveFloorPlaneLargeMirrored.getSymbol());
		waveFloorPlaneLargeMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-03-01-11"), waveFloorPlaneLargeMirrored.getSymbol());
		waveFloorPlaneLargeMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-03-01-10"), waveFloorPlaneLargeMirrored.getSymbol());
		waveFloorPlaneLargeMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-03-01-09"), waveFloorPlaneLargeMirrored.getSymbol());

		waveFloorPlaneLargeEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-03-02-16"),
				waveFloorPlaneLargeEmptyArrowheadMirrored.getSymbol());
		waveFloorPlaneLargeEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-03-02-15"),
				waveFloorPlaneLargeEmptyArrowheadMirrored.getSymbol());
		waveFloorPlaneLargeEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-03-02-14"),
				waveFloorPlaneLargeEmptyArrowheadMirrored.getSymbol());
		waveFloorPlaneLargeEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-03-02-13"),
				waveFloorPlaneLargeEmptyArrowheadMirrored.getSymbol());
		waveFloorPlaneLargeEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-03-02-12"),
				waveFloorPlaneLargeEmptyArrowheadMirrored.getSymbol());
		waveFloorPlaneLargeEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-03-02-11"),
				waveFloorPlaneLargeEmptyArrowheadMirrored.getSymbol());
		waveFloorPlaneLargeEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-03-02-10"),
				waveFloorPlaneLargeEmptyArrowheadMirrored.getSymbol());
		waveFloorPlaneLargeEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-03-02-09"),
				waveFloorPlaneLargeEmptyArrowheadMirrored.getSymbol());

		waveFloorPlaneLargeSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-03-03-16"),
				waveFloorPlaneLargeSchemaArrowheadMirrored.getSymbol());
		waveFloorPlaneLargeSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-03-03-15"),
				waveFloorPlaneLargeSchemaArrowheadMirrored.getSymbol());
		waveFloorPlaneLargeSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-03-03-14"),
				waveFloorPlaneLargeSchemaArrowheadMirrored.getSymbol());
		waveFloorPlaneLargeSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-03-03-13"),
				waveFloorPlaneLargeSchemaArrowheadMirrored.getSymbol());
		waveFloorPlaneLargeSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-03-03-12"),
				waveFloorPlaneLargeSchemaArrowheadMirrored.getSymbol());
		waveFloorPlaneLargeSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-03-03-11"),
				waveFloorPlaneLargeSchemaArrowheadMirrored.getSymbol());
		waveFloorPlaneLargeSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-03-03-10"),
				waveFloorPlaneLargeSchemaArrowheadMirrored.getSymbol());
		waveFloorPlaneLargeSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-004-03-03-09"),
				waveFloorPlaneLargeSchemaArrowheadMirrored.getSymbol());

		rotationSingleFloorPlane.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-005-01-01-02"), rotationSingleFloorPlane.getSymbol());
		rotationSingleFloorPlane.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-005-01-01-03"), rotationSingleFloorPlane.getSymbol());
		rotationSingleFloorPlane.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-005-01-01-04"), rotationSingleFloorPlane.getSymbol());
		rotationSingleFloorPlane.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-005-01-01-05"), rotationSingleFloorPlane.getSymbol());
		rotationSingleFloorPlane.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-005-01-01-06"), rotationSingleFloorPlane.getSymbol());
		rotationSingleFloorPlane.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-005-01-01-07"), rotationSingleFloorPlane.getSymbol());
		rotationSingleFloorPlane.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-005-01-01-08"), rotationSingleFloorPlane.getSymbol());
		rotationSingleFloorPlane.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-005-01-01-01"), rotationSingleFloorPlane.getSymbol());

		rotationSingleFloorPlaneEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-005-01-02-02"),
				rotationSingleFloorPlaneEmptyArrowhead.getSymbol());
		rotationSingleFloorPlaneEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-005-01-02-03"),
				rotationSingleFloorPlaneEmptyArrowhead.getSymbol());
		rotationSingleFloorPlaneEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-005-01-02-04"),
				rotationSingleFloorPlaneEmptyArrowhead.getSymbol());
		rotationSingleFloorPlaneEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-005-01-02-05"),
				rotationSingleFloorPlaneEmptyArrowhead.getSymbol());
		rotationSingleFloorPlaneEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-005-01-02-06"),
				rotationSingleFloorPlaneEmptyArrowhead.getSymbol());
		rotationSingleFloorPlaneEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-005-01-02-07"),
				rotationSingleFloorPlaneEmptyArrowhead.getSymbol());
		rotationSingleFloorPlaneEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-005-01-02-08"),
				rotationSingleFloorPlaneEmptyArrowhead.getSymbol());
		rotationSingleFloorPlaneEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-005-01-02-01"),
				rotationSingleFloorPlaneEmptyArrowhead.getSymbol());

		rotationSingleFloorPlaneSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-005-01-03-02"),
				rotationSingleFloorPlaneSchemaArrowhead.getSymbol());
		rotationSingleFloorPlaneSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-005-01-03-03"),
				rotationSingleFloorPlaneSchemaArrowhead.getSymbol());
		rotationSingleFloorPlaneSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-005-01-03-04"),
				rotationSingleFloorPlaneSchemaArrowhead.getSymbol());
		rotationSingleFloorPlaneSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-005-01-03-05"),
				rotationSingleFloorPlaneSchemaArrowhead.getSymbol());
		rotationSingleFloorPlaneSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-005-01-03-06"),
				rotationSingleFloorPlaneSchemaArrowhead.getSymbol());
		rotationSingleFloorPlaneSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-005-01-03-07"),
				rotationSingleFloorPlaneSchemaArrowhead.getSymbol());
		rotationSingleFloorPlaneSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-005-01-03-08"),
				rotationSingleFloorPlaneSchemaArrowhead.getSymbol());
		rotationSingleFloorPlaneSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-005-01-03-01"),
				rotationSingleFloorPlaneSchemaArrowhead.getSymbol());

		rotationSingleFloorPlaneMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-005-01-01-16"), rotationSingleFloorPlaneMirrored.getSymbol());
		rotationSingleFloorPlaneMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-005-01-01-15"), rotationSingleFloorPlaneMirrored.getSymbol());
		rotationSingleFloorPlaneMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-005-01-01-14"), rotationSingleFloorPlaneMirrored.getSymbol());
		rotationSingleFloorPlaneMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-005-01-01-13"), rotationSingleFloorPlaneMirrored.getSymbol());
		rotationSingleFloorPlaneMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-005-01-01-12"), rotationSingleFloorPlaneMirrored.getSymbol());
		rotationSingleFloorPlaneMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-005-01-01-11"), rotationSingleFloorPlaneMirrored.getSymbol());
		rotationSingleFloorPlaneMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-005-01-01-10"), rotationSingleFloorPlaneMirrored.getSymbol());
		rotationSingleFloorPlaneMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-005-01-01-09"), rotationSingleFloorPlaneMirrored.getSymbol());

		rotationSingleFloorPlaneEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-005-01-02-16"),
				rotationSingleFloorPlaneEmptyArrowheadMirrored.getSymbol());
		rotationSingleFloorPlaneEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-005-01-02-15"),
				rotationSingleFloorPlaneEmptyArrowheadMirrored.getSymbol());
		rotationSingleFloorPlaneEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-005-01-02-14"),
				rotationSingleFloorPlaneEmptyArrowheadMirrored.getSymbol());
		rotationSingleFloorPlaneEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-005-01-02-13"),
				rotationSingleFloorPlaneEmptyArrowheadMirrored.getSymbol());
		rotationSingleFloorPlaneEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-005-01-02-12"),
				rotationSingleFloorPlaneEmptyArrowheadMirrored.getSymbol());
		rotationSingleFloorPlaneEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-005-01-02-11"),
				rotationSingleFloorPlaneEmptyArrowheadMirrored.getSymbol());
		rotationSingleFloorPlaneEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-005-01-02-10"),
				rotationSingleFloorPlaneEmptyArrowheadMirrored.getSymbol());
		rotationSingleFloorPlaneEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-005-01-02-09"),
				rotationSingleFloorPlaneEmptyArrowheadMirrored.getSymbol());

		rotationSingleFloorPlaneSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-005-01-03-16"),
				rotationSingleFloorPlaneSchemaArrowheadMirrored.getSymbol());
		rotationSingleFloorPlaneSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-005-01-03-15"),
				rotationSingleFloorPlaneSchemaArrowheadMirrored.getSymbol());
		rotationSingleFloorPlaneSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-005-01-03-14"),
				rotationSingleFloorPlaneSchemaArrowheadMirrored.getSymbol());
		rotationSingleFloorPlaneSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-005-01-03-13"),
				rotationSingleFloorPlaneSchemaArrowheadMirrored.getSymbol());
		rotationSingleFloorPlaneSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-005-01-03-12"),
				rotationSingleFloorPlaneSchemaArrowheadMirrored.getSymbol());
		rotationSingleFloorPlaneSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-005-01-03-11"),
				rotationSingleFloorPlaneSchemaArrowheadMirrored.getSymbol());
		rotationSingleFloorPlaneSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-005-01-03-10"),
				rotationSingleFloorPlaneSchemaArrowheadMirrored.getSymbol());
		rotationSingleFloorPlaneSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-005-01-03-09"),
				rotationSingleFloorPlaneSchemaArrowheadMirrored.getSymbol());

		rotationDoubleFloorPlane.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-006-01-01-02"), rotationDoubleFloorPlane.getSymbol());
		rotationDoubleFloorPlane.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-006-01-01-03"), rotationDoubleFloorPlane.getSymbol());
		rotationDoubleFloorPlane.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-006-01-01-04"), rotationDoubleFloorPlane.getSymbol());
		rotationDoubleFloorPlane.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-006-01-01-05"), rotationDoubleFloorPlane.getSymbol());
		rotationDoubleFloorPlane.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-006-01-01-06"), rotationDoubleFloorPlane.getSymbol());
		rotationDoubleFloorPlane.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-006-01-01-07"), rotationDoubleFloorPlane.getSymbol());
		rotationDoubleFloorPlane.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-006-01-01-08"), rotationDoubleFloorPlane.getSymbol());
		rotationDoubleFloorPlane.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-006-01-01-01"), rotationDoubleFloorPlane.getSymbol());

		rotationDoubleFloorPlaneEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-006-01-02-02"),
				rotationDoubleFloorPlaneEmptyArrowhead.getSymbol());
		rotationDoubleFloorPlaneEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-006-01-02-03"),
				rotationDoubleFloorPlaneEmptyArrowhead.getSymbol());
		rotationDoubleFloorPlaneEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-006-01-02-04"),
				rotationDoubleFloorPlaneEmptyArrowhead.getSymbol());
		rotationDoubleFloorPlaneEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-006-01-02-05"),
				rotationDoubleFloorPlaneEmptyArrowhead.getSymbol());
		rotationDoubleFloorPlaneEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-006-01-02-06"),
				rotationDoubleFloorPlaneEmptyArrowhead.getSymbol());
		rotationDoubleFloorPlaneEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-006-01-02-07"),
				rotationDoubleFloorPlaneEmptyArrowhead.getSymbol());
		rotationDoubleFloorPlaneEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-006-01-02-08"),
				rotationDoubleFloorPlaneEmptyArrowhead.getSymbol());
		rotationDoubleFloorPlaneEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-006-01-02-01"),
				rotationDoubleFloorPlaneEmptyArrowhead.getSymbol());

		rotationDoubleFloorPlaneSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-006-01-03-02"),
				rotationDoubleFloorPlaneSchemaArrowhead.getSymbol());
		rotationDoubleFloorPlaneSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-006-01-03-03"),
				rotationDoubleFloorPlaneSchemaArrowhead.getSymbol());
		rotationDoubleFloorPlaneSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-006-01-03-04"),
				rotationDoubleFloorPlaneSchemaArrowhead.getSymbol());
		rotationDoubleFloorPlaneSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-006-01-03-05"),
				rotationDoubleFloorPlaneSchemaArrowhead.getSymbol());
		rotationDoubleFloorPlaneSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-006-01-03-06"),
				rotationDoubleFloorPlaneSchemaArrowhead.getSymbol());
		rotationDoubleFloorPlaneSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-006-01-03-07"),
				rotationDoubleFloorPlaneSchemaArrowhead.getSymbol());
		rotationDoubleFloorPlaneSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-006-01-03-08"),
				rotationDoubleFloorPlaneSchemaArrowhead.getSymbol());
		rotationDoubleFloorPlaneSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-006-01-03-01"),
				rotationDoubleFloorPlaneSchemaArrowhead.getSymbol());

		rotationDoubleFloorPlaneMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-006-01-01-16"), rotationDoubleFloorPlaneMirrored.getSymbol());
		rotationDoubleFloorPlaneMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-006-01-01-15"), rotationDoubleFloorPlaneMirrored.getSymbol());
		rotationDoubleFloorPlaneMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-006-01-01-14"), rotationDoubleFloorPlaneMirrored.getSymbol());
		rotationDoubleFloorPlaneMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-006-01-01-13"), rotationDoubleFloorPlaneMirrored.getSymbol());
		rotationDoubleFloorPlaneMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-006-01-01-12"), rotationDoubleFloorPlaneMirrored.getSymbol());
		rotationDoubleFloorPlaneMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-006-01-01-11"), rotationDoubleFloorPlaneMirrored.getSymbol());
		rotationDoubleFloorPlaneMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-006-01-01-10"), rotationDoubleFloorPlaneMirrored.getSymbol());
		rotationDoubleFloorPlaneMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-006-01-01-09"), rotationDoubleFloorPlaneMirrored.getSymbol());

		rotationDoubleFloorPlaneEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-006-01-02-16"),
				rotationDoubleFloorPlaneEmptyArrowheadMirrored.getSymbol());
		rotationDoubleFloorPlaneEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-006-01-02-15"),
				rotationDoubleFloorPlaneEmptyArrowheadMirrored.getSymbol());
		rotationDoubleFloorPlaneEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-006-01-02-14"),
				rotationDoubleFloorPlaneEmptyArrowheadMirrored.getSymbol());
		rotationDoubleFloorPlaneEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-006-01-02-13"),
				rotationDoubleFloorPlaneEmptyArrowheadMirrored.getSymbol());
		rotationDoubleFloorPlaneEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-006-01-02-12"),
				rotationDoubleFloorPlaneEmptyArrowheadMirrored.getSymbol());
		rotationDoubleFloorPlaneEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-006-01-02-11"),
				rotationDoubleFloorPlaneEmptyArrowheadMirrored.getSymbol());
		rotationDoubleFloorPlaneEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-006-01-02-10"),
				rotationDoubleFloorPlaneEmptyArrowheadMirrored.getSymbol());
		rotationDoubleFloorPlaneEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-006-01-02-09"),
				rotationDoubleFloorPlaneEmptyArrowheadMirrored.getSymbol());

		rotationDoubleFloorPlaneSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-006-01-03-16"),
				rotationDoubleFloorPlaneSchemaArrowheadMirrored.getSymbol());
		rotationDoubleFloorPlaneSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-006-01-03-15"),
				rotationDoubleFloorPlaneSchemaArrowheadMirrored.getSymbol());
		rotationDoubleFloorPlaneSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-006-01-03-14"),
				rotationDoubleFloorPlaneSchemaArrowheadMirrored.getSymbol());
		rotationDoubleFloorPlaneSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-006-01-03-13"),
				rotationDoubleFloorPlaneSchemaArrowheadMirrored.getSymbol());
		rotationDoubleFloorPlaneSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-006-01-03-12"),
				rotationDoubleFloorPlaneSchemaArrowheadMirrored.getSymbol());
		rotationDoubleFloorPlaneSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-006-01-03-11"),
				rotationDoubleFloorPlaneSchemaArrowheadMirrored.getSymbol());
		rotationDoubleFloorPlaneSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-006-01-03-10"),
				rotationDoubleFloorPlaneSchemaArrowheadMirrored.getSymbol());
		rotationDoubleFloorPlaneSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-006-01-03-09"),
				rotationDoubleFloorPlaneSchemaArrowheadMirrored.getSymbol());

		rotationAlternatingFloorPlane.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-007-01-01-02"), rotationAlternatingFloorPlane.getSymbol());
		rotationAlternatingFloorPlane.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-007-01-01-03"), rotationAlternatingFloorPlane.getSymbol());
		rotationAlternatingFloorPlane.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-007-01-01-04"), rotationAlternatingFloorPlane.getSymbol());
		rotationAlternatingFloorPlane.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-007-01-01-05"), rotationAlternatingFloorPlane.getSymbol());
		rotationAlternatingFloorPlane.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-007-01-01-06"), rotationAlternatingFloorPlane.getSymbol());
		rotationAlternatingFloorPlane.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-007-01-01-07"), rotationAlternatingFloorPlane.getSymbol());
		rotationAlternatingFloorPlane.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-007-01-01-08"), rotationAlternatingFloorPlane.getSymbol());
		rotationAlternatingFloorPlane.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-007-01-01-01"), rotationAlternatingFloorPlane.getSymbol());

		rotationAlternatingFloorPlaneEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-007-01-02-02"),
				rotationAlternatingFloorPlaneEmptyArrowhead.getSymbol());
		rotationAlternatingFloorPlaneEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-007-01-02-03"),
				rotationAlternatingFloorPlaneEmptyArrowhead.getSymbol());
		rotationAlternatingFloorPlaneEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-007-01-02-04"),
				rotationAlternatingFloorPlaneEmptyArrowhead.getSymbol());
		rotationAlternatingFloorPlaneEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-007-01-02-05"),
				rotationAlternatingFloorPlaneEmptyArrowhead.getSymbol());
		rotationAlternatingFloorPlaneEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-007-01-02-06"),
				rotationAlternatingFloorPlaneEmptyArrowhead.getSymbol());
		rotationAlternatingFloorPlaneEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-007-01-02-07"),
				rotationAlternatingFloorPlaneEmptyArrowhead.getSymbol());
		rotationAlternatingFloorPlaneEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-007-01-02-08"),
				rotationAlternatingFloorPlaneEmptyArrowhead.getSymbol());
		rotationAlternatingFloorPlaneEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-007-01-02-01"),
				rotationAlternatingFloorPlaneEmptyArrowhead.getSymbol());

		rotationAlternatingFloorPlaneSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-007-01-03-02"),
				rotationAlternatingFloorPlaneSchemaArrowhead.getSymbol());
		rotationAlternatingFloorPlaneSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-007-01-03-03"),
				rotationAlternatingFloorPlaneSchemaArrowhead.getSymbol());
		rotationAlternatingFloorPlaneSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-007-01-03-04"),
				rotationAlternatingFloorPlaneSchemaArrowhead.getSymbol());
		rotationAlternatingFloorPlaneSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-007-01-03-05"),
				rotationAlternatingFloorPlaneSchemaArrowhead.getSymbol());
		rotationAlternatingFloorPlaneSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-007-01-03-06"),
				rotationAlternatingFloorPlaneSchemaArrowhead.getSymbol());
		rotationAlternatingFloorPlaneSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-007-01-03-07"),
				rotationAlternatingFloorPlaneSchemaArrowhead.getSymbol());
		rotationAlternatingFloorPlaneSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-007-01-03-08"),
				rotationAlternatingFloorPlaneSchemaArrowhead.getSymbol());
		rotationAlternatingFloorPlaneSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-007-01-03-01"),
				rotationAlternatingFloorPlaneSchemaArrowhead.getSymbol());

		rotationAlternatingFloorPlaneMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-007-01-01-16"),
				rotationAlternatingFloorPlaneMirrored.getSymbol());
		rotationAlternatingFloorPlaneMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-007-01-01-15"),
				rotationAlternatingFloorPlaneMirrored.getSymbol());
		rotationAlternatingFloorPlaneMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-007-01-01-14"),
				rotationAlternatingFloorPlaneMirrored.getSymbol());
		rotationAlternatingFloorPlaneMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-007-01-01-13"),
				rotationAlternatingFloorPlaneMirrored.getSymbol());
		rotationAlternatingFloorPlaneMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-007-01-01-12"),
				rotationAlternatingFloorPlaneMirrored.getSymbol());
		rotationAlternatingFloorPlaneMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-007-01-01-11"),
				rotationAlternatingFloorPlaneMirrored.getSymbol());
		rotationAlternatingFloorPlaneMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-007-01-01-10"),
				rotationAlternatingFloorPlaneMirrored.getSymbol());
		rotationAlternatingFloorPlaneMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-007-01-01-09"),
				rotationAlternatingFloorPlaneMirrored.getSymbol());

		rotationAlternatingFloorPlaneEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-007-01-02-16"),
				rotationAlternatingFloorPlaneEmptyArrowheadMirrored.getSymbol());
		rotationAlternatingFloorPlaneEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-007-01-02-15"),
				rotationAlternatingFloorPlaneEmptyArrowheadMirrored.getSymbol());
		rotationAlternatingFloorPlaneEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-007-01-02-14"),
				rotationAlternatingFloorPlaneEmptyArrowheadMirrored.getSymbol());
		rotationAlternatingFloorPlaneEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-007-01-02-13"),
				rotationAlternatingFloorPlaneEmptyArrowheadMirrored.getSymbol());
		rotationAlternatingFloorPlaneEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-007-01-02-12"),
				rotationAlternatingFloorPlaneEmptyArrowheadMirrored.getSymbol());
		rotationAlternatingFloorPlaneEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-007-01-02-11"),
				rotationAlternatingFloorPlaneEmptyArrowheadMirrored.getSymbol());
		rotationAlternatingFloorPlaneEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-007-01-02-10"),
				rotationAlternatingFloorPlaneEmptyArrowheadMirrored.getSymbol());
		rotationAlternatingFloorPlaneEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-007-01-02-09"),
				rotationAlternatingFloorPlaneEmptyArrowheadMirrored.getSymbol());

		rotationAlternatingFloorPlaneSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-007-01-03-16"),
				rotationAlternatingFloorPlaneSchemaArrowheadMirrored.getSymbol());
		rotationAlternatingFloorPlaneSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-007-01-03-15"),
				rotationAlternatingFloorPlaneSchemaArrowheadMirrored.getSymbol());
		rotationAlternatingFloorPlaneSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-007-01-03-14"),
				rotationAlternatingFloorPlaneSchemaArrowheadMirrored.getSymbol());
		rotationAlternatingFloorPlaneSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-007-01-03-13"),
				rotationAlternatingFloorPlaneSchemaArrowheadMirrored.getSymbol());
		rotationAlternatingFloorPlaneSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-007-01-03-12"),
				rotationAlternatingFloorPlaneSchemaArrowheadMirrored.getSymbol());
		rotationAlternatingFloorPlaneSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-007-01-03-11"),
				rotationAlternatingFloorPlaneSchemaArrowheadMirrored.getSymbol());
		rotationAlternatingFloorPlaneSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-007-01-03-10"),
				rotationAlternatingFloorPlaneSchemaArrowheadMirrored.getSymbol());
		rotationAlternatingFloorPlaneSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-007-01-03-09"),
				rotationAlternatingFloorPlaneSchemaArrowheadMirrored.getSymbol());

		shakingParallelFloor.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-008-01-01-02"), shakingParallelFloor.getSymbol());
		shakingParallelFloor.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-008-01-01-03"), shakingParallelFloor.getSymbol());
		shakingParallelFloor.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-008-01-01-04"), shakingParallelFloor.getSymbol());
		shakingParallelFloor.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-008-01-01-05"), shakingParallelFloor.getSymbol());
		shakingParallelFloor.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-008-01-01-06"), shakingParallelFloor.getSymbol());
		shakingParallelFloor.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-008-01-01-07"), shakingParallelFloor.getSymbol());
		shakingParallelFloor.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-008-01-01-08"), shakingParallelFloor.getSymbol());
		shakingParallelFloor.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-008-01-01-01"), shakingParallelFloor.getSymbol());

		shakingParallelFloorEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-008-01-02-02"), shakingParallelFloorEmptyArrowhead.getSymbol());
		shakingParallelFloorEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-008-01-02-03"), shakingParallelFloorEmptyArrowhead.getSymbol());
		shakingParallelFloorEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-008-01-02-04"), shakingParallelFloorEmptyArrowhead.getSymbol());
		shakingParallelFloorEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-008-01-02-05"), shakingParallelFloorEmptyArrowhead.getSymbol());
		shakingParallelFloorEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-008-01-02-06"), shakingParallelFloorEmptyArrowhead.getSymbol());
		shakingParallelFloorEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-008-01-02-07"), shakingParallelFloorEmptyArrowhead.getSymbol());
		shakingParallelFloorEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-008-01-02-08"), shakingParallelFloorEmptyArrowhead.getSymbol());
		shakingParallelFloorEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-008-01-02-01"), shakingParallelFloorEmptyArrowhead.getSymbol());

		shakingParallelFloorSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-008-01-03-02"), shakingParallelFloorSchemaArrowhead.getSymbol());
		shakingParallelFloorSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-008-01-03-03"), shakingParallelFloorSchemaArrowhead.getSymbol());
		shakingParallelFloorSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-008-01-03-04"), shakingParallelFloorSchemaArrowhead.getSymbol());
		shakingParallelFloorSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-008-01-03-05"), shakingParallelFloorSchemaArrowhead.getSymbol());
		shakingParallelFloorSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-008-01-03-06"), shakingParallelFloorSchemaArrowhead.getSymbol());
		shakingParallelFloorSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-008-01-03-07"), shakingParallelFloorSchemaArrowhead.getSymbol());
		shakingParallelFloorSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-008-01-03-08"), shakingParallelFloorSchemaArrowhead.getSymbol());
		shakingParallelFloorSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-008-01-03-01"), shakingParallelFloorSchemaArrowhead.getSymbol());

		shakingParallelFloorMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-008-01-01-16"), shakingParallelFloorMirrored.getSymbol());
		shakingParallelFloorMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-008-01-01-15"), shakingParallelFloorMirrored.getSymbol());
		shakingParallelFloorMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-008-01-01-14"), shakingParallelFloorMirrored.getSymbol());
		shakingParallelFloorMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-008-01-01-13"), shakingParallelFloorMirrored.getSymbol());
		shakingParallelFloorMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-008-01-01-12"), shakingParallelFloorMirrored.getSymbol());
		shakingParallelFloorMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-008-01-01-11"), shakingParallelFloorMirrored.getSymbol());
		shakingParallelFloorMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-008-01-01-10"), shakingParallelFloorMirrored.getSymbol());
		shakingParallelFloorMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-008-01-01-09"), shakingParallelFloorMirrored.getSymbol());

		shakingParallelFloorEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-008-01-02-16"),
				shakingParallelFloorEmptyArrowheadMirrored.getSymbol());
		shakingParallelFloorEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-008-01-02-15"),
				shakingParallelFloorEmptyArrowheadMirrored.getSymbol());
		shakingParallelFloorEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-008-01-02-14"),
				shakingParallelFloorEmptyArrowheadMirrored.getSymbol());
		shakingParallelFloorEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-008-01-02-13"),
				shakingParallelFloorEmptyArrowheadMirrored.getSymbol());
		shakingParallelFloorEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-008-01-02-12"),
				shakingParallelFloorEmptyArrowheadMirrored.getSymbol());
		shakingParallelFloorEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-008-01-02-11"),
				shakingParallelFloorEmptyArrowheadMirrored.getSymbol());
		shakingParallelFloorEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-008-01-02-10"),
				shakingParallelFloorEmptyArrowheadMirrored.getSymbol());
		shakingParallelFloorEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-008-01-02-09"),
				shakingParallelFloorEmptyArrowheadMirrored.getSymbol());

		shakingParallelFloorSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-008-01-03-16"),
				shakingParallelFloorSchemaArrowheadMirrored.getSymbol());
		shakingParallelFloorSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-008-01-03-15"),
				shakingParallelFloorSchemaArrowheadMirrored.getSymbol());
		shakingParallelFloorSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-008-01-03-14"),
				shakingParallelFloorSchemaArrowheadMirrored.getSymbol());
		shakingParallelFloorSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-008-01-03-13"),
				shakingParallelFloorSchemaArrowheadMirrored.getSymbol());
		shakingParallelFloorSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-008-01-03-12"),
				shakingParallelFloorSchemaArrowheadMirrored.getSymbol());
		shakingParallelFloorSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-008-01-03-11"),
				shakingParallelFloorSchemaArrowheadMirrored.getSymbol());
		shakingParallelFloorSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-008-01-03-10"),
				shakingParallelFloorSchemaArrowheadMirrored.getSymbol());
		shakingParallelFloorSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-09-008-01-03-09"),
				shakingParallelFloorSchemaArrowheadMirrored.getSymbol());

	}

	@Override
	public void testCanMirror() {

		assertTrue(curveFloorPlaneSmall.canMirror());
		assertTrue(curveFloorPlaneSmallEmptyArrowhead.canMirror());
		assertTrue(curveFloorPlaneSmallSchemaArrowhead.canMirror());
		assertTrue(curveFloorPlaneSmallMirrored.canMirror());
		assertTrue(curveFloorPlaneSmallEmptyArrowheadMirrored.canMirror());
		assertTrue(curveFloorPlaneSmallSchemaArrowheadMirrored.canMirror());

		assertTrue(curveFloorPlaneMedium1.canMirror());
		assertTrue(curveFloorPlaneMedium1EmptyArrowhead.canMirror());
		assertTrue(curveFloorPlaneMedium1SchemaArrowhead.canMirror());
		assertTrue(curveFloorPlaneMedium1Mirrored.canMirror());
		assertTrue(curveFloorPlaneMedium1EmptyArrowheadMirrored.canMirror());
		assertTrue(curveFloorPlaneMedium1SchemaArrowheadMirrored.canMirror());

		assertTrue(curveFloorPlaneMedium2.canMirror());
		assertTrue(curveFloorPlaneMedium2EmptyArrowhead.canMirror());
		assertTrue(curveFloorPlaneMedium2SchemaArrowhead.canMirror());
		assertTrue(curveFloorPlaneMedium2Mirrored.canMirror());
		assertTrue(curveFloorPlaneMedium2EmptyArrowheadMirrored.canMirror());
		assertTrue(curveFloorPlaneMedium2SchemaArrowheadMirrored.canMirror());

		assertTrue(curveFloorPlaneLarge.canMirror());
		assertTrue(curveFloorPlaneLargeEmptyArrowhead.canMirror());
		assertTrue(curveFloorPlaneLargeSchemaArrowhead.canMirror());
		assertTrue(curveFloorPlaneLargeMirrored.canMirror());
		assertTrue(curveFloorPlaneLargeEmptyArrowheadMirrored.canMirror());
		assertTrue(curveFloorPlaneLargeSchemaArrowheadMirrored.canMirror());

		assertTrue(curveFloorPlaneCombined.canMirror());
		assertTrue(curveFloorPlaneCombinedEmptyArrowhead.canMirror());
		assertTrue(curveFloorPlaneCombinedSchemaArrowhead.canMirror());
		assertTrue(curveFloorPlaneCombinedMirrored.canMirror());
		assertTrue(curveFloorPlaneCombinedEmptyArrowheadMirrored.canMirror());
		assertTrue(curveFloorPlaneCombinedSchemaArrowheadMirrored.canMirror());

		assertTrue(humpFloorPlaneSmall.canMirror());
		assertTrue(humpFloorPlaneSmallEmptyArrowhead.canMirror());
		assertTrue(humpFloorPlaneSmallSchemaArrowhead.canMirror());
		assertTrue(humpFloorPlaneSmallMirrored.canMirror());
		assertTrue(humpFloorPlaneSmallEmptyArrowheadMirrored.canMirror());
		assertTrue(humpFloorPlaneSmallSchemaArrowheadMirrored.canMirror());

		assertTrue(loopFloorPlaneSmall.canMirror());
		assertTrue(loopFloorPlaneSmallEmptyArrowhead.canMirror());
		assertTrue(loopFloorPlaneSmallSchemaArrowhead.canMirror());
		assertTrue(loopFloorPlaneSmallMirrored.canMirror());
		assertTrue(loopFloorPlaneSmallEmptyArrowheadMirrored.canMirror());
		assertTrue(loopFloorPlaneSmallSchemaArrowheadMirrored.canMirror());

		assertTrue(waveFloorPlaneSnake.canMirror());
		assertTrue(waveFloorPlaneSnakeEmptyArrowhead.canMirror());
		assertTrue(waveFloorPlaneSnakeSchemaArrowhead.canMirror());
		assertTrue(waveFloorPlaneSnakeMirrored.canMirror());
		assertTrue(waveFloorPlaneSnakeEmptyArrowheadMirrored.canMirror());
		assertTrue(waveFloorPlaneSnakeSchemaArrowheadMirrored.canMirror());

		assertTrue(waveFloorPlaneSmall.canMirror());
		assertTrue(waveFloorPlaneSmallEmptyArrowhead.canMirror());
		assertTrue(waveFloorPlaneSmallSchemaArrowhead.canMirror());
		assertTrue(waveFloorPlaneSmallMirrored.canMirror());
		assertTrue(waveFloorPlaneSmallEmptyArrowheadMirrored.canMirror());
		assertTrue(waveFloorPlaneSmallSchemaArrowheadMirrored.canMirror());

		assertTrue(waveFloorPlaneLarge.canMirror());
		assertTrue(waveFloorPlaneLargeEmptyArrowhead.canMirror());
		assertTrue(waveFloorPlaneLargeSchemaArrowhead.canMirror());
		assertTrue(waveFloorPlaneLargeMirrored.canMirror());
		assertTrue(waveFloorPlaneLargeEmptyArrowheadMirrored.canMirror());
		assertTrue(waveFloorPlaneLargeSchemaArrowheadMirrored.canMirror());

		assertTrue(rotationSingleFloorPlane.canMirror());
		assertTrue(rotationSingleFloorPlaneEmptyArrowhead.canMirror());
		assertTrue(rotationSingleFloorPlaneSchemaArrowhead.canMirror());
		assertTrue(rotationSingleFloorPlaneMirrored.canMirror());
		assertTrue(rotationSingleFloorPlaneEmptyArrowheadMirrored.canMirror());
		assertTrue(rotationSingleFloorPlaneSchemaArrowheadMirrored.canMirror());

		assertTrue(rotationDoubleFloorPlane.canMirror());
		assertTrue(rotationDoubleFloorPlaneEmptyArrowhead.canMirror());
		assertTrue(rotationDoubleFloorPlaneSchemaArrowhead.canMirror());
		assertTrue(rotationDoubleFloorPlaneMirrored.canMirror());
		assertTrue(rotationDoubleFloorPlaneEmptyArrowheadMirrored.canMirror());
		assertTrue(rotationDoubleFloorPlaneSchemaArrowheadMirrored.canMirror());

		assertTrue(rotationAlternatingFloorPlane.canMirror());
		assertTrue(rotationAlternatingFloorPlaneEmptyArrowhead.canMirror());
		assertTrue(rotationAlternatingFloorPlaneSchemaArrowhead.canMirror());
		assertTrue(rotationAlternatingFloorPlaneMirrored.canMirror());
		assertTrue(rotationAlternatingFloorPlaneEmptyArrowheadMirrored.canMirror());
		assertTrue(rotationAlternatingFloorPlaneSchemaArrowheadMirrored.canMirror());

		assertTrue(shakingParallelFloor.canMirror());
		assertTrue(shakingParallelFloorEmptyArrowhead.canMirror());
		assertTrue(shakingParallelFloorSchemaArrowhead.canMirror());
		assertTrue(shakingParallelFloorMirrored.canMirror());
		assertTrue(shakingParallelFloorEmptyArrowheadMirrored.canMirror());
		assertTrue(shakingParallelFloorSchemaArrowheadMirrored.canMirror());

	}

	@Override
	public void testMirror() {

		curveFloorPlaneSmall.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-001-01-01-09"), curveFloorPlaneSmall.getSymbol());
		curveFloorPlaneSmall.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-001-01-01-01"), curveFloorPlaneSmall.getSymbol());

		curveFloorPlaneSmallEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-001-01-02-09"), curveFloorPlaneSmallEmptyArrowhead.getSymbol());
		curveFloorPlaneSmallEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-001-01-02-01"), curveFloorPlaneSmallEmptyArrowhead.getSymbol());

		curveFloorPlaneSmallSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-001-01-03-09"), curveFloorPlaneSmallSchemaArrowhead.getSymbol());
		curveFloorPlaneSmallSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-001-01-03-01"), curveFloorPlaneSmallSchemaArrowhead.getSymbol());

		curveFloorPlaneSmallMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-001-01-01-01"), curveFloorPlaneSmallMirrored.getSymbol());
		curveFloorPlaneSmallMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-001-01-01-09"), curveFloorPlaneSmallMirrored.getSymbol());

		curveFloorPlaneSmallEmptyArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-001-01-02-01"),
				curveFloorPlaneSmallEmptyArrowheadMirrored.getSymbol());
		curveFloorPlaneSmallEmptyArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-001-01-02-09"),
				curveFloorPlaneSmallEmptyArrowheadMirrored.getSymbol());

		curveFloorPlaneSmallSchemaArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-001-01-03-01"),
				curveFloorPlaneSmallSchemaArrowheadMirrored.getSymbol());
		curveFloorPlaneSmallSchemaArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-001-01-03-09"),
				curveFloorPlaneSmallSchemaArrowheadMirrored.getSymbol());

		curveFloorPlaneMedium1.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-001-02-01-09"), curveFloorPlaneMedium1.getSymbol());
		curveFloorPlaneMedium1.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-001-02-01-01"), curveFloorPlaneMedium1.getSymbol());

		curveFloorPlaneMedium1EmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-001-02-02-09"),
				curveFloorPlaneMedium1EmptyArrowhead.getSymbol());
		curveFloorPlaneMedium1EmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-001-02-02-01"),
				curveFloorPlaneMedium1EmptyArrowhead.getSymbol());

		curveFloorPlaneMedium1SchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-001-02-03-09"),
				curveFloorPlaneMedium1SchemaArrowhead.getSymbol());
		curveFloorPlaneMedium1SchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-001-02-03-01"),
				curveFloorPlaneMedium1SchemaArrowhead.getSymbol());

		curveFloorPlaneMedium1Mirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-001-02-01-01"), curveFloorPlaneMedium1Mirrored.getSymbol());
		curveFloorPlaneMedium1Mirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-001-02-01-09"), curveFloorPlaneMedium1Mirrored.getSymbol());

		curveFloorPlaneMedium1EmptyArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-001-02-02-01"),
				curveFloorPlaneMedium1EmptyArrowheadMirrored.getSymbol());
		curveFloorPlaneMedium1EmptyArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-001-02-02-09"),
				curveFloorPlaneMedium1EmptyArrowheadMirrored.getSymbol());

		curveFloorPlaneMedium1SchemaArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-001-02-03-01"),
				curveFloorPlaneMedium1SchemaArrowheadMirrored.getSymbol());
		curveFloorPlaneMedium1SchemaArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-001-02-03-09"),
				curveFloorPlaneMedium1SchemaArrowheadMirrored.getSymbol());

		curveFloorPlaneMedium2.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-001-03-01-09"), curveFloorPlaneMedium2.getSymbol());
		curveFloorPlaneMedium2.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-001-03-01-01"), curveFloorPlaneMedium2.getSymbol());

		curveFloorPlaneMedium2EmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-001-03-02-09"),
				curveFloorPlaneMedium2EmptyArrowhead.getSymbol());
		curveFloorPlaneMedium2EmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-001-03-02-01"),
				curveFloorPlaneMedium2EmptyArrowhead.getSymbol());

		curveFloorPlaneMedium2SchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-001-03-03-09"),
				curveFloorPlaneMedium2SchemaArrowhead.getSymbol());
		curveFloorPlaneMedium2SchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-001-03-03-01"),
				curveFloorPlaneMedium2SchemaArrowhead.getSymbol());

		curveFloorPlaneMedium2Mirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-001-03-01-01"), curveFloorPlaneMedium2Mirrored.getSymbol());
		curveFloorPlaneMedium2Mirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-001-03-01-09"), curveFloorPlaneMedium2Mirrored.getSymbol());

		curveFloorPlaneMedium2EmptyArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-001-03-02-01"),
				curveFloorPlaneMedium2EmptyArrowheadMirrored.getSymbol());
		curveFloorPlaneMedium2EmptyArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-001-03-02-09"),
				curveFloorPlaneMedium2EmptyArrowheadMirrored.getSymbol());

		curveFloorPlaneMedium2SchemaArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-001-03-03-01"),
				curveFloorPlaneMedium2SchemaArrowheadMirrored.getSymbol());
		curveFloorPlaneMedium2SchemaArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-001-03-03-09"),
				curveFloorPlaneMedium2SchemaArrowheadMirrored.getSymbol());

		curveFloorPlaneLarge.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-001-04-01-09"), curveFloorPlaneLarge.getSymbol());
		curveFloorPlaneLarge.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-001-04-01-01"), curveFloorPlaneLarge.getSymbol());

		curveFloorPlaneLargeEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-001-04-02-09"), curveFloorPlaneLargeEmptyArrowhead.getSymbol());
		curveFloorPlaneLargeEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-001-04-02-01"), curveFloorPlaneLargeEmptyArrowhead.getSymbol());

		curveFloorPlaneLargeSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-001-04-03-09"), curveFloorPlaneLargeSchemaArrowhead.getSymbol());
		curveFloorPlaneLargeSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-001-04-03-01"), curveFloorPlaneLargeSchemaArrowhead.getSymbol());

		curveFloorPlaneLargeMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-001-04-01-01"), curveFloorPlaneLargeMirrored.getSymbol());
		curveFloorPlaneLargeMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-001-04-01-09"), curveFloorPlaneLargeMirrored.getSymbol());

		curveFloorPlaneLargeEmptyArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-001-04-02-01"),
				curveFloorPlaneLargeEmptyArrowheadMirrored.getSymbol());
		curveFloorPlaneLargeEmptyArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-001-04-02-09"),
				curveFloorPlaneLargeEmptyArrowheadMirrored.getSymbol());

		curveFloorPlaneLargeSchemaArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-001-04-03-01"),
				curveFloorPlaneLargeSchemaArrowheadMirrored.getSymbol());
		curveFloorPlaneLargeSchemaArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-001-04-03-09"),
				curveFloorPlaneLargeSchemaArrowheadMirrored.getSymbol());

		curveFloorPlaneCombined.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-001-05-01-09"), curveFloorPlaneCombined.getSymbol());
		curveFloorPlaneCombined.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-001-05-01-01"), curveFloorPlaneCombined.getSymbol());

		curveFloorPlaneCombinedEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-001-05-02-09"),
				curveFloorPlaneCombinedEmptyArrowhead.getSymbol());
		curveFloorPlaneCombinedEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-001-05-02-01"),
				curveFloorPlaneCombinedEmptyArrowhead.getSymbol());

		curveFloorPlaneCombinedSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-001-05-03-09"),
				curveFloorPlaneCombinedSchemaArrowhead.getSymbol());
		curveFloorPlaneCombinedSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-001-05-03-01"),
				curveFloorPlaneCombinedSchemaArrowhead.getSymbol());

		curveFloorPlaneCombinedMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-001-05-01-01"), curveFloorPlaneCombinedMirrored.getSymbol());
		curveFloorPlaneCombinedMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-001-05-01-09"), curveFloorPlaneCombinedMirrored.getSymbol());

		curveFloorPlaneCombinedEmptyArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-001-05-02-01"),
				curveFloorPlaneCombinedEmptyArrowheadMirrored.getSymbol());
		curveFloorPlaneCombinedEmptyArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-001-05-02-09"),
				curveFloorPlaneCombinedEmptyArrowheadMirrored.getSymbol());

		curveFloorPlaneCombinedSchemaArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-001-05-03-01"),
				curveFloorPlaneCombinedSchemaArrowheadMirrored.getSymbol());
		curveFloorPlaneCombinedSchemaArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-001-05-03-09"),
				curveFloorPlaneCombinedSchemaArrowheadMirrored.getSymbol());

		humpFloorPlaneSmall.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-002-01-01-09"), humpFloorPlaneSmall.getSymbol());
		humpFloorPlaneSmall.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-002-01-01-01"), humpFloorPlaneSmall.getSymbol());

		humpFloorPlaneSmallEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-002-01-02-09"), humpFloorPlaneSmallEmptyArrowhead.getSymbol());
		humpFloorPlaneSmallEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-002-01-02-01"), humpFloorPlaneSmallEmptyArrowhead.getSymbol());

		humpFloorPlaneSmallSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-002-01-03-09"), humpFloorPlaneSmallSchemaArrowhead.getSymbol());
		humpFloorPlaneSmallSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-002-01-03-01"), humpFloorPlaneSmallSchemaArrowhead.getSymbol());

		humpFloorPlaneSmallMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-002-01-01-01"), humpFloorPlaneSmallMirrored.getSymbol());
		humpFloorPlaneSmallMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-002-01-01-09"), humpFloorPlaneSmallMirrored.getSymbol());

		humpFloorPlaneSmallEmptyArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-002-01-02-01"),
				humpFloorPlaneSmallEmptyArrowheadMirrored.getSymbol());
		humpFloorPlaneSmallEmptyArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-002-01-02-09"),
				humpFloorPlaneSmallEmptyArrowheadMirrored.getSymbol());

		humpFloorPlaneSmallSchemaArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-002-01-03-01"),
				humpFloorPlaneSmallSchemaArrowheadMirrored.getSymbol());
		humpFloorPlaneSmallSchemaArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-002-01-03-09"),
				humpFloorPlaneSmallSchemaArrowheadMirrored.getSymbol());

		loopFloorPlaneSmall.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-003-01-01-09"), loopFloorPlaneSmall.getSymbol());
		loopFloorPlaneSmall.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-003-01-01-01"), loopFloorPlaneSmall.getSymbol());

		loopFloorPlaneSmallEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-003-01-02-09"), loopFloorPlaneSmallEmptyArrowhead.getSymbol());
		loopFloorPlaneSmallEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-003-01-02-01"), loopFloorPlaneSmallEmptyArrowhead.getSymbol());

		loopFloorPlaneSmallSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-003-01-03-09"), loopFloorPlaneSmallSchemaArrowhead.getSymbol());
		loopFloorPlaneSmallSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-003-01-03-01"), loopFloorPlaneSmallSchemaArrowhead.getSymbol());

		loopFloorPlaneSmallMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-003-01-01-01"), loopFloorPlaneSmallMirrored.getSymbol());
		loopFloorPlaneSmallMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-003-01-01-09"), loopFloorPlaneSmallMirrored.getSymbol());

		loopFloorPlaneSmallEmptyArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-003-01-02-01"),
				loopFloorPlaneSmallEmptyArrowheadMirrored.getSymbol());
		loopFloorPlaneSmallEmptyArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-003-01-02-09"),
				loopFloorPlaneSmallEmptyArrowheadMirrored.getSymbol());

		loopFloorPlaneSmallSchemaArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-003-01-03-01"),
				loopFloorPlaneSmallSchemaArrowheadMirrored.getSymbol());
		loopFloorPlaneSmallSchemaArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-003-01-03-09"),
				loopFloorPlaneSmallSchemaArrowheadMirrored.getSymbol());

		waveFloorPlaneSnake.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-004-01-01-09"), waveFloorPlaneSnake.getSymbol());
		waveFloorPlaneSnake.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-004-01-01-01"), waveFloorPlaneSnake.getSymbol());

		waveFloorPlaneSnakeEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-004-01-02-09"), waveFloorPlaneSnakeEmptyArrowhead.getSymbol());
		waveFloorPlaneSnakeEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-004-01-02-01"), waveFloorPlaneSnakeEmptyArrowhead.getSymbol());

		waveFloorPlaneSnakeSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-004-01-03-09"), waveFloorPlaneSnakeSchemaArrowhead.getSymbol());
		waveFloorPlaneSnakeSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-004-01-03-01"), waveFloorPlaneSnakeSchemaArrowhead.getSymbol());

		waveFloorPlaneSnakeMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-004-01-01-01"), waveFloorPlaneSnakeMirrored.getSymbol());
		waveFloorPlaneSnakeMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-004-01-01-09"), waveFloorPlaneSnakeMirrored.getSymbol());

		waveFloorPlaneSnakeEmptyArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-004-01-02-01"),
				waveFloorPlaneSnakeEmptyArrowheadMirrored.getSymbol());
		waveFloorPlaneSnakeEmptyArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-004-01-02-09"),
				waveFloorPlaneSnakeEmptyArrowheadMirrored.getSymbol());

		waveFloorPlaneSnakeSchemaArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-004-01-03-01"),
				waveFloorPlaneSnakeSchemaArrowheadMirrored.getSymbol());
		waveFloorPlaneSnakeSchemaArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-004-01-03-09"),
				waveFloorPlaneSnakeSchemaArrowheadMirrored.getSymbol());

		waveFloorPlaneSmall.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-004-02-01-09"), waveFloorPlaneSmall.getSymbol());
		waveFloorPlaneSmall.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-004-02-01-01"), waveFloorPlaneSmall.getSymbol());

		waveFloorPlaneSmallEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-004-02-02-09"), waveFloorPlaneSmallEmptyArrowhead.getSymbol());
		waveFloorPlaneSmallEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-004-02-02-01"), waveFloorPlaneSmallEmptyArrowhead.getSymbol());

		waveFloorPlaneSmallSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-004-02-03-09"), waveFloorPlaneSmallSchemaArrowhead.getSymbol());
		waveFloorPlaneSmallSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-004-02-03-01"), waveFloorPlaneSmallSchemaArrowhead.getSymbol());

		waveFloorPlaneSmallMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-004-02-01-01"), waveFloorPlaneSmallMirrored.getSymbol());
		waveFloorPlaneSmallMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-004-02-01-09"), waveFloorPlaneSmallMirrored.getSymbol());

		waveFloorPlaneSmallEmptyArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-004-02-02-01"),
				waveFloorPlaneSmallEmptyArrowheadMirrored.getSymbol());
		waveFloorPlaneSmallEmptyArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-004-02-02-09"),
				waveFloorPlaneSmallEmptyArrowheadMirrored.getSymbol());

		waveFloorPlaneSmallSchemaArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-004-02-03-01"),
				waveFloorPlaneSmallSchemaArrowheadMirrored.getSymbol());
		waveFloorPlaneSmallSchemaArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-004-02-03-09"),
				waveFloorPlaneSmallSchemaArrowheadMirrored.getSymbol());

		waveFloorPlaneLarge.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-004-03-01-09"), waveFloorPlaneLarge.getSymbol());
		waveFloorPlaneLarge.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-004-03-01-01"), waveFloorPlaneLarge.getSymbol());

		waveFloorPlaneLargeEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-004-03-02-09"), waveFloorPlaneLargeEmptyArrowhead.getSymbol());
		waveFloorPlaneLargeEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-004-03-02-01"), waveFloorPlaneLargeEmptyArrowhead.getSymbol());

		waveFloorPlaneLargeSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-004-03-03-09"), waveFloorPlaneLargeSchemaArrowhead.getSymbol());
		waveFloorPlaneLargeSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-004-03-03-01"), waveFloorPlaneLargeSchemaArrowhead.getSymbol());

		waveFloorPlaneLargeMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-004-03-01-01"), waveFloorPlaneLargeMirrored.getSymbol());
		waveFloorPlaneLargeMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-004-03-01-09"), waveFloorPlaneLargeMirrored.getSymbol());

		waveFloorPlaneLargeEmptyArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-004-03-02-01"),
				waveFloorPlaneLargeEmptyArrowheadMirrored.getSymbol());
		waveFloorPlaneLargeEmptyArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-004-03-02-09"),
				waveFloorPlaneLargeEmptyArrowheadMirrored.getSymbol());

		waveFloorPlaneLargeSchemaArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-004-03-03-01"),
				waveFloorPlaneLargeSchemaArrowheadMirrored.getSymbol());
		waveFloorPlaneLargeSchemaArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-004-03-03-09"),
				waveFloorPlaneLargeSchemaArrowheadMirrored.getSymbol());

		rotationSingleFloorPlane.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-005-01-01-09"), rotationSingleFloorPlane.getSymbol());
		rotationSingleFloorPlane.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-005-01-01-01"), rotationSingleFloorPlane.getSymbol());

		rotationSingleFloorPlaneEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-005-01-02-09"),
				rotationSingleFloorPlaneEmptyArrowhead.getSymbol());
		rotationSingleFloorPlaneEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-005-01-02-01"),
				rotationSingleFloorPlaneEmptyArrowhead.getSymbol());

		rotationSingleFloorPlaneSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-005-01-03-09"),
				rotationSingleFloorPlaneSchemaArrowhead.getSymbol());
		rotationSingleFloorPlaneSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-005-01-03-01"),
				rotationSingleFloorPlaneSchemaArrowhead.getSymbol());

		rotationSingleFloorPlaneMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-005-01-01-01"), rotationSingleFloorPlaneMirrored.getSymbol());
		rotationSingleFloorPlaneMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-005-01-01-09"), rotationSingleFloorPlaneMirrored.getSymbol());

		rotationSingleFloorPlaneEmptyArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-005-01-02-01"),
				rotationSingleFloorPlaneEmptyArrowheadMirrored.getSymbol());
		rotationSingleFloorPlaneEmptyArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-005-01-02-09"),
				rotationSingleFloorPlaneEmptyArrowheadMirrored.getSymbol());

		rotationSingleFloorPlaneSchemaArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-005-01-03-01"),
				rotationSingleFloorPlaneSchemaArrowheadMirrored.getSymbol());
		rotationSingleFloorPlaneSchemaArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-005-01-03-09"),
				rotationSingleFloorPlaneSchemaArrowheadMirrored.getSymbol());

		rotationDoubleFloorPlane.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-006-01-01-09"), rotationDoubleFloorPlane.getSymbol());
		rotationDoubleFloorPlane.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-006-01-01-01"), rotationDoubleFloorPlane.getSymbol());

		rotationDoubleFloorPlaneEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-006-01-02-09"),
				rotationDoubleFloorPlaneEmptyArrowhead.getSymbol());
		rotationDoubleFloorPlaneEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-006-01-02-01"),
				rotationDoubleFloorPlaneEmptyArrowhead.getSymbol());

		rotationDoubleFloorPlaneSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-006-01-03-09"),
				rotationDoubleFloorPlaneSchemaArrowhead.getSymbol());
		rotationDoubleFloorPlaneSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-006-01-03-01"),
				rotationDoubleFloorPlaneSchemaArrowhead.getSymbol());

		rotationDoubleFloorPlaneMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-006-01-01-01"), rotationDoubleFloorPlaneMirrored.getSymbol());
		rotationDoubleFloorPlaneMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-006-01-01-09"), rotationDoubleFloorPlaneMirrored.getSymbol());

		rotationDoubleFloorPlaneEmptyArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-006-01-02-01"),
				rotationDoubleFloorPlaneEmptyArrowheadMirrored.getSymbol());
		rotationDoubleFloorPlaneEmptyArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-006-01-02-09"),
				rotationDoubleFloorPlaneEmptyArrowheadMirrored.getSymbol());

		rotationDoubleFloorPlaneSchemaArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-006-01-03-01"),
				rotationDoubleFloorPlaneSchemaArrowheadMirrored.getSymbol());
		rotationDoubleFloorPlaneSchemaArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-006-01-03-09"),
				rotationDoubleFloorPlaneSchemaArrowheadMirrored.getSymbol());

		rotationAlternatingFloorPlane.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-007-01-01-09"), rotationAlternatingFloorPlane.getSymbol());
		rotationAlternatingFloorPlane.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-007-01-01-01"), rotationAlternatingFloorPlane.getSymbol());

		rotationAlternatingFloorPlaneEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-007-01-02-09"),
				rotationAlternatingFloorPlaneEmptyArrowhead.getSymbol());
		rotationAlternatingFloorPlaneEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-007-01-02-01"),
				rotationAlternatingFloorPlaneEmptyArrowhead.getSymbol());

		rotationAlternatingFloorPlaneSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-007-01-03-09"),
				rotationAlternatingFloorPlaneSchemaArrowhead.getSymbol());
		rotationAlternatingFloorPlaneSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-007-01-03-01"),
				rotationAlternatingFloorPlaneSchemaArrowhead.getSymbol());

		rotationAlternatingFloorPlaneMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-007-01-01-01"),
				rotationAlternatingFloorPlaneMirrored.getSymbol());
		rotationAlternatingFloorPlaneMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-007-01-01-09"),
				rotationAlternatingFloorPlaneMirrored.getSymbol());

		rotationAlternatingFloorPlaneEmptyArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-007-01-02-01"),
				rotationAlternatingFloorPlaneEmptyArrowheadMirrored.getSymbol());
		rotationAlternatingFloorPlaneEmptyArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-007-01-02-09"),
				rotationAlternatingFloorPlaneEmptyArrowheadMirrored.getSymbol());

		rotationAlternatingFloorPlaneSchemaArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-007-01-03-01"),
				rotationAlternatingFloorPlaneSchemaArrowheadMirrored.getSymbol());
		rotationAlternatingFloorPlaneSchemaArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-007-01-03-09"),
				rotationAlternatingFloorPlaneSchemaArrowheadMirrored.getSymbol());

		shakingParallelFloor.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-008-01-01-09"), shakingParallelFloor.getSymbol());
		shakingParallelFloor.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-008-01-01-01"), shakingParallelFloor.getSymbol());

		shakingParallelFloorEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-008-01-02-09"), shakingParallelFloorEmptyArrowhead.getSymbol());
		shakingParallelFloorEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-008-01-02-01"), shakingParallelFloorEmptyArrowhead.getSymbol());

		shakingParallelFloorSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-008-01-03-09"), shakingParallelFloorSchemaArrowhead.getSymbol());
		shakingParallelFloorSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-008-01-03-01"), shakingParallelFloorSchemaArrowhead.getSymbol());

		shakingParallelFloorMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-008-01-01-01"), shakingParallelFloorMirrored.getSymbol());
		shakingParallelFloorMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-008-01-01-09"), shakingParallelFloorMirrored.getSymbol());

		shakingParallelFloorEmptyArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-008-01-02-01"),
				shakingParallelFloorEmptyArrowheadMirrored.getSymbol());
		shakingParallelFloorEmptyArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-008-01-02-09"),
				shakingParallelFloorEmptyArrowheadMirrored.getSymbol());

		shakingParallelFloorSchemaArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-008-01-03-01"),
				shakingParallelFloorSchemaArrowheadMirrored.getSymbol());
		shakingParallelFloorSchemaArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-09-008-01-03-09"),
				shakingParallelFloorSchemaArrowheadMirrored.getSymbol());

	}

	@Override
	public void testCanMirrorVertically() {

		assertTrue(curveFloorPlaneSmall.canMirrorVertically());
		assertTrue(curveFloorPlaneSmallEmptyArrowhead.canMirrorVertically());
		assertTrue(curveFloorPlaneSmallSchemaArrowhead.canMirrorVertically());
		assertTrue(curveFloorPlaneSmallMirrored.canMirrorVertically());
		assertTrue(curveFloorPlaneSmallEmptyArrowheadMirrored.canMirrorVertically());
		assertTrue(curveFloorPlaneSmallSchemaArrowheadMirrored.canMirrorVertically());

		assertTrue(curveFloorPlaneMedium1.canMirrorVertically());
		assertTrue(curveFloorPlaneMedium1EmptyArrowhead.canMirrorVertically());
		assertTrue(curveFloorPlaneMedium1SchemaArrowhead.canMirrorVertically());
		assertTrue(curveFloorPlaneMedium1Mirrored.canMirrorVertically());
		assertTrue(curveFloorPlaneMedium1EmptyArrowheadMirrored.canMirrorVertically());
		assertTrue(curveFloorPlaneMedium1SchemaArrowheadMirrored.canMirrorVertically());

		assertTrue(curveFloorPlaneMedium2.canMirrorVertically());
		assertTrue(curveFloorPlaneMedium2EmptyArrowhead.canMirrorVertically());
		assertTrue(curveFloorPlaneMedium2SchemaArrowhead.canMirrorVertically());
		assertTrue(curveFloorPlaneMedium2Mirrored.canMirrorVertically());
		assertTrue(curveFloorPlaneMedium2EmptyArrowheadMirrored.canMirrorVertically());
		assertTrue(curveFloorPlaneMedium2SchemaArrowheadMirrored.canMirrorVertically());

		assertTrue(curveFloorPlaneLarge.canMirrorVertically());
		assertTrue(curveFloorPlaneLargeEmptyArrowhead.canMirrorVertically());
		assertTrue(curveFloorPlaneLargeSchemaArrowhead.canMirrorVertically());
		assertTrue(curveFloorPlaneLargeMirrored.canMirrorVertically());
		assertTrue(curveFloorPlaneLargeEmptyArrowheadMirrored.canMirrorVertically());
		assertTrue(curveFloorPlaneLargeSchemaArrowheadMirrored.canMirrorVertically());

		assertFalse(curveFloorPlaneCombined.canMirrorVertically());
		assertFalse(curveFloorPlaneCombinedEmptyArrowhead.canMirrorVertically());
		assertFalse(curveFloorPlaneCombinedSchemaArrowhead.canMirrorVertically());
		assertFalse(curveFloorPlaneCombinedMirrored.canMirrorVertically());
		assertFalse(curveFloorPlaneCombinedEmptyArrowheadMirrored.canMirrorVertically());
		assertFalse(curveFloorPlaneCombinedSchemaArrowheadMirrored.canMirrorVertically());

		assertTrue(humpFloorPlaneSmall.canMirrorVertically());
		assertTrue(humpFloorPlaneSmallEmptyArrowhead.canMirrorVertically());
		assertTrue(humpFloorPlaneSmallSchemaArrowhead.canMirrorVertically());
		assertTrue(humpFloorPlaneSmallMirrored.canMirrorVertically());
		assertTrue(humpFloorPlaneSmallEmptyArrowheadMirrored.canMirrorVertically());
		assertTrue(humpFloorPlaneSmallSchemaArrowheadMirrored.canMirrorVertically());

		assertTrue(loopFloorPlaneSmall.canMirrorVertically());
		assertTrue(loopFloorPlaneSmallEmptyArrowhead.canMirrorVertically());
		assertTrue(loopFloorPlaneSmallSchemaArrowhead.canMirrorVertically());
		assertTrue(loopFloorPlaneSmallMirrored.canMirrorVertically());
		assertTrue(loopFloorPlaneSmallEmptyArrowheadMirrored.canMirrorVertically());
		assertTrue(loopFloorPlaneSmallSchemaArrowheadMirrored.canMirrorVertically());

		assertTrue(waveFloorPlaneSnake.canMirrorVertically());
		assertTrue(waveFloorPlaneSnakeEmptyArrowhead.canMirrorVertically());
		assertTrue(waveFloorPlaneSnakeSchemaArrowhead.canMirrorVertically());
		assertTrue(waveFloorPlaneSnakeMirrored.canMirrorVertically());
		assertTrue(waveFloorPlaneSnakeEmptyArrowheadMirrored.canMirrorVertically());
		assertTrue(waveFloorPlaneSnakeSchemaArrowheadMirrored.canMirrorVertically());

		assertTrue(waveFloorPlaneSmall.canMirrorVertically());
		assertTrue(waveFloorPlaneSmallEmptyArrowhead.canMirrorVertically());
		assertTrue(waveFloorPlaneSmallSchemaArrowhead.canMirrorVertically());
		assertTrue(waveFloorPlaneSmallMirrored.canMirrorVertically());
		assertTrue(waveFloorPlaneSmallEmptyArrowheadMirrored.canMirrorVertically());
		assertTrue(waveFloorPlaneSmallSchemaArrowheadMirrored.canMirrorVertically());

		assertTrue(waveFloorPlaneLarge.canMirrorVertically());
		assertTrue(waveFloorPlaneLargeEmptyArrowhead.canMirrorVertically());
		assertTrue(waveFloorPlaneLargeSchemaArrowhead.canMirrorVertically());
		assertTrue(waveFloorPlaneLargeMirrored.canMirrorVertically());
		assertTrue(waveFloorPlaneLargeEmptyArrowheadMirrored.canMirrorVertically());
		assertTrue(waveFloorPlaneLargeSchemaArrowheadMirrored.canMirrorVertically());

		assertTrue(rotationSingleFloorPlane.canMirrorVertically());
		assertTrue(rotationSingleFloorPlaneEmptyArrowhead.canMirrorVertically());
		assertTrue(rotationSingleFloorPlaneSchemaArrowhead.canMirrorVertically());
		assertTrue(rotationSingleFloorPlaneMirrored.canMirrorVertically());
		assertTrue(rotationSingleFloorPlaneEmptyArrowheadMirrored.canMirrorVertically());
		assertTrue(rotationSingleFloorPlaneSchemaArrowheadMirrored.canMirrorVertically());

		assertTrue(rotationDoubleFloorPlane.canMirrorVertically());
		assertTrue(rotationDoubleFloorPlaneEmptyArrowhead.canMirrorVertically());
		assertTrue(rotationDoubleFloorPlaneSchemaArrowhead.canMirrorVertically());
		assertTrue(rotationDoubleFloorPlaneMirrored.canMirrorVertically());
		assertTrue(rotationDoubleFloorPlaneEmptyArrowheadMirrored.canMirrorVertically());
		assertTrue(rotationDoubleFloorPlaneSchemaArrowheadMirrored.canMirrorVertically());

		assertTrue(rotationAlternatingFloorPlane.canMirrorVertically());
		assertTrue(rotationAlternatingFloorPlaneEmptyArrowhead.canMirrorVertically());
		assertTrue(rotationAlternatingFloorPlaneSchemaArrowhead.canMirrorVertically());
		assertTrue(rotationAlternatingFloorPlaneMirrored.canMirrorVertically());
		assertTrue(rotationAlternatingFloorPlaneEmptyArrowheadMirrored.canMirrorVertically());
		assertTrue(rotationAlternatingFloorPlaneSchemaArrowheadMirrored.canMirrorVertically());

		assertTrue(shakingParallelFloor.canMirrorVertically());
		assertTrue(shakingParallelFloorEmptyArrowhead.canMirrorVertically());
		assertTrue(shakingParallelFloorSchemaArrowhead.canMirrorVertically());
		assertTrue(shakingParallelFloorMirrored.canMirrorVertically());
		assertTrue(shakingParallelFloorEmptyArrowheadMirrored.canMirrorVertically());
		assertTrue(shakingParallelFloorSchemaArrowheadMirrored.canMirrorVertically());

	}

	@Override
	public void testMirrorVertically() {

		curveFloorPlaneSmall.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-001-01-01-13"), curveFloorPlaneSmall.getSymbol());
		curveFloorPlaneSmall.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-001-01-01-01"), curveFloorPlaneSmall.getSymbol());

		curveFloorPlaneSmallEmptyArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-001-01-02-13"), curveFloorPlaneSmallEmptyArrowhead.getSymbol());
		curveFloorPlaneSmallEmptyArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-001-01-02-01"), curveFloorPlaneSmallEmptyArrowhead.getSymbol());

		curveFloorPlaneSmallSchemaArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-001-01-03-13"), curveFloorPlaneSmallSchemaArrowhead.getSymbol());
		curveFloorPlaneSmallSchemaArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-001-01-03-01"), curveFloorPlaneSmallSchemaArrowhead.getSymbol());

		curveFloorPlaneSmallMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-001-01-01-05"), curveFloorPlaneSmallMirrored.getSymbol());
		curveFloorPlaneSmallMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-001-01-01-09"), curveFloorPlaneSmallMirrored.getSymbol());

		curveFloorPlaneSmallEmptyArrowheadMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-001-01-02-05"),
				curveFloorPlaneSmallEmptyArrowheadMirrored.getSymbol());
		curveFloorPlaneSmallEmptyArrowheadMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-001-01-02-09"),
				curveFloorPlaneSmallEmptyArrowheadMirrored.getSymbol());

		curveFloorPlaneSmallSchemaArrowheadMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-001-01-03-05"),
				curveFloorPlaneSmallSchemaArrowheadMirrored.getSymbol());
		curveFloorPlaneSmallSchemaArrowheadMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-001-01-03-09"),
				curveFloorPlaneSmallSchemaArrowheadMirrored.getSymbol());

		curveFloorPlaneMedium1.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-001-02-01-13"), curveFloorPlaneMedium1.getSymbol());
		curveFloorPlaneMedium1.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-001-02-01-01"), curveFloorPlaneMedium1.getSymbol());

		curveFloorPlaneMedium1EmptyArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-001-02-02-13"),
				curveFloorPlaneMedium1EmptyArrowhead.getSymbol());
		curveFloorPlaneMedium1EmptyArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-001-02-02-01"),
				curveFloorPlaneMedium1EmptyArrowhead.getSymbol());

		curveFloorPlaneMedium1SchemaArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-001-02-03-13"),
				curveFloorPlaneMedium1SchemaArrowhead.getSymbol());
		curveFloorPlaneMedium1SchemaArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-001-02-03-01"),
				curveFloorPlaneMedium1SchemaArrowhead.getSymbol());

		curveFloorPlaneMedium1Mirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-001-02-01-05"), curveFloorPlaneMedium1Mirrored.getSymbol());
		curveFloorPlaneMedium1Mirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-001-02-01-09"), curveFloorPlaneMedium1Mirrored.getSymbol());

		curveFloorPlaneMedium1EmptyArrowheadMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-001-02-02-05"),
				curveFloorPlaneMedium1EmptyArrowheadMirrored.getSymbol());
		curveFloorPlaneMedium1EmptyArrowheadMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-001-02-02-09"),
				curveFloorPlaneMedium1EmptyArrowheadMirrored.getSymbol());

		curveFloorPlaneMedium1SchemaArrowheadMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-001-02-03-05"),
				curveFloorPlaneMedium1SchemaArrowheadMirrored.getSymbol());
		curveFloorPlaneMedium1SchemaArrowheadMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-001-02-03-09"),
				curveFloorPlaneMedium1SchemaArrowheadMirrored.getSymbol());

		curveFloorPlaneMedium2.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-001-03-01-13"), curveFloorPlaneMedium2.getSymbol());
		curveFloorPlaneMedium2.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-001-03-01-01"), curveFloorPlaneMedium2.getSymbol());

		curveFloorPlaneMedium2EmptyArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-001-03-02-13"),
				curveFloorPlaneMedium2EmptyArrowhead.getSymbol());
		curveFloorPlaneMedium2EmptyArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-001-03-02-01"),
				curveFloorPlaneMedium2EmptyArrowhead.getSymbol());

		curveFloorPlaneMedium2SchemaArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-001-03-03-13"),
				curveFloorPlaneMedium2SchemaArrowhead.getSymbol());
		curveFloorPlaneMedium2SchemaArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-001-03-03-01"),
				curveFloorPlaneMedium2SchemaArrowhead.getSymbol());

		curveFloorPlaneMedium2Mirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-001-03-01-05"), curveFloorPlaneMedium2Mirrored.getSymbol());
		curveFloorPlaneMedium2Mirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-001-03-01-09"), curveFloorPlaneMedium2Mirrored.getSymbol());

		curveFloorPlaneMedium2EmptyArrowheadMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-001-03-02-05"),
				curveFloorPlaneMedium2EmptyArrowheadMirrored.getSymbol());
		curveFloorPlaneMedium2EmptyArrowheadMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-001-03-02-09"),
				curveFloorPlaneMedium2EmptyArrowheadMirrored.getSymbol());

		curveFloorPlaneMedium2SchemaArrowheadMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-001-03-03-05"),
				curveFloorPlaneMedium2SchemaArrowheadMirrored.getSymbol());
		curveFloorPlaneMedium2SchemaArrowheadMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-001-03-03-09"),
				curveFloorPlaneMedium2SchemaArrowheadMirrored.getSymbol());

		curveFloorPlaneLarge.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-001-04-01-13"), curveFloorPlaneLarge.getSymbol());
		curveFloorPlaneLarge.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-001-04-01-01"), curveFloorPlaneLarge.getSymbol());

		curveFloorPlaneLargeEmptyArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-001-04-02-13"), curveFloorPlaneLargeEmptyArrowhead.getSymbol());
		curveFloorPlaneLargeEmptyArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-001-04-02-01"), curveFloorPlaneLargeEmptyArrowhead.getSymbol());

		curveFloorPlaneLargeSchemaArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-001-04-03-13"), curveFloorPlaneLargeSchemaArrowhead.getSymbol());
		curveFloorPlaneLargeSchemaArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-001-04-03-01"), curveFloorPlaneLargeSchemaArrowhead.getSymbol());

		curveFloorPlaneLargeMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-001-04-01-05"), curveFloorPlaneLargeMirrored.getSymbol());
		curveFloorPlaneLargeMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-001-04-01-09"), curveFloorPlaneLargeMirrored.getSymbol());

		curveFloorPlaneLargeEmptyArrowheadMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-001-04-02-05"),
				curveFloorPlaneLargeEmptyArrowheadMirrored.getSymbol());
		curveFloorPlaneLargeEmptyArrowheadMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-001-04-02-09"),
				curveFloorPlaneLargeEmptyArrowheadMirrored.getSymbol());

		curveFloorPlaneLargeSchemaArrowheadMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-001-04-03-05"),
				curveFloorPlaneLargeSchemaArrowheadMirrored.getSymbol());
		curveFloorPlaneLargeSchemaArrowheadMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-001-04-03-09"),
				curveFloorPlaneLargeSchemaArrowheadMirrored.getSymbol());

		humpFloorPlaneSmall.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-002-01-01-13"), humpFloorPlaneSmall.getSymbol());
		humpFloorPlaneSmall.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-002-01-01-01"), humpFloorPlaneSmall.getSymbol());

		humpFloorPlaneSmallEmptyArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-002-01-02-13"), humpFloorPlaneSmallEmptyArrowhead.getSymbol());
		humpFloorPlaneSmallEmptyArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-002-01-02-01"), humpFloorPlaneSmallEmptyArrowhead.getSymbol());

		humpFloorPlaneSmallSchemaArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-002-01-03-13"), humpFloorPlaneSmallSchemaArrowhead.getSymbol());
		humpFloorPlaneSmallSchemaArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-002-01-03-01"), humpFloorPlaneSmallSchemaArrowhead.getSymbol());

		humpFloorPlaneSmallMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-002-01-01-05"), humpFloorPlaneSmallMirrored.getSymbol());
		humpFloorPlaneSmallMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-002-01-01-09"), humpFloorPlaneSmallMirrored.getSymbol());

		humpFloorPlaneSmallEmptyArrowheadMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-002-01-02-05"),
				humpFloorPlaneSmallEmptyArrowheadMirrored.getSymbol());
		humpFloorPlaneSmallEmptyArrowheadMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-002-01-02-09"),
				humpFloorPlaneSmallEmptyArrowheadMirrored.getSymbol());

		humpFloorPlaneSmallSchemaArrowheadMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-002-01-03-05"),
				humpFloorPlaneSmallSchemaArrowheadMirrored.getSymbol());
		humpFloorPlaneSmallSchemaArrowheadMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-002-01-03-09"),
				humpFloorPlaneSmallSchemaArrowheadMirrored.getSymbol());

		loopFloorPlaneSmall.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-003-01-01-13"), loopFloorPlaneSmall.getSymbol());
		loopFloorPlaneSmall.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-003-01-01-01"), loopFloorPlaneSmall.getSymbol());

		loopFloorPlaneSmallEmptyArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-003-01-02-13"), loopFloorPlaneSmallEmptyArrowhead.getSymbol());
		loopFloorPlaneSmallEmptyArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-003-01-02-01"), loopFloorPlaneSmallEmptyArrowhead.getSymbol());

		loopFloorPlaneSmallSchemaArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-003-01-03-13"), loopFloorPlaneSmallSchemaArrowhead.getSymbol());
		loopFloorPlaneSmallSchemaArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-003-01-03-01"), loopFloorPlaneSmallSchemaArrowhead.getSymbol());

		loopFloorPlaneSmallMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-003-01-01-05"), loopFloorPlaneSmallMirrored.getSymbol());
		loopFloorPlaneSmallMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-003-01-01-09"), loopFloorPlaneSmallMirrored.getSymbol());

		loopFloorPlaneSmallEmptyArrowheadMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-003-01-02-05"),
				loopFloorPlaneSmallEmptyArrowheadMirrored.getSymbol());
		loopFloorPlaneSmallEmptyArrowheadMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-003-01-02-09"),
				loopFloorPlaneSmallEmptyArrowheadMirrored.getSymbol());

		loopFloorPlaneSmallSchemaArrowheadMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-003-01-03-05"),
				loopFloorPlaneSmallSchemaArrowheadMirrored.getSymbol());
		loopFloorPlaneSmallSchemaArrowheadMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-003-01-03-09"),
				loopFloorPlaneSmallSchemaArrowheadMirrored.getSymbol());

		waveFloorPlaneSnake.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-004-01-01-13"), waveFloorPlaneSnake.getSymbol());
		waveFloorPlaneSnake.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-004-01-01-01"), waveFloorPlaneSnake.getSymbol());

		waveFloorPlaneSnakeEmptyArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-004-01-02-13"), waveFloorPlaneSnakeEmptyArrowhead.getSymbol());
		waveFloorPlaneSnakeEmptyArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-004-01-02-01"), waveFloorPlaneSnakeEmptyArrowhead.getSymbol());

		waveFloorPlaneSnakeSchemaArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-004-01-03-13"), waveFloorPlaneSnakeSchemaArrowhead.getSymbol());
		waveFloorPlaneSnakeSchemaArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-004-01-03-01"), waveFloorPlaneSnakeSchemaArrowhead.getSymbol());

		waveFloorPlaneSnakeMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-004-01-01-05"), waveFloorPlaneSnakeMirrored.getSymbol());
		waveFloorPlaneSnakeMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-004-01-01-09"), waveFloorPlaneSnakeMirrored.getSymbol());

		waveFloorPlaneSnakeEmptyArrowheadMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-004-01-02-05"),
				waveFloorPlaneSnakeEmptyArrowheadMirrored.getSymbol());
		waveFloorPlaneSnakeEmptyArrowheadMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-004-01-02-09"),
				waveFloorPlaneSnakeEmptyArrowheadMirrored.getSymbol());

		waveFloorPlaneSnakeSchemaArrowheadMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-004-01-03-05"),
				waveFloorPlaneSnakeSchemaArrowheadMirrored.getSymbol());
		waveFloorPlaneSnakeSchemaArrowheadMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-004-01-03-09"),
				waveFloorPlaneSnakeSchemaArrowheadMirrored.getSymbol());

		waveFloorPlaneSmall.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-004-02-01-13"), waveFloorPlaneSmall.getSymbol());
		waveFloorPlaneSmall.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-004-02-01-01"), waveFloorPlaneSmall.getSymbol());

		waveFloorPlaneSmallEmptyArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-004-02-02-13"), waveFloorPlaneSmallEmptyArrowhead.getSymbol());
		waveFloorPlaneSmallEmptyArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-004-02-02-01"), waveFloorPlaneSmallEmptyArrowhead.getSymbol());

		waveFloorPlaneSmallSchemaArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-004-02-03-13"), waveFloorPlaneSmallSchemaArrowhead.getSymbol());
		waveFloorPlaneSmallSchemaArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-004-02-03-01"), waveFloorPlaneSmallSchemaArrowhead.getSymbol());

		waveFloorPlaneSmallMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-004-02-01-05"), waveFloorPlaneSmallMirrored.getSymbol());
		waveFloorPlaneSmallMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-004-02-01-09"), waveFloorPlaneSmallMirrored.getSymbol());

		waveFloorPlaneSmallEmptyArrowheadMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-004-02-02-05"),
				waveFloorPlaneSmallEmptyArrowheadMirrored.getSymbol());
		waveFloorPlaneSmallEmptyArrowheadMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-004-02-02-09"),
				waveFloorPlaneSmallEmptyArrowheadMirrored.getSymbol());

		waveFloorPlaneSmallSchemaArrowheadMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-004-02-03-05"),
				waveFloorPlaneSmallSchemaArrowheadMirrored.getSymbol());
		waveFloorPlaneSmallSchemaArrowheadMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-004-02-03-09"),
				waveFloorPlaneSmallSchemaArrowheadMirrored.getSymbol());

		waveFloorPlaneLarge.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-004-03-01-13"), waveFloorPlaneLarge.getSymbol());
		waveFloorPlaneLarge.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-004-03-01-01"), waveFloorPlaneLarge.getSymbol());

		waveFloorPlaneLargeEmptyArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-004-03-02-13"), waveFloorPlaneLargeEmptyArrowhead.getSymbol());
		waveFloorPlaneLargeEmptyArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-004-03-02-01"), waveFloorPlaneLargeEmptyArrowhead.getSymbol());

		waveFloorPlaneLargeSchemaArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-004-03-03-13"), waveFloorPlaneLargeSchemaArrowhead.getSymbol());
		waveFloorPlaneLargeSchemaArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-004-03-03-01"), waveFloorPlaneLargeSchemaArrowhead.getSymbol());

		waveFloorPlaneLargeMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-004-03-01-05"), waveFloorPlaneLargeMirrored.getSymbol());
		waveFloorPlaneLargeMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-004-03-01-09"), waveFloorPlaneLargeMirrored.getSymbol());

		waveFloorPlaneLargeEmptyArrowheadMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-004-03-02-05"),
				waveFloorPlaneLargeEmptyArrowheadMirrored.getSymbol());
		waveFloorPlaneLargeEmptyArrowheadMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-004-03-02-09"),
				waveFloorPlaneLargeEmptyArrowheadMirrored.getSymbol());

		waveFloorPlaneLargeSchemaArrowheadMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-004-03-03-05"),
				waveFloorPlaneLargeSchemaArrowheadMirrored.getSymbol());
		waveFloorPlaneLargeSchemaArrowheadMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-004-03-03-09"),
				waveFloorPlaneLargeSchemaArrowheadMirrored.getSymbol());

		rotationSingleFloorPlane.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-005-01-01-13"), rotationSingleFloorPlane.getSymbol());
		rotationSingleFloorPlane.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-005-01-01-01"), rotationSingleFloorPlane.getSymbol());

		rotationSingleFloorPlaneEmptyArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-005-01-02-13"),
				rotationSingleFloorPlaneEmptyArrowhead.getSymbol());
		rotationSingleFloorPlaneEmptyArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-005-01-02-01"),
				rotationSingleFloorPlaneEmptyArrowhead.getSymbol());

		rotationSingleFloorPlaneSchemaArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-005-01-03-13"),
				rotationSingleFloorPlaneSchemaArrowhead.getSymbol());
		rotationSingleFloorPlaneSchemaArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-005-01-03-01"),
				rotationSingleFloorPlaneSchemaArrowhead.getSymbol());

		rotationSingleFloorPlaneMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-005-01-01-05"), rotationSingleFloorPlaneMirrored.getSymbol());
		rotationSingleFloorPlaneMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-005-01-01-09"), rotationSingleFloorPlaneMirrored.getSymbol());

		rotationSingleFloorPlaneEmptyArrowheadMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-005-01-02-05"),
				rotationSingleFloorPlaneEmptyArrowheadMirrored.getSymbol());
		rotationSingleFloorPlaneEmptyArrowheadMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-005-01-02-09"),
				rotationSingleFloorPlaneEmptyArrowheadMirrored.getSymbol());

		rotationSingleFloorPlaneSchemaArrowheadMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-005-01-03-05"),
				rotationSingleFloorPlaneSchemaArrowheadMirrored.getSymbol());
		rotationSingleFloorPlaneSchemaArrowheadMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-005-01-03-09"),
				rotationSingleFloorPlaneSchemaArrowheadMirrored.getSymbol());

		rotationDoubleFloorPlane.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-006-01-01-13"), rotationDoubleFloorPlane.getSymbol());
		rotationDoubleFloorPlane.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-006-01-01-01"), rotationDoubleFloorPlane.getSymbol());

		rotationDoubleFloorPlaneEmptyArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-006-01-02-13"),
				rotationDoubleFloorPlaneEmptyArrowhead.getSymbol());
		rotationDoubleFloorPlaneEmptyArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-006-01-02-01"),
				rotationDoubleFloorPlaneEmptyArrowhead.getSymbol());

		rotationDoubleFloorPlaneSchemaArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-006-01-03-13"),
				rotationDoubleFloorPlaneSchemaArrowhead.getSymbol());
		rotationDoubleFloorPlaneSchemaArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-006-01-03-01"),
				rotationDoubleFloorPlaneSchemaArrowhead.getSymbol());

		rotationDoubleFloorPlaneMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-006-01-01-05"), rotationDoubleFloorPlaneMirrored.getSymbol());
		rotationDoubleFloorPlaneMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-006-01-01-09"), rotationDoubleFloorPlaneMirrored.getSymbol());

		rotationDoubleFloorPlaneEmptyArrowheadMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-006-01-02-05"),
				rotationDoubleFloorPlaneEmptyArrowheadMirrored.getSymbol());
		rotationDoubleFloorPlaneEmptyArrowheadMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-006-01-02-09"),
				rotationDoubleFloorPlaneEmptyArrowheadMirrored.getSymbol());

		rotationDoubleFloorPlaneSchemaArrowheadMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-006-01-03-05"),
				rotationDoubleFloorPlaneSchemaArrowheadMirrored.getSymbol());
		rotationDoubleFloorPlaneSchemaArrowheadMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-006-01-03-09"),
				rotationDoubleFloorPlaneSchemaArrowheadMirrored.getSymbol());

		rotationAlternatingFloorPlane.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-007-01-01-13"), rotationAlternatingFloorPlane.getSymbol());
		rotationAlternatingFloorPlane.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-007-01-01-01"), rotationAlternatingFloorPlane.getSymbol());

		rotationAlternatingFloorPlaneEmptyArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-007-01-02-13"),
				rotationAlternatingFloorPlaneEmptyArrowhead.getSymbol());
		rotationAlternatingFloorPlaneEmptyArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-007-01-02-01"),
				rotationAlternatingFloorPlaneEmptyArrowhead.getSymbol());

		rotationAlternatingFloorPlaneSchemaArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-007-01-03-13"),
				rotationAlternatingFloorPlaneSchemaArrowhead.getSymbol());
		rotationAlternatingFloorPlaneSchemaArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-007-01-03-01"),
				rotationAlternatingFloorPlaneSchemaArrowhead.getSymbol());

		rotationAlternatingFloorPlaneMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-007-01-01-05"),
				rotationAlternatingFloorPlaneMirrored.getSymbol());
		rotationAlternatingFloorPlaneMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-007-01-01-09"),
				rotationAlternatingFloorPlaneMirrored.getSymbol());

		rotationAlternatingFloorPlaneEmptyArrowheadMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-007-01-02-05"),
				rotationAlternatingFloorPlaneEmptyArrowheadMirrored.getSymbol());
		rotationAlternatingFloorPlaneEmptyArrowheadMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-007-01-02-09"),
				rotationAlternatingFloorPlaneEmptyArrowheadMirrored.getSymbol());

		rotationAlternatingFloorPlaneSchemaArrowheadMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-007-01-03-05"),
				rotationAlternatingFloorPlaneSchemaArrowheadMirrored.getSymbol());
		rotationAlternatingFloorPlaneSchemaArrowheadMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-007-01-03-09"),
				rotationAlternatingFloorPlaneSchemaArrowheadMirrored.getSymbol());

		shakingParallelFloor.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-008-01-01-13"), shakingParallelFloor.getSymbol());
		shakingParallelFloor.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-008-01-01-01"), shakingParallelFloor.getSymbol());

		shakingParallelFloorEmptyArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-008-01-02-13"), shakingParallelFloorEmptyArrowhead.getSymbol());
		shakingParallelFloorEmptyArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-008-01-02-01"), shakingParallelFloorEmptyArrowhead.getSymbol());

		shakingParallelFloorSchemaArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-008-01-03-13"), shakingParallelFloorSchemaArrowhead.getSymbol());
		shakingParallelFloorSchemaArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-008-01-03-01"), shakingParallelFloorSchemaArrowhead.getSymbol());

		shakingParallelFloorMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-008-01-01-05"), shakingParallelFloorMirrored.getSymbol());
		shakingParallelFloorMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-008-01-01-09"), shakingParallelFloorMirrored.getSymbol());

		shakingParallelFloorEmptyArrowheadMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-008-01-02-05"),
				shakingParallelFloorEmptyArrowheadMirrored.getSymbol());
		shakingParallelFloorEmptyArrowheadMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-008-01-02-09"),
				shakingParallelFloorEmptyArrowheadMirrored.getSymbol());

		shakingParallelFloorSchemaArrowheadMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-09-008-01-03-05"),
				shakingParallelFloorSchemaArrowheadMirrored.getSymbol());

	}

	@Override
	public void testCanPitch() {

		assertFalse(curveFloorPlaneSmall.canPitch());
		assertFalse(curveFloorPlaneSmallEmptyArrowhead.canPitch());
		assertFalse(curveFloorPlaneSmallSchemaArrowhead.canPitch());
		assertFalse(curveFloorPlaneSmallMirrored.canPitch());
		assertFalse(curveFloorPlaneSmallEmptyArrowheadMirrored.canPitch());
		assertFalse(curveFloorPlaneSmallSchemaArrowheadMirrored.canPitch());

		assertFalse(curveFloorPlaneMedium1.canPitch());
		assertFalse(curveFloorPlaneMedium1EmptyArrowhead.canPitch());
		assertFalse(curveFloorPlaneMedium1SchemaArrowhead.canPitch());
		assertFalse(curveFloorPlaneMedium1Mirrored.canPitch());
		assertFalse(curveFloorPlaneMedium1EmptyArrowheadMirrored.canPitch());
		assertFalse(curveFloorPlaneMedium1SchemaArrowheadMirrored.canPitch());

		assertFalse(curveFloorPlaneMedium2.canPitch());
		assertFalse(curveFloorPlaneMedium2EmptyArrowhead.canPitch());
		assertFalse(curveFloorPlaneMedium2SchemaArrowhead.canPitch());
		assertFalse(curveFloorPlaneMedium2Mirrored.canPitch());
		assertFalse(curveFloorPlaneMedium2EmptyArrowheadMirrored.canPitch());
		assertFalse(curveFloorPlaneMedium2SchemaArrowheadMirrored.canPitch());

		assertFalse(curveFloorPlaneLarge.canPitch());
		assertFalse(curveFloorPlaneLargeEmptyArrowhead.canPitch());
		assertFalse(curveFloorPlaneLargeSchemaArrowhead.canPitch());
		assertFalse(curveFloorPlaneLargeMirrored.canPitch());
		assertFalse(curveFloorPlaneLargeEmptyArrowheadMirrored.canPitch());
		assertFalse(curveFloorPlaneLargeSchemaArrowheadMirrored.canPitch());

		assertFalse(curveFloorPlaneCombined.canPitch());
		assertFalse(curveFloorPlaneCombinedEmptyArrowhead.canPitch());
		assertFalse(curveFloorPlaneCombinedSchemaArrowhead.canPitch());
		assertFalse(curveFloorPlaneCombinedMirrored.canPitch());
		assertFalse(curveFloorPlaneCombinedEmptyArrowheadMirrored.canPitch());
		assertFalse(curveFloorPlaneCombinedSchemaArrowheadMirrored.canPitch());

		assertFalse(humpFloorPlaneSmall.canPitch());
		assertFalse(humpFloorPlaneSmallEmptyArrowhead.canPitch());
		assertFalse(humpFloorPlaneSmallSchemaArrowhead.canPitch());
		assertFalse(humpFloorPlaneSmallMirrored.canPitch());
		assertFalse(humpFloorPlaneSmallEmptyArrowheadMirrored.canPitch());
		assertFalse(humpFloorPlaneSmallSchemaArrowheadMirrored.canPitch());

		assertFalse(loopFloorPlaneSmall.canPitch());
		assertFalse(loopFloorPlaneSmallEmptyArrowhead.canPitch());
		assertFalse(loopFloorPlaneSmallSchemaArrowhead.canPitch());
		assertFalse(loopFloorPlaneSmallMirrored.canPitch());
		assertFalse(loopFloorPlaneSmallEmptyArrowheadMirrored.canPitch());
		assertFalse(loopFloorPlaneSmallSchemaArrowheadMirrored.canPitch());

		assertFalse(waveFloorPlaneSnake.canPitch());
		assertFalse(waveFloorPlaneSnakeEmptyArrowhead.canPitch());
		assertFalse(waveFloorPlaneSnakeSchemaArrowhead.canPitch());
		assertFalse(waveFloorPlaneSnakeMirrored.canPitch());
		assertFalse(waveFloorPlaneSnakeEmptyArrowheadMirrored.canPitch());
		assertFalse(waveFloorPlaneSnakeSchemaArrowheadMirrored.canPitch());

		assertFalse(waveFloorPlaneSmall.canPitch());
		assertFalse(waveFloorPlaneSmallEmptyArrowhead.canPitch());
		assertFalse(waveFloorPlaneSmallSchemaArrowhead.canPitch());
		assertFalse(waveFloorPlaneSmallMirrored.canPitch());
		assertFalse(waveFloorPlaneSmallEmptyArrowheadMirrored.canPitch());
		assertFalse(waveFloorPlaneSmallSchemaArrowheadMirrored.canPitch());

		assertFalse(waveFloorPlaneLarge.canPitch());
		assertFalse(waveFloorPlaneLargeEmptyArrowhead.canPitch());
		assertFalse(waveFloorPlaneLargeSchemaArrowhead.canPitch());
		assertFalse(waveFloorPlaneLargeMirrored.canPitch());
		assertFalse(waveFloorPlaneLargeEmptyArrowheadMirrored.canPitch());
		assertFalse(waveFloorPlaneLargeSchemaArrowheadMirrored.canPitch());

		assertFalse(rotationSingleFloorPlane.canPitch());
		assertFalse(rotationSingleFloorPlaneEmptyArrowhead.canPitch());
		assertFalse(rotationSingleFloorPlaneSchemaArrowhead.canPitch());
		assertFalse(rotationSingleFloorPlaneMirrored.canPitch());
		assertFalse(rotationSingleFloorPlaneEmptyArrowheadMirrored.canPitch());
		assertFalse(rotationSingleFloorPlaneSchemaArrowheadMirrored.canPitch());

		assertFalse(rotationDoubleFloorPlane.canPitch());
		assertFalse(rotationDoubleFloorPlaneEmptyArrowhead.canPitch());
		assertFalse(rotationDoubleFloorPlaneSchemaArrowhead.canPitch());
		assertFalse(rotationDoubleFloorPlaneMirrored.canPitch());
		assertFalse(rotationDoubleFloorPlaneEmptyArrowheadMirrored.canPitch());
		assertFalse(rotationDoubleFloorPlaneSchemaArrowheadMirrored.canPitch());

		assertFalse(rotationAlternatingFloorPlane.canPitch());
		assertFalse(rotationAlternatingFloorPlaneEmptyArrowhead.canPitch());
		assertFalse(rotationAlternatingFloorPlaneSchemaArrowhead.canPitch());
		assertFalse(rotationAlternatingFloorPlaneMirrored.canPitch());
		assertFalse(rotationAlternatingFloorPlaneEmptyArrowheadMirrored.canPitch());
		assertFalse(rotationAlternatingFloorPlaneSchemaArrowheadMirrored.canPitch());

		assertFalse(shakingParallelFloor.canPitch());
		assertFalse(shakingParallelFloorEmptyArrowhead.canPitch());
		assertFalse(shakingParallelFloorSchemaArrowhead.canPitch());
		assertFalse(shakingParallelFloorMirrored.canPitch());
		assertFalse(shakingParallelFloorEmptyArrowheadMirrored.canPitch());
		assertFalse(shakingParallelFloorSchemaArrowheadMirrored.canPitch());

	}

	@Override
	public void testPitch() {

	}

	@Override
	public void testCanRoll() {

		assertFalse(curveFloorPlaneSmall.canRoll());
		assertFalse(curveFloorPlaneSmallEmptyArrowhead.canRoll());
		assertFalse(curveFloorPlaneSmallSchemaArrowhead.canRoll());
		assertFalse(curveFloorPlaneSmallMirrored.canRoll());
		assertFalse(curveFloorPlaneSmallEmptyArrowheadMirrored.canRoll());
		assertFalse(curveFloorPlaneSmallSchemaArrowheadMirrored.canRoll());

		assertFalse(curveFloorPlaneMedium1.canRoll());
		assertFalse(curveFloorPlaneMedium1EmptyArrowhead.canRoll());
		assertFalse(curveFloorPlaneMedium1SchemaArrowhead.canRoll());
		assertFalse(curveFloorPlaneMedium1Mirrored.canRoll());
		assertFalse(curveFloorPlaneMedium1EmptyArrowheadMirrored.canRoll());
		assertFalse(curveFloorPlaneMedium1SchemaArrowheadMirrored.canRoll());

		assertFalse(curveFloorPlaneMedium2.canRoll());
		assertFalse(curveFloorPlaneMedium2EmptyArrowhead.canRoll());
		assertFalse(curveFloorPlaneMedium2SchemaArrowhead.canRoll());
		assertFalse(curveFloorPlaneMedium2Mirrored.canRoll());
		assertFalse(curveFloorPlaneMedium2EmptyArrowheadMirrored.canRoll());
		assertFalse(curveFloorPlaneMedium2SchemaArrowheadMirrored.canRoll());

		assertFalse(curveFloorPlaneLarge.canRoll());
		assertFalse(curveFloorPlaneLargeEmptyArrowhead.canRoll());
		assertFalse(curveFloorPlaneLargeSchemaArrowhead.canRoll());
		assertFalse(curveFloorPlaneLargeMirrored.canRoll());
		assertFalse(curveFloorPlaneLargeEmptyArrowheadMirrored.canRoll());
		assertFalse(curveFloorPlaneLargeSchemaArrowheadMirrored.canRoll());

		assertFalse(curveFloorPlaneCombined.canRoll());
		assertFalse(curveFloorPlaneCombinedEmptyArrowhead.canRoll());
		assertFalse(curveFloorPlaneCombinedSchemaArrowhead.canRoll());
		assertFalse(curveFloorPlaneCombinedMirrored.canRoll());
		assertFalse(curveFloorPlaneCombinedEmptyArrowheadMirrored.canRoll());
		assertFalse(curveFloorPlaneCombinedSchemaArrowheadMirrored.canRoll());

		assertFalse(humpFloorPlaneSmall.canRoll());
		assertFalse(humpFloorPlaneSmallEmptyArrowhead.canRoll());
		assertFalse(humpFloorPlaneSmallSchemaArrowhead.canRoll());
		assertFalse(humpFloorPlaneSmallMirrored.canRoll());
		assertFalse(humpFloorPlaneSmallEmptyArrowheadMirrored.canRoll());
		assertFalse(humpFloorPlaneSmallSchemaArrowheadMirrored.canRoll());

		assertFalse(loopFloorPlaneSmall.canRoll());
		assertFalse(loopFloorPlaneSmallEmptyArrowhead.canRoll());
		assertFalse(loopFloorPlaneSmallSchemaArrowhead.canRoll());
		assertFalse(loopFloorPlaneSmallMirrored.canRoll());
		assertFalse(loopFloorPlaneSmallEmptyArrowheadMirrored.canRoll());
		assertFalse(loopFloorPlaneSmallSchemaArrowheadMirrored.canRoll());

		assertFalse(waveFloorPlaneSnake.canRoll());
		assertFalse(waveFloorPlaneSnakeEmptyArrowhead.canRoll());
		assertFalse(waveFloorPlaneSnakeSchemaArrowhead.canRoll());
		assertFalse(waveFloorPlaneSnakeMirrored.canRoll());
		assertFalse(waveFloorPlaneSnakeEmptyArrowheadMirrored.canRoll());
		assertFalse(waveFloorPlaneSnakeSchemaArrowheadMirrored.canRoll());

		assertFalse(waveFloorPlaneSmall.canRoll());
		assertFalse(waveFloorPlaneSmallEmptyArrowhead.canRoll());
		assertFalse(waveFloorPlaneSmallSchemaArrowhead.canRoll());
		assertFalse(waveFloorPlaneSmallMirrored.canRoll());
		assertFalse(waveFloorPlaneSmallEmptyArrowheadMirrored.canRoll());
		assertFalse(waveFloorPlaneSmallSchemaArrowheadMirrored.canRoll());

		assertFalse(waveFloorPlaneLarge.canRoll());
		assertFalse(waveFloorPlaneLargeEmptyArrowhead.canRoll());
		assertFalse(waveFloorPlaneLargeSchemaArrowhead.canRoll());
		assertFalse(waveFloorPlaneLargeMirrored.canRoll());
		assertFalse(waveFloorPlaneLargeEmptyArrowheadMirrored.canRoll());
		assertFalse(waveFloorPlaneLargeSchemaArrowheadMirrored.canRoll());

		assertFalse(rotationSingleFloorPlane.canRoll());
		assertFalse(rotationSingleFloorPlaneEmptyArrowhead.canRoll());
		assertFalse(rotationSingleFloorPlaneSchemaArrowhead.canRoll());
		assertFalse(rotationSingleFloorPlaneMirrored.canRoll());
		assertFalse(rotationSingleFloorPlaneEmptyArrowheadMirrored.canRoll());
		assertFalse(rotationSingleFloorPlaneSchemaArrowheadMirrored.canRoll());

		assertFalse(rotationDoubleFloorPlane.canRoll());
		assertFalse(rotationDoubleFloorPlaneEmptyArrowhead.canRoll());
		assertFalse(rotationDoubleFloorPlaneSchemaArrowhead.canRoll());
		assertFalse(rotationDoubleFloorPlaneMirrored.canRoll());
		assertFalse(rotationDoubleFloorPlaneEmptyArrowheadMirrored.canRoll());
		assertFalse(rotationDoubleFloorPlaneSchemaArrowheadMirrored.canRoll());

		assertFalse(rotationAlternatingFloorPlane.canRoll());
		assertFalse(rotationAlternatingFloorPlaneEmptyArrowhead.canRoll());
		assertFalse(rotationAlternatingFloorPlaneSchemaArrowhead.canRoll());
		assertFalse(rotationAlternatingFloorPlaneMirrored.canRoll());
		assertFalse(rotationAlternatingFloorPlaneEmptyArrowheadMirrored.canRoll());
		assertFalse(rotationAlternatingFloorPlaneSchemaArrowheadMirrored.canRoll());

		assertFalse(shakingParallelFloor.canRoll());
		assertFalse(shakingParallelFloorEmptyArrowhead.canRoll());
		assertFalse(shakingParallelFloorSchemaArrowhead.canRoll());
		assertFalse(shakingParallelFloorMirrored.canRoll());
		assertFalse(shakingParallelFloorEmptyArrowheadMirrored.canRoll());
		assertFalse(shakingParallelFloorSchemaArrowheadMirrored.canRoll());

	}

	@Override
	public void testRoll() {

	}

	@Override
	public void testCanSwitchArrowHead() {

		assertTrue(curveFloorPlaneSmall.canSwitchArrowHead());
		assertTrue(curveFloorPlaneSmallEmptyArrowhead.canSwitchArrowHead());
		assertTrue(curveFloorPlaneSmallSchemaArrowhead.canSwitchArrowHead());
		assertTrue(curveFloorPlaneSmallMirrored.canSwitchArrowHead());
		assertTrue(curveFloorPlaneSmallEmptyArrowheadMirrored.canSwitchArrowHead());
		assertTrue(curveFloorPlaneSmallSchemaArrowheadMirrored.canSwitchArrowHead());

		assertTrue(curveFloorPlaneMedium1.canSwitchArrowHead());
		assertTrue(curveFloorPlaneMedium1EmptyArrowhead.canSwitchArrowHead());
		assertTrue(curveFloorPlaneMedium1SchemaArrowhead.canSwitchArrowHead());
		assertTrue(curveFloorPlaneMedium1Mirrored.canSwitchArrowHead());
		assertTrue(curveFloorPlaneMedium1EmptyArrowheadMirrored.canSwitchArrowHead());
		assertTrue(curveFloorPlaneMedium1SchemaArrowheadMirrored.canSwitchArrowHead());

		assertTrue(curveFloorPlaneMedium2.canSwitchArrowHead());
		assertTrue(curveFloorPlaneMedium2EmptyArrowhead.canSwitchArrowHead());
		assertTrue(curveFloorPlaneMedium2SchemaArrowhead.canSwitchArrowHead());
		assertTrue(curveFloorPlaneMedium2Mirrored.canSwitchArrowHead());
		assertTrue(curveFloorPlaneMedium2EmptyArrowheadMirrored.canSwitchArrowHead());
		assertTrue(curveFloorPlaneMedium2SchemaArrowheadMirrored.canSwitchArrowHead());

		assertTrue(curveFloorPlaneLarge.canSwitchArrowHead());
		assertTrue(curveFloorPlaneLargeEmptyArrowhead.canSwitchArrowHead());
		assertTrue(curveFloorPlaneLargeSchemaArrowhead.canSwitchArrowHead());
		assertTrue(curveFloorPlaneLargeMirrored.canSwitchArrowHead());
		assertTrue(curveFloorPlaneLargeEmptyArrowheadMirrored.canSwitchArrowHead());
		assertTrue(curveFloorPlaneLargeSchemaArrowheadMirrored.canSwitchArrowHead());

		assertTrue(curveFloorPlaneCombined.canSwitchArrowHead());
		assertTrue(curveFloorPlaneCombinedEmptyArrowhead.canSwitchArrowHead());
		assertTrue(curveFloorPlaneCombinedSchemaArrowhead.canSwitchArrowHead());
		assertTrue(curveFloorPlaneCombinedMirrored.canSwitchArrowHead());
		assertTrue(curveFloorPlaneCombinedEmptyArrowheadMirrored.canSwitchArrowHead());
		assertTrue(curveFloorPlaneCombinedSchemaArrowheadMirrored.canSwitchArrowHead());

		assertTrue(humpFloorPlaneSmall.canSwitchArrowHead());
		assertTrue(humpFloorPlaneSmallEmptyArrowhead.canSwitchArrowHead());
		assertTrue(humpFloorPlaneSmallSchemaArrowhead.canSwitchArrowHead());
		assertTrue(humpFloorPlaneSmallMirrored.canSwitchArrowHead());
		assertTrue(humpFloorPlaneSmallEmptyArrowheadMirrored.canSwitchArrowHead());
		assertTrue(humpFloorPlaneSmallSchemaArrowheadMirrored.canSwitchArrowHead());

		assertTrue(loopFloorPlaneSmall.canSwitchArrowHead());
		assertTrue(loopFloorPlaneSmallEmptyArrowhead.canSwitchArrowHead());
		assertTrue(loopFloorPlaneSmallSchemaArrowhead.canSwitchArrowHead());
		assertTrue(loopFloorPlaneSmallMirrored.canSwitchArrowHead());
		assertTrue(loopFloorPlaneSmallEmptyArrowheadMirrored.canSwitchArrowHead());
		assertTrue(loopFloorPlaneSmallSchemaArrowheadMirrored.canSwitchArrowHead());

		assertTrue(waveFloorPlaneSnake.canSwitchArrowHead());
		assertTrue(waveFloorPlaneSnakeEmptyArrowhead.canSwitchArrowHead());
		assertTrue(waveFloorPlaneSnakeSchemaArrowhead.canSwitchArrowHead());
		assertTrue(waveFloorPlaneSnakeMirrored.canSwitchArrowHead());
		assertTrue(waveFloorPlaneSnakeEmptyArrowheadMirrored.canSwitchArrowHead());
		assertTrue(waveFloorPlaneSnakeSchemaArrowheadMirrored.canSwitchArrowHead());

		assertTrue(waveFloorPlaneSmall.canSwitchArrowHead());
		assertTrue(waveFloorPlaneSmallEmptyArrowhead.canSwitchArrowHead());
		assertTrue(waveFloorPlaneSmallSchemaArrowhead.canSwitchArrowHead());
		assertTrue(waveFloorPlaneSmallMirrored.canSwitchArrowHead());
		assertTrue(waveFloorPlaneSmallEmptyArrowheadMirrored.canSwitchArrowHead());
		assertTrue(waveFloorPlaneSmallSchemaArrowheadMirrored.canSwitchArrowHead());

		assertTrue(waveFloorPlaneLarge.canSwitchArrowHead());
		assertTrue(waveFloorPlaneLargeEmptyArrowhead.canSwitchArrowHead());
		assertTrue(waveFloorPlaneLargeSchemaArrowhead.canSwitchArrowHead());
		assertTrue(waveFloorPlaneLargeMirrored.canSwitchArrowHead());
		assertTrue(waveFloorPlaneLargeEmptyArrowheadMirrored.canSwitchArrowHead());
		assertTrue(waveFloorPlaneLargeSchemaArrowheadMirrored.canSwitchArrowHead());

		assertTrue(rotationSingleFloorPlane.canSwitchArrowHead());
		assertTrue(rotationSingleFloorPlaneEmptyArrowhead.canSwitchArrowHead());
		assertTrue(rotationSingleFloorPlaneSchemaArrowhead.canSwitchArrowHead());
		assertTrue(rotationSingleFloorPlaneMirrored.canSwitchArrowHead());
		assertTrue(rotationSingleFloorPlaneEmptyArrowheadMirrored.canSwitchArrowHead());
		assertTrue(rotationSingleFloorPlaneSchemaArrowheadMirrored.canSwitchArrowHead());

		assertTrue(rotationDoubleFloorPlane.canSwitchArrowHead());
		assertTrue(rotationDoubleFloorPlaneEmptyArrowhead.canSwitchArrowHead());
		assertTrue(rotationDoubleFloorPlaneSchemaArrowhead.canSwitchArrowHead());
		assertTrue(rotationDoubleFloorPlaneMirrored.canSwitchArrowHead());
		assertTrue(rotationDoubleFloorPlaneEmptyArrowheadMirrored.canSwitchArrowHead());
		assertTrue(rotationDoubleFloorPlaneSchemaArrowheadMirrored.canSwitchArrowHead());

		assertTrue(rotationAlternatingFloorPlane.canSwitchArrowHead());
		assertTrue(rotationAlternatingFloorPlaneEmptyArrowhead.canSwitchArrowHead());
		assertTrue(rotationAlternatingFloorPlaneSchemaArrowhead.canSwitchArrowHead());
		assertTrue(rotationAlternatingFloorPlaneMirrored.canSwitchArrowHead());
		assertTrue(rotationAlternatingFloorPlaneEmptyArrowheadMirrored.canSwitchArrowHead());
		assertTrue(rotationAlternatingFloorPlaneSchemaArrowheadMirrored.canSwitchArrowHead());

		assertTrue(shakingParallelFloor.canSwitchArrowHead());
		assertTrue(shakingParallelFloorEmptyArrowhead.canSwitchArrowHead());
		assertTrue(shakingParallelFloorSchemaArrowhead.canSwitchArrowHead());
		assertTrue(shakingParallelFloorMirrored.canSwitchArrowHead());
		assertTrue(shakingParallelFloorEmptyArrowheadMirrored.canSwitchArrowHead());
		assertTrue(shakingParallelFloorSchemaArrowheadMirrored.canSwitchArrowHead());

	}

	@Override
	public void testSwitchArrowHead() {

		curveFloorPlaneSmall.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-001-01-02-01"), curveFloorPlaneSmall.getSymbol());
		curveFloorPlaneSmall.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-001-01-03-01"), curveFloorPlaneSmall.getSymbol());
		curveFloorPlaneSmall.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-001-01-01-01"), curveFloorPlaneSmall.getSymbol());

		curveFloorPlaneSmallEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-001-01-03-01"), curveFloorPlaneSmallEmptyArrowhead.getSymbol());
		curveFloorPlaneSmallEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-001-01-01-01"), curveFloorPlaneSmallEmptyArrowhead.getSymbol());
		curveFloorPlaneSmallEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-001-01-02-01"), curveFloorPlaneSmallEmptyArrowhead.getSymbol());

		curveFloorPlaneSmallSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-001-01-01-01"), curveFloorPlaneSmallSchemaArrowhead.getSymbol());
		curveFloorPlaneSmallSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-001-01-02-01"), curveFloorPlaneSmallSchemaArrowhead.getSymbol());
		curveFloorPlaneSmallSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-001-01-03-01"), curveFloorPlaneSmallSchemaArrowhead.getSymbol());

		curveFloorPlaneSmallMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-001-01-02-09"), curveFloorPlaneSmallMirrored.getSymbol());
		curveFloorPlaneSmallMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-001-01-03-09"), curveFloorPlaneSmallMirrored.getSymbol());
		curveFloorPlaneSmallMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-001-01-01-09"), curveFloorPlaneSmallMirrored.getSymbol());

		curveFloorPlaneSmallEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-001-01-03-09"),
				curveFloorPlaneSmallEmptyArrowheadMirrored.getSymbol());
		curveFloorPlaneSmallEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-001-01-01-09"),
				curveFloorPlaneSmallEmptyArrowheadMirrored.getSymbol());
		curveFloorPlaneSmallEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-001-01-02-09"),
				curveFloorPlaneSmallEmptyArrowheadMirrored.getSymbol());

		curveFloorPlaneSmallSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-001-01-01-09"),
				curveFloorPlaneSmallSchemaArrowheadMirrored.getSymbol());
		curveFloorPlaneSmallSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-001-01-02-09"),
				curveFloorPlaneSmallSchemaArrowheadMirrored.getSymbol());
		curveFloorPlaneSmallSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-001-01-03-09"),
				curveFloorPlaneSmallSchemaArrowheadMirrored.getSymbol());

		curveFloorPlaneMedium1.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-001-02-02-01"), curveFloorPlaneMedium1.getSymbol());
		curveFloorPlaneMedium1.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-001-02-03-01"), curveFloorPlaneMedium1.getSymbol());
		curveFloorPlaneMedium1.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-001-02-01-01"), curveFloorPlaneMedium1.getSymbol());

		curveFloorPlaneMedium1EmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-001-02-03-01"),
				curveFloorPlaneMedium1EmptyArrowhead.getSymbol());
		curveFloorPlaneMedium1EmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-001-02-01-01"),
				curveFloorPlaneMedium1EmptyArrowhead.getSymbol());
		curveFloorPlaneMedium1EmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-001-02-02-01"),
				curveFloorPlaneMedium1EmptyArrowhead.getSymbol());

		curveFloorPlaneMedium1SchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-001-02-01-01"),
				curveFloorPlaneMedium1SchemaArrowhead.getSymbol());
		curveFloorPlaneMedium1SchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-001-02-02-01"),
				curveFloorPlaneMedium1SchemaArrowhead.getSymbol());
		curveFloorPlaneMedium1SchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-001-02-03-01"),
				curveFloorPlaneMedium1SchemaArrowhead.getSymbol());

		curveFloorPlaneMedium1Mirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-001-02-02-09"), curveFloorPlaneMedium1Mirrored.getSymbol());
		curveFloorPlaneMedium1Mirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-001-02-03-09"), curveFloorPlaneMedium1Mirrored.getSymbol());
		curveFloorPlaneMedium1Mirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-001-02-01-09"), curveFloorPlaneMedium1Mirrored.getSymbol());

		curveFloorPlaneMedium1EmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-001-02-03-09"),
				curveFloorPlaneMedium1EmptyArrowheadMirrored.getSymbol());
		curveFloorPlaneMedium1EmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-001-02-01-09"),
				curveFloorPlaneMedium1EmptyArrowheadMirrored.getSymbol());
		curveFloorPlaneMedium1EmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-001-02-02-09"),
				curveFloorPlaneMedium1EmptyArrowheadMirrored.getSymbol());

		curveFloorPlaneMedium1SchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-001-02-01-09"),
				curveFloorPlaneMedium1SchemaArrowheadMirrored.getSymbol());
		curveFloorPlaneMedium1SchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-001-02-02-09"),
				curveFloorPlaneMedium1SchemaArrowheadMirrored.getSymbol());
		curveFloorPlaneMedium1SchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-001-02-03-09"),
				curveFloorPlaneMedium1SchemaArrowheadMirrored.getSymbol());

		curveFloorPlaneMedium2.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-001-03-02-01"), curveFloorPlaneMedium2.getSymbol());
		curveFloorPlaneMedium2.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-001-03-03-01"), curveFloorPlaneMedium2.getSymbol());
		curveFloorPlaneMedium2.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-001-03-01-01"), curveFloorPlaneMedium2.getSymbol());

		curveFloorPlaneMedium2EmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-001-03-03-01"),
				curveFloorPlaneMedium2EmptyArrowhead.getSymbol());
		curveFloorPlaneMedium2EmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-001-03-01-01"),
				curveFloorPlaneMedium2EmptyArrowhead.getSymbol());
		curveFloorPlaneMedium2EmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-001-03-02-01"),
				curveFloorPlaneMedium2EmptyArrowhead.getSymbol());

		curveFloorPlaneMedium2SchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-001-03-01-01"),
				curveFloorPlaneMedium2SchemaArrowhead.getSymbol());
		curveFloorPlaneMedium2SchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-001-03-02-01"),
				curveFloorPlaneMedium2SchemaArrowhead.getSymbol());
		curveFloorPlaneMedium2SchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-001-03-03-01"),
				curveFloorPlaneMedium2SchemaArrowhead.getSymbol());

		curveFloorPlaneMedium2Mirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-001-03-02-09"), curveFloorPlaneMedium2Mirrored.getSymbol());
		curveFloorPlaneMedium2Mirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-001-03-03-09"), curveFloorPlaneMedium2Mirrored.getSymbol());
		curveFloorPlaneMedium2Mirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-001-03-01-09"), curveFloorPlaneMedium2Mirrored.getSymbol());

		curveFloorPlaneMedium2EmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-001-03-03-09"),
				curveFloorPlaneMedium2EmptyArrowheadMirrored.getSymbol());
		curveFloorPlaneMedium2EmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-001-03-01-09"),
				curveFloorPlaneMedium2EmptyArrowheadMirrored.getSymbol());
		curveFloorPlaneMedium2EmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-001-03-02-09"),
				curveFloorPlaneMedium2EmptyArrowheadMirrored.getSymbol());

		curveFloorPlaneMedium2SchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-001-03-01-09"),
				curveFloorPlaneMedium2SchemaArrowheadMirrored.getSymbol());
		curveFloorPlaneMedium2SchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-001-03-02-09"),
				curveFloorPlaneMedium2SchemaArrowheadMirrored.getSymbol());
		curveFloorPlaneMedium2SchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-001-03-03-09"),
				curveFloorPlaneMedium2SchemaArrowheadMirrored.getSymbol());

		curveFloorPlaneLarge.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-001-04-02-01"), curveFloorPlaneLarge.getSymbol());
		curveFloorPlaneLarge.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-001-04-03-01"), curveFloorPlaneLarge.getSymbol());
		curveFloorPlaneLarge.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-001-04-01-01"), curveFloorPlaneLarge.getSymbol());

		curveFloorPlaneLargeEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-001-04-03-01"), curveFloorPlaneLargeEmptyArrowhead.getSymbol());
		curveFloorPlaneLargeEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-001-04-01-01"), curveFloorPlaneLargeEmptyArrowhead.getSymbol());
		curveFloorPlaneLargeEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-001-04-02-01"), curveFloorPlaneLargeEmptyArrowhead.getSymbol());

		curveFloorPlaneLargeSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-001-04-01-01"), curveFloorPlaneLargeSchemaArrowhead.getSymbol());
		curveFloorPlaneLargeSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-001-04-02-01"), curveFloorPlaneLargeSchemaArrowhead.getSymbol());
		curveFloorPlaneLargeSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-001-04-03-01"), curveFloorPlaneLargeSchemaArrowhead.getSymbol());

		curveFloorPlaneLargeMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-001-04-02-09"), curveFloorPlaneLargeMirrored.getSymbol());
		curveFloorPlaneLargeMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-001-04-03-09"), curveFloorPlaneLargeMirrored.getSymbol());
		curveFloorPlaneLargeMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-001-04-01-09"), curveFloorPlaneLargeMirrored.getSymbol());

		curveFloorPlaneLargeEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-001-04-03-09"),
				curveFloorPlaneLargeEmptyArrowheadMirrored.getSymbol());
		curveFloorPlaneLargeEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-001-04-01-09"),
				curveFloorPlaneLargeEmptyArrowheadMirrored.getSymbol());
		curveFloorPlaneLargeEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-001-04-02-09"),
				curveFloorPlaneLargeEmptyArrowheadMirrored.getSymbol());

		curveFloorPlaneLargeSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-001-04-01-09"),
				curveFloorPlaneLargeSchemaArrowheadMirrored.getSymbol());
		curveFloorPlaneLargeSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-001-04-02-09"),
				curveFloorPlaneLargeSchemaArrowheadMirrored.getSymbol());
		curveFloorPlaneLargeSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-001-04-03-09"),
				curveFloorPlaneLargeSchemaArrowheadMirrored.getSymbol());

		curveFloorPlaneCombined.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-001-05-02-01"), curveFloorPlaneCombined.getSymbol());
		curveFloorPlaneCombined.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-001-05-03-01"), curveFloorPlaneCombined.getSymbol());
		curveFloorPlaneCombined.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-001-05-01-01"), curveFloorPlaneCombined.getSymbol());

		curveFloorPlaneCombinedEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-001-05-03-01"),
				curveFloorPlaneCombinedEmptyArrowhead.getSymbol());
		curveFloorPlaneCombinedEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-001-05-01-01"),
				curveFloorPlaneCombinedEmptyArrowhead.getSymbol());
		curveFloorPlaneCombinedEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-001-05-02-01"),
				curveFloorPlaneCombinedEmptyArrowhead.getSymbol());

		curveFloorPlaneCombinedSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-001-05-01-01"),
				curveFloorPlaneCombinedSchemaArrowhead.getSymbol());
		curveFloorPlaneCombinedSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-001-05-02-01"),
				curveFloorPlaneCombinedSchemaArrowhead.getSymbol());
		curveFloorPlaneCombinedSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-001-05-03-01"),
				curveFloorPlaneCombinedSchemaArrowhead.getSymbol());

		curveFloorPlaneCombinedMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-001-05-02-09"), curveFloorPlaneCombinedMirrored.getSymbol());
		curveFloorPlaneCombinedMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-001-05-03-09"), curveFloorPlaneCombinedMirrored.getSymbol());
		curveFloorPlaneCombinedMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-001-05-01-09"), curveFloorPlaneCombinedMirrored.getSymbol());

		curveFloorPlaneCombinedEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-001-05-03-09"),
				curveFloorPlaneCombinedEmptyArrowheadMirrored.getSymbol());
		curveFloorPlaneCombinedEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-001-05-01-09"),
				curveFloorPlaneCombinedEmptyArrowheadMirrored.getSymbol());
		curveFloorPlaneCombinedEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-001-05-02-09"),
				curveFloorPlaneCombinedEmptyArrowheadMirrored.getSymbol());

		curveFloorPlaneCombinedSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-001-05-01-09"),
				curveFloorPlaneCombinedSchemaArrowheadMirrored.getSymbol());
		curveFloorPlaneCombinedSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-001-05-02-09"),
				curveFloorPlaneCombinedSchemaArrowheadMirrored.getSymbol());
		curveFloorPlaneCombinedSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-001-05-03-09"),
				curveFloorPlaneCombinedSchemaArrowheadMirrored.getSymbol());

		humpFloorPlaneSmall.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-002-01-02-01"), humpFloorPlaneSmall.getSymbol());
		humpFloorPlaneSmall.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-002-01-03-01"), humpFloorPlaneSmall.getSymbol());
		humpFloorPlaneSmall.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-002-01-01-01"), humpFloorPlaneSmall.getSymbol());

		humpFloorPlaneSmallEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-002-01-03-01"), humpFloorPlaneSmallEmptyArrowhead.getSymbol());
		humpFloorPlaneSmallEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-002-01-01-01"), humpFloorPlaneSmallEmptyArrowhead.getSymbol());
		humpFloorPlaneSmallEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-002-01-02-01"), humpFloorPlaneSmallEmptyArrowhead.getSymbol());

		humpFloorPlaneSmallSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-002-01-01-01"), humpFloorPlaneSmallSchemaArrowhead.getSymbol());
		humpFloorPlaneSmallSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-002-01-02-01"), humpFloorPlaneSmallSchemaArrowhead.getSymbol());
		humpFloorPlaneSmallSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-002-01-03-01"), humpFloorPlaneSmallSchemaArrowhead.getSymbol());

		humpFloorPlaneSmallMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-002-01-02-09"), humpFloorPlaneSmallMirrored.getSymbol());
		humpFloorPlaneSmallMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-002-01-03-09"), humpFloorPlaneSmallMirrored.getSymbol());
		humpFloorPlaneSmallMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-002-01-01-09"), humpFloorPlaneSmallMirrored.getSymbol());

		humpFloorPlaneSmallEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-002-01-03-09"),
				humpFloorPlaneSmallEmptyArrowheadMirrored.getSymbol());
		humpFloorPlaneSmallEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-002-01-01-09"),
				humpFloorPlaneSmallEmptyArrowheadMirrored.getSymbol());
		humpFloorPlaneSmallEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-002-01-02-09"),
				humpFloorPlaneSmallEmptyArrowheadMirrored.getSymbol());

		humpFloorPlaneSmallSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-002-01-01-09"),
				humpFloorPlaneSmallSchemaArrowheadMirrored.getSymbol());
		humpFloorPlaneSmallSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-002-01-02-09"),
				humpFloorPlaneSmallSchemaArrowheadMirrored.getSymbol());
		humpFloorPlaneSmallSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-002-01-03-09"),
				humpFloorPlaneSmallSchemaArrowheadMirrored.getSymbol());

		loopFloorPlaneSmall.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-003-01-02-01"), loopFloorPlaneSmall.getSymbol());
		loopFloorPlaneSmall.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-003-01-03-01"), loopFloorPlaneSmall.getSymbol());
		loopFloorPlaneSmall.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-003-01-01-01"), loopFloorPlaneSmall.getSymbol());

		loopFloorPlaneSmallEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-003-01-03-01"), loopFloorPlaneSmallEmptyArrowhead.getSymbol());
		loopFloorPlaneSmallEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-003-01-01-01"), loopFloorPlaneSmallEmptyArrowhead.getSymbol());
		loopFloorPlaneSmallEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-003-01-02-01"), loopFloorPlaneSmallEmptyArrowhead.getSymbol());

		loopFloorPlaneSmallSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-003-01-01-01"), loopFloorPlaneSmallSchemaArrowhead.getSymbol());
		loopFloorPlaneSmallSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-003-01-02-01"), loopFloorPlaneSmallSchemaArrowhead.getSymbol());
		loopFloorPlaneSmallSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-003-01-03-01"), loopFloorPlaneSmallSchemaArrowhead.getSymbol());

		loopFloorPlaneSmallMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-003-01-02-09"), loopFloorPlaneSmallMirrored.getSymbol());
		loopFloorPlaneSmallMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-003-01-03-09"), loopFloorPlaneSmallMirrored.getSymbol());
		loopFloorPlaneSmallMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-003-01-01-09"), loopFloorPlaneSmallMirrored.getSymbol());

		loopFloorPlaneSmallEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-003-01-03-09"),
				loopFloorPlaneSmallEmptyArrowheadMirrored.getSymbol());
		loopFloorPlaneSmallEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-003-01-01-09"),
				loopFloorPlaneSmallEmptyArrowheadMirrored.getSymbol());
		loopFloorPlaneSmallEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-003-01-02-09"),
				loopFloorPlaneSmallEmptyArrowheadMirrored.getSymbol());

		loopFloorPlaneSmallSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-003-01-01-09"),
				loopFloorPlaneSmallSchemaArrowheadMirrored.getSymbol());
		loopFloorPlaneSmallSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-003-01-02-09"),
				loopFloorPlaneSmallSchemaArrowheadMirrored.getSymbol());
		loopFloorPlaneSmallSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-003-01-03-09"),
				loopFloorPlaneSmallSchemaArrowheadMirrored.getSymbol());

		waveFloorPlaneSnake.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-004-01-02-01"), waveFloorPlaneSnake.getSymbol());
		waveFloorPlaneSnake.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-004-01-03-01"), waveFloorPlaneSnake.getSymbol());
		waveFloorPlaneSnake.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-004-01-01-01"), waveFloorPlaneSnake.getSymbol());

		waveFloorPlaneSnakeEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-004-01-03-01"), waveFloorPlaneSnakeEmptyArrowhead.getSymbol());
		waveFloorPlaneSnakeEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-004-01-01-01"), waveFloorPlaneSnakeEmptyArrowhead.getSymbol());
		waveFloorPlaneSnakeEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-004-01-02-01"), waveFloorPlaneSnakeEmptyArrowhead.getSymbol());

		waveFloorPlaneSnakeSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-004-01-01-01"), waveFloorPlaneSnakeSchemaArrowhead.getSymbol());
		waveFloorPlaneSnakeSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-004-01-02-01"), waveFloorPlaneSnakeSchemaArrowhead.getSymbol());
		waveFloorPlaneSnakeSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-004-01-03-01"), waveFloorPlaneSnakeSchemaArrowhead.getSymbol());

		waveFloorPlaneSnakeMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-004-01-02-09"), waveFloorPlaneSnakeMirrored.getSymbol());
		waveFloorPlaneSnakeMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-004-01-03-09"), waveFloorPlaneSnakeMirrored.getSymbol());
		waveFloorPlaneSnakeMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-004-01-01-09"), waveFloorPlaneSnakeMirrored.getSymbol());

		waveFloorPlaneSnakeEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-004-01-03-09"),
				waveFloorPlaneSnakeEmptyArrowheadMirrored.getSymbol());
		waveFloorPlaneSnakeEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-004-01-01-09"),
				waveFloorPlaneSnakeEmptyArrowheadMirrored.getSymbol());
		waveFloorPlaneSnakeEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-004-01-02-09"),
				waveFloorPlaneSnakeEmptyArrowheadMirrored.getSymbol());

		waveFloorPlaneSnakeSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-004-01-01-09"),
				waveFloorPlaneSnakeSchemaArrowheadMirrored.getSymbol());
		waveFloorPlaneSnakeSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-004-01-02-09"),
				waveFloorPlaneSnakeSchemaArrowheadMirrored.getSymbol());
		waveFloorPlaneSnakeSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-004-01-03-09"),
				waveFloorPlaneSnakeSchemaArrowheadMirrored.getSymbol());

		waveFloorPlaneSmall.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-004-02-02-01"), waveFloorPlaneSmall.getSymbol());
		waveFloorPlaneSmall.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-004-02-03-01"), waveFloorPlaneSmall.getSymbol());
		waveFloorPlaneSmall.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-004-02-01-01"), waveFloorPlaneSmall.getSymbol());

		waveFloorPlaneSmallEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-004-02-03-01"), waveFloorPlaneSmallEmptyArrowhead.getSymbol());
		waveFloorPlaneSmallEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-004-02-01-01"), waveFloorPlaneSmallEmptyArrowhead.getSymbol());
		waveFloorPlaneSmallEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-004-02-02-01"), waveFloorPlaneSmallEmptyArrowhead.getSymbol());

		waveFloorPlaneSmallSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-004-02-01-01"), waveFloorPlaneSmallSchemaArrowhead.getSymbol());
		waveFloorPlaneSmallSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-004-02-02-01"), waveFloorPlaneSmallSchemaArrowhead.getSymbol());
		waveFloorPlaneSmallSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-004-02-03-01"), waveFloorPlaneSmallSchemaArrowhead.getSymbol());

		waveFloorPlaneSmallMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-004-02-02-09"), waveFloorPlaneSmallMirrored.getSymbol());
		waveFloorPlaneSmallMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-004-02-03-09"), waveFloorPlaneSmallMirrored.getSymbol());
		waveFloorPlaneSmallMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-004-02-01-09"), waveFloorPlaneSmallMirrored.getSymbol());

		waveFloorPlaneSmallEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-004-02-03-09"),
				waveFloorPlaneSmallEmptyArrowheadMirrored.getSymbol());
		waveFloorPlaneSmallEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-004-02-01-09"),
				waveFloorPlaneSmallEmptyArrowheadMirrored.getSymbol());
		waveFloorPlaneSmallEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-004-02-02-09"),
				waveFloorPlaneSmallEmptyArrowheadMirrored.getSymbol());

		waveFloorPlaneSmallSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-004-02-01-09"),
				waveFloorPlaneSmallSchemaArrowheadMirrored.getSymbol());
		waveFloorPlaneSmallSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-004-02-02-09"),
				waveFloorPlaneSmallSchemaArrowheadMirrored.getSymbol());
		waveFloorPlaneSmallSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-004-02-03-09"),
				waveFloorPlaneSmallSchemaArrowheadMirrored.getSymbol());

		waveFloorPlaneLarge.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-004-03-02-01"), waveFloorPlaneLarge.getSymbol());
		waveFloorPlaneLarge.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-004-03-03-01"), waveFloorPlaneLarge.getSymbol());
		waveFloorPlaneLarge.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-004-03-01-01"), waveFloorPlaneLarge.getSymbol());

		waveFloorPlaneLargeEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-004-03-03-01"), waveFloorPlaneLargeEmptyArrowhead.getSymbol());
		waveFloorPlaneLargeEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-004-03-01-01"), waveFloorPlaneLargeEmptyArrowhead.getSymbol());
		waveFloorPlaneLargeEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-004-03-02-01"), waveFloorPlaneLargeEmptyArrowhead.getSymbol());

		waveFloorPlaneLargeSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-004-03-01-01"), waveFloorPlaneLargeSchemaArrowhead.getSymbol());
		waveFloorPlaneLargeSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-004-03-02-01"), waveFloorPlaneLargeSchemaArrowhead.getSymbol());
		waveFloorPlaneLargeSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-004-03-03-01"), waveFloorPlaneLargeSchemaArrowhead.getSymbol());

		waveFloorPlaneLargeMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-004-03-02-09"), waveFloorPlaneLargeMirrored.getSymbol());
		waveFloorPlaneLargeMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-004-03-03-09"), waveFloorPlaneLargeMirrored.getSymbol());
		waveFloorPlaneLargeMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-004-03-01-09"), waveFloorPlaneLargeMirrored.getSymbol());

		waveFloorPlaneLargeEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-004-03-03-09"),
				waveFloorPlaneLargeEmptyArrowheadMirrored.getSymbol());
		waveFloorPlaneLargeEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-004-03-01-09"),
				waveFloorPlaneLargeEmptyArrowheadMirrored.getSymbol());
		waveFloorPlaneLargeEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-004-03-02-09"),
				waveFloorPlaneLargeEmptyArrowheadMirrored.getSymbol());

		waveFloorPlaneLargeSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-004-03-01-09"),
				waveFloorPlaneLargeSchemaArrowheadMirrored.getSymbol());
		waveFloorPlaneLargeSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-004-03-02-09"),
				waveFloorPlaneLargeSchemaArrowheadMirrored.getSymbol());
		waveFloorPlaneLargeSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-004-03-03-09"),
				waveFloorPlaneLargeSchemaArrowheadMirrored.getSymbol());

		rotationSingleFloorPlane.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-005-01-02-01"), rotationSingleFloorPlane.getSymbol());
		rotationSingleFloorPlane.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-005-01-03-01"), rotationSingleFloorPlane.getSymbol());
		rotationSingleFloorPlane.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-005-01-01-01"), rotationSingleFloorPlane.getSymbol());

		rotationSingleFloorPlaneEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-005-01-03-01"),
				rotationSingleFloorPlaneEmptyArrowhead.getSymbol());
		rotationSingleFloorPlaneEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-005-01-01-01"),
				rotationSingleFloorPlaneEmptyArrowhead.getSymbol());
		rotationSingleFloorPlaneEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-005-01-02-01"),
				rotationSingleFloorPlaneEmptyArrowhead.getSymbol());

		rotationSingleFloorPlaneSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-005-01-01-01"),
				rotationSingleFloorPlaneSchemaArrowhead.getSymbol());
		rotationSingleFloorPlaneSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-005-01-02-01"),
				rotationSingleFloorPlaneSchemaArrowhead.getSymbol());
		rotationSingleFloorPlaneSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-005-01-03-01"),
				rotationSingleFloorPlaneSchemaArrowhead.getSymbol());

		rotationSingleFloorPlaneMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-005-01-02-09"), rotationSingleFloorPlaneMirrored.getSymbol());
		rotationSingleFloorPlaneMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-005-01-03-09"), rotationSingleFloorPlaneMirrored.getSymbol());
		rotationSingleFloorPlaneMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-005-01-01-09"), rotationSingleFloorPlaneMirrored.getSymbol());

		rotationSingleFloorPlaneEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-005-01-03-09"),
				rotationSingleFloorPlaneEmptyArrowheadMirrored.getSymbol());
		rotationSingleFloorPlaneEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-005-01-01-09"),
				rotationSingleFloorPlaneEmptyArrowheadMirrored.getSymbol());
		rotationSingleFloorPlaneEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-005-01-02-09"),
				rotationSingleFloorPlaneEmptyArrowheadMirrored.getSymbol());

		rotationSingleFloorPlaneSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-005-01-01-09"),
				rotationSingleFloorPlaneSchemaArrowheadMirrored.getSymbol());
		rotationSingleFloorPlaneSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-005-01-02-09"),
				rotationSingleFloorPlaneSchemaArrowheadMirrored.getSymbol());
		rotationSingleFloorPlaneSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-005-01-03-09"),
				rotationSingleFloorPlaneSchemaArrowheadMirrored.getSymbol());

		rotationDoubleFloorPlane.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-006-01-02-01"), rotationDoubleFloorPlane.getSymbol());
		rotationDoubleFloorPlane.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-006-01-03-01"), rotationDoubleFloorPlane.getSymbol());
		rotationDoubleFloorPlane.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-006-01-01-01"), rotationDoubleFloorPlane.getSymbol());

		rotationDoubleFloorPlaneEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-006-01-03-01"),
				rotationDoubleFloorPlaneEmptyArrowhead.getSymbol());
		rotationDoubleFloorPlaneEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-006-01-01-01"),
				rotationDoubleFloorPlaneEmptyArrowhead.getSymbol());
		rotationDoubleFloorPlaneEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-006-01-02-01"),
				rotationDoubleFloorPlaneEmptyArrowhead.getSymbol());

		rotationDoubleFloorPlaneSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-006-01-01-01"),
				rotationDoubleFloorPlaneSchemaArrowhead.getSymbol());
		rotationDoubleFloorPlaneSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-006-01-02-01"),
				rotationDoubleFloorPlaneSchemaArrowhead.getSymbol());
		rotationDoubleFloorPlaneSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-006-01-03-01"),
				rotationDoubleFloorPlaneSchemaArrowhead.getSymbol());

		rotationDoubleFloorPlaneMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-006-01-02-09"), rotationDoubleFloorPlaneMirrored.getSymbol());
		rotationDoubleFloorPlaneMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-006-01-03-09"), rotationDoubleFloorPlaneMirrored.getSymbol());
		rotationDoubleFloorPlaneMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-006-01-01-09"), rotationDoubleFloorPlaneMirrored.getSymbol());

		rotationDoubleFloorPlaneEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-006-01-03-09"),
				rotationDoubleFloorPlaneEmptyArrowheadMirrored.getSymbol());
		rotationDoubleFloorPlaneEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-006-01-01-09"),
				rotationDoubleFloorPlaneEmptyArrowheadMirrored.getSymbol());
		rotationDoubleFloorPlaneEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-006-01-02-09"),
				rotationDoubleFloorPlaneEmptyArrowheadMirrored.getSymbol());

		rotationDoubleFloorPlaneSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-006-01-01-09"),
				rotationDoubleFloorPlaneSchemaArrowheadMirrored.getSymbol());
		rotationDoubleFloorPlaneSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-006-01-02-09"),
				rotationDoubleFloorPlaneSchemaArrowheadMirrored.getSymbol());
		rotationDoubleFloorPlaneSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-006-01-03-09"),
				rotationDoubleFloorPlaneSchemaArrowheadMirrored.getSymbol());

		rotationAlternatingFloorPlane.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-007-01-02-01"), rotationAlternatingFloorPlane.getSymbol());
		rotationAlternatingFloorPlane.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-007-01-03-01"), rotationAlternatingFloorPlane.getSymbol());
		rotationAlternatingFloorPlane.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-007-01-01-01"), rotationAlternatingFloorPlane.getSymbol());

		rotationAlternatingFloorPlaneEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-007-01-03-01"),
				rotationAlternatingFloorPlaneEmptyArrowhead.getSymbol());
		rotationAlternatingFloorPlaneEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-007-01-01-01"),
				rotationAlternatingFloorPlaneEmptyArrowhead.getSymbol());
		rotationAlternatingFloorPlaneEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-007-01-02-01"),
				rotationAlternatingFloorPlaneEmptyArrowhead.getSymbol());

		rotationAlternatingFloorPlaneSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-007-01-01-01"),
				rotationAlternatingFloorPlaneSchemaArrowhead.getSymbol());
		rotationAlternatingFloorPlaneSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-007-01-02-01"),
				rotationAlternatingFloorPlaneSchemaArrowhead.getSymbol());
		rotationAlternatingFloorPlaneSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-007-01-03-01"),
				rotationAlternatingFloorPlaneSchemaArrowhead.getSymbol());

		rotationAlternatingFloorPlaneMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-007-01-02-09"),
				rotationAlternatingFloorPlaneMirrored.getSymbol());
		rotationAlternatingFloorPlaneMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-007-01-03-09"),
				rotationAlternatingFloorPlaneMirrored.getSymbol());
		rotationAlternatingFloorPlaneMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-007-01-01-09"),
				rotationAlternatingFloorPlaneMirrored.getSymbol());

		rotationAlternatingFloorPlaneEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-007-01-03-09"),
				rotationAlternatingFloorPlaneEmptyArrowheadMirrored.getSymbol());
		rotationAlternatingFloorPlaneEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-007-01-01-09"),
				rotationAlternatingFloorPlaneEmptyArrowheadMirrored.getSymbol());
		rotationAlternatingFloorPlaneEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-007-01-02-09"),
				rotationAlternatingFloorPlaneEmptyArrowheadMirrored.getSymbol());

		rotationAlternatingFloorPlaneSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-007-01-01-09"),
				rotationAlternatingFloorPlaneSchemaArrowheadMirrored.getSymbol());
		rotationAlternatingFloorPlaneSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-007-01-02-09"),
				rotationAlternatingFloorPlaneSchemaArrowheadMirrored.getSymbol());
		rotationAlternatingFloorPlaneSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-007-01-03-09"),
				rotationAlternatingFloorPlaneSchemaArrowheadMirrored.getSymbol());

		shakingParallelFloor.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-008-01-02-01"), shakingParallelFloor.getSymbol());
		shakingParallelFloor.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-008-01-03-01"), shakingParallelFloor.getSymbol());
		shakingParallelFloor.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-008-01-01-01"), shakingParallelFloor.getSymbol());

		shakingParallelFloorEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-008-01-03-01"), shakingParallelFloorEmptyArrowhead.getSymbol());
		shakingParallelFloorEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-008-01-01-01"), shakingParallelFloorEmptyArrowhead.getSymbol());
		shakingParallelFloorEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-008-01-02-01"), shakingParallelFloorEmptyArrowhead.getSymbol());

		shakingParallelFloorSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-008-01-01-01"), shakingParallelFloorSchemaArrowhead.getSymbol());
		shakingParallelFloorSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-008-01-02-01"), shakingParallelFloorSchemaArrowhead.getSymbol());
		shakingParallelFloorSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-008-01-03-01"), shakingParallelFloorSchemaArrowhead.getSymbol());

		shakingParallelFloorMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-008-01-02-09"), shakingParallelFloorMirrored.getSymbol());
		shakingParallelFloorMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-008-01-03-09"), shakingParallelFloorMirrored.getSymbol());
		shakingParallelFloorMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-008-01-01-09"), shakingParallelFloorMirrored.getSymbol());

		shakingParallelFloorEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-008-01-03-09"),
				shakingParallelFloorEmptyArrowheadMirrored.getSymbol());
		shakingParallelFloorEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-008-01-01-09"),
				shakingParallelFloorEmptyArrowheadMirrored.getSymbol());
		shakingParallelFloorEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-008-01-02-09"),
				shakingParallelFloorEmptyArrowheadMirrored.getSymbol());

		shakingParallelFloorSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-008-01-01-09"),
				shakingParallelFloorSchemaArrowheadMirrored.getSymbol());
		shakingParallelFloorSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-008-01-02-09"),
				shakingParallelFloorSchemaArrowheadMirrored.getSymbol());
		shakingParallelFloorSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-09-008-01-03-09"),
				shakingParallelFloorSchemaArrowheadMirrored.getSymbol());

	}

	@Override
	public void testCanSwitchToNormalArrows() {

		assertFalse(curveFloorPlaneSmall.canSwitchToNormalArrows());
		assertFalse(curveFloorPlaneSmallEmptyArrowhead.canSwitchToNormalArrows());
		assertFalse(curveFloorPlaneSmallSchemaArrowhead.canSwitchToNormalArrows());
		assertFalse(curveFloorPlaneSmallMirrored.canSwitchToNormalArrows());
		assertFalse(curveFloorPlaneSmallEmptyArrowheadMirrored.canSwitchToNormalArrows());
		assertFalse(curveFloorPlaneSmallSchemaArrowheadMirrored.canSwitchToNormalArrows());

		assertFalse(curveFloorPlaneMedium1.canSwitchToNormalArrows());
		assertFalse(curveFloorPlaneMedium1EmptyArrowhead.canSwitchToNormalArrows());
		assertFalse(curveFloorPlaneMedium1SchemaArrowhead.canSwitchToNormalArrows());
		assertFalse(curveFloorPlaneMedium1Mirrored.canSwitchToNormalArrows());
		assertFalse(curveFloorPlaneMedium1EmptyArrowheadMirrored.canSwitchToNormalArrows());
		assertFalse(curveFloorPlaneMedium1SchemaArrowheadMirrored.canSwitchToNormalArrows());

		assertFalse(curveFloorPlaneMedium2.canSwitchToNormalArrows());
		assertFalse(curveFloorPlaneMedium2EmptyArrowhead.canSwitchToNormalArrows());
		assertFalse(curveFloorPlaneMedium2SchemaArrowhead.canSwitchToNormalArrows());
		assertFalse(curveFloorPlaneMedium2Mirrored.canSwitchToNormalArrows());
		assertFalse(curveFloorPlaneMedium2EmptyArrowheadMirrored.canSwitchToNormalArrows());
		assertFalse(curveFloorPlaneMedium2SchemaArrowheadMirrored.canSwitchToNormalArrows());

		assertFalse(curveFloorPlaneLarge.canSwitchToNormalArrows());
		assertFalse(curveFloorPlaneLargeEmptyArrowhead.canSwitchToNormalArrows());
		assertFalse(curveFloorPlaneLargeSchemaArrowhead.canSwitchToNormalArrows());
		assertFalse(curveFloorPlaneLargeMirrored.canSwitchToNormalArrows());
		assertFalse(curveFloorPlaneLargeEmptyArrowheadMirrored.canSwitchToNormalArrows());
		assertFalse(curveFloorPlaneLargeSchemaArrowheadMirrored.canSwitchToNormalArrows());

		assertFalse(curveFloorPlaneCombined.canSwitchToNormalArrows());
		assertFalse(curveFloorPlaneCombinedEmptyArrowhead.canSwitchToNormalArrows());
		assertFalse(curveFloorPlaneCombinedSchemaArrowhead.canSwitchToNormalArrows());
		assertFalse(curveFloorPlaneCombinedMirrored.canSwitchToNormalArrows());
		assertFalse(curveFloorPlaneCombinedEmptyArrowheadMirrored.canSwitchToNormalArrows());
		assertFalse(curveFloorPlaneCombinedSchemaArrowheadMirrored.canSwitchToNormalArrows());

		assertFalse(humpFloorPlaneSmall.canSwitchToNormalArrows());
		assertFalse(humpFloorPlaneSmallEmptyArrowhead.canSwitchToNormalArrows());
		assertFalse(humpFloorPlaneSmallSchemaArrowhead.canSwitchToNormalArrows());
		assertFalse(humpFloorPlaneSmallMirrored.canSwitchToNormalArrows());
		assertFalse(humpFloorPlaneSmallEmptyArrowheadMirrored.canSwitchToNormalArrows());
		assertFalse(humpFloorPlaneSmallSchemaArrowheadMirrored.canSwitchToNormalArrows());

		assertFalse(loopFloorPlaneSmall.canSwitchToNormalArrows());
		assertFalse(loopFloorPlaneSmallEmptyArrowhead.canSwitchToNormalArrows());
		assertFalse(loopFloorPlaneSmallSchemaArrowhead.canSwitchToNormalArrows());
		assertFalse(loopFloorPlaneSmallMirrored.canSwitchToNormalArrows());
		assertFalse(loopFloorPlaneSmallEmptyArrowheadMirrored.canSwitchToNormalArrows());
		assertFalse(loopFloorPlaneSmallSchemaArrowheadMirrored.canSwitchToNormalArrows());

		assertFalse(waveFloorPlaneSnake.canSwitchToNormalArrows());
		assertFalse(waveFloorPlaneSnakeEmptyArrowhead.canSwitchToNormalArrows());
		assertFalse(waveFloorPlaneSnakeSchemaArrowhead.canSwitchToNormalArrows());
		assertFalse(waveFloorPlaneSnakeMirrored.canSwitchToNormalArrows());
		assertFalse(waveFloorPlaneSnakeEmptyArrowheadMirrored.canSwitchToNormalArrows());
		assertFalse(waveFloorPlaneSnakeSchemaArrowheadMirrored.canSwitchToNormalArrows());

		assertFalse(waveFloorPlaneSmall.canSwitchToNormalArrows());
		assertFalse(waveFloorPlaneSmallEmptyArrowhead.canSwitchToNormalArrows());
		assertFalse(waveFloorPlaneSmallSchemaArrowhead.canSwitchToNormalArrows());
		assertFalse(waveFloorPlaneSmallMirrored.canSwitchToNormalArrows());
		assertFalse(waveFloorPlaneSmallEmptyArrowheadMirrored.canSwitchToNormalArrows());
		assertFalse(waveFloorPlaneSmallSchemaArrowheadMirrored.canSwitchToNormalArrows());

		assertFalse(waveFloorPlaneLarge.canSwitchToNormalArrows());
		assertFalse(waveFloorPlaneLargeEmptyArrowhead.canSwitchToNormalArrows());
		assertFalse(waveFloorPlaneLargeSchemaArrowhead.canSwitchToNormalArrows());
		assertFalse(waveFloorPlaneLargeMirrored.canSwitchToNormalArrows());
		assertFalse(waveFloorPlaneLargeEmptyArrowheadMirrored.canSwitchToNormalArrows());
		assertFalse(waveFloorPlaneLargeSchemaArrowheadMirrored.canSwitchToNormalArrows());

		assertFalse(rotationSingleFloorPlane.canSwitchToNormalArrows());
		assertFalse(rotationSingleFloorPlaneEmptyArrowhead.canSwitchToNormalArrows());
		assertFalse(rotationSingleFloorPlaneSchemaArrowhead.canSwitchToNormalArrows());
		assertFalse(rotationSingleFloorPlaneMirrored.canSwitchToNormalArrows());
		assertFalse(rotationSingleFloorPlaneEmptyArrowheadMirrored.canSwitchToNormalArrows());
		assertFalse(rotationSingleFloorPlaneSchemaArrowheadMirrored.canSwitchToNormalArrows());

		assertFalse(rotationDoubleFloorPlane.canSwitchToNormalArrows());
		assertFalse(rotationDoubleFloorPlaneEmptyArrowhead.canSwitchToNormalArrows());
		assertFalse(rotationDoubleFloorPlaneSchemaArrowhead.canSwitchToNormalArrows());
		assertFalse(rotationDoubleFloorPlaneMirrored.canSwitchToNormalArrows());
		assertFalse(rotationDoubleFloorPlaneEmptyArrowheadMirrored.canSwitchToNormalArrows());
		assertFalse(rotationDoubleFloorPlaneSchemaArrowheadMirrored.canSwitchToNormalArrows());

		assertTrue(rotationAlternatingFloorPlane.canSwitchToNormalArrows());
		assertTrue(rotationAlternatingFloorPlaneEmptyArrowhead.canSwitchToNormalArrows());
		assertTrue(rotationAlternatingFloorPlaneSchemaArrowhead.canSwitchToNormalArrows());
		assertTrue(rotationAlternatingFloorPlaneMirrored.canSwitchToNormalArrows());
		assertTrue(rotationAlternatingFloorPlaneEmptyArrowheadMirrored.canSwitchToNormalArrows());
		assertTrue(rotationAlternatingFloorPlaneSchemaArrowheadMirrored.canSwitchToNormalArrows());

		assertFalse(shakingParallelFloor.canSwitchToNormalArrows());
		assertFalse(shakingParallelFloorEmptyArrowhead.canSwitchToNormalArrows());
		assertFalse(shakingParallelFloorSchemaArrowhead.canSwitchToNormalArrows());
		assertFalse(shakingParallelFloorMirrored.canSwitchToNormalArrows());
		assertFalse(shakingParallelFloorEmptyArrowheadMirrored.canSwitchToNormalArrows());
		assertFalse(shakingParallelFloorSchemaArrowheadMirrored.canSwitchToNormalArrows());

	}

	@Override
	public void testSwitchToNormalArrows() {

		rotationAlternatingFloorPlane.switchToNormalArrows();
		assertEquals(rotationDoubleFloorPlane.getSymbol(), rotationAlternatingFloorPlane.getSymbol());

		rotationAlternatingFloorPlaneEmptyArrowhead.switchToNormalArrows();
		assertEquals(rotationDoubleFloorPlaneEmptyArrowhead.getSymbol(),
				rotationAlternatingFloorPlaneEmptyArrowhead.getSymbol());

		rotationAlternatingFloorPlaneSchemaArrowhead.switchToNormalArrows();
		assertEquals(rotationDoubleFloorPlaneSchemaArrowhead.getSymbol(),
				rotationAlternatingFloorPlaneSchemaArrowhead.getSymbol());

		rotationAlternatingFloorPlaneMirrored.switchToNormalArrows();
		assertEquals(rotationDoubleFloorPlaneMirrored.getSymbol(), rotationAlternatingFloorPlaneMirrored.getSymbol());

		rotationAlternatingFloorPlaneEmptyArrowheadMirrored.switchToNormalArrows();
		assertEquals(rotationDoubleFloorPlaneEmptyArrowheadMirrored.getSymbol(),
				rotationAlternatingFloorPlaneEmptyArrowheadMirrored.getSymbol());

		rotationAlternatingFloorPlaneSchemaArrowheadMirrored.switchToNormalArrows();
		assertEquals(rotationDoubleFloorPlaneSchemaArrowheadMirrored.getSymbol(),
				rotationAlternatingFloorPlaneSchemaArrowheadMirrored.getSymbol());

	}

	@Override
	public void testCanSwitchToAlternatingArrows() {

		assertFalse(curveFloorPlaneSmall.canSwitchToAlternatingArrows());
		assertFalse(curveFloorPlaneSmallEmptyArrowhead.canSwitchToAlternatingArrows());
		assertFalse(curveFloorPlaneSmallSchemaArrowhead.canSwitchToAlternatingArrows());
		assertFalse(curveFloorPlaneSmallMirrored.canSwitchToAlternatingArrows());
		assertFalse(curveFloorPlaneSmallEmptyArrowheadMirrored.canSwitchToAlternatingArrows());
		assertFalse(curveFloorPlaneSmallSchemaArrowheadMirrored.canSwitchToAlternatingArrows());

		assertFalse(curveFloorPlaneMedium1.canSwitchToAlternatingArrows());
		assertFalse(curveFloorPlaneMedium1EmptyArrowhead.canSwitchToAlternatingArrows());
		assertFalse(curveFloorPlaneMedium1SchemaArrowhead.canSwitchToAlternatingArrows());
		assertFalse(curveFloorPlaneMedium1Mirrored.canSwitchToAlternatingArrows());
		assertFalse(curveFloorPlaneMedium1EmptyArrowheadMirrored.canSwitchToAlternatingArrows());
		assertFalse(curveFloorPlaneMedium1SchemaArrowheadMirrored.canSwitchToAlternatingArrows());

		assertFalse(curveFloorPlaneMedium2.canSwitchToAlternatingArrows());
		assertFalse(curveFloorPlaneMedium2EmptyArrowhead.canSwitchToAlternatingArrows());
		assertFalse(curveFloorPlaneMedium2SchemaArrowhead.canSwitchToAlternatingArrows());
		assertFalse(curveFloorPlaneMedium2Mirrored.canSwitchToAlternatingArrows());
		assertFalse(curveFloorPlaneMedium2EmptyArrowheadMirrored.canSwitchToAlternatingArrows());
		assertFalse(curveFloorPlaneMedium2SchemaArrowheadMirrored.canSwitchToAlternatingArrows());

		assertFalse(curveFloorPlaneLarge.canSwitchToAlternatingArrows());
		assertFalse(curveFloorPlaneLargeEmptyArrowhead.canSwitchToAlternatingArrows());
		assertFalse(curveFloorPlaneLargeSchemaArrowhead.canSwitchToAlternatingArrows());
		assertFalse(curveFloorPlaneLargeMirrored.canSwitchToAlternatingArrows());
		assertFalse(curveFloorPlaneLargeEmptyArrowheadMirrored.canSwitchToAlternatingArrows());
		assertFalse(curveFloorPlaneLargeSchemaArrowheadMirrored.canSwitchToAlternatingArrows());

		assertFalse(curveFloorPlaneCombined.canSwitchToAlternatingArrows());
		assertFalse(curveFloorPlaneCombinedEmptyArrowhead.canSwitchToAlternatingArrows());
		assertFalse(curveFloorPlaneCombinedSchemaArrowhead.canSwitchToAlternatingArrows());
		assertFalse(curveFloorPlaneCombinedMirrored.canSwitchToAlternatingArrows());
		assertFalse(curveFloorPlaneCombinedEmptyArrowheadMirrored.canSwitchToAlternatingArrows());
		assertFalse(curveFloorPlaneCombinedSchemaArrowheadMirrored.canSwitchToAlternatingArrows());

		assertFalse(humpFloorPlaneSmall.canSwitchToAlternatingArrows());
		assertFalse(humpFloorPlaneSmallEmptyArrowhead.canSwitchToAlternatingArrows());
		assertFalse(humpFloorPlaneSmallSchemaArrowhead.canSwitchToAlternatingArrows());
		assertFalse(humpFloorPlaneSmallMirrored.canSwitchToAlternatingArrows());
		assertFalse(humpFloorPlaneSmallEmptyArrowheadMirrored.canSwitchToAlternatingArrows());
		assertFalse(humpFloorPlaneSmallSchemaArrowheadMirrored.canSwitchToAlternatingArrows());

		assertFalse(loopFloorPlaneSmall.canSwitchToAlternatingArrows());
		assertFalse(loopFloorPlaneSmallEmptyArrowhead.canSwitchToAlternatingArrows());
		assertFalse(loopFloorPlaneSmallSchemaArrowhead.canSwitchToAlternatingArrows());
		assertFalse(loopFloorPlaneSmallMirrored.canSwitchToAlternatingArrows());
		assertFalse(loopFloorPlaneSmallEmptyArrowheadMirrored.canSwitchToAlternatingArrows());
		assertFalse(loopFloorPlaneSmallSchemaArrowheadMirrored.canSwitchToAlternatingArrows());

		assertFalse(waveFloorPlaneSnake.canSwitchToAlternatingArrows());
		assertFalse(waveFloorPlaneSnakeEmptyArrowhead.canSwitchToAlternatingArrows());
		assertFalse(waveFloorPlaneSnakeSchemaArrowhead.canSwitchToAlternatingArrows());
		assertFalse(waveFloorPlaneSnakeMirrored.canSwitchToAlternatingArrows());
		assertFalse(waveFloorPlaneSnakeEmptyArrowheadMirrored.canSwitchToAlternatingArrows());
		assertFalse(waveFloorPlaneSnakeSchemaArrowheadMirrored.canSwitchToAlternatingArrows());

		assertFalse(waveFloorPlaneSmall.canSwitchToAlternatingArrows());
		assertFalse(waveFloorPlaneSmallEmptyArrowhead.canSwitchToAlternatingArrows());
		assertFalse(waveFloorPlaneSmallSchemaArrowhead.canSwitchToAlternatingArrows());
		assertFalse(waveFloorPlaneSmallMirrored.canSwitchToAlternatingArrows());
		assertFalse(waveFloorPlaneSmallEmptyArrowheadMirrored.canSwitchToAlternatingArrows());
		assertFalse(waveFloorPlaneSmallSchemaArrowheadMirrored.canSwitchToAlternatingArrows());

		assertFalse(waveFloorPlaneLarge.canSwitchToAlternatingArrows());
		assertFalse(waveFloorPlaneLargeEmptyArrowhead.canSwitchToAlternatingArrows());
		assertFalse(waveFloorPlaneLargeSchemaArrowhead.canSwitchToAlternatingArrows());
		assertFalse(waveFloorPlaneLargeMirrored.canSwitchToAlternatingArrows());
		assertFalse(waveFloorPlaneLargeEmptyArrowheadMirrored.canSwitchToAlternatingArrows());
		assertFalse(waveFloorPlaneLargeSchemaArrowheadMirrored.canSwitchToAlternatingArrows());

		assertFalse(rotationSingleFloorPlane.canSwitchToAlternatingArrows());
		assertFalse(rotationSingleFloorPlaneEmptyArrowhead.canSwitchToAlternatingArrows());
		assertFalse(rotationSingleFloorPlaneSchemaArrowhead.canSwitchToAlternatingArrows());
		assertFalse(rotationSingleFloorPlaneMirrored.canSwitchToAlternatingArrows());
		assertFalse(rotationSingleFloorPlaneEmptyArrowheadMirrored.canSwitchToAlternatingArrows());
		assertFalse(rotationSingleFloorPlaneSchemaArrowheadMirrored.canSwitchToAlternatingArrows());

		assertTrue(rotationDoubleFloorPlane.canSwitchToAlternatingArrows());
		assertTrue(rotationDoubleFloorPlaneEmptyArrowhead.canSwitchToAlternatingArrows());
		assertTrue(rotationDoubleFloorPlaneSchemaArrowhead.canSwitchToAlternatingArrows());
		assertTrue(rotationDoubleFloorPlaneMirrored.canSwitchToAlternatingArrows());
		assertTrue(rotationDoubleFloorPlaneEmptyArrowheadMirrored.canSwitchToAlternatingArrows());
		assertTrue(rotationDoubleFloorPlaneSchemaArrowheadMirrored.canSwitchToAlternatingArrows());

		assertFalse(rotationAlternatingFloorPlane.canSwitchToAlternatingArrows());
		assertFalse(rotationAlternatingFloorPlaneEmptyArrowhead.canSwitchToAlternatingArrows());
		assertFalse(rotationAlternatingFloorPlaneSchemaArrowhead.canSwitchToAlternatingArrows());
		assertFalse(rotationAlternatingFloorPlaneMirrored.canSwitchToAlternatingArrows());
		assertFalse(rotationAlternatingFloorPlaneEmptyArrowheadMirrored.canSwitchToAlternatingArrows());
		assertFalse(rotationAlternatingFloorPlaneSchemaArrowheadMirrored.canSwitchToAlternatingArrows());

		assertFalse(shakingParallelFloor.canSwitchToAlternatingArrows());
		assertFalse(shakingParallelFloorEmptyArrowhead.canSwitchToAlternatingArrows());
		assertFalse(shakingParallelFloorSchemaArrowhead.canSwitchToAlternatingArrows());
		assertFalse(shakingParallelFloorMirrored.canSwitchToAlternatingArrows());
		assertFalse(shakingParallelFloorEmptyArrowheadMirrored.canSwitchToAlternatingArrows());
		assertFalse(shakingParallelFloorSchemaArrowheadMirrored.canSwitchToAlternatingArrows());

	}

	@Override
	public void testSwitchToAlternatingArrows() {

		rotationDoubleFloorPlane.switchToAlternatingArrows();
		assertEquals(rotationAlternatingFloorPlane.getSymbol(), rotationDoubleFloorPlane.getSymbol());

		rotationDoubleFloorPlaneEmptyArrowhead.switchToAlternatingArrows();
		assertEquals(rotationAlternatingFloorPlaneEmptyArrowhead.getSymbol(),
				rotationDoubleFloorPlaneEmptyArrowhead.getSymbol());

		rotationDoubleFloorPlaneSchemaArrowhead.switchToAlternatingArrows();
		assertEquals(rotationAlternatingFloorPlaneSchemaArrowhead.getSymbol(),
				rotationDoubleFloorPlaneSchemaArrowhead.getSymbol());

		rotationDoubleFloorPlaneMirrored.switchToAlternatingArrows();
		assertEquals(rotationAlternatingFloorPlaneMirrored.getSymbol(), rotationDoubleFloorPlaneMirrored.getSymbol());

		rotationDoubleFloorPlaneEmptyArrowheadMirrored.switchToAlternatingArrows();
		assertEquals(rotationAlternatingFloorPlaneEmptyArrowheadMirrored.getSymbol(),
				rotationDoubleFloorPlaneEmptyArrowheadMirrored.getSymbol());

		rotationDoubleFloorPlaneSchemaArrowheadMirrored.switchToAlternatingArrows();
		assertEquals(rotationAlternatingFloorPlaneSchemaArrowheadMirrored.getSymbol(),
				rotationDoubleFloorPlaneSchemaArrowheadMirrored.getSymbol());

	}

	@Override
	public void testCanSwitchStartingPoint() {

		assertFalse(curveFloorPlaneSmall.canSwitchStartingPoint());
		assertFalse(curveFloorPlaneSmallEmptyArrowhead.canSwitchStartingPoint());
		assertFalse(curveFloorPlaneSmallSchemaArrowhead.canSwitchStartingPoint());
		assertFalse(curveFloorPlaneSmallMirrored.canSwitchStartingPoint());
		assertFalse(curveFloorPlaneSmallEmptyArrowheadMirrored.canSwitchStartingPoint());
		assertFalse(curveFloorPlaneSmallSchemaArrowheadMirrored.canSwitchStartingPoint());

		assertFalse(curveFloorPlaneMedium1.canSwitchStartingPoint());
		assertFalse(curveFloorPlaneMedium1EmptyArrowhead.canSwitchStartingPoint());
		assertFalse(curveFloorPlaneMedium1SchemaArrowhead.canSwitchStartingPoint());
		assertFalse(curveFloorPlaneMedium1Mirrored.canSwitchStartingPoint());
		assertFalse(curveFloorPlaneMedium1EmptyArrowheadMirrored.canSwitchStartingPoint());
		assertFalse(curveFloorPlaneMedium1SchemaArrowheadMirrored.canSwitchStartingPoint());

		assertFalse(curveFloorPlaneMedium2.canSwitchStartingPoint());
		assertFalse(curveFloorPlaneMedium2EmptyArrowhead.canSwitchStartingPoint());
		assertFalse(curveFloorPlaneMedium2SchemaArrowhead.canSwitchStartingPoint());
		assertFalse(curveFloorPlaneMedium2Mirrored.canSwitchStartingPoint());
		assertFalse(curveFloorPlaneMedium2EmptyArrowheadMirrored.canSwitchStartingPoint());
		assertFalse(curveFloorPlaneMedium2SchemaArrowheadMirrored.canSwitchStartingPoint());

		assertFalse(curveFloorPlaneLarge.canSwitchStartingPoint());
		assertFalse(curveFloorPlaneLargeEmptyArrowhead.canSwitchStartingPoint());
		assertFalse(curveFloorPlaneLargeSchemaArrowhead.canSwitchStartingPoint());
		assertFalse(curveFloorPlaneLargeMirrored.canSwitchStartingPoint());
		assertFalse(curveFloorPlaneLargeEmptyArrowheadMirrored.canSwitchStartingPoint());
		assertFalse(curveFloorPlaneLargeSchemaArrowheadMirrored.canSwitchStartingPoint());

		assertFalse(curveFloorPlaneCombined.canSwitchStartingPoint());
		assertFalse(curveFloorPlaneCombinedEmptyArrowhead.canSwitchStartingPoint());
		assertFalse(curveFloorPlaneCombinedSchemaArrowhead.canSwitchStartingPoint());
		assertFalse(curveFloorPlaneCombinedMirrored.canSwitchStartingPoint());
		assertFalse(curveFloorPlaneCombinedEmptyArrowheadMirrored.canSwitchStartingPoint());
		assertFalse(curveFloorPlaneCombinedSchemaArrowheadMirrored.canSwitchStartingPoint());

		assertFalse(humpFloorPlaneSmall.canSwitchStartingPoint());
		assertFalse(humpFloorPlaneSmallEmptyArrowhead.canSwitchStartingPoint());
		assertFalse(humpFloorPlaneSmallSchemaArrowhead.canSwitchStartingPoint());
		assertFalse(humpFloorPlaneSmallMirrored.canSwitchStartingPoint());
		assertFalse(humpFloorPlaneSmallEmptyArrowheadMirrored.canSwitchStartingPoint());
		assertFalse(humpFloorPlaneSmallSchemaArrowheadMirrored.canSwitchStartingPoint());

		assertFalse(loopFloorPlaneSmall.canSwitchStartingPoint());
		assertFalse(loopFloorPlaneSmallEmptyArrowhead.canSwitchStartingPoint());
		assertFalse(loopFloorPlaneSmallSchemaArrowhead.canSwitchStartingPoint());
		assertFalse(loopFloorPlaneSmallMirrored.canSwitchStartingPoint());
		assertFalse(loopFloorPlaneSmallEmptyArrowheadMirrored.canSwitchStartingPoint());
		assertFalse(loopFloorPlaneSmallSchemaArrowheadMirrored.canSwitchStartingPoint());

		assertFalse(waveFloorPlaneSnake.canSwitchStartingPoint());
		assertFalse(waveFloorPlaneSnakeEmptyArrowhead.canSwitchStartingPoint());
		assertFalse(waveFloorPlaneSnakeSchemaArrowhead.canSwitchStartingPoint());
		assertFalse(waveFloorPlaneSnakeMirrored.canSwitchStartingPoint());
		assertFalse(waveFloorPlaneSnakeEmptyArrowheadMirrored.canSwitchStartingPoint());
		assertFalse(waveFloorPlaneSnakeSchemaArrowheadMirrored.canSwitchStartingPoint());

		assertFalse(waveFloorPlaneSmall.canSwitchStartingPoint());
		assertFalse(waveFloorPlaneSmallEmptyArrowhead.canSwitchStartingPoint());
		assertFalse(waveFloorPlaneSmallSchemaArrowhead.canSwitchStartingPoint());
		assertFalse(waveFloorPlaneSmallMirrored.canSwitchStartingPoint());
		assertFalse(waveFloorPlaneSmallEmptyArrowheadMirrored.canSwitchStartingPoint());
		assertFalse(waveFloorPlaneSmallSchemaArrowheadMirrored.canSwitchStartingPoint());

		assertFalse(waveFloorPlaneLarge.canSwitchStartingPoint());
		assertFalse(waveFloorPlaneLargeEmptyArrowhead.canSwitchStartingPoint());
		assertFalse(waveFloorPlaneLargeSchemaArrowhead.canSwitchStartingPoint());
		assertFalse(waveFloorPlaneLargeMirrored.canSwitchStartingPoint());
		assertFalse(waveFloorPlaneLargeEmptyArrowheadMirrored.canSwitchStartingPoint());
		assertFalse(waveFloorPlaneLargeSchemaArrowheadMirrored.canSwitchStartingPoint());

		assertFalse(rotationSingleFloorPlane.canSwitchStartingPoint());
		assertFalse(rotationSingleFloorPlaneEmptyArrowhead.canSwitchStartingPoint());
		assertFalse(rotationSingleFloorPlaneSchemaArrowhead.canSwitchStartingPoint());
		assertFalse(rotationSingleFloorPlaneMirrored.canSwitchStartingPoint());
		assertFalse(rotationSingleFloorPlaneEmptyArrowheadMirrored.canSwitchStartingPoint());
		assertFalse(rotationSingleFloorPlaneSchemaArrowheadMirrored.canSwitchStartingPoint());

		assertFalse(rotationDoubleFloorPlane.canSwitchStartingPoint());
		assertFalse(rotationDoubleFloorPlaneEmptyArrowhead.canSwitchStartingPoint());
		assertFalse(rotationDoubleFloorPlaneSchemaArrowhead.canSwitchStartingPoint());
		assertFalse(rotationDoubleFloorPlaneMirrored.canSwitchStartingPoint());
		assertFalse(rotationDoubleFloorPlaneEmptyArrowheadMirrored.canSwitchStartingPoint());
		assertFalse(rotationDoubleFloorPlaneSchemaArrowheadMirrored.canSwitchStartingPoint());

		assertFalse(rotationAlternatingFloorPlane.canSwitchStartingPoint());
		assertFalse(rotationAlternatingFloorPlaneEmptyArrowhead.canSwitchStartingPoint());
		assertFalse(rotationAlternatingFloorPlaneSchemaArrowhead.canSwitchStartingPoint());
		assertFalse(rotationAlternatingFloorPlaneMirrored.canSwitchStartingPoint());
		assertFalse(rotationAlternatingFloorPlaneEmptyArrowheadMirrored.canSwitchStartingPoint());
		assertFalse(rotationAlternatingFloorPlaneSchemaArrowheadMirrored.canSwitchStartingPoint());

		assertFalse(shakingParallelFloor.canSwitchStartingPoint());
		assertFalse(shakingParallelFloorEmptyArrowhead.canSwitchStartingPoint());
		assertFalse(shakingParallelFloorSchemaArrowhead.canSwitchStartingPoint());
		assertFalse(shakingParallelFloorMirrored.canSwitchStartingPoint());
		assertFalse(shakingParallelFloorEmptyArrowheadMirrored.canSwitchStartingPoint());
		assertFalse(shakingParallelFloorSchemaArrowheadMirrored.canSwitchStartingPoint());

	}

	@Override
	public void testSwitchStartingPoint() {

	}

	@Override
	public void testCanSwitchPlane() {
		assertTrue(curveFloorPlaneSmall.canSwitchPlane());
		assertTrue(curveFloorPlaneSmallEmptyArrowhead.canSwitchPlane());
		assertTrue(curveFloorPlaneSmallSchemaArrowhead.canSwitchPlane());
		assertTrue(curveFloorPlaneSmallMirrored.canSwitchPlane());
		assertTrue(curveFloorPlaneSmallEmptyArrowheadMirrored.canSwitchPlane());
		assertTrue(curveFloorPlaneSmallSchemaArrowheadMirrored.canSwitchPlane());

		assertFalse(curveFloorPlaneMedium1.canSwitchPlane());
		assertFalse(curveFloorPlaneMedium1EmptyArrowhead.canSwitchPlane());
		assertFalse(curveFloorPlaneMedium1SchemaArrowhead.canSwitchPlane());
		assertFalse(curveFloorPlaneMedium1Mirrored.canSwitchPlane());
		assertFalse(curveFloorPlaneMedium1EmptyArrowheadMirrored.canSwitchPlane());
		assertFalse(curveFloorPlaneMedium1SchemaArrowheadMirrored.canSwitchPlane());

		assertFalse(curveFloorPlaneMedium2.canSwitchPlane());
		assertFalse(curveFloorPlaneMedium2EmptyArrowhead.canSwitchPlane());
		assertFalse(curveFloorPlaneMedium2SchemaArrowhead.canSwitchPlane());
		assertFalse(curveFloorPlaneMedium2Mirrored.canSwitchPlane());
		assertFalse(curveFloorPlaneMedium2EmptyArrowheadMirrored.canSwitchPlane());
		assertFalse(curveFloorPlaneMedium2SchemaArrowheadMirrored.canSwitchPlane());

		assertFalse(curveFloorPlaneLarge.canSwitchPlane());
		assertFalse(curveFloorPlaneLargeEmptyArrowhead.canSwitchPlane());
		assertFalse(curveFloorPlaneLargeSchemaArrowhead.canSwitchPlane());
		assertFalse(curveFloorPlaneLargeMirrored.canSwitchPlane());
		assertFalse(curveFloorPlaneLargeEmptyArrowheadMirrored.canSwitchPlane());
		assertFalse(curveFloorPlaneLargeSchemaArrowheadMirrored.canSwitchPlane());

		assertFalse(curveFloorPlaneCombined.canSwitchPlane());
		assertFalse(curveFloorPlaneCombinedEmptyArrowhead.canSwitchPlane());
		assertFalse(curveFloorPlaneCombinedSchemaArrowhead.canSwitchPlane());
		assertFalse(curveFloorPlaneCombinedMirrored.canSwitchPlane());
		assertFalse(curveFloorPlaneCombinedEmptyArrowheadMirrored.canSwitchPlane());
		assertFalse(curveFloorPlaneCombinedSchemaArrowheadMirrored.canSwitchPlane());

		assertTrue(humpFloorPlaneSmall.canSwitchPlane());
		assertTrue(humpFloorPlaneSmallEmptyArrowhead.canSwitchPlane());
		assertTrue(humpFloorPlaneSmallSchemaArrowhead.canSwitchPlane());
		assertTrue(humpFloorPlaneSmallMirrored.canSwitchPlane());
		assertTrue(humpFloorPlaneSmallEmptyArrowheadMirrored.canSwitchPlane());
		assertTrue(humpFloorPlaneSmallSchemaArrowheadMirrored.canSwitchPlane());

		assertTrue(loopFloorPlaneSmall.canSwitchPlane());
		assertTrue(loopFloorPlaneSmallEmptyArrowhead.canSwitchPlane());
		assertTrue(loopFloorPlaneSmallSchemaArrowhead.canSwitchPlane());
		assertTrue(loopFloorPlaneSmallMirrored.canSwitchPlane());
		assertTrue(loopFloorPlaneSmallEmptyArrowheadMirrored.canSwitchPlane());
		assertTrue(loopFloorPlaneSmallSchemaArrowheadMirrored.canSwitchPlane());

		assertFalse(waveFloorPlaneSnake.canSwitchPlane());
		assertFalse(waveFloorPlaneSnakeEmptyArrowhead.canSwitchPlane());
		assertFalse(waveFloorPlaneSnakeSchemaArrowhead.canSwitchPlane());
		assertFalse(waveFloorPlaneSnakeMirrored.canSwitchPlane());
		assertFalse(waveFloorPlaneSnakeEmptyArrowheadMirrored.canSwitchPlane());
		assertFalse(waveFloorPlaneSnakeSchemaArrowheadMirrored.canSwitchPlane());

		assertTrue(waveFloorPlaneSmall.canSwitchPlane());
		assertTrue(waveFloorPlaneSmallEmptyArrowhead.canSwitchPlane());
		assertTrue(waveFloorPlaneSmallSchemaArrowhead.canSwitchPlane());
		assertTrue(waveFloorPlaneSmallMirrored.canSwitchPlane());
		assertTrue(waveFloorPlaneSmallEmptyArrowheadMirrored.canSwitchPlane());
		assertTrue(waveFloorPlaneSmallSchemaArrowheadMirrored.canSwitchPlane());

		assertFalse(waveFloorPlaneLarge.canSwitchPlane());
		assertFalse(waveFloorPlaneLargeEmptyArrowhead.canSwitchPlane());
		assertFalse(waveFloorPlaneLargeSchemaArrowhead.canSwitchPlane());
		assertFalse(waveFloorPlaneLargeMirrored.canSwitchPlane());
		assertFalse(waveFloorPlaneLargeEmptyArrowheadMirrored.canSwitchPlane());
		assertFalse(waveFloorPlaneLargeSchemaArrowheadMirrored.canSwitchPlane());

		assertFalse(rotationSingleFloorPlane.canSwitchPlane());
		assertFalse(rotationSingleFloorPlaneEmptyArrowhead.canSwitchPlane());
		assertFalse(rotationSingleFloorPlaneSchemaArrowhead.canSwitchPlane());
		assertFalse(rotationSingleFloorPlaneMirrored.canSwitchPlane());
		assertFalse(rotationSingleFloorPlaneEmptyArrowheadMirrored.canSwitchPlane());
		assertFalse(rotationSingleFloorPlaneSchemaArrowheadMirrored.canSwitchPlane());

		assertFalse(rotationDoubleFloorPlane.canSwitchPlane());
		assertFalse(rotationDoubleFloorPlaneEmptyArrowhead.canSwitchPlane());
		assertFalse(rotationDoubleFloorPlaneSchemaArrowhead.canSwitchPlane());
		assertFalse(rotationDoubleFloorPlaneMirrored.canSwitchPlane());
		assertFalse(rotationDoubleFloorPlaneEmptyArrowheadMirrored.canSwitchPlane());
		assertFalse(rotationDoubleFloorPlaneSchemaArrowheadMirrored.canSwitchPlane());

		assertFalse(rotationAlternatingFloorPlane.canSwitchPlane());
		assertFalse(rotationAlternatingFloorPlaneEmptyArrowhead.canSwitchPlane());
		assertFalse(rotationAlternatingFloorPlaneSchemaArrowhead.canSwitchPlane());
		assertFalse(rotationAlternatingFloorPlaneMirrored.canSwitchPlane());
		assertFalse(rotationAlternatingFloorPlaneEmptyArrowheadMirrored.canSwitchPlane());
		assertFalse(rotationAlternatingFloorPlaneSchemaArrowheadMirrored.canSwitchPlane());

		assertTrue(shakingParallelFloor.canSwitchPlane());
		assertTrue(shakingParallelFloorEmptyArrowhead.canSwitchPlane());
		assertTrue(shakingParallelFloorSchemaArrowhead.canSwitchPlane());
		assertTrue(shakingParallelFloorMirrored.canSwitchPlane());
		assertTrue(shakingParallelFloorEmptyArrowheadMirrored.canSwitchPlane());
		assertTrue(shakingParallelFloorSchemaArrowheadMirrored.canSwitchPlane());
	}

	@Override
	public void testSwitchPlane() {

		curveFloorPlaneSmall.switchPlane();
		assertEquals(symbolFactory.createSymbol("02-06-001-01-01-03"), curveFloorPlaneSmall.getSymbol());
		curveFloorPlaneSmallEmptyArrowhead.switchPlane();
		assertEquals(symbolFactory.createSymbol("02-06-001-01-02-03"), curveFloorPlaneSmallEmptyArrowhead.getSymbol());
		curveFloorPlaneSmallSchemaArrowhead.switchPlane();
		assertEquals(symbolFactory.createSymbol("02-06-001-01-03-03"), curveFloorPlaneSmallSchemaArrowhead.getSymbol());
		curveFloorPlaneSmallMirrored.switchPlane();
		assertEquals(symbolFactory.createSymbol("02-06-001-01-01-11"), curveFloorPlaneSmallMirrored.getSymbol());
		curveFloorPlaneSmallEmptyArrowheadMirrored.switchPlane();
		assertEquals(symbolFactory.createSymbol("02-06-001-01-02-11"),
				curveFloorPlaneSmallEmptyArrowheadMirrored.getSymbol());
		curveFloorPlaneSmallSchemaArrowheadMirrored.switchPlane();
		assertEquals(symbolFactory.createSymbol("02-06-001-01-03-11"),
				curveFloorPlaneSmallSchemaArrowheadMirrored.getSymbol());

		humpFloorPlaneSmall.switchPlane();
		assertEquals(symbolFactory.createSymbol("02-06-004-01-01-03"), humpFloorPlaneSmall.getSymbol());
		humpFloorPlaneSmallEmptyArrowhead.switchPlane();
		assertEquals(symbolFactory.createSymbol("02-06-004-01-02-03"), humpFloorPlaneSmallEmptyArrowhead.getSymbol());
		humpFloorPlaneSmallSchemaArrowhead.switchPlane();
		assertEquals(symbolFactory.createSymbol("02-06-004-01-03-03"), humpFloorPlaneSmallSchemaArrowhead.getSymbol());
		humpFloorPlaneSmallMirrored.switchPlane();
		assertEquals(symbolFactory.createSymbol("02-06-004-01-01-11"), humpFloorPlaneSmallMirrored.getSymbol());
		humpFloorPlaneSmallEmptyArrowheadMirrored.switchPlane();
		assertEquals(symbolFactory.createSymbol("02-06-004-01-02-11"),
				humpFloorPlaneSmallEmptyArrowheadMirrored.getSymbol());
		humpFloorPlaneSmallSchemaArrowheadMirrored.switchPlane();
		assertEquals(symbolFactory.createSymbol("02-06-004-01-03-11"),
				humpFloorPlaneSmallSchemaArrowheadMirrored.getSymbol());

		loopFloorPlaneSmall.switchPlane();
		assertEquals(symbolFactory.createSymbol("02-06-005-01-01-03"), loopFloorPlaneSmall.getSymbol());
		loopFloorPlaneSmallEmptyArrowhead.switchPlane();
		assertEquals(symbolFactory.createSymbol("02-06-005-01-02-03"), loopFloorPlaneSmallEmptyArrowhead.getSymbol());
		loopFloorPlaneSmallSchemaArrowhead.switchPlane();
		assertEquals(symbolFactory.createSymbol("02-06-005-01-03-03"), loopFloorPlaneSmallSchemaArrowhead.getSymbol());
		loopFloorPlaneSmallMirrored.switchPlane();
		assertEquals(symbolFactory.createSymbol("02-06-005-01-01-11"), loopFloorPlaneSmallMirrored.getSymbol());
		loopFloorPlaneSmallEmptyArrowheadMirrored.switchPlane();
		assertEquals(symbolFactory.createSymbol("02-06-005-01-02-11"),
				loopFloorPlaneSmallEmptyArrowheadMirrored.getSymbol());
		loopFloorPlaneSmallSchemaArrowheadMirrored.switchPlane();
		assertEquals(symbolFactory.createSymbol("02-06-005-01-03-11"),
				loopFloorPlaneSmallSchemaArrowheadMirrored.getSymbol());

		waveFloorPlaneSmall.switchPlane();
		assertEquals(symbolFactory.createSymbol("02-06-006-01-01-03"), waveFloorPlaneSmall.getSymbol());
		waveFloorPlaneSmallEmptyArrowhead.switchPlane();
		assertEquals(symbolFactory.createSymbol("02-06-006-01-02-03"), waveFloorPlaneSmallEmptyArrowhead.getSymbol());
		waveFloorPlaneSmallSchemaArrowhead.switchPlane();
		assertEquals(symbolFactory.createSymbol("02-06-006-01-03-03"), waveFloorPlaneSmallSchemaArrowhead.getSymbol());
		waveFloorPlaneSmallMirrored.switchPlane();
		assertEquals(symbolFactory.createSymbol("02-06-006-01-01-11"), waveFloorPlaneSmallMirrored.getSymbol());
		waveFloorPlaneSmallEmptyArrowheadMirrored.switchPlane();
		assertEquals(symbolFactory.createSymbol("02-06-006-01-02-11"),
				waveFloorPlaneSmallEmptyArrowheadMirrored.getSymbol());
		waveFloorPlaneSmallSchemaArrowheadMirrored.switchPlane();
		assertEquals(symbolFactory.createSymbol("02-06-006-01-03-11"),
				waveFloorPlaneSmallSchemaArrowheadMirrored.getSymbol());

		shakingParallelFloor.switchPlane();
		assertEquals(symbolFactory.createSymbol("02-06-011-01-01-01"), shakingParallelFloor.getSymbol());
		shakingParallelFloorEmptyArrowhead.switchPlane();
		assertEquals(symbolFactory.createSymbol("02-06-011-01-02-01"), shakingParallelFloorEmptyArrowhead.getSymbol());
		shakingParallelFloorSchemaArrowhead.switchPlane();
		assertEquals(symbolFactory.createSymbol("02-06-011-01-03-01"), shakingParallelFloorSchemaArrowhead.getSymbol());
		shakingParallelFloorMirrored.switchPlane();
		assertEquals(symbolFactory.createSymbol("02-06-011-01-01-09"), shakingParallelFloorMirrored.getSymbol());
		shakingParallelFloorEmptyArrowheadMirrored.switchPlane();
		assertEquals(symbolFactory.createSymbol("02-06-011-01-02-09"),
				shakingParallelFloorEmptyArrowheadMirrored.getSymbol());
		shakingParallelFloorSchemaArrowheadMirrored.switchPlane();
		assertEquals(symbolFactory.createSymbol("02-06-011-01-03-09"),
				shakingParallelFloorSchemaArrowheadMirrored.getSymbol());

	}

}
