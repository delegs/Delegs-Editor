package de.signWritingEditor.client.model.material.positionedMovementSymbols;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import de.signWritingEditor.shared.model.domainValue.Symbol;
import de.signWritingEditor.shared.model.material.MovementBaseSymbol;
import de.signWritingEditor.shared.model.material.PositionedMovementSymbol;
import de.signWritingEditor.shared.model.material.SymbolFactory;

public class StraightDiagonalPlaneMovementSymbolTest implements PositionedMovementSymbolTestInterface {

	/**
	 * straightDiagonalPlane movement symbols group 02, symbolId 04
	 */
	private PositionedMovementSymbol diagonalAwayMovementSmall;
	private PositionedMovementSymbol diagonalAwayMovementSmallEmptyArrowhead;
	private PositionedMovementSymbol diagonalAwayMovementSmallSchemaArrowhead;

	private PositionedMovementSymbol diagonalAwayMovementMedium;
	private PositionedMovementSymbol diagonalAwayMovementMediumEmptyArrowhead;
	private PositionedMovementSymbol diagonalAwayMovementMediumSchemaArrowhead;

	private PositionedMovementSymbol diagonalAwayMovementLarge;
	private PositionedMovementSymbol diagonalAwayMovementLargeEmptyArrowhead;
	private PositionedMovementSymbol diagonalAwayMovementLargeSchemaArrowhead;

	private PositionedMovementSymbol diagonalAwayMovementLargest;
	private PositionedMovementSymbol diagonalAwayMovementLargestEmptyArrowhead;
	private PositionedMovementSymbol diagonalAwayMovementLargestSchemaArrowhead;

	private PositionedMovementSymbol diagonalTowardsMovementSmall;
	private PositionedMovementSymbol diagonalTowardsMovementSmallEmptyArrowhead;
	private PositionedMovementSymbol diagonalTowardsMovementSmallSchemaArrowhead;

	private PositionedMovementSymbol diagonalTowardsMovementMedium;
	private PositionedMovementSymbol diagonalTowardsMovementMediumEmptyArrowhead;
	private PositionedMovementSymbol diagonalTowardsMovementMediumSchemaArrowhead;

	private PositionedMovementSymbol diagonalTowardsMovementLarge;
	private PositionedMovementSymbol diagonalTowardsMovementLargeEmptyArrowhead;
	private PositionedMovementSymbol diagonalTowardsMovementLargeSchemaArrowhead;

	private PositionedMovementSymbol diagonalTowardsMovementLargest;
	private PositionedMovementSymbol diagonalTowardsMovementLargestEmptyArrowhead;
	private PositionedMovementSymbol diagonalTowardsMovementLargestSchemaArrowhead;

	private PositionedMovementSymbol diagonalBetweenAwaySmall;
	private PositionedMovementSymbol diagonalBetweenAwaySmallEmptyArrowhead;
	private PositionedMovementSymbol diagonalBetweenAwaySmallSchemaArrowhead;

	private PositionedMovementSymbol diagonalBetweenAwayMedium;
	private PositionedMovementSymbol diagonalBetweenAwayMediumEmptyArrowhead;
	private PositionedMovementSymbol diagonalBetweenAwayMediumSchemaArrowhead;

	private PositionedMovementSymbol diagonalBetweenAwayLarge;
	private PositionedMovementSymbol diagonalBetweenAwayLargeEmptyArrowhead;
	private PositionedMovementSymbol diagonalBetweenAwayLargeSchemaArrowhead;

	private PositionedMovementSymbol diagonalBetweenAwayLargest;
	private PositionedMovementSymbol diagonalBetweenAwayLargestEmptyArrowhead;
	private PositionedMovementSymbol diagonalBetweenAwayLargestSchemaArrowhead;

	private PositionedMovementSymbol diagonalBetweenTowardsSmall;
	private PositionedMovementSymbol diagonalBetweenTowardsSmallEmptyArrowhead;
	private PositionedMovementSymbol diagonalBetweenTowardsSmallSchemaArrowhead;

	private PositionedMovementSymbol diagonalBetweenTowardsMedium;
	private PositionedMovementSymbol diagonalBetweenTowardsMediumEmptyArrowhead;
	private PositionedMovementSymbol diagonalBetweenTowardsMediumSchemaArrowhead;

	private PositionedMovementSymbol diagonalBetweenTowardsLarge;
	private PositionedMovementSymbol diagonalBetweenTowardsLargeEmptyArrowhead;
	private PositionedMovementSymbol diagonalBetweenTowardsLargeSchemaArrowhead;

	private PositionedMovementSymbol diagonalBetweenTowardsLargest;
	private PositionedMovementSymbol diagonalBetweenTowardsLargestEmptyArrowhead;
	private PositionedMovementSymbol diagonalBetweenTowardsLargestSchemaArrowhead;

	private SymbolFactory symbolFactory;

	@Override
	public void setUp(SymbolFactory symbolFactory) {

		this.symbolFactory = symbolFactory;

		diagonalAwayMovementSmall = new PositionedMovementSymbol(
				MovementBaseSymbol.DIAGONAL_AWAY_MOVEMENT_SMALL.getIswaSymbol(), 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						MovementBaseSymbol.DIAGONAL_AWAY_MOVEMENT_SMALL.getIswaSymbol().getBaseSymbol()));
		Symbol diagonalAwayMovementSmallEmptyArrowheadSymbol = symbolFactory.createSymbol("02-04-001-01-02-01");
		diagonalAwayMovementSmallEmptyArrowhead = new PositionedMovementSymbol(
				diagonalAwayMovementSmallEmptyArrowheadSymbol, 0, 0, 0, symbolFactory
						.getAllRotationsAndFillsFor(diagonalAwayMovementSmallEmptyArrowheadSymbol.getBaseSymbol()));
		Symbol diagonalAwayMovementSmallSchemaArrowheadSymbol = symbolFactory.createSymbol("02-04-001-01-03-01");
		diagonalAwayMovementSmallSchemaArrowhead = new PositionedMovementSymbol(
				diagonalAwayMovementSmallSchemaArrowheadSymbol, 0, 0, 2, symbolFactory
						.getAllRotationsAndFillsFor(diagonalAwayMovementSmallSchemaArrowheadSymbol.getBaseSymbol()));

		diagonalAwayMovementMedium = new PositionedMovementSymbol(
				MovementBaseSymbol.DIAGONAL_AWAY_MOVEMENT_MEDIUM.getIswaSymbol(), 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						MovementBaseSymbol.DIAGONAL_AWAY_MOVEMENT_MEDIUM.getIswaSymbol().getBaseSymbol()));
		Symbol diagonalAwayMovementMediumEmptyArrowheadSymbol = symbolFactory.createSymbol("02-04-001-02-02-01");
		diagonalAwayMovementMediumEmptyArrowhead = new PositionedMovementSymbol(
				diagonalAwayMovementMediumEmptyArrowheadSymbol, 0, 0, 0, symbolFactory
						.getAllRotationsAndFillsFor(diagonalAwayMovementMediumEmptyArrowheadSymbol.getBaseSymbol()));
		Symbol diagonalAwayMovementMediumSchemaArrowheadSymbol = symbolFactory.createSymbol("02-04-001-02-03-01");
		diagonalAwayMovementMediumSchemaArrowhead = new PositionedMovementSymbol(
				diagonalAwayMovementMediumSchemaArrowheadSymbol, 0, 0, 2, symbolFactory
						.getAllRotationsAndFillsFor(diagonalAwayMovementMediumSchemaArrowheadSymbol.getBaseSymbol()));

		diagonalAwayMovementLarge = new PositionedMovementSymbol(
				MovementBaseSymbol.DIAGONAL_AWAY_MOVEMENT_LARGE.getIswaSymbol(), 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						MovementBaseSymbol.DIAGONAL_AWAY_MOVEMENT_LARGE.getIswaSymbol().getBaseSymbol()));
		Symbol diagonalAwayMovementLargeEmptyArrowheadSymbol = symbolFactory.createSymbol("02-04-001-03-02-01");
		diagonalAwayMovementLargeEmptyArrowhead = new PositionedMovementSymbol(
				diagonalAwayMovementLargeEmptyArrowheadSymbol, 0, 0, 0, symbolFactory
						.getAllRotationsAndFillsFor(diagonalAwayMovementLargeEmptyArrowheadSymbol.getBaseSymbol()));
		Symbol diagonalAwayMovementLargeSchemaArrowheadSymbol = symbolFactory.createSymbol("02-04-001-03-03-01");
		diagonalAwayMovementLargeSchemaArrowhead = new PositionedMovementSymbol(
				diagonalAwayMovementLargeSchemaArrowheadSymbol, 0, 0, 2, symbolFactory
						.getAllRotationsAndFillsFor(diagonalAwayMovementLargeSchemaArrowheadSymbol.getBaseSymbol()));

		diagonalAwayMovementLargest = new PositionedMovementSymbol(
				MovementBaseSymbol.DIAGONAL_AWAY_MOVEMENT_LARGEST.getIswaSymbol(), 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						MovementBaseSymbol.DIAGONAL_AWAY_MOVEMENT_LARGEST.getIswaSymbol().getBaseSymbol()));
		Symbol diagonalAwayMovementLargestEmptyArrowheadSymbol = symbolFactory.createSymbol("02-04-001-04-02-01");
		diagonalAwayMovementLargestEmptyArrowhead = new PositionedMovementSymbol(
				diagonalAwayMovementLargestEmptyArrowheadSymbol, 0, 0, 0, symbolFactory
						.getAllRotationsAndFillsFor(diagonalAwayMovementLargestEmptyArrowheadSymbol.getBaseSymbol()));
		Symbol diagonalAwayMovementLargestSchemaArrowheadSymbol = symbolFactory.createSymbol("02-04-001-04-03-01");
		diagonalAwayMovementLargestSchemaArrowhead = new PositionedMovementSymbol(
				diagonalAwayMovementLargestSchemaArrowheadSymbol, 0, 0, 2, symbolFactory
						.getAllRotationsAndFillsFor(diagonalAwayMovementLargestSchemaArrowheadSymbol.getBaseSymbol()));

		diagonalTowardsMovementSmall = new PositionedMovementSymbol(
				MovementBaseSymbol.DIAGONAL_TOWARDS_MOVEMENT_SMALL.getIswaSymbol(), 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						MovementBaseSymbol.DIAGONAL_TOWARDS_MOVEMENT_SMALL.getIswaSymbol().getBaseSymbol()));
		Symbol diagonalTowardsMovementSmallEmptyArrowheadSymbol = symbolFactory.createSymbol("02-04-002-01-02-01");
		diagonalTowardsMovementSmallEmptyArrowhead = new PositionedMovementSymbol(
				diagonalTowardsMovementSmallEmptyArrowheadSymbol, 0, 0, 0, symbolFactory
						.getAllRotationsAndFillsFor(diagonalTowardsMovementSmallEmptyArrowheadSymbol.getBaseSymbol()));
		Symbol diagonalTowardsMovementSmallSchemaArrowheadSymbol = symbolFactory.createSymbol("02-04-002-01-03-01");
		diagonalTowardsMovementSmallSchemaArrowhead = new PositionedMovementSymbol(
				diagonalTowardsMovementSmallSchemaArrowheadSymbol, 0, 0, 2, symbolFactory
						.getAllRotationsAndFillsFor(diagonalTowardsMovementSmallSchemaArrowheadSymbol.getBaseSymbol()));

		diagonalTowardsMovementMedium = new PositionedMovementSymbol(
				MovementBaseSymbol.DIAGONAL_TOWARDS_MOVEMENT_MEDIUM.getIswaSymbol(), 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						MovementBaseSymbol.DIAGONAL_TOWARDS_MOVEMENT_MEDIUM.getIswaSymbol().getBaseSymbol()));
		Symbol diagonalTowardsMovementMediumEmptyArrowheadSymbol = symbolFactory.createSymbol("02-04-002-02-02-01");
		diagonalTowardsMovementMediumEmptyArrowhead = new PositionedMovementSymbol(
				diagonalTowardsMovementMediumEmptyArrowheadSymbol, 0, 0, 0, symbolFactory
						.getAllRotationsAndFillsFor(diagonalTowardsMovementMediumEmptyArrowheadSymbol.getBaseSymbol()));
		Symbol diagonalTowardsMovementMediumSchemaArrowheadSymbol = symbolFactory.createSymbol("02-04-002-02-03-01");
		diagonalTowardsMovementMediumSchemaArrowhead = new PositionedMovementSymbol(
				diagonalTowardsMovementMediumSchemaArrowheadSymbol, 0, 0, 2, symbolFactory.getAllRotationsAndFillsFor(
						diagonalTowardsMovementMediumSchemaArrowheadSymbol.getBaseSymbol()));

		diagonalTowardsMovementLarge = new PositionedMovementSymbol(
				MovementBaseSymbol.DIAGONAL_TOWARDS_MOVEMENT_LARGE.getIswaSymbol(), 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						MovementBaseSymbol.DIAGONAL_TOWARDS_MOVEMENT_LARGE.getIswaSymbol().getBaseSymbol()));
		Symbol diagonalTowardsMovementLargeEmptyArrowheadSymbol = symbolFactory.createSymbol("02-04-002-03-02-01");
		diagonalTowardsMovementLargeEmptyArrowhead = new PositionedMovementSymbol(
				diagonalTowardsMovementLargeEmptyArrowheadSymbol, 0, 0, 0, symbolFactory
						.getAllRotationsAndFillsFor(diagonalTowardsMovementLargeEmptyArrowheadSymbol.getBaseSymbol()));
		Symbol diagonalTowardsMovementLargeSchemaArrowheadSymbol = symbolFactory.createSymbol("02-04-002-03-03-01");
		diagonalTowardsMovementLargeSchemaArrowhead = new PositionedMovementSymbol(
				diagonalTowardsMovementLargeSchemaArrowheadSymbol, 0, 0, 2, symbolFactory
						.getAllRotationsAndFillsFor(diagonalTowardsMovementLargeSchemaArrowheadSymbol.getBaseSymbol()));

		diagonalTowardsMovementLargest = new PositionedMovementSymbol(
				MovementBaseSymbol.DIAGONAL_TOWARDS_MOVEMENT_LARGEST.getIswaSymbol(), 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						MovementBaseSymbol.DIAGONAL_TOWARDS_MOVEMENT_LARGEST.getIswaSymbol().getBaseSymbol()));
		Symbol diagonalTowardsMovementLargestEmptyArrowheadSymbol = symbolFactory.createSymbol("02-04-002-04-02-01");
		diagonalTowardsMovementLargestEmptyArrowhead = new PositionedMovementSymbol(
				diagonalTowardsMovementLargestEmptyArrowheadSymbol, 0, 0, 0, symbolFactory.getAllRotationsAndFillsFor(
						diagonalTowardsMovementLargestEmptyArrowheadSymbol.getBaseSymbol()));
		Symbol diagonalTowardsMovementLargestSchemaArrowheadSymbol = symbolFactory.createSymbol("02-04-002-04-03-01");
		diagonalTowardsMovementLargestSchemaArrowhead = new PositionedMovementSymbol(
				diagonalTowardsMovementLargestSchemaArrowheadSymbol, 0, 0, 2, symbolFactory.getAllRotationsAndFillsFor(
						diagonalTowardsMovementLargestSchemaArrowheadSymbol.getBaseSymbol()));

		diagonalBetweenAwaySmall = new PositionedMovementSymbol(
				MovementBaseSymbol.DIAGONAL_BETWEEN_AWAY_SMALL.getIswaSymbol(), 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						MovementBaseSymbol.DIAGONAL_BETWEEN_AWAY_SMALL.getIswaSymbol().getBaseSymbol()));
		Symbol diagonalBetweenAwayMovementSmallEmptyArrowheadSymbol = symbolFactory.createSymbol("02-04-003-01-02-01");
		diagonalBetweenAwaySmallEmptyArrowhead = new PositionedMovementSymbol(
				diagonalBetweenAwayMovementSmallEmptyArrowheadSymbol, 0, 0, 0, symbolFactory.getAllRotationsAndFillsFor(
						diagonalBetweenAwayMovementSmallEmptyArrowheadSymbol.getBaseSymbol()));
		Symbol diagonalBetweenAwayMovementSmallSchemaArrowheadSymbol = symbolFactory.createSymbol("02-04-003-01-03-01");
		diagonalBetweenAwaySmallSchemaArrowhead = new PositionedMovementSymbol(
				diagonalBetweenAwayMovementSmallSchemaArrowheadSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						diagonalBetweenAwayMovementSmallSchemaArrowheadSymbol.getBaseSymbol()));

		diagonalBetweenAwayMedium = new PositionedMovementSymbol(
				MovementBaseSymbol.DIAGONAL_BETWEEN_AWAY_MEDIUM.getIswaSymbol(), 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						MovementBaseSymbol.DIAGONAL_BETWEEN_AWAY_MEDIUM.getIswaSymbol().getBaseSymbol()));
		Symbol diagonalBetweenAwayMovementMediumEmptyArrowheadSymbol = symbolFactory.createSymbol("02-04-003-02-02-01");
		diagonalBetweenAwayMediumEmptyArrowhead = new PositionedMovementSymbol(
				diagonalBetweenAwayMovementMediumEmptyArrowheadSymbol, 0, 0, 0,
				symbolFactory.getAllRotationsAndFillsFor(
						diagonalBetweenAwayMovementMediumEmptyArrowheadSymbol.getBaseSymbol()));
		Symbol diagonalBetweenAwayMovementMediumSchemaArrowheadSymbol = symbolFactory
				.createSymbol("02-04-003-02-03-01");
		diagonalBetweenAwayMediumSchemaArrowhead = new PositionedMovementSymbol(
				diagonalBetweenAwayMovementMediumSchemaArrowheadSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						diagonalBetweenAwayMovementMediumSchemaArrowheadSymbol.getBaseSymbol()));

		diagonalBetweenAwayLarge = new PositionedMovementSymbol(
				MovementBaseSymbol.DIAGONAL_BETWEEN_AWAY_LARGE.getIswaSymbol(), 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						MovementBaseSymbol.DIAGONAL_BETWEEN_AWAY_LARGE.getIswaSymbol().getBaseSymbol()));
		Symbol diagonalBetweenAwayMovementLargeEmptyArrowheadSymbol = symbolFactory.createSymbol("02-04-003-03-02-01");
		diagonalBetweenAwayLargeEmptyArrowhead = new PositionedMovementSymbol(
				diagonalBetweenAwayMovementLargeEmptyArrowheadSymbol, 0, 0, 0, symbolFactory.getAllRotationsAndFillsFor(
						diagonalBetweenAwayMovementLargeEmptyArrowheadSymbol.getBaseSymbol()));
		Symbol diagonalBetweenAwayMovementLargeSchemaArrowheadSymbol = symbolFactory.createSymbol("02-04-003-03-03-01");
		diagonalBetweenAwayLargeSchemaArrowhead = new PositionedMovementSymbol(
				diagonalBetweenAwayMovementLargeSchemaArrowheadSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						diagonalBetweenAwayMovementLargeSchemaArrowheadSymbol.getBaseSymbol()));

		diagonalBetweenAwayLargest = new PositionedMovementSymbol(
				MovementBaseSymbol.DIAGONAL_BETWEEN_AWAY_LARGEST.getIswaSymbol(), 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						MovementBaseSymbol.DIAGONAL_BETWEEN_AWAY_LARGEST.getIswaSymbol().getBaseSymbol()));
		Symbol diagonalBetweenAwayMovementLargestEmptyArrowheadSymbol = symbolFactory
				.createSymbol("02-04-003-04-02-01");
		diagonalBetweenAwayLargestEmptyArrowhead = new PositionedMovementSymbol(
				diagonalBetweenAwayMovementLargestEmptyArrowheadSymbol, 0, 0, 0,
				symbolFactory.getAllRotationsAndFillsFor(
						diagonalBetweenAwayMovementLargestEmptyArrowheadSymbol.getBaseSymbol()));
		Symbol diagonalBetweenAwayMovementLargestSchemaArrowheadSymbol = symbolFactory
				.createSymbol("02-04-003-04-03-01");
		diagonalBetweenAwayLargestSchemaArrowhead = new PositionedMovementSymbol(
				diagonalBetweenAwayMovementLargestSchemaArrowheadSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						diagonalBetweenAwayMovementLargestSchemaArrowheadSymbol.getBaseSymbol()));

		diagonalBetweenTowardsSmall = new PositionedMovementSymbol(
				MovementBaseSymbol.DIAGONAL_BETWEEN_TOWARDS_SMALL.getIswaSymbol(), 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						MovementBaseSymbol.DIAGONAL_BETWEEN_TOWARDS_SMALL.getIswaSymbol().getBaseSymbol()));
		Symbol diagonalBetweenTowardsMovementSmallEmptyArrowheadSymbol = symbolFactory
				.createSymbol("02-04-004-01-02-01");
		diagonalBetweenTowardsSmallEmptyArrowhead = new PositionedMovementSymbol(
				diagonalBetweenTowardsMovementSmallEmptyArrowheadSymbol, 0, 0, 0,
				symbolFactory.getAllRotationsAndFillsFor(
						diagonalBetweenTowardsMovementSmallEmptyArrowheadSymbol.getBaseSymbol()));
		Symbol diagonalBetweenTowardsMovementSmallSchemaArrowheadSymbol = symbolFactory
				.createSymbol("02-04-004-01-03-01");
		diagonalBetweenTowardsSmallSchemaArrowhead = new PositionedMovementSymbol(
				diagonalBetweenTowardsMovementSmallSchemaArrowheadSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						diagonalBetweenTowardsMovementSmallSchemaArrowheadSymbol.getBaseSymbol()));

		diagonalBetweenTowardsMedium = new PositionedMovementSymbol(
				MovementBaseSymbol.DIAGONAL_BETWEEN_TOWARDS_MEDIUM.getIswaSymbol(), 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						MovementBaseSymbol.DIAGONAL_BETWEEN_TOWARDS_MEDIUM.getIswaSymbol().getBaseSymbol()));
		Symbol diagonalBetweenTowardsMovementMediumEmptyArrowheadSymbol = symbolFactory
				.createSymbol("02-04-004-02-02-01");
		diagonalBetweenTowardsMediumEmptyArrowhead = new PositionedMovementSymbol(
				diagonalBetweenTowardsMovementMediumEmptyArrowheadSymbol, 0, 0, 0,
				symbolFactory.getAllRotationsAndFillsFor(
						diagonalBetweenTowardsMovementMediumEmptyArrowheadSymbol.getBaseSymbol()));
		Symbol diagonalBetweenTowardsMovementMediumSchemaArrowheadSymbol = symbolFactory
				.createSymbol("02-04-004-02-03-01");
		diagonalBetweenTowardsMediumSchemaArrowhead = new PositionedMovementSymbol(
				diagonalBetweenTowardsMovementMediumSchemaArrowheadSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						diagonalBetweenTowardsMovementMediumSchemaArrowheadSymbol.getBaseSymbol()));

		diagonalBetweenTowardsLarge = new PositionedMovementSymbol(
				MovementBaseSymbol.DIAGONAL_BETWEEN_TOWARDS_LARGE.getIswaSymbol(), 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						MovementBaseSymbol.DIAGONAL_BETWEEN_TOWARDS_LARGE.getIswaSymbol().getBaseSymbol()));
		Symbol diagonalBetweenTowardsMovementLargeEmptyArrowheadSymbol = symbolFactory
				.createSymbol("02-04-004-03-02-01");
		diagonalBetweenTowardsLargeEmptyArrowhead = new PositionedMovementSymbol(
				diagonalBetweenTowardsMovementLargeEmptyArrowheadSymbol, 0, 0, 0,
				symbolFactory.getAllRotationsAndFillsFor(
						diagonalBetweenTowardsMovementLargeEmptyArrowheadSymbol.getBaseSymbol()));
		Symbol diagonalBetweenTowardsMovementLargeSchemaArrowheadSymbol = symbolFactory
				.createSymbol("02-04-004-03-03-01");
		diagonalBetweenTowardsLargeSchemaArrowhead = new PositionedMovementSymbol(
				diagonalBetweenTowardsMovementLargeSchemaArrowheadSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						diagonalBetweenTowardsMovementLargeSchemaArrowheadSymbol.getBaseSymbol()));

		diagonalBetweenTowardsLargest = new PositionedMovementSymbol(
				MovementBaseSymbol.DIAGONAL_BETWEEN_TOWARDS_LARGEST.getIswaSymbol(), 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						MovementBaseSymbol.DIAGONAL_BETWEEN_TOWARDS_LARGEST.getIswaSymbol().getBaseSymbol()));
		Symbol diagonalBetweenTowardsMovementLargestEmptyArrowheadSymbol = symbolFactory
				.createSymbol("02-04-004-04-02-01");
		diagonalBetweenTowardsLargestEmptyArrowhead = new PositionedMovementSymbol(
				diagonalBetweenTowardsMovementLargestEmptyArrowheadSymbol, 0, 0, 0,
				symbolFactory.getAllRotationsAndFillsFor(
						diagonalBetweenTowardsMovementLargestEmptyArrowheadSymbol.getBaseSymbol()));
		Symbol diagonalBetweenTowardsMovementLargestSchemaArrowheadSymbol = symbolFactory
				.createSymbol("02-04-004-04-03-01");
		diagonalBetweenTowardsLargestSchemaArrowhead = new PositionedMovementSymbol(
				diagonalBetweenTowardsMovementLargestSchemaArrowheadSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						diagonalBetweenTowardsMovementLargestSchemaArrowheadSymbol.getBaseSymbol()));

	}

	@Override
	public void testCanIncrease() {

		assertFalse(diagonalAwayMovementSmall.canIncrease());
		assertFalse(diagonalAwayMovementSmallEmptyArrowhead.canIncrease());
		assertFalse(diagonalAwayMovementSmallSchemaArrowhead.canIncrease());

		assertFalse(diagonalAwayMovementMedium.canIncrease());
		assertFalse(diagonalAwayMovementMediumEmptyArrowhead.canIncrease());
		assertFalse(diagonalAwayMovementMediumSchemaArrowhead.canIncrease());

		assertFalse(diagonalAwayMovementLarge.canIncrease());
		assertFalse(diagonalAwayMovementLargeEmptyArrowhead.canIncrease());
		assertFalse(diagonalAwayMovementLargeSchemaArrowhead.canIncrease());

		assertFalse(diagonalAwayMovementLargest.canIncrease());
		assertFalse(diagonalAwayMovementLargestEmptyArrowhead.canIncrease());
		assertFalse(diagonalAwayMovementLargestSchemaArrowhead.canIncrease());

		assertFalse(diagonalTowardsMovementSmall.canIncrease());
		assertFalse(diagonalTowardsMovementSmallEmptyArrowhead.canIncrease());
		assertFalse(diagonalTowardsMovementSmallSchemaArrowhead.canIncrease());

		assertFalse(diagonalTowardsMovementMedium.canIncrease());
		assertFalse(diagonalTowardsMovementMediumEmptyArrowhead.canIncrease());
		assertFalse(diagonalTowardsMovementMediumSchemaArrowhead.canIncrease());

		assertFalse(diagonalTowardsMovementLarge.canIncrease());
		assertFalse(diagonalTowardsMovementLargeEmptyArrowhead.canIncrease());
		assertFalse(diagonalTowardsMovementLargeSchemaArrowhead.canIncrease());

		assertFalse(diagonalTowardsMovementLargest.canIncrease());
		assertFalse(diagonalTowardsMovementLargestEmptyArrowhead.canIncrease());
		assertFalse(diagonalTowardsMovementLargestSchemaArrowhead.canIncrease());

		assertFalse(diagonalBetweenAwaySmall.canIncrease());
		assertFalse(diagonalBetweenAwaySmallEmptyArrowhead.canIncrease());
		assertFalse(diagonalBetweenAwaySmallSchemaArrowhead.canIncrease());

		assertFalse(diagonalBetweenAwayMedium.canIncrease());
		assertFalse(diagonalBetweenAwayMediumEmptyArrowhead.canIncrease());
		assertFalse(diagonalBetweenAwayMediumSchemaArrowhead.canIncrease());

		assertFalse(diagonalBetweenAwayLarge.canIncrease());
		assertFalse(diagonalBetweenAwayLargeEmptyArrowhead.canIncrease());
		assertFalse(diagonalBetweenAwayLargeSchemaArrowhead.canIncrease());

		assertFalse(diagonalBetweenAwayLargest.canIncrease());
		assertFalse(diagonalBetweenAwayLargestEmptyArrowhead.canIncrease());
		assertFalse(diagonalBetweenAwayLargestSchemaArrowhead.canIncrease());

		assertFalse(diagonalBetweenTowardsSmall.canIncrease());
		assertFalse(diagonalBetweenTowardsSmallEmptyArrowhead.canIncrease());
		assertFalse(diagonalBetweenTowardsSmallSchemaArrowhead.canIncrease());

		assertFalse(diagonalBetweenTowardsMedium.canIncrease());
		assertFalse(diagonalBetweenTowardsMediumEmptyArrowhead.canIncrease());
		assertFalse(diagonalBetweenTowardsMediumSchemaArrowhead.canIncrease());

		assertFalse(diagonalBetweenTowardsLarge.canIncrease());
		assertFalse(diagonalBetweenTowardsLargeEmptyArrowhead.canIncrease());
		assertFalse(diagonalBetweenTowardsLargeSchemaArrowhead.canIncrease());

		assertFalse(diagonalBetweenTowardsLargest.canIncrease());
		assertFalse(diagonalBetweenTowardsLargestEmptyArrowhead.canIncrease());
		assertFalse(diagonalBetweenTowardsLargestSchemaArrowhead.canIncrease());

	}

	@Override
	public void testIncrease() {

	}

	@Override
	public void testCanDecrease() {
		assertFalse(diagonalAwayMovementSmall.canDecrease());
		assertFalse(diagonalAwayMovementSmallEmptyArrowhead.canDecrease());
		assertFalse(diagonalAwayMovementSmallSchemaArrowhead.canDecrease());

		assertFalse(diagonalAwayMovementMedium.canDecrease());
		assertFalse(diagonalAwayMovementMediumEmptyArrowhead.canDecrease());
		assertFalse(diagonalAwayMovementMediumSchemaArrowhead.canDecrease());

		assertFalse(diagonalAwayMovementLarge.canDecrease());
		assertFalse(diagonalAwayMovementLargeEmptyArrowhead.canDecrease());
		assertFalse(diagonalAwayMovementLargeSchemaArrowhead.canDecrease());

		assertFalse(diagonalAwayMovementLargest.canDecrease());
		assertFalse(diagonalAwayMovementLargestEmptyArrowhead.canDecrease());
		assertFalse(diagonalAwayMovementLargestSchemaArrowhead.canDecrease());

		assertFalse(diagonalTowardsMovementSmall.canDecrease());
		assertFalse(diagonalTowardsMovementSmallEmptyArrowhead.canDecrease());
		assertFalse(diagonalTowardsMovementSmallSchemaArrowhead.canDecrease());

		assertFalse(diagonalTowardsMovementMedium.canDecrease());
		assertFalse(diagonalTowardsMovementMediumEmptyArrowhead.canDecrease());
		assertFalse(diagonalTowardsMovementMediumSchemaArrowhead.canDecrease());

		assertFalse(diagonalTowardsMovementLarge.canDecrease());
		assertFalse(diagonalTowardsMovementLargeEmptyArrowhead.canDecrease());
		assertFalse(diagonalTowardsMovementLargeSchemaArrowhead.canDecrease());

		assertFalse(diagonalTowardsMovementLargest.canDecrease());
		assertFalse(diagonalTowardsMovementLargestEmptyArrowhead.canDecrease());
		assertFalse(diagonalTowardsMovementLargestSchemaArrowhead.canDecrease());

		assertFalse(diagonalBetweenAwaySmall.canDecrease());
		assertFalse(diagonalBetweenAwaySmallEmptyArrowhead.canDecrease());
		assertFalse(diagonalBetweenAwaySmallSchemaArrowhead.canDecrease());

		assertFalse(diagonalBetweenAwayMedium.canDecrease());
		assertFalse(diagonalBetweenAwayMediumEmptyArrowhead.canDecrease());
		assertFalse(diagonalBetweenAwayMediumSchemaArrowhead.canDecrease());

		assertFalse(diagonalBetweenAwayLarge.canDecrease());
		assertFalse(diagonalBetweenAwayLargeEmptyArrowhead.canDecrease());
		assertFalse(diagonalBetweenAwayLargeSchemaArrowhead.canDecrease());

		assertFalse(diagonalBetweenAwayLargest.canDecrease());
		assertFalse(diagonalBetweenAwayLargestEmptyArrowhead.canDecrease());
		assertFalse(diagonalBetweenAwayLargestSchemaArrowhead.canDecrease());

		assertFalse(diagonalBetweenTowardsSmall.canDecrease());
		assertFalse(diagonalBetweenTowardsSmallEmptyArrowhead.canDecrease());
		assertFalse(diagonalBetweenTowardsSmallSchemaArrowhead.canDecrease());

		assertFalse(diagonalBetweenTowardsMedium.canDecrease());
		assertFalse(diagonalBetweenTowardsMediumEmptyArrowhead.canDecrease());
		assertFalse(diagonalBetweenTowardsMediumSchemaArrowhead.canDecrease());

		assertFalse(diagonalBetweenTowardsLarge.canDecrease());
		assertFalse(diagonalBetweenTowardsLargeEmptyArrowhead.canDecrease());
		assertFalse(diagonalBetweenTowardsLargeSchemaArrowhead.canDecrease());

		assertFalse(diagonalBetweenTowardsLargest.canDecrease());
		assertFalse(diagonalBetweenTowardsLargestEmptyArrowhead.canDecrease());
		assertFalse(diagonalBetweenTowardsLargestSchemaArrowhead.canDecrease());

	}

	@Override
	public void testDecrease() {

	}

	@Override
	public void testCanRotate() {

		assertTrue(diagonalAwayMovementSmall.canRotate());
		assertTrue(diagonalAwayMovementSmallEmptyArrowhead.canRotate());
		assertTrue(diagonalAwayMovementSmallSchemaArrowhead.canRotate());

		assertTrue(diagonalAwayMovementMedium.canRotate());
		assertTrue(diagonalAwayMovementMediumEmptyArrowhead.canRotate());
		assertTrue(diagonalAwayMovementMediumSchemaArrowhead.canRotate());

		assertTrue(diagonalAwayMovementLarge.canRotate());
		assertTrue(diagonalAwayMovementLargeEmptyArrowhead.canRotate());
		assertTrue(diagonalAwayMovementLargeSchemaArrowhead.canRotate());

		assertTrue(diagonalAwayMovementLargest.canRotate());
		assertTrue(diagonalAwayMovementLargestEmptyArrowhead.canRotate());
		assertTrue(diagonalAwayMovementLargestSchemaArrowhead.canRotate());

		assertTrue(diagonalTowardsMovementSmall.canRotate());
		assertTrue(diagonalTowardsMovementSmallEmptyArrowhead.canRotate());
		assertTrue(diagonalTowardsMovementSmallSchemaArrowhead.canRotate());

		assertTrue(diagonalTowardsMovementMedium.canRotate());
		assertTrue(diagonalTowardsMovementMediumEmptyArrowhead.canRotate());
		assertTrue(diagonalTowardsMovementMediumSchemaArrowhead.canRotate());

		assertTrue(diagonalTowardsMovementLarge.canRotate());
		assertTrue(diagonalTowardsMovementLargeEmptyArrowhead.canRotate());
		assertTrue(diagonalTowardsMovementLargeSchemaArrowhead.canRotate());

		assertTrue(diagonalTowardsMovementLargest.canRotate());
		assertTrue(diagonalTowardsMovementLargestEmptyArrowhead.canRotate());
		assertTrue(diagonalTowardsMovementLargestSchemaArrowhead.canRotate());

		assertTrue(diagonalBetweenAwaySmall.canRotate());
		assertTrue(diagonalBetweenAwaySmallEmptyArrowhead.canRotate());
		assertTrue(diagonalBetweenAwaySmallSchemaArrowhead.canRotate());

		assertTrue(diagonalBetweenAwayMedium.canRotate());
		assertTrue(diagonalBetweenAwayMediumEmptyArrowhead.canRotate());
		assertTrue(diagonalBetweenAwayMediumSchemaArrowhead.canRotate());

		assertTrue(diagonalBetweenAwayLarge.canRotate());
		assertTrue(diagonalBetweenAwayLargeEmptyArrowhead.canRotate());
		assertTrue(diagonalBetweenAwayLargeSchemaArrowhead.canRotate());

		assertTrue(diagonalBetweenAwayLargest.canRotate());
		assertTrue(diagonalBetweenAwayLargestEmptyArrowhead.canRotate());
		assertTrue(diagonalBetweenAwayLargestSchemaArrowhead.canRotate());

		assertTrue(diagonalBetweenTowardsSmall.canRotate());
		assertTrue(diagonalBetweenTowardsSmallEmptyArrowhead.canRotate());
		assertTrue(diagonalBetweenTowardsSmallSchemaArrowhead.canRotate());

		assertTrue(diagonalBetweenTowardsMedium.canRotate());
		assertTrue(diagonalBetweenTowardsMediumEmptyArrowhead.canRotate());
		assertTrue(diagonalBetweenTowardsMediumSchemaArrowhead.canRotate());

		assertTrue(diagonalBetweenTowardsLarge.canRotate());
		assertTrue(diagonalBetweenTowardsLargeEmptyArrowhead.canRotate());
		assertTrue(diagonalBetweenTowardsLargeSchemaArrowhead.canRotate());

		assertTrue(diagonalBetweenTowardsLargest.canRotate());
		assertTrue(diagonalBetweenTowardsLargestEmptyArrowhead.canRotate());
		assertTrue(diagonalBetweenTowardsLargestSchemaArrowhead.canRotate());

	}

	@Override
	public void testRotateClockwise() {

		diagonalAwayMovementSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-001-01-01-08"), diagonalAwayMovementSmall.getSymbol());
		diagonalAwayMovementSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-001-01-01-06"), diagonalAwayMovementSmall.getSymbol());
		diagonalAwayMovementSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-001-01-01-05"), diagonalAwayMovementSmall.getSymbol());
		diagonalAwayMovementSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-001-01-01-04"), diagonalAwayMovementSmall.getSymbol());
		diagonalAwayMovementSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-001-01-01-02"), diagonalAwayMovementSmall.getSymbol());
		diagonalAwayMovementSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-001-01-01-01"), diagonalAwayMovementSmall.getSymbol());

		diagonalAwayMovementSmallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-001-01-02-08"),
				diagonalAwayMovementSmallEmptyArrowhead.getSymbol());
		diagonalAwayMovementSmallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-001-01-02-06"),
				diagonalAwayMovementSmallEmptyArrowhead.getSymbol());
		diagonalAwayMovementSmallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-001-01-02-05"),
				diagonalAwayMovementSmallEmptyArrowhead.getSymbol());
		diagonalAwayMovementSmallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-001-01-02-04"),
				diagonalAwayMovementSmallEmptyArrowhead.getSymbol());
		diagonalAwayMovementSmallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-001-01-02-02"),
				diagonalAwayMovementSmallEmptyArrowhead.getSymbol());
		diagonalAwayMovementSmallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-001-01-02-01"),
				diagonalAwayMovementSmallEmptyArrowhead.getSymbol());

		diagonalAwayMovementSmallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-001-01-03-08"),
				diagonalAwayMovementSmallSchemaArrowhead.getSymbol());
		diagonalAwayMovementSmallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-001-01-03-06"),
				diagonalAwayMovementSmallSchemaArrowhead.getSymbol());
		diagonalAwayMovementSmallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-001-01-03-05"),
				diagonalAwayMovementSmallSchemaArrowhead.getSymbol());
		diagonalAwayMovementSmallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-001-01-03-04"),
				diagonalAwayMovementSmallSchemaArrowhead.getSymbol());
		diagonalAwayMovementSmallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-001-01-03-02"),
				diagonalAwayMovementSmallSchemaArrowhead.getSymbol());
		diagonalAwayMovementSmallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-001-01-03-01"),
				diagonalAwayMovementSmallSchemaArrowhead.getSymbol());

		diagonalAwayMovementMedium.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-001-02-01-08"), diagonalAwayMovementMedium.getSymbol());
		diagonalAwayMovementMedium.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-001-02-01-06"), diagonalAwayMovementMedium.getSymbol());
		diagonalAwayMovementMedium.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-001-02-01-05"), diagonalAwayMovementMedium.getSymbol());
		diagonalAwayMovementMedium.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-001-02-01-04"), diagonalAwayMovementMedium.getSymbol());
		diagonalAwayMovementMedium.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-001-02-01-02"), diagonalAwayMovementMedium.getSymbol());
		diagonalAwayMovementMedium.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-001-02-01-01"), diagonalAwayMovementMedium.getSymbol());

		diagonalAwayMovementMediumEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-001-02-02-08"),
				diagonalAwayMovementMediumEmptyArrowhead.getSymbol());
		diagonalAwayMovementMediumEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-001-02-02-06"),
				diagonalAwayMovementMediumEmptyArrowhead.getSymbol());
		diagonalAwayMovementMediumEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-001-02-02-05"),
				diagonalAwayMovementMediumEmptyArrowhead.getSymbol());
		diagonalAwayMovementMediumEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-001-02-02-04"),
				diagonalAwayMovementMediumEmptyArrowhead.getSymbol());
		diagonalAwayMovementMediumEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-001-02-02-02"),
				diagonalAwayMovementMediumEmptyArrowhead.getSymbol());
		diagonalAwayMovementMediumEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-001-02-02-01"),
				diagonalAwayMovementMediumEmptyArrowhead.getSymbol());

		diagonalAwayMovementMediumSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-001-02-03-08"),
				diagonalAwayMovementMediumSchemaArrowhead.getSymbol());
		diagonalAwayMovementMediumSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-001-02-03-06"),
				diagonalAwayMovementMediumSchemaArrowhead.getSymbol());
		diagonalAwayMovementMediumSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-001-02-03-05"),
				diagonalAwayMovementMediumSchemaArrowhead.getSymbol());
		diagonalAwayMovementMediumSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-001-02-03-04"),
				diagonalAwayMovementMediumSchemaArrowhead.getSymbol());
		diagonalAwayMovementMediumSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-001-02-03-02"),
				diagonalAwayMovementMediumSchemaArrowhead.getSymbol());
		diagonalAwayMovementMediumSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-001-02-03-01"),
				diagonalAwayMovementMediumSchemaArrowhead.getSymbol());

		diagonalAwayMovementLarge.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-001-03-01-08"), diagonalAwayMovementLarge.getSymbol());
		diagonalAwayMovementLarge.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-001-03-01-06"), diagonalAwayMovementLarge.getSymbol());
		diagonalAwayMovementLarge.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-001-03-01-05"), diagonalAwayMovementLarge.getSymbol());
		diagonalAwayMovementLarge.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-001-03-01-04"), diagonalAwayMovementLarge.getSymbol());
		diagonalAwayMovementLarge.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-001-03-01-02"), diagonalAwayMovementLarge.getSymbol());
		diagonalAwayMovementLarge.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-001-03-01-01"), diagonalAwayMovementLarge.getSymbol());

		diagonalAwayMovementLargeEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-001-03-02-08"),
				diagonalAwayMovementLargeEmptyArrowhead.getSymbol());
		diagonalAwayMovementLargeEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-001-03-02-06"),
				diagonalAwayMovementLargeEmptyArrowhead.getSymbol());
		diagonalAwayMovementLargeEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-001-03-02-05"),
				diagonalAwayMovementLargeEmptyArrowhead.getSymbol());
		diagonalAwayMovementLargeEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-001-03-02-04"),
				diagonalAwayMovementLargeEmptyArrowhead.getSymbol());
		diagonalAwayMovementLargeEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-001-03-02-02"),
				diagonalAwayMovementLargeEmptyArrowhead.getSymbol());
		diagonalAwayMovementLargeEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-001-03-02-01"),
				diagonalAwayMovementLargeEmptyArrowhead.getSymbol());

		diagonalAwayMovementLargeSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-001-03-03-08"),
				diagonalAwayMovementLargeSchemaArrowhead.getSymbol());
		diagonalAwayMovementLargeSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-001-03-03-06"),
				diagonalAwayMovementLargeSchemaArrowhead.getSymbol());
		diagonalAwayMovementLargeSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-001-03-03-05"),
				diagonalAwayMovementLargeSchemaArrowhead.getSymbol());
		diagonalAwayMovementLargeSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-001-03-03-04"),
				diagonalAwayMovementLargeSchemaArrowhead.getSymbol());
		diagonalAwayMovementLargeSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-001-03-03-02"),
				diagonalAwayMovementLargeSchemaArrowhead.getSymbol());
		diagonalAwayMovementLargeSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-001-03-03-01"),
				diagonalAwayMovementLargeSchemaArrowhead.getSymbol());

		diagonalAwayMovementLargest.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-001-04-01-08"), diagonalAwayMovementLargest.getSymbol());
		diagonalAwayMovementLargest.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-001-04-01-06"), diagonalAwayMovementLargest.getSymbol());
		diagonalAwayMovementLargest.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-001-04-01-05"), diagonalAwayMovementLargest.getSymbol());
		diagonalAwayMovementLargest.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-001-04-01-04"), diagonalAwayMovementLargest.getSymbol());
		diagonalAwayMovementLargest.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-001-04-01-02"), diagonalAwayMovementLargest.getSymbol());
		diagonalAwayMovementLargest.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-001-04-01-01"), diagonalAwayMovementLargest.getSymbol());

		diagonalAwayMovementLargestEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-001-04-02-08"),
				diagonalAwayMovementLargestEmptyArrowhead.getSymbol());
		diagonalAwayMovementLargestEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-001-04-02-06"),
				diagonalAwayMovementLargestEmptyArrowhead.getSymbol());
		diagonalAwayMovementLargestEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-001-04-02-05"),
				diagonalAwayMovementLargestEmptyArrowhead.getSymbol());
		diagonalAwayMovementLargestEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-001-04-02-04"),
				diagonalAwayMovementLargestEmptyArrowhead.getSymbol());
		diagonalAwayMovementLargestEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-001-04-02-02"),
				diagonalAwayMovementLargestEmptyArrowhead.getSymbol());
		diagonalAwayMovementLargestEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-001-04-02-01"),
				diagonalAwayMovementLargestEmptyArrowhead.getSymbol());

		diagonalAwayMovementLargestSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-001-04-03-08"),
				diagonalAwayMovementLargestSchemaArrowhead.getSymbol());
		diagonalAwayMovementLargestSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-001-04-03-06"),
				diagonalAwayMovementLargestSchemaArrowhead.getSymbol());
		diagonalAwayMovementLargestSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-001-04-03-05"),
				diagonalAwayMovementLargestSchemaArrowhead.getSymbol());
		diagonalAwayMovementLargestSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-001-04-03-04"),
				diagonalAwayMovementLargestSchemaArrowhead.getSymbol());
		diagonalAwayMovementLargestSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-001-04-03-02"),
				diagonalAwayMovementLargestSchemaArrowhead.getSymbol());
		diagonalAwayMovementLargestSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-001-04-03-01"),
				diagonalAwayMovementLargestSchemaArrowhead.getSymbol());

		diagonalTowardsMovementSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-002-01-01-08"), diagonalTowardsMovementSmall.getSymbol());
		diagonalTowardsMovementSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-002-01-01-06"), diagonalTowardsMovementSmall.getSymbol());
		diagonalTowardsMovementSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-002-01-01-05"), diagonalTowardsMovementSmall.getSymbol());
		diagonalTowardsMovementSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-002-01-01-04"), diagonalTowardsMovementSmall.getSymbol());
		diagonalTowardsMovementSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-002-01-01-02"), diagonalTowardsMovementSmall.getSymbol());
		diagonalTowardsMovementSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-002-01-01-01"), diagonalTowardsMovementSmall.getSymbol());

		diagonalTowardsMovementSmallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-002-01-02-08"),
				diagonalTowardsMovementSmallEmptyArrowhead.getSymbol());
		diagonalTowardsMovementSmallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-002-01-02-06"),
				diagonalTowardsMovementSmallEmptyArrowhead.getSymbol());
		diagonalTowardsMovementSmallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-002-01-02-05"),
				diagonalTowardsMovementSmallEmptyArrowhead.getSymbol());
		diagonalTowardsMovementSmallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-002-01-02-04"),
				diagonalTowardsMovementSmallEmptyArrowhead.getSymbol());
		diagonalTowardsMovementSmallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-002-01-02-02"),
				diagonalTowardsMovementSmallEmptyArrowhead.getSymbol());
		diagonalTowardsMovementSmallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-002-01-02-01"),
				diagonalTowardsMovementSmallEmptyArrowhead.getSymbol());

		diagonalTowardsMovementSmallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-002-01-03-08"),
				diagonalTowardsMovementSmallSchemaArrowhead.getSymbol());
		diagonalTowardsMovementSmallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-002-01-03-06"),
				diagonalTowardsMovementSmallSchemaArrowhead.getSymbol());
		diagonalTowardsMovementSmallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-002-01-03-05"),
				diagonalTowardsMovementSmallSchemaArrowhead.getSymbol());
		diagonalTowardsMovementSmallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-002-01-03-04"),
				diagonalTowardsMovementSmallSchemaArrowhead.getSymbol());
		diagonalTowardsMovementSmallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-002-01-03-02"),
				diagonalTowardsMovementSmallSchemaArrowhead.getSymbol());
		diagonalTowardsMovementSmallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-002-01-03-01"),
				diagonalTowardsMovementSmallSchemaArrowhead.getSymbol());

		diagonalTowardsMovementMedium.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-002-02-01-08"), diagonalTowardsMovementMedium.getSymbol());
		diagonalTowardsMovementMedium.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-002-02-01-06"), diagonalTowardsMovementMedium.getSymbol());
		diagonalTowardsMovementMedium.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-002-02-01-05"), diagonalTowardsMovementMedium.getSymbol());
		diagonalTowardsMovementMedium.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-002-02-01-04"), diagonalTowardsMovementMedium.getSymbol());
		diagonalTowardsMovementMedium.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-002-02-01-02"), diagonalTowardsMovementMedium.getSymbol());
		diagonalTowardsMovementMedium.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-002-02-01-01"), diagonalTowardsMovementMedium.getSymbol());

		diagonalTowardsMovementMediumEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-002-02-02-08"),
				diagonalTowardsMovementMediumEmptyArrowhead.getSymbol());
		diagonalTowardsMovementMediumEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-002-02-02-06"),
				diagonalTowardsMovementMediumEmptyArrowhead.getSymbol());
		diagonalTowardsMovementMediumEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-002-02-02-05"),
				diagonalTowardsMovementMediumEmptyArrowhead.getSymbol());
		diagonalTowardsMovementMediumEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-002-02-02-04"),
				diagonalTowardsMovementMediumEmptyArrowhead.getSymbol());
		diagonalTowardsMovementMediumEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-002-02-02-02"),
				diagonalTowardsMovementMediumEmptyArrowhead.getSymbol());
		diagonalTowardsMovementMediumEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-002-02-02-01"),
				diagonalTowardsMovementMediumEmptyArrowhead.getSymbol());

		diagonalTowardsMovementMediumSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-002-02-03-08"),
				diagonalTowardsMovementMediumSchemaArrowhead.getSymbol());
		diagonalTowardsMovementMediumSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-002-02-03-06"),
				diagonalTowardsMovementMediumSchemaArrowhead.getSymbol());
		diagonalTowardsMovementMediumSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-002-02-03-05"),
				diagonalTowardsMovementMediumSchemaArrowhead.getSymbol());
		diagonalTowardsMovementMediumSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-002-02-03-04"),
				diagonalTowardsMovementMediumSchemaArrowhead.getSymbol());
		diagonalTowardsMovementMediumSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-002-02-03-02"),
				diagonalTowardsMovementMediumSchemaArrowhead.getSymbol());
		diagonalTowardsMovementMediumSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-002-02-03-01"),
				diagonalTowardsMovementMediumSchemaArrowhead.getSymbol());

		diagonalTowardsMovementLarge.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-002-03-01-08"), diagonalTowardsMovementLarge.getSymbol());
		diagonalTowardsMovementLarge.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-002-03-01-06"), diagonalTowardsMovementLarge.getSymbol());
		diagonalTowardsMovementLarge.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-002-03-01-05"), diagonalTowardsMovementLarge.getSymbol());
		diagonalTowardsMovementLarge.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-002-03-01-04"), diagonalTowardsMovementLarge.getSymbol());
		diagonalTowardsMovementLarge.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-002-03-01-02"), diagonalTowardsMovementLarge.getSymbol());
		diagonalTowardsMovementLarge.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-002-03-01-01"), diagonalTowardsMovementLarge.getSymbol());

		diagonalTowardsMovementLargeEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-002-03-02-08"),
				diagonalTowardsMovementLargeEmptyArrowhead.getSymbol());
		diagonalTowardsMovementLargeEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-002-03-02-06"),
				diagonalTowardsMovementLargeEmptyArrowhead.getSymbol());
		diagonalTowardsMovementLargeEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-002-03-02-05"),
				diagonalTowardsMovementLargeEmptyArrowhead.getSymbol());
		diagonalTowardsMovementLargeEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-002-03-02-04"),
				diagonalTowardsMovementLargeEmptyArrowhead.getSymbol());
		diagonalTowardsMovementLargeEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-002-03-02-02"),
				diagonalTowardsMovementLargeEmptyArrowhead.getSymbol());
		diagonalTowardsMovementLargeEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-002-03-02-01"),
				diagonalTowardsMovementLargeEmptyArrowhead.getSymbol());

		diagonalTowardsMovementLargeSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-002-03-03-08"),
				diagonalTowardsMovementLargeSchemaArrowhead.getSymbol());
		diagonalTowardsMovementLargeSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-002-03-03-06"),
				diagonalTowardsMovementLargeSchemaArrowhead.getSymbol());
		diagonalTowardsMovementLargeSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-002-03-03-05"),
				diagonalTowardsMovementLargeSchemaArrowhead.getSymbol());
		diagonalTowardsMovementLargeSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-002-03-03-04"),
				diagonalTowardsMovementLargeSchemaArrowhead.getSymbol());
		diagonalTowardsMovementLargeSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-002-03-03-02"),
				diagonalTowardsMovementLargeSchemaArrowhead.getSymbol());
		diagonalTowardsMovementLargeSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-002-03-03-01"),
				diagonalTowardsMovementLargeSchemaArrowhead.getSymbol());

		diagonalTowardsMovementLargest.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-002-04-01-08"), diagonalTowardsMovementLargest.getSymbol());
		diagonalTowardsMovementLargest.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-002-04-01-06"), diagonalTowardsMovementLargest.getSymbol());
		diagonalTowardsMovementLargest.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-002-04-01-05"), diagonalTowardsMovementLargest.getSymbol());
		diagonalTowardsMovementLargest.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-002-04-01-04"), diagonalTowardsMovementLargest.getSymbol());
		diagonalTowardsMovementLargest.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-002-04-01-02"), diagonalTowardsMovementLargest.getSymbol());
		diagonalTowardsMovementLargest.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-002-04-01-01"), diagonalTowardsMovementLargest.getSymbol());

		diagonalTowardsMovementLargestEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-002-04-02-08"),
				diagonalTowardsMovementLargestEmptyArrowhead.getSymbol());
		diagonalTowardsMovementLargestEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-002-04-02-06"),
				diagonalTowardsMovementLargestEmptyArrowhead.getSymbol());
		diagonalTowardsMovementLargestEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-002-04-02-05"),
				diagonalTowardsMovementLargestEmptyArrowhead.getSymbol());
		diagonalTowardsMovementLargestEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-002-04-02-04"),
				diagonalTowardsMovementLargestEmptyArrowhead.getSymbol());
		diagonalTowardsMovementLargestEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-002-04-02-02"),
				diagonalTowardsMovementLargestEmptyArrowhead.getSymbol());
		diagonalTowardsMovementLargestEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-002-04-02-01"),
				diagonalTowardsMovementLargestEmptyArrowhead.getSymbol());

		diagonalTowardsMovementLargestSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-002-04-03-08"),
				diagonalTowardsMovementLargestSchemaArrowhead.getSymbol());
		diagonalTowardsMovementLargestSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-002-04-03-06"),
				diagonalTowardsMovementLargestSchemaArrowhead.getSymbol());
		diagonalTowardsMovementLargestSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-002-04-03-05"),
				diagonalTowardsMovementLargestSchemaArrowhead.getSymbol());
		diagonalTowardsMovementLargestSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-002-04-03-04"),
				diagonalTowardsMovementLargestSchemaArrowhead.getSymbol());
		diagonalTowardsMovementLargestSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-002-04-03-02"),
				diagonalTowardsMovementLargestSchemaArrowhead.getSymbol());
		diagonalTowardsMovementLargestSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-002-04-03-01"),
				diagonalTowardsMovementLargestSchemaArrowhead.getSymbol());

		diagonalBetweenAwaySmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-003-01-01-08"), diagonalBetweenAwaySmall.getSymbol());
		diagonalBetweenAwaySmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-003-01-01-06"), diagonalBetweenAwaySmall.getSymbol());
		diagonalBetweenAwaySmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-003-01-01-05"), diagonalBetweenAwaySmall.getSymbol());
		diagonalBetweenAwaySmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-003-01-01-04"), diagonalBetweenAwaySmall.getSymbol());
		diagonalBetweenAwaySmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-003-01-01-02"), diagonalBetweenAwaySmall.getSymbol());
		diagonalBetweenAwaySmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-003-01-01-01"), diagonalBetweenAwaySmall.getSymbol());

		diagonalBetweenAwaySmallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-003-01-02-08"),
				diagonalBetweenAwaySmallEmptyArrowhead.getSymbol());
		diagonalBetweenAwaySmallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-003-01-02-06"),
				diagonalBetweenAwaySmallEmptyArrowhead.getSymbol());
		diagonalBetweenAwaySmallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-003-01-02-05"),
				diagonalBetweenAwaySmallEmptyArrowhead.getSymbol());
		diagonalBetweenAwaySmallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-003-01-02-04"),
				diagonalBetweenAwaySmallEmptyArrowhead.getSymbol());
		diagonalBetweenAwaySmallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-003-01-02-02"),
				diagonalBetweenAwaySmallEmptyArrowhead.getSymbol());
		diagonalBetweenAwaySmallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-003-01-02-01"),
				diagonalBetweenAwaySmallEmptyArrowhead.getSymbol());

		diagonalBetweenAwaySmallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-003-01-03-08"),
				diagonalBetweenAwaySmallSchemaArrowhead.getSymbol());
		diagonalBetweenAwaySmallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-003-01-03-06"),
				diagonalBetweenAwaySmallSchemaArrowhead.getSymbol());
		diagonalBetweenAwaySmallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-003-01-03-05"),
				diagonalBetweenAwaySmallSchemaArrowhead.getSymbol());
		diagonalBetweenAwaySmallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-003-01-03-04"),
				diagonalBetweenAwaySmallSchemaArrowhead.getSymbol());
		diagonalBetweenAwaySmallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-003-01-03-02"),
				diagonalBetweenAwaySmallSchemaArrowhead.getSymbol());
		diagonalBetweenAwaySmallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-003-01-03-01"),
				diagonalBetweenAwaySmallSchemaArrowhead.getSymbol());

		diagonalBetweenAwayMedium.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-003-02-01-08"), diagonalBetweenAwayMedium.getSymbol());
		diagonalBetweenAwayMedium.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-003-02-01-06"), diagonalBetweenAwayMedium.getSymbol());
		diagonalBetweenAwayMedium.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-003-02-01-05"), diagonalBetweenAwayMedium.getSymbol());
		diagonalBetweenAwayMedium.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-003-02-01-04"), diagonalBetweenAwayMedium.getSymbol());
		diagonalBetweenAwayMedium.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-003-02-01-02"), diagonalBetweenAwayMedium.getSymbol());
		diagonalBetweenAwayMedium.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-003-02-01-01"), diagonalBetweenAwayMedium.getSymbol());

		diagonalBetweenAwayMediumEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-003-02-02-08"),
				diagonalBetweenAwayMediumEmptyArrowhead.getSymbol());
		diagonalBetweenAwayMediumEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-003-02-02-06"),
				diagonalBetweenAwayMediumEmptyArrowhead.getSymbol());
		diagonalBetweenAwayMediumEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-003-02-02-05"),
				diagonalBetweenAwayMediumEmptyArrowhead.getSymbol());
		diagonalBetweenAwayMediumEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-003-02-02-04"),
				diagonalBetweenAwayMediumEmptyArrowhead.getSymbol());
		diagonalBetweenAwayMediumEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-003-02-02-02"),
				diagonalBetweenAwayMediumEmptyArrowhead.getSymbol());
		diagonalBetweenAwayMediumEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-003-02-02-01"),
				diagonalBetweenAwayMediumEmptyArrowhead.getSymbol());

		diagonalBetweenAwayMediumSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-003-02-03-08"),
				diagonalBetweenAwayMediumSchemaArrowhead.getSymbol());
		diagonalBetweenAwayMediumSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-003-02-03-06"),
				diagonalBetweenAwayMediumSchemaArrowhead.getSymbol());
		diagonalBetweenAwayMediumSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-003-02-03-05"),
				diagonalBetweenAwayMediumSchemaArrowhead.getSymbol());
		diagonalBetweenAwayMediumSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-003-02-03-04"),
				diagonalBetweenAwayMediumSchemaArrowhead.getSymbol());
		diagonalBetweenAwayMediumSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-003-02-03-02"),
				diagonalBetweenAwayMediumSchemaArrowhead.getSymbol());
		diagonalBetweenAwayMediumSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-003-02-03-01"),
				diagonalBetweenAwayMediumSchemaArrowhead.getSymbol());

		diagonalBetweenAwayLarge.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-003-03-01-08"), diagonalBetweenAwayLarge.getSymbol());
		diagonalBetweenAwayLarge.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-003-03-01-06"), diagonalBetweenAwayLarge.getSymbol());
		diagonalBetweenAwayLarge.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-003-03-01-05"), diagonalBetweenAwayLarge.getSymbol());
		diagonalBetweenAwayLarge.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-003-03-01-04"), diagonalBetweenAwayLarge.getSymbol());
		diagonalBetweenAwayLarge.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-003-03-01-02"), diagonalBetweenAwayLarge.getSymbol());
		diagonalBetweenAwayLarge.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-003-03-01-01"), diagonalBetweenAwayLarge.getSymbol());

		diagonalBetweenAwayLargeEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-003-03-02-08"),
				diagonalBetweenAwayLargeEmptyArrowhead.getSymbol());
		diagonalBetweenAwayLargeEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-003-03-02-06"),
				diagonalBetweenAwayLargeEmptyArrowhead.getSymbol());
		diagonalBetweenAwayLargeEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-003-03-02-05"),
				diagonalBetweenAwayLargeEmptyArrowhead.getSymbol());
		diagonalBetweenAwayLargeEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-003-03-02-04"),
				diagonalBetweenAwayLargeEmptyArrowhead.getSymbol());
		diagonalBetweenAwayLargeEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-003-03-02-02"),
				diagonalBetweenAwayLargeEmptyArrowhead.getSymbol());
		diagonalBetweenAwayLargeEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-003-03-02-01"),
				diagonalBetweenAwayLargeEmptyArrowhead.getSymbol());

		diagonalBetweenAwayLargeSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-003-03-03-08"),
				diagonalBetweenAwayLargeSchemaArrowhead.getSymbol());
		diagonalBetweenAwayLargeSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-003-03-03-06"),
				diagonalBetweenAwayLargeSchemaArrowhead.getSymbol());
		diagonalBetweenAwayLargeSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-003-03-03-05"),
				diagonalBetweenAwayLargeSchemaArrowhead.getSymbol());
		diagonalBetweenAwayLargeSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-003-03-03-04"),
				diagonalBetweenAwayLargeSchemaArrowhead.getSymbol());
		diagonalBetweenAwayLargeSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-003-03-03-02"),
				diagonalBetweenAwayLargeSchemaArrowhead.getSymbol());
		diagonalBetweenAwayLargeSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-003-03-03-01"),
				diagonalBetweenAwayLargeSchemaArrowhead.getSymbol());

		diagonalBetweenAwayLargest.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-003-04-01-08"), diagonalBetweenAwayLargest.getSymbol());
		diagonalBetweenAwayLargest.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-003-04-01-06"), diagonalBetweenAwayLargest.getSymbol());
		diagonalBetweenAwayLargest.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-003-04-01-05"), diagonalBetweenAwayLargest.getSymbol());
		diagonalBetweenAwayLargest.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-003-04-01-04"), diagonalBetweenAwayLargest.getSymbol());
		diagonalBetweenAwayLargest.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-003-04-01-02"), diagonalBetweenAwayLargest.getSymbol());
		diagonalBetweenAwayLargest.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-003-04-01-01"), diagonalBetweenAwayLargest.getSymbol());

		diagonalBetweenAwayLargestEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-003-04-02-08"),
				diagonalBetweenAwayLargestEmptyArrowhead.getSymbol());
		diagonalBetweenAwayLargestEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-003-04-02-06"),
				diagonalBetweenAwayLargestEmptyArrowhead.getSymbol());
		diagonalBetweenAwayLargestEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-003-04-02-05"),
				diagonalBetweenAwayLargestEmptyArrowhead.getSymbol());
		diagonalBetweenAwayLargestEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-003-04-02-04"),
				diagonalBetweenAwayLargestEmptyArrowhead.getSymbol());
		diagonalBetweenAwayLargestEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-003-04-02-02"),
				diagonalBetweenAwayLargestEmptyArrowhead.getSymbol());
		diagonalBetweenAwayLargestEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-003-04-02-01"),
				diagonalBetweenAwayLargestEmptyArrowhead.getSymbol());

		diagonalBetweenAwayLargestSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-003-04-03-08"),
				diagonalBetweenAwayLargestSchemaArrowhead.getSymbol());
		diagonalBetweenAwayLargestSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-003-04-03-06"),
				diagonalBetweenAwayLargestSchemaArrowhead.getSymbol());
		diagonalBetweenAwayLargestSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-003-04-03-05"),
				diagonalBetweenAwayLargestSchemaArrowhead.getSymbol());
		diagonalBetweenAwayLargestSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-003-04-03-04"),
				diagonalBetweenAwayLargestSchemaArrowhead.getSymbol());
		diagonalBetweenAwayLargestSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-003-04-03-02"),
				diagonalBetweenAwayLargestSchemaArrowhead.getSymbol());
		diagonalBetweenAwayLargestSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-003-04-03-01"),
				diagonalBetweenAwayLargestSchemaArrowhead.getSymbol());

		diagonalBetweenTowardsSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-004-01-01-08"), diagonalBetweenTowardsSmall.getSymbol());
		diagonalBetweenTowardsSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-004-01-01-06"), diagonalBetweenTowardsSmall.getSymbol());
		diagonalBetweenTowardsSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-004-01-01-05"), diagonalBetweenTowardsSmall.getSymbol());
		diagonalBetweenTowardsSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-004-01-01-04"), diagonalBetweenTowardsSmall.getSymbol());
		diagonalBetweenTowardsSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-004-01-01-02"), diagonalBetweenTowardsSmall.getSymbol());
		diagonalBetweenTowardsSmall.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-004-01-01-01"), diagonalBetweenTowardsSmall.getSymbol());

		diagonalBetweenTowardsSmallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-004-01-02-08"),
				diagonalBetweenTowardsSmallEmptyArrowhead.getSymbol());
		diagonalBetweenTowardsSmallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-004-01-02-06"),
				diagonalBetweenTowardsSmallEmptyArrowhead.getSymbol());
		diagonalBetweenTowardsSmallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-004-01-02-05"),
				diagonalBetweenTowardsSmallEmptyArrowhead.getSymbol());
		diagonalBetweenTowardsSmallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-004-01-02-04"),
				diagonalBetweenTowardsSmallEmptyArrowhead.getSymbol());
		diagonalBetweenTowardsSmallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-004-01-02-02"),
				diagonalBetweenTowardsSmallEmptyArrowhead.getSymbol());
		diagonalBetweenTowardsSmallEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-004-01-02-01"),
				diagonalBetweenTowardsSmallEmptyArrowhead.getSymbol());

		diagonalBetweenTowardsSmallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-004-01-03-08"),
				diagonalBetweenTowardsSmallSchemaArrowhead.getSymbol());
		diagonalBetweenTowardsSmallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-004-01-03-06"),
				diagonalBetweenTowardsSmallSchemaArrowhead.getSymbol());
		diagonalBetweenTowardsSmallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-004-01-03-05"),
				diagonalBetweenTowardsSmallSchemaArrowhead.getSymbol());
		diagonalBetweenTowardsSmallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-004-01-03-04"),
				diagonalBetweenTowardsSmallSchemaArrowhead.getSymbol());
		diagonalBetweenTowardsSmallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-004-01-03-02"),
				diagonalBetweenTowardsSmallSchemaArrowhead.getSymbol());
		diagonalBetweenTowardsSmallSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-004-01-03-01"),
				diagonalBetweenTowardsSmallSchemaArrowhead.getSymbol());

		diagonalBetweenTowardsMedium.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-004-02-01-08"), diagonalBetweenTowardsMedium.getSymbol());
		diagonalBetweenTowardsMedium.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-004-02-01-06"), diagonalBetweenTowardsMedium.getSymbol());
		diagonalBetweenTowardsMedium.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-004-02-01-05"), diagonalBetweenTowardsMedium.getSymbol());
		diagonalBetweenTowardsMedium.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-004-02-01-04"), diagonalBetweenTowardsMedium.getSymbol());
		diagonalBetweenTowardsMedium.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-004-02-01-02"), diagonalBetweenTowardsMedium.getSymbol());
		diagonalBetweenTowardsMedium.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-004-02-01-01"), diagonalBetweenTowardsMedium.getSymbol());

		diagonalBetweenTowardsMediumEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-004-02-02-08"),
				diagonalBetweenTowardsMediumEmptyArrowhead.getSymbol());
		diagonalBetweenTowardsMediumEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-004-02-02-06"),
				diagonalBetweenTowardsMediumEmptyArrowhead.getSymbol());
		diagonalBetweenTowardsMediumEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-004-02-02-05"),
				diagonalBetweenTowardsMediumEmptyArrowhead.getSymbol());
		diagonalBetweenTowardsMediumEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-004-02-02-04"),
				diagonalBetweenTowardsMediumEmptyArrowhead.getSymbol());
		diagonalBetweenTowardsMediumEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-004-02-02-02"),
				diagonalBetweenTowardsMediumEmptyArrowhead.getSymbol());
		diagonalBetweenTowardsMediumEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-004-02-02-01"),
				diagonalBetweenTowardsMediumEmptyArrowhead.getSymbol());

		diagonalBetweenTowardsMediumSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-004-02-03-08"),
				diagonalBetweenTowardsMediumSchemaArrowhead.getSymbol());
		diagonalBetweenTowardsMediumSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-004-02-03-06"),
				diagonalBetweenTowardsMediumSchemaArrowhead.getSymbol());
		diagonalBetweenTowardsMediumSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-004-02-03-05"),
				diagonalBetweenTowardsMediumSchemaArrowhead.getSymbol());
		diagonalBetweenTowardsMediumSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-004-02-03-04"),
				diagonalBetweenTowardsMediumSchemaArrowhead.getSymbol());
		diagonalBetweenTowardsMediumSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-004-02-03-02"),
				diagonalBetweenTowardsMediumSchemaArrowhead.getSymbol());
		diagonalBetweenTowardsMediumSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-004-02-03-01"),
				diagonalBetweenTowardsMediumSchemaArrowhead.getSymbol());

		diagonalBetweenTowardsLarge.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-004-03-01-08"), diagonalBetweenTowardsLarge.getSymbol());
		diagonalBetweenTowardsLarge.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-004-03-01-06"), diagonalBetweenTowardsLarge.getSymbol());
		diagonalBetweenTowardsLarge.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-004-03-01-05"), diagonalBetweenTowardsLarge.getSymbol());
		diagonalBetweenTowardsLarge.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-004-03-01-04"), diagonalBetweenTowardsLarge.getSymbol());
		diagonalBetweenTowardsLarge.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-004-03-01-02"), diagonalBetweenTowardsLarge.getSymbol());
		diagonalBetweenTowardsLarge.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-004-03-01-01"), diagonalBetweenTowardsLarge.getSymbol());

		diagonalBetweenTowardsLargeEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-004-03-02-08"),
				diagonalBetweenTowardsLargeEmptyArrowhead.getSymbol());
		diagonalBetweenTowardsLargeEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-004-03-02-06"),
				diagonalBetweenTowardsLargeEmptyArrowhead.getSymbol());
		diagonalBetweenTowardsLargeEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-004-03-02-05"),
				diagonalBetweenTowardsLargeEmptyArrowhead.getSymbol());
		diagonalBetweenTowardsLargeEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-004-03-02-04"),
				diagonalBetweenTowardsLargeEmptyArrowhead.getSymbol());
		diagonalBetweenTowardsLargeEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-004-03-02-02"),
				diagonalBetweenTowardsLargeEmptyArrowhead.getSymbol());
		diagonalBetweenTowardsLargeEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-004-03-02-01"),
				diagonalBetweenTowardsLargeEmptyArrowhead.getSymbol());

		diagonalBetweenTowardsLargeSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-004-03-03-08"),
				diagonalBetweenTowardsLargeSchemaArrowhead.getSymbol());
		diagonalBetweenTowardsLargeSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-004-03-03-06"),
				diagonalBetweenTowardsLargeSchemaArrowhead.getSymbol());
		diagonalBetweenTowardsLargeSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-004-03-03-05"),
				diagonalBetweenTowardsLargeSchemaArrowhead.getSymbol());
		diagonalBetweenTowardsLargeSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-004-03-03-04"),
				diagonalBetweenTowardsLargeSchemaArrowhead.getSymbol());
		diagonalBetweenTowardsLargeSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-004-03-03-02"),
				diagonalBetweenTowardsLargeSchemaArrowhead.getSymbol());
		diagonalBetweenTowardsLargeSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-004-03-03-01"),
				diagonalBetweenTowardsLargeSchemaArrowhead.getSymbol());

		diagonalBetweenTowardsLargest.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-004-04-01-08"), diagonalBetweenTowardsLargest.getSymbol());
		diagonalBetweenTowardsLargest.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-004-04-01-06"), diagonalBetweenTowardsLargest.getSymbol());
		diagonalBetweenTowardsLargest.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-004-04-01-05"), diagonalBetweenTowardsLargest.getSymbol());
		diagonalBetweenTowardsLargest.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-004-04-01-04"), diagonalBetweenTowardsLargest.getSymbol());
		diagonalBetweenTowardsLargest.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-004-04-01-02"), diagonalBetweenTowardsLargest.getSymbol());
		diagonalBetweenTowardsLargest.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-004-04-01-01"), diagonalBetweenTowardsLargest.getSymbol());

		diagonalBetweenTowardsLargestEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-004-04-02-08"),
				diagonalBetweenTowardsLargestEmptyArrowhead.getSymbol());
		diagonalBetweenTowardsLargestEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-004-04-02-06"),
				diagonalBetweenTowardsLargestEmptyArrowhead.getSymbol());
		diagonalBetweenTowardsLargestEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-004-04-02-05"),
				diagonalBetweenTowardsLargestEmptyArrowhead.getSymbol());
		diagonalBetweenTowardsLargestEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-004-04-02-04"),
				diagonalBetweenTowardsLargestEmptyArrowhead.getSymbol());
		diagonalBetweenTowardsLargestEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-004-04-02-02"),
				diagonalBetweenTowardsLargestEmptyArrowhead.getSymbol());
		diagonalBetweenTowardsLargestEmptyArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-004-04-02-01"),
				diagonalBetweenTowardsLargestEmptyArrowhead.getSymbol());

		diagonalBetweenTowardsLargestSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-004-04-03-08"),
				diagonalBetweenTowardsLargestSchemaArrowhead.getSymbol());
		diagonalBetweenTowardsLargestSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-004-04-03-06"),
				diagonalBetweenTowardsLargestSchemaArrowhead.getSymbol());
		diagonalBetweenTowardsLargestSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-004-04-03-05"),
				diagonalBetweenTowardsLargestSchemaArrowhead.getSymbol());
		diagonalBetweenTowardsLargestSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-004-04-03-04"),
				diagonalBetweenTowardsLargestSchemaArrowhead.getSymbol());
		diagonalBetweenTowardsLargestSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-004-04-03-02"),
				diagonalBetweenTowardsLargestSchemaArrowhead.getSymbol());
		diagonalBetweenTowardsLargestSchemaArrowhead.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-004-04-03-01"),
				diagonalBetweenTowardsLargestSchemaArrowhead.getSymbol());

	}

	@Override
	public void testRotateCounterClockwise() {

		diagonalAwayMovementSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-001-01-01-02"), diagonalAwayMovementSmall.getSymbol());
		diagonalAwayMovementSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-001-01-01-04"), diagonalAwayMovementSmall.getSymbol());
		diagonalAwayMovementSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-001-01-01-05"), diagonalAwayMovementSmall.getSymbol());
		diagonalAwayMovementSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-001-01-01-06"), diagonalAwayMovementSmall.getSymbol());
		diagonalAwayMovementSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-001-01-01-08"), diagonalAwayMovementSmall.getSymbol());
		diagonalAwayMovementSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-001-01-01-01"), diagonalAwayMovementSmall.getSymbol());

		diagonalAwayMovementSmallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-001-01-02-02"),
				diagonalAwayMovementSmallEmptyArrowhead.getSymbol());
		diagonalAwayMovementSmallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-001-01-02-04"),
				diagonalAwayMovementSmallEmptyArrowhead.getSymbol());
		diagonalAwayMovementSmallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-001-01-02-05"),
				diagonalAwayMovementSmallEmptyArrowhead.getSymbol());
		diagonalAwayMovementSmallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-001-01-02-06"),
				diagonalAwayMovementSmallEmptyArrowhead.getSymbol());
		diagonalAwayMovementSmallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-001-01-02-08"),
				diagonalAwayMovementSmallEmptyArrowhead.getSymbol());
		diagonalAwayMovementSmallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-001-01-02-01"),
				diagonalAwayMovementSmallEmptyArrowhead.getSymbol());

		diagonalAwayMovementSmallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-001-01-03-02"),
				diagonalAwayMovementSmallSchemaArrowhead.getSymbol());
		diagonalAwayMovementSmallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-001-01-03-04"),
				diagonalAwayMovementSmallSchemaArrowhead.getSymbol());
		diagonalAwayMovementSmallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-001-01-03-05"),
				diagonalAwayMovementSmallSchemaArrowhead.getSymbol());
		diagonalAwayMovementSmallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-001-01-03-06"),
				diagonalAwayMovementSmallSchemaArrowhead.getSymbol());
		diagonalAwayMovementSmallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-001-01-03-08"),
				diagonalAwayMovementSmallSchemaArrowhead.getSymbol());
		diagonalAwayMovementSmallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-001-01-03-01"),
				diagonalAwayMovementSmallSchemaArrowhead.getSymbol());

		diagonalAwayMovementMedium.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-001-02-01-02"), diagonalAwayMovementMedium.getSymbol());
		diagonalAwayMovementMedium.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-001-02-01-04"), diagonalAwayMovementMedium.getSymbol());
		diagonalAwayMovementMedium.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-001-02-01-05"), diagonalAwayMovementMedium.getSymbol());
		diagonalAwayMovementMedium.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-001-02-01-06"), diagonalAwayMovementMedium.getSymbol());
		diagonalAwayMovementMedium.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-001-02-01-08"), diagonalAwayMovementMedium.getSymbol());
		diagonalAwayMovementMedium.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-001-02-01-01"), diagonalAwayMovementMedium.getSymbol());

		diagonalAwayMovementMediumEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-001-02-02-02"),
				diagonalAwayMovementMediumEmptyArrowhead.getSymbol());
		diagonalAwayMovementMediumEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-001-02-02-04"),
				diagonalAwayMovementMediumEmptyArrowhead.getSymbol());
		diagonalAwayMovementMediumEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-001-02-02-05"),
				diagonalAwayMovementMediumEmptyArrowhead.getSymbol());
		diagonalAwayMovementMediumEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-001-02-02-06"),
				diagonalAwayMovementMediumEmptyArrowhead.getSymbol());
		diagonalAwayMovementMediumEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-001-02-02-08"),
				diagonalAwayMovementMediumEmptyArrowhead.getSymbol());
		diagonalAwayMovementMediumEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-001-02-02-01"),
				diagonalAwayMovementMediumEmptyArrowhead.getSymbol());

		diagonalAwayMovementMediumSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-001-02-03-02"),
				diagonalAwayMovementMediumSchemaArrowhead.getSymbol());
		diagonalAwayMovementMediumSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-001-02-03-04"),
				diagonalAwayMovementMediumSchemaArrowhead.getSymbol());
		diagonalAwayMovementMediumSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-001-02-03-05"),
				diagonalAwayMovementMediumSchemaArrowhead.getSymbol());
		diagonalAwayMovementMediumSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-001-02-03-06"),
				diagonalAwayMovementMediumSchemaArrowhead.getSymbol());
		diagonalAwayMovementMediumSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-001-02-03-08"),
				diagonalAwayMovementMediumSchemaArrowhead.getSymbol());
		diagonalAwayMovementMediumSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-001-02-03-01"),
				diagonalAwayMovementMediumSchemaArrowhead.getSymbol());

		diagonalAwayMovementLarge.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-001-03-01-02"), diagonalAwayMovementLarge.getSymbol());
		diagonalAwayMovementLarge.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-001-03-01-04"), diagonalAwayMovementLarge.getSymbol());
		diagonalAwayMovementLarge.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-001-03-01-05"), diagonalAwayMovementLarge.getSymbol());
		diagonalAwayMovementLarge.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-001-03-01-06"), diagonalAwayMovementLarge.getSymbol());
		diagonalAwayMovementLarge.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-001-03-01-08"), diagonalAwayMovementLarge.getSymbol());
		diagonalAwayMovementLarge.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-001-03-01-01"), diagonalAwayMovementLarge.getSymbol());

		diagonalAwayMovementLargeEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-001-03-02-02"),
				diagonalAwayMovementLargeEmptyArrowhead.getSymbol());
		diagonalAwayMovementLargeEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-001-03-02-04"),
				diagonalAwayMovementLargeEmptyArrowhead.getSymbol());
		diagonalAwayMovementLargeEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-001-03-02-05"),
				diagonalAwayMovementLargeEmptyArrowhead.getSymbol());
		diagonalAwayMovementLargeEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-001-03-02-06"),
				diagonalAwayMovementLargeEmptyArrowhead.getSymbol());
		diagonalAwayMovementLargeEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-001-03-02-08"),
				diagonalAwayMovementLargeEmptyArrowhead.getSymbol());
		diagonalAwayMovementLargeEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-001-03-02-01"),
				diagonalAwayMovementLargeEmptyArrowhead.getSymbol());

		diagonalAwayMovementLargeSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-001-03-03-02"),
				diagonalAwayMovementLargeSchemaArrowhead.getSymbol());
		diagonalAwayMovementLargeSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-001-03-03-04"),
				diagonalAwayMovementLargeSchemaArrowhead.getSymbol());
		diagonalAwayMovementLargeSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-001-03-03-05"),
				diagonalAwayMovementLargeSchemaArrowhead.getSymbol());
		diagonalAwayMovementLargeSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-001-03-03-06"),
				diagonalAwayMovementLargeSchemaArrowhead.getSymbol());
		diagonalAwayMovementLargeSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-001-03-03-08"),
				diagonalAwayMovementLargeSchemaArrowhead.getSymbol());
		diagonalAwayMovementLargeSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-001-03-03-01"),
				diagonalAwayMovementLargeSchemaArrowhead.getSymbol());

		diagonalAwayMovementLargest.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-001-04-01-02"), diagonalAwayMovementLargest.getSymbol());
		diagonalAwayMovementLargest.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-001-04-01-04"), diagonalAwayMovementLargest.getSymbol());
		diagonalAwayMovementLargest.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-001-04-01-05"), diagonalAwayMovementLargest.getSymbol());
		diagonalAwayMovementLargest.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-001-04-01-06"), diagonalAwayMovementLargest.getSymbol());
		diagonalAwayMovementLargest.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-001-04-01-08"), diagonalAwayMovementLargest.getSymbol());
		diagonalAwayMovementLargest.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-001-04-01-01"), diagonalAwayMovementLargest.getSymbol());

		diagonalAwayMovementLargestEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-001-04-02-02"),
				diagonalAwayMovementLargestEmptyArrowhead.getSymbol());
		diagonalAwayMovementLargestEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-001-04-02-04"),
				diagonalAwayMovementLargestEmptyArrowhead.getSymbol());
		diagonalAwayMovementLargestEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-001-04-02-05"),
				diagonalAwayMovementLargestEmptyArrowhead.getSymbol());
		diagonalAwayMovementLargestEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-001-04-02-06"),
				diagonalAwayMovementLargestEmptyArrowhead.getSymbol());
		diagonalAwayMovementLargestEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-001-04-02-08"),
				diagonalAwayMovementLargestEmptyArrowhead.getSymbol());
		diagonalAwayMovementLargestEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-001-04-02-01"),
				diagonalAwayMovementLargestEmptyArrowhead.getSymbol());

		diagonalAwayMovementLargestSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-001-04-03-02"),
				diagonalAwayMovementLargestSchemaArrowhead.getSymbol());
		diagonalAwayMovementLargestSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-001-04-03-04"),
				diagonalAwayMovementLargestSchemaArrowhead.getSymbol());
		diagonalAwayMovementLargestSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-001-04-03-05"),
				diagonalAwayMovementLargestSchemaArrowhead.getSymbol());
		diagonalAwayMovementLargestSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-001-04-03-06"),
				diagonalAwayMovementLargestSchemaArrowhead.getSymbol());
		diagonalAwayMovementLargestSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-001-04-03-08"),
				diagonalAwayMovementLargestSchemaArrowhead.getSymbol());
		diagonalAwayMovementLargestSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-001-04-03-01"),
				diagonalAwayMovementLargestSchemaArrowhead.getSymbol());

		diagonalTowardsMovementSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-002-01-01-02"), diagonalTowardsMovementSmall.getSymbol());
		diagonalTowardsMovementSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-002-01-01-04"), diagonalTowardsMovementSmall.getSymbol());
		diagonalTowardsMovementSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-002-01-01-05"), diagonalTowardsMovementSmall.getSymbol());
		diagonalTowardsMovementSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-002-01-01-06"), diagonalTowardsMovementSmall.getSymbol());
		diagonalTowardsMovementSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-002-01-01-08"), diagonalTowardsMovementSmall.getSymbol());
		diagonalTowardsMovementSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-002-01-01-01"), diagonalTowardsMovementSmall.getSymbol());

		diagonalTowardsMovementSmallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-002-01-02-02"),
				diagonalTowardsMovementSmallEmptyArrowhead.getSymbol());
		diagonalTowardsMovementSmallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-002-01-02-04"),
				diagonalTowardsMovementSmallEmptyArrowhead.getSymbol());
		diagonalTowardsMovementSmallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-002-01-02-05"),
				diagonalTowardsMovementSmallEmptyArrowhead.getSymbol());
		diagonalTowardsMovementSmallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-002-01-02-06"),
				diagonalTowardsMovementSmallEmptyArrowhead.getSymbol());
		diagonalTowardsMovementSmallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-002-01-02-08"),
				diagonalTowardsMovementSmallEmptyArrowhead.getSymbol());
		diagonalTowardsMovementSmallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-002-01-02-01"),
				diagonalTowardsMovementSmallEmptyArrowhead.getSymbol());

		diagonalTowardsMovementSmallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-002-01-03-02"),
				diagonalTowardsMovementSmallSchemaArrowhead.getSymbol());
		diagonalTowardsMovementSmallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-002-01-03-04"),
				diagonalTowardsMovementSmallSchemaArrowhead.getSymbol());
		diagonalTowardsMovementSmallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-002-01-03-05"),
				diagonalTowardsMovementSmallSchemaArrowhead.getSymbol());
		diagonalTowardsMovementSmallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-002-01-03-06"),
				diagonalTowardsMovementSmallSchemaArrowhead.getSymbol());
		diagonalTowardsMovementSmallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-002-01-03-08"),
				diagonalTowardsMovementSmallSchemaArrowhead.getSymbol());
		diagonalTowardsMovementSmallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-002-01-03-01"),
				diagonalTowardsMovementSmallSchemaArrowhead.getSymbol());

		diagonalTowardsMovementMedium.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-002-02-01-02"), diagonalTowardsMovementMedium.getSymbol());
		diagonalTowardsMovementMedium.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-002-02-01-04"), diagonalTowardsMovementMedium.getSymbol());
		diagonalTowardsMovementMedium.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-002-02-01-05"), diagonalTowardsMovementMedium.getSymbol());
		diagonalTowardsMovementMedium.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-002-02-01-06"), diagonalTowardsMovementMedium.getSymbol());
		diagonalTowardsMovementMedium.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-002-02-01-08"), diagonalTowardsMovementMedium.getSymbol());
		diagonalTowardsMovementMedium.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-002-02-01-01"), diagonalTowardsMovementMedium.getSymbol());

		diagonalTowardsMovementMediumEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-002-02-02-02"),
				diagonalTowardsMovementMediumEmptyArrowhead.getSymbol());
		diagonalTowardsMovementMediumEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-002-02-02-04"),
				diagonalTowardsMovementMediumEmptyArrowhead.getSymbol());
		diagonalTowardsMovementMediumEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-002-02-02-05"),
				diagonalTowardsMovementMediumEmptyArrowhead.getSymbol());
		diagonalTowardsMovementMediumEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-002-02-02-06"),
				diagonalTowardsMovementMediumEmptyArrowhead.getSymbol());
		diagonalTowardsMovementMediumEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-002-02-02-08"),
				diagonalTowardsMovementMediumEmptyArrowhead.getSymbol());
		diagonalTowardsMovementMediumEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-002-02-02-01"),
				diagonalTowardsMovementMediumEmptyArrowhead.getSymbol());

		diagonalTowardsMovementMediumSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-002-02-03-02"),
				diagonalTowardsMovementMediumSchemaArrowhead.getSymbol());
		diagonalTowardsMovementMediumSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-002-02-03-04"),
				diagonalTowardsMovementMediumSchemaArrowhead.getSymbol());
		diagonalTowardsMovementMediumSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-002-02-03-05"),
				diagonalTowardsMovementMediumSchemaArrowhead.getSymbol());
		diagonalTowardsMovementMediumSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-002-02-03-06"),
				diagonalTowardsMovementMediumSchemaArrowhead.getSymbol());
		diagonalTowardsMovementMediumSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-002-02-03-08"),
				diagonalTowardsMovementMediumSchemaArrowhead.getSymbol());
		diagonalTowardsMovementMediumSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-002-02-03-01"),
				diagonalTowardsMovementMediumSchemaArrowhead.getSymbol());

		diagonalTowardsMovementLarge.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-002-03-01-02"), diagonalTowardsMovementLarge.getSymbol());
		diagonalTowardsMovementLarge.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-002-03-01-04"), diagonalTowardsMovementLarge.getSymbol());
		diagonalTowardsMovementLarge.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-002-03-01-05"), diagonalTowardsMovementLarge.getSymbol());
		diagonalTowardsMovementLarge.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-002-03-01-06"), diagonalTowardsMovementLarge.getSymbol());
		diagonalTowardsMovementLarge.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-002-03-01-08"), diagonalTowardsMovementLarge.getSymbol());
		diagonalTowardsMovementLarge.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-002-03-01-01"), diagonalTowardsMovementLarge.getSymbol());

		diagonalTowardsMovementLargeEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-002-03-02-02"),
				diagonalTowardsMovementLargeEmptyArrowhead.getSymbol());
		diagonalTowardsMovementLargeEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-002-03-02-04"),
				diagonalTowardsMovementLargeEmptyArrowhead.getSymbol());
		diagonalTowardsMovementLargeEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-002-03-02-05"),
				diagonalTowardsMovementLargeEmptyArrowhead.getSymbol());
		diagonalTowardsMovementLargeEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-002-03-02-06"),
				diagonalTowardsMovementLargeEmptyArrowhead.getSymbol());
		diagonalTowardsMovementLargeEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-002-03-02-08"),
				diagonalTowardsMovementLargeEmptyArrowhead.getSymbol());
		diagonalTowardsMovementLargeEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-002-03-02-01"),
				diagonalTowardsMovementLargeEmptyArrowhead.getSymbol());

		diagonalTowardsMovementLargeSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-002-03-03-02"),
				diagonalTowardsMovementLargeSchemaArrowhead.getSymbol());
		diagonalTowardsMovementLargeSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-002-03-03-04"),
				diagonalTowardsMovementLargeSchemaArrowhead.getSymbol());
		diagonalTowardsMovementLargeSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-002-03-03-05"),
				diagonalTowardsMovementLargeSchemaArrowhead.getSymbol());
		diagonalTowardsMovementLargeSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-002-03-03-06"),
				diagonalTowardsMovementLargeSchemaArrowhead.getSymbol());
		diagonalTowardsMovementLargeSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-002-03-03-08"),
				diagonalTowardsMovementLargeSchemaArrowhead.getSymbol());
		diagonalTowardsMovementLargeSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-002-03-03-01"),
				diagonalTowardsMovementLargeSchemaArrowhead.getSymbol());

		diagonalTowardsMovementLargest.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-002-04-01-02"), diagonalTowardsMovementLargest.getSymbol());
		diagonalTowardsMovementLargest.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-002-04-01-04"), diagonalTowardsMovementLargest.getSymbol());
		diagonalTowardsMovementLargest.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-002-04-01-05"), diagonalTowardsMovementLargest.getSymbol());
		diagonalTowardsMovementLargest.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-002-04-01-06"), diagonalTowardsMovementLargest.getSymbol());
		diagonalTowardsMovementLargest.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-002-04-01-08"), diagonalTowardsMovementLargest.getSymbol());
		diagonalTowardsMovementLargest.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-002-04-01-01"), diagonalTowardsMovementLargest.getSymbol());

		diagonalTowardsMovementLargestEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-002-04-02-02"),
				diagonalTowardsMovementLargestEmptyArrowhead.getSymbol());
		diagonalTowardsMovementLargestEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-002-04-02-04"),
				diagonalTowardsMovementLargestEmptyArrowhead.getSymbol());
		diagonalTowardsMovementLargestEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-002-04-02-05"),
				diagonalTowardsMovementLargestEmptyArrowhead.getSymbol());
		diagonalTowardsMovementLargestEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-002-04-02-06"),
				diagonalTowardsMovementLargestEmptyArrowhead.getSymbol());
		diagonalTowardsMovementLargestEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-002-04-02-08"),
				diagonalTowardsMovementLargestEmptyArrowhead.getSymbol());
		diagonalTowardsMovementLargestEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-002-04-02-01"),
				diagonalTowardsMovementLargestEmptyArrowhead.getSymbol());

		diagonalTowardsMovementLargestSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-002-04-03-02"),
				diagonalTowardsMovementLargestSchemaArrowhead.getSymbol());
		diagonalTowardsMovementLargestSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-002-04-03-04"),
				diagonalTowardsMovementLargestSchemaArrowhead.getSymbol());
		diagonalTowardsMovementLargestSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-002-04-03-05"),
				diagonalTowardsMovementLargestSchemaArrowhead.getSymbol());
		diagonalTowardsMovementLargestSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-002-04-03-06"),
				diagonalTowardsMovementLargestSchemaArrowhead.getSymbol());
		diagonalTowardsMovementLargestSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-002-04-03-08"),
				diagonalTowardsMovementLargestSchemaArrowhead.getSymbol());
		diagonalTowardsMovementLargestSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-002-04-03-01"),
				diagonalTowardsMovementLargestSchemaArrowhead.getSymbol());

		diagonalBetweenAwaySmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-003-01-01-02"), diagonalBetweenAwaySmall.getSymbol());
		diagonalBetweenAwaySmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-003-01-01-04"), diagonalBetweenAwaySmall.getSymbol());
		diagonalBetweenAwaySmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-003-01-01-05"), diagonalBetweenAwaySmall.getSymbol());
		diagonalBetweenAwaySmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-003-01-01-06"), diagonalBetweenAwaySmall.getSymbol());
		diagonalBetweenAwaySmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-003-01-01-08"), diagonalBetweenAwaySmall.getSymbol());
		diagonalBetweenAwaySmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-003-01-01-01"), diagonalBetweenAwaySmall.getSymbol());

		diagonalBetweenAwaySmallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-003-01-02-02"),
				diagonalBetweenAwaySmallEmptyArrowhead.getSymbol());
		diagonalBetweenAwaySmallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-003-01-02-04"),
				diagonalBetweenAwaySmallEmptyArrowhead.getSymbol());
		diagonalBetweenAwaySmallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-003-01-02-05"),
				diagonalBetweenAwaySmallEmptyArrowhead.getSymbol());
		diagonalBetweenAwaySmallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-003-01-02-06"),
				diagonalBetweenAwaySmallEmptyArrowhead.getSymbol());
		diagonalBetweenAwaySmallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-003-01-02-08"),
				diagonalBetweenAwaySmallEmptyArrowhead.getSymbol());
		diagonalBetweenAwaySmallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-003-01-02-01"),
				diagonalBetweenAwaySmallEmptyArrowhead.getSymbol());

		diagonalBetweenAwaySmallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-003-01-03-02"),
				diagonalBetweenAwaySmallSchemaArrowhead.getSymbol());
		diagonalBetweenAwaySmallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-003-01-03-04"),
				diagonalBetweenAwaySmallSchemaArrowhead.getSymbol());
		diagonalBetweenAwaySmallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-003-01-03-05"),
				diagonalBetweenAwaySmallSchemaArrowhead.getSymbol());
		diagonalBetweenAwaySmallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-003-01-03-06"),
				diagonalBetweenAwaySmallSchemaArrowhead.getSymbol());
		diagonalBetweenAwaySmallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-003-01-03-08"),
				diagonalBetweenAwaySmallSchemaArrowhead.getSymbol());
		diagonalBetweenAwaySmallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-003-01-03-01"),
				diagonalBetweenAwaySmallSchemaArrowhead.getSymbol());

		diagonalBetweenAwayMedium.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-003-02-01-02"), diagonalBetweenAwayMedium.getSymbol());
		diagonalBetweenAwayMedium.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-003-02-01-04"), diagonalBetweenAwayMedium.getSymbol());
		diagonalBetweenAwayMedium.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-003-02-01-05"), diagonalBetweenAwayMedium.getSymbol());
		diagonalBetweenAwayMedium.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-003-02-01-06"), diagonalBetweenAwayMedium.getSymbol());
		diagonalBetweenAwayMedium.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-003-02-01-08"), diagonalBetweenAwayMedium.getSymbol());
		diagonalBetweenAwayMedium.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-003-02-01-01"), diagonalBetweenAwayMedium.getSymbol());

		diagonalBetweenAwayMediumEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-003-02-02-02"),
				diagonalBetweenAwayMediumEmptyArrowhead.getSymbol());
		diagonalBetweenAwayMediumEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-003-02-02-04"),
				diagonalBetweenAwayMediumEmptyArrowhead.getSymbol());
		diagonalBetweenAwayMediumEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-003-02-02-05"),
				diagonalBetweenAwayMediumEmptyArrowhead.getSymbol());
		diagonalBetweenAwayMediumEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-003-02-02-06"),
				diagonalBetweenAwayMediumEmptyArrowhead.getSymbol());
		diagonalBetweenAwayMediumEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-003-02-02-08"),
				diagonalBetweenAwayMediumEmptyArrowhead.getSymbol());
		diagonalBetweenAwayMediumEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-003-02-02-01"),
				diagonalBetweenAwayMediumEmptyArrowhead.getSymbol());

		diagonalBetweenAwayMediumSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-003-02-03-02"),
				diagonalBetweenAwayMediumSchemaArrowhead.getSymbol());
		diagonalBetweenAwayMediumSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-003-02-03-04"),
				diagonalBetweenAwayMediumSchemaArrowhead.getSymbol());
		diagonalBetweenAwayMediumSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-003-02-03-05"),
				diagonalBetweenAwayMediumSchemaArrowhead.getSymbol());
		diagonalBetweenAwayMediumSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-003-02-03-06"),
				diagonalBetweenAwayMediumSchemaArrowhead.getSymbol());
		diagonalBetweenAwayMediumSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-003-02-03-08"),
				diagonalBetweenAwayMediumSchemaArrowhead.getSymbol());
		diagonalBetweenAwayMediumSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-003-02-03-01"),
				diagonalBetweenAwayMediumSchemaArrowhead.getSymbol());

		diagonalBetweenAwayLarge.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-003-03-01-02"), diagonalBetweenAwayLarge.getSymbol());
		diagonalBetweenAwayLarge.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-003-03-01-04"), diagonalBetweenAwayLarge.getSymbol());
		diagonalBetweenAwayLarge.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-003-03-01-05"), diagonalBetweenAwayLarge.getSymbol());
		diagonalBetweenAwayLarge.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-003-03-01-06"), diagonalBetweenAwayLarge.getSymbol());
		diagonalBetweenAwayLarge.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-003-03-01-08"), diagonalBetweenAwayLarge.getSymbol());
		diagonalBetweenAwayLarge.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-003-03-01-01"), diagonalBetweenAwayLarge.getSymbol());

		diagonalBetweenAwayLargeEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-003-03-02-02"),
				diagonalBetweenAwayLargeEmptyArrowhead.getSymbol());
		diagonalBetweenAwayLargeEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-003-03-02-04"),
				diagonalBetweenAwayLargeEmptyArrowhead.getSymbol());
		diagonalBetweenAwayLargeEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-003-03-02-05"),
				diagonalBetweenAwayLargeEmptyArrowhead.getSymbol());
		diagonalBetweenAwayLargeEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-003-03-02-06"),
				diagonalBetweenAwayLargeEmptyArrowhead.getSymbol());
		diagonalBetweenAwayLargeEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-003-03-02-08"),
				diagonalBetweenAwayLargeEmptyArrowhead.getSymbol());
		diagonalBetweenAwayLargeEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-003-03-02-01"),
				diagonalBetweenAwayLargeEmptyArrowhead.getSymbol());

		diagonalBetweenAwayLargeSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-003-03-03-02"),
				diagonalBetweenAwayLargeSchemaArrowhead.getSymbol());
		diagonalBetweenAwayLargeSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-003-03-03-04"),
				diagonalBetweenAwayLargeSchemaArrowhead.getSymbol());
		diagonalBetweenAwayLargeSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-003-03-03-05"),
				diagonalBetweenAwayLargeSchemaArrowhead.getSymbol());
		diagonalBetweenAwayLargeSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-003-03-03-06"),
				diagonalBetweenAwayLargeSchemaArrowhead.getSymbol());
		diagonalBetweenAwayLargeSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-003-03-03-08"),
				diagonalBetweenAwayLargeSchemaArrowhead.getSymbol());
		diagonalBetweenAwayLargeSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-003-03-03-01"),
				diagonalBetweenAwayLargeSchemaArrowhead.getSymbol());

		diagonalBetweenAwayLargest.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-003-04-01-02"), diagonalBetweenAwayLargest.getSymbol());
		diagonalBetweenAwayLargest.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-003-04-01-04"), diagonalBetweenAwayLargest.getSymbol());
		diagonalBetweenAwayLargest.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-003-04-01-05"), diagonalBetweenAwayLargest.getSymbol());
		diagonalBetweenAwayLargest.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-003-04-01-06"), diagonalBetweenAwayLargest.getSymbol());
		diagonalBetweenAwayLargest.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-003-04-01-08"), diagonalBetweenAwayLargest.getSymbol());
		diagonalBetweenAwayLargest.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-003-04-01-01"), diagonalBetweenAwayLargest.getSymbol());

		diagonalBetweenAwayLargestEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-003-04-02-02"),
				diagonalBetweenAwayLargestEmptyArrowhead.getSymbol());
		diagonalBetweenAwayLargestEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-003-04-02-04"),
				diagonalBetweenAwayLargestEmptyArrowhead.getSymbol());
		diagonalBetweenAwayLargestEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-003-04-02-05"),
				diagonalBetweenAwayLargestEmptyArrowhead.getSymbol());
		diagonalBetweenAwayLargestEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-003-04-02-06"),
				diagonalBetweenAwayLargestEmptyArrowhead.getSymbol());
		diagonalBetweenAwayLargestEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-003-04-02-08"),
				diagonalBetweenAwayLargestEmptyArrowhead.getSymbol());
		diagonalBetweenAwayLargestEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-003-04-02-01"),
				diagonalBetweenAwayLargestEmptyArrowhead.getSymbol());

		diagonalBetweenAwayLargestSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-003-04-03-02"),
				diagonalBetweenAwayLargestSchemaArrowhead.getSymbol());
		diagonalBetweenAwayLargestSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-003-04-03-04"),
				diagonalBetweenAwayLargestSchemaArrowhead.getSymbol());
		diagonalBetweenAwayLargestSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-003-04-03-05"),
				diagonalBetweenAwayLargestSchemaArrowhead.getSymbol());
		diagonalBetweenAwayLargestSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-003-04-03-06"),
				diagonalBetweenAwayLargestSchemaArrowhead.getSymbol());
		diagonalBetweenAwayLargestSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-003-04-03-08"),
				diagonalBetweenAwayLargestSchemaArrowhead.getSymbol());
		diagonalBetweenAwayLargestSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-003-04-03-01"),
				diagonalBetweenAwayLargestSchemaArrowhead.getSymbol());

		diagonalBetweenTowardsSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-004-01-01-02"), diagonalBetweenTowardsSmall.getSymbol());
		diagonalBetweenTowardsSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-004-01-01-04"), diagonalBetweenTowardsSmall.getSymbol());
		diagonalBetweenTowardsSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-004-01-01-05"), diagonalBetweenTowardsSmall.getSymbol());
		diagonalBetweenTowardsSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-004-01-01-06"), diagonalBetweenTowardsSmall.getSymbol());
		diagonalBetweenTowardsSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-004-01-01-08"), diagonalBetweenTowardsSmall.getSymbol());
		diagonalBetweenTowardsSmall.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-004-01-01-01"), diagonalBetweenTowardsSmall.getSymbol());

		diagonalBetweenTowardsSmallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-004-01-02-02"),
				diagonalBetweenTowardsSmallEmptyArrowhead.getSymbol());
		diagonalBetweenTowardsSmallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-004-01-02-04"),
				diagonalBetweenTowardsSmallEmptyArrowhead.getSymbol());
		diagonalBetweenTowardsSmallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-004-01-02-05"),
				diagonalBetweenTowardsSmallEmptyArrowhead.getSymbol());
		diagonalBetweenTowardsSmallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-004-01-02-06"),
				diagonalBetweenTowardsSmallEmptyArrowhead.getSymbol());
		diagonalBetweenTowardsSmallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-004-01-02-08"),
				diagonalBetweenTowardsSmallEmptyArrowhead.getSymbol());
		diagonalBetweenTowardsSmallEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-004-01-02-01"),
				diagonalBetweenTowardsSmallEmptyArrowhead.getSymbol());

		diagonalBetweenTowardsSmallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-004-01-03-02"),
				diagonalBetweenTowardsSmallSchemaArrowhead.getSymbol());
		diagonalBetweenTowardsSmallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-004-01-03-04"),
				diagonalBetweenTowardsSmallSchemaArrowhead.getSymbol());
		diagonalBetweenTowardsSmallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-004-01-03-05"),
				diagonalBetweenTowardsSmallSchemaArrowhead.getSymbol());
		diagonalBetweenTowardsSmallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-004-01-03-06"),
				diagonalBetweenTowardsSmallSchemaArrowhead.getSymbol());
		diagonalBetweenTowardsSmallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-004-01-03-08"),
				diagonalBetweenTowardsSmallSchemaArrowhead.getSymbol());
		diagonalBetweenTowardsSmallSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-004-01-03-01"),
				diagonalBetweenTowardsSmallSchemaArrowhead.getSymbol());

		diagonalBetweenTowardsMedium.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-004-02-01-02"), diagonalBetweenTowardsMedium.getSymbol());
		diagonalBetweenTowardsMedium.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-004-02-01-04"), diagonalBetweenTowardsMedium.getSymbol());
		diagonalBetweenTowardsMedium.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-004-02-01-05"), diagonalBetweenTowardsMedium.getSymbol());
		diagonalBetweenTowardsMedium.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-004-02-01-06"), diagonalBetweenTowardsMedium.getSymbol());
		diagonalBetweenTowardsMedium.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-004-02-01-08"), diagonalBetweenTowardsMedium.getSymbol());
		diagonalBetweenTowardsMedium.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-004-02-01-01"), diagonalBetweenTowardsMedium.getSymbol());

		diagonalBetweenTowardsMediumEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-004-02-02-02"),
				diagonalBetweenTowardsMediumEmptyArrowhead.getSymbol());
		diagonalBetweenTowardsMediumEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-004-02-02-04"),
				diagonalBetweenTowardsMediumEmptyArrowhead.getSymbol());
		diagonalBetweenTowardsMediumEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-004-02-02-05"),
				diagonalBetweenTowardsMediumEmptyArrowhead.getSymbol());
		diagonalBetweenTowardsMediumEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-004-02-02-06"),
				diagonalBetweenTowardsMediumEmptyArrowhead.getSymbol());
		diagonalBetweenTowardsMediumEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-004-02-02-08"),
				diagonalBetweenTowardsMediumEmptyArrowhead.getSymbol());
		diagonalBetweenTowardsMediumEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-004-02-02-01"),
				diagonalBetweenTowardsMediumEmptyArrowhead.getSymbol());

		diagonalBetweenTowardsMediumSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-004-02-03-02"),
				diagonalBetweenTowardsMediumSchemaArrowhead.getSymbol());
		diagonalBetweenTowardsMediumSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-004-02-03-04"),
				diagonalBetweenTowardsMediumSchemaArrowhead.getSymbol());
		diagonalBetweenTowardsMediumSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-004-02-03-05"),
				diagonalBetweenTowardsMediumSchemaArrowhead.getSymbol());
		diagonalBetweenTowardsMediumSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-004-02-03-06"),
				diagonalBetweenTowardsMediumSchemaArrowhead.getSymbol());
		diagonalBetweenTowardsMediumSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-004-02-03-08"),
				diagonalBetweenTowardsMediumSchemaArrowhead.getSymbol());
		diagonalBetweenTowardsMediumSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-004-02-03-01"),
				diagonalBetweenTowardsMediumSchemaArrowhead.getSymbol());

		diagonalBetweenTowardsLarge.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-004-03-01-02"), diagonalBetweenTowardsLarge.getSymbol());
		diagonalBetweenTowardsLarge.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-004-03-01-04"), diagonalBetweenTowardsLarge.getSymbol());
		diagonalBetweenTowardsLarge.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-004-03-01-05"), diagonalBetweenTowardsLarge.getSymbol());
		diagonalBetweenTowardsLarge.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-004-03-01-06"), diagonalBetweenTowardsLarge.getSymbol());
		diagonalBetweenTowardsLarge.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-004-03-01-08"), diagonalBetweenTowardsLarge.getSymbol());
		diagonalBetweenTowardsLarge.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-004-03-01-01"), diagonalBetweenTowardsLarge.getSymbol());

		diagonalBetweenTowardsLargeEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-004-03-02-02"),
				diagonalBetweenTowardsLargeEmptyArrowhead.getSymbol());
		diagonalBetweenTowardsLargeEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-004-03-02-04"),
				diagonalBetweenTowardsLargeEmptyArrowhead.getSymbol());
		diagonalBetweenTowardsLargeEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-004-03-02-05"),
				diagonalBetweenTowardsLargeEmptyArrowhead.getSymbol());
		diagonalBetweenTowardsLargeEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-004-03-02-06"),
				diagonalBetweenTowardsLargeEmptyArrowhead.getSymbol());
		diagonalBetweenTowardsLargeEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-004-03-02-08"),
				diagonalBetweenTowardsLargeEmptyArrowhead.getSymbol());
		diagonalBetweenTowardsLargeEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-004-03-02-01"),
				diagonalBetweenTowardsLargeEmptyArrowhead.getSymbol());

		diagonalBetweenTowardsLargeSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-004-03-03-02"),
				diagonalBetweenTowardsLargeSchemaArrowhead.getSymbol());
		diagonalBetweenTowardsLargeSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-004-03-03-04"),
				diagonalBetweenTowardsLargeSchemaArrowhead.getSymbol());
		diagonalBetweenTowardsLargeSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-004-03-03-05"),
				diagonalBetweenTowardsLargeSchemaArrowhead.getSymbol());
		diagonalBetweenTowardsLargeSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-004-03-03-06"),
				diagonalBetweenTowardsLargeSchemaArrowhead.getSymbol());
		diagonalBetweenTowardsLargeSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-004-03-03-08"),
				diagonalBetweenTowardsLargeSchemaArrowhead.getSymbol());
		diagonalBetweenTowardsLargeSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-004-03-03-01"),
				diagonalBetweenTowardsLargeSchemaArrowhead.getSymbol());

		diagonalBetweenTowardsLargest.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-004-04-01-02"), diagonalBetweenTowardsLargest.getSymbol());
		diagonalBetweenTowardsLargest.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-004-04-01-04"), diagonalBetweenTowardsLargest.getSymbol());
		diagonalBetweenTowardsLargest.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-004-04-01-05"), diagonalBetweenTowardsLargest.getSymbol());
		diagonalBetweenTowardsLargest.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-004-04-01-06"), diagonalBetweenTowardsLargest.getSymbol());
		diagonalBetweenTowardsLargest.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-004-04-01-08"), diagonalBetweenTowardsLargest.getSymbol());
		diagonalBetweenTowardsLargest.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-004-04-01-01"), diagonalBetweenTowardsLargest.getSymbol());

		diagonalBetweenTowardsLargestEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-004-04-02-02"),
				diagonalBetweenTowardsLargestEmptyArrowhead.getSymbol());
		diagonalBetweenTowardsLargestEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-004-04-02-04"),
				diagonalBetweenTowardsLargestEmptyArrowhead.getSymbol());
		diagonalBetweenTowardsLargestEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-004-04-02-05"),
				diagonalBetweenTowardsLargestEmptyArrowhead.getSymbol());
		diagonalBetweenTowardsLargestEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-004-04-02-06"),
				diagonalBetweenTowardsLargestEmptyArrowhead.getSymbol());
		diagonalBetweenTowardsLargestEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-004-04-02-08"),
				diagonalBetweenTowardsLargestEmptyArrowhead.getSymbol());
		diagonalBetweenTowardsLargestEmptyArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-004-04-02-01"),
				diagonalBetweenTowardsLargestEmptyArrowhead.getSymbol());

		diagonalBetweenTowardsLargestSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-004-04-03-02"),
				diagonalBetweenTowardsLargestSchemaArrowhead.getSymbol());
		diagonalBetweenTowardsLargestSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-004-04-03-04"),
				diagonalBetweenTowardsLargestSchemaArrowhead.getSymbol());
		diagonalBetweenTowardsLargestSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-004-04-03-05"),
				diagonalBetweenTowardsLargestSchemaArrowhead.getSymbol());
		diagonalBetweenTowardsLargestSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-004-04-03-06"),
				diagonalBetweenTowardsLargestSchemaArrowhead.getSymbol());
		diagonalBetweenTowardsLargestSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-004-04-03-08"),
				diagonalBetweenTowardsLargestSchemaArrowhead.getSymbol());
		diagonalBetweenTowardsLargestSchemaArrowhead.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("02-04-004-04-03-01"),
				diagonalBetweenTowardsLargestSchemaArrowhead.getSymbol());

	}

	@Override
	public void testCanMirror() {

		assertTrue(diagonalAwayMovementSmall.canMirror());
		assertTrue(diagonalAwayMovementSmallEmptyArrowhead.canMirror());
		assertTrue(diagonalAwayMovementSmallSchemaArrowhead.canMirror());

		assertTrue(diagonalAwayMovementMedium.canMirror());
		assertTrue(diagonalAwayMovementMediumEmptyArrowhead.canMirror());
		assertTrue(diagonalAwayMovementMediumSchemaArrowhead.canMirror());

		assertTrue(diagonalAwayMovementLarge.canMirror());
		assertTrue(diagonalAwayMovementLargeEmptyArrowhead.canMirror());
		assertTrue(diagonalAwayMovementLargeSchemaArrowhead.canMirror());

		assertTrue(diagonalAwayMovementLargest.canMirror());
		assertTrue(diagonalAwayMovementLargestEmptyArrowhead.canMirror());
		assertTrue(diagonalAwayMovementLargestSchemaArrowhead.canMirror());

		assertTrue(diagonalTowardsMovementSmall.canMirror());
		assertTrue(diagonalTowardsMovementSmallEmptyArrowhead.canMirror());
		assertTrue(diagonalTowardsMovementSmallSchemaArrowhead.canMirror());

		assertTrue(diagonalTowardsMovementMedium.canMirror());
		assertTrue(diagonalTowardsMovementMediumEmptyArrowhead.canMirror());
		assertTrue(diagonalTowardsMovementMediumSchemaArrowhead.canMirror());

		assertTrue(diagonalTowardsMovementLarge.canMirror());
		assertTrue(diagonalTowardsMovementLargeEmptyArrowhead.canMirror());
		assertTrue(diagonalTowardsMovementLargeSchemaArrowhead.canMirror());

		assertTrue(diagonalTowardsMovementLargest.canMirror());
		assertTrue(diagonalTowardsMovementLargestEmptyArrowhead.canMirror());
		assertTrue(diagonalTowardsMovementLargestSchemaArrowhead.canMirror());

		assertTrue(diagonalBetweenAwaySmall.canMirror());
		assertTrue(diagonalBetweenAwaySmallEmptyArrowhead.canMirror());
		assertTrue(diagonalBetweenAwaySmallSchemaArrowhead.canMirror());

		assertTrue(diagonalBetweenAwayMedium.canMirror());
		assertTrue(diagonalBetweenAwayMediumEmptyArrowhead.canMirror());
		assertTrue(diagonalBetweenAwayMediumSchemaArrowhead.canMirror());

		assertTrue(diagonalBetweenAwayLarge.canMirror());
		assertTrue(diagonalBetweenAwayLargeEmptyArrowhead.canMirror());
		assertTrue(diagonalBetweenAwayLargeSchemaArrowhead.canMirror());

		assertTrue(diagonalBetweenAwayLargest.canMirror());
		assertTrue(diagonalBetweenAwayLargestEmptyArrowhead.canMirror());
		assertTrue(diagonalBetweenAwayLargestSchemaArrowhead.canMirror());

		assertTrue(diagonalBetweenTowardsSmall.canMirror());
		assertTrue(diagonalBetweenTowardsSmallEmptyArrowhead.canMirror());
		assertTrue(diagonalBetweenTowardsSmallSchemaArrowhead.canMirror());

		assertTrue(diagonalBetweenTowardsMedium.canMirror());
		assertTrue(diagonalBetweenTowardsMediumEmptyArrowhead.canMirror());
		assertTrue(diagonalBetweenTowardsMediumSchemaArrowhead.canMirror());

		assertTrue(diagonalBetweenTowardsLarge.canMirror());
		assertTrue(diagonalBetweenTowardsLargeEmptyArrowhead.canMirror());
		assertTrue(diagonalBetweenTowardsLargeSchemaArrowhead.canMirror());

		assertTrue(diagonalBetweenTowardsLargest.canMirror());
		assertTrue(diagonalBetweenTowardsLargestEmptyArrowhead.canMirror());
		assertTrue(diagonalBetweenTowardsLargestSchemaArrowhead.canMirror());

	}

	@Override
	public void testMirror() {

		diagonalAwayMovementSmall.mirror();
		assertEquals(symbolFactory.createSymbol("02-04-001-01-01-01"), diagonalAwayMovementSmall.getSymbol());
		diagonalAwayMovementSmallEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-04-001-01-02-01"),
				diagonalAwayMovementSmallEmptyArrowhead.getSymbol());
		diagonalAwayMovementSmallSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-04-001-01-03-01"),
				diagonalAwayMovementSmallSchemaArrowhead.getSymbol());

		diagonalAwayMovementMedium.mirror();
		assertEquals(symbolFactory.createSymbol("02-04-001-02-01-01"), diagonalAwayMovementMedium.getSymbol());
		diagonalAwayMovementMediumEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-04-001-02-02-01"),
				diagonalAwayMovementMediumEmptyArrowhead.getSymbol());
		diagonalAwayMovementMediumSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-04-001-02-03-01"),
				diagonalAwayMovementMediumSchemaArrowhead.getSymbol());

		diagonalAwayMovementLarge.mirror();
		assertEquals(symbolFactory.createSymbol("02-04-001-03-01-01"), diagonalAwayMovementLarge.getSymbol());
		diagonalAwayMovementLargeEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-04-001-03-02-01"),
				diagonalAwayMovementLargeEmptyArrowhead.getSymbol());
		diagonalAwayMovementLargeSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-04-001-03-03-01"),
				diagonalAwayMovementLargeSchemaArrowhead.getSymbol());

		diagonalAwayMovementLargest.mirror();
		assertEquals(symbolFactory.createSymbol("02-04-001-04-01-01"), diagonalAwayMovementLargest.getSymbol());
		diagonalAwayMovementLargestEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-04-001-04-02-01"),
				diagonalAwayMovementLargestEmptyArrowhead.getSymbol());
		diagonalAwayMovementLargestSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-04-001-04-03-01"),
				diagonalAwayMovementLargestSchemaArrowhead.getSymbol());

		diagonalTowardsMovementSmall.mirror();
		assertEquals(symbolFactory.createSymbol("02-04-002-01-01-01"), diagonalTowardsMovementSmall.getSymbol());
		diagonalTowardsMovementSmallEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-04-002-01-02-01"),
				diagonalTowardsMovementSmallEmptyArrowhead.getSymbol());
		diagonalTowardsMovementSmallSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-04-002-01-03-01"),
				diagonalTowardsMovementSmallSchemaArrowhead.getSymbol());

		diagonalTowardsMovementMedium.mirror();
		assertEquals(symbolFactory.createSymbol("02-04-002-02-01-01"), diagonalTowardsMovementMedium.getSymbol());
		diagonalTowardsMovementMediumEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-04-002-02-02-01"),
				diagonalTowardsMovementMediumEmptyArrowhead.getSymbol());
		diagonalTowardsMovementMediumSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-04-002-02-03-01"),
				diagonalTowardsMovementMediumSchemaArrowhead.getSymbol());

		diagonalTowardsMovementLarge.mirror();
		assertEquals(symbolFactory.createSymbol("02-04-002-03-01-01"), diagonalTowardsMovementLarge.getSymbol());
		diagonalTowardsMovementLargeEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-04-002-03-02-01"),
				diagonalTowardsMovementLargeEmptyArrowhead.getSymbol());
		diagonalTowardsMovementLargeSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-04-002-03-03-01"),
				diagonalTowardsMovementLargeSchemaArrowhead.getSymbol());

		diagonalTowardsMovementLargest.mirror();
		assertEquals(symbolFactory.createSymbol("02-04-002-04-01-01"), diagonalTowardsMovementLargest.getSymbol());
		diagonalTowardsMovementLargestEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-04-002-04-02-01"),
				diagonalTowardsMovementLargestEmptyArrowhead.getSymbol());
		diagonalTowardsMovementLargestSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-04-002-04-03-01"),
				diagonalTowardsMovementLargestSchemaArrowhead.getSymbol());

		diagonalBetweenAwaySmall.mirror();
		assertEquals(symbolFactory.createSymbol("02-04-003-01-01-01"), diagonalBetweenAwaySmall.getSymbol());
		diagonalBetweenAwaySmallEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-04-003-01-02-01"),
				diagonalBetweenAwaySmallEmptyArrowhead.getSymbol());
		diagonalBetweenAwaySmallSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-04-003-01-03-01"),
				diagonalBetweenAwaySmallSchemaArrowhead.getSymbol());

		diagonalBetweenAwayMedium.mirror();
		assertEquals(symbolFactory.createSymbol("02-04-003-02-01-01"), diagonalBetweenAwayMedium.getSymbol());
		diagonalBetweenAwayMediumEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-04-003-02-02-01"),
				diagonalBetweenAwayMediumEmptyArrowhead.getSymbol());
		diagonalBetweenAwayMediumSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-04-003-02-03-01"),
				diagonalBetweenAwayMediumSchemaArrowhead.getSymbol());

		diagonalBetweenAwayLarge.mirror();
		assertEquals(symbolFactory.createSymbol("02-04-003-03-01-01"), diagonalBetweenAwayLarge.getSymbol());
		diagonalBetweenAwayLargeEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-04-003-03-02-01"),
				diagonalBetweenAwayLargeEmptyArrowhead.getSymbol());
		diagonalBetweenAwayLargeSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-04-003-03-03-01"),
				diagonalBetweenAwayLargeSchemaArrowhead.getSymbol());

		diagonalBetweenAwayLargest.mirror();
		assertEquals(symbolFactory.createSymbol("02-04-003-04-01-01"), diagonalBetweenAwayLargest.getSymbol());
		diagonalBetweenAwayLargestEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-04-003-04-02-01"),
				diagonalBetweenAwayLargestEmptyArrowhead.getSymbol());
		diagonalBetweenAwayLargestSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-04-003-04-03-01"),
				diagonalBetweenAwayLargestSchemaArrowhead.getSymbol());

		diagonalBetweenTowardsSmall.mirror();
		assertEquals(symbolFactory.createSymbol("02-04-004-01-01-01"), diagonalBetweenTowardsSmall.getSymbol());
		diagonalBetweenTowardsSmallEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-04-004-01-02-01"),
				diagonalBetweenTowardsSmallEmptyArrowhead.getSymbol());
		diagonalBetweenTowardsSmallSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-04-004-01-03-01"),
				diagonalBetweenTowardsSmallSchemaArrowhead.getSymbol());

		diagonalBetweenTowardsMedium.mirror();
		assertEquals(symbolFactory.createSymbol("02-04-004-02-01-01"), diagonalBetweenTowardsMedium.getSymbol());
		diagonalBetweenTowardsMediumEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-04-004-02-02-01"),
				diagonalBetweenTowardsMediumEmptyArrowhead.getSymbol());
		diagonalBetweenTowardsMediumSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-04-004-02-03-01"),
				diagonalBetweenTowardsMediumSchemaArrowhead.getSymbol());

		diagonalBetweenTowardsLarge.mirror();
		assertEquals(symbolFactory.createSymbol("02-04-004-03-01-01"), diagonalBetweenTowardsLarge.getSymbol());
		diagonalBetweenTowardsLargeEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-04-004-03-02-01"),
				diagonalBetweenTowardsLargeEmptyArrowhead.getSymbol());
		diagonalBetweenTowardsLargeSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-04-004-03-03-01"),
				diagonalBetweenTowardsLargeSchemaArrowhead.getSymbol());

		diagonalBetweenTowardsLargest.mirror();
		assertEquals(symbolFactory.createSymbol("02-04-004-04-01-01"), diagonalBetweenTowardsLargest.getSymbol());
		diagonalBetweenTowardsLargestEmptyArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-04-004-04-02-01"),
				diagonalBetweenTowardsLargestEmptyArrowhead.getSymbol());
		diagonalBetweenTowardsLargestSchemaArrowhead.mirror();
		assertEquals(symbolFactory.createSymbol("02-04-004-04-03-01"),
				diagonalBetweenTowardsLargestSchemaArrowhead.getSymbol());

	}

	@Override
	public void testCanMirrorVertically() {

		assertTrue(diagonalAwayMovementSmall.canMirrorVertically());
		assertTrue(diagonalAwayMovementSmallEmptyArrowhead.canMirrorVertically());
		assertTrue(diagonalAwayMovementSmallSchemaArrowhead.canMirrorVertically());

		assertTrue(diagonalAwayMovementMedium.canMirrorVertically());
		assertTrue(diagonalAwayMovementMediumEmptyArrowhead.canMirrorVertically());
		assertTrue(diagonalAwayMovementMediumSchemaArrowhead.canMirrorVertically());

		assertTrue(diagonalAwayMovementLarge.canMirrorVertically());
		assertTrue(diagonalAwayMovementLargeEmptyArrowhead.canMirrorVertically());
		assertTrue(diagonalAwayMovementLargeSchemaArrowhead.canMirrorVertically());

		assertTrue(diagonalAwayMovementLargest.canMirrorVertically());
		assertTrue(diagonalAwayMovementLargestEmptyArrowhead.canMirrorVertically());
		assertTrue(diagonalAwayMovementLargestSchemaArrowhead.canMirrorVertically());

		assertTrue(diagonalTowardsMovementSmall.canMirrorVertically());
		assertTrue(diagonalTowardsMovementSmallEmptyArrowhead.canMirrorVertically());
		assertTrue(diagonalTowardsMovementSmallSchemaArrowhead.canMirrorVertically());

		assertTrue(diagonalTowardsMovementMedium.canMirrorVertically());
		assertTrue(diagonalTowardsMovementMediumEmptyArrowhead.canMirrorVertically());
		assertTrue(diagonalTowardsMovementMediumSchemaArrowhead.canMirrorVertically());

		assertTrue(diagonalTowardsMovementLarge.canMirrorVertically());
		assertTrue(diagonalTowardsMovementLargeEmptyArrowhead.canMirrorVertically());
		assertTrue(diagonalTowardsMovementLargeSchemaArrowhead.canMirrorVertically());

		assertTrue(diagonalTowardsMovementLargest.canMirrorVertically());
		assertTrue(diagonalTowardsMovementLargestEmptyArrowhead.canMirrorVertically());
		assertTrue(diagonalTowardsMovementLargestSchemaArrowhead.canMirrorVertically());

		assertTrue(diagonalBetweenAwaySmall.canMirrorVertically());
		assertTrue(diagonalBetweenAwaySmallEmptyArrowhead.canMirrorVertically());
		assertTrue(diagonalBetweenAwaySmallSchemaArrowhead.canMirrorVertically());

		assertTrue(diagonalBetweenAwayMedium.canMirrorVertically());
		assertTrue(diagonalBetweenAwayMediumEmptyArrowhead.canMirrorVertically());
		assertTrue(diagonalBetweenAwayMediumSchemaArrowhead.canMirrorVertically());

		assertTrue(diagonalBetweenAwayLarge.canMirrorVertically());
		assertTrue(diagonalBetweenAwayLargeEmptyArrowhead.canMirrorVertically());
		assertTrue(diagonalBetweenAwayLargeSchemaArrowhead.canMirrorVertically());

		assertTrue(diagonalBetweenAwayLargest.canMirrorVertically());
		assertTrue(diagonalBetweenAwayLargestEmptyArrowhead.canMirrorVertically());
		assertTrue(diagonalBetweenAwayLargestSchemaArrowhead.canMirrorVertically());

		assertTrue(diagonalBetweenTowardsSmall.canMirrorVertically());
		assertTrue(diagonalBetweenTowardsSmallEmptyArrowhead.canMirrorVertically());
		assertTrue(diagonalBetweenTowardsSmallSchemaArrowhead.canMirrorVertically());

		assertTrue(diagonalBetweenTowardsMedium.canMirrorVertically());
		assertTrue(diagonalBetweenTowardsMediumEmptyArrowhead.canMirrorVertically());
		assertTrue(diagonalBetweenTowardsMediumSchemaArrowhead.canMirrorVertically());

		assertTrue(diagonalBetweenTowardsLarge.canMirrorVertically());
		assertTrue(diagonalBetweenTowardsLargeEmptyArrowhead.canMirrorVertically());
		assertTrue(diagonalBetweenTowardsLargeSchemaArrowhead.canMirrorVertically());

		assertTrue(diagonalBetweenTowardsLargest.canMirrorVertically());
		assertTrue(diagonalBetweenTowardsLargestEmptyArrowhead.canMirrorVertically());
		assertTrue(diagonalBetweenTowardsLargestSchemaArrowhead.canMirrorVertically());

	}

	@Override
	public void testMirrorVertically() {

		diagonalAwayMovementSmall.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-04-001-01-01-05"), diagonalAwayMovementSmall.getSymbol());
		diagonalAwayMovementSmall.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-04-001-01-01-01"), diagonalAwayMovementSmall.getSymbol());

		diagonalAwayMovementSmallEmptyArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-04-001-01-02-05"),
				diagonalAwayMovementSmallEmptyArrowhead.getSymbol());
		diagonalAwayMovementSmallEmptyArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-04-001-01-02-01"),
				diagonalAwayMovementSmallEmptyArrowhead.getSymbol());

		diagonalAwayMovementSmallSchemaArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-04-001-01-03-05"),
				diagonalAwayMovementSmallSchemaArrowhead.getSymbol());
		diagonalAwayMovementSmallSchemaArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-04-001-01-03-01"),
				diagonalAwayMovementSmallSchemaArrowhead.getSymbol());

		diagonalAwayMovementMedium.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-04-001-02-01-05"), diagonalAwayMovementMedium.getSymbol());
		diagonalAwayMovementMedium.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-04-001-02-01-01"), diagonalAwayMovementMedium.getSymbol());

		diagonalAwayMovementMediumEmptyArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-04-001-02-02-05"),
				diagonalAwayMovementMediumEmptyArrowhead.getSymbol());
		diagonalAwayMovementMediumEmptyArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-04-001-02-02-01"),
				diagonalAwayMovementMediumEmptyArrowhead.getSymbol());

		diagonalAwayMovementMediumSchemaArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-04-001-02-03-05"),
				diagonalAwayMovementMediumSchemaArrowhead.getSymbol());
		diagonalAwayMovementMediumSchemaArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-04-001-02-03-01"),
				diagonalAwayMovementMediumSchemaArrowhead.getSymbol());

		diagonalAwayMovementLarge.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-04-001-03-01-05"), diagonalAwayMovementLarge.getSymbol());
		diagonalAwayMovementLarge.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-04-001-03-01-01"), diagonalAwayMovementLarge.getSymbol());

		diagonalAwayMovementLargeEmptyArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-04-001-03-02-05"),
				diagonalAwayMovementLargeEmptyArrowhead.getSymbol());
		diagonalAwayMovementLargeEmptyArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-04-001-03-02-01"),
				diagonalAwayMovementLargeEmptyArrowhead.getSymbol());

		diagonalAwayMovementLargeSchemaArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-04-001-03-03-05"),
				diagonalAwayMovementLargeSchemaArrowhead.getSymbol());
		diagonalAwayMovementLargeSchemaArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-04-001-03-03-01"),
				diagonalAwayMovementLargeSchemaArrowhead.getSymbol());

		diagonalAwayMovementLargest.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-04-001-04-01-05"), diagonalAwayMovementLargest.getSymbol());
		diagonalAwayMovementLargest.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-04-001-04-01-01"), diagonalAwayMovementLargest.getSymbol());

		diagonalAwayMovementLargestEmptyArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-04-001-04-02-05"),
				diagonalAwayMovementLargestEmptyArrowhead.getSymbol());
		diagonalAwayMovementLargestEmptyArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-04-001-04-02-01"),
				diagonalAwayMovementLargestEmptyArrowhead.getSymbol());

		diagonalAwayMovementLargestSchemaArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-04-001-04-03-05"),
				diagonalAwayMovementLargestSchemaArrowhead.getSymbol());
		diagonalAwayMovementLargestSchemaArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-04-001-04-03-01"),
				diagonalAwayMovementLargestSchemaArrowhead.getSymbol());

		diagonalTowardsMovementSmall.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-04-002-01-01-05"), diagonalTowardsMovementSmall.getSymbol());
		diagonalTowardsMovementSmall.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-04-002-01-01-01"), diagonalTowardsMovementSmall.getSymbol());

		diagonalTowardsMovementSmallEmptyArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-04-002-01-02-05"),
				diagonalTowardsMovementSmallEmptyArrowhead.getSymbol());
		diagonalTowardsMovementSmallEmptyArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-04-002-01-02-01"),
				diagonalTowardsMovementSmallEmptyArrowhead.getSymbol());

		diagonalTowardsMovementSmallSchemaArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-04-002-01-03-05"),
				diagonalTowardsMovementSmallSchemaArrowhead.getSymbol());
		diagonalTowardsMovementSmallSchemaArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-04-002-01-03-01"),
				diagonalTowardsMovementSmallSchemaArrowhead.getSymbol());

		diagonalTowardsMovementMedium.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-04-002-02-01-05"), diagonalTowardsMovementMedium.getSymbol());
		diagonalTowardsMovementMedium.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-04-002-02-01-01"), diagonalTowardsMovementMedium.getSymbol());

		diagonalTowardsMovementMediumEmptyArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-04-002-02-02-05"),
				diagonalTowardsMovementMediumEmptyArrowhead.getSymbol());
		diagonalTowardsMovementMediumEmptyArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-04-002-02-02-01"),
				diagonalTowardsMovementMediumEmptyArrowhead.getSymbol());

		diagonalTowardsMovementMediumSchemaArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-04-002-02-03-05"),
				diagonalTowardsMovementMediumSchemaArrowhead.getSymbol());
		diagonalTowardsMovementMediumSchemaArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-04-002-02-03-01"),
				diagonalTowardsMovementMediumSchemaArrowhead.getSymbol());

		diagonalTowardsMovementLarge.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-04-002-03-01-05"), diagonalTowardsMovementLarge.getSymbol());
		diagonalTowardsMovementLarge.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-04-002-03-01-01"), diagonalTowardsMovementLarge.getSymbol());

		diagonalTowardsMovementLargeEmptyArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-04-002-03-02-05"),
				diagonalTowardsMovementLargeEmptyArrowhead.getSymbol());
		diagonalTowardsMovementLargeEmptyArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-04-002-03-02-01"),
				diagonalTowardsMovementLargeEmptyArrowhead.getSymbol());

		diagonalTowardsMovementLargeSchemaArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-04-002-03-03-05"),
				diagonalTowardsMovementLargeSchemaArrowhead.getSymbol());
		diagonalTowardsMovementLargeSchemaArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-04-002-03-03-01"),
				diagonalTowardsMovementLargeSchemaArrowhead.getSymbol());

		diagonalTowardsMovementLargest.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-04-002-04-01-05"), diagonalTowardsMovementLargest.getSymbol());
		diagonalTowardsMovementLargest.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-04-002-04-01-01"), diagonalTowardsMovementLargest.getSymbol());

		diagonalTowardsMovementLargestEmptyArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-04-002-04-02-05"),
				diagonalTowardsMovementLargestEmptyArrowhead.getSymbol());
		diagonalTowardsMovementLargestEmptyArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-04-002-04-02-01"),
				diagonalTowardsMovementLargestEmptyArrowhead.getSymbol());

		diagonalTowardsMovementLargestSchemaArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-04-002-04-03-05"),
				diagonalTowardsMovementLargestSchemaArrowhead.getSymbol());
		diagonalTowardsMovementLargestSchemaArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-04-002-04-03-01"),
				diagonalTowardsMovementLargestSchemaArrowhead.getSymbol());

		diagonalBetweenAwaySmall.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-04-003-01-01-05"), diagonalBetweenAwaySmall.getSymbol());
		diagonalBetweenAwaySmall.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-04-003-01-01-01"), diagonalBetweenAwaySmall.getSymbol());

		diagonalBetweenAwaySmallEmptyArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-04-003-01-02-05"),
				diagonalBetweenAwaySmallEmptyArrowhead.getSymbol());
		diagonalBetweenAwaySmallEmptyArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-04-003-01-02-01"),
				diagonalBetweenAwaySmallEmptyArrowhead.getSymbol());

		diagonalBetweenAwaySmallSchemaArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-04-003-01-03-05"),
				diagonalBetweenAwaySmallSchemaArrowhead.getSymbol());
		diagonalBetweenAwaySmallSchemaArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-04-003-01-03-01"),
				diagonalBetweenAwaySmallSchemaArrowhead.getSymbol());

		diagonalBetweenAwayMedium.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-04-003-02-01-05"), diagonalBetweenAwayMedium.getSymbol());
		diagonalBetweenAwayMedium.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-04-003-02-01-01"), diagonalBetweenAwayMedium.getSymbol());

		diagonalBetweenAwayMediumEmptyArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-04-003-02-02-05"),
				diagonalBetweenAwayMediumEmptyArrowhead.getSymbol());
		diagonalBetweenAwayMediumEmptyArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-04-003-02-02-01"),
				diagonalBetweenAwayMediumEmptyArrowhead.getSymbol());

		diagonalBetweenAwayMediumSchemaArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-04-003-02-03-05"),
				diagonalBetweenAwayMediumSchemaArrowhead.getSymbol());
		diagonalBetweenAwayMediumSchemaArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-04-003-02-03-01"),
				diagonalBetweenAwayMediumSchemaArrowhead.getSymbol());

		diagonalBetweenAwayLarge.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-04-003-03-01-05"), diagonalBetweenAwayLarge.getSymbol());
		diagonalBetweenAwayLarge.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-04-003-03-01-01"), diagonalBetweenAwayLarge.getSymbol());

		diagonalBetweenAwayLargeEmptyArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-04-003-03-02-05"),
				diagonalBetweenAwayLargeEmptyArrowhead.getSymbol());
		diagonalBetweenAwayLargeEmptyArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-04-003-03-02-01"),
				diagonalBetweenAwayLargeEmptyArrowhead.getSymbol());

		diagonalBetweenAwayLargeSchemaArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-04-003-03-03-05"),
				diagonalBetweenAwayLargeSchemaArrowhead.getSymbol());
		diagonalBetweenAwayLargeSchemaArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-04-003-03-03-01"),
				diagonalBetweenAwayLargeSchemaArrowhead.getSymbol());

		diagonalBetweenAwayLargest.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-04-003-04-01-05"), diagonalBetweenAwayLargest.getSymbol());
		diagonalBetweenAwayLargest.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-04-003-04-01-01"), diagonalBetweenAwayLargest.getSymbol());

		diagonalBetweenAwayLargestEmptyArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-04-003-04-02-05"),
				diagonalBetweenAwayLargestEmptyArrowhead.getSymbol());
		diagonalBetweenAwayLargestEmptyArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-04-003-04-02-01"),
				diagonalBetweenAwayLargestEmptyArrowhead.getSymbol());

		diagonalBetweenAwayLargestSchemaArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-04-003-04-03-05"),
				diagonalBetweenAwayLargestSchemaArrowhead.getSymbol());
		diagonalBetweenAwayLargestSchemaArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-04-003-04-03-01"),
				diagonalBetweenAwayLargestSchemaArrowhead.getSymbol());

		diagonalBetweenTowardsSmall.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-04-004-01-01-05"), diagonalBetweenTowardsSmall.getSymbol());
		diagonalBetweenTowardsSmall.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-04-004-01-01-01"), diagonalBetweenTowardsSmall.getSymbol());

		diagonalBetweenTowardsSmallEmptyArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-04-004-01-02-05"),
				diagonalBetweenTowardsSmallEmptyArrowhead.getSymbol());
		diagonalBetweenTowardsSmallEmptyArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-04-004-01-02-01"),
				diagonalBetweenTowardsSmallEmptyArrowhead.getSymbol());

		diagonalBetweenTowardsSmallSchemaArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-04-004-01-03-05"),
				diagonalBetweenTowardsSmallSchemaArrowhead.getSymbol());
		diagonalBetweenTowardsSmallSchemaArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-04-004-01-03-01"),
				diagonalBetweenTowardsSmallSchemaArrowhead.getSymbol());

		diagonalBetweenTowardsMedium.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-04-004-02-01-05"), diagonalBetweenTowardsMedium.getSymbol());
		diagonalBetweenTowardsMedium.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-04-004-02-01-01"), diagonalBetweenTowardsMedium.getSymbol());

		diagonalBetweenTowardsMediumEmptyArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-04-004-02-02-05"),
				diagonalBetweenTowardsMediumEmptyArrowhead.getSymbol());
		diagonalBetweenTowardsMediumEmptyArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-04-004-02-02-01"),
				diagonalBetweenTowardsMediumEmptyArrowhead.getSymbol());

		diagonalBetweenTowardsMediumSchemaArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-04-004-02-03-05"),
				diagonalBetweenTowardsMediumSchemaArrowhead.getSymbol());
		diagonalBetweenTowardsMediumSchemaArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-04-004-02-03-01"),
				diagonalBetweenTowardsMediumSchemaArrowhead.getSymbol());

		diagonalBetweenTowardsLarge.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-04-004-03-01-05"), diagonalBetweenTowardsLarge.getSymbol());
		diagonalBetweenTowardsLarge.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-04-004-03-01-01"), diagonalBetweenTowardsLarge.getSymbol());

		diagonalBetweenTowardsLargeEmptyArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-04-004-03-02-05"),
				diagonalBetweenTowardsLargeEmptyArrowhead.getSymbol());
		diagonalBetweenTowardsLargeEmptyArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-04-004-03-02-01"),
				diagonalBetweenTowardsLargeEmptyArrowhead.getSymbol());

		diagonalBetweenTowardsLargeSchemaArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-04-004-03-03-05"),
				diagonalBetweenTowardsLargeSchemaArrowhead.getSymbol());
		diagonalBetweenTowardsLargeSchemaArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-04-004-03-03-01"),
				diagonalBetweenTowardsLargeSchemaArrowhead.getSymbol());

		diagonalBetweenTowardsLargest.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-04-004-04-01-05"), diagonalBetweenTowardsLargest.getSymbol());
		diagonalBetweenTowardsLargest.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-04-004-04-01-01"), diagonalBetweenTowardsLargest.getSymbol());

		diagonalBetweenTowardsLargestEmptyArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-04-004-04-02-05"),
				diagonalBetweenTowardsLargestEmptyArrowhead.getSymbol());
		diagonalBetweenTowardsLargestEmptyArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-04-004-04-02-01"),
				diagonalBetweenTowardsLargestEmptyArrowhead.getSymbol());

		diagonalBetweenTowardsLargestSchemaArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-04-004-04-03-05"),
				diagonalBetweenTowardsLargestSchemaArrowhead.getSymbol());
		diagonalBetweenTowardsLargestSchemaArrowhead.mirrorVertically();
		assertEquals(symbolFactory.createSymbol("02-04-004-04-03-01"),
				diagonalBetweenTowardsLargestSchemaArrowhead.getSymbol());
	}

	@Override
	public void testCanPitch() {
		assertFalse(diagonalAwayMovementSmall.canPitch());
		assertFalse(diagonalAwayMovementSmallEmptyArrowhead.canPitch());
		assertFalse(diagonalAwayMovementSmallSchemaArrowhead.canPitch());

		assertFalse(diagonalAwayMovementMedium.canPitch());
		assertFalse(diagonalAwayMovementMediumEmptyArrowhead.canPitch());
		assertFalse(diagonalAwayMovementMediumSchemaArrowhead.canPitch());

		assertFalse(diagonalAwayMovementLarge.canPitch());
		assertFalse(diagonalAwayMovementLargeEmptyArrowhead.canPitch());
		assertFalse(diagonalAwayMovementLargeSchemaArrowhead.canPitch());

		assertFalse(diagonalAwayMovementLargest.canPitch());
		assertFalse(diagonalAwayMovementLargestEmptyArrowhead.canPitch());
		assertFalse(diagonalAwayMovementLargestSchemaArrowhead.canPitch());

		assertFalse(diagonalTowardsMovementSmall.canPitch());
		assertFalse(diagonalTowardsMovementSmallEmptyArrowhead.canPitch());
		assertFalse(diagonalTowardsMovementSmallSchemaArrowhead.canPitch());

		assertFalse(diagonalTowardsMovementMedium.canPitch());
		assertFalse(diagonalTowardsMovementMediumEmptyArrowhead.canPitch());
		assertFalse(diagonalTowardsMovementMediumSchemaArrowhead.canPitch());

		assertFalse(diagonalTowardsMovementLarge.canPitch());
		assertFalse(diagonalTowardsMovementLargeEmptyArrowhead.canPitch());
		assertFalse(diagonalTowardsMovementLargeSchemaArrowhead.canPitch());

		assertFalse(diagonalTowardsMovementLargest.canPitch());
		assertFalse(diagonalTowardsMovementLargestEmptyArrowhead.canPitch());
		assertFalse(diagonalTowardsMovementLargestSchemaArrowhead.canPitch());

		assertFalse(diagonalBetweenAwaySmall.canPitch());
		assertFalse(diagonalBetweenAwaySmallEmptyArrowhead.canPitch());
		assertFalse(diagonalBetweenAwaySmallSchemaArrowhead.canPitch());

		assertFalse(diagonalBetweenAwayMedium.canPitch());
		assertFalse(diagonalBetweenAwayMediumEmptyArrowhead.canPitch());
		assertFalse(diagonalBetweenAwayMediumSchemaArrowhead.canPitch());

		assertFalse(diagonalBetweenAwayLarge.canPitch());
		assertFalse(diagonalBetweenAwayLargeEmptyArrowhead.canPitch());
		assertFalse(diagonalBetweenAwayLargeSchemaArrowhead.canPitch());

		assertFalse(diagonalBetweenAwayLargest.canPitch());
		assertFalse(diagonalBetweenAwayLargestEmptyArrowhead.canPitch());
		assertFalse(diagonalBetweenAwayLargestSchemaArrowhead.canPitch());

		assertFalse(diagonalBetweenTowardsSmall.canPitch());
		assertFalse(diagonalBetweenTowardsSmallEmptyArrowhead.canPitch());
		assertFalse(diagonalBetweenTowardsSmallSchemaArrowhead.canPitch());

		assertFalse(diagonalBetweenTowardsMedium.canPitch());
		assertFalse(diagonalBetweenTowardsMediumEmptyArrowhead.canPitch());
		assertFalse(diagonalBetweenTowardsMediumSchemaArrowhead.canPitch());

		assertFalse(diagonalBetweenTowardsLarge.canPitch());
		assertFalse(diagonalBetweenTowardsLargeEmptyArrowhead.canPitch());
		assertFalse(diagonalBetweenTowardsLargeSchemaArrowhead.canPitch());

		assertFalse(diagonalBetweenTowardsLargest.canPitch());
		assertFalse(diagonalBetweenTowardsLargestEmptyArrowhead.canPitch());
		assertFalse(diagonalBetweenTowardsLargestSchemaArrowhead.canPitch());

	}

	@Override
	public void testPitch() {

	}

	@Override
	public void testCanRoll() {

		assertFalse(diagonalAwayMovementSmall.canRoll());
		assertFalse(diagonalAwayMovementSmallEmptyArrowhead.canRoll());
		assertFalse(diagonalAwayMovementSmallSchemaArrowhead.canRoll());

		assertFalse(diagonalAwayMovementMedium.canRoll());
		assertFalse(diagonalAwayMovementMediumEmptyArrowhead.canRoll());
		assertFalse(diagonalAwayMovementMediumSchemaArrowhead.canRoll());

		assertFalse(diagonalAwayMovementLarge.canRoll());
		assertFalse(diagonalAwayMovementLargeEmptyArrowhead.canRoll());
		assertFalse(diagonalAwayMovementLargeSchemaArrowhead.canRoll());

		assertFalse(diagonalAwayMovementLargest.canRoll());
		assertFalse(diagonalAwayMovementLargestEmptyArrowhead.canRoll());
		assertFalse(diagonalAwayMovementLargestSchemaArrowhead.canRoll());

		assertFalse(diagonalTowardsMovementSmall.canRoll());
		assertFalse(diagonalTowardsMovementSmallEmptyArrowhead.canRoll());
		assertFalse(diagonalTowardsMovementSmallSchemaArrowhead.canRoll());

		assertFalse(diagonalTowardsMovementMedium.canRoll());
		assertFalse(diagonalTowardsMovementMediumEmptyArrowhead.canRoll());
		assertFalse(diagonalTowardsMovementMediumSchemaArrowhead.canRoll());

		assertFalse(diagonalTowardsMovementLarge.canRoll());
		assertFalse(diagonalTowardsMovementLargeEmptyArrowhead.canRoll());
		assertFalse(diagonalTowardsMovementLargeSchemaArrowhead.canRoll());

		assertFalse(diagonalTowardsMovementLargest.canRoll());
		assertFalse(diagonalTowardsMovementLargestEmptyArrowhead.canRoll());
		assertFalse(diagonalTowardsMovementLargestSchemaArrowhead.canRoll());

		assertFalse(diagonalBetweenAwaySmall.canRoll());
		assertFalse(diagonalBetweenAwaySmallEmptyArrowhead.canRoll());
		assertFalse(diagonalBetweenAwaySmallSchemaArrowhead.canRoll());

		assertFalse(diagonalBetweenAwayMedium.canRoll());
		assertFalse(diagonalBetweenAwayMediumEmptyArrowhead.canRoll());
		assertFalse(diagonalBetweenAwayMediumSchemaArrowhead.canRoll());

		assertFalse(diagonalBetweenAwayLarge.canRoll());
		assertFalse(diagonalBetweenAwayLargeEmptyArrowhead.canRoll());
		assertFalse(diagonalBetweenAwayLargeSchemaArrowhead.canRoll());

		assertFalse(diagonalBetweenAwayLargest.canRoll());
		assertFalse(diagonalBetweenAwayLargestEmptyArrowhead.canRoll());
		assertFalse(diagonalBetweenAwayLargestSchemaArrowhead.canRoll());

		assertFalse(diagonalBetweenTowardsSmall.canRoll());
		assertFalse(diagonalBetweenTowardsSmallEmptyArrowhead.canRoll());
		assertFalse(diagonalBetweenTowardsSmallSchemaArrowhead.canRoll());

		assertFalse(diagonalBetweenTowardsMedium.canRoll());
		assertFalse(diagonalBetweenTowardsMediumEmptyArrowhead.canRoll());
		assertFalse(diagonalBetweenTowardsMediumSchemaArrowhead.canRoll());

		assertFalse(diagonalBetweenTowardsLarge.canRoll());
		assertFalse(diagonalBetweenTowardsLargeEmptyArrowhead.canRoll());
		assertFalse(diagonalBetweenTowardsLargeSchemaArrowhead.canRoll());

		assertFalse(diagonalBetweenTowardsLargest.canRoll());
		assertFalse(diagonalBetweenTowardsLargestEmptyArrowhead.canRoll());
		assertFalse(diagonalBetweenTowardsLargestSchemaArrowhead.canRoll());

	}

	@Override
	public void testRoll() {

	}

	@Override
	public void testCanSwitchArrowHead() {

		assertTrue(diagonalAwayMovementSmall.canSwitchArrowHead());
		assertTrue(diagonalAwayMovementSmallEmptyArrowhead.canSwitchArrowHead());
		assertTrue(diagonalAwayMovementSmallSchemaArrowhead.canSwitchArrowHead());

		assertTrue(diagonalAwayMovementMedium.canSwitchArrowHead());
		assertTrue(diagonalAwayMovementMediumEmptyArrowhead.canSwitchArrowHead());
		assertTrue(diagonalAwayMovementMediumSchemaArrowhead.canSwitchArrowHead());

		assertTrue(diagonalAwayMovementLarge.canSwitchArrowHead());
		assertTrue(diagonalAwayMovementLargeEmptyArrowhead.canSwitchArrowHead());
		assertTrue(diagonalAwayMovementLargeSchemaArrowhead.canSwitchArrowHead());

		assertTrue(diagonalAwayMovementLargest.canSwitchArrowHead());
		assertTrue(diagonalAwayMovementLargestEmptyArrowhead.canSwitchArrowHead());
		assertTrue(diagonalAwayMovementLargestSchemaArrowhead.canSwitchArrowHead());

		assertTrue(diagonalTowardsMovementSmall.canSwitchArrowHead());
		assertTrue(diagonalTowardsMovementSmallEmptyArrowhead.canSwitchArrowHead());
		assertTrue(diagonalTowardsMovementSmallSchemaArrowhead.canSwitchArrowHead());

		assertTrue(diagonalTowardsMovementMedium.canSwitchArrowHead());
		assertTrue(diagonalTowardsMovementMediumEmptyArrowhead.canSwitchArrowHead());
		assertTrue(diagonalTowardsMovementMediumSchemaArrowhead.canSwitchArrowHead());

		assertTrue(diagonalTowardsMovementLarge.canSwitchArrowHead());
		assertTrue(diagonalTowardsMovementLargeEmptyArrowhead.canSwitchArrowHead());
		assertTrue(diagonalTowardsMovementLargeSchemaArrowhead.canSwitchArrowHead());

		assertTrue(diagonalTowardsMovementLargest.canSwitchArrowHead());
		assertTrue(diagonalTowardsMovementLargestEmptyArrowhead.canSwitchArrowHead());
		assertTrue(diagonalTowardsMovementLargestSchemaArrowhead.canSwitchArrowHead());

		assertTrue(diagonalBetweenAwaySmall.canSwitchArrowHead());
		assertTrue(diagonalBetweenAwaySmallEmptyArrowhead.canSwitchArrowHead());
		assertTrue(diagonalBetweenAwaySmallSchemaArrowhead.canSwitchArrowHead());

		assertTrue(diagonalBetweenAwayMedium.canSwitchArrowHead());
		assertTrue(diagonalBetweenAwayMediumEmptyArrowhead.canSwitchArrowHead());
		assertTrue(diagonalBetweenAwayMediumSchemaArrowhead.canSwitchArrowHead());

		assertTrue(diagonalBetweenAwayLarge.canSwitchArrowHead());
		assertTrue(diagonalBetweenAwayLargeEmptyArrowhead.canSwitchArrowHead());
		assertTrue(diagonalBetweenAwayLargeSchemaArrowhead.canSwitchArrowHead());

		assertTrue(diagonalBetweenAwayLargest.canSwitchArrowHead());
		assertTrue(diagonalBetweenAwayLargestEmptyArrowhead.canSwitchArrowHead());
		assertTrue(diagonalBetweenAwayLargestSchemaArrowhead.canSwitchArrowHead());

		assertTrue(diagonalBetweenTowardsSmall.canSwitchArrowHead());
		assertTrue(diagonalBetweenTowardsSmallEmptyArrowhead.canSwitchArrowHead());
		assertTrue(diagonalBetweenTowardsSmallSchemaArrowhead.canSwitchArrowHead());

		assertTrue(diagonalBetweenTowardsMedium.canSwitchArrowHead());
		assertTrue(diagonalBetweenTowardsMediumEmptyArrowhead.canSwitchArrowHead());
		assertTrue(diagonalBetweenTowardsMediumSchemaArrowhead.canSwitchArrowHead());

		assertTrue(diagonalBetweenTowardsLarge.canSwitchArrowHead());
		assertTrue(diagonalBetweenTowardsLargeEmptyArrowhead.canSwitchArrowHead());
		assertTrue(diagonalBetweenTowardsLargeSchemaArrowhead.canSwitchArrowHead());

		assertTrue(diagonalBetweenTowardsLargest.canSwitchArrowHead());
		assertTrue(diagonalBetweenTowardsLargestEmptyArrowhead.canSwitchArrowHead());
		assertTrue(diagonalBetweenTowardsLargestSchemaArrowhead.canSwitchArrowHead());

	}

	@Override
	public void testSwitchArrowHead() {

		diagonalAwayMovementSmall.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-04-001-01-02-01"), diagonalAwayMovementSmall.getSymbol());
		diagonalAwayMovementSmall.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-04-001-01-03-01"), diagonalAwayMovementSmall.getSymbol());
		diagonalAwayMovementSmall.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-04-001-01-01-01"), diagonalAwayMovementSmall.getSymbol());

		diagonalAwayMovementSmallEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-04-001-01-03-01"),
				diagonalAwayMovementSmallEmptyArrowhead.getSymbol());
		diagonalAwayMovementSmallEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-04-001-01-01-01"),
				diagonalAwayMovementSmallEmptyArrowhead.getSymbol());
		diagonalAwayMovementSmallEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-04-001-01-02-01"),
				diagonalAwayMovementSmallEmptyArrowhead.getSymbol());

		diagonalAwayMovementSmallSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-04-001-01-01-01"),
				diagonalAwayMovementSmallSchemaArrowhead.getSymbol());
		diagonalAwayMovementSmallSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-04-001-01-02-01"),
				diagonalAwayMovementSmallSchemaArrowhead.getSymbol());
		diagonalAwayMovementSmallSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-04-001-01-03-01"),
				diagonalAwayMovementSmallSchemaArrowhead.getSymbol());

		diagonalAwayMovementMedium.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-04-001-02-02-01"), diagonalAwayMovementMedium.getSymbol());
		diagonalAwayMovementMedium.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-04-001-02-03-01"), diagonalAwayMovementMedium.getSymbol());
		diagonalAwayMovementMedium.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-04-001-02-01-01"), diagonalAwayMovementMedium.getSymbol());

		diagonalAwayMovementMediumEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-04-001-02-03-01"),
				diagonalAwayMovementMediumEmptyArrowhead.getSymbol());
		diagonalAwayMovementMediumEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-04-001-02-01-01"),
				diagonalAwayMovementMediumEmptyArrowhead.getSymbol());
		diagonalAwayMovementMediumEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-04-001-02-02-01"),
				diagonalAwayMovementMediumEmptyArrowhead.getSymbol());

		diagonalAwayMovementMediumSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-04-001-02-01-01"),
				diagonalAwayMovementMediumSchemaArrowhead.getSymbol());
		diagonalAwayMovementMediumSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-04-001-02-02-01"),
				diagonalAwayMovementMediumSchemaArrowhead.getSymbol());
		diagonalAwayMovementMediumSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-04-001-02-03-01"),
				diagonalAwayMovementMediumSchemaArrowhead.getSymbol());

		diagonalAwayMovementLarge.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-04-001-03-02-01"), diagonalAwayMovementLarge.getSymbol());
		diagonalAwayMovementLarge.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-04-001-03-03-01"), diagonalAwayMovementLarge.getSymbol());
		diagonalAwayMovementLarge.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-04-001-03-01-01"), diagonalAwayMovementLarge.getSymbol());

		diagonalAwayMovementLargeEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-04-001-03-03-01"),
				diagonalAwayMovementLargeEmptyArrowhead.getSymbol());
		diagonalAwayMovementLargeEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-04-001-03-01-01"),
				diagonalAwayMovementLargeEmptyArrowhead.getSymbol());
		diagonalAwayMovementLargeEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-04-001-03-02-01"),
				diagonalAwayMovementLargeEmptyArrowhead.getSymbol());

		diagonalAwayMovementLargeSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-04-001-03-01-01"),
				diagonalAwayMovementLargeSchemaArrowhead.getSymbol());
		diagonalAwayMovementLargeSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-04-001-03-02-01"),
				diagonalAwayMovementLargeSchemaArrowhead.getSymbol());
		diagonalAwayMovementLargeSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-04-001-03-03-01"),
				diagonalAwayMovementLargeSchemaArrowhead.getSymbol());

		diagonalAwayMovementLargest.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-04-001-04-02-01"), diagonalAwayMovementLargest.getSymbol());
		diagonalAwayMovementLargest.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-04-001-04-03-01"), diagonalAwayMovementLargest.getSymbol());
		diagonalAwayMovementLargest.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-04-001-04-01-01"), diagonalAwayMovementLargest.getSymbol());

		diagonalAwayMovementLargestEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-04-001-04-03-01"),
				diagonalAwayMovementLargestEmptyArrowhead.getSymbol());
		diagonalAwayMovementLargestEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-04-001-04-01-01"),
				diagonalAwayMovementLargestEmptyArrowhead.getSymbol());
		diagonalAwayMovementLargestEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-04-001-04-02-01"),
				diagonalAwayMovementLargestEmptyArrowhead.getSymbol());

		diagonalAwayMovementLargestSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-04-001-04-01-01"),
				diagonalAwayMovementLargestSchemaArrowhead.getSymbol());
		diagonalAwayMovementLargestSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-04-001-04-02-01"),
				diagonalAwayMovementLargestSchemaArrowhead.getSymbol());
		diagonalAwayMovementLargestSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-04-001-04-03-01"),
				diagonalAwayMovementLargestSchemaArrowhead.getSymbol());

		diagonalTowardsMovementSmall.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-04-002-01-02-01"), diagonalTowardsMovementSmall.getSymbol());
		diagonalTowardsMovementSmall.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-04-002-01-03-01"), diagonalTowardsMovementSmall.getSymbol());
		diagonalTowardsMovementSmall.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-04-002-01-01-01"), diagonalTowardsMovementSmall.getSymbol());

		diagonalTowardsMovementSmallEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-04-002-01-03-01"),
				diagonalTowardsMovementSmallEmptyArrowhead.getSymbol());
		diagonalTowardsMovementSmallEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-04-002-01-01-01"),
				diagonalTowardsMovementSmallEmptyArrowhead.getSymbol());
		diagonalTowardsMovementSmallEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-04-002-01-02-01"),
				diagonalTowardsMovementSmallEmptyArrowhead.getSymbol());

		diagonalTowardsMovementSmallSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-04-002-01-01-01"),
				diagonalTowardsMovementSmallSchemaArrowhead.getSymbol());
		diagonalTowardsMovementSmallSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-04-002-01-02-01"),
				diagonalTowardsMovementSmallSchemaArrowhead.getSymbol());
		diagonalTowardsMovementSmallSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-04-002-01-03-01"),
				diagonalTowardsMovementSmallSchemaArrowhead.getSymbol());

		diagonalTowardsMovementMedium.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-04-002-02-02-01"), diagonalTowardsMovementMedium.getSymbol());
		diagonalTowardsMovementMedium.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-04-002-02-03-01"), diagonalTowardsMovementMedium.getSymbol());
		diagonalTowardsMovementMedium.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-04-002-02-01-01"), diagonalTowardsMovementMedium.getSymbol());

		diagonalTowardsMovementMediumEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-04-002-02-03-01"),
				diagonalTowardsMovementMediumEmptyArrowhead.getSymbol());
		diagonalTowardsMovementMediumEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-04-002-02-01-01"),
				diagonalTowardsMovementMediumEmptyArrowhead.getSymbol());
		diagonalTowardsMovementMediumEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-04-002-02-02-01"),
				diagonalTowardsMovementMediumEmptyArrowhead.getSymbol());

		diagonalTowardsMovementMediumSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-04-002-02-01-01"),
				diagonalTowardsMovementMediumSchemaArrowhead.getSymbol());
		diagonalTowardsMovementMediumSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-04-002-02-02-01"),
				diagonalTowardsMovementMediumSchemaArrowhead.getSymbol());
		diagonalTowardsMovementMediumSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-04-002-02-03-01"),
				diagonalTowardsMovementMediumSchemaArrowhead.getSymbol());

		diagonalTowardsMovementLarge.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-04-002-03-02-01"), diagonalTowardsMovementLarge.getSymbol());
		diagonalTowardsMovementLarge.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-04-002-03-03-01"), diagonalTowardsMovementLarge.getSymbol());
		diagonalTowardsMovementLarge.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-04-002-03-01-01"), diagonalTowardsMovementLarge.getSymbol());

		diagonalTowardsMovementLargeEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-04-002-03-03-01"),
				diagonalTowardsMovementLargeEmptyArrowhead.getSymbol());
		diagonalTowardsMovementLargeEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-04-002-03-01-01"),
				diagonalTowardsMovementLargeEmptyArrowhead.getSymbol());
		diagonalTowardsMovementLargeEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-04-002-03-02-01"),
				diagonalTowardsMovementLargeEmptyArrowhead.getSymbol());

		diagonalTowardsMovementLargeSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-04-002-03-01-01"),
				diagonalTowardsMovementLargeSchemaArrowhead.getSymbol());
		diagonalTowardsMovementLargeSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-04-002-03-02-01"),
				diagonalTowardsMovementLargeSchemaArrowhead.getSymbol());
		diagonalTowardsMovementLargeSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-04-002-03-03-01"),
				diagonalTowardsMovementLargeSchemaArrowhead.getSymbol());

		diagonalTowardsMovementLargest.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-04-002-04-02-01"), diagonalTowardsMovementLargest.getSymbol());
		diagonalTowardsMovementLargest.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-04-002-04-03-01"), diagonalTowardsMovementLargest.getSymbol());
		diagonalTowardsMovementLargest.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-04-002-04-01-01"), diagonalTowardsMovementLargest.getSymbol());

		diagonalTowardsMovementLargestEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-04-002-04-03-01"),
				diagonalTowardsMovementLargestEmptyArrowhead.getSymbol());
		diagonalTowardsMovementLargestEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-04-002-04-01-01"),
				diagonalTowardsMovementLargestEmptyArrowhead.getSymbol());
		diagonalTowardsMovementLargestEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-04-002-04-02-01"),
				diagonalTowardsMovementLargestEmptyArrowhead.getSymbol());

		diagonalTowardsMovementLargestSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-04-002-04-01-01"),
				diagonalTowardsMovementLargestSchemaArrowhead.getSymbol());
		diagonalTowardsMovementLargestSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-04-002-04-02-01"),
				diagonalTowardsMovementLargestSchemaArrowhead.getSymbol());
		diagonalTowardsMovementLargestSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-04-002-04-03-01"),
				diagonalTowardsMovementLargestSchemaArrowhead.getSymbol());

		diagonalBetweenAwaySmall.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-04-003-01-02-01"), diagonalBetweenAwaySmall.getSymbol());
		diagonalBetweenAwaySmall.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-04-003-01-03-01"), diagonalBetweenAwaySmall.getSymbol());
		diagonalBetweenAwaySmall.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-04-003-01-01-01"), diagonalBetweenAwaySmall.getSymbol());

		diagonalBetweenAwaySmallEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-04-003-01-03-01"),
				diagonalBetweenAwaySmallEmptyArrowhead.getSymbol());
		diagonalBetweenAwaySmallEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-04-003-01-01-01"),
				diagonalBetweenAwaySmallEmptyArrowhead.getSymbol());
		diagonalBetweenAwaySmallEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-04-003-01-02-01"),
				diagonalBetweenAwaySmallEmptyArrowhead.getSymbol());

		diagonalBetweenAwaySmallSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-04-003-01-01-01"),
				diagonalBetweenAwaySmallSchemaArrowhead.getSymbol());
		diagonalBetweenAwaySmallSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-04-003-01-02-01"),
				diagonalBetweenAwaySmallSchemaArrowhead.getSymbol());
		diagonalBetweenAwaySmallSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-04-003-01-03-01"),
				diagonalBetweenAwaySmallSchemaArrowhead.getSymbol());

		diagonalBetweenAwayMedium.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-04-003-02-02-01"), diagonalBetweenAwayMedium.getSymbol());
		diagonalBetweenAwayMedium.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-04-003-02-03-01"), diagonalBetweenAwayMedium.getSymbol());
		diagonalBetweenAwayMedium.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-04-003-02-01-01"), diagonalBetweenAwayMedium.getSymbol());

		diagonalBetweenAwayMediumEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-04-003-02-03-01"),
				diagonalBetweenAwayMediumEmptyArrowhead.getSymbol());
		diagonalBetweenAwayMediumEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-04-003-02-01-01"),
				diagonalBetweenAwayMediumEmptyArrowhead.getSymbol());
		diagonalBetweenAwayMediumEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-04-003-02-02-01"),
				diagonalBetweenAwayMediumEmptyArrowhead.getSymbol());

		diagonalBetweenAwayMediumSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-04-003-02-01-01"),
				diagonalBetweenAwayMediumSchemaArrowhead.getSymbol());
		diagonalBetweenAwayMediumSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-04-003-02-02-01"),
				diagonalBetweenAwayMediumSchemaArrowhead.getSymbol());
		diagonalBetweenAwayMediumSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-04-003-02-03-01"),
				diagonalBetweenAwayMediumSchemaArrowhead.getSymbol());

		diagonalBetweenAwayLarge.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-04-003-03-02-01"), diagonalBetweenAwayLarge.getSymbol());
		diagonalBetweenAwayLarge.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-04-003-03-03-01"), diagonalBetweenAwayLarge.getSymbol());
		diagonalBetweenAwayLarge.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-04-003-03-01-01"), diagonalBetweenAwayLarge.getSymbol());

		diagonalBetweenAwayLargeEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-04-003-03-03-01"),
				diagonalBetweenAwayLargeEmptyArrowhead.getSymbol());
		diagonalBetweenAwayLargeEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-04-003-03-01-01"),
				diagonalBetweenAwayLargeEmptyArrowhead.getSymbol());
		diagonalBetweenAwayLargeEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-04-003-03-02-01"),
				diagonalBetweenAwayLargeEmptyArrowhead.getSymbol());

		diagonalBetweenAwayLargeSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-04-003-03-01-01"),
				diagonalBetweenAwayLargeSchemaArrowhead.getSymbol());
		diagonalBetweenAwayLargeSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-04-003-03-02-01"),
				diagonalBetweenAwayLargeSchemaArrowhead.getSymbol());
		diagonalBetweenAwayLargeSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-04-003-03-03-01"),
				diagonalBetweenAwayLargeSchemaArrowhead.getSymbol());

		diagonalBetweenAwayLargest.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-04-003-04-02-01"), diagonalBetweenAwayLargest.getSymbol());
		diagonalBetweenAwayLargest.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-04-003-04-03-01"), diagonalBetweenAwayLargest.getSymbol());
		diagonalBetweenAwayLargest.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-04-003-04-01-01"), diagonalBetweenAwayLargest.getSymbol());

		diagonalBetweenAwayLargestEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-04-003-04-03-01"),
				diagonalBetweenAwayLargestEmptyArrowhead.getSymbol());
		diagonalBetweenAwayLargestEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-04-003-04-01-01"),
				diagonalBetweenAwayLargestEmptyArrowhead.getSymbol());
		diagonalBetweenAwayLargestEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-04-003-04-02-01"),
				diagonalBetweenAwayLargestEmptyArrowhead.getSymbol());

		diagonalBetweenAwayLargestSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-04-003-04-01-01"),
				diagonalBetweenAwayLargestSchemaArrowhead.getSymbol());
		diagonalBetweenAwayLargestSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-04-003-04-02-01"),
				diagonalBetweenAwayLargestSchemaArrowhead.getSymbol());
		diagonalBetweenAwayLargestSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-04-003-04-03-01"),
				diagonalBetweenAwayLargestSchemaArrowhead.getSymbol());

		diagonalBetweenTowardsSmall.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-04-004-01-02-01"), diagonalBetweenTowardsSmall.getSymbol());
		diagonalBetweenTowardsSmall.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-04-004-01-03-01"), diagonalBetweenTowardsSmall.getSymbol());
		diagonalBetweenTowardsSmall.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-04-004-01-01-01"), diagonalBetweenTowardsSmall.getSymbol());

		diagonalBetweenTowardsSmallEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-04-004-01-03-01"),
				diagonalBetweenTowardsSmallEmptyArrowhead.getSymbol());
		diagonalBetweenTowardsSmallEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-04-004-01-01-01"),
				diagonalBetweenTowardsSmallEmptyArrowhead.getSymbol());
		diagonalBetweenTowardsSmallEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-04-004-01-02-01"),
				diagonalBetweenTowardsSmallEmptyArrowhead.getSymbol());

		diagonalBetweenTowardsSmallSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-04-004-01-01-01"),
				diagonalBetweenTowardsSmallSchemaArrowhead.getSymbol());
		diagonalBetweenTowardsSmallSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-04-004-01-02-01"),
				diagonalBetweenTowardsSmallSchemaArrowhead.getSymbol());
		diagonalBetweenTowardsSmallSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-04-004-01-03-01"),
				diagonalBetweenTowardsSmallSchemaArrowhead.getSymbol());

		diagonalBetweenTowardsMedium.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-04-004-02-02-01"), diagonalBetweenTowardsMedium.getSymbol());
		diagonalBetweenTowardsMedium.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-04-004-02-03-01"), diagonalBetweenTowardsMedium.getSymbol());
		diagonalBetweenTowardsMedium.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-04-004-02-01-01"), diagonalBetweenTowardsMedium.getSymbol());

		diagonalBetweenTowardsMediumEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-04-004-02-03-01"),
				diagonalBetweenTowardsMediumEmptyArrowhead.getSymbol());
		diagonalBetweenTowardsMediumEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-04-004-02-01-01"),
				diagonalBetweenTowardsMediumEmptyArrowhead.getSymbol());
		diagonalBetweenTowardsMediumEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-04-004-02-02-01"),
				diagonalBetweenTowardsMediumEmptyArrowhead.getSymbol());

		diagonalBetweenTowardsMediumSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-04-004-02-01-01"),
				diagonalBetweenTowardsMediumSchemaArrowhead.getSymbol());
		diagonalBetweenTowardsMediumSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-04-004-02-02-01"),
				diagonalBetweenTowardsMediumSchemaArrowhead.getSymbol());
		diagonalBetweenTowardsMediumSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-04-004-02-03-01"),
				diagonalBetweenTowardsMediumSchemaArrowhead.getSymbol());

		diagonalBetweenTowardsLarge.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-04-004-03-02-01"), diagonalBetweenTowardsLarge.getSymbol());
		diagonalBetweenTowardsLarge.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-04-004-03-03-01"), diagonalBetweenTowardsLarge.getSymbol());
		diagonalBetweenTowardsLarge.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-04-004-03-01-01"), diagonalBetweenTowardsLarge.getSymbol());

		diagonalBetweenTowardsLargeEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-04-004-03-03-01"),
				diagonalBetweenTowardsLargeEmptyArrowhead.getSymbol());
		diagonalBetweenTowardsLargeEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-04-004-03-01-01"),
				diagonalBetweenTowardsLargeEmptyArrowhead.getSymbol());
		diagonalBetweenTowardsLargeEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-04-004-03-02-01"),
				diagonalBetweenTowardsLargeEmptyArrowhead.getSymbol());

		diagonalBetweenTowardsLargeSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-04-004-03-01-01"),
				diagonalBetweenTowardsLargeSchemaArrowhead.getSymbol());
		diagonalBetweenTowardsLargeSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-04-004-03-02-01"),
				diagonalBetweenTowardsLargeSchemaArrowhead.getSymbol());
		diagonalBetweenTowardsLargeSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-04-004-03-03-01"),
				diagonalBetweenTowardsLargeSchemaArrowhead.getSymbol());

		diagonalBetweenTowardsLargest.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-04-004-04-02-01"), diagonalBetweenTowardsLargest.getSymbol());
		diagonalBetweenTowardsLargest.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-04-004-04-03-01"), diagonalBetweenTowardsLargest.getSymbol());
		diagonalBetweenTowardsLargest.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-04-004-04-01-01"), diagonalBetweenTowardsLargest.getSymbol());

		diagonalBetweenTowardsLargestEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-04-004-04-03-01"),
				diagonalBetweenTowardsLargestEmptyArrowhead.getSymbol());
		diagonalBetweenTowardsLargestEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-04-004-04-01-01"),
				diagonalBetweenTowardsLargestEmptyArrowhead.getSymbol());
		diagonalBetweenTowardsLargestEmptyArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-04-004-04-02-01"),
				diagonalBetweenTowardsLargestEmptyArrowhead.getSymbol());

		diagonalBetweenTowardsLargestSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-04-004-04-01-01"),
				diagonalBetweenTowardsLargestSchemaArrowhead.getSymbol());
		diagonalBetweenTowardsLargestSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-04-004-04-02-01"),
				diagonalBetweenTowardsLargestSchemaArrowhead.getSymbol());
		diagonalBetweenTowardsLargestSchemaArrowhead.switchArrowHead();
		assertEquals(symbolFactory.createSymbol("02-04-004-04-03-01"),
				diagonalBetweenTowardsLargestSchemaArrowhead.getSymbol());

	}

	@Override
	public void testCanSwitchToNormalArrows() {

		assertFalse(diagonalAwayMovementSmall.canSwitchToNormalArrows());
		assertFalse(diagonalAwayMovementSmallEmptyArrowhead.canSwitchToNormalArrows());
		assertFalse(diagonalAwayMovementSmallSchemaArrowhead.canSwitchToNormalArrows());

		assertFalse(diagonalAwayMovementMedium.canSwitchToNormalArrows());
		assertFalse(diagonalAwayMovementMediumEmptyArrowhead.canSwitchToNormalArrows());
		assertFalse(diagonalAwayMovementMediumSchemaArrowhead.canSwitchToNormalArrows());

		assertFalse(diagonalAwayMovementLarge.canSwitchToNormalArrows());
		assertFalse(diagonalAwayMovementLargeEmptyArrowhead.canSwitchToNormalArrows());
		assertFalse(diagonalAwayMovementLargeSchemaArrowhead.canSwitchToNormalArrows());

		assertFalse(diagonalAwayMovementLargest.canSwitchToNormalArrows());
		assertFalse(diagonalAwayMovementLargestEmptyArrowhead.canSwitchToNormalArrows());
		assertFalse(diagonalAwayMovementLargestSchemaArrowhead.canSwitchToNormalArrows());

		assertFalse(diagonalTowardsMovementSmall.canSwitchToNormalArrows());
		assertFalse(diagonalTowardsMovementSmallEmptyArrowhead.canSwitchToNormalArrows());
		assertFalse(diagonalTowardsMovementSmallSchemaArrowhead.canSwitchToNormalArrows());

		assertFalse(diagonalTowardsMovementMedium.canSwitchToNormalArrows());
		assertFalse(diagonalTowardsMovementMediumEmptyArrowhead.canSwitchToNormalArrows());
		assertFalse(diagonalTowardsMovementMediumSchemaArrowhead.canSwitchToNormalArrows());

		assertFalse(diagonalTowardsMovementLarge.canSwitchToNormalArrows());
		assertFalse(diagonalTowardsMovementLargeEmptyArrowhead.canSwitchToNormalArrows());
		assertFalse(diagonalTowardsMovementLargeSchemaArrowhead.canSwitchToNormalArrows());

		assertFalse(diagonalTowardsMovementLargest.canSwitchToNormalArrows());
		assertFalse(diagonalTowardsMovementLargestEmptyArrowhead.canSwitchToNormalArrows());
		assertFalse(diagonalTowardsMovementLargestSchemaArrowhead.canSwitchToNormalArrows());

		assertFalse(diagonalBetweenAwaySmall.canSwitchToNormalArrows());
		assertFalse(diagonalBetweenAwaySmallEmptyArrowhead.canSwitchToNormalArrows());
		assertFalse(diagonalBetweenAwaySmallSchemaArrowhead.canSwitchToNormalArrows());

		assertFalse(diagonalBetweenAwayMedium.canSwitchToNormalArrows());
		assertFalse(diagonalBetweenAwayMediumEmptyArrowhead.canSwitchToNormalArrows());
		assertFalse(diagonalBetweenAwayMediumSchemaArrowhead.canSwitchToNormalArrows());

		assertFalse(diagonalBetweenAwayLarge.canSwitchToNormalArrows());
		assertFalse(diagonalBetweenAwayLargeEmptyArrowhead.canSwitchToNormalArrows());
		assertFalse(diagonalBetweenAwayLargeSchemaArrowhead.canSwitchToNormalArrows());

		assertFalse(diagonalBetweenAwayLargest.canSwitchToNormalArrows());
		assertFalse(diagonalBetweenAwayLargestEmptyArrowhead.canSwitchToNormalArrows());
		assertFalse(diagonalBetweenAwayLargestSchemaArrowhead.canSwitchToNormalArrows());

		assertFalse(diagonalBetweenTowardsSmall.canSwitchToNormalArrows());
		assertFalse(diagonalBetweenTowardsSmallEmptyArrowhead.canSwitchToNormalArrows());
		assertFalse(diagonalBetweenTowardsSmallSchemaArrowhead.canSwitchToNormalArrows());

		assertFalse(diagonalBetweenTowardsMedium.canSwitchToNormalArrows());
		assertFalse(diagonalBetweenTowardsMediumEmptyArrowhead.canSwitchToNormalArrows());
		assertFalse(diagonalBetweenTowardsMediumSchemaArrowhead.canSwitchToNormalArrows());

		assertFalse(diagonalBetweenTowardsLarge.canSwitchToNormalArrows());
		assertFalse(diagonalBetweenTowardsLargeEmptyArrowhead.canSwitchToNormalArrows());
		assertFalse(diagonalBetweenTowardsLargeSchemaArrowhead.canSwitchToNormalArrows());

		assertFalse(diagonalBetweenTowardsLargest.canSwitchToNormalArrows());
		assertFalse(diagonalBetweenTowardsLargestEmptyArrowhead.canSwitchToNormalArrows());
		assertFalse(diagonalBetweenTowardsLargestSchemaArrowhead.canSwitchToNormalArrows());

	}

	@Override
	public void testSwitchToNormalArrows() {

	}

	@Override
	public void testCanSwitchToAlternatingArrows() {

		assertFalse(diagonalAwayMovementSmall.canSwitchToAlternatingArrows());
		assertFalse(diagonalAwayMovementSmallEmptyArrowhead.canSwitchToAlternatingArrows());
		assertFalse(diagonalAwayMovementSmallSchemaArrowhead.canSwitchToAlternatingArrows());

		assertFalse(diagonalAwayMovementMedium.canSwitchToAlternatingArrows());
		assertFalse(diagonalAwayMovementMediumEmptyArrowhead.canSwitchToAlternatingArrows());
		assertFalse(diagonalAwayMovementMediumSchemaArrowhead.canSwitchToAlternatingArrows());

		assertFalse(diagonalAwayMovementLarge.canSwitchToAlternatingArrows());
		assertFalse(diagonalAwayMovementLargeEmptyArrowhead.canSwitchToAlternatingArrows());
		assertFalse(diagonalAwayMovementLargeSchemaArrowhead.canSwitchToAlternatingArrows());

		assertFalse(diagonalAwayMovementLargest.canSwitchToAlternatingArrows());
		assertFalse(diagonalAwayMovementLargestEmptyArrowhead.canSwitchToAlternatingArrows());
		assertFalse(diagonalAwayMovementLargestSchemaArrowhead.canSwitchToAlternatingArrows());

		assertFalse(diagonalTowardsMovementSmall.canSwitchToAlternatingArrows());
		assertFalse(diagonalTowardsMovementSmallEmptyArrowhead.canSwitchToAlternatingArrows());
		assertFalse(diagonalTowardsMovementSmallSchemaArrowhead.canSwitchToAlternatingArrows());

		assertFalse(diagonalTowardsMovementMedium.canSwitchToAlternatingArrows());
		assertFalse(diagonalTowardsMovementMediumEmptyArrowhead.canSwitchToAlternatingArrows());
		assertFalse(diagonalTowardsMovementMediumSchemaArrowhead.canSwitchToAlternatingArrows());

		assertFalse(diagonalTowardsMovementLarge.canSwitchToAlternatingArrows());
		assertFalse(diagonalTowardsMovementLargeEmptyArrowhead.canSwitchToAlternatingArrows());
		assertFalse(diagonalTowardsMovementLargeSchemaArrowhead.canSwitchToAlternatingArrows());

		assertFalse(diagonalTowardsMovementLargest.canSwitchToAlternatingArrows());
		assertFalse(diagonalTowardsMovementLargestEmptyArrowhead.canSwitchToAlternatingArrows());
		assertFalse(diagonalTowardsMovementLargestSchemaArrowhead.canSwitchToAlternatingArrows());

		assertFalse(diagonalBetweenAwaySmall.canSwitchToAlternatingArrows());
		assertFalse(diagonalBetweenAwaySmallEmptyArrowhead.canSwitchToAlternatingArrows());
		assertFalse(diagonalBetweenAwaySmallSchemaArrowhead.canSwitchToAlternatingArrows());

		assertFalse(diagonalBetweenAwayMedium.canSwitchToAlternatingArrows());
		assertFalse(diagonalBetweenAwayMediumEmptyArrowhead.canSwitchToAlternatingArrows());
		assertFalse(diagonalBetweenAwayMediumSchemaArrowhead.canSwitchToAlternatingArrows());

		assertFalse(diagonalBetweenAwayLarge.canSwitchToAlternatingArrows());
		assertFalse(diagonalBetweenAwayLargeEmptyArrowhead.canSwitchToAlternatingArrows());
		assertFalse(diagonalBetweenAwayLargeSchemaArrowhead.canSwitchToAlternatingArrows());

		assertFalse(diagonalBetweenAwayLargest.canSwitchToAlternatingArrows());
		assertFalse(diagonalBetweenAwayLargestEmptyArrowhead.canSwitchToAlternatingArrows());
		assertFalse(diagonalBetweenAwayLargestSchemaArrowhead.canSwitchToAlternatingArrows());

		assertFalse(diagonalBetweenTowardsSmall.canSwitchToAlternatingArrows());
		assertFalse(diagonalBetweenTowardsSmallEmptyArrowhead.canSwitchToAlternatingArrows());
		assertFalse(diagonalBetweenTowardsSmallSchemaArrowhead.canSwitchToAlternatingArrows());

		assertFalse(diagonalBetweenTowardsMedium.canSwitchToAlternatingArrows());
		assertFalse(diagonalBetweenTowardsMediumEmptyArrowhead.canSwitchToAlternatingArrows());
		assertFalse(diagonalBetweenTowardsMediumSchemaArrowhead.canSwitchToAlternatingArrows());

		assertFalse(diagonalBetweenTowardsLarge.canSwitchToAlternatingArrows());
		assertFalse(diagonalBetweenTowardsLargeEmptyArrowhead.canSwitchToAlternatingArrows());
		assertFalse(diagonalBetweenTowardsLargeSchemaArrowhead.canSwitchToAlternatingArrows());

		assertFalse(diagonalBetweenTowardsLargest.canSwitchToAlternatingArrows());
		assertFalse(diagonalBetweenTowardsLargestEmptyArrowhead.canSwitchToAlternatingArrows());
		assertFalse(diagonalBetweenTowardsLargestSchemaArrowhead.canSwitchToAlternatingArrows());

	}

	@Override
	public void testSwitchToAlternatingArrows() {

	}

	@Override
	public void testCanSwitchStartingPoint() {

		assertFalse(diagonalAwayMovementSmall.canSwitchStartingPoint());
		assertFalse(diagonalAwayMovementSmallEmptyArrowhead.canSwitchStartingPoint());
		assertFalse(diagonalAwayMovementSmallSchemaArrowhead.canSwitchStartingPoint());

		assertFalse(diagonalAwayMovementMedium.canSwitchStartingPoint());
		assertFalse(diagonalAwayMovementMediumEmptyArrowhead.canSwitchStartingPoint());
		assertFalse(diagonalAwayMovementMediumSchemaArrowhead.canSwitchStartingPoint());

		assertFalse(diagonalAwayMovementLarge.canSwitchStartingPoint());
		assertFalse(diagonalAwayMovementLargeEmptyArrowhead.canSwitchStartingPoint());
		assertFalse(diagonalAwayMovementLargeSchemaArrowhead.canSwitchStartingPoint());

		assertFalse(diagonalAwayMovementLargest.canSwitchStartingPoint());
		assertFalse(diagonalAwayMovementLargestEmptyArrowhead.canSwitchStartingPoint());
		assertFalse(diagonalAwayMovementLargestSchemaArrowhead.canSwitchStartingPoint());

		assertFalse(diagonalTowardsMovementSmall.canSwitchStartingPoint());
		assertFalse(diagonalTowardsMovementSmallEmptyArrowhead.canSwitchStartingPoint());
		assertFalse(diagonalTowardsMovementSmallSchemaArrowhead.canSwitchStartingPoint());

		assertFalse(diagonalTowardsMovementMedium.canSwitchStartingPoint());
		assertFalse(diagonalTowardsMovementMediumEmptyArrowhead.canSwitchStartingPoint());
		assertFalse(diagonalTowardsMovementMediumSchemaArrowhead.canSwitchStartingPoint());

		assertFalse(diagonalTowardsMovementLarge.canSwitchStartingPoint());
		assertFalse(diagonalTowardsMovementLargeEmptyArrowhead.canSwitchStartingPoint());
		assertFalse(diagonalTowardsMovementLargeSchemaArrowhead.canSwitchStartingPoint());

		assertFalse(diagonalTowardsMovementLargest.canSwitchStartingPoint());
		assertFalse(diagonalTowardsMovementLargestEmptyArrowhead.canSwitchStartingPoint());
		assertFalse(diagonalTowardsMovementLargestSchemaArrowhead.canSwitchStartingPoint());

		assertFalse(diagonalBetweenAwaySmall.canSwitchStartingPoint());
		assertFalse(diagonalBetweenAwaySmallEmptyArrowhead.canSwitchStartingPoint());
		assertFalse(diagonalBetweenAwaySmallSchemaArrowhead.canSwitchStartingPoint());

		assertFalse(diagonalBetweenAwayMedium.canSwitchStartingPoint());
		assertFalse(diagonalBetweenAwayMediumEmptyArrowhead.canSwitchStartingPoint());
		assertFalse(diagonalBetweenAwayMediumSchemaArrowhead.canSwitchStartingPoint());

		assertFalse(diagonalBetweenAwayLarge.canSwitchStartingPoint());
		assertFalse(diagonalBetweenAwayLargeEmptyArrowhead.canSwitchStartingPoint());
		assertFalse(diagonalBetweenAwayLargeSchemaArrowhead.canSwitchStartingPoint());

		assertFalse(diagonalBetweenAwayLargest.canSwitchStartingPoint());
		assertFalse(diagonalBetweenAwayLargestEmptyArrowhead.canSwitchStartingPoint());
		assertFalse(diagonalBetweenAwayLargestSchemaArrowhead.canSwitchStartingPoint());

		assertFalse(diagonalBetweenTowardsSmall.canSwitchStartingPoint());
		assertFalse(diagonalBetweenTowardsSmallEmptyArrowhead.canSwitchStartingPoint());
		assertFalse(diagonalBetweenTowardsSmallSchemaArrowhead.canSwitchStartingPoint());

		assertFalse(diagonalBetweenTowardsMedium.canSwitchStartingPoint());
		assertFalse(diagonalBetweenTowardsMediumEmptyArrowhead.canSwitchStartingPoint());
		assertFalse(diagonalBetweenTowardsMediumSchemaArrowhead.canSwitchStartingPoint());

		assertFalse(diagonalBetweenTowardsLarge.canSwitchStartingPoint());
		assertFalse(diagonalBetweenTowardsLargeEmptyArrowhead.canSwitchStartingPoint());
		assertFalse(diagonalBetweenTowardsLargeSchemaArrowhead.canSwitchStartingPoint());

		assertFalse(diagonalBetweenTowardsLargest.canSwitchStartingPoint());
		assertFalse(diagonalBetweenTowardsLargestEmptyArrowhead.canSwitchStartingPoint());
		assertFalse(diagonalBetweenTowardsLargestSchemaArrowhead.canSwitchStartingPoint());

	}

	@Override
	public void testSwitchStartingPoint() {

	}

	@Override
	public void testCanSwitchPlane() {

		assertTrue(diagonalAwayMovementSmall.canSwitchPlane());
		assertTrue(diagonalAwayMovementSmallEmptyArrowhead.canSwitchPlane());
		assertTrue(diagonalAwayMovementSmallSchemaArrowhead.canSwitchPlane());

		assertTrue(diagonalAwayMovementMedium.canSwitchPlane());
		assertTrue(diagonalAwayMovementMediumEmptyArrowhead.canSwitchPlane());
		assertTrue(diagonalAwayMovementMediumSchemaArrowhead.canSwitchPlane());

		assertTrue(diagonalAwayMovementLarge.canSwitchPlane());
		assertTrue(diagonalAwayMovementLargeEmptyArrowhead.canSwitchPlane());
		assertTrue(diagonalAwayMovementLargeSchemaArrowhead.canSwitchPlane());

		assertTrue(diagonalAwayMovementLargest.canSwitchPlane());
		assertTrue(diagonalAwayMovementLargestEmptyArrowhead.canSwitchPlane());
		assertTrue(diagonalAwayMovementLargestSchemaArrowhead.canSwitchPlane());

		assertFalse(diagonalTowardsMovementSmall.canSwitchPlane());
		assertFalse(diagonalTowardsMovementSmallEmptyArrowhead.canSwitchPlane());
		assertFalse(diagonalTowardsMovementSmallSchemaArrowhead.canSwitchPlane());

		assertFalse(diagonalTowardsMovementMedium.canSwitchPlane());
		assertFalse(diagonalTowardsMovementMediumEmptyArrowhead.canSwitchPlane());
		assertFalse(diagonalTowardsMovementMediumSchemaArrowhead.canSwitchPlane());

		assertFalse(diagonalTowardsMovementLarge.canSwitchPlane());
		assertFalse(diagonalTowardsMovementLargeEmptyArrowhead.canSwitchPlane());
		assertFalse(diagonalTowardsMovementLargeSchemaArrowhead.canSwitchPlane());

		assertFalse(diagonalTowardsMovementLargest.canSwitchPlane());
		assertFalse(diagonalTowardsMovementLargestEmptyArrowhead.canSwitchPlane());
		assertFalse(diagonalTowardsMovementLargestSchemaArrowhead.canSwitchPlane());

		assertFalse(diagonalBetweenAwaySmall.canSwitchPlane());
		assertFalse(diagonalBetweenAwaySmallEmptyArrowhead.canSwitchPlane());
		assertFalse(diagonalBetweenAwaySmallSchemaArrowhead.canSwitchPlane());

		assertFalse(diagonalBetweenAwayMedium.canSwitchPlane());
		assertFalse(diagonalBetweenAwayMediumEmptyArrowhead.canSwitchPlane());
		assertFalse(diagonalBetweenAwayMediumSchemaArrowhead.canSwitchPlane());

		assertFalse(diagonalBetweenAwayLarge.canSwitchPlane());
		assertFalse(diagonalBetweenAwayLargeEmptyArrowhead.canSwitchPlane());
		assertFalse(diagonalBetweenAwayLargeSchemaArrowhead.canSwitchPlane());

		assertFalse(diagonalBetweenAwayLargest.canSwitchPlane());
		assertFalse(diagonalBetweenAwayLargestEmptyArrowhead.canSwitchPlane());
		assertFalse(diagonalBetweenAwayLargestSchemaArrowhead.canSwitchPlane());

		assertFalse(diagonalBetweenTowardsSmall.canSwitchPlane());
		assertFalse(diagonalBetweenTowardsSmallEmptyArrowhead.canSwitchPlane());
		assertFalse(diagonalBetweenTowardsSmallSchemaArrowhead.canSwitchPlane());

		assertFalse(diagonalBetweenTowardsMedium.canSwitchPlane());
		assertFalse(diagonalBetweenTowardsMediumEmptyArrowhead.canSwitchPlane());
		assertFalse(diagonalBetweenTowardsMediumSchemaArrowhead.canSwitchPlane());

		assertFalse(diagonalBetweenTowardsLarge.canSwitchPlane());
		assertFalse(diagonalBetweenTowardsLargeEmptyArrowhead.canSwitchPlane());
		assertFalse(diagonalBetweenTowardsLargeSchemaArrowhead.canSwitchPlane());

		assertFalse(diagonalBetweenTowardsLargest.canSwitchPlane());
		assertFalse(diagonalBetweenTowardsLargestEmptyArrowhead.canSwitchPlane());
		assertFalse(diagonalBetweenTowardsLargestSchemaArrowhead.canSwitchPlane());

	}

	@Override
	public void testSwitchPlane() {

		diagonalAwayMovementSmall.switchPlane();
		assertEquals(symbolFactory.createSymbol("02-05-001-01-01-01"), diagonalAwayMovementSmall.getSymbol());
		diagonalAwayMovementSmallEmptyArrowhead.switchPlane();
		assertEquals(symbolFactory.createSymbol("02-05-001-01-02-01"),
				diagonalAwayMovementSmallEmptyArrowhead.getSymbol());
		diagonalAwayMovementSmallSchemaArrowhead.switchPlane();
		assertEquals(symbolFactory.createSymbol("02-05-001-01-03-01"),
				diagonalAwayMovementSmallSchemaArrowhead.getSymbol());

		diagonalAwayMovementMedium.switchPlane();
		assertEquals(symbolFactory.createSymbol("02-05-001-02-01-01"), diagonalAwayMovementMedium.getSymbol());
		diagonalAwayMovementMediumEmptyArrowhead.switchPlane();
		assertEquals(symbolFactory.createSymbol("02-05-001-02-02-01"),
				diagonalAwayMovementMediumEmptyArrowhead.getSymbol());
		diagonalAwayMovementMediumSchemaArrowhead.switchPlane();
		assertEquals(symbolFactory.createSymbol("02-05-001-02-03-01"),
				diagonalAwayMovementMediumSchemaArrowhead.getSymbol());

		diagonalAwayMovementLarge.switchPlane();
		assertEquals(symbolFactory.createSymbol("02-05-001-03-01-01"), diagonalAwayMovementLarge.getSymbol());
		diagonalAwayMovementLargeEmptyArrowhead.switchPlane();
		assertEquals(symbolFactory.createSymbol("02-05-001-03-02-01"),
				diagonalAwayMovementLargeEmptyArrowhead.getSymbol());
		diagonalAwayMovementLargeSchemaArrowhead.switchPlane();
		assertEquals(symbolFactory.createSymbol("02-05-001-03-03-01"),
				diagonalAwayMovementLargeSchemaArrowhead.getSymbol());

		diagonalAwayMovementLargest.switchPlane();
		assertEquals(symbolFactory.createSymbol("02-05-001-04-01-01"), diagonalAwayMovementLargest.getSymbol());
		diagonalAwayMovementLargestEmptyArrowhead.switchPlane();
		assertEquals(symbolFactory.createSymbol("02-05-001-04-02-01"),
				diagonalAwayMovementLargestEmptyArrowhead.getSymbol());
		diagonalAwayMovementLargestSchemaArrowhead.switchPlane();
		assertEquals(symbolFactory.createSymbol("02-05-001-04-03-01"),
				diagonalAwayMovementLargestSchemaArrowhead.getSymbol());
	}

}
