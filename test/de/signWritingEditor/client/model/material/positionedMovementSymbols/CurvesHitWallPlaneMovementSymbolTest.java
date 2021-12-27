package de.signWritingEditor.client.model.material.positionedMovementSymbols;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import de.signWritingEditor.shared.model.domainValue.Symbol;
import de.signWritingEditor.shared.model.material.MovementBaseSymbol;
import de.signWritingEditor.shared.model.material.PositionedMovementSymbol;
import de.signWritingEditor.shared.model.material.SymbolFactory;

public class CurvesHitWallPlaneMovementSymbolTest implements PositionedMovementSymbolTestInterface {

	private PositionedMovementSymbol curveHitsFrontWall;
	private PositionedMovementSymbol curveHitsFrontWallEmptyArrowhead;
	private PositionedMovementSymbol curveHitsFrontWallSchemaArrowhead;

	private PositionedMovementSymbol humpHitsFrontWall;
	private PositionedMovementSymbol humpHitsFrontWallEmptyArrowhead;
	private PositionedMovementSymbol humpHitsFrontWallSchemaArrowhead;

	private PositionedMovementSymbol loopHitsFrontWall;
	private PositionedMovementSymbol loopHitsFrontWallEmptyArrowhead;
	private PositionedMovementSymbol loopHitsFrontWallSchemaArrowhead;

	private PositionedMovementSymbol waveHitsFrontWall;
	private PositionedMovementSymbol waveHitsFrontWallEmptyArrowhead;
	private PositionedMovementSymbol waveHitsFrontWallSchemaArrowhead;

	private PositionedMovementSymbol rotationSingleHitsFrontWall;
	private PositionedMovementSymbol rotationSingleHitsFrontWallEmptyArrowhead;
	private PositionedMovementSymbol rotationSingleHitsFrontWallSchemaArrowhead;

	private PositionedMovementSymbol rotationDoubleHitsFrontWall;
	private PositionedMovementSymbol rotationDoubleHitsFrontWallEmptyArrowhead;
	private PositionedMovementSymbol rotationDoubleHitsFrontWallSchemaArrowhead;

	private PositionedMovementSymbol rotationAlternatingHitsFrontWall;
	private PositionedMovementSymbol rotationAlternatingHitsFrontWallEmptyArrowhead;
	private PositionedMovementSymbol rotationAlternatingHitsFrontWallSchemaArrowhead;

	private PositionedMovementSymbol curveHitsChest;
	private PositionedMovementSymbol curveHitsChestEmptyArrowhead;
	private PositionedMovementSymbol curveHitsChestSchemaArrowhead;

	private PositionedMovementSymbol humpHitsChest;
	private PositionedMovementSymbol humpHitsChestEmptyArrowhead;
	private PositionedMovementSymbol humpHitsChestSchemaArrowhead;

	private PositionedMovementSymbol loopHitsChest;
	private PositionedMovementSymbol loopHitsChestEmptyArrowhead;
	private PositionedMovementSymbol loopHitsChestSchemaArrowhead;

	private PositionedMovementSymbol waveHitsChest;
	private PositionedMovementSymbol waveHitsChestEmptyArrowhead;
	private PositionedMovementSymbol waveHitsChestSchemaArrowhead;

	private PositionedMovementSymbol rotationSingleHitsChest;
	private PositionedMovementSymbol rotationSingleHitsChestEmptyArrowhead;
	private PositionedMovementSymbol rotationSingleHitsChestSchemaArrowhead;

	private PositionedMovementSymbol rotationDoubleHitsChest;
	private PositionedMovementSymbol rotationDoubleHitsChestEmptyArrowhead;
	private PositionedMovementSymbol rotationDoubleHitsChestSchemaArrowhead;

	private PositionedMovementSymbol rotationAlternatingHitsChest;
	private PositionedMovementSymbol rotationAlternatingHitsChestEmptyArrowhead;
	private PositionedMovementSymbol rotationAlternatingHitsChestSchemaArrowhead;

	private PositionedMovementSymbol waveDiagonalPathSmall;
	private PositionedMovementSymbol waveDiagonalPathSmallEmptyArrowhead;
	private PositionedMovementSymbol waveDiagonalPathSmallSchemaArrowhead;
	private PositionedMovementSymbol waveDiagonalPathSmallMirrored;
	private PositionedMovementSymbol waveDiagonalPathSmallEmptyArrowheadMirrored;
	private PositionedMovementSymbol waveDiagonalPathSmallSchemaArrowheadMirrored;

	private PositionedMovementSymbol waveDiagonalPathMedium;
	private PositionedMovementSymbol waveDiagonalPathMediumEmptyArrowhead;
	private PositionedMovementSymbol waveDiagonalPathMediumSchemaArrowhead;
	private PositionedMovementSymbol waveDiagonalPathMediumMirrored;
	private PositionedMovementSymbol waveDiagonalPathMediumEmptyArrowheadMirrored;
	private PositionedMovementSymbol waveDiagonalPathMediumSchemaArrowheadMirrored;

	private PositionedMovementSymbol waveDiagonalPathLarge;
	private PositionedMovementSymbol waveDiagonalPathLargeEmptyArrowhead;
	private PositionedMovementSymbol waveDiagonalPathLargeSchemaArrowhead;
	private PositionedMovementSymbol waveDiagonalPathLargeMirrored;
	private PositionedMovementSymbol waveDiagonalPathLargeEmptyArrowheadMirrored;
	private PositionedMovementSymbol waveDiagonalPathLargeSchemaArrowheadMirrored;

	private SymbolFactory symbolFactory;

	@Override
	public void setUp(SymbolFactory symbolFactory) {

		this.symbolFactory = symbolFactory;

		curveHitsFrontWall = new PositionedMovementSymbol(MovementBaseSymbol.CURVE_HITS_FRONT_WALL.getIswaSymbol(), 0,
				0, 2, symbolFactory.getAllRotationsAndFillsFor(
						MovementBaseSymbol.CURVE_HITS_FRONT_WALL.getIswaSymbol().getBaseSymbol()));
		Symbol curveHitsFrontWallEmptyArrowheadSymbol = symbolFactory.createSymbol("02-07-001-01-02-01");
		curveHitsFrontWallEmptyArrowhead = new PositionedMovementSymbol(curveHitsFrontWallEmptyArrowheadSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(curveHitsFrontWallEmptyArrowheadSymbol.getBaseSymbol()));
		Symbol curveHitsFrontWallSchemaArrowheadSymbol = symbolFactory.createSymbol("02-07-001-01-03-01");
		curveHitsFrontWallSchemaArrowhead = new PositionedMovementSymbol(curveHitsFrontWallSchemaArrowheadSymbol, 0, 0,
				2, symbolFactory.getAllRotationsAndFillsFor(curveHitsFrontWallSchemaArrowheadSymbol.getBaseSymbol()));

		humpHitsFrontWall = new PositionedMovementSymbol(MovementBaseSymbol.HUMP_HITS_FRONT_WALL.getIswaSymbol(), 0, 0,
				2, symbolFactory.getAllRotationsAndFillsFor(
						MovementBaseSymbol.HUMP_HITS_FRONT_WALL.getIswaSymbol().getBaseSymbol()));
		Symbol humpHitsFrontWallEmptyArrowheadSymbol = symbolFactory.createSymbol("02-07-002-01-02-01");
		humpHitsFrontWallEmptyArrowhead = new PositionedMovementSymbol(humpHitsFrontWallEmptyArrowheadSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(humpHitsFrontWallEmptyArrowheadSymbol.getBaseSymbol()));
		Symbol humpHitsFrontWallSchemaArrowheadSymbol = symbolFactory.createSymbol("02-07-002-01-03-01");
		humpHitsFrontWallSchemaArrowhead = new PositionedMovementSymbol(humpHitsFrontWallSchemaArrowheadSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(humpHitsFrontWallSchemaArrowheadSymbol.getBaseSymbol()));

		loopHitsFrontWall = new PositionedMovementSymbol(MovementBaseSymbol.LOOP_HITS_FRONT_WALL.getIswaSymbol(), 0, 0,
				2, symbolFactory.getAllRotationsAndFillsFor(
						MovementBaseSymbol.LOOP_HITS_FRONT_WALL.getIswaSymbol().getBaseSymbol()));
		Symbol loopHitsFrontWallEmptyArrowheadSymbol = symbolFactory.createSymbol("02-07-003-01-02-01");
		loopHitsFrontWallEmptyArrowhead = new PositionedMovementSymbol(loopHitsFrontWallEmptyArrowheadSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(loopHitsFrontWallEmptyArrowheadSymbol.getBaseSymbol()));
		Symbol loopHitsFrontWallSchemaArrowheadSymbol = symbolFactory.createSymbol("02-07-003-01-03-01");
		loopHitsFrontWallSchemaArrowhead = new PositionedMovementSymbol(loopHitsFrontWallSchemaArrowheadSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(loopHitsFrontWallSchemaArrowheadSymbol.getBaseSymbol()));

		waveHitsFrontWall = new PositionedMovementSymbol(MovementBaseSymbol.WAVE_HITS_FRONT_WALL.getIswaSymbol(), 0, 0,
				2, symbolFactory.getAllRotationsAndFillsFor(
						MovementBaseSymbol.WAVE_HITS_FRONT_WALL.getIswaSymbol().getBaseSymbol()));
		Symbol waveHitsFrontWallEmptyArrowheadSymbol = symbolFactory.createSymbol("02-07-004-01-02-01");
		waveHitsFrontWallEmptyArrowhead = new PositionedMovementSymbol(waveHitsFrontWallEmptyArrowheadSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(waveHitsFrontWallEmptyArrowheadSymbol.getBaseSymbol()));
		Symbol waveHitsFrontWallSchemaArrowheadSymbol = symbolFactory.createSymbol("02-07-004-01-03-01");
		waveHitsFrontWallSchemaArrowhead = new PositionedMovementSymbol(waveHitsFrontWallSchemaArrowheadSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(waveHitsFrontWallSchemaArrowheadSymbol.getBaseSymbol()));

		rotationSingleHitsFrontWall = new PositionedMovementSymbol(
				MovementBaseSymbol.ROTATION_SINGLE_HITS_FRONT_WALL.getIswaSymbol(), 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						MovementBaseSymbol.ROTATION_SINGLE_HITS_FRONT_WALL.getIswaSymbol().getBaseSymbol()));
		Symbol rotationSingleHitsFrontWallEmptyArrowheadSymbol = symbolFactory.createSymbol("02-07-005-01-02-01");
		rotationSingleHitsFrontWallEmptyArrowhead = new PositionedMovementSymbol(
				rotationSingleHitsFrontWallEmptyArrowheadSymbol, 0, 0, 2, symbolFactory
						.getAllRotationsAndFillsFor(rotationSingleHitsFrontWallEmptyArrowheadSymbol.getBaseSymbol()));
		Symbol rotationSingleHitsFrontWallSchemaArrowheadSymbol = symbolFactory.createSymbol("02-07-005-01-03-01");
		rotationSingleHitsFrontWallSchemaArrowhead = new PositionedMovementSymbol(
				rotationSingleHitsFrontWallSchemaArrowheadSymbol, 0, 0, 2, symbolFactory
						.getAllRotationsAndFillsFor(rotationSingleHitsFrontWallSchemaArrowheadSymbol.getBaseSymbol()));

		rotationDoubleHitsFrontWall = new PositionedMovementSymbol(
				MovementBaseSymbol.ROTATION_DOUBLE_HITS_FRONT_WALL.getIswaSymbol(), 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						MovementBaseSymbol.ROTATION_DOUBLE_HITS_FRONT_WALL.getIswaSymbol().getBaseSymbol()));
		Symbol rotationDoubleHitsFrontWallEmptyArrowheadSymbol = symbolFactory.createSymbol("02-07-006-01-02-01");
		rotationDoubleHitsFrontWallEmptyArrowhead = new PositionedMovementSymbol(
				rotationDoubleHitsFrontWallEmptyArrowheadSymbol, 0, 0, 2, symbolFactory
						.getAllRotationsAndFillsFor(rotationDoubleHitsFrontWallEmptyArrowheadSymbol.getBaseSymbol()));
		Symbol rotationDoubleHitsFrontWallSchemaArrowheadSymbol = symbolFactory.createSymbol("02-07-006-01-03-01");
		rotationDoubleHitsFrontWallSchemaArrowhead = new PositionedMovementSymbol(
				rotationDoubleHitsFrontWallSchemaArrowheadSymbol, 0, 0, 2, symbolFactory
						.getAllRotationsAndFillsFor(rotationDoubleHitsFrontWallSchemaArrowheadSymbol.getBaseSymbol()));

		rotationAlternatingHitsFrontWall = new PositionedMovementSymbol(
				MovementBaseSymbol.ROTATION_ALTERNATING_HITS_FRONT_WALL.getIswaSymbol(), 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						MovementBaseSymbol.ROTATION_ALTERNATING_HITS_FRONT_WALL.getIswaSymbol().getBaseSymbol()));
		Symbol rotationAlternatingHitsFrontWallEmptyArrowheadSymbol = symbolFactory.createSymbol("02-07-007-01-02-01");
		rotationAlternatingHitsFrontWallEmptyArrowhead = new PositionedMovementSymbol(
				rotationAlternatingHitsFrontWallEmptyArrowheadSymbol, 0, 0, 2, symbolFactory.getAllRotationsAndFillsFor(
						rotationAlternatingHitsFrontWallEmptyArrowheadSymbol.getBaseSymbol()));
		Symbol rotationAlternatingHitsFrontWallSchemaArrowheadSymbol = symbolFactory.createSymbol("02-07-007-01-03-01");
		rotationAlternatingHitsFrontWallSchemaArrowhead = new PositionedMovementSymbol(
				rotationAlternatingHitsFrontWallSchemaArrowheadSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						rotationAlternatingHitsFrontWallSchemaArrowheadSymbol.getBaseSymbol()));

		curveHitsChest = new PositionedMovementSymbol(MovementBaseSymbol.CURVE_HITS_CHEST.getIswaSymbol(), 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						MovementBaseSymbol.CURVE_HITS_CHEST.getIswaSymbol().getBaseSymbol()));
		Symbol curveHitsChestEmptyArrowheadSymbol = symbolFactory.createSymbol("02-07-009-01-02-01");
		curveHitsChestEmptyArrowhead = new PositionedMovementSymbol(curveHitsChestEmptyArrowheadSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(curveHitsChestEmptyArrowheadSymbol.getBaseSymbol()));
		Symbol curveHitsChestSchemaArrowheadSymbol = symbolFactory.createSymbol("02-07-009-01-03-01");
		curveHitsChestSchemaArrowhead = new PositionedMovementSymbol(curveHitsChestSchemaArrowheadSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(curveHitsChestSchemaArrowheadSymbol.getBaseSymbol()));

		humpHitsChest = new PositionedMovementSymbol(MovementBaseSymbol.HUMP_HITS_CHEST.getIswaSymbol(), 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						MovementBaseSymbol.HUMP_HITS_CHEST.getIswaSymbol().getBaseSymbol()));
		Symbol humpHitsChestEmptyArrowheadSymbol = symbolFactory.createSymbol("02-07-010-01-02-01");
		humpHitsChestEmptyArrowhead = new PositionedMovementSymbol(humpHitsChestEmptyArrowheadSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(humpHitsChestEmptyArrowheadSymbol.getBaseSymbol()));
		Symbol humpHitsChestSchemaArrowheadSymbol = symbolFactory.createSymbol("02-07-010-01-03-01");
		humpHitsChestSchemaArrowhead = new PositionedMovementSymbol(humpHitsChestSchemaArrowheadSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(humpHitsChestSchemaArrowheadSymbol.getBaseSymbol()));

		loopHitsChest = new PositionedMovementSymbol(MovementBaseSymbol.LOOP_HITS_CHEST.getIswaSymbol(), 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						MovementBaseSymbol.LOOP_HITS_CHEST.getIswaSymbol().getBaseSymbol()));
		Symbol loopHitsChestEmptyArrowheadSymbol = symbolFactory.createSymbol("02-07-011-01-02-01");
		loopHitsChestEmptyArrowhead = new PositionedMovementSymbol(loopHitsChestEmptyArrowheadSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(loopHitsChestEmptyArrowheadSymbol.getBaseSymbol()));
		Symbol loopHitsChestSchemaArrowheadSymbol = symbolFactory.createSymbol("02-07-011-01-03-01");
		loopHitsChestSchemaArrowhead = new PositionedMovementSymbol(loopHitsChestSchemaArrowheadSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(loopHitsChestSchemaArrowheadSymbol.getBaseSymbol()));

		waveHitsChest = new PositionedMovementSymbol(MovementBaseSymbol.WAVE_HITS_CHEST.getIswaSymbol(), 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						MovementBaseSymbol.WAVE_HITS_CHEST.getIswaSymbol().getBaseSymbol()));
		Symbol waveHitsChestEmptyArrowheadSymbol = symbolFactory.createSymbol("02-07-012-01-02-01");
		waveHitsChestEmptyArrowhead = new PositionedMovementSymbol(waveHitsChestEmptyArrowheadSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(waveHitsChestEmptyArrowheadSymbol.getBaseSymbol()));
		Symbol waveHitsChestSchemaArrowheadSymbol = symbolFactory.createSymbol("02-07-012-01-03-01");
		waveHitsChestSchemaArrowhead = new PositionedMovementSymbol(waveHitsChestSchemaArrowheadSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(waveHitsChestSchemaArrowheadSymbol.getBaseSymbol()));

		rotationSingleHitsChest = new PositionedMovementSymbol(
				MovementBaseSymbol.ROTATION_SINGLE_HITS_CHEST.getIswaSymbol(), 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						MovementBaseSymbol.ROTATION_SINGLE_HITS_CHEST.getIswaSymbol().getBaseSymbol()));
		Symbol rotationSingleHitsChestEmptyArrowheadSymbol = symbolFactory.createSymbol("02-07-013-01-02-01");
		rotationSingleHitsChestEmptyArrowhead = new PositionedMovementSymbol(
				rotationSingleHitsChestEmptyArrowheadSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(rotationSingleHitsChestEmptyArrowheadSymbol.getBaseSymbol()));
		Symbol rotationSingleHitsChestSchemaArrowheadSymbol = symbolFactory.createSymbol("02-07-013-01-03-01");
		rotationSingleHitsChestSchemaArrowhead = new PositionedMovementSymbol(
				rotationSingleHitsChestSchemaArrowheadSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(rotationSingleHitsChestSchemaArrowheadSymbol.getBaseSymbol()));

		rotationDoubleHitsChest = new PositionedMovementSymbol(
				MovementBaseSymbol.ROTATION_DOUBLE_HITS_CHEST.getIswaSymbol(), 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						MovementBaseSymbol.ROTATION_DOUBLE_HITS_CHEST.getIswaSymbol().getBaseSymbol()));
		Symbol rotationDoubleHitsChestEmptyArrowheadSymbol = symbolFactory.createSymbol("02-07-014-01-02-01");
		rotationDoubleHitsChestEmptyArrowhead = new PositionedMovementSymbol(
				rotationDoubleHitsChestEmptyArrowheadSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(rotationDoubleHitsChestEmptyArrowheadSymbol.getBaseSymbol()));
		Symbol rotationDoubleHitsChestSchemaArrowheadSymbol = symbolFactory.createSymbol("02-07-014-01-03-01");
		rotationDoubleHitsChestSchemaArrowhead = new PositionedMovementSymbol(
				rotationDoubleHitsChestSchemaArrowheadSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(rotationDoubleHitsChestSchemaArrowheadSymbol.getBaseSymbol()));

		rotationAlternatingHitsChest = new PositionedMovementSymbol(
				MovementBaseSymbol.ROTATION_ALTERNATIVE_HITS_CHEST.getIswaSymbol(), 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						MovementBaseSymbol.ROTATION_ALTERNATIVE_HITS_CHEST.getIswaSymbol().getBaseSymbol()));
		Symbol rotationAlternatingHitsChestEmptyArrowheadSymbol = symbolFactory.createSymbol("02-07-015-01-02-01");
		rotationAlternatingHitsChestEmptyArrowhead = new PositionedMovementSymbol(
				rotationAlternatingHitsChestEmptyArrowheadSymbol, 0, 0, 2, symbolFactory
						.getAllRotationsAndFillsFor(rotationAlternatingHitsChestEmptyArrowheadSymbol.getBaseSymbol()));
		Symbol rotationAlternatingHitsChestSchemaArrowheadSymbol = symbolFactory.createSymbol("02-07-015-01-03-01");
		rotationAlternatingHitsChestSchemaArrowhead = new PositionedMovementSymbol(
				rotationAlternatingHitsChestSchemaArrowheadSymbol, 0, 0, 2, symbolFactory
						.getAllRotationsAndFillsFor(rotationAlternatingHitsChestSchemaArrowheadSymbol.getBaseSymbol()));

		waveDiagonalPathSmall = new PositionedMovementSymbol(
				MovementBaseSymbol.WAVE_DIAGONAL_PATH_SMALL.getIswaSymbol(), 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						MovementBaseSymbol.WAVE_DIAGONAL_PATH_SMALL.getIswaSymbol().getBaseSymbol()));
		Symbol waveDiagonalPathSmallEmptyArrowheadSymbol = symbolFactory.createSymbol("02-07-016-01-02-01");
		waveDiagonalPathSmallEmptyArrowhead = new PositionedMovementSymbol(waveDiagonalPathSmallEmptyArrowheadSymbol, 0,
				0, 2,
				symbolFactory.getAllRotationsAndFillsFor(waveDiagonalPathSmallEmptyArrowheadSymbol.getBaseSymbol()));
		Symbol waveDiagonalPathSmallSchemaArrowheadSymbol = symbolFactory.createSymbol("02-07-016-01-03-01");
		waveDiagonalPathSmallSchemaArrowhead = new PositionedMovementSymbol(waveDiagonalPathSmallSchemaArrowheadSymbol,
				0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(waveDiagonalPathSmallSchemaArrowheadSymbol.getBaseSymbol()));
		Symbol waveDiagonalPathSmallMirroredSymbol = symbolFactory.createSymbol("02-07-016-01-01-09");
		waveDiagonalPathSmallMirrored = new PositionedMovementSymbol(waveDiagonalPathSmallMirroredSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(waveDiagonalPathSmallMirroredSymbol.getBaseSymbol()));
		Symbol waveDiagonalPathSmallMirroredEmptyArrowheadSymbol = symbolFactory.createSymbol("02-07-016-01-02-09");
		waveDiagonalPathSmallEmptyArrowheadMirrored = new PositionedMovementSymbol(
				waveDiagonalPathSmallMirroredEmptyArrowheadSymbol, 0, 0, 2, symbolFactory
						.getAllRotationsAndFillsFor(waveDiagonalPathSmallMirroredEmptyArrowheadSymbol.getBaseSymbol()));
		Symbol waveDiagonalPathSmallMirroredSchemaArrowheadSymbol = symbolFactory.createSymbol("02-07-016-01-03-09");
		waveDiagonalPathSmallSchemaArrowheadMirrored = new PositionedMovementSymbol(
				waveDiagonalPathSmallMirroredSchemaArrowheadSymbol, 0, 0, 2, symbolFactory.getAllRotationsAndFillsFor(
						waveDiagonalPathSmallMirroredSchemaArrowheadSymbol.getBaseSymbol()));

		waveDiagonalPathMedium = new PositionedMovementSymbol(
				MovementBaseSymbol.WAVE_DIAGONAL_PATH_MEDIUM.getIswaSymbol(), 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						MovementBaseSymbol.WAVE_DIAGONAL_PATH_MEDIUM.getIswaSymbol().getBaseSymbol()));
		Symbol waveDiagonalPathMediumEmptyArrowheadSymbol = symbolFactory.createSymbol("02-07-016-02-02-01");
		waveDiagonalPathMediumEmptyArrowhead = new PositionedMovementSymbol(waveDiagonalPathMediumEmptyArrowheadSymbol,
				0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(waveDiagonalPathMediumEmptyArrowheadSymbol.getBaseSymbol()));
		Symbol waveDiagonalPathMediumSchemaArrowheadSymbol = symbolFactory.createSymbol("02-07-016-02-03-01");
		waveDiagonalPathMediumSchemaArrowhead = new PositionedMovementSymbol(
				waveDiagonalPathMediumSchemaArrowheadSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(waveDiagonalPathMediumSchemaArrowheadSymbol.getBaseSymbol()));
		Symbol waveDiagonalPathMediumMirroredSymbol = symbolFactory.createSymbol("02-07-016-02-01-09");
		waveDiagonalPathMediumMirrored = new PositionedMovementSymbol(waveDiagonalPathMediumMirroredSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(waveDiagonalPathMediumMirroredSymbol.getBaseSymbol()));
		Symbol waveDiagonalPathMediumMirroredEmptyArrowheadSymbol = symbolFactory.createSymbol("02-07-016-02-02-09");
		waveDiagonalPathMediumEmptyArrowheadMirrored = new PositionedMovementSymbol(
				waveDiagonalPathMediumMirroredEmptyArrowheadSymbol, 0, 0, 2, symbolFactory.getAllRotationsAndFillsFor(
						waveDiagonalPathMediumMirroredEmptyArrowheadSymbol.getBaseSymbol()));
		Symbol waveDiagonalPathMediumMirroredSchemaArrowheadSymbol = symbolFactory.createSymbol("02-07-016-02-03-09");
		waveDiagonalPathMediumSchemaArrowheadMirrored = new PositionedMovementSymbol(
				waveDiagonalPathMediumMirroredSchemaArrowheadSymbol, 0, 0, 2, symbolFactory.getAllRotationsAndFillsFor(
						waveDiagonalPathMediumMirroredSchemaArrowheadSymbol.getBaseSymbol()));

		waveDiagonalPathLarge = new PositionedMovementSymbol(
				MovementBaseSymbol.WAVE_DIAGONAL_PATH_LARGE.getIswaSymbol(), 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						MovementBaseSymbol.WAVE_DIAGONAL_PATH_LARGE.getIswaSymbol().getBaseSymbol()));
		Symbol waveDiagonalPathLargeEmptyArrowheadSymbol = symbolFactory.createSymbol("02-07-016-03-02-01");
		waveDiagonalPathLargeEmptyArrowhead = new PositionedMovementSymbol(waveDiagonalPathLargeEmptyArrowheadSymbol, 0,
				0, 2,
				symbolFactory.getAllRotationsAndFillsFor(waveDiagonalPathLargeEmptyArrowheadSymbol.getBaseSymbol()));
		Symbol waveDiagonalPathLargeSchemaArrowheadSymbol = symbolFactory.createSymbol("02-07-016-03-03-01");
		waveDiagonalPathLargeSchemaArrowhead = new PositionedMovementSymbol(waveDiagonalPathLargeSchemaArrowheadSymbol,
				0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(waveDiagonalPathLargeSchemaArrowheadSymbol.getBaseSymbol()));
		Symbol waveDiagonalPathLargeMirroredSymbol = symbolFactory.createSymbol("02-07-016-03-01-09");
		waveDiagonalPathLargeMirrored = new PositionedMovementSymbol(waveDiagonalPathLargeMirroredSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(waveDiagonalPathLargeMirroredSymbol.getBaseSymbol()));
		Symbol waveDiagonalPathLargeMirroredEmptyArrowheadSymbol = symbolFactory.createSymbol("02-07-016-03-02-09");
		waveDiagonalPathLargeEmptyArrowheadMirrored = new PositionedMovementSymbol(
				waveDiagonalPathLargeMirroredEmptyArrowheadSymbol, 0, 0, 2, symbolFactory
						.getAllRotationsAndFillsFor(waveDiagonalPathLargeMirroredEmptyArrowheadSymbol.getBaseSymbol()));
		Symbol waveDiagonalPathLargeMirroredSchemaArrowheadSymbol = symbolFactory.createSymbol("02-07-016-03-03-09");
		waveDiagonalPathLargeSchemaArrowheadMirrored = new PositionedMovementSymbol(
				waveDiagonalPathLargeMirroredSchemaArrowheadSymbol, 0, 0, 2, symbolFactory.getAllRotationsAndFillsFor(
						waveDiagonalPathLargeMirroredSchemaArrowheadSymbol.getBaseSymbol()));

	}

	@Override
	public void testCanIncrease() {

		assertFalse(curveHitsFrontWall.canIncrease());
		assertFalse(curveHitsFrontWallEmptyArrowhead.canIncrease());
		assertFalse(curveHitsFrontWallSchemaArrowhead.canIncrease());

		assertFalse(humpHitsFrontWall.canIncrease());
		assertFalse(humpHitsFrontWallEmptyArrowhead.canIncrease());
		assertFalse(humpHitsFrontWallSchemaArrowhead.canIncrease());

		assertFalse(loopHitsFrontWall.canIncrease());
		assertFalse(loopHitsFrontWallEmptyArrowhead.canIncrease());
		assertFalse(loopHitsFrontWallSchemaArrowhead.canIncrease());

		assertFalse(waveHitsFrontWall.canIncrease());
		assertFalse(waveHitsFrontWallEmptyArrowhead.canIncrease());
		assertFalse(waveHitsFrontWallSchemaArrowhead.canIncrease());

		assertTrue(rotationSingleHitsFrontWall.canIncrease());
		assertTrue(rotationSingleHitsFrontWallEmptyArrowhead.canIncrease());
		assertTrue(rotationSingleHitsFrontWallSchemaArrowhead.canIncrease());

		assertFalse(rotationDoubleHitsFrontWall.canIncrease());
		assertFalse(rotationDoubleHitsFrontWallEmptyArrowhead.canIncrease());
		assertFalse(rotationDoubleHitsFrontWallSchemaArrowhead.canIncrease());

		assertFalse(rotationAlternatingHitsFrontWall.canIncrease());
		assertFalse(rotationAlternatingHitsFrontWallEmptyArrowhead.canIncrease());
		assertFalse(rotationAlternatingHitsFrontWallSchemaArrowhead.canIncrease());

		assertFalse(curveHitsChest.canIncrease());
		assertFalse(curveHitsChestEmptyArrowhead.canIncrease());
		assertFalse(curveHitsChestSchemaArrowhead.canIncrease());

		assertFalse(humpHitsChest.canIncrease());
		assertFalse(humpHitsChestEmptyArrowhead.canIncrease());
		assertFalse(humpHitsChestSchemaArrowhead.canIncrease());

		assertFalse(loopHitsChest.canIncrease());
		assertFalse(loopHitsChestEmptyArrowhead.canIncrease());
		assertFalse(loopHitsChestSchemaArrowhead.canIncrease());

		assertFalse(waveHitsChest.canIncrease());
		assertFalse(waveHitsChestEmptyArrowhead.canIncrease());
		assertFalse(waveHitsChestSchemaArrowhead.canIncrease());

		assertTrue(rotationSingleHitsChest.canIncrease());
		assertTrue(rotationSingleHitsChestEmptyArrowhead.canIncrease());
		assertTrue(rotationSingleHitsChestSchemaArrowhead.canIncrease());

		assertFalse(rotationDoubleHitsChest.canIncrease());
		assertFalse(rotationDoubleHitsChestEmptyArrowhead.canIncrease());
		assertFalse(rotationDoubleHitsChestSchemaArrowhead.canIncrease());

		assertFalse(rotationAlternatingHitsChest.canIncrease());
		assertFalse(rotationAlternatingHitsChestEmptyArrowhead.canIncrease());
		assertFalse(rotationAlternatingHitsChestSchemaArrowhead.canIncrease());

		assertFalse(waveDiagonalPathSmall.canIncrease());
		assertFalse(waveDiagonalPathSmallEmptyArrowhead.canIncrease());
		assertFalse(waveDiagonalPathSmallSchemaArrowhead.canIncrease());
		assertFalse(waveDiagonalPathSmallMirrored.canIncrease());
		assertFalse(waveDiagonalPathSmallEmptyArrowheadMirrored.canIncrease());
		assertFalse(waveDiagonalPathSmallSchemaArrowheadMirrored.canIncrease());

		assertFalse(waveDiagonalPathMedium.canIncrease());
		assertFalse(waveDiagonalPathMediumEmptyArrowhead.canIncrease());
		assertFalse(waveDiagonalPathMediumSchemaArrowhead.canIncrease());
		assertFalse(waveDiagonalPathMediumMirrored.canIncrease());
		assertFalse(waveDiagonalPathMediumEmptyArrowheadMirrored.canIncrease());
		assertFalse(waveDiagonalPathMediumSchemaArrowheadMirrored.canIncrease());

		assertFalse(waveDiagonalPathLarge.canIncrease());
		assertFalse(waveDiagonalPathLargeEmptyArrowhead.canIncrease());
		assertFalse(waveDiagonalPathLargeSchemaArrowhead.canIncrease());
		assertFalse(waveDiagonalPathLargeMirrored.canIncrease());
		assertFalse(waveDiagonalPathLargeEmptyArrowheadMirrored.canIncrease());
		assertFalse(waveDiagonalPathLargeSchemaArrowheadMirrored.canIncrease());

	}

	@Override
	public void testIncrease() {

		rotationSingleHitsFrontWall.increase();
		assertEquals(rotationDoubleHitsFrontWall.getSymbol(), rotationSingleHitsFrontWall.getSymbol());
		rotationSingleHitsFrontWallEmptyArrowhead.increase();
		assertEquals(rotationDoubleHitsFrontWallEmptyArrowhead.getSymbol(),
				rotationSingleHitsFrontWallEmptyArrowhead.getSymbol());
		rotationSingleHitsFrontWallSchemaArrowhead.increase();
		assertEquals(rotationDoubleHitsFrontWallSchemaArrowhead.getSymbol(),
				rotationSingleHitsFrontWallSchemaArrowhead.getSymbol());

		rotationSingleHitsChest.increase();
		assertEquals(rotationDoubleHitsChest.getSymbol(), rotationSingleHitsChest.getSymbol());
		rotationSingleHitsChestEmptyArrowhead.increase();
		assertEquals(rotationDoubleHitsChestEmptyArrowhead.getSymbol(),
				rotationSingleHitsChestEmptyArrowhead.getSymbol());
		rotationSingleHitsChestSchemaArrowhead.increase();
		assertEquals(rotationDoubleHitsChestSchemaArrowhead.getSymbol(),
				rotationSingleHitsChestSchemaArrowhead.getSymbol());

	}

	@Override
	public void testCanDecrease() {

		assertFalse(curveHitsFrontWall.canDecrease());
		assertFalse(curveHitsFrontWallEmptyArrowhead.canDecrease());
		assertFalse(curveHitsFrontWallSchemaArrowhead.canDecrease());

		assertFalse(humpHitsFrontWall.canDecrease());
		assertFalse(humpHitsFrontWallEmptyArrowhead.canDecrease());
		assertFalse(humpHitsFrontWallSchemaArrowhead.canDecrease());

		assertFalse(loopHitsFrontWall.canDecrease());
		assertFalse(loopHitsFrontWallEmptyArrowhead.canDecrease());
		assertFalse(loopHitsFrontWallSchemaArrowhead.canDecrease());

		assertFalse(waveHitsFrontWall.canDecrease());
		assertFalse(waveHitsFrontWallEmptyArrowhead.canDecrease());
		assertFalse(waveHitsFrontWallSchemaArrowhead.canDecrease());

		assertFalse(rotationSingleHitsFrontWall.canDecrease());
		assertFalse(rotationSingleHitsFrontWallEmptyArrowhead.canDecrease());
		assertFalse(rotationSingleHitsFrontWallSchemaArrowhead.canDecrease());

		assertTrue(rotationDoubleHitsFrontWall.canDecrease());
		assertTrue(rotationDoubleHitsFrontWallEmptyArrowhead.canDecrease());
		assertTrue(rotationDoubleHitsFrontWallSchemaArrowhead.canDecrease());

		assertFalse(rotationAlternatingHitsFrontWall.canDecrease());
		assertFalse(rotationAlternatingHitsFrontWallEmptyArrowhead.canDecrease());
		assertFalse(rotationAlternatingHitsFrontWallSchemaArrowhead.canDecrease());

		assertFalse(curveHitsChest.canDecrease());
		assertFalse(curveHitsChestEmptyArrowhead.canDecrease());
		assertFalse(curveHitsChestSchemaArrowhead.canDecrease());

		assertFalse(humpHitsChest.canDecrease());
		assertFalse(humpHitsChestEmptyArrowhead.canDecrease());
		assertFalse(humpHitsChestSchemaArrowhead.canDecrease());

		assertFalse(loopHitsChest.canDecrease());
		assertFalse(loopHitsChestEmptyArrowhead.canDecrease());
		assertFalse(loopHitsChestSchemaArrowhead.canDecrease());

		assertFalse(waveHitsChest.canDecrease());
		assertFalse(waveHitsChestEmptyArrowhead.canDecrease());
		assertFalse(waveHitsChestSchemaArrowhead.canDecrease());

		assertFalse(rotationSingleHitsChest.canDecrease());
		assertFalse(rotationSingleHitsChestEmptyArrowhead.canDecrease());
		assertFalse(rotationSingleHitsChestSchemaArrowhead.canDecrease());

		assertTrue(rotationDoubleHitsChest.canDecrease());
		assertTrue(rotationDoubleHitsChestEmptyArrowhead.canDecrease());
		assertTrue(rotationDoubleHitsChestSchemaArrowhead.canDecrease());

		assertFalse(rotationAlternatingHitsChest.canDecrease());
		assertFalse(rotationAlternatingHitsChestEmptyArrowhead.canDecrease());
		assertFalse(rotationAlternatingHitsChestSchemaArrowhead.canDecrease());

		assertFalse(waveDiagonalPathSmall.canDecrease());
		assertFalse(waveDiagonalPathSmallEmptyArrowhead.canDecrease());
		assertFalse(waveDiagonalPathSmallSchemaArrowhead.canDecrease());
		assertFalse(waveDiagonalPathSmallMirrored.canDecrease());
		assertFalse(waveDiagonalPathSmallEmptyArrowheadMirrored.canDecrease());
		assertFalse(waveDiagonalPathSmallSchemaArrowheadMirrored.canDecrease());

		assertFalse(waveDiagonalPathMedium.canDecrease());
		assertFalse(waveDiagonalPathMediumEmptyArrowhead.canDecrease());
		assertFalse(waveDiagonalPathMediumSchemaArrowhead.canDecrease());
		assertFalse(waveDiagonalPathMediumMirrored.canDecrease());
		assertFalse(waveDiagonalPathMediumEmptyArrowheadMirrored.canDecrease());
		assertFalse(waveDiagonalPathMediumSchemaArrowheadMirrored.canDecrease());

		assertFalse(waveDiagonalPathLarge.canDecrease());
		assertFalse(waveDiagonalPathLargeEmptyArrowhead.canDecrease());
		assertFalse(waveDiagonalPathLargeSchemaArrowhead.canDecrease());
		assertFalse(waveDiagonalPathLargeMirrored.canDecrease());
		assertFalse(waveDiagonalPathLargeEmptyArrowheadMirrored.canDecrease());
		assertFalse(waveDiagonalPathLargeSchemaArrowheadMirrored.canDecrease());

	}

	@Override
	public void testDecrease() {

		rotationDoubleHitsFrontWall.decrease();
		assertEquals(rotationSingleHitsFrontWall.getSymbol(), rotationDoubleHitsFrontWall.getSymbol());
		rotationDoubleHitsFrontWallEmptyArrowhead.decrease();
		assertEquals(rotationSingleHitsFrontWallEmptyArrowhead.getSymbol(),
				rotationDoubleHitsFrontWallEmptyArrowhead.getSymbol());
		rotationDoubleHitsFrontWallSchemaArrowhead.decrease();
		assertEquals(rotationSingleHitsFrontWallSchemaArrowhead.getSymbol(),
				rotationDoubleHitsFrontWallSchemaArrowhead.getSymbol());

		rotationDoubleHitsChest.decrease();
		assertEquals(rotationSingleHitsChest.getSymbol(), rotationDoubleHitsChest.getSymbol());
		rotationDoubleHitsChestEmptyArrowhead.decrease();
		assertEquals(rotationSingleHitsChestEmptyArrowhead.getSymbol(),
				rotationDoubleHitsChestEmptyArrowhead.getSymbol());
		rotationDoubleHitsChestSchemaArrowhead.decrease();
		assertEquals(rotationSingleHitsChestSchemaArrowhead.getSymbol(),
				rotationDoubleHitsChestSchemaArrowhead.getSymbol());

	}

	@Override
	public void testCanRotate() {

		assertTrue(curveHitsFrontWall.canRotate());
		assertTrue(curveHitsFrontWallEmptyArrowhead.canRotate());
		assertTrue(curveHitsFrontWallSchemaArrowhead.canRotate());

		assertTrue(humpHitsFrontWall.canRotate());
		assertTrue(humpHitsFrontWallEmptyArrowhead.canRotate());
		assertTrue(humpHitsFrontWallSchemaArrowhead.canRotate());

		assertTrue(loopHitsFrontWall.canRotate());
		assertTrue(loopHitsFrontWallEmptyArrowhead.canRotate());
		assertTrue(loopHitsFrontWallSchemaArrowhead.canRotate());

		assertTrue(waveHitsFrontWall.canRotate());
		assertTrue(waveHitsFrontWallEmptyArrowhead.canRotate());
		assertTrue(waveHitsFrontWallSchemaArrowhead.canRotate());

		assertTrue(rotationSingleHitsFrontWall.canRotate());
		assertTrue(rotationSingleHitsFrontWallEmptyArrowhead.canRotate());
		assertTrue(rotationSingleHitsFrontWallSchemaArrowhead.canRotate());

		assertTrue(rotationDoubleHitsFrontWall.canRotate());
		assertTrue(rotationDoubleHitsFrontWallEmptyArrowhead.canRotate());
		assertTrue(rotationDoubleHitsFrontWallSchemaArrowhead.canRotate());

		assertTrue(rotationAlternatingHitsFrontWall.canRotate());
		assertTrue(rotationAlternatingHitsFrontWallEmptyArrowhead.canRotate());
		assertTrue(rotationAlternatingHitsFrontWallSchemaArrowhead.canRotate());

		assertTrue(curveHitsChest.canRotate());
		assertTrue(curveHitsChestEmptyArrowhead.canRotate());
		assertTrue(curveHitsChestSchemaArrowhead.canRotate());

		assertTrue(humpHitsChest.canRotate());
		assertTrue(humpHitsChestEmptyArrowhead.canRotate());
		assertTrue(humpHitsChestSchemaArrowhead.canRotate());

		assertTrue(loopHitsChest.canRotate());
		assertTrue(loopHitsChestEmptyArrowhead.canRotate());
		assertTrue(loopHitsChestSchemaArrowhead.canRotate());

		assertTrue(waveHitsChest.canRotate());
		assertTrue(waveHitsChestEmptyArrowhead.canRotate());
		assertTrue(waveHitsChestSchemaArrowhead.canRotate());

		assertTrue(rotationSingleHitsChest.canRotate());
		assertTrue(rotationSingleHitsChestEmptyArrowhead.canRotate());
		assertTrue(rotationSingleHitsChestSchemaArrowhead.canRotate());

		assertTrue(rotationDoubleHitsChest.canRotate());
		assertTrue(rotationDoubleHitsChestEmptyArrowhead.canRotate());
		assertTrue(rotationDoubleHitsChestSchemaArrowhead.canRotate());

		assertTrue(rotationAlternatingHitsChest.canRotate());
		assertTrue(rotationAlternatingHitsChestEmptyArrowhead.canRotate());
		assertTrue(rotationAlternatingHitsChestSchemaArrowhead.canRotate());

		assertTrue(waveDiagonalPathSmall.canRotate());
		assertTrue(waveDiagonalPathSmallEmptyArrowhead.canRotate());
		assertTrue(waveDiagonalPathSmallSchemaArrowhead.canRotate());
		assertTrue(waveDiagonalPathSmallMirrored.canRotate());
		assertTrue(waveDiagonalPathSmallEmptyArrowheadMirrored.canRotate());
		assertTrue(waveDiagonalPathSmallSchemaArrowheadMirrored.canRotate());

		assertTrue(waveDiagonalPathMedium.canRotate());
		assertTrue(waveDiagonalPathMediumEmptyArrowhead.canRotate());
		assertTrue(waveDiagonalPathMediumSchemaArrowhead.canRotate());
		assertTrue(waveDiagonalPathMediumMirrored.canRotate());
		assertTrue(waveDiagonalPathMediumEmptyArrowheadMirrored.canRotate());
		assertTrue(waveDiagonalPathMediumSchemaArrowheadMirrored.canRotate());

		assertTrue(waveDiagonalPathLarge.canRotate());
		assertTrue(waveDiagonalPathLargeEmptyArrowhead.canRotate());
		assertTrue(waveDiagonalPathLargeSchemaArrowhead.canRotate());
		assertTrue(waveDiagonalPathLargeMirrored.canRotate());
		assertTrue(waveDiagonalPathLargeEmptyArrowheadMirrored.canRotate());
		assertTrue(waveDiagonalPathLargeSchemaArrowheadMirrored.canRotate());

	}

	@Override
	public void testRotateClockwise() {

		curveHitsFrontWall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-001-01-01-04"), curveHitsFrontWall.getSymbol());
		curveHitsFrontWall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-001-01-01-03"), curveHitsFrontWall.getSymbol());
		curveHitsFrontWall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-001-01-01-02"), curveHitsFrontWall.getSymbol());
		curveHitsFrontWall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-001-01-01-01"), curveHitsFrontWall.getSymbol());

		curveHitsFrontWallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-001-01-02-04"), curveHitsFrontWallEmptyArrowhead.getSymbol());
		curveHitsFrontWallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-001-01-02-03"), curveHitsFrontWallEmptyArrowhead.getSymbol());
		curveHitsFrontWallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-001-01-02-02"), curveHitsFrontWallEmptyArrowhead.getSymbol());
		curveHitsFrontWallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-001-01-02-01"), curveHitsFrontWallEmptyArrowhead.getSymbol());

		curveHitsFrontWallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-001-01-03-04"), curveHitsFrontWallSchemaArrowhead.getSymbol());
		curveHitsFrontWallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-001-01-03-03"), curveHitsFrontWallSchemaArrowhead.getSymbol());
		curveHitsFrontWallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-001-01-03-02"), curveHitsFrontWallSchemaArrowhead.getSymbol());
		curveHitsFrontWallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-001-01-03-01"), curveHitsFrontWallSchemaArrowhead.getSymbol());

		humpHitsFrontWall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-002-01-01-04"), humpHitsFrontWall.getSymbol());
		humpHitsFrontWall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-002-01-01-03"), humpHitsFrontWall.getSymbol());
		humpHitsFrontWall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-002-01-01-02"), humpHitsFrontWall.getSymbol());
		humpHitsFrontWall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-002-01-01-01"), humpHitsFrontWall.getSymbol());

		humpHitsFrontWallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-002-01-02-04"), humpHitsFrontWallEmptyArrowhead.getSymbol());
		humpHitsFrontWallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-002-01-02-03"), humpHitsFrontWallEmptyArrowhead.getSymbol());
		humpHitsFrontWallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-002-01-02-02"), humpHitsFrontWallEmptyArrowhead.getSymbol());
		humpHitsFrontWallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-002-01-02-01"), humpHitsFrontWallEmptyArrowhead.getSymbol());

		humpHitsFrontWallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-002-01-03-04"), humpHitsFrontWallSchemaArrowhead.getSymbol());
		humpHitsFrontWallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-002-01-03-03"), humpHitsFrontWallSchemaArrowhead.getSymbol());
		humpHitsFrontWallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-002-01-03-02"), humpHitsFrontWallSchemaArrowhead.getSymbol());
		humpHitsFrontWallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-002-01-03-01"), humpHitsFrontWallSchemaArrowhead.getSymbol());

		loopHitsFrontWall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-003-01-01-04"), loopHitsFrontWall.getSymbol());
		loopHitsFrontWall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-003-01-01-03"), loopHitsFrontWall.getSymbol());
		loopHitsFrontWall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-003-01-01-02"), loopHitsFrontWall.getSymbol());
		loopHitsFrontWall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-003-01-01-01"), loopHitsFrontWall.getSymbol());

		loopHitsFrontWallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-003-01-02-04"), loopHitsFrontWallEmptyArrowhead.getSymbol());
		loopHitsFrontWallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-003-01-02-03"), loopHitsFrontWallEmptyArrowhead.getSymbol());
		loopHitsFrontWallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-003-01-02-02"), loopHitsFrontWallEmptyArrowhead.getSymbol());
		loopHitsFrontWallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-003-01-02-01"), loopHitsFrontWallEmptyArrowhead.getSymbol());

		loopHitsFrontWallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-003-01-03-04"), loopHitsFrontWallSchemaArrowhead.getSymbol());
		loopHitsFrontWallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-003-01-03-03"), loopHitsFrontWallSchemaArrowhead.getSymbol());
		loopHitsFrontWallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-003-01-03-02"), loopHitsFrontWallSchemaArrowhead.getSymbol());
		loopHitsFrontWallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-003-01-03-01"), loopHitsFrontWallSchemaArrowhead.getSymbol());

		waveHitsFrontWall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-004-01-01-04"), waveHitsFrontWall.getSymbol());
		waveHitsFrontWall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-004-01-01-03"), waveHitsFrontWall.getSymbol());
		waveHitsFrontWall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-004-01-01-02"), waveHitsFrontWall.getSymbol());
		waveHitsFrontWall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-004-01-01-01"), waveHitsFrontWall.getSymbol());

		waveHitsFrontWallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-004-01-02-04"), waveHitsFrontWallEmptyArrowhead.getSymbol());
		waveHitsFrontWallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-004-01-02-03"), waveHitsFrontWallEmptyArrowhead.getSymbol());
		waveHitsFrontWallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-004-01-02-02"), waveHitsFrontWallEmptyArrowhead.getSymbol());
		waveHitsFrontWallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-004-01-02-01"), waveHitsFrontWallEmptyArrowhead.getSymbol());

		waveHitsFrontWallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-004-01-03-04"), waveHitsFrontWallSchemaArrowhead.getSymbol());
		waveHitsFrontWallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-004-01-03-03"), waveHitsFrontWallSchemaArrowhead.getSymbol());
		waveHitsFrontWallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-004-01-03-02"), waveHitsFrontWallSchemaArrowhead.getSymbol());
		waveHitsFrontWallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-004-01-03-01"), waveHitsFrontWallSchemaArrowhead.getSymbol());

		rotationSingleHitsFrontWall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-005-01-01-04"), rotationSingleHitsFrontWall.getSymbol());
		rotationSingleHitsFrontWall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-005-01-01-03"), rotationSingleHitsFrontWall.getSymbol());
		rotationSingleHitsFrontWall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-005-01-01-02"), rotationSingleHitsFrontWall.getSymbol());
		rotationSingleHitsFrontWall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-005-01-01-01"), rotationSingleHitsFrontWall.getSymbol());

		rotationSingleHitsFrontWallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-005-01-02-04"),
				rotationSingleHitsFrontWallEmptyArrowhead.getSymbol());
		rotationSingleHitsFrontWallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-005-01-02-03"),
				rotationSingleHitsFrontWallEmptyArrowhead.getSymbol());
		rotationSingleHitsFrontWallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-005-01-02-02"),
				rotationSingleHitsFrontWallEmptyArrowhead.getSymbol());
		rotationSingleHitsFrontWallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-005-01-02-01"),
				rotationSingleHitsFrontWallEmptyArrowhead.getSymbol());

		rotationSingleHitsFrontWallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-005-01-03-04"),
				rotationSingleHitsFrontWallSchemaArrowhead.getSymbol());
		rotationSingleHitsFrontWallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-005-01-03-03"),
				rotationSingleHitsFrontWallSchemaArrowhead.getSymbol());
		rotationSingleHitsFrontWallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-005-01-03-02"),
				rotationSingleHitsFrontWallSchemaArrowhead.getSymbol());
		rotationSingleHitsFrontWallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-005-01-03-01"),
				rotationSingleHitsFrontWallSchemaArrowhead.getSymbol());

		rotationDoubleHitsFrontWall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-006-01-01-04"), rotationDoubleHitsFrontWall.getSymbol());
		rotationDoubleHitsFrontWall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-006-01-01-03"), rotationDoubleHitsFrontWall.getSymbol());
		rotationDoubleHitsFrontWall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-006-01-01-02"), rotationDoubleHitsFrontWall.getSymbol());
		rotationDoubleHitsFrontWall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-006-01-01-01"), rotationDoubleHitsFrontWall.getSymbol());

		rotationDoubleHitsFrontWallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-006-01-02-04"),
				rotationDoubleHitsFrontWallEmptyArrowhead.getSymbol());
		rotationDoubleHitsFrontWallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-006-01-02-03"),
				rotationDoubleHitsFrontWallEmptyArrowhead.getSymbol());
		rotationDoubleHitsFrontWallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-006-01-02-02"),
				rotationDoubleHitsFrontWallEmptyArrowhead.getSymbol());
		rotationDoubleHitsFrontWallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-006-01-02-01"),
				rotationDoubleHitsFrontWallEmptyArrowhead.getSymbol());

		rotationDoubleHitsFrontWallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-006-01-03-04"),
				rotationDoubleHitsFrontWallSchemaArrowhead.getSymbol());
		rotationDoubleHitsFrontWallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-006-01-03-03"),
				rotationDoubleHitsFrontWallSchemaArrowhead.getSymbol());
		rotationDoubleHitsFrontWallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-006-01-03-02"),
				rotationDoubleHitsFrontWallSchemaArrowhead.getSymbol());
		rotationDoubleHitsFrontWallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-006-01-03-01"),
				rotationDoubleHitsFrontWallSchemaArrowhead.getSymbol());

		rotationAlternatingHitsFrontWall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-007-01-01-04"), rotationAlternatingHitsFrontWall.getSymbol());
		rotationAlternatingHitsFrontWall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-007-01-01-03"), rotationAlternatingHitsFrontWall.getSymbol());
		rotationAlternatingHitsFrontWall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-007-01-01-02"), rotationAlternatingHitsFrontWall.getSymbol());
		rotationAlternatingHitsFrontWall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-007-01-01-01"), rotationAlternatingHitsFrontWall.getSymbol());

		rotationAlternatingHitsFrontWallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-007-01-02-04"),
				rotationAlternatingHitsFrontWallEmptyArrowhead.getSymbol());
		rotationAlternatingHitsFrontWallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-007-01-02-03"),
				rotationAlternatingHitsFrontWallEmptyArrowhead.getSymbol());
		rotationAlternatingHitsFrontWallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-007-01-02-02"),
				rotationAlternatingHitsFrontWallEmptyArrowhead.getSymbol());
		rotationAlternatingHitsFrontWallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-007-01-02-01"),
				rotationAlternatingHitsFrontWallEmptyArrowhead.getSymbol());

		rotationAlternatingHitsFrontWallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-007-01-03-04"),
				rotationAlternatingHitsFrontWallSchemaArrowhead.getSymbol());
		rotationAlternatingHitsFrontWallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-007-01-03-03"),
				rotationAlternatingHitsFrontWallSchemaArrowhead.getSymbol());
		rotationAlternatingHitsFrontWallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-007-01-03-02"),
				rotationAlternatingHitsFrontWallSchemaArrowhead.getSymbol());
		rotationAlternatingHitsFrontWallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-007-01-03-01"),
				rotationAlternatingHitsFrontWallSchemaArrowhead.getSymbol());

		curveHitsChest.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-009-01-01-04"), curveHitsChest.getSymbol());
		curveHitsChest.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-009-01-01-03"), curveHitsChest.getSymbol());
		curveHitsChest.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-009-01-01-02"), curveHitsChest.getSymbol());
		curveHitsChest.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-009-01-01-01"), curveHitsChest.getSymbol());

		curveHitsChestEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-009-01-02-04"), curveHitsChestEmptyArrowhead.getSymbol());
		curveHitsChestEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-009-01-02-03"), curveHitsChestEmptyArrowhead.getSymbol());
		curveHitsChestEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-009-01-02-02"), curveHitsChestEmptyArrowhead.getSymbol());
		curveHitsChestEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-009-01-02-01"), curveHitsChestEmptyArrowhead.getSymbol());

		curveHitsChestSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-009-01-03-04"), curveHitsChestSchemaArrowhead.getSymbol());
		curveHitsChestSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-009-01-03-03"), curveHitsChestSchemaArrowhead.getSymbol());
		curveHitsChestSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-009-01-03-02"), curveHitsChestSchemaArrowhead.getSymbol());
		curveHitsChestSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-009-01-03-01"), curveHitsChestSchemaArrowhead.getSymbol());

		humpHitsChest.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-010-01-01-04"), humpHitsChest.getSymbol());
		humpHitsChest.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-010-01-01-03"), humpHitsChest.getSymbol());
		humpHitsChest.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-010-01-01-02"), humpHitsChest.getSymbol());
		humpHitsChest.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-010-01-01-01"), humpHitsChest.getSymbol());

		humpHitsChestEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-010-01-02-04"), humpHitsChestEmptyArrowhead.getSymbol());
		humpHitsChestEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-010-01-02-03"), humpHitsChestEmptyArrowhead.getSymbol());
		humpHitsChestEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-010-01-02-02"), humpHitsChestEmptyArrowhead.getSymbol());
		humpHitsChestEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-010-01-02-01"), humpHitsChestEmptyArrowhead.getSymbol());

		humpHitsChestSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-010-01-03-04"), humpHitsChestSchemaArrowhead.getSymbol());
		humpHitsChestSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-010-01-03-03"), humpHitsChestSchemaArrowhead.getSymbol());
		humpHitsChestSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-010-01-03-02"), humpHitsChestSchemaArrowhead.getSymbol());
		humpHitsChestSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-010-01-03-01"), humpHitsChestSchemaArrowhead.getSymbol());

		loopHitsChest.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-011-01-01-04"), loopHitsChest.getSymbol());
		loopHitsChest.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-011-01-01-03"), loopHitsChest.getSymbol());
		loopHitsChest.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-011-01-01-02"), loopHitsChest.getSymbol());
		loopHitsChest.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-011-01-01-01"), loopHitsChest.getSymbol());

		loopHitsChestEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-011-01-02-04"), loopHitsChestEmptyArrowhead.getSymbol());
		loopHitsChestEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-011-01-02-03"), loopHitsChestEmptyArrowhead.getSymbol());
		loopHitsChestEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-011-01-02-02"), loopHitsChestEmptyArrowhead.getSymbol());
		loopHitsChestEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-011-01-02-01"), loopHitsChestEmptyArrowhead.getSymbol());

		loopHitsChestSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-011-01-03-04"), loopHitsChestSchemaArrowhead.getSymbol());
		loopHitsChestSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-011-01-03-03"), loopHitsChestSchemaArrowhead.getSymbol());
		loopHitsChestSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-011-01-03-02"), loopHitsChestSchemaArrowhead.getSymbol());
		loopHitsChestSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-011-01-03-01"), loopHitsChestSchemaArrowhead.getSymbol());

		waveHitsChest.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-012-01-01-04"), waveHitsChest.getSymbol());
		waveHitsChest.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-012-01-01-03"), waveHitsChest.getSymbol());
		waveHitsChest.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-012-01-01-02"), waveHitsChest.getSymbol());
		waveHitsChest.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-012-01-01-01"), waveHitsChest.getSymbol());

		waveHitsChestEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-012-01-02-04"), waveHitsChestEmptyArrowhead.getSymbol());
		waveHitsChestEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-012-01-02-03"), waveHitsChestEmptyArrowhead.getSymbol());
		waveHitsChestEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-012-01-02-02"), waveHitsChestEmptyArrowhead.getSymbol());
		waveHitsChestEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-012-01-02-01"), waveHitsChestEmptyArrowhead.getSymbol());

		waveHitsChestSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-012-01-03-04"), waveHitsChestSchemaArrowhead.getSymbol());
		waveHitsChestSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-012-01-03-03"), waveHitsChestSchemaArrowhead.getSymbol());
		waveHitsChestSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-012-01-03-02"), waveHitsChestSchemaArrowhead.getSymbol());
		waveHitsChestSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-012-01-03-01"), waveHitsChestSchemaArrowhead.getSymbol());

		rotationSingleHitsChest.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-013-01-01-04"), rotationSingleHitsChest.getSymbol());
		rotationSingleHitsChest.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-013-01-01-03"), rotationSingleHitsChest.getSymbol());
		rotationSingleHitsChest.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-013-01-01-02"), rotationSingleHitsChest.getSymbol());
		rotationSingleHitsChest.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-013-01-01-01"), rotationSingleHitsChest.getSymbol());

		rotationSingleHitsChestEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-013-01-02-04"),
				rotationSingleHitsChestEmptyArrowhead.getSymbol());
		rotationSingleHitsChestEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-013-01-02-03"),
				rotationSingleHitsChestEmptyArrowhead.getSymbol());
		rotationSingleHitsChestEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-013-01-02-02"),
				rotationSingleHitsChestEmptyArrowhead.getSymbol());
		rotationSingleHitsChestEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-013-01-02-01"),
				rotationSingleHitsChestEmptyArrowhead.getSymbol());

		rotationSingleHitsChestSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-013-01-03-04"),
				rotationSingleHitsChestSchemaArrowhead.getSymbol());
		rotationSingleHitsChestSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-013-01-03-03"),
				rotationSingleHitsChestSchemaArrowhead.getSymbol());
		rotationSingleHitsChestSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-013-01-03-02"),
				rotationSingleHitsChestSchemaArrowhead.getSymbol());
		rotationSingleHitsChestSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-013-01-03-01"),
				rotationSingleHitsChestSchemaArrowhead.getSymbol());

		rotationDoubleHitsChest.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-014-01-01-04"), rotationDoubleHitsChest.getSymbol());
		rotationDoubleHitsChest.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-014-01-01-03"), rotationDoubleHitsChest.getSymbol());
		rotationDoubleHitsChest.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-014-01-01-02"), rotationDoubleHitsChest.getSymbol());
		rotationDoubleHitsChest.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-014-01-01-01"), rotationDoubleHitsChest.getSymbol());

		rotationDoubleHitsChestEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-014-01-02-04"),
				rotationDoubleHitsChestEmptyArrowhead.getSymbol());
		rotationDoubleHitsChestEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-014-01-02-03"),
				rotationDoubleHitsChestEmptyArrowhead.getSymbol());
		rotationDoubleHitsChestEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-014-01-02-02"),
				rotationDoubleHitsChestEmptyArrowhead.getSymbol());
		rotationDoubleHitsChestEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-014-01-02-01"),
				rotationDoubleHitsChestEmptyArrowhead.getSymbol());

		rotationDoubleHitsChestSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-014-01-03-04"),
				rotationDoubleHitsChestSchemaArrowhead.getSymbol());
		rotationDoubleHitsChestSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-014-01-03-03"),
				rotationDoubleHitsChestSchemaArrowhead.getSymbol());
		rotationDoubleHitsChestSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-014-01-03-02"),
				rotationDoubleHitsChestSchemaArrowhead.getSymbol());
		rotationDoubleHitsChestSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-014-01-03-01"),
				rotationDoubleHitsChestSchemaArrowhead.getSymbol());

		rotationAlternatingHitsChest.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-015-01-01-04"), rotationAlternatingHitsChest.getSymbol());
		rotationAlternatingHitsChest.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-015-01-01-03"), rotationAlternatingHitsChest.getSymbol());
		rotationAlternatingHitsChest.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-015-01-01-02"), rotationAlternatingHitsChest.getSymbol());
		rotationAlternatingHitsChest.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-015-01-01-01"), rotationAlternatingHitsChest.getSymbol());

		rotationAlternatingHitsChestEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-015-01-02-04"),
				rotationAlternatingHitsChestEmptyArrowhead.getSymbol());
		rotationAlternatingHitsChestEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-015-01-02-03"),
				rotationAlternatingHitsChestEmptyArrowhead.getSymbol());
		rotationAlternatingHitsChestEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-015-01-02-02"),
				rotationAlternatingHitsChestEmptyArrowhead.getSymbol());
		rotationAlternatingHitsChestEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-015-01-02-01"),
				rotationAlternatingHitsChestEmptyArrowhead.getSymbol());

		rotationAlternatingHitsChestSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-015-01-03-04"),
				rotationAlternatingHitsChestSchemaArrowhead.getSymbol());
		rotationAlternatingHitsChestSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-015-01-03-03"),
				rotationAlternatingHitsChestSchemaArrowhead.getSymbol());
		rotationAlternatingHitsChestSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-015-01-03-02"),
				rotationAlternatingHitsChestSchemaArrowhead.getSymbol());
		rotationAlternatingHitsChestSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-015-01-03-01"),
				rotationAlternatingHitsChestSchemaArrowhead.getSymbol());

		waveDiagonalPathSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-01-01-08"), waveDiagonalPathSmall.getSymbol());
		waveDiagonalPathSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-01-01-06"), waveDiagonalPathSmall.getSymbol());
		waveDiagonalPathSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-01-01-05"), waveDiagonalPathSmall.getSymbol());
		waveDiagonalPathSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-01-01-04"), waveDiagonalPathSmall.getSymbol());
		waveDiagonalPathSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-01-01-02"), waveDiagonalPathSmall.getSymbol());
		waveDiagonalPathSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-01-01-01"), waveDiagonalPathSmall.getSymbol());

		waveDiagonalPathSmallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-01-02-08"), waveDiagonalPathSmallEmptyArrowhead.getSymbol());
		waveDiagonalPathSmallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-01-02-06"), waveDiagonalPathSmallEmptyArrowhead.getSymbol());
		waveDiagonalPathSmallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-01-02-05"), waveDiagonalPathSmallEmptyArrowhead.getSymbol());
		waveDiagonalPathSmallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-01-02-04"), waveDiagonalPathSmallEmptyArrowhead.getSymbol());
		waveDiagonalPathSmallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-01-02-02"), waveDiagonalPathSmallEmptyArrowhead.getSymbol());
		waveDiagonalPathSmallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-01-02-01"), waveDiagonalPathSmallEmptyArrowhead.getSymbol());

		waveDiagonalPathSmallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-01-03-08"),
				waveDiagonalPathSmallSchemaArrowhead.getSymbol());
		waveDiagonalPathSmallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-01-03-06"),
				waveDiagonalPathSmallSchemaArrowhead.getSymbol());
		waveDiagonalPathSmallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-01-03-05"),
				waveDiagonalPathSmallSchemaArrowhead.getSymbol());
		waveDiagonalPathSmallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-01-03-04"),
				waveDiagonalPathSmallSchemaArrowhead.getSymbol());
		waveDiagonalPathSmallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-01-03-02"),
				waveDiagonalPathSmallSchemaArrowhead.getSymbol());
		waveDiagonalPathSmallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-01-03-01"),
				waveDiagonalPathSmallSchemaArrowhead.getSymbol());

		waveDiagonalPathSmallMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-01-01-10"), waveDiagonalPathSmallMirrored.getSymbol());
		waveDiagonalPathSmallMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-01-01-12"), waveDiagonalPathSmallMirrored.getSymbol());
		waveDiagonalPathSmallMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-01-01-13"), waveDiagonalPathSmallMirrored.getSymbol());
		waveDiagonalPathSmallMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-01-01-14"), waveDiagonalPathSmallMirrored.getSymbol());
		waveDiagonalPathSmallMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-01-01-16"), waveDiagonalPathSmallMirrored.getSymbol());
		waveDiagonalPathSmallMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-01-01-09"), waveDiagonalPathSmallMirrored.getSymbol());

		waveDiagonalPathSmallEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-01-02-10"),
				waveDiagonalPathSmallEmptyArrowheadMirrored.getSymbol());
		waveDiagonalPathSmallEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-01-02-12"),
				waveDiagonalPathSmallEmptyArrowheadMirrored.getSymbol());
		waveDiagonalPathSmallEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-01-02-13"),
				waveDiagonalPathSmallEmptyArrowheadMirrored.getSymbol());
		waveDiagonalPathSmallEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-01-02-14"),
				waveDiagonalPathSmallEmptyArrowheadMirrored.getSymbol());
		waveDiagonalPathSmallEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-01-02-16"),
				waveDiagonalPathSmallEmptyArrowheadMirrored.getSymbol());
		waveDiagonalPathSmallEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-01-02-09"),
				waveDiagonalPathSmallEmptyArrowheadMirrored.getSymbol());

		waveDiagonalPathSmallSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-01-03-10"),
				waveDiagonalPathSmallSchemaArrowheadMirrored.getSymbol());
		waveDiagonalPathSmallSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-01-03-12"),
				waveDiagonalPathSmallSchemaArrowheadMirrored.getSymbol());
		waveDiagonalPathSmallSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-01-03-13"),
				waveDiagonalPathSmallSchemaArrowheadMirrored.getSymbol());
		waveDiagonalPathSmallSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-01-03-14"),
				waveDiagonalPathSmallSchemaArrowheadMirrored.getSymbol());
		waveDiagonalPathSmallSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-01-03-16"),
				waveDiagonalPathSmallSchemaArrowheadMirrored.getSymbol());
		waveDiagonalPathSmallSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-01-03-09"),
				waveDiagonalPathSmallSchemaArrowheadMirrored.getSymbol());

		waveDiagonalPathMedium.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-02-01-08"), waveDiagonalPathMedium.getSymbol());
		waveDiagonalPathMedium.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-02-01-06"), waveDiagonalPathMedium.getSymbol());
		waveDiagonalPathMedium.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-02-01-05"), waveDiagonalPathMedium.getSymbol());
		waveDiagonalPathMedium.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-02-01-04"), waveDiagonalPathMedium.getSymbol());
		waveDiagonalPathMedium.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-02-01-02"), waveDiagonalPathMedium.getSymbol());
		waveDiagonalPathMedium.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-02-01-01"), waveDiagonalPathMedium.getSymbol());

		waveDiagonalPathMediumEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-02-02-08"),
				waveDiagonalPathMediumEmptyArrowhead.getSymbol());
		waveDiagonalPathMediumEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-02-02-06"),
				waveDiagonalPathMediumEmptyArrowhead.getSymbol());
		waveDiagonalPathMediumEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-02-02-05"),
				waveDiagonalPathMediumEmptyArrowhead.getSymbol());
		waveDiagonalPathMediumEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-02-02-04"),
				waveDiagonalPathMediumEmptyArrowhead.getSymbol());
		waveDiagonalPathMediumEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-02-02-02"),
				waveDiagonalPathMediumEmptyArrowhead.getSymbol());
		waveDiagonalPathMediumEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-02-02-01"),
				waveDiagonalPathMediumEmptyArrowhead.getSymbol());

		waveDiagonalPathMediumSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-02-03-08"),
				waveDiagonalPathMediumSchemaArrowhead.getSymbol());
		waveDiagonalPathMediumSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-02-03-06"),
				waveDiagonalPathMediumSchemaArrowhead.getSymbol());
		waveDiagonalPathMediumSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-02-03-05"),
				waveDiagonalPathMediumSchemaArrowhead.getSymbol());
		waveDiagonalPathMediumSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-02-03-04"),
				waveDiagonalPathMediumSchemaArrowhead.getSymbol());
		waveDiagonalPathMediumSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-02-03-02"),
				waveDiagonalPathMediumSchemaArrowhead.getSymbol());
		waveDiagonalPathMediumSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-02-03-01"),
				waveDiagonalPathMediumSchemaArrowhead.getSymbol());

		waveDiagonalPathMediumMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-02-01-10"), waveDiagonalPathMediumMirrored.getSymbol());
		waveDiagonalPathMediumMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-02-01-12"), waveDiagonalPathMediumMirrored.getSymbol());
		waveDiagonalPathMediumMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-02-01-13"), waveDiagonalPathMediumMirrored.getSymbol());
		waveDiagonalPathMediumMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-02-01-14"), waveDiagonalPathMediumMirrored.getSymbol());
		waveDiagonalPathMediumMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-02-01-16"), waveDiagonalPathMediumMirrored.getSymbol());
		waveDiagonalPathMediumMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-02-01-09"), waveDiagonalPathMediumMirrored.getSymbol());

		waveDiagonalPathMediumEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-02-02-10"),
				waveDiagonalPathMediumEmptyArrowheadMirrored.getSymbol());
		waveDiagonalPathMediumEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-02-02-12"),
				waveDiagonalPathMediumEmptyArrowheadMirrored.getSymbol());
		waveDiagonalPathMediumEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-02-02-13"),
				waveDiagonalPathMediumEmptyArrowheadMirrored.getSymbol());
		waveDiagonalPathMediumEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-02-02-14"),
				waveDiagonalPathMediumEmptyArrowheadMirrored.getSymbol());
		waveDiagonalPathMediumEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-02-02-16"),
				waveDiagonalPathMediumEmptyArrowheadMirrored.getSymbol());
		waveDiagonalPathMediumEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-02-02-09"),
				waveDiagonalPathMediumEmptyArrowheadMirrored.getSymbol());

		waveDiagonalPathMediumSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-02-03-10"),
				waveDiagonalPathMediumSchemaArrowheadMirrored.getSymbol());
		waveDiagonalPathMediumSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-02-03-12"),
				waveDiagonalPathMediumSchemaArrowheadMirrored.getSymbol());
		waveDiagonalPathMediumSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-02-03-13"),
				waveDiagonalPathMediumSchemaArrowheadMirrored.getSymbol());
		waveDiagonalPathMediumSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-02-03-14"),
				waveDiagonalPathMediumSchemaArrowheadMirrored.getSymbol());
		waveDiagonalPathMediumSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-02-03-16"),
				waveDiagonalPathMediumSchemaArrowheadMirrored.getSymbol());
		waveDiagonalPathMediumSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-02-03-09"),
				waveDiagonalPathMediumSchemaArrowheadMirrored.getSymbol());

		waveDiagonalPathLarge.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-03-01-08"), waveDiagonalPathLarge.getSymbol());
		waveDiagonalPathLarge.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-03-01-06"), waveDiagonalPathLarge.getSymbol());
		waveDiagonalPathLarge.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-03-01-05"), waveDiagonalPathLarge.getSymbol());
		waveDiagonalPathLarge.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-03-01-04"), waveDiagonalPathLarge.getSymbol());
		waveDiagonalPathLarge.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-03-01-02"), waveDiagonalPathLarge.getSymbol());
		waveDiagonalPathLarge.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-03-01-01"), waveDiagonalPathLarge.getSymbol());

		waveDiagonalPathLargeEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-03-02-08"), waveDiagonalPathLargeEmptyArrowhead.getSymbol());
		waveDiagonalPathLargeEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-03-02-06"), waveDiagonalPathLargeEmptyArrowhead.getSymbol());
		waveDiagonalPathLargeEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-03-02-05"), waveDiagonalPathLargeEmptyArrowhead.getSymbol());
		waveDiagonalPathLargeEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-03-02-04"), waveDiagonalPathLargeEmptyArrowhead.getSymbol());
		waveDiagonalPathLargeEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-03-02-02"), waveDiagonalPathLargeEmptyArrowhead.getSymbol());
		waveDiagonalPathLargeEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-03-02-01"), waveDiagonalPathLargeEmptyArrowhead.getSymbol());

		waveDiagonalPathLargeSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-03-03-08"),
				waveDiagonalPathLargeSchemaArrowhead.getSymbol());
		waveDiagonalPathLargeSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-03-03-06"),
				waveDiagonalPathLargeSchemaArrowhead.getSymbol());
		waveDiagonalPathLargeSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-03-03-05"),
				waveDiagonalPathLargeSchemaArrowhead.getSymbol());
		waveDiagonalPathLargeSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-03-03-04"),
				waveDiagonalPathLargeSchemaArrowhead.getSymbol());
		waveDiagonalPathLargeSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-03-03-02"),
				waveDiagonalPathLargeSchemaArrowhead.getSymbol());
		waveDiagonalPathLargeSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-03-03-01"),
				waveDiagonalPathLargeSchemaArrowhead.getSymbol());

		waveDiagonalPathLargeMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-03-01-10"), waveDiagonalPathLargeMirrored.getSymbol());
		waveDiagonalPathLargeMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-03-01-12"), waveDiagonalPathLargeMirrored.getSymbol());
		waveDiagonalPathLargeMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-03-01-13"), waveDiagonalPathLargeMirrored.getSymbol());
		waveDiagonalPathLargeMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-03-01-14"), waveDiagonalPathLargeMirrored.getSymbol());
		waveDiagonalPathLargeMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-03-01-16"), waveDiagonalPathLargeMirrored.getSymbol());
		waveDiagonalPathLargeMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-03-01-09"), waveDiagonalPathLargeMirrored.getSymbol());

		waveDiagonalPathLargeEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-03-02-10"),
				waveDiagonalPathLargeEmptyArrowheadMirrored.getSymbol());
		waveDiagonalPathLargeEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-03-02-12"),
				waveDiagonalPathLargeEmptyArrowheadMirrored.getSymbol());
		waveDiagonalPathLargeEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-03-02-13"),
				waveDiagonalPathLargeEmptyArrowheadMirrored.getSymbol());
		waveDiagonalPathLargeEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-03-02-14"),
				waveDiagonalPathLargeEmptyArrowheadMirrored.getSymbol());
		waveDiagonalPathLargeEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-03-02-16"),
				waveDiagonalPathLargeEmptyArrowheadMirrored.getSymbol());
		waveDiagonalPathLargeEmptyArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-03-02-09"),
				waveDiagonalPathLargeEmptyArrowheadMirrored.getSymbol());

		waveDiagonalPathLargeSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-03-03-10"),
				waveDiagonalPathLargeSchemaArrowheadMirrored.getSymbol());
		waveDiagonalPathLargeSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-03-03-12"),
				waveDiagonalPathLargeSchemaArrowheadMirrored.getSymbol());
		waveDiagonalPathLargeSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-03-03-13"),
				waveDiagonalPathLargeSchemaArrowheadMirrored.getSymbol());
		waveDiagonalPathLargeSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-03-03-14"),
				waveDiagonalPathLargeSchemaArrowheadMirrored.getSymbol());
		waveDiagonalPathLargeSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-03-03-16"),
				waveDiagonalPathLargeSchemaArrowheadMirrored.getSymbol());
		waveDiagonalPathLargeSchemaArrowheadMirrored.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-03-03-09"),
				waveDiagonalPathLargeSchemaArrowheadMirrored.getSymbol());

	}

	@Override
	public void testRotateCounterClockwise() {

		curveHitsFrontWall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-001-01-01-02"), curveHitsFrontWall.getSymbol());
		curveHitsFrontWall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-001-01-01-03"), curveHitsFrontWall.getSymbol());
		curveHitsFrontWall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-001-01-01-04"), curveHitsFrontWall.getSymbol());
		curveHitsFrontWall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-001-01-01-01"), curveHitsFrontWall.getSymbol());

		curveHitsFrontWallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-001-01-02-02"), curveHitsFrontWallEmptyArrowhead.getSymbol());
		curveHitsFrontWallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-001-01-02-03"), curveHitsFrontWallEmptyArrowhead.getSymbol());
		curveHitsFrontWallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-001-01-02-04"), curveHitsFrontWallEmptyArrowhead.getSymbol());
		curveHitsFrontWallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-001-01-02-01"), curveHitsFrontWallEmptyArrowhead.getSymbol());

		curveHitsFrontWallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-001-01-03-02"), curveHitsFrontWallSchemaArrowhead.getSymbol());
		curveHitsFrontWallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-001-01-03-03"), curveHitsFrontWallSchemaArrowhead.getSymbol());
		curveHitsFrontWallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-001-01-03-04"), curveHitsFrontWallSchemaArrowhead.getSymbol());
		curveHitsFrontWallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-001-01-03-01"), curveHitsFrontWallSchemaArrowhead.getSymbol());

		humpHitsFrontWall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-002-01-01-02"), humpHitsFrontWall.getSymbol());
		humpHitsFrontWall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-002-01-01-03"), humpHitsFrontWall.getSymbol());
		humpHitsFrontWall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-002-01-01-04"), humpHitsFrontWall.getSymbol());
		humpHitsFrontWall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-002-01-01-01"), humpHitsFrontWall.getSymbol());

		humpHitsFrontWallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-002-01-02-02"), humpHitsFrontWallEmptyArrowhead.getSymbol());
		humpHitsFrontWallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-002-01-02-03"), humpHitsFrontWallEmptyArrowhead.getSymbol());
		humpHitsFrontWallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-002-01-02-04"), humpHitsFrontWallEmptyArrowhead.getSymbol());
		humpHitsFrontWallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-002-01-02-01"), humpHitsFrontWallEmptyArrowhead.getSymbol());

		humpHitsFrontWallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-002-01-03-02"), humpHitsFrontWallSchemaArrowhead.getSymbol());
		humpHitsFrontWallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-002-01-03-03"), humpHitsFrontWallSchemaArrowhead.getSymbol());
		humpHitsFrontWallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-002-01-03-04"), humpHitsFrontWallSchemaArrowhead.getSymbol());
		humpHitsFrontWallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-002-01-03-01"), humpHitsFrontWallSchemaArrowhead.getSymbol());

		loopHitsFrontWall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-003-01-01-02"), loopHitsFrontWall.getSymbol());
		loopHitsFrontWall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-003-01-01-03"), loopHitsFrontWall.getSymbol());
		loopHitsFrontWall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-003-01-01-04"), loopHitsFrontWall.getSymbol());
		loopHitsFrontWall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-003-01-01-01"), loopHitsFrontWall.getSymbol());

		loopHitsFrontWallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-003-01-02-02"), loopHitsFrontWallEmptyArrowhead.getSymbol());
		loopHitsFrontWallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-003-01-02-03"), loopHitsFrontWallEmptyArrowhead.getSymbol());
		loopHitsFrontWallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-003-01-02-04"), loopHitsFrontWallEmptyArrowhead.getSymbol());
		loopHitsFrontWallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-003-01-02-01"), loopHitsFrontWallEmptyArrowhead.getSymbol());

		loopHitsFrontWallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-003-01-03-02"), loopHitsFrontWallSchemaArrowhead.getSymbol());
		loopHitsFrontWallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-003-01-03-03"), loopHitsFrontWallSchemaArrowhead.getSymbol());
		loopHitsFrontWallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-003-01-03-04"), loopHitsFrontWallSchemaArrowhead.getSymbol());
		loopHitsFrontWallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-003-01-03-01"), loopHitsFrontWallSchemaArrowhead.getSymbol());

		waveHitsFrontWall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-004-01-01-02"), waveHitsFrontWall.getSymbol());
		waveHitsFrontWall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-004-01-01-03"), waveHitsFrontWall.getSymbol());
		waveHitsFrontWall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-004-01-01-04"), waveHitsFrontWall.getSymbol());
		waveHitsFrontWall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-004-01-01-01"), waveHitsFrontWall.getSymbol());

		waveHitsFrontWallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-004-01-02-02"), waveHitsFrontWallEmptyArrowhead.getSymbol());
		waveHitsFrontWallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-004-01-02-03"), waveHitsFrontWallEmptyArrowhead.getSymbol());
		waveHitsFrontWallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-004-01-02-04"), waveHitsFrontWallEmptyArrowhead.getSymbol());
		waveHitsFrontWallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-004-01-02-01"), waveHitsFrontWallEmptyArrowhead.getSymbol());

		waveHitsFrontWallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-004-01-03-02"), waveHitsFrontWallSchemaArrowhead.getSymbol());
		waveHitsFrontWallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-004-01-03-03"), waveHitsFrontWallSchemaArrowhead.getSymbol());
		waveHitsFrontWallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-004-01-03-04"), waveHitsFrontWallSchemaArrowhead.getSymbol());
		waveHitsFrontWallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-004-01-03-01"), waveHitsFrontWallSchemaArrowhead.getSymbol());

		rotationSingleHitsFrontWall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-005-01-01-02"), rotationSingleHitsFrontWall.getSymbol());
		rotationSingleHitsFrontWall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-005-01-01-03"), rotationSingleHitsFrontWall.getSymbol());
		rotationSingleHitsFrontWall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-005-01-01-04"), rotationSingleHitsFrontWall.getSymbol());
		rotationSingleHitsFrontWall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-005-01-01-01"), rotationSingleHitsFrontWall.getSymbol());

		rotationSingleHitsFrontWallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-005-01-02-02"),
				rotationSingleHitsFrontWallEmptyArrowhead.getSymbol());
		rotationSingleHitsFrontWallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-005-01-02-03"),
				rotationSingleHitsFrontWallEmptyArrowhead.getSymbol());
		rotationSingleHitsFrontWallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-005-01-02-04"),
				rotationSingleHitsFrontWallEmptyArrowhead.getSymbol());
		rotationSingleHitsFrontWallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-005-01-02-01"),
				rotationSingleHitsFrontWallEmptyArrowhead.getSymbol());

		rotationSingleHitsFrontWallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-005-01-03-02"),
				rotationSingleHitsFrontWallSchemaArrowhead.getSymbol());
		rotationSingleHitsFrontWallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-005-01-03-03"),
				rotationSingleHitsFrontWallSchemaArrowhead.getSymbol());
		rotationSingleHitsFrontWallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-005-01-03-04"),
				rotationSingleHitsFrontWallSchemaArrowhead.getSymbol());
		rotationSingleHitsFrontWallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-005-01-03-01"),
				rotationSingleHitsFrontWallSchemaArrowhead.getSymbol());

		rotationDoubleHitsFrontWall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-006-01-01-02"), rotationDoubleHitsFrontWall.getSymbol());
		rotationDoubleHitsFrontWall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-006-01-01-03"), rotationDoubleHitsFrontWall.getSymbol());
		rotationDoubleHitsFrontWall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-006-01-01-04"), rotationDoubleHitsFrontWall.getSymbol());
		rotationDoubleHitsFrontWall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-006-01-01-01"), rotationDoubleHitsFrontWall.getSymbol());

		rotationDoubleHitsFrontWallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-006-01-02-02"),
				rotationDoubleHitsFrontWallEmptyArrowhead.getSymbol());
		rotationDoubleHitsFrontWallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-006-01-02-03"),
				rotationDoubleHitsFrontWallEmptyArrowhead.getSymbol());
		rotationDoubleHitsFrontWallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-006-01-02-04"),
				rotationDoubleHitsFrontWallEmptyArrowhead.getSymbol());
		rotationDoubleHitsFrontWallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-006-01-02-01"),
				rotationDoubleHitsFrontWallEmptyArrowhead.getSymbol());

		rotationDoubleHitsFrontWallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-006-01-03-02"),
				rotationDoubleHitsFrontWallSchemaArrowhead.getSymbol());
		rotationDoubleHitsFrontWallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-006-01-03-03"),
				rotationDoubleHitsFrontWallSchemaArrowhead.getSymbol());
		rotationDoubleHitsFrontWallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-006-01-03-04"),
				rotationDoubleHitsFrontWallSchemaArrowhead.getSymbol());
		rotationDoubleHitsFrontWallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-006-01-03-01"),
				rotationDoubleHitsFrontWallSchemaArrowhead.getSymbol());

		rotationAlternatingHitsFrontWall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-007-01-01-02"), rotationAlternatingHitsFrontWall.getSymbol());
		rotationAlternatingHitsFrontWall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-007-01-01-03"), rotationAlternatingHitsFrontWall.getSymbol());
		rotationAlternatingHitsFrontWall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-007-01-01-04"), rotationAlternatingHitsFrontWall.getSymbol());
		rotationAlternatingHitsFrontWall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-007-01-01-01"), rotationAlternatingHitsFrontWall.getSymbol());

		rotationAlternatingHitsFrontWallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-007-01-02-02"),
				rotationAlternatingHitsFrontWallEmptyArrowhead.getSymbol());
		rotationAlternatingHitsFrontWallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-007-01-02-03"),
				rotationAlternatingHitsFrontWallEmptyArrowhead.getSymbol());
		rotationAlternatingHitsFrontWallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-007-01-02-04"),
				rotationAlternatingHitsFrontWallEmptyArrowhead.getSymbol());
		rotationAlternatingHitsFrontWallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-007-01-02-01"),
				rotationAlternatingHitsFrontWallEmptyArrowhead.getSymbol());

		rotationAlternatingHitsFrontWallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-007-01-03-02"),
				rotationAlternatingHitsFrontWallSchemaArrowhead.getSymbol());
		rotationAlternatingHitsFrontWallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-007-01-03-03"),
				rotationAlternatingHitsFrontWallSchemaArrowhead.getSymbol());
		rotationAlternatingHitsFrontWallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-007-01-03-04"),
				rotationAlternatingHitsFrontWallSchemaArrowhead.getSymbol());
		rotationAlternatingHitsFrontWallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-007-01-03-01"),
				rotationAlternatingHitsFrontWallSchemaArrowhead.getSymbol());

		curveHitsChest.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-009-01-01-02"), curveHitsChest.getSymbol());
		curveHitsChest.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-009-01-01-03"), curveHitsChest.getSymbol());
		curveHitsChest.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-009-01-01-04"), curveHitsChest.getSymbol());
		curveHitsChest.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-009-01-01-01"), curveHitsChest.getSymbol());

		curveHitsChestEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-009-01-02-02"), curveHitsChestEmptyArrowhead.getSymbol());
		curveHitsChestEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-009-01-02-03"), curveHitsChestEmptyArrowhead.getSymbol());
		curveHitsChestEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-009-01-02-04"), curveHitsChestEmptyArrowhead.getSymbol());
		curveHitsChestEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-009-01-02-01"), curveHitsChestEmptyArrowhead.getSymbol());

		curveHitsChestSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-009-01-03-02"), curveHitsChestSchemaArrowhead.getSymbol());
		curveHitsChestSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-009-01-03-03"), curveHitsChestSchemaArrowhead.getSymbol());
		curveHitsChestSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-009-01-03-04"), curveHitsChestSchemaArrowhead.getSymbol());
		curveHitsChestSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-009-01-03-01"), curveHitsChestSchemaArrowhead.getSymbol());

		humpHitsChest.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-010-01-01-02"), humpHitsChest.getSymbol());
		humpHitsChest.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-010-01-01-03"), humpHitsChest.getSymbol());
		humpHitsChest.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-010-01-01-04"), humpHitsChest.getSymbol());
		humpHitsChest.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-010-01-01-01"), humpHitsChest.getSymbol());

		humpHitsChestEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-010-01-02-02"), humpHitsChestEmptyArrowhead.getSymbol());
		humpHitsChestEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-010-01-02-03"), humpHitsChestEmptyArrowhead.getSymbol());
		humpHitsChestEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-010-01-02-04"), humpHitsChestEmptyArrowhead.getSymbol());
		humpHitsChestEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-010-01-02-01"), humpHitsChestEmptyArrowhead.getSymbol());

		humpHitsChestSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-010-01-03-02"), humpHitsChestSchemaArrowhead.getSymbol());
		humpHitsChestSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-010-01-03-03"), humpHitsChestSchemaArrowhead.getSymbol());
		humpHitsChestSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-010-01-03-04"), humpHitsChestSchemaArrowhead.getSymbol());
		humpHitsChestSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-010-01-03-01"), humpHitsChestSchemaArrowhead.getSymbol());

		loopHitsChest.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-011-01-01-02"), loopHitsChest.getSymbol());
		loopHitsChest.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-011-01-01-03"), loopHitsChest.getSymbol());
		loopHitsChest.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-011-01-01-04"), loopHitsChest.getSymbol());
		loopHitsChest.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-011-01-01-01"), loopHitsChest.getSymbol());

		loopHitsChestEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-011-01-02-02"), loopHitsChestEmptyArrowhead.getSymbol());
		loopHitsChestEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-011-01-02-03"), loopHitsChestEmptyArrowhead.getSymbol());
		loopHitsChestEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-011-01-02-04"), loopHitsChestEmptyArrowhead.getSymbol());
		loopHitsChestEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-011-01-02-01"), loopHitsChestEmptyArrowhead.getSymbol());

		loopHitsChestSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-011-01-03-02"), loopHitsChestSchemaArrowhead.getSymbol());
		loopHitsChestSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-011-01-03-03"), loopHitsChestSchemaArrowhead.getSymbol());
		loopHitsChestSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-011-01-03-04"), loopHitsChestSchemaArrowhead.getSymbol());
		loopHitsChestSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-011-01-03-01"), loopHitsChestSchemaArrowhead.getSymbol());

		waveHitsChest.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-012-01-01-02"), waveHitsChest.getSymbol());
		waveHitsChest.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-012-01-01-03"), waveHitsChest.getSymbol());
		waveHitsChest.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-012-01-01-04"), waveHitsChest.getSymbol());
		waveHitsChest.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-012-01-01-01"), waveHitsChest.getSymbol());

		waveHitsChestEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-012-01-02-02"), waveHitsChestEmptyArrowhead.getSymbol());
		waveHitsChestEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-012-01-02-03"), waveHitsChestEmptyArrowhead.getSymbol());
		waveHitsChestEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-012-01-02-04"), waveHitsChestEmptyArrowhead.getSymbol());
		waveHitsChestEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-012-01-02-01"), waveHitsChestEmptyArrowhead.getSymbol());

		waveHitsChestSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-012-01-03-02"), waveHitsChestSchemaArrowhead.getSymbol());
		waveHitsChestSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-012-01-03-03"), waveHitsChestSchemaArrowhead.getSymbol());
		waveHitsChestSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-012-01-03-04"), waveHitsChestSchemaArrowhead.getSymbol());
		waveHitsChestSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-012-01-03-01"), waveHitsChestSchemaArrowhead.getSymbol());

		rotationSingleHitsChest.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-013-01-01-02"), rotationSingleHitsChest.getSymbol());
		rotationSingleHitsChest.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-013-01-01-03"), rotationSingleHitsChest.getSymbol());
		rotationSingleHitsChest.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-013-01-01-04"), rotationSingleHitsChest.getSymbol());
		rotationSingleHitsChest.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-013-01-01-01"), rotationSingleHitsChest.getSymbol());

		rotationSingleHitsChestEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-013-01-02-02"),
				rotationSingleHitsChestEmptyArrowhead.getSymbol());
		rotationSingleHitsChestEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-013-01-02-03"),
				rotationSingleHitsChestEmptyArrowhead.getSymbol());
		rotationSingleHitsChestEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-013-01-02-04"),
				rotationSingleHitsChestEmptyArrowhead.getSymbol());
		rotationSingleHitsChestEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-013-01-02-01"),
				rotationSingleHitsChestEmptyArrowhead.getSymbol());

		rotationSingleHitsChestSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-013-01-03-02"),
				rotationSingleHitsChestSchemaArrowhead.getSymbol());
		rotationSingleHitsChestSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-013-01-03-03"),
				rotationSingleHitsChestSchemaArrowhead.getSymbol());
		rotationSingleHitsChestSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-013-01-03-04"),
				rotationSingleHitsChestSchemaArrowhead.getSymbol());
		rotationSingleHitsChestSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-013-01-03-01"),
				rotationSingleHitsChestSchemaArrowhead.getSymbol());

		rotationDoubleHitsChest.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-014-01-01-02"), rotationDoubleHitsChest.getSymbol());
		rotationDoubleHitsChest.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-014-01-01-03"), rotationDoubleHitsChest.getSymbol());
		rotationDoubleHitsChest.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-014-01-01-04"), rotationDoubleHitsChest.getSymbol());
		rotationDoubleHitsChest.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-014-01-01-01"), rotationDoubleHitsChest.getSymbol());

		rotationDoubleHitsChestEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-014-01-02-02"),
				rotationDoubleHitsChestEmptyArrowhead.getSymbol());
		rotationDoubleHitsChestEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-014-01-02-03"),
				rotationDoubleHitsChestEmptyArrowhead.getSymbol());
		rotationDoubleHitsChestEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-014-01-02-04"),
				rotationDoubleHitsChestEmptyArrowhead.getSymbol());
		rotationDoubleHitsChestEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-014-01-02-01"),
				rotationDoubleHitsChestEmptyArrowhead.getSymbol());

		rotationDoubleHitsChestSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-014-01-03-02"),
				rotationDoubleHitsChestSchemaArrowhead.getSymbol());
		rotationDoubleHitsChestSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-014-01-03-03"),
				rotationDoubleHitsChestSchemaArrowhead.getSymbol());
		rotationDoubleHitsChestSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-014-01-03-04"),
				rotationDoubleHitsChestSchemaArrowhead.getSymbol());
		rotationDoubleHitsChestSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-014-01-03-01"),
				rotationDoubleHitsChestSchemaArrowhead.getSymbol());

		rotationAlternatingHitsChest.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-015-01-01-02"), rotationAlternatingHitsChest.getSymbol());
		rotationAlternatingHitsChest.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-015-01-01-03"), rotationAlternatingHitsChest.getSymbol());
		rotationAlternatingHitsChest.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-015-01-01-04"), rotationAlternatingHitsChest.getSymbol());
		rotationAlternatingHitsChest.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-015-01-01-01"), rotationAlternatingHitsChest.getSymbol());

		rotationAlternatingHitsChestEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-015-01-02-02"),
				rotationAlternatingHitsChestEmptyArrowhead.getSymbol());
		rotationAlternatingHitsChestEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-015-01-02-03"),
				rotationAlternatingHitsChestEmptyArrowhead.getSymbol());
		rotationAlternatingHitsChestEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-015-01-02-04"),
				rotationAlternatingHitsChestEmptyArrowhead.getSymbol());
		rotationAlternatingHitsChestEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-015-01-02-01"),
				rotationAlternatingHitsChestEmptyArrowhead.getSymbol());

		rotationAlternatingHitsChestSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-015-01-03-02"),
				rotationAlternatingHitsChestSchemaArrowhead.getSymbol());
		rotationAlternatingHitsChestSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-015-01-03-03"),
				rotationAlternatingHitsChestSchemaArrowhead.getSymbol());
		rotationAlternatingHitsChestSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-015-01-03-04"),
				rotationAlternatingHitsChestSchemaArrowhead.getSymbol());
		rotationAlternatingHitsChestSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-015-01-03-01"),
				rotationAlternatingHitsChestSchemaArrowhead.getSymbol());

		waveDiagonalPathSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-01-01-02"), waveDiagonalPathSmall.getSymbol());
		waveDiagonalPathSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-01-01-04"), waveDiagonalPathSmall.getSymbol());
		waveDiagonalPathSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-01-01-05"), waveDiagonalPathSmall.getSymbol());
		waveDiagonalPathSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-01-01-06"), waveDiagonalPathSmall.getSymbol());
		waveDiagonalPathSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-01-01-08"), waveDiagonalPathSmall.getSymbol());
		waveDiagonalPathSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-01-01-01"), waveDiagonalPathSmall.getSymbol());

		waveDiagonalPathSmallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-01-02-02"), waveDiagonalPathSmallEmptyArrowhead.getSymbol());
		waveDiagonalPathSmallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-01-02-04"), waveDiagonalPathSmallEmptyArrowhead.getSymbol());
		waveDiagonalPathSmallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-01-02-05"), waveDiagonalPathSmallEmptyArrowhead.getSymbol());
		waveDiagonalPathSmallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-01-02-06"), waveDiagonalPathSmallEmptyArrowhead.getSymbol());
		waveDiagonalPathSmallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-01-02-08"), waveDiagonalPathSmallEmptyArrowhead.getSymbol());
		waveDiagonalPathSmallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-01-02-01"), waveDiagonalPathSmallEmptyArrowhead.getSymbol());

		waveDiagonalPathSmallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-01-03-02"),
				waveDiagonalPathSmallSchemaArrowhead.getSymbol());
		waveDiagonalPathSmallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-01-03-04"),
				waveDiagonalPathSmallSchemaArrowhead.getSymbol());
		waveDiagonalPathSmallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-01-03-05"),
				waveDiagonalPathSmallSchemaArrowhead.getSymbol());
		waveDiagonalPathSmallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-01-03-06"),
				waveDiagonalPathSmallSchemaArrowhead.getSymbol());
		waveDiagonalPathSmallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-01-03-08"),
				waveDiagonalPathSmallSchemaArrowhead.getSymbol());
		waveDiagonalPathSmallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-01-03-01"),
				waveDiagonalPathSmallSchemaArrowhead.getSymbol());

		waveDiagonalPathSmallMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-01-01-16"), waveDiagonalPathSmallMirrored.getSymbol());
		waveDiagonalPathSmallMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-01-01-14"), waveDiagonalPathSmallMirrored.getSymbol());
		waveDiagonalPathSmallMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-01-01-13"), waveDiagonalPathSmallMirrored.getSymbol());
		waveDiagonalPathSmallMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-01-01-12"), waveDiagonalPathSmallMirrored.getSymbol());
		waveDiagonalPathSmallMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-01-01-10"), waveDiagonalPathSmallMirrored.getSymbol());
		waveDiagonalPathSmallMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-01-01-09"), waveDiagonalPathSmallMirrored.getSymbol());

		waveDiagonalPathSmallEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-01-02-16"),
				waveDiagonalPathSmallEmptyArrowheadMirrored.getSymbol());
		waveDiagonalPathSmallEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-01-02-14"),
				waveDiagonalPathSmallEmptyArrowheadMirrored.getSymbol());
		waveDiagonalPathSmallEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-01-02-13"),
				waveDiagonalPathSmallEmptyArrowheadMirrored.getSymbol());
		waveDiagonalPathSmallEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-01-02-12"),
				waveDiagonalPathSmallEmptyArrowheadMirrored.getSymbol());
		waveDiagonalPathSmallEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-01-02-10"),
				waveDiagonalPathSmallEmptyArrowheadMirrored.getSymbol());
		waveDiagonalPathSmallEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-01-02-09"),
				waveDiagonalPathSmallEmptyArrowheadMirrored.getSymbol());

		waveDiagonalPathSmallSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-01-03-16"),
				waveDiagonalPathSmallSchemaArrowheadMirrored.getSymbol());
		waveDiagonalPathSmallSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-01-03-14"),
				waveDiagonalPathSmallSchemaArrowheadMirrored.getSymbol());
		waveDiagonalPathSmallSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-01-03-13"),
				waveDiagonalPathSmallSchemaArrowheadMirrored.getSymbol());
		waveDiagonalPathSmallSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-01-03-12"),
				waveDiagonalPathSmallSchemaArrowheadMirrored.getSymbol());
		waveDiagonalPathSmallSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-01-03-10"),
				waveDiagonalPathSmallSchemaArrowheadMirrored.getSymbol());
		waveDiagonalPathSmallSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-01-03-09"),
				waveDiagonalPathSmallSchemaArrowheadMirrored.getSymbol());

		waveDiagonalPathMedium.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-02-01-02"), waveDiagonalPathMedium.getSymbol());
		waveDiagonalPathMedium.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-02-01-04"), waveDiagonalPathMedium.getSymbol());
		waveDiagonalPathMedium.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-02-01-05"), waveDiagonalPathMedium.getSymbol());
		waveDiagonalPathMedium.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-02-01-06"), waveDiagonalPathMedium.getSymbol());
		waveDiagonalPathMedium.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-02-01-08"), waveDiagonalPathMedium.getSymbol());
		waveDiagonalPathMedium.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-02-01-01"), waveDiagonalPathMedium.getSymbol());

		waveDiagonalPathMediumEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-02-02-02"),
				waveDiagonalPathMediumEmptyArrowhead.getSymbol());
		waveDiagonalPathMediumEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-02-02-04"),
				waveDiagonalPathMediumEmptyArrowhead.getSymbol());
		waveDiagonalPathMediumEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-02-02-05"),
				waveDiagonalPathMediumEmptyArrowhead.getSymbol());
		waveDiagonalPathMediumEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-02-02-06"),
				waveDiagonalPathMediumEmptyArrowhead.getSymbol());
		waveDiagonalPathMediumEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-02-02-08"),
				waveDiagonalPathMediumEmptyArrowhead.getSymbol());
		waveDiagonalPathMediumEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-02-02-01"),
				waveDiagonalPathMediumEmptyArrowhead.getSymbol());

		waveDiagonalPathMediumSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-02-03-02"),
				waveDiagonalPathMediumSchemaArrowhead.getSymbol());
		waveDiagonalPathMediumSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-02-03-04"),
				waveDiagonalPathMediumSchemaArrowhead.getSymbol());
		waveDiagonalPathMediumSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-02-03-05"),
				waveDiagonalPathMediumSchemaArrowhead.getSymbol());
		waveDiagonalPathMediumSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-02-03-06"),
				waveDiagonalPathMediumSchemaArrowhead.getSymbol());
		waveDiagonalPathMediumSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-02-03-08"),
				waveDiagonalPathMediumSchemaArrowhead.getSymbol());
		waveDiagonalPathMediumSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-02-03-01"),
				waveDiagonalPathMediumSchemaArrowhead.getSymbol());

		waveDiagonalPathMediumMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-02-01-16"), waveDiagonalPathMediumMirrored.getSymbol());
		waveDiagonalPathMediumMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-02-01-14"), waveDiagonalPathMediumMirrored.getSymbol());
		waveDiagonalPathMediumMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-02-01-13"), waveDiagonalPathMediumMirrored.getSymbol());
		waveDiagonalPathMediumMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-02-01-12"), waveDiagonalPathMediumMirrored.getSymbol());
		waveDiagonalPathMediumMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-02-01-10"), waveDiagonalPathMediumMirrored.getSymbol());
		waveDiagonalPathMediumMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-02-01-09"), waveDiagonalPathMediumMirrored.getSymbol());

		waveDiagonalPathMediumEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-02-02-16"),
				waveDiagonalPathMediumEmptyArrowheadMirrored.getSymbol());
		waveDiagonalPathMediumEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-02-02-14"),
				waveDiagonalPathMediumEmptyArrowheadMirrored.getSymbol());
		waveDiagonalPathMediumEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-02-02-13"),
				waveDiagonalPathMediumEmptyArrowheadMirrored.getSymbol());
		waveDiagonalPathMediumEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-02-02-12"),
				waveDiagonalPathMediumEmptyArrowheadMirrored.getSymbol());
		waveDiagonalPathMediumEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-02-02-10"),
				waveDiagonalPathMediumEmptyArrowheadMirrored.getSymbol());
		waveDiagonalPathMediumEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-02-02-09"),
				waveDiagonalPathMediumEmptyArrowheadMirrored.getSymbol());

		waveDiagonalPathMediumSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-02-03-16"),
				waveDiagonalPathMediumSchemaArrowheadMirrored.getSymbol());
		waveDiagonalPathMediumSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-02-03-14"),
				waveDiagonalPathMediumSchemaArrowheadMirrored.getSymbol());
		waveDiagonalPathMediumSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-02-03-13"),
				waveDiagonalPathMediumSchemaArrowheadMirrored.getSymbol());
		waveDiagonalPathMediumSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-02-03-12"),
				waveDiagonalPathMediumSchemaArrowheadMirrored.getSymbol());
		waveDiagonalPathMediumSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-02-03-10"),
				waveDiagonalPathMediumSchemaArrowheadMirrored.getSymbol());
		waveDiagonalPathMediumSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-02-03-09"),
				waveDiagonalPathMediumSchemaArrowheadMirrored.getSymbol());

		waveDiagonalPathLarge.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-03-01-02"), waveDiagonalPathLarge.getSymbol());
		waveDiagonalPathLarge.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-03-01-04"), waveDiagonalPathLarge.getSymbol());
		waveDiagonalPathLarge.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-03-01-05"), waveDiagonalPathLarge.getSymbol());
		waveDiagonalPathLarge.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-03-01-06"), waveDiagonalPathLarge.getSymbol());
		waveDiagonalPathLarge.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-03-01-08"), waveDiagonalPathLarge.getSymbol());
		waveDiagonalPathLarge.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-03-01-01"), waveDiagonalPathLarge.getSymbol());

		waveDiagonalPathLargeEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-03-02-02"), waveDiagonalPathLargeEmptyArrowhead.getSymbol());
		waveDiagonalPathLargeEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-03-02-04"), waveDiagonalPathLargeEmptyArrowhead.getSymbol());
		waveDiagonalPathLargeEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-03-02-05"), waveDiagonalPathLargeEmptyArrowhead.getSymbol());
		waveDiagonalPathLargeEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-03-02-06"), waveDiagonalPathLargeEmptyArrowhead.getSymbol());
		waveDiagonalPathLargeEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-03-02-08"), waveDiagonalPathLargeEmptyArrowhead.getSymbol());
		waveDiagonalPathLargeEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-03-02-01"), waveDiagonalPathLargeEmptyArrowhead.getSymbol());

		waveDiagonalPathLargeSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-03-03-02"),
				waveDiagonalPathLargeSchemaArrowhead.getSymbol());
		waveDiagonalPathLargeSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-03-03-04"),
				waveDiagonalPathLargeSchemaArrowhead.getSymbol());
		waveDiagonalPathLargeSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-03-03-05"),
				waveDiagonalPathLargeSchemaArrowhead.getSymbol());
		waveDiagonalPathLargeSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-03-03-06"),
				waveDiagonalPathLargeSchemaArrowhead.getSymbol());
		waveDiagonalPathLargeSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-03-03-08"),
				waveDiagonalPathLargeSchemaArrowhead.getSymbol());
		waveDiagonalPathLargeSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-03-03-01"),
				waveDiagonalPathLargeSchemaArrowhead.getSymbol());

		waveDiagonalPathLargeMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-03-01-16"), waveDiagonalPathLargeMirrored.getSymbol());
		waveDiagonalPathLargeMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-03-01-14"), waveDiagonalPathLargeMirrored.getSymbol());
		waveDiagonalPathLargeMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-03-01-13"), waveDiagonalPathLargeMirrored.getSymbol());
		waveDiagonalPathLargeMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-03-01-12"), waveDiagonalPathLargeMirrored.getSymbol());
		waveDiagonalPathLargeMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-03-01-10"), waveDiagonalPathLargeMirrored.getSymbol());
		waveDiagonalPathLargeMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-03-01-09"), waveDiagonalPathLargeMirrored.getSymbol());

		waveDiagonalPathLargeEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-03-02-16"),
				waveDiagonalPathLargeEmptyArrowheadMirrored.getSymbol());
		waveDiagonalPathLargeEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-03-02-14"),
				waveDiagonalPathLargeEmptyArrowheadMirrored.getSymbol());
		waveDiagonalPathLargeEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-03-02-13"),
				waveDiagonalPathLargeEmptyArrowheadMirrored.getSymbol());
		waveDiagonalPathLargeEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-03-02-12"),
				waveDiagonalPathLargeEmptyArrowheadMirrored.getSymbol());
		waveDiagonalPathLargeEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-03-02-10"),
				waveDiagonalPathLargeEmptyArrowheadMirrored.getSymbol());
		waveDiagonalPathLargeEmptyArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-03-02-09"),
				waveDiagonalPathLargeEmptyArrowheadMirrored.getSymbol());

		waveDiagonalPathLargeSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-03-03-16"),
				waveDiagonalPathLargeSchemaArrowheadMirrored.getSymbol());
		waveDiagonalPathLargeSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-03-03-14"),
				waveDiagonalPathLargeSchemaArrowheadMirrored.getSymbol());
		waveDiagonalPathLargeSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-03-03-13"),
				waveDiagonalPathLargeSchemaArrowheadMirrored.getSymbol());
		waveDiagonalPathLargeSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-03-03-12"),
				waveDiagonalPathLargeSchemaArrowheadMirrored.getSymbol());
		waveDiagonalPathLargeSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-03-03-10"),
				waveDiagonalPathLargeSchemaArrowheadMirrored.getSymbol());
		waveDiagonalPathLargeSchemaArrowheadMirrored.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-07-016-03-03-09"),
				waveDiagonalPathLargeSchemaArrowheadMirrored.getSymbol());

	}

	@Override
	public void testCanMirror() {

		assertTrue(curveHitsFrontWall.canMirror());
		assertTrue(curveHitsFrontWallEmptyArrowhead.canMirror());
		assertTrue(curveHitsFrontWallSchemaArrowhead.canMirror());

		assertTrue(humpHitsFrontWall.canMirror());
		assertTrue(humpHitsFrontWallEmptyArrowhead.canMirror());
		assertTrue(humpHitsFrontWallSchemaArrowhead.canMirror());

		assertTrue(loopHitsFrontWall.canMirror());
		assertTrue(loopHitsFrontWallEmptyArrowhead.canMirror());
		assertTrue(loopHitsFrontWallSchemaArrowhead.canMirror());

		assertTrue(waveHitsFrontWall.canMirror());
		assertTrue(waveHitsFrontWallEmptyArrowhead.canMirror());
		assertTrue(waveHitsFrontWallSchemaArrowhead.canMirror());

		assertTrue(rotationSingleHitsFrontWall.canMirror());
		assertTrue(rotationSingleHitsFrontWallEmptyArrowhead.canMirror());
		assertTrue(rotationSingleHitsFrontWallSchemaArrowhead.canMirror());

		assertTrue(rotationDoubleHitsFrontWall.canMirror());
		assertTrue(rotationDoubleHitsFrontWallEmptyArrowhead.canMirror());
		assertTrue(rotationDoubleHitsFrontWallSchemaArrowhead.canMirror());

		assertTrue(rotationAlternatingHitsFrontWall.canMirror());
		assertTrue(rotationAlternatingHitsFrontWallEmptyArrowhead.canMirror());
		assertTrue(rotationAlternatingHitsFrontWallSchemaArrowhead.canMirror());

		assertTrue(curveHitsChest.canMirror());
		assertTrue(curveHitsChestEmptyArrowhead.canMirror());
		assertTrue(curveHitsChestSchemaArrowhead.canMirror());

		assertTrue(humpHitsChest.canMirror());
		assertTrue(humpHitsChestEmptyArrowhead.canMirror());
		assertTrue(humpHitsChestSchemaArrowhead.canMirror());

		assertTrue(loopHitsChest.canMirror());
		assertTrue(loopHitsChestEmptyArrowhead.canMirror());
		assertTrue(loopHitsChestSchemaArrowhead.canMirror());

		assertTrue(waveHitsChest.canMirror());
		assertTrue(waveHitsChestEmptyArrowhead.canMirror());
		assertTrue(waveHitsChestSchemaArrowhead.canMirror());

		assertTrue(rotationSingleHitsChest.canMirror());
		assertTrue(rotationSingleHitsChestEmptyArrowhead.canMirror());
		assertTrue(rotationSingleHitsChestSchemaArrowhead.canMirror());

		assertTrue(rotationDoubleHitsChest.canMirror());
		assertTrue(rotationDoubleHitsChestEmptyArrowhead.canMirror());
		assertTrue(rotationDoubleHitsChestSchemaArrowhead.canMirror());

		assertTrue(rotationAlternatingHitsChest.canMirror());
		assertTrue(rotationAlternatingHitsChestEmptyArrowhead.canMirror());
		assertTrue(rotationAlternatingHitsChestSchemaArrowhead.canMirror());

		assertTrue(waveDiagonalPathSmall.canMirror());
		assertTrue(waveDiagonalPathSmallEmptyArrowhead.canMirror());
		assertTrue(waveDiagonalPathSmallSchemaArrowhead.canMirror());
		assertTrue(waveDiagonalPathSmallMirrored.canMirror());
		assertTrue(waveDiagonalPathSmallEmptyArrowheadMirrored.canMirror());
		assertTrue(waveDiagonalPathSmallSchemaArrowheadMirrored.canMirror());

		assertTrue(waveDiagonalPathMedium.canMirror());
		assertTrue(waveDiagonalPathMediumEmptyArrowhead.canMirror());
		assertTrue(waveDiagonalPathMediumSchemaArrowhead.canMirror());
		assertTrue(waveDiagonalPathMediumMirrored.canMirror());
		assertTrue(waveDiagonalPathMediumEmptyArrowheadMirrored.canMirror());
		assertTrue(waveDiagonalPathMediumSchemaArrowheadMirrored.canMirror());

		assertTrue(waveDiagonalPathLarge.canMirror());
		assertTrue(waveDiagonalPathLargeEmptyArrowhead.canMirror());
		assertTrue(waveDiagonalPathLargeSchemaArrowhead.canMirror());
		assertTrue(waveDiagonalPathLargeMirrored.canMirror());
		assertTrue(waveDiagonalPathLargeEmptyArrowheadMirrored.canMirror());
		assertTrue(waveDiagonalPathLargeSchemaArrowheadMirrored.canMirror());

	}

	@Override
	public void testMirror() {

		curveHitsFrontWall.mirror();
		assertEquals(symbolFactory.createSymbol("02-07-001-01-01-02"), curveHitsFrontWall.getSymbol());
		curveHitsFrontWall.mirror();
		assertEquals(symbolFactory.createSymbol("02-07-001-01-01-01"), curveHitsFrontWall.getSymbol());

		curveHitsFrontWallEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-07-001-01-02-02"), curveHitsFrontWallEmptyArrowhead.getSymbol());
		curveHitsFrontWallEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-07-001-01-02-01"), curveHitsFrontWallEmptyArrowhead.getSymbol());

		curveHitsFrontWallSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-07-001-01-03-02"), curveHitsFrontWallSchemaArrowhead.getSymbol());
		curveHitsFrontWallSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-07-001-01-03-01"), curveHitsFrontWallSchemaArrowhead.getSymbol());

		humpHitsFrontWall.mirror();
		assertEquals(symbolFactory.createSymbol("02-07-002-01-01-02"), humpHitsFrontWall.getSymbol());
		humpHitsFrontWall.mirror();
		assertEquals(symbolFactory.createSymbol("02-07-002-01-01-01"), humpHitsFrontWall.getSymbol());

		humpHitsFrontWallEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-07-002-01-02-02"), humpHitsFrontWallEmptyArrowhead.getSymbol());
		humpHitsFrontWallEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-07-002-01-02-01"), humpHitsFrontWallEmptyArrowhead.getSymbol());

		humpHitsFrontWallSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-07-002-01-03-02"), humpHitsFrontWallSchemaArrowhead.getSymbol());
		humpHitsFrontWallSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-07-002-01-03-01"), humpHitsFrontWallSchemaArrowhead.getSymbol());

		loopHitsFrontWall.mirror();
		assertEquals(symbolFactory.createSymbol("02-07-003-01-01-02"), loopHitsFrontWall.getSymbol());
		loopHitsFrontWall.mirror();
		assertEquals(symbolFactory.createSymbol("02-07-003-01-01-01"), loopHitsFrontWall.getSymbol());

		loopHitsFrontWallEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-07-003-01-02-02"), loopHitsFrontWallEmptyArrowhead.getSymbol());
		loopHitsFrontWallEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-07-003-01-02-01"), loopHitsFrontWallEmptyArrowhead.getSymbol());

		loopHitsFrontWallSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-07-003-01-03-02"), loopHitsFrontWallSchemaArrowhead.getSymbol());
		loopHitsFrontWallSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-07-003-01-03-01"), loopHitsFrontWallSchemaArrowhead.getSymbol());

		waveHitsFrontWall.mirror();
		assertEquals(symbolFactory.createSymbol("02-07-004-01-01-02"), waveHitsFrontWall.getSymbol());
		waveHitsFrontWall.mirror();
		assertEquals(symbolFactory.createSymbol("02-07-004-01-01-01"), waveHitsFrontWall.getSymbol());

		waveHitsFrontWallEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-07-004-01-02-02"), waveHitsFrontWallEmptyArrowhead.getSymbol());
		waveHitsFrontWallEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-07-004-01-02-01"), waveHitsFrontWallEmptyArrowhead.getSymbol());

		waveHitsFrontWallSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-07-004-01-03-02"), waveHitsFrontWallSchemaArrowhead.getSymbol());
		waveHitsFrontWallSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-07-004-01-03-01"), waveHitsFrontWallSchemaArrowhead.getSymbol());

		rotationSingleHitsFrontWall.mirror();
		assertEquals(symbolFactory.createSymbol("02-07-005-01-01-02"), rotationSingleHitsFrontWall.getSymbol());
		rotationSingleHitsFrontWall.mirror();
		assertEquals(symbolFactory.createSymbol("02-07-005-01-01-01"), rotationSingleHitsFrontWall.getSymbol());

		rotationSingleHitsFrontWallEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-07-005-01-02-02"),
				rotationSingleHitsFrontWallEmptyArrowhead.getSymbol());
		rotationSingleHitsFrontWallEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-07-005-01-02-01"),
				rotationSingleHitsFrontWallEmptyArrowhead.getSymbol());

		rotationSingleHitsFrontWallSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-07-005-01-03-02"),
				rotationSingleHitsFrontWallSchemaArrowhead.getSymbol());
		rotationSingleHitsFrontWallSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-07-005-01-03-01"),
				rotationSingleHitsFrontWallSchemaArrowhead.getSymbol());

		rotationDoubleHitsFrontWall.mirror();
		assertEquals(symbolFactory.createSymbol("02-07-006-01-01-02"), rotationDoubleHitsFrontWall.getSymbol());
		rotationDoubleHitsFrontWall.mirror();
		assertEquals(symbolFactory.createSymbol("02-07-006-01-01-01"), rotationDoubleHitsFrontWall.getSymbol());

		rotationDoubleHitsFrontWallEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-07-006-01-02-02"),
				rotationDoubleHitsFrontWallEmptyArrowhead.getSymbol());
		rotationDoubleHitsFrontWallEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-07-006-01-02-01"),
				rotationDoubleHitsFrontWallEmptyArrowhead.getSymbol());

		rotationDoubleHitsFrontWallSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-07-006-01-03-02"),
				rotationDoubleHitsFrontWallSchemaArrowhead.getSymbol());
		rotationDoubleHitsFrontWallSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-07-006-01-03-01"),
				rotationDoubleHitsFrontWallSchemaArrowhead.getSymbol());

		rotationAlternatingHitsFrontWall.mirror();
		assertEquals(symbolFactory.createSymbol("02-07-007-01-01-02"), rotationAlternatingHitsFrontWall.getSymbol());
		rotationAlternatingHitsFrontWall.mirror();
		assertEquals(symbolFactory.createSymbol("02-07-007-01-01-01"), rotationAlternatingHitsFrontWall.getSymbol());

		rotationAlternatingHitsFrontWallEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-07-007-01-02-02"),
				rotationAlternatingHitsFrontWallEmptyArrowhead.getSymbol());
		rotationAlternatingHitsFrontWallEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-07-007-01-02-01"),
				rotationAlternatingHitsFrontWallEmptyArrowhead.getSymbol());

		rotationAlternatingHitsFrontWallSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-07-007-01-03-02"),
				rotationAlternatingHitsFrontWallSchemaArrowhead.getSymbol());
		rotationAlternatingHitsFrontWallSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-07-007-01-03-01"),
				rotationAlternatingHitsFrontWallSchemaArrowhead.getSymbol());

		curveHitsChest.mirror();
		assertEquals(symbolFactory.createSymbol("02-07-009-01-01-02"), curveHitsChest.getSymbol());
		curveHitsChest.mirror();
		assertEquals(symbolFactory.createSymbol("02-07-009-01-01-01"), curveHitsChest.getSymbol());

		curveHitsChestEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-07-009-01-02-02"), curveHitsChestEmptyArrowhead.getSymbol());
		curveHitsChestEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-07-009-01-02-01"), curveHitsChestEmptyArrowhead.getSymbol());

		curveHitsChestSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-07-009-01-03-02"), curveHitsChestSchemaArrowhead.getSymbol());
		curveHitsChestSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-07-009-01-03-01"), curveHitsChestSchemaArrowhead.getSymbol());

		humpHitsChest.mirror();
		assertEquals(symbolFactory.createSymbol("02-07-010-01-01-02"), humpHitsChest.getSymbol());
		humpHitsChest.mirror();
		assertEquals(symbolFactory.createSymbol("02-07-010-01-01-01"), humpHitsChest.getSymbol());

		humpHitsChestEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-07-010-01-02-02"), humpHitsChestEmptyArrowhead.getSymbol());
		humpHitsChestEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-07-010-01-02-01"), humpHitsChestEmptyArrowhead.getSymbol());

		humpHitsChestSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-07-010-01-03-02"), humpHitsChestSchemaArrowhead.getSymbol());
		humpHitsChestSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-07-010-01-03-01"), humpHitsChestSchemaArrowhead.getSymbol());

		loopHitsChest.mirror();
		assertEquals(symbolFactory.createSymbol("02-07-011-01-01-02"), loopHitsChest.getSymbol());
		loopHitsChest.mirror();
		assertEquals(symbolFactory.createSymbol("02-07-011-01-01-01"), loopHitsChest.getSymbol());

		loopHitsChestEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-07-011-01-02-02"), loopHitsChestEmptyArrowhead.getSymbol());
		loopHitsChestEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-07-011-01-02-01"), loopHitsChestEmptyArrowhead.getSymbol());

		loopHitsChestSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-07-011-01-03-02"), loopHitsChestSchemaArrowhead.getSymbol());
		loopHitsChestSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-07-011-01-03-01"), loopHitsChestSchemaArrowhead.getSymbol());

		waveHitsChest.mirror();
		assertEquals(symbolFactory.createSymbol("02-07-012-01-01-02"), waveHitsChest.getSymbol());
		waveHitsChest.mirror();
		assertEquals(symbolFactory.createSymbol("02-07-012-01-01-01"), waveHitsChest.getSymbol());

		waveHitsChestEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-07-012-01-02-02"), waveHitsChestEmptyArrowhead.getSymbol());
		waveHitsChestEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-07-012-01-02-01"), waveHitsChestEmptyArrowhead.getSymbol());

		waveHitsChestSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-07-012-01-03-02"), waveHitsChestSchemaArrowhead.getSymbol());
		waveHitsChestSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-07-012-01-03-01"), waveHitsChestSchemaArrowhead.getSymbol());

		rotationSingleHitsChest.mirror();
		assertEquals(symbolFactory.createSymbol("02-07-013-01-01-02"), rotationSingleHitsChest.getSymbol());
		rotationSingleHitsChest.mirror();
		assertEquals(symbolFactory.createSymbol("02-07-013-01-01-01"), rotationSingleHitsChest.getSymbol());

		rotationSingleHitsChestEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-07-013-01-02-02"),
				rotationSingleHitsChestEmptyArrowhead.getSymbol());
		rotationSingleHitsChestEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-07-013-01-02-01"),
				rotationSingleHitsChestEmptyArrowhead.getSymbol());

		rotationSingleHitsChestSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-07-013-01-03-02"),
				rotationSingleHitsChestSchemaArrowhead.getSymbol());
		rotationSingleHitsChestSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-07-013-01-03-01"),
				rotationSingleHitsChestSchemaArrowhead.getSymbol());

		rotationDoubleHitsChest.mirror();
		assertEquals(symbolFactory.createSymbol("02-07-014-01-01-02"), rotationDoubleHitsChest.getSymbol());
		rotationDoubleHitsChest.mirror();
		assertEquals(symbolFactory.createSymbol("02-07-014-01-01-01"), rotationDoubleHitsChest.getSymbol());

		rotationDoubleHitsChestEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-07-014-01-02-02"),
				rotationDoubleHitsChestEmptyArrowhead.getSymbol());
		rotationDoubleHitsChestEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-07-014-01-02-01"),
				rotationDoubleHitsChestEmptyArrowhead.getSymbol());

		rotationDoubleHitsChestSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-07-014-01-03-02"),
				rotationDoubleHitsChestSchemaArrowhead.getSymbol());
		rotationDoubleHitsChestSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-07-014-01-03-01"),
				rotationDoubleHitsChestSchemaArrowhead.getSymbol());

		rotationAlternatingHitsChest.mirror();
		assertEquals(symbolFactory.createSymbol("02-07-015-01-01-02"), rotationAlternatingHitsChest.getSymbol());
		rotationAlternatingHitsChest.mirror();
		assertEquals(symbolFactory.createSymbol("02-07-015-01-01-01"), rotationAlternatingHitsChest.getSymbol());

		rotationAlternatingHitsChestEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-07-015-01-02-02"),
				rotationAlternatingHitsChestEmptyArrowhead.getSymbol());
		rotationAlternatingHitsChestEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-07-015-01-02-01"),
				rotationAlternatingHitsChestEmptyArrowhead.getSymbol());

		rotationAlternatingHitsChestSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-07-015-01-03-02"),
				rotationAlternatingHitsChestSchemaArrowhead.getSymbol());
		rotationAlternatingHitsChestSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-07-015-01-03-01"),
				rotationAlternatingHitsChestSchemaArrowhead.getSymbol());

		waveDiagonalPathSmall.mirror();
		assertEquals(symbolFactory.createSymbol("02-07-016-01-01-09"), waveDiagonalPathSmall.getSymbol());
		waveDiagonalPathSmall.mirror();
		assertEquals(symbolFactory.createSymbol("02-07-016-01-01-01"), waveDiagonalPathSmall.getSymbol());

		waveDiagonalPathSmallEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-07-016-01-02-09"), waveDiagonalPathSmallEmptyArrowhead.getSymbol());
		waveDiagonalPathSmallEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-07-016-01-02-01"), waveDiagonalPathSmallEmptyArrowhead.getSymbol());

		waveDiagonalPathSmallSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-07-016-01-03-09"),
				waveDiagonalPathSmallSchemaArrowhead.getSymbol());
		waveDiagonalPathSmallSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-07-016-01-03-01"),
				waveDiagonalPathSmallSchemaArrowhead.getSymbol());

		waveDiagonalPathSmallMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-07-016-01-01-01"), waveDiagonalPathSmallMirrored.getSymbol());
		waveDiagonalPathSmallMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-07-016-01-01-09"), waveDiagonalPathSmallMirrored.getSymbol());

		waveDiagonalPathSmallEmptyArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-07-016-01-02-01"),
				waveDiagonalPathSmallEmptyArrowheadMirrored.getSymbol());
		waveDiagonalPathSmallEmptyArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-07-016-01-02-09"),
				waveDiagonalPathSmallEmptyArrowheadMirrored.getSymbol());

		waveDiagonalPathSmallSchemaArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-07-016-01-03-01"),
				waveDiagonalPathSmallSchemaArrowheadMirrored.getSymbol());
		waveDiagonalPathSmallSchemaArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-07-016-01-03-09"),
				waveDiagonalPathSmallSchemaArrowheadMirrored.getSymbol());

		waveDiagonalPathMedium.mirror();
		assertEquals(symbolFactory.createSymbol("02-07-016-02-01-09"), waveDiagonalPathMedium.getSymbol());
		waveDiagonalPathMedium.mirror();
		assertEquals(symbolFactory.createSymbol("02-07-016-02-01-01"), waveDiagonalPathMedium.getSymbol());

		waveDiagonalPathMediumEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-07-016-02-02-09"),
				waveDiagonalPathMediumEmptyArrowhead.getSymbol());
		waveDiagonalPathMediumEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-07-016-02-02-01"),
				waveDiagonalPathMediumEmptyArrowhead.getSymbol());

		waveDiagonalPathMediumSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-07-016-02-03-09"),
				waveDiagonalPathMediumSchemaArrowhead.getSymbol());
		waveDiagonalPathMediumSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-07-016-02-03-01"),
				waveDiagonalPathMediumSchemaArrowhead.getSymbol());

		waveDiagonalPathMediumMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-07-016-02-01-01"), waveDiagonalPathMediumMirrored.getSymbol());
		waveDiagonalPathMediumMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-07-016-02-01-09"), waveDiagonalPathMediumMirrored.getSymbol());

		waveDiagonalPathMediumEmptyArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-07-016-02-02-01"),
				waveDiagonalPathMediumEmptyArrowheadMirrored.getSymbol());
		waveDiagonalPathMediumEmptyArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-07-016-02-02-09"),
				waveDiagonalPathMediumEmptyArrowheadMirrored.getSymbol());

		waveDiagonalPathMediumSchemaArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-07-016-02-03-01"),
				waveDiagonalPathMediumSchemaArrowheadMirrored.getSymbol());
		waveDiagonalPathMediumSchemaArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-07-016-02-03-09"),
				waveDiagonalPathMediumSchemaArrowheadMirrored.getSymbol());

		waveDiagonalPathLarge.mirror();
		assertEquals(symbolFactory.createSymbol("02-07-016-03-01-09"), waveDiagonalPathLarge.getSymbol());
		waveDiagonalPathLarge.mirror();
		assertEquals(symbolFactory.createSymbol("02-07-016-03-01-01"), waveDiagonalPathLarge.getSymbol());

		waveDiagonalPathLargeEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-07-016-03-02-09"), waveDiagonalPathLargeEmptyArrowhead.getSymbol());
		waveDiagonalPathLargeEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-07-016-03-02-01"), waveDiagonalPathLargeEmptyArrowhead.getSymbol());

		waveDiagonalPathLargeSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-07-016-03-03-09"),
				waveDiagonalPathLargeSchemaArrowhead.getSymbol());
		waveDiagonalPathLargeSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-07-016-03-03-01"),
				waveDiagonalPathLargeSchemaArrowhead.getSymbol());

		waveDiagonalPathLargeMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-07-016-03-01-01"), waveDiagonalPathLargeMirrored.getSymbol());
		waveDiagonalPathLargeMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-07-016-03-01-09"), waveDiagonalPathLargeMirrored.getSymbol());

		waveDiagonalPathLargeEmptyArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-07-016-03-02-01"),
				waveDiagonalPathLargeEmptyArrowheadMirrored.getSymbol());
		waveDiagonalPathLargeEmptyArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-07-016-03-02-09"),
				waveDiagonalPathLargeEmptyArrowheadMirrored.getSymbol());

		waveDiagonalPathLargeSchemaArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-07-016-03-03-01"),
				waveDiagonalPathLargeSchemaArrowheadMirrored.getSymbol());
		waveDiagonalPathLargeSchemaArrowheadMirrored.mirror();
		assertEquals(symbolFactory.createSymbol("02-07-016-03-03-09"),
				waveDiagonalPathLargeSchemaArrowheadMirrored.getSymbol());

	}

	@Override
	public void testCanMirrorVertically() {
		assertTrue(curveHitsFrontWall.canMirrorVertically());
		assertTrue(curveHitsFrontWallEmptyArrowhead.canMirrorVertically());
		assertTrue(curveHitsFrontWallSchemaArrowhead.canMirrorVertically());

		assertTrue(humpHitsFrontWall.canMirrorVertically());
		assertTrue(humpHitsFrontWallEmptyArrowhead.canMirrorVertically());
		assertTrue(humpHitsFrontWallSchemaArrowhead.canMirrorVertically());

		assertTrue(loopHitsFrontWall.canMirrorVertically());
		assertTrue(loopHitsFrontWallEmptyArrowhead.canMirrorVertically());
		assertTrue(loopHitsFrontWallSchemaArrowhead.canMirrorVertically());

		assertTrue(waveHitsFrontWall.canMirrorVertically());
		assertTrue(waveHitsFrontWallEmptyArrowhead.canMirrorVertically());
		assertTrue(waveHitsFrontWallSchemaArrowhead.canMirrorVertically());

		assertTrue(rotationSingleHitsFrontWall.canMirrorVertically());
		assertTrue(rotationSingleHitsFrontWallEmptyArrowhead.canMirrorVertically());
		assertTrue(rotationSingleHitsFrontWallSchemaArrowhead.canMirrorVertically());

		assertTrue(rotationDoubleHitsFrontWall.canMirrorVertically());
		assertTrue(rotationDoubleHitsFrontWallEmptyArrowhead.canMirrorVertically());
		assertTrue(rotationDoubleHitsFrontWallSchemaArrowhead.canMirrorVertically());

		assertTrue(rotationAlternatingHitsFrontWall.canMirrorVertically());
		assertTrue(rotationAlternatingHitsFrontWallEmptyArrowhead.canMirrorVertically());
		assertTrue(rotationAlternatingHitsFrontWallSchemaArrowhead.canMirrorVertically());

		assertTrue(curveHitsChest.canMirrorVertically());
		assertTrue(curveHitsChestEmptyArrowhead.canMirrorVertically());
		assertTrue(curveHitsChestSchemaArrowhead.canMirrorVertically());

		assertTrue(humpHitsChest.canMirrorVertically());
		assertTrue(humpHitsChestEmptyArrowhead.canMirrorVertically());
		assertTrue(humpHitsChestSchemaArrowhead.canMirrorVertically());

		assertTrue(loopHitsChest.canMirrorVertically());
		assertTrue(loopHitsChestEmptyArrowhead.canMirrorVertically());
		assertTrue(loopHitsChestSchemaArrowhead.canMirrorVertically());

		assertTrue(waveHitsChest.canMirrorVertically());
		assertTrue(waveHitsChestEmptyArrowhead.canMirrorVertically());
		assertTrue(waveHitsChestSchemaArrowhead.canMirrorVertically());

		assertTrue(rotationSingleHitsChest.canMirrorVertically());
		assertTrue(rotationSingleHitsChestEmptyArrowhead.canMirrorVertically());
		assertTrue(rotationSingleHitsChestSchemaArrowhead.canMirrorVertically());

		assertTrue(rotationDoubleHitsChest.canMirrorVertically());
		assertTrue(rotationDoubleHitsChestEmptyArrowhead.canMirrorVertically());
		assertTrue(rotationDoubleHitsChestSchemaArrowhead.canMirrorVertically());

		assertTrue(rotationAlternatingHitsChest.canMirrorVertically());
		assertTrue(rotationAlternatingHitsChestEmptyArrowhead.canMirrorVertically());
		assertTrue(rotationAlternatingHitsChestSchemaArrowhead.canMirrorVertically());

		assertTrue(waveDiagonalPathSmall.canMirrorVertically());
		assertTrue(waveDiagonalPathSmallEmptyArrowhead.canMirrorVertically());
		assertTrue(waveDiagonalPathSmallSchemaArrowhead.canMirrorVertically());
		assertTrue(waveDiagonalPathSmallMirrored.canMirrorVertically());
		assertTrue(waveDiagonalPathSmallEmptyArrowheadMirrored.canMirrorVertically());
		assertTrue(waveDiagonalPathSmallSchemaArrowheadMirrored.canMirrorVertically());

		assertTrue(waveDiagonalPathMedium.canMirrorVertically());
		assertTrue(waveDiagonalPathMediumEmptyArrowhead.canMirrorVertically());
		assertTrue(waveDiagonalPathMediumSchemaArrowhead.canMirrorVertically());
		assertTrue(waveDiagonalPathMediumMirrored.canMirrorVertically());
		assertTrue(waveDiagonalPathMediumEmptyArrowheadMirrored.canMirrorVertically());
		assertTrue(waveDiagonalPathMediumSchemaArrowheadMirrored.canMirrorVertically());

		assertTrue(waveDiagonalPathLarge.canMirrorVertically());
		assertTrue(waveDiagonalPathLargeEmptyArrowhead.canMirrorVertically());
		assertTrue(waveDiagonalPathLargeSchemaArrowhead.canMirrorVertically());
		assertTrue(waveDiagonalPathLargeMirrored.canMirrorVertically());
		assertTrue(waveDiagonalPathLargeEmptyArrowheadMirrored.canMirrorVertically());
		assertTrue(waveDiagonalPathLargeSchemaArrowheadMirrored.canMirrorVertically());

	}

	@Override
	public void testMirrorVertically() {

		curveHitsFrontWall.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-07-001-01-01-03"), curveHitsFrontWall.getSymbol());
		curveHitsFrontWall.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-07-001-01-01-01"), curveHitsFrontWall.getSymbol());

		curveHitsFrontWallEmptyArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-07-001-01-02-03"), curveHitsFrontWallEmptyArrowhead.getSymbol());
		curveHitsFrontWallEmptyArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-07-001-01-02-01"), curveHitsFrontWallEmptyArrowhead.getSymbol());

		curveHitsFrontWallSchemaArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-07-001-01-03-03"), curveHitsFrontWallSchemaArrowhead.getSymbol());
		curveHitsFrontWallSchemaArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-07-001-01-03-01"), curveHitsFrontWallSchemaArrowhead.getSymbol());

		humpHitsFrontWall.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-07-002-01-01-03"), humpHitsFrontWall.getSymbol());
		humpHitsFrontWall.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-07-002-01-01-01"), humpHitsFrontWall.getSymbol());

		humpHitsFrontWallEmptyArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-07-002-01-02-03"), humpHitsFrontWallEmptyArrowhead.getSymbol());
		humpHitsFrontWallEmptyArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-07-002-01-02-01"), humpHitsFrontWallEmptyArrowhead.getSymbol());

		humpHitsFrontWallSchemaArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-07-002-01-03-03"), humpHitsFrontWallSchemaArrowhead.getSymbol());
		humpHitsFrontWallSchemaArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-07-002-01-03-01"), humpHitsFrontWallSchemaArrowhead.getSymbol());

		loopHitsFrontWall.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-07-003-01-01-03"), loopHitsFrontWall.getSymbol());
		loopHitsFrontWall.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-07-003-01-01-01"), loopHitsFrontWall.getSymbol());

		loopHitsFrontWallEmptyArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-07-003-01-02-03"), loopHitsFrontWallEmptyArrowhead.getSymbol());
		loopHitsFrontWallEmptyArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-07-003-01-02-01"), loopHitsFrontWallEmptyArrowhead.getSymbol());

		loopHitsFrontWallSchemaArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-07-003-01-03-03"), loopHitsFrontWallSchemaArrowhead.getSymbol());
		loopHitsFrontWallSchemaArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-07-003-01-03-01"), loopHitsFrontWallSchemaArrowhead.getSymbol());

		waveHitsFrontWall.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-07-004-01-01-03"), waveHitsFrontWall.getSymbol());
		waveHitsFrontWall.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-07-004-01-01-01"), waveHitsFrontWall.getSymbol());

		waveHitsFrontWallEmptyArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-07-004-01-02-03"), waveHitsFrontWallEmptyArrowhead.getSymbol());
		waveHitsFrontWallEmptyArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-07-004-01-02-01"), waveHitsFrontWallEmptyArrowhead.getSymbol());

		waveHitsFrontWallSchemaArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-07-004-01-03-03"), waveHitsFrontWallSchemaArrowhead.getSymbol());
		waveHitsFrontWallSchemaArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-07-004-01-03-01"), waveHitsFrontWallSchemaArrowhead.getSymbol());

		rotationSingleHitsFrontWall.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-07-005-01-01-03"), rotationSingleHitsFrontWall.getSymbol());
		rotationSingleHitsFrontWall.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-07-005-01-01-01"), rotationSingleHitsFrontWall.getSymbol());

		rotationSingleHitsFrontWallEmptyArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-07-005-01-02-03"),
				rotationSingleHitsFrontWallEmptyArrowhead.getSymbol());
		rotationSingleHitsFrontWallEmptyArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-07-005-01-02-01"),
				rotationSingleHitsFrontWallEmptyArrowhead.getSymbol());

		rotationSingleHitsFrontWallSchemaArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-07-005-01-03-03"),
				rotationSingleHitsFrontWallSchemaArrowhead.getSymbol());
		rotationSingleHitsFrontWallSchemaArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-07-005-01-03-01"),
				rotationSingleHitsFrontWallSchemaArrowhead.getSymbol());

		rotationDoubleHitsFrontWall.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-07-006-01-01-03"), rotationDoubleHitsFrontWall.getSymbol());
		rotationDoubleHitsFrontWall.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-07-006-01-01-01"), rotationDoubleHitsFrontWall.getSymbol());

		rotationDoubleHitsFrontWallEmptyArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-07-006-01-02-03"),
				rotationDoubleHitsFrontWallEmptyArrowhead.getSymbol());
		rotationDoubleHitsFrontWallEmptyArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-07-006-01-02-01"),
				rotationDoubleHitsFrontWallEmptyArrowhead.getSymbol());

		rotationDoubleHitsFrontWallSchemaArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-07-006-01-03-03"),
				rotationDoubleHitsFrontWallSchemaArrowhead.getSymbol());
		rotationDoubleHitsFrontWallSchemaArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-07-006-01-03-01"),
				rotationDoubleHitsFrontWallSchemaArrowhead.getSymbol());

		rotationAlternatingHitsFrontWall.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-07-007-01-01-03"), rotationAlternatingHitsFrontWall.getSymbol());
		rotationAlternatingHitsFrontWall.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-07-007-01-01-01"), rotationAlternatingHitsFrontWall.getSymbol());

		rotationAlternatingHitsFrontWallEmptyArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-07-007-01-02-03"),
				rotationAlternatingHitsFrontWallEmptyArrowhead.getSymbol());
		rotationAlternatingHitsFrontWallEmptyArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-07-007-01-02-01"),
				rotationAlternatingHitsFrontWallEmptyArrowhead.getSymbol());

		rotationAlternatingHitsFrontWallSchemaArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-07-007-01-03-03"),
				rotationAlternatingHitsFrontWallSchemaArrowhead.getSymbol());
		rotationAlternatingHitsFrontWallSchemaArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-07-007-01-03-01"),
				rotationAlternatingHitsFrontWallSchemaArrowhead.getSymbol());

		curveHitsChest.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-07-009-01-01-03"), curveHitsChest.getSymbol());
		curveHitsChest.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-07-009-01-01-01"), curveHitsChest.getSymbol());

		curveHitsChestEmptyArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-07-009-01-02-03"), curveHitsChestEmptyArrowhead.getSymbol());
		curveHitsChestEmptyArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-07-009-01-02-01"), curveHitsChestEmptyArrowhead.getSymbol());

		curveHitsChestSchemaArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-07-009-01-03-03"), curveHitsChestSchemaArrowhead.getSymbol());
		curveHitsChestSchemaArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-07-009-01-03-01"), curveHitsChestSchemaArrowhead.getSymbol());

		humpHitsChest.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-07-010-01-01-03"), humpHitsChest.getSymbol());
		humpHitsChest.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-07-010-01-01-01"), humpHitsChest.getSymbol());

		humpHitsChestEmptyArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-07-010-01-02-03"), humpHitsChestEmptyArrowhead.getSymbol());
		humpHitsChestEmptyArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-07-010-01-02-01"), humpHitsChestEmptyArrowhead.getSymbol());

		humpHitsChestSchemaArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-07-010-01-03-03"), humpHitsChestSchemaArrowhead.getSymbol());
		humpHitsChestSchemaArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-07-010-01-03-01"), humpHitsChestSchemaArrowhead.getSymbol());

		loopHitsChest.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-07-011-01-01-03"), loopHitsChest.getSymbol());
		loopHitsChest.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-07-011-01-01-01"), loopHitsChest.getSymbol());

		loopHitsChestEmptyArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-07-011-01-02-03"), loopHitsChestEmptyArrowhead.getSymbol());
		loopHitsChestEmptyArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-07-011-01-02-01"), loopHitsChestEmptyArrowhead.getSymbol());

		loopHitsChestSchemaArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-07-011-01-03-03"), loopHitsChestSchemaArrowhead.getSymbol());
		loopHitsChestSchemaArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-07-011-01-03-01"), loopHitsChestSchemaArrowhead.getSymbol());

		waveHitsChest.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-07-012-01-01-04"), waveHitsChest.getSymbol());
		waveHitsChest.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-07-012-01-01-01"), waveHitsChest.getSymbol());

		// Begin Special Case for waveHitsChes
		waveHitsChest.rotateCounterClockwise();
		waveHitsChestEmptyArrowhead.rotateCounterClockwise();
		waveHitsChestSchemaArrowhead.rotateCounterClockwise();

		waveHitsChest.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-07-012-01-01-03"), waveHitsChest.getSymbol());
		waveHitsChest.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-07-012-01-01-02"), waveHitsChest.getSymbol());

		waveHitsChestEmptyArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-07-012-01-02-03"), waveHitsChestEmptyArrowhead.getSymbol());
		waveHitsChestEmptyArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-07-012-01-02-02"), waveHitsChestEmptyArrowhead.getSymbol());

		waveHitsChestSchemaArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-07-012-01-03-03"), waveHitsChestSchemaArrowhead.getSymbol());
		waveHitsChestSchemaArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-07-012-01-03-02"), waveHitsChestSchemaArrowhead.getSymbol());

		waveHitsChest.rotateClockwise();
		waveHitsChestEmptyArrowhead.rotateClockwise();
		waveHitsChestSchemaArrowhead.rotateClockwise();
		// End Special Case

		waveHitsChestEmptyArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-07-012-01-02-04"), waveHitsChestEmptyArrowhead.getSymbol());
		waveHitsChestEmptyArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-07-012-01-02-01"), waveHitsChestEmptyArrowhead.getSymbol());

		waveHitsChestSchemaArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-07-012-01-03-04"), waveHitsChestSchemaArrowhead.getSymbol());
		waveHitsChestSchemaArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-07-012-01-03-01"), waveHitsChestSchemaArrowhead.getSymbol());

		rotationSingleHitsChest.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-07-013-01-01-03"), rotationSingleHitsChest.getSymbol());
		rotationSingleHitsChest.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-07-013-01-01-01"), rotationSingleHitsChest.getSymbol());

		rotationSingleHitsChestEmptyArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-07-013-01-02-03"),
				rotationSingleHitsChestEmptyArrowhead.getSymbol());
		rotationSingleHitsChestEmptyArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-07-013-01-02-01"),
				rotationSingleHitsChestEmptyArrowhead.getSymbol());

		rotationSingleHitsChestSchemaArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-07-013-01-03-03"),
				rotationSingleHitsChestSchemaArrowhead.getSymbol());
		rotationSingleHitsChestSchemaArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-07-013-01-03-01"),
				rotationSingleHitsChestSchemaArrowhead.getSymbol());

		rotationDoubleHitsChest.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-07-014-01-01-03"), rotationDoubleHitsChest.getSymbol());
		rotationDoubleHitsChest.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-07-014-01-01-01"), rotationDoubleHitsChest.getSymbol());

		rotationDoubleHitsChestEmptyArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-07-014-01-02-03"),
				rotationDoubleHitsChestEmptyArrowhead.getSymbol());
		rotationDoubleHitsChestEmptyArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-07-014-01-02-01"),
				rotationDoubleHitsChestEmptyArrowhead.getSymbol());

		rotationDoubleHitsChestSchemaArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-07-014-01-03-03"),
				rotationDoubleHitsChestSchemaArrowhead.getSymbol());
		rotationDoubleHitsChestSchemaArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-07-014-01-03-01"),
				rotationDoubleHitsChestSchemaArrowhead.getSymbol());

		rotationAlternatingHitsChest.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-07-015-01-01-03"), rotationAlternatingHitsChest.getSymbol());
		rotationAlternatingHitsChest.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-07-015-01-01-01"), rotationAlternatingHitsChest.getSymbol());

		rotationAlternatingHitsChestEmptyArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-07-015-01-02-03"),
				rotationAlternatingHitsChestEmptyArrowhead.getSymbol());
		rotationAlternatingHitsChestEmptyArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-07-015-01-02-01"),
				rotationAlternatingHitsChestEmptyArrowhead.getSymbol());

		rotationAlternatingHitsChestSchemaArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-07-015-01-03-03"),
				rotationAlternatingHitsChestSchemaArrowhead.getSymbol());
		rotationAlternatingHitsChestSchemaArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-07-015-01-03-01"),
				rotationAlternatingHitsChestSchemaArrowhead.getSymbol());

		waveDiagonalPathSmall.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-07-016-01-01-13"), waveDiagonalPathSmall.getSymbol());
		waveDiagonalPathSmall.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-07-016-01-01-01"), waveDiagonalPathSmall.getSymbol());

		waveDiagonalPathSmallEmptyArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-07-016-01-02-13"), waveDiagonalPathSmallEmptyArrowhead.getSymbol());
		waveDiagonalPathSmallEmptyArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-07-016-01-02-01"), waveDiagonalPathSmallEmptyArrowhead.getSymbol());

		waveDiagonalPathSmallSchemaArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-07-016-01-03-13"),
				waveDiagonalPathSmallSchemaArrowhead.getSymbol());
		waveDiagonalPathSmallSchemaArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-07-016-01-03-01"),
				waveDiagonalPathSmallSchemaArrowhead.getSymbol());

		waveDiagonalPathSmallMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-07-016-01-01-05"), waveDiagonalPathSmallMirrored.getSymbol());
		waveDiagonalPathSmallMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-07-016-01-01-09"), waveDiagonalPathSmallMirrored.getSymbol());

		waveDiagonalPathSmallEmptyArrowheadMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-07-016-01-02-05"),
				waveDiagonalPathSmallEmptyArrowheadMirrored.getSymbol());
		waveDiagonalPathSmallEmptyArrowheadMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-07-016-01-02-09"),
				waveDiagonalPathSmallEmptyArrowheadMirrored.getSymbol());

		waveDiagonalPathSmallSchemaArrowheadMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-07-016-01-03-05"),
				waveDiagonalPathSmallSchemaArrowheadMirrored.getSymbol());
		waveDiagonalPathSmallSchemaArrowheadMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-07-016-01-03-09"),
				waveDiagonalPathSmallSchemaArrowheadMirrored.getSymbol());

		waveDiagonalPathMedium.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-07-016-02-01-13"), waveDiagonalPathMedium.getSymbol());
		waveDiagonalPathMedium.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-07-016-02-01-01"), waveDiagonalPathMedium.getSymbol());

		waveDiagonalPathMediumEmptyArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-07-016-02-02-13"),
				waveDiagonalPathMediumEmptyArrowhead.getSymbol());
		waveDiagonalPathMediumEmptyArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-07-016-02-02-01"),
				waveDiagonalPathMediumEmptyArrowhead.getSymbol());

		waveDiagonalPathMediumSchemaArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-07-016-02-03-13"),
				waveDiagonalPathMediumSchemaArrowhead.getSymbol());
		waveDiagonalPathMediumSchemaArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-07-016-02-03-01"),
				waveDiagonalPathMediumSchemaArrowhead.getSymbol());

		waveDiagonalPathMediumMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-07-016-02-01-05"), waveDiagonalPathMediumMirrored.getSymbol());
		waveDiagonalPathMediumMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-07-016-02-01-09"), waveDiagonalPathMediumMirrored.getSymbol());

		waveDiagonalPathMediumEmptyArrowheadMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-07-016-02-02-05"),
				waveDiagonalPathMediumEmptyArrowheadMirrored.getSymbol());
		waveDiagonalPathMediumEmptyArrowheadMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-07-016-02-02-09"),
				waveDiagonalPathMediumEmptyArrowheadMirrored.getSymbol());

		waveDiagonalPathMediumSchemaArrowheadMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-07-016-02-03-05"),
				waveDiagonalPathMediumSchemaArrowheadMirrored.getSymbol());
		waveDiagonalPathMediumSchemaArrowheadMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-07-016-02-03-09"),
				waveDiagonalPathMediumSchemaArrowheadMirrored.getSymbol());

		waveDiagonalPathLarge.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-07-016-03-01-13"), waveDiagonalPathLarge.getSymbol());
		waveDiagonalPathLarge.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-07-016-03-01-01"), waveDiagonalPathLarge.getSymbol());

		waveDiagonalPathLargeEmptyArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-07-016-03-02-13"), waveDiagonalPathLargeEmptyArrowhead.getSymbol());
		waveDiagonalPathLargeEmptyArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-07-016-03-02-01"), waveDiagonalPathLargeEmptyArrowhead.getSymbol());

		waveDiagonalPathLargeSchemaArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-07-016-03-03-13"),
				waveDiagonalPathLargeSchemaArrowhead.getSymbol());
		waveDiagonalPathLargeSchemaArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-07-016-03-03-01"),
				waveDiagonalPathLargeSchemaArrowhead.getSymbol());

		waveDiagonalPathLargeMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-07-016-03-01-05"), waveDiagonalPathLargeMirrored.getSymbol());
		waveDiagonalPathLargeMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-07-016-03-01-09"), waveDiagonalPathLargeMirrored.getSymbol());

		waveDiagonalPathLargeEmptyArrowheadMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-07-016-03-02-05"),
				waveDiagonalPathLargeEmptyArrowheadMirrored.getSymbol());
		waveDiagonalPathLargeEmptyArrowheadMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-07-016-03-02-09"),
				waveDiagonalPathLargeEmptyArrowheadMirrored.getSymbol());

		waveDiagonalPathLargeSchemaArrowheadMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-07-016-03-03-05"),
				waveDiagonalPathLargeSchemaArrowheadMirrored.getSymbol());
		waveDiagonalPathLargeSchemaArrowheadMirrored.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-07-016-03-03-09"),
				waveDiagonalPathLargeSchemaArrowheadMirrored.getSymbol());

	}

	@Override
	public void testCanPitch() {

		assertFalse(curveHitsFrontWall.canPitch());
		assertFalse(curveHitsFrontWallEmptyArrowhead.canPitch());
		assertFalse(curveHitsFrontWallSchemaArrowhead.canPitch());

		assertFalse(humpHitsFrontWall.canPitch());
		assertFalse(humpHitsFrontWallEmptyArrowhead.canPitch());
		assertFalse(humpHitsFrontWallSchemaArrowhead.canPitch());

		assertFalse(loopHitsFrontWall.canPitch());
		assertFalse(loopHitsFrontWallEmptyArrowhead.canPitch());
		assertFalse(loopHitsFrontWallSchemaArrowhead.canPitch());

		assertFalse(waveHitsFrontWall.canPitch());
		assertFalse(waveHitsFrontWallEmptyArrowhead.canPitch());
		assertFalse(waveHitsFrontWallSchemaArrowhead.canPitch());

		assertFalse(rotationSingleHitsFrontWall.canPitch());
		assertFalse(rotationSingleHitsFrontWallEmptyArrowhead.canPitch());
		assertFalse(rotationSingleHitsFrontWallSchemaArrowhead.canPitch());

		assertFalse(rotationDoubleHitsFrontWall.canPitch());
		assertFalse(rotationDoubleHitsFrontWallEmptyArrowhead.canPitch());
		assertFalse(rotationDoubleHitsFrontWallSchemaArrowhead.canPitch());

		assertFalse(rotationAlternatingHitsFrontWall.canPitch());
		assertFalse(rotationAlternatingHitsFrontWallEmptyArrowhead.canPitch());
		assertFalse(rotationAlternatingHitsFrontWallSchemaArrowhead.canPitch());

		assertFalse(curveHitsChest.canPitch());
		assertFalse(curveHitsChestEmptyArrowhead.canPitch());
		assertFalse(curveHitsChestSchemaArrowhead.canPitch());

		assertFalse(humpHitsChest.canPitch());
		assertFalse(humpHitsChestEmptyArrowhead.canPitch());
		assertFalse(humpHitsChestSchemaArrowhead.canPitch());

		assertFalse(loopHitsChest.canPitch());
		assertFalse(loopHitsChestEmptyArrowhead.canPitch());
		assertFalse(loopHitsChestSchemaArrowhead.canPitch());

		assertFalse(waveHitsChest.canPitch());
		assertFalse(waveHitsChestEmptyArrowhead.canPitch());
		assertFalse(waveHitsChestSchemaArrowhead.canPitch());

		assertFalse(rotationSingleHitsChest.canPitch());
		assertFalse(rotationSingleHitsChestEmptyArrowhead.canPitch());
		assertFalse(rotationSingleHitsChestSchemaArrowhead.canPitch());

		assertFalse(rotationDoubleHitsChest.canPitch());
		assertFalse(rotationDoubleHitsChestEmptyArrowhead.canPitch());
		assertFalse(rotationDoubleHitsChestSchemaArrowhead.canPitch());

		assertFalse(rotationAlternatingHitsChest.canPitch());
		assertFalse(rotationAlternatingHitsChestEmptyArrowhead.canPitch());
		assertFalse(rotationAlternatingHitsChestSchemaArrowhead.canPitch());

		assertFalse(waveDiagonalPathSmall.canPitch());
		assertFalse(waveDiagonalPathSmallEmptyArrowhead.canPitch());
		assertFalse(waveDiagonalPathSmallSchemaArrowhead.canPitch());
		assertFalse(waveDiagonalPathSmallMirrored.canPitch());
		assertFalse(waveDiagonalPathSmallEmptyArrowheadMirrored.canPitch());
		assertFalse(waveDiagonalPathSmallSchemaArrowheadMirrored.canPitch());

		assertFalse(waveDiagonalPathMedium.canPitch());
		assertFalse(waveDiagonalPathMediumEmptyArrowhead.canPitch());
		assertFalse(waveDiagonalPathMediumSchemaArrowhead.canPitch());
		assertFalse(waveDiagonalPathMediumMirrored.canPitch());
		assertFalse(waveDiagonalPathMediumEmptyArrowheadMirrored.canPitch());
		assertFalse(waveDiagonalPathMediumSchemaArrowheadMirrored.canPitch());

		assertFalse(waveDiagonalPathLarge.canPitch());
		assertFalse(waveDiagonalPathLargeEmptyArrowhead.canPitch());
		assertFalse(waveDiagonalPathLargeSchemaArrowhead.canPitch());
		assertFalse(waveDiagonalPathLargeMirrored.canPitch());
		assertFalse(waveDiagonalPathLargeEmptyArrowheadMirrored.canPitch());
		assertFalse(waveDiagonalPathLargeSchemaArrowheadMirrored.canPitch());

	}

	@Override
	public void testPitch() {

	}

	@Override
	public void testCanRoll() {

		assertFalse(curveHitsFrontWall.canRoll());
		assertFalse(curveHitsFrontWallEmptyArrowhead.canRoll());
		assertFalse(curveHitsFrontWallSchemaArrowhead.canRoll());

		assertFalse(humpHitsFrontWall.canRoll());
		assertFalse(humpHitsFrontWallEmptyArrowhead.canRoll());
		assertFalse(humpHitsFrontWallSchemaArrowhead.canRoll());

		assertFalse(loopHitsFrontWall.canRoll());
		assertFalse(loopHitsFrontWallEmptyArrowhead.canRoll());
		assertFalse(loopHitsFrontWallSchemaArrowhead.canRoll());

		assertFalse(waveHitsFrontWall.canRoll());
		assertFalse(waveHitsFrontWallEmptyArrowhead.canRoll());
		assertFalse(waveHitsFrontWallSchemaArrowhead.canRoll());

		assertFalse(rotationSingleHitsFrontWall.canRoll());
		assertFalse(rotationSingleHitsFrontWallEmptyArrowhead.canRoll());
		assertFalse(rotationSingleHitsFrontWallSchemaArrowhead.canRoll());

		assertFalse(rotationDoubleHitsFrontWall.canRoll());
		assertFalse(rotationDoubleHitsFrontWallEmptyArrowhead.canRoll());
		assertFalse(rotationDoubleHitsFrontWallSchemaArrowhead.canRoll());

		assertFalse(rotationAlternatingHitsFrontWall.canRoll());
		assertFalse(rotationAlternatingHitsFrontWallEmptyArrowhead.canRoll());
		assertFalse(rotationAlternatingHitsFrontWallSchemaArrowhead.canRoll());

		assertFalse(curveHitsChest.canRoll());
		assertFalse(curveHitsChestEmptyArrowhead.canRoll());
		assertFalse(curveHitsChestSchemaArrowhead.canRoll());

		assertFalse(humpHitsChest.canRoll());
		assertFalse(humpHitsChestEmptyArrowhead.canRoll());
		assertFalse(humpHitsChestSchemaArrowhead.canRoll());

		assertFalse(loopHitsChest.canRoll());
		assertFalse(loopHitsChestEmptyArrowhead.canRoll());
		assertFalse(loopHitsChestSchemaArrowhead.canRoll());

		assertFalse(waveHitsChest.canRoll());
		assertFalse(waveHitsChestEmptyArrowhead.canRoll());
		assertFalse(waveHitsChestSchemaArrowhead.canRoll());

		assertFalse(rotationSingleHitsChest.canRoll());
		assertFalse(rotationSingleHitsChestEmptyArrowhead.canRoll());
		assertFalse(rotationSingleHitsChestSchemaArrowhead.canRoll());

		assertFalse(rotationDoubleHitsChest.canRoll());
		assertFalse(rotationDoubleHitsChestEmptyArrowhead.canRoll());
		assertFalse(rotationDoubleHitsChestSchemaArrowhead.canRoll());

		assertFalse(rotationAlternatingHitsChest.canRoll());
		assertFalse(rotationAlternatingHitsChestEmptyArrowhead.canRoll());
		assertFalse(rotationAlternatingHitsChestSchemaArrowhead.canRoll());

		assertFalse(waveDiagonalPathSmall.canRoll());
		assertFalse(waveDiagonalPathSmallEmptyArrowhead.canRoll());
		assertFalse(waveDiagonalPathSmallSchemaArrowhead.canRoll());
		assertFalse(waveDiagonalPathSmallMirrored.canRoll());
		assertFalse(waveDiagonalPathSmallEmptyArrowheadMirrored.canRoll());
		assertFalse(waveDiagonalPathSmallSchemaArrowheadMirrored.canRoll());

		assertFalse(waveDiagonalPathMedium.canRoll());
		assertFalse(waveDiagonalPathMediumEmptyArrowhead.canRoll());
		assertFalse(waveDiagonalPathMediumSchemaArrowhead.canRoll());
		assertFalse(waveDiagonalPathMediumMirrored.canRoll());
		assertFalse(waveDiagonalPathMediumEmptyArrowheadMirrored.canRoll());
		assertFalse(waveDiagonalPathMediumSchemaArrowheadMirrored.canRoll());

		assertFalse(waveDiagonalPathLarge.canRoll());
		assertFalse(waveDiagonalPathLargeEmptyArrowhead.canRoll());
		assertFalse(waveDiagonalPathLargeSchemaArrowhead.canRoll());
		assertFalse(waveDiagonalPathLargeMirrored.canRoll());
		assertFalse(waveDiagonalPathLargeEmptyArrowheadMirrored.canRoll());
		assertFalse(waveDiagonalPathLargeSchemaArrowheadMirrored.canRoll());

	}

	@Override
	public void testRoll() {

	}

	@Override
	public void testCanSwitchArrowHead() {

		assertTrue(curveHitsFrontWall.canSwitchArrowHead());
		assertTrue(curveHitsFrontWallEmptyArrowhead.canSwitchArrowHead());
		assertTrue(curveHitsFrontWallSchemaArrowhead.canSwitchArrowHead());

		assertTrue(humpHitsFrontWall.canSwitchArrowHead());
		assertTrue(humpHitsFrontWallEmptyArrowhead.canSwitchArrowHead());
		assertTrue(humpHitsFrontWallSchemaArrowhead.canSwitchArrowHead());

		assertTrue(loopHitsFrontWall.canSwitchArrowHead());
		assertTrue(loopHitsFrontWallEmptyArrowhead.canSwitchArrowHead());
		assertTrue(loopHitsFrontWallSchemaArrowhead.canSwitchArrowHead());

		assertTrue(waveHitsFrontWall.canSwitchArrowHead());
		assertTrue(waveHitsFrontWallEmptyArrowhead.canSwitchArrowHead());
		assertTrue(waveHitsFrontWallSchemaArrowhead.canSwitchArrowHead());

		assertTrue(rotationSingleHitsFrontWall.canSwitchArrowHead());
		assertTrue(rotationSingleHitsFrontWallEmptyArrowhead.canSwitchArrowHead());
		assertTrue(rotationSingleHitsFrontWallSchemaArrowhead.canSwitchArrowHead());

		assertTrue(rotationDoubleHitsFrontWall.canSwitchArrowHead());
		assertTrue(rotationDoubleHitsFrontWallEmptyArrowhead.canSwitchArrowHead());
		assertTrue(rotationDoubleHitsFrontWallSchemaArrowhead.canSwitchArrowHead());

		assertTrue(rotationAlternatingHitsFrontWall.canSwitchArrowHead());
		assertTrue(rotationAlternatingHitsFrontWallEmptyArrowhead.canSwitchArrowHead());
		assertTrue(rotationAlternatingHitsFrontWallSchemaArrowhead.canSwitchArrowHead());

		assertTrue(curveHitsChest.canSwitchArrowHead());
		assertTrue(curveHitsChestEmptyArrowhead.canSwitchArrowHead());
		assertTrue(curveHitsChestSchemaArrowhead.canSwitchArrowHead());

		assertTrue(humpHitsChest.canSwitchArrowHead());
		assertTrue(humpHitsChestEmptyArrowhead.canSwitchArrowHead());
		assertTrue(humpHitsChestSchemaArrowhead.canSwitchArrowHead());

		assertTrue(loopHitsChest.canSwitchArrowHead());
		assertTrue(loopHitsChestEmptyArrowhead.canSwitchArrowHead());
		assertTrue(loopHitsChestSchemaArrowhead.canSwitchArrowHead());

		assertTrue(waveHitsChest.canSwitchArrowHead());
		assertTrue(waveHitsChestEmptyArrowhead.canSwitchArrowHead());
		assertTrue(waveHitsChestSchemaArrowhead.canSwitchArrowHead());

		assertTrue(rotationSingleHitsChest.canSwitchArrowHead());
		assertTrue(rotationSingleHitsChestEmptyArrowhead.canSwitchArrowHead());
		assertTrue(rotationSingleHitsChestSchemaArrowhead.canSwitchArrowHead());

		assertTrue(rotationDoubleHitsChest.canSwitchArrowHead());
		assertTrue(rotationDoubleHitsChestEmptyArrowhead.canSwitchArrowHead());
		assertTrue(rotationDoubleHitsChestSchemaArrowhead.canSwitchArrowHead());

		assertTrue(rotationAlternatingHitsChest.canSwitchArrowHead());
		assertTrue(rotationAlternatingHitsChestEmptyArrowhead.canSwitchArrowHead());
		assertTrue(rotationAlternatingHitsChestSchemaArrowhead.canSwitchArrowHead());

		assertTrue(waveDiagonalPathSmall.canSwitchArrowHead());
		assertTrue(waveDiagonalPathSmallEmptyArrowhead.canSwitchArrowHead());
		assertTrue(waveDiagonalPathSmallSchemaArrowhead.canSwitchArrowHead());
		assertTrue(waveDiagonalPathSmallMirrored.canSwitchArrowHead());
		assertTrue(waveDiagonalPathSmallEmptyArrowheadMirrored.canSwitchArrowHead());
		assertTrue(waveDiagonalPathSmallSchemaArrowheadMirrored.canSwitchArrowHead());

		assertTrue(waveDiagonalPathMedium.canSwitchArrowHead());
		assertTrue(waveDiagonalPathMediumEmptyArrowhead.canSwitchArrowHead());
		assertTrue(waveDiagonalPathMediumSchemaArrowhead.canSwitchArrowHead());
		assertTrue(waveDiagonalPathMediumMirrored.canSwitchArrowHead());
		assertTrue(waveDiagonalPathMediumEmptyArrowheadMirrored.canSwitchArrowHead());
		assertTrue(waveDiagonalPathMediumSchemaArrowheadMirrored.canSwitchArrowHead());

		assertTrue(waveDiagonalPathLarge.canSwitchArrowHead());
		assertTrue(waveDiagonalPathLargeEmptyArrowhead.canSwitchArrowHead());
		assertTrue(waveDiagonalPathLargeSchemaArrowhead.canSwitchArrowHead());
		assertTrue(waveDiagonalPathLargeMirrored.canSwitchArrowHead());
		assertTrue(waveDiagonalPathLargeEmptyArrowheadMirrored.canSwitchArrowHead());
		assertTrue(waveDiagonalPathLargeSchemaArrowheadMirrored.canSwitchArrowHead());

	}

	@Override
	public void testSwitchArrowHead() {

		curveHitsFrontWall.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-001-01-02-01"), curveHitsFrontWall.getSymbol());
		curveHitsFrontWall.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-001-01-03-01"), curveHitsFrontWall.getSymbol());
		curveHitsFrontWall.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-001-01-01-01"), curveHitsFrontWall.getSymbol());

		curveHitsFrontWallEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-001-01-03-01"), curveHitsFrontWallEmptyArrowhead.getSymbol());
		curveHitsFrontWallEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-001-01-01-01"), curveHitsFrontWallEmptyArrowhead.getSymbol());
		curveHitsFrontWallEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-001-01-02-01"), curveHitsFrontWallEmptyArrowhead.getSymbol());

		curveHitsFrontWallSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-001-01-01-01"), curveHitsFrontWallSchemaArrowhead.getSymbol());
		curveHitsFrontWallSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-001-01-02-01"), curveHitsFrontWallSchemaArrowhead.getSymbol());
		curveHitsFrontWallSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-001-01-03-01"), curveHitsFrontWallSchemaArrowhead.getSymbol());

		humpHitsFrontWall.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-002-01-02-01"), humpHitsFrontWall.getSymbol());
		humpHitsFrontWall.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-002-01-03-01"), humpHitsFrontWall.getSymbol());
		humpHitsFrontWall.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-002-01-01-01"), humpHitsFrontWall.getSymbol());

		humpHitsFrontWallEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-002-01-03-01"), humpHitsFrontWallEmptyArrowhead.getSymbol());
		humpHitsFrontWallEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-002-01-01-01"), humpHitsFrontWallEmptyArrowhead.getSymbol());
		humpHitsFrontWallEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-002-01-02-01"), humpHitsFrontWallEmptyArrowhead.getSymbol());

		humpHitsFrontWallSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-002-01-01-01"), humpHitsFrontWallSchemaArrowhead.getSymbol());
		humpHitsFrontWallSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-002-01-02-01"), humpHitsFrontWallSchemaArrowhead.getSymbol());
		humpHitsFrontWallSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-002-01-03-01"), humpHitsFrontWallSchemaArrowhead.getSymbol());

		loopHitsFrontWall.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-003-01-02-01"), loopHitsFrontWall.getSymbol());
		loopHitsFrontWall.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-003-01-03-01"), loopHitsFrontWall.getSymbol());
		loopHitsFrontWall.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-003-01-01-01"), loopHitsFrontWall.getSymbol());

		loopHitsFrontWallEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-003-01-03-01"), loopHitsFrontWallEmptyArrowhead.getSymbol());
		loopHitsFrontWallEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-003-01-01-01"), loopHitsFrontWallEmptyArrowhead.getSymbol());
		loopHitsFrontWallEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-003-01-02-01"), loopHitsFrontWallEmptyArrowhead.getSymbol());

		loopHitsFrontWallSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-003-01-01-01"), loopHitsFrontWallSchemaArrowhead.getSymbol());
		loopHitsFrontWallSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-003-01-02-01"), loopHitsFrontWallSchemaArrowhead.getSymbol());
		loopHitsFrontWallSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-003-01-03-01"), loopHitsFrontWallSchemaArrowhead.getSymbol());

		waveHitsFrontWall.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-004-01-02-01"), waveHitsFrontWall.getSymbol());
		waveHitsFrontWall.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-004-01-03-01"), waveHitsFrontWall.getSymbol());
		waveHitsFrontWall.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-004-01-01-01"), waveHitsFrontWall.getSymbol());

		waveHitsFrontWallEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-004-01-03-01"), waveHitsFrontWallEmptyArrowhead.getSymbol());
		waveHitsFrontWallEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-004-01-01-01"), waveHitsFrontWallEmptyArrowhead.getSymbol());
		waveHitsFrontWallEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-004-01-02-01"), waveHitsFrontWallEmptyArrowhead.getSymbol());

		waveHitsFrontWallSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-004-01-01-01"), waveHitsFrontWallSchemaArrowhead.getSymbol());
		waveHitsFrontWallSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-004-01-02-01"), waveHitsFrontWallSchemaArrowhead.getSymbol());
		waveHitsFrontWallSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-004-01-03-01"), waveHitsFrontWallSchemaArrowhead.getSymbol());

		rotationSingleHitsFrontWall.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-005-01-02-01"), rotationSingleHitsFrontWall.getSymbol());
		rotationSingleHitsFrontWall.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-005-01-03-01"), rotationSingleHitsFrontWall.getSymbol());
		rotationSingleHitsFrontWall.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-005-01-01-01"), rotationSingleHitsFrontWall.getSymbol());

		rotationSingleHitsFrontWallEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-005-01-03-01"),
				rotationSingleHitsFrontWallEmptyArrowhead.getSymbol());
		rotationSingleHitsFrontWallEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-005-01-01-01"),
				rotationSingleHitsFrontWallEmptyArrowhead.getSymbol());
		rotationSingleHitsFrontWallEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-005-01-02-01"),
				rotationSingleHitsFrontWallEmptyArrowhead.getSymbol());

		rotationSingleHitsFrontWallSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-005-01-01-01"),
				rotationSingleHitsFrontWallSchemaArrowhead.getSymbol());
		rotationSingleHitsFrontWallSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-005-01-02-01"),
				rotationSingleHitsFrontWallSchemaArrowhead.getSymbol());
		rotationSingleHitsFrontWallSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-005-01-03-01"),
				rotationSingleHitsFrontWallSchemaArrowhead.getSymbol());

		rotationDoubleHitsFrontWall.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-006-01-02-01"), rotationDoubleHitsFrontWall.getSymbol());
		rotationDoubleHitsFrontWall.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-006-01-03-01"), rotationDoubleHitsFrontWall.getSymbol());
		rotationDoubleHitsFrontWall.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-006-01-01-01"), rotationDoubleHitsFrontWall.getSymbol());

		rotationDoubleHitsFrontWallEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-006-01-03-01"),
				rotationDoubleHitsFrontWallEmptyArrowhead.getSymbol());
		rotationDoubleHitsFrontWallEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-006-01-01-01"),
				rotationDoubleHitsFrontWallEmptyArrowhead.getSymbol());
		rotationDoubleHitsFrontWallEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-006-01-02-01"),
				rotationDoubleHitsFrontWallEmptyArrowhead.getSymbol());

		rotationDoubleHitsFrontWallSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-006-01-01-01"),
				rotationDoubleHitsFrontWallSchemaArrowhead.getSymbol());
		rotationDoubleHitsFrontWallSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-006-01-02-01"),
				rotationDoubleHitsFrontWallSchemaArrowhead.getSymbol());
		rotationDoubleHitsFrontWallSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-006-01-03-01"),
				rotationDoubleHitsFrontWallSchemaArrowhead.getSymbol());

		rotationAlternatingHitsFrontWall.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-007-01-02-01"), rotationAlternatingHitsFrontWall.getSymbol());
		rotationAlternatingHitsFrontWall.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-007-01-03-01"), rotationAlternatingHitsFrontWall.getSymbol());
		rotationAlternatingHitsFrontWall.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-007-01-01-01"), rotationAlternatingHitsFrontWall.getSymbol());

		rotationAlternatingHitsFrontWallEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-007-01-03-01"),
				rotationAlternatingHitsFrontWallEmptyArrowhead.getSymbol());
		rotationAlternatingHitsFrontWallEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-007-01-01-01"),
				rotationAlternatingHitsFrontWallEmptyArrowhead.getSymbol());
		rotationAlternatingHitsFrontWallEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-007-01-02-01"),
				rotationAlternatingHitsFrontWallEmptyArrowhead.getSymbol());

		rotationAlternatingHitsFrontWallSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-007-01-01-01"),
				rotationAlternatingHitsFrontWallSchemaArrowhead.getSymbol());
		rotationAlternatingHitsFrontWallSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-007-01-02-01"),
				rotationAlternatingHitsFrontWallSchemaArrowhead.getSymbol());
		rotationAlternatingHitsFrontWallSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-007-01-03-01"),
				rotationAlternatingHitsFrontWallSchemaArrowhead.getSymbol());

		curveHitsChest.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-009-01-02-01"), curveHitsChest.getSymbol());
		curveHitsChest.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-009-01-03-01"), curveHitsChest.getSymbol());
		curveHitsChest.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-009-01-01-01"), curveHitsChest.getSymbol());

		curveHitsChestEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-009-01-03-01"), curveHitsChestEmptyArrowhead.getSymbol());
		curveHitsChestEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-009-01-01-01"), curveHitsChestEmptyArrowhead.getSymbol());
		curveHitsChestEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-009-01-02-01"), curveHitsChestEmptyArrowhead.getSymbol());

		curveHitsChestSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-009-01-01-01"), curveHitsChestSchemaArrowhead.getSymbol());
		curveHitsChestSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-009-01-02-01"), curveHitsChestSchemaArrowhead.getSymbol());
		curveHitsChestSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-009-01-03-01"), curveHitsChestSchemaArrowhead.getSymbol());

		humpHitsChest.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-010-01-02-01"), humpHitsChest.getSymbol());
		humpHitsChest.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-010-01-03-01"), humpHitsChest.getSymbol());
		humpHitsChest.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-010-01-01-01"), humpHitsChest.getSymbol());

		humpHitsChestEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-010-01-03-01"), humpHitsChestEmptyArrowhead.getSymbol());
		humpHitsChestEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-010-01-01-01"), humpHitsChestEmptyArrowhead.getSymbol());
		humpHitsChestEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-010-01-02-01"), humpHitsChestEmptyArrowhead.getSymbol());

		humpHitsChestSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-010-01-01-01"), humpHitsChestSchemaArrowhead.getSymbol());
		humpHitsChestSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-010-01-02-01"), humpHitsChestSchemaArrowhead.getSymbol());
		humpHitsChestSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-010-01-03-01"), humpHitsChestSchemaArrowhead.getSymbol());

		loopHitsChest.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-011-01-02-01"), loopHitsChest.getSymbol());
		loopHitsChest.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-011-01-03-01"), loopHitsChest.getSymbol());
		loopHitsChest.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-011-01-01-01"), loopHitsChest.getSymbol());

		loopHitsChestEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-011-01-03-01"), loopHitsChestEmptyArrowhead.getSymbol());
		loopHitsChestEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-011-01-01-01"), loopHitsChestEmptyArrowhead.getSymbol());
		loopHitsChestEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-011-01-02-01"), loopHitsChestEmptyArrowhead.getSymbol());

		loopHitsChestSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-011-01-01-01"), loopHitsChestSchemaArrowhead.getSymbol());
		loopHitsChestSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-011-01-02-01"), loopHitsChestSchemaArrowhead.getSymbol());
		loopHitsChestSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-011-01-03-01"), loopHitsChestSchemaArrowhead.getSymbol());

		waveHitsChest.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-012-01-02-01"), waveHitsChest.getSymbol());
		waveHitsChest.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-012-01-03-01"), waveHitsChest.getSymbol());
		waveHitsChest.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-012-01-01-01"), waveHitsChest.getSymbol());

		waveHitsChestEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-012-01-03-01"), waveHitsChestEmptyArrowhead.getSymbol());
		waveHitsChestEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-012-01-01-01"), waveHitsChestEmptyArrowhead.getSymbol());
		waveHitsChestEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-012-01-02-01"), waveHitsChestEmptyArrowhead.getSymbol());

		waveHitsChestSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-012-01-01-01"), waveHitsChestSchemaArrowhead.getSymbol());
		waveHitsChestSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-012-01-02-01"), waveHitsChestSchemaArrowhead.getSymbol());
		waveHitsChestSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-012-01-03-01"), waveHitsChestSchemaArrowhead.getSymbol());

		rotationSingleHitsChest.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-013-01-02-01"), rotationSingleHitsChest.getSymbol());
		rotationSingleHitsChest.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-013-01-03-01"), rotationSingleHitsChest.getSymbol());
		rotationSingleHitsChest.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-013-01-01-01"), rotationSingleHitsChest.getSymbol());

		rotationSingleHitsChestEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-013-01-03-01"),
				rotationSingleHitsChestEmptyArrowhead.getSymbol());
		rotationSingleHitsChestEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-013-01-01-01"),
				rotationSingleHitsChestEmptyArrowhead.getSymbol());
		rotationSingleHitsChestEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-013-01-02-01"),
				rotationSingleHitsChestEmptyArrowhead.getSymbol());

		rotationSingleHitsChestSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-013-01-01-01"),
				rotationSingleHitsChestSchemaArrowhead.getSymbol());
		rotationSingleHitsChestSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-013-01-02-01"),
				rotationSingleHitsChestSchemaArrowhead.getSymbol());
		rotationSingleHitsChestSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-013-01-03-01"),
				rotationSingleHitsChestSchemaArrowhead.getSymbol());

		rotationDoubleHitsChest.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-014-01-02-01"), rotationDoubleHitsChest.getSymbol());
		rotationDoubleHitsChest.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-014-01-03-01"), rotationDoubleHitsChest.getSymbol());
		rotationDoubleHitsChest.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-014-01-01-01"), rotationDoubleHitsChest.getSymbol());

		rotationDoubleHitsChestEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-014-01-03-01"),
				rotationDoubleHitsChestEmptyArrowhead.getSymbol());
		rotationDoubleHitsChestEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-014-01-01-01"),
				rotationDoubleHitsChestEmptyArrowhead.getSymbol());
		rotationDoubleHitsChestEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-014-01-02-01"),
				rotationDoubleHitsChestEmptyArrowhead.getSymbol());

		rotationDoubleHitsChestSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-014-01-01-01"),
				rotationDoubleHitsChestSchemaArrowhead.getSymbol());
		rotationDoubleHitsChestSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-014-01-02-01"),
				rotationDoubleHitsChestSchemaArrowhead.getSymbol());
		rotationDoubleHitsChestSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-014-01-03-01"),
				rotationDoubleHitsChestSchemaArrowhead.getSymbol());

		rotationAlternatingHitsChest.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-015-01-02-01"), rotationAlternatingHitsChest.getSymbol());
		rotationAlternatingHitsChest.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-015-01-03-01"), rotationAlternatingHitsChest.getSymbol());
		rotationAlternatingHitsChest.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-015-01-01-01"), rotationAlternatingHitsChest.getSymbol());

		rotationAlternatingHitsChestEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-015-01-03-01"),
				rotationAlternatingHitsChestEmptyArrowhead.getSymbol());
		rotationAlternatingHitsChestEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-015-01-01-01"),
				rotationAlternatingHitsChestEmptyArrowhead.getSymbol());
		rotationAlternatingHitsChestEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-015-01-02-01"),
				rotationAlternatingHitsChestEmptyArrowhead.getSymbol());

		rotationAlternatingHitsChestSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-015-01-01-01"),
				rotationAlternatingHitsChestSchemaArrowhead.getSymbol());
		rotationAlternatingHitsChestSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-015-01-02-01"),
				rotationAlternatingHitsChestSchemaArrowhead.getSymbol());
		rotationAlternatingHitsChestSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-015-01-03-01"),
				rotationAlternatingHitsChestSchemaArrowhead.getSymbol());

		waveDiagonalPathSmall.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-016-01-02-01"), waveDiagonalPathSmall.getSymbol());
		waveDiagonalPathSmall.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-016-01-03-01"), waveDiagonalPathSmall.getSymbol());
		waveDiagonalPathSmall.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-016-01-01-01"), waveDiagonalPathSmall.getSymbol());

		waveDiagonalPathSmallEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-016-01-03-01"), waveDiagonalPathSmallEmptyArrowhead.getSymbol());
		waveDiagonalPathSmallEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-016-01-01-01"), waveDiagonalPathSmallEmptyArrowhead.getSymbol());
		waveDiagonalPathSmallEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-016-01-02-01"), waveDiagonalPathSmallEmptyArrowhead.getSymbol());

		waveDiagonalPathSmallSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-016-01-01-01"),
				waveDiagonalPathSmallSchemaArrowhead.getSymbol());
		waveDiagonalPathSmallSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-016-01-02-01"),
				waveDiagonalPathSmallSchemaArrowhead.getSymbol());
		waveDiagonalPathSmallSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-016-01-03-01"),
				waveDiagonalPathSmallSchemaArrowhead.getSymbol());

		waveDiagonalPathSmallMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-016-01-02-09"), waveDiagonalPathSmallMirrored.getSymbol());
		waveDiagonalPathSmallMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-016-01-03-09"), waveDiagonalPathSmallMirrored.getSymbol());
		waveDiagonalPathSmallMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-016-01-01-09"), waveDiagonalPathSmallMirrored.getSymbol());

		waveDiagonalPathSmallEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-016-01-03-09"),
				waveDiagonalPathSmallEmptyArrowheadMirrored.getSymbol());
		waveDiagonalPathSmallEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-016-01-01-09"),
				waveDiagonalPathSmallEmptyArrowheadMirrored.getSymbol());
		waveDiagonalPathSmallEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-016-01-02-09"),
				waveDiagonalPathSmallEmptyArrowheadMirrored.getSymbol());

		waveDiagonalPathSmallSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-016-01-01-09"),
				waveDiagonalPathSmallSchemaArrowheadMirrored.getSymbol());
		waveDiagonalPathSmallSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-016-01-02-09"),
				waveDiagonalPathSmallSchemaArrowheadMirrored.getSymbol());
		waveDiagonalPathSmallSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-016-01-03-09"),
				waveDiagonalPathSmallSchemaArrowheadMirrored.getSymbol());

		waveDiagonalPathMedium.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-016-02-02-01"), waveDiagonalPathMedium.getSymbol());
		waveDiagonalPathMedium.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-016-02-03-01"), waveDiagonalPathMedium.getSymbol());
		waveDiagonalPathMedium.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-016-02-01-01"), waveDiagonalPathMedium.getSymbol());

		waveDiagonalPathMediumEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-016-02-03-01"),
				waveDiagonalPathMediumEmptyArrowhead.getSymbol());
		waveDiagonalPathMediumEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-016-02-01-01"),
				waveDiagonalPathMediumEmptyArrowhead.getSymbol());
		waveDiagonalPathMediumEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-016-02-02-01"),
				waveDiagonalPathMediumEmptyArrowhead.getSymbol());

		waveDiagonalPathMediumSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-016-02-01-01"),
				waveDiagonalPathMediumSchemaArrowhead.getSymbol());
		waveDiagonalPathMediumSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-016-02-02-01"),
				waveDiagonalPathMediumSchemaArrowhead.getSymbol());
		waveDiagonalPathMediumSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-016-02-03-01"),
				waveDiagonalPathMediumSchemaArrowhead.getSymbol());

		waveDiagonalPathMediumMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-016-02-02-09"), waveDiagonalPathMediumMirrored.getSymbol());
		waveDiagonalPathMediumMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-016-02-03-09"), waveDiagonalPathMediumMirrored.getSymbol());
		waveDiagonalPathMediumMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-016-02-01-09"), waveDiagonalPathMediumMirrored.getSymbol());

		waveDiagonalPathMediumEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-016-02-03-09"),
				waveDiagonalPathMediumEmptyArrowheadMirrored.getSymbol());
		waveDiagonalPathMediumEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-016-02-01-09"),
				waveDiagonalPathMediumEmptyArrowheadMirrored.getSymbol());
		waveDiagonalPathMediumEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-016-02-02-09"),
				waveDiagonalPathMediumEmptyArrowheadMirrored.getSymbol());

		waveDiagonalPathMediumSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-016-02-01-09"),
				waveDiagonalPathMediumSchemaArrowheadMirrored.getSymbol());
		waveDiagonalPathMediumSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-016-02-02-09"),
				waveDiagonalPathMediumSchemaArrowheadMirrored.getSymbol());
		waveDiagonalPathMediumSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-016-02-03-09"),
				waveDiagonalPathMediumSchemaArrowheadMirrored.getSymbol());

		waveDiagonalPathLarge.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-016-03-02-01"), waveDiagonalPathLarge.getSymbol());
		waveDiagonalPathLarge.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-016-03-03-01"), waveDiagonalPathLarge.getSymbol());
		waveDiagonalPathLarge.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-016-03-01-01"), waveDiagonalPathLarge.getSymbol());

		waveDiagonalPathLargeEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-016-03-03-01"), waveDiagonalPathLargeEmptyArrowhead.getSymbol());
		waveDiagonalPathLargeEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-016-03-01-01"), waveDiagonalPathLargeEmptyArrowhead.getSymbol());
		waveDiagonalPathLargeEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-016-03-02-01"), waveDiagonalPathLargeEmptyArrowhead.getSymbol());

		waveDiagonalPathLargeSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-016-03-01-01"),
				waveDiagonalPathLargeSchemaArrowhead.getSymbol());
		waveDiagonalPathLargeSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-016-03-02-01"),
				waveDiagonalPathLargeSchemaArrowhead.getSymbol());
		waveDiagonalPathLargeSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-016-03-03-01"),
				waveDiagonalPathLargeSchemaArrowhead.getSymbol());

		waveDiagonalPathLargeMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-016-03-02-09"), waveDiagonalPathLargeMirrored.getSymbol());
		waveDiagonalPathLargeMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-016-03-03-09"), waveDiagonalPathLargeMirrored.getSymbol());
		waveDiagonalPathLargeMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-016-03-01-09"), waveDiagonalPathLargeMirrored.getSymbol());

		waveDiagonalPathLargeEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-016-03-03-09"),
				waveDiagonalPathLargeEmptyArrowheadMirrored.getSymbol());
		waveDiagonalPathLargeEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-016-03-01-09"),
				waveDiagonalPathLargeEmptyArrowheadMirrored.getSymbol());
		waveDiagonalPathLargeEmptyArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-016-03-02-09"),
				waveDiagonalPathLargeEmptyArrowheadMirrored.getSymbol());

		waveDiagonalPathLargeSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-016-03-01-09"),
				waveDiagonalPathLargeSchemaArrowheadMirrored.getSymbol());
		waveDiagonalPathLargeSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-016-03-02-09"),
				waveDiagonalPathLargeSchemaArrowheadMirrored.getSymbol());
		waveDiagonalPathLargeSchemaArrowheadMirrored.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-07-016-03-03-09"),
				waveDiagonalPathLargeSchemaArrowheadMirrored.getSymbol());

	}

	@Override
	public void testCanSwitchToNormalArrows() {

		assertFalse(curveHitsFrontWall.canSwitchToNormalArrows());
		assertFalse(curveHitsFrontWallEmptyArrowhead.canSwitchToNormalArrows());
		assertFalse(curveHitsFrontWallSchemaArrowhead.canSwitchToNormalArrows());

		assertFalse(humpHitsFrontWall.canSwitchToNormalArrows());
		assertFalse(humpHitsFrontWallEmptyArrowhead.canSwitchToNormalArrows());
		assertFalse(humpHitsFrontWallSchemaArrowhead.canSwitchToNormalArrows());

		assertFalse(loopHitsFrontWall.canSwitchToNormalArrows());
		assertFalse(loopHitsFrontWallEmptyArrowhead.canSwitchToNormalArrows());
		assertFalse(loopHitsFrontWallSchemaArrowhead.canSwitchToNormalArrows());

		assertFalse(waveHitsFrontWall.canSwitchToNormalArrows());
		assertFalse(waveHitsFrontWallEmptyArrowhead.canSwitchToNormalArrows());
		assertFalse(waveHitsFrontWallSchemaArrowhead.canSwitchToNormalArrows());

		assertFalse(rotationSingleHitsFrontWall.canSwitchToNormalArrows());
		assertFalse(rotationSingleHitsFrontWallEmptyArrowhead.canSwitchToNormalArrows());
		assertFalse(rotationSingleHitsFrontWallSchemaArrowhead.canSwitchToNormalArrows());

		assertFalse(rotationDoubleHitsFrontWall.canSwitchToNormalArrows());
		assertFalse(rotationDoubleHitsFrontWallEmptyArrowhead.canSwitchToNormalArrows());
		assertFalse(rotationDoubleHitsFrontWallSchemaArrowhead.canSwitchToNormalArrows());

		assertTrue(rotationAlternatingHitsFrontWall.canSwitchToNormalArrows());
		assertTrue(rotationAlternatingHitsFrontWallEmptyArrowhead.canSwitchToNormalArrows());
		assertTrue(rotationAlternatingHitsFrontWallSchemaArrowhead.canSwitchToNormalArrows());

		assertFalse(curveHitsChest.canSwitchToNormalArrows());
		assertFalse(curveHitsChestEmptyArrowhead.canSwitchToNormalArrows());
		assertFalse(curveHitsChestSchemaArrowhead.canSwitchToNormalArrows());

		assertFalse(humpHitsChest.canSwitchToNormalArrows());
		assertFalse(humpHitsChestEmptyArrowhead.canSwitchToNormalArrows());
		assertFalse(humpHitsChestSchemaArrowhead.canSwitchToNormalArrows());

		assertFalse(loopHitsChest.canSwitchToNormalArrows());
		assertFalse(loopHitsChestEmptyArrowhead.canSwitchToNormalArrows());
		assertFalse(loopHitsChestSchemaArrowhead.canSwitchToNormalArrows());

		assertFalse(waveHitsChest.canSwitchToNormalArrows());
		assertFalse(waveHitsChestEmptyArrowhead.canSwitchToNormalArrows());
		assertFalse(waveHitsChestSchemaArrowhead.canSwitchToNormalArrows());

		assertFalse(rotationSingleHitsChest.canSwitchToNormalArrows());
		assertFalse(rotationSingleHitsChestEmptyArrowhead.canSwitchToNormalArrows());
		assertFalse(rotationSingleHitsChestSchemaArrowhead.canSwitchToNormalArrows());

		assertFalse(rotationDoubleHitsChest.canSwitchToNormalArrows());
		assertFalse(rotationDoubleHitsChestEmptyArrowhead.canSwitchToNormalArrows());
		assertFalse(rotationDoubleHitsChestSchemaArrowhead.canSwitchToNormalArrows());

		assertTrue(rotationAlternatingHitsChest.canSwitchToNormalArrows());
		assertTrue(rotationAlternatingHitsChestEmptyArrowhead.canSwitchToNormalArrows());
		assertTrue(rotationAlternatingHitsChestSchemaArrowhead.canSwitchToNormalArrows());

		assertFalse(waveDiagonalPathSmall.canSwitchToNormalArrows());
		assertFalse(waveDiagonalPathSmallEmptyArrowhead.canSwitchToNormalArrows());
		assertFalse(waveDiagonalPathSmallSchemaArrowhead.canSwitchToNormalArrows());
		assertFalse(waveDiagonalPathSmallMirrored.canSwitchToNormalArrows());
		assertFalse(waveDiagonalPathSmallEmptyArrowheadMirrored.canSwitchToNormalArrows());
		assertFalse(waveDiagonalPathSmallSchemaArrowheadMirrored.canSwitchToNormalArrows());

		assertFalse(waveDiagonalPathMedium.canSwitchToNormalArrows());
		assertFalse(waveDiagonalPathMediumEmptyArrowhead.canSwitchToNormalArrows());
		assertFalse(waveDiagonalPathMediumSchemaArrowhead.canSwitchToNormalArrows());
		assertFalse(waveDiagonalPathMediumMirrored.canSwitchToNormalArrows());
		assertFalse(waveDiagonalPathMediumEmptyArrowheadMirrored.canSwitchToNormalArrows());
		assertFalse(waveDiagonalPathMediumSchemaArrowheadMirrored.canSwitchToNormalArrows());

		assertFalse(waveDiagonalPathLarge.canSwitchToNormalArrows());
		assertFalse(waveDiagonalPathLargeEmptyArrowhead.canSwitchToNormalArrows());
		assertFalse(waveDiagonalPathLargeSchemaArrowhead.canSwitchToNormalArrows());
		assertFalse(waveDiagonalPathLargeMirrored.canSwitchToNormalArrows());
		assertFalse(waveDiagonalPathLargeEmptyArrowheadMirrored.canSwitchToNormalArrows());
		assertFalse(waveDiagonalPathLargeSchemaArrowheadMirrored.canSwitchToNormalArrows());
	}

	@Override
	public void testSwitchToNormalArrows() {

		rotationAlternatingHitsFrontWall.switchToNormalArrows();
		assertEquals(rotationDoubleHitsFrontWall.getSymbol(), rotationAlternatingHitsFrontWall.getSymbol());
		rotationAlternatingHitsFrontWallEmptyArrowhead.switchToNormalArrows();
		assertEquals(rotationDoubleHitsFrontWallEmptyArrowhead.getSymbol(),
				rotationAlternatingHitsFrontWallEmptyArrowhead.getSymbol());
		rotationAlternatingHitsFrontWallSchemaArrowhead.switchToNormalArrows();
		assertEquals(rotationDoubleHitsFrontWallSchemaArrowhead.getSymbol(),
				rotationAlternatingHitsFrontWallSchemaArrowhead.getSymbol());

		rotationAlternatingHitsChest.switchToNormalArrows();
		assertEquals(rotationDoubleHitsChest.getSymbol(), rotationAlternatingHitsChest.getSymbol());
		rotationAlternatingHitsChestEmptyArrowhead.switchToNormalArrows();
		assertEquals(rotationDoubleHitsChestEmptyArrowhead.getSymbol(),
				rotationAlternatingHitsChestEmptyArrowhead.getSymbol());
		rotationAlternatingHitsChestSchemaArrowhead.switchToNormalArrows();
		assertEquals(rotationDoubleHitsChestSchemaArrowhead.getSymbol(),
				rotationAlternatingHitsChestSchemaArrowhead.getSymbol());

	}

	@Override
	public void testCanSwitchToAlternatingArrows() {

		assertFalse(curveHitsFrontWall.canSwitchToAlternatingArrows());
		assertFalse(curveHitsFrontWallEmptyArrowhead.canSwitchToAlternatingArrows());
		assertFalse(curveHitsFrontWallSchemaArrowhead.canSwitchToAlternatingArrows());

		assertFalse(humpHitsFrontWall.canSwitchToAlternatingArrows());
		assertFalse(humpHitsFrontWallEmptyArrowhead.canSwitchToAlternatingArrows());
		assertFalse(humpHitsFrontWallSchemaArrowhead.canSwitchToAlternatingArrows());

		assertFalse(loopHitsFrontWall.canSwitchToAlternatingArrows());
		assertFalse(loopHitsFrontWallEmptyArrowhead.canSwitchToAlternatingArrows());
		assertFalse(loopHitsFrontWallSchemaArrowhead.canSwitchToAlternatingArrows());

		assertFalse(waveHitsFrontWall.canSwitchToAlternatingArrows());
		assertFalse(waveHitsFrontWallEmptyArrowhead.canSwitchToAlternatingArrows());
		assertFalse(waveHitsFrontWallSchemaArrowhead.canSwitchToAlternatingArrows());

		assertFalse(rotationSingleHitsFrontWall.canSwitchToAlternatingArrows());
		assertFalse(rotationSingleHitsFrontWallEmptyArrowhead.canSwitchToAlternatingArrows());
		assertFalse(rotationSingleHitsFrontWallSchemaArrowhead.canSwitchToAlternatingArrows());

		assertTrue(rotationDoubleHitsFrontWall.canSwitchToAlternatingArrows());
		assertTrue(rotationDoubleHitsFrontWallEmptyArrowhead.canSwitchToAlternatingArrows());
		assertTrue(rotationDoubleHitsFrontWallSchemaArrowhead.canSwitchToAlternatingArrows());

		assertFalse(rotationAlternatingHitsFrontWall.canSwitchToAlternatingArrows());
		assertFalse(rotationAlternatingHitsFrontWallEmptyArrowhead.canSwitchToAlternatingArrows());
		assertFalse(rotationAlternatingHitsFrontWallSchemaArrowhead.canSwitchToAlternatingArrows());

		assertFalse(curveHitsChest.canSwitchToAlternatingArrows());
		assertFalse(curveHitsChestEmptyArrowhead.canSwitchToAlternatingArrows());
		assertFalse(curveHitsChestSchemaArrowhead.canSwitchToAlternatingArrows());

		assertFalse(humpHitsChest.canSwitchToAlternatingArrows());
		assertFalse(humpHitsChestEmptyArrowhead.canSwitchToAlternatingArrows());
		assertFalse(humpHitsChestSchemaArrowhead.canSwitchToAlternatingArrows());

		assertFalse(loopHitsChest.canSwitchToAlternatingArrows());
		assertFalse(loopHitsChestEmptyArrowhead.canSwitchToAlternatingArrows());
		assertFalse(loopHitsChestSchemaArrowhead.canSwitchToAlternatingArrows());

		assertFalse(waveHitsChest.canSwitchToAlternatingArrows());
		assertFalse(waveHitsChestEmptyArrowhead.canSwitchToAlternatingArrows());
		assertFalse(waveHitsChestSchemaArrowhead.canSwitchToAlternatingArrows());

		assertFalse(rotationSingleHitsChest.canSwitchToAlternatingArrows());
		assertFalse(rotationSingleHitsChestEmptyArrowhead.canSwitchToAlternatingArrows());
		assertFalse(rotationSingleHitsChestSchemaArrowhead.canSwitchToAlternatingArrows());

		assertTrue(rotationDoubleHitsChest.canSwitchToAlternatingArrows());
		assertTrue(rotationDoubleHitsChestEmptyArrowhead.canSwitchToAlternatingArrows());
		assertTrue(rotationDoubleHitsChestSchemaArrowhead.canSwitchToAlternatingArrows());

		assertFalse(rotationAlternatingHitsChest.canSwitchToAlternatingArrows());
		assertFalse(rotationAlternatingHitsChestEmptyArrowhead.canSwitchToAlternatingArrows());
		assertFalse(rotationAlternatingHitsChestSchemaArrowhead.canSwitchToAlternatingArrows());

		assertFalse(waveDiagonalPathSmall.canSwitchToAlternatingArrows());
		assertFalse(waveDiagonalPathSmallEmptyArrowhead.canSwitchToAlternatingArrows());
		assertFalse(waveDiagonalPathSmallSchemaArrowhead.canSwitchToAlternatingArrows());
		assertFalse(waveDiagonalPathSmallMirrored.canSwitchToAlternatingArrows());
		assertFalse(waveDiagonalPathSmallEmptyArrowheadMirrored.canSwitchToAlternatingArrows());
		assertFalse(waveDiagonalPathSmallSchemaArrowheadMirrored.canSwitchToAlternatingArrows());

		assertFalse(waveDiagonalPathMedium.canSwitchToAlternatingArrows());
		assertFalse(waveDiagonalPathMediumEmptyArrowhead.canSwitchToAlternatingArrows());
		assertFalse(waveDiagonalPathMediumSchemaArrowhead.canSwitchToAlternatingArrows());
		assertFalse(waveDiagonalPathMediumMirrored.canSwitchToAlternatingArrows());
		assertFalse(waveDiagonalPathMediumEmptyArrowheadMirrored.canSwitchToAlternatingArrows());
		assertFalse(waveDiagonalPathMediumSchemaArrowheadMirrored.canSwitchToAlternatingArrows());

		assertFalse(waveDiagonalPathLarge.canSwitchToAlternatingArrows());
		assertFalse(waveDiagonalPathLargeEmptyArrowhead.canSwitchToAlternatingArrows());
		assertFalse(waveDiagonalPathLargeSchemaArrowhead.canSwitchToAlternatingArrows());
		assertFalse(waveDiagonalPathLargeMirrored.canSwitchToAlternatingArrows());
		assertFalse(waveDiagonalPathLargeEmptyArrowheadMirrored.canSwitchToAlternatingArrows());
		assertFalse(waveDiagonalPathLargeSchemaArrowheadMirrored.canSwitchToAlternatingArrows());

	}

	@Override
	public void testSwitchToAlternatingArrows() {

		rotationDoubleHitsFrontWall.switchToAlternatingArrows();
		assertEquals(rotationAlternatingHitsFrontWall.getSymbol(), rotationDoubleHitsFrontWall.getSymbol());
		rotationDoubleHitsFrontWallEmptyArrowhead.switchToAlternatingArrows();
		assertEquals(rotationAlternatingHitsFrontWallEmptyArrowhead.getSymbol(),
				rotationDoubleHitsFrontWallEmptyArrowhead.getSymbol());
		rotationDoubleHitsFrontWallSchemaArrowhead.switchToAlternatingArrows();
		assertEquals(rotationAlternatingHitsFrontWallSchemaArrowhead.getSymbol(),
				rotationDoubleHitsFrontWallSchemaArrowhead.getSymbol());

		rotationDoubleHitsChest.switchToAlternatingArrows();
		assertEquals(rotationAlternatingHitsChest.getSymbol(), rotationDoubleHitsChest.getSymbol());
		rotationDoubleHitsChestEmptyArrowhead.switchToAlternatingArrows();
		assertEquals(rotationAlternatingHitsChestEmptyArrowhead.getSymbol(),
				rotationDoubleHitsChestEmptyArrowhead.getSymbol());
		rotationDoubleHitsChestSchemaArrowhead.switchToAlternatingArrows();
		assertEquals(rotationAlternatingHitsChestSchemaArrowhead.getSymbol(),
				rotationDoubleHitsChestSchemaArrowhead.getSymbol());
	}

	@Override
	public void testCanSwitchStartingPoint() {

		assertFalse(curveHitsFrontWall.canSwitchStartingPoint());
		assertFalse(curveHitsFrontWallEmptyArrowhead.canSwitchStartingPoint());
		assertFalse(curveHitsFrontWallSchemaArrowhead.canSwitchStartingPoint());

		assertFalse(humpHitsFrontWall.canSwitchStartingPoint());
		assertFalse(humpHitsFrontWallEmptyArrowhead.canSwitchStartingPoint());
		assertFalse(humpHitsFrontWallSchemaArrowhead.canSwitchStartingPoint());

		assertFalse(loopHitsFrontWall.canSwitchStartingPoint());
		assertFalse(loopHitsFrontWallEmptyArrowhead.canSwitchStartingPoint());
		assertFalse(loopHitsFrontWallSchemaArrowhead.canSwitchStartingPoint());

		assertFalse(waveHitsFrontWall.canSwitchStartingPoint());
		assertFalse(waveHitsFrontWallEmptyArrowhead.canSwitchStartingPoint());
		assertFalse(waveHitsFrontWallSchemaArrowhead.canSwitchStartingPoint());

		assertFalse(rotationSingleHitsFrontWall.canSwitchStartingPoint());
		assertFalse(rotationSingleHitsFrontWallEmptyArrowhead.canSwitchStartingPoint());
		assertFalse(rotationSingleHitsFrontWallSchemaArrowhead.canSwitchStartingPoint());

		assertFalse(rotationDoubleHitsFrontWall.canSwitchStartingPoint());
		assertFalse(rotationDoubleHitsFrontWallEmptyArrowhead.canSwitchStartingPoint());
		assertFalse(rotationDoubleHitsFrontWallSchemaArrowhead.canSwitchStartingPoint());

		assertFalse(rotationAlternatingHitsFrontWall.canSwitchStartingPoint());
		assertFalse(rotationAlternatingHitsFrontWallEmptyArrowhead.canSwitchStartingPoint());
		assertFalse(rotationAlternatingHitsFrontWallSchemaArrowhead.canSwitchStartingPoint());

		assertFalse(curveHitsChest.canSwitchStartingPoint());
		assertFalse(curveHitsChestEmptyArrowhead.canSwitchStartingPoint());
		assertFalse(curveHitsChestSchemaArrowhead.canSwitchStartingPoint());

		assertFalse(humpHitsChest.canSwitchStartingPoint());
		assertFalse(humpHitsChestEmptyArrowhead.canSwitchStartingPoint());
		assertFalse(humpHitsChestSchemaArrowhead.canSwitchStartingPoint());

		assertFalse(loopHitsChest.canSwitchStartingPoint());
		assertFalse(loopHitsChestEmptyArrowhead.canSwitchStartingPoint());
		assertFalse(loopHitsChestSchemaArrowhead.canSwitchStartingPoint());

		assertFalse(waveHitsChest.canSwitchStartingPoint());
		assertFalse(waveHitsChestEmptyArrowhead.canSwitchStartingPoint());
		assertFalse(waveHitsChestSchemaArrowhead.canSwitchStartingPoint());

		assertFalse(rotationSingleHitsChest.canSwitchStartingPoint());
		assertFalse(rotationSingleHitsChestEmptyArrowhead.canSwitchStartingPoint());
		assertFalse(rotationSingleHitsChestSchemaArrowhead.canSwitchStartingPoint());

		assertFalse(rotationDoubleHitsChest.canSwitchStartingPoint());
		assertFalse(rotationDoubleHitsChestEmptyArrowhead.canSwitchStartingPoint());
		assertFalse(rotationDoubleHitsChestSchemaArrowhead.canSwitchStartingPoint());

		assertFalse(rotationAlternatingHitsChest.canSwitchStartingPoint());
		assertFalse(rotationAlternatingHitsChestEmptyArrowhead.canSwitchStartingPoint());
		assertFalse(rotationAlternatingHitsChestSchemaArrowhead.canSwitchStartingPoint());

		assertFalse(waveDiagonalPathSmall.canSwitchStartingPoint());
		assertFalse(waveDiagonalPathSmallEmptyArrowhead.canSwitchStartingPoint());
		assertFalse(waveDiagonalPathSmallSchemaArrowhead.canSwitchStartingPoint());
		assertFalse(waveDiagonalPathSmallMirrored.canSwitchStartingPoint());
		assertFalse(waveDiagonalPathSmallEmptyArrowheadMirrored.canSwitchStartingPoint());
		assertFalse(waveDiagonalPathSmallSchemaArrowheadMirrored.canSwitchStartingPoint());

		assertFalse(waveDiagonalPathMedium.canSwitchStartingPoint());
		assertFalse(waveDiagonalPathMediumEmptyArrowhead.canSwitchStartingPoint());
		assertFalse(waveDiagonalPathMediumSchemaArrowhead.canSwitchStartingPoint());
		assertFalse(waveDiagonalPathMediumMirrored.canSwitchStartingPoint());
		assertFalse(waveDiagonalPathMediumEmptyArrowheadMirrored.canSwitchStartingPoint());
		assertFalse(waveDiagonalPathMediumSchemaArrowheadMirrored.canSwitchStartingPoint());

		assertFalse(waveDiagonalPathLarge.canSwitchStartingPoint());
		assertFalse(waveDiagonalPathLargeEmptyArrowhead.canSwitchStartingPoint());
		assertFalse(waveDiagonalPathLargeSchemaArrowhead.canSwitchStartingPoint());
		assertFalse(waveDiagonalPathLargeMirrored.canSwitchStartingPoint());
		assertFalse(waveDiagonalPathLargeEmptyArrowheadMirrored.canSwitchStartingPoint());
		assertFalse(waveDiagonalPathLargeSchemaArrowheadMirrored.canSwitchStartingPoint());

	}

	@Override
	public void testSwitchStartingPoint() {

	}

	@Override
	public void testCanSwitchPlane() {

		assertTrue(curveHitsFrontWall.canSwitchPlane());
		assertTrue(curveHitsFrontWallEmptyArrowhead.canSwitchPlane());
		assertTrue(curveHitsFrontWallSchemaArrowhead.canSwitchPlane());

		assertTrue(humpHitsFrontWall.canSwitchPlane());
		assertTrue(humpHitsFrontWallEmptyArrowhead.canSwitchPlane());
		assertTrue(humpHitsFrontWallSchemaArrowhead.canSwitchPlane());

		assertTrue(loopHitsFrontWall.canSwitchPlane());
		assertTrue(loopHitsFrontWallEmptyArrowhead.canSwitchPlane());
		assertTrue(loopHitsFrontWallSchemaArrowhead.canSwitchPlane());

		assertTrue(waveHitsFrontWall.canSwitchPlane());
		assertTrue(waveHitsFrontWallEmptyArrowhead.canSwitchPlane());
		assertTrue(waveHitsFrontWallSchemaArrowhead.canSwitchPlane());

		assertFalse(rotationSingleHitsFrontWall.canSwitchPlane());
		assertFalse(rotationSingleHitsFrontWallEmptyArrowhead.canSwitchPlane());
		assertFalse(rotationSingleHitsFrontWallSchemaArrowhead.canSwitchPlane());

		assertFalse(rotationDoubleHitsFrontWall.canSwitchPlane());
		assertFalse(rotationDoubleHitsFrontWallEmptyArrowhead.canSwitchPlane());
		assertFalse(rotationDoubleHitsFrontWallSchemaArrowhead.canSwitchPlane());

		assertFalse(rotationAlternatingHitsFrontWall.canSwitchPlane());
		assertFalse(rotationAlternatingHitsFrontWallEmptyArrowhead.canSwitchPlane());
		assertFalse(rotationAlternatingHitsFrontWallSchemaArrowhead.canSwitchPlane());

		assertFalse(curveHitsChest.canSwitchPlane());
		assertFalse(curveHitsChestEmptyArrowhead.canSwitchPlane());
		assertFalse(curveHitsChestSchemaArrowhead.canSwitchPlane());

		assertFalse(humpHitsChest.canSwitchPlane());
		assertFalse(humpHitsChestEmptyArrowhead.canSwitchPlane());
		assertFalse(humpHitsChestSchemaArrowhead.canSwitchPlane());

		assertFalse(loopHitsChest.canSwitchPlane());
		assertFalse(loopHitsChestEmptyArrowhead.canSwitchPlane());
		assertFalse(loopHitsChestSchemaArrowhead.canSwitchPlane());

		assertFalse(waveHitsChest.canSwitchPlane());
		assertFalse(waveHitsChestEmptyArrowhead.canSwitchPlane());
		assertFalse(waveHitsChestSchemaArrowhead.canSwitchPlane());

		assertFalse(rotationSingleHitsChest.canSwitchPlane());
		assertFalse(rotationSingleHitsChestEmptyArrowhead.canSwitchPlane());
		assertFalse(rotationSingleHitsChestSchemaArrowhead.canSwitchPlane());

		assertFalse(rotationDoubleHitsChest.canSwitchPlane());
		assertFalse(rotationDoubleHitsChestEmptyArrowhead.canSwitchPlane());
		assertFalse(rotationDoubleHitsChestSchemaArrowhead.canSwitchPlane());

		assertFalse(rotationAlternatingHitsChest.canSwitchPlane());
		assertFalse(rotationAlternatingHitsChestEmptyArrowhead.canSwitchPlane());
		assertFalse(rotationAlternatingHitsChestSchemaArrowhead.canSwitchPlane());

		assertFalse(waveDiagonalPathSmall.canSwitchPlane());
		assertFalse(waveDiagonalPathSmallEmptyArrowhead.canSwitchPlane());
		assertFalse(waveDiagonalPathSmallSchemaArrowhead.canSwitchPlane());
		assertFalse(waveDiagonalPathSmallMirrored.canSwitchPlane());
		assertFalse(waveDiagonalPathSmallEmptyArrowheadMirrored.canSwitchPlane());
		assertFalse(waveDiagonalPathSmallSchemaArrowheadMirrored.canSwitchPlane());

		assertFalse(waveDiagonalPathMedium.canSwitchPlane());
		assertFalse(waveDiagonalPathMediumEmptyArrowhead.canSwitchPlane());
		assertFalse(waveDiagonalPathMediumSchemaArrowhead.canSwitchPlane());
		assertFalse(waveDiagonalPathMediumMirrored.canSwitchPlane());
		assertFalse(waveDiagonalPathMediumEmptyArrowheadMirrored.canSwitchPlane());
		assertFalse(waveDiagonalPathMediumSchemaArrowheadMirrored.canSwitchPlane());

		assertFalse(waveDiagonalPathLarge.canSwitchPlane());
		assertFalse(waveDiagonalPathLargeEmptyArrowhead.canSwitchPlane());
		assertFalse(waveDiagonalPathLargeSchemaArrowhead.canSwitchPlane());
		assertFalse(waveDiagonalPathLargeMirrored.canSwitchPlane());
		assertFalse(waveDiagonalPathLargeEmptyArrowheadMirrored.canSwitchPlane());
		assertFalse(waveDiagonalPathLargeSchemaArrowheadMirrored.canSwitchPlane());

	}

	@Override
	public void testSwitchPlane() {
		curveHitsFrontWall.switchPlane();
		assertEquals(symbolFactory.createSymbol("02-09-001-01-01-07"), curveHitsFrontWall.getSymbol());
		curveHitsFrontWallEmptyArrowhead.switchPlane();
		assertEquals(symbolFactory.createSymbol("02-09-001-01-02-07"), curveHitsFrontWallEmptyArrowhead.getSymbol());
		curveHitsFrontWallSchemaArrowhead.switchPlane();
		assertEquals(symbolFactory.createSymbol("02-09-001-01-03-07"), curveHitsFrontWallSchemaArrowhead.getSymbol());

		humpHitsFrontWall.switchPlane();
		assertEquals(symbolFactory.createSymbol("02-09-002-01-01-07"), humpHitsFrontWall.getSymbol());
		humpHitsFrontWallEmptyArrowhead.switchPlane();
		assertEquals(symbolFactory.createSymbol("02-09-002-01-02-07"), humpHitsFrontWallEmptyArrowhead.getSymbol());
		humpHitsFrontWallSchemaArrowhead.switchPlane();
		assertEquals(symbolFactory.createSymbol("02-09-002-01-03-07"), humpHitsFrontWallSchemaArrowhead.getSymbol());

		loopHitsFrontWall.switchPlane();
		assertEquals(symbolFactory.createSymbol("02-09-003-01-01-07"), loopHitsFrontWall.getSymbol());
		loopHitsFrontWallEmptyArrowhead.switchPlane();
		assertEquals(symbolFactory.createSymbol("02-09-003-01-02-07"), loopHitsFrontWallEmptyArrowhead.getSymbol());
		loopHitsFrontWallSchemaArrowhead.switchPlane();
		assertEquals(symbolFactory.createSymbol("02-09-003-01-03-07"), loopHitsFrontWallSchemaArrowhead.getSymbol());

		waveHitsFrontWall.switchPlane();
		assertEquals(symbolFactory.createSymbol("02-09-004-02-01-07"), waveHitsFrontWall.getSymbol());
		waveHitsFrontWallEmptyArrowhead.switchPlane();
		assertEquals(symbolFactory.createSymbol("02-09-004-02-02-07"), waveHitsFrontWallEmptyArrowhead.getSymbol());
		waveHitsFrontWallSchemaArrowhead.switchPlane();
		assertEquals(symbolFactory.createSymbol("02-09-004-02-03-07"), waveHitsFrontWallSchemaArrowhead.getSymbol());

	}

}
