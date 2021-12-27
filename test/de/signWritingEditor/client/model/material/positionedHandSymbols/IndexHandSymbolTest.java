package de.signWritingEditor.client.model.material.positionedHandSymbols;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import de.signWritingEditor.shared.model.domainValue.Symbol;
import de.signWritingEditor.shared.model.material.HandBaseSymbol;
import de.signWritingEditor.shared.model.material.PositionedHandSymbol;
import de.signWritingEditor.shared.model.material.SymbolFactory;

public class IndexHandSymbolTest implements PositionedHandSymbolTestInterface {

	private PositionedHandSymbol indexRightHand;
	private PositionedHandSymbol indexLeftHand;
	private PositionedHandSymbol indexRightHandHalfTurn;
	private PositionedHandSymbol indexLeftHandHalfTurn;
	private PositionedHandSymbol indexRightHandFullTurn;
	private PositionedHandSymbol indexLeftHandFullTurn;
	private PositionedHandSymbol indexRightHandPitched;
	private PositionedHandSymbol indexLeftHandPitched;
	private PositionedHandSymbol indexRightHandHalfTurnPitched;
	private PositionedHandSymbol indexLeftHandHalfTurnPitched;
	private PositionedHandSymbol indexRightHandFullTurnPitched;
	private PositionedHandSymbol indexLeftHandFullTurnPitched;

	private PositionedHandSymbol indexOnCircleRightHand;
	private PositionedHandSymbol indexOnCircleLeftHand;
	private PositionedHandSymbol indexOnCircleRightHandHalfTurn;
	private PositionedHandSymbol indexOnCircleLeftHandHalfTurn;
	private PositionedHandSymbol indexOnCircleRightHandFullTurn;
	private PositionedHandSymbol indexOnCircleLeftHandFullTurn;
	private PositionedHandSymbol indexOnCircleRightHandPitched;
	private PositionedHandSymbol indexOnCircleLeftHandPitched;
	private PositionedHandSymbol indexOnCircleRightHandHalfTurnPitched;
	private PositionedHandSymbol indexOnCircleLeftHandHalfTurnPitched;
	private PositionedHandSymbol indexOnCircleRightHandFullTurnPitched;
	private PositionedHandSymbol indexOnCircleLeftHandFullTurnPitched;

	private PositionedHandSymbol indexOnCupRightHand;
	private PositionedHandSymbol indexOnCupLeftHand;
	private PositionedHandSymbol indexOnCupRightHandHalfTurn;
	private PositionedHandSymbol indexOnCupLeftHandHalfTurn;
	private PositionedHandSymbol indexOnCupRightHandFullTurn;
	private PositionedHandSymbol indexOnCupLeftHandFullTurn;
	private PositionedHandSymbol indexOnCupRightHandPitched;
	private PositionedHandSymbol indexOnCupLeftHandPitched;
	private PositionedHandSymbol indexOnCupRightHandHalfTurnPitched;
	private PositionedHandSymbol indexOnCupLeftHandHalfTurnPitched;
	private PositionedHandSymbol indexOnCupRightHandFullTurnPitched;
	private PositionedHandSymbol indexOnCupLeftHandFullTurnPitched;

	private PositionedHandSymbol indexOnOvalRightHand;
	private PositionedHandSymbol indexOnOvalLeftHand;
	private PositionedHandSymbol indexOnOvalRightHandHalfTurn;
	private PositionedHandSymbol indexOnOvalLeftHandHalfTurn;
	private PositionedHandSymbol indexOnOvalRightHandFullTurn;
	private PositionedHandSymbol indexOnOvalLeftHandFullTurn;
	private PositionedHandSymbol indexOnOvalRightHandPitched;
	private PositionedHandSymbol indexOnOvalLeftHandPitched;
	private PositionedHandSymbol indexOnOvalRightHandHalfTurnPitched;
	private PositionedHandSymbol indexOnOvalLeftHandHalfTurnPitched;
	private PositionedHandSymbol indexOnOvalRightHandFullTurnPitched;
	private PositionedHandSymbol indexOnOvalLeftHandFullTurnPitched;

	private PositionedHandSymbol indexOnHingeRightHand;
	private PositionedHandSymbol indexOnHingeLeftHand;
	private PositionedHandSymbol indexOnHingeRightHandHalfTurn;
	private PositionedHandSymbol indexOnHingeLeftHandHalfTurn;
	private PositionedHandSymbol indexOnHingeRightHandFullTurn;
	private PositionedHandSymbol indexOnHingeLeftHandFullTurn;
	private PositionedHandSymbol indexOnHingeRightHandPitched;
	private PositionedHandSymbol indexOnHingeLeftHandPitched;
	private PositionedHandSymbol indexOnHingeRightHandHalfTurnPitched;
	private PositionedHandSymbol indexOnHingeLeftHandHalfTurnPitched;
	private PositionedHandSymbol indexOnHingeRightHandFullTurnPitched;
	private PositionedHandSymbol indexOnHingeLeftHandFullTurnPitched;

	private PositionedHandSymbol indexOnAngleRightHand;
	private PositionedHandSymbol indexOnAngleLeftHand;
	private PositionedHandSymbol indexOnAngleRightHandHalfTurn;
	private PositionedHandSymbol indexOnAngleLeftHandHalfTurn;
	private PositionedHandSymbol indexOnAngleRightHandFullTurn;
	private PositionedHandSymbol indexOnAngleLeftHandFullTurn;
	private PositionedHandSymbol indexOnAngleRightHandPitched;
	private PositionedHandSymbol indexOnAngleLeftHandPitched;
	private PositionedHandSymbol indexOnAngleRightHandHalfTurnPitched;
	private PositionedHandSymbol indexOnAngleLeftHandHalfTurnPitched;
	private PositionedHandSymbol indexOnAngleRightHandFullTurnPitched;
	private PositionedHandSymbol indexOnAngleLeftHandFullTurnPitched;

	private PositionedHandSymbol indexBentRightHand;
	private PositionedHandSymbol indexBentLeftHand;
	private PositionedHandSymbol indexBentRightHandHalfTurn;
	private PositionedHandSymbol indexBentLeftHandHalfTurn;
	private PositionedHandSymbol indexBentRightHandFullTurn;
	private PositionedHandSymbol indexBentLeftHandFullTurn;
	private PositionedHandSymbol indexBentRightHandPitched;
	private PositionedHandSymbol indexBentLeftHandPitched;
	private PositionedHandSymbol indexBentRightHandHalfTurnPitched;
	private PositionedHandSymbol indexBentLeftHandHalfTurnPitched;
	private PositionedHandSymbol indexBentRightHandFullTurnPitched;
	private PositionedHandSymbol indexBentLeftHandFullTurnPitched;

	private PositionedHandSymbol indexBentOnCircleRightHand;
	private PositionedHandSymbol indexBentOnCircleLeftHand;
	private PositionedHandSymbol indexBentOnCircleRightHandHalfTurn;
	private PositionedHandSymbol indexBentOnCircleLeftHandHalfTurn;
	private PositionedHandSymbol indexBentOnCircleRightHandFullTurn;
	private PositionedHandSymbol indexBentOnCircleLeftHandFullTurn;
	private PositionedHandSymbol indexBentOnCircleRightHandPitched;
	private PositionedHandSymbol indexBentOnCircleLeftHandPitched;
	private PositionedHandSymbol indexBentOnCircleRightHandHalfTurnPitched;
	private PositionedHandSymbol indexBentOnCircleLeftHandHalfTurnPitched;
	private PositionedHandSymbol indexBentOnCircleRightHandFullTurnPitched;
	private PositionedHandSymbol indexBentOnCircleLeftHandFullTurnPitched;

	private PositionedHandSymbol indexBentOnFistThumbUnderRightHand;
	private PositionedHandSymbol indexBentOnFistThumbUnderLeftHand;
	private PositionedHandSymbol indexBentOnFistThumbUnderRightHandHalfTurn;
	private PositionedHandSymbol indexBentOnFistThumbUnderLeftHandHalfTurn;
	private PositionedHandSymbol indexBentOnFistThumbUnderRightHandFullTurn;
	private PositionedHandSymbol indexBentOnFistThumbUnderLeftHandFullTurn;
	private PositionedHandSymbol indexBentOnFistThumbUnderRightHandPitched;
	private PositionedHandSymbol indexBentOnFistThumbUnderLeftHandPitched;
	private PositionedHandSymbol indexBentOnFistThumbUnderRightHandHalfTurnPitched;
	private PositionedHandSymbol indexBentOnFistThumbUnderLeftHandHalfTurnPitched;
	private PositionedHandSymbol indexBentOnFistThumbUnderRightHandFullTurnPitched;
	private PositionedHandSymbol indexBentOnFistThumbUnderLeftHandFullTurnPitched;

	private PositionedHandSymbol indexRaisedKnuckleRightHand;
	private PositionedHandSymbol indexRaisedKnuckleLeftHand;
	private PositionedHandSymbol indexRaisedKnuckleRightHandHalfTurn;
	private PositionedHandSymbol indexRaisedKnuckleLeftHandHalfTurn;
	private PositionedHandSymbol indexRaisedKnuckleRightHandFullTurn;
	private PositionedHandSymbol indexRaisedKnuckleLeftHandFullTurn;
	private PositionedHandSymbol indexRaisedKnuckleRightHandPitched;
	private PositionedHandSymbol indexRaisedKnuckleLeftHandPitched;
	private PositionedHandSymbol indexRaisedKnuckleRightHandHalfTurnPitched;
	private PositionedHandSymbol indexRaisedKnuckleLeftHandHalfTurnPitched;
	private PositionedHandSymbol indexRaisedKnuckleRightHandFullTurnPitched;
	private PositionedHandSymbol indexRaisedKnuckleLeftHandFullTurnPitched;

	private PositionedHandSymbol indexCupRightHand;
	private PositionedHandSymbol indexCupLeftHand;
	private PositionedHandSymbol indexCupRightHandHalfTurn;
	private PositionedHandSymbol indexCupLeftHandHalfTurn;
	private PositionedHandSymbol indexCupRightHandFullTurn;
	private PositionedHandSymbol indexCupLeftHandFullTurn;
	private PositionedHandSymbol indexCupRightHandPitched;
	private PositionedHandSymbol indexCupLeftHandPitched;
	private PositionedHandSymbol indexCupRightHandHalfTurnPitched;
	private PositionedHandSymbol indexCupLeftHandHalfTurnPitched;
	private PositionedHandSymbol indexCupRightHandFullTurnPitched;
	private PositionedHandSymbol indexCupLeftHandFullTurnPitched;

	private PositionedHandSymbol indexHingeOnFistRightHand;
	private PositionedHandSymbol indexHingeOnFistLeftHand;
	private PositionedHandSymbol indexHingeOnFistRightHandHalfTurn;
	private PositionedHandSymbol indexHingeOnFistLeftHandHalfTurn;
	private PositionedHandSymbol indexHingeOnFistRightHandFullTurn;
	private PositionedHandSymbol indexHingeOnFistLeftHandFullTurn;
	private PositionedHandSymbol indexHingeOnFistRightHandPitched;
	private PositionedHandSymbol indexHingeOnFistLeftHandPitched;
	private PositionedHandSymbol indexHingeOnFistRightHandHalfTurnPitched;
	private PositionedHandSymbol indexHingeOnFistLeftHandHalfTurnPitched;
	private PositionedHandSymbol indexHingeOnFistRightHandFullTurnPitched;
	private PositionedHandSymbol indexHingeOnFistLeftHandFullTurnPitched;

	private PositionedHandSymbol indexHingeOnFistLowRightHand;
	private PositionedHandSymbol indexHingeOnFistLowLeftHand;
	private PositionedHandSymbol indexHingeOnFistLowRightHandHalfTurn;
	private PositionedHandSymbol indexHingeOnFistLowLeftHandHalfTurn;
	private PositionedHandSymbol indexHingeOnFistLowRightHandFullTurn;
	private PositionedHandSymbol indexHingeOnFistLowLeftHandFullTurn;
	private PositionedHandSymbol indexHingeOnFistLowRightHandPitched;
	private PositionedHandSymbol indexHingeOnFistLowLeftHandPitched;
	private PositionedHandSymbol indexHingeOnFistLowRightHandHalfTurnPitched;
	private PositionedHandSymbol indexHingeOnFistLowLeftHandHalfTurnPitched;
	private PositionedHandSymbol indexHingeOnFistLowRightHandFullTurnPitched;
	private PositionedHandSymbol indexHingeOnFistLowLeftHandFullTurnPitched;

	private PositionedHandSymbol indexHingeOnCircleRightHand;
	private PositionedHandSymbol indexHingeOnCircleLeftHand;
	private PositionedHandSymbol indexHingeOnCircleRightHandHalfTurn;
	private PositionedHandSymbol indexHingeOnCircleLeftHandHalfTurn;
	private PositionedHandSymbol indexHingeOnCircleRightHandFullTurn;
	private PositionedHandSymbol indexHingeOnCircleLeftHandFullTurn;
	private PositionedHandSymbol indexHingeOnCircleRightHandPitched;
	private PositionedHandSymbol indexHingeOnCircleLeftHandPitched;
	private PositionedHandSymbol indexHingeOnCircleRightHandHalfTurnPitched;
	private PositionedHandSymbol indexHingeOnCircleLeftHandHalfTurnPitched;
	private PositionedHandSymbol indexHingeOnCircleRightHandFullTurnPitched;
	private PositionedHandSymbol indexHingeOnCircleLeftHandFullTurnPitched;

	private SymbolFactory symbolFactory;

	@Override
	public void setUp(SymbolFactory symbolFactory) {

		this.symbolFactory = symbolFactory;

		indexRightHand = new PositionedHandSymbol(HandBaseSymbol.INDEX.getIswaSymbol(), 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(HandBaseSymbol.INDEX.getIswaSymbol().getBaseSymbol()));
		Symbol indexLeftHandSymbol = symbolFactory.createSymbol("01-01-001-01-01-09");
		indexLeftHand = new PositionedHandSymbol(indexLeftHandSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(indexLeftHandSymbol.getBaseSymbol()));
		Symbol indexRightHandHalfTurnSymbol = symbolFactory.createSymbol("01-01-001-01-02-01");
		indexRightHandHalfTurn = new PositionedHandSymbol(indexRightHandHalfTurnSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(indexRightHandHalfTurnSymbol.getBaseSymbol()));
		Symbol indexLeftHandHalfTurnSymbol = symbolFactory.createSymbol("01-01-001-01-02-09");
		indexLeftHandHalfTurn = new PositionedHandSymbol(indexLeftHandHalfTurnSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(indexLeftHandHalfTurnSymbol.getBaseSymbol()));
		Symbol indexRightHandFullTurnSymbol = symbolFactory.createSymbol("01-01-001-01-03-01");
		indexRightHandFullTurn = new PositionedHandSymbol(indexRightHandFullTurnSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(indexRightHandFullTurnSymbol.getBaseSymbol()));
		Symbol indexLeftHandFullTurnSymbol = symbolFactory.createSymbol("01-01-001-01-03-09");
		indexLeftHandFullTurn = new PositionedHandSymbol(indexLeftHandFullTurnSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(indexLeftHandFullTurnSymbol.getBaseSymbol()));
		Symbol indexRightHandPitchedSymbol = symbolFactory.createSymbol("01-01-001-01-04-01");
		indexRightHandPitched = new PositionedHandSymbol(indexRightHandPitchedSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(indexRightHandPitchedSymbol.getBaseSymbol()));
		Symbol indexLeftHandPitchedSymbol = symbolFactory.createSymbol("01-01-001-01-04-09");
		indexLeftHandPitched = new PositionedHandSymbol(indexLeftHandPitchedSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(indexLeftHandPitchedSymbol.getBaseSymbol()));
		Symbol indexRightHandHalfTurnPitchedSymbol = symbolFactory.createSymbol("01-01-001-01-05-01");
		indexRightHandHalfTurnPitched = new PositionedHandSymbol(indexRightHandHalfTurnPitchedSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(indexRightHandHalfTurnPitchedSymbol.getBaseSymbol()));
		Symbol indexLeftHandHalfTurnPitchedSymbol = symbolFactory.createSymbol("01-01-001-01-05-09");
		indexLeftHandHalfTurnPitched = new PositionedHandSymbol(indexLeftHandHalfTurnPitchedSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(indexLeftHandHalfTurnPitchedSymbol.getBaseSymbol()));
		Symbol indexRightHandFullTurnPitchedSymbol = symbolFactory.createSymbol("01-01-001-01-06-01");
		indexRightHandFullTurnPitched = new PositionedHandSymbol(indexRightHandFullTurnPitchedSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(indexRightHandFullTurnPitchedSymbol.getBaseSymbol()));
		Symbol indexLeftHandFullTurnPitchedSymbol = symbolFactory.createSymbol("01-01-001-01-06-09");
		indexLeftHandFullTurnPitched = new PositionedHandSymbol(indexLeftHandFullTurnPitchedSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(indexLeftHandFullTurnPitchedSymbol.getBaseSymbol()));

		indexOnCircleRightHand = new PositionedHandSymbol(HandBaseSymbol.INDEX_ON_CIRCLE.getIswaSymbol(), 0, 0, 2,
				symbolFactory
						.getAllRotationsAndFillsFor(HandBaseSymbol.INDEX_ON_CIRCLE.getIswaSymbol().getBaseSymbol()));
		Symbol indexOnCircleLeftHandSymbol = symbolFactory.createSymbol("01-01-002-01-01-09");
		indexOnCircleLeftHand = new PositionedHandSymbol(indexOnCircleLeftHandSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(indexOnCircleLeftHandSymbol.getBaseSymbol()));
		Symbol indexOnCircleRightHandHalfTurnSymbol = symbolFactory.createSymbol("01-01-002-01-02-01");
		indexOnCircleRightHandHalfTurn = new PositionedHandSymbol(indexOnCircleRightHandHalfTurnSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(indexOnCircleRightHandHalfTurnSymbol.getBaseSymbol()));
		Symbol indexOnCircleLeftHandHalfTurnSymbol = symbolFactory.createSymbol("01-01-002-01-02-09");
		indexOnCircleLeftHandHalfTurn = new PositionedHandSymbol(indexOnCircleLeftHandHalfTurnSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(indexOnCircleLeftHandHalfTurnSymbol.getBaseSymbol()));
		Symbol indexOnCircleRightHandFullTurnSymbol = symbolFactory.createSymbol("01-01-002-01-03-01");
		indexOnCircleRightHandFullTurn = new PositionedHandSymbol(indexOnCircleRightHandFullTurnSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(indexOnCircleRightHandFullTurnSymbol.getBaseSymbol()));
		Symbol indexOnCircleLeftHandFullTurnSymbol = symbolFactory.createSymbol("01-01-002-01-03-09");
		indexOnCircleLeftHandFullTurn = new PositionedHandSymbol(indexOnCircleLeftHandFullTurnSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(indexOnCircleLeftHandFullTurnSymbol.getBaseSymbol()));
		Symbol indexOnCircleRightHandPitchedSymbol = symbolFactory.createSymbol("01-01-002-01-04-01");
		indexOnCircleRightHandPitched = new PositionedHandSymbol(indexOnCircleRightHandPitchedSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(indexOnCircleRightHandPitchedSymbol.getBaseSymbol()));
		Symbol indexOnCircleLeftHandPitchedSymbol = symbolFactory.createSymbol("01-01-002-01-04-09");
		indexOnCircleLeftHandPitched = new PositionedHandSymbol(indexOnCircleLeftHandPitchedSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(indexOnCircleLeftHandPitchedSymbol.getBaseSymbol()));
		Symbol indexOnCircleRightHandHalfTurnPitchedSymbol = symbolFactory.createSymbol("01-01-002-01-05-01");
		indexOnCircleRightHandHalfTurnPitched = new PositionedHandSymbol(indexOnCircleRightHandHalfTurnPitchedSymbol, 0,
				0, 2,
				symbolFactory.getAllRotationsAndFillsFor(indexOnCircleRightHandHalfTurnPitchedSymbol.getBaseSymbol()));
		Symbol indexOnCircleLeftHandHalfTurnPitchedSymbol = symbolFactory.createSymbol("01-01-002-01-05-09");
		indexOnCircleLeftHandHalfTurnPitched = new PositionedHandSymbol(indexOnCircleLeftHandHalfTurnPitchedSymbol, 0,
				0, 2,
				symbolFactory.getAllRotationsAndFillsFor(indexOnCircleLeftHandHalfTurnPitchedSymbol.getBaseSymbol()));
		Symbol indexOnCircleRightHandFullTurnPitchedSymbol = symbolFactory.createSymbol("01-01-002-01-06-01");
		indexOnCircleRightHandFullTurnPitched = new PositionedHandSymbol(indexOnCircleRightHandFullTurnPitchedSymbol, 0,
				0, 2,
				symbolFactory.getAllRotationsAndFillsFor(indexOnCircleRightHandFullTurnPitchedSymbol.getBaseSymbol()));
		Symbol indexOnCircleLeftHandFullTurnPitchedSymbol = symbolFactory.createSymbol("01-01-002-01-06-09");
		indexOnCircleLeftHandFullTurnPitched = new PositionedHandSymbol(indexOnCircleLeftHandFullTurnPitchedSymbol, 0,
				0, 2,
				symbolFactory.getAllRotationsAndFillsFor(indexOnCircleLeftHandFullTurnPitchedSymbol.getBaseSymbol()));

		indexOnCupRightHand = new PositionedHandSymbol(HandBaseSymbol.INDEX_ON_CUP.getIswaSymbol(), 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(HandBaseSymbol.INDEX_ON_CUP.getIswaSymbol().getBaseSymbol()));
		Symbol indexOnCupLeftHandSymbol = symbolFactory.createSymbol("01-01-003-01-01-09");
		indexOnCupLeftHand = new PositionedHandSymbol(indexOnCupLeftHandSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(indexOnCupLeftHandSymbol.getBaseSymbol()));
		Symbol indexOnCupRightHandHalfTurnSymbol = symbolFactory.createSymbol("01-01-003-01-02-01");
		indexOnCupRightHandHalfTurn = new PositionedHandSymbol(indexOnCupRightHandHalfTurnSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(indexOnCupRightHandHalfTurnSymbol.getBaseSymbol()));
		Symbol indexOnCupLeftHandHalfTurnSymbol = symbolFactory.createSymbol("01-01-003-01-02-09");
		indexOnCupLeftHandHalfTurn = new PositionedHandSymbol(indexOnCupLeftHandHalfTurnSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(indexOnCupLeftHandHalfTurnSymbol.getBaseSymbol()));
		Symbol indexOnCupRightHandFullTurnSymbol = symbolFactory.createSymbol("01-01-003-01-03-01");
		indexOnCupRightHandFullTurn = new PositionedHandSymbol(indexOnCupRightHandFullTurnSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(indexOnCupRightHandFullTurnSymbol.getBaseSymbol()));
		Symbol indexOnCupLeftHandFullTurnSymbol = symbolFactory.createSymbol("01-01-003-01-03-09");
		indexOnCupLeftHandFullTurn = new PositionedHandSymbol(indexOnCupLeftHandFullTurnSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(indexOnCupLeftHandFullTurnSymbol.getBaseSymbol()));
		Symbol indexOnCupRightHandPitchedSymbol = symbolFactory.createSymbol("01-01-003-01-04-01");
		indexOnCupRightHandPitched = new PositionedHandSymbol(indexOnCupRightHandPitchedSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(indexOnCupRightHandPitchedSymbol.getBaseSymbol()));
		Symbol indexOnCupLeftHandPitchedSymbol = symbolFactory.createSymbol("01-01-003-01-04-09");
		indexOnCupLeftHandPitched = new PositionedHandSymbol(indexOnCupLeftHandPitchedSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(indexOnCupLeftHandPitchedSymbol.getBaseSymbol()));
		Symbol indexOnCupRightHandHalfTurnPitchedSymbol = symbolFactory.createSymbol("01-01-003-01-05-01");
		indexOnCupRightHandHalfTurnPitched = new PositionedHandSymbol(indexOnCupRightHandHalfTurnPitchedSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(indexOnCupRightHandHalfTurnPitchedSymbol.getBaseSymbol()));
		Symbol indexOnCupLeftHandHalfTurnPitchedSymbol = symbolFactory.createSymbol("01-01-003-01-05-09");
		indexOnCupLeftHandHalfTurnPitched = new PositionedHandSymbol(indexOnCupLeftHandHalfTurnPitchedSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(indexOnCupLeftHandHalfTurnPitchedSymbol.getBaseSymbol()));
		Symbol indexOnCupRightHandFullTurnPitchedSymbol = symbolFactory.createSymbol("01-01-003-01-06-01");
		indexOnCupRightHandFullTurnPitched = new PositionedHandSymbol(indexOnCupRightHandFullTurnPitchedSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(indexOnCupRightHandFullTurnPitchedSymbol.getBaseSymbol()));
		Symbol indexOnCupLeftHandFullTurnPitchedSymbol = symbolFactory.createSymbol("01-01-003-01-06-09");
		indexOnCupLeftHandFullTurnPitched = new PositionedHandSymbol(indexOnCupLeftHandFullTurnPitchedSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(indexOnCupLeftHandFullTurnPitchedSymbol.getBaseSymbol()));

		indexOnOvalRightHand = new PositionedHandSymbol(HandBaseSymbol.INDEX_ON_OVAL.getIswaSymbol(), 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(HandBaseSymbol.INDEX_ON_OVAL.getIswaSymbol().getBaseSymbol()));
		Symbol indexOnOvalLeftHandSymbol = symbolFactory.createSymbol("01-01-004-01-01-09");
		indexOnOvalLeftHand = new PositionedHandSymbol(indexOnOvalLeftHandSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(indexOnOvalLeftHandSymbol.getBaseSymbol()));
		Symbol indexOnOvalRightHandHalfTurnSymbol = symbolFactory.createSymbol("01-01-004-01-02-01");
		indexOnOvalRightHandHalfTurn = new PositionedHandSymbol(indexOnOvalRightHandHalfTurnSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(indexOnOvalRightHandHalfTurnSymbol.getBaseSymbol()));
		Symbol indexOnOvalLeftHandHalfTurnSymbol = symbolFactory.createSymbol("01-01-004-01-02-09");
		indexOnOvalLeftHandHalfTurn = new PositionedHandSymbol(indexOnOvalLeftHandHalfTurnSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(indexOnOvalLeftHandHalfTurnSymbol.getBaseSymbol()));
		Symbol indexOnOvalRightHandFullTurnSymbol = symbolFactory.createSymbol("01-01-004-01-03-01");
		indexOnOvalRightHandFullTurn = new PositionedHandSymbol(indexOnOvalRightHandFullTurnSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(indexOnOvalRightHandFullTurnSymbol.getBaseSymbol()));
		Symbol indexOnOvalLeftHandFullTurnSymbol = symbolFactory.createSymbol("01-01-004-01-03-09");
		indexOnOvalLeftHandFullTurn = new PositionedHandSymbol(indexOnOvalLeftHandFullTurnSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(indexOnOvalLeftHandFullTurnSymbol.getBaseSymbol()));
		Symbol indexOnOvalRightHandPitchedSymbol = symbolFactory.createSymbol("01-01-004-01-04-01");
		indexOnOvalRightHandPitched = new PositionedHandSymbol(indexOnOvalRightHandPitchedSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(indexOnOvalRightHandPitchedSymbol.getBaseSymbol()));
		Symbol indexOnOvalLeftHandPitchedSymbol = symbolFactory.createSymbol("01-01-004-01-04-09");
		indexOnOvalLeftHandPitched = new PositionedHandSymbol(indexOnOvalLeftHandPitchedSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(indexOnOvalLeftHandPitchedSymbol.getBaseSymbol()));
		Symbol indexOnOvalRightHandHalfTurnPitchedSymbol = symbolFactory.createSymbol("01-01-004-01-05-01");
		indexOnOvalRightHandHalfTurnPitched = new PositionedHandSymbol(indexOnOvalRightHandHalfTurnPitchedSymbol, 0, 0,
				2, symbolFactory.getAllRotationsAndFillsFor(indexOnOvalRightHandHalfTurnPitchedSymbol.getBaseSymbol()));
		Symbol indexOnOvalLeftHandHalfTurnPitchedSymbol = symbolFactory.createSymbol("01-01-004-01-05-09");
		indexOnOvalLeftHandHalfTurnPitched = new PositionedHandSymbol(indexOnOvalLeftHandHalfTurnPitchedSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(indexOnOvalLeftHandHalfTurnPitchedSymbol.getBaseSymbol()));
		Symbol indexOnOvalRightHandFullTurnPitchedSymbol = symbolFactory.createSymbol("01-01-004-01-06-01");
		indexOnOvalRightHandFullTurnPitched = new PositionedHandSymbol(indexOnOvalRightHandFullTurnPitchedSymbol, 0, 0,
				2, symbolFactory.getAllRotationsAndFillsFor(indexOnOvalRightHandFullTurnPitchedSymbol.getBaseSymbol()));
		Symbol indexOnOvalLeftHandFullTurnPitchedSymbol = symbolFactory.createSymbol("01-01-004-01-06-09");
		indexOnOvalLeftHandFullTurnPitched = new PositionedHandSymbol(indexOnOvalLeftHandFullTurnPitchedSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(indexOnOvalLeftHandFullTurnPitchedSymbol.getBaseSymbol()));

		indexOnHingeRightHand = new PositionedHandSymbol(HandBaseSymbol.INDEX_ON_HINGE.getIswaSymbol(), 0, 0, 2,
				symbolFactory
						.getAllRotationsAndFillsFor(HandBaseSymbol.INDEX_ON_HINGE.getIswaSymbol().getBaseSymbol()));
		Symbol indexOnHingeLeftHandSymbol = symbolFactory.createSymbol("01-01-005-01-01-09");
		indexOnHingeLeftHand = new PositionedHandSymbol(indexOnHingeLeftHandSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(indexOnHingeLeftHandSymbol.getBaseSymbol()));
		Symbol indexOnHingeRightHandHalfTurnSymbol = symbolFactory.createSymbol("01-01-005-01-02-01");
		indexOnHingeRightHandHalfTurn = new PositionedHandSymbol(indexOnHingeRightHandHalfTurnSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(indexOnHingeRightHandHalfTurnSymbol.getBaseSymbol()));
		Symbol indexOnHingeLeftHandHalfTurnSymbol = symbolFactory.createSymbol("01-01-005-01-02-09");
		indexOnHingeLeftHandHalfTurn = new PositionedHandSymbol(indexOnHingeLeftHandHalfTurnSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(indexOnHingeLeftHandHalfTurnSymbol.getBaseSymbol()));
		Symbol indexOnHingeRightHandFullTurnSymbol = symbolFactory.createSymbol("01-01-005-01-03-01");
		indexOnHingeRightHandFullTurn = new PositionedHandSymbol(indexOnHingeRightHandFullTurnSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(indexOnHingeRightHandFullTurnSymbol.getBaseSymbol()));
		Symbol indexOnHingeLeftHandFullTurnSymbol = symbolFactory.createSymbol("01-01-005-01-03-09");
		indexOnHingeLeftHandFullTurn = new PositionedHandSymbol(indexOnHingeLeftHandFullTurnSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(indexOnHingeLeftHandFullTurnSymbol.getBaseSymbol()));
		Symbol indexOnHingeRightHandPitchedSymbol = symbolFactory.createSymbol("01-01-005-01-04-01");
		indexOnHingeRightHandPitched = new PositionedHandSymbol(indexOnHingeRightHandPitchedSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(indexOnHingeRightHandPitchedSymbol.getBaseSymbol()));
		Symbol indexOnHingeLeftHandPitchedSymbol = symbolFactory.createSymbol("01-01-005-01-04-09");
		indexOnHingeLeftHandPitched = new PositionedHandSymbol(indexOnHingeLeftHandPitchedSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(indexOnHingeLeftHandPitchedSymbol.getBaseSymbol()));
		Symbol indexOnHingeRightHandHalfTurnPitchedSymbol = symbolFactory.createSymbol("01-01-005-01-05-01");
		indexOnHingeRightHandHalfTurnPitched = new PositionedHandSymbol(indexOnHingeRightHandHalfTurnPitchedSymbol, 0,
				0, 2,
				symbolFactory.getAllRotationsAndFillsFor(indexOnHingeRightHandHalfTurnPitchedSymbol.getBaseSymbol()));
		Symbol indexOnHingeLeftHandHalfTurnPitchedSymbol = symbolFactory.createSymbol("01-01-005-01-05-09");
		indexOnHingeLeftHandHalfTurnPitched = new PositionedHandSymbol(indexOnHingeLeftHandHalfTurnPitchedSymbol, 0, 0,
				2, symbolFactory.getAllRotationsAndFillsFor(indexOnHingeLeftHandHalfTurnPitchedSymbol.getBaseSymbol()));
		Symbol indexOnHingeRightHandFullTurnPitchedSymbol = symbolFactory.createSymbol("01-01-005-01-06-01");
		indexOnHingeRightHandFullTurnPitched = new PositionedHandSymbol(indexOnHingeRightHandFullTurnPitchedSymbol, 0,
				0, 2,
				symbolFactory.getAllRotationsAndFillsFor(indexOnHingeRightHandFullTurnPitchedSymbol.getBaseSymbol()));
		Symbol indexOnHingeLeftHandFullTurnPitchedSymbol = symbolFactory.createSymbol("01-01-005-01-06-09");
		indexOnHingeLeftHandFullTurnPitched = new PositionedHandSymbol(indexOnHingeLeftHandFullTurnPitchedSymbol, 0, 0,
				2, symbolFactory.getAllRotationsAndFillsFor(indexOnHingeLeftHandFullTurnPitchedSymbol.getBaseSymbol()));

		indexOnAngleRightHand = new PositionedHandSymbol(HandBaseSymbol.INDEX_ON_ANGLE.getIswaSymbol(), 0, 0, 2,
				symbolFactory
						.getAllRotationsAndFillsFor(HandBaseSymbol.INDEX_ON_ANGLE.getIswaSymbol().getBaseSymbol()));
		Symbol indexOnAngleLeftHandSymbol = symbolFactory.createSymbol("01-01-006-01-01-09");
		indexOnAngleLeftHand = new PositionedHandSymbol(indexOnAngleLeftHandSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(indexOnAngleLeftHandSymbol.getBaseSymbol()));
		Symbol indexOnAngleRightHandHalfTurnSymbol = symbolFactory.createSymbol("01-01-006-01-02-01");
		indexOnAngleRightHandHalfTurn = new PositionedHandSymbol(indexOnAngleRightHandHalfTurnSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(indexOnAngleRightHandHalfTurnSymbol.getBaseSymbol()));
		Symbol indexOnAngleLeftHandHalfTurnSymbol = symbolFactory.createSymbol("01-01-006-01-02-09");
		indexOnAngleLeftHandHalfTurn = new PositionedHandSymbol(indexOnAngleLeftHandHalfTurnSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(indexOnAngleLeftHandHalfTurnSymbol.getBaseSymbol()));
		Symbol indexOnAngleRightHandFullTurnSymbol = symbolFactory.createSymbol("01-01-006-01-03-01");
		indexOnAngleRightHandFullTurn = new PositionedHandSymbol(indexOnAngleRightHandFullTurnSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(indexOnAngleRightHandFullTurnSymbol.getBaseSymbol()));
		Symbol indexOnAngleLeftHandFullTurnSymbol = symbolFactory.createSymbol("01-01-006-01-03-09");
		indexOnAngleLeftHandFullTurn = new PositionedHandSymbol(indexOnAngleLeftHandFullTurnSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(indexOnAngleLeftHandFullTurnSymbol.getBaseSymbol()));
		Symbol indexOnAngleRightHandPitchedSymbol = symbolFactory.createSymbol("01-01-006-01-04-01");
		indexOnAngleRightHandPitched = new PositionedHandSymbol(indexOnAngleRightHandPitchedSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(indexOnAngleRightHandPitchedSymbol.getBaseSymbol()));
		Symbol indexOnAngleLeftHandPitchedSymbol = symbolFactory.createSymbol("01-01-006-01-04-09");
		indexOnAngleLeftHandPitched = new PositionedHandSymbol(indexOnAngleLeftHandPitchedSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(indexOnAngleLeftHandPitchedSymbol.getBaseSymbol()));
		Symbol indexOnAngleRightHandHalfTurnPitchedSymbol = symbolFactory.createSymbol("01-01-006-01-05-01");
		indexOnAngleRightHandHalfTurnPitched = new PositionedHandSymbol(indexOnAngleRightHandHalfTurnPitchedSymbol, 0,
				0, 2,
				symbolFactory.getAllRotationsAndFillsFor(indexOnAngleRightHandHalfTurnPitchedSymbol.getBaseSymbol()));
		Symbol indexOnAngleLeftHandHalfTurnPitchedSymbol = symbolFactory.createSymbol("01-01-006-01-05-09");
		indexOnAngleLeftHandHalfTurnPitched = new PositionedHandSymbol(indexOnAngleLeftHandHalfTurnPitchedSymbol, 0, 0,
				2, symbolFactory.getAllRotationsAndFillsFor(indexOnAngleLeftHandHalfTurnPitchedSymbol.getBaseSymbol()));
		Symbol indexOnAngleRightHandFullTurnPitchedSymbol = symbolFactory.createSymbol("01-01-006-01-06-01");
		indexOnAngleRightHandFullTurnPitched = new PositionedHandSymbol(indexOnAngleRightHandFullTurnPitchedSymbol, 0,
				0, 2,
				symbolFactory.getAllRotationsAndFillsFor(indexOnAngleRightHandFullTurnPitchedSymbol.getBaseSymbol()));
		Symbol indexOnAngleLeftHandFullTurnPitchedSymbol = symbolFactory.createSymbol("01-01-006-01-06-09");
		indexOnAngleLeftHandFullTurnPitched = new PositionedHandSymbol(indexOnAngleLeftHandFullTurnPitchedSymbol, 0, 0,
				2, symbolFactory.getAllRotationsAndFillsFor(indexOnAngleLeftHandFullTurnPitchedSymbol.getBaseSymbol()));

		indexBentRightHand = new PositionedHandSymbol(HandBaseSymbol.INDEX_BENT.getIswaSymbol(), 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(HandBaseSymbol.INDEX_BENT.getIswaSymbol().getBaseSymbol()));
		Symbol indexBentLeftHandSymbol = symbolFactory.createSymbol("01-01-007-01-01-09");
		indexBentLeftHand = new PositionedHandSymbol(indexBentLeftHandSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(indexBentLeftHandSymbol.getBaseSymbol()));
		Symbol indexBentRightHandHalfTurnSymbol = symbolFactory.createSymbol("01-01-007-01-02-01");
		indexBentRightHandHalfTurn = new PositionedHandSymbol(indexBentRightHandHalfTurnSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(indexBentRightHandHalfTurnSymbol.getBaseSymbol()));
		Symbol indexBentLeftHandHalfTurnSymbol = symbolFactory.createSymbol("01-01-007-01-02-09");
		indexBentLeftHandHalfTurn = new PositionedHandSymbol(indexBentLeftHandHalfTurnSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(indexBentLeftHandHalfTurnSymbol.getBaseSymbol()));
		Symbol indexBentRightHandFullTurnSymbol = symbolFactory.createSymbol("01-01-007-01-03-01");
		indexBentRightHandFullTurn = new PositionedHandSymbol(indexBentRightHandFullTurnSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(indexBentRightHandFullTurnSymbol.getBaseSymbol()));
		Symbol indexBentLeftHandFullTurnSymbol = symbolFactory.createSymbol("01-01-007-01-03-09");
		indexBentLeftHandFullTurn = new PositionedHandSymbol(indexBentLeftHandFullTurnSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(indexBentLeftHandFullTurnSymbol.getBaseSymbol()));
		Symbol indexBentRightHandPitchedSymbol = symbolFactory.createSymbol("01-01-007-01-04-01");
		indexBentRightHandPitched = new PositionedHandSymbol(indexBentRightHandPitchedSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(indexBentRightHandPitchedSymbol.getBaseSymbol()));
		Symbol indexBentLeftHandPitchedSymbol = symbolFactory.createSymbol("01-01-007-01-04-09");
		indexBentLeftHandPitched = new PositionedHandSymbol(indexBentLeftHandPitchedSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(indexBentLeftHandPitchedSymbol.getBaseSymbol()));
		Symbol indexBentRightHandHalfTurnPitchedSymbol = symbolFactory.createSymbol("01-01-007-01-05-01");
		indexBentRightHandHalfTurnPitched = new PositionedHandSymbol(indexBentRightHandHalfTurnPitchedSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(indexBentRightHandHalfTurnPitchedSymbol.getBaseSymbol()));
		Symbol indexBentLeftHandHalfTurnPitchedSymbol = symbolFactory.createSymbol("01-01-007-01-05-09");
		indexBentLeftHandHalfTurnPitched = new PositionedHandSymbol(indexBentLeftHandHalfTurnPitchedSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(indexBentLeftHandHalfTurnPitchedSymbol.getBaseSymbol()));
		Symbol indexBentRightHandFullTurnPitchedSymbol = symbolFactory.createSymbol("01-01-007-01-06-01");
		indexBentRightHandFullTurnPitched = new PositionedHandSymbol(indexBentRightHandFullTurnPitchedSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(indexBentRightHandFullTurnPitchedSymbol.getBaseSymbol()));
		Symbol indexBentLeftHandFullTurnPitchedSymbol = symbolFactory.createSymbol("01-01-007-01-06-09");
		indexBentLeftHandFullTurnPitched = new PositionedHandSymbol(indexBentLeftHandFullTurnPitchedSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(indexBentLeftHandFullTurnPitchedSymbol.getBaseSymbol()));

		indexBentOnCircleRightHand = new PositionedHandSymbol(HandBaseSymbol.INDEX_BENT_ON_CIRCLE.getIswaSymbol(), 0, 0,
				2, symbolFactory.getAllRotationsAndFillsFor(
						HandBaseSymbol.INDEX_BENT_ON_CIRCLE.getIswaSymbol().getBaseSymbol()));
		Symbol indexBentOnCircleLeftHandSymbol = symbolFactory.createSymbol("01-01-008-01-01-09");
		indexBentOnCircleLeftHand = new PositionedHandSymbol(indexBentOnCircleLeftHandSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(indexBentOnCircleLeftHandSymbol.getBaseSymbol()));
		Symbol indexBentOnCircleRightHandHalfTurnSymbol = symbolFactory.createSymbol("01-01-008-01-02-01");
		indexBentOnCircleRightHandHalfTurn = new PositionedHandSymbol(indexBentOnCircleRightHandHalfTurnSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(indexBentOnCircleRightHandHalfTurnSymbol.getBaseSymbol()));
		Symbol indexBentOnCircleLeftHandHalfTurnSymbol = symbolFactory.createSymbol("01-01-008-01-02-09");
		indexBentOnCircleLeftHandHalfTurn = new PositionedHandSymbol(indexBentOnCircleLeftHandHalfTurnSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(indexBentOnCircleLeftHandHalfTurnSymbol.getBaseSymbol()));
		Symbol indexBentOnCircleRightHandFullTurnSymbol = symbolFactory.createSymbol("01-01-008-01-03-01");
		indexBentOnCircleRightHandFullTurn = new PositionedHandSymbol(indexBentOnCircleRightHandFullTurnSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(indexBentOnCircleRightHandFullTurnSymbol.getBaseSymbol()));
		Symbol indexBentOnCircleLeftHandFullTurnSymbol = symbolFactory.createSymbol("01-01-008-01-03-09");
		indexBentOnCircleLeftHandFullTurn = new PositionedHandSymbol(indexBentOnCircleLeftHandFullTurnSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(indexBentOnCircleLeftHandFullTurnSymbol.getBaseSymbol()));
		Symbol indexBentOnCircleRightHandPitchedSymbol = symbolFactory.createSymbol("01-01-008-01-04-01");
		indexBentOnCircleRightHandPitched = new PositionedHandSymbol(indexBentOnCircleRightHandPitchedSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(indexBentOnCircleRightHandPitchedSymbol.getBaseSymbol()));
		Symbol indexBentOnCircleLeftHandPitchedSymbol = symbolFactory.createSymbol("01-01-008-01-04-09");
		indexBentOnCircleLeftHandPitched = new PositionedHandSymbol(indexBentOnCircleLeftHandPitchedSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(indexBentOnCircleLeftHandPitchedSymbol.getBaseSymbol()));
		Symbol indexBentOnCircleRightHandHalfTurnPitchedSymbol = symbolFactory.createSymbol("01-01-008-01-05-01");
		indexBentOnCircleRightHandHalfTurnPitched = new PositionedHandSymbol(
				indexBentOnCircleRightHandHalfTurnPitchedSymbol, 0, 0, 2, symbolFactory
						.getAllRotationsAndFillsFor(indexBentOnCircleRightHandHalfTurnPitchedSymbol.getBaseSymbol()));
		Symbol indexBentOnCircleLeftHandHalfTurnPitchedSymbol = symbolFactory.createSymbol("01-01-008-01-05-09");
		indexBentOnCircleLeftHandHalfTurnPitched = new PositionedHandSymbol(
				indexBentOnCircleLeftHandHalfTurnPitchedSymbol, 0, 0, 2, symbolFactory
						.getAllRotationsAndFillsFor(indexBentOnCircleLeftHandHalfTurnPitchedSymbol.getBaseSymbol()));
		Symbol indexBentOnCircleRightHandFullTurnPitchedSymbol = symbolFactory.createSymbol("01-01-008-01-06-01");
		indexBentOnCircleRightHandFullTurnPitched = new PositionedHandSymbol(
				indexBentOnCircleRightHandFullTurnPitchedSymbol, 0, 0, 2, symbolFactory
						.getAllRotationsAndFillsFor(indexBentOnCircleRightHandFullTurnPitchedSymbol.getBaseSymbol()));
		Symbol indexBentOnCircleLeftHandFullTurnPitchedSymbol = symbolFactory.createSymbol("01-01-008-01-06-09");
		indexBentOnCircleLeftHandFullTurnPitched = new PositionedHandSymbol(
				indexBentOnCircleLeftHandFullTurnPitchedSymbol, 0, 0, 2, symbolFactory
						.getAllRotationsAndFillsFor(indexBentOnCircleLeftHandFullTurnPitchedSymbol.getBaseSymbol()));

		indexBentOnFistThumbUnderRightHand = new PositionedHandSymbol(
				HandBaseSymbol.INDEX_BENT_ON_FIRST_THUMB_UNDER.getIswaSymbol(), 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						HandBaseSymbol.INDEX_BENT_ON_FIRST_THUMB_UNDER.getIswaSymbol().getBaseSymbol()));
		Symbol indexBentOnFistThumbUnderLeftHandSymbol = symbolFactory.createSymbol("01-01-009-01-01-09");
		indexBentOnFistThumbUnderLeftHand = new PositionedHandSymbol(indexBentOnFistThumbUnderLeftHandSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(indexBentOnFistThumbUnderLeftHandSymbol.getBaseSymbol()));
		Symbol indexBentOnFistThumbUnderRightHandHalfTurnSymbol = symbolFactory.createSymbol("01-01-009-01-02-01");
		indexBentOnFistThumbUnderRightHandHalfTurn = new PositionedHandSymbol(
				indexBentOnFistThumbUnderRightHandHalfTurnSymbol, 0, 0, 2, symbolFactory
						.getAllRotationsAndFillsFor(indexBentOnFistThumbUnderRightHandHalfTurnSymbol.getBaseSymbol()));
		Symbol indexBentOnFistThumbUnderLeftHandHalfTurnSymbol = symbolFactory.createSymbol("01-01-009-01-02-09");
		indexBentOnFistThumbUnderLeftHandHalfTurn = new PositionedHandSymbol(
				indexBentOnFistThumbUnderLeftHandHalfTurnSymbol, 0, 0, 2, symbolFactory
						.getAllRotationsAndFillsFor(indexBentOnFistThumbUnderLeftHandHalfTurnSymbol.getBaseSymbol()));
		Symbol indexBentOnFistThumbUnderRightHandFullTurnSymbol = symbolFactory.createSymbol("01-01-009-01-03-01");
		indexBentOnFistThumbUnderRightHandFullTurn = new PositionedHandSymbol(
				indexBentOnFistThumbUnderRightHandFullTurnSymbol, 0, 0, 2, symbolFactory
						.getAllRotationsAndFillsFor(indexBentOnFistThumbUnderRightHandFullTurnSymbol.getBaseSymbol()));
		Symbol indexBentOnFistThumbUnderLeftHandFullTurnSymbol = symbolFactory.createSymbol("01-01-009-01-03-09");
		indexBentOnFistThumbUnderLeftHandFullTurn = new PositionedHandSymbol(
				indexBentOnFistThumbUnderLeftHandFullTurnSymbol, 0, 0, 2, symbolFactory
						.getAllRotationsAndFillsFor(indexBentOnFistThumbUnderLeftHandFullTurnSymbol.getBaseSymbol()));
		Symbol indexBentOnFistThumbUnderRightHandPitchedSymbol = symbolFactory.createSymbol("01-01-009-01-04-01");
		indexBentOnFistThumbUnderRightHandPitched = new PositionedHandSymbol(
				indexBentOnFistThumbUnderRightHandPitchedSymbol, 0, 0, 2, symbolFactory
						.getAllRotationsAndFillsFor(indexBentOnFistThumbUnderRightHandPitchedSymbol.getBaseSymbol()));
		Symbol indexBentOnFistThumbUnderLeftHandPitchedSymbol = symbolFactory.createSymbol("01-01-009-01-04-09");
		indexBentOnFistThumbUnderLeftHandPitched = new PositionedHandSymbol(
				indexBentOnFistThumbUnderLeftHandPitchedSymbol, 0, 0, 2, symbolFactory
						.getAllRotationsAndFillsFor(indexBentOnFistThumbUnderLeftHandPitchedSymbol.getBaseSymbol()));
		Symbol indexBentOnFistThumbUnderRightHandHalfTurnPitchedSymbol = symbolFactory
				.createSymbol("01-01-009-01-05-01");
		indexBentOnFistThumbUnderRightHandHalfTurnPitched = new PositionedHandSymbol(
				indexBentOnFistThumbUnderRightHandHalfTurnPitchedSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						indexBentOnFistThumbUnderRightHandHalfTurnPitchedSymbol.getBaseSymbol()));
		Symbol indexBentOnFistThumbUnderLeftHandHalfTurnPitchedSymbol = symbolFactory
				.createSymbol("01-01-009-01-05-09");
		indexBentOnFistThumbUnderLeftHandHalfTurnPitched = new PositionedHandSymbol(
				indexBentOnFistThumbUnderLeftHandHalfTurnPitchedSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						indexBentOnFistThumbUnderLeftHandHalfTurnPitchedSymbol.getBaseSymbol()));
		Symbol indexBentOnFistThumbUnderRightHandFullTurnPitchedSymbol = symbolFactory
				.createSymbol("01-01-009-01-06-01");
		indexBentOnFistThumbUnderRightHandFullTurnPitched = new PositionedHandSymbol(
				indexBentOnFistThumbUnderRightHandFullTurnPitchedSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						indexBentOnFistThumbUnderRightHandFullTurnPitchedSymbol.getBaseSymbol()));
		Symbol indexBentOnFistThumbUnderLeftHandFullTurnPitchedSymbol = symbolFactory
				.createSymbol("01-01-009-01-06-09");
		indexBentOnFistThumbUnderLeftHandFullTurnPitched = new PositionedHandSymbol(
				indexBentOnFistThumbUnderLeftHandFullTurnPitchedSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(
						indexBentOnFistThumbUnderLeftHandFullTurnPitchedSymbol.getBaseSymbol()));

		indexRaisedKnuckleRightHand = new PositionedHandSymbol(HandBaseSymbol.INDEX_RAISED_KNUCKLE.getIswaSymbol(), 0,
				0, 2, symbolFactory.getAllRotationsAndFillsFor(
						HandBaseSymbol.INDEX_RAISED_KNUCKLE.getIswaSymbol().getBaseSymbol()));
		Symbol indexRaisedKnuckleLeftHandSymbol = symbolFactory.createSymbol("01-01-010-01-01-09");
		indexRaisedKnuckleLeftHand = new PositionedHandSymbol(indexRaisedKnuckleLeftHandSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(indexRaisedKnuckleLeftHandSymbol.getBaseSymbol()));
		Symbol indexRaisedKnuckleRightHandHalfTurnSymbol = symbolFactory.createSymbol("01-01-010-01-02-01");
		indexRaisedKnuckleRightHandHalfTurn = new PositionedHandSymbol(indexRaisedKnuckleRightHandHalfTurnSymbol, 0, 0,
				2, symbolFactory.getAllRotationsAndFillsFor(indexRaisedKnuckleRightHandHalfTurnSymbol.getBaseSymbol()));
		Symbol indexRaisedKnuckleLeftHandHalfTurnSymbol = symbolFactory.createSymbol("01-01-010-01-02-09");
		indexRaisedKnuckleLeftHandHalfTurn = new PositionedHandSymbol(indexRaisedKnuckleLeftHandHalfTurnSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(indexRaisedKnuckleLeftHandHalfTurnSymbol.getBaseSymbol()));
		Symbol indexRaisedKnuckleRightHandFullTurnSymbol = symbolFactory.createSymbol("01-01-010-01-03-01");
		indexRaisedKnuckleRightHandFullTurn = new PositionedHandSymbol(indexRaisedKnuckleRightHandFullTurnSymbol, 0, 0,
				2, symbolFactory.getAllRotationsAndFillsFor(indexRaisedKnuckleRightHandFullTurnSymbol.getBaseSymbol()));
		Symbol indexRaisedKnuckleLeftHandFullTurnSymbol = symbolFactory.createSymbol("01-01-010-01-03-09");
		indexRaisedKnuckleLeftHandFullTurn = new PositionedHandSymbol(indexRaisedKnuckleLeftHandFullTurnSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(indexRaisedKnuckleLeftHandFullTurnSymbol.getBaseSymbol()));
		Symbol indexRaisedKnuckleRightHandPitchedSymbol = symbolFactory.createSymbol("01-01-010-01-04-01");
		indexRaisedKnuckleRightHandPitched = new PositionedHandSymbol(indexRaisedKnuckleRightHandPitchedSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(indexRaisedKnuckleRightHandPitchedSymbol.getBaseSymbol()));
		Symbol indexRaisedKnuckleLeftHandPitchedSymbol = symbolFactory.createSymbol("01-01-010-01-04-09");
		indexRaisedKnuckleLeftHandPitched = new PositionedHandSymbol(indexRaisedKnuckleLeftHandPitchedSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(indexRaisedKnuckleLeftHandPitchedSymbol.getBaseSymbol()));
		Symbol indexRaisedKnuckleRightHandHalfTurnPitchedSymbol = symbolFactory.createSymbol("01-01-010-01-05-01");
		indexRaisedKnuckleRightHandHalfTurnPitched = new PositionedHandSymbol(
				indexRaisedKnuckleRightHandHalfTurnPitchedSymbol, 0, 0, 2, symbolFactory
						.getAllRotationsAndFillsFor(indexRaisedKnuckleRightHandHalfTurnPitchedSymbol.getBaseSymbol()));
		Symbol indexRaisedKnuckleLeftHandHalfTurnPitchedSymbol = symbolFactory.createSymbol("01-01-010-01-05-09");
		indexRaisedKnuckleLeftHandHalfTurnPitched = new PositionedHandSymbol(
				indexRaisedKnuckleLeftHandHalfTurnPitchedSymbol, 0, 0, 2, symbolFactory
						.getAllRotationsAndFillsFor(indexRaisedKnuckleLeftHandHalfTurnPitchedSymbol.getBaseSymbol()));
		Symbol indexRaisedKnuckleRightHandFullTurnPitchedSymbol = symbolFactory.createSymbol("01-01-010-01-06-01");
		indexRaisedKnuckleRightHandFullTurnPitched = new PositionedHandSymbol(
				indexRaisedKnuckleRightHandFullTurnPitchedSymbol, 0, 0, 2, symbolFactory
						.getAllRotationsAndFillsFor(indexRaisedKnuckleRightHandFullTurnPitchedSymbol.getBaseSymbol()));
		Symbol indexRaisedKnuckleLeftHandFullTurnPitchedSymbol = symbolFactory.createSymbol("01-01-010-01-06-09");
		indexRaisedKnuckleLeftHandFullTurnPitched = new PositionedHandSymbol(
				indexRaisedKnuckleLeftHandFullTurnPitchedSymbol, 0, 0, 2, symbolFactory
						.getAllRotationsAndFillsFor(indexRaisedKnuckleLeftHandFullTurnPitchedSymbol.getBaseSymbol()));

		indexCupRightHand = new PositionedHandSymbol(HandBaseSymbol.INDEX_CUP.getIswaSymbol(), 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(HandBaseSymbol.INDEX_CUP.getIswaSymbol().getBaseSymbol()));
		Symbol indexCupLeftHandSymbol = symbolFactory.createSymbol("01-01-011-01-01-09");
		indexCupLeftHand = new PositionedHandSymbol(indexCupLeftHandSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(indexCupLeftHandSymbol.getBaseSymbol()));
		Symbol indexCupRightHandHalfTurnSymbol = symbolFactory.createSymbol("01-01-011-01-02-01");
		indexCupRightHandHalfTurn = new PositionedHandSymbol(indexCupRightHandHalfTurnSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(indexCupRightHandHalfTurnSymbol.getBaseSymbol()));
		Symbol indexCupLeftHandHalfTurnSymbol = symbolFactory.createSymbol("01-01-011-01-02-09");
		indexCupLeftHandHalfTurn = new PositionedHandSymbol(indexCupLeftHandHalfTurnSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(indexCupLeftHandHalfTurnSymbol.getBaseSymbol()));
		Symbol indexCupRightHandFullTurnSymbol = symbolFactory.createSymbol("01-01-011-01-03-01");
		indexCupRightHandFullTurn = new PositionedHandSymbol(indexCupRightHandFullTurnSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(indexCupRightHandFullTurnSymbol.getBaseSymbol()));
		Symbol indexCupLeftHandFullTurnSymbol = symbolFactory.createSymbol("01-01-011-01-03-09");
		indexCupLeftHandFullTurn = new PositionedHandSymbol(indexCupLeftHandFullTurnSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(indexCupLeftHandFullTurnSymbol.getBaseSymbol()));
		Symbol indexCupRightHandPitchedSymbol = symbolFactory.createSymbol("01-01-011-01-04-01");
		indexCupRightHandPitched = new PositionedHandSymbol(indexCupRightHandPitchedSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(indexCupRightHandPitchedSymbol.getBaseSymbol()));
		Symbol indexCupLeftHandPitchedSymbol = symbolFactory.createSymbol("01-01-011-01-04-09");
		indexCupLeftHandPitched = new PositionedHandSymbol(indexCupLeftHandPitchedSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(indexCupLeftHandPitchedSymbol.getBaseSymbol()));
		Symbol indexCupRightHandHalfTurnPitchedSymbol = symbolFactory.createSymbol("01-01-011-01-05-01");
		indexCupRightHandHalfTurnPitched = new PositionedHandSymbol(indexCupRightHandHalfTurnPitchedSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(indexCupRightHandHalfTurnPitchedSymbol.getBaseSymbol()));
		Symbol indexCupLeftHandHalfTurnPitchedSymbol = symbolFactory.createSymbol("01-01-011-01-05-09");
		indexCupLeftHandHalfTurnPitched = new PositionedHandSymbol(indexCupLeftHandHalfTurnPitchedSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(indexCupLeftHandHalfTurnPitchedSymbol.getBaseSymbol()));
		Symbol indexCupRightHandFullTurnPitchedSymbol = symbolFactory.createSymbol("01-01-011-01-06-01");
		indexCupRightHandFullTurnPitched = new PositionedHandSymbol(indexCupRightHandFullTurnPitchedSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(indexCupRightHandFullTurnPitchedSymbol.getBaseSymbol()));
		Symbol indexCupLeftHandFullTurnPitchedSymbol = symbolFactory.createSymbol("01-01-011-01-06-09");
		indexCupLeftHandFullTurnPitched = new PositionedHandSymbol(indexCupLeftHandFullTurnPitchedSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(indexCupLeftHandFullTurnPitchedSymbol.getBaseSymbol()));

		indexHingeOnFistRightHand = new PositionedHandSymbol(HandBaseSymbol.INDEX_HINGE_ON_FIST.getIswaSymbol(), 0, 0,
				2, symbolFactory.getAllRotationsAndFillsFor(
						HandBaseSymbol.INDEX_HINGE_ON_FIST.getIswaSymbol().getBaseSymbol()));
		Symbol indexHingeOnFistLeftHandSymbol = symbolFactory.createSymbol("01-01-012-01-01-09");
		indexHingeOnFistLeftHand = new PositionedHandSymbol(indexHingeOnFistLeftHandSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(indexHingeOnFistLeftHandSymbol.getBaseSymbol()));
		Symbol indexHingeOnFistRightHandHalfTurnSymbol = symbolFactory.createSymbol("01-01-012-01-02-01");
		indexHingeOnFistRightHandHalfTurn = new PositionedHandSymbol(indexHingeOnFistRightHandHalfTurnSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(indexHingeOnFistRightHandHalfTurnSymbol.getBaseSymbol()));
		Symbol indexHingeOnFistLeftHandHalfTurnSymbol = symbolFactory.createSymbol("01-01-012-01-02-09");
		indexHingeOnFistLeftHandHalfTurn = new PositionedHandSymbol(indexHingeOnFistLeftHandHalfTurnSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(indexHingeOnFistLeftHandHalfTurnSymbol.getBaseSymbol()));
		Symbol indexHingeOnFistRightHandFullTurnSymbol = symbolFactory.createSymbol("01-01-012-01-03-01");
		indexHingeOnFistRightHandFullTurn = new PositionedHandSymbol(indexHingeOnFistRightHandFullTurnSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(indexHingeOnFistRightHandFullTurnSymbol.getBaseSymbol()));
		Symbol indexHingeOnFistLeftHandFullTurnSymbol = symbolFactory.createSymbol("01-01-012-01-03-09");
		indexHingeOnFistLeftHandFullTurn = new PositionedHandSymbol(indexHingeOnFistLeftHandFullTurnSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(indexHingeOnFistLeftHandFullTurnSymbol.getBaseSymbol()));
		Symbol indexHingeOnFistRightHandPitchedSymbol = symbolFactory.createSymbol("01-01-012-01-04-01");
		indexHingeOnFistRightHandPitched = new PositionedHandSymbol(indexHingeOnFistRightHandPitchedSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(indexHingeOnFistRightHandPitchedSymbol.getBaseSymbol()));
		Symbol indexHingeOnFistLeftHandPitchedSymbol = symbolFactory.createSymbol("01-01-012-01-04-09");
		indexHingeOnFistLeftHandPitched = new PositionedHandSymbol(indexHingeOnFistLeftHandPitchedSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(indexHingeOnFistLeftHandPitchedSymbol.getBaseSymbol()));
		Symbol indexHingeOnFistRightHandHalfTurnPitchedSymbol = symbolFactory.createSymbol("01-01-012-01-05-01");
		indexHingeOnFistRightHandHalfTurnPitched = new PositionedHandSymbol(
				indexHingeOnFistRightHandHalfTurnPitchedSymbol, 0, 0, 2, symbolFactory
						.getAllRotationsAndFillsFor(indexHingeOnFistRightHandHalfTurnPitchedSymbol.getBaseSymbol()));
		Symbol indexHingeOnFistLeftHandHalfTurnPitchedSymbol = symbolFactory.createSymbol("01-01-012-01-05-09");
		indexHingeOnFistLeftHandHalfTurnPitched = new PositionedHandSymbol(
				indexHingeOnFistLeftHandHalfTurnPitchedSymbol, 0, 0, 2, symbolFactory
						.getAllRotationsAndFillsFor(indexHingeOnFistLeftHandHalfTurnPitchedSymbol.getBaseSymbol()));
		Symbol indexHingeOnFistRightHandFullTurnPitchedSymbol = symbolFactory.createSymbol("01-01-012-01-06-01");
		indexHingeOnFistRightHandFullTurnPitched = new PositionedHandSymbol(
				indexHingeOnFistRightHandFullTurnPitchedSymbol, 0, 0, 2, symbolFactory
						.getAllRotationsAndFillsFor(indexHingeOnFistRightHandFullTurnPitchedSymbol.getBaseSymbol()));
		Symbol indexHingeOnFistLeftHandFullTurnPitchedSymbol = symbolFactory.createSymbol("01-01-012-01-06-09");
		indexHingeOnFistLeftHandFullTurnPitched = new PositionedHandSymbol(
				indexHingeOnFistLeftHandFullTurnPitchedSymbol, 0, 0, 2, symbolFactory
						.getAllRotationsAndFillsFor(indexHingeOnFistLeftHandFullTurnPitchedSymbol.getBaseSymbol()));

		indexHingeOnFistLowRightHand = new PositionedHandSymbol(HandBaseSymbol.INDEX_HINGE_ON_FIST_LOW.getIswaSymbol(),
				0, 0, 2, symbolFactory.getAllRotationsAndFillsFor(
						HandBaseSymbol.INDEX_HINGE_ON_FIST_LOW.getIswaSymbol().getBaseSymbol()));
		Symbol indexHingeOnFistLowLeftHandSymbol = symbolFactory.createSymbol("01-01-013-01-01-09");
		indexHingeOnFistLowLeftHand = new PositionedHandSymbol(indexHingeOnFistLowLeftHandSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(indexHingeOnFistLowLeftHandSymbol.getBaseSymbol()));
		Symbol indexHingeOnFistLowRightHandHalfTurnSymbol = symbolFactory.createSymbol("01-01-013-01-02-01");
		indexHingeOnFistLowRightHandHalfTurn = new PositionedHandSymbol(indexHingeOnFistLowRightHandHalfTurnSymbol, 0,
				0, 2,
				symbolFactory.getAllRotationsAndFillsFor(indexHingeOnFistLowRightHandHalfTurnSymbol.getBaseSymbol()));
		Symbol indexHingeOnFistLowLeftHandHalfTurnSymbol = symbolFactory.createSymbol("01-01-013-01-02-09");
		indexHingeOnFistLowLeftHandHalfTurn = new PositionedHandSymbol(indexHingeOnFistLowLeftHandHalfTurnSymbol, 0, 0,
				2, symbolFactory.getAllRotationsAndFillsFor(indexHingeOnFistLowLeftHandHalfTurnSymbol.getBaseSymbol()));
		Symbol indexHingeOnFistLowRightHandFullTurnSymbol = symbolFactory.createSymbol("01-01-013-01-03-01");
		indexHingeOnFistLowRightHandFullTurn = new PositionedHandSymbol(indexHingeOnFistLowRightHandFullTurnSymbol, 0,
				0, 2,
				symbolFactory.getAllRotationsAndFillsFor(indexHingeOnFistLowRightHandFullTurnSymbol.getBaseSymbol()));
		Symbol indexHingeOnFistLowLeftHandFullTurnSymbol = symbolFactory.createSymbol("01-01-013-01-03-09");
		indexHingeOnFistLowLeftHandFullTurn = new PositionedHandSymbol(indexHingeOnFistLowLeftHandFullTurnSymbol, 0, 0,
				2, symbolFactory.getAllRotationsAndFillsFor(indexHingeOnFistLowLeftHandFullTurnSymbol.getBaseSymbol()));
		Symbol indexHingeOnFistLowRightHandPitchedSymbol = symbolFactory.createSymbol("01-01-013-01-04-01");
		indexHingeOnFistLowRightHandPitched = new PositionedHandSymbol(indexHingeOnFistLowRightHandPitchedSymbol, 0, 0,
				2, symbolFactory.getAllRotationsAndFillsFor(indexHingeOnFistLowRightHandPitchedSymbol.getBaseSymbol()));
		Symbol indexHingeOnFistLowLeftHandPitchedSymbol = symbolFactory.createSymbol("01-01-013-01-04-09");
		indexHingeOnFistLowLeftHandPitched = new PositionedHandSymbol(indexHingeOnFistLowLeftHandPitchedSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(indexHingeOnFistLowLeftHandPitchedSymbol.getBaseSymbol()));
		Symbol indexHingeOnFistLowRightHandHalfTurnPitchedSymbol = symbolFactory.createSymbol("01-01-013-01-05-01");
		indexHingeOnFistLowRightHandHalfTurnPitched = new PositionedHandSymbol(
				indexHingeOnFistLowRightHandHalfTurnPitchedSymbol, 0, 0, 2, symbolFactory
						.getAllRotationsAndFillsFor(indexHingeOnFistLowRightHandHalfTurnPitchedSymbol.getBaseSymbol()));
		Symbol indexHingeOnFistLowLeftHandHalfTurnPitchedSymbol = symbolFactory.createSymbol("01-01-013-01-05-09");
		indexHingeOnFistLowLeftHandHalfTurnPitched = new PositionedHandSymbol(
				indexHingeOnFistLowLeftHandHalfTurnPitchedSymbol, 0, 0, 2, symbolFactory
						.getAllRotationsAndFillsFor(indexHingeOnFistLowLeftHandHalfTurnPitchedSymbol.getBaseSymbol()));
		Symbol indexHingeOnFistLowRightHandFullTurnPitchedSymbol = symbolFactory.createSymbol("01-01-013-01-06-01");
		indexHingeOnFistLowRightHandFullTurnPitched = new PositionedHandSymbol(
				indexHingeOnFistLowRightHandFullTurnPitchedSymbol, 0, 0, 2, symbolFactory
						.getAllRotationsAndFillsFor(indexHingeOnFistLowRightHandFullTurnPitchedSymbol.getBaseSymbol()));
		Symbol indexHingeOnFistLowLeftHandFullTurnPitchedSymbol = symbolFactory.createSymbol("01-01-013-01-06-09");
		indexHingeOnFistLowLeftHandFullTurnPitched = new PositionedHandSymbol(
				indexHingeOnFistLowLeftHandFullTurnPitchedSymbol, 0, 0, 2, symbolFactory
						.getAllRotationsAndFillsFor(indexHingeOnFistLowLeftHandFullTurnPitchedSymbol.getBaseSymbol()));

		indexHingeOnCircleRightHand = new PositionedHandSymbol(HandBaseSymbol.INDEX_HINGE_ON_CIRCLE.getIswaSymbol(), 0,
				0, 2, symbolFactory.getAllRotationsAndFillsFor(
						HandBaseSymbol.INDEX_HINGE_ON_CIRCLE.getIswaSymbol().getBaseSymbol()));
		Symbol indexHingeOnCircleLeftHandSymbol = symbolFactory.createSymbol("01-01-014-01-01-09");
		indexHingeOnCircleLeftHand = new PositionedHandSymbol(indexHingeOnCircleLeftHandSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(indexHingeOnCircleLeftHandSymbol.getBaseSymbol()));
		Symbol indexHingeOnCircleRightHandHalfTurnSymbol = symbolFactory.createSymbol("01-01-014-01-02-01");
		indexHingeOnCircleRightHandHalfTurn = new PositionedHandSymbol(indexHingeOnCircleRightHandHalfTurnSymbol, 0, 0,
				2, symbolFactory.getAllRotationsAndFillsFor(indexHingeOnCircleRightHandHalfTurnSymbol.getBaseSymbol()));
		Symbol indexHingeOnCircleLeftHandHalfTurnSymbol = symbolFactory.createSymbol("01-01-014-01-02-09");
		indexHingeOnCircleLeftHandHalfTurn = new PositionedHandSymbol(indexHingeOnCircleLeftHandHalfTurnSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(indexHingeOnCircleLeftHandHalfTurnSymbol.getBaseSymbol()));
		Symbol indexHingeOnCircleRightHandFullTurnSymbol = symbolFactory.createSymbol("01-01-014-01-03-01");
		indexHingeOnCircleRightHandFullTurn = new PositionedHandSymbol(indexHingeOnCircleRightHandFullTurnSymbol, 0, 0,
				2, symbolFactory.getAllRotationsAndFillsFor(indexHingeOnCircleRightHandFullTurnSymbol.getBaseSymbol()));
		Symbol indexHingeOnCircleLeftHandFullTurnSymbol = symbolFactory.createSymbol("01-01-014-01-03-09");
		indexHingeOnCircleLeftHandFullTurn = new PositionedHandSymbol(indexHingeOnCircleLeftHandFullTurnSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(indexHingeOnCircleLeftHandFullTurnSymbol.getBaseSymbol()));
		Symbol indexHingeOnCircleRightHandPitchedSymbol = symbolFactory.createSymbol("01-01-014-01-04-01");
		indexHingeOnCircleRightHandPitched = new PositionedHandSymbol(indexHingeOnCircleRightHandPitchedSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(indexHingeOnCircleRightHandPitchedSymbol.getBaseSymbol()));
		Symbol indexHingeOnCircleLeftHandPitchedSymbol = symbolFactory.createSymbol("01-01-014-01-04-09");
		indexHingeOnCircleLeftHandPitched = new PositionedHandSymbol(indexHingeOnCircleLeftHandPitchedSymbol, 0, 0, 2,
				symbolFactory.getAllRotationsAndFillsFor(indexHingeOnCircleLeftHandPitchedSymbol.getBaseSymbol()));
		Symbol indexHingeOnCircleRightHandHalfTurnPitchedSymbol = symbolFactory.createSymbol("01-01-014-01-05-01");
		indexHingeOnCircleRightHandHalfTurnPitched = new PositionedHandSymbol(
				indexHingeOnCircleRightHandHalfTurnPitchedSymbol, 0, 0, 2, symbolFactory
						.getAllRotationsAndFillsFor(indexHingeOnCircleRightHandHalfTurnPitchedSymbol.getBaseSymbol()));
		Symbol indexHingeOnCircleLeftHandHalfTurnPitchedSymbol = symbolFactory.createSymbol("01-01-014-01-05-09");
		indexHingeOnCircleLeftHandHalfTurnPitched = new PositionedHandSymbol(
				indexHingeOnCircleLeftHandHalfTurnPitchedSymbol, 0, 0, 2, symbolFactory
						.getAllRotationsAndFillsFor(indexHingeOnCircleLeftHandHalfTurnPitchedSymbol.getBaseSymbol()));
		Symbol indexHingeOnCircleRightHandFullTurnPitchedSymbol = symbolFactory.createSymbol("01-01-014-01-06-01");
		indexHingeOnCircleRightHandFullTurnPitched = new PositionedHandSymbol(
				indexHingeOnCircleRightHandFullTurnPitchedSymbol, 0, 0, 2, symbolFactory
						.getAllRotationsAndFillsFor(indexHingeOnCircleRightHandFullTurnPitchedSymbol.getBaseSymbol()));
		Symbol indexHingeOnCircleLeftHandFullTurnPitchedSymbol = symbolFactory.createSymbol("01-01-014-01-06-09");
		indexHingeOnCircleLeftHandFullTurnPitched = new PositionedHandSymbol(
				indexHingeOnCircleLeftHandFullTurnPitchedSymbol, 0, 0, 2, symbolFactory
						.getAllRotationsAndFillsFor(indexHingeOnCircleLeftHandFullTurnPitchedSymbol.getBaseSymbol()));

	}

	@Override
	public void testIsRightHand() {

		assertTrue(indexRightHand.isRightHand());
		assertTrue(indexRightHandHalfTurn.isRightHand());
		assertTrue(indexRightHandFullTurn.isRightHand());
		assertTrue(indexRightHandPitched.isRightHand());
		assertTrue(indexRightHandHalfTurnPitched.isRightHand());
		assertTrue(indexRightHandFullTurnPitched.isRightHand());

		assertFalse(indexLeftHand.isRightHand());
		assertFalse(indexLeftHandHalfTurn.isRightHand());
		assertFalse(indexLeftHandFullTurn.isRightHand());
		assertFalse(indexLeftHandPitched.isRightHand());
		assertFalse(indexLeftHandHalfTurnPitched.isRightHand());
		assertFalse(indexLeftHandFullTurnPitched.isRightHand());

		assertTrue(indexOnCircleRightHand.isRightHand());
		assertTrue(indexOnCircleRightHandHalfTurn.isRightHand());
		assertTrue(indexOnCircleRightHandFullTurn.isRightHand());
		assertTrue(indexOnCircleRightHandPitched.isRightHand());
		assertTrue(indexOnCircleRightHandHalfTurnPitched.isRightHand());
		assertTrue(indexOnCircleRightHandFullTurnPitched.isRightHand());

		assertFalse(indexOnCircleLeftHand.isRightHand());
		assertFalse(indexOnCircleLeftHandHalfTurn.isRightHand());
		assertFalse(indexOnCircleLeftHandFullTurn.isRightHand());
		assertFalse(indexOnCircleLeftHandPitched.isRightHand());
		assertFalse(indexOnCircleLeftHandHalfTurnPitched.isRightHand());
		assertFalse(indexOnCircleLeftHandFullTurnPitched.isRightHand());

		assertTrue(indexOnCupRightHand.isRightHand());
		assertTrue(indexOnCupRightHandHalfTurn.isRightHand());
		assertTrue(indexOnCupRightHandFullTurn.isRightHand());
		assertTrue(indexOnCupRightHandPitched.isRightHand());
		assertTrue(indexOnCupRightHandHalfTurnPitched.isRightHand());
		assertTrue(indexOnCupRightHandFullTurnPitched.isRightHand());

		assertFalse(indexOnCupLeftHand.isRightHand());
		assertFalse(indexOnCupLeftHandHalfTurn.isRightHand());
		assertFalse(indexOnCupLeftHandFullTurn.isRightHand());
		assertFalse(indexOnCupLeftHandPitched.isRightHand());
		assertFalse(indexOnCupLeftHandHalfTurnPitched.isRightHand());
		assertFalse(indexOnCupLeftHandFullTurnPitched.isRightHand());

		assertTrue(indexOnOvalRightHand.isRightHand());
		assertTrue(indexOnOvalRightHandHalfTurn.isRightHand());
		assertTrue(indexOnOvalRightHandFullTurn.isRightHand());
		assertTrue(indexOnOvalRightHandPitched.isRightHand());
		assertTrue(indexOnOvalRightHandHalfTurnPitched.isRightHand());
		assertTrue(indexOnOvalRightHandFullTurnPitched.isRightHand());

		assertFalse(indexOnOvalLeftHand.isRightHand());
		assertFalse(indexOnOvalLeftHandHalfTurn.isRightHand());
		assertFalse(indexOnOvalLeftHandFullTurn.isRightHand());
		assertFalse(indexOnOvalLeftHandPitched.isRightHand());
		assertFalse(indexOnOvalLeftHandHalfTurnPitched.isRightHand());
		assertFalse(indexOnOvalLeftHandFullTurnPitched.isRightHand());

		assertTrue(indexOnHingeRightHand.isRightHand());
		assertTrue(indexOnHingeRightHandHalfTurn.isRightHand());
		assertTrue(indexOnHingeRightHandFullTurn.isRightHand());
		assertTrue(indexOnHingeRightHandPitched.isRightHand());
		assertTrue(indexOnHingeRightHandHalfTurnPitched.isRightHand());
		assertTrue(indexOnHingeRightHandFullTurnPitched.isRightHand());

		assertFalse(indexOnHingeLeftHand.isRightHand());
		assertFalse(indexOnHingeLeftHandHalfTurn.isRightHand());
		assertFalse(indexOnHingeLeftHandFullTurn.isRightHand());
		assertFalse(indexOnHingeLeftHandPitched.isRightHand());
		assertFalse(indexOnHingeLeftHandHalfTurnPitched.isRightHand());
		assertFalse(indexOnHingeLeftHandFullTurnPitched.isRightHand());

		assertTrue(indexOnAngleRightHand.isRightHand());
		assertTrue(indexOnAngleRightHandHalfTurn.isRightHand());
		assertTrue(indexOnAngleRightHandFullTurn.isRightHand());
		assertTrue(indexOnAngleRightHandPitched.isRightHand());
		assertTrue(indexOnAngleRightHandHalfTurnPitched.isRightHand());
		assertTrue(indexOnAngleRightHandFullTurnPitched.isRightHand());

		assertFalse(indexOnAngleLeftHand.isRightHand());
		assertFalse(indexOnAngleLeftHandHalfTurn.isRightHand());
		assertFalse(indexOnAngleLeftHandFullTurn.isRightHand());
		assertFalse(indexOnAngleLeftHandPitched.isRightHand());
		assertFalse(indexOnAngleLeftHandHalfTurnPitched.isRightHand());
		assertFalse(indexOnAngleLeftHandFullTurnPitched.isRightHand());

		assertTrue(indexBentRightHand.isRightHand());
		assertTrue(indexBentRightHandHalfTurn.isRightHand());
		assertTrue(indexBentRightHandFullTurn.isRightHand());
		assertTrue(indexBentRightHandPitched.isRightHand());
		assertTrue(indexBentRightHandHalfTurnPitched.isRightHand());
		assertTrue(indexBentRightHandFullTurnPitched.isRightHand());

		assertFalse(indexBentLeftHand.isRightHand());
		assertFalse(indexBentLeftHandHalfTurn.isRightHand());
		assertFalse(indexBentLeftHandFullTurn.isRightHand());
		assertFalse(indexBentLeftHandPitched.isRightHand());
		assertFalse(indexBentLeftHandHalfTurnPitched.isRightHand());
		assertFalse(indexBentLeftHandFullTurnPitched.isRightHand());

		assertTrue(indexBentOnCircleRightHand.isRightHand());
		assertTrue(indexBentOnCircleRightHandHalfTurn.isRightHand());
		assertTrue(indexBentOnCircleRightHandFullTurn.isRightHand());
		assertTrue(indexBentOnCircleRightHandPitched.isRightHand());
		assertTrue(indexBentOnCircleRightHandHalfTurnPitched.isRightHand());
		assertTrue(indexBentOnCircleRightHandFullTurnPitched.isRightHand());

		assertFalse(indexBentOnCircleLeftHand.isRightHand());
		assertFalse(indexBentOnCircleLeftHandHalfTurn.isRightHand());
		assertFalse(indexBentOnCircleLeftHandFullTurn.isRightHand());
		assertFalse(indexBentOnCircleLeftHandPitched.isRightHand());
		assertFalse(indexBentOnCircleLeftHandHalfTurnPitched.isRightHand());
		assertFalse(indexBentOnCircleLeftHandFullTurnPitched.isRightHand());

		assertTrue(indexBentOnFistThumbUnderRightHand.isRightHand());
		assertTrue(indexBentOnFistThumbUnderRightHandHalfTurn.isRightHand());
		assertTrue(indexBentOnFistThumbUnderRightHandFullTurn.isRightHand());
		assertTrue(indexBentOnFistThumbUnderRightHandPitched.isRightHand());
		assertTrue(indexBentOnFistThumbUnderRightHandHalfTurnPitched.isRightHand());
		assertTrue(indexBentOnFistThumbUnderRightHandFullTurnPitched.isRightHand());

		assertFalse(indexBentOnFistThumbUnderLeftHand.isRightHand());
		assertFalse(indexBentOnFistThumbUnderLeftHandHalfTurn.isRightHand());
		assertFalse(indexBentOnFistThumbUnderLeftHandFullTurn.isRightHand());
		assertFalse(indexBentOnFistThumbUnderLeftHandPitched.isRightHand());
		assertFalse(indexBentOnFistThumbUnderLeftHandHalfTurnPitched.isRightHand());
		assertFalse(indexBentOnFistThumbUnderLeftHandFullTurnPitched.isRightHand());

		assertTrue(indexRaisedKnuckleRightHand.isRightHand());
		assertTrue(indexRaisedKnuckleRightHandHalfTurn.isRightHand());
		assertTrue(indexRaisedKnuckleRightHandFullTurn.isRightHand());
		assertTrue(indexRaisedKnuckleRightHandPitched.isRightHand());
		assertTrue(indexRaisedKnuckleRightHandHalfTurnPitched.isRightHand());
		assertTrue(indexRaisedKnuckleRightHandFullTurnPitched.isRightHand());

		assertFalse(indexRaisedKnuckleLeftHand.isRightHand());
		assertFalse(indexRaisedKnuckleLeftHandHalfTurn.isRightHand());
		assertFalse(indexRaisedKnuckleLeftHandFullTurn.isRightHand());
		assertFalse(indexRaisedKnuckleLeftHandPitched.isRightHand());
		assertFalse(indexRaisedKnuckleLeftHandHalfTurnPitched.isRightHand());
		assertFalse(indexRaisedKnuckleLeftHandFullTurnPitched.isRightHand());

		assertTrue(indexCupRightHand.isRightHand());
		assertTrue(indexCupRightHandHalfTurn.isRightHand());
		assertTrue(indexCupRightHandFullTurn.isRightHand());
		assertTrue(indexCupRightHandPitched.isRightHand());
		assertTrue(indexCupRightHandHalfTurnPitched.isRightHand());
		assertTrue(indexCupRightHandFullTurnPitched.isRightHand());

		assertFalse(indexCupLeftHand.isRightHand());
		assertFalse(indexCupLeftHandHalfTurn.isRightHand());
		assertFalse(indexCupLeftHandFullTurn.isRightHand());
		assertFalse(indexCupLeftHandPitched.isRightHand());
		assertFalse(indexCupLeftHandHalfTurnPitched.isRightHand());
		assertFalse(indexCupLeftHandFullTurnPitched.isRightHand());

		assertTrue(indexHingeOnFistRightHand.isRightHand());
		assertTrue(indexHingeOnFistRightHandHalfTurn.isRightHand());
		assertTrue(indexHingeOnFistRightHandFullTurn.isRightHand());
		assertTrue(indexHingeOnFistRightHandPitched.isRightHand());
		assertTrue(indexHingeOnFistRightHandHalfTurnPitched.isRightHand());
		assertTrue(indexHingeOnFistRightHandFullTurnPitched.isRightHand());

		assertFalse(indexHingeOnFistLeftHand.isRightHand());
		assertFalse(indexHingeOnFistLeftHandHalfTurn.isRightHand());
		assertFalse(indexHingeOnFistLeftHandFullTurn.isRightHand());
		assertFalse(indexHingeOnFistLeftHandPitched.isRightHand());
		assertFalse(indexHingeOnFistLeftHandHalfTurnPitched.isRightHand());
		assertFalse(indexHingeOnFistLeftHandFullTurnPitched.isRightHand());

		assertTrue(indexHingeOnFistLowRightHand.isRightHand());
		assertTrue(indexHingeOnFistLowRightHandHalfTurn.isRightHand());
		assertTrue(indexHingeOnFistLowRightHandFullTurn.isRightHand());
		assertTrue(indexHingeOnFistLowRightHandPitched.isRightHand());
		assertTrue(indexHingeOnFistLowRightHandHalfTurnPitched.isRightHand());
		assertTrue(indexHingeOnFistLowRightHandFullTurnPitched.isRightHand());

		assertFalse(indexHingeOnFistLowLeftHand.isRightHand());
		assertFalse(indexHingeOnFistLowLeftHandHalfTurn.isRightHand());
		assertFalse(indexHingeOnFistLowLeftHandFullTurn.isRightHand());
		assertFalse(indexHingeOnFistLowLeftHandPitched.isRightHand());
		assertFalse(indexHingeOnFistLowLeftHandHalfTurnPitched.isRightHand());
		assertFalse(indexHingeOnFistLowLeftHandFullTurnPitched.isRightHand());

		assertTrue(indexHingeOnCircleRightHand.isRightHand());
		assertTrue(indexHingeOnCircleRightHandHalfTurn.isRightHand());
		assertTrue(indexHingeOnCircleRightHandFullTurn.isRightHand());
		assertTrue(indexHingeOnCircleRightHandPitched.isRightHand());
		assertTrue(indexHingeOnCircleRightHandHalfTurnPitched.isRightHand());
		assertTrue(indexHingeOnCircleRightHandFullTurnPitched.isRightHand());

		assertFalse(indexHingeOnCircleLeftHand.isRightHand());
		assertFalse(indexHingeOnCircleLeftHandHalfTurn.isRightHand());
		assertFalse(indexHingeOnCircleLeftHandFullTurn.isRightHand());
		assertFalse(indexHingeOnCircleLeftHandPitched.isRightHand());
		assertFalse(indexHingeOnCircleLeftHandHalfTurnPitched.isRightHand());
		assertFalse(indexHingeOnCircleLeftHandFullTurnPitched.isRightHand());

	}

	@Override
	public void testIsLeftHand() {

		assertFalse(indexRightHand.isLeftHand());
		assertFalse(indexRightHandHalfTurn.isLeftHand());
		assertFalse(indexRightHandFullTurn.isLeftHand());
		assertFalse(indexRightHandPitched.isLeftHand());
		assertFalse(indexRightHandHalfTurnPitched.isLeftHand());
		assertFalse(indexRightHandFullTurnPitched.isLeftHand());

		assertTrue(indexLeftHand.isLeftHand());
		assertTrue(indexLeftHandHalfTurn.isLeftHand());
		assertTrue(indexLeftHandFullTurn.isLeftHand());
		assertTrue(indexLeftHandPitched.isLeftHand());
		assertTrue(indexLeftHandHalfTurnPitched.isLeftHand());
		assertTrue(indexLeftHandFullTurnPitched.isLeftHand());

		assertFalse(indexOnCircleRightHand.isLeftHand());
		assertFalse(indexOnCircleRightHandHalfTurn.isLeftHand());
		assertFalse(indexOnCircleRightHandFullTurn.isLeftHand());
		assertFalse(indexOnCircleRightHandPitched.isLeftHand());
		assertFalse(indexOnCircleRightHandHalfTurnPitched.isLeftHand());
		assertFalse(indexOnCircleRightHandFullTurnPitched.isLeftHand());

		assertTrue(indexOnCircleLeftHand.isLeftHand());
		assertTrue(indexOnCircleLeftHandHalfTurn.isLeftHand());
		assertTrue(indexOnCircleLeftHandFullTurn.isLeftHand());
		assertTrue(indexOnCircleLeftHandPitched.isLeftHand());
		assertTrue(indexOnCircleLeftHandHalfTurnPitched.isLeftHand());
		assertTrue(indexOnCircleLeftHandFullTurnPitched.isLeftHand());

		assertFalse(indexOnCupRightHand.isLeftHand());
		assertFalse(indexOnCupRightHandHalfTurn.isLeftHand());
		assertFalse(indexOnCupRightHandFullTurn.isLeftHand());
		assertFalse(indexOnCupRightHandPitched.isLeftHand());
		assertFalse(indexOnCupRightHandHalfTurnPitched.isLeftHand());
		assertFalse(indexOnCupRightHandFullTurnPitched.isLeftHand());

		assertTrue(indexOnCupLeftHand.isLeftHand());
		assertTrue(indexOnCupLeftHandHalfTurn.isLeftHand());
		assertTrue(indexOnCupLeftHandFullTurn.isLeftHand());
		assertTrue(indexOnCupLeftHandPitched.isLeftHand());
		assertTrue(indexOnCupLeftHandHalfTurnPitched.isLeftHand());
		assertTrue(indexOnCupLeftHandFullTurnPitched.isLeftHand());

		assertFalse(indexOnOvalRightHand.isLeftHand());
		assertFalse(indexOnOvalRightHandHalfTurn.isLeftHand());
		assertFalse(indexOnOvalRightHandFullTurn.isLeftHand());
		assertFalse(indexOnOvalRightHandPitched.isLeftHand());
		assertFalse(indexOnOvalRightHandHalfTurnPitched.isLeftHand());
		assertFalse(indexOnOvalRightHandFullTurnPitched.isLeftHand());

		assertTrue(indexOnOvalLeftHand.isLeftHand());
		assertTrue(indexOnOvalLeftHandHalfTurn.isLeftHand());
		assertTrue(indexOnOvalLeftHandFullTurn.isLeftHand());
		assertTrue(indexOnOvalLeftHandPitched.isLeftHand());
		assertTrue(indexOnOvalLeftHandHalfTurnPitched.isLeftHand());
		assertTrue(indexOnOvalLeftHandFullTurnPitched.isLeftHand());

		assertFalse(indexOnHingeRightHand.isLeftHand());
		assertFalse(indexOnHingeRightHandHalfTurn.isLeftHand());
		assertFalse(indexOnHingeRightHandFullTurn.isLeftHand());
		assertFalse(indexOnHingeRightHandPitched.isLeftHand());
		assertFalse(indexOnHingeRightHandHalfTurnPitched.isLeftHand());
		assertFalse(indexOnHingeRightHandFullTurnPitched.isLeftHand());

		assertTrue(indexOnHingeLeftHand.isLeftHand());
		assertTrue(indexOnHingeLeftHandHalfTurn.isLeftHand());
		assertTrue(indexOnHingeLeftHandFullTurn.isLeftHand());
		assertTrue(indexOnHingeLeftHandPitched.isLeftHand());
		assertTrue(indexOnHingeLeftHandHalfTurnPitched.isLeftHand());
		assertTrue(indexOnHingeLeftHandFullTurnPitched.isLeftHand());

		assertFalse(indexOnAngleRightHand.isLeftHand());
		assertFalse(indexOnAngleRightHandHalfTurn.isLeftHand());
		assertFalse(indexOnAngleRightHandFullTurn.isLeftHand());
		assertFalse(indexOnAngleRightHandPitched.isLeftHand());
		assertFalse(indexOnAngleRightHandHalfTurnPitched.isLeftHand());
		assertFalse(indexOnAngleRightHandFullTurnPitched.isLeftHand());

		assertTrue(indexOnAngleLeftHand.isLeftHand());
		assertTrue(indexOnAngleLeftHandHalfTurn.isLeftHand());
		assertTrue(indexOnAngleLeftHandFullTurn.isLeftHand());
		assertTrue(indexOnAngleLeftHandPitched.isLeftHand());
		assertTrue(indexOnAngleLeftHandHalfTurnPitched.isLeftHand());
		assertTrue(indexOnAngleLeftHandFullTurnPitched.isLeftHand());

		assertFalse(indexBentRightHand.isLeftHand());
		assertFalse(indexBentRightHandHalfTurn.isLeftHand());
		assertFalse(indexBentRightHandFullTurn.isLeftHand());
		assertFalse(indexBentRightHandPitched.isLeftHand());
		assertFalse(indexBentRightHandHalfTurnPitched.isLeftHand());
		assertFalse(indexBentRightHandFullTurnPitched.isLeftHand());

		assertTrue(indexBentLeftHand.isLeftHand());
		assertTrue(indexBentLeftHandHalfTurn.isLeftHand());
		assertTrue(indexBentLeftHandFullTurn.isLeftHand());
		assertTrue(indexBentLeftHandPitched.isLeftHand());
		assertTrue(indexBentLeftHandHalfTurnPitched.isLeftHand());
		assertTrue(indexBentLeftHandFullTurnPitched.isLeftHand());

		assertFalse(indexBentOnCircleRightHand.isLeftHand());
		assertFalse(indexBentOnCircleRightHandHalfTurn.isLeftHand());
		assertFalse(indexBentOnCircleRightHandFullTurn.isLeftHand());
		assertFalse(indexBentOnCircleRightHandPitched.isLeftHand());
		assertFalse(indexBentOnCircleRightHandHalfTurnPitched.isLeftHand());
		assertFalse(indexBentOnCircleRightHandFullTurnPitched.isLeftHand());

		assertTrue(indexBentOnCircleLeftHand.isLeftHand());
		assertTrue(indexBentOnCircleLeftHandHalfTurn.isLeftHand());
		assertTrue(indexBentOnCircleLeftHandFullTurn.isLeftHand());
		assertTrue(indexBentOnCircleLeftHandPitched.isLeftHand());
		assertTrue(indexBentOnCircleLeftHandHalfTurnPitched.isLeftHand());
		assertTrue(indexBentOnCircleLeftHandFullTurnPitched.isLeftHand());

		assertFalse(indexBentOnFistThumbUnderRightHand.isLeftHand());
		assertFalse(indexBentOnFistThumbUnderRightHandHalfTurn.isLeftHand());
		assertFalse(indexBentOnFistThumbUnderRightHandFullTurn.isLeftHand());
		assertFalse(indexBentOnFistThumbUnderRightHandPitched.isLeftHand());
		assertFalse(indexBentOnFistThumbUnderRightHandHalfTurnPitched.isLeftHand());
		assertFalse(indexBentOnFistThumbUnderRightHandFullTurnPitched.isLeftHand());

		assertTrue(indexBentOnFistThumbUnderLeftHand.isLeftHand());
		assertTrue(indexBentOnFistThumbUnderLeftHandHalfTurn.isLeftHand());
		assertTrue(indexBentOnFistThumbUnderLeftHandFullTurn.isLeftHand());
		assertTrue(indexBentOnFistThumbUnderLeftHandPitched.isLeftHand());
		assertTrue(indexBentOnFistThumbUnderLeftHandHalfTurnPitched.isLeftHand());
		assertTrue(indexBentOnFistThumbUnderLeftHandFullTurnPitched.isLeftHand());

		assertFalse(indexRaisedKnuckleRightHand.isLeftHand());
		assertFalse(indexRaisedKnuckleRightHandHalfTurn.isLeftHand());
		assertFalse(indexRaisedKnuckleRightHandFullTurn.isLeftHand());
		assertFalse(indexRaisedKnuckleRightHandPitched.isLeftHand());
		assertFalse(indexRaisedKnuckleRightHandHalfTurnPitched.isLeftHand());
		assertFalse(indexRaisedKnuckleRightHandFullTurnPitched.isLeftHand());

		assertTrue(indexRaisedKnuckleLeftHand.isLeftHand());
		assertTrue(indexRaisedKnuckleLeftHandHalfTurn.isLeftHand());
		assertTrue(indexRaisedKnuckleLeftHandFullTurn.isLeftHand());
		assertTrue(indexRaisedKnuckleLeftHandPitched.isLeftHand());
		assertTrue(indexRaisedKnuckleLeftHandHalfTurnPitched.isLeftHand());
		assertTrue(indexRaisedKnuckleLeftHandFullTurnPitched.isLeftHand());

		assertFalse(indexCupRightHand.isLeftHand());
		assertFalse(indexCupRightHandHalfTurn.isLeftHand());
		assertFalse(indexCupRightHandFullTurn.isLeftHand());
		assertFalse(indexCupRightHandPitched.isLeftHand());
		assertFalse(indexCupRightHandHalfTurnPitched.isLeftHand());
		assertFalse(indexCupRightHandFullTurnPitched.isLeftHand());

		assertTrue(indexCupLeftHand.isLeftHand());
		assertTrue(indexCupLeftHandHalfTurn.isLeftHand());
		assertTrue(indexCupLeftHandFullTurn.isLeftHand());
		assertTrue(indexCupLeftHandPitched.isLeftHand());
		assertTrue(indexCupLeftHandHalfTurnPitched.isLeftHand());
		assertTrue(indexCupLeftHandFullTurnPitched.isLeftHand());

		assertFalse(indexHingeOnFistRightHand.isLeftHand());
		assertFalse(indexHingeOnFistRightHandHalfTurn.isLeftHand());
		assertFalse(indexHingeOnFistRightHandFullTurn.isLeftHand());
		assertFalse(indexHingeOnFistRightHandPitched.isLeftHand());
		assertFalse(indexHingeOnFistRightHandHalfTurnPitched.isLeftHand());
		assertFalse(indexHingeOnFistRightHandFullTurnPitched.isLeftHand());

		assertTrue(indexHingeOnFistLeftHand.isLeftHand());
		assertTrue(indexHingeOnFistLeftHandHalfTurn.isLeftHand());
		assertTrue(indexHingeOnFistLeftHandFullTurn.isLeftHand());
		assertTrue(indexHingeOnFistLeftHandPitched.isLeftHand());
		assertTrue(indexHingeOnFistLeftHandHalfTurnPitched.isLeftHand());
		assertTrue(indexHingeOnFistLeftHandFullTurnPitched.isLeftHand());

		assertFalse(indexHingeOnFistLowRightHand.isLeftHand());
		assertFalse(indexHingeOnFistLowRightHandHalfTurn.isLeftHand());
		assertFalse(indexHingeOnFistLowRightHandFullTurn.isLeftHand());
		assertFalse(indexHingeOnFistLowRightHandPitched.isLeftHand());
		assertFalse(indexHingeOnFistLowRightHandHalfTurnPitched.isLeftHand());
		assertFalse(indexHingeOnFistLowRightHandFullTurnPitched.isLeftHand());

		assertTrue(indexHingeOnFistLowLeftHand.isLeftHand());
		assertTrue(indexHingeOnFistLowLeftHandHalfTurn.isLeftHand());
		assertTrue(indexHingeOnFistLowLeftHandFullTurn.isLeftHand());
		assertTrue(indexHingeOnFistLowLeftHandPitched.isLeftHand());
		assertTrue(indexHingeOnFistLowLeftHandHalfTurnPitched.isLeftHand());
		assertTrue(indexHingeOnFistLowLeftHandFullTurnPitched.isLeftHand());

		assertFalse(indexHingeOnCircleRightHand.isLeftHand());
		assertFalse(indexHingeOnCircleRightHandHalfTurn.isLeftHand());
		assertFalse(indexHingeOnCircleRightHandFullTurn.isLeftHand());
		assertFalse(indexHingeOnCircleRightHandPitched.isLeftHand());
		assertFalse(indexHingeOnCircleRightHandHalfTurnPitched.isLeftHand());
		assertFalse(indexHingeOnCircleRightHandFullTurnPitched.isLeftHand());

		assertTrue(indexHingeOnCircleLeftHand.isLeftHand());
		assertTrue(indexHingeOnCircleLeftHandHalfTurn.isLeftHand());
		assertTrue(indexHingeOnCircleLeftHandFullTurn.isLeftHand());
		assertTrue(indexHingeOnCircleLeftHandPitched.isLeftHand());
		assertTrue(indexHingeOnCircleLeftHandHalfTurnPitched.isLeftHand());
		assertTrue(indexHingeOnCircleLeftHandFullTurnPitched.isLeftHand());

	}

	@Override
	public void testCanIncrease() {

		assertFalse(indexRightHand.canIncrease());
		assertFalse(indexLeftHand.canIncrease());
		assertFalse(indexRightHandHalfTurn.canIncrease());
		assertFalse(indexLeftHandHalfTurn.canIncrease());
		assertFalse(indexRightHandFullTurn.canIncrease());
		assertFalse(indexLeftHandFullTurn.canIncrease());
		assertFalse(indexRightHandPitched.canIncrease());
		assertFalse(indexLeftHandPitched.canIncrease());
		assertFalse(indexRightHandHalfTurnPitched.canIncrease());
		assertFalse(indexLeftHandHalfTurnPitched.canIncrease());
		assertFalse(indexRightHandFullTurnPitched.canIncrease());
		assertFalse(indexLeftHandFullTurnPitched.canIncrease());

		assertFalse(indexOnCircleRightHand.canIncrease());
		assertFalse(indexOnCircleLeftHand.canIncrease());
		assertFalse(indexOnCircleRightHandHalfTurn.canIncrease());
		assertFalse(indexOnCircleLeftHandHalfTurn.canIncrease());
		assertFalse(indexOnCircleRightHandFullTurn.canIncrease());
		assertFalse(indexOnCircleLeftHandFullTurn.canIncrease());
		assertFalse(indexOnCircleRightHandPitched.canIncrease());
		assertFalse(indexOnCircleLeftHandPitched.canIncrease());
		assertFalse(indexOnCircleRightHandHalfTurnPitched.canIncrease());
		assertFalse(indexOnCircleLeftHandHalfTurnPitched.canIncrease());
		assertFalse(indexOnCircleRightHandFullTurnPitched.canIncrease());
		assertFalse(indexOnCircleLeftHandFullTurnPitched.canIncrease());

		assertFalse(indexOnCupRightHand.canIncrease());
		assertFalse(indexOnCupLeftHand.canIncrease());
		assertFalse(indexOnCupRightHandHalfTurn.canIncrease());
		assertFalse(indexOnCupLeftHandHalfTurn.canIncrease());
		assertFalse(indexOnCupRightHandFullTurn.canIncrease());
		assertFalse(indexOnCupLeftHandFullTurn.canIncrease());
		assertFalse(indexOnCupRightHandPitched.canIncrease());
		assertFalse(indexOnCupLeftHandPitched.canIncrease());
		assertFalse(indexOnCupRightHandHalfTurnPitched.canIncrease());
		assertFalse(indexOnCupLeftHandHalfTurnPitched.canIncrease());
		assertFalse(indexOnCupRightHandFullTurnPitched.canIncrease());
		assertFalse(indexOnCupLeftHandFullTurnPitched.canIncrease());

		assertFalse(indexOnOvalRightHand.canIncrease());
		assertFalse(indexOnOvalLeftHand.canIncrease());
		assertFalse(indexOnOvalRightHandHalfTurn.canIncrease());
		assertFalse(indexOnOvalLeftHandHalfTurn.canIncrease());
		assertFalse(indexOnOvalRightHandFullTurn.canIncrease());
		assertFalse(indexOnOvalLeftHandFullTurn.canIncrease());
		assertFalse(indexOnOvalRightHandPitched.canIncrease());
		assertFalse(indexOnOvalLeftHandPitched.canIncrease());
		assertFalse(indexOnOvalRightHandHalfTurnPitched.canIncrease());
		assertFalse(indexOnOvalLeftHandHalfTurnPitched.canIncrease());
		assertFalse(indexOnOvalRightHandFullTurnPitched.canIncrease());
		assertFalse(indexOnOvalLeftHandFullTurnPitched.canIncrease());

		assertFalse(indexOnHingeRightHand.canIncrease());
		assertFalse(indexOnHingeLeftHand.canIncrease());
		assertFalse(indexOnHingeRightHandHalfTurn.canIncrease());
		assertFalse(indexOnHingeLeftHandHalfTurn.canIncrease());
		assertFalse(indexOnHingeRightHandFullTurn.canIncrease());
		assertFalse(indexOnHingeLeftHandFullTurn.canIncrease());
		assertFalse(indexOnHingeRightHandPitched.canIncrease());
		assertFalse(indexOnHingeLeftHandPitched.canIncrease());
		assertFalse(indexOnHingeRightHandHalfTurnPitched.canIncrease());
		assertFalse(indexOnHingeLeftHandHalfTurnPitched.canIncrease());
		assertFalse(indexOnHingeRightHandFullTurnPitched.canIncrease());
		assertFalse(indexOnHingeLeftHandFullTurnPitched.canIncrease());

		assertFalse(indexOnAngleRightHand.canIncrease());
		assertFalse(indexOnAngleLeftHand.canIncrease());
		assertFalse(indexOnAngleRightHandHalfTurn.canIncrease());
		assertFalse(indexOnAngleLeftHandHalfTurn.canIncrease());
		assertFalse(indexOnAngleRightHandFullTurn.canIncrease());
		assertFalse(indexOnAngleLeftHandFullTurn.canIncrease());
		assertFalse(indexOnAngleRightHandPitched.canIncrease());
		assertFalse(indexOnAngleLeftHandPitched.canIncrease());
		assertFalse(indexOnAngleRightHandHalfTurnPitched.canIncrease());
		assertFalse(indexOnAngleLeftHandHalfTurnPitched.canIncrease());
		assertFalse(indexOnAngleRightHandFullTurnPitched.canIncrease());
		assertFalse(indexOnAngleLeftHandFullTurnPitched.canIncrease());

		assertFalse(indexBentRightHand.canIncrease());
		assertFalse(indexBentLeftHand.canIncrease());
		assertFalse(indexBentRightHandHalfTurn.canIncrease());
		assertFalse(indexBentLeftHandHalfTurn.canIncrease());
		assertFalse(indexBentRightHandFullTurn.canIncrease());
		assertFalse(indexBentLeftHandFullTurn.canIncrease());
		assertFalse(indexBentRightHandPitched.canIncrease());
		assertFalse(indexBentLeftHandPitched.canIncrease());
		assertFalse(indexBentRightHandHalfTurnPitched.canIncrease());
		assertFalse(indexBentLeftHandHalfTurnPitched.canIncrease());
		assertFalse(indexBentRightHandFullTurnPitched.canIncrease());
		assertFalse(indexBentLeftHandFullTurnPitched.canIncrease());

		assertFalse(indexBentOnCircleRightHand.canIncrease());
		assertFalse(indexBentOnCircleLeftHand.canIncrease());
		assertFalse(indexBentOnCircleRightHandHalfTurn.canIncrease());
		assertFalse(indexBentOnCircleLeftHandHalfTurn.canIncrease());
		assertFalse(indexBentOnCircleRightHandFullTurn.canIncrease());
		assertFalse(indexBentOnCircleLeftHandFullTurn.canIncrease());
		assertFalse(indexBentOnCircleRightHandPitched.canIncrease());
		assertFalse(indexBentOnCircleLeftHandPitched.canIncrease());
		assertFalse(indexBentOnCircleRightHandHalfTurnPitched.canIncrease());
		assertFalse(indexBentOnCircleLeftHandHalfTurnPitched.canIncrease());
		assertFalse(indexBentOnCircleRightHandFullTurnPitched.canIncrease());
		assertFalse(indexBentOnCircleLeftHandFullTurnPitched.canIncrease());

		assertFalse(indexBentOnFistThumbUnderRightHand.canIncrease());
		assertFalse(indexBentOnFistThumbUnderLeftHand.canIncrease());
		assertFalse(indexBentOnFistThumbUnderRightHandHalfTurn.canIncrease());
		assertFalse(indexBentOnFistThumbUnderLeftHandHalfTurn.canIncrease());
		assertFalse(indexBentOnFistThumbUnderRightHandFullTurn.canIncrease());
		assertFalse(indexBentOnFistThumbUnderLeftHandFullTurn.canIncrease());
		assertFalse(indexBentOnFistThumbUnderRightHandPitched.canIncrease());
		assertFalse(indexBentOnFistThumbUnderLeftHandPitched.canIncrease());
		assertFalse(indexBentOnFistThumbUnderRightHandHalfTurnPitched.canIncrease());
		assertFalse(indexBentOnFistThumbUnderLeftHandHalfTurnPitched.canIncrease());
		assertFalse(indexBentOnFistThumbUnderRightHandFullTurnPitched.canIncrease());
		assertFalse(indexBentOnFistThumbUnderLeftHandFullTurnPitched.canIncrease());

		assertFalse(indexRaisedKnuckleRightHand.canIncrease());
		assertFalse(indexRaisedKnuckleLeftHand.canIncrease());
		assertFalse(indexRaisedKnuckleRightHandHalfTurn.canIncrease());
		assertFalse(indexRaisedKnuckleLeftHandHalfTurn.canIncrease());
		assertFalse(indexRaisedKnuckleRightHandFullTurn.canIncrease());
		assertFalse(indexRaisedKnuckleLeftHandFullTurn.canIncrease());
		assertFalse(indexRaisedKnuckleRightHandPitched.canIncrease());
		assertFalse(indexRaisedKnuckleLeftHandPitched.canIncrease());
		assertFalse(indexRaisedKnuckleRightHandHalfTurnPitched.canIncrease());
		assertFalse(indexRaisedKnuckleLeftHandHalfTurnPitched.canIncrease());
		assertFalse(indexRaisedKnuckleRightHandFullTurnPitched.canIncrease());
		assertFalse(indexRaisedKnuckleLeftHandFullTurnPitched.canIncrease());

		assertFalse(indexCupRightHand.canIncrease());
		assertFalse(indexCupLeftHand.canIncrease());
		assertFalse(indexCupRightHandHalfTurn.canIncrease());
		assertFalse(indexCupLeftHandHalfTurn.canIncrease());
		assertFalse(indexCupRightHandFullTurn.canIncrease());
		assertFalse(indexCupLeftHandFullTurn.canIncrease());
		assertFalse(indexCupRightHandPitched.canIncrease());
		assertFalse(indexCupLeftHandPitched.canIncrease());
		assertFalse(indexCupRightHandHalfTurnPitched.canIncrease());
		assertFalse(indexCupLeftHandHalfTurnPitched.canIncrease());
		assertFalse(indexCupRightHandFullTurnPitched.canIncrease());
		assertFalse(indexCupLeftHandFullTurnPitched.canIncrease());

		assertFalse(indexHingeOnFistRightHand.canIncrease());
		assertFalse(indexHingeOnFistLeftHand.canIncrease());
		assertFalse(indexHingeOnFistRightHandHalfTurn.canIncrease());
		assertFalse(indexHingeOnFistLeftHandHalfTurn.canIncrease());
		assertFalse(indexHingeOnFistRightHandFullTurn.canIncrease());
		assertFalse(indexHingeOnFistLeftHandFullTurn.canIncrease());
		assertFalse(indexHingeOnFistRightHandPitched.canIncrease());
		assertFalse(indexHingeOnFistLeftHandPitched.canIncrease());
		assertFalse(indexHingeOnFistRightHandHalfTurnPitched.canIncrease());
		assertFalse(indexHingeOnFistLeftHandHalfTurnPitched.canIncrease());
		assertFalse(indexHingeOnFistRightHandFullTurnPitched.canIncrease());
		assertFalse(indexHingeOnFistLeftHandFullTurnPitched.canIncrease());

		assertFalse(indexHingeOnFistLowRightHand.canIncrease());
		assertFalse(indexHingeOnFistLowLeftHand.canIncrease());
		assertFalse(indexHingeOnFistLowRightHandHalfTurn.canIncrease());
		assertFalse(indexHingeOnFistLowLeftHandHalfTurn.canIncrease());
		assertFalse(indexHingeOnFistLowRightHandFullTurn.canIncrease());
		assertFalse(indexHingeOnFistLowLeftHandFullTurn.canIncrease());
		assertFalse(indexHingeOnFistLowRightHandPitched.canIncrease());
		assertFalse(indexHingeOnFistLowLeftHandPitched.canIncrease());
		assertFalse(indexHingeOnFistLowRightHandHalfTurnPitched.canIncrease());
		assertFalse(indexHingeOnFistLowLeftHandHalfTurnPitched.canIncrease());
		assertFalse(indexHingeOnFistLowRightHandFullTurnPitched.canIncrease());
		assertFalse(indexHingeOnFistLowLeftHandFullTurnPitched.canIncrease());

		assertFalse(indexHingeOnCircleRightHand.canIncrease());
		assertFalse(indexHingeOnCircleLeftHand.canIncrease());
		assertFalse(indexHingeOnCircleRightHandHalfTurn.canIncrease());
		assertFalse(indexHingeOnCircleLeftHandHalfTurn.canIncrease());
		assertFalse(indexHingeOnCircleRightHandFullTurn.canIncrease());
		assertFalse(indexHingeOnCircleLeftHandFullTurn.canIncrease());
		assertFalse(indexHingeOnCircleRightHandPitched.canIncrease());
		assertFalse(indexHingeOnCircleLeftHandPitched.canIncrease());
		assertFalse(indexHingeOnCircleRightHandHalfTurnPitched.canIncrease());
		assertFalse(indexHingeOnCircleLeftHandHalfTurnPitched.canIncrease());
		assertFalse(indexHingeOnCircleRightHandFullTurnPitched.canIncrease());
		assertFalse(indexHingeOnCircleLeftHandFullTurnPitched.canIncrease());

	}

	@Override
	public void testIncrease() {

	}

	@Override
	public void testCanDecrease() {

		assertFalse(indexRightHand.canDecrease());
		assertFalse(indexLeftHand.canDecrease());
		assertFalse(indexRightHandHalfTurn.canDecrease());
		assertFalse(indexLeftHandHalfTurn.canDecrease());
		assertFalse(indexRightHandFullTurn.canDecrease());
		assertFalse(indexLeftHandFullTurn.canDecrease());
		assertFalse(indexRightHandPitched.canDecrease());
		assertFalse(indexLeftHandPitched.canDecrease());
		assertFalse(indexRightHandHalfTurnPitched.canDecrease());
		assertFalse(indexLeftHandHalfTurnPitched.canDecrease());
		assertFalse(indexRightHandFullTurnPitched.canDecrease());
		assertFalse(indexLeftHandFullTurnPitched.canDecrease());

		assertFalse(indexOnCircleRightHand.canDecrease());
		assertFalse(indexOnCircleLeftHand.canDecrease());
		assertFalse(indexOnCircleRightHandHalfTurn.canDecrease());
		assertFalse(indexOnCircleLeftHandHalfTurn.canDecrease());
		assertFalse(indexOnCircleRightHandFullTurn.canDecrease());
		assertFalse(indexOnCircleLeftHandFullTurn.canDecrease());
		assertFalse(indexOnCircleRightHandPitched.canDecrease());
		assertFalse(indexOnCircleLeftHandPitched.canDecrease());
		assertFalse(indexOnCircleRightHandHalfTurnPitched.canDecrease());
		assertFalse(indexOnCircleLeftHandHalfTurnPitched.canDecrease());
		assertFalse(indexOnCircleRightHandFullTurnPitched.canDecrease());
		assertFalse(indexOnCircleLeftHandFullTurnPitched.canDecrease());

		assertFalse(indexOnCupRightHand.canDecrease());
		assertFalse(indexOnCupLeftHand.canDecrease());
		assertFalse(indexOnCupRightHandHalfTurn.canDecrease());
		assertFalse(indexOnCupLeftHandHalfTurn.canDecrease());
		assertFalse(indexOnCupRightHandFullTurn.canDecrease());
		assertFalse(indexOnCupLeftHandFullTurn.canDecrease());
		assertFalse(indexOnCupRightHandPitched.canDecrease());
		assertFalse(indexOnCupLeftHandPitched.canDecrease());
		assertFalse(indexOnCupRightHandHalfTurnPitched.canDecrease());
		assertFalse(indexOnCupLeftHandHalfTurnPitched.canDecrease());
		assertFalse(indexOnCupRightHandFullTurnPitched.canDecrease());
		assertFalse(indexOnCupLeftHandFullTurnPitched.canDecrease());

		assertFalse(indexOnOvalRightHand.canDecrease());
		assertFalse(indexOnOvalLeftHand.canDecrease());
		assertFalse(indexOnOvalRightHandHalfTurn.canDecrease());
		assertFalse(indexOnOvalLeftHandHalfTurn.canDecrease());
		assertFalse(indexOnOvalRightHandFullTurn.canDecrease());
		assertFalse(indexOnOvalLeftHandFullTurn.canDecrease());
		assertFalse(indexOnOvalRightHandPitched.canDecrease());
		assertFalse(indexOnOvalLeftHandPitched.canDecrease());
		assertFalse(indexOnOvalRightHandHalfTurnPitched.canDecrease());
		assertFalse(indexOnOvalLeftHandHalfTurnPitched.canDecrease());
		assertFalse(indexOnOvalRightHandFullTurnPitched.canDecrease());
		assertFalse(indexOnOvalLeftHandFullTurnPitched.canDecrease());

		assertFalse(indexOnHingeRightHand.canDecrease());
		assertFalse(indexOnHingeLeftHand.canDecrease());
		assertFalse(indexOnHingeRightHandHalfTurn.canDecrease());
		assertFalse(indexOnHingeLeftHandHalfTurn.canDecrease());
		assertFalse(indexOnHingeRightHandFullTurn.canDecrease());
		assertFalse(indexOnHingeLeftHandFullTurn.canDecrease());
		assertFalse(indexOnHingeRightHandPitched.canDecrease());
		assertFalse(indexOnHingeLeftHandPitched.canDecrease());
		assertFalse(indexOnHingeRightHandHalfTurnPitched.canDecrease());
		assertFalse(indexOnHingeLeftHandHalfTurnPitched.canDecrease());
		assertFalse(indexOnHingeRightHandFullTurnPitched.canDecrease());
		assertFalse(indexOnHingeLeftHandFullTurnPitched.canDecrease());

		assertFalse(indexOnAngleRightHand.canDecrease());
		assertFalse(indexOnAngleLeftHand.canDecrease());
		assertFalse(indexOnAngleRightHandHalfTurn.canDecrease());
		assertFalse(indexOnAngleLeftHandHalfTurn.canDecrease());
		assertFalse(indexOnAngleRightHandFullTurn.canDecrease());
		assertFalse(indexOnAngleLeftHandFullTurn.canDecrease());
		assertFalse(indexOnAngleRightHandPitched.canDecrease());
		assertFalse(indexOnAngleLeftHandPitched.canDecrease());
		assertFalse(indexOnAngleRightHandHalfTurnPitched.canDecrease());
		assertFalse(indexOnAngleLeftHandHalfTurnPitched.canDecrease());
		assertFalse(indexOnAngleRightHandFullTurnPitched.canDecrease());
		assertFalse(indexOnAngleLeftHandFullTurnPitched.canDecrease());

		assertFalse(indexBentRightHand.canDecrease());
		assertFalse(indexBentLeftHand.canDecrease());
		assertFalse(indexBentRightHandHalfTurn.canDecrease());
		assertFalse(indexBentLeftHandHalfTurn.canDecrease());
		assertFalse(indexBentRightHandFullTurn.canDecrease());
		assertFalse(indexBentLeftHandFullTurn.canDecrease());
		assertFalse(indexBentRightHandPitched.canDecrease());
		assertFalse(indexBentLeftHandPitched.canDecrease());
		assertFalse(indexBentRightHandHalfTurnPitched.canDecrease());
		assertFalse(indexBentLeftHandHalfTurnPitched.canDecrease());
		assertFalse(indexBentRightHandFullTurnPitched.canDecrease());
		assertFalse(indexBentLeftHandFullTurnPitched.canDecrease());

		assertFalse(indexBentOnCircleRightHand.canDecrease());
		assertFalse(indexBentOnCircleLeftHand.canDecrease());
		assertFalse(indexBentOnCircleRightHandHalfTurn.canDecrease());
		assertFalse(indexBentOnCircleLeftHandHalfTurn.canDecrease());
		assertFalse(indexBentOnCircleRightHandFullTurn.canDecrease());
		assertFalse(indexBentOnCircleLeftHandFullTurn.canDecrease());
		assertFalse(indexBentOnCircleRightHandPitched.canDecrease());
		assertFalse(indexBentOnCircleLeftHandPitched.canDecrease());
		assertFalse(indexBentOnCircleRightHandHalfTurnPitched.canDecrease());
		assertFalse(indexBentOnCircleLeftHandHalfTurnPitched.canDecrease());
		assertFalse(indexBentOnCircleRightHandFullTurnPitched.canDecrease());
		assertFalse(indexBentOnCircleLeftHandFullTurnPitched.canDecrease());

		assertFalse(indexBentOnFistThumbUnderRightHand.canDecrease());
		assertFalse(indexBentOnFistThumbUnderLeftHand.canDecrease());
		assertFalse(indexBentOnFistThumbUnderRightHandHalfTurn.canDecrease());
		assertFalse(indexBentOnFistThumbUnderLeftHandHalfTurn.canDecrease());
		assertFalse(indexBentOnFistThumbUnderRightHandFullTurn.canDecrease());
		assertFalse(indexBentOnFistThumbUnderLeftHandFullTurn.canDecrease());
		assertFalse(indexBentOnFistThumbUnderRightHandPitched.canDecrease());
		assertFalse(indexBentOnFistThumbUnderLeftHandPitched.canDecrease());
		assertFalse(indexBentOnFistThumbUnderRightHandHalfTurnPitched.canDecrease());
		assertFalse(indexBentOnFistThumbUnderLeftHandHalfTurnPitched.canDecrease());
		assertFalse(indexBentOnFistThumbUnderRightHandFullTurnPitched.canDecrease());
		assertFalse(indexBentOnFistThumbUnderLeftHandFullTurnPitched.canDecrease());

		assertFalse(indexRaisedKnuckleRightHand.canDecrease());
		assertFalse(indexRaisedKnuckleLeftHand.canDecrease());
		assertFalse(indexRaisedKnuckleRightHandHalfTurn.canDecrease());
		assertFalse(indexRaisedKnuckleLeftHandHalfTurn.canDecrease());
		assertFalse(indexRaisedKnuckleRightHandFullTurn.canDecrease());
		assertFalse(indexRaisedKnuckleLeftHandFullTurn.canDecrease());
		assertFalse(indexRaisedKnuckleRightHandPitched.canDecrease());
		assertFalse(indexRaisedKnuckleLeftHandPitched.canDecrease());
		assertFalse(indexRaisedKnuckleRightHandHalfTurnPitched.canDecrease());
		assertFalse(indexRaisedKnuckleLeftHandHalfTurnPitched.canDecrease());
		assertFalse(indexRaisedKnuckleRightHandFullTurnPitched.canDecrease());
		assertFalse(indexRaisedKnuckleLeftHandFullTurnPitched.canDecrease());

		assertFalse(indexCupRightHand.canDecrease());
		assertFalse(indexCupLeftHand.canDecrease());
		assertFalse(indexCupRightHandHalfTurn.canDecrease());
		assertFalse(indexCupLeftHandHalfTurn.canDecrease());
		assertFalse(indexCupRightHandFullTurn.canDecrease());
		assertFalse(indexCupLeftHandFullTurn.canDecrease());
		assertFalse(indexCupRightHandPitched.canDecrease());
		assertFalse(indexCupLeftHandPitched.canDecrease());
		assertFalse(indexCupRightHandHalfTurnPitched.canDecrease());
		assertFalse(indexCupLeftHandHalfTurnPitched.canDecrease());
		assertFalse(indexCupRightHandFullTurnPitched.canDecrease());
		assertFalse(indexCupLeftHandFullTurnPitched.canDecrease());

		assertFalse(indexHingeOnFistRightHand.canDecrease());
		assertFalse(indexHingeOnFistLeftHand.canDecrease());
		assertFalse(indexHingeOnFistRightHandHalfTurn.canDecrease());
		assertFalse(indexHingeOnFistLeftHandHalfTurn.canDecrease());
		assertFalse(indexHingeOnFistRightHandFullTurn.canDecrease());
		assertFalse(indexHingeOnFistLeftHandFullTurn.canDecrease());
		assertFalse(indexHingeOnFistRightHandPitched.canDecrease());
		assertFalse(indexHingeOnFistLeftHandPitched.canDecrease());
		assertFalse(indexHingeOnFistRightHandHalfTurnPitched.canDecrease());
		assertFalse(indexHingeOnFistLeftHandHalfTurnPitched.canDecrease());
		assertFalse(indexHingeOnFistRightHandFullTurnPitched.canDecrease());
		assertFalse(indexHingeOnFistLeftHandFullTurnPitched.canDecrease());

		assertFalse(indexHingeOnFistLowRightHand.canDecrease());
		assertFalse(indexHingeOnFistLowLeftHand.canDecrease());
		assertFalse(indexHingeOnFistLowRightHandHalfTurn.canDecrease());
		assertFalse(indexHingeOnFistLowLeftHandHalfTurn.canDecrease());
		assertFalse(indexHingeOnFistLowRightHandFullTurn.canDecrease());
		assertFalse(indexHingeOnFistLowLeftHandFullTurn.canDecrease());
		assertFalse(indexHingeOnFistLowRightHandPitched.canDecrease());
		assertFalse(indexHingeOnFistLowLeftHandPitched.canDecrease());
		assertFalse(indexHingeOnFistLowRightHandHalfTurnPitched.canDecrease());
		assertFalse(indexHingeOnFistLowLeftHandHalfTurnPitched.canDecrease());
		assertFalse(indexHingeOnFistLowRightHandFullTurnPitched.canDecrease());
		assertFalse(indexHingeOnFistLowLeftHandFullTurnPitched.canDecrease());

		assertFalse(indexHingeOnCircleRightHand.canDecrease());
		assertFalse(indexHingeOnCircleLeftHand.canDecrease());
		assertFalse(indexHingeOnCircleRightHandHalfTurn.canDecrease());
		assertFalse(indexHingeOnCircleLeftHandHalfTurn.canDecrease());
		assertFalse(indexHingeOnCircleRightHandFullTurn.canDecrease());
		assertFalse(indexHingeOnCircleLeftHandFullTurn.canDecrease());
		assertFalse(indexHingeOnCircleRightHandPitched.canDecrease());
		assertFalse(indexHingeOnCircleLeftHandPitched.canDecrease());
		assertFalse(indexHingeOnCircleRightHandHalfTurnPitched.canDecrease());
		assertFalse(indexHingeOnCircleLeftHandHalfTurnPitched.canDecrease());
		assertFalse(indexHingeOnCircleRightHandFullTurnPitched.canDecrease());
		assertFalse(indexHingeOnCircleLeftHandFullTurnPitched.canDecrease());

	}

	@Override
	public void testDecrease() {

	}

	@Override
	public void testCanRotate() {

		assertTrue(indexRightHand.canRotate());
		assertTrue(indexLeftHand.canRotate());
		assertTrue(indexRightHandHalfTurn.canRotate());
		assertTrue(indexLeftHandHalfTurn.canRotate());
		assertTrue(indexRightHandFullTurn.canRotate());
		assertTrue(indexLeftHandFullTurn.canRotate());
		assertTrue(indexRightHandPitched.canRotate());
		assertTrue(indexLeftHandPitched.canRotate());
		assertTrue(indexRightHandHalfTurnPitched.canRotate());
		assertTrue(indexLeftHandHalfTurnPitched.canRotate());
		assertTrue(indexRightHandFullTurnPitched.canRotate());
		assertTrue(indexLeftHandFullTurnPitched.canRotate());

		assertTrue(indexOnCircleRightHand.canRotate());
		assertTrue(indexOnCircleLeftHand.canRotate());
		assertTrue(indexOnCircleRightHandHalfTurn.canRotate());
		assertTrue(indexOnCircleLeftHandHalfTurn.canRotate());
		assertTrue(indexOnCircleRightHandFullTurn.canRotate());
		assertTrue(indexOnCircleLeftHandFullTurn.canRotate());
		assertTrue(indexOnCircleRightHandPitched.canRotate());
		assertTrue(indexOnCircleLeftHandPitched.canRotate());
		assertTrue(indexOnCircleRightHandHalfTurnPitched.canRotate());
		assertTrue(indexOnCircleLeftHandHalfTurnPitched.canRotate());
		assertTrue(indexOnCircleRightHandFullTurnPitched.canRotate());
		assertTrue(indexOnCircleLeftHandFullTurnPitched.canRotate());

		assertTrue(indexOnCupRightHand.canRotate());
		assertTrue(indexOnCupLeftHand.canRotate());
		assertTrue(indexOnCupRightHandHalfTurn.canRotate());
		assertTrue(indexOnCupLeftHandHalfTurn.canRotate());
		assertTrue(indexOnCupRightHandFullTurn.canRotate());
		assertTrue(indexOnCupLeftHandFullTurn.canRotate());
		assertTrue(indexOnCupRightHandPitched.canRotate());
		assertTrue(indexOnCupLeftHandPitched.canRotate());
		assertTrue(indexOnCupRightHandHalfTurnPitched.canRotate());
		assertTrue(indexOnCupLeftHandHalfTurnPitched.canRotate());
		assertTrue(indexOnCupRightHandFullTurnPitched.canRotate());
		assertTrue(indexOnCupLeftHandFullTurnPitched.canRotate());

		assertTrue(indexOnOvalRightHand.canRotate());
		assertTrue(indexOnOvalLeftHand.canRotate());
		assertTrue(indexOnOvalRightHandHalfTurn.canRotate());
		assertTrue(indexOnOvalLeftHandHalfTurn.canRotate());
		assertTrue(indexOnOvalRightHandFullTurn.canRotate());
		assertTrue(indexOnOvalLeftHandFullTurn.canRotate());
		assertTrue(indexOnOvalRightHandPitched.canRotate());
		assertTrue(indexOnOvalLeftHandPitched.canRotate());
		assertTrue(indexOnOvalRightHandHalfTurnPitched.canRotate());
		assertTrue(indexOnOvalLeftHandHalfTurnPitched.canRotate());
		assertTrue(indexOnOvalRightHandFullTurnPitched.canRotate());
		assertTrue(indexOnOvalLeftHandFullTurnPitched.canRotate());

		assertTrue(indexOnHingeRightHand.canRotate());
		assertTrue(indexOnHingeLeftHand.canRotate());
		assertTrue(indexOnHingeRightHandHalfTurn.canRotate());
		assertTrue(indexOnHingeLeftHandHalfTurn.canRotate());
		assertTrue(indexOnHingeRightHandFullTurn.canRotate());
		assertTrue(indexOnHingeLeftHandFullTurn.canRotate());
		assertTrue(indexOnHingeRightHandPitched.canRotate());
		assertTrue(indexOnHingeLeftHandPitched.canRotate());
		assertTrue(indexOnHingeRightHandHalfTurnPitched.canRotate());
		assertTrue(indexOnHingeLeftHandHalfTurnPitched.canRotate());
		assertTrue(indexOnHingeRightHandFullTurnPitched.canRotate());
		assertTrue(indexOnHingeLeftHandFullTurnPitched.canRotate());

		assertTrue(indexOnAngleRightHand.canRotate());
		assertTrue(indexOnAngleLeftHand.canRotate());
		assertTrue(indexOnAngleRightHandHalfTurn.canRotate());
		assertTrue(indexOnAngleLeftHandHalfTurn.canRotate());
		assertTrue(indexOnAngleRightHandFullTurn.canRotate());
		assertTrue(indexOnAngleLeftHandFullTurn.canRotate());
		assertTrue(indexOnAngleRightHandPitched.canRotate());
		assertTrue(indexOnAngleLeftHandPitched.canRotate());
		assertTrue(indexOnAngleRightHandHalfTurnPitched.canRotate());
		assertTrue(indexOnAngleLeftHandHalfTurnPitched.canRotate());
		assertTrue(indexOnAngleRightHandFullTurnPitched.canRotate());
		assertTrue(indexOnAngleLeftHandFullTurnPitched.canRotate());

		assertTrue(indexBentRightHand.canRotate());
		assertTrue(indexBentLeftHand.canRotate());
		assertTrue(indexBentRightHandHalfTurn.canRotate());
		assertTrue(indexBentLeftHandHalfTurn.canRotate());
		assertTrue(indexBentRightHandFullTurn.canRotate());
		assertTrue(indexBentLeftHandFullTurn.canRotate());
		assertTrue(indexBentRightHandPitched.canRotate());
		assertTrue(indexBentLeftHandPitched.canRotate());
		assertTrue(indexBentRightHandHalfTurnPitched.canRotate());
		assertTrue(indexBentLeftHandHalfTurnPitched.canRotate());
		assertTrue(indexBentRightHandFullTurnPitched.canRotate());
		assertTrue(indexBentLeftHandFullTurnPitched.canRotate());

		assertTrue(indexBentOnCircleRightHand.canRotate());
		assertTrue(indexBentOnCircleLeftHand.canRotate());
		assertTrue(indexBentOnCircleRightHandHalfTurn.canRotate());
		assertTrue(indexBentOnCircleLeftHandHalfTurn.canRotate());
		assertTrue(indexBentOnCircleRightHandFullTurn.canRotate());
		assertTrue(indexBentOnCircleLeftHandFullTurn.canRotate());
		assertTrue(indexBentOnCircleRightHandPitched.canRotate());
		assertTrue(indexBentOnCircleLeftHandPitched.canRotate());
		assertTrue(indexBentOnCircleRightHandHalfTurnPitched.canRotate());
		assertTrue(indexBentOnCircleLeftHandHalfTurnPitched.canRotate());
		assertTrue(indexBentOnCircleRightHandFullTurnPitched.canRotate());
		assertTrue(indexBentOnCircleLeftHandFullTurnPitched.canRotate());

		assertTrue(indexBentOnFistThumbUnderRightHand.canRotate());
		assertTrue(indexBentOnFistThumbUnderLeftHand.canRotate());
		assertTrue(indexBentOnFistThumbUnderRightHandHalfTurn.canRotate());
		assertTrue(indexBentOnFistThumbUnderLeftHandHalfTurn.canRotate());
		assertTrue(indexBentOnFistThumbUnderRightHandFullTurn.canRotate());
		assertTrue(indexBentOnFistThumbUnderLeftHandFullTurn.canRotate());
		assertTrue(indexBentOnFistThumbUnderRightHandPitched.canRotate());
		assertTrue(indexBentOnFistThumbUnderLeftHandPitched.canRotate());
		assertTrue(indexBentOnFistThumbUnderRightHandHalfTurnPitched.canRotate());
		assertTrue(indexBentOnFistThumbUnderLeftHandHalfTurnPitched.canRotate());
		assertTrue(indexBentOnFistThumbUnderRightHandFullTurnPitched.canRotate());
		assertTrue(indexBentOnFistThumbUnderLeftHandFullTurnPitched.canRotate());

		assertTrue(indexRaisedKnuckleRightHand.canRotate());
		assertTrue(indexRaisedKnuckleLeftHand.canRotate());
		assertTrue(indexRaisedKnuckleRightHandHalfTurn.canRotate());
		assertTrue(indexRaisedKnuckleLeftHandHalfTurn.canRotate());
		assertTrue(indexRaisedKnuckleRightHandFullTurn.canRotate());
		assertTrue(indexRaisedKnuckleLeftHandFullTurn.canRotate());
		assertTrue(indexRaisedKnuckleRightHandPitched.canRotate());
		assertTrue(indexRaisedKnuckleLeftHandPitched.canRotate());
		assertTrue(indexRaisedKnuckleRightHandHalfTurnPitched.canRotate());
		assertTrue(indexRaisedKnuckleLeftHandHalfTurnPitched.canRotate());
		assertTrue(indexRaisedKnuckleRightHandFullTurnPitched.canRotate());
		assertTrue(indexRaisedKnuckleLeftHandFullTurnPitched.canRotate());

		assertTrue(indexCupRightHand.canRotate());
		assertTrue(indexCupLeftHand.canRotate());
		assertTrue(indexCupRightHandHalfTurn.canRotate());
		assertTrue(indexCupLeftHandHalfTurn.canRotate());
		assertTrue(indexCupRightHandFullTurn.canRotate());
		assertTrue(indexCupLeftHandFullTurn.canRotate());
		assertTrue(indexCupRightHandPitched.canRotate());
		assertTrue(indexCupLeftHandPitched.canRotate());
		assertTrue(indexCupRightHandHalfTurnPitched.canRotate());
		assertTrue(indexCupLeftHandHalfTurnPitched.canRotate());
		assertTrue(indexCupRightHandFullTurnPitched.canRotate());
		assertTrue(indexCupLeftHandFullTurnPitched.canRotate());

		assertTrue(indexHingeOnFistRightHand.canRotate());
		assertTrue(indexHingeOnFistLeftHand.canRotate());
		assertTrue(indexHingeOnFistRightHandHalfTurn.canRotate());
		assertTrue(indexHingeOnFistLeftHandHalfTurn.canRotate());
		assertTrue(indexHingeOnFistRightHandFullTurn.canRotate());
		assertTrue(indexHingeOnFistLeftHandFullTurn.canRotate());
		assertTrue(indexHingeOnFistRightHandPitched.canRotate());
		assertTrue(indexHingeOnFistLeftHandPitched.canRotate());
		assertTrue(indexHingeOnFistRightHandHalfTurnPitched.canRotate());
		assertTrue(indexHingeOnFistLeftHandHalfTurnPitched.canRotate());
		assertTrue(indexHingeOnFistRightHandFullTurnPitched.canRotate());
		assertTrue(indexHingeOnFistLeftHandFullTurnPitched.canRotate());

		assertTrue(indexHingeOnFistLowRightHand.canRotate());
		assertTrue(indexHingeOnFistLowLeftHand.canRotate());
		assertTrue(indexHingeOnFistLowRightHandHalfTurn.canRotate());
		assertTrue(indexHingeOnFistLowLeftHandHalfTurn.canRotate());
		assertTrue(indexHingeOnFistLowRightHandFullTurn.canRotate());
		assertTrue(indexHingeOnFistLowLeftHandFullTurn.canRotate());
		assertTrue(indexHingeOnFistLowRightHandPitched.canRotate());
		assertTrue(indexHingeOnFistLowLeftHandPitched.canRotate());
		assertTrue(indexHingeOnFistLowRightHandHalfTurnPitched.canRotate());
		assertTrue(indexHingeOnFistLowLeftHandHalfTurnPitched.canRotate());
		assertTrue(indexHingeOnFistLowRightHandFullTurnPitched.canRotate());
		assertTrue(indexHingeOnFistLowLeftHandFullTurnPitched.canRotate());

		assertTrue(indexHingeOnCircleRightHand.canRotate());
		assertTrue(indexHingeOnCircleLeftHand.canRotate());
		assertTrue(indexHingeOnCircleRightHandHalfTurn.canRotate());
		assertTrue(indexHingeOnCircleLeftHandHalfTurn.canRotate());
		assertTrue(indexHingeOnCircleRightHandFullTurn.canRotate());
		assertTrue(indexHingeOnCircleLeftHandFullTurn.canRotate());
		assertTrue(indexHingeOnCircleRightHandPitched.canRotate());
		assertTrue(indexHingeOnCircleLeftHandPitched.canRotate());
		assertTrue(indexHingeOnCircleRightHandHalfTurnPitched.canRotate());
		assertTrue(indexHingeOnCircleLeftHandHalfTurnPitched.canRotate());
		assertTrue(indexHingeOnCircleRightHandFullTurnPitched.canRotate());
		assertTrue(indexHingeOnCircleLeftHandFullTurnPitched.canRotate());

	}

	@Override
	public void testRotateClockwise() {

		indexRightHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-01-08"), indexRightHand.getSymbol());
		indexRightHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-01-07"), indexRightHand.getSymbol());
		indexRightHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-01-06"), indexRightHand.getSymbol());
		indexRightHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-01-05"), indexRightHand.getSymbol());
		indexRightHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-01-04"), indexRightHand.getSymbol());
		indexRightHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-01-03"), indexRightHand.getSymbol());
		indexRightHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-01-02"), indexRightHand.getSymbol());
		indexRightHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-01-01"), indexRightHand.getSymbol());

		indexLeftHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-01-10"), indexLeftHand.getSymbol());
		indexLeftHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-01-11"), indexLeftHand.getSymbol());
		indexLeftHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-01-12"), indexLeftHand.getSymbol());
		indexLeftHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-01-13"), indexLeftHand.getSymbol());
		indexLeftHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-01-14"), indexLeftHand.getSymbol());
		indexLeftHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-01-15"), indexLeftHand.getSymbol());
		indexLeftHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-01-16"), indexLeftHand.getSymbol());
		indexLeftHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-01-09"), indexLeftHand.getSymbol());

		indexRightHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-02-08"), indexRightHandHalfTurn.getSymbol());
		indexRightHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-02-07"), indexRightHandHalfTurn.getSymbol());
		indexRightHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-02-06"), indexRightHandHalfTurn.getSymbol());
		indexRightHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-02-05"), indexRightHandHalfTurn.getSymbol());
		indexRightHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-02-04"), indexRightHandHalfTurn.getSymbol());
		indexRightHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-02-03"), indexRightHandHalfTurn.getSymbol());
		indexRightHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-02-02"), indexRightHandHalfTurn.getSymbol());
		indexRightHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-02-01"), indexRightHandHalfTurn.getSymbol());

		indexLeftHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-02-10"), indexLeftHandHalfTurn.getSymbol());
		indexLeftHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-02-11"), indexLeftHandHalfTurn.getSymbol());
		indexLeftHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-02-12"), indexLeftHandHalfTurn.getSymbol());
		indexLeftHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-02-13"), indexLeftHandHalfTurn.getSymbol());
		indexLeftHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-02-14"), indexLeftHandHalfTurn.getSymbol());
		indexLeftHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-02-15"), indexLeftHandHalfTurn.getSymbol());
		indexLeftHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-02-16"), indexLeftHandHalfTurn.getSymbol());
		indexLeftHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-02-09"), indexLeftHandHalfTurn.getSymbol());

		indexRightHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-03-08"), indexRightHandFullTurn.getSymbol());
		indexRightHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-03-07"), indexRightHandFullTurn.getSymbol());
		indexRightHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-03-06"), indexRightHandFullTurn.getSymbol());
		indexRightHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-03-05"), indexRightHandFullTurn.getSymbol());
		indexRightHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-03-04"), indexRightHandFullTurn.getSymbol());
		indexRightHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-03-03"), indexRightHandFullTurn.getSymbol());
		indexRightHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-03-02"), indexRightHandFullTurn.getSymbol());
		indexRightHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-03-01"), indexRightHandFullTurn.getSymbol());

		indexLeftHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-03-10"), indexLeftHandFullTurn.getSymbol());
		indexLeftHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-03-11"), indexLeftHandFullTurn.getSymbol());
		indexLeftHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-03-12"), indexLeftHandFullTurn.getSymbol());
		indexLeftHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-03-13"), indexLeftHandFullTurn.getSymbol());
		indexLeftHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-03-14"), indexLeftHandFullTurn.getSymbol());
		indexLeftHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-03-15"), indexLeftHandFullTurn.getSymbol());
		indexLeftHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-03-16"), indexLeftHandFullTurn.getSymbol());
		indexLeftHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-03-09"), indexLeftHandFullTurn.getSymbol());

		indexRightHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-04-08"), indexRightHandPitched.getSymbol());
		indexRightHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-04-07"), indexRightHandPitched.getSymbol());
		indexRightHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-04-06"), indexRightHandPitched.getSymbol());
		indexRightHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-04-05"), indexRightHandPitched.getSymbol());
		indexRightHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-04-04"), indexRightHandPitched.getSymbol());
		indexRightHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-04-03"), indexRightHandPitched.getSymbol());
		indexRightHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-04-02"), indexRightHandPitched.getSymbol());
		indexRightHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-04-01"), indexRightHandPitched.getSymbol());

		indexLeftHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-04-10"), indexLeftHandPitched.getSymbol());
		indexLeftHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-04-11"), indexLeftHandPitched.getSymbol());
		indexLeftHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-04-12"), indexLeftHandPitched.getSymbol());
		indexLeftHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-04-13"), indexLeftHandPitched.getSymbol());
		indexLeftHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-04-14"), indexLeftHandPitched.getSymbol());
		indexLeftHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-04-15"), indexLeftHandPitched.getSymbol());
		indexLeftHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-04-16"), indexLeftHandPitched.getSymbol());
		indexLeftHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-04-09"), indexLeftHandPitched.getSymbol());

		indexRightHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-05-08"), indexRightHandHalfTurnPitched.getSymbol());
		indexRightHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-05-07"), indexRightHandHalfTurnPitched.getSymbol());
		indexRightHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-05-06"), indexRightHandHalfTurnPitched.getSymbol());
		indexRightHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-05-05"), indexRightHandHalfTurnPitched.getSymbol());
		indexRightHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-05-04"), indexRightHandHalfTurnPitched.getSymbol());
		indexRightHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-05-03"), indexRightHandHalfTurnPitched.getSymbol());
		indexRightHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-05-02"), indexRightHandHalfTurnPitched.getSymbol());
		indexRightHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-05-01"), indexRightHandHalfTurnPitched.getSymbol());

		indexLeftHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-05-10"), indexLeftHandHalfTurnPitched.getSymbol());
		indexLeftHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-05-11"), indexLeftHandHalfTurnPitched.getSymbol());
		indexLeftHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-05-12"), indexLeftHandHalfTurnPitched.getSymbol());
		indexLeftHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-05-13"), indexLeftHandHalfTurnPitched.getSymbol());
		indexLeftHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-05-14"), indexLeftHandHalfTurnPitched.getSymbol());
		indexLeftHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-05-15"), indexLeftHandHalfTurnPitched.getSymbol());
		indexLeftHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-05-16"), indexLeftHandHalfTurnPitched.getSymbol());
		indexLeftHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-05-09"), indexLeftHandHalfTurnPitched.getSymbol());

		indexRightHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-06-08"), indexRightHandFullTurnPitched.getSymbol());
		indexRightHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-06-07"), indexRightHandFullTurnPitched.getSymbol());
		indexRightHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-06-06"), indexRightHandFullTurnPitched.getSymbol());
		indexRightHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-06-05"), indexRightHandFullTurnPitched.getSymbol());
		indexRightHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-06-04"), indexRightHandFullTurnPitched.getSymbol());
		indexRightHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-06-03"), indexRightHandFullTurnPitched.getSymbol());
		indexRightHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-06-02"), indexRightHandFullTurnPitched.getSymbol());
		indexRightHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-06-01"), indexRightHandFullTurnPitched.getSymbol());

		indexLeftHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-06-10"), indexLeftHandFullTurnPitched.getSymbol());
		indexLeftHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-06-11"), indexLeftHandFullTurnPitched.getSymbol());
		indexLeftHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-06-12"), indexLeftHandFullTurnPitched.getSymbol());
		indexLeftHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-06-13"), indexLeftHandFullTurnPitched.getSymbol());
		indexLeftHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-06-14"), indexLeftHandFullTurnPitched.getSymbol());
		indexLeftHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-06-15"), indexLeftHandFullTurnPitched.getSymbol());
		indexLeftHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-06-16"), indexLeftHandFullTurnPitched.getSymbol());
		indexLeftHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-06-09"), indexLeftHandFullTurnPitched.getSymbol());

		indexOnCircleRightHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-01-08"), indexOnCircleRightHand.getSymbol());
		indexOnCircleRightHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-01-07"), indexOnCircleRightHand.getSymbol());
		indexOnCircleRightHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-01-06"), indexOnCircleRightHand.getSymbol());
		indexOnCircleRightHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-01-05"), indexOnCircleRightHand.getSymbol());
		indexOnCircleRightHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-01-04"), indexOnCircleRightHand.getSymbol());
		indexOnCircleRightHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-01-03"), indexOnCircleRightHand.getSymbol());
		indexOnCircleRightHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-01-02"), indexOnCircleRightHand.getSymbol());
		indexOnCircleRightHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-01-01"), indexOnCircleRightHand.getSymbol());

		indexOnCircleLeftHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-01-10"), indexOnCircleLeftHand.getSymbol());
		indexOnCircleLeftHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-01-11"), indexOnCircleLeftHand.getSymbol());
		indexOnCircleLeftHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-01-12"), indexOnCircleLeftHand.getSymbol());
		indexOnCircleLeftHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-01-13"), indexOnCircleLeftHand.getSymbol());
		indexOnCircleLeftHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-01-14"), indexOnCircleLeftHand.getSymbol());
		indexOnCircleLeftHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-01-15"), indexOnCircleLeftHand.getSymbol());
		indexOnCircleLeftHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-01-16"), indexOnCircleLeftHand.getSymbol());
		indexOnCircleLeftHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-01-09"), indexOnCircleLeftHand.getSymbol());

		indexOnCircleRightHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-02-08"), indexOnCircleRightHandHalfTurn.getSymbol());
		indexOnCircleRightHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-02-07"), indexOnCircleRightHandHalfTurn.getSymbol());
		indexOnCircleRightHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-02-06"), indexOnCircleRightHandHalfTurn.getSymbol());
		indexOnCircleRightHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-02-05"), indexOnCircleRightHandHalfTurn.getSymbol());
		indexOnCircleRightHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-02-04"), indexOnCircleRightHandHalfTurn.getSymbol());
		indexOnCircleRightHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-02-03"), indexOnCircleRightHandHalfTurn.getSymbol());
		indexOnCircleRightHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-02-02"), indexOnCircleRightHandHalfTurn.getSymbol());
		indexOnCircleRightHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-02-01"), indexOnCircleRightHandHalfTurn.getSymbol());

		indexOnCircleLeftHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-02-10"), indexOnCircleLeftHandHalfTurn.getSymbol());
		indexOnCircleLeftHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-02-11"), indexOnCircleLeftHandHalfTurn.getSymbol());
		indexOnCircleLeftHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-02-12"), indexOnCircleLeftHandHalfTurn.getSymbol());
		indexOnCircleLeftHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-02-13"), indexOnCircleLeftHandHalfTurn.getSymbol());
		indexOnCircleLeftHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-02-14"), indexOnCircleLeftHandHalfTurn.getSymbol());
		indexOnCircleLeftHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-02-15"), indexOnCircleLeftHandHalfTurn.getSymbol());
		indexOnCircleLeftHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-02-16"), indexOnCircleLeftHandHalfTurn.getSymbol());
		indexOnCircleLeftHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-02-09"), indexOnCircleLeftHandHalfTurn.getSymbol());

		indexOnCircleRightHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-03-08"), indexOnCircleRightHandFullTurn.getSymbol());
		indexOnCircleRightHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-03-07"), indexOnCircleRightHandFullTurn.getSymbol());
		indexOnCircleRightHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-03-06"), indexOnCircleRightHandFullTurn.getSymbol());
		indexOnCircleRightHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-03-05"), indexOnCircleRightHandFullTurn.getSymbol());
		indexOnCircleRightHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-03-04"), indexOnCircleRightHandFullTurn.getSymbol());
		indexOnCircleRightHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-03-03"), indexOnCircleRightHandFullTurn.getSymbol());
		indexOnCircleRightHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-03-02"), indexOnCircleRightHandFullTurn.getSymbol());
		indexOnCircleRightHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-03-01"), indexOnCircleRightHandFullTurn.getSymbol());

		indexOnCircleLeftHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-03-10"), indexOnCircleLeftHandFullTurn.getSymbol());
		indexOnCircleLeftHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-03-11"), indexOnCircleLeftHandFullTurn.getSymbol());
		indexOnCircleLeftHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-03-12"), indexOnCircleLeftHandFullTurn.getSymbol());
		indexOnCircleLeftHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-03-13"), indexOnCircleLeftHandFullTurn.getSymbol());
		indexOnCircleLeftHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-03-14"), indexOnCircleLeftHandFullTurn.getSymbol());
		indexOnCircleLeftHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-03-15"), indexOnCircleLeftHandFullTurn.getSymbol());
		indexOnCircleLeftHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-03-16"), indexOnCircleLeftHandFullTurn.getSymbol());
		indexOnCircleLeftHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-03-09"), indexOnCircleLeftHandFullTurn.getSymbol());

		indexOnCircleRightHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-04-08"), indexOnCircleRightHandPitched.getSymbol());
		indexOnCircleRightHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-04-07"), indexOnCircleRightHandPitched.getSymbol());
		indexOnCircleRightHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-04-06"), indexOnCircleRightHandPitched.getSymbol());
		indexOnCircleRightHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-04-05"), indexOnCircleRightHandPitched.getSymbol());
		indexOnCircleRightHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-04-04"), indexOnCircleRightHandPitched.getSymbol());
		indexOnCircleRightHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-04-03"), indexOnCircleRightHandPitched.getSymbol());
		indexOnCircleRightHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-04-02"), indexOnCircleRightHandPitched.getSymbol());
		indexOnCircleRightHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-04-01"), indexOnCircleRightHandPitched.getSymbol());

		indexOnCircleLeftHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-04-10"), indexOnCircleLeftHandPitched.getSymbol());
		indexOnCircleLeftHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-04-11"), indexOnCircleLeftHandPitched.getSymbol());
		indexOnCircleLeftHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-04-12"), indexOnCircleLeftHandPitched.getSymbol());
		indexOnCircleLeftHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-04-13"), indexOnCircleLeftHandPitched.getSymbol());
		indexOnCircleLeftHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-04-14"), indexOnCircleLeftHandPitched.getSymbol());
		indexOnCircleLeftHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-04-15"), indexOnCircleLeftHandPitched.getSymbol());
		indexOnCircleLeftHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-04-16"), indexOnCircleLeftHandPitched.getSymbol());
		indexOnCircleLeftHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-04-09"), indexOnCircleLeftHandPitched.getSymbol());

		indexOnCircleRightHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-05-08"),
				indexOnCircleRightHandHalfTurnPitched.getSymbol());
		indexOnCircleRightHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-05-07"),
				indexOnCircleRightHandHalfTurnPitched.getSymbol());
		indexOnCircleRightHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-05-06"),
				indexOnCircleRightHandHalfTurnPitched.getSymbol());
		indexOnCircleRightHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-05-05"),
				indexOnCircleRightHandHalfTurnPitched.getSymbol());
		indexOnCircleRightHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-05-04"),
				indexOnCircleRightHandHalfTurnPitched.getSymbol());
		indexOnCircleRightHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-05-03"),
				indexOnCircleRightHandHalfTurnPitched.getSymbol());
		indexOnCircleRightHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-05-02"),
				indexOnCircleRightHandHalfTurnPitched.getSymbol());
		indexOnCircleRightHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-05-01"),
				indexOnCircleRightHandHalfTurnPitched.getSymbol());

		indexOnCircleLeftHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-05-10"),
				indexOnCircleLeftHandHalfTurnPitched.getSymbol());
		indexOnCircleLeftHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-05-11"),
				indexOnCircleLeftHandHalfTurnPitched.getSymbol());
		indexOnCircleLeftHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-05-12"),
				indexOnCircleLeftHandHalfTurnPitched.getSymbol());
		indexOnCircleLeftHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-05-13"),
				indexOnCircleLeftHandHalfTurnPitched.getSymbol());
		indexOnCircleLeftHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-05-14"),
				indexOnCircleLeftHandHalfTurnPitched.getSymbol());
		indexOnCircleLeftHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-05-15"),
				indexOnCircleLeftHandHalfTurnPitched.getSymbol());
		indexOnCircleLeftHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-05-16"),
				indexOnCircleLeftHandHalfTurnPitched.getSymbol());
		indexOnCircleLeftHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-05-09"),
				indexOnCircleLeftHandHalfTurnPitched.getSymbol());

		indexOnCircleRightHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-06-08"),
				indexOnCircleRightHandFullTurnPitched.getSymbol());
		indexOnCircleRightHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-06-07"),
				indexOnCircleRightHandFullTurnPitched.getSymbol());
		indexOnCircleRightHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-06-06"),
				indexOnCircleRightHandFullTurnPitched.getSymbol());
		indexOnCircleRightHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-06-05"),
				indexOnCircleRightHandFullTurnPitched.getSymbol());
		indexOnCircleRightHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-06-04"),
				indexOnCircleRightHandFullTurnPitched.getSymbol());
		indexOnCircleRightHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-06-03"),
				indexOnCircleRightHandFullTurnPitched.getSymbol());
		indexOnCircleRightHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-06-02"),
				indexOnCircleRightHandFullTurnPitched.getSymbol());
		indexOnCircleRightHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-06-01"),
				indexOnCircleRightHandFullTurnPitched.getSymbol());

		indexOnCircleLeftHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-06-10"),
				indexOnCircleLeftHandFullTurnPitched.getSymbol());
		indexOnCircleLeftHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-06-11"),
				indexOnCircleLeftHandFullTurnPitched.getSymbol());
		indexOnCircleLeftHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-06-12"),
				indexOnCircleLeftHandFullTurnPitched.getSymbol());
		indexOnCircleLeftHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-06-13"),
				indexOnCircleLeftHandFullTurnPitched.getSymbol());
		indexOnCircleLeftHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-06-14"),
				indexOnCircleLeftHandFullTurnPitched.getSymbol());
		indexOnCircleLeftHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-06-15"),
				indexOnCircleLeftHandFullTurnPitched.getSymbol());
		indexOnCircleLeftHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-06-16"),
				indexOnCircleLeftHandFullTurnPitched.getSymbol());
		indexOnCircleLeftHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-06-09"),
				indexOnCircleLeftHandFullTurnPitched.getSymbol());

		indexOnCupRightHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-01-08"), indexOnCupRightHand.getSymbol());
		indexOnCupRightHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-01-07"), indexOnCupRightHand.getSymbol());
		indexOnCupRightHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-01-06"), indexOnCupRightHand.getSymbol());
		indexOnCupRightHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-01-05"), indexOnCupRightHand.getSymbol());
		indexOnCupRightHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-01-04"), indexOnCupRightHand.getSymbol());
		indexOnCupRightHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-01-03"), indexOnCupRightHand.getSymbol());
		indexOnCupRightHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-01-02"), indexOnCupRightHand.getSymbol());
		indexOnCupRightHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-01-01"), indexOnCupRightHand.getSymbol());

		indexOnCupLeftHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-01-10"), indexOnCupLeftHand.getSymbol());
		indexOnCupLeftHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-01-11"), indexOnCupLeftHand.getSymbol());
		indexOnCupLeftHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-01-12"), indexOnCupLeftHand.getSymbol());
		indexOnCupLeftHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-01-13"), indexOnCupLeftHand.getSymbol());
		indexOnCupLeftHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-01-14"), indexOnCupLeftHand.getSymbol());
		indexOnCupLeftHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-01-15"), indexOnCupLeftHand.getSymbol());
		indexOnCupLeftHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-01-16"), indexOnCupLeftHand.getSymbol());
		indexOnCupLeftHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-01-09"), indexOnCupLeftHand.getSymbol());

		indexOnCupRightHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-02-08"), indexOnCupRightHandHalfTurn.getSymbol());
		indexOnCupRightHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-02-07"), indexOnCupRightHandHalfTurn.getSymbol());
		indexOnCupRightHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-02-06"), indexOnCupRightHandHalfTurn.getSymbol());
		indexOnCupRightHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-02-05"), indexOnCupRightHandHalfTurn.getSymbol());
		indexOnCupRightHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-02-04"), indexOnCupRightHandHalfTurn.getSymbol());
		indexOnCupRightHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-02-03"), indexOnCupRightHandHalfTurn.getSymbol());
		indexOnCupRightHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-02-02"), indexOnCupRightHandHalfTurn.getSymbol());
		indexOnCupRightHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-02-01"), indexOnCupRightHandHalfTurn.getSymbol());

		indexOnCupLeftHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-02-10"), indexOnCupLeftHandHalfTurn.getSymbol());
		indexOnCupLeftHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-02-11"), indexOnCupLeftHandHalfTurn.getSymbol());
		indexOnCupLeftHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-02-12"), indexOnCupLeftHandHalfTurn.getSymbol());
		indexOnCupLeftHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-02-13"), indexOnCupLeftHandHalfTurn.getSymbol());
		indexOnCupLeftHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-02-14"), indexOnCupLeftHandHalfTurn.getSymbol());
		indexOnCupLeftHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-02-15"), indexOnCupLeftHandHalfTurn.getSymbol());
		indexOnCupLeftHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-02-16"), indexOnCupLeftHandHalfTurn.getSymbol());
		indexOnCupLeftHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-02-09"), indexOnCupLeftHandHalfTurn.getSymbol());

		indexOnCupRightHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-03-08"), indexOnCupRightHandFullTurn.getSymbol());
		indexOnCupRightHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-03-07"), indexOnCupRightHandFullTurn.getSymbol());
		indexOnCupRightHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-03-06"), indexOnCupRightHandFullTurn.getSymbol());
		indexOnCupRightHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-03-05"), indexOnCupRightHandFullTurn.getSymbol());
		indexOnCupRightHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-03-04"), indexOnCupRightHandFullTurn.getSymbol());
		indexOnCupRightHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-03-03"), indexOnCupRightHandFullTurn.getSymbol());
		indexOnCupRightHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-03-02"), indexOnCupRightHandFullTurn.getSymbol());
		indexOnCupRightHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-03-01"), indexOnCupRightHandFullTurn.getSymbol());

		indexOnCupLeftHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-03-10"), indexOnCupLeftHandFullTurn.getSymbol());
		indexOnCupLeftHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-03-11"), indexOnCupLeftHandFullTurn.getSymbol());
		indexOnCupLeftHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-03-12"), indexOnCupLeftHandFullTurn.getSymbol());
		indexOnCupLeftHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-03-13"), indexOnCupLeftHandFullTurn.getSymbol());
		indexOnCupLeftHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-03-14"), indexOnCupLeftHandFullTurn.getSymbol());
		indexOnCupLeftHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-03-15"), indexOnCupLeftHandFullTurn.getSymbol());
		indexOnCupLeftHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-03-16"), indexOnCupLeftHandFullTurn.getSymbol());
		indexOnCupLeftHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-03-09"), indexOnCupLeftHandFullTurn.getSymbol());

		indexOnCupRightHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-04-08"), indexOnCupRightHandPitched.getSymbol());
		indexOnCupRightHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-04-07"), indexOnCupRightHandPitched.getSymbol());
		indexOnCupRightHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-04-06"), indexOnCupRightHandPitched.getSymbol());
		indexOnCupRightHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-04-05"), indexOnCupRightHandPitched.getSymbol());
		indexOnCupRightHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-04-04"), indexOnCupRightHandPitched.getSymbol());
		indexOnCupRightHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-04-03"), indexOnCupRightHandPitched.getSymbol());
		indexOnCupRightHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-04-02"), indexOnCupRightHandPitched.getSymbol());
		indexOnCupRightHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-04-01"), indexOnCupRightHandPitched.getSymbol());

		indexOnCupLeftHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-04-10"), indexOnCupLeftHandPitched.getSymbol());
		indexOnCupLeftHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-04-11"), indexOnCupLeftHandPitched.getSymbol());
		indexOnCupLeftHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-04-12"), indexOnCupLeftHandPitched.getSymbol());
		indexOnCupLeftHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-04-13"), indexOnCupLeftHandPitched.getSymbol());
		indexOnCupLeftHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-04-14"), indexOnCupLeftHandPitched.getSymbol());
		indexOnCupLeftHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-04-15"), indexOnCupLeftHandPitched.getSymbol());
		indexOnCupLeftHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-04-16"), indexOnCupLeftHandPitched.getSymbol());
		indexOnCupLeftHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-04-09"), indexOnCupLeftHandPitched.getSymbol());

		indexOnCupRightHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-05-08"), indexOnCupRightHandHalfTurnPitched.getSymbol());
		indexOnCupRightHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-05-07"), indexOnCupRightHandHalfTurnPitched.getSymbol());
		indexOnCupRightHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-05-06"), indexOnCupRightHandHalfTurnPitched.getSymbol());
		indexOnCupRightHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-05-05"), indexOnCupRightHandHalfTurnPitched.getSymbol());
		indexOnCupRightHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-05-04"), indexOnCupRightHandHalfTurnPitched.getSymbol());
		indexOnCupRightHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-05-03"), indexOnCupRightHandHalfTurnPitched.getSymbol());
		indexOnCupRightHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-05-02"), indexOnCupRightHandHalfTurnPitched.getSymbol());
		indexOnCupRightHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-05-01"), indexOnCupRightHandHalfTurnPitched.getSymbol());

		indexOnCupLeftHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-05-10"), indexOnCupLeftHandHalfTurnPitched.getSymbol());
		indexOnCupLeftHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-05-11"), indexOnCupLeftHandHalfTurnPitched.getSymbol());
		indexOnCupLeftHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-05-12"), indexOnCupLeftHandHalfTurnPitched.getSymbol());
		indexOnCupLeftHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-05-13"), indexOnCupLeftHandHalfTurnPitched.getSymbol());
		indexOnCupLeftHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-05-14"), indexOnCupLeftHandHalfTurnPitched.getSymbol());
		indexOnCupLeftHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-05-15"), indexOnCupLeftHandHalfTurnPitched.getSymbol());
		indexOnCupLeftHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-05-16"), indexOnCupLeftHandHalfTurnPitched.getSymbol());
		indexOnCupLeftHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-05-09"), indexOnCupLeftHandHalfTurnPitched.getSymbol());

		indexOnCupRightHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-06-08"), indexOnCupRightHandFullTurnPitched.getSymbol());
		indexOnCupRightHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-06-07"), indexOnCupRightHandFullTurnPitched.getSymbol());
		indexOnCupRightHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-06-06"), indexOnCupRightHandFullTurnPitched.getSymbol());
		indexOnCupRightHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-06-05"), indexOnCupRightHandFullTurnPitched.getSymbol());
		indexOnCupRightHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-06-04"), indexOnCupRightHandFullTurnPitched.getSymbol());
		indexOnCupRightHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-06-03"), indexOnCupRightHandFullTurnPitched.getSymbol());
		indexOnCupRightHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-06-02"), indexOnCupRightHandFullTurnPitched.getSymbol());
		indexOnCupRightHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-06-01"), indexOnCupRightHandFullTurnPitched.getSymbol());

		indexOnCupLeftHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-06-10"), indexOnCupLeftHandFullTurnPitched.getSymbol());
		indexOnCupLeftHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-06-11"), indexOnCupLeftHandFullTurnPitched.getSymbol());
		indexOnCupLeftHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-06-12"), indexOnCupLeftHandFullTurnPitched.getSymbol());
		indexOnCupLeftHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-06-13"), indexOnCupLeftHandFullTurnPitched.getSymbol());
		indexOnCupLeftHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-06-14"), indexOnCupLeftHandFullTurnPitched.getSymbol());
		indexOnCupLeftHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-06-15"), indexOnCupLeftHandFullTurnPitched.getSymbol());
		indexOnCupLeftHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-06-16"), indexOnCupLeftHandFullTurnPitched.getSymbol());
		indexOnCupLeftHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-06-09"), indexOnCupLeftHandFullTurnPitched.getSymbol());

		indexOnOvalRightHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-01-08"), indexOnOvalRightHand.getSymbol());
		indexOnOvalRightHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-01-07"), indexOnOvalRightHand.getSymbol());
		indexOnOvalRightHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-01-06"), indexOnOvalRightHand.getSymbol());
		indexOnOvalRightHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-01-05"), indexOnOvalRightHand.getSymbol());
		indexOnOvalRightHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-01-04"), indexOnOvalRightHand.getSymbol());
		indexOnOvalRightHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-01-03"), indexOnOvalRightHand.getSymbol());
		indexOnOvalRightHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-01-02"), indexOnOvalRightHand.getSymbol());
		indexOnOvalRightHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-01-01"), indexOnOvalRightHand.getSymbol());

		indexOnOvalLeftHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-01-10"), indexOnOvalLeftHand.getSymbol());
		indexOnOvalLeftHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-01-11"), indexOnOvalLeftHand.getSymbol());
		indexOnOvalLeftHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-01-12"), indexOnOvalLeftHand.getSymbol());
		indexOnOvalLeftHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-01-13"), indexOnOvalLeftHand.getSymbol());
		indexOnOvalLeftHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-01-14"), indexOnOvalLeftHand.getSymbol());
		indexOnOvalLeftHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-01-15"), indexOnOvalLeftHand.getSymbol());
		indexOnOvalLeftHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-01-16"), indexOnOvalLeftHand.getSymbol());
		indexOnOvalLeftHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-01-09"), indexOnOvalLeftHand.getSymbol());

		indexOnOvalRightHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-02-08"), indexOnOvalRightHandHalfTurn.getSymbol());
		indexOnOvalRightHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-02-07"), indexOnOvalRightHandHalfTurn.getSymbol());
		indexOnOvalRightHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-02-06"), indexOnOvalRightHandHalfTurn.getSymbol());
		indexOnOvalRightHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-02-05"), indexOnOvalRightHandHalfTurn.getSymbol());
		indexOnOvalRightHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-02-04"), indexOnOvalRightHandHalfTurn.getSymbol());
		indexOnOvalRightHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-02-03"), indexOnOvalRightHandHalfTurn.getSymbol());
		indexOnOvalRightHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-02-02"), indexOnOvalRightHandHalfTurn.getSymbol());
		indexOnOvalRightHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-02-01"), indexOnOvalRightHandHalfTurn.getSymbol());

		indexOnOvalLeftHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-02-10"), indexOnOvalLeftHandHalfTurn.getSymbol());
		indexOnOvalLeftHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-02-11"), indexOnOvalLeftHandHalfTurn.getSymbol());
		indexOnOvalLeftHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-02-12"), indexOnOvalLeftHandHalfTurn.getSymbol());
		indexOnOvalLeftHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-02-13"), indexOnOvalLeftHandHalfTurn.getSymbol());
		indexOnOvalLeftHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-02-14"), indexOnOvalLeftHandHalfTurn.getSymbol());
		indexOnOvalLeftHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-02-15"), indexOnOvalLeftHandHalfTurn.getSymbol());
		indexOnOvalLeftHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-02-16"), indexOnOvalLeftHandHalfTurn.getSymbol());
		indexOnOvalLeftHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-02-09"), indexOnOvalLeftHandHalfTurn.getSymbol());

		indexOnOvalRightHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-03-08"), indexOnOvalRightHandFullTurn.getSymbol());
		indexOnOvalRightHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-03-07"), indexOnOvalRightHandFullTurn.getSymbol());
		indexOnOvalRightHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-03-06"), indexOnOvalRightHandFullTurn.getSymbol());
		indexOnOvalRightHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-03-05"), indexOnOvalRightHandFullTurn.getSymbol());
		indexOnOvalRightHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-03-04"), indexOnOvalRightHandFullTurn.getSymbol());
		indexOnOvalRightHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-03-03"), indexOnOvalRightHandFullTurn.getSymbol());
		indexOnOvalRightHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-03-02"), indexOnOvalRightHandFullTurn.getSymbol());
		indexOnOvalRightHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-03-01"), indexOnOvalRightHandFullTurn.getSymbol());

		indexOnOvalLeftHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-03-10"), indexOnOvalLeftHandFullTurn.getSymbol());
		indexOnOvalLeftHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-03-11"), indexOnOvalLeftHandFullTurn.getSymbol());
		indexOnOvalLeftHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-03-12"), indexOnOvalLeftHandFullTurn.getSymbol());
		indexOnOvalLeftHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-03-13"), indexOnOvalLeftHandFullTurn.getSymbol());
		indexOnOvalLeftHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-03-14"), indexOnOvalLeftHandFullTurn.getSymbol());
		indexOnOvalLeftHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-03-15"), indexOnOvalLeftHandFullTurn.getSymbol());
		indexOnOvalLeftHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-03-16"), indexOnOvalLeftHandFullTurn.getSymbol());
		indexOnOvalLeftHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-03-09"), indexOnOvalLeftHandFullTurn.getSymbol());

		indexOnOvalRightHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-04-08"), indexOnOvalRightHandPitched.getSymbol());
		indexOnOvalRightHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-04-07"), indexOnOvalRightHandPitched.getSymbol());
		indexOnOvalRightHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-04-06"), indexOnOvalRightHandPitched.getSymbol());
		indexOnOvalRightHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-04-05"), indexOnOvalRightHandPitched.getSymbol());
		indexOnOvalRightHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-04-04"), indexOnOvalRightHandPitched.getSymbol());
		indexOnOvalRightHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-04-03"), indexOnOvalRightHandPitched.getSymbol());
		indexOnOvalRightHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-04-02"), indexOnOvalRightHandPitched.getSymbol());
		indexOnOvalRightHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-04-01"), indexOnOvalRightHandPitched.getSymbol());

		indexOnOvalLeftHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-04-10"), indexOnOvalLeftHandPitched.getSymbol());
		indexOnOvalLeftHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-04-11"), indexOnOvalLeftHandPitched.getSymbol());
		indexOnOvalLeftHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-04-12"), indexOnOvalLeftHandPitched.getSymbol());
		indexOnOvalLeftHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-04-13"), indexOnOvalLeftHandPitched.getSymbol());
		indexOnOvalLeftHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-04-14"), indexOnOvalLeftHandPitched.getSymbol());
		indexOnOvalLeftHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-04-15"), indexOnOvalLeftHandPitched.getSymbol());
		indexOnOvalLeftHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-04-16"), indexOnOvalLeftHandPitched.getSymbol());
		indexOnOvalLeftHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-04-09"), indexOnOvalLeftHandPitched.getSymbol());

		indexOnOvalRightHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-05-08"), indexOnOvalRightHandHalfTurnPitched.getSymbol());
		indexOnOvalRightHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-05-07"), indexOnOvalRightHandHalfTurnPitched.getSymbol());
		indexOnOvalRightHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-05-06"), indexOnOvalRightHandHalfTurnPitched.getSymbol());
		indexOnOvalRightHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-05-05"), indexOnOvalRightHandHalfTurnPitched.getSymbol());
		indexOnOvalRightHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-05-04"), indexOnOvalRightHandHalfTurnPitched.getSymbol());
		indexOnOvalRightHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-05-03"), indexOnOvalRightHandHalfTurnPitched.getSymbol());
		indexOnOvalRightHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-05-02"), indexOnOvalRightHandHalfTurnPitched.getSymbol());
		indexOnOvalRightHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-05-01"), indexOnOvalRightHandHalfTurnPitched.getSymbol());

		indexOnOvalLeftHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-05-10"), indexOnOvalLeftHandHalfTurnPitched.getSymbol());
		indexOnOvalLeftHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-05-11"), indexOnOvalLeftHandHalfTurnPitched.getSymbol());
		indexOnOvalLeftHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-05-12"), indexOnOvalLeftHandHalfTurnPitched.getSymbol());
		indexOnOvalLeftHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-05-13"), indexOnOvalLeftHandHalfTurnPitched.getSymbol());
		indexOnOvalLeftHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-05-14"), indexOnOvalLeftHandHalfTurnPitched.getSymbol());
		indexOnOvalLeftHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-05-15"), indexOnOvalLeftHandHalfTurnPitched.getSymbol());
		indexOnOvalLeftHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-05-16"), indexOnOvalLeftHandHalfTurnPitched.getSymbol());
		indexOnOvalLeftHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-05-09"), indexOnOvalLeftHandHalfTurnPitched.getSymbol());

		indexOnOvalRightHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-06-08"), indexOnOvalRightHandFullTurnPitched.getSymbol());
		indexOnOvalRightHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-06-07"), indexOnOvalRightHandFullTurnPitched.getSymbol());
		indexOnOvalRightHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-06-06"), indexOnOvalRightHandFullTurnPitched.getSymbol());
		indexOnOvalRightHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-06-05"), indexOnOvalRightHandFullTurnPitched.getSymbol());
		indexOnOvalRightHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-06-04"), indexOnOvalRightHandFullTurnPitched.getSymbol());
		indexOnOvalRightHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-06-03"), indexOnOvalRightHandFullTurnPitched.getSymbol());
		indexOnOvalRightHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-06-02"), indexOnOvalRightHandFullTurnPitched.getSymbol());
		indexOnOvalRightHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-06-01"), indexOnOvalRightHandFullTurnPitched.getSymbol());

		indexOnOvalLeftHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-06-10"), indexOnOvalLeftHandFullTurnPitched.getSymbol());
		indexOnOvalLeftHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-06-11"), indexOnOvalLeftHandFullTurnPitched.getSymbol());
		indexOnOvalLeftHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-06-12"), indexOnOvalLeftHandFullTurnPitched.getSymbol());
		indexOnOvalLeftHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-06-13"), indexOnOvalLeftHandFullTurnPitched.getSymbol());
		indexOnOvalLeftHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-06-14"), indexOnOvalLeftHandFullTurnPitched.getSymbol());
		indexOnOvalLeftHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-06-15"), indexOnOvalLeftHandFullTurnPitched.getSymbol());
		indexOnOvalLeftHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-06-16"), indexOnOvalLeftHandFullTurnPitched.getSymbol());
		indexOnOvalLeftHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-06-09"), indexOnOvalLeftHandFullTurnPitched.getSymbol());

		indexOnHingeRightHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-01-08"), indexOnHingeRightHand.getSymbol());
		indexOnHingeRightHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-01-07"), indexOnHingeRightHand.getSymbol());
		indexOnHingeRightHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-01-06"), indexOnHingeRightHand.getSymbol());
		indexOnHingeRightHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-01-05"), indexOnHingeRightHand.getSymbol());
		indexOnHingeRightHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-01-04"), indexOnHingeRightHand.getSymbol());
		indexOnHingeRightHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-01-03"), indexOnHingeRightHand.getSymbol());
		indexOnHingeRightHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-01-02"), indexOnHingeRightHand.getSymbol());
		indexOnHingeRightHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-01-01"), indexOnHingeRightHand.getSymbol());

		indexOnHingeLeftHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-01-10"), indexOnHingeLeftHand.getSymbol());
		indexOnHingeLeftHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-01-11"), indexOnHingeLeftHand.getSymbol());
		indexOnHingeLeftHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-01-12"), indexOnHingeLeftHand.getSymbol());
		indexOnHingeLeftHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-01-13"), indexOnHingeLeftHand.getSymbol());
		indexOnHingeLeftHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-01-14"), indexOnHingeLeftHand.getSymbol());
		indexOnHingeLeftHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-01-15"), indexOnHingeLeftHand.getSymbol());
		indexOnHingeLeftHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-01-16"), indexOnHingeLeftHand.getSymbol());
		indexOnHingeLeftHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-01-09"), indexOnHingeLeftHand.getSymbol());

		indexOnHingeRightHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-02-08"), indexOnHingeRightHandHalfTurn.getSymbol());
		indexOnHingeRightHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-02-07"), indexOnHingeRightHandHalfTurn.getSymbol());
		indexOnHingeRightHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-02-06"), indexOnHingeRightHandHalfTurn.getSymbol());
		indexOnHingeRightHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-02-05"), indexOnHingeRightHandHalfTurn.getSymbol());
		indexOnHingeRightHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-02-04"), indexOnHingeRightHandHalfTurn.getSymbol());
		indexOnHingeRightHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-02-03"), indexOnHingeRightHandHalfTurn.getSymbol());
		indexOnHingeRightHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-02-02"), indexOnHingeRightHandHalfTurn.getSymbol());
		indexOnHingeRightHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-02-01"), indexOnHingeRightHandHalfTurn.getSymbol());

		indexOnHingeLeftHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-02-10"), indexOnHingeLeftHandHalfTurn.getSymbol());
		indexOnHingeLeftHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-02-11"), indexOnHingeLeftHandHalfTurn.getSymbol());
		indexOnHingeLeftHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-02-12"), indexOnHingeLeftHandHalfTurn.getSymbol());
		indexOnHingeLeftHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-02-13"), indexOnHingeLeftHandHalfTurn.getSymbol());
		indexOnHingeLeftHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-02-14"), indexOnHingeLeftHandHalfTurn.getSymbol());
		indexOnHingeLeftHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-02-15"), indexOnHingeLeftHandHalfTurn.getSymbol());
		indexOnHingeLeftHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-02-16"), indexOnHingeLeftHandHalfTurn.getSymbol());
		indexOnHingeLeftHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-02-09"), indexOnHingeLeftHandHalfTurn.getSymbol());

		indexOnHingeRightHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-03-08"), indexOnHingeRightHandFullTurn.getSymbol());
		indexOnHingeRightHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-03-07"), indexOnHingeRightHandFullTurn.getSymbol());
		indexOnHingeRightHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-03-06"), indexOnHingeRightHandFullTurn.getSymbol());
		indexOnHingeRightHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-03-05"), indexOnHingeRightHandFullTurn.getSymbol());
		indexOnHingeRightHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-03-04"), indexOnHingeRightHandFullTurn.getSymbol());
		indexOnHingeRightHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-03-03"), indexOnHingeRightHandFullTurn.getSymbol());
		indexOnHingeRightHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-03-02"), indexOnHingeRightHandFullTurn.getSymbol());
		indexOnHingeRightHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-03-01"), indexOnHingeRightHandFullTurn.getSymbol());

		indexOnHingeLeftHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-03-10"), indexOnHingeLeftHandFullTurn.getSymbol());
		indexOnHingeLeftHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-03-11"), indexOnHingeLeftHandFullTurn.getSymbol());
		indexOnHingeLeftHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-03-12"), indexOnHingeLeftHandFullTurn.getSymbol());
		indexOnHingeLeftHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-03-13"), indexOnHingeLeftHandFullTurn.getSymbol());
		indexOnHingeLeftHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-03-14"), indexOnHingeLeftHandFullTurn.getSymbol());
		indexOnHingeLeftHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-03-15"), indexOnHingeLeftHandFullTurn.getSymbol());
		indexOnHingeLeftHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-03-16"), indexOnHingeLeftHandFullTurn.getSymbol());
		indexOnHingeLeftHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-03-09"), indexOnHingeLeftHandFullTurn.getSymbol());

		indexOnHingeRightHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-04-08"), indexOnHingeRightHandPitched.getSymbol());
		indexOnHingeRightHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-04-07"), indexOnHingeRightHandPitched.getSymbol());
		indexOnHingeRightHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-04-06"), indexOnHingeRightHandPitched.getSymbol());
		indexOnHingeRightHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-04-05"), indexOnHingeRightHandPitched.getSymbol());
		indexOnHingeRightHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-04-04"), indexOnHingeRightHandPitched.getSymbol());
		indexOnHingeRightHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-04-03"), indexOnHingeRightHandPitched.getSymbol());
		indexOnHingeRightHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-04-02"), indexOnHingeRightHandPitched.getSymbol());
		indexOnHingeRightHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-04-01"), indexOnHingeRightHandPitched.getSymbol());

		indexOnHingeLeftHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-04-10"), indexOnHingeLeftHandPitched.getSymbol());
		indexOnHingeLeftHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-04-11"), indexOnHingeLeftHandPitched.getSymbol());
		indexOnHingeLeftHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-04-12"), indexOnHingeLeftHandPitched.getSymbol());
		indexOnHingeLeftHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-04-13"), indexOnHingeLeftHandPitched.getSymbol());
		indexOnHingeLeftHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-04-14"), indexOnHingeLeftHandPitched.getSymbol());
		indexOnHingeLeftHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-04-15"), indexOnHingeLeftHandPitched.getSymbol());
		indexOnHingeLeftHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-04-16"), indexOnHingeLeftHandPitched.getSymbol());
		indexOnHingeLeftHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-04-09"), indexOnHingeLeftHandPitched.getSymbol());

		indexOnHingeRightHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-05-08"),
				indexOnHingeRightHandHalfTurnPitched.getSymbol());
		indexOnHingeRightHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-05-07"),
				indexOnHingeRightHandHalfTurnPitched.getSymbol());
		indexOnHingeRightHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-05-06"),
				indexOnHingeRightHandHalfTurnPitched.getSymbol());
		indexOnHingeRightHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-05-05"),
				indexOnHingeRightHandHalfTurnPitched.getSymbol());
		indexOnHingeRightHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-05-04"),
				indexOnHingeRightHandHalfTurnPitched.getSymbol());
		indexOnHingeRightHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-05-03"),
				indexOnHingeRightHandHalfTurnPitched.getSymbol());
		indexOnHingeRightHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-05-02"),
				indexOnHingeRightHandHalfTurnPitched.getSymbol());
		indexOnHingeRightHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-05-01"),
				indexOnHingeRightHandHalfTurnPitched.getSymbol());

		indexOnHingeLeftHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-05-10"), indexOnHingeLeftHandHalfTurnPitched.getSymbol());
		indexOnHingeLeftHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-05-11"), indexOnHingeLeftHandHalfTurnPitched.getSymbol());
		indexOnHingeLeftHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-05-12"), indexOnHingeLeftHandHalfTurnPitched.getSymbol());
		indexOnHingeLeftHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-05-13"), indexOnHingeLeftHandHalfTurnPitched.getSymbol());
		indexOnHingeLeftHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-05-14"), indexOnHingeLeftHandHalfTurnPitched.getSymbol());
		indexOnHingeLeftHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-05-15"), indexOnHingeLeftHandHalfTurnPitched.getSymbol());
		indexOnHingeLeftHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-05-16"), indexOnHingeLeftHandHalfTurnPitched.getSymbol());
		indexOnHingeLeftHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-05-09"), indexOnHingeLeftHandHalfTurnPitched.getSymbol());

		indexOnHingeRightHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-06-08"),
				indexOnHingeRightHandFullTurnPitched.getSymbol());
		indexOnHingeRightHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-06-07"),
				indexOnHingeRightHandFullTurnPitched.getSymbol());
		indexOnHingeRightHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-06-06"),
				indexOnHingeRightHandFullTurnPitched.getSymbol());
		indexOnHingeRightHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-06-05"),
				indexOnHingeRightHandFullTurnPitched.getSymbol());
		indexOnHingeRightHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-06-04"),
				indexOnHingeRightHandFullTurnPitched.getSymbol());
		indexOnHingeRightHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-06-03"),
				indexOnHingeRightHandFullTurnPitched.getSymbol());
		indexOnHingeRightHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-06-02"),
				indexOnHingeRightHandFullTurnPitched.getSymbol());
		indexOnHingeRightHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-06-01"),
				indexOnHingeRightHandFullTurnPitched.getSymbol());

		indexOnHingeLeftHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-06-10"), indexOnHingeLeftHandFullTurnPitched.getSymbol());
		indexOnHingeLeftHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-06-11"), indexOnHingeLeftHandFullTurnPitched.getSymbol());
		indexOnHingeLeftHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-06-12"), indexOnHingeLeftHandFullTurnPitched.getSymbol());
		indexOnHingeLeftHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-06-13"), indexOnHingeLeftHandFullTurnPitched.getSymbol());
		indexOnHingeLeftHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-06-14"), indexOnHingeLeftHandFullTurnPitched.getSymbol());
		indexOnHingeLeftHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-06-15"), indexOnHingeLeftHandFullTurnPitched.getSymbol());
		indexOnHingeLeftHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-06-16"), indexOnHingeLeftHandFullTurnPitched.getSymbol());
		indexOnHingeLeftHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-06-09"), indexOnHingeLeftHandFullTurnPitched.getSymbol());

		indexOnAngleRightHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-01-08"), indexOnAngleRightHand.getSymbol());
		indexOnAngleRightHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-01-07"), indexOnAngleRightHand.getSymbol());
		indexOnAngleRightHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-01-06"), indexOnAngleRightHand.getSymbol());
		indexOnAngleRightHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-01-05"), indexOnAngleRightHand.getSymbol());
		indexOnAngleRightHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-01-04"), indexOnAngleRightHand.getSymbol());
		indexOnAngleRightHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-01-03"), indexOnAngleRightHand.getSymbol());
		indexOnAngleRightHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-01-02"), indexOnAngleRightHand.getSymbol());
		indexOnAngleRightHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-01-01"), indexOnAngleRightHand.getSymbol());

		indexOnAngleLeftHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-01-10"), indexOnAngleLeftHand.getSymbol());
		indexOnAngleLeftHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-01-11"), indexOnAngleLeftHand.getSymbol());
		indexOnAngleLeftHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-01-12"), indexOnAngleLeftHand.getSymbol());
		indexOnAngleLeftHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-01-13"), indexOnAngleLeftHand.getSymbol());
		indexOnAngleLeftHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-01-14"), indexOnAngleLeftHand.getSymbol());
		indexOnAngleLeftHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-01-15"), indexOnAngleLeftHand.getSymbol());
		indexOnAngleLeftHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-01-16"), indexOnAngleLeftHand.getSymbol());
		indexOnAngleLeftHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-01-09"), indexOnAngleLeftHand.getSymbol());

		indexOnAngleRightHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-02-08"), indexOnAngleRightHandHalfTurn.getSymbol());
		indexOnAngleRightHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-02-07"), indexOnAngleRightHandHalfTurn.getSymbol());
		indexOnAngleRightHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-02-06"), indexOnAngleRightHandHalfTurn.getSymbol());
		indexOnAngleRightHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-02-05"), indexOnAngleRightHandHalfTurn.getSymbol());
		indexOnAngleRightHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-02-04"), indexOnAngleRightHandHalfTurn.getSymbol());
		indexOnAngleRightHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-02-03"), indexOnAngleRightHandHalfTurn.getSymbol());
		indexOnAngleRightHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-02-02"), indexOnAngleRightHandHalfTurn.getSymbol());
		indexOnAngleRightHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-02-01"), indexOnAngleRightHandHalfTurn.getSymbol());

		indexOnAngleLeftHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-02-10"), indexOnAngleLeftHandHalfTurn.getSymbol());
		indexOnAngleLeftHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-02-11"), indexOnAngleLeftHandHalfTurn.getSymbol());
		indexOnAngleLeftHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-02-12"), indexOnAngleLeftHandHalfTurn.getSymbol());
		indexOnAngleLeftHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-02-13"), indexOnAngleLeftHandHalfTurn.getSymbol());
		indexOnAngleLeftHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-02-14"), indexOnAngleLeftHandHalfTurn.getSymbol());
		indexOnAngleLeftHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-02-15"), indexOnAngleLeftHandHalfTurn.getSymbol());
		indexOnAngleLeftHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-02-16"), indexOnAngleLeftHandHalfTurn.getSymbol());
		indexOnAngleLeftHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-02-09"), indexOnAngleLeftHandHalfTurn.getSymbol());

		indexOnAngleRightHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-03-08"), indexOnAngleRightHandFullTurn.getSymbol());
		indexOnAngleRightHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-03-07"), indexOnAngleRightHandFullTurn.getSymbol());
		indexOnAngleRightHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-03-06"), indexOnAngleRightHandFullTurn.getSymbol());
		indexOnAngleRightHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-03-05"), indexOnAngleRightHandFullTurn.getSymbol());
		indexOnAngleRightHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-03-04"), indexOnAngleRightHandFullTurn.getSymbol());
		indexOnAngleRightHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-03-03"), indexOnAngleRightHandFullTurn.getSymbol());
		indexOnAngleRightHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-03-02"), indexOnAngleRightHandFullTurn.getSymbol());
		indexOnAngleRightHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-03-01"), indexOnAngleRightHandFullTurn.getSymbol());

		indexOnAngleLeftHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-03-10"), indexOnAngleLeftHandFullTurn.getSymbol());
		indexOnAngleLeftHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-03-11"), indexOnAngleLeftHandFullTurn.getSymbol());
		indexOnAngleLeftHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-03-12"), indexOnAngleLeftHandFullTurn.getSymbol());
		indexOnAngleLeftHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-03-13"), indexOnAngleLeftHandFullTurn.getSymbol());
		indexOnAngleLeftHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-03-14"), indexOnAngleLeftHandFullTurn.getSymbol());
		indexOnAngleLeftHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-03-15"), indexOnAngleLeftHandFullTurn.getSymbol());
		indexOnAngleLeftHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-03-16"), indexOnAngleLeftHandFullTurn.getSymbol());
		indexOnAngleLeftHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-03-09"), indexOnAngleLeftHandFullTurn.getSymbol());

		indexOnAngleRightHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-04-08"), indexOnAngleRightHandPitched.getSymbol());
		indexOnAngleRightHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-04-07"), indexOnAngleRightHandPitched.getSymbol());
		indexOnAngleRightHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-04-06"), indexOnAngleRightHandPitched.getSymbol());
		indexOnAngleRightHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-04-05"), indexOnAngleRightHandPitched.getSymbol());
		indexOnAngleRightHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-04-04"), indexOnAngleRightHandPitched.getSymbol());
		indexOnAngleRightHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-04-03"), indexOnAngleRightHandPitched.getSymbol());
		indexOnAngleRightHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-04-02"), indexOnAngleRightHandPitched.getSymbol());
		indexOnAngleRightHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-04-01"), indexOnAngleRightHandPitched.getSymbol());

		indexOnAngleLeftHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-04-10"), indexOnAngleLeftHandPitched.getSymbol());
		indexOnAngleLeftHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-04-11"), indexOnAngleLeftHandPitched.getSymbol());
		indexOnAngleLeftHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-04-12"), indexOnAngleLeftHandPitched.getSymbol());
		indexOnAngleLeftHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-04-13"), indexOnAngleLeftHandPitched.getSymbol());
		indexOnAngleLeftHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-04-14"), indexOnAngleLeftHandPitched.getSymbol());
		indexOnAngleLeftHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-04-15"), indexOnAngleLeftHandPitched.getSymbol());
		indexOnAngleLeftHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-04-16"), indexOnAngleLeftHandPitched.getSymbol());
		indexOnAngleLeftHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-04-09"), indexOnAngleLeftHandPitched.getSymbol());

		indexOnAngleRightHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-05-08"),
				indexOnAngleRightHandHalfTurnPitched.getSymbol());
		indexOnAngleRightHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-05-07"),
				indexOnAngleRightHandHalfTurnPitched.getSymbol());
		indexOnAngleRightHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-05-06"),
				indexOnAngleRightHandHalfTurnPitched.getSymbol());
		indexOnAngleRightHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-05-05"),
				indexOnAngleRightHandHalfTurnPitched.getSymbol());
		indexOnAngleRightHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-05-04"),
				indexOnAngleRightHandHalfTurnPitched.getSymbol());
		indexOnAngleRightHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-05-03"),
				indexOnAngleRightHandHalfTurnPitched.getSymbol());
		indexOnAngleRightHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-05-02"),
				indexOnAngleRightHandHalfTurnPitched.getSymbol());
		indexOnAngleRightHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-05-01"),
				indexOnAngleRightHandHalfTurnPitched.getSymbol());

		indexOnAngleLeftHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-05-10"), indexOnAngleLeftHandHalfTurnPitched.getSymbol());
		indexOnAngleLeftHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-05-11"), indexOnAngleLeftHandHalfTurnPitched.getSymbol());
		indexOnAngleLeftHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-05-12"), indexOnAngleLeftHandHalfTurnPitched.getSymbol());
		indexOnAngleLeftHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-05-13"), indexOnAngleLeftHandHalfTurnPitched.getSymbol());
		indexOnAngleLeftHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-05-14"), indexOnAngleLeftHandHalfTurnPitched.getSymbol());
		indexOnAngleLeftHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-05-15"), indexOnAngleLeftHandHalfTurnPitched.getSymbol());
		indexOnAngleLeftHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-05-16"), indexOnAngleLeftHandHalfTurnPitched.getSymbol());
		indexOnAngleLeftHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-05-09"), indexOnAngleLeftHandHalfTurnPitched.getSymbol());

		indexOnAngleRightHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-06-08"),
				indexOnAngleRightHandFullTurnPitched.getSymbol());
		indexOnAngleRightHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-06-07"),
				indexOnAngleRightHandFullTurnPitched.getSymbol());
		indexOnAngleRightHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-06-06"),
				indexOnAngleRightHandFullTurnPitched.getSymbol());
		indexOnAngleRightHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-06-05"),
				indexOnAngleRightHandFullTurnPitched.getSymbol());
		indexOnAngleRightHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-06-04"),
				indexOnAngleRightHandFullTurnPitched.getSymbol());
		indexOnAngleRightHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-06-03"),
				indexOnAngleRightHandFullTurnPitched.getSymbol());
		indexOnAngleRightHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-06-02"),
				indexOnAngleRightHandFullTurnPitched.getSymbol());
		indexOnAngleRightHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-06-01"),
				indexOnAngleRightHandFullTurnPitched.getSymbol());

		indexOnAngleLeftHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-06-10"), indexOnAngleLeftHandFullTurnPitched.getSymbol());
		indexOnAngleLeftHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-06-11"), indexOnAngleLeftHandFullTurnPitched.getSymbol());
		indexOnAngleLeftHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-06-12"), indexOnAngleLeftHandFullTurnPitched.getSymbol());
		indexOnAngleLeftHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-06-13"), indexOnAngleLeftHandFullTurnPitched.getSymbol());
		indexOnAngleLeftHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-06-14"), indexOnAngleLeftHandFullTurnPitched.getSymbol());
		indexOnAngleLeftHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-06-15"), indexOnAngleLeftHandFullTurnPitched.getSymbol());
		indexOnAngleLeftHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-06-16"), indexOnAngleLeftHandFullTurnPitched.getSymbol());
		indexOnAngleLeftHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-06-09"), indexOnAngleLeftHandFullTurnPitched.getSymbol());

		indexBentRightHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-01-08"), indexBentRightHand.getSymbol());
		indexBentRightHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-01-07"), indexBentRightHand.getSymbol());
		indexBentRightHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-01-06"), indexBentRightHand.getSymbol());
		indexBentRightHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-01-05"), indexBentRightHand.getSymbol());
		indexBentRightHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-01-04"), indexBentRightHand.getSymbol());
		indexBentRightHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-01-03"), indexBentRightHand.getSymbol());
		indexBentRightHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-01-02"), indexBentRightHand.getSymbol());
		indexBentRightHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-01-01"), indexBentRightHand.getSymbol());

		indexBentLeftHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-01-10"), indexBentLeftHand.getSymbol());
		indexBentLeftHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-01-11"), indexBentLeftHand.getSymbol());
		indexBentLeftHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-01-12"), indexBentLeftHand.getSymbol());
		indexBentLeftHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-01-13"), indexBentLeftHand.getSymbol());
		indexBentLeftHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-01-14"), indexBentLeftHand.getSymbol());
		indexBentLeftHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-01-15"), indexBentLeftHand.getSymbol());
		indexBentLeftHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-01-16"), indexBentLeftHand.getSymbol());
		indexBentLeftHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-01-09"), indexBentLeftHand.getSymbol());

		indexBentRightHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-02-08"), indexBentRightHandHalfTurn.getSymbol());
		indexBentRightHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-02-07"), indexBentRightHandHalfTurn.getSymbol());
		indexBentRightHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-02-06"), indexBentRightHandHalfTurn.getSymbol());
		indexBentRightHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-02-05"), indexBentRightHandHalfTurn.getSymbol());
		indexBentRightHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-02-04"), indexBentRightHandHalfTurn.getSymbol());
		indexBentRightHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-02-03"), indexBentRightHandHalfTurn.getSymbol());
		indexBentRightHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-02-02"), indexBentRightHandHalfTurn.getSymbol());
		indexBentRightHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-02-01"), indexBentRightHandHalfTurn.getSymbol());

		indexBentLeftHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-02-10"), indexBentLeftHandHalfTurn.getSymbol());
		indexBentLeftHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-02-11"), indexBentLeftHandHalfTurn.getSymbol());
		indexBentLeftHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-02-12"), indexBentLeftHandHalfTurn.getSymbol());
		indexBentLeftHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-02-13"), indexBentLeftHandHalfTurn.getSymbol());
		indexBentLeftHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-02-14"), indexBentLeftHandHalfTurn.getSymbol());
		indexBentLeftHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-02-15"), indexBentLeftHandHalfTurn.getSymbol());
		indexBentLeftHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-02-16"), indexBentLeftHandHalfTurn.getSymbol());
		indexBentLeftHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-02-09"), indexBentLeftHandHalfTurn.getSymbol());

		indexBentRightHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-03-08"), indexBentRightHandFullTurn.getSymbol());
		indexBentRightHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-03-07"), indexBentRightHandFullTurn.getSymbol());
		indexBentRightHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-03-06"), indexBentRightHandFullTurn.getSymbol());
		indexBentRightHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-03-05"), indexBentRightHandFullTurn.getSymbol());
		indexBentRightHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-03-04"), indexBentRightHandFullTurn.getSymbol());
		indexBentRightHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-03-03"), indexBentRightHandFullTurn.getSymbol());
		indexBentRightHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-03-02"), indexBentRightHandFullTurn.getSymbol());
		indexBentRightHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-03-01"), indexBentRightHandFullTurn.getSymbol());

		indexBentLeftHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-03-10"), indexBentLeftHandFullTurn.getSymbol());
		indexBentLeftHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-03-11"), indexBentLeftHandFullTurn.getSymbol());
		indexBentLeftHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-03-12"), indexBentLeftHandFullTurn.getSymbol());
		indexBentLeftHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-03-13"), indexBentLeftHandFullTurn.getSymbol());
		indexBentLeftHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-03-14"), indexBentLeftHandFullTurn.getSymbol());
		indexBentLeftHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-03-15"), indexBentLeftHandFullTurn.getSymbol());
		indexBentLeftHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-03-16"), indexBentLeftHandFullTurn.getSymbol());
		indexBentLeftHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-03-09"), indexBentLeftHandFullTurn.getSymbol());

		indexBentRightHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-04-08"), indexBentRightHandPitched.getSymbol());
		indexBentRightHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-04-07"), indexBentRightHandPitched.getSymbol());
		indexBentRightHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-04-06"), indexBentRightHandPitched.getSymbol());
		indexBentRightHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-04-05"), indexBentRightHandPitched.getSymbol());
		indexBentRightHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-04-04"), indexBentRightHandPitched.getSymbol());
		indexBentRightHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-04-03"), indexBentRightHandPitched.getSymbol());
		indexBentRightHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-04-02"), indexBentRightHandPitched.getSymbol());
		indexBentRightHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-04-01"), indexBentRightHandPitched.getSymbol());

		indexBentLeftHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-04-10"), indexBentLeftHandPitched.getSymbol());
		indexBentLeftHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-04-11"), indexBentLeftHandPitched.getSymbol());
		indexBentLeftHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-04-12"), indexBentLeftHandPitched.getSymbol());
		indexBentLeftHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-04-13"), indexBentLeftHandPitched.getSymbol());
		indexBentLeftHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-04-14"), indexBentLeftHandPitched.getSymbol());
		indexBentLeftHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-04-15"), indexBentLeftHandPitched.getSymbol());
		indexBentLeftHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-04-16"), indexBentLeftHandPitched.getSymbol());
		indexBentLeftHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-04-09"), indexBentLeftHandPitched.getSymbol());

		indexBentRightHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-05-08"), indexBentRightHandHalfTurnPitched.getSymbol());
		indexBentRightHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-05-07"), indexBentRightHandHalfTurnPitched.getSymbol());
		indexBentRightHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-05-06"), indexBentRightHandHalfTurnPitched.getSymbol());
		indexBentRightHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-05-05"), indexBentRightHandHalfTurnPitched.getSymbol());
		indexBentRightHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-05-04"), indexBentRightHandHalfTurnPitched.getSymbol());
		indexBentRightHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-05-03"), indexBentRightHandHalfTurnPitched.getSymbol());
		indexBentRightHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-05-02"), indexBentRightHandHalfTurnPitched.getSymbol());
		indexBentRightHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-05-01"), indexBentRightHandHalfTurnPitched.getSymbol());

		indexBentLeftHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-05-10"), indexBentLeftHandHalfTurnPitched.getSymbol());
		indexBentLeftHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-05-11"), indexBentLeftHandHalfTurnPitched.getSymbol());
		indexBentLeftHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-05-12"), indexBentLeftHandHalfTurnPitched.getSymbol());
		indexBentLeftHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-05-13"), indexBentLeftHandHalfTurnPitched.getSymbol());
		indexBentLeftHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-05-14"), indexBentLeftHandHalfTurnPitched.getSymbol());
		indexBentLeftHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-05-15"), indexBentLeftHandHalfTurnPitched.getSymbol());
		indexBentLeftHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-05-16"), indexBentLeftHandHalfTurnPitched.getSymbol());
		indexBentLeftHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-05-09"), indexBentLeftHandHalfTurnPitched.getSymbol());

		indexBentRightHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-06-08"), indexBentRightHandFullTurnPitched.getSymbol());
		indexBentRightHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-06-07"), indexBentRightHandFullTurnPitched.getSymbol());
		indexBentRightHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-06-06"), indexBentRightHandFullTurnPitched.getSymbol());
		indexBentRightHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-06-05"), indexBentRightHandFullTurnPitched.getSymbol());
		indexBentRightHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-06-04"), indexBentRightHandFullTurnPitched.getSymbol());
		indexBentRightHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-06-03"), indexBentRightHandFullTurnPitched.getSymbol());
		indexBentRightHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-06-02"), indexBentRightHandFullTurnPitched.getSymbol());
		indexBentRightHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-06-01"), indexBentRightHandFullTurnPitched.getSymbol());

		indexBentLeftHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-06-10"), indexBentLeftHandFullTurnPitched.getSymbol());
		indexBentLeftHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-06-11"), indexBentLeftHandFullTurnPitched.getSymbol());
		indexBentLeftHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-06-12"), indexBentLeftHandFullTurnPitched.getSymbol());
		indexBentLeftHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-06-13"), indexBentLeftHandFullTurnPitched.getSymbol());
		indexBentLeftHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-06-14"), indexBentLeftHandFullTurnPitched.getSymbol());
		indexBentLeftHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-06-15"), indexBentLeftHandFullTurnPitched.getSymbol());
		indexBentLeftHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-06-16"), indexBentLeftHandFullTurnPitched.getSymbol());
		indexBentLeftHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-06-09"), indexBentLeftHandFullTurnPitched.getSymbol());

		indexBentOnCircleRightHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-01-08"), indexBentOnCircleRightHand.getSymbol());
		indexBentOnCircleRightHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-01-07"), indexBentOnCircleRightHand.getSymbol());
		indexBentOnCircleRightHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-01-06"), indexBentOnCircleRightHand.getSymbol());
		indexBentOnCircleRightHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-01-05"), indexBentOnCircleRightHand.getSymbol());
		indexBentOnCircleRightHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-01-04"), indexBentOnCircleRightHand.getSymbol());
		indexBentOnCircleRightHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-01-03"), indexBentOnCircleRightHand.getSymbol());
		indexBentOnCircleRightHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-01-02"), indexBentOnCircleRightHand.getSymbol());
		indexBentOnCircleRightHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-01-01"), indexBentOnCircleRightHand.getSymbol());

		indexBentOnCircleLeftHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-01-10"), indexBentOnCircleLeftHand.getSymbol());
		indexBentOnCircleLeftHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-01-11"), indexBentOnCircleLeftHand.getSymbol());
		indexBentOnCircleLeftHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-01-12"), indexBentOnCircleLeftHand.getSymbol());
		indexBentOnCircleLeftHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-01-13"), indexBentOnCircleLeftHand.getSymbol());
		indexBentOnCircleLeftHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-01-14"), indexBentOnCircleLeftHand.getSymbol());
		indexBentOnCircleLeftHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-01-15"), indexBentOnCircleLeftHand.getSymbol());
		indexBentOnCircleLeftHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-01-16"), indexBentOnCircleLeftHand.getSymbol());
		indexBentOnCircleLeftHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-01-09"), indexBentOnCircleLeftHand.getSymbol());

		indexBentOnCircleRightHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-02-08"), indexBentOnCircleRightHandHalfTurn.getSymbol());
		indexBentOnCircleRightHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-02-07"), indexBentOnCircleRightHandHalfTurn.getSymbol());
		indexBentOnCircleRightHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-02-06"), indexBentOnCircleRightHandHalfTurn.getSymbol());
		indexBentOnCircleRightHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-02-05"), indexBentOnCircleRightHandHalfTurn.getSymbol());
		indexBentOnCircleRightHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-02-04"), indexBentOnCircleRightHandHalfTurn.getSymbol());
		indexBentOnCircleRightHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-02-03"), indexBentOnCircleRightHandHalfTurn.getSymbol());
		indexBentOnCircleRightHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-02-02"), indexBentOnCircleRightHandHalfTurn.getSymbol());
		indexBentOnCircleRightHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-02-01"), indexBentOnCircleRightHandHalfTurn.getSymbol());

		indexBentOnCircleLeftHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-02-10"), indexBentOnCircleLeftHandHalfTurn.getSymbol());
		indexBentOnCircleLeftHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-02-11"), indexBentOnCircleLeftHandHalfTurn.getSymbol());
		indexBentOnCircleLeftHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-02-12"), indexBentOnCircleLeftHandHalfTurn.getSymbol());
		indexBentOnCircleLeftHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-02-13"), indexBentOnCircleLeftHandHalfTurn.getSymbol());
		indexBentOnCircleLeftHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-02-14"), indexBentOnCircleLeftHandHalfTurn.getSymbol());
		indexBentOnCircleLeftHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-02-15"), indexBentOnCircleLeftHandHalfTurn.getSymbol());
		indexBentOnCircleLeftHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-02-16"), indexBentOnCircleLeftHandHalfTurn.getSymbol());
		indexBentOnCircleLeftHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-02-09"), indexBentOnCircleLeftHandHalfTurn.getSymbol());

		indexBentOnCircleRightHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-03-08"), indexBentOnCircleRightHandFullTurn.getSymbol());
		indexBentOnCircleRightHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-03-07"), indexBentOnCircleRightHandFullTurn.getSymbol());
		indexBentOnCircleRightHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-03-06"), indexBentOnCircleRightHandFullTurn.getSymbol());
		indexBentOnCircleRightHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-03-05"), indexBentOnCircleRightHandFullTurn.getSymbol());
		indexBentOnCircleRightHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-03-04"), indexBentOnCircleRightHandFullTurn.getSymbol());
		indexBentOnCircleRightHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-03-03"), indexBentOnCircleRightHandFullTurn.getSymbol());
		indexBentOnCircleRightHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-03-02"), indexBentOnCircleRightHandFullTurn.getSymbol());
		indexBentOnCircleRightHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-03-01"), indexBentOnCircleRightHandFullTurn.getSymbol());

		indexBentOnCircleLeftHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-03-10"), indexBentOnCircleLeftHandFullTurn.getSymbol());
		indexBentOnCircleLeftHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-03-11"), indexBentOnCircleLeftHandFullTurn.getSymbol());
		indexBentOnCircleLeftHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-03-12"), indexBentOnCircleLeftHandFullTurn.getSymbol());
		indexBentOnCircleLeftHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-03-13"), indexBentOnCircleLeftHandFullTurn.getSymbol());
		indexBentOnCircleLeftHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-03-14"), indexBentOnCircleLeftHandFullTurn.getSymbol());
		indexBentOnCircleLeftHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-03-15"), indexBentOnCircleLeftHandFullTurn.getSymbol());
		indexBentOnCircleLeftHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-03-16"), indexBentOnCircleLeftHandFullTurn.getSymbol());
		indexBentOnCircleLeftHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-03-09"), indexBentOnCircleLeftHandFullTurn.getSymbol());

		indexBentOnCircleRightHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-04-08"), indexBentOnCircleRightHandPitched.getSymbol());
		indexBentOnCircleRightHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-04-07"), indexBentOnCircleRightHandPitched.getSymbol());
		indexBentOnCircleRightHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-04-06"), indexBentOnCircleRightHandPitched.getSymbol());
		indexBentOnCircleRightHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-04-05"), indexBentOnCircleRightHandPitched.getSymbol());
		indexBentOnCircleRightHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-04-04"), indexBentOnCircleRightHandPitched.getSymbol());
		indexBentOnCircleRightHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-04-03"), indexBentOnCircleRightHandPitched.getSymbol());
		indexBentOnCircleRightHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-04-02"), indexBentOnCircleRightHandPitched.getSymbol());
		indexBentOnCircleRightHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-04-01"), indexBentOnCircleRightHandPitched.getSymbol());

		indexBentOnCircleLeftHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-04-10"), indexBentOnCircleLeftHandPitched.getSymbol());
		indexBentOnCircleLeftHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-04-11"), indexBentOnCircleLeftHandPitched.getSymbol());
		indexBentOnCircleLeftHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-04-12"), indexBentOnCircleLeftHandPitched.getSymbol());
		indexBentOnCircleLeftHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-04-13"), indexBentOnCircleLeftHandPitched.getSymbol());
		indexBentOnCircleLeftHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-04-14"), indexBentOnCircleLeftHandPitched.getSymbol());
		indexBentOnCircleLeftHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-04-15"), indexBentOnCircleLeftHandPitched.getSymbol());
		indexBentOnCircleLeftHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-04-16"), indexBentOnCircleLeftHandPitched.getSymbol());
		indexBentOnCircleLeftHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-04-09"), indexBentOnCircleLeftHandPitched.getSymbol());

		indexBentOnCircleRightHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-05-08"),
				indexBentOnCircleRightHandHalfTurnPitched.getSymbol());
		indexBentOnCircleRightHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-05-07"),
				indexBentOnCircleRightHandHalfTurnPitched.getSymbol());
		indexBentOnCircleRightHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-05-06"),
				indexBentOnCircleRightHandHalfTurnPitched.getSymbol());
		indexBentOnCircleRightHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-05-05"),
				indexBentOnCircleRightHandHalfTurnPitched.getSymbol());
		indexBentOnCircleRightHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-05-04"),
				indexBentOnCircleRightHandHalfTurnPitched.getSymbol());
		indexBentOnCircleRightHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-05-03"),
				indexBentOnCircleRightHandHalfTurnPitched.getSymbol());
		indexBentOnCircleRightHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-05-02"),
				indexBentOnCircleRightHandHalfTurnPitched.getSymbol());
		indexBentOnCircleRightHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-05-01"),
				indexBentOnCircleRightHandHalfTurnPitched.getSymbol());

		indexBentOnCircleLeftHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-05-10"),
				indexBentOnCircleLeftHandHalfTurnPitched.getSymbol());
		indexBentOnCircleLeftHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-05-11"),
				indexBentOnCircleLeftHandHalfTurnPitched.getSymbol());
		indexBentOnCircleLeftHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-05-12"),
				indexBentOnCircleLeftHandHalfTurnPitched.getSymbol());
		indexBentOnCircleLeftHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-05-13"),
				indexBentOnCircleLeftHandHalfTurnPitched.getSymbol());
		indexBentOnCircleLeftHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-05-14"),
				indexBentOnCircleLeftHandHalfTurnPitched.getSymbol());
		indexBentOnCircleLeftHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-05-15"),
				indexBentOnCircleLeftHandHalfTurnPitched.getSymbol());
		indexBentOnCircleLeftHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-05-16"),
				indexBentOnCircleLeftHandHalfTurnPitched.getSymbol());
		indexBentOnCircleLeftHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-05-09"),
				indexBentOnCircleLeftHandHalfTurnPitched.getSymbol());

		indexBentOnCircleRightHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-06-08"),
				indexBentOnCircleRightHandFullTurnPitched.getSymbol());
		indexBentOnCircleRightHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-06-07"),
				indexBentOnCircleRightHandFullTurnPitched.getSymbol());
		indexBentOnCircleRightHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-06-06"),
				indexBentOnCircleRightHandFullTurnPitched.getSymbol());
		indexBentOnCircleRightHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-06-05"),
				indexBentOnCircleRightHandFullTurnPitched.getSymbol());
		indexBentOnCircleRightHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-06-04"),
				indexBentOnCircleRightHandFullTurnPitched.getSymbol());
		indexBentOnCircleRightHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-06-03"),
				indexBentOnCircleRightHandFullTurnPitched.getSymbol());
		indexBentOnCircleRightHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-06-02"),
				indexBentOnCircleRightHandFullTurnPitched.getSymbol());
		indexBentOnCircleRightHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-06-01"),
				indexBentOnCircleRightHandFullTurnPitched.getSymbol());

		indexBentOnCircleLeftHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-06-10"),
				indexBentOnCircleLeftHandFullTurnPitched.getSymbol());
		indexBentOnCircleLeftHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-06-11"),
				indexBentOnCircleLeftHandFullTurnPitched.getSymbol());
		indexBentOnCircleLeftHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-06-12"),
				indexBentOnCircleLeftHandFullTurnPitched.getSymbol());
		indexBentOnCircleLeftHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-06-13"),
				indexBentOnCircleLeftHandFullTurnPitched.getSymbol());
		indexBentOnCircleLeftHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-06-14"),
				indexBentOnCircleLeftHandFullTurnPitched.getSymbol());
		indexBentOnCircleLeftHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-06-15"),
				indexBentOnCircleLeftHandFullTurnPitched.getSymbol());
		indexBentOnCircleLeftHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-06-16"),
				indexBentOnCircleLeftHandFullTurnPitched.getSymbol());
		indexBentOnCircleLeftHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-06-09"),
				indexBentOnCircleLeftHandFullTurnPitched.getSymbol());

		indexBentOnFistThumbUnderRightHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-01-08"), indexBentOnFistThumbUnderRightHand.getSymbol());
		indexBentOnFistThumbUnderRightHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-01-07"), indexBentOnFistThumbUnderRightHand.getSymbol());
		indexBentOnFistThumbUnderRightHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-01-06"), indexBentOnFistThumbUnderRightHand.getSymbol());
		indexBentOnFistThumbUnderRightHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-01-05"), indexBentOnFistThumbUnderRightHand.getSymbol());
		indexBentOnFistThumbUnderRightHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-01-04"), indexBentOnFistThumbUnderRightHand.getSymbol());
		indexBentOnFistThumbUnderRightHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-01-03"), indexBentOnFistThumbUnderRightHand.getSymbol());
		indexBentOnFistThumbUnderRightHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-01-02"), indexBentOnFistThumbUnderRightHand.getSymbol());
		indexBentOnFistThumbUnderRightHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-01-01"), indexBentOnFistThumbUnderRightHand.getSymbol());

		indexBentOnFistThumbUnderLeftHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-01-10"), indexBentOnFistThumbUnderLeftHand.getSymbol());
		indexBentOnFistThumbUnderLeftHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-01-11"), indexBentOnFistThumbUnderLeftHand.getSymbol());
		indexBentOnFistThumbUnderLeftHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-01-12"), indexBentOnFistThumbUnderLeftHand.getSymbol());
		indexBentOnFistThumbUnderLeftHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-01-13"), indexBentOnFistThumbUnderLeftHand.getSymbol());
		indexBentOnFistThumbUnderLeftHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-01-14"), indexBentOnFistThumbUnderLeftHand.getSymbol());
		indexBentOnFistThumbUnderLeftHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-01-15"), indexBentOnFistThumbUnderLeftHand.getSymbol());
		indexBentOnFistThumbUnderLeftHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-01-16"), indexBentOnFistThumbUnderLeftHand.getSymbol());
		indexBentOnFistThumbUnderLeftHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-01-09"), indexBentOnFistThumbUnderLeftHand.getSymbol());

		indexBentOnFistThumbUnderRightHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-02-08"),
				indexBentOnFistThumbUnderRightHandHalfTurn.getSymbol());
		indexBentOnFistThumbUnderRightHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-02-07"),
				indexBentOnFistThumbUnderRightHandHalfTurn.getSymbol());
		indexBentOnFistThumbUnderRightHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-02-06"),
				indexBentOnFistThumbUnderRightHandHalfTurn.getSymbol());
		indexBentOnFistThumbUnderRightHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-02-05"),
				indexBentOnFistThumbUnderRightHandHalfTurn.getSymbol());
		indexBentOnFistThumbUnderRightHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-02-04"),
				indexBentOnFistThumbUnderRightHandHalfTurn.getSymbol());
		indexBentOnFistThumbUnderRightHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-02-03"),
				indexBentOnFistThumbUnderRightHandHalfTurn.getSymbol());
		indexBentOnFistThumbUnderRightHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-02-02"),
				indexBentOnFistThumbUnderRightHandHalfTurn.getSymbol());
		indexBentOnFistThumbUnderRightHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-02-01"),
				indexBentOnFistThumbUnderRightHandHalfTurn.getSymbol());

		indexBentOnFistThumbUnderLeftHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-02-10"),
				indexBentOnFistThumbUnderLeftHandHalfTurn.getSymbol());
		indexBentOnFistThumbUnderLeftHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-02-11"),
				indexBentOnFistThumbUnderLeftHandHalfTurn.getSymbol());
		indexBentOnFistThumbUnderLeftHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-02-12"),
				indexBentOnFistThumbUnderLeftHandHalfTurn.getSymbol());
		indexBentOnFistThumbUnderLeftHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-02-13"),
				indexBentOnFistThumbUnderLeftHandHalfTurn.getSymbol());
		indexBentOnFistThumbUnderLeftHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-02-14"),
				indexBentOnFistThumbUnderLeftHandHalfTurn.getSymbol());
		indexBentOnFistThumbUnderLeftHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-02-15"),
				indexBentOnFistThumbUnderLeftHandHalfTurn.getSymbol());
		indexBentOnFistThumbUnderLeftHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-02-16"),
				indexBentOnFistThumbUnderLeftHandHalfTurn.getSymbol());
		indexBentOnFistThumbUnderLeftHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-02-09"),
				indexBentOnFistThumbUnderLeftHandHalfTurn.getSymbol());

		indexBentOnFistThumbUnderRightHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-03-08"),
				indexBentOnFistThumbUnderRightHandFullTurn.getSymbol());
		indexBentOnFistThumbUnderRightHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-03-07"),
				indexBentOnFistThumbUnderRightHandFullTurn.getSymbol());
		indexBentOnFistThumbUnderRightHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-03-06"),
				indexBentOnFistThumbUnderRightHandFullTurn.getSymbol());
		indexBentOnFistThumbUnderRightHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-03-05"),
				indexBentOnFistThumbUnderRightHandFullTurn.getSymbol());
		indexBentOnFistThumbUnderRightHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-03-04"),
				indexBentOnFistThumbUnderRightHandFullTurn.getSymbol());
		indexBentOnFistThumbUnderRightHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-03-03"),
				indexBentOnFistThumbUnderRightHandFullTurn.getSymbol());
		indexBentOnFistThumbUnderRightHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-03-02"),
				indexBentOnFistThumbUnderRightHandFullTurn.getSymbol());
		indexBentOnFistThumbUnderRightHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-03-01"),
				indexBentOnFistThumbUnderRightHandFullTurn.getSymbol());

		indexBentOnFistThumbUnderLeftHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-03-10"),
				indexBentOnFistThumbUnderLeftHandFullTurn.getSymbol());
		indexBentOnFistThumbUnderLeftHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-03-11"),
				indexBentOnFistThumbUnderLeftHandFullTurn.getSymbol());
		indexBentOnFistThumbUnderLeftHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-03-12"),
				indexBentOnFistThumbUnderLeftHandFullTurn.getSymbol());
		indexBentOnFistThumbUnderLeftHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-03-13"),
				indexBentOnFistThumbUnderLeftHandFullTurn.getSymbol());
		indexBentOnFistThumbUnderLeftHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-03-14"),
				indexBentOnFistThumbUnderLeftHandFullTurn.getSymbol());
		indexBentOnFistThumbUnderLeftHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-03-15"),
				indexBentOnFistThumbUnderLeftHandFullTurn.getSymbol());
		indexBentOnFistThumbUnderLeftHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-03-16"),
				indexBentOnFistThumbUnderLeftHandFullTurn.getSymbol());
		indexBentOnFistThumbUnderLeftHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-03-09"),
				indexBentOnFistThumbUnderLeftHandFullTurn.getSymbol());

		indexBentOnFistThumbUnderRightHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-04-08"),
				indexBentOnFistThumbUnderRightHandPitched.getSymbol());
		indexBentOnFistThumbUnderRightHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-04-07"),
				indexBentOnFistThumbUnderRightHandPitched.getSymbol());
		indexBentOnFistThumbUnderRightHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-04-06"),
				indexBentOnFistThumbUnderRightHandPitched.getSymbol());
		indexBentOnFistThumbUnderRightHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-04-05"),
				indexBentOnFistThumbUnderRightHandPitched.getSymbol());
		indexBentOnFistThumbUnderRightHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-04-04"),
				indexBentOnFistThumbUnderRightHandPitched.getSymbol());
		indexBentOnFistThumbUnderRightHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-04-03"),
				indexBentOnFistThumbUnderRightHandPitched.getSymbol());
		indexBentOnFistThumbUnderRightHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-04-02"),
				indexBentOnFistThumbUnderRightHandPitched.getSymbol());
		indexBentOnFistThumbUnderRightHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-04-01"),
				indexBentOnFistThumbUnderRightHandPitched.getSymbol());

		indexBentOnFistThumbUnderLeftHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-04-10"),
				indexBentOnFistThumbUnderLeftHandPitched.getSymbol());
		indexBentOnFistThumbUnderLeftHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-04-11"),
				indexBentOnFistThumbUnderLeftHandPitched.getSymbol());
		indexBentOnFistThumbUnderLeftHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-04-12"),
				indexBentOnFistThumbUnderLeftHandPitched.getSymbol());
		indexBentOnFistThumbUnderLeftHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-04-13"),
				indexBentOnFistThumbUnderLeftHandPitched.getSymbol());
		indexBentOnFistThumbUnderLeftHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-04-14"),
				indexBentOnFistThumbUnderLeftHandPitched.getSymbol());
		indexBentOnFistThumbUnderLeftHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-04-15"),
				indexBentOnFistThumbUnderLeftHandPitched.getSymbol());
		indexBentOnFistThumbUnderLeftHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-04-16"),
				indexBentOnFistThumbUnderLeftHandPitched.getSymbol());
		indexBentOnFistThumbUnderLeftHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-04-09"),
				indexBentOnFistThumbUnderLeftHandPitched.getSymbol());

		indexBentOnFistThumbUnderRightHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-05-08"),
				indexBentOnFistThumbUnderRightHandHalfTurnPitched.getSymbol());
		indexBentOnFistThumbUnderRightHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-05-07"),
				indexBentOnFistThumbUnderRightHandHalfTurnPitched.getSymbol());
		indexBentOnFistThumbUnderRightHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-05-06"),
				indexBentOnFistThumbUnderRightHandHalfTurnPitched.getSymbol());
		indexBentOnFistThumbUnderRightHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-05-05"),
				indexBentOnFistThumbUnderRightHandHalfTurnPitched.getSymbol());
		indexBentOnFistThumbUnderRightHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-05-04"),
				indexBentOnFistThumbUnderRightHandHalfTurnPitched.getSymbol());
		indexBentOnFistThumbUnderRightHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-05-03"),
				indexBentOnFistThumbUnderRightHandHalfTurnPitched.getSymbol());
		indexBentOnFistThumbUnderRightHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-05-02"),
				indexBentOnFistThumbUnderRightHandHalfTurnPitched.getSymbol());
		indexBentOnFistThumbUnderRightHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-05-01"),
				indexBentOnFistThumbUnderRightHandHalfTurnPitched.getSymbol());

		indexBentOnFistThumbUnderLeftHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-05-10"),
				indexBentOnFistThumbUnderLeftHandHalfTurnPitched.getSymbol());
		indexBentOnFistThumbUnderLeftHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-05-11"),
				indexBentOnFistThumbUnderLeftHandHalfTurnPitched.getSymbol());
		indexBentOnFistThumbUnderLeftHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-05-12"),
				indexBentOnFistThumbUnderLeftHandHalfTurnPitched.getSymbol());
		indexBentOnFistThumbUnderLeftHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-05-13"),
				indexBentOnFistThumbUnderLeftHandHalfTurnPitched.getSymbol());
		indexBentOnFistThumbUnderLeftHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-05-14"),
				indexBentOnFistThumbUnderLeftHandHalfTurnPitched.getSymbol());
		indexBentOnFistThumbUnderLeftHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-05-15"),
				indexBentOnFistThumbUnderLeftHandHalfTurnPitched.getSymbol());
		indexBentOnFistThumbUnderLeftHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-05-16"),
				indexBentOnFistThumbUnderLeftHandHalfTurnPitched.getSymbol());
		indexBentOnFistThumbUnderLeftHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-05-09"),
				indexBentOnFistThumbUnderLeftHandHalfTurnPitched.getSymbol());

		indexBentOnFistThumbUnderRightHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-06-08"),
				indexBentOnFistThumbUnderRightHandFullTurnPitched.getSymbol());
		indexBentOnFistThumbUnderRightHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-06-07"),
				indexBentOnFistThumbUnderRightHandFullTurnPitched.getSymbol());
		indexBentOnFistThumbUnderRightHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-06-06"),
				indexBentOnFistThumbUnderRightHandFullTurnPitched.getSymbol());
		indexBentOnFistThumbUnderRightHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-06-05"),
				indexBentOnFistThumbUnderRightHandFullTurnPitched.getSymbol());
		indexBentOnFistThumbUnderRightHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-06-04"),
				indexBentOnFistThumbUnderRightHandFullTurnPitched.getSymbol());
		indexBentOnFistThumbUnderRightHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-06-03"),
				indexBentOnFistThumbUnderRightHandFullTurnPitched.getSymbol());
		indexBentOnFistThumbUnderRightHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-06-02"),
				indexBentOnFistThumbUnderRightHandFullTurnPitched.getSymbol());
		indexBentOnFistThumbUnderRightHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-06-01"),
				indexBentOnFistThumbUnderRightHandFullTurnPitched.getSymbol());

		indexBentOnFistThumbUnderLeftHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-06-10"),
				indexBentOnFistThumbUnderLeftHandFullTurnPitched.getSymbol());
		indexBentOnFistThumbUnderLeftHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-06-11"),
				indexBentOnFistThumbUnderLeftHandFullTurnPitched.getSymbol());
		indexBentOnFistThumbUnderLeftHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-06-12"),
				indexBentOnFistThumbUnderLeftHandFullTurnPitched.getSymbol());
		indexBentOnFistThumbUnderLeftHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-06-13"),
				indexBentOnFistThumbUnderLeftHandFullTurnPitched.getSymbol());
		indexBentOnFistThumbUnderLeftHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-06-14"),
				indexBentOnFistThumbUnderLeftHandFullTurnPitched.getSymbol());
		indexBentOnFistThumbUnderLeftHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-06-15"),
				indexBentOnFistThumbUnderLeftHandFullTurnPitched.getSymbol());
		indexBentOnFistThumbUnderLeftHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-06-16"),
				indexBentOnFistThumbUnderLeftHandFullTurnPitched.getSymbol());
		indexBentOnFistThumbUnderLeftHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-06-09"),
				indexBentOnFistThumbUnderLeftHandFullTurnPitched.getSymbol());

		indexRaisedKnuckleRightHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-01-08"), indexRaisedKnuckleRightHand.getSymbol());
		indexRaisedKnuckleRightHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-01-07"), indexRaisedKnuckleRightHand.getSymbol());
		indexRaisedKnuckleRightHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-01-06"), indexRaisedKnuckleRightHand.getSymbol());
		indexRaisedKnuckleRightHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-01-05"), indexRaisedKnuckleRightHand.getSymbol());
		indexRaisedKnuckleRightHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-01-04"), indexRaisedKnuckleRightHand.getSymbol());
		indexRaisedKnuckleRightHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-01-03"), indexRaisedKnuckleRightHand.getSymbol());
		indexRaisedKnuckleRightHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-01-02"), indexRaisedKnuckleRightHand.getSymbol());
		indexRaisedKnuckleRightHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-01-01"), indexRaisedKnuckleRightHand.getSymbol());

		indexRaisedKnuckleLeftHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-01-10"), indexRaisedKnuckleLeftHand.getSymbol());
		indexRaisedKnuckleLeftHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-01-11"), indexRaisedKnuckleLeftHand.getSymbol());
		indexRaisedKnuckleLeftHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-01-12"), indexRaisedKnuckleLeftHand.getSymbol());
		indexRaisedKnuckleLeftHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-01-13"), indexRaisedKnuckleLeftHand.getSymbol());
		indexRaisedKnuckleLeftHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-01-14"), indexRaisedKnuckleLeftHand.getSymbol());
		indexRaisedKnuckleLeftHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-01-15"), indexRaisedKnuckleLeftHand.getSymbol());
		indexRaisedKnuckleLeftHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-01-16"), indexRaisedKnuckleLeftHand.getSymbol());
		indexRaisedKnuckleLeftHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-01-09"), indexRaisedKnuckleLeftHand.getSymbol());

		indexRaisedKnuckleRightHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-02-08"), indexRaisedKnuckleRightHandHalfTurn.getSymbol());
		indexRaisedKnuckleRightHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-02-07"), indexRaisedKnuckleRightHandHalfTurn.getSymbol());
		indexRaisedKnuckleRightHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-02-06"), indexRaisedKnuckleRightHandHalfTurn.getSymbol());
		indexRaisedKnuckleRightHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-02-05"), indexRaisedKnuckleRightHandHalfTurn.getSymbol());
		indexRaisedKnuckleRightHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-02-04"), indexRaisedKnuckleRightHandHalfTurn.getSymbol());
		indexRaisedKnuckleRightHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-02-03"), indexRaisedKnuckleRightHandHalfTurn.getSymbol());
		indexRaisedKnuckleRightHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-02-02"), indexRaisedKnuckleRightHandHalfTurn.getSymbol());
		indexRaisedKnuckleRightHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-02-01"), indexRaisedKnuckleRightHandHalfTurn.getSymbol());

		indexRaisedKnuckleLeftHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-02-10"), indexRaisedKnuckleLeftHandHalfTurn.getSymbol());
		indexRaisedKnuckleLeftHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-02-11"), indexRaisedKnuckleLeftHandHalfTurn.getSymbol());
		indexRaisedKnuckleLeftHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-02-12"), indexRaisedKnuckleLeftHandHalfTurn.getSymbol());
		indexRaisedKnuckleLeftHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-02-13"), indexRaisedKnuckleLeftHandHalfTurn.getSymbol());
		indexRaisedKnuckleLeftHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-02-14"), indexRaisedKnuckleLeftHandHalfTurn.getSymbol());
		indexRaisedKnuckleLeftHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-02-15"), indexRaisedKnuckleLeftHandHalfTurn.getSymbol());
		indexRaisedKnuckleLeftHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-02-16"), indexRaisedKnuckleLeftHandHalfTurn.getSymbol());
		indexRaisedKnuckleLeftHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-02-09"), indexRaisedKnuckleLeftHandHalfTurn.getSymbol());

		indexRaisedKnuckleRightHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-03-08"), indexRaisedKnuckleRightHandFullTurn.getSymbol());
		indexRaisedKnuckleRightHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-03-07"), indexRaisedKnuckleRightHandFullTurn.getSymbol());
		indexRaisedKnuckleRightHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-03-06"), indexRaisedKnuckleRightHandFullTurn.getSymbol());
		indexRaisedKnuckleRightHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-03-05"), indexRaisedKnuckleRightHandFullTurn.getSymbol());
		indexRaisedKnuckleRightHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-03-04"), indexRaisedKnuckleRightHandFullTurn.getSymbol());
		indexRaisedKnuckleRightHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-03-03"), indexRaisedKnuckleRightHandFullTurn.getSymbol());
		indexRaisedKnuckleRightHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-03-02"), indexRaisedKnuckleRightHandFullTurn.getSymbol());
		indexRaisedKnuckleRightHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-03-01"), indexRaisedKnuckleRightHandFullTurn.getSymbol());

		indexRaisedKnuckleLeftHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-03-10"), indexRaisedKnuckleLeftHandFullTurn.getSymbol());
		indexRaisedKnuckleLeftHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-03-11"), indexRaisedKnuckleLeftHandFullTurn.getSymbol());
		indexRaisedKnuckleLeftHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-03-12"), indexRaisedKnuckleLeftHandFullTurn.getSymbol());
		indexRaisedKnuckleLeftHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-03-13"), indexRaisedKnuckleLeftHandFullTurn.getSymbol());
		indexRaisedKnuckleLeftHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-03-14"), indexRaisedKnuckleLeftHandFullTurn.getSymbol());
		indexRaisedKnuckleLeftHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-03-15"), indexRaisedKnuckleLeftHandFullTurn.getSymbol());
		indexRaisedKnuckleLeftHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-03-16"), indexRaisedKnuckleLeftHandFullTurn.getSymbol());
		indexRaisedKnuckleLeftHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-03-09"), indexRaisedKnuckleLeftHandFullTurn.getSymbol());

		indexRaisedKnuckleRightHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-04-08"), indexRaisedKnuckleRightHandPitched.getSymbol());
		indexRaisedKnuckleRightHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-04-07"), indexRaisedKnuckleRightHandPitched.getSymbol());
		indexRaisedKnuckleRightHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-04-06"), indexRaisedKnuckleRightHandPitched.getSymbol());
		indexRaisedKnuckleRightHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-04-05"), indexRaisedKnuckleRightHandPitched.getSymbol());
		indexRaisedKnuckleRightHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-04-04"), indexRaisedKnuckleRightHandPitched.getSymbol());
		indexRaisedKnuckleRightHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-04-03"), indexRaisedKnuckleRightHandPitched.getSymbol());
		indexRaisedKnuckleRightHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-04-02"), indexRaisedKnuckleRightHandPitched.getSymbol());
		indexRaisedKnuckleRightHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-04-01"), indexRaisedKnuckleRightHandPitched.getSymbol());

		indexRaisedKnuckleLeftHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-04-10"), indexRaisedKnuckleLeftHandPitched.getSymbol());
		indexRaisedKnuckleLeftHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-04-11"), indexRaisedKnuckleLeftHandPitched.getSymbol());
		indexRaisedKnuckleLeftHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-04-12"), indexRaisedKnuckleLeftHandPitched.getSymbol());
		indexRaisedKnuckleLeftHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-04-13"), indexRaisedKnuckleLeftHandPitched.getSymbol());
		indexRaisedKnuckleLeftHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-04-14"), indexRaisedKnuckleLeftHandPitched.getSymbol());
		indexRaisedKnuckleLeftHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-04-15"), indexRaisedKnuckleLeftHandPitched.getSymbol());
		indexRaisedKnuckleLeftHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-04-16"), indexRaisedKnuckleLeftHandPitched.getSymbol());
		indexRaisedKnuckleLeftHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-04-09"), indexRaisedKnuckleLeftHandPitched.getSymbol());

		indexRaisedKnuckleRightHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-05-08"),
				indexRaisedKnuckleRightHandHalfTurnPitched.getSymbol());
		indexRaisedKnuckleRightHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-05-07"),
				indexRaisedKnuckleRightHandHalfTurnPitched.getSymbol());
		indexRaisedKnuckleRightHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-05-06"),
				indexRaisedKnuckleRightHandHalfTurnPitched.getSymbol());
		indexRaisedKnuckleRightHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-05-05"),
				indexRaisedKnuckleRightHandHalfTurnPitched.getSymbol());
		indexRaisedKnuckleRightHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-05-04"),
				indexRaisedKnuckleRightHandHalfTurnPitched.getSymbol());
		indexRaisedKnuckleRightHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-05-03"),
				indexRaisedKnuckleRightHandHalfTurnPitched.getSymbol());
		indexRaisedKnuckleRightHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-05-02"),
				indexRaisedKnuckleRightHandHalfTurnPitched.getSymbol());
		indexRaisedKnuckleRightHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-05-01"),
				indexRaisedKnuckleRightHandHalfTurnPitched.getSymbol());

		indexRaisedKnuckleLeftHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-05-10"),
				indexRaisedKnuckleLeftHandHalfTurnPitched.getSymbol());
		indexRaisedKnuckleLeftHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-05-11"),
				indexRaisedKnuckleLeftHandHalfTurnPitched.getSymbol());
		indexRaisedKnuckleLeftHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-05-12"),
				indexRaisedKnuckleLeftHandHalfTurnPitched.getSymbol());
		indexRaisedKnuckleLeftHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-05-13"),
				indexRaisedKnuckleLeftHandHalfTurnPitched.getSymbol());
		indexRaisedKnuckleLeftHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-05-14"),
				indexRaisedKnuckleLeftHandHalfTurnPitched.getSymbol());
		indexRaisedKnuckleLeftHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-05-15"),
				indexRaisedKnuckleLeftHandHalfTurnPitched.getSymbol());
		indexRaisedKnuckleLeftHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-05-16"),
				indexRaisedKnuckleLeftHandHalfTurnPitched.getSymbol());
		indexRaisedKnuckleLeftHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-05-09"),
				indexRaisedKnuckleLeftHandHalfTurnPitched.getSymbol());

		indexRaisedKnuckleRightHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-06-08"),
				indexRaisedKnuckleRightHandFullTurnPitched.getSymbol());
		indexRaisedKnuckleRightHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-06-07"),
				indexRaisedKnuckleRightHandFullTurnPitched.getSymbol());
		indexRaisedKnuckleRightHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-06-06"),
				indexRaisedKnuckleRightHandFullTurnPitched.getSymbol());
		indexRaisedKnuckleRightHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-06-05"),
				indexRaisedKnuckleRightHandFullTurnPitched.getSymbol());
		indexRaisedKnuckleRightHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-06-04"),
				indexRaisedKnuckleRightHandFullTurnPitched.getSymbol());
		indexRaisedKnuckleRightHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-06-03"),
				indexRaisedKnuckleRightHandFullTurnPitched.getSymbol());
		indexRaisedKnuckleRightHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-06-02"),
				indexRaisedKnuckleRightHandFullTurnPitched.getSymbol());
		indexRaisedKnuckleRightHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-06-01"),
				indexRaisedKnuckleRightHandFullTurnPitched.getSymbol());

		indexRaisedKnuckleLeftHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-06-10"),
				indexRaisedKnuckleLeftHandFullTurnPitched.getSymbol());
		indexRaisedKnuckleLeftHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-06-11"),
				indexRaisedKnuckleLeftHandFullTurnPitched.getSymbol());
		indexRaisedKnuckleLeftHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-06-12"),
				indexRaisedKnuckleLeftHandFullTurnPitched.getSymbol());
		indexRaisedKnuckleLeftHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-06-13"),
				indexRaisedKnuckleLeftHandFullTurnPitched.getSymbol());
		indexRaisedKnuckleLeftHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-06-14"),
				indexRaisedKnuckleLeftHandFullTurnPitched.getSymbol());
		indexRaisedKnuckleLeftHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-06-15"),
				indexRaisedKnuckleLeftHandFullTurnPitched.getSymbol());
		indexRaisedKnuckleLeftHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-06-16"),
				indexRaisedKnuckleLeftHandFullTurnPitched.getSymbol());
		indexRaisedKnuckleLeftHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-06-09"),
				indexRaisedKnuckleLeftHandFullTurnPitched.getSymbol());

		indexCupRightHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-01-08"), indexCupRightHand.getSymbol());
		indexCupRightHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-01-07"), indexCupRightHand.getSymbol());
		indexCupRightHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-01-06"), indexCupRightHand.getSymbol());
		indexCupRightHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-01-05"), indexCupRightHand.getSymbol());
		indexCupRightHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-01-04"), indexCupRightHand.getSymbol());
		indexCupRightHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-01-03"), indexCupRightHand.getSymbol());
		indexCupRightHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-01-02"), indexCupRightHand.getSymbol());
		indexCupRightHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-01-01"), indexCupRightHand.getSymbol());

		indexCupLeftHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-01-10"), indexCupLeftHand.getSymbol());
		indexCupLeftHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-01-11"), indexCupLeftHand.getSymbol());
		indexCupLeftHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-01-12"), indexCupLeftHand.getSymbol());
		indexCupLeftHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-01-13"), indexCupLeftHand.getSymbol());
		indexCupLeftHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-01-14"), indexCupLeftHand.getSymbol());
		indexCupLeftHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-01-15"), indexCupLeftHand.getSymbol());
		indexCupLeftHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-01-16"), indexCupLeftHand.getSymbol());
		indexCupLeftHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-01-09"), indexCupLeftHand.getSymbol());

		indexCupRightHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-02-08"), indexCupRightHandHalfTurn.getSymbol());
		indexCupRightHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-02-07"), indexCupRightHandHalfTurn.getSymbol());
		indexCupRightHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-02-06"), indexCupRightHandHalfTurn.getSymbol());
		indexCupRightHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-02-05"), indexCupRightHandHalfTurn.getSymbol());
		indexCupRightHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-02-04"), indexCupRightHandHalfTurn.getSymbol());
		indexCupRightHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-02-03"), indexCupRightHandHalfTurn.getSymbol());
		indexCupRightHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-02-02"), indexCupRightHandHalfTurn.getSymbol());
		indexCupRightHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-02-01"), indexCupRightHandHalfTurn.getSymbol());

		indexCupLeftHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-02-10"), indexCupLeftHandHalfTurn.getSymbol());
		indexCupLeftHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-02-11"), indexCupLeftHandHalfTurn.getSymbol());
		indexCupLeftHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-02-12"), indexCupLeftHandHalfTurn.getSymbol());
		indexCupLeftHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-02-13"), indexCupLeftHandHalfTurn.getSymbol());
		indexCupLeftHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-02-14"), indexCupLeftHandHalfTurn.getSymbol());
		indexCupLeftHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-02-15"), indexCupLeftHandHalfTurn.getSymbol());
		indexCupLeftHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-02-16"), indexCupLeftHandHalfTurn.getSymbol());
		indexCupLeftHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-02-09"), indexCupLeftHandHalfTurn.getSymbol());

		indexCupRightHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-03-08"), indexCupRightHandFullTurn.getSymbol());
		indexCupRightHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-03-07"), indexCupRightHandFullTurn.getSymbol());
		indexCupRightHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-03-06"), indexCupRightHandFullTurn.getSymbol());
		indexCupRightHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-03-05"), indexCupRightHandFullTurn.getSymbol());
		indexCupRightHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-03-04"), indexCupRightHandFullTurn.getSymbol());
		indexCupRightHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-03-03"), indexCupRightHandFullTurn.getSymbol());
		indexCupRightHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-03-02"), indexCupRightHandFullTurn.getSymbol());
		indexCupRightHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-03-01"), indexCupRightHandFullTurn.getSymbol());

		indexCupLeftHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-03-10"), indexCupLeftHandFullTurn.getSymbol());
		indexCupLeftHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-03-11"), indexCupLeftHandFullTurn.getSymbol());
		indexCupLeftHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-03-12"), indexCupLeftHandFullTurn.getSymbol());
		indexCupLeftHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-03-13"), indexCupLeftHandFullTurn.getSymbol());
		indexCupLeftHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-03-14"), indexCupLeftHandFullTurn.getSymbol());
		indexCupLeftHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-03-15"), indexCupLeftHandFullTurn.getSymbol());
		indexCupLeftHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-03-16"), indexCupLeftHandFullTurn.getSymbol());
		indexCupLeftHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-03-09"), indexCupLeftHandFullTurn.getSymbol());

		indexCupRightHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-04-08"), indexCupRightHandPitched.getSymbol());
		indexCupRightHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-04-07"), indexCupRightHandPitched.getSymbol());
		indexCupRightHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-04-06"), indexCupRightHandPitched.getSymbol());
		indexCupRightHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-04-05"), indexCupRightHandPitched.getSymbol());
		indexCupRightHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-04-04"), indexCupRightHandPitched.getSymbol());
		indexCupRightHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-04-03"), indexCupRightHandPitched.getSymbol());
		indexCupRightHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-04-02"), indexCupRightHandPitched.getSymbol());
		indexCupRightHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-04-01"), indexCupRightHandPitched.getSymbol());

		indexCupLeftHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-04-10"), indexCupLeftHandPitched.getSymbol());
		indexCupLeftHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-04-11"), indexCupLeftHandPitched.getSymbol());
		indexCupLeftHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-04-12"), indexCupLeftHandPitched.getSymbol());
		indexCupLeftHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-04-13"), indexCupLeftHandPitched.getSymbol());
		indexCupLeftHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-04-14"), indexCupLeftHandPitched.getSymbol());
		indexCupLeftHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-04-15"), indexCupLeftHandPitched.getSymbol());
		indexCupLeftHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-04-16"), indexCupLeftHandPitched.getSymbol());
		indexCupLeftHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-04-09"), indexCupLeftHandPitched.getSymbol());

		indexCupRightHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-05-08"), indexCupRightHandHalfTurnPitched.getSymbol());
		indexCupRightHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-05-07"), indexCupRightHandHalfTurnPitched.getSymbol());
		indexCupRightHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-05-06"), indexCupRightHandHalfTurnPitched.getSymbol());
		indexCupRightHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-05-05"), indexCupRightHandHalfTurnPitched.getSymbol());
		indexCupRightHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-05-04"), indexCupRightHandHalfTurnPitched.getSymbol());
		indexCupRightHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-05-03"), indexCupRightHandHalfTurnPitched.getSymbol());
		indexCupRightHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-05-02"), indexCupRightHandHalfTurnPitched.getSymbol());
		indexCupRightHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-05-01"), indexCupRightHandHalfTurnPitched.getSymbol());

		indexCupLeftHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-05-10"), indexCupLeftHandHalfTurnPitched.getSymbol());
		indexCupLeftHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-05-11"), indexCupLeftHandHalfTurnPitched.getSymbol());
		indexCupLeftHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-05-12"), indexCupLeftHandHalfTurnPitched.getSymbol());
		indexCupLeftHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-05-13"), indexCupLeftHandHalfTurnPitched.getSymbol());
		indexCupLeftHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-05-14"), indexCupLeftHandHalfTurnPitched.getSymbol());
		indexCupLeftHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-05-15"), indexCupLeftHandHalfTurnPitched.getSymbol());
		indexCupLeftHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-05-16"), indexCupLeftHandHalfTurnPitched.getSymbol());
		indexCupLeftHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-05-09"), indexCupLeftHandHalfTurnPitched.getSymbol());

		indexCupRightHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-06-08"), indexCupRightHandFullTurnPitched.getSymbol());
		indexCupRightHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-06-07"), indexCupRightHandFullTurnPitched.getSymbol());
		indexCupRightHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-06-06"), indexCupRightHandFullTurnPitched.getSymbol());
		indexCupRightHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-06-05"), indexCupRightHandFullTurnPitched.getSymbol());
		indexCupRightHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-06-04"), indexCupRightHandFullTurnPitched.getSymbol());
		indexCupRightHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-06-03"), indexCupRightHandFullTurnPitched.getSymbol());
		indexCupRightHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-06-02"), indexCupRightHandFullTurnPitched.getSymbol());
		indexCupRightHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-06-01"), indexCupRightHandFullTurnPitched.getSymbol());

		indexCupLeftHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-06-10"), indexCupLeftHandFullTurnPitched.getSymbol());
		indexCupLeftHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-06-11"), indexCupLeftHandFullTurnPitched.getSymbol());
		indexCupLeftHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-06-12"), indexCupLeftHandFullTurnPitched.getSymbol());
		indexCupLeftHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-06-13"), indexCupLeftHandFullTurnPitched.getSymbol());
		indexCupLeftHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-06-14"), indexCupLeftHandFullTurnPitched.getSymbol());
		indexCupLeftHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-06-15"), indexCupLeftHandFullTurnPitched.getSymbol());
		indexCupLeftHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-06-16"), indexCupLeftHandFullTurnPitched.getSymbol());
		indexCupLeftHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-06-09"), indexCupLeftHandFullTurnPitched.getSymbol());

		indexHingeOnFistRightHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-01-08"), indexHingeOnFistRightHand.getSymbol());
		indexHingeOnFistRightHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-01-07"), indexHingeOnFistRightHand.getSymbol());
		indexHingeOnFistRightHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-01-06"), indexHingeOnFistRightHand.getSymbol());
		indexHingeOnFistRightHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-01-05"), indexHingeOnFistRightHand.getSymbol());
		indexHingeOnFistRightHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-01-04"), indexHingeOnFistRightHand.getSymbol());
		indexHingeOnFistRightHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-01-03"), indexHingeOnFistRightHand.getSymbol());
		indexHingeOnFistRightHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-01-02"), indexHingeOnFistRightHand.getSymbol());
		indexHingeOnFistRightHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-01-01"), indexHingeOnFistRightHand.getSymbol());

		indexHingeOnFistLeftHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-01-10"), indexHingeOnFistLeftHand.getSymbol());
		indexHingeOnFistLeftHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-01-11"), indexHingeOnFistLeftHand.getSymbol());
		indexHingeOnFistLeftHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-01-12"), indexHingeOnFistLeftHand.getSymbol());
		indexHingeOnFistLeftHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-01-13"), indexHingeOnFistLeftHand.getSymbol());
		indexHingeOnFistLeftHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-01-14"), indexHingeOnFistLeftHand.getSymbol());
		indexHingeOnFistLeftHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-01-15"), indexHingeOnFistLeftHand.getSymbol());
		indexHingeOnFistLeftHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-01-16"), indexHingeOnFistLeftHand.getSymbol());
		indexHingeOnFistLeftHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-01-09"), indexHingeOnFistLeftHand.getSymbol());

		indexHingeOnFistRightHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-02-08"), indexHingeOnFistRightHandHalfTurn.getSymbol());
		indexHingeOnFistRightHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-02-07"), indexHingeOnFistRightHandHalfTurn.getSymbol());
		indexHingeOnFistRightHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-02-06"), indexHingeOnFistRightHandHalfTurn.getSymbol());
		indexHingeOnFistRightHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-02-05"), indexHingeOnFistRightHandHalfTurn.getSymbol());
		indexHingeOnFistRightHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-02-04"), indexHingeOnFistRightHandHalfTurn.getSymbol());
		indexHingeOnFistRightHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-02-03"), indexHingeOnFistRightHandHalfTurn.getSymbol());
		indexHingeOnFistRightHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-02-02"), indexHingeOnFistRightHandHalfTurn.getSymbol());
		indexHingeOnFistRightHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-02-01"), indexHingeOnFistRightHandHalfTurn.getSymbol());

		indexHingeOnFistLeftHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-02-10"), indexHingeOnFistLeftHandHalfTurn.getSymbol());
		indexHingeOnFistLeftHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-02-11"), indexHingeOnFistLeftHandHalfTurn.getSymbol());
		indexHingeOnFistLeftHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-02-12"), indexHingeOnFistLeftHandHalfTurn.getSymbol());
		indexHingeOnFistLeftHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-02-13"), indexHingeOnFistLeftHandHalfTurn.getSymbol());
		indexHingeOnFistLeftHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-02-14"), indexHingeOnFistLeftHandHalfTurn.getSymbol());
		indexHingeOnFistLeftHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-02-15"), indexHingeOnFistLeftHandHalfTurn.getSymbol());
		indexHingeOnFistLeftHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-02-16"), indexHingeOnFistLeftHandHalfTurn.getSymbol());
		indexHingeOnFistLeftHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-02-09"), indexHingeOnFistLeftHandHalfTurn.getSymbol());

		indexHingeOnFistRightHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-03-08"), indexHingeOnFistRightHandFullTurn.getSymbol());
		indexHingeOnFistRightHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-03-07"), indexHingeOnFistRightHandFullTurn.getSymbol());
		indexHingeOnFistRightHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-03-06"), indexHingeOnFistRightHandFullTurn.getSymbol());
		indexHingeOnFistRightHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-03-05"), indexHingeOnFistRightHandFullTurn.getSymbol());
		indexHingeOnFistRightHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-03-04"), indexHingeOnFistRightHandFullTurn.getSymbol());
		indexHingeOnFistRightHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-03-03"), indexHingeOnFistRightHandFullTurn.getSymbol());
		indexHingeOnFistRightHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-03-02"), indexHingeOnFistRightHandFullTurn.getSymbol());
		indexHingeOnFistRightHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-03-01"), indexHingeOnFistRightHandFullTurn.getSymbol());

		indexHingeOnFistLeftHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-03-10"), indexHingeOnFistLeftHandFullTurn.getSymbol());
		indexHingeOnFistLeftHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-03-11"), indexHingeOnFistLeftHandFullTurn.getSymbol());
		indexHingeOnFistLeftHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-03-12"), indexHingeOnFistLeftHandFullTurn.getSymbol());
		indexHingeOnFistLeftHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-03-13"), indexHingeOnFistLeftHandFullTurn.getSymbol());
		indexHingeOnFistLeftHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-03-14"), indexHingeOnFistLeftHandFullTurn.getSymbol());
		indexHingeOnFistLeftHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-03-15"), indexHingeOnFistLeftHandFullTurn.getSymbol());
		indexHingeOnFistLeftHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-03-16"), indexHingeOnFistLeftHandFullTurn.getSymbol());
		indexHingeOnFistLeftHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-03-09"), indexHingeOnFistLeftHandFullTurn.getSymbol());

		indexHingeOnFistRightHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-04-08"), indexHingeOnFistRightHandPitched.getSymbol());
		indexHingeOnFistRightHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-04-07"), indexHingeOnFistRightHandPitched.getSymbol());
		indexHingeOnFistRightHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-04-06"), indexHingeOnFistRightHandPitched.getSymbol());
		indexHingeOnFistRightHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-04-05"), indexHingeOnFistRightHandPitched.getSymbol());
		indexHingeOnFistRightHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-04-04"), indexHingeOnFistRightHandPitched.getSymbol());
		indexHingeOnFistRightHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-04-03"), indexHingeOnFistRightHandPitched.getSymbol());
		indexHingeOnFistRightHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-04-02"), indexHingeOnFistRightHandPitched.getSymbol());
		indexHingeOnFistRightHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-04-01"), indexHingeOnFistRightHandPitched.getSymbol());

		indexHingeOnFistLeftHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-04-10"), indexHingeOnFistLeftHandPitched.getSymbol());
		indexHingeOnFistLeftHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-04-11"), indexHingeOnFistLeftHandPitched.getSymbol());
		indexHingeOnFistLeftHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-04-12"), indexHingeOnFistLeftHandPitched.getSymbol());
		indexHingeOnFistLeftHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-04-13"), indexHingeOnFistLeftHandPitched.getSymbol());
		indexHingeOnFistLeftHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-04-14"), indexHingeOnFistLeftHandPitched.getSymbol());
		indexHingeOnFistLeftHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-04-15"), indexHingeOnFistLeftHandPitched.getSymbol());
		indexHingeOnFistLeftHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-04-16"), indexHingeOnFistLeftHandPitched.getSymbol());
		indexHingeOnFistLeftHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-04-09"), indexHingeOnFistLeftHandPitched.getSymbol());

		indexHingeOnFistRightHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-05-08"),
				indexHingeOnFistRightHandHalfTurnPitched.getSymbol());
		indexHingeOnFistRightHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-05-07"),
				indexHingeOnFistRightHandHalfTurnPitched.getSymbol());
		indexHingeOnFistRightHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-05-06"),
				indexHingeOnFistRightHandHalfTurnPitched.getSymbol());
		indexHingeOnFistRightHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-05-05"),
				indexHingeOnFistRightHandHalfTurnPitched.getSymbol());
		indexHingeOnFistRightHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-05-04"),
				indexHingeOnFistRightHandHalfTurnPitched.getSymbol());
		indexHingeOnFistRightHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-05-03"),
				indexHingeOnFistRightHandHalfTurnPitched.getSymbol());
		indexHingeOnFistRightHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-05-02"),
				indexHingeOnFistRightHandHalfTurnPitched.getSymbol());
		indexHingeOnFistRightHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-05-01"),
				indexHingeOnFistRightHandHalfTurnPitched.getSymbol());

		indexHingeOnFistLeftHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-05-10"),
				indexHingeOnFistLeftHandHalfTurnPitched.getSymbol());
		indexHingeOnFistLeftHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-05-11"),
				indexHingeOnFistLeftHandHalfTurnPitched.getSymbol());
		indexHingeOnFistLeftHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-05-12"),
				indexHingeOnFistLeftHandHalfTurnPitched.getSymbol());
		indexHingeOnFistLeftHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-05-13"),
				indexHingeOnFistLeftHandHalfTurnPitched.getSymbol());
		indexHingeOnFistLeftHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-05-14"),
				indexHingeOnFistLeftHandHalfTurnPitched.getSymbol());
		indexHingeOnFistLeftHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-05-15"),
				indexHingeOnFistLeftHandHalfTurnPitched.getSymbol());
		indexHingeOnFistLeftHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-05-16"),
				indexHingeOnFistLeftHandHalfTurnPitched.getSymbol());
		indexHingeOnFistLeftHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-05-09"),
				indexHingeOnFistLeftHandHalfTurnPitched.getSymbol());

		indexHingeOnFistRightHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-06-08"),
				indexHingeOnFistRightHandFullTurnPitched.getSymbol());
		indexHingeOnFistRightHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-06-07"),
				indexHingeOnFistRightHandFullTurnPitched.getSymbol());
		indexHingeOnFistRightHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-06-06"),
				indexHingeOnFistRightHandFullTurnPitched.getSymbol());
		indexHingeOnFistRightHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-06-05"),
				indexHingeOnFistRightHandFullTurnPitched.getSymbol());
		indexHingeOnFistRightHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-06-04"),
				indexHingeOnFistRightHandFullTurnPitched.getSymbol());
		indexHingeOnFistRightHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-06-03"),
				indexHingeOnFistRightHandFullTurnPitched.getSymbol());
		indexHingeOnFistRightHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-06-02"),
				indexHingeOnFistRightHandFullTurnPitched.getSymbol());
		indexHingeOnFistRightHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-06-01"),
				indexHingeOnFistRightHandFullTurnPitched.getSymbol());

		indexHingeOnFistLeftHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-06-10"),
				indexHingeOnFistLeftHandFullTurnPitched.getSymbol());
		indexHingeOnFistLeftHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-06-11"),
				indexHingeOnFistLeftHandFullTurnPitched.getSymbol());
		indexHingeOnFistLeftHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-06-12"),
				indexHingeOnFistLeftHandFullTurnPitched.getSymbol());
		indexHingeOnFistLeftHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-06-13"),
				indexHingeOnFistLeftHandFullTurnPitched.getSymbol());
		indexHingeOnFistLeftHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-06-14"),
				indexHingeOnFistLeftHandFullTurnPitched.getSymbol());
		indexHingeOnFistLeftHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-06-15"),
				indexHingeOnFistLeftHandFullTurnPitched.getSymbol());
		indexHingeOnFistLeftHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-06-16"),
				indexHingeOnFistLeftHandFullTurnPitched.getSymbol());
		indexHingeOnFistLeftHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-06-09"),
				indexHingeOnFistLeftHandFullTurnPitched.getSymbol());

		indexHingeOnFistLowRightHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-01-08"), indexHingeOnFistLowRightHand.getSymbol());
		indexHingeOnFistLowRightHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-01-07"), indexHingeOnFistLowRightHand.getSymbol());
		indexHingeOnFistLowRightHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-01-06"), indexHingeOnFistLowRightHand.getSymbol());
		indexHingeOnFistLowRightHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-01-05"), indexHingeOnFistLowRightHand.getSymbol());
		indexHingeOnFistLowRightHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-01-04"), indexHingeOnFistLowRightHand.getSymbol());
		indexHingeOnFistLowRightHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-01-03"), indexHingeOnFistLowRightHand.getSymbol());
		indexHingeOnFistLowRightHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-01-02"), indexHingeOnFistLowRightHand.getSymbol());
		indexHingeOnFistLowRightHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-01-01"), indexHingeOnFistLowRightHand.getSymbol());

		indexHingeOnFistLowLeftHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-01-10"), indexHingeOnFistLowLeftHand.getSymbol());
		indexHingeOnFistLowLeftHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-01-11"), indexHingeOnFistLowLeftHand.getSymbol());
		indexHingeOnFistLowLeftHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-01-12"), indexHingeOnFistLowLeftHand.getSymbol());
		indexHingeOnFistLowLeftHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-01-13"), indexHingeOnFistLowLeftHand.getSymbol());
		indexHingeOnFistLowLeftHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-01-14"), indexHingeOnFistLowLeftHand.getSymbol());
		indexHingeOnFistLowLeftHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-01-15"), indexHingeOnFistLowLeftHand.getSymbol());
		indexHingeOnFistLowLeftHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-01-16"), indexHingeOnFistLowLeftHand.getSymbol());
		indexHingeOnFistLowLeftHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-01-09"), indexHingeOnFistLowLeftHand.getSymbol());

		indexHingeOnFistLowRightHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-02-08"),
				indexHingeOnFistLowRightHandHalfTurn.getSymbol());
		indexHingeOnFistLowRightHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-02-07"),
				indexHingeOnFistLowRightHandHalfTurn.getSymbol());
		indexHingeOnFistLowRightHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-02-06"),
				indexHingeOnFistLowRightHandHalfTurn.getSymbol());
		indexHingeOnFistLowRightHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-02-05"),
				indexHingeOnFistLowRightHandHalfTurn.getSymbol());
		indexHingeOnFistLowRightHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-02-04"),
				indexHingeOnFistLowRightHandHalfTurn.getSymbol());
		indexHingeOnFistLowRightHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-02-03"),
				indexHingeOnFistLowRightHandHalfTurn.getSymbol());
		indexHingeOnFistLowRightHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-02-02"),
				indexHingeOnFistLowRightHandHalfTurn.getSymbol());
		indexHingeOnFistLowRightHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-02-01"),
				indexHingeOnFistLowRightHandHalfTurn.getSymbol());

		indexHingeOnFistLowLeftHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-02-10"), indexHingeOnFistLowLeftHandHalfTurn.getSymbol());
		indexHingeOnFistLowLeftHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-02-11"), indexHingeOnFistLowLeftHandHalfTurn.getSymbol());
		indexHingeOnFistLowLeftHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-02-12"), indexHingeOnFistLowLeftHandHalfTurn.getSymbol());
		indexHingeOnFistLowLeftHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-02-13"), indexHingeOnFistLowLeftHandHalfTurn.getSymbol());
		indexHingeOnFistLowLeftHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-02-14"), indexHingeOnFistLowLeftHandHalfTurn.getSymbol());
		indexHingeOnFistLowLeftHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-02-15"), indexHingeOnFistLowLeftHandHalfTurn.getSymbol());
		indexHingeOnFistLowLeftHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-02-16"), indexHingeOnFistLowLeftHandHalfTurn.getSymbol());
		indexHingeOnFistLowLeftHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-02-09"), indexHingeOnFistLowLeftHandHalfTurn.getSymbol());

		indexHingeOnFistLowRightHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-03-08"),
				indexHingeOnFistLowRightHandFullTurn.getSymbol());
		indexHingeOnFistLowRightHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-03-07"),
				indexHingeOnFistLowRightHandFullTurn.getSymbol());
		indexHingeOnFistLowRightHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-03-06"),
				indexHingeOnFistLowRightHandFullTurn.getSymbol());
		indexHingeOnFistLowRightHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-03-05"),
				indexHingeOnFistLowRightHandFullTurn.getSymbol());
		indexHingeOnFistLowRightHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-03-04"),
				indexHingeOnFistLowRightHandFullTurn.getSymbol());
		indexHingeOnFistLowRightHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-03-03"),
				indexHingeOnFistLowRightHandFullTurn.getSymbol());
		indexHingeOnFistLowRightHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-03-02"),
				indexHingeOnFistLowRightHandFullTurn.getSymbol());
		indexHingeOnFistLowRightHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-03-01"),
				indexHingeOnFistLowRightHandFullTurn.getSymbol());

		indexHingeOnFistLowLeftHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-03-10"), indexHingeOnFistLowLeftHandFullTurn.getSymbol());
		indexHingeOnFistLowLeftHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-03-11"), indexHingeOnFistLowLeftHandFullTurn.getSymbol());
		indexHingeOnFistLowLeftHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-03-12"), indexHingeOnFistLowLeftHandFullTurn.getSymbol());
		indexHingeOnFistLowLeftHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-03-13"), indexHingeOnFistLowLeftHandFullTurn.getSymbol());
		indexHingeOnFistLowLeftHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-03-14"), indexHingeOnFistLowLeftHandFullTurn.getSymbol());
		indexHingeOnFistLowLeftHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-03-15"), indexHingeOnFistLowLeftHandFullTurn.getSymbol());
		indexHingeOnFistLowLeftHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-03-16"), indexHingeOnFistLowLeftHandFullTurn.getSymbol());
		indexHingeOnFistLowLeftHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-03-09"), indexHingeOnFistLowLeftHandFullTurn.getSymbol());

		indexHingeOnFistLowRightHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-04-08"), indexHingeOnFistLowRightHandPitched.getSymbol());
		indexHingeOnFistLowRightHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-04-07"), indexHingeOnFistLowRightHandPitched.getSymbol());
		indexHingeOnFistLowRightHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-04-06"), indexHingeOnFistLowRightHandPitched.getSymbol());
		indexHingeOnFistLowRightHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-04-05"), indexHingeOnFistLowRightHandPitched.getSymbol());
		indexHingeOnFistLowRightHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-04-04"), indexHingeOnFistLowRightHandPitched.getSymbol());
		indexHingeOnFistLowRightHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-04-03"), indexHingeOnFistLowRightHandPitched.getSymbol());
		indexHingeOnFistLowRightHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-04-02"), indexHingeOnFistLowRightHandPitched.getSymbol());
		indexHingeOnFistLowRightHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-04-01"), indexHingeOnFistLowRightHandPitched.getSymbol());

		indexHingeOnFistLowLeftHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-04-10"), indexHingeOnFistLowLeftHandPitched.getSymbol());
		indexHingeOnFistLowLeftHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-04-11"), indexHingeOnFistLowLeftHandPitched.getSymbol());
		indexHingeOnFistLowLeftHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-04-12"), indexHingeOnFistLowLeftHandPitched.getSymbol());
		indexHingeOnFistLowLeftHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-04-13"), indexHingeOnFistLowLeftHandPitched.getSymbol());
		indexHingeOnFistLowLeftHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-04-14"), indexHingeOnFistLowLeftHandPitched.getSymbol());
		indexHingeOnFistLowLeftHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-04-15"), indexHingeOnFistLowLeftHandPitched.getSymbol());
		indexHingeOnFistLowLeftHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-04-16"), indexHingeOnFistLowLeftHandPitched.getSymbol());
		indexHingeOnFistLowLeftHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-04-09"), indexHingeOnFistLowLeftHandPitched.getSymbol());

		indexHingeOnFistLowRightHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-05-08"),
				indexHingeOnFistLowRightHandHalfTurnPitched.getSymbol());
		indexHingeOnFistLowRightHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-05-07"),
				indexHingeOnFistLowRightHandHalfTurnPitched.getSymbol());
		indexHingeOnFistLowRightHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-05-06"),
				indexHingeOnFistLowRightHandHalfTurnPitched.getSymbol());
		indexHingeOnFistLowRightHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-05-05"),
				indexHingeOnFistLowRightHandHalfTurnPitched.getSymbol());
		indexHingeOnFistLowRightHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-05-04"),
				indexHingeOnFistLowRightHandHalfTurnPitched.getSymbol());
		indexHingeOnFistLowRightHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-05-03"),
				indexHingeOnFistLowRightHandHalfTurnPitched.getSymbol());
		indexHingeOnFistLowRightHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-05-02"),
				indexHingeOnFistLowRightHandHalfTurnPitched.getSymbol());
		indexHingeOnFistLowRightHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-05-01"),
				indexHingeOnFistLowRightHandHalfTurnPitched.getSymbol());

		indexHingeOnFistLowLeftHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-05-10"),
				indexHingeOnFistLowLeftHandHalfTurnPitched.getSymbol());
		indexHingeOnFistLowLeftHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-05-11"),
				indexHingeOnFistLowLeftHandHalfTurnPitched.getSymbol());
		indexHingeOnFistLowLeftHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-05-12"),
				indexHingeOnFistLowLeftHandHalfTurnPitched.getSymbol());
		indexHingeOnFistLowLeftHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-05-13"),
				indexHingeOnFistLowLeftHandHalfTurnPitched.getSymbol());
		indexHingeOnFistLowLeftHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-05-14"),
				indexHingeOnFistLowLeftHandHalfTurnPitched.getSymbol());
		indexHingeOnFistLowLeftHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-05-15"),
				indexHingeOnFistLowLeftHandHalfTurnPitched.getSymbol());
		indexHingeOnFistLowLeftHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-05-16"),
				indexHingeOnFistLowLeftHandHalfTurnPitched.getSymbol());
		indexHingeOnFistLowLeftHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-05-09"),
				indexHingeOnFistLowLeftHandHalfTurnPitched.getSymbol());

		indexHingeOnFistLowRightHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-06-08"),
				indexHingeOnFistLowRightHandFullTurnPitched.getSymbol());
		indexHingeOnFistLowRightHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-06-07"),
				indexHingeOnFistLowRightHandFullTurnPitched.getSymbol());
		indexHingeOnFistLowRightHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-06-06"),
				indexHingeOnFistLowRightHandFullTurnPitched.getSymbol());
		indexHingeOnFistLowRightHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-06-05"),
				indexHingeOnFistLowRightHandFullTurnPitched.getSymbol());
		indexHingeOnFistLowRightHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-06-04"),
				indexHingeOnFistLowRightHandFullTurnPitched.getSymbol());
		indexHingeOnFistLowRightHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-06-03"),
				indexHingeOnFistLowRightHandFullTurnPitched.getSymbol());
		indexHingeOnFistLowRightHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-06-02"),
				indexHingeOnFistLowRightHandFullTurnPitched.getSymbol());
		indexHingeOnFistLowRightHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-06-01"),
				indexHingeOnFistLowRightHandFullTurnPitched.getSymbol());

		indexHingeOnFistLowLeftHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-06-10"),
				indexHingeOnFistLowLeftHandFullTurnPitched.getSymbol());
		indexHingeOnFistLowLeftHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-06-11"),
				indexHingeOnFistLowLeftHandFullTurnPitched.getSymbol());
		indexHingeOnFistLowLeftHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-06-12"),
				indexHingeOnFistLowLeftHandFullTurnPitched.getSymbol());
		indexHingeOnFistLowLeftHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-06-13"),
				indexHingeOnFistLowLeftHandFullTurnPitched.getSymbol());
		indexHingeOnFistLowLeftHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-06-14"),
				indexHingeOnFistLowLeftHandFullTurnPitched.getSymbol());
		indexHingeOnFistLowLeftHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-06-15"),
				indexHingeOnFistLowLeftHandFullTurnPitched.getSymbol());
		indexHingeOnFistLowLeftHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-06-16"),
				indexHingeOnFistLowLeftHandFullTurnPitched.getSymbol());
		indexHingeOnFistLowLeftHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-06-09"),
				indexHingeOnFistLowLeftHandFullTurnPitched.getSymbol());

		indexHingeOnCircleRightHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-01-08"), indexHingeOnCircleRightHand.getSymbol());
		indexHingeOnCircleRightHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-01-07"), indexHingeOnCircleRightHand.getSymbol());
		indexHingeOnCircleRightHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-01-06"), indexHingeOnCircleRightHand.getSymbol());
		indexHingeOnCircleRightHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-01-05"), indexHingeOnCircleRightHand.getSymbol());
		indexHingeOnCircleRightHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-01-04"), indexHingeOnCircleRightHand.getSymbol());
		indexHingeOnCircleRightHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-01-03"), indexHingeOnCircleRightHand.getSymbol());
		indexHingeOnCircleRightHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-01-02"), indexHingeOnCircleRightHand.getSymbol());
		indexHingeOnCircleRightHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-01-01"), indexHingeOnCircleRightHand.getSymbol());

		indexHingeOnCircleLeftHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-01-10"), indexHingeOnCircleLeftHand.getSymbol());
		indexHingeOnCircleLeftHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-01-11"), indexHingeOnCircleLeftHand.getSymbol());
		indexHingeOnCircleLeftHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-01-12"), indexHingeOnCircleLeftHand.getSymbol());
		indexHingeOnCircleLeftHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-01-13"), indexHingeOnCircleLeftHand.getSymbol());
		indexHingeOnCircleLeftHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-01-14"), indexHingeOnCircleLeftHand.getSymbol());
		indexHingeOnCircleLeftHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-01-15"), indexHingeOnCircleLeftHand.getSymbol());
		indexHingeOnCircleLeftHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-01-16"), indexHingeOnCircleLeftHand.getSymbol());
		indexHingeOnCircleLeftHand.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-01-09"), indexHingeOnCircleLeftHand.getSymbol());

		indexHingeOnCircleRightHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-02-08"), indexHingeOnCircleRightHandHalfTurn.getSymbol());
		indexHingeOnCircleRightHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-02-07"), indexHingeOnCircleRightHandHalfTurn.getSymbol());
		indexHingeOnCircleRightHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-02-06"), indexHingeOnCircleRightHandHalfTurn.getSymbol());
		indexHingeOnCircleRightHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-02-05"), indexHingeOnCircleRightHandHalfTurn.getSymbol());
		indexHingeOnCircleRightHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-02-04"), indexHingeOnCircleRightHandHalfTurn.getSymbol());
		indexHingeOnCircleRightHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-02-03"), indexHingeOnCircleRightHandHalfTurn.getSymbol());
		indexHingeOnCircleRightHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-02-02"), indexHingeOnCircleRightHandHalfTurn.getSymbol());
		indexHingeOnCircleRightHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-02-01"), indexHingeOnCircleRightHandHalfTurn.getSymbol());

		indexHingeOnCircleLeftHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-02-10"), indexHingeOnCircleLeftHandHalfTurn.getSymbol());
		indexHingeOnCircleLeftHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-02-11"), indexHingeOnCircleLeftHandHalfTurn.getSymbol());
		indexHingeOnCircleLeftHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-02-12"), indexHingeOnCircleLeftHandHalfTurn.getSymbol());
		indexHingeOnCircleLeftHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-02-13"), indexHingeOnCircleLeftHandHalfTurn.getSymbol());
		indexHingeOnCircleLeftHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-02-14"), indexHingeOnCircleLeftHandHalfTurn.getSymbol());
		indexHingeOnCircleLeftHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-02-15"), indexHingeOnCircleLeftHandHalfTurn.getSymbol());
		indexHingeOnCircleLeftHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-02-16"), indexHingeOnCircleLeftHandHalfTurn.getSymbol());
		indexHingeOnCircleLeftHandHalfTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-02-09"), indexHingeOnCircleLeftHandHalfTurn.getSymbol());

		indexHingeOnCircleRightHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-03-08"), indexHingeOnCircleRightHandFullTurn.getSymbol());
		indexHingeOnCircleRightHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-03-07"), indexHingeOnCircleRightHandFullTurn.getSymbol());
		indexHingeOnCircleRightHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-03-06"), indexHingeOnCircleRightHandFullTurn.getSymbol());
		indexHingeOnCircleRightHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-03-05"), indexHingeOnCircleRightHandFullTurn.getSymbol());
		indexHingeOnCircleRightHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-03-04"), indexHingeOnCircleRightHandFullTurn.getSymbol());
		indexHingeOnCircleRightHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-03-03"), indexHingeOnCircleRightHandFullTurn.getSymbol());
		indexHingeOnCircleRightHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-03-02"), indexHingeOnCircleRightHandFullTurn.getSymbol());
		indexHingeOnCircleRightHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-03-01"), indexHingeOnCircleRightHandFullTurn.getSymbol());

		indexHingeOnCircleLeftHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-03-10"), indexHingeOnCircleLeftHandFullTurn.getSymbol());
		indexHingeOnCircleLeftHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-03-11"), indexHingeOnCircleLeftHandFullTurn.getSymbol());
		indexHingeOnCircleLeftHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-03-12"), indexHingeOnCircleLeftHandFullTurn.getSymbol());
		indexHingeOnCircleLeftHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-03-13"), indexHingeOnCircleLeftHandFullTurn.getSymbol());
		indexHingeOnCircleLeftHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-03-14"), indexHingeOnCircleLeftHandFullTurn.getSymbol());
		indexHingeOnCircleLeftHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-03-15"), indexHingeOnCircleLeftHandFullTurn.getSymbol());
		indexHingeOnCircleLeftHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-03-16"), indexHingeOnCircleLeftHandFullTurn.getSymbol());
		indexHingeOnCircleLeftHandFullTurn.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-03-09"), indexHingeOnCircleLeftHandFullTurn.getSymbol());

		indexHingeOnCircleRightHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-04-08"), indexHingeOnCircleRightHandPitched.getSymbol());
		indexHingeOnCircleRightHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-04-07"), indexHingeOnCircleRightHandPitched.getSymbol());
		indexHingeOnCircleRightHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-04-06"), indexHingeOnCircleRightHandPitched.getSymbol());
		indexHingeOnCircleRightHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-04-05"), indexHingeOnCircleRightHandPitched.getSymbol());
		indexHingeOnCircleRightHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-04-04"), indexHingeOnCircleRightHandPitched.getSymbol());
		indexHingeOnCircleRightHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-04-03"), indexHingeOnCircleRightHandPitched.getSymbol());
		indexHingeOnCircleRightHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-04-02"), indexHingeOnCircleRightHandPitched.getSymbol());
		indexHingeOnCircleRightHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-04-01"), indexHingeOnCircleRightHandPitched.getSymbol());

		indexHingeOnCircleLeftHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-04-10"), indexHingeOnCircleLeftHandPitched.getSymbol());
		indexHingeOnCircleLeftHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-04-11"), indexHingeOnCircleLeftHandPitched.getSymbol());
		indexHingeOnCircleLeftHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-04-12"), indexHingeOnCircleLeftHandPitched.getSymbol());
		indexHingeOnCircleLeftHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-04-13"), indexHingeOnCircleLeftHandPitched.getSymbol());
		indexHingeOnCircleLeftHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-04-14"), indexHingeOnCircleLeftHandPitched.getSymbol());
		indexHingeOnCircleLeftHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-04-15"), indexHingeOnCircleLeftHandPitched.getSymbol());
		indexHingeOnCircleLeftHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-04-16"), indexHingeOnCircleLeftHandPitched.getSymbol());
		indexHingeOnCircleLeftHandPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-04-09"), indexHingeOnCircleLeftHandPitched.getSymbol());

		indexHingeOnCircleRightHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-05-08"),
				indexHingeOnCircleRightHandHalfTurnPitched.getSymbol());
		indexHingeOnCircleRightHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-05-07"),
				indexHingeOnCircleRightHandHalfTurnPitched.getSymbol());
		indexHingeOnCircleRightHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-05-06"),
				indexHingeOnCircleRightHandHalfTurnPitched.getSymbol());
		indexHingeOnCircleRightHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-05-05"),
				indexHingeOnCircleRightHandHalfTurnPitched.getSymbol());
		indexHingeOnCircleRightHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-05-04"),
				indexHingeOnCircleRightHandHalfTurnPitched.getSymbol());
		indexHingeOnCircleRightHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-05-03"),
				indexHingeOnCircleRightHandHalfTurnPitched.getSymbol());
		indexHingeOnCircleRightHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-05-02"),
				indexHingeOnCircleRightHandHalfTurnPitched.getSymbol());
		indexHingeOnCircleRightHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-05-01"),
				indexHingeOnCircleRightHandHalfTurnPitched.getSymbol());

		indexHingeOnCircleLeftHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-05-10"),
				indexHingeOnCircleLeftHandHalfTurnPitched.getSymbol());
		indexHingeOnCircleLeftHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-05-11"),
				indexHingeOnCircleLeftHandHalfTurnPitched.getSymbol());
		indexHingeOnCircleLeftHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-05-12"),
				indexHingeOnCircleLeftHandHalfTurnPitched.getSymbol());
		indexHingeOnCircleLeftHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-05-13"),
				indexHingeOnCircleLeftHandHalfTurnPitched.getSymbol());
		indexHingeOnCircleLeftHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-05-14"),
				indexHingeOnCircleLeftHandHalfTurnPitched.getSymbol());
		indexHingeOnCircleLeftHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-05-15"),
				indexHingeOnCircleLeftHandHalfTurnPitched.getSymbol());
		indexHingeOnCircleLeftHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-05-16"),
				indexHingeOnCircleLeftHandHalfTurnPitched.getSymbol());
		indexHingeOnCircleLeftHandHalfTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-05-09"),
				indexHingeOnCircleLeftHandHalfTurnPitched.getSymbol());

		indexHingeOnCircleRightHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-06-08"),
				indexHingeOnCircleRightHandFullTurnPitched.getSymbol());
		indexHingeOnCircleRightHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-06-07"),
				indexHingeOnCircleRightHandFullTurnPitched.getSymbol());
		indexHingeOnCircleRightHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-06-06"),
				indexHingeOnCircleRightHandFullTurnPitched.getSymbol());
		indexHingeOnCircleRightHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-06-05"),
				indexHingeOnCircleRightHandFullTurnPitched.getSymbol());
		indexHingeOnCircleRightHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-06-04"),
				indexHingeOnCircleRightHandFullTurnPitched.getSymbol());
		indexHingeOnCircleRightHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-06-03"),
				indexHingeOnCircleRightHandFullTurnPitched.getSymbol());
		indexHingeOnCircleRightHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-06-02"),
				indexHingeOnCircleRightHandFullTurnPitched.getSymbol());
		indexHingeOnCircleRightHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-06-01"),
				indexHingeOnCircleRightHandFullTurnPitched.getSymbol());

		indexHingeOnCircleLeftHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-06-10"),
				indexHingeOnCircleLeftHandFullTurnPitched.getSymbol());
		indexHingeOnCircleLeftHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-06-11"),
				indexHingeOnCircleLeftHandFullTurnPitched.getSymbol());
		indexHingeOnCircleLeftHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-06-12"),
				indexHingeOnCircleLeftHandFullTurnPitched.getSymbol());
		indexHingeOnCircleLeftHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-06-13"),
				indexHingeOnCircleLeftHandFullTurnPitched.getSymbol());
		indexHingeOnCircleLeftHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-06-14"),
				indexHingeOnCircleLeftHandFullTurnPitched.getSymbol());
		indexHingeOnCircleLeftHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-06-15"),
				indexHingeOnCircleLeftHandFullTurnPitched.getSymbol());
		indexHingeOnCircleLeftHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-06-16"),
				indexHingeOnCircleLeftHandFullTurnPitched.getSymbol());
		indexHingeOnCircleLeftHandFullTurnPitched.rotateClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-06-09"),
				indexHingeOnCircleLeftHandFullTurnPitched.getSymbol());

	}

	@Override
	public void testRotateCounterClockwise() {

		indexRightHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-01-02"), indexRightHand.getSymbol());
		indexRightHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-01-03"), indexRightHand.getSymbol());
		indexRightHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-01-04"), indexRightHand.getSymbol());
		indexRightHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-01-05"), indexRightHand.getSymbol());
		indexRightHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-01-06"), indexRightHand.getSymbol());
		indexRightHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-01-07"), indexRightHand.getSymbol());
		indexRightHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-01-08"), indexRightHand.getSymbol());
		indexRightHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-01-01"), indexRightHand.getSymbol());

		indexLeftHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-01-16"), indexLeftHand.getSymbol());
		indexLeftHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-01-15"), indexLeftHand.getSymbol());
		indexLeftHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-01-14"), indexLeftHand.getSymbol());
		indexLeftHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-01-13"), indexLeftHand.getSymbol());
		indexLeftHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-01-12"), indexLeftHand.getSymbol());
		indexLeftHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-01-11"), indexLeftHand.getSymbol());
		indexLeftHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-01-10"), indexLeftHand.getSymbol());
		indexLeftHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-01-09"), indexLeftHand.getSymbol());

		indexRightHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-02-02"), indexRightHandHalfTurn.getSymbol());
		indexRightHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-02-03"), indexRightHandHalfTurn.getSymbol());
		indexRightHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-02-04"), indexRightHandHalfTurn.getSymbol());
		indexRightHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-02-05"), indexRightHandHalfTurn.getSymbol());
		indexRightHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-02-06"), indexRightHandHalfTurn.getSymbol());
		indexRightHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-02-07"), indexRightHandHalfTurn.getSymbol());
		indexRightHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-02-08"), indexRightHandHalfTurn.getSymbol());
		indexRightHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-02-01"), indexRightHandHalfTurn.getSymbol());

		indexLeftHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-02-16"), indexLeftHandHalfTurn.getSymbol());
		indexLeftHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-02-15"), indexLeftHandHalfTurn.getSymbol());
		indexLeftHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-02-14"), indexLeftHandHalfTurn.getSymbol());
		indexLeftHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-02-13"), indexLeftHandHalfTurn.getSymbol());
		indexLeftHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-02-12"), indexLeftHandHalfTurn.getSymbol());
		indexLeftHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-02-11"), indexLeftHandHalfTurn.getSymbol());
		indexLeftHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-02-10"), indexLeftHandHalfTurn.getSymbol());
		indexLeftHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-02-09"), indexLeftHandHalfTurn.getSymbol());

		indexRightHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-03-02"), indexRightHandFullTurn.getSymbol());
		indexRightHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-03-03"), indexRightHandFullTurn.getSymbol());
		indexRightHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-03-04"), indexRightHandFullTurn.getSymbol());
		indexRightHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-03-05"), indexRightHandFullTurn.getSymbol());
		indexRightHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-03-06"), indexRightHandFullTurn.getSymbol());
		indexRightHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-03-07"), indexRightHandFullTurn.getSymbol());
		indexRightHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-03-08"), indexRightHandFullTurn.getSymbol());
		indexRightHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-03-01"), indexRightHandFullTurn.getSymbol());

		indexLeftHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-03-16"), indexLeftHandFullTurn.getSymbol());
		indexLeftHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-03-15"), indexLeftHandFullTurn.getSymbol());
		indexLeftHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-03-14"), indexLeftHandFullTurn.getSymbol());
		indexLeftHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-03-13"), indexLeftHandFullTurn.getSymbol());
		indexLeftHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-03-12"), indexLeftHandFullTurn.getSymbol());
		indexLeftHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-03-11"), indexLeftHandFullTurn.getSymbol());
		indexLeftHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-03-10"), indexLeftHandFullTurn.getSymbol());
		indexLeftHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-03-09"), indexLeftHandFullTurn.getSymbol());

		indexRightHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-04-02"), indexRightHandPitched.getSymbol());
		indexRightHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-04-03"), indexRightHandPitched.getSymbol());
		indexRightHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-04-04"), indexRightHandPitched.getSymbol());
		indexRightHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-04-05"), indexRightHandPitched.getSymbol());
		indexRightHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-04-06"), indexRightHandPitched.getSymbol());
		indexRightHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-04-07"), indexRightHandPitched.getSymbol());
		indexRightHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-04-08"), indexRightHandPitched.getSymbol());
		indexRightHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-04-01"), indexRightHandPitched.getSymbol());

		indexLeftHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-04-16"), indexLeftHandPitched.getSymbol());
		indexLeftHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-04-15"), indexLeftHandPitched.getSymbol());
		indexLeftHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-04-14"), indexLeftHandPitched.getSymbol());
		indexLeftHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-04-13"), indexLeftHandPitched.getSymbol());
		indexLeftHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-04-12"), indexLeftHandPitched.getSymbol());
		indexLeftHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-04-11"), indexLeftHandPitched.getSymbol());
		indexLeftHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-04-10"), indexLeftHandPitched.getSymbol());
		indexLeftHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-04-09"), indexLeftHandPitched.getSymbol());

		indexRightHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-05-02"), indexRightHandHalfTurnPitched.getSymbol());
		indexRightHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-05-03"), indexRightHandHalfTurnPitched.getSymbol());
		indexRightHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-05-04"), indexRightHandHalfTurnPitched.getSymbol());
		indexRightHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-05-05"), indexRightHandHalfTurnPitched.getSymbol());
		indexRightHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-05-06"), indexRightHandHalfTurnPitched.getSymbol());
		indexRightHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-05-07"), indexRightHandHalfTurnPitched.getSymbol());
		indexRightHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-05-08"), indexRightHandHalfTurnPitched.getSymbol());
		indexRightHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-05-01"), indexRightHandHalfTurnPitched.getSymbol());

		indexLeftHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-05-16"), indexLeftHandHalfTurnPitched.getSymbol());
		indexLeftHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-05-15"), indexLeftHandHalfTurnPitched.getSymbol());
		indexLeftHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-05-14"), indexLeftHandHalfTurnPitched.getSymbol());
		indexLeftHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-05-13"), indexLeftHandHalfTurnPitched.getSymbol());
		indexLeftHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-05-12"), indexLeftHandHalfTurnPitched.getSymbol());
		indexLeftHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-05-11"), indexLeftHandHalfTurnPitched.getSymbol());
		indexLeftHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-05-10"), indexLeftHandHalfTurnPitched.getSymbol());
		indexLeftHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-05-09"), indexLeftHandHalfTurnPitched.getSymbol());

		indexRightHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-06-02"), indexRightHandFullTurnPitched.getSymbol());
		indexRightHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-06-03"), indexRightHandFullTurnPitched.getSymbol());
		indexRightHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-06-04"), indexRightHandFullTurnPitched.getSymbol());
		indexRightHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-06-05"), indexRightHandFullTurnPitched.getSymbol());
		indexRightHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-06-06"), indexRightHandFullTurnPitched.getSymbol());
		indexRightHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-06-07"), indexRightHandFullTurnPitched.getSymbol());
		indexRightHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-06-08"), indexRightHandFullTurnPitched.getSymbol());
		indexRightHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-06-01"), indexRightHandFullTurnPitched.getSymbol());

		indexLeftHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-06-16"), indexLeftHandFullTurnPitched.getSymbol());
		indexLeftHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-06-15"), indexLeftHandFullTurnPitched.getSymbol());
		indexLeftHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-06-14"), indexLeftHandFullTurnPitched.getSymbol());
		indexLeftHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-06-13"), indexLeftHandFullTurnPitched.getSymbol());
		indexLeftHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-06-12"), indexLeftHandFullTurnPitched.getSymbol());
		indexLeftHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-06-11"), indexLeftHandFullTurnPitched.getSymbol());
		indexLeftHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-06-10"), indexLeftHandFullTurnPitched.getSymbol());
		indexLeftHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-06-09"), indexLeftHandFullTurnPitched.getSymbol());

		indexOnCircleRightHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-01-02"), indexOnCircleRightHand.getSymbol());
		indexOnCircleRightHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-01-03"), indexOnCircleRightHand.getSymbol());
		indexOnCircleRightHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-01-04"), indexOnCircleRightHand.getSymbol());
		indexOnCircleRightHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-01-05"), indexOnCircleRightHand.getSymbol());
		indexOnCircleRightHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-01-06"), indexOnCircleRightHand.getSymbol());
		indexOnCircleRightHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-01-07"), indexOnCircleRightHand.getSymbol());
		indexOnCircleRightHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-01-08"), indexOnCircleRightHand.getSymbol());
		indexOnCircleRightHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-01-01"), indexOnCircleRightHand.getSymbol());

		indexOnCircleLeftHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-01-16"), indexOnCircleLeftHand.getSymbol());
		indexOnCircleLeftHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-01-15"), indexOnCircleLeftHand.getSymbol());
		indexOnCircleLeftHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-01-14"), indexOnCircleLeftHand.getSymbol());
		indexOnCircleLeftHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-01-13"), indexOnCircleLeftHand.getSymbol());
		indexOnCircleLeftHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-01-12"), indexOnCircleLeftHand.getSymbol());
		indexOnCircleLeftHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-01-11"), indexOnCircleLeftHand.getSymbol());
		indexOnCircleLeftHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-01-10"), indexOnCircleLeftHand.getSymbol());
		indexOnCircleLeftHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-01-09"), indexOnCircleLeftHand.getSymbol());

		indexOnCircleRightHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-02-02"), indexOnCircleRightHandHalfTurn.getSymbol());
		indexOnCircleRightHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-02-03"), indexOnCircleRightHandHalfTurn.getSymbol());
		indexOnCircleRightHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-02-04"), indexOnCircleRightHandHalfTurn.getSymbol());
		indexOnCircleRightHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-02-05"), indexOnCircleRightHandHalfTurn.getSymbol());
		indexOnCircleRightHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-02-06"), indexOnCircleRightHandHalfTurn.getSymbol());
		indexOnCircleRightHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-02-07"), indexOnCircleRightHandHalfTurn.getSymbol());
		indexOnCircleRightHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-02-08"), indexOnCircleRightHandHalfTurn.getSymbol());
		indexOnCircleRightHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-02-01"), indexOnCircleRightHandHalfTurn.getSymbol());

		indexOnCircleLeftHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-02-16"), indexOnCircleLeftHandHalfTurn.getSymbol());
		indexOnCircleLeftHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-02-15"), indexOnCircleLeftHandHalfTurn.getSymbol());
		indexOnCircleLeftHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-02-14"), indexOnCircleLeftHandHalfTurn.getSymbol());
		indexOnCircleLeftHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-02-13"), indexOnCircleLeftHandHalfTurn.getSymbol());
		indexOnCircleLeftHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-02-12"), indexOnCircleLeftHandHalfTurn.getSymbol());
		indexOnCircleLeftHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-02-11"), indexOnCircleLeftHandHalfTurn.getSymbol());
		indexOnCircleLeftHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-02-10"), indexOnCircleLeftHandHalfTurn.getSymbol());
		indexOnCircleLeftHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-02-09"), indexOnCircleLeftHandHalfTurn.getSymbol());

		indexOnCircleRightHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-03-02"), indexOnCircleRightHandFullTurn.getSymbol());
		indexOnCircleRightHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-03-03"), indexOnCircleRightHandFullTurn.getSymbol());
		indexOnCircleRightHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-03-04"), indexOnCircleRightHandFullTurn.getSymbol());
		indexOnCircleRightHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-03-05"), indexOnCircleRightHandFullTurn.getSymbol());
		indexOnCircleRightHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-03-06"), indexOnCircleRightHandFullTurn.getSymbol());
		indexOnCircleRightHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-03-07"), indexOnCircleRightHandFullTurn.getSymbol());
		indexOnCircleRightHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-03-08"), indexOnCircleRightHandFullTurn.getSymbol());
		indexOnCircleRightHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-03-01"), indexOnCircleRightHandFullTurn.getSymbol());

		indexOnCircleLeftHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-03-16"), indexOnCircleLeftHandFullTurn.getSymbol());
		indexOnCircleLeftHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-03-15"), indexOnCircleLeftHandFullTurn.getSymbol());
		indexOnCircleLeftHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-03-14"), indexOnCircleLeftHandFullTurn.getSymbol());
		indexOnCircleLeftHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-03-13"), indexOnCircleLeftHandFullTurn.getSymbol());
		indexOnCircleLeftHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-03-12"), indexOnCircleLeftHandFullTurn.getSymbol());
		indexOnCircleLeftHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-03-11"), indexOnCircleLeftHandFullTurn.getSymbol());
		indexOnCircleLeftHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-03-10"), indexOnCircleLeftHandFullTurn.getSymbol());
		indexOnCircleLeftHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-03-09"), indexOnCircleLeftHandFullTurn.getSymbol());

		indexOnCircleRightHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-04-02"), indexOnCircleRightHandPitched.getSymbol());
		indexOnCircleRightHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-04-03"), indexOnCircleRightHandPitched.getSymbol());
		indexOnCircleRightHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-04-04"), indexOnCircleRightHandPitched.getSymbol());
		indexOnCircleRightHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-04-05"), indexOnCircleRightHandPitched.getSymbol());
		indexOnCircleRightHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-04-06"), indexOnCircleRightHandPitched.getSymbol());
		indexOnCircleRightHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-04-07"), indexOnCircleRightHandPitched.getSymbol());
		indexOnCircleRightHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-04-08"), indexOnCircleRightHandPitched.getSymbol());
		indexOnCircleRightHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-04-01"), indexOnCircleRightHandPitched.getSymbol());

		indexOnCircleLeftHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-04-16"), indexOnCircleLeftHandPitched.getSymbol());
		indexOnCircleLeftHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-04-15"), indexOnCircleLeftHandPitched.getSymbol());
		indexOnCircleLeftHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-04-14"), indexOnCircleLeftHandPitched.getSymbol());
		indexOnCircleLeftHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-04-13"), indexOnCircleLeftHandPitched.getSymbol());
		indexOnCircleLeftHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-04-12"), indexOnCircleLeftHandPitched.getSymbol());
		indexOnCircleLeftHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-04-11"), indexOnCircleLeftHandPitched.getSymbol());
		indexOnCircleLeftHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-04-10"), indexOnCircleLeftHandPitched.getSymbol());
		indexOnCircleLeftHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-04-09"), indexOnCircleLeftHandPitched.getSymbol());

		indexOnCircleRightHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-05-02"),
				indexOnCircleRightHandHalfTurnPitched.getSymbol());
		indexOnCircleRightHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-05-03"),
				indexOnCircleRightHandHalfTurnPitched.getSymbol());
		indexOnCircleRightHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-05-04"),
				indexOnCircleRightHandHalfTurnPitched.getSymbol());
		indexOnCircleRightHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-05-05"),
				indexOnCircleRightHandHalfTurnPitched.getSymbol());
		indexOnCircleRightHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-05-06"),
				indexOnCircleRightHandHalfTurnPitched.getSymbol());
		indexOnCircleRightHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-05-07"),
				indexOnCircleRightHandHalfTurnPitched.getSymbol());
		indexOnCircleRightHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-05-08"),
				indexOnCircleRightHandHalfTurnPitched.getSymbol());
		indexOnCircleRightHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-05-01"),
				indexOnCircleRightHandHalfTurnPitched.getSymbol());

		indexOnCircleLeftHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-05-16"),
				indexOnCircleLeftHandHalfTurnPitched.getSymbol());
		indexOnCircleLeftHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-05-15"),
				indexOnCircleLeftHandHalfTurnPitched.getSymbol());
		indexOnCircleLeftHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-05-14"),
				indexOnCircleLeftHandHalfTurnPitched.getSymbol());
		indexOnCircleLeftHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-05-13"),
				indexOnCircleLeftHandHalfTurnPitched.getSymbol());
		indexOnCircleLeftHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-05-12"),
				indexOnCircleLeftHandHalfTurnPitched.getSymbol());
		indexOnCircleLeftHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-05-11"),
				indexOnCircleLeftHandHalfTurnPitched.getSymbol());
		indexOnCircleLeftHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-05-10"),
				indexOnCircleLeftHandHalfTurnPitched.getSymbol());
		indexOnCircleLeftHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-05-09"),
				indexOnCircleLeftHandHalfTurnPitched.getSymbol());

		indexOnCircleRightHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-06-02"),
				indexOnCircleRightHandFullTurnPitched.getSymbol());
		indexOnCircleRightHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-06-03"),
				indexOnCircleRightHandFullTurnPitched.getSymbol());
		indexOnCircleRightHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-06-04"),
				indexOnCircleRightHandFullTurnPitched.getSymbol());
		indexOnCircleRightHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-06-05"),
				indexOnCircleRightHandFullTurnPitched.getSymbol());
		indexOnCircleRightHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-06-06"),
				indexOnCircleRightHandFullTurnPitched.getSymbol());
		indexOnCircleRightHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-06-07"),
				indexOnCircleRightHandFullTurnPitched.getSymbol());
		indexOnCircleRightHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-06-08"),
				indexOnCircleRightHandFullTurnPitched.getSymbol());
		indexOnCircleRightHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-06-01"),
				indexOnCircleRightHandFullTurnPitched.getSymbol());

		indexOnCircleLeftHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-06-16"),
				indexOnCircleLeftHandFullTurnPitched.getSymbol());
		indexOnCircleLeftHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-06-15"),
				indexOnCircleLeftHandFullTurnPitched.getSymbol());
		indexOnCircleLeftHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-06-14"),
				indexOnCircleLeftHandFullTurnPitched.getSymbol());
		indexOnCircleLeftHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-06-13"),
				indexOnCircleLeftHandFullTurnPitched.getSymbol());
		indexOnCircleLeftHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-06-12"),
				indexOnCircleLeftHandFullTurnPitched.getSymbol());
		indexOnCircleLeftHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-06-11"),
				indexOnCircleLeftHandFullTurnPitched.getSymbol());
		indexOnCircleLeftHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-06-10"),
				indexOnCircleLeftHandFullTurnPitched.getSymbol());
		indexOnCircleLeftHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-06-09"),
				indexOnCircleLeftHandFullTurnPitched.getSymbol());

		indexOnCupRightHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-01-02"), indexOnCupRightHand.getSymbol());
		indexOnCupRightHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-01-03"), indexOnCupRightHand.getSymbol());
		indexOnCupRightHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-01-04"), indexOnCupRightHand.getSymbol());
		indexOnCupRightHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-01-05"), indexOnCupRightHand.getSymbol());
		indexOnCupRightHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-01-06"), indexOnCupRightHand.getSymbol());
		indexOnCupRightHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-01-07"), indexOnCupRightHand.getSymbol());
		indexOnCupRightHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-01-08"), indexOnCupRightHand.getSymbol());
		indexOnCupRightHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-01-01"), indexOnCupRightHand.getSymbol());

		indexOnCupLeftHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-01-16"), indexOnCupLeftHand.getSymbol());
		indexOnCupLeftHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-01-15"), indexOnCupLeftHand.getSymbol());
		indexOnCupLeftHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-01-14"), indexOnCupLeftHand.getSymbol());
		indexOnCupLeftHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-01-13"), indexOnCupLeftHand.getSymbol());
		indexOnCupLeftHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-01-12"), indexOnCupLeftHand.getSymbol());
		indexOnCupLeftHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-01-11"), indexOnCupLeftHand.getSymbol());
		indexOnCupLeftHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-01-10"), indexOnCupLeftHand.getSymbol());
		indexOnCupLeftHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-01-09"), indexOnCupLeftHand.getSymbol());

		indexOnCupRightHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-02-02"), indexOnCupRightHandHalfTurn.getSymbol());
		indexOnCupRightHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-02-03"), indexOnCupRightHandHalfTurn.getSymbol());
		indexOnCupRightHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-02-04"), indexOnCupRightHandHalfTurn.getSymbol());
		indexOnCupRightHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-02-05"), indexOnCupRightHandHalfTurn.getSymbol());
		indexOnCupRightHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-02-06"), indexOnCupRightHandHalfTurn.getSymbol());
		indexOnCupRightHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-02-07"), indexOnCupRightHandHalfTurn.getSymbol());
		indexOnCupRightHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-02-08"), indexOnCupRightHandHalfTurn.getSymbol());
		indexOnCupRightHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-02-01"), indexOnCupRightHandHalfTurn.getSymbol());

		indexOnCupLeftHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-02-16"), indexOnCupLeftHandHalfTurn.getSymbol());
		indexOnCupLeftHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-02-15"), indexOnCupLeftHandHalfTurn.getSymbol());
		indexOnCupLeftHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-02-14"), indexOnCupLeftHandHalfTurn.getSymbol());
		indexOnCupLeftHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-02-13"), indexOnCupLeftHandHalfTurn.getSymbol());
		indexOnCupLeftHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-02-12"), indexOnCupLeftHandHalfTurn.getSymbol());
		indexOnCupLeftHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-02-11"), indexOnCupLeftHandHalfTurn.getSymbol());
		indexOnCupLeftHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-02-10"), indexOnCupLeftHandHalfTurn.getSymbol());
		indexOnCupLeftHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-02-09"), indexOnCupLeftHandHalfTurn.getSymbol());

		indexOnCupRightHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-03-02"), indexOnCupRightHandFullTurn.getSymbol());
		indexOnCupRightHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-03-03"), indexOnCupRightHandFullTurn.getSymbol());
		indexOnCupRightHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-03-04"), indexOnCupRightHandFullTurn.getSymbol());
		indexOnCupRightHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-03-05"), indexOnCupRightHandFullTurn.getSymbol());
		indexOnCupRightHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-03-06"), indexOnCupRightHandFullTurn.getSymbol());
		indexOnCupRightHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-03-07"), indexOnCupRightHandFullTurn.getSymbol());
		indexOnCupRightHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-03-08"), indexOnCupRightHandFullTurn.getSymbol());
		indexOnCupRightHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-03-01"), indexOnCupRightHandFullTurn.getSymbol());

		indexOnCupLeftHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-03-16"), indexOnCupLeftHandFullTurn.getSymbol());
		indexOnCupLeftHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-03-15"), indexOnCupLeftHandFullTurn.getSymbol());
		indexOnCupLeftHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-03-14"), indexOnCupLeftHandFullTurn.getSymbol());
		indexOnCupLeftHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-03-13"), indexOnCupLeftHandFullTurn.getSymbol());
		indexOnCupLeftHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-03-12"), indexOnCupLeftHandFullTurn.getSymbol());
		indexOnCupLeftHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-03-11"), indexOnCupLeftHandFullTurn.getSymbol());
		indexOnCupLeftHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-03-10"), indexOnCupLeftHandFullTurn.getSymbol());
		indexOnCupLeftHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-03-09"), indexOnCupLeftHandFullTurn.getSymbol());

		indexOnCupRightHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-04-02"), indexOnCupRightHandPitched.getSymbol());
		indexOnCupRightHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-04-03"), indexOnCupRightHandPitched.getSymbol());
		indexOnCupRightHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-04-04"), indexOnCupRightHandPitched.getSymbol());
		indexOnCupRightHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-04-05"), indexOnCupRightHandPitched.getSymbol());
		indexOnCupRightHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-04-06"), indexOnCupRightHandPitched.getSymbol());
		indexOnCupRightHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-04-07"), indexOnCupRightHandPitched.getSymbol());
		indexOnCupRightHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-04-08"), indexOnCupRightHandPitched.getSymbol());
		indexOnCupRightHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-04-01"), indexOnCupRightHandPitched.getSymbol());

		indexOnCupLeftHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-04-16"), indexOnCupLeftHandPitched.getSymbol());
		indexOnCupLeftHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-04-15"), indexOnCupLeftHandPitched.getSymbol());
		indexOnCupLeftHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-04-14"), indexOnCupLeftHandPitched.getSymbol());
		indexOnCupLeftHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-04-13"), indexOnCupLeftHandPitched.getSymbol());
		indexOnCupLeftHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-04-12"), indexOnCupLeftHandPitched.getSymbol());
		indexOnCupLeftHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-04-11"), indexOnCupLeftHandPitched.getSymbol());
		indexOnCupLeftHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-04-10"), indexOnCupLeftHandPitched.getSymbol());
		indexOnCupLeftHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-04-09"), indexOnCupLeftHandPitched.getSymbol());

		indexOnCupRightHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-05-02"), indexOnCupRightHandHalfTurnPitched.getSymbol());
		indexOnCupRightHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-05-03"), indexOnCupRightHandHalfTurnPitched.getSymbol());
		indexOnCupRightHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-05-04"), indexOnCupRightHandHalfTurnPitched.getSymbol());
		indexOnCupRightHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-05-05"), indexOnCupRightHandHalfTurnPitched.getSymbol());
		indexOnCupRightHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-05-06"), indexOnCupRightHandHalfTurnPitched.getSymbol());
		indexOnCupRightHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-05-07"), indexOnCupRightHandHalfTurnPitched.getSymbol());
		indexOnCupRightHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-05-08"), indexOnCupRightHandHalfTurnPitched.getSymbol());
		indexOnCupRightHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-05-01"), indexOnCupRightHandHalfTurnPitched.getSymbol());

		indexOnCupLeftHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-05-16"), indexOnCupLeftHandHalfTurnPitched.getSymbol());
		indexOnCupLeftHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-05-15"), indexOnCupLeftHandHalfTurnPitched.getSymbol());
		indexOnCupLeftHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-05-14"), indexOnCupLeftHandHalfTurnPitched.getSymbol());
		indexOnCupLeftHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-05-13"), indexOnCupLeftHandHalfTurnPitched.getSymbol());
		indexOnCupLeftHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-05-12"), indexOnCupLeftHandHalfTurnPitched.getSymbol());
		indexOnCupLeftHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-05-11"), indexOnCupLeftHandHalfTurnPitched.getSymbol());
		indexOnCupLeftHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-05-10"), indexOnCupLeftHandHalfTurnPitched.getSymbol());
		indexOnCupLeftHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-05-09"), indexOnCupLeftHandHalfTurnPitched.getSymbol());

		indexOnCupRightHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-06-02"), indexOnCupRightHandFullTurnPitched.getSymbol());
		indexOnCupRightHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-06-03"), indexOnCupRightHandFullTurnPitched.getSymbol());
		indexOnCupRightHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-06-04"), indexOnCupRightHandFullTurnPitched.getSymbol());
		indexOnCupRightHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-06-05"), indexOnCupRightHandFullTurnPitched.getSymbol());
		indexOnCupRightHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-06-06"), indexOnCupRightHandFullTurnPitched.getSymbol());
		indexOnCupRightHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-06-07"), indexOnCupRightHandFullTurnPitched.getSymbol());
		indexOnCupRightHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-06-08"), indexOnCupRightHandFullTurnPitched.getSymbol());
		indexOnCupRightHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-06-01"), indexOnCupRightHandFullTurnPitched.getSymbol());

		indexOnCupLeftHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-06-16"), indexOnCupLeftHandFullTurnPitched.getSymbol());
		indexOnCupLeftHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-06-15"), indexOnCupLeftHandFullTurnPitched.getSymbol());
		indexOnCupLeftHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-06-14"), indexOnCupLeftHandFullTurnPitched.getSymbol());
		indexOnCupLeftHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-06-13"), indexOnCupLeftHandFullTurnPitched.getSymbol());
		indexOnCupLeftHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-06-12"), indexOnCupLeftHandFullTurnPitched.getSymbol());
		indexOnCupLeftHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-06-11"), indexOnCupLeftHandFullTurnPitched.getSymbol());
		indexOnCupLeftHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-06-10"), indexOnCupLeftHandFullTurnPitched.getSymbol());
		indexOnCupLeftHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-06-09"), indexOnCupLeftHandFullTurnPitched.getSymbol());

		indexOnOvalRightHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-01-02"), indexOnOvalRightHand.getSymbol());
		indexOnOvalRightHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-01-03"), indexOnOvalRightHand.getSymbol());
		indexOnOvalRightHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-01-04"), indexOnOvalRightHand.getSymbol());
		indexOnOvalRightHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-01-05"), indexOnOvalRightHand.getSymbol());
		indexOnOvalRightHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-01-06"), indexOnOvalRightHand.getSymbol());
		indexOnOvalRightHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-01-07"), indexOnOvalRightHand.getSymbol());
		indexOnOvalRightHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-01-08"), indexOnOvalRightHand.getSymbol());
		indexOnOvalRightHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-01-01"), indexOnOvalRightHand.getSymbol());

		indexOnOvalLeftHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-01-16"), indexOnOvalLeftHand.getSymbol());
		indexOnOvalLeftHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-01-15"), indexOnOvalLeftHand.getSymbol());
		indexOnOvalLeftHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-01-14"), indexOnOvalLeftHand.getSymbol());
		indexOnOvalLeftHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-01-13"), indexOnOvalLeftHand.getSymbol());
		indexOnOvalLeftHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-01-12"), indexOnOvalLeftHand.getSymbol());
		indexOnOvalLeftHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-01-11"), indexOnOvalLeftHand.getSymbol());
		indexOnOvalLeftHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-01-10"), indexOnOvalLeftHand.getSymbol());
		indexOnOvalLeftHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-01-09"), indexOnOvalLeftHand.getSymbol());

		indexOnOvalRightHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-02-02"), indexOnOvalRightHandHalfTurn.getSymbol());
		indexOnOvalRightHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-02-03"), indexOnOvalRightHandHalfTurn.getSymbol());
		indexOnOvalRightHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-02-04"), indexOnOvalRightHandHalfTurn.getSymbol());
		indexOnOvalRightHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-02-05"), indexOnOvalRightHandHalfTurn.getSymbol());
		indexOnOvalRightHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-02-06"), indexOnOvalRightHandHalfTurn.getSymbol());
		indexOnOvalRightHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-02-07"), indexOnOvalRightHandHalfTurn.getSymbol());
		indexOnOvalRightHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-02-08"), indexOnOvalRightHandHalfTurn.getSymbol());
		indexOnOvalRightHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-02-01"), indexOnOvalRightHandHalfTurn.getSymbol());

		indexOnOvalLeftHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-02-16"), indexOnOvalLeftHandHalfTurn.getSymbol());
		indexOnOvalLeftHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-02-15"), indexOnOvalLeftHandHalfTurn.getSymbol());
		indexOnOvalLeftHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-02-14"), indexOnOvalLeftHandHalfTurn.getSymbol());
		indexOnOvalLeftHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-02-13"), indexOnOvalLeftHandHalfTurn.getSymbol());
		indexOnOvalLeftHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-02-12"), indexOnOvalLeftHandHalfTurn.getSymbol());
		indexOnOvalLeftHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-02-11"), indexOnOvalLeftHandHalfTurn.getSymbol());
		indexOnOvalLeftHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-02-10"), indexOnOvalLeftHandHalfTurn.getSymbol());
		indexOnOvalLeftHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-02-09"), indexOnOvalLeftHandHalfTurn.getSymbol());

		indexOnOvalRightHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-03-02"), indexOnOvalRightHandFullTurn.getSymbol());
		indexOnOvalRightHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-03-03"), indexOnOvalRightHandFullTurn.getSymbol());
		indexOnOvalRightHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-03-04"), indexOnOvalRightHandFullTurn.getSymbol());
		indexOnOvalRightHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-03-05"), indexOnOvalRightHandFullTurn.getSymbol());
		indexOnOvalRightHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-03-06"), indexOnOvalRightHandFullTurn.getSymbol());
		indexOnOvalRightHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-03-07"), indexOnOvalRightHandFullTurn.getSymbol());
		indexOnOvalRightHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-03-08"), indexOnOvalRightHandFullTurn.getSymbol());
		indexOnOvalRightHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-03-01"), indexOnOvalRightHandFullTurn.getSymbol());

		indexOnOvalLeftHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-03-16"), indexOnOvalLeftHandFullTurn.getSymbol());
		indexOnOvalLeftHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-03-15"), indexOnOvalLeftHandFullTurn.getSymbol());
		indexOnOvalLeftHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-03-14"), indexOnOvalLeftHandFullTurn.getSymbol());
		indexOnOvalLeftHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-03-13"), indexOnOvalLeftHandFullTurn.getSymbol());
		indexOnOvalLeftHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-03-12"), indexOnOvalLeftHandFullTurn.getSymbol());
		indexOnOvalLeftHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-03-11"), indexOnOvalLeftHandFullTurn.getSymbol());
		indexOnOvalLeftHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-03-10"), indexOnOvalLeftHandFullTurn.getSymbol());
		indexOnOvalLeftHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-03-09"), indexOnOvalLeftHandFullTurn.getSymbol());

		indexOnOvalRightHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-04-02"), indexOnOvalRightHandPitched.getSymbol());
		indexOnOvalRightHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-04-03"), indexOnOvalRightHandPitched.getSymbol());
		indexOnOvalRightHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-04-04"), indexOnOvalRightHandPitched.getSymbol());
		indexOnOvalRightHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-04-05"), indexOnOvalRightHandPitched.getSymbol());
		indexOnOvalRightHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-04-06"), indexOnOvalRightHandPitched.getSymbol());
		indexOnOvalRightHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-04-07"), indexOnOvalRightHandPitched.getSymbol());
		indexOnOvalRightHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-04-08"), indexOnOvalRightHandPitched.getSymbol());
		indexOnOvalRightHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-04-01"), indexOnOvalRightHandPitched.getSymbol());

		indexOnOvalLeftHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-04-16"), indexOnOvalLeftHandPitched.getSymbol());
		indexOnOvalLeftHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-04-15"), indexOnOvalLeftHandPitched.getSymbol());
		indexOnOvalLeftHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-04-14"), indexOnOvalLeftHandPitched.getSymbol());
		indexOnOvalLeftHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-04-13"), indexOnOvalLeftHandPitched.getSymbol());
		indexOnOvalLeftHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-04-12"), indexOnOvalLeftHandPitched.getSymbol());
		indexOnOvalLeftHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-04-11"), indexOnOvalLeftHandPitched.getSymbol());
		indexOnOvalLeftHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-04-10"), indexOnOvalLeftHandPitched.getSymbol());
		indexOnOvalLeftHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-04-09"), indexOnOvalLeftHandPitched.getSymbol());

		indexOnOvalRightHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-05-02"), indexOnOvalRightHandHalfTurnPitched.getSymbol());
		indexOnOvalRightHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-05-03"), indexOnOvalRightHandHalfTurnPitched.getSymbol());
		indexOnOvalRightHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-05-04"), indexOnOvalRightHandHalfTurnPitched.getSymbol());
		indexOnOvalRightHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-05-05"), indexOnOvalRightHandHalfTurnPitched.getSymbol());
		indexOnOvalRightHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-05-06"), indexOnOvalRightHandHalfTurnPitched.getSymbol());
		indexOnOvalRightHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-05-07"), indexOnOvalRightHandHalfTurnPitched.getSymbol());
		indexOnOvalRightHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-05-08"), indexOnOvalRightHandHalfTurnPitched.getSymbol());
		indexOnOvalRightHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-05-01"), indexOnOvalRightHandHalfTurnPitched.getSymbol());

		indexOnOvalLeftHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-05-16"), indexOnOvalLeftHandHalfTurnPitched.getSymbol());
		indexOnOvalLeftHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-05-15"), indexOnOvalLeftHandHalfTurnPitched.getSymbol());
		indexOnOvalLeftHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-05-14"), indexOnOvalLeftHandHalfTurnPitched.getSymbol());
		indexOnOvalLeftHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-05-13"), indexOnOvalLeftHandHalfTurnPitched.getSymbol());
		indexOnOvalLeftHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-05-12"), indexOnOvalLeftHandHalfTurnPitched.getSymbol());
		indexOnOvalLeftHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-05-11"), indexOnOvalLeftHandHalfTurnPitched.getSymbol());
		indexOnOvalLeftHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-05-10"), indexOnOvalLeftHandHalfTurnPitched.getSymbol());
		indexOnOvalLeftHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-05-09"), indexOnOvalLeftHandHalfTurnPitched.getSymbol());

		indexOnOvalRightHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-06-02"), indexOnOvalRightHandFullTurnPitched.getSymbol());
		indexOnOvalRightHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-06-03"), indexOnOvalRightHandFullTurnPitched.getSymbol());
		indexOnOvalRightHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-06-04"), indexOnOvalRightHandFullTurnPitched.getSymbol());
		indexOnOvalRightHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-06-05"), indexOnOvalRightHandFullTurnPitched.getSymbol());
		indexOnOvalRightHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-06-06"), indexOnOvalRightHandFullTurnPitched.getSymbol());
		indexOnOvalRightHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-06-07"), indexOnOvalRightHandFullTurnPitched.getSymbol());
		indexOnOvalRightHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-06-08"), indexOnOvalRightHandFullTurnPitched.getSymbol());
		indexOnOvalRightHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-06-01"), indexOnOvalRightHandFullTurnPitched.getSymbol());

		indexOnOvalLeftHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-06-16"), indexOnOvalLeftHandFullTurnPitched.getSymbol());
		indexOnOvalLeftHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-06-15"), indexOnOvalLeftHandFullTurnPitched.getSymbol());
		indexOnOvalLeftHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-06-14"), indexOnOvalLeftHandFullTurnPitched.getSymbol());
		indexOnOvalLeftHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-06-13"), indexOnOvalLeftHandFullTurnPitched.getSymbol());
		indexOnOvalLeftHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-06-12"), indexOnOvalLeftHandFullTurnPitched.getSymbol());
		indexOnOvalLeftHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-06-11"), indexOnOvalLeftHandFullTurnPitched.getSymbol());
		indexOnOvalLeftHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-06-10"), indexOnOvalLeftHandFullTurnPitched.getSymbol());
		indexOnOvalLeftHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-06-09"), indexOnOvalLeftHandFullTurnPitched.getSymbol());

		indexOnHingeRightHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-01-02"), indexOnHingeRightHand.getSymbol());
		indexOnHingeRightHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-01-03"), indexOnHingeRightHand.getSymbol());
		indexOnHingeRightHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-01-04"), indexOnHingeRightHand.getSymbol());
		indexOnHingeRightHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-01-05"), indexOnHingeRightHand.getSymbol());
		indexOnHingeRightHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-01-06"), indexOnHingeRightHand.getSymbol());
		indexOnHingeRightHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-01-07"), indexOnHingeRightHand.getSymbol());
		indexOnHingeRightHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-01-08"), indexOnHingeRightHand.getSymbol());
		indexOnHingeRightHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-01-01"), indexOnHingeRightHand.getSymbol());

		indexOnHingeLeftHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-01-16"), indexOnHingeLeftHand.getSymbol());
		indexOnHingeLeftHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-01-15"), indexOnHingeLeftHand.getSymbol());
		indexOnHingeLeftHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-01-14"), indexOnHingeLeftHand.getSymbol());
		indexOnHingeLeftHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-01-13"), indexOnHingeLeftHand.getSymbol());
		indexOnHingeLeftHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-01-12"), indexOnHingeLeftHand.getSymbol());
		indexOnHingeLeftHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-01-11"), indexOnHingeLeftHand.getSymbol());
		indexOnHingeLeftHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-01-10"), indexOnHingeLeftHand.getSymbol());
		indexOnHingeLeftHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-01-09"), indexOnHingeLeftHand.getSymbol());

		indexOnHingeRightHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-02-02"), indexOnHingeRightHandHalfTurn.getSymbol());
		indexOnHingeRightHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-02-03"), indexOnHingeRightHandHalfTurn.getSymbol());
		indexOnHingeRightHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-02-04"), indexOnHingeRightHandHalfTurn.getSymbol());
		indexOnHingeRightHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-02-05"), indexOnHingeRightHandHalfTurn.getSymbol());
		indexOnHingeRightHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-02-06"), indexOnHingeRightHandHalfTurn.getSymbol());
		indexOnHingeRightHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-02-07"), indexOnHingeRightHandHalfTurn.getSymbol());
		indexOnHingeRightHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-02-08"), indexOnHingeRightHandHalfTurn.getSymbol());
		indexOnHingeRightHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-02-01"), indexOnHingeRightHandHalfTurn.getSymbol());

		indexOnHingeLeftHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-02-16"), indexOnHingeLeftHandHalfTurn.getSymbol());
		indexOnHingeLeftHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-02-15"), indexOnHingeLeftHandHalfTurn.getSymbol());
		indexOnHingeLeftHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-02-14"), indexOnHingeLeftHandHalfTurn.getSymbol());
		indexOnHingeLeftHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-02-13"), indexOnHingeLeftHandHalfTurn.getSymbol());
		indexOnHingeLeftHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-02-12"), indexOnHingeLeftHandHalfTurn.getSymbol());
		indexOnHingeLeftHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-02-11"), indexOnHingeLeftHandHalfTurn.getSymbol());
		indexOnHingeLeftHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-02-10"), indexOnHingeLeftHandHalfTurn.getSymbol());
		indexOnHingeLeftHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-02-09"), indexOnHingeLeftHandHalfTurn.getSymbol());

		indexOnHingeRightHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-03-02"), indexOnHingeRightHandFullTurn.getSymbol());
		indexOnHingeRightHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-03-03"), indexOnHingeRightHandFullTurn.getSymbol());
		indexOnHingeRightHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-03-04"), indexOnHingeRightHandFullTurn.getSymbol());
		indexOnHingeRightHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-03-05"), indexOnHingeRightHandFullTurn.getSymbol());
		indexOnHingeRightHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-03-06"), indexOnHingeRightHandFullTurn.getSymbol());
		indexOnHingeRightHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-03-07"), indexOnHingeRightHandFullTurn.getSymbol());
		indexOnHingeRightHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-03-08"), indexOnHingeRightHandFullTurn.getSymbol());
		indexOnHingeRightHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-03-01"), indexOnHingeRightHandFullTurn.getSymbol());

		indexOnHingeLeftHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-03-16"), indexOnHingeLeftHandFullTurn.getSymbol());
		indexOnHingeLeftHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-03-15"), indexOnHingeLeftHandFullTurn.getSymbol());
		indexOnHingeLeftHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-03-14"), indexOnHingeLeftHandFullTurn.getSymbol());
		indexOnHingeLeftHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-03-13"), indexOnHingeLeftHandFullTurn.getSymbol());
		indexOnHingeLeftHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-03-12"), indexOnHingeLeftHandFullTurn.getSymbol());
		indexOnHingeLeftHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-03-11"), indexOnHingeLeftHandFullTurn.getSymbol());
		indexOnHingeLeftHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-03-10"), indexOnHingeLeftHandFullTurn.getSymbol());
		indexOnHingeLeftHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-03-09"), indexOnHingeLeftHandFullTurn.getSymbol());

		indexOnHingeRightHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-04-02"), indexOnHingeRightHandPitched.getSymbol());
		indexOnHingeRightHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-04-03"), indexOnHingeRightHandPitched.getSymbol());
		indexOnHingeRightHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-04-04"), indexOnHingeRightHandPitched.getSymbol());
		indexOnHingeRightHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-04-05"), indexOnHingeRightHandPitched.getSymbol());
		indexOnHingeRightHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-04-06"), indexOnHingeRightHandPitched.getSymbol());
		indexOnHingeRightHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-04-07"), indexOnHingeRightHandPitched.getSymbol());
		indexOnHingeRightHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-04-08"), indexOnHingeRightHandPitched.getSymbol());
		indexOnHingeRightHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-04-01"), indexOnHingeRightHandPitched.getSymbol());

		indexOnHingeLeftHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-04-16"), indexOnHingeLeftHandPitched.getSymbol());
		indexOnHingeLeftHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-04-15"), indexOnHingeLeftHandPitched.getSymbol());
		indexOnHingeLeftHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-04-14"), indexOnHingeLeftHandPitched.getSymbol());
		indexOnHingeLeftHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-04-13"), indexOnHingeLeftHandPitched.getSymbol());
		indexOnHingeLeftHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-04-12"), indexOnHingeLeftHandPitched.getSymbol());
		indexOnHingeLeftHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-04-11"), indexOnHingeLeftHandPitched.getSymbol());
		indexOnHingeLeftHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-04-10"), indexOnHingeLeftHandPitched.getSymbol());
		indexOnHingeLeftHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-04-09"), indexOnHingeLeftHandPitched.getSymbol());

		indexOnHingeRightHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-05-02"),
				indexOnHingeRightHandHalfTurnPitched.getSymbol());
		indexOnHingeRightHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-05-03"),
				indexOnHingeRightHandHalfTurnPitched.getSymbol());
		indexOnHingeRightHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-05-04"),
				indexOnHingeRightHandHalfTurnPitched.getSymbol());
		indexOnHingeRightHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-05-05"),
				indexOnHingeRightHandHalfTurnPitched.getSymbol());
		indexOnHingeRightHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-05-06"),
				indexOnHingeRightHandHalfTurnPitched.getSymbol());
		indexOnHingeRightHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-05-07"),
				indexOnHingeRightHandHalfTurnPitched.getSymbol());
		indexOnHingeRightHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-05-08"),
				indexOnHingeRightHandHalfTurnPitched.getSymbol());
		indexOnHingeRightHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-05-01"),
				indexOnHingeRightHandHalfTurnPitched.getSymbol());

		indexOnHingeLeftHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-05-16"), indexOnHingeLeftHandHalfTurnPitched.getSymbol());
		indexOnHingeLeftHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-05-15"), indexOnHingeLeftHandHalfTurnPitched.getSymbol());
		indexOnHingeLeftHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-05-14"), indexOnHingeLeftHandHalfTurnPitched.getSymbol());
		indexOnHingeLeftHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-05-13"), indexOnHingeLeftHandHalfTurnPitched.getSymbol());
		indexOnHingeLeftHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-05-12"), indexOnHingeLeftHandHalfTurnPitched.getSymbol());
		indexOnHingeLeftHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-05-11"), indexOnHingeLeftHandHalfTurnPitched.getSymbol());
		indexOnHingeLeftHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-05-10"), indexOnHingeLeftHandHalfTurnPitched.getSymbol());
		indexOnHingeLeftHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-05-09"), indexOnHingeLeftHandHalfTurnPitched.getSymbol());

		indexOnHingeRightHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-06-02"),
				indexOnHingeRightHandFullTurnPitched.getSymbol());
		indexOnHingeRightHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-06-03"),
				indexOnHingeRightHandFullTurnPitched.getSymbol());
		indexOnHingeRightHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-06-04"),
				indexOnHingeRightHandFullTurnPitched.getSymbol());
		indexOnHingeRightHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-06-05"),
				indexOnHingeRightHandFullTurnPitched.getSymbol());
		indexOnHingeRightHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-06-06"),
				indexOnHingeRightHandFullTurnPitched.getSymbol());
		indexOnHingeRightHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-06-07"),
				indexOnHingeRightHandFullTurnPitched.getSymbol());
		indexOnHingeRightHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-06-08"),
				indexOnHingeRightHandFullTurnPitched.getSymbol());
		indexOnHingeRightHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-06-01"),
				indexOnHingeRightHandFullTurnPitched.getSymbol());

		indexOnHingeLeftHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-06-16"), indexOnHingeLeftHandFullTurnPitched.getSymbol());
		indexOnHingeLeftHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-06-15"), indexOnHingeLeftHandFullTurnPitched.getSymbol());
		indexOnHingeLeftHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-06-14"), indexOnHingeLeftHandFullTurnPitched.getSymbol());
		indexOnHingeLeftHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-06-13"), indexOnHingeLeftHandFullTurnPitched.getSymbol());
		indexOnHingeLeftHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-06-12"), indexOnHingeLeftHandFullTurnPitched.getSymbol());
		indexOnHingeLeftHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-06-11"), indexOnHingeLeftHandFullTurnPitched.getSymbol());
		indexOnHingeLeftHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-06-10"), indexOnHingeLeftHandFullTurnPitched.getSymbol());
		indexOnHingeLeftHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-06-09"), indexOnHingeLeftHandFullTurnPitched.getSymbol());

		indexOnAngleRightHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-01-02"), indexOnAngleRightHand.getSymbol());
		indexOnAngleRightHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-01-03"), indexOnAngleRightHand.getSymbol());
		indexOnAngleRightHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-01-04"), indexOnAngleRightHand.getSymbol());
		indexOnAngleRightHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-01-05"), indexOnAngleRightHand.getSymbol());
		indexOnAngleRightHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-01-06"), indexOnAngleRightHand.getSymbol());
		indexOnAngleRightHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-01-07"), indexOnAngleRightHand.getSymbol());
		indexOnAngleRightHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-01-08"), indexOnAngleRightHand.getSymbol());
		indexOnAngleRightHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-01-01"), indexOnAngleRightHand.getSymbol());

		indexOnAngleLeftHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-01-16"), indexOnAngleLeftHand.getSymbol());
		indexOnAngleLeftHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-01-15"), indexOnAngleLeftHand.getSymbol());
		indexOnAngleLeftHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-01-14"), indexOnAngleLeftHand.getSymbol());
		indexOnAngleLeftHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-01-13"), indexOnAngleLeftHand.getSymbol());
		indexOnAngleLeftHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-01-12"), indexOnAngleLeftHand.getSymbol());
		indexOnAngleLeftHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-01-11"), indexOnAngleLeftHand.getSymbol());
		indexOnAngleLeftHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-01-10"), indexOnAngleLeftHand.getSymbol());
		indexOnAngleLeftHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-01-09"), indexOnAngleLeftHand.getSymbol());

		indexOnAngleRightHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-02-02"), indexOnAngleRightHandHalfTurn.getSymbol());
		indexOnAngleRightHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-02-03"), indexOnAngleRightHandHalfTurn.getSymbol());
		indexOnAngleRightHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-02-04"), indexOnAngleRightHandHalfTurn.getSymbol());
		indexOnAngleRightHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-02-05"), indexOnAngleRightHandHalfTurn.getSymbol());
		indexOnAngleRightHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-02-06"), indexOnAngleRightHandHalfTurn.getSymbol());
		indexOnAngleRightHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-02-07"), indexOnAngleRightHandHalfTurn.getSymbol());
		indexOnAngleRightHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-02-08"), indexOnAngleRightHandHalfTurn.getSymbol());
		indexOnAngleRightHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-02-01"), indexOnAngleRightHandHalfTurn.getSymbol());

		indexOnAngleLeftHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-02-16"), indexOnAngleLeftHandHalfTurn.getSymbol());
		indexOnAngleLeftHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-02-15"), indexOnAngleLeftHandHalfTurn.getSymbol());
		indexOnAngleLeftHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-02-14"), indexOnAngleLeftHandHalfTurn.getSymbol());
		indexOnAngleLeftHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-02-13"), indexOnAngleLeftHandHalfTurn.getSymbol());
		indexOnAngleLeftHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-02-12"), indexOnAngleLeftHandHalfTurn.getSymbol());
		indexOnAngleLeftHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-02-11"), indexOnAngleLeftHandHalfTurn.getSymbol());
		indexOnAngleLeftHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-02-10"), indexOnAngleLeftHandHalfTurn.getSymbol());
		indexOnAngleLeftHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-02-09"), indexOnAngleLeftHandHalfTurn.getSymbol());

		indexOnAngleRightHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-03-02"), indexOnAngleRightHandFullTurn.getSymbol());
		indexOnAngleRightHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-03-03"), indexOnAngleRightHandFullTurn.getSymbol());
		indexOnAngleRightHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-03-04"), indexOnAngleRightHandFullTurn.getSymbol());
		indexOnAngleRightHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-03-05"), indexOnAngleRightHandFullTurn.getSymbol());
		indexOnAngleRightHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-03-06"), indexOnAngleRightHandFullTurn.getSymbol());
		indexOnAngleRightHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-03-07"), indexOnAngleRightHandFullTurn.getSymbol());
		indexOnAngleRightHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-03-08"), indexOnAngleRightHandFullTurn.getSymbol());
		indexOnAngleRightHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-03-01"), indexOnAngleRightHandFullTurn.getSymbol());

		indexOnAngleLeftHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-03-16"), indexOnAngleLeftHandFullTurn.getSymbol());
		indexOnAngleLeftHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-03-15"), indexOnAngleLeftHandFullTurn.getSymbol());
		indexOnAngleLeftHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-03-14"), indexOnAngleLeftHandFullTurn.getSymbol());
		indexOnAngleLeftHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-03-13"), indexOnAngleLeftHandFullTurn.getSymbol());
		indexOnAngleLeftHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-03-12"), indexOnAngleLeftHandFullTurn.getSymbol());
		indexOnAngleLeftHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-03-11"), indexOnAngleLeftHandFullTurn.getSymbol());
		indexOnAngleLeftHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-03-10"), indexOnAngleLeftHandFullTurn.getSymbol());
		indexOnAngleLeftHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-03-09"), indexOnAngleLeftHandFullTurn.getSymbol());

		indexOnAngleRightHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-04-02"), indexOnAngleRightHandPitched.getSymbol());
		indexOnAngleRightHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-04-03"), indexOnAngleRightHandPitched.getSymbol());
		indexOnAngleRightHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-04-04"), indexOnAngleRightHandPitched.getSymbol());
		indexOnAngleRightHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-04-05"), indexOnAngleRightHandPitched.getSymbol());
		indexOnAngleRightHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-04-06"), indexOnAngleRightHandPitched.getSymbol());
		indexOnAngleRightHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-04-07"), indexOnAngleRightHandPitched.getSymbol());
		indexOnAngleRightHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-04-08"), indexOnAngleRightHandPitched.getSymbol());
		indexOnAngleRightHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-04-01"), indexOnAngleRightHandPitched.getSymbol());

		indexOnAngleLeftHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-04-16"), indexOnAngleLeftHandPitched.getSymbol());
		indexOnAngleLeftHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-04-15"), indexOnAngleLeftHandPitched.getSymbol());
		indexOnAngleLeftHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-04-14"), indexOnAngleLeftHandPitched.getSymbol());
		indexOnAngleLeftHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-04-13"), indexOnAngleLeftHandPitched.getSymbol());
		indexOnAngleLeftHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-04-12"), indexOnAngleLeftHandPitched.getSymbol());
		indexOnAngleLeftHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-04-11"), indexOnAngleLeftHandPitched.getSymbol());
		indexOnAngleLeftHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-04-10"), indexOnAngleLeftHandPitched.getSymbol());
		indexOnAngleLeftHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-04-09"), indexOnAngleLeftHandPitched.getSymbol());

		indexOnAngleRightHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-05-02"),
				indexOnAngleRightHandHalfTurnPitched.getSymbol());
		indexOnAngleRightHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-05-03"),
				indexOnAngleRightHandHalfTurnPitched.getSymbol());
		indexOnAngleRightHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-05-04"),
				indexOnAngleRightHandHalfTurnPitched.getSymbol());
		indexOnAngleRightHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-05-05"),
				indexOnAngleRightHandHalfTurnPitched.getSymbol());
		indexOnAngleRightHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-05-06"),
				indexOnAngleRightHandHalfTurnPitched.getSymbol());
		indexOnAngleRightHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-05-07"),
				indexOnAngleRightHandHalfTurnPitched.getSymbol());
		indexOnAngleRightHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-05-08"),
				indexOnAngleRightHandHalfTurnPitched.getSymbol());
		indexOnAngleRightHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-05-01"),
				indexOnAngleRightHandHalfTurnPitched.getSymbol());

		indexOnAngleLeftHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-05-16"), indexOnAngleLeftHandHalfTurnPitched.getSymbol());
		indexOnAngleLeftHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-05-15"), indexOnAngleLeftHandHalfTurnPitched.getSymbol());
		indexOnAngleLeftHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-05-14"), indexOnAngleLeftHandHalfTurnPitched.getSymbol());
		indexOnAngleLeftHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-05-13"), indexOnAngleLeftHandHalfTurnPitched.getSymbol());
		indexOnAngleLeftHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-05-12"), indexOnAngleLeftHandHalfTurnPitched.getSymbol());
		indexOnAngleLeftHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-05-11"), indexOnAngleLeftHandHalfTurnPitched.getSymbol());
		indexOnAngleLeftHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-05-10"), indexOnAngleLeftHandHalfTurnPitched.getSymbol());
		indexOnAngleLeftHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-05-09"), indexOnAngleLeftHandHalfTurnPitched.getSymbol());

		indexOnAngleRightHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-06-02"),
				indexOnAngleRightHandFullTurnPitched.getSymbol());
		indexOnAngleRightHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-06-03"),
				indexOnAngleRightHandFullTurnPitched.getSymbol());
		indexOnAngleRightHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-06-04"),
				indexOnAngleRightHandFullTurnPitched.getSymbol());
		indexOnAngleRightHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-06-05"),
				indexOnAngleRightHandFullTurnPitched.getSymbol());
		indexOnAngleRightHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-06-06"),
				indexOnAngleRightHandFullTurnPitched.getSymbol());
		indexOnAngleRightHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-06-07"),
				indexOnAngleRightHandFullTurnPitched.getSymbol());
		indexOnAngleRightHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-06-08"),
				indexOnAngleRightHandFullTurnPitched.getSymbol());
		indexOnAngleRightHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-06-01"),
				indexOnAngleRightHandFullTurnPitched.getSymbol());

		indexOnAngleLeftHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-06-16"), indexOnAngleLeftHandFullTurnPitched.getSymbol());
		indexOnAngleLeftHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-06-15"), indexOnAngleLeftHandFullTurnPitched.getSymbol());
		indexOnAngleLeftHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-06-14"), indexOnAngleLeftHandFullTurnPitched.getSymbol());
		indexOnAngleLeftHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-06-13"), indexOnAngleLeftHandFullTurnPitched.getSymbol());
		indexOnAngleLeftHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-06-12"), indexOnAngleLeftHandFullTurnPitched.getSymbol());
		indexOnAngleLeftHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-06-11"), indexOnAngleLeftHandFullTurnPitched.getSymbol());
		indexOnAngleLeftHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-06-10"), indexOnAngleLeftHandFullTurnPitched.getSymbol());
		indexOnAngleLeftHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-06-09"), indexOnAngleLeftHandFullTurnPitched.getSymbol());

		indexBentRightHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-01-02"), indexBentRightHand.getSymbol());
		indexBentRightHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-01-03"), indexBentRightHand.getSymbol());
		indexBentRightHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-01-04"), indexBentRightHand.getSymbol());
		indexBentRightHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-01-05"), indexBentRightHand.getSymbol());
		indexBentRightHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-01-06"), indexBentRightHand.getSymbol());
		indexBentRightHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-01-07"), indexBentRightHand.getSymbol());
		indexBentRightHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-01-08"), indexBentRightHand.getSymbol());
		indexBentRightHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-01-01"), indexBentRightHand.getSymbol());

		indexBentLeftHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-01-16"), indexBentLeftHand.getSymbol());
		indexBentLeftHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-01-15"), indexBentLeftHand.getSymbol());
		indexBentLeftHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-01-14"), indexBentLeftHand.getSymbol());
		indexBentLeftHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-01-13"), indexBentLeftHand.getSymbol());
		indexBentLeftHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-01-12"), indexBentLeftHand.getSymbol());
		indexBentLeftHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-01-11"), indexBentLeftHand.getSymbol());
		indexBentLeftHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-01-10"), indexBentLeftHand.getSymbol());
		indexBentLeftHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-01-09"), indexBentLeftHand.getSymbol());

		indexBentRightHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-02-02"), indexBentRightHandHalfTurn.getSymbol());
		indexBentRightHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-02-03"), indexBentRightHandHalfTurn.getSymbol());
		indexBentRightHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-02-04"), indexBentRightHandHalfTurn.getSymbol());
		indexBentRightHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-02-05"), indexBentRightHandHalfTurn.getSymbol());
		indexBentRightHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-02-06"), indexBentRightHandHalfTurn.getSymbol());
		indexBentRightHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-02-07"), indexBentRightHandHalfTurn.getSymbol());
		indexBentRightHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-02-08"), indexBentRightHandHalfTurn.getSymbol());
		indexBentRightHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-02-01"), indexBentRightHandHalfTurn.getSymbol());

		indexBentLeftHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-02-16"), indexBentLeftHandHalfTurn.getSymbol());
		indexBentLeftHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-02-15"), indexBentLeftHandHalfTurn.getSymbol());
		indexBentLeftHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-02-14"), indexBentLeftHandHalfTurn.getSymbol());
		indexBentLeftHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-02-13"), indexBentLeftHandHalfTurn.getSymbol());
		indexBentLeftHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-02-12"), indexBentLeftHandHalfTurn.getSymbol());
		indexBentLeftHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-02-11"), indexBentLeftHandHalfTurn.getSymbol());
		indexBentLeftHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-02-10"), indexBentLeftHandHalfTurn.getSymbol());
		indexBentLeftHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-02-09"), indexBentLeftHandHalfTurn.getSymbol());

		indexBentRightHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-03-02"), indexBentRightHandFullTurn.getSymbol());
		indexBentRightHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-03-03"), indexBentRightHandFullTurn.getSymbol());
		indexBentRightHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-03-04"), indexBentRightHandFullTurn.getSymbol());
		indexBentRightHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-03-05"), indexBentRightHandFullTurn.getSymbol());
		indexBentRightHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-03-06"), indexBentRightHandFullTurn.getSymbol());
		indexBentRightHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-03-07"), indexBentRightHandFullTurn.getSymbol());
		indexBentRightHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-03-08"), indexBentRightHandFullTurn.getSymbol());
		indexBentRightHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-03-01"), indexBentRightHandFullTurn.getSymbol());

		indexBentLeftHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-03-16"), indexBentLeftHandFullTurn.getSymbol());
		indexBentLeftHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-03-15"), indexBentLeftHandFullTurn.getSymbol());
		indexBentLeftHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-03-14"), indexBentLeftHandFullTurn.getSymbol());
		indexBentLeftHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-03-13"), indexBentLeftHandFullTurn.getSymbol());
		indexBentLeftHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-03-12"), indexBentLeftHandFullTurn.getSymbol());
		indexBentLeftHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-03-11"), indexBentLeftHandFullTurn.getSymbol());
		indexBentLeftHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-03-10"), indexBentLeftHandFullTurn.getSymbol());
		indexBentLeftHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-03-09"), indexBentLeftHandFullTurn.getSymbol());

		indexBentRightHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-04-02"), indexBentRightHandPitched.getSymbol());
		indexBentRightHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-04-03"), indexBentRightHandPitched.getSymbol());
		indexBentRightHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-04-04"), indexBentRightHandPitched.getSymbol());
		indexBentRightHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-04-05"), indexBentRightHandPitched.getSymbol());
		indexBentRightHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-04-06"), indexBentRightHandPitched.getSymbol());
		indexBentRightHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-04-07"), indexBentRightHandPitched.getSymbol());
		indexBentRightHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-04-08"), indexBentRightHandPitched.getSymbol());
		indexBentRightHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-04-01"), indexBentRightHandPitched.getSymbol());

		indexBentLeftHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-04-16"), indexBentLeftHandPitched.getSymbol());
		indexBentLeftHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-04-15"), indexBentLeftHandPitched.getSymbol());
		indexBentLeftHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-04-14"), indexBentLeftHandPitched.getSymbol());
		indexBentLeftHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-04-13"), indexBentLeftHandPitched.getSymbol());
		indexBentLeftHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-04-12"), indexBentLeftHandPitched.getSymbol());
		indexBentLeftHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-04-11"), indexBentLeftHandPitched.getSymbol());
		indexBentLeftHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-04-10"), indexBentLeftHandPitched.getSymbol());
		indexBentLeftHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-04-09"), indexBentLeftHandPitched.getSymbol());

		indexBentRightHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-05-02"), indexBentRightHandHalfTurnPitched.getSymbol());
		indexBentRightHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-05-03"), indexBentRightHandHalfTurnPitched.getSymbol());
		indexBentRightHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-05-04"), indexBentRightHandHalfTurnPitched.getSymbol());
		indexBentRightHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-05-05"), indexBentRightHandHalfTurnPitched.getSymbol());
		indexBentRightHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-05-06"), indexBentRightHandHalfTurnPitched.getSymbol());
		indexBentRightHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-05-07"), indexBentRightHandHalfTurnPitched.getSymbol());
		indexBentRightHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-05-08"), indexBentRightHandHalfTurnPitched.getSymbol());
		indexBentRightHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-05-01"), indexBentRightHandHalfTurnPitched.getSymbol());

		indexBentLeftHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-05-16"), indexBentLeftHandHalfTurnPitched.getSymbol());
		indexBentLeftHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-05-15"), indexBentLeftHandHalfTurnPitched.getSymbol());
		indexBentLeftHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-05-14"), indexBentLeftHandHalfTurnPitched.getSymbol());
		indexBentLeftHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-05-13"), indexBentLeftHandHalfTurnPitched.getSymbol());
		indexBentLeftHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-05-12"), indexBentLeftHandHalfTurnPitched.getSymbol());
		indexBentLeftHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-05-11"), indexBentLeftHandHalfTurnPitched.getSymbol());
		indexBentLeftHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-05-10"), indexBentLeftHandHalfTurnPitched.getSymbol());
		indexBentLeftHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-05-09"), indexBentLeftHandHalfTurnPitched.getSymbol());

		indexBentRightHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-06-02"), indexBentRightHandFullTurnPitched.getSymbol());
		indexBentRightHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-06-03"), indexBentRightHandFullTurnPitched.getSymbol());
		indexBentRightHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-06-04"), indexBentRightHandFullTurnPitched.getSymbol());
		indexBentRightHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-06-05"), indexBentRightHandFullTurnPitched.getSymbol());
		indexBentRightHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-06-06"), indexBentRightHandFullTurnPitched.getSymbol());
		indexBentRightHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-06-07"), indexBentRightHandFullTurnPitched.getSymbol());
		indexBentRightHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-06-08"), indexBentRightHandFullTurnPitched.getSymbol());
		indexBentRightHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-06-01"), indexBentRightHandFullTurnPitched.getSymbol());

		indexBentLeftHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-06-16"), indexBentLeftHandFullTurnPitched.getSymbol());
		indexBentLeftHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-06-15"), indexBentLeftHandFullTurnPitched.getSymbol());
		indexBentLeftHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-06-14"), indexBentLeftHandFullTurnPitched.getSymbol());
		indexBentLeftHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-06-13"), indexBentLeftHandFullTurnPitched.getSymbol());
		indexBentLeftHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-06-12"), indexBentLeftHandFullTurnPitched.getSymbol());
		indexBentLeftHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-06-11"), indexBentLeftHandFullTurnPitched.getSymbol());
		indexBentLeftHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-06-10"), indexBentLeftHandFullTurnPitched.getSymbol());
		indexBentLeftHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-06-09"), indexBentLeftHandFullTurnPitched.getSymbol());

		indexBentOnCircleRightHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-01-02"), indexBentOnCircleRightHand.getSymbol());
		indexBentOnCircleRightHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-01-03"), indexBentOnCircleRightHand.getSymbol());
		indexBentOnCircleRightHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-01-04"), indexBentOnCircleRightHand.getSymbol());
		indexBentOnCircleRightHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-01-05"), indexBentOnCircleRightHand.getSymbol());
		indexBentOnCircleRightHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-01-06"), indexBentOnCircleRightHand.getSymbol());
		indexBentOnCircleRightHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-01-07"), indexBentOnCircleRightHand.getSymbol());
		indexBentOnCircleRightHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-01-08"), indexBentOnCircleRightHand.getSymbol());
		indexBentOnCircleRightHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-01-01"), indexBentOnCircleRightHand.getSymbol());

		indexBentOnCircleLeftHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-01-16"), indexBentOnCircleLeftHand.getSymbol());
		indexBentOnCircleLeftHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-01-15"), indexBentOnCircleLeftHand.getSymbol());
		indexBentOnCircleLeftHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-01-14"), indexBentOnCircleLeftHand.getSymbol());
		indexBentOnCircleLeftHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-01-13"), indexBentOnCircleLeftHand.getSymbol());
		indexBentOnCircleLeftHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-01-12"), indexBentOnCircleLeftHand.getSymbol());
		indexBentOnCircleLeftHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-01-11"), indexBentOnCircleLeftHand.getSymbol());
		indexBentOnCircleLeftHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-01-10"), indexBentOnCircleLeftHand.getSymbol());
		indexBentOnCircleLeftHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-01-09"), indexBentOnCircleLeftHand.getSymbol());

		indexBentOnCircleRightHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-02-02"), indexBentOnCircleRightHandHalfTurn.getSymbol());
		indexBentOnCircleRightHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-02-03"), indexBentOnCircleRightHandHalfTurn.getSymbol());
		indexBentOnCircleRightHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-02-04"), indexBentOnCircleRightHandHalfTurn.getSymbol());
		indexBentOnCircleRightHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-02-05"), indexBentOnCircleRightHandHalfTurn.getSymbol());
		indexBentOnCircleRightHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-02-06"), indexBentOnCircleRightHandHalfTurn.getSymbol());
		indexBentOnCircleRightHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-02-07"), indexBentOnCircleRightHandHalfTurn.getSymbol());
		indexBentOnCircleRightHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-02-08"), indexBentOnCircleRightHandHalfTurn.getSymbol());
		indexBentOnCircleRightHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-02-01"), indexBentOnCircleRightHandHalfTurn.getSymbol());

		indexBentOnCircleLeftHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-02-16"), indexBentOnCircleLeftHandHalfTurn.getSymbol());
		indexBentOnCircleLeftHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-02-15"), indexBentOnCircleLeftHandHalfTurn.getSymbol());
		indexBentOnCircleLeftHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-02-14"), indexBentOnCircleLeftHandHalfTurn.getSymbol());
		indexBentOnCircleLeftHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-02-13"), indexBentOnCircleLeftHandHalfTurn.getSymbol());
		indexBentOnCircleLeftHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-02-12"), indexBentOnCircleLeftHandHalfTurn.getSymbol());
		indexBentOnCircleLeftHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-02-11"), indexBentOnCircleLeftHandHalfTurn.getSymbol());
		indexBentOnCircleLeftHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-02-10"), indexBentOnCircleLeftHandHalfTurn.getSymbol());
		indexBentOnCircleLeftHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-02-09"), indexBentOnCircleLeftHandHalfTurn.getSymbol());

		indexBentOnCircleRightHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-03-02"), indexBentOnCircleRightHandFullTurn.getSymbol());
		indexBentOnCircleRightHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-03-03"), indexBentOnCircleRightHandFullTurn.getSymbol());
		indexBentOnCircleRightHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-03-04"), indexBentOnCircleRightHandFullTurn.getSymbol());
		indexBentOnCircleRightHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-03-05"), indexBentOnCircleRightHandFullTurn.getSymbol());
		indexBentOnCircleRightHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-03-06"), indexBentOnCircleRightHandFullTurn.getSymbol());
		indexBentOnCircleRightHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-03-07"), indexBentOnCircleRightHandFullTurn.getSymbol());
		indexBentOnCircleRightHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-03-08"), indexBentOnCircleRightHandFullTurn.getSymbol());
		indexBentOnCircleRightHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-03-01"), indexBentOnCircleRightHandFullTurn.getSymbol());

		indexBentOnCircleLeftHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-03-16"), indexBentOnCircleLeftHandFullTurn.getSymbol());
		indexBentOnCircleLeftHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-03-15"), indexBentOnCircleLeftHandFullTurn.getSymbol());
		indexBentOnCircleLeftHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-03-14"), indexBentOnCircleLeftHandFullTurn.getSymbol());
		indexBentOnCircleLeftHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-03-13"), indexBentOnCircleLeftHandFullTurn.getSymbol());
		indexBentOnCircleLeftHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-03-12"), indexBentOnCircleLeftHandFullTurn.getSymbol());
		indexBentOnCircleLeftHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-03-11"), indexBentOnCircleLeftHandFullTurn.getSymbol());
		indexBentOnCircleLeftHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-03-10"), indexBentOnCircleLeftHandFullTurn.getSymbol());
		indexBentOnCircleLeftHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-03-09"), indexBentOnCircleLeftHandFullTurn.getSymbol());

		indexBentOnCircleRightHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-04-02"), indexBentOnCircleRightHandPitched.getSymbol());
		indexBentOnCircleRightHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-04-03"), indexBentOnCircleRightHandPitched.getSymbol());
		indexBentOnCircleRightHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-04-04"), indexBentOnCircleRightHandPitched.getSymbol());
		indexBentOnCircleRightHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-04-05"), indexBentOnCircleRightHandPitched.getSymbol());
		indexBentOnCircleRightHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-04-06"), indexBentOnCircleRightHandPitched.getSymbol());
		indexBentOnCircleRightHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-04-07"), indexBentOnCircleRightHandPitched.getSymbol());
		indexBentOnCircleRightHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-04-08"), indexBentOnCircleRightHandPitched.getSymbol());
		indexBentOnCircleRightHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-04-01"), indexBentOnCircleRightHandPitched.getSymbol());

		indexBentOnCircleLeftHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-04-16"), indexBentOnCircleLeftHandPitched.getSymbol());
		indexBentOnCircleLeftHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-04-15"), indexBentOnCircleLeftHandPitched.getSymbol());
		indexBentOnCircleLeftHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-04-14"), indexBentOnCircleLeftHandPitched.getSymbol());
		indexBentOnCircleLeftHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-04-13"), indexBentOnCircleLeftHandPitched.getSymbol());
		indexBentOnCircleLeftHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-04-12"), indexBentOnCircleLeftHandPitched.getSymbol());
		indexBentOnCircleLeftHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-04-11"), indexBentOnCircleLeftHandPitched.getSymbol());
		indexBentOnCircleLeftHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-04-10"), indexBentOnCircleLeftHandPitched.getSymbol());
		indexBentOnCircleLeftHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-04-09"), indexBentOnCircleLeftHandPitched.getSymbol());

		indexBentOnCircleRightHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-05-02"),
				indexBentOnCircleRightHandHalfTurnPitched.getSymbol());
		indexBentOnCircleRightHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-05-03"),
				indexBentOnCircleRightHandHalfTurnPitched.getSymbol());
		indexBentOnCircleRightHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-05-04"),
				indexBentOnCircleRightHandHalfTurnPitched.getSymbol());
		indexBentOnCircleRightHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-05-05"),
				indexBentOnCircleRightHandHalfTurnPitched.getSymbol());
		indexBentOnCircleRightHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-05-06"),
				indexBentOnCircleRightHandHalfTurnPitched.getSymbol());
		indexBentOnCircleRightHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-05-07"),
				indexBentOnCircleRightHandHalfTurnPitched.getSymbol());
		indexBentOnCircleRightHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-05-08"),
				indexBentOnCircleRightHandHalfTurnPitched.getSymbol());
		indexBentOnCircleRightHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-05-01"),
				indexBentOnCircleRightHandHalfTurnPitched.getSymbol());

		indexBentOnCircleLeftHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-05-16"),
				indexBentOnCircleLeftHandHalfTurnPitched.getSymbol());
		indexBentOnCircleLeftHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-05-15"),
				indexBentOnCircleLeftHandHalfTurnPitched.getSymbol());
		indexBentOnCircleLeftHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-05-14"),
				indexBentOnCircleLeftHandHalfTurnPitched.getSymbol());
		indexBentOnCircleLeftHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-05-13"),
				indexBentOnCircleLeftHandHalfTurnPitched.getSymbol());
		indexBentOnCircleLeftHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-05-12"),
				indexBentOnCircleLeftHandHalfTurnPitched.getSymbol());
		indexBentOnCircleLeftHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-05-11"),
				indexBentOnCircleLeftHandHalfTurnPitched.getSymbol());
		indexBentOnCircleLeftHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-05-10"),
				indexBentOnCircleLeftHandHalfTurnPitched.getSymbol());
		indexBentOnCircleLeftHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-05-09"),
				indexBentOnCircleLeftHandHalfTurnPitched.getSymbol());

		indexBentOnCircleRightHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-06-02"),
				indexBentOnCircleRightHandFullTurnPitched.getSymbol());
		indexBentOnCircleRightHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-06-03"),
				indexBentOnCircleRightHandFullTurnPitched.getSymbol());
		indexBentOnCircleRightHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-06-04"),
				indexBentOnCircleRightHandFullTurnPitched.getSymbol());
		indexBentOnCircleRightHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-06-05"),
				indexBentOnCircleRightHandFullTurnPitched.getSymbol());
		indexBentOnCircleRightHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-06-06"),
				indexBentOnCircleRightHandFullTurnPitched.getSymbol());
		indexBentOnCircleRightHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-06-07"),
				indexBentOnCircleRightHandFullTurnPitched.getSymbol());
		indexBentOnCircleRightHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-06-08"),
				indexBentOnCircleRightHandFullTurnPitched.getSymbol());
		indexBentOnCircleRightHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-06-01"),
				indexBentOnCircleRightHandFullTurnPitched.getSymbol());

		indexBentOnCircleLeftHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-06-16"),
				indexBentOnCircleLeftHandFullTurnPitched.getSymbol());
		indexBentOnCircleLeftHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-06-15"),
				indexBentOnCircleLeftHandFullTurnPitched.getSymbol());
		indexBentOnCircleLeftHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-06-14"),
				indexBentOnCircleLeftHandFullTurnPitched.getSymbol());
		indexBentOnCircleLeftHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-06-13"),
				indexBentOnCircleLeftHandFullTurnPitched.getSymbol());
		indexBentOnCircleLeftHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-06-12"),
				indexBentOnCircleLeftHandFullTurnPitched.getSymbol());
		indexBentOnCircleLeftHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-06-11"),
				indexBentOnCircleLeftHandFullTurnPitched.getSymbol());
		indexBentOnCircleLeftHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-06-10"),
				indexBentOnCircleLeftHandFullTurnPitched.getSymbol());
		indexBentOnCircleLeftHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-06-09"),
				indexBentOnCircleLeftHandFullTurnPitched.getSymbol());

		indexBentOnFistThumbUnderRightHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-01-02"), indexBentOnFistThumbUnderRightHand.getSymbol());
		indexBentOnFistThumbUnderRightHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-01-03"), indexBentOnFistThumbUnderRightHand.getSymbol());
		indexBentOnFistThumbUnderRightHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-01-04"), indexBentOnFistThumbUnderRightHand.getSymbol());
		indexBentOnFistThumbUnderRightHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-01-05"), indexBentOnFistThumbUnderRightHand.getSymbol());
		indexBentOnFistThumbUnderRightHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-01-06"), indexBentOnFistThumbUnderRightHand.getSymbol());
		indexBentOnFistThumbUnderRightHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-01-07"), indexBentOnFistThumbUnderRightHand.getSymbol());
		indexBentOnFistThumbUnderRightHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-01-08"), indexBentOnFistThumbUnderRightHand.getSymbol());
		indexBentOnFistThumbUnderRightHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-01-01"), indexBentOnFistThumbUnderRightHand.getSymbol());

		indexBentOnFistThumbUnderLeftHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-01-16"), indexBentOnFistThumbUnderLeftHand.getSymbol());
		indexBentOnFistThumbUnderLeftHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-01-15"), indexBentOnFistThumbUnderLeftHand.getSymbol());
		indexBentOnFistThumbUnderLeftHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-01-14"), indexBentOnFistThumbUnderLeftHand.getSymbol());
		indexBentOnFistThumbUnderLeftHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-01-13"), indexBentOnFistThumbUnderLeftHand.getSymbol());
		indexBentOnFistThumbUnderLeftHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-01-12"), indexBentOnFistThumbUnderLeftHand.getSymbol());
		indexBentOnFistThumbUnderLeftHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-01-11"), indexBentOnFistThumbUnderLeftHand.getSymbol());
		indexBentOnFistThumbUnderLeftHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-01-10"), indexBentOnFistThumbUnderLeftHand.getSymbol());
		indexBentOnFistThumbUnderLeftHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-01-09"), indexBentOnFistThumbUnderLeftHand.getSymbol());

		indexBentOnFistThumbUnderRightHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-02-02"),
				indexBentOnFistThumbUnderRightHandHalfTurn.getSymbol());
		indexBentOnFistThumbUnderRightHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-02-03"),
				indexBentOnFistThumbUnderRightHandHalfTurn.getSymbol());
		indexBentOnFistThumbUnderRightHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-02-04"),
				indexBentOnFistThumbUnderRightHandHalfTurn.getSymbol());
		indexBentOnFistThumbUnderRightHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-02-05"),
				indexBentOnFistThumbUnderRightHandHalfTurn.getSymbol());
		indexBentOnFistThumbUnderRightHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-02-06"),
				indexBentOnFistThumbUnderRightHandHalfTurn.getSymbol());
		indexBentOnFistThumbUnderRightHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-02-07"),
				indexBentOnFistThumbUnderRightHandHalfTurn.getSymbol());
		indexBentOnFistThumbUnderRightHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-02-08"),
				indexBentOnFistThumbUnderRightHandHalfTurn.getSymbol());
		indexBentOnFistThumbUnderRightHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-02-01"),
				indexBentOnFistThumbUnderRightHandHalfTurn.getSymbol());

		indexBentOnFistThumbUnderLeftHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-02-16"),
				indexBentOnFistThumbUnderLeftHandHalfTurn.getSymbol());
		indexBentOnFistThumbUnderLeftHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-02-15"),
				indexBentOnFistThumbUnderLeftHandHalfTurn.getSymbol());
		indexBentOnFistThumbUnderLeftHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-02-14"),
				indexBentOnFistThumbUnderLeftHandHalfTurn.getSymbol());
		indexBentOnFistThumbUnderLeftHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-02-13"),
				indexBentOnFistThumbUnderLeftHandHalfTurn.getSymbol());
		indexBentOnFistThumbUnderLeftHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-02-12"),
				indexBentOnFistThumbUnderLeftHandHalfTurn.getSymbol());
		indexBentOnFistThumbUnderLeftHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-02-11"),
				indexBentOnFistThumbUnderLeftHandHalfTurn.getSymbol());
		indexBentOnFistThumbUnderLeftHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-02-10"),
				indexBentOnFistThumbUnderLeftHandHalfTurn.getSymbol());
		indexBentOnFistThumbUnderLeftHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-02-09"),
				indexBentOnFistThumbUnderLeftHandHalfTurn.getSymbol());

		indexBentOnFistThumbUnderRightHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-03-02"),
				indexBentOnFistThumbUnderRightHandFullTurn.getSymbol());
		indexBentOnFistThumbUnderRightHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-03-03"),
				indexBentOnFistThumbUnderRightHandFullTurn.getSymbol());
		indexBentOnFistThumbUnderRightHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-03-04"),
				indexBentOnFistThumbUnderRightHandFullTurn.getSymbol());
		indexBentOnFistThumbUnderRightHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-03-05"),
				indexBentOnFistThumbUnderRightHandFullTurn.getSymbol());
		indexBentOnFistThumbUnderRightHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-03-06"),
				indexBentOnFistThumbUnderRightHandFullTurn.getSymbol());
		indexBentOnFistThumbUnderRightHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-03-07"),
				indexBentOnFistThumbUnderRightHandFullTurn.getSymbol());
		indexBentOnFistThumbUnderRightHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-03-08"),
				indexBentOnFistThumbUnderRightHandFullTurn.getSymbol());
		indexBentOnFistThumbUnderRightHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-03-01"),
				indexBentOnFistThumbUnderRightHandFullTurn.getSymbol());

		indexBentOnFistThumbUnderLeftHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-03-16"),
				indexBentOnFistThumbUnderLeftHandFullTurn.getSymbol());
		indexBentOnFistThumbUnderLeftHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-03-15"),
				indexBentOnFistThumbUnderLeftHandFullTurn.getSymbol());
		indexBentOnFistThumbUnderLeftHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-03-14"),
				indexBentOnFistThumbUnderLeftHandFullTurn.getSymbol());
		indexBentOnFistThumbUnderLeftHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-03-13"),
				indexBentOnFistThumbUnderLeftHandFullTurn.getSymbol());
		indexBentOnFistThumbUnderLeftHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-03-12"),
				indexBentOnFistThumbUnderLeftHandFullTurn.getSymbol());
		indexBentOnFistThumbUnderLeftHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-03-11"),
				indexBentOnFistThumbUnderLeftHandFullTurn.getSymbol());
		indexBentOnFistThumbUnderLeftHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-03-10"),
				indexBentOnFistThumbUnderLeftHandFullTurn.getSymbol());
		indexBentOnFistThumbUnderLeftHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-03-09"),
				indexBentOnFistThumbUnderLeftHandFullTurn.getSymbol());

		indexBentOnFistThumbUnderRightHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-04-02"),
				indexBentOnFistThumbUnderRightHandPitched.getSymbol());
		indexBentOnFistThumbUnderRightHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-04-03"),
				indexBentOnFistThumbUnderRightHandPitched.getSymbol());
		indexBentOnFistThumbUnderRightHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-04-04"),
				indexBentOnFistThumbUnderRightHandPitched.getSymbol());
		indexBentOnFistThumbUnderRightHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-04-05"),
				indexBentOnFistThumbUnderRightHandPitched.getSymbol());
		indexBentOnFistThumbUnderRightHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-04-06"),
				indexBentOnFistThumbUnderRightHandPitched.getSymbol());
		indexBentOnFistThumbUnderRightHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-04-07"),
				indexBentOnFistThumbUnderRightHandPitched.getSymbol());
		indexBentOnFistThumbUnderRightHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-04-08"),
				indexBentOnFistThumbUnderRightHandPitched.getSymbol());
		indexBentOnFistThumbUnderRightHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-04-01"),
				indexBentOnFistThumbUnderRightHandPitched.getSymbol());

		indexBentOnFistThumbUnderLeftHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-04-16"),
				indexBentOnFistThumbUnderLeftHandPitched.getSymbol());
		indexBentOnFistThumbUnderLeftHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-04-15"),
				indexBentOnFistThumbUnderLeftHandPitched.getSymbol());
		indexBentOnFistThumbUnderLeftHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-04-14"),
				indexBentOnFistThumbUnderLeftHandPitched.getSymbol());
		indexBentOnFistThumbUnderLeftHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-04-13"),
				indexBentOnFistThumbUnderLeftHandPitched.getSymbol());
		indexBentOnFistThumbUnderLeftHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-04-12"),
				indexBentOnFistThumbUnderLeftHandPitched.getSymbol());
		indexBentOnFistThumbUnderLeftHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-04-11"),
				indexBentOnFistThumbUnderLeftHandPitched.getSymbol());
		indexBentOnFistThumbUnderLeftHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-04-10"),
				indexBentOnFistThumbUnderLeftHandPitched.getSymbol());
		indexBentOnFistThumbUnderLeftHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-04-09"),
				indexBentOnFistThumbUnderLeftHandPitched.getSymbol());

		indexBentOnFistThumbUnderRightHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-05-02"),
				indexBentOnFistThumbUnderRightHandHalfTurnPitched.getSymbol());
		indexBentOnFistThumbUnderRightHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-05-03"),
				indexBentOnFistThumbUnderRightHandHalfTurnPitched.getSymbol());
		indexBentOnFistThumbUnderRightHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-05-04"),
				indexBentOnFistThumbUnderRightHandHalfTurnPitched.getSymbol());
		indexBentOnFistThumbUnderRightHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-05-05"),
				indexBentOnFistThumbUnderRightHandHalfTurnPitched.getSymbol());
		indexBentOnFistThumbUnderRightHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-05-06"),
				indexBentOnFistThumbUnderRightHandHalfTurnPitched.getSymbol());
		indexBentOnFistThumbUnderRightHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-05-07"),
				indexBentOnFistThumbUnderRightHandHalfTurnPitched.getSymbol());
		indexBentOnFistThumbUnderRightHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-05-08"),
				indexBentOnFistThumbUnderRightHandHalfTurnPitched.getSymbol());
		indexBentOnFistThumbUnderRightHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-05-01"),
				indexBentOnFistThumbUnderRightHandHalfTurnPitched.getSymbol());

		indexBentOnFistThumbUnderLeftHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-05-16"),
				indexBentOnFistThumbUnderLeftHandHalfTurnPitched.getSymbol());
		indexBentOnFistThumbUnderLeftHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-05-15"),
				indexBentOnFistThumbUnderLeftHandHalfTurnPitched.getSymbol());
		indexBentOnFistThumbUnderLeftHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-05-14"),
				indexBentOnFistThumbUnderLeftHandHalfTurnPitched.getSymbol());
		indexBentOnFistThumbUnderLeftHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-05-13"),
				indexBentOnFistThumbUnderLeftHandHalfTurnPitched.getSymbol());
		indexBentOnFistThumbUnderLeftHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-05-12"),
				indexBentOnFistThumbUnderLeftHandHalfTurnPitched.getSymbol());
		indexBentOnFistThumbUnderLeftHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-05-11"),
				indexBentOnFistThumbUnderLeftHandHalfTurnPitched.getSymbol());
		indexBentOnFistThumbUnderLeftHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-05-10"),
				indexBentOnFistThumbUnderLeftHandHalfTurnPitched.getSymbol());
		indexBentOnFistThumbUnderLeftHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-05-09"),
				indexBentOnFistThumbUnderLeftHandHalfTurnPitched.getSymbol());

		indexBentOnFistThumbUnderRightHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-06-02"),
				indexBentOnFistThumbUnderRightHandFullTurnPitched.getSymbol());
		indexBentOnFistThumbUnderRightHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-06-03"),
				indexBentOnFistThumbUnderRightHandFullTurnPitched.getSymbol());
		indexBentOnFistThumbUnderRightHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-06-04"),
				indexBentOnFistThumbUnderRightHandFullTurnPitched.getSymbol());
		indexBentOnFistThumbUnderRightHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-06-05"),
				indexBentOnFistThumbUnderRightHandFullTurnPitched.getSymbol());
		indexBentOnFistThumbUnderRightHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-06-06"),
				indexBentOnFistThumbUnderRightHandFullTurnPitched.getSymbol());
		indexBentOnFistThumbUnderRightHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-06-07"),
				indexBentOnFistThumbUnderRightHandFullTurnPitched.getSymbol());
		indexBentOnFistThumbUnderRightHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-06-08"),
				indexBentOnFistThumbUnderRightHandFullTurnPitched.getSymbol());
		indexBentOnFistThumbUnderRightHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-06-01"),
				indexBentOnFistThumbUnderRightHandFullTurnPitched.getSymbol());

		indexBentOnFistThumbUnderLeftHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-06-16"),
				indexBentOnFistThumbUnderLeftHandFullTurnPitched.getSymbol());
		indexBentOnFistThumbUnderLeftHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-06-15"),
				indexBentOnFistThumbUnderLeftHandFullTurnPitched.getSymbol());
		indexBentOnFistThumbUnderLeftHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-06-14"),
				indexBentOnFistThumbUnderLeftHandFullTurnPitched.getSymbol());
		indexBentOnFistThumbUnderLeftHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-06-13"),
				indexBentOnFistThumbUnderLeftHandFullTurnPitched.getSymbol());
		indexBentOnFistThumbUnderLeftHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-06-12"),
				indexBentOnFistThumbUnderLeftHandFullTurnPitched.getSymbol());
		indexBentOnFistThumbUnderLeftHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-06-11"),
				indexBentOnFistThumbUnderLeftHandFullTurnPitched.getSymbol());
		indexBentOnFistThumbUnderLeftHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-06-10"),
				indexBentOnFistThumbUnderLeftHandFullTurnPitched.getSymbol());
		indexBentOnFistThumbUnderLeftHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-06-09"),
				indexBentOnFistThumbUnderLeftHandFullTurnPitched.getSymbol());

		indexRaisedKnuckleRightHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-01-02"), indexRaisedKnuckleRightHand.getSymbol());
		indexRaisedKnuckleRightHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-01-03"), indexRaisedKnuckleRightHand.getSymbol());
		indexRaisedKnuckleRightHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-01-04"), indexRaisedKnuckleRightHand.getSymbol());
		indexRaisedKnuckleRightHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-01-05"), indexRaisedKnuckleRightHand.getSymbol());
		indexRaisedKnuckleRightHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-01-06"), indexRaisedKnuckleRightHand.getSymbol());
		indexRaisedKnuckleRightHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-01-07"), indexRaisedKnuckleRightHand.getSymbol());
		indexRaisedKnuckleRightHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-01-08"), indexRaisedKnuckleRightHand.getSymbol());
		indexRaisedKnuckleRightHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-01-01"), indexRaisedKnuckleRightHand.getSymbol());

		indexRaisedKnuckleLeftHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-01-16"), indexRaisedKnuckleLeftHand.getSymbol());
		indexRaisedKnuckleLeftHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-01-15"), indexRaisedKnuckleLeftHand.getSymbol());
		indexRaisedKnuckleLeftHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-01-14"), indexRaisedKnuckleLeftHand.getSymbol());
		indexRaisedKnuckleLeftHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-01-13"), indexRaisedKnuckleLeftHand.getSymbol());
		indexRaisedKnuckleLeftHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-01-12"), indexRaisedKnuckleLeftHand.getSymbol());
		indexRaisedKnuckleLeftHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-01-11"), indexRaisedKnuckleLeftHand.getSymbol());
		indexRaisedKnuckleLeftHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-01-10"), indexRaisedKnuckleLeftHand.getSymbol());
		indexRaisedKnuckleLeftHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-01-09"), indexRaisedKnuckleLeftHand.getSymbol());

		indexRaisedKnuckleRightHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-02-02"), indexRaisedKnuckleRightHandHalfTurn.getSymbol());
		indexRaisedKnuckleRightHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-02-03"), indexRaisedKnuckleRightHandHalfTurn.getSymbol());
		indexRaisedKnuckleRightHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-02-04"), indexRaisedKnuckleRightHandHalfTurn.getSymbol());
		indexRaisedKnuckleRightHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-02-05"), indexRaisedKnuckleRightHandHalfTurn.getSymbol());
		indexRaisedKnuckleRightHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-02-06"), indexRaisedKnuckleRightHandHalfTurn.getSymbol());
		indexRaisedKnuckleRightHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-02-07"), indexRaisedKnuckleRightHandHalfTurn.getSymbol());
		indexRaisedKnuckleRightHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-02-08"), indexRaisedKnuckleRightHandHalfTurn.getSymbol());
		indexRaisedKnuckleRightHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-02-01"), indexRaisedKnuckleRightHandHalfTurn.getSymbol());

		indexRaisedKnuckleLeftHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-02-16"), indexRaisedKnuckleLeftHandHalfTurn.getSymbol());
		indexRaisedKnuckleLeftHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-02-15"), indexRaisedKnuckleLeftHandHalfTurn.getSymbol());
		indexRaisedKnuckleLeftHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-02-14"), indexRaisedKnuckleLeftHandHalfTurn.getSymbol());
		indexRaisedKnuckleLeftHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-02-13"), indexRaisedKnuckleLeftHandHalfTurn.getSymbol());
		indexRaisedKnuckleLeftHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-02-12"), indexRaisedKnuckleLeftHandHalfTurn.getSymbol());
		indexRaisedKnuckleLeftHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-02-11"), indexRaisedKnuckleLeftHandHalfTurn.getSymbol());
		indexRaisedKnuckleLeftHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-02-10"), indexRaisedKnuckleLeftHandHalfTurn.getSymbol());
		indexRaisedKnuckleLeftHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-02-09"), indexRaisedKnuckleLeftHandHalfTurn.getSymbol());

		indexRaisedKnuckleRightHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-03-02"), indexRaisedKnuckleRightHandFullTurn.getSymbol());
		indexRaisedKnuckleRightHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-03-03"), indexRaisedKnuckleRightHandFullTurn.getSymbol());
		indexRaisedKnuckleRightHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-03-04"), indexRaisedKnuckleRightHandFullTurn.getSymbol());
		indexRaisedKnuckleRightHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-03-05"), indexRaisedKnuckleRightHandFullTurn.getSymbol());
		indexRaisedKnuckleRightHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-03-06"), indexRaisedKnuckleRightHandFullTurn.getSymbol());
		indexRaisedKnuckleRightHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-03-07"), indexRaisedKnuckleRightHandFullTurn.getSymbol());
		indexRaisedKnuckleRightHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-03-08"), indexRaisedKnuckleRightHandFullTurn.getSymbol());
		indexRaisedKnuckleRightHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-03-01"), indexRaisedKnuckleRightHandFullTurn.getSymbol());

		indexRaisedKnuckleLeftHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-03-16"), indexRaisedKnuckleLeftHandFullTurn.getSymbol());
		indexRaisedKnuckleLeftHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-03-15"), indexRaisedKnuckleLeftHandFullTurn.getSymbol());
		indexRaisedKnuckleLeftHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-03-14"), indexRaisedKnuckleLeftHandFullTurn.getSymbol());
		indexRaisedKnuckleLeftHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-03-13"), indexRaisedKnuckleLeftHandFullTurn.getSymbol());
		indexRaisedKnuckleLeftHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-03-12"), indexRaisedKnuckleLeftHandFullTurn.getSymbol());
		indexRaisedKnuckleLeftHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-03-11"), indexRaisedKnuckleLeftHandFullTurn.getSymbol());
		indexRaisedKnuckleLeftHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-03-10"), indexRaisedKnuckleLeftHandFullTurn.getSymbol());
		indexRaisedKnuckleLeftHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-03-09"), indexRaisedKnuckleLeftHandFullTurn.getSymbol());

		indexRaisedKnuckleRightHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-04-02"), indexRaisedKnuckleRightHandPitched.getSymbol());
		indexRaisedKnuckleRightHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-04-03"), indexRaisedKnuckleRightHandPitched.getSymbol());
		indexRaisedKnuckleRightHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-04-04"), indexRaisedKnuckleRightHandPitched.getSymbol());
		indexRaisedKnuckleRightHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-04-05"), indexRaisedKnuckleRightHandPitched.getSymbol());
		indexRaisedKnuckleRightHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-04-06"), indexRaisedKnuckleRightHandPitched.getSymbol());
		indexRaisedKnuckleRightHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-04-07"), indexRaisedKnuckleRightHandPitched.getSymbol());
		indexRaisedKnuckleRightHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-04-08"), indexRaisedKnuckleRightHandPitched.getSymbol());
		indexRaisedKnuckleRightHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-04-01"), indexRaisedKnuckleRightHandPitched.getSymbol());

		indexRaisedKnuckleLeftHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-04-16"), indexRaisedKnuckleLeftHandPitched.getSymbol());
		indexRaisedKnuckleLeftHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-04-15"), indexRaisedKnuckleLeftHandPitched.getSymbol());
		indexRaisedKnuckleLeftHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-04-14"), indexRaisedKnuckleLeftHandPitched.getSymbol());
		indexRaisedKnuckleLeftHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-04-13"), indexRaisedKnuckleLeftHandPitched.getSymbol());
		indexRaisedKnuckleLeftHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-04-12"), indexRaisedKnuckleLeftHandPitched.getSymbol());
		indexRaisedKnuckleLeftHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-04-11"), indexRaisedKnuckleLeftHandPitched.getSymbol());
		indexRaisedKnuckleLeftHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-04-10"), indexRaisedKnuckleLeftHandPitched.getSymbol());
		indexRaisedKnuckleLeftHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-04-09"), indexRaisedKnuckleLeftHandPitched.getSymbol());

		indexRaisedKnuckleRightHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-05-02"),
				indexRaisedKnuckleRightHandHalfTurnPitched.getSymbol());
		indexRaisedKnuckleRightHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-05-03"),
				indexRaisedKnuckleRightHandHalfTurnPitched.getSymbol());
		indexRaisedKnuckleRightHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-05-04"),
				indexRaisedKnuckleRightHandHalfTurnPitched.getSymbol());
		indexRaisedKnuckleRightHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-05-05"),
				indexRaisedKnuckleRightHandHalfTurnPitched.getSymbol());
		indexRaisedKnuckleRightHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-05-06"),
				indexRaisedKnuckleRightHandHalfTurnPitched.getSymbol());
		indexRaisedKnuckleRightHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-05-07"),
				indexRaisedKnuckleRightHandHalfTurnPitched.getSymbol());
		indexRaisedKnuckleRightHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-05-08"),
				indexRaisedKnuckleRightHandHalfTurnPitched.getSymbol());
		indexRaisedKnuckleRightHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-05-01"),
				indexRaisedKnuckleRightHandHalfTurnPitched.getSymbol());

		indexRaisedKnuckleLeftHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-05-16"),
				indexRaisedKnuckleLeftHandHalfTurnPitched.getSymbol());
		indexRaisedKnuckleLeftHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-05-15"),
				indexRaisedKnuckleLeftHandHalfTurnPitched.getSymbol());
		indexRaisedKnuckleLeftHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-05-14"),
				indexRaisedKnuckleLeftHandHalfTurnPitched.getSymbol());
		indexRaisedKnuckleLeftHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-05-13"),
				indexRaisedKnuckleLeftHandHalfTurnPitched.getSymbol());
		indexRaisedKnuckleLeftHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-05-12"),
				indexRaisedKnuckleLeftHandHalfTurnPitched.getSymbol());
		indexRaisedKnuckleLeftHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-05-11"),
				indexRaisedKnuckleLeftHandHalfTurnPitched.getSymbol());
		indexRaisedKnuckleLeftHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-05-10"),
				indexRaisedKnuckleLeftHandHalfTurnPitched.getSymbol());
		indexRaisedKnuckleLeftHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-05-09"),
				indexRaisedKnuckleLeftHandHalfTurnPitched.getSymbol());

		indexRaisedKnuckleRightHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-06-02"),
				indexRaisedKnuckleRightHandFullTurnPitched.getSymbol());
		indexRaisedKnuckleRightHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-06-03"),
				indexRaisedKnuckleRightHandFullTurnPitched.getSymbol());
		indexRaisedKnuckleRightHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-06-04"),
				indexRaisedKnuckleRightHandFullTurnPitched.getSymbol());
		indexRaisedKnuckleRightHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-06-05"),
				indexRaisedKnuckleRightHandFullTurnPitched.getSymbol());
		indexRaisedKnuckleRightHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-06-06"),
				indexRaisedKnuckleRightHandFullTurnPitched.getSymbol());
		indexRaisedKnuckleRightHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-06-07"),
				indexRaisedKnuckleRightHandFullTurnPitched.getSymbol());
		indexRaisedKnuckleRightHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-06-08"),
				indexRaisedKnuckleRightHandFullTurnPitched.getSymbol());
		indexRaisedKnuckleRightHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-06-01"),
				indexRaisedKnuckleRightHandFullTurnPitched.getSymbol());

		indexRaisedKnuckleLeftHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-06-16"),
				indexRaisedKnuckleLeftHandFullTurnPitched.getSymbol());
		indexRaisedKnuckleLeftHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-06-15"),
				indexRaisedKnuckleLeftHandFullTurnPitched.getSymbol());
		indexRaisedKnuckleLeftHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-06-14"),
				indexRaisedKnuckleLeftHandFullTurnPitched.getSymbol());
		indexRaisedKnuckleLeftHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-06-13"),
				indexRaisedKnuckleLeftHandFullTurnPitched.getSymbol());
		indexRaisedKnuckleLeftHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-06-12"),
				indexRaisedKnuckleLeftHandFullTurnPitched.getSymbol());
		indexRaisedKnuckleLeftHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-06-11"),
				indexRaisedKnuckleLeftHandFullTurnPitched.getSymbol());
		indexRaisedKnuckleLeftHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-06-10"),
				indexRaisedKnuckleLeftHandFullTurnPitched.getSymbol());
		indexRaisedKnuckleLeftHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-06-09"),
				indexRaisedKnuckleLeftHandFullTurnPitched.getSymbol());

		indexCupRightHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-01-02"), indexCupRightHand.getSymbol());
		indexCupRightHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-01-03"), indexCupRightHand.getSymbol());
		indexCupRightHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-01-04"), indexCupRightHand.getSymbol());
		indexCupRightHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-01-05"), indexCupRightHand.getSymbol());
		indexCupRightHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-01-06"), indexCupRightHand.getSymbol());
		indexCupRightHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-01-07"), indexCupRightHand.getSymbol());
		indexCupRightHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-01-08"), indexCupRightHand.getSymbol());
		indexCupRightHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-01-01"), indexCupRightHand.getSymbol());

		indexCupLeftHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-01-16"), indexCupLeftHand.getSymbol());
		indexCupLeftHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-01-15"), indexCupLeftHand.getSymbol());
		indexCupLeftHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-01-14"), indexCupLeftHand.getSymbol());
		indexCupLeftHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-01-13"), indexCupLeftHand.getSymbol());
		indexCupLeftHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-01-12"), indexCupLeftHand.getSymbol());
		indexCupLeftHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-01-11"), indexCupLeftHand.getSymbol());
		indexCupLeftHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-01-10"), indexCupLeftHand.getSymbol());
		indexCupLeftHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-01-09"), indexCupLeftHand.getSymbol());

		indexCupRightHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-02-02"), indexCupRightHandHalfTurn.getSymbol());
		indexCupRightHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-02-03"), indexCupRightHandHalfTurn.getSymbol());
		indexCupRightHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-02-04"), indexCupRightHandHalfTurn.getSymbol());
		indexCupRightHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-02-05"), indexCupRightHandHalfTurn.getSymbol());
		indexCupRightHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-02-06"), indexCupRightHandHalfTurn.getSymbol());
		indexCupRightHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-02-07"), indexCupRightHandHalfTurn.getSymbol());
		indexCupRightHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-02-08"), indexCupRightHandHalfTurn.getSymbol());
		indexCupRightHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-02-01"), indexCupRightHandHalfTurn.getSymbol());

		indexCupLeftHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-02-16"), indexCupLeftHandHalfTurn.getSymbol());
		indexCupLeftHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-02-15"), indexCupLeftHandHalfTurn.getSymbol());
		indexCupLeftHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-02-14"), indexCupLeftHandHalfTurn.getSymbol());
		indexCupLeftHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-02-13"), indexCupLeftHandHalfTurn.getSymbol());
		indexCupLeftHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-02-12"), indexCupLeftHandHalfTurn.getSymbol());
		indexCupLeftHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-02-11"), indexCupLeftHandHalfTurn.getSymbol());
		indexCupLeftHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-02-10"), indexCupLeftHandHalfTurn.getSymbol());
		indexCupLeftHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-02-09"), indexCupLeftHandHalfTurn.getSymbol());

		indexCupRightHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-03-02"), indexCupRightHandFullTurn.getSymbol());
		indexCupRightHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-03-03"), indexCupRightHandFullTurn.getSymbol());
		indexCupRightHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-03-04"), indexCupRightHandFullTurn.getSymbol());
		indexCupRightHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-03-05"), indexCupRightHandFullTurn.getSymbol());
		indexCupRightHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-03-06"), indexCupRightHandFullTurn.getSymbol());
		indexCupRightHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-03-07"), indexCupRightHandFullTurn.getSymbol());
		indexCupRightHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-03-08"), indexCupRightHandFullTurn.getSymbol());
		indexCupRightHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-03-01"), indexCupRightHandFullTurn.getSymbol());

		indexCupLeftHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-03-16"), indexCupLeftHandFullTurn.getSymbol());
		indexCupLeftHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-03-15"), indexCupLeftHandFullTurn.getSymbol());
		indexCupLeftHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-03-14"), indexCupLeftHandFullTurn.getSymbol());
		indexCupLeftHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-03-13"), indexCupLeftHandFullTurn.getSymbol());
		indexCupLeftHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-03-12"), indexCupLeftHandFullTurn.getSymbol());
		indexCupLeftHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-03-11"), indexCupLeftHandFullTurn.getSymbol());
		indexCupLeftHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-03-10"), indexCupLeftHandFullTurn.getSymbol());
		indexCupLeftHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-03-09"), indexCupLeftHandFullTurn.getSymbol());

		indexCupRightHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-04-02"), indexCupRightHandPitched.getSymbol());
		indexCupRightHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-04-03"), indexCupRightHandPitched.getSymbol());
		indexCupRightHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-04-04"), indexCupRightHandPitched.getSymbol());
		indexCupRightHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-04-05"), indexCupRightHandPitched.getSymbol());
		indexCupRightHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-04-06"), indexCupRightHandPitched.getSymbol());
		indexCupRightHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-04-07"), indexCupRightHandPitched.getSymbol());
		indexCupRightHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-04-08"), indexCupRightHandPitched.getSymbol());
		indexCupRightHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-04-01"), indexCupRightHandPitched.getSymbol());

		indexCupLeftHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-04-16"), indexCupLeftHandPitched.getSymbol());
		indexCupLeftHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-04-15"), indexCupLeftHandPitched.getSymbol());
		indexCupLeftHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-04-14"), indexCupLeftHandPitched.getSymbol());
		indexCupLeftHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-04-13"), indexCupLeftHandPitched.getSymbol());
		indexCupLeftHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-04-12"), indexCupLeftHandPitched.getSymbol());
		indexCupLeftHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-04-11"), indexCupLeftHandPitched.getSymbol());
		indexCupLeftHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-04-10"), indexCupLeftHandPitched.getSymbol());
		indexCupLeftHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-04-09"), indexCupLeftHandPitched.getSymbol());

		indexCupRightHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-05-02"), indexCupRightHandHalfTurnPitched.getSymbol());
		indexCupRightHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-05-03"), indexCupRightHandHalfTurnPitched.getSymbol());
		indexCupRightHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-05-04"), indexCupRightHandHalfTurnPitched.getSymbol());
		indexCupRightHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-05-05"), indexCupRightHandHalfTurnPitched.getSymbol());
		indexCupRightHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-05-06"), indexCupRightHandHalfTurnPitched.getSymbol());
		indexCupRightHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-05-07"), indexCupRightHandHalfTurnPitched.getSymbol());
		indexCupRightHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-05-08"), indexCupRightHandHalfTurnPitched.getSymbol());
		indexCupRightHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-05-01"), indexCupRightHandHalfTurnPitched.getSymbol());

		indexCupLeftHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-05-16"), indexCupLeftHandHalfTurnPitched.getSymbol());
		indexCupLeftHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-05-15"), indexCupLeftHandHalfTurnPitched.getSymbol());
		indexCupLeftHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-05-14"), indexCupLeftHandHalfTurnPitched.getSymbol());
		indexCupLeftHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-05-13"), indexCupLeftHandHalfTurnPitched.getSymbol());
		indexCupLeftHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-05-12"), indexCupLeftHandHalfTurnPitched.getSymbol());
		indexCupLeftHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-05-11"), indexCupLeftHandHalfTurnPitched.getSymbol());
		indexCupLeftHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-05-10"), indexCupLeftHandHalfTurnPitched.getSymbol());
		indexCupLeftHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-05-09"), indexCupLeftHandHalfTurnPitched.getSymbol());

		indexCupRightHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-06-02"), indexCupRightHandFullTurnPitched.getSymbol());
		indexCupRightHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-06-03"), indexCupRightHandFullTurnPitched.getSymbol());
		indexCupRightHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-06-04"), indexCupRightHandFullTurnPitched.getSymbol());
		indexCupRightHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-06-05"), indexCupRightHandFullTurnPitched.getSymbol());
		indexCupRightHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-06-06"), indexCupRightHandFullTurnPitched.getSymbol());
		indexCupRightHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-06-07"), indexCupRightHandFullTurnPitched.getSymbol());
		indexCupRightHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-06-08"), indexCupRightHandFullTurnPitched.getSymbol());
		indexCupRightHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-06-01"), indexCupRightHandFullTurnPitched.getSymbol());

		indexCupLeftHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-06-16"), indexCupLeftHandFullTurnPitched.getSymbol());
		indexCupLeftHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-06-15"), indexCupLeftHandFullTurnPitched.getSymbol());
		indexCupLeftHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-06-14"), indexCupLeftHandFullTurnPitched.getSymbol());
		indexCupLeftHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-06-13"), indexCupLeftHandFullTurnPitched.getSymbol());
		indexCupLeftHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-06-12"), indexCupLeftHandFullTurnPitched.getSymbol());
		indexCupLeftHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-06-11"), indexCupLeftHandFullTurnPitched.getSymbol());
		indexCupLeftHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-06-10"), indexCupLeftHandFullTurnPitched.getSymbol());
		indexCupLeftHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-06-09"), indexCupLeftHandFullTurnPitched.getSymbol());

		indexHingeOnFistRightHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-01-02"), indexHingeOnFistRightHand.getSymbol());
		indexHingeOnFistRightHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-01-03"), indexHingeOnFistRightHand.getSymbol());
		indexHingeOnFistRightHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-01-04"), indexHingeOnFistRightHand.getSymbol());
		indexHingeOnFistRightHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-01-05"), indexHingeOnFistRightHand.getSymbol());
		indexHingeOnFistRightHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-01-06"), indexHingeOnFistRightHand.getSymbol());
		indexHingeOnFistRightHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-01-07"), indexHingeOnFistRightHand.getSymbol());
		indexHingeOnFistRightHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-01-08"), indexHingeOnFistRightHand.getSymbol());
		indexHingeOnFistRightHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-01-01"), indexHingeOnFistRightHand.getSymbol());

		indexHingeOnFistLeftHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-01-16"), indexHingeOnFistLeftHand.getSymbol());
		indexHingeOnFistLeftHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-01-15"), indexHingeOnFistLeftHand.getSymbol());
		indexHingeOnFistLeftHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-01-14"), indexHingeOnFistLeftHand.getSymbol());
		indexHingeOnFistLeftHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-01-13"), indexHingeOnFistLeftHand.getSymbol());
		indexHingeOnFistLeftHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-01-12"), indexHingeOnFistLeftHand.getSymbol());
		indexHingeOnFistLeftHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-01-11"), indexHingeOnFistLeftHand.getSymbol());
		indexHingeOnFistLeftHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-01-10"), indexHingeOnFistLeftHand.getSymbol());
		indexHingeOnFistLeftHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-01-09"), indexHingeOnFistLeftHand.getSymbol());

		indexHingeOnFistRightHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-02-02"), indexHingeOnFistRightHandHalfTurn.getSymbol());
		indexHingeOnFistRightHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-02-03"), indexHingeOnFistRightHandHalfTurn.getSymbol());
		indexHingeOnFistRightHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-02-04"), indexHingeOnFistRightHandHalfTurn.getSymbol());
		indexHingeOnFistRightHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-02-05"), indexHingeOnFistRightHandHalfTurn.getSymbol());
		indexHingeOnFistRightHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-02-06"), indexHingeOnFistRightHandHalfTurn.getSymbol());
		indexHingeOnFistRightHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-02-07"), indexHingeOnFistRightHandHalfTurn.getSymbol());
		indexHingeOnFistRightHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-02-08"), indexHingeOnFistRightHandHalfTurn.getSymbol());
		indexHingeOnFistRightHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-02-01"), indexHingeOnFistRightHandHalfTurn.getSymbol());

		indexHingeOnFistLeftHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-02-16"), indexHingeOnFistLeftHandHalfTurn.getSymbol());
		indexHingeOnFistLeftHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-02-15"), indexHingeOnFistLeftHandHalfTurn.getSymbol());
		indexHingeOnFistLeftHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-02-14"), indexHingeOnFistLeftHandHalfTurn.getSymbol());
		indexHingeOnFistLeftHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-02-13"), indexHingeOnFistLeftHandHalfTurn.getSymbol());
		indexHingeOnFistLeftHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-02-12"), indexHingeOnFistLeftHandHalfTurn.getSymbol());
		indexHingeOnFistLeftHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-02-11"), indexHingeOnFistLeftHandHalfTurn.getSymbol());
		indexHingeOnFistLeftHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-02-10"), indexHingeOnFistLeftHandHalfTurn.getSymbol());
		indexHingeOnFistLeftHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-02-09"), indexHingeOnFistLeftHandHalfTurn.getSymbol());

		indexHingeOnFistRightHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-03-02"), indexHingeOnFistRightHandFullTurn.getSymbol());
		indexHingeOnFistRightHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-03-03"), indexHingeOnFistRightHandFullTurn.getSymbol());
		indexHingeOnFistRightHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-03-04"), indexHingeOnFistRightHandFullTurn.getSymbol());
		indexHingeOnFistRightHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-03-05"), indexHingeOnFistRightHandFullTurn.getSymbol());
		indexHingeOnFistRightHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-03-06"), indexHingeOnFistRightHandFullTurn.getSymbol());
		indexHingeOnFistRightHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-03-07"), indexHingeOnFistRightHandFullTurn.getSymbol());
		indexHingeOnFistRightHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-03-08"), indexHingeOnFistRightHandFullTurn.getSymbol());
		indexHingeOnFistRightHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-03-01"), indexHingeOnFistRightHandFullTurn.getSymbol());

		indexHingeOnFistLeftHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-03-16"), indexHingeOnFistLeftHandFullTurn.getSymbol());
		indexHingeOnFistLeftHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-03-15"), indexHingeOnFistLeftHandFullTurn.getSymbol());
		indexHingeOnFistLeftHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-03-14"), indexHingeOnFistLeftHandFullTurn.getSymbol());
		indexHingeOnFistLeftHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-03-13"), indexHingeOnFistLeftHandFullTurn.getSymbol());
		indexHingeOnFistLeftHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-03-12"), indexHingeOnFistLeftHandFullTurn.getSymbol());
		indexHingeOnFistLeftHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-03-11"), indexHingeOnFistLeftHandFullTurn.getSymbol());
		indexHingeOnFistLeftHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-03-10"), indexHingeOnFistLeftHandFullTurn.getSymbol());
		indexHingeOnFistLeftHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-03-09"), indexHingeOnFistLeftHandFullTurn.getSymbol());

		indexHingeOnFistRightHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-04-02"), indexHingeOnFistRightHandPitched.getSymbol());
		indexHingeOnFistRightHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-04-03"), indexHingeOnFistRightHandPitched.getSymbol());
		indexHingeOnFistRightHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-04-04"), indexHingeOnFistRightHandPitched.getSymbol());
		indexHingeOnFistRightHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-04-05"), indexHingeOnFistRightHandPitched.getSymbol());
		indexHingeOnFistRightHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-04-06"), indexHingeOnFistRightHandPitched.getSymbol());
		indexHingeOnFistRightHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-04-07"), indexHingeOnFistRightHandPitched.getSymbol());
		indexHingeOnFistRightHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-04-08"), indexHingeOnFistRightHandPitched.getSymbol());
		indexHingeOnFistRightHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-04-01"), indexHingeOnFistRightHandPitched.getSymbol());

		indexHingeOnFistLeftHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-04-16"), indexHingeOnFistLeftHandPitched.getSymbol());
		indexHingeOnFistLeftHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-04-15"), indexHingeOnFistLeftHandPitched.getSymbol());
		indexHingeOnFistLeftHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-04-14"), indexHingeOnFistLeftHandPitched.getSymbol());
		indexHingeOnFistLeftHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-04-13"), indexHingeOnFistLeftHandPitched.getSymbol());
		indexHingeOnFistLeftHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-04-12"), indexHingeOnFistLeftHandPitched.getSymbol());
		indexHingeOnFistLeftHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-04-11"), indexHingeOnFistLeftHandPitched.getSymbol());
		indexHingeOnFistLeftHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-04-10"), indexHingeOnFistLeftHandPitched.getSymbol());
		indexHingeOnFistLeftHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-04-09"), indexHingeOnFistLeftHandPitched.getSymbol());

		indexHingeOnFistRightHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-05-02"),
				indexHingeOnFistRightHandHalfTurnPitched.getSymbol());
		indexHingeOnFistRightHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-05-03"),
				indexHingeOnFistRightHandHalfTurnPitched.getSymbol());
		indexHingeOnFistRightHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-05-04"),
				indexHingeOnFistRightHandHalfTurnPitched.getSymbol());
		indexHingeOnFistRightHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-05-05"),
				indexHingeOnFistRightHandHalfTurnPitched.getSymbol());
		indexHingeOnFistRightHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-05-06"),
				indexHingeOnFistRightHandHalfTurnPitched.getSymbol());
		indexHingeOnFistRightHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-05-07"),
				indexHingeOnFistRightHandHalfTurnPitched.getSymbol());
		indexHingeOnFistRightHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-05-08"),
				indexHingeOnFistRightHandHalfTurnPitched.getSymbol());
		indexHingeOnFistRightHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-05-01"),
				indexHingeOnFistRightHandHalfTurnPitched.getSymbol());

		indexHingeOnFistLeftHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-05-16"),
				indexHingeOnFistLeftHandHalfTurnPitched.getSymbol());
		indexHingeOnFistLeftHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-05-15"),
				indexHingeOnFistLeftHandHalfTurnPitched.getSymbol());
		indexHingeOnFistLeftHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-05-14"),
				indexHingeOnFistLeftHandHalfTurnPitched.getSymbol());
		indexHingeOnFistLeftHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-05-13"),
				indexHingeOnFistLeftHandHalfTurnPitched.getSymbol());
		indexHingeOnFistLeftHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-05-12"),
				indexHingeOnFistLeftHandHalfTurnPitched.getSymbol());
		indexHingeOnFistLeftHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-05-11"),
				indexHingeOnFistLeftHandHalfTurnPitched.getSymbol());
		indexHingeOnFistLeftHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-05-10"),
				indexHingeOnFistLeftHandHalfTurnPitched.getSymbol());
		indexHingeOnFistLeftHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-05-09"),
				indexHingeOnFistLeftHandHalfTurnPitched.getSymbol());

		indexHingeOnFistRightHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-06-02"),
				indexHingeOnFistRightHandFullTurnPitched.getSymbol());
		indexHingeOnFistRightHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-06-03"),
				indexHingeOnFistRightHandFullTurnPitched.getSymbol());
		indexHingeOnFistRightHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-06-04"),
				indexHingeOnFistRightHandFullTurnPitched.getSymbol());
		indexHingeOnFistRightHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-06-05"),
				indexHingeOnFistRightHandFullTurnPitched.getSymbol());
		indexHingeOnFistRightHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-06-06"),
				indexHingeOnFistRightHandFullTurnPitched.getSymbol());
		indexHingeOnFistRightHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-06-07"),
				indexHingeOnFistRightHandFullTurnPitched.getSymbol());
		indexHingeOnFistRightHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-06-08"),
				indexHingeOnFistRightHandFullTurnPitched.getSymbol());
		indexHingeOnFistRightHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-06-01"),
				indexHingeOnFistRightHandFullTurnPitched.getSymbol());

		indexHingeOnFistLeftHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-06-16"),
				indexHingeOnFistLeftHandFullTurnPitched.getSymbol());
		indexHingeOnFistLeftHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-06-15"),
				indexHingeOnFistLeftHandFullTurnPitched.getSymbol());
		indexHingeOnFistLeftHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-06-14"),
				indexHingeOnFistLeftHandFullTurnPitched.getSymbol());
		indexHingeOnFistLeftHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-06-13"),
				indexHingeOnFistLeftHandFullTurnPitched.getSymbol());
		indexHingeOnFistLeftHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-06-12"),
				indexHingeOnFistLeftHandFullTurnPitched.getSymbol());
		indexHingeOnFistLeftHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-06-11"),
				indexHingeOnFistLeftHandFullTurnPitched.getSymbol());
		indexHingeOnFistLeftHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-06-10"),
				indexHingeOnFistLeftHandFullTurnPitched.getSymbol());
		indexHingeOnFistLeftHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-06-09"),
				indexHingeOnFistLeftHandFullTurnPitched.getSymbol());

		indexHingeOnFistLowRightHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-01-02"), indexHingeOnFistLowRightHand.getSymbol());
		indexHingeOnFistLowRightHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-01-03"), indexHingeOnFistLowRightHand.getSymbol());
		indexHingeOnFistLowRightHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-01-04"), indexHingeOnFistLowRightHand.getSymbol());
		indexHingeOnFistLowRightHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-01-05"), indexHingeOnFistLowRightHand.getSymbol());
		indexHingeOnFistLowRightHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-01-06"), indexHingeOnFistLowRightHand.getSymbol());
		indexHingeOnFistLowRightHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-01-07"), indexHingeOnFistLowRightHand.getSymbol());
		indexHingeOnFistLowRightHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-01-08"), indexHingeOnFistLowRightHand.getSymbol());
		indexHingeOnFistLowRightHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-01-01"), indexHingeOnFistLowRightHand.getSymbol());

		indexHingeOnFistLowLeftHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-01-16"), indexHingeOnFistLowLeftHand.getSymbol());
		indexHingeOnFistLowLeftHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-01-15"), indexHingeOnFistLowLeftHand.getSymbol());
		indexHingeOnFistLowLeftHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-01-14"), indexHingeOnFistLowLeftHand.getSymbol());
		indexHingeOnFistLowLeftHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-01-13"), indexHingeOnFistLowLeftHand.getSymbol());
		indexHingeOnFistLowLeftHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-01-12"), indexHingeOnFistLowLeftHand.getSymbol());
		indexHingeOnFistLowLeftHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-01-11"), indexHingeOnFistLowLeftHand.getSymbol());
		indexHingeOnFistLowLeftHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-01-10"), indexHingeOnFistLowLeftHand.getSymbol());
		indexHingeOnFistLowLeftHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-01-09"), indexHingeOnFistLowLeftHand.getSymbol());

		indexHingeOnFistLowRightHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-02-02"),
				indexHingeOnFistLowRightHandHalfTurn.getSymbol());
		indexHingeOnFistLowRightHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-02-03"),
				indexHingeOnFistLowRightHandHalfTurn.getSymbol());
		indexHingeOnFistLowRightHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-02-04"),
				indexHingeOnFistLowRightHandHalfTurn.getSymbol());
		indexHingeOnFistLowRightHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-02-05"),
				indexHingeOnFistLowRightHandHalfTurn.getSymbol());
		indexHingeOnFistLowRightHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-02-06"),
				indexHingeOnFistLowRightHandHalfTurn.getSymbol());
		indexHingeOnFistLowRightHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-02-07"),
				indexHingeOnFistLowRightHandHalfTurn.getSymbol());
		indexHingeOnFistLowRightHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-02-08"),
				indexHingeOnFistLowRightHandHalfTurn.getSymbol());
		indexHingeOnFistLowRightHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-02-01"),
				indexHingeOnFistLowRightHandHalfTurn.getSymbol());

		indexHingeOnFistLowLeftHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-02-16"), indexHingeOnFistLowLeftHandHalfTurn.getSymbol());
		indexHingeOnFistLowLeftHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-02-15"), indexHingeOnFistLowLeftHandHalfTurn.getSymbol());
		indexHingeOnFistLowLeftHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-02-14"), indexHingeOnFistLowLeftHandHalfTurn.getSymbol());
		indexHingeOnFistLowLeftHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-02-13"), indexHingeOnFistLowLeftHandHalfTurn.getSymbol());
		indexHingeOnFistLowLeftHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-02-12"), indexHingeOnFistLowLeftHandHalfTurn.getSymbol());
		indexHingeOnFistLowLeftHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-02-11"), indexHingeOnFistLowLeftHandHalfTurn.getSymbol());
		indexHingeOnFistLowLeftHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-02-10"), indexHingeOnFistLowLeftHandHalfTurn.getSymbol());
		indexHingeOnFistLowLeftHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-02-09"), indexHingeOnFistLowLeftHandHalfTurn.getSymbol());

		indexHingeOnFistLowRightHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-03-02"),
				indexHingeOnFistLowRightHandFullTurn.getSymbol());
		indexHingeOnFistLowRightHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-03-03"),
				indexHingeOnFistLowRightHandFullTurn.getSymbol());
		indexHingeOnFistLowRightHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-03-04"),
				indexHingeOnFistLowRightHandFullTurn.getSymbol());
		indexHingeOnFistLowRightHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-03-05"),
				indexHingeOnFistLowRightHandFullTurn.getSymbol());
		indexHingeOnFistLowRightHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-03-06"),
				indexHingeOnFistLowRightHandFullTurn.getSymbol());
		indexHingeOnFistLowRightHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-03-07"),
				indexHingeOnFistLowRightHandFullTurn.getSymbol());
		indexHingeOnFistLowRightHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-03-08"),
				indexHingeOnFistLowRightHandFullTurn.getSymbol());
		indexHingeOnFistLowRightHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-03-01"),
				indexHingeOnFistLowRightHandFullTurn.getSymbol());

		indexHingeOnFistLowLeftHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-03-16"), indexHingeOnFistLowLeftHandFullTurn.getSymbol());
		indexHingeOnFistLowLeftHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-03-15"), indexHingeOnFistLowLeftHandFullTurn.getSymbol());
		indexHingeOnFistLowLeftHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-03-14"), indexHingeOnFistLowLeftHandFullTurn.getSymbol());
		indexHingeOnFistLowLeftHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-03-13"), indexHingeOnFistLowLeftHandFullTurn.getSymbol());
		indexHingeOnFistLowLeftHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-03-12"), indexHingeOnFistLowLeftHandFullTurn.getSymbol());
		indexHingeOnFistLowLeftHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-03-11"), indexHingeOnFistLowLeftHandFullTurn.getSymbol());
		indexHingeOnFistLowLeftHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-03-10"), indexHingeOnFistLowLeftHandFullTurn.getSymbol());
		indexHingeOnFistLowLeftHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-03-09"), indexHingeOnFistLowLeftHandFullTurn.getSymbol());

		indexHingeOnFistLowRightHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-04-02"), indexHingeOnFistLowRightHandPitched.getSymbol());
		indexHingeOnFistLowRightHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-04-03"), indexHingeOnFistLowRightHandPitched.getSymbol());
		indexHingeOnFistLowRightHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-04-04"), indexHingeOnFistLowRightHandPitched.getSymbol());
		indexHingeOnFistLowRightHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-04-05"), indexHingeOnFistLowRightHandPitched.getSymbol());
		indexHingeOnFistLowRightHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-04-06"), indexHingeOnFistLowRightHandPitched.getSymbol());
		indexHingeOnFistLowRightHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-04-07"), indexHingeOnFistLowRightHandPitched.getSymbol());
		indexHingeOnFistLowRightHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-04-08"), indexHingeOnFistLowRightHandPitched.getSymbol());
		indexHingeOnFistLowRightHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-04-01"), indexHingeOnFistLowRightHandPitched.getSymbol());

		indexHingeOnFistLowLeftHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-04-16"), indexHingeOnFistLowLeftHandPitched.getSymbol());
		indexHingeOnFistLowLeftHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-04-15"), indexHingeOnFistLowLeftHandPitched.getSymbol());
		indexHingeOnFistLowLeftHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-04-14"), indexHingeOnFistLowLeftHandPitched.getSymbol());
		indexHingeOnFistLowLeftHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-04-13"), indexHingeOnFistLowLeftHandPitched.getSymbol());
		indexHingeOnFistLowLeftHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-04-12"), indexHingeOnFistLowLeftHandPitched.getSymbol());
		indexHingeOnFistLowLeftHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-04-11"), indexHingeOnFistLowLeftHandPitched.getSymbol());
		indexHingeOnFistLowLeftHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-04-10"), indexHingeOnFistLowLeftHandPitched.getSymbol());
		indexHingeOnFistLowLeftHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-04-09"), indexHingeOnFistLowLeftHandPitched.getSymbol());

		indexHingeOnFistLowRightHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-05-02"),
				indexHingeOnFistLowRightHandHalfTurnPitched.getSymbol());
		indexHingeOnFistLowRightHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-05-03"),
				indexHingeOnFistLowRightHandHalfTurnPitched.getSymbol());
		indexHingeOnFistLowRightHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-05-04"),
				indexHingeOnFistLowRightHandHalfTurnPitched.getSymbol());
		indexHingeOnFistLowRightHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-05-05"),
				indexHingeOnFistLowRightHandHalfTurnPitched.getSymbol());
		indexHingeOnFistLowRightHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-05-06"),
				indexHingeOnFistLowRightHandHalfTurnPitched.getSymbol());
		indexHingeOnFistLowRightHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-05-07"),
				indexHingeOnFistLowRightHandHalfTurnPitched.getSymbol());
		indexHingeOnFistLowRightHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-05-08"),
				indexHingeOnFistLowRightHandHalfTurnPitched.getSymbol());
		indexHingeOnFistLowRightHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-05-01"),
				indexHingeOnFistLowRightHandHalfTurnPitched.getSymbol());

		indexHingeOnFistLowLeftHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-05-16"),
				indexHingeOnFistLowLeftHandHalfTurnPitched.getSymbol());
		indexHingeOnFistLowLeftHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-05-15"),
				indexHingeOnFistLowLeftHandHalfTurnPitched.getSymbol());
		indexHingeOnFistLowLeftHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-05-14"),
				indexHingeOnFistLowLeftHandHalfTurnPitched.getSymbol());
		indexHingeOnFistLowLeftHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-05-13"),
				indexHingeOnFistLowLeftHandHalfTurnPitched.getSymbol());
		indexHingeOnFistLowLeftHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-05-12"),
				indexHingeOnFistLowLeftHandHalfTurnPitched.getSymbol());
		indexHingeOnFistLowLeftHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-05-11"),
				indexHingeOnFistLowLeftHandHalfTurnPitched.getSymbol());
		indexHingeOnFistLowLeftHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-05-10"),
				indexHingeOnFistLowLeftHandHalfTurnPitched.getSymbol());
		indexHingeOnFistLowLeftHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-05-09"),
				indexHingeOnFistLowLeftHandHalfTurnPitched.getSymbol());

		indexHingeOnFistLowRightHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-06-02"),
				indexHingeOnFistLowRightHandFullTurnPitched.getSymbol());
		indexHingeOnFistLowRightHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-06-03"),
				indexHingeOnFistLowRightHandFullTurnPitched.getSymbol());
		indexHingeOnFistLowRightHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-06-04"),
				indexHingeOnFistLowRightHandFullTurnPitched.getSymbol());
		indexHingeOnFistLowRightHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-06-05"),
				indexHingeOnFistLowRightHandFullTurnPitched.getSymbol());
		indexHingeOnFistLowRightHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-06-06"),
				indexHingeOnFistLowRightHandFullTurnPitched.getSymbol());
		indexHingeOnFistLowRightHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-06-07"),
				indexHingeOnFistLowRightHandFullTurnPitched.getSymbol());
		indexHingeOnFistLowRightHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-06-08"),
				indexHingeOnFistLowRightHandFullTurnPitched.getSymbol());
		indexHingeOnFistLowRightHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-06-01"),
				indexHingeOnFistLowRightHandFullTurnPitched.getSymbol());

		indexHingeOnFistLowLeftHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-06-16"),
				indexHingeOnFistLowLeftHandFullTurnPitched.getSymbol());
		indexHingeOnFistLowLeftHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-06-15"),
				indexHingeOnFistLowLeftHandFullTurnPitched.getSymbol());
		indexHingeOnFistLowLeftHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-06-14"),
				indexHingeOnFistLowLeftHandFullTurnPitched.getSymbol());
		indexHingeOnFistLowLeftHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-06-13"),
				indexHingeOnFistLowLeftHandFullTurnPitched.getSymbol());
		indexHingeOnFistLowLeftHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-06-12"),
				indexHingeOnFistLowLeftHandFullTurnPitched.getSymbol());
		indexHingeOnFistLowLeftHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-06-11"),
				indexHingeOnFistLowLeftHandFullTurnPitched.getSymbol());
		indexHingeOnFistLowLeftHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-06-10"),
				indexHingeOnFistLowLeftHandFullTurnPitched.getSymbol());
		indexHingeOnFistLowLeftHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-06-09"),
				indexHingeOnFistLowLeftHandFullTurnPitched.getSymbol());

		indexHingeOnCircleRightHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-01-02"), indexHingeOnCircleRightHand.getSymbol());
		indexHingeOnCircleRightHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-01-03"), indexHingeOnCircleRightHand.getSymbol());
		indexHingeOnCircleRightHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-01-04"), indexHingeOnCircleRightHand.getSymbol());
		indexHingeOnCircleRightHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-01-05"), indexHingeOnCircleRightHand.getSymbol());
		indexHingeOnCircleRightHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-01-06"), indexHingeOnCircleRightHand.getSymbol());
		indexHingeOnCircleRightHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-01-07"), indexHingeOnCircleRightHand.getSymbol());
		indexHingeOnCircleRightHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-01-08"), indexHingeOnCircleRightHand.getSymbol());
		indexHingeOnCircleRightHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-01-01"), indexHingeOnCircleRightHand.getSymbol());

		indexHingeOnCircleLeftHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-01-16"), indexHingeOnCircleLeftHand.getSymbol());
		indexHingeOnCircleLeftHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-01-15"), indexHingeOnCircleLeftHand.getSymbol());
		indexHingeOnCircleLeftHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-01-14"), indexHingeOnCircleLeftHand.getSymbol());
		indexHingeOnCircleLeftHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-01-13"), indexHingeOnCircleLeftHand.getSymbol());
		indexHingeOnCircleLeftHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-01-12"), indexHingeOnCircleLeftHand.getSymbol());
		indexHingeOnCircleLeftHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-01-11"), indexHingeOnCircleLeftHand.getSymbol());
		indexHingeOnCircleLeftHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-01-10"), indexHingeOnCircleLeftHand.getSymbol());
		indexHingeOnCircleLeftHand.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-01-09"), indexHingeOnCircleLeftHand.getSymbol());

		indexHingeOnCircleRightHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-02-02"), indexHingeOnCircleRightHandHalfTurn.getSymbol());
		indexHingeOnCircleRightHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-02-03"), indexHingeOnCircleRightHandHalfTurn.getSymbol());
		indexHingeOnCircleRightHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-02-04"), indexHingeOnCircleRightHandHalfTurn.getSymbol());
		indexHingeOnCircleRightHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-02-05"), indexHingeOnCircleRightHandHalfTurn.getSymbol());
		indexHingeOnCircleRightHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-02-06"), indexHingeOnCircleRightHandHalfTurn.getSymbol());
		indexHingeOnCircleRightHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-02-07"), indexHingeOnCircleRightHandHalfTurn.getSymbol());
		indexHingeOnCircleRightHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-02-08"), indexHingeOnCircleRightHandHalfTurn.getSymbol());
		indexHingeOnCircleRightHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-02-01"), indexHingeOnCircleRightHandHalfTurn.getSymbol());

		indexHingeOnCircleLeftHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-02-16"), indexHingeOnCircleLeftHandHalfTurn.getSymbol());
		indexHingeOnCircleLeftHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-02-15"), indexHingeOnCircleLeftHandHalfTurn.getSymbol());
		indexHingeOnCircleLeftHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-02-14"), indexHingeOnCircleLeftHandHalfTurn.getSymbol());
		indexHingeOnCircleLeftHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-02-13"), indexHingeOnCircleLeftHandHalfTurn.getSymbol());
		indexHingeOnCircleLeftHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-02-12"), indexHingeOnCircleLeftHandHalfTurn.getSymbol());
		indexHingeOnCircleLeftHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-02-11"), indexHingeOnCircleLeftHandHalfTurn.getSymbol());
		indexHingeOnCircleLeftHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-02-10"), indexHingeOnCircleLeftHandHalfTurn.getSymbol());
		indexHingeOnCircleLeftHandHalfTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-02-09"), indexHingeOnCircleLeftHandHalfTurn.getSymbol());

		indexHingeOnCircleRightHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-03-02"), indexHingeOnCircleRightHandFullTurn.getSymbol());
		indexHingeOnCircleRightHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-03-03"), indexHingeOnCircleRightHandFullTurn.getSymbol());
		indexHingeOnCircleRightHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-03-04"), indexHingeOnCircleRightHandFullTurn.getSymbol());
		indexHingeOnCircleRightHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-03-05"), indexHingeOnCircleRightHandFullTurn.getSymbol());
		indexHingeOnCircleRightHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-03-06"), indexHingeOnCircleRightHandFullTurn.getSymbol());
		indexHingeOnCircleRightHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-03-07"), indexHingeOnCircleRightHandFullTurn.getSymbol());
		indexHingeOnCircleRightHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-03-08"), indexHingeOnCircleRightHandFullTurn.getSymbol());
		indexHingeOnCircleRightHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-03-01"), indexHingeOnCircleRightHandFullTurn.getSymbol());

		indexHingeOnCircleLeftHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-03-16"), indexHingeOnCircleLeftHandFullTurn.getSymbol());
		indexHingeOnCircleLeftHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-03-15"), indexHingeOnCircleLeftHandFullTurn.getSymbol());
		indexHingeOnCircleLeftHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-03-14"), indexHingeOnCircleLeftHandFullTurn.getSymbol());
		indexHingeOnCircleLeftHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-03-13"), indexHingeOnCircleLeftHandFullTurn.getSymbol());
		indexHingeOnCircleLeftHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-03-12"), indexHingeOnCircleLeftHandFullTurn.getSymbol());
		indexHingeOnCircleLeftHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-03-11"), indexHingeOnCircleLeftHandFullTurn.getSymbol());
		indexHingeOnCircleLeftHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-03-10"), indexHingeOnCircleLeftHandFullTurn.getSymbol());
		indexHingeOnCircleLeftHandFullTurn.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-03-09"), indexHingeOnCircleLeftHandFullTurn.getSymbol());

		indexHingeOnCircleRightHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-04-02"), indexHingeOnCircleRightHandPitched.getSymbol());
		indexHingeOnCircleRightHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-04-03"), indexHingeOnCircleRightHandPitched.getSymbol());
		indexHingeOnCircleRightHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-04-04"), indexHingeOnCircleRightHandPitched.getSymbol());
		indexHingeOnCircleRightHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-04-05"), indexHingeOnCircleRightHandPitched.getSymbol());
		indexHingeOnCircleRightHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-04-06"), indexHingeOnCircleRightHandPitched.getSymbol());
		indexHingeOnCircleRightHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-04-07"), indexHingeOnCircleRightHandPitched.getSymbol());
		indexHingeOnCircleRightHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-04-08"), indexHingeOnCircleRightHandPitched.getSymbol());
		indexHingeOnCircleRightHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-04-01"), indexHingeOnCircleRightHandPitched.getSymbol());

		indexHingeOnCircleLeftHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-04-16"), indexHingeOnCircleLeftHandPitched.getSymbol());
		indexHingeOnCircleLeftHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-04-15"), indexHingeOnCircleLeftHandPitched.getSymbol());
		indexHingeOnCircleLeftHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-04-14"), indexHingeOnCircleLeftHandPitched.getSymbol());
		indexHingeOnCircleLeftHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-04-13"), indexHingeOnCircleLeftHandPitched.getSymbol());
		indexHingeOnCircleLeftHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-04-12"), indexHingeOnCircleLeftHandPitched.getSymbol());
		indexHingeOnCircleLeftHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-04-11"), indexHingeOnCircleLeftHandPitched.getSymbol());
		indexHingeOnCircleLeftHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-04-10"), indexHingeOnCircleLeftHandPitched.getSymbol());
		indexHingeOnCircleLeftHandPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-04-09"), indexHingeOnCircleLeftHandPitched.getSymbol());

		indexHingeOnCircleRightHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-05-02"),
				indexHingeOnCircleRightHandHalfTurnPitched.getSymbol());
		indexHingeOnCircleRightHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-05-03"),
				indexHingeOnCircleRightHandHalfTurnPitched.getSymbol());
		indexHingeOnCircleRightHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-05-04"),
				indexHingeOnCircleRightHandHalfTurnPitched.getSymbol());
		indexHingeOnCircleRightHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-05-05"),
				indexHingeOnCircleRightHandHalfTurnPitched.getSymbol());
		indexHingeOnCircleRightHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-05-06"),
				indexHingeOnCircleRightHandHalfTurnPitched.getSymbol());
		indexHingeOnCircleRightHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-05-07"),
				indexHingeOnCircleRightHandHalfTurnPitched.getSymbol());
		indexHingeOnCircleRightHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-05-08"),
				indexHingeOnCircleRightHandHalfTurnPitched.getSymbol());
		indexHingeOnCircleRightHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-05-01"),
				indexHingeOnCircleRightHandHalfTurnPitched.getSymbol());

		indexHingeOnCircleLeftHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-05-16"),
				indexHingeOnCircleLeftHandHalfTurnPitched.getSymbol());
		indexHingeOnCircleLeftHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-05-15"),
				indexHingeOnCircleLeftHandHalfTurnPitched.getSymbol());
		indexHingeOnCircleLeftHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-05-14"),
				indexHingeOnCircleLeftHandHalfTurnPitched.getSymbol());
		indexHingeOnCircleLeftHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-05-13"),
				indexHingeOnCircleLeftHandHalfTurnPitched.getSymbol());
		indexHingeOnCircleLeftHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-05-12"),
				indexHingeOnCircleLeftHandHalfTurnPitched.getSymbol());
		indexHingeOnCircleLeftHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-05-11"),
				indexHingeOnCircleLeftHandHalfTurnPitched.getSymbol());
		indexHingeOnCircleLeftHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-05-10"),
				indexHingeOnCircleLeftHandHalfTurnPitched.getSymbol());
		indexHingeOnCircleLeftHandHalfTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-05-09"),
				indexHingeOnCircleLeftHandHalfTurnPitched.getSymbol());

		indexHingeOnCircleRightHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-06-02"),
				indexHingeOnCircleRightHandFullTurnPitched.getSymbol());
		indexHingeOnCircleRightHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-06-03"),
				indexHingeOnCircleRightHandFullTurnPitched.getSymbol());
		indexHingeOnCircleRightHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-06-04"),
				indexHingeOnCircleRightHandFullTurnPitched.getSymbol());
		indexHingeOnCircleRightHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-06-05"),
				indexHingeOnCircleRightHandFullTurnPitched.getSymbol());
		indexHingeOnCircleRightHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-06-06"),
				indexHingeOnCircleRightHandFullTurnPitched.getSymbol());
		indexHingeOnCircleRightHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-06-07"),
				indexHingeOnCircleRightHandFullTurnPitched.getSymbol());
		indexHingeOnCircleRightHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-06-08"),
				indexHingeOnCircleRightHandFullTurnPitched.getSymbol());
		indexHingeOnCircleRightHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-06-01"),
				indexHingeOnCircleRightHandFullTurnPitched.getSymbol());

		indexHingeOnCircleLeftHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-06-16"),
				indexHingeOnCircleLeftHandFullTurnPitched.getSymbol());
		indexHingeOnCircleLeftHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-06-15"),
				indexHingeOnCircleLeftHandFullTurnPitched.getSymbol());
		indexHingeOnCircleLeftHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-06-14"),
				indexHingeOnCircleLeftHandFullTurnPitched.getSymbol());
		indexHingeOnCircleLeftHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-06-13"),
				indexHingeOnCircleLeftHandFullTurnPitched.getSymbol());
		indexHingeOnCircleLeftHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-06-12"),
				indexHingeOnCircleLeftHandFullTurnPitched.getSymbol());
		indexHingeOnCircleLeftHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-06-11"),
				indexHingeOnCircleLeftHandFullTurnPitched.getSymbol());
		indexHingeOnCircleLeftHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-06-10"),
				indexHingeOnCircleLeftHandFullTurnPitched.getSymbol());
		indexHingeOnCircleLeftHandFullTurnPitched.rotateCounterClockwise();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-06-09"),
				indexHingeOnCircleLeftHandFullTurnPitched.getSymbol());

	}

	@Override
	public void testCanMirror() {

		assertTrue(indexRightHand.canMirror());
		assertTrue(indexLeftHand.canMirror());
		assertTrue(indexRightHandHalfTurn.canMirror());
		assertTrue(indexLeftHandHalfTurn.canMirror());
		assertTrue(indexRightHandFullTurn.canMirror());
		assertTrue(indexLeftHandFullTurn.canMirror());
		assertTrue(indexRightHandPitched.canMirror());
		assertTrue(indexLeftHandPitched.canMirror());
		assertTrue(indexRightHandHalfTurnPitched.canMirror());
		assertTrue(indexLeftHandHalfTurnPitched.canMirror());
		assertTrue(indexRightHandFullTurnPitched.canMirror());
		assertTrue(indexLeftHandFullTurnPitched.canMirror());

		assertTrue(indexOnCircleRightHand.canMirror());
		assertTrue(indexOnCircleLeftHand.canMirror());
		assertTrue(indexOnCircleRightHandHalfTurn.canMirror());
		assertTrue(indexOnCircleLeftHandHalfTurn.canMirror());
		assertTrue(indexOnCircleRightHandFullTurn.canMirror());
		assertTrue(indexOnCircleLeftHandFullTurn.canMirror());
		assertTrue(indexOnCircleRightHandPitched.canMirror());
		assertTrue(indexOnCircleLeftHandPitched.canMirror());
		assertTrue(indexOnCircleRightHandHalfTurnPitched.canMirror());
		assertTrue(indexOnCircleLeftHandHalfTurnPitched.canMirror());
		assertTrue(indexOnCircleRightHandFullTurnPitched.canMirror());
		assertTrue(indexOnCircleLeftHandFullTurnPitched.canMirror());

		assertTrue(indexOnCupRightHand.canMirror());
		assertTrue(indexOnCupLeftHand.canMirror());
		assertTrue(indexOnCupRightHandHalfTurn.canMirror());
		assertTrue(indexOnCupLeftHandHalfTurn.canMirror());
		assertTrue(indexOnCupRightHandFullTurn.canMirror());
		assertTrue(indexOnCupLeftHandFullTurn.canMirror());
		assertTrue(indexOnCupRightHandPitched.canMirror());
		assertTrue(indexOnCupLeftHandPitched.canMirror());
		assertTrue(indexOnCupRightHandHalfTurnPitched.canMirror());
		assertTrue(indexOnCupLeftHandHalfTurnPitched.canMirror());
		assertTrue(indexOnCupRightHandFullTurnPitched.canMirror());
		assertTrue(indexOnCupLeftHandFullTurnPitched.canMirror());

		assertTrue(indexOnOvalRightHand.canMirror());
		assertTrue(indexOnOvalLeftHand.canMirror());
		assertTrue(indexOnOvalRightHandHalfTurn.canMirror());
		assertTrue(indexOnOvalLeftHandHalfTurn.canMirror());
		assertTrue(indexOnOvalRightHandFullTurn.canMirror());
		assertTrue(indexOnOvalLeftHandFullTurn.canMirror());
		assertTrue(indexOnOvalRightHandPitched.canMirror());
		assertTrue(indexOnOvalLeftHandPitched.canMirror());
		assertTrue(indexOnOvalRightHandHalfTurnPitched.canMirror());
		assertTrue(indexOnOvalLeftHandHalfTurnPitched.canMirror());
		assertTrue(indexOnOvalRightHandFullTurnPitched.canMirror());
		assertTrue(indexOnOvalLeftHandFullTurnPitched.canMirror());

		assertTrue(indexOnHingeRightHand.canMirror());
		assertTrue(indexOnHingeLeftHand.canMirror());
		assertTrue(indexOnHingeRightHandHalfTurn.canMirror());
		assertTrue(indexOnHingeLeftHandHalfTurn.canMirror());
		assertTrue(indexOnHingeRightHandFullTurn.canMirror());
		assertTrue(indexOnHingeLeftHandFullTurn.canMirror());
		assertTrue(indexOnHingeRightHandPitched.canMirror());
		assertTrue(indexOnHingeLeftHandPitched.canMirror());
		assertTrue(indexOnHingeRightHandHalfTurnPitched.canMirror());
		assertTrue(indexOnHingeLeftHandHalfTurnPitched.canMirror());
		assertTrue(indexOnHingeRightHandFullTurnPitched.canMirror());
		assertTrue(indexOnHingeLeftHandFullTurnPitched.canMirror());

		assertTrue(indexOnAngleRightHand.canMirror());
		assertTrue(indexOnAngleLeftHand.canMirror());
		assertTrue(indexOnAngleRightHandHalfTurn.canMirror());
		assertTrue(indexOnAngleLeftHandHalfTurn.canMirror());
		assertTrue(indexOnAngleRightHandFullTurn.canMirror());
		assertTrue(indexOnAngleLeftHandFullTurn.canMirror());
		assertTrue(indexOnAngleRightHandPitched.canMirror());
		assertTrue(indexOnAngleLeftHandPitched.canMirror());
		assertTrue(indexOnAngleRightHandHalfTurnPitched.canMirror());
		assertTrue(indexOnAngleLeftHandHalfTurnPitched.canMirror());
		assertTrue(indexOnAngleRightHandFullTurnPitched.canMirror());
		assertTrue(indexOnAngleLeftHandFullTurnPitched.canMirror());

		assertTrue(indexBentRightHand.canMirror());
		assertTrue(indexBentLeftHand.canMirror());
		assertTrue(indexBentRightHandHalfTurn.canMirror());
		assertTrue(indexBentLeftHandHalfTurn.canMirror());
		assertTrue(indexBentRightHandFullTurn.canMirror());
		assertTrue(indexBentLeftHandFullTurn.canMirror());
		assertTrue(indexBentRightHandPitched.canMirror());
		assertTrue(indexBentLeftHandPitched.canMirror());
		assertTrue(indexBentRightHandHalfTurnPitched.canMirror());
		assertTrue(indexBentLeftHandHalfTurnPitched.canMirror());
		assertTrue(indexBentRightHandFullTurnPitched.canMirror());
		assertTrue(indexBentLeftHandFullTurnPitched.canMirror());

		assertTrue(indexBentOnCircleRightHand.canMirror());
		assertTrue(indexBentOnCircleLeftHand.canMirror());
		assertTrue(indexBentOnCircleRightHandHalfTurn.canMirror());
		assertTrue(indexBentOnCircleLeftHandHalfTurn.canMirror());
		assertTrue(indexBentOnCircleRightHandFullTurn.canMirror());
		assertTrue(indexBentOnCircleLeftHandFullTurn.canMirror());
		assertTrue(indexBentOnCircleRightHandPitched.canMirror());
		assertTrue(indexBentOnCircleLeftHandPitched.canMirror());
		assertTrue(indexBentOnCircleRightHandHalfTurnPitched.canMirror());
		assertTrue(indexBentOnCircleLeftHandHalfTurnPitched.canMirror());
		assertTrue(indexBentOnCircleRightHandFullTurnPitched.canMirror());
		assertTrue(indexBentOnCircleLeftHandFullTurnPitched.canMirror());

		assertTrue(indexBentOnFistThumbUnderRightHand.canMirror());
		assertTrue(indexBentOnFistThumbUnderLeftHand.canMirror());
		assertTrue(indexBentOnFistThumbUnderRightHandHalfTurn.canMirror());
		assertTrue(indexBentOnFistThumbUnderLeftHandHalfTurn.canMirror());
		assertTrue(indexBentOnFistThumbUnderRightHandFullTurn.canMirror());
		assertTrue(indexBentOnFistThumbUnderLeftHandFullTurn.canMirror());
		assertTrue(indexBentOnFistThumbUnderRightHandPitched.canMirror());
		assertTrue(indexBentOnFistThumbUnderLeftHandPitched.canMirror());
		assertTrue(indexBentOnFistThumbUnderRightHandHalfTurnPitched.canMirror());
		assertTrue(indexBentOnFistThumbUnderLeftHandHalfTurnPitched.canMirror());
		assertTrue(indexBentOnFistThumbUnderRightHandFullTurnPitched.canMirror());
		assertTrue(indexBentOnFistThumbUnderLeftHandFullTurnPitched.canMirror());

		assertTrue(indexRaisedKnuckleRightHand.canMirror());
		assertTrue(indexRaisedKnuckleLeftHand.canMirror());
		assertTrue(indexRaisedKnuckleRightHandHalfTurn.canMirror());
		assertTrue(indexRaisedKnuckleLeftHandHalfTurn.canMirror());
		assertTrue(indexRaisedKnuckleRightHandFullTurn.canMirror());
		assertTrue(indexRaisedKnuckleLeftHandFullTurn.canMirror());
		assertTrue(indexRaisedKnuckleRightHandPitched.canMirror());
		assertTrue(indexRaisedKnuckleLeftHandPitched.canMirror());
		assertTrue(indexRaisedKnuckleRightHandHalfTurnPitched.canMirror());
		assertTrue(indexRaisedKnuckleLeftHandHalfTurnPitched.canMirror());
		assertTrue(indexRaisedKnuckleRightHandFullTurnPitched.canMirror());
		assertTrue(indexRaisedKnuckleLeftHandFullTurnPitched.canMirror());

		assertTrue(indexCupRightHand.canMirror());
		assertTrue(indexCupLeftHand.canMirror());
		assertTrue(indexCupRightHandHalfTurn.canMirror());
		assertTrue(indexCupLeftHandHalfTurn.canMirror());
		assertTrue(indexCupRightHandFullTurn.canMirror());
		assertTrue(indexCupLeftHandFullTurn.canMirror());
		assertTrue(indexCupRightHandPitched.canMirror());
		assertTrue(indexCupLeftHandPitched.canMirror());
		assertTrue(indexCupRightHandHalfTurnPitched.canMirror());
		assertTrue(indexCupLeftHandHalfTurnPitched.canMirror());
		assertTrue(indexCupRightHandFullTurnPitched.canMirror());
		assertTrue(indexCupLeftHandFullTurnPitched.canMirror());

		assertTrue(indexHingeOnFistRightHand.canMirror());
		assertTrue(indexHingeOnFistLeftHand.canMirror());
		assertTrue(indexHingeOnFistRightHandHalfTurn.canMirror());
		assertTrue(indexHingeOnFistLeftHandHalfTurn.canMirror());
		assertTrue(indexHingeOnFistRightHandFullTurn.canMirror());
		assertTrue(indexHingeOnFistLeftHandFullTurn.canMirror());
		assertTrue(indexHingeOnFistRightHandPitched.canMirror());
		assertTrue(indexHingeOnFistLeftHandPitched.canMirror());
		assertTrue(indexHingeOnFistRightHandHalfTurnPitched.canMirror());
		assertTrue(indexHingeOnFistLeftHandHalfTurnPitched.canMirror());
		assertTrue(indexHingeOnFistRightHandFullTurnPitched.canMirror());
		assertTrue(indexHingeOnFistLeftHandFullTurnPitched.canMirror());

		assertTrue(indexHingeOnFistLowRightHand.canMirror());
		assertTrue(indexHingeOnFistLowLeftHand.canMirror());
		assertTrue(indexHingeOnFistLowRightHandHalfTurn.canMirror());
		assertTrue(indexHingeOnFistLowLeftHandHalfTurn.canMirror());
		assertTrue(indexHingeOnFistLowRightHandFullTurn.canMirror());
		assertTrue(indexHingeOnFistLowLeftHandFullTurn.canMirror());
		assertTrue(indexHingeOnFistLowRightHandPitched.canMirror());
		assertTrue(indexHingeOnFistLowLeftHandPitched.canMirror());
		assertTrue(indexHingeOnFistLowRightHandHalfTurnPitched.canMirror());
		assertTrue(indexHingeOnFistLowLeftHandHalfTurnPitched.canMirror());
		assertTrue(indexHingeOnFistLowRightHandFullTurnPitched.canMirror());
		assertTrue(indexHingeOnFistLowLeftHandFullTurnPitched.canMirror());

		assertTrue(indexHingeOnCircleRightHand.canMirror());
		assertTrue(indexHingeOnCircleLeftHand.canMirror());
		assertTrue(indexHingeOnCircleRightHandHalfTurn.canMirror());
		assertTrue(indexHingeOnCircleLeftHandHalfTurn.canMirror());
		assertTrue(indexHingeOnCircleRightHandFullTurn.canMirror());
		assertTrue(indexHingeOnCircleLeftHandFullTurn.canMirror());
		assertTrue(indexHingeOnCircleRightHandPitched.canMirror());
		assertTrue(indexHingeOnCircleLeftHandPitched.canMirror());
		assertTrue(indexHingeOnCircleRightHandHalfTurnPitched.canMirror());
		assertTrue(indexHingeOnCircleLeftHandHalfTurnPitched.canMirror());
		assertTrue(indexHingeOnCircleRightHandFullTurnPitched.canMirror());
		assertTrue(indexHingeOnCircleLeftHandFullTurnPitched.canMirror());

	}

	@Override
	public void testMirror() {

		indexRightHand.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-01-09"), indexRightHand.getSymbol());
		indexRightHand.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-01-01"), indexRightHand.getSymbol());

		indexLeftHand.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-01-01"), indexLeftHand.getSymbol());
		indexLeftHand.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-01-09"), indexLeftHand.getSymbol());

		indexRightHandHalfTurn.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-02-09"), indexRightHandHalfTurn.getSymbol());
		indexRightHandHalfTurn.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-02-01"), indexRightHandHalfTurn.getSymbol());

		indexLeftHandHalfTurn.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-02-01"), indexLeftHandHalfTurn.getSymbol());
		indexLeftHandHalfTurn.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-02-09"), indexLeftHandHalfTurn.getSymbol());

		indexRightHandFullTurn.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-03-09"), indexRightHandFullTurn.getSymbol());
		indexRightHandFullTurn.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-03-01"), indexRightHandFullTurn.getSymbol());

		indexLeftHandFullTurn.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-03-01"), indexLeftHandFullTurn.getSymbol());
		indexLeftHandFullTurn.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-03-09"), indexLeftHandFullTurn.getSymbol());

		indexRightHandPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-04-09"), indexRightHandPitched.getSymbol());
		indexRightHandPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-04-01"), indexRightHandPitched.getSymbol());

		indexLeftHandPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-04-01"), indexLeftHandPitched.getSymbol());
		indexLeftHandPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-04-09"), indexLeftHandPitched.getSymbol());

		indexRightHandHalfTurnPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-05-09"), indexRightHandHalfTurnPitched.getSymbol());
		indexRightHandHalfTurnPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-05-01"), indexRightHandHalfTurnPitched.getSymbol());

		indexLeftHandHalfTurnPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-05-01"), indexLeftHandHalfTurnPitched.getSymbol());
		indexLeftHandHalfTurnPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-05-09"), indexLeftHandHalfTurnPitched.getSymbol());

		indexRightHandFullTurnPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-06-09"), indexRightHandFullTurnPitched.getSymbol());
		indexRightHandFullTurnPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-06-01"), indexRightHandFullTurnPitched.getSymbol());

		indexLeftHandFullTurnPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-06-01"), indexLeftHandFullTurnPitched.getSymbol());
		indexLeftHandFullTurnPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-06-09"), indexLeftHandFullTurnPitched.getSymbol());

		indexOnCircleRightHand.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-01-09"), indexOnCircleRightHand.getSymbol());
		indexOnCircleRightHand.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-01-01"), indexOnCircleRightHand.getSymbol());

		indexOnCircleLeftHand.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-01-01"), indexOnCircleLeftHand.getSymbol());
		indexOnCircleLeftHand.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-01-09"), indexOnCircleLeftHand.getSymbol());

		indexOnCircleRightHandHalfTurn.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-02-09"), indexOnCircleRightHandHalfTurn.getSymbol());
		indexOnCircleRightHandHalfTurn.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-02-01"), indexOnCircleRightHandHalfTurn.getSymbol());

		indexOnCircleLeftHandHalfTurn.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-02-01"), indexOnCircleLeftHandHalfTurn.getSymbol());
		indexOnCircleLeftHandHalfTurn.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-02-09"), indexOnCircleLeftHandHalfTurn.getSymbol());

		indexOnCircleRightHandFullTurn.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-03-09"), indexOnCircleRightHandFullTurn.getSymbol());
		indexOnCircleRightHandFullTurn.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-03-01"), indexOnCircleRightHandFullTurn.getSymbol());

		indexOnCircleLeftHandFullTurn.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-03-01"), indexOnCircleLeftHandFullTurn.getSymbol());
		indexOnCircleLeftHandFullTurn.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-03-09"), indexOnCircleLeftHandFullTurn.getSymbol());

		indexOnCircleRightHandPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-04-09"), indexOnCircleRightHandPitched.getSymbol());
		indexOnCircleRightHandPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-04-01"), indexOnCircleRightHandPitched.getSymbol());

		indexOnCircleLeftHandPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-04-01"), indexOnCircleLeftHandPitched.getSymbol());
		indexOnCircleLeftHandPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-04-09"), indexOnCircleLeftHandPitched.getSymbol());

		indexOnCircleRightHandHalfTurnPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-05-09"),
				indexOnCircleRightHandHalfTurnPitched.getSymbol());
		indexOnCircleRightHandHalfTurnPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-05-01"),
				indexOnCircleRightHandHalfTurnPitched.getSymbol());

		indexOnCircleLeftHandHalfTurnPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-05-01"),
				indexOnCircleLeftHandHalfTurnPitched.getSymbol());
		indexOnCircleLeftHandHalfTurnPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-05-09"),
				indexOnCircleLeftHandHalfTurnPitched.getSymbol());

		indexOnCircleRightHandFullTurnPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-06-09"),
				indexOnCircleRightHandFullTurnPitched.getSymbol());
		indexOnCircleRightHandFullTurnPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-06-01"),
				indexOnCircleRightHandFullTurnPitched.getSymbol());

		indexOnCircleLeftHandFullTurnPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-06-01"),
				indexOnCircleLeftHandFullTurnPitched.getSymbol());
		indexOnCircleLeftHandFullTurnPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-06-09"),
				indexOnCircleLeftHandFullTurnPitched.getSymbol());

		indexOnCupRightHand.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-01-09"), indexOnCupRightHand.getSymbol());
		indexOnCupRightHand.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-01-01"), indexOnCupRightHand.getSymbol());

		indexOnCupLeftHand.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-01-01"), indexOnCupLeftHand.getSymbol());
		indexOnCupLeftHand.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-01-09"), indexOnCupLeftHand.getSymbol());

		indexOnCupRightHandHalfTurn.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-02-09"), indexOnCupRightHandHalfTurn.getSymbol());
		indexOnCupRightHandHalfTurn.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-02-01"), indexOnCupRightHandHalfTurn.getSymbol());

		indexOnCupLeftHandHalfTurn.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-02-01"), indexOnCupLeftHandHalfTurn.getSymbol());
		indexOnCupLeftHandHalfTurn.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-02-09"), indexOnCupLeftHandHalfTurn.getSymbol());

		indexOnCupRightHandFullTurn.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-03-09"), indexOnCupRightHandFullTurn.getSymbol());
		indexOnCupRightHandFullTurn.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-03-01"), indexOnCupRightHandFullTurn.getSymbol());

		indexOnCupLeftHandFullTurn.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-03-01"), indexOnCupLeftHandFullTurn.getSymbol());
		indexOnCupLeftHandFullTurn.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-03-09"), indexOnCupLeftHandFullTurn.getSymbol());

		indexOnCupRightHandPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-04-09"), indexOnCupRightHandPitched.getSymbol());
		indexOnCupRightHandPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-04-01"), indexOnCupRightHandPitched.getSymbol());

		indexOnCupLeftHandPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-04-01"), indexOnCupLeftHandPitched.getSymbol());
		indexOnCupLeftHandPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-04-09"), indexOnCupLeftHandPitched.getSymbol());

		indexOnCupRightHandHalfTurnPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-05-09"), indexOnCupRightHandHalfTurnPitched.getSymbol());
		indexOnCupRightHandHalfTurnPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-05-01"), indexOnCupRightHandHalfTurnPitched.getSymbol());

		indexOnCupLeftHandHalfTurnPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-05-01"), indexOnCupLeftHandHalfTurnPitched.getSymbol());
		indexOnCupLeftHandHalfTurnPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-05-09"), indexOnCupLeftHandHalfTurnPitched.getSymbol());

		indexOnCupRightHandFullTurnPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-06-09"), indexOnCupRightHandFullTurnPitched.getSymbol());
		indexOnCupRightHandFullTurnPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-06-01"), indexOnCupRightHandFullTurnPitched.getSymbol());

		indexOnCupLeftHandFullTurnPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-06-01"), indexOnCupLeftHandFullTurnPitched.getSymbol());
		indexOnCupLeftHandFullTurnPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-06-09"), indexOnCupLeftHandFullTurnPitched.getSymbol());

		indexOnOvalRightHand.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-01-09"), indexOnOvalRightHand.getSymbol());
		indexOnOvalRightHand.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-01-01"), indexOnOvalRightHand.getSymbol());

		indexOnOvalLeftHand.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-01-01"), indexOnOvalLeftHand.getSymbol());
		indexOnOvalLeftHand.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-01-09"), indexOnOvalLeftHand.getSymbol());

		indexOnOvalRightHandHalfTurn.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-02-09"), indexOnOvalRightHandHalfTurn.getSymbol());
		indexOnOvalRightHandHalfTurn.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-02-01"), indexOnOvalRightHandHalfTurn.getSymbol());

		indexOnOvalLeftHandHalfTurn.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-02-01"), indexOnOvalLeftHandHalfTurn.getSymbol());
		indexOnOvalLeftHandHalfTurn.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-02-09"), indexOnOvalLeftHandHalfTurn.getSymbol());

		indexOnOvalRightHandFullTurn.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-03-09"), indexOnOvalRightHandFullTurn.getSymbol());
		indexOnOvalRightHandFullTurn.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-03-01"), indexOnOvalRightHandFullTurn.getSymbol());

		indexOnOvalLeftHandFullTurn.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-03-01"), indexOnOvalLeftHandFullTurn.getSymbol());
		indexOnOvalLeftHandFullTurn.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-03-09"), indexOnOvalLeftHandFullTurn.getSymbol());

		indexOnOvalRightHandPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-04-09"), indexOnOvalRightHandPitched.getSymbol());
		indexOnOvalRightHandPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-04-01"), indexOnOvalRightHandPitched.getSymbol());

		indexOnOvalLeftHandPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-04-01"), indexOnOvalLeftHandPitched.getSymbol());
		indexOnOvalLeftHandPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-04-09"), indexOnOvalLeftHandPitched.getSymbol());

		indexOnOvalRightHandHalfTurnPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-05-09"), indexOnOvalRightHandHalfTurnPitched.getSymbol());
		indexOnOvalRightHandHalfTurnPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-05-01"), indexOnOvalRightHandHalfTurnPitched.getSymbol());

		indexOnOvalLeftHandHalfTurnPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-05-01"), indexOnOvalLeftHandHalfTurnPitched.getSymbol());
		indexOnOvalLeftHandHalfTurnPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-05-09"), indexOnOvalLeftHandHalfTurnPitched.getSymbol());

		indexOnOvalRightHandFullTurnPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-06-09"), indexOnOvalRightHandFullTurnPitched.getSymbol());
		indexOnOvalRightHandFullTurnPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-06-01"), indexOnOvalRightHandFullTurnPitched.getSymbol());

		indexOnOvalLeftHandFullTurnPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-06-01"), indexOnOvalLeftHandFullTurnPitched.getSymbol());
		indexOnOvalLeftHandFullTurnPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-06-09"), indexOnOvalLeftHandFullTurnPitched.getSymbol());

		indexOnHingeRightHand.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-01-09"), indexOnHingeRightHand.getSymbol());
		indexOnHingeRightHand.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-01-01"), indexOnHingeRightHand.getSymbol());

		indexOnHingeLeftHand.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-01-01"), indexOnHingeLeftHand.getSymbol());
		indexOnHingeLeftHand.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-01-09"), indexOnHingeLeftHand.getSymbol());

		indexOnHingeRightHandHalfTurn.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-02-09"), indexOnHingeRightHandHalfTurn.getSymbol());
		indexOnHingeRightHandHalfTurn.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-02-01"), indexOnHingeRightHandHalfTurn.getSymbol());

		indexOnHingeLeftHandHalfTurn.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-02-01"), indexOnHingeLeftHandHalfTurn.getSymbol());
		indexOnHingeLeftHandHalfTurn.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-02-09"), indexOnHingeLeftHandHalfTurn.getSymbol());

		indexOnHingeRightHandFullTurn.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-03-09"), indexOnHingeRightHandFullTurn.getSymbol());
		indexOnHingeRightHandFullTurn.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-03-01"), indexOnHingeRightHandFullTurn.getSymbol());

		indexOnHingeLeftHandFullTurn.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-03-01"), indexOnHingeLeftHandFullTurn.getSymbol());
		indexOnHingeLeftHandFullTurn.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-03-09"), indexOnHingeLeftHandFullTurn.getSymbol());

		indexOnHingeRightHandPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-04-09"), indexOnHingeRightHandPitched.getSymbol());
		indexOnHingeRightHandPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-04-01"), indexOnHingeRightHandPitched.getSymbol());

		indexOnHingeLeftHandPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-04-01"), indexOnHingeLeftHandPitched.getSymbol());
		indexOnHingeLeftHandPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-04-09"), indexOnHingeLeftHandPitched.getSymbol());

		indexOnHingeRightHandHalfTurnPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-05-09"),
				indexOnHingeRightHandHalfTurnPitched.getSymbol());
		indexOnHingeRightHandHalfTurnPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-05-01"),
				indexOnHingeRightHandHalfTurnPitched.getSymbol());

		indexOnHingeLeftHandHalfTurnPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-05-01"), indexOnHingeLeftHandHalfTurnPitched.getSymbol());
		indexOnHingeLeftHandHalfTurnPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-05-09"), indexOnHingeLeftHandHalfTurnPitched.getSymbol());

		indexOnHingeRightHandFullTurnPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-06-09"),
				indexOnHingeRightHandFullTurnPitched.getSymbol());
		indexOnHingeRightHandFullTurnPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-06-01"),
				indexOnHingeRightHandFullTurnPitched.getSymbol());

		indexOnHingeLeftHandFullTurnPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-06-01"), indexOnHingeLeftHandFullTurnPitched.getSymbol());
		indexOnHingeLeftHandFullTurnPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-06-09"), indexOnHingeLeftHandFullTurnPitched.getSymbol());

		indexOnAngleRightHand.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-01-09"), indexOnAngleRightHand.getSymbol());
		indexOnAngleRightHand.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-01-01"), indexOnAngleRightHand.getSymbol());

		indexOnAngleLeftHand.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-01-01"), indexOnAngleLeftHand.getSymbol());
		indexOnAngleLeftHand.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-01-09"), indexOnAngleLeftHand.getSymbol());

		indexOnAngleRightHandHalfTurn.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-02-09"), indexOnAngleRightHandHalfTurn.getSymbol());
		indexOnAngleRightHandHalfTurn.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-02-01"), indexOnAngleRightHandHalfTurn.getSymbol());

		indexOnAngleLeftHandHalfTurn.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-02-01"), indexOnAngleLeftHandHalfTurn.getSymbol());
		indexOnAngleLeftHandHalfTurn.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-02-09"), indexOnAngleLeftHandHalfTurn.getSymbol());

		indexOnAngleRightHandFullTurn.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-03-09"), indexOnAngleRightHandFullTurn.getSymbol());
		indexOnAngleRightHandFullTurn.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-03-01"), indexOnAngleRightHandFullTurn.getSymbol());

		indexOnAngleLeftHandFullTurn.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-03-01"), indexOnAngleLeftHandFullTurn.getSymbol());
		indexOnAngleLeftHandFullTurn.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-03-09"), indexOnAngleLeftHandFullTurn.getSymbol());

		indexOnAngleRightHandPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-04-09"), indexOnAngleRightHandPitched.getSymbol());
		indexOnAngleRightHandPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-04-01"), indexOnAngleRightHandPitched.getSymbol());

		indexOnAngleLeftHandPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-04-01"), indexOnAngleLeftHandPitched.getSymbol());
		indexOnAngleLeftHandPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-04-09"), indexOnAngleLeftHandPitched.getSymbol());

		indexOnAngleRightHandHalfTurnPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-05-09"),
				indexOnAngleRightHandHalfTurnPitched.getSymbol());
		indexOnAngleRightHandHalfTurnPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-05-01"),
				indexOnAngleRightHandHalfTurnPitched.getSymbol());

		indexOnAngleLeftHandHalfTurnPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-05-01"), indexOnAngleLeftHandHalfTurnPitched.getSymbol());
		indexOnAngleLeftHandHalfTurnPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-05-09"), indexOnAngleLeftHandHalfTurnPitched.getSymbol());

		indexOnAngleRightHandFullTurnPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-06-09"),
				indexOnAngleRightHandFullTurnPitched.getSymbol());
		indexOnAngleRightHandFullTurnPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-06-01"),
				indexOnAngleRightHandFullTurnPitched.getSymbol());

		indexOnAngleLeftHandFullTurnPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-06-01"), indexOnAngleLeftHandFullTurnPitched.getSymbol());
		indexOnAngleLeftHandFullTurnPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-06-09"), indexOnAngleLeftHandFullTurnPitched.getSymbol());

		indexBentRightHand.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-01-09"), indexBentRightHand.getSymbol());
		indexBentRightHand.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-01-01"), indexBentRightHand.getSymbol());

		indexBentLeftHand.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-01-01"), indexBentLeftHand.getSymbol());
		indexBentLeftHand.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-01-09"), indexBentLeftHand.getSymbol());

		indexBentRightHandHalfTurn.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-02-09"), indexBentRightHandHalfTurn.getSymbol());
		indexBentRightHandHalfTurn.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-02-01"), indexBentRightHandHalfTurn.getSymbol());

		indexBentLeftHandHalfTurn.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-02-01"), indexBentLeftHandHalfTurn.getSymbol());
		indexBentLeftHandHalfTurn.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-02-09"), indexBentLeftHandHalfTurn.getSymbol());

		indexBentRightHandFullTurn.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-03-09"), indexBentRightHandFullTurn.getSymbol());
		indexBentRightHandFullTurn.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-03-01"), indexBentRightHandFullTurn.getSymbol());

		indexBentLeftHandFullTurn.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-03-01"), indexBentLeftHandFullTurn.getSymbol());
		indexBentLeftHandFullTurn.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-03-09"), indexBentLeftHandFullTurn.getSymbol());

		indexBentRightHandPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-04-09"), indexBentRightHandPitched.getSymbol());
		indexBentRightHandPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-04-01"), indexBentRightHandPitched.getSymbol());

		indexBentLeftHandPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-04-01"), indexBentLeftHandPitched.getSymbol());
		indexBentLeftHandPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-04-09"), indexBentLeftHandPitched.getSymbol());

		indexBentRightHandHalfTurnPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-05-09"), indexBentRightHandHalfTurnPitched.getSymbol());
		indexBentRightHandHalfTurnPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-05-01"), indexBentRightHandHalfTurnPitched.getSymbol());

		indexBentLeftHandHalfTurnPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-05-01"), indexBentLeftHandHalfTurnPitched.getSymbol());
		indexBentLeftHandHalfTurnPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-05-09"), indexBentLeftHandHalfTurnPitched.getSymbol());

		indexBentRightHandFullTurnPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-06-09"), indexBentRightHandFullTurnPitched.getSymbol());
		indexBentRightHandFullTurnPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-06-01"), indexBentRightHandFullTurnPitched.getSymbol());

		indexBentLeftHandFullTurnPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-06-01"), indexBentLeftHandFullTurnPitched.getSymbol());
		indexBentLeftHandFullTurnPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-06-09"), indexBentLeftHandFullTurnPitched.getSymbol());

		indexBentOnCircleRightHand.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-01-09"), indexBentOnCircleRightHand.getSymbol());
		indexBentOnCircleRightHand.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-01-01"), indexBentOnCircleRightHand.getSymbol());

		indexBentOnCircleLeftHand.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-01-01"), indexBentOnCircleLeftHand.getSymbol());
		indexBentOnCircleLeftHand.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-01-09"), indexBentOnCircleLeftHand.getSymbol());

		indexBentOnCircleRightHandHalfTurn.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-02-09"), indexBentOnCircleRightHandHalfTurn.getSymbol());
		indexBentOnCircleRightHandHalfTurn.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-02-01"), indexBentOnCircleRightHandHalfTurn.getSymbol());

		indexBentOnCircleLeftHandHalfTurn.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-02-01"), indexBentOnCircleLeftHandHalfTurn.getSymbol());
		indexBentOnCircleLeftHandHalfTurn.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-02-09"), indexBentOnCircleLeftHandHalfTurn.getSymbol());

		indexBentOnCircleRightHandFullTurn.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-03-09"), indexBentOnCircleRightHandFullTurn.getSymbol());
		indexBentOnCircleRightHandFullTurn.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-03-01"), indexBentOnCircleRightHandFullTurn.getSymbol());

		indexBentOnCircleLeftHandFullTurn.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-03-01"), indexBentOnCircleLeftHandFullTurn.getSymbol());
		indexBentOnCircleLeftHandFullTurn.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-03-09"), indexBentOnCircleLeftHandFullTurn.getSymbol());

		indexBentOnCircleRightHandPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-04-09"), indexBentOnCircleRightHandPitched.getSymbol());
		indexBentOnCircleRightHandPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-04-01"), indexBentOnCircleRightHandPitched.getSymbol());

		indexBentOnCircleLeftHandPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-04-01"), indexBentOnCircleLeftHandPitched.getSymbol());
		indexBentOnCircleLeftHandPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-04-09"), indexBentOnCircleLeftHandPitched.getSymbol());

		indexBentOnCircleRightHandHalfTurnPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-05-09"),
				indexBentOnCircleRightHandHalfTurnPitched.getSymbol());
		indexBentOnCircleRightHandHalfTurnPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-05-01"),
				indexBentOnCircleRightHandHalfTurnPitched.getSymbol());

		indexBentOnCircleLeftHandHalfTurnPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-05-01"),
				indexBentOnCircleLeftHandHalfTurnPitched.getSymbol());
		indexBentOnCircleLeftHandHalfTurnPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-05-09"),
				indexBentOnCircleLeftHandHalfTurnPitched.getSymbol());

		indexBentOnCircleRightHandFullTurnPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-06-09"),
				indexBentOnCircleRightHandFullTurnPitched.getSymbol());
		indexBentOnCircleRightHandFullTurnPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-06-01"),
				indexBentOnCircleRightHandFullTurnPitched.getSymbol());

		indexBentOnCircleLeftHandFullTurnPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-06-01"),
				indexBentOnCircleLeftHandFullTurnPitched.getSymbol());
		indexBentOnCircleLeftHandFullTurnPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-06-09"),
				indexBentOnCircleLeftHandFullTurnPitched.getSymbol());

		indexBentOnFistThumbUnderRightHand.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-01-09"), indexBentOnFistThumbUnderRightHand.getSymbol());
		indexBentOnFistThumbUnderRightHand.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-01-01"), indexBentOnFistThumbUnderRightHand.getSymbol());

		indexBentOnFistThumbUnderLeftHand.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-01-01"), indexBentOnFistThumbUnderLeftHand.getSymbol());
		indexBentOnFistThumbUnderLeftHand.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-01-09"), indexBentOnFistThumbUnderLeftHand.getSymbol());

		indexBentOnFistThumbUnderRightHandHalfTurn.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-02-09"),
				indexBentOnFistThumbUnderRightHandHalfTurn.getSymbol());
		indexBentOnFistThumbUnderRightHandHalfTurn.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-02-01"),
				indexBentOnFistThumbUnderRightHandHalfTurn.getSymbol());

		indexBentOnFistThumbUnderLeftHandHalfTurn.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-02-01"),
				indexBentOnFistThumbUnderLeftHandHalfTurn.getSymbol());
		indexBentOnFistThumbUnderLeftHandHalfTurn.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-02-09"),
				indexBentOnFistThumbUnderLeftHandHalfTurn.getSymbol());

		indexBentOnFistThumbUnderRightHandFullTurn.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-03-09"),
				indexBentOnFistThumbUnderRightHandFullTurn.getSymbol());
		indexBentOnFistThumbUnderRightHandFullTurn.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-03-01"),
				indexBentOnFistThumbUnderRightHandFullTurn.getSymbol());

		indexBentOnFistThumbUnderLeftHandFullTurn.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-03-01"),
				indexBentOnFistThumbUnderLeftHandFullTurn.getSymbol());
		indexBentOnFistThumbUnderLeftHandFullTurn.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-03-09"),
				indexBentOnFistThumbUnderLeftHandFullTurn.getSymbol());

		indexBentOnFistThumbUnderRightHandPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-04-09"),
				indexBentOnFistThumbUnderRightHandPitched.getSymbol());
		indexBentOnFistThumbUnderRightHandPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-04-01"),
				indexBentOnFistThumbUnderRightHandPitched.getSymbol());

		indexBentOnFistThumbUnderLeftHandPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-04-01"),
				indexBentOnFistThumbUnderLeftHandPitched.getSymbol());
		indexBentOnFistThumbUnderLeftHandPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-04-09"),
				indexBentOnFistThumbUnderLeftHandPitched.getSymbol());

		indexBentOnFistThumbUnderRightHandHalfTurnPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-05-09"),
				indexBentOnFistThumbUnderRightHandHalfTurnPitched.getSymbol());
		indexBentOnFistThumbUnderRightHandHalfTurnPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-05-01"),
				indexBentOnFistThumbUnderRightHandHalfTurnPitched.getSymbol());

		indexBentOnFistThumbUnderLeftHandHalfTurnPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-05-01"),
				indexBentOnFistThumbUnderLeftHandHalfTurnPitched.getSymbol());
		indexBentOnFistThumbUnderLeftHandHalfTurnPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-05-09"),
				indexBentOnFistThumbUnderLeftHandHalfTurnPitched.getSymbol());

		indexBentOnFistThumbUnderRightHandFullTurnPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-06-09"),
				indexBentOnFistThumbUnderRightHandFullTurnPitched.getSymbol());
		indexBentOnFistThumbUnderRightHandFullTurnPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-06-01"),
				indexBentOnFistThumbUnderRightHandFullTurnPitched.getSymbol());

		indexBentOnFistThumbUnderLeftHandFullTurnPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-06-01"),
				indexBentOnFistThumbUnderLeftHandFullTurnPitched.getSymbol());
		indexBentOnFistThumbUnderLeftHandFullTurnPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-06-09"),
				indexBentOnFistThumbUnderLeftHandFullTurnPitched.getSymbol());

		indexRaisedKnuckleRightHand.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-01-09"), indexRaisedKnuckleRightHand.getSymbol());
		indexRaisedKnuckleRightHand.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-01-01"), indexRaisedKnuckleRightHand.getSymbol());

		indexRaisedKnuckleLeftHand.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-01-01"), indexRaisedKnuckleLeftHand.getSymbol());
		indexRaisedKnuckleLeftHand.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-01-09"), indexRaisedKnuckleLeftHand.getSymbol());

		indexRaisedKnuckleRightHandHalfTurn.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-02-09"), indexRaisedKnuckleRightHandHalfTurn.getSymbol());
		indexRaisedKnuckleRightHandHalfTurn.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-02-01"), indexRaisedKnuckleRightHandHalfTurn.getSymbol());

		indexRaisedKnuckleLeftHandHalfTurn.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-02-01"), indexRaisedKnuckleLeftHandHalfTurn.getSymbol());
		indexRaisedKnuckleLeftHandHalfTurn.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-02-09"), indexRaisedKnuckleLeftHandHalfTurn.getSymbol());

		indexRaisedKnuckleRightHandFullTurn.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-03-09"), indexRaisedKnuckleRightHandFullTurn.getSymbol());
		indexRaisedKnuckleRightHandFullTurn.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-03-01"), indexRaisedKnuckleRightHandFullTurn.getSymbol());

		indexRaisedKnuckleLeftHandFullTurn.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-03-01"), indexRaisedKnuckleLeftHandFullTurn.getSymbol());
		indexRaisedKnuckleLeftHandFullTurn.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-03-09"), indexRaisedKnuckleLeftHandFullTurn.getSymbol());

		indexRaisedKnuckleRightHandPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-04-09"), indexRaisedKnuckleRightHandPitched.getSymbol());
		indexRaisedKnuckleRightHandPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-04-01"), indexRaisedKnuckleRightHandPitched.getSymbol());

		indexRaisedKnuckleLeftHandPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-04-01"), indexRaisedKnuckleLeftHandPitched.getSymbol());
		indexRaisedKnuckleLeftHandPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-04-09"), indexRaisedKnuckleLeftHandPitched.getSymbol());

		indexRaisedKnuckleRightHandHalfTurnPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-05-09"),
				indexRaisedKnuckleRightHandHalfTurnPitched.getSymbol());
		indexRaisedKnuckleRightHandHalfTurnPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-05-01"),
				indexRaisedKnuckleRightHandHalfTurnPitched.getSymbol());

		indexRaisedKnuckleLeftHandHalfTurnPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-05-01"),
				indexRaisedKnuckleLeftHandHalfTurnPitched.getSymbol());
		indexRaisedKnuckleLeftHandHalfTurnPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-05-09"),
				indexRaisedKnuckleLeftHandHalfTurnPitched.getSymbol());

		indexRaisedKnuckleRightHandFullTurnPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-06-09"),
				indexRaisedKnuckleRightHandFullTurnPitched.getSymbol());
		indexRaisedKnuckleRightHandFullTurnPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-06-01"),
				indexRaisedKnuckleRightHandFullTurnPitched.getSymbol());

		indexRaisedKnuckleLeftHandFullTurnPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-06-01"),
				indexRaisedKnuckleLeftHandFullTurnPitched.getSymbol());
		indexRaisedKnuckleLeftHandFullTurnPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-06-09"),
				indexRaisedKnuckleLeftHandFullTurnPitched.getSymbol());

		indexCupRightHand.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-01-09"), indexCupRightHand.getSymbol());
		indexCupRightHand.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-01-01"), indexCupRightHand.getSymbol());

		indexCupLeftHand.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-01-01"), indexCupLeftHand.getSymbol());
		indexCupLeftHand.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-01-09"), indexCupLeftHand.getSymbol());

		indexCupRightHandHalfTurn.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-02-09"), indexCupRightHandHalfTurn.getSymbol());
		indexCupRightHandHalfTurn.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-02-01"), indexCupRightHandHalfTurn.getSymbol());

		indexCupLeftHandHalfTurn.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-02-01"), indexCupLeftHandHalfTurn.getSymbol());
		indexCupLeftHandHalfTurn.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-02-09"), indexCupLeftHandHalfTurn.getSymbol());

		indexCupRightHandFullTurn.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-03-09"), indexCupRightHandFullTurn.getSymbol());
		indexCupRightHandFullTurn.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-03-01"), indexCupRightHandFullTurn.getSymbol());

		indexCupLeftHandFullTurn.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-03-01"), indexCupLeftHandFullTurn.getSymbol());
		indexCupLeftHandFullTurn.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-03-09"), indexCupLeftHandFullTurn.getSymbol());

		indexCupRightHandPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-04-09"), indexCupRightHandPitched.getSymbol());
		indexCupRightHandPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-04-01"), indexCupRightHandPitched.getSymbol());

		indexCupLeftHandPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-04-01"), indexCupLeftHandPitched.getSymbol());
		indexCupLeftHandPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-04-09"), indexCupLeftHandPitched.getSymbol());

		indexCupRightHandHalfTurnPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-05-09"), indexCupRightHandHalfTurnPitched.getSymbol());
		indexCupRightHandHalfTurnPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-05-01"), indexCupRightHandHalfTurnPitched.getSymbol());

		indexCupLeftHandHalfTurnPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-05-01"), indexCupLeftHandHalfTurnPitched.getSymbol());
		indexCupLeftHandHalfTurnPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-05-09"), indexCupLeftHandHalfTurnPitched.getSymbol());

		indexCupRightHandFullTurnPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-06-09"), indexCupRightHandFullTurnPitched.getSymbol());
		indexCupRightHandFullTurnPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-06-01"), indexCupRightHandFullTurnPitched.getSymbol());

		indexCupLeftHandFullTurnPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-06-01"), indexCupLeftHandFullTurnPitched.getSymbol());
		indexCupLeftHandFullTurnPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-06-09"), indexCupLeftHandFullTurnPitched.getSymbol());

		indexHingeOnFistRightHand.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-01-09"), indexHingeOnFistRightHand.getSymbol());
		indexHingeOnFistRightHand.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-01-01"), indexHingeOnFistRightHand.getSymbol());

		indexHingeOnFistLeftHand.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-01-01"), indexHingeOnFistLeftHand.getSymbol());
		indexHingeOnFistLeftHand.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-01-09"), indexHingeOnFistLeftHand.getSymbol());

		indexHingeOnFistRightHandHalfTurn.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-02-09"), indexHingeOnFistRightHandHalfTurn.getSymbol());
		indexHingeOnFistRightHandHalfTurn.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-02-01"), indexHingeOnFistRightHandHalfTurn.getSymbol());

		indexHingeOnFistLeftHandHalfTurn.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-02-01"), indexHingeOnFistLeftHandHalfTurn.getSymbol());
		indexHingeOnFistLeftHandHalfTurn.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-02-09"), indexHingeOnFistLeftHandHalfTurn.getSymbol());

		indexHingeOnFistRightHandFullTurn.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-03-09"), indexHingeOnFistRightHandFullTurn.getSymbol());
		indexHingeOnFistRightHandFullTurn.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-03-01"), indexHingeOnFistRightHandFullTurn.getSymbol());

		indexHingeOnFistLeftHandFullTurn.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-03-01"), indexHingeOnFistLeftHandFullTurn.getSymbol());
		indexHingeOnFistLeftHandFullTurn.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-03-09"), indexHingeOnFistLeftHandFullTurn.getSymbol());

		indexHingeOnFistRightHandPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-04-09"), indexHingeOnFistRightHandPitched.getSymbol());
		indexHingeOnFistRightHandPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-04-01"), indexHingeOnFistRightHandPitched.getSymbol());

		indexHingeOnFistLeftHandPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-04-01"), indexHingeOnFistLeftHandPitched.getSymbol());
		indexHingeOnFistLeftHandPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-04-09"), indexHingeOnFistLeftHandPitched.getSymbol());

		indexHingeOnFistRightHandHalfTurnPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-05-09"),
				indexHingeOnFistRightHandHalfTurnPitched.getSymbol());
		indexHingeOnFistRightHandHalfTurnPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-05-01"),
				indexHingeOnFistRightHandHalfTurnPitched.getSymbol());

		indexHingeOnFistLeftHandHalfTurnPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-05-01"),
				indexHingeOnFistLeftHandHalfTurnPitched.getSymbol());
		indexHingeOnFistLeftHandHalfTurnPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-05-09"),
				indexHingeOnFistLeftHandHalfTurnPitched.getSymbol());

		indexHingeOnFistRightHandFullTurnPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-06-09"),
				indexHingeOnFistRightHandFullTurnPitched.getSymbol());
		indexHingeOnFistRightHandFullTurnPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-06-01"),
				indexHingeOnFistRightHandFullTurnPitched.getSymbol());

		indexHingeOnFistLeftHandFullTurnPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-06-01"),
				indexHingeOnFistLeftHandFullTurnPitched.getSymbol());
		indexHingeOnFistLeftHandFullTurnPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-06-09"),
				indexHingeOnFistLeftHandFullTurnPitched.getSymbol());

		indexHingeOnFistLowRightHand.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-01-09"), indexHingeOnFistLowRightHand.getSymbol());
		indexHingeOnFistLowRightHand.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-01-01"), indexHingeOnFistLowRightHand.getSymbol());

		indexHingeOnFistLowLeftHand.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-01-01"), indexHingeOnFistLowLeftHand.getSymbol());
		indexHingeOnFistLowLeftHand.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-01-09"), indexHingeOnFistLowLeftHand.getSymbol());

		indexHingeOnFistLowRightHandHalfTurn.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-02-09"),
				indexHingeOnFistLowRightHandHalfTurn.getSymbol());
		indexHingeOnFistLowRightHandHalfTurn.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-02-01"),
				indexHingeOnFistLowRightHandHalfTurn.getSymbol());

		indexHingeOnFistLowLeftHandHalfTurn.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-02-01"), indexHingeOnFistLowLeftHandHalfTurn.getSymbol());
		indexHingeOnFistLowLeftHandHalfTurn.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-02-09"), indexHingeOnFistLowLeftHandHalfTurn.getSymbol());

		indexHingeOnFistLowRightHandFullTurn.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-03-09"),
				indexHingeOnFistLowRightHandFullTurn.getSymbol());
		indexHingeOnFistLowRightHandFullTurn.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-03-01"),
				indexHingeOnFistLowRightHandFullTurn.getSymbol());

		indexHingeOnFistLowLeftHandFullTurn.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-03-01"), indexHingeOnFistLowLeftHandFullTurn.getSymbol());
		indexHingeOnFistLowLeftHandFullTurn.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-03-09"), indexHingeOnFistLowLeftHandFullTurn.getSymbol());

		indexHingeOnFistLowRightHandPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-04-09"), indexHingeOnFistLowRightHandPitched.getSymbol());
		indexHingeOnFistLowRightHandPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-04-01"), indexHingeOnFistLowRightHandPitched.getSymbol());

		indexHingeOnFistLowLeftHandPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-04-01"), indexHingeOnFistLowLeftHandPitched.getSymbol());
		indexHingeOnFistLowLeftHandPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-04-09"), indexHingeOnFistLowLeftHandPitched.getSymbol());

		indexHingeOnFistLowRightHandHalfTurnPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-05-09"),
				indexHingeOnFistLowRightHandHalfTurnPitched.getSymbol());
		indexHingeOnFistLowRightHandHalfTurnPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-05-01"),
				indexHingeOnFistLowRightHandHalfTurnPitched.getSymbol());

		indexHingeOnFistLowLeftHandHalfTurnPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-05-01"),
				indexHingeOnFistLowLeftHandHalfTurnPitched.getSymbol());
		indexHingeOnFistLowLeftHandHalfTurnPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-05-09"),
				indexHingeOnFistLowLeftHandHalfTurnPitched.getSymbol());

		indexHingeOnFistLowRightHandFullTurnPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-06-09"),
				indexHingeOnFistLowRightHandFullTurnPitched.getSymbol());
		indexHingeOnFistLowRightHandFullTurnPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-06-01"),
				indexHingeOnFistLowRightHandFullTurnPitched.getSymbol());

		indexHingeOnFistLowLeftHandFullTurnPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-06-01"),
				indexHingeOnFistLowLeftHandFullTurnPitched.getSymbol());
		indexHingeOnFistLowLeftHandFullTurnPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-06-09"),
				indexHingeOnFistLowLeftHandFullTurnPitched.getSymbol());

		indexHingeOnCircleRightHand.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-01-09"), indexHingeOnCircleRightHand.getSymbol());
		indexHingeOnCircleRightHand.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-01-01"), indexHingeOnCircleRightHand.getSymbol());

		indexHingeOnCircleLeftHand.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-01-01"), indexHingeOnCircleLeftHand.getSymbol());
		indexHingeOnCircleLeftHand.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-01-09"), indexHingeOnCircleLeftHand.getSymbol());

		indexHingeOnCircleRightHandHalfTurn.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-02-09"), indexHingeOnCircleRightHandHalfTurn.getSymbol());
		indexHingeOnCircleRightHandHalfTurn.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-02-01"), indexHingeOnCircleRightHandHalfTurn.getSymbol());

		indexHingeOnCircleLeftHandHalfTurn.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-02-01"), indexHingeOnCircleLeftHandHalfTurn.getSymbol());
		indexHingeOnCircleLeftHandHalfTurn.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-02-09"), indexHingeOnCircleLeftHandHalfTurn.getSymbol());

		indexHingeOnCircleRightHandFullTurn.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-03-09"), indexHingeOnCircleRightHandFullTurn.getSymbol());
		indexHingeOnCircleRightHandFullTurn.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-03-01"), indexHingeOnCircleRightHandFullTurn.getSymbol());

		indexHingeOnCircleLeftHandFullTurn.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-03-01"), indexHingeOnCircleLeftHandFullTurn.getSymbol());
		indexHingeOnCircleLeftHandFullTurn.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-03-09"), indexHingeOnCircleLeftHandFullTurn.getSymbol());

		indexHingeOnCircleRightHandPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-04-09"), indexHingeOnCircleRightHandPitched.getSymbol());
		indexHingeOnCircleRightHandPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-04-01"), indexHingeOnCircleRightHandPitched.getSymbol());

		indexHingeOnCircleLeftHandPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-04-01"), indexHingeOnCircleLeftHandPitched.getSymbol());
		indexHingeOnCircleLeftHandPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-04-09"), indexHingeOnCircleLeftHandPitched.getSymbol());

		indexHingeOnCircleRightHandHalfTurnPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-05-09"),
				indexHingeOnCircleRightHandHalfTurnPitched.getSymbol());
		indexHingeOnCircleRightHandHalfTurnPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-05-01"),
				indexHingeOnCircleRightHandHalfTurnPitched.getSymbol());

		indexHingeOnCircleLeftHandHalfTurnPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-05-01"),
				indexHingeOnCircleLeftHandHalfTurnPitched.getSymbol());
		indexHingeOnCircleLeftHandHalfTurnPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-05-09"),
				indexHingeOnCircleLeftHandHalfTurnPitched.getSymbol());

		indexHingeOnCircleRightHandFullTurnPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-06-09"),
				indexHingeOnCircleRightHandFullTurnPitched.getSymbol());
		indexHingeOnCircleRightHandFullTurnPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-06-01"),
				indexHingeOnCircleRightHandFullTurnPitched.getSymbol());

		indexHingeOnCircleLeftHandFullTurnPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-06-01"),
				indexHingeOnCircleLeftHandFullTurnPitched.getSymbol());
		indexHingeOnCircleLeftHandFullTurnPitched.mirror();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-06-09"),
				indexHingeOnCircleLeftHandFullTurnPitched.getSymbol());

	}

	@Override
	public void testCanMirrorVertically() {

		assertTrue(indexRightHand.canMirrorVertically());
		assertTrue(indexLeftHand.canMirrorVertically());
		assertTrue(indexRightHandHalfTurn.canMirrorVertically());
		assertTrue(indexLeftHandHalfTurn.canMirrorVertically());
		assertTrue(indexRightHandFullTurn.canMirrorVertically());
		assertTrue(indexLeftHandFullTurn.canMirrorVertically());
		assertTrue(indexRightHandPitched.canMirrorVertically());
		assertTrue(indexLeftHandPitched.canMirrorVertically());
		assertTrue(indexRightHandHalfTurnPitched.canMirrorVertically());
		assertTrue(indexLeftHandHalfTurnPitched.canMirrorVertically());
		assertTrue(indexRightHandFullTurnPitched.canMirrorVertically());
		assertTrue(indexLeftHandFullTurnPitched.canMirrorVertically());

		assertTrue(indexOnCircleRightHand.canMirrorVertically());
		assertTrue(indexOnCircleLeftHand.canMirrorVertically());
		assertTrue(indexOnCircleRightHandHalfTurn.canMirrorVertically());
		assertTrue(indexOnCircleLeftHandHalfTurn.canMirrorVertically());
		assertTrue(indexOnCircleRightHandFullTurn.canMirrorVertically());
		assertTrue(indexOnCircleLeftHandFullTurn.canMirrorVertically());
		assertTrue(indexOnCircleRightHandPitched.canMirrorVertically());
		assertTrue(indexOnCircleLeftHandPitched.canMirrorVertically());
		assertTrue(indexOnCircleRightHandHalfTurnPitched.canMirrorVertically());
		assertTrue(indexOnCircleLeftHandHalfTurnPitched.canMirrorVertically());
		assertTrue(indexOnCircleRightHandFullTurnPitched.canMirrorVertically());
		assertTrue(indexOnCircleLeftHandFullTurnPitched.canMirrorVertically());

		assertTrue(indexOnCupRightHand.canMirrorVertically());
		assertTrue(indexOnCupLeftHand.canMirrorVertically());
		assertTrue(indexOnCupRightHandHalfTurn.canMirrorVertically());
		assertTrue(indexOnCupLeftHandHalfTurn.canMirrorVertically());
		assertTrue(indexOnCupRightHandFullTurn.canMirrorVertically());
		assertTrue(indexOnCupLeftHandFullTurn.canMirrorVertically());
		assertTrue(indexOnCupRightHandPitched.canMirrorVertically());
		assertTrue(indexOnCupLeftHandPitched.canMirrorVertically());
		assertTrue(indexOnCupRightHandHalfTurnPitched.canMirrorVertically());
		assertTrue(indexOnCupLeftHandHalfTurnPitched.canMirrorVertically());
		assertTrue(indexOnCupRightHandFullTurnPitched.canMirrorVertically());
		assertTrue(indexOnCupLeftHandFullTurnPitched.canMirrorVertically());

		assertTrue(indexOnOvalRightHand.canMirrorVertically());
		assertTrue(indexOnOvalLeftHand.canMirrorVertically());
		assertTrue(indexOnOvalRightHandHalfTurn.canMirrorVertically());
		assertTrue(indexOnOvalLeftHandHalfTurn.canMirrorVertically());
		assertTrue(indexOnOvalRightHandFullTurn.canMirrorVertically());
		assertTrue(indexOnOvalLeftHandFullTurn.canMirrorVertically());
		assertTrue(indexOnOvalRightHandPitched.canMirrorVertically());
		assertTrue(indexOnOvalLeftHandPitched.canMirrorVertically());
		assertTrue(indexOnOvalRightHandHalfTurnPitched.canMirrorVertically());
		assertTrue(indexOnOvalLeftHandHalfTurnPitched.canMirrorVertically());
		assertTrue(indexOnOvalRightHandFullTurnPitched.canMirrorVertically());
		assertTrue(indexOnOvalLeftHandFullTurnPitched.canMirrorVertically());

		assertTrue(indexOnHingeRightHand.canMirrorVertically());
		assertTrue(indexOnHingeLeftHand.canMirrorVertically());
		assertTrue(indexOnHingeRightHandHalfTurn.canMirrorVertically());
		assertTrue(indexOnHingeLeftHandHalfTurn.canMirrorVertically());
		assertTrue(indexOnHingeRightHandFullTurn.canMirrorVertically());
		assertTrue(indexOnHingeLeftHandFullTurn.canMirrorVertically());
		assertTrue(indexOnHingeRightHandPitched.canMirrorVertically());
		assertTrue(indexOnHingeLeftHandPitched.canMirrorVertically());
		assertTrue(indexOnHingeRightHandHalfTurnPitched.canMirrorVertically());
		assertTrue(indexOnHingeLeftHandHalfTurnPitched.canMirrorVertically());
		assertTrue(indexOnHingeRightHandFullTurnPitched.canMirrorVertically());
		assertTrue(indexOnHingeLeftHandFullTurnPitched.canMirrorVertically());

		assertTrue(indexOnAngleRightHand.canMirrorVertically());
		assertTrue(indexOnAngleLeftHand.canMirrorVertically());
		assertTrue(indexOnAngleRightHandHalfTurn.canMirrorVertically());
		assertTrue(indexOnAngleLeftHandHalfTurn.canMirrorVertically());
		assertTrue(indexOnAngleRightHandFullTurn.canMirrorVertically());
		assertTrue(indexOnAngleLeftHandFullTurn.canMirrorVertically());
		assertTrue(indexOnAngleRightHandPitched.canMirrorVertically());
		assertTrue(indexOnAngleLeftHandPitched.canMirrorVertically());
		assertTrue(indexOnAngleRightHandHalfTurnPitched.canMirrorVertically());
		assertTrue(indexOnAngleLeftHandHalfTurnPitched.canMirrorVertically());
		assertTrue(indexOnAngleRightHandFullTurnPitched.canMirrorVertically());
		assertTrue(indexOnAngleLeftHandFullTurnPitched.canMirrorVertically());

		assertTrue(indexBentRightHand.canMirrorVertically());
		assertTrue(indexBentLeftHand.canMirrorVertically());
		assertTrue(indexBentRightHandHalfTurn.canMirrorVertically());
		assertTrue(indexBentLeftHandHalfTurn.canMirrorVertically());
		assertTrue(indexBentRightHandFullTurn.canMirrorVertically());
		assertTrue(indexBentLeftHandFullTurn.canMirrorVertically());
		assertTrue(indexBentRightHandPitched.canMirrorVertically());
		assertTrue(indexBentLeftHandPitched.canMirrorVertically());
		assertTrue(indexBentRightHandHalfTurnPitched.canMirrorVertically());
		assertTrue(indexBentLeftHandHalfTurnPitched.canMirrorVertically());
		assertTrue(indexBentRightHandFullTurnPitched.canMirrorVertically());
		assertTrue(indexBentLeftHandFullTurnPitched.canMirrorVertically());

		assertTrue(indexBentOnCircleRightHand.canMirrorVertically());
		assertTrue(indexBentOnCircleLeftHand.canMirrorVertically());
		assertTrue(indexBentOnCircleRightHandHalfTurn.canMirrorVertically());
		assertTrue(indexBentOnCircleLeftHandHalfTurn.canMirrorVertically());
		assertTrue(indexBentOnCircleRightHandFullTurn.canMirrorVertically());
		assertTrue(indexBentOnCircleLeftHandFullTurn.canMirrorVertically());
		assertTrue(indexBentOnCircleRightHandPitched.canMirrorVertically());
		assertTrue(indexBentOnCircleLeftHandPitched.canMirrorVertically());
		assertTrue(indexBentOnCircleRightHandHalfTurnPitched.canMirrorVertically());
		assertTrue(indexBentOnCircleLeftHandHalfTurnPitched.canMirrorVertically());
		assertTrue(indexBentOnCircleRightHandFullTurnPitched.canMirrorVertically());
		assertTrue(indexBentOnCircleLeftHandFullTurnPitched.canMirrorVertically());

		assertTrue(indexBentOnFistThumbUnderRightHand.canMirrorVertically());
		assertTrue(indexBentOnFistThumbUnderLeftHand.canMirrorVertically());
		assertTrue(indexBentOnFistThumbUnderRightHandHalfTurn.canMirrorVertically());
		assertTrue(indexBentOnFistThumbUnderLeftHandHalfTurn.canMirrorVertically());
		assertTrue(indexBentOnFistThumbUnderRightHandFullTurn.canMirrorVertically());
		assertTrue(indexBentOnFistThumbUnderLeftHandFullTurn.canMirrorVertically());
		assertTrue(indexBentOnFistThumbUnderRightHandPitched.canMirrorVertically());
		assertTrue(indexBentOnFistThumbUnderLeftHandPitched.canMirrorVertically());
		assertTrue(indexBentOnFistThumbUnderRightHandHalfTurnPitched.canMirrorVertically());
		assertTrue(indexBentOnFistThumbUnderLeftHandHalfTurnPitched.canMirrorVertically());
		assertTrue(indexBentOnFistThumbUnderRightHandFullTurnPitched.canMirrorVertically());
		assertTrue(indexBentOnFistThumbUnderLeftHandFullTurnPitched.canMirrorVertically());

		assertTrue(indexRaisedKnuckleRightHand.canMirrorVertically());
		assertTrue(indexRaisedKnuckleLeftHand.canMirrorVertically());
		assertTrue(indexRaisedKnuckleRightHandHalfTurn.canMirrorVertically());
		assertTrue(indexRaisedKnuckleLeftHandHalfTurn.canMirrorVertically());
		assertTrue(indexRaisedKnuckleRightHandFullTurn.canMirrorVertically());
		assertTrue(indexRaisedKnuckleLeftHandFullTurn.canMirrorVertically());
		assertTrue(indexRaisedKnuckleRightHandPitched.canMirrorVertically());
		assertTrue(indexRaisedKnuckleLeftHandPitched.canMirrorVertically());
		assertTrue(indexRaisedKnuckleRightHandHalfTurnPitched.canMirrorVertically());
		assertTrue(indexRaisedKnuckleLeftHandHalfTurnPitched.canMirrorVertically());
		assertTrue(indexRaisedKnuckleRightHandFullTurnPitched.canMirrorVertically());
		assertTrue(indexRaisedKnuckleLeftHandFullTurnPitched.canMirrorVertically());

		assertTrue(indexCupRightHand.canMirrorVertically());
		assertTrue(indexCupLeftHand.canMirrorVertically());
		assertTrue(indexCupRightHandHalfTurn.canMirrorVertically());
		assertTrue(indexCupLeftHandHalfTurn.canMirrorVertically());
		assertTrue(indexCupRightHandFullTurn.canMirrorVertically());
		assertTrue(indexCupLeftHandFullTurn.canMirrorVertically());
		assertTrue(indexCupRightHandPitched.canMirrorVertically());
		assertTrue(indexCupLeftHandPitched.canMirrorVertically());
		assertTrue(indexCupRightHandHalfTurnPitched.canMirrorVertically());
		assertTrue(indexCupLeftHandHalfTurnPitched.canMirrorVertically());
		assertTrue(indexCupRightHandFullTurnPitched.canMirrorVertically());
		assertTrue(indexCupLeftHandFullTurnPitched.canMirrorVertically());

		assertTrue(indexHingeOnFistRightHand.canMirrorVertically());
		assertTrue(indexHingeOnFistLeftHand.canMirrorVertically());
		assertTrue(indexHingeOnFistRightHandHalfTurn.canMirrorVertically());
		assertTrue(indexHingeOnFistLeftHandHalfTurn.canMirrorVertically());
		assertTrue(indexHingeOnFistRightHandFullTurn.canMirrorVertically());
		assertTrue(indexHingeOnFistLeftHandFullTurn.canMirrorVertically());
		assertTrue(indexHingeOnFistRightHandPitched.canMirrorVertically());
		assertTrue(indexHingeOnFistLeftHandPitched.canMirrorVertically());
		assertTrue(indexHingeOnFistRightHandHalfTurnPitched.canMirrorVertically());
		assertTrue(indexHingeOnFistLeftHandHalfTurnPitched.canMirrorVertically());
		assertTrue(indexHingeOnFistRightHandFullTurnPitched.canMirrorVertically());
		assertTrue(indexHingeOnFistLeftHandFullTurnPitched.canMirrorVertically());

		assertTrue(indexHingeOnFistLowRightHand.canMirrorVertically());
		assertTrue(indexHingeOnFistLowLeftHand.canMirrorVertically());
		assertTrue(indexHingeOnFistLowRightHandHalfTurn.canMirrorVertically());
		assertTrue(indexHingeOnFistLowLeftHandHalfTurn.canMirrorVertically());
		assertTrue(indexHingeOnFistLowRightHandFullTurn.canMirrorVertically());
		assertTrue(indexHingeOnFistLowLeftHandFullTurn.canMirrorVertically());
		assertTrue(indexHingeOnFistLowRightHandPitched.canMirrorVertically());
		assertTrue(indexHingeOnFistLowLeftHandPitched.canMirrorVertically());
		assertTrue(indexHingeOnFistLowRightHandHalfTurnPitched.canMirrorVertically());
		assertTrue(indexHingeOnFistLowLeftHandHalfTurnPitched.canMirrorVertically());
		assertTrue(indexHingeOnFistLowRightHandFullTurnPitched.canMirrorVertically());
		assertTrue(indexHingeOnFistLowLeftHandFullTurnPitched.canMirrorVertically());

		assertTrue(indexHingeOnCircleRightHand.canMirrorVertically());
		assertTrue(indexHingeOnCircleLeftHand.canMirrorVertically());
		assertTrue(indexHingeOnCircleRightHandHalfTurn.canMirrorVertically());
		assertTrue(indexHingeOnCircleLeftHandHalfTurn.canMirrorVertically());
		assertTrue(indexHingeOnCircleRightHandFullTurn.canMirrorVertically());
		assertTrue(indexHingeOnCircleLeftHandFullTurn.canMirrorVertically());
		assertTrue(indexHingeOnCircleRightHandPitched.canMirrorVertically());
		assertTrue(indexHingeOnCircleLeftHandPitched.canMirrorVertically());
		assertTrue(indexHingeOnCircleRightHandHalfTurnPitched.canMirrorVertically());
		assertTrue(indexHingeOnCircleLeftHandHalfTurnPitched.canMirrorVertically());
		assertTrue(indexHingeOnCircleRightHandFullTurnPitched.canMirrorVertically());
		assertTrue(indexHingeOnCircleLeftHandFullTurnPitched.canMirrorVertically());

	}

	@Override
	public void testMirrorVertically() {

	}

	@Override
	public void testCanPitch() {

		assertTrue(indexRightHand.canPitch());
		assertTrue(indexLeftHand.canPitch());
		assertTrue(indexRightHandHalfTurn.canPitch());
		assertTrue(indexLeftHandHalfTurn.canPitch());
		assertTrue(indexRightHandFullTurn.canPitch());
		assertTrue(indexLeftHandFullTurn.canPitch());
		assertTrue(indexRightHandPitched.canPitch());
		assertTrue(indexLeftHandPitched.canPitch());
		assertTrue(indexRightHandHalfTurnPitched.canPitch());
		assertTrue(indexLeftHandHalfTurnPitched.canPitch());
		assertTrue(indexRightHandFullTurnPitched.canPitch());
		assertTrue(indexLeftHandFullTurnPitched.canPitch());

		assertTrue(indexOnCircleRightHand.canPitch());
		assertTrue(indexOnCircleLeftHand.canPitch());
		assertTrue(indexOnCircleRightHandHalfTurn.canPitch());
		assertTrue(indexOnCircleLeftHandHalfTurn.canPitch());
		assertTrue(indexOnCircleRightHandFullTurn.canPitch());
		assertTrue(indexOnCircleLeftHandFullTurn.canPitch());
		assertTrue(indexOnCircleRightHandPitched.canPitch());
		assertTrue(indexOnCircleLeftHandPitched.canPitch());
		assertTrue(indexOnCircleRightHandHalfTurnPitched.canPitch());
		assertTrue(indexOnCircleLeftHandHalfTurnPitched.canPitch());
		assertTrue(indexOnCircleRightHandFullTurnPitched.canPitch());
		assertTrue(indexOnCircleLeftHandFullTurnPitched.canPitch());

		assertTrue(indexOnCupRightHand.canPitch());
		assertTrue(indexOnCupLeftHand.canPitch());
		assertTrue(indexOnCupRightHandHalfTurn.canPitch());
		assertTrue(indexOnCupLeftHandHalfTurn.canPitch());
		assertTrue(indexOnCupRightHandFullTurn.canPitch());
		assertTrue(indexOnCupLeftHandFullTurn.canPitch());
		assertTrue(indexOnCupRightHandPitched.canPitch());
		assertTrue(indexOnCupLeftHandPitched.canPitch());
		assertTrue(indexOnCupRightHandHalfTurnPitched.canPitch());
		assertTrue(indexOnCupLeftHandHalfTurnPitched.canPitch());
		assertTrue(indexOnCupRightHandFullTurnPitched.canPitch());
		assertTrue(indexOnCupLeftHandFullTurnPitched.canPitch());

		assertTrue(indexOnOvalRightHand.canPitch());
		assertTrue(indexOnOvalLeftHand.canPitch());
		assertTrue(indexOnOvalRightHandHalfTurn.canPitch());
		assertTrue(indexOnOvalLeftHandHalfTurn.canPitch());
		assertTrue(indexOnOvalRightHandFullTurn.canPitch());
		assertTrue(indexOnOvalLeftHandFullTurn.canPitch());
		assertTrue(indexOnOvalRightHandPitched.canPitch());
		assertTrue(indexOnOvalLeftHandPitched.canPitch());
		assertTrue(indexOnOvalRightHandHalfTurnPitched.canPitch());
		assertTrue(indexOnOvalLeftHandHalfTurnPitched.canPitch());
		assertTrue(indexOnOvalRightHandFullTurnPitched.canPitch());
		assertTrue(indexOnOvalLeftHandFullTurnPitched.canPitch());

		assertTrue(indexOnHingeRightHand.canPitch());
		assertTrue(indexOnHingeLeftHand.canPitch());
		assertTrue(indexOnHingeRightHandHalfTurn.canPitch());
		assertTrue(indexOnHingeLeftHandHalfTurn.canPitch());
		assertTrue(indexOnHingeRightHandFullTurn.canPitch());
		assertTrue(indexOnHingeLeftHandFullTurn.canPitch());
		assertTrue(indexOnHingeRightHandPitched.canPitch());
		assertTrue(indexOnHingeLeftHandPitched.canPitch());
		assertTrue(indexOnHingeRightHandHalfTurnPitched.canPitch());
		assertTrue(indexOnHingeLeftHandHalfTurnPitched.canPitch());
		assertTrue(indexOnHingeRightHandFullTurnPitched.canPitch());
		assertTrue(indexOnHingeLeftHandFullTurnPitched.canPitch());

		assertTrue(indexOnAngleRightHand.canPitch());
		assertTrue(indexOnAngleLeftHand.canPitch());
		assertTrue(indexOnAngleRightHandHalfTurn.canPitch());
		assertTrue(indexOnAngleLeftHandHalfTurn.canPitch());
		assertTrue(indexOnAngleRightHandFullTurn.canPitch());
		assertTrue(indexOnAngleLeftHandFullTurn.canPitch());
		assertTrue(indexOnAngleRightHandPitched.canPitch());
		assertTrue(indexOnAngleLeftHandPitched.canPitch());
		assertTrue(indexOnAngleRightHandHalfTurnPitched.canPitch());
		assertTrue(indexOnAngleLeftHandHalfTurnPitched.canPitch());
		assertTrue(indexOnAngleRightHandFullTurnPitched.canPitch());
		assertTrue(indexOnAngleLeftHandFullTurnPitched.canPitch());

		assertTrue(indexBentRightHand.canPitch());
		assertTrue(indexBentLeftHand.canPitch());
		assertTrue(indexBentRightHandHalfTurn.canPitch());
		assertTrue(indexBentLeftHandHalfTurn.canPitch());
		assertTrue(indexBentRightHandFullTurn.canPitch());
		assertTrue(indexBentLeftHandFullTurn.canPitch());
		assertTrue(indexBentRightHandPitched.canPitch());
		assertTrue(indexBentLeftHandPitched.canPitch());
		assertTrue(indexBentRightHandHalfTurnPitched.canPitch());
		assertTrue(indexBentLeftHandHalfTurnPitched.canPitch());
		assertTrue(indexBentRightHandFullTurnPitched.canPitch());
		assertTrue(indexBentLeftHandFullTurnPitched.canPitch());

		assertTrue(indexBentOnCircleRightHand.canPitch());
		assertTrue(indexBentOnCircleLeftHand.canPitch());
		assertTrue(indexBentOnCircleRightHandHalfTurn.canPitch());
		assertTrue(indexBentOnCircleLeftHandHalfTurn.canPitch());
		assertTrue(indexBentOnCircleRightHandFullTurn.canPitch());
		assertTrue(indexBentOnCircleLeftHandFullTurn.canPitch());
		assertTrue(indexBentOnCircleRightHandPitched.canPitch());
		assertTrue(indexBentOnCircleLeftHandPitched.canPitch());
		assertTrue(indexBentOnCircleRightHandHalfTurnPitched.canPitch());
		assertTrue(indexBentOnCircleLeftHandHalfTurnPitched.canPitch());
		assertTrue(indexBentOnCircleRightHandFullTurnPitched.canPitch());
		assertTrue(indexBentOnCircleLeftHandFullTurnPitched.canPitch());

		assertTrue(indexBentOnFistThumbUnderRightHand.canPitch());
		assertTrue(indexBentOnFistThumbUnderLeftHand.canPitch());
		assertTrue(indexBentOnFistThumbUnderRightHandHalfTurn.canPitch());
		assertTrue(indexBentOnFistThumbUnderLeftHandHalfTurn.canPitch());
		assertTrue(indexBentOnFistThumbUnderRightHandFullTurn.canPitch());
		assertTrue(indexBentOnFistThumbUnderLeftHandFullTurn.canPitch());
		assertTrue(indexBentOnFistThumbUnderRightHandPitched.canPitch());
		assertTrue(indexBentOnFistThumbUnderLeftHandPitched.canPitch());
		assertTrue(indexBentOnFistThumbUnderRightHandHalfTurnPitched.canPitch());
		assertTrue(indexBentOnFistThumbUnderLeftHandHalfTurnPitched.canPitch());
		assertTrue(indexBentOnFistThumbUnderRightHandFullTurnPitched.canPitch());
		assertTrue(indexBentOnFistThumbUnderLeftHandFullTurnPitched.canPitch());

		assertTrue(indexRaisedKnuckleRightHand.canPitch());
		assertTrue(indexRaisedKnuckleLeftHand.canPitch());
		assertTrue(indexRaisedKnuckleRightHandHalfTurn.canPitch());
		assertTrue(indexRaisedKnuckleLeftHandHalfTurn.canPitch());
		assertTrue(indexRaisedKnuckleRightHandFullTurn.canPitch());
		assertTrue(indexRaisedKnuckleLeftHandFullTurn.canPitch());
		assertTrue(indexRaisedKnuckleRightHandPitched.canPitch());
		assertTrue(indexRaisedKnuckleLeftHandPitched.canPitch());
		assertTrue(indexRaisedKnuckleRightHandHalfTurnPitched.canPitch());
		assertTrue(indexRaisedKnuckleLeftHandHalfTurnPitched.canPitch());
		assertTrue(indexRaisedKnuckleRightHandFullTurnPitched.canPitch());
		assertTrue(indexRaisedKnuckleLeftHandFullTurnPitched.canPitch());

		assertTrue(indexCupRightHand.canPitch());
		assertTrue(indexCupLeftHand.canPitch());
		assertTrue(indexCupRightHandHalfTurn.canPitch());
		assertTrue(indexCupLeftHandHalfTurn.canPitch());
		assertTrue(indexCupRightHandFullTurn.canPitch());
		assertTrue(indexCupLeftHandFullTurn.canPitch());
		assertTrue(indexCupRightHandPitched.canPitch());
		assertTrue(indexCupLeftHandPitched.canPitch());
		assertTrue(indexCupRightHandHalfTurnPitched.canPitch());
		assertTrue(indexCupLeftHandHalfTurnPitched.canPitch());
		assertTrue(indexCupRightHandFullTurnPitched.canPitch());
		assertTrue(indexCupLeftHandFullTurnPitched.canPitch());

		assertTrue(indexHingeOnFistRightHand.canPitch());
		assertTrue(indexHingeOnFistLeftHand.canPitch());
		assertTrue(indexHingeOnFistRightHandHalfTurn.canPitch());
		assertTrue(indexHingeOnFistLeftHandHalfTurn.canPitch());
		assertTrue(indexHingeOnFistRightHandFullTurn.canPitch());
		assertTrue(indexHingeOnFistLeftHandFullTurn.canPitch());
		assertTrue(indexHingeOnFistRightHandPitched.canPitch());
		assertTrue(indexHingeOnFistLeftHandPitched.canPitch());
		assertTrue(indexHingeOnFistRightHandHalfTurnPitched.canPitch());
		assertTrue(indexHingeOnFistLeftHandHalfTurnPitched.canPitch());
		assertTrue(indexHingeOnFistRightHandFullTurnPitched.canPitch());
		assertTrue(indexHingeOnFistLeftHandFullTurnPitched.canPitch());

		assertTrue(indexHingeOnFistLowRightHand.canPitch());
		assertTrue(indexHingeOnFistLowLeftHand.canPitch());
		assertTrue(indexHingeOnFistLowRightHandHalfTurn.canPitch());
		assertTrue(indexHingeOnFistLowLeftHandHalfTurn.canPitch());
		assertTrue(indexHingeOnFistLowRightHandFullTurn.canPitch());
		assertTrue(indexHingeOnFistLowLeftHandFullTurn.canPitch());
		assertTrue(indexHingeOnFistLowRightHandPitched.canPitch());
		assertTrue(indexHingeOnFistLowLeftHandPitched.canPitch());
		assertTrue(indexHingeOnFistLowRightHandHalfTurnPitched.canPitch());
		assertTrue(indexHingeOnFistLowLeftHandHalfTurnPitched.canPitch());
		assertTrue(indexHingeOnFistLowRightHandFullTurnPitched.canPitch());
		assertTrue(indexHingeOnFistLowLeftHandFullTurnPitched.canPitch());

		assertTrue(indexHingeOnCircleRightHand.canPitch());
		assertTrue(indexHingeOnCircleLeftHand.canPitch());
		assertTrue(indexHingeOnCircleRightHandHalfTurn.canPitch());
		assertTrue(indexHingeOnCircleLeftHandHalfTurn.canPitch());
		assertTrue(indexHingeOnCircleRightHandFullTurn.canPitch());
		assertTrue(indexHingeOnCircleLeftHandFullTurn.canPitch());
		assertTrue(indexHingeOnCircleRightHandPitched.canPitch());
		assertTrue(indexHingeOnCircleLeftHandPitched.canPitch());
		assertTrue(indexHingeOnCircleRightHandHalfTurnPitched.canPitch());
		assertTrue(indexHingeOnCircleLeftHandHalfTurnPitched.canPitch());
		assertTrue(indexHingeOnCircleRightHandFullTurnPitched.canPitch());
		assertTrue(indexHingeOnCircleLeftHandFullTurnPitched.canPitch());

	}

	@Override
	public void testPitch() {

		indexRightHand.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-04-01"), indexRightHand.getSymbol());
		indexRightHand.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-01-01"), indexRightHand.getSymbol());

		indexLeftHand.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-04-09"), indexLeftHand.getSymbol());
		indexLeftHand.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-01-09"), indexLeftHand.getSymbol());

		indexRightHandHalfTurn.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-05-01"), indexRightHandHalfTurn.getSymbol());
		indexRightHandHalfTurn.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-02-01"), indexRightHandHalfTurn.getSymbol());

		indexLeftHandHalfTurn.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-05-09"), indexLeftHandHalfTurn.getSymbol());
		indexLeftHandHalfTurn.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-02-09"), indexLeftHandHalfTurn.getSymbol());

		indexRightHandFullTurn.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-06-01"), indexRightHandFullTurn.getSymbol());
		indexRightHandFullTurn.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-03-01"), indexRightHandFullTurn.getSymbol());

		indexLeftHandFullTurn.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-06-09"), indexLeftHandFullTurn.getSymbol());
		indexLeftHandFullTurn.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-03-09"), indexLeftHandFullTurn.getSymbol());

		indexRightHandPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-01-01"), indexRightHandPitched.getSymbol());
		indexRightHandPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-04-01"), indexRightHandPitched.getSymbol());

		indexLeftHandPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-01-09"), indexLeftHandPitched.getSymbol());
		indexLeftHandPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-04-09"), indexLeftHandPitched.getSymbol());

		indexRightHandHalfTurnPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-02-01"), indexRightHandHalfTurnPitched.getSymbol());
		indexRightHandHalfTurnPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-05-01"), indexRightHandHalfTurnPitched.getSymbol());

		indexLeftHandHalfTurnPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-02-09"), indexLeftHandHalfTurnPitched.getSymbol());
		indexLeftHandHalfTurnPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-05-09"), indexLeftHandHalfTurnPitched.getSymbol());

		indexRightHandFullTurnPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-03-01"), indexRightHandFullTurnPitched.getSymbol());
		indexRightHandFullTurnPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-06-01"), indexRightHandFullTurnPitched.getSymbol());

		indexLeftHandFullTurnPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-03-09"), indexLeftHandFullTurnPitched.getSymbol());
		indexLeftHandFullTurnPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-06-09"), indexLeftHandFullTurnPitched.getSymbol());

		indexOnCircleRightHand.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-04-01"), indexOnCircleRightHand.getSymbol());
		indexOnCircleRightHand.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-01-01"), indexOnCircleRightHand.getSymbol());

		indexOnCircleLeftHand.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-04-09"), indexOnCircleLeftHand.getSymbol());
		indexOnCircleLeftHand.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-01-09"), indexOnCircleLeftHand.getSymbol());

		indexOnCircleRightHandHalfTurn.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-05-01"), indexOnCircleRightHandHalfTurn.getSymbol());
		indexOnCircleRightHandHalfTurn.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-02-01"), indexOnCircleRightHandHalfTurn.getSymbol());

		indexOnCircleLeftHandHalfTurn.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-05-09"), indexOnCircleLeftHandHalfTurn.getSymbol());
		indexOnCircleLeftHandHalfTurn.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-02-09"), indexOnCircleLeftHandHalfTurn.getSymbol());

		indexOnCircleRightHandFullTurn.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-06-01"), indexOnCircleRightHandFullTurn.getSymbol());
		indexOnCircleRightHandFullTurn.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-03-01"), indexOnCircleRightHandFullTurn.getSymbol());

		indexOnCircleLeftHandFullTurn.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-06-09"), indexOnCircleLeftHandFullTurn.getSymbol());
		indexOnCircleLeftHandFullTurn.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-03-09"), indexOnCircleLeftHandFullTurn.getSymbol());

		indexOnCircleRightHandPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-01-01"), indexOnCircleRightHandPitched.getSymbol());
		indexOnCircleRightHandPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-04-01"), indexOnCircleRightHandPitched.getSymbol());

		indexOnCircleLeftHandPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-01-09"), indexOnCircleLeftHandPitched.getSymbol());
		indexOnCircleLeftHandPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-04-09"), indexOnCircleLeftHandPitched.getSymbol());

		indexOnCircleRightHandHalfTurnPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-02-01"),
				indexOnCircleRightHandHalfTurnPitched.getSymbol());
		indexOnCircleRightHandHalfTurnPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-05-01"),
				indexOnCircleRightHandHalfTurnPitched.getSymbol());

		indexOnCircleLeftHandHalfTurnPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-02-09"),
				indexOnCircleLeftHandHalfTurnPitched.getSymbol());
		indexOnCircleLeftHandHalfTurnPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-05-09"),
				indexOnCircleLeftHandHalfTurnPitched.getSymbol());

		indexOnCircleRightHandFullTurnPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-03-01"),
				indexOnCircleRightHandFullTurnPitched.getSymbol());
		indexOnCircleRightHandFullTurnPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-06-01"),
				indexOnCircleRightHandFullTurnPitched.getSymbol());

		indexOnCircleLeftHandFullTurnPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-03-09"),
				indexOnCircleLeftHandFullTurnPitched.getSymbol());
		indexOnCircleLeftHandFullTurnPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-06-09"),
				indexOnCircleLeftHandFullTurnPitched.getSymbol());

		indexOnCupRightHand.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-04-01"), indexOnCupRightHand.getSymbol());
		indexOnCupRightHand.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-01-01"), indexOnCupRightHand.getSymbol());

		indexOnCupLeftHand.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-04-09"), indexOnCupLeftHand.getSymbol());
		indexOnCupLeftHand.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-01-09"), indexOnCupLeftHand.getSymbol());

		indexOnCupRightHandHalfTurn.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-05-01"), indexOnCupRightHandHalfTurn.getSymbol());
		indexOnCupRightHandHalfTurn.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-02-01"), indexOnCupRightHandHalfTurn.getSymbol());

		indexOnCupLeftHandHalfTurn.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-05-09"), indexOnCupLeftHandHalfTurn.getSymbol());
		indexOnCupLeftHandHalfTurn.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-02-09"), indexOnCupLeftHandHalfTurn.getSymbol());

		indexOnCupRightHandFullTurn.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-06-01"), indexOnCupRightHandFullTurn.getSymbol());
		indexOnCupRightHandFullTurn.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-03-01"), indexOnCupRightHandFullTurn.getSymbol());

		indexOnCupLeftHandFullTurn.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-06-09"), indexOnCupLeftHandFullTurn.getSymbol());
		indexOnCupLeftHandFullTurn.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-03-09"), indexOnCupLeftHandFullTurn.getSymbol());

		indexOnCupRightHandPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-01-01"), indexOnCupRightHandPitched.getSymbol());
		indexOnCupRightHandPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-04-01"), indexOnCupRightHandPitched.getSymbol());

		indexOnCupLeftHandPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-01-09"), indexOnCupLeftHandPitched.getSymbol());
		indexOnCupLeftHandPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-04-09"), indexOnCupLeftHandPitched.getSymbol());

		indexOnCupRightHandHalfTurnPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-02-01"), indexOnCupRightHandHalfTurnPitched.getSymbol());
		indexOnCupRightHandHalfTurnPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-05-01"), indexOnCupRightHandHalfTurnPitched.getSymbol());

		indexOnCupLeftHandHalfTurnPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-02-09"), indexOnCupLeftHandHalfTurnPitched.getSymbol());
		indexOnCupLeftHandHalfTurnPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-05-09"), indexOnCupLeftHandHalfTurnPitched.getSymbol());

		indexOnCupRightHandFullTurnPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-03-01"), indexOnCupRightHandFullTurnPitched.getSymbol());
		indexOnCupRightHandFullTurnPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-06-01"), indexOnCupRightHandFullTurnPitched.getSymbol());

		indexOnCupLeftHandFullTurnPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-03-09"), indexOnCupLeftHandFullTurnPitched.getSymbol());
		indexOnCupLeftHandFullTurnPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-06-09"), indexOnCupLeftHandFullTurnPitched.getSymbol());

		indexOnOvalRightHand.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-04-01"), indexOnOvalRightHand.getSymbol());
		indexOnOvalRightHand.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-01-01"), indexOnOvalRightHand.getSymbol());

		indexOnOvalLeftHand.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-04-09"), indexOnOvalLeftHand.getSymbol());
		indexOnOvalLeftHand.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-01-09"), indexOnOvalLeftHand.getSymbol());

		indexOnOvalRightHandHalfTurn.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-05-01"), indexOnOvalRightHandHalfTurn.getSymbol());
		indexOnOvalRightHandHalfTurn.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-02-01"), indexOnOvalRightHandHalfTurn.getSymbol());

		indexOnOvalLeftHandHalfTurn.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-05-09"), indexOnOvalLeftHandHalfTurn.getSymbol());
		indexOnOvalLeftHandHalfTurn.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-02-09"), indexOnOvalLeftHandHalfTurn.getSymbol());

		indexOnOvalRightHandFullTurn.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-06-01"), indexOnOvalRightHandFullTurn.getSymbol());
		indexOnOvalRightHandFullTurn.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-03-01"), indexOnOvalRightHandFullTurn.getSymbol());

		indexOnOvalLeftHandFullTurn.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-06-09"), indexOnOvalLeftHandFullTurn.getSymbol());
		indexOnOvalLeftHandFullTurn.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-03-09"), indexOnOvalLeftHandFullTurn.getSymbol());

		indexOnOvalRightHandPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-01-01"), indexOnOvalRightHandPitched.getSymbol());
		indexOnOvalRightHandPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-04-01"), indexOnOvalRightHandPitched.getSymbol());

		indexOnOvalLeftHandPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-01-09"), indexOnOvalLeftHandPitched.getSymbol());
		indexOnOvalLeftHandPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-04-09"), indexOnOvalLeftHandPitched.getSymbol());

		indexOnOvalRightHandHalfTurnPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-02-01"), indexOnOvalRightHandHalfTurnPitched.getSymbol());
		indexOnOvalRightHandHalfTurnPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-05-01"), indexOnOvalRightHandHalfTurnPitched.getSymbol());

		indexOnOvalLeftHandHalfTurnPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-02-09"), indexOnOvalLeftHandHalfTurnPitched.getSymbol());
		indexOnOvalLeftHandHalfTurnPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-05-09"), indexOnOvalLeftHandHalfTurnPitched.getSymbol());

		indexOnOvalRightHandFullTurnPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-03-01"), indexOnOvalRightHandFullTurnPitched.getSymbol());
		indexOnOvalRightHandFullTurnPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-06-01"), indexOnOvalRightHandFullTurnPitched.getSymbol());

		indexOnOvalLeftHandFullTurnPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-03-09"), indexOnOvalLeftHandFullTurnPitched.getSymbol());
		indexOnOvalLeftHandFullTurnPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-06-09"), indexOnOvalLeftHandFullTurnPitched.getSymbol());

		indexOnHingeRightHand.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-04-01"), indexOnHingeRightHand.getSymbol());
		indexOnHingeRightHand.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-01-01"), indexOnHingeRightHand.getSymbol());

		indexOnHingeLeftHand.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-04-09"), indexOnHingeLeftHand.getSymbol());
		indexOnHingeLeftHand.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-01-09"), indexOnHingeLeftHand.getSymbol());

		indexOnHingeRightHandHalfTurn.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-05-01"), indexOnHingeRightHandHalfTurn.getSymbol());
		indexOnHingeRightHandHalfTurn.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-02-01"), indexOnHingeRightHandHalfTurn.getSymbol());

		indexOnHingeLeftHandHalfTurn.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-05-09"), indexOnHingeLeftHandHalfTurn.getSymbol());
		indexOnHingeLeftHandHalfTurn.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-02-09"), indexOnHingeLeftHandHalfTurn.getSymbol());

		indexOnHingeRightHandFullTurn.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-06-01"), indexOnHingeRightHandFullTurn.getSymbol());
		indexOnHingeRightHandFullTurn.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-03-01"), indexOnHingeRightHandFullTurn.getSymbol());

		indexOnHingeLeftHandFullTurn.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-06-09"), indexOnHingeLeftHandFullTurn.getSymbol());
		indexOnHingeLeftHandFullTurn.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-03-09"), indexOnHingeLeftHandFullTurn.getSymbol());

		indexOnHingeRightHandPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-01-01"), indexOnHingeRightHandPitched.getSymbol());
		indexOnHingeRightHandPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-04-01"), indexOnHingeRightHandPitched.getSymbol());

		indexOnHingeLeftHandPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-01-09"), indexOnHingeLeftHandPitched.getSymbol());
		indexOnHingeLeftHandPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-04-09"), indexOnHingeLeftHandPitched.getSymbol());

		indexOnHingeRightHandHalfTurnPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-02-01"),
				indexOnHingeRightHandHalfTurnPitched.getSymbol());
		indexOnHingeRightHandHalfTurnPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-05-01"),
				indexOnHingeRightHandHalfTurnPitched.getSymbol());

		indexOnHingeLeftHandHalfTurnPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-02-09"), indexOnHingeLeftHandHalfTurnPitched.getSymbol());
		indexOnHingeLeftHandHalfTurnPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-05-09"), indexOnHingeLeftHandHalfTurnPitched.getSymbol());

		indexOnHingeRightHandFullTurnPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-03-01"),
				indexOnHingeRightHandFullTurnPitched.getSymbol());
		indexOnHingeRightHandFullTurnPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-06-01"),
				indexOnHingeRightHandFullTurnPitched.getSymbol());

		indexOnHingeLeftHandFullTurnPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-03-09"), indexOnHingeLeftHandFullTurnPitched.getSymbol());
		indexOnHingeLeftHandFullTurnPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-06-09"), indexOnHingeLeftHandFullTurnPitched.getSymbol());

		indexOnAngleRightHand.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-04-01"), indexOnAngleRightHand.getSymbol());
		indexOnAngleRightHand.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-01-01"), indexOnAngleRightHand.getSymbol());

		indexOnAngleLeftHand.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-04-09"), indexOnAngleLeftHand.getSymbol());
		indexOnAngleLeftHand.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-01-09"), indexOnAngleLeftHand.getSymbol());

		indexOnAngleRightHandHalfTurn.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-05-01"), indexOnAngleRightHandHalfTurn.getSymbol());
		indexOnAngleRightHandHalfTurn.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-02-01"), indexOnAngleRightHandHalfTurn.getSymbol());

		indexOnAngleLeftHandHalfTurn.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-05-09"), indexOnAngleLeftHandHalfTurn.getSymbol());
		indexOnAngleLeftHandHalfTurn.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-02-09"), indexOnAngleLeftHandHalfTurn.getSymbol());

		indexOnAngleRightHandFullTurn.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-06-01"), indexOnAngleRightHandFullTurn.getSymbol());
		indexOnAngleRightHandFullTurn.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-03-01"), indexOnAngleRightHandFullTurn.getSymbol());

		indexOnAngleLeftHandFullTurn.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-06-09"), indexOnAngleLeftHandFullTurn.getSymbol());
		indexOnAngleLeftHandFullTurn.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-03-09"), indexOnAngleLeftHandFullTurn.getSymbol());

		indexOnAngleRightHandPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-01-01"), indexOnAngleRightHandPitched.getSymbol());
		indexOnAngleRightHandPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-04-01"), indexOnAngleRightHandPitched.getSymbol());

		indexOnAngleLeftHandPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-01-09"), indexOnAngleLeftHandPitched.getSymbol());
		indexOnAngleLeftHandPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-04-09"), indexOnAngleLeftHandPitched.getSymbol());

		indexOnAngleRightHandHalfTurnPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-02-01"),
				indexOnAngleRightHandHalfTurnPitched.getSymbol());
		indexOnAngleRightHandHalfTurnPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-05-01"),
				indexOnAngleRightHandHalfTurnPitched.getSymbol());

		indexOnAngleLeftHandHalfTurnPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-02-09"), indexOnAngleLeftHandHalfTurnPitched.getSymbol());
		indexOnAngleLeftHandHalfTurnPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-05-09"), indexOnAngleLeftHandHalfTurnPitched.getSymbol());

		indexOnAngleRightHandFullTurnPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-03-01"),
				indexOnAngleRightHandFullTurnPitched.getSymbol());
		indexOnAngleRightHandFullTurnPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-06-01"),
				indexOnAngleRightHandFullTurnPitched.getSymbol());

		indexOnAngleLeftHandFullTurnPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-03-09"), indexOnAngleLeftHandFullTurnPitched.getSymbol());
		indexOnAngleLeftHandFullTurnPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-06-09"), indexOnAngleLeftHandFullTurnPitched.getSymbol());

		indexBentRightHand.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-04-01"), indexBentRightHand.getSymbol());
		indexBentRightHand.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-01-01"), indexBentRightHand.getSymbol());

		indexBentLeftHand.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-04-09"), indexBentLeftHand.getSymbol());
		indexBentLeftHand.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-01-09"), indexBentLeftHand.getSymbol());

		indexBentRightHandHalfTurn.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-05-01"), indexBentRightHandHalfTurn.getSymbol());
		indexBentRightHandHalfTurn.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-02-01"), indexBentRightHandHalfTurn.getSymbol());

		indexBentLeftHandHalfTurn.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-05-09"), indexBentLeftHandHalfTurn.getSymbol());
		indexBentLeftHandHalfTurn.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-02-09"), indexBentLeftHandHalfTurn.getSymbol());

		indexBentRightHandFullTurn.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-06-01"), indexBentRightHandFullTurn.getSymbol());
		indexBentRightHandFullTurn.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-03-01"), indexBentRightHandFullTurn.getSymbol());

		indexBentLeftHandFullTurn.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-06-09"), indexBentLeftHandFullTurn.getSymbol());
		indexBentLeftHandFullTurn.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-03-09"), indexBentLeftHandFullTurn.getSymbol());

		indexBentRightHandPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-01-01"), indexBentRightHandPitched.getSymbol());
		indexBentRightHandPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-04-01"), indexBentRightHandPitched.getSymbol());

		indexBentLeftHandPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-01-09"), indexBentLeftHandPitched.getSymbol());
		indexBentLeftHandPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-04-09"), indexBentLeftHandPitched.getSymbol());

		indexBentRightHandHalfTurnPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-02-01"), indexBentRightHandHalfTurnPitched.getSymbol());
		indexBentRightHandHalfTurnPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-05-01"), indexBentRightHandHalfTurnPitched.getSymbol());

		indexBentLeftHandHalfTurnPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-02-09"), indexBentLeftHandHalfTurnPitched.getSymbol());
		indexBentLeftHandHalfTurnPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-05-09"), indexBentLeftHandHalfTurnPitched.getSymbol());

		indexBentRightHandFullTurnPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-03-01"), indexBentRightHandFullTurnPitched.getSymbol());
		indexBentRightHandFullTurnPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-06-01"), indexBentRightHandFullTurnPitched.getSymbol());

		indexBentLeftHandFullTurnPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-03-09"), indexBentLeftHandFullTurnPitched.getSymbol());
		indexBentLeftHandFullTurnPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-06-09"), indexBentLeftHandFullTurnPitched.getSymbol());

		indexBentOnCircleRightHand.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-04-01"), indexBentOnCircleRightHand.getSymbol());
		indexBentOnCircleRightHand.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-01-01"), indexBentOnCircleRightHand.getSymbol());

		indexBentOnCircleLeftHand.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-04-09"), indexBentOnCircleLeftHand.getSymbol());
		indexBentOnCircleLeftHand.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-01-09"), indexBentOnCircleLeftHand.getSymbol());

		indexBentOnCircleRightHandHalfTurn.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-05-01"), indexBentOnCircleRightHandHalfTurn.getSymbol());
		indexBentOnCircleRightHandHalfTurn.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-02-01"), indexBentOnCircleRightHandHalfTurn.getSymbol());

		indexBentOnCircleLeftHandHalfTurn.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-05-09"), indexBentOnCircleLeftHandHalfTurn.getSymbol());
		indexBentOnCircleLeftHandHalfTurn.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-02-09"), indexBentOnCircleLeftHandHalfTurn.getSymbol());

		indexBentOnCircleRightHandFullTurn.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-06-01"), indexBentOnCircleRightHandFullTurn.getSymbol());
		indexBentOnCircleRightHandFullTurn.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-03-01"), indexBentOnCircleRightHandFullTurn.getSymbol());

		indexBentOnCircleLeftHandFullTurn.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-06-09"), indexBentOnCircleLeftHandFullTurn.getSymbol());
		indexBentOnCircleLeftHandFullTurn.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-03-09"), indexBentOnCircleLeftHandFullTurn.getSymbol());

		indexBentOnCircleRightHandPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-01-01"), indexBentOnCircleRightHandPitched.getSymbol());
		indexBentOnCircleRightHandPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-04-01"), indexBentOnCircleRightHandPitched.getSymbol());

		indexBentOnCircleLeftHandPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-01-09"), indexBentOnCircleLeftHandPitched.getSymbol());
		indexBentOnCircleLeftHandPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-04-09"), indexBentOnCircleLeftHandPitched.getSymbol());

		indexBentOnCircleRightHandHalfTurnPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-02-01"),
				indexBentOnCircleRightHandHalfTurnPitched.getSymbol());
		indexBentOnCircleRightHandHalfTurnPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-05-01"),
				indexBentOnCircleRightHandHalfTurnPitched.getSymbol());

		indexBentOnCircleLeftHandHalfTurnPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-02-09"),
				indexBentOnCircleLeftHandHalfTurnPitched.getSymbol());
		indexBentOnCircleLeftHandHalfTurnPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-05-09"),
				indexBentOnCircleLeftHandHalfTurnPitched.getSymbol());

		indexBentOnCircleRightHandFullTurnPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-03-01"),
				indexBentOnCircleRightHandFullTurnPitched.getSymbol());
		indexBentOnCircleRightHandFullTurnPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-06-01"),
				indexBentOnCircleRightHandFullTurnPitched.getSymbol());

		indexBentOnCircleLeftHandFullTurnPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-03-09"),
				indexBentOnCircleLeftHandFullTurnPitched.getSymbol());
		indexBentOnCircleLeftHandFullTurnPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-06-09"),
				indexBentOnCircleLeftHandFullTurnPitched.getSymbol());

		indexBentOnFistThumbUnderRightHand.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-04-01"), indexBentOnFistThumbUnderRightHand.getSymbol());
		indexBentOnFistThumbUnderRightHand.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-01-01"), indexBentOnFistThumbUnderRightHand.getSymbol());

		indexBentOnFistThumbUnderLeftHand.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-04-09"), indexBentOnFistThumbUnderLeftHand.getSymbol());
		indexBentOnFistThumbUnderLeftHand.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-01-09"), indexBentOnFistThumbUnderLeftHand.getSymbol());

		indexBentOnFistThumbUnderRightHandHalfTurn.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-05-01"),
				indexBentOnFistThumbUnderRightHandHalfTurn.getSymbol());
		indexBentOnFistThumbUnderRightHandHalfTurn.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-02-01"),
				indexBentOnFistThumbUnderRightHandHalfTurn.getSymbol());

		indexBentOnFistThumbUnderLeftHandHalfTurn.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-05-09"),
				indexBentOnFistThumbUnderLeftHandHalfTurn.getSymbol());
		indexBentOnFistThumbUnderLeftHandHalfTurn.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-02-09"),
				indexBentOnFistThumbUnderLeftHandHalfTurn.getSymbol());

		indexBentOnFistThumbUnderRightHandFullTurn.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-06-01"),
				indexBentOnFistThumbUnderRightHandFullTurn.getSymbol());
		indexBentOnFistThumbUnderRightHandFullTurn.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-03-01"),
				indexBentOnFistThumbUnderRightHandFullTurn.getSymbol());

		indexBentOnFistThumbUnderLeftHandFullTurn.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-06-09"),
				indexBentOnFistThumbUnderLeftHandFullTurn.getSymbol());
		indexBentOnFistThumbUnderLeftHandFullTurn.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-03-09"),
				indexBentOnFistThumbUnderLeftHandFullTurn.getSymbol());

		indexBentOnFistThumbUnderRightHandPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-01-01"),
				indexBentOnFistThumbUnderRightHandPitched.getSymbol());
		indexBentOnFistThumbUnderRightHandPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-04-01"),
				indexBentOnFistThumbUnderRightHandPitched.getSymbol());

		indexBentOnFistThumbUnderLeftHandPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-01-09"),
				indexBentOnFistThumbUnderLeftHandPitched.getSymbol());
		indexBentOnFistThumbUnderLeftHandPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-04-09"),
				indexBentOnFistThumbUnderLeftHandPitched.getSymbol());

		indexBentOnFistThumbUnderRightHandHalfTurnPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-02-01"),
				indexBentOnFistThumbUnderRightHandHalfTurnPitched.getSymbol());
		indexBentOnFistThumbUnderRightHandHalfTurnPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-05-01"),
				indexBentOnFistThumbUnderRightHandHalfTurnPitched.getSymbol());

		indexBentOnFistThumbUnderLeftHandHalfTurnPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-02-09"),
				indexBentOnFistThumbUnderLeftHandHalfTurnPitched.getSymbol());
		indexBentOnFistThumbUnderLeftHandHalfTurnPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-05-09"),
				indexBentOnFistThumbUnderLeftHandHalfTurnPitched.getSymbol());

		indexBentOnFistThumbUnderRightHandFullTurnPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-03-01"),
				indexBentOnFistThumbUnderRightHandFullTurnPitched.getSymbol());
		indexBentOnFistThumbUnderRightHandFullTurnPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-06-01"),
				indexBentOnFistThumbUnderRightHandFullTurnPitched.getSymbol());

		indexBentOnFistThumbUnderLeftHandFullTurnPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-03-09"),
				indexBentOnFistThumbUnderLeftHandFullTurnPitched.getSymbol());
		indexBentOnFistThumbUnderLeftHandFullTurnPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-06-09"),
				indexBentOnFistThumbUnderLeftHandFullTurnPitched.getSymbol());

		indexRaisedKnuckleRightHand.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-04-01"), indexRaisedKnuckleRightHand.getSymbol());
		indexRaisedKnuckleRightHand.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-01-01"), indexRaisedKnuckleRightHand.getSymbol());

		indexRaisedKnuckleLeftHand.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-04-09"), indexRaisedKnuckleLeftHand.getSymbol());
		indexRaisedKnuckleLeftHand.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-01-09"), indexRaisedKnuckleLeftHand.getSymbol());

		indexRaisedKnuckleRightHandHalfTurn.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-05-01"), indexRaisedKnuckleRightHandHalfTurn.getSymbol());
		indexRaisedKnuckleRightHandHalfTurn.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-02-01"), indexRaisedKnuckleRightHandHalfTurn.getSymbol());

		indexRaisedKnuckleLeftHandHalfTurn.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-05-09"), indexRaisedKnuckleLeftHandHalfTurn.getSymbol());
		indexRaisedKnuckleLeftHandHalfTurn.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-02-09"), indexRaisedKnuckleLeftHandHalfTurn.getSymbol());

		indexRaisedKnuckleRightHandFullTurn.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-06-01"), indexRaisedKnuckleRightHandFullTurn.getSymbol());
		indexRaisedKnuckleRightHandFullTurn.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-03-01"), indexRaisedKnuckleRightHandFullTurn.getSymbol());

		indexRaisedKnuckleLeftHandFullTurn.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-06-09"), indexRaisedKnuckleLeftHandFullTurn.getSymbol());
		indexRaisedKnuckleLeftHandFullTurn.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-03-09"), indexRaisedKnuckleLeftHandFullTurn.getSymbol());

		indexRaisedKnuckleRightHandPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-01-01"), indexRaisedKnuckleRightHandPitched.getSymbol());
		indexRaisedKnuckleRightHandPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-04-01"), indexRaisedKnuckleRightHandPitched.getSymbol());

		indexRaisedKnuckleLeftHandPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-01-09"), indexRaisedKnuckleLeftHandPitched.getSymbol());
		indexRaisedKnuckleLeftHandPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-04-09"), indexRaisedKnuckleLeftHandPitched.getSymbol());

		indexRaisedKnuckleRightHandHalfTurnPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-02-01"),
				indexRaisedKnuckleRightHandHalfTurnPitched.getSymbol());
		indexRaisedKnuckleRightHandHalfTurnPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-05-01"),
				indexRaisedKnuckleRightHandHalfTurnPitched.getSymbol());

		indexRaisedKnuckleLeftHandHalfTurnPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-02-09"),
				indexRaisedKnuckleLeftHandHalfTurnPitched.getSymbol());
		indexRaisedKnuckleLeftHandHalfTurnPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-05-09"),
				indexRaisedKnuckleLeftHandHalfTurnPitched.getSymbol());

		indexRaisedKnuckleRightHandFullTurnPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-03-01"),
				indexRaisedKnuckleRightHandFullTurnPitched.getSymbol());
		indexRaisedKnuckleRightHandFullTurnPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-06-01"),
				indexRaisedKnuckleRightHandFullTurnPitched.getSymbol());

		indexRaisedKnuckleLeftHandFullTurnPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-03-09"),
				indexRaisedKnuckleLeftHandFullTurnPitched.getSymbol());
		indexRaisedKnuckleLeftHandFullTurnPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-06-09"),
				indexRaisedKnuckleLeftHandFullTurnPitched.getSymbol());

		indexCupRightHand.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-04-01"), indexCupRightHand.getSymbol());
		indexCupRightHand.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-01-01"), indexCupRightHand.getSymbol());

		indexCupLeftHand.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-04-09"), indexCupLeftHand.getSymbol());
		indexCupLeftHand.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-01-09"), indexCupLeftHand.getSymbol());

		indexCupRightHandHalfTurn.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-05-01"), indexCupRightHandHalfTurn.getSymbol());
		indexCupRightHandHalfTurn.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-02-01"), indexCupRightHandHalfTurn.getSymbol());

		indexCupLeftHandHalfTurn.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-05-09"), indexCupLeftHandHalfTurn.getSymbol());
		indexCupLeftHandHalfTurn.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-02-09"), indexCupLeftHandHalfTurn.getSymbol());

		indexCupRightHandFullTurn.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-06-01"), indexCupRightHandFullTurn.getSymbol());
		indexCupRightHandFullTurn.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-03-01"), indexCupRightHandFullTurn.getSymbol());

		indexCupLeftHandFullTurn.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-06-09"), indexCupLeftHandFullTurn.getSymbol());
		indexCupLeftHandFullTurn.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-03-09"), indexCupLeftHandFullTurn.getSymbol());

		indexCupRightHandPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-01-01"), indexCupRightHandPitched.getSymbol());
		indexCupRightHandPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-04-01"), indexCupRightHandPitched.getSymbol());

		indexCupLeftHandPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-01-09"), indexCupLeftHandPitched.getSymbol());
		indexCupLeftHandPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-04-09"), indexCupLeftHandPitched.getSymbol());

		indexCupRightHandHalfTurnPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-02-01"), indexCupRightHandHalfTurnPitched.getSymbol());
		indexCupRightHandHalfTurnPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-05-01"), indexCupRightHandHalfTurnPitched.getSymbol());

		indexCupLeftHandHalfTurnPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-02-09"), indexCupLeftHandHalfTurnPitched.getSymbol());
		indexCupLeftHandHalfTurnPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-05-09"), indexCupLeftHandHalfTurnPitched.getSymbol());

		indexCupRightHandFullTurnPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-03-01"), indexCupRightHandFullTurnPitched.getSymbol());
		indexCupRightHandFullTurnPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-06-01"), indexCupRightHandFullTurnPitched.getSymbol());

		indexCupLeftHandFullTurnPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-03-09"), indexCupLeftHandFullTurnPitched.getSymbol());
		indexCupLeftHandFullTurnPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-06-09"), indexCupLeftHandFullTurnPitched.getSymbol());

		indexHingeOnFistRightHand.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-04-01"), indexHingeOnFistRightHand.getSymbol());
		indexHingeOnFistRightHand.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-01-01"), indexHingeOnFistRightHand.getSymbol());

		indexHingeOnFistLeftHand.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-04-09"), indexHingeOnFistLeftHand.getSymbol());
		indexHingeOnFistLeftHand.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-01-09"), indexHingeOnFistLeftHand.getSymbol());

		indexHingeOnFistRightHandHalfTurn.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-05-01"), indexHingeOnFistRightHandHalfTurn.getSymbol());
		indexHingeOnFistRightHandHalfTurn.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-02-01"), indexHingeOnFistRightHandHalfTurn.getSymbol());

		indexHingeOnFistLeftHandHalfTurn.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-05-09"), indexHingeOnFistLeftHandHalfTurn.getSymbol());
		indexHingeOnFistLeftHandHalfTurn.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-02-09"), indexHingeOnFistLeftHandHalfTurn.getSymbol());

		indexHingeOnFistRightHandFullTurn.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-06-01"), indexHingeOnFistRightHandFullTurn.getSymbol());
		indexHingeOnFistRightHandFullTurn.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-03-01"), indexHingeOnFistRightHandFullTurn.getSymbol());

		indexHingeOnFistLeftHandFullTurn.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-06-09"), indexHingeOnFistLeftHandFullTurn.getSymbol());
		indexHingeOnFistLeftHandFullTurn.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-03-09"), indexHingeOnFistLeftHandFullTurn.getSymbol());

		indexHingeOnFistRightHandPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-01-01"), indexHingeOnFistRightHandPitched.getSymbol());
		indexHingeOnFistRightHandPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-04-01"), indexHingeOnFistRightHandPitched.getSymbol());

		indexHingeOnFistLeftHandPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-01-09"), indexHingeOnFistLeftHandPitched.getSymbol());
		indexHingeOnFistLeftHandPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-04-09"), indexHingeOnFistLeftHandPitched.getSymbol());

		indexHingeOnFistRightHandHalfTurnPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-02-01"),
				indexHingeOnFistRightHandHalfTurnPitched.getSymbol());
		indexHingeOnFistRightHandHalfTurnPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-05-01"),
				indexHingeOnFistRightHandHalfTurnPitched.getSymbol());

		indexHingeOnFistLeftHandHalfTurnPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-02-09"),
				indexHingeOnFistLeftHandHalfTurnPitched.getSymbol());
		indexHingeOnFistLeftHandHalfTurnPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-05-09"),
				indexHingeOnFistLeftHandHalfTurnPitched.getSymbol());

		indexHingeOnFistRightHandFullTurnPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-03-01"),
				indexHingeOnFistRightHandFullTurnPitched.getSymbol());
		indexHingeOnFistRightHandFullTurnPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-06-01"),
				indexHingeOnFistRightHandFullTurnPitched.getSymbol());

		indexHingeOnFistLeftHandFullTurnPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-03-09"),
				indexHingeOnFistLeftHandFullTurnPitched.getSymbol());
		indexHingeOnFistLeftHandFullTurnPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-06-09"),
				indexHingeOnFistLeftHandFullTurnPitched.getSymbol());

		indexHingeOnFistLowRightHand.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-04-01"), indexHingeOnFistLowRightHand.getSymbol());
		indexHingeOnFistLowRightHand.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-01-01"), indexHingeOnFistLowRightHand.getSymbol());

		indexHingeOnFistLowLeftHand.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-04-09"), indexHingeOnFistLowLeftHand.getSymbol());
		indexHingeOnFistLowLeftHand.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-01-09"), indexHingeOnFistLowLeftHand.getSymbol());

		indexHingeOnFistLowRightHandHalfTurn.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-05-01"),
				indexHingeOnFistLowRightHandHalfTurn.getSymbol());
		indexHingeOnFistLowRightHandHalfTurn.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-02-01"),
				indexHingeOnFistLowRightHandHalfTurn.getSymbol());

		indexHingeOnFistLowLeftHandHalfTurn.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-05-09"), indexHingeOnFistLowLeftHandHalfTurn.getSymbol());
		indexHingeOnFistLowLeftHandHalfTurn.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-02-09"), indexHingeOnFistLowLeftHandHalfTurn.getSymbol());

		indexHingeOnFistLowRightHandFullTurn.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-06-01"),
				indexHingeOnFistLowRightHandFullTurn.getSymbol());
		indexHingeOnFistLowRightHandFullTurn.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-03-01"),
				indexHingeOnFistLowRightHandFullTurn.getSymbol());

		indexHingeOnFistLowLeftHandFullTurn.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-06-09"), indexHingeOnFistLowLeftHandFullTurn.getSymbol());
		indexHingeOnFistLowLeftHandFullTurn.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-03-09"), indexHingeOnFistLowLeftHandFullTurn.getSymbol());

		indexHingeOnFistLowRightHandPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-01-01"), indexHingeOnFistLowRightHandPitched.getSymbol());
		indexHingeOnFistLowRightHandPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-04-01"), indexHingeOnFistLowRightHandPitched.getSymbol());

		indexHingeOnFistLowLeftHandPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-01-09"), indexHingeOnFistLowLeftHandPitched.getSymbol());
		indexHingeOnFistLowLeftHandPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-04-09"), indexHingeOnFistLowLeftHandPitched.getSymbol());

		indexHingeOnFistLowRightHandHalfTurnPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-02-01"),
				indexHingeOnFistLowRightHandHalfTurnPitched.getSymbol());
		indexHingeOnFistLowRightHandHalfTurnPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-05-01"),
				indexHingeOnFistLowRightHandHalfTurnPitched.getSymbol());

		indexHingeOnFistLowLeftHandHalfTurnPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-02-09"),
				indexHingeOnFistLowLeftHandHalfTurnPitched.getSymbol());
		indexHingeOnFistLowLeftHandHalfTurnPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-05-09"),
				indexHingeOnFistLowLeftHandHalfTurnPitched.getSymbol());

		indexHingeOnFistLowRightHandFullTurnPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-03-01"),
				indexHingeOnFistLowRightHandFullTurnPitched.getSymbol());
		indexHingeOnFistLowRightHandFullTurnPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-06-01"),
				indexHingeOnFistLowRightHandFullTurnPitched.getSymbol());

		indexHingeOnFistLowLeftHandFullTurnPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-03-09"),
				indexHingeOnFistLowLeftHandFullTurnPitched.getSymbol());
		indexHingeOnFistLowLeftHandFullTurnPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-06-09"),
				indexHingeOnFistLowLeftHandFullTurnPitched.getSymbol());

		indexHingeOnCircleRightHand.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-04-01"), indexHingeOnCircleRightHand.getSymbol());
		indexHingeOnCircleRightHand.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-01-01"), indexHingeOnCircleRightHand.getSymbol());

		indexHingeOnCircleLeftHand.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-04-09"), indexHingeOnCircleLeftHand.getSymbol());
		indexHingeOnCircleLeftHand.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-01-09"), indexHingeOnCircleLeftHand.getSymbol());

		indexHingeOnCircleRightHandHalfTurn.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-05-01"), indexHingeOnCircleRightHandHalfTurn.getSymbol());
		indexHingeOnCircleRightHandHalfTurn.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-02-01"), indexHingeOnCircleRightHandHalfTurn.getSymbol());

		indexHingeOnCircleLeftHandHalfTurn.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-05-09"), indexHingeOnCircleLeftHandHalfTurn.getSymbol());
		indexHingeOnCircleLeftHandHalfTurn.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-02-09"), indexHingeOnCircleLeftHandHalfTurn.getSymbol());

		indexHingeOnCircleRightHandFullTurn.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-06-01"), indexHingeOnCircleRightHandFullTurn.getSymbol());
		indexHingeOnCircleRightHandFullTurn.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-03-01"), indexHingeOnCircleRightHandFullTurn.getSymbol());

		indexHingeOnCircleLeftHandFullTurn.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-06-09"), indexHingeOnCircleLeftHandFullTurn.getSymbol());
		indexHingeOnCircleLeftHandFullTurn.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-03-09"), indexHingeOnCircleLeftHandFullTurn.getSymbol());

		indexHingeOnCircleRightHandPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-01-01"), indexHingeOnCircleRightHandPitched.getSymbol());
		indexHingeOnCircleRightHandPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-04-01"), indexHingeOnCircleRightHandPitched.getSymbol());

		indexHingeOnCircleLeftHandPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-01-09"), indexHingeOnCircleLeftHandPitched.getSymbol());
		indexHingeOnCircleLeftHandPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-04-09"), indexHingeOnCircleLeftHandPitched.getSymbol());

		indexHingeOnCircleRightHandHalfTurnPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-02-01"),
				indexHingeOnCircleRightHandHalfTurnPitched.getSymbol());
		indexHingeOnCircleRightHandHalfTurnPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-05-01"),
				indexHingeOnCircleRightHandHalfTurnPitched.getSymbol());

		indexHingeOnCircleLeftHandHalfTurnPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-02-09"),
				indexHingeOnCircleLeftHandHalfTurnPitched.getSymbol());
		indexHingeOnCircleLeftHandHalfTurnPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-05-09"),
				indexHingeOnCircleLeftHandHalfTurnPitched.getSymbol());

		indexHingeOnCircleRightHandFullTurnPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-03-01"),
				indexHingeOnCircleRightHandFullTurnPitched.getSymbol());
		indexHingeOnCircleRightHandFullTurnPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-06-01"),
				indexHingeOnCircleRightHandFullTurnPitched.getSymbol());

		indexHingeOnCircleLeftHandFullTurnPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-03-09"),
				indexHingeOnCircleLeftHandFullTurnPitched.getSymbol());
		indexHingeOnCircleLeftHandFullTurnPitched.pitch();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-06-09"),
				indexHingeOnCircleLeftHandFullTurnPitched.getSymbol());

	}

	@Override
	public void testCanRoll() {

		assertTrue(indexRightHand.canRoll());
		assertTrue(indexLeftHand.canRoll());
		assertTrue(indexRightHandHalfTurn.canRoll());
		assertTrue(indexLeftHandHalfTurn.canRoll());
		assertTrue(indexRightHandFullTurn.canRoll());
		assertTrue(indexLeftHandFullTurn.canRoll());
		assertTrue(indexRightHandPitched.canRoll());
		assertTrue(indexLeftHandPitched.canRoll());
		assertTrue(indexRightHandHalfTurnPitched.canRoll());
		assertTrue(indexLeftHandHalfTurnPitched.canRoll());
		assertTrue(indexRightHandFullTurnPitched.canRoll());
		assertTrue(indexLeftHandFullTurnPitched.canRoll());

		assertTrue(indexOnCircleRightHand.canRoll());
		assertTrue(indexOnCircleLeftHand.canRoll());
		assertTrue(indexOnCircleRightHandHalfTurn.canRoll());
		assertTrue(indexOnCircleLeftHandHalfTurn.canRoll());
		assertTrue(indexOnCircleRightHandFullTurn.canRoll());
		assertTrue(indexOnCircleLeftHandFullTurn.canRoll());
		assertTrue(indexOnCircleRightHandPitched.canRoll());
		assertTrue(indexOnCircleLeftHandPitched.canRoll());
		assertTrue(indexOnCircleRightHandHalfTurnPitched.canRoll());
		assertTrue(indexOnCircleLeftHandHalfTurnPitched.canRoll());
		assertTrue(indexOnCircleRightHandFullTurnPitched.canRoll());
		assertTrue(indexOnCircleLeftHandFullTurnPitched.canRoll());

		assertTrue(indexOnCupRightHand.canRoll());
		assertTrue(indexOnCupLeftHand.canRoll());
		assertTrue(indexOnCupRightHandHalfTurn.canRoll());
		assertTrue(indexOnCupLeftHandHalfTurn.canRoll());
		assertTrue(indexOnCupRightHandFullTurn.canRoll());
		assertTrue(indexOnCupLeftHandFullTurn.canRoll());
		assertTrue(indexOnCupRightHandPitched.canRoll());
		assertTrue(indexOnCupLeftHandPitched.canRoll());
		assertTrue(indexOnCupRightHandHalfTurnPitched.canRoll());
		assertTrue(indexOnCupLeftHandHalfTurnPitched.canRoll());
		assertTrue(indexOnCupRightHandFullTurnPitched.canRoll());
		assertTrue(indexOnCupLeftHandFullTurnPitched.canRoll());

		assertTrue(indexOnOvalRightHand.canRoll());
		assertTrue(indexOnOvalLeftHand.canRoll());
		assertTrue(indexOnOvalRightHandHalfTurn.canRoll());
		assertTrue(indexOnOvalLeftHandHalfTurn.canRoll());
		assertTrue(indexOnOvalRightHandFullTurn.canRoll());
		assertTrue(indexOnOvalLeftHandFullTurn.canRoll());
		assertTrue(indexOnOvalRightHandPitched.canRoll());
		assertTrue(indexOnOvalLeftHandPitched.canRoll());
		assertTrue(indexOnOvalRightHandHalfTurnPitched.canRoll());
		assertTrue(indexOnOvalLeftHandHalfTurnPitched.canRoll());
		assertTrue(indexOnOvalRightHandFullTurnPitched.canRoll());
		assertTrue(indexOnOvalLeftHandFullTurnPitched.canRoll());

		assertTrue(indexOnHingeRightHand.canRoll());
		assertTrue(indexOnHingeLeftHand.canRoll());
		assertTrue(indexOnHingeRightHandHalfTurn.canRoll());
		assertTrue(indexOnHingeLeftHandHalfTurn.canRoll());
		assertTrue(indexOnHingeRightHandFullTurn.canRoll());
		assertTrue(indexOnHingeLeftHandFullTurn.canRoll());
		assertTrue(indexOnHingeRightHandPitched.canRoll());
		assertTrue(indexOnHingeLeftHandPitched.canRoll());
		assertTrue(indexOnHingeRightHandHalfTurnPitched.canRoll());
		assertTrue(indexOnHingeLeftHandHalfTurnPitched.canRoll());
		assertTrue(indexOnHingeRightHandFullTurnPitched.canRoll());
		assertTrue(indexOnHingeLeftHandFullTurnPitched.canRoll());

		assertTrue(indexOnAngleRightHand.canRoll());
		assertTrue(indexOnAngleLeftHand.canRoll());
		assertTrue(indexOnAngleRightHandHalfTurn.canRoll());
		assertTrue(indexOnAngleLeftHandHalfTurn.canRoll());
		assertTrue(indexOnAngleRightHandFullTurn.canRoll());
		assertTrue(indexOnAngleLeftHandFullTurn.canRoll());
		assertTrue(indexOnAngleRightHandPitched.canRoll());
		assertTrue(indexOnAngleLeftHandPitched.canRoll());
		assertTrue(indexOnAngleRightHandHalfTurnPitched.canRoll());
		assertTrue(indexOnAngleLeftHandHalfTurnPitched.canRoll());
		assertTrue(indexOnAngleRightHandFullTurnPitched.canRoll());
		assertTrue(indexOnAngleLeftHandFullTurnPitched.canRoll());

		assertTrue(indexBentRightHand.canRoll());
		assertTrue(indexBentLeftHand.canRoll());
		assertTrue(indexBentRightHandHalfTurn.canRoll());
		assertTrue(indexBentLeftHandHalfTurn.canRoll());
		assertTrue(indexBentRightHandFullTurn.canRoll());
		assertTrue(indexBentLeftHandFullTurn.canRoll());
		assertTrue(indexBentRightHandPitched.canRoll());
		assertTrue(indexBentLeftHandPitched.canRoll());
		assertTrue(indexBentRightHandHalfTurnPitched.canRoll());
		assertTrue(indexBentLeftHandHalfTurnPitched.canRoll());
		assertTrue(indexBentRightHandFullTurnPitched.canRoll());
		assertTrue(indexBentLeftHandFullTurnPitched.canRoll());

		assertTrue(indexBentOnCircleRightHand.canRoll());
		assertTrue(indexBentOnCircleLeftHand.canRoll());
		assertTrue(indexBentOnCircleRightHandHalfTurn.canRoll());
		assertTrue(indexBentOnCircleLeftHandHalfTurn.canRoll());
		assertTrue(indexBentOnCircleRightHandFullTurn.canRoll());
		assertTrue(indexBentOnCircleLeftHandFullTurn.canRoll());
		assertTrue(indexBentOnCircleRightHandPitched.canRoll());
		assertTrue(indexBentOnCircleLeftHandPitched.canRoll());
		assertTrue(indexBentOnCircleRightHandHalfTurnPitched.canRoll());
		assertTrue(indexBentOnCircleLeftHandHalfTurnPitched.canRoll());
		assertTrue(indexBentOnCircleRightHandFullTurnPitched.canRoll());
		assertTrue(indexBentOnCircleLeftHandFullTurnPitched.canRoll());

		assertTrue(indexBentOnFistThumbUnderRightHand.canRoll());
		assertTrue(indexBentOnFistThumbUnderLeftHand.canRoll());
		assertTrue(indexBentOnFistThumbUnderRightHandHalfTurn.canRoll());
		assertTrue(indexBentOnFistThumbUnderLeftHandHalfTurn.canRoll());
		assertTrue(indexBentOnFistThumbUnderRightHandFullTurn.canRoll());
		assertTrue(indexBentOnFistThumbUnderLeftHandFullTurn.canRoll());
		assertTrue(indexBentOnFistThumbUnderRightHandPitched.canRoll());
		assertTrue(indexBentOnFistThumbUnderLeftHandPitched.canRoll());
		assertTrue(indexBentOnFistThumbUnderRightHandHalfTurnPitched.canRoll());
		assertTrue(indexBentOnFistThumbUnderLeftHandHalfTurnPitched.canRoll());
		assertTrue(indexBentOnFistThumbUnderRightHandFullTurnPitched.canRoll());
		assertTrue(indexBentOnFistThumbUnderLeftHandFullTurnPitched.canRoll());

		assertTrue(indexRaisedKnuckleRightHand.canRoll());
		assertTrue(indexRaisedKnuckleLeftHand.canRoll());
		assertTrue(indexRaisedKnuckleRightHandHalfTurn.canRoll());
		assertTrue(indexRaisedKnuckleLeftHandHalfTurn.canRoll());
		assertTrue(indexRaisedKnuckleRightHandFullTurn.canRoll());
		assertTrue(indexRaisedKnuckleLeftHandFullTurn.canRoll());
		assertTrue(indexRaisedKnuckleRightHandPitched.canRoll());
		assertTrue(indexRaisedKnuckleLeftHandPitched.canRoll());
		assertTrue(indexRaisedKnuckleRightHandHalfTurnPitched.canRoll());
		assertTrue(indexRaisedKnuckleLeftHandHalfTurnPitched.canRoll());
		assertTrue(indexRaisedKnuckleRightHandFullTurnPitched.canRoll());
		assertTrue(indexRaisedKnuckleLeftHandFullTurnPitched.canRoll());

		assertTrue(indexCupRightHand.canRoll());
		assertTrue(indexCupLeftHand.canRoll());
		assertTrue(indexCupRightHandHalfTurn.canRoll());
		assertTrue(indexCupLeftHandHalfTurn.canRoll());
		assertTrue(indexCupRightHandFullTurn.canRoll());
		assertTrue(indexCupLeftHandFullTurn.canRoll());
		assertTrue(indexCupRightHandPitched.canRoll());
		assertTrue(indexCupLeftHandPitched.canRoll());
		assertTrue(indexCupRightHandHalfTurnPitched.canRoll());
		assertTrue(indexCupLeftHandHalfTurnPitched.canRoll());
		assertTrue(indexCupRightHandFullTurnPitched.canRoll());
		assertTrue(indexCupLeftHandFullTurnPitched.canRoll());

		assertTrue(indexHingeOnFistRightHand.canRoll());
		assertTrue(indexHingeOnFistLeftHand.canRoll());
		assertTrue(indexHingeOnFistRightHandHalfTurn.canRoll());
		assertTrue(indexHingeOnFistLeftHandHalfTurn.canRoll());
		assertTrue(indexHingeOnFistRightHandFullTurn.canRoll());
		assertTrue(indexHingeOnFistLeftHandFullTurn.canRoll());
		assertTrue(indexHingeOnFistRightHandPitched.canRoll());
		assertTrue(indexHingeOnFistLeftHandPitched.canRoll());
		assertTrue(indexHingeOnFistRightHandHalfTurnPitched.canRoll());
		assertTrue(indexHingeOnFistLeftHandHalfTurnPitched.canRoll());
		assertTrue(indexHingeOnFistRightHandFullTurnPitched.canRoll());
		assertTrue(indexHingeOnFistLeftHandFullTurnPitched.canRoll());

		assertTrue(indexHingeOnFistLowRightHand.canRoll());
		assertTrue(indexHingeOnFistLowLeftHand.canRoll());
		assertTrue(indexHingeOnFistLowRightHandHalfTurn.canRoll());
		assertTrue(indexHingeOnFistLowLeftHandHalfTurn.canRoll());
		assertTrue(indexHingeOnFistLowRightHandFullTurn.canRoll());
		assertTrue(indexHingeOnFistLowLeftHandFullTurn.canRoll());
		assertTrue(indexHingeOnFistLowRightHandPitched.canRoll());
		assertTrue(indexHingeOnFistLowLeftHandPitched.canRoll());
		assertTrue(indexHingeOnFistLowRightHandHalfTurnPitched.canRoll());
		assertTrue(indexHingeOnFistLowLeftHandHalfTurnPitched.canRoll());
		assertTrue(indexHingeOnFistLowRightHandFullTurnPitched.canRoll());
		assertTrue(indexHingeOnFistLowLeftHandFullTurnPitched.canRoll());

		assertTrue(indexHingeOnCircleRightHand.canRoll());
		assertTrue(indexHingeOnCircleLeftHand.canRoll());
		assertTrue(indexHingeOnCircleRightHandHalfTurn.canRoll());
		assertTrue(indexHingeOnCircleLeftHandHalfTurn.canRoll());
		assertTrue(indexHingeOnCircleRightHandFullTurn.canRoll());
		assertTrue(indexHingeOnCircleLeftHandFullTurn.canRoll());
		assertTrue(indexHingeOnCircleRightHandPitched.canRoll());
		assertTrue(indexHingeOnCircleLeftHandPitched.canRoll());
		assertTrue(indexHingeOnCircleRightHandHalfTurnPitched.canRoll());
		assertTrue(indexHingeOnCircleLeftHandHalfTurnPitched.canRoll());
		assertTrue(indexHingeOnCircleRightHandFullTurnPitched.canRoll());
		assertTrue(indexHingeOnCircleLeftHandFullTurnPitched.canRoll());

	}

	@Override
	public void testRoll() {

		indexRightHand.roll();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-03-01"), indexRightHand.getSymbol());
		indexRightHand.roll();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-02-01"), indexRightHand.getSymbol());
		indexRightHand.roll();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-01-01"), indexRightHand.getSymbol());

		indexLeftHand.roll();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-03-09"), indexLeftHand.getSymbol());
		indexLeftHand.roll();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-02-09"), indexLeftHand.getSymbol());
		indexLeftHand.roll();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-01-09"), indexLeftHand.getSymbol());

		indexRightHandHalfTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-01-01"), indexRightHandHalfTurn.getSymbol());
		indexRightHandHalfTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-03-01"), indexRightHandHalfTurn.getSymbol());
		indexRightHandHalfTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-02-01"), indexRightHandHalfTurn.getSymbol());

		indexLeftHandHalfTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-01-09"), indexLeftHandHalfTurn.getSymbol());
		indexLeftHandHalfTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-03-09"), indexLeftHandHalfTurn.getSymbol());
		indexLeftHandHalfTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-02-09"), indexLeftHandHalfTurn.getSymbol());

		indexRightHandFullTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-02-01"), indexRightHandFullTurn.getSymbol());
		indexRightHandFullTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-01-01"), indexRightHandFullTurn.getSymbol());
		indexRightHandFullTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-03-01"), indexRightHandFullTurn.getSymbol());

		indexLeftHandFullTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-02-09"), indexLeftHandFullTurn.getSymbol());
		indexLeftHandFullTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-01-09"), indexLeftHandFullTurn.getSymbol());
		indexLeftHandFullTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-03-09"), indexLeftHandFullTurn.getSymbol());

		indexRightHandPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-06-01"), indexRightHandPitched.getSymbol());
		indexRightHandPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-05-01"), indexRightHandPitched.getSymbol());
		indexRightHandPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-04-01"), indexRightHandPitched.getSymbol());

		indexLeftHandPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-06-09"), indexLeftHandPitched.getSymbol());
		indexLeftHandPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-05-09"), indexLeftHandPitched.getSymbol());
		indexLeftHandPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-04-09"), indexLeftHandPitched.getSymbol());

		indexRightHandHalfTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-04-01"), indexRightHandHalfTurnPitched.getSymbol());
		indexRightHandHalfTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-06-01"), indexRightHandHalfTurnPitched.getSymbol());
		indexRightHandHalfTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-05-01"), indexRightHandHalfTurnPitched.getSymbol());

		indexLeftHandHalfTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-04-09"), indexLeftHandHalfTurnPitched.getSymbol());
		indexLeftHandHalfTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-06-09"), indexLeftHandHalfTurnPitched.getSymbol());
		indexLeftHandHalfTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-05-09"), indexLeftHandHalfTurnPitched.getSymbol());

		indexRightHandFullTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-05-01"), indexRightHandFullTurnPitched.getSymbol());
		indexRightHandFullTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-04-01"), indexRightHandFullTurnPitched.getSymbol());
		indexRightHandFullTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-06-01"), indexRightHandFullTurnPitched.getSymbol());

		indexLeftHandFullTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-05-09"), indexLeftHandFullTurnPitched.getSymbol());
		indexLeftHandFullTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-04-09"), indexLeftHandFullTurnPitched.getSymbol());
		indexLeftHandFullTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-001-01-06-09"), indexLeftHandFullTurnPitched.getSymbol());

		indexOnCircleRightHand.roll();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-03-01"), indexOnCircleRightHand.getSymbol());
		indexOnCircleRightHand.roll();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-02-01"), indexOnCircleRightHand.getSymbol());
		indexOnCircleRightHand.roll();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-01-01"), indexOnCircleRightHand.getSymbol());

		indexOnCircleLeftHand.roll();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-03-09"), indexOnCircleLeftHand.getSymbol());
		indexOnCircleLeftHand.roll();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-02-09"), indexOnCircleLeftHand.getSymbol());
		indexOnCircleLeftHand.roll();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-01-09"), indexOnCircleLeftHand.getSymbol());

		indexOnCircleRightHandHalfTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-01-01"), indexOnCircleRightHandHalfTurn.getSymbol());
		indexOnCircleRightHandHalfTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-03-01"), indexOnCircleRightHandHalfTurn.getSymbol());
		indexOnCircleRightHandHalfTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-02-01"), indexOnCircleRightHandHalfTurn.getSymbol());

		indexOnCircleLeftHandHalfTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-01-09"), indexOnCircleLeftHandHalfTurn.getSymbol());
		indexOnCircleLeftHandHalfTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-03-09"), indexOnCircleLeftHandHalfTurn.getSymbol());
		indexOnCircleLeftHandHalfTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-02-09"), indexOnCircleLeftHandHalfTurn.getSymbol());

		indexOnCircleRightHandFullTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-02-01"), indexOnCircleRightHandFullTurn.getSymbol());
		indexOnCircleRightHandFullTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-01-01"), indexOnCircleRightHandFullTurn.getSymbol());
		indexOnCircleRightHandFullTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-03-01"), indexOnCircleRightHandFullTurn.getSymbol());

		indexOnCircleLeftHandFullTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-02-09"), indexOnCircleLeftHandFullTurn.getSymbol());
		indexOnCircleLeftHandFullTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-01-09"), indexOnCircleLeftHandFullTurn.getSymbol());
		indexOnCircleLeftHandFullTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-03-09"), indexOnCircleLeftHandFullTurn.getSymbol());

		indexOnCircleRightHandPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-06-01"), indexOnCircleRightHandPitched.getSymbol());
		indexOnCircleRightHandPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-05-01"), indexOnCircleRightHandPitched.getSymbol());
		indexOnCircleRightHandPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-04-01"), indexOnCircleRightHandPitched.getSymbol());

		indexOnCircleLeftHandPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-06-09"), indexOnCircleLeftHandPitched.getSymbol());
		indexOnCircleLeftHandPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-05-09"), indexOnCircleLeftHandPitched.getSymbol());
		indexOnCircleLeftHandPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-04-09"), indexOnCircleLeftHandPitched.getSymbol());

		indexOnCircleRightHandHalfTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-04-01"),
				indexOnCircleRightHandHalfTurnPitched.getSymbol());
		indexOnCircleRightHandHalfTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-06-01"),
				indexOnCircleRightHandHalfTurnPitched.getSymbol());
		indexOnCircleRightHandHalfTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-05-01"),
				indexOnCircleRightHandHalfTurnPitched.getSymbol());

		indexOnCircleLeftHandHalfTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-04-09"),
				indexOnCircleLeftHandHalfTurnPitched.getSymbol());
		indexOnCircleLeftHandHalfTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-06-09"),
				indexOnCircleLeftHandHalfTurnPitched.getSymbol());
		indexOnCircleLeftHandHalfTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-05-09"),
				indexOnCircleLeftHandHalfTurnPitched.getSymbol());

		indexOnCircleRightHandFullTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-05-01"),
				indexOnCircleRightHandFullTurnPitched.getSymbol());
		indexOnCircleRightHandFullTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-04-01"),
				indexOnCircleRightHandFullTurnPitched.getSymbol());
		indexOnCircleRightHandFullTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-06-01"),
				indexOnCircleRightHandFullTurnPitched.getSymbol());

		indexOnCircleLeftHandFullTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-05-09"),
				indexOnCircleLeftHandFullTurnPitched.getSymbol());
		indexOnCircleLeftHandFullTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-04-09"),
				indexOnCircleLeftHandFullTurnPitched.getSymbol());
		indexOnCircleLeftHandFullTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-002-01-06-09"),
				indexOnCircleLeftHandFullTurnPitched.getSymbol());

		indexOnCupRightHand.roll();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-03-01"), indexOnCupRightHand.getSymbol());
		indexOnCupRightHand.roll();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-02-01"), indexOnCupRightHand.getSymbol());
		indexOnCupRightHand.roll();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-01-01"), indexOnCupRightHand.getSymbol());

		indexOnCupLeftHand.roll();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-03-09"), indexOnCupLeftHand.getSymbol());
		indexOnCupLeftHand.roll();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-02-09"), indexOnCupLeftHand.getSymbol());
		indexOnCupLeftHand.roll();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-01-09"), indexOnCupLeftHand.getSymbol());

		indexOnCupRightHandHalfTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-01-01"), indexOnCupRightHandHalfTurn.getSymbol());
		indexOnCupRightHandHalfTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-03-01"), indexOnCupRightHandHalfTurn.getSymbol());
		indexOnCupRightHandHalfTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-02-01"), indexOnCupRightHandHalfTurn.getSymbol());

		indexOnCupLeftHandHalfTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-01-09"), indexOnCupLeftHandHalfTurn.getSymbol());
		indexOnCupLeftHandHalfTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-03-09"), indexOnCupLeftHandHalfTurn.getSymbol());
		indexOnCupLeftHandHalfTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-02-09"), indexOnCupLeftHandHalfTurn.getSymbol());

		indexOnCupRightHandFullTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-02-01"), indexOnCupRightHandFullTurn.getSymbol());
		indexOnCupRightHandFullTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-01-01"), indexOnCupRightHandFullTurn.getSymbol());
		indexOnCupRightHandFullTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-03-01"), indexOnCupRightHandFullTurn.getSymbol());

		indexOnCupLeftHandFullTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-02-09"), indexOnCupLeftHandFullTurn.getSymbol());
		indexOnCupLeftHandFullTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-01-09"), indexOnCupLeftHandFullTurn.getSymbol());
		indexOnCupLeftHandFullTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-03-09"), indexOnCupLeftHandFullTurn.getSymbol());

		indexOnCupRightHandPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-06-01"), indexOnCupRightHandPitched.getSymbol());
		indexOnCupRightHandPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-05-01"), indexOnCupRightHandPitched.getSymbol());
		indexOnCupRightHandPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-04-01"), indexOnCupRightHandPitched.getSymbol());

		indexOnCupLeftHandPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-06-09"), indexOnCupLeftHandPitched.getSymbol());
		indexOnCupLeftHandPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-05-09"), indexOnCupLeftHandPitched.getSymbol());
		indexOnCupLeftHandPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-04-09"), indexOnCupLeftHandPitched.getSymbol());

		indexOnCupRightHandHalfTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-04-01"), indexOnCupRightHandHalfTurnPitched.getSymbol());
		indexOnCupRightHandHalfTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-06-01"), indexOnCupRightHandHalfTurnPitched.getSymbol());
		indexOnCupRightHandHalfTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-05-01"), indexOnCupRightHandHalfTurnPitched.getSymbol());

		indexOnCupLeftHandHalfTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-04-09"), indexOnCupLeftHandHalfTurnPitched.getSymbol());
		indexOnCupLeftHandHalfTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-06-09"), indexOnCupLeftHandHalfTurnPitched.getSymbol());
		indexOnCupLeftHandHalfTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-05-09"), indexOnCupLeftHandHalfTurnPitched.getSymbol());

		indexOnCupRightHandFullTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-05-01"), indexOnCupRightHandFullTurnPitched.getSymbol());
		indexOnCupRightHandFullTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-04-01"), indexOnCupRightHandFullTurnPitched.getSymbol());
		indexOnCupRightHandFullTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-06-01"), indexOnCupRightHandFullTurnPitched.getSymbol());

		indexOnCupLeftHandFullTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-05-09"), indexOnCupLeftHandFullTurnPitched.getSymbol());
		indexOnCupLeftHandFullTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-04-09"), indexOnCupLeftHandFullTurnPitched.getSymbol());
		indexOnCupLeftHandFullTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-003-01-06-09"), indexOnCupLeftHandFullTurnPitched.getSymbol());

		indexOnOvalRightHand.roll();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-03-01"), indexOnOvalRightHand.getSymbol());
		indexOnOvalRightHand.roll();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-02-01"), indexOnOvalRightHand.getSymbol());
		indexOnOvalRightHand.roll();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-01-01"), indexOnOvalRightHand.getSymbol());

		indexOnOvalLeftHand.roll();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-03-09"), indexOnOvalLeftHand.getSymbol());
		indexOnOvalLeftHand.roll();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-02-09"), indexOnOvalLeftHand.getSymbol());
		indexOnOvalLeftHand.roll();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-01-09"), indexOnOvalLeftHand.getSymbol());

		indexOnOvalRightHandHalfTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-01-01"), indexOnOvalRightHandHalfTurn.getSymbol());
		indexOnOvalRightHandHalfTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-03-01"), indexOnOvalRightHandHalfTurn.getSymbol());
		indexOnOvalRightHandHalfTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-02-01"), indexOnOvalRightHandHalfTurn.getSymbol());

		indexOnOvalLeftHandHalfTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-01-09"), indexOnOvalLeftHandHalfTurn.getSymbol());
		indexOnOvalLeftHandHalfTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-03-09"), indexOnOvalLeftHandHalfTurn.getSymbol());
		indexOnOvalLeftHandHalfTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-02-09"), indexOnOvalLeftHandHalfTurn.getSymbol());

		indexOnOvalRightHandFullTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-02-01"), indexOnOvalRightHandFullTurn.getSymbol());
		indexOnOvalRightHandFullTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-01-01"), indexOnOvalRightHandFullTurn.getSymbol());
		indexOnOvalRightHandFullTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-03-01"), indexOnOvalRightHandFullTurn.getSymbol());

		indexOnOvalLeftHandFullTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-02-09"), indexOnOvalLeftHandFullTurn.getSymbol());
		indexOnOvalLeftHandFullTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-01-09"), indexOnOvalLeftHandFullTurn.getSymbol());
		indexOnOvalLeftHandFullTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-03-09"), indexOnOvalLeftHandFullTurn.getSymbol());

		indexOnOvalRightHandPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-06-01"), indexOnOvalRightHandPitched.getSymbol());
		indexOnOvalRightHandPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-05-01"), indexOnOvalRightHandPitched.getSymbol());
		indexOnOvalRightHandPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-04-01"), indexOnOvalRightHandPitched.getSymbol());

		indexOnOvalLeftHandPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-06-09"), indexOnOvalLeftHandPitched.getSymbol());
		indexOnOvalLeftHandPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-05-09"), indexOnOvalLeftHandPitched.getSymbol());
		indexOnOvalLeftHandPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-04-09"), indexOnOvalLeftHandPitched.getSymbol());

		indexOnOvalRightHandHalfTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-04-01"), indexOnOvalRightHandHalfTurnPitched.getSymbol());
		indexOnOvalRightHandHalfTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-06-01"), indexOnOvalRightHandHalfTurnPitched.getSymbol());
		indexOnOvalRightHandHalfTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-05-01"), indexOnOvalRightHandHalfTurnPitched.getSymbol());

		indexOnOvalLeftHandHalfTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-04-09"), indexOnOvalLeftHandHalfTurnPitched.getSymbol());
		indexOnOvalLeftHandHalfTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-06-09"), indexOnOvalLeftHandHalfTurnPitched.getSymbol());
		indexOnOvalLeftHandHalfTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-05-09"), indexOnOvalLeftHandHalfTurnPitched.getSymbol());

		indexOnOvalRightHandFullTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-05-01"), indexOnOvalRightHandFullTurnPitched.getSymbol());
		indexOnOvalRightHandFullTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-04-01"), indexOnOvalRightHandFullTurnPitched.getSymbol());
		indexOnOvalRightHandFullTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-06-01"), indexOnOvalRightHandFullTurnPitched.getSymbol());

		indexOnOvalLeftHandFullTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-05-09"), indexOnOvalLeftHandFullTurnPitched.getSymbol());
		indexOnOvalLeftHandFullTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-04-09"), indexOnOvalLeftHandFullTurnPitched.getSymbol());
		indexOnOvalLeftHandFullTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-004-01-06-09"), indexOnOvalLeftHandFullTurnPitched.getSymbol());

		indexOnHingeRightHand.roll();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-03-01"), indexOnHingeRightHand.getSymbol());
		indexOnHingeRightHand.roll();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-02-01"), indexOnHingeRightHand.getSymbol());
		indexOnHingeRightHand.roll();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-01-01"), indexOnHingeRightHand.getSymbol());

		indexOnHingeLeftHand.roll();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-03-09"), indexOnHingeLeftHand.getSymbol());
		indexOnHingeLeftHand.roll();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-02-09"), indexOnHingeLeftHand.getSymbol());
		indexOnHingeLeftHand.roll();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-01-09"), indexOnHingeLeftHand.getSymbol());

		indexOnHingeRightHandHalfTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-01-01"), indexOnHingeRightHandHalfTurn.getSymbol());
		indexOnHingeRightHandHalfTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-03-01"), indexOnHingeRightHandHalfTurn.getSymbol());
		indexOnHingeRightHandHalfTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-02-01"), indexOnHingeRightHandHalfTurn.getSymbol());

		indexOnHingeLeftHandHalfTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-01-09"), indexOnHingeLeftHandHalfTurn.getSymbol());
		indexOnHingeLeftHandHalfTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-03-09"), indexOnHingeLeftHandHalfTurn.getSymbol());
		indexOnHingeLeftHandHalfTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-02-09"), indexOnHingeLeftHandHalfTurn.getSymbol());

		indexOnHingeRightHandFullTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-02-01"), indexOnHingeRightHandFullTurn.getSymbol());
		indexOnHingeRightHandFullTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-01-01"), indexOnHingeRightHandFullTurn.getSymbol());
		indexOnHingeRightHandFullTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-03-01"), indexOnHingeRightHandFullTurn.getSymbol());

		indexOnHingeLeftHandFullTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-02-09"), indexOnHingeLeftHandFullTurn.getSymbol());
		indexOnHingeLeftHandFullTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-01-09"), indexOnHingeLeftHandFullTurn.getSymbol());
		indexOnHingeLeftHandFullTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-03-09"), indexOnHingeLeftHandFullTurn.getSymbol());

		indexOnHingeRightHandPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-06-01"), indexOnHingeRightHandPitched.getSymbol());
		indexOnHingeRightHandPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-05-01"), indexOnHingeRightHandPitched.getSymbol());
		indexOnHingeRightHandPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-04-01"), indexOnHingeRightHandPitched.getSymbol());

		indexOnHingeLeftHandPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-06-09"), indexOnHingeLeftHandPitched.getSymbol());
		indexOnHingeLeftHandPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-05-09"), indexOnHingeLeftHandPitched.getSymbol());
		indexOnHingeLeftHandPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-04-09"), indexOnHingeLeftHandPitched.getSymbol());

		indexOnHingeRightHandHalfTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-04-01"),
				indexOnHingeRightHandHalfTurnPitched.getSymbol());
		indexOnHingeRightHandHalfTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-06-01"),
				indexOnHingeRightHandHalfTurnPitched.getSymbol());
		indexOnHingeRightHandHalfTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-05-01"),
				indexOnHingeRightHandHalfTurnPitched.getSymbol());

		indexOnHingeLeftHandHalfTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-04-09"), indexOnHingeLeftHandHalfTurnPitched.getSymbol());
		indexOnHingeLeftHandHalfTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-06-09"), indexOnHingeLeftHandHalfTurnPitched.getSymbol());
		indexOnHingeLeftHandHalfTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-05-09"), indexOnHingeLeftHandHalfTurnPitched.getSymbol());

		indexOnHingeRightHandFullTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-05-01"),
				indexOnHingeRightHandFullTurnPitched.getSymbol());
		indexOnHingeRightHandFullTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-04-01"),
				indexOnHingeRightHandFullTurnPitched.getSymbol());
		indexOnHingeRightHandFullTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-06-01"),
				indexOnHingeRightHandFullTurnPitched.getSymbol());

		indexOnHingeLeftHandFullTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-05-09"), indexOnHingeLeftHandFullTurnPitched.getSymbol());
		indexOnHingeLeftHandFullTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-04-09"), indexOnHingeLeftHandFullTurnPitched.getSymbol());
		indexOnHingeLeftHandFullTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-005-01-06-09"), indexOnHingeLeftHandFullTurnPitched.getSymbol());

		indexOnAngleRightHand.roll();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-03-01"), indexOnAngleRightHand.getSymbol());
		indexOnAngleRightHand.roll();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-02-01"), indexOnAngleRightHand.getSymbol());
		indexOnAngleRightHand.roll();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-01-01"), indexOnAngleRightHand.getSymbol());

		indexOnAngleLeftHand.roll();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-03-09"), indexOnAngleLeftHand.getSymbol());
		indexOnAngleLeftHand.roll();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-02-09"), indexOnAngleLeftHand.getSymbol());
		indexOnAngleLeftHand.roll();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-01-09"), indexOnAngleLeftHand.getSymbol());

		indexOnAngleRightHandHalfTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-01-01"), indexOnAngleRightHandHalfTurn.getSymbol());
		indexOnAngleRightHandHalfTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-03-01"), indexOnAngleRightHandHalfTurn.getSymbol());
		indexOnAngleRightHandHalfTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-02-01"), indexOnAngleRightHandHalfTurn.getSymbol());

		indexOnAngleLeftHandHalfTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-01-09"), indexOnAngleLeftHandHalfTurn.getSymbol());
		indexOnAngleLeftHandHalfTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-03-09"), indexOnAngleLeftHandHalfTurn.getSymbol());
		indexOnAngleLeftHandHalfTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-02-09"), indexOnAngleLeftHandHalfTurn.getSymbol());

		indexOnAngleRightHandFullTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-02-01"), indexOnAngleRightHandFullTurn.getSymbol());
		indexOnAngleRightHandFullTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-01-01"), indexOnAngleRightHandFullTurn.getSymbol());
		indexOnAngleRightHandFullTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-03-01"), indexOnAngleRightHandFullTurn.getSymbol());

		indexOnAngleLeftHandFullTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-02-09"), indexOnAngleLeftHandFullTurn.getSymbol());
		indexOnAngleLeftHandFullTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-01-09"), indexOnAngleLeftHandFullTurn.getSymbol());
		indexOnAngleLeftHandFullTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-03-09"), indexOnAngleLeftHandFullTurn.getSymbol());

		indexOnAngleRightHandPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-06-01"), indexOnAngleRightHandPitched.getSymbol());
		indexOnAngleRightHandPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-05-01"), indexOnAngleRightHandPitched.getSymbol());
		indexOnAngleRightHandPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-04-01"), indexOnAngleRightHandPitched.getSymbol());

		indexOnAngleLeftHandPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-06-09"), indexOnAngleLeftHandPitched.getSymbol());
		indexOnAngleLeftHandPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-05-09"), indexOnAngleLeftHandPitched.getSymbol());
		indexOnAngleLeftHandPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-04-09"), indexOnAngleLeftHandPitched.getSymbol());

		indexOnAngleRightHandHalfTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-04-01"),
				indexOnAngleRightHandHalfTurnPitched.getSymbol());
		indexOnAngleRightHandHalfTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-06-01"),
				indexOnAngleRightHandHalfTurnPitched.getSymbol());
		indexOnAngleRightHandHalfTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-05-01"),
				indexOnAngleRightHandHalfTurnPitched.getSymbol());

		indexOnAngleLeftHandHalfTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-04-09"), indexOnAngleLeftHandHalfTurnPitched.getSymbol());
		indexOnAngleLeftHandHalfTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-06-09"), indexOnAngleLeftHandHalfTurnPitched.getSymbol());
		indexOnAngleLeftHandHalfTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-05-09"), indexOnAngleLeftHandHalfTurnPitched.getSymbol());

		indexOnAngleRightHandFullTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-05-01"),
				indexOnAngleRightHandFullTurnPitched.getSymbol());
		indexOnAngleRightHandFullTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-04-01"),
				indexOnAngleRightHandFullTurnPitched.getSymbol());
		indexOnAngleRightHandFullTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-06-01"),
				indexOnAngleRightHandFullTurnPitched.getSymbol());

		indexOnAngleLeftHandFullTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-05-09"), indexOnAngleLeftHandFullTurnPitched.getSymbol());
		indexOnAngleLeftHandFullTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-04-09"), indexOnAngleLeftHandFullTurnPitched.getSymbol());
		indexOnAngleLeftHandFullTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-006-01-06-09"), indexOnAngleLeftHandFullTurnPitched.getSymbol());

		indexBentRightHand.roll();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-03-01"), indexBentRightHand.getSymbol());
		indexBentRightHand.roll();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-02-01"), indexBentRightHand.getSymbol());
		indexBentRightHand.roll();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-01-01"), indexBentRightHand.getSymbol());

		indexBentLeftHand.roll();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-03-09"), indexBentLeftHand.getSymbol());
		indexBentLeftHand.roll();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-02-09"), indexBentLeftHand.getSymbol());
		indexBentLeftHand.roll();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-01-09"), indexBentLeftHand.getSymbol());

		indexBentRightHandHalfTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-01-01"), indexBentRightHandHalfTurn.getSymbol());
		indexBentRightHandHalfTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-03-01"), indexBentRightHandHalfTurn.getSymbol());
		indexBentRightHandHalfTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-02-01"), indexBentRightHandHalfTurn.getSymbol());

		indexBentLeftHandHalfTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-01-09"), indexBentLeftHandHalfTurn.getSymbol());
		indexBentLeftHandHalfTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-03-09"), indexBentLeftHandHalfTurn.getSymbol());
		indexBentLeftHandHalfTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-02-09"), indexBentLeftHandHalfTurn.getSymbol());

		indexBentRightHandFullTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-02-01"), indexBentRightHandFullTurn.getSymbol());
		indexBentRightHandFullTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-01-01"), indexBentRightHandFullTurn.getSymbol());
		indexBentRightHandFullTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-03-01"), indexBentRightHandFullTurn.getSymbol());

		indexBentLeftHandFullTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-02-09"), indexBentLeftHandFullTurn.getSymbol());
		indexBentLeftHandFullTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-01-09"), indexBentLeftHandFullTurn.getSymbol());
		indexBentLeftHandFullTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-03-09"), indexBentLeftHandFullTurn.getSymbol());

		indexBentRightHandPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-06-01"), indexBentRightHandPitched.getSymbol());
		indexBentRightHandPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-05-01"), indexBentRightHandPitched.getSymbol());
		indexBentRightHandPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-04-01"), indexBentRightHandPitched.getSymbol());

		indexBentLeftHandPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-06-09"), indexBentLeftHandPitched.getSymbol());
		indexBentLeftHandPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-05-09"), indexBentLeftHandPitched.getSymbol());
		indexBentLeftHandPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-04-09"), indexBentLeftHandPitched.getSymbol());

		indexBentRightHandHalfTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-04-01"), indexBentRightHandHalfTurnPitched.getSymbol());
		indexBentRightHandHalfTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-06-01"), indexBentRightHandHalfTurnPitched.getSymbol());
		indexBentRightHandHalfTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-05-01"), indexBentRightHandHalfTurnPitched.getSymbol());

		indexBentLeftHandHalfTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-04-09"), indexBentLeftHandHalfTurnPitched.getSymbol());
		indexBentLeftHandHalfTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-06-09"), indexBentLeftHandHalfTurnPitched.getSymbol());
		indexBentLeftHandHalfTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-05-09"), indexBentLeftHandHalfTurnPitched.getSymbol());

		indexBentRightHandFullTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-05-01"), indexBentRightHandFullTurnPitched.getSymbol());
		indexBentRightHandFullTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-04-01"), indexBentRightHandFullTurnPitched.getSymbol());
		indexBentRightHandFullTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-06-01"), indexBentRightHandFullTurnPitched.getSymbol());

		indexBentLeftHandFullTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-05-09"), indexBentLeftHandFullTurnPitched.getSymbol());
		indexBentLeftHandFullTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-04-09"), indexBentLeftHandFullTurnPitched.getSymbol());
		indexBentLeftHandFullTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-007-01-06-09"), indexBentLeftHandFullTurnPitched.getSymbol());

		indexBentOnCircleRightHand.roll();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-03-01"), indexBentOnCircleRightHand.getSymbol());
		indexBentOnCircleRightHand.roll();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-02-01"), indexBentOnCircleRightHand.getSymbol());
		indexBentOnCircleRightHand.roll();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-01-01"), indexBentOnCircleRightHand.getSymbol());

		indexBentOnCircleLeftHand.roll();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-03-09"), indexBentOnCircleLeftHand.getSymbol());
		indexBentOnCircleLeftHand.roll();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-02-09"), indexBentOnCircleLeftHand.getSymbol());
		indexBentOnCircleLeftHand.roll();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-01-09"), indexBentOnCircleLeftHand.getSymbol());

		indexBentOnCircleRightHandHalfTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-01-01"), indexBentOnCircleRightHandHalfTurn.getSymbol());
		indexBentOnCircleRightHandHalfTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-03-01"), indexBentOnCircleRightHandHalfTurn.getSymbol());
		indexBentOnCircleRightHandHalfTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-02-01"), indexBentOnCircleRightHandHalfTurn.getSymbol());

		indexBentOnCircleLeftHandHalfTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-01-09"), indexBentOnCircleLeftHandHalfTurn.getSymbol());
		indexBentOnCircleLeftHandHalfTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-03-09"), indexBentOnCircleLeftHandHalfTurn.getSymbol());
		indexBentOnCircleLeftHandHalfTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-02-09"), indexBentOnCircleLeftHandHalfTurn.getSymbol());

		indexBentOnCircleRightHandFullTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-02-01"), indexBentOnCircleRightHandFullTurn.getSymbol());
		indexBentOnCircleRightHandFullTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-01-01"), indexBentOnCircleRightHandFullTurn.getSymbol());
		indexBentOnCircleRightHandFullTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-03-01"), indexBentOnCircleRightHandFullTurn.getSymbol());

		indexBentOnCircleLeftHandFullTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-02-09"), indexBentOnCircleLeftHandFullTurn.getSymbol());
		indexBentOnCircleLeftHandFullTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-01-09"), indexBentOnCircleLeftHandFullTurn.getSymbol());
		indexBentOnCircleLeftHandFullTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-03-09"), indexBentOnCircleLeftHandFullTurn.getSymbol());

		indexBentOnCircleRightHandPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-06-01"), indexBentOnCircleRightHandPitched.getSymbol());
		indexBentOnCircleRightHandPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-05-01"), indexBentOnCircleRightHandPitched.getSymbol());
		indexBentOnCircleRightHandPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-04-01"), indexBentOnCircleRightHandPitched.getSymbol());

		indexBentOnCircleLeftHandPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-06-09"), indexBentOnCircleLeftHandPitched.getSymbol());
		indexBentOnCircleLeftHandPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-05-09"), indexBentOnCircleLeftHandPitched.getSymbol());
		indexBentOnCircleLeftHandPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-04-09"), indexBentOnCircleLeftHandPitched.getSymbol());

		indexBentOnCircleRightHandHalfTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-04-01"),
				indexBentOnCircleRightHandHalfTurnPitched.getSymbol());
		indexBentOnCircleRightHandHalfTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-06-01"),
				indexBentOnCircleRightHandHalfTurnPitched.getSymbol());
		indexBentOnCircleRightHandHalfTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-05-01"),
				indexBentOnCircleRightHandHalfTurnPitched.getSymbol());

		indexBentOnCircleLeftHandHalfTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-04-09"),
				indexBentOnCircleLeftHandHalfTurnPitched.getSymbol());
		indexBentOnCircleLeftHandHalfTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-06-09"),
				indexBentOnCircleLeftHandHalfTurnPitched.getSymbol());
		indexBentOnCircleLeftHandHalfTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-05-09"),
				indexBentOnCircleLeftHandHalfTurnPitched.getSymbol());

		indexBentOnCircleRightHandFullTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-05-01"),
				indexBentOnCircleRightHandFullTurnPitched.getSymbol());
		indexBentOnCircleRightHandFullTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-04-01"),
				indexBentOnCircleRightHandFullTurnPitched.getSymbol());
		indexBentOnCircleRightHandFullTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-06-01"),
				indexBentOnCircleRightHandFullTurnPitched.getSymbol());

		indexBentOnCircleLeftHandFullTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-05-09"),
				indexBentOnCircleLeftHandFullTurnPitched.getSymbol());
		indexBentOnCircleLeftHandFullTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-04-09"),
				indexBentOnCircleLeftHandFullTurnPitched.getSymbol());
		indexBentOnCircleLeftHandFullTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-008-01-06-09"),
				indexBentOnCircleLeftHandFullTurnPitched.getSymbol());

		indexBentOnFistThumbUnderRightHand.roll();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-03-01"), indexBentOnFistThumbUnderRightHand.getSymbol());
		indexBentOnFistThumbUnderRightHand.roll();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-02-01"), indexBentOnFistThumbUnderRightHand.getSymbol());
		indexBentOnFistThumbUnderRightHand.roll();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-01-01"), indexBentOnFistThumbUnderRightHand.getSymbol());

		indexBentOnFistThumbUnderLeftHand.roll();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-03-09"), indexBentOnFistThumbUnderLeftHand.getSymbol());
		indexBentOnFistThumbUnderLeftHand.roll();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-02-09"), indexBentOnFistThumbUnderLeftHand.getSymbol());
		indexBentOnFistThumbUnderLeftHand.roll();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-01-09"), indexBentOnFistThumbUnderLeftHand.getSymbol());

		indexBentOnFistThumbUnderRightHandHalfTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-01-01"),
				indexBentOnFistThumbUnderRightHandHalfTurn.getSymbol());
		indexBentOnFistThumbUnderRightHandHalfTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-03-01"),
				indexBentOnFistThumbUnderRightHandHalfTurn.getSymbol());
		indexBentOnFistThumbUnderRightHandHalfTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-02-01"),
				indexBentOnFistThumbUnderRightHandHalfTurn.getSymbol());

		indexBentOnFistThumbUnderLeftHandHalfTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-01-09"),
				indexBentOnFistThumbUnderLeftHandHalfTurn.getSymbol());
		indexBentOnFistThumbUnderLeftHandHalfTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-03-09"),
				indexBentOnFistThumbUnderLeftHandHalfTurn.getSymbol());
		indexBentOnFistThumbUnderLeftHandHalfTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-02-09"),
				indexBentOnFistThumbUnderLeftHandHalfTurn.getSymbol());

		indexBentOnFistThumbUnderRightHandFullTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-02-01"),
				indexBentOnFistThumbUnderRightHandFullTurn.getSymbol());
		indexBentOnFistThumbUnderRightHandFullTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-01-01"),
				indexBentOnFistThumbUnderRightHandFullTurn.getSymbol());
		indexBentOnFistThumbUnderRightHandFullTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-03-01"),
				indexBentOnFistThumbUnderRightHandFullTurn.getSymbol());

		indexBentOnFistThumbUnderLeftHandFullTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-02-09"),
				indexBentOnFistThumbUnderLeftHandFullTurn.getSymbol());
		indexBentOnFistThumbUnderLeftHandFullTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-01-09"),
				indexBentOnFistThumbUnderLeftHandFullTurn.getSymbol());
		indexBentOnFistThumbUnderLeftHandFullTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-03-09"),
				indexBentOnFistThumbUnderLeftHandFullTurn.getSymbol());

		indexBentOnFistThumbUnderRightHandPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-06-01"),
				indexBentOnFistThumbUnderRightHandPitched.getSymbol());
		indexBentOnFistThumbUnderRightHandPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-05-01"),
				indexBentOnFistThumbUnderRightHandPitched.getSymbol());
		indexBentOnFistThumbUnderRightHandPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-04-01"),
				indexBentOnFistThumbUnderRightHandPitched.getSymbol());

		indexBentOnFistThumbUnderLeftHandPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-06-09"),
				indexBentOnFistThumbUnderLeftHandPitched.getSymbol());
		indexBentOnFistThumbUnderLeftHandPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-05-09"),
				indexBentOnFistThumbUnderLeftHandPitched.getSymbol());
		indexBentOnFistThumbUnderLeftHandPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-04-09"),
				indexBentOnFistThumbUnderLeftHandPitched.getSymbol());

		indexBentOnFistThumbUnderRightHandHalfTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-04-01"),
				indexBentOnFistThumbUnderRightHandHalfTurnPitched.getSymbol());
		indexBentOnFistThumbUnderRightHandHalfTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-06-01"),
				indexBentOnFistThumbUnderRightHandHalfTurnPitched.getSymbol());
		indexBentOnFistThumbUnderRightHandHalfTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-05-01"),
				indexBentOnFistThumbUnderRightHandHalfTurnPitched.getSymbol());

		indexBentOnFistThumbUnderLeftHandHalfTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-04-09"),
				indexBentOnFistThumbUnderLeftHandHalfTurnPitched.getSymbol());
		indexBentOnFistThumbUnderLeftHandHalfTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-06-09"),
				indexBentOnFistThumbUnderLeftHandHalfTurnPitched.getSymbol());
		indexBentOnFistThumbUnderLeftHandHalfTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-05-09"),
				indexBentOnFistThumbUnderLeftHandHalfTurnPitched.getSymbol());

		indexBentOnFistThumbUnderRightHandFullTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-05-01"),
				indexBentOnFistThumbUnderRightHandFullTurnPitched.getSymbol());
		indexBentOnFistThumbUnderRightHandFullTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-04-01"),
				indexBentOnFistThumbUnderRightHandFullTurnPitched.getSymbol());
		indexBentOnFistThumbUnderRightHandFullTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-06-01"),
				indexBentOnFistThumbUnderRightHandFullTurnPitched.getSymbol());

		indexBentOnFistThumbUnderLeftHandFullTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-05-09"),
				indexBentOnFistThumbUnderLeftHandFullTurnPitched.getSymbol());
		indexBentOnFistThumbUnderLeftHandFullTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-04-09"),
				indexBentOnFistThumbUnderLeftHandFullTurnPitched.getSymbol());
		indexBentOnFistThumbUnderLeftHandFullTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-009-01-06-09"),
				indexBentOnFistThumbUnderLeftHandFullTurnPitched.getSymbol());

		indexRaisedKnuckleRightHand.roll();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-03-01"), indexRaisedKnuckleRightHand.getSymbol());
		indexRaisedKnuckleRightHand.roll();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-02-01"), indexRaisedKnuckleRightHand.getSymbol());
		indexRaisedKnuckleRightHand.roll();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-01-01"), indexRaisedKnuckleRightHand.getSymbol());

		indexRaisedKnuckleLeftHand.roll();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-03-09"), indexRaisedKnuckleLeftHand.getSymbol());
		indexRaisedKnuckleLeftHand.roll();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-02-09"), indexRaisedKnuckleLeftHand.getSymbol());
		indexRaisedKnuckleLeftHand.roll();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-01-09"), indexRaisedKnuckleLeftHand.getSymbol());

		indexRaisedKnuckleRightHandHalfTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-01-01"), indexRaisedKnuckleRightHandHalfTurn.getSymbol());
		indexRaisedKnuckleRightHandHalfTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-03-01"), indexRaisedKnuckleRightHandHalfTurn.getSymbol());
		indexRaisedKnuckleRightHandHalfTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-02-01"), indexRaisedKnuckleRightHandHalfTurn.getSymbol());

		indexRaisedKnuckleLeftHandHalfTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-01-09"), indexRaisedKnuckleLeftHandHalfTurn.getSymbol());
		indexRaisedKnuckleLeftHandHalfTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-03-09"), indexRaisedKnuckleLeftHandHalfTurn.getSymbol());
		indexRaisedKnuckleLeftHandHalfTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-02-09"), indexRaisedKnuckleLeftHandHalfTurn.getSymbol());

		indexRaisedKnuckleRightHandFullTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-02-01"), indexRaisedKnuckleRightHandFullTurn.getSymbol());
		indexRaisedKnuckleRightHandFullTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-01-01"), indexRaisedKnuckleRightHandFullTurn.getSymbol());
		indexRaisedKnuckleRightHandFullTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-03-01"), indexRaisedKnuckleRightHandFullTurn.getSymbol());

		indexRaisedKnuckleLeftHandFullTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-02-09"), indexRaisedKnuckleLeftHandFullTurn.getSymbol());
		indexRaisedKnuckleLeftHandFullTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-01-09"), indexRaisedKnuckleLeftHandFullTurn.getSymbol());
		indexRaisedKnuckleLeftHandFullTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-03-09"), indexRaisedKnuckleLeftHandFullTurn.getSymbol());

		indexRaisedKnuckleRightHandPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-06-01"), indexRaisedKnuckleRightHandPitched.getSymbol());
		indexRaisedKnuckleRightHandPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-05-01"), indexRaisedKnuckleRightHandPitched.getSymbol());
		indexRaisedKnuckleRightHandPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-04-01"), indexRaisedKnuckleRightHandPitched.getSymbol());

		indexRaisedKnuckleLeftHandPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-06-09"), indexRaisedKnuckleLeftHandPitched.getSymbol());
		indexRaisedKnuckleLeftHandPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-05-09"), indexRaisedKnuckleLeftHandPitched.getSymbol());
		indexRaisedKnuckleLeftHandPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-04-09"), indexRaisedKnuckleLeftHandPitched.getSymbol());

		indexRaisedKnuckleRightHandHalfTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-04-01"),
				indexRaisedKnuckleRightHandHalfTurnPitched.getSymbol());
		indexRaisedKnuckleRightHandHalfTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-06-01"),
				indexRaisedKnuckleRightHandHalfTurnPitched.getSymbol());
		indexRaisedKnuckleRightHandHalfTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-05-01"),
				indexRaisedKnuckleRightHandHalfTurnPitched.getSymbol());

		indexRaisedKnuckleLeftHandHalfTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-04-09"),
				indexRaisedKnuckleLeftHandHalfTurnPitched.getSymbol());
		indexRaisedKnuckleLeftHandHalfTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-06-09"),
				indexRaisedKnuckleLeftHandHalfTurnPitched.getSymbol());
		indexRaisedKnuckleLeftHandHalfTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-05-09"),
				indexRaisedKnuckleLeftHandHalfTurnPitched.getSymbol());

		indexRaisedKnuckleRightHandFullTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-05-01"),
				indexRaisedKnuckleRightHandFullTurnPitched.getSymbol());
		indexRaisedKnuckleRightHandFullTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-04-01"),
				indexRaisedKnuckleRightHandFullTurnPitched.getSymbol());
		indexRaisedKnuckleRightHandFullTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-06-01"),
				indexRaisedKnuckleRightHandFullTurnPitched.getSymbol());

		indexRaisedKnuckleLeftHandFullTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-05-09"),
				indexRaisedKnuckleLeftHandFullTurnPitched.getSymbol());
		indexRaisedKnuckleLeftHandFullTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-04-09"),
				indexRaisedKnuckleLeftHandFullTurnPitched.getSymbol());
		indexRaisedKnuckleLeftHandFullTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-010-01-06-09"),
				indexRaisedKnuckleLeftHandFullTurnPitched.getSymbol());

		indexCupRightHand.roll();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-03-01"), indexCupRightHand.getSymbol());
		indexCupRightHand.roll();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-02-01"), indexCupRightHand.getSymbol());
		indexCupRightHand.roll();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-01-01"), indexCupRightHand.getSymbol());

		indexCupLeftHand.roll();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-03-09"), indexCupLeftHand.getSymbol());
		indexCupLeftHand.roll();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-02-09"), indexCupLeftHand.getSymbol());
		indexCupLeftHand.roll();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-01-09"), indexCupLeftHand.getSymbol());

		indexCupRightHandHalfTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-01-01"), indexCupRightHandHalfTurn.getSymbol());
		indexCupRightHandHalfTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-03-01"), indexCupRightHandHalfTurn.getSymbol());
		indexCupRightHandHalfTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-02-01"), indexCupRightHandHalfTurn.getSymbol());

		indexCupLeftHandHalfTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-01-09"), indexCupLeftHandHalfTurn.getSymbol());
		indexCupLeftHandHalfTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-03-09"), indexCupLeftHandHalfTurn.getSymbol());
		indexCupLeftHandHalfTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-02-09"), indexCupLeftHandHalfTurn.getSymbol());

		indexCupRightHandFullTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-02-01"), indexCupRightHandFullTurn.getSymbol());
		indexCupRightHandFullTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-01-01"), indexCupRightHandFullTurn.getSymbol());
		indexCupRightHandFullTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-03-01"), indexCupRightHandFullTurn.getSymbol());

		indexCupLeftHandFullTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-02-09"), indexCupLeftHandFullTurn.getSymbol());
		indexCupLeftHandFullTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-01-09"), indexCupLeftHandFullTurn.getSymbol());
		indexCupLeftHandFullTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-03-09"), indexCupLeftHandFullTurn.getSymbol());

		indexCupRightHandPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-06-01"), indexCupRightHandPitched.getSymbol());
		indexCupRightHandPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-05-01"), indexCupRightHandPitched.getSymbol());
		indexCupRightHandPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-04-01"), indexCupRightHandPitched.getSymbol());

		indexCupLeftHandPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-06-09"), indexCupLeftHandPitched.getSymbol());
		indexCupLeftHandPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-05-09"), indexCupLeftHandPitched.getSymbol());
		indexCupLeftHandPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-04-09"), indexCupLeftHandPitched.getSymbol());

		indexCupRightHandHalfTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-04-01"), indexCupRightHandHalfTurnPitched.getSymbol());
		indexCupRightHandHalfTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-06-01"), indexCupRightHandHalfTurnPitched.getSymbol());
		indexCupRightHandHalfTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-05-01"), indexCupRightHandHalfTurnPitched.getSymbol());

		indexCupLeftHandHalfTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-04-09"), indexCupLeftHandHalfTurnPitched.getSymbol());
		indexCupLeftHandHalfTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-06-09"), indexCupLeftHandHalfTurnPitched.getSymbol());
		indexCupLeftHandHalfTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-05-09"), indexCupLeftHandHalfTurnPitched.getSymbol());

		indexCupRightHandFullTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-05-01"), indexCupRightHandFullTurnPitched.getSymbol());
		indexCupRightHandFullTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-04-01"), indexCupRightHandFullTurnPitched.getSymbol());
		indexCupRightHandFullTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-06-01"), indexCupRightHandFullTurnPitched.getSymbol());

		indexCupLeftHandFullTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-05-09"), indexCupLeftHandFullTurnPitched.getSymbol());
		indexCupLeftHandFullTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-04-09"), indexCupLeftHandFullTurnPitched.getSymbol());
		indexCupLeftHandFullTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-011-01-06-09"), indexCupLeftHandFullTurnPitched.getSymbol());

		indexHingeOnFistRightHand.roll();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-03-01"), indexHingeOnFistRightHand.getSymbol());
		indexHingeOnFistRightHand.roll();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-02-01"), indexHingeOnFistRightHand.getSymbol());
		indexHingeOnFistRightHand.roll();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-01-01"), indexHingeOnFistRightHand.getSymbol());

		indexHingeOnFistLeftHand.roll();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-03-09"), indexHingeOnFistLeftHand.getSymbol());
		indexHingeOnFistLeftHand.roll();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-02-09"), indexHingeOnFistLeftHand.getSymbol());
		indexHingeOnFistLeftHand.roll();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-01-09"), indexHingeOnFistLeftHand.getSymbol());

		indexHingeOnFistRightHandHalfTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-01-01"), indexHingeOnFistRightHandHalfTurn.getSymbol());
		indexHingeOnFistRightHandHalfTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-03-01"), indexHingeOnFistRightHandHalfTurn.getSymbol());
		indexHingeOnFistRightHandHalfTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-02-01"), indexHingeOnFistRightHandHalfTurn.getSymbol());

		indexHingeOnFistLeftHandHalfTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-01-09"), indexHingeOnFistLeftHandHalfTurn.getSymbol());
		indexHingeOnFistLeftHandHalfTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-03-09"), indexHingeOnFistLeftHandHalfTurn.getSymbol());
		indexHingeOnFistLeftHandHalfTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-02-09"), indexHingeOnFistLeftHandHalfTurn.getSymbol());

		indexHingeOnFistRightHandFullTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-02-01"), indexHingeOnFistRightHandFullTurn.getSymbol());
		indexHingeOnFistRightHandFullTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-01-01"), indexHingeOnFistRightHandFullTurn.getSymbol());
		indexHingeOnFistRightHandFullTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-03-01"), indexHingeOnFistRightHandFullTurn.getSymbol());

		indexHingeOnFistLeftHandFullTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-02-09"), indexHingeOnFistLeftHandFullTurn.getSymbol());
		indexHingeOnFistLeftHandFullTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-01-09"), indexHingeOnFistLeftHandFullTurn.getSymbol());
		indexHingeOnFistLeftHandFullTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-03-09"), indexHingeOnFistLeftHandFullTurn.getSymbol());

		indexHingeOnFistRightHandPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-06-01"), indexHingeOnFistRightHandPitched.getSymbol());
		indexHingeOnFistRightHandPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-05-01"), indexHingeOnFistRightHandPitched.getSymbol());
		indexHingeOnFistRightHandPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-04-01"), indexHingeOnFistRightHandPitched.getSymbol());

		indexHingeOnFistLeftHandPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-06-09"), indexHingeOnFistLeftHandPitched.getSymbol());
		indexHingeOnFistLeftHandPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-05-09"), indexHingeOnFistLeftHandPitched.getSymbol());
		indexHingeOnFistLeftHandPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-04-09"), indexHingeOnFistLeftHandPitched.getSymbol());

		indexHingeOnFistRightHandHalfTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-04-01"),
				indexHingeOnFistRightHandHalfTurnPitched.getSymbol());
		indexHingeOnFistRightHandHalfTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-06-01"),
				indexHingeOnFistRightHandHalfTurnPitched.getSymbol());
		indexHingeOnFistRightHandHalfTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-05-01"),
				indexHingeOnFistRightHandHalfTurnPitched.getSymbol());

		indexHingeOnFistLeftHandHalfTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-04-09"),
				indexHingeOnFistLeftHandHalfTurnPitched.getSymbol());
		indexHingeOnFistLeftHandHalfTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-06-09"),
				indexHingeOnFistLeftHandHalfTurnPitched.getSymbol());
		indexHingeOnFistLeftHandHalfTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-05-09"),
				indexHingeOnFistLeftHandHalfTurnPitched.getSymbol());

		indexHingeOnFistRightHandFullTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-05-01"),
				indexHingeOnFistRightHandFullTurnPitched.getSymbol());
		indexHingeOnFistRightHandFullTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-04-01"),
				indexHingeOnFistRightHandFullTurnPitched.getSymbol());
		indexHingeOnFistRightHandFullTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-06-01"),
				indexHingeOnFistRightHandFullTurnPitched.getSymbol());

		indexHingeOnFistLeftHandFullTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-05-09"),
				indexHingeOnFistLeftHandFullTurnPitched.getSymbol());
		indexHingeOnFistLeftHandFullTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-04-09"),
				indexHingeOnFistLeftHandFullTurnPitched.getSymbol());
		indexHingeOnFistLeftHandFullTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-012-01-06-09"),
				indexHingeOnFistLeftHandFullTurnPitched.getSymbol());

		indexHingeOnFistLowRightHand.roll();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-03-01"), indexHingeOnFistLowRightHand.getSymbol());
		indexHingeOnFistLowRightHand.roll();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-02-01"), indexHingeOnFistLowRightHand.getSymbol());
		indexHingeOnFistLowRightHand.roll();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-01-01"), indexHingeOnFistLowRightHand.getSymbol());

		indexHingeOnFistLowLeftHand.roll();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-03-09"), indexHingeOnFistLowLeftHand.getSymbol());
		indexHingeOnFistLowLeftHand.roll();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-02-09"), indexHingeOnFistLowLeftHand.getSymbol());
		indexHingeOnFistLowLeftHand.roll();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-01-09"), indexHingeOnFistLowLeftHand.getSymbol());

		indexHingeOnFistLowRightHandHalfTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-01-01"),
				indexHingeOnFistLowRightHandHalfTurn.getSymbol());
		indexHingeOnFistLowRightHandHalfTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-03-01"),
				indexHingeOnFistLowRightHandHalfTurn.getSymbol());
		indexHingeOnFistLowRightHandHalfTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-02-01"),
				indexHingeOnFistLowRightHandHalfTurn.getSymbol());

		indexHingeOnFistLowLeftHandHalfTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-01-09"), indexHingeOnFistLowLeftHandHalfTurn.getSymbol());
		indexHingeOnFistLowLeftHandHalfTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-03-09"), indexHingeOnFistLowLeftHandHalfTurn.getSymbol());
		indexHingeOnFistLowLeftHandHalfTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-02-09"), indexHingeOnFistLowLeftHandHalfTurn.getSymbol());

		indexHingeOnFistLowRightHandFullTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-02-01"),
				indexHingeOnFistLowRightHandFullTurn.getSymbol());
		indexHingeOnFistLowRightHandFullTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-01-01"),
				indexHingeOnFistLowRightHandFullTurn.getSymbol());
		indexHingeOnFistLowRightHandFullTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-03-01"),
				indexHingeOnFistLowRightHandFullTurn.getSymbol());

		indexHingeOnFistLowLeftHandFullTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-02-09"), indexHingeOnFistLowLeftHandFullTurn.getSymbol());
		indexHingeOnFistLowLeftHandFullTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-01-09"), indexHingeOnFistLowLeftHandFullTurn.getSymbol());
		indexHingeOnFistLowLeftHandFullTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-03-09"), indexHingeOnFistLowLeftHandFullTurn.getSymbol());

		indexHingeOnFistLowRightHandPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-06-01"), indexHingeOnFistLowRightHandPitched.getSymbol());
		indexHingeOnFistLowRightHandPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-05-01"), indexHingeOnFistLowRightHandPitched.getSymbol());
		indexHingeOnFistLowRightHandPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-04-01"), indexHingeOnFistLowRightHandPitched.getSymbol());

		indexHingeOnFistLowLeftHandPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-06-09"), indexHingeOnFistLowLeftHandPitched.getSymbol());
		indexHingeOnFistLowLeftHandPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-05-09"), indexHingeOnFistLowLeftHandPitched.getSymbol());
		indexHingeOnFistLowLeftHandPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-04-09"), indexHingeOnFistLowLeftHandPitched.getSymbol());

		indexHingeOnFistLowRightHandHalfTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-04-01"),
				indexHingeOnFistLowRightHandHalfTurnPitched.getSymbol());
		indexHingeOnFistLowRightHandHalfTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-06-01"),
				indexHingeOnFistLowRightHandHalfTurnPitched.getSymbol());
		indexHingeOnFistLowRightHandHalfTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-05-01"),
				indexHingeOnFistLowRightHandHalfTurnPitched.getSymbol());

		indexHingeOnFistLowLeftHandHalfTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-04-09"),
				indexHingeOnFistLowLeftHandHalfTurnPitched.getSymbol());
		indexHingeOnFistLowLeftHandHalfTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-06-09"),
				indexHingeOnFistLowLeftHandHalfTurnPitched.getSymbol());
		indexHingeOnFistLowLeftHandHalfTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-05-09"),
				indexHingeOnFistLowLeftHandHalfTurnPitched.getSymbol());

		indexHingeOnFistLowRightHandFullTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-05-01"),
				indexHingeOnFistLowRightHandFullTurnPitched.getSymbol());
		indexHingeOnFistLowRightHandFullTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-04-01"),
				indexHingeOnFistLowRightHandFullTurnPitched.getSymbol());
		indexHingeOnFistLowRightHandFullTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-06-01"),
				indexHingeOnFistLowRightHandFullTurnPitched.getSymbol());

		indexHingeOnFistLowLeftHandFullTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-05-09"),
				indexHingeOnFistLowLeftHandFullTurnPitched.getSymbol());
		indexHingeOnFistLowLeftHandFullTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-04-09"),
				indexHingeOnFistLowLeftHandFullTurnPitched.getSymbol());
		indexHingeOnFistLowLeftHandFullTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-013-01-06-09"),
				indexHingeOnFistLowLeftHandFullTurnPitched.getSymbol());

		indexHingeOnCircleRightHand.roll();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-03-01"), indexHingeOnCircleRightHand.getSymbol());
		indexHingeOnCircleRightHand.roll();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-02-01"), indexHingeOnCircleRightHand.getSymbol());
		indexHingeOnCircleRightHand.roll();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-01-01"), indexHingeOnCircleRightHand.getSymbol());

		indexHingeOnCircleLeftHand.roll();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-03-09"), indexHingeOnCircleLeftHand.getSymbol());
		indexHingeOnCircleLeftHand.roll();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-02-09"), indexHingeOnCircleLeftHand.getSymbol());
		indexHingeOnCircleLeftHand.roll();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-01-09"), indexHingeOnCircleLeftHand.getSymbol());

		indexHingeOnCircleRightHandHalfTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-01-01"), indexHingeOnCircleRightHandHalfTurn.getSymbol());
		indexHingeOnCircleRightHandHalfTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-03-01"), indexHingeOnCircleRightHandHalfTurn.getSymbol());
		indexHingeOnCircleRightHandHalfTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-02-01"), indexHingeOnCircleRightHandHalfTurn.getSymbol());

		indexHingeOnCircleLeftHandHalfTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-01-09"), indexHingeOnCircleLeftHandHalfTurn.getSymbol());
		indexHingeOnCircleLeftHandHalfTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-03-09"), indexHingeOnCircleLeftHandHalfTurn.getSymbol());
		indexHingeOnCircleLeftHandHalfTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-02-09"), indexHingeOnCircleLeftHandHalfTurn.getSymbol());

		indexHingeOnCircleRightHandFullTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-02-01"), indexHingeOnCircleRightHandFullTurn.getSymbol());
		indexHingeOnCircleRightHandFullTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-01-01"), indexHingeOnCircleRightHandFullTurn.getSymbol());
		indexHingeOnCircleRightHandFullTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-03-01"), indexHingeOnCircleRightHandFullTurn.getSymbol());

		indexHingeOnCircleLeftHandFullTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-02-09"), indexHingeOnCircleLeftHandFullTurn.getSymbol());
		indexHingeOnCircleLeftHandFullTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-01-09"), indexHingeOnCircleLeftHandFullTurn.getSymbol());
		indexHingeOnCircleLeftHandFullTurn.roll();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-03-09"), indexHingeOnCircleLeftHandFullTurn.getSymbol());

		indexHingeOnCircleRightHandPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-06-01"), indexHingeOnCircleRightHandPitched.getSymbol());
		indexHingeOnCircleRightHandPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-05-01"), indexHingeOnCircleRightHandPitched.getSymbol());
		indexHingeOnCircleRightHandPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-04-01"), indexHingeOnCircleRightHandPitched.getSymbol());

		indexHingeOnCircleLeftHandPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-06-09"), indexHingeOnCircleLeftHandPitched.getSymbol());
		indexHingeOnCircleLeftHandPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-05-09"), indexHingeOnCircleLeftHandPitched.getSymbol());
		indexHingeOnCircleLeftHandPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-04-09"), indexHingeOnCircleLeftHandPitched.getSymbol());

		indexHingeOnCircleRightHandHalfTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-04-01"),
				indexHingeOnCircleRightHandHalfTurnPitched.getSymbol());
		indexHingeOnCircleRightHandHalfTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-06-01"),
				indexHingeOnCircleRightHandHalfTurnPitched.getSymbol());
		indexHingeOnCircleRightHandHalfTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-05-01"),
				indexHingeOnCircleRightHandHalfTurnPitched.getSymbol());

		indexHingeOnCircleLeftHandHalfTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-04-09"),
				indexHingeOnCircleLeftHandHalfTurnPitched.getSymbol());
		indexHingeOnCircleLeftHandHalfTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-06-09"),
				indexHingeOnCircleLeftHandHalfTurnPitched.getSymbol());
		indexHingeOnCircleLeftHandHalfTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-05-09"),
				indexHingeOnCircleLeftHandHalfTurnPitched.getSymbol());

		indexHingeOnCircleRightHandFullTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-05-01"),
				indexHingeOnCircleRightHandFullTurnPitched.getSymbol());
		indexHingeOnCircleRightHandFullTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-04-01"),
				indexHingeOnCircleRightHandFullTurnPitched.getSymbol());
		indexHingeOnCircleRightHandFullTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-06-01"),
				indexHingeOnCircleRightHandFullTurnPitched.getSymbol());

		indexHingeOnCircleLeftHandFullTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-05-09"),
				indexHingeOnCircleLeftHandFullTurnPitched.getSymbol());
		indexHingeOnCircleLeftHandFullTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-04-09"),
				indexHingeOnCircleLeftHandFullTurnPitched.getSymbol());
		indexHingeOnCircleLeftHandFullTurnPitched.roll();
		assertEquals(symbolFactory.createSymbol("01-01-014-01-06-09"),
				indexHingeOnCircleLeftHandFullTurnPitched.getSymbol());

	}

	@Override
	public void testCanSwitchArrowHead() {

		assertFalse(indexRightHand.canSwitchArrowHead());
		assertFalse(indexLeftHand.canSwitchArrowHead());
		assertFalse(indexRightHandHalfTurn.canSwitchArrowHead());
		assertFalse(indexLeftHandHalfTurn.canSwitchArrowHead());
		assertFalse(indexRightHandFullTurn.canSwitchArrowHead());
		assertFalse(indexLeftHandFullTurn.canSwitchArrowHead());
		assertFalse(indexRightHandPitched.canSwitchArrowHead());
		assertFalse(indexLeftHandPitched.canSwitchArrowHead());
		assertFalse(indexRightHandHalfTurnPitched.canSwitchArrowHead());
		assertFalse(indexLeftHandHalfTurnPitched.canSwitchArrowHead());
		assertFalse(indexRightHandFullTurnPitched.canSwitchArrowHead());
		assertFalse(indexLeftHandFullTurnPitched.canSwitchArrowHead());

		assertFalse(indexOnCircleRightHand.canSwitchArrowHead());
		assertFalse(indexOnCircleLeftHand.canSwitchArrowHead());
		assertFalse(indexOnCircleRightHandHalfTurn.canSwitchArrowHead());
		assertFalse(indexOnCircleLeftHandHalfTurn.canSwitchArrowHead());
		assertFalse(indexOnCircleRightHandFullTurn.canSwitchArrowHead());
		assertFalse(indexOnCircleLeftHandFullTurn.canSwitchArrowHead());
		assertFalse(indexOnCircleRightHandPitched.canSwitchArrowHead());
		assertFalse(indexOnCircleLeftHandPitched.canSwitchArrowHead());
		assertFalse(indexOnCircleRightHandHalfTurnPitched.canSwitchArrowHead());
		assertFalse(indexOnCircleLeftHandHalfTurnPitched.canSwitchArrowHead());
		assertFalse(indexOnCircleRightHandFullTurnPitched.canSwitchArrowHead());
		assertFalse(indexOnCircleLeftHandFullTurnPitched.canSwitchArrowHead());

		assertFalse(indexOnCupRightHand.canSwitchArrowHead());
		assertFalse(indexOnCupLeftHand.canSwitchArrowHead());
		assertFalse(indexOnCupRightHandHalfTurn.canSwitchArrowHead());
		assertFalse(indexOnCupLeftHandHalfTurn.canSwitchArrowHead());
		assertFalse(indexOnCupRightHandFullTurn.canSwitchArrowHead());
		assertFalse(indexOnCupLeftHandFullTurn.canSwitchArrowHead());
		assertFalse(indexOnCupRightHandPitched.canSwitchArrowHead());
		assertFalse(indexOnCupLeftHandPitched.canSwitchArrowHead());
		assertFalse(indexOnCupRightHandHalfTurnPitched.canSwitchArrowHead());
		assertFalse(indexOnCupLeftHandHalfTurnPitched.canSwitchArrowHead());
		assertFalse(indexOnCupRightHandFullTurnPitched.canSwitchArrowHead());
		assertFalse(indexOnCupLeftHandFullTurnPitched.canSwitchArrowHead());

		assertFalse(indexOnOvalRightHand.canSwitchArrowHead());
		assertFalse(indexOnOvalLeftHand.canSwitchArrowHead());
		assertFalse(indexOnOvalRightHandHalfTurn.canSwitchArrowHead());
		assertFalse(indexOnOvalLeftHandHalfTurn.canSwitchArrowHead());
		assertFalse(indexOnOvalRightHandFullTurn.canSwitchArrowHead());
		assertFalse(indexOnOvalLeftHandFullTurn.canSwitchArrowHead());
		assertFalse(indexOnOvalRightHandPitched.canSwitchArrowHead());
		assertFalse(indexOnOvalLeftHandPitched.canSwitchArrowHead());
		assertFalse(indexOnOvalRightHandHalfTurnPitched.canSwitchArrowHead());
		assertFalse(indexOnOvalLeftHandHalfTurnPitched.canSwitchArrowHead());
		assertFalse(indexOnOvalRightHandFullTurnPitched.canSwitchArrowHead());
		assertFalse(indexOnOvalLeftHandFullTurnPitched.canSwitchArrowHead());

		assertFalse(indexOnHingeRightHand.canSwitchArrowHead());
		assertFalse(indexOnHingeLeftHand.canSwitchArrowHead());
		assertFalse(indexOnHingeRightHandHalfTurn.canSwitchArrowHead());
		assertFalse(indexOnHingeLeftHandHalfTurn.canSwitchArrowHead());
		assertFalse(indexOnHingeRightHandFullTurn.canSwitchArrowHead());
		assertFalse(indexOnHingeLeftHandFullTurn.canSwitchArrowHead());
		assertFalse(indexOnHingeRightHandPitched.canSwitchArrowHead());
		assertFalse(indexOnHingeLeftHandPitched.canSwitchArrowHead());
		assertFalse(indexOnHingeRightHandHalfTurnPitched.canSwitchArrowHead());
		assertFalse(indexOnHingeLeftHandHalfTurnPitched.canSwitchArrowHead());
		assertFalse(indexOnHingeRightHandFullTurnPitched.canSwitchArrowHead());
		assertFalse(indexOnHingeLeftHandFullTurnPitched.canSwitchArrowHead());

		assertFalse(indexOnAngleRightHand.canSwitchArrowHead());
		assertFalse(indexOnAngleLeftHand.canSwitchArrowHead());
		assertFalse(indexOnAngleRightHandHalfTurn.canSwitchArrowHead());
		assertFalse(indexOnAngleLeftHandHalfTurn.canSwitchArrowHead());
		assertFalse(indexOnAngleRightHandFullTurn.canSwitchArrowHead());
		assertFalse(indexOnAngleLeftHandFullTurn.canSwitchArrowHead());
		assertFalse(indexOnAngleRightHandPitched.canSwitchArrowHead());
		assertFalse(indexOnAngleLeftHandPitched.canSwitchArrowHead());
		assertFalse(indexOnAngleRightHandHalfTurnPitched.canSwitchArrowHead());
		assertFalse(indexOnAngleLeftHandHalfTurnPitched.canSwitchArrowHead());
		assertFalse(indexOnAngleRightHandFullTurnPitched.canSwitchArrowHead());
		assertFalse(indexOnAngleLeftHandFullTurnPitched.canSwitchArrowHead());

		assertFalse(indexBentRightHand.canSwitchArrowHead());
		assertFalse(indexBentLeftHand.canSwitchArrowHead());
		assertFalse(indexBentRightHandHalfTurn.canSwitchArrowHead());
		assertFalse(indexBentLeftHandHalfTurn.canSwitchArrowHead());
		assertFalse(indexBentRightHandFullTurn.canSwitchArrowHead());
		assertFalse(indexBentLeftHandFullTurn.canSwitchArrowHead());
		assertFalse(indexBentRightHandPitched.canSwitchArrowHead());
		assertFalse(indexBentLeftHandPitched.canSwitchArrowHead());
		assertFalse(indexBentRightHandHalfTurnPitched.canSwitchArrowHead());
		assertFalse(indexBentLeftHandHalfTurnPitched.canSwitchArrowHead());
		assertFalse(indexBentRightHandFullTurnPitched.canSwitchArrowHead());
		assertFalse(indexBentLeftHandFullTurnPitched.canSwitchArrowHead());

		assertFalse(indexBentOnCircleRightHand.canSwitchArrowHead());
		assertFalse(indexBentOnCircleLeftHand.canSwitchArrowHead());
		assertFalse(indexBentOnCircleRightHandHalfTurn.canSwitchArrowHead());
		assertFalse(indexBentOnCircleLeftHandHalfTurn.canSwitchArrowHead());
		assertFalse(indexBentOnCircleRightHandFullTurn.canSwitchArrowHead());
		assertFalse(indexBentOnCircleLeftHandFullTurn.canSwitchArrowHead());
		assertFalse(indexBentOnCircleRightHandPitched.canSwitchArrowHead());
		assertFalse(indexBentOnCircleLeftHandPitched.canSwitchArrowHead());
		assertFalse(indexBentOnCircleRightHandHalfTurnPitched.canSwitchArrowHead());
		assertFalse(indexBentOnCircleLeftHandHalfTurnPitched.canSwitchArrowHead());
		assertFalse(indexBentOnCircleRightHandFullTurnPitched.canSwitchArrowHead());
		assertFalse(indexBentOnCircleLeftHandFullTurnPitched.canSwitchArrowHead());

		assertFalse(indexBentOnFistThumbUnderRightHand.canSwitchArrowHead());
		assertFalse(indexBentOnFistThumbUnderLeftHand.canSwitchArrowHead());
		assertFalse(indexBentOnFistThumbUnderRightHandHalfTurn.canSwitchArrowHead());
		assertFalse(indexBentOnFistThumbUnderLeftHandHalfTurn.canSwitchArrowHead());
		assertFalse(indexBentOnFistThumbUnderRightHandFullTurn.canSwitchArrowHead());
		assertFalse(indexBentOnFistThumbUnderLeftHandFullTurn.canSwitchArrowHead());
		assertFalse(indexBentOnFistThumbUnderRightHandPitched.canSwitchArrowHead());
		assertFalse(indexBentOnFistThumbUnderLeftHandPitched.canSwitchArrowHead());
		assertFalse(indexBentOnFistThumbUnderRightHandHalfTurnPitched.canSwitchArrowHead());
		assertFalse(indexBentOnFistThumbUnderLeftHandHalfTurnPitched.canSwitchArrowHead());
		assertFalse(indexBentOnFistThumbUnderRightHandFullTurnPitched.canSwitchArrowHead());
		assertFalse(indexBentOnFistThumbUnderLeftHandFullTurnPitched.canSwitchArrowHead());

		assertFalse(indexRaisedKnuckleRightHand.canSwitchArrowHead());
		assertFalse(indexRaisedKnuckleLeftHand.canSwitchArrowHead());
		assertFalse(indexRaisedKnuckleRightHandHalfTurn.canSwitchArrowHead());
		assertFalse(indexRaisedKnuckleLeftHandHalfTurn.canSwitchArrowHead());
		assertFalse(indexRaisedKnuckleRightHandFullTurn.canSwitchArrowHead());
		assertFalse(indexRaisedKnuckleLeftHandFullTurn.canSwitchArrowHead());
		assertFalse(indexRaisedKnuckleRightHandPitched.canSwitchArrowHead());
		assertFalse(indexRaisedKnuckleLeftHandPitched.canSwitchArrowHead());
		assertFalse(indexRaisedKnuckleRightHandHalfTurnPitched.canSwitchArrowHead());
		assertFalse(indexRaisedKnuckleLeftHandHalfTurnPitched.canSwitchArrowHead());
		assertFalse(indexRaisedKnuckleRightHandFullTurnPitched.canSwitchArrowHead());
		assertFalse(indexRaisedKnuckleLeftHandFullTurnPitched.canSwitchArrowHead());

		assertFalse(indexCupRightHand.canSwitchArrowHead());
		assertFalse(indexCupLeftHand.canSwitchArrowHead());
		assertFalse(indexCupRightHandHalfTurn.canSwitchArrowHead());
		assertFalse(indexCupLeftHandHalfTurn.canSwitchArrowHead());
		assertFalse(indexCupRightHandFullTurn.canSwitchArrowHead());
		assertFalse(indexCupLeftHandFullTurn.canSwitchArrowHead());
		assertFalse(indexCupRightHandPitched.canSwitchArrowHead());
		assertFalse(indexCupLeftHandPitched.canSwitchArrowHead());
		assertFalse(indexCupRightHandHalfTurnPitched.canSwitchArrowHead());
		assertFalse(indexCupLeftHandHalfTurnPitched.canSwitchArrowHead());
		assertFalse(indexCupRightHandFullTurnPitched.canSwitchArrowHead());
		assertFalse(indexCupLeftHandFullTurnPitched.canSwitchArrowHead());

		assertFalse(indexHingeOnFistRightHand.canSwitchArrowHead());
		assertFalse(indexHingeOnFistLeftHand.canSwitchArrowHead());
		assertFalse(indexHingeOnFistRightHandHalfTurn.canSwitchArrowHead());
		assertFalse(indexHingeOnFistLeftHandHalfTurn.canSwitchArrowHead());
		assertFalse(indexHingeOnFistRightHandFullTurn.canSwitchArrowHead());
		assertFalse(indexHingeOnFistLeftHandFullTurn.canSwitchArrowHead());
		assertFalse(indexHingeOnFistRightHandPitched.canSwitchArrowHead());
		assertFalse(indexHingeOnFistLeftHandPitched.canSwitchArrowHead());
		assertFalse(indexHingeOnFistRightHandHalfTurnPitched.canSwitchArrowHead());
		assertFalse(indexHingeOnFistLeftHandHalfTurnPitched.canSwitchArrowHead());
		assertFalse(indexHingeOnFistRightHandFullTurnPitched.canSwitchArrowHead());
		assertFalse(indexHingeOnFistLeftHandFullTurnPitched.canSwitchArrowHead());

		assertFalse(indexHingeOnFistLowRightHand.canSwitchArrowHead());
		assertFalse(indexHingeOnFistLowLeftHand.canSwitchArrowHead());
		assertFalse(indexHingeOnFistLowRightHandHalfTurn.canSwitchArrowHead());
		assertFalse(indexHingeOnFistLowLeftHandHalfTurn.canSwitchArrowHead());
		assertFalse(indexHingeOnFistLowRightHandFullTurn.canSwitchArrowHead());
		assertFalse(indexHingeOnFistLowLeftHandFullTurn.canSwitchArrowHead());
		assertFalse(indexHingeOnFistLowRightHandPitched.canSwitchArrowHead());
		assertFalse(indexHingeOnFistLowLeftHandPitched.canSwitchArrowHead());
		assertFalse(indexHingeOnFistLowRightHandHalfTurnPitched.canSwitchArrowHead());
		assertFalse(indexHingeOnFistLowLeftHandHalfTurnPitched.canSwitchArrowHead());
		assertFalse(indexHingeOnFistLowRightHandFullTurnPitched.canSwitchArrowHead());
		assertFalse(indexHingeOnFistLowLeftHandFullTurnPitched.canSwitchArrowHead());

		assertFalse(indexHingeOnCircleRightHand.canSwitchArrowHead());
		assertFalse(indexHingeOnCircleLeftHand.canSwitchArrowHead());
		assertFalse(indexHingeOnCircleRightHandHalfTurn.canSwitchArrowHead());
		assertFalse(indexHingeOnCircleLeftHandHalfTurn.canSwitchArrowHead());
		assertFalse(indexHingeOnCircleRightHandFullTurn.canSwitchArrowHead());
		assertFalse(indexHingeOnCircleLeftHandFullTurn.canSwitchArrowHead());
		assertFalse(indexHingeOnCircleRightHandPitched.canSwitchArrowHead());
		assertFalse(indexHingeOnCircleLeftHandPitched.canSwitchArrowHead());
		assertFalse(indexHingeOnCircleRightHandHalfTurnPitched.canSwitchArrowHead());
		assertFalse(indexHingeOnCircleLeftHandHalfTurnPitched.canSwitchArrowHead());
		assertFalse(indexHingeOnCircleRightHandFullTurnPitched.canSwitchArrowHead());
		assertFalse(indexHingeOnCircleLeftHandFullTurnPitched.canSwitchArrowHead());

	}

	@Override
	public void testSwitchArrowHead() {

	}

	@Override
	public void testCanSwitchToNormalArrows() {
		assertFalse(indexRightHand.canSwitchToNormalArrows());
		assertFalse(indexLeftHand.canSwitchToNormalArrows());
		assertFalse(indexRightHandHalfTurn.canSwitchToNormalArrows());
		assertFalse(indexLeftHandHalfTurn.canSwitchToNormalArrows());
		assertFalse(indexRightHandFullTurn.canSwitchToNormalArrows());
		assertFalse(indexLeftHandFullTurn.canSwitchToNormalArrows());
		assertFalse(indexRightHandPitched.canSwitchToNormalArrows());
		assertFalse(indexLeftHandPitched.canSwitchToNormalArrows());
		assertFalse(indexRightHandHalfTurnPitched.canSwitchToNormalArrows());
		assertFalse(indexLeftHandHalfTurnPitched.canSwitchToNormalArrows());
		assertFalse(indexRightHandFullTurnPitched.canSwitchToNormalArrows());
		assertFalse(indexLeftHandFullTurnPitched.canSwitchToNormalArrows());

		assertFalse(indexOnCircleRightHand.canSwitchToNormalArrows());
		assertFalse(indexOnCircleLeftHand.canSwitchToNormalArrows());
		assertFalse(indexOnCircleRightHandHalfTurn.canSwitchToNormalArrows());
		assertFalse(indexOnCircleLeftHandHalfTurn.canSwitchToNormalArrows());
		assertFalse(indexOnCircleRightHandFullTurn.canSwitchToNormalArrows());
		assertFalse(indexOnCircleLeftHandFullTurn.canSwitchToNormalArrows());
		assertFalse(indexOnCircleRightHandPitched.canSwitchToNormalArrows());
		assertFalse(indexOnCircleLeftHandPitched.canSwitchToNormalArrows());
		assertFalse(indexOnCircleRightHandHalfTurnPitched.canSwitchToNormalArrows());
		assertFalse(indexOnCircleLeftHandHalfTurnPitched.canSwitchToNormalArrows());
		assertFalse(indexOnCircleRightHandFullTurnPitched.canSwitchToNormalArrows());
		assertFalse(indexOnCircleLeftHandFullTurnPitched.canSwitchToNormalArrows());

		assertFalse(indexOnCupRightHand.canSwitchToNormalArrows());
		assertFalse(indexOnCupLeftHand.canSwitchToNormalArrows());
		assertFalse(indexOnCupRightHandHalfTurn.canSwitchToNormalArrows());
		assertFalse(indexOnCupLeftHandHalfTurn.canSwitchToNormalArrows());
		assertFalse(indexOnCupRightHandFullTurn.canSwitchToNormalArrows());
		assertFalse(indexOnCupLeftHandFullTurn.canSwitchToNormalArrows());
		assertFalse(indexOnCupRightHandPitched.canSwitchToNormalArrows());
		assertFalse(indexOnCupLeftHandPitched.canSwitchToNormalArrows());
		assertFalse(indexOnCupRightHandHalfTurnPitched.canSwitchToNormalArrows());
		assertFalse(indexOnCupLeftHandHalfTurnPitched.canSwitchToNormalArrows());
		assertFalse(indexOnCupRightHandFullTurnPitched.canSwitchToNormalArrows());
		assertFalse(indexOnCupLeftHandFullTurnPitched.canSwitchToNormalArrows());

		assertFalse(indexOnOvalRightHand.canSwitchToNormalArrows());
		assertFalse(indexOnOvalLeftHand.canSwitchToNormalArrows());
		assertFalse(indexOnOvalRightHandHalfTurn.canSwitchToNormalArrows());
		assertFalse(indexOnOvalLeftHandHalfTurn.canSwitchToNormalArrows());
		assertFalse(indexOnOvalRightHandFullTurn.canSwitchToNormalArrows());
		assertFalse(indexOnOvalLeftHandFullTurn.canSwitchToNormalArrows());
		assertFalse(indexOnOvalRightHandPitched.canSwitchToNormalArrows());
		assertFalse(indexOnOvalLeftHandPitched.canSwitchToNormalArrows());
		assertFalse(indexOnOvalRightHandHalfTurnPitched.canSwitchToNormalArrows());
		assertFalse(indexOnOvalLeftHandHalfTurnPitched.canSwitchToNormalArrows());
		assertFalse(indexOnOvalRightHandFullTurnPitched.canSwitchToNormalArrows());
		assertFalse(indexOnOvalLeftHandFullTurnPitched.canSwitchToNormalArrows());

		assertFalse(indexOnHingeRightHand.canSwitchToNormalArrows());
		assertFalse(indexOnHingeLeftHand.canSwitchToNormalArrows());
		assertFalse(indexOnHingeRightHandHalfTurn.canSwitchToNormalArrows());
		assertFalse(indexOnHingeLeftHandHalfTurn.canSwitchToNormalArrows());
		assertFalse(indexOnHingeRightHandFullTurn.canSwitchToNormalArrows());
		assertFalse(indexOnHingeLeftHandFullTurn.canSwitchToNormalArrows());
		assertFalse(indexOnHingeRightHandPitched.canSwitchToNormalArrows());
		assertFalse(indexOnHingeLeftHandPitched.canSwitchToNormalArrows());
		assertFalse(indexOnHingeRightHandHalfTurnPitched.canSwitchToNormalArrows());
		assertFalse(indexOnHingeLeftHandHalfTurnPitched.canSwitchToNormalArrows());
		assertFalse(indexOnHingeRightHandFullTurnPitched.canSwitchToNormalArrows());
		assertFalse(indexOnHingeLeftHandFullTurnPitched.canSwitchToNormalArrows());

		assertFalse(indexOnAngleRightHand.canSwitchToNormalArrows());
		assertFalse(indexOnAngleLeftHand.canSwitchToNormalArrows());
		assertFalse(indexOnAngleRightHandHalfTurn.canSwitchToNormalArrows());
		assertFalse(indexOnAngleLeftHandHalfTurn.canSwitchToNormalArrows());
		assertFalse(indexOnAngleRightHandFullTurn.canSwitchToNormalArrows());
		assertFalse(indexOnAngleLeftHandFullTurn.canSwitchToNormalArrows());
		assertFalse(indexOnAngleRightHandPitched.canSwitchToNormalArrows());
		assertFalse(indexOnAngleLeftHandPitched.canSwitchToNormalArrows());
		assertFalse(indexOnAngleRightHandHalfTurnPitched.canSwitchToNormalArrows());
		assertFalse(indexOnAngleLeftHandHalfTurnPitched.canSwitchToNormalArrows());
		assertFalse(indexOnAngleRightHandFullTurnPitched.canSwitchToNormalArrows());
		assertFalse(indexOnAngleLeftHandFullTurnPitched.canSwitchToNormalArrows());

		assertFalse(indexBentRightHand.canSwitchToNormalArrows());
		assertFalse(indexBentLeftHand.canSwitchToNormalArrows());
		assertFalse(indexBentRightHandHalfTurn.canSwitchToNormalArrows());
		assertFalse(indexBentLeftHandHalfTurn.canSwitchToNormalArrows());
		assertFalse(indexBentRightHandFullTurn.canSwitchToNormalArrows());
		assertFalse(indexBentLeftHandFullTurn.canSwitchToNormalArrows());
		assertFalse(indexBentRightHandPitched.canSwitchToNormalArrows());
		assertFalse(indexBentLeftHandPitched.canSwitchToNormalArrows());
		assertFalse(indexBentRightHandHalfTurnPitched.canSwitchToNormalArrows());
		assertFalse(indexBentLeftHandHalfTurnPitched.canSwitchToNormalArrows());
		assertFalse(indexBentRightHandFullTurnPitched.canSwitchToNormalArrows());
		assertFalse(indexBentLeftHandFullTurnPitched.canSwitchToNormalArrows());

		assertFalse(indexBentOnCircleRightHand.canSwitchToNormalArrows());
		assertFalse(indexBentOnCircleLeftHand.canSwitchToNormalArrows());
		assertFalse(indexBentOnCircleRightHandHalfTurn.canSwitchToNormalArrows());
		assertFalse(indexBentOnCircleLeftHandHalfTurn.canSwitchToNormalArrows());
		assertFalse(indexBentOnCircleRightHandFullTurn.canSwitchToNormalArrows());
		assertFalse(indexBentOnCircleLeftHandFullTurn.canSwitchToNormalArrows());
		assertFalse(indexBentOnCircleRightHandPitched.canSwitchToNormalArrows());
		assertFalse(indexBentOnCircleLeftHandPitched.canSwitchToNormalArrows());
		assertFalse(indexBentOnCircleRightHandHalfTurnPitched.canSwitchToNormalArrows());
		assertFalse(indexBentOnCircleLeftHandHalfTurnPitched.canSwitchToNormalArrows());
		assertFalse(indexBentOnCircleRightHandFullTurnPitched.canSwitchToNormalArrows());
		assertFalse(indexBentOnCircleLeftHandFullTurnPitched.canSwitchToNormalArrows());

		assertFalse(indexBentOnFistThumbUnderRightHand.canSwitchToNormalArrows());
		assertFalse(indexBentOnFistThumbUnderLeftHand.canSwitchToNormalArrows());
		assertFalse(indexBentOnFistThumbUnderRightHandHalfTurn.canSwitchToNormalArrows());
		assertFalse(indexBentOnFistThumbUnderLeftHandHalfTurn.canSwitchToNormalArrows());
		assertFalse(indexBentOnFistThumbUnderRightHandFullTurn.canSwitchToNormalArrows());
		assertFalse(indexBentOnFistThumbUnderLeftHandFullTurn.canSwitchToNormalArrows());
		assertFalse(indexBentOnFistThumbUnderRightHandPitched.canSwitchToNormalArrows());
		assertFalse(indexBentOnFistThumbUnderLeftHandPitched.canSwitchToNormalArrows());
		assertFalse(indexBentOnFistThumbUnderRightHandHalfTurnPitched.canSwitchToNormalArrows());
		assertFalse(indexBentOnFistThumbUnderLeftHandHalfTurnPitched.canSwitchToNormalArrows());
		assertFalse(indexBentOnFistThumbUnderRightHandFullTurnPitched.canSwitchToNormalArrows());
		assertFalse(indexBentOnFistThumbUnderLeftHandFullTurnPitched.canSwitchToNormalArrows());

		assertFalse(indexRaisedKnuckleRightHand.canSwitchToNormalArrows());
		assertFalse(indexRaisedKnuckleLeftHand.canSwitchToNormalArrows());
		assertFalse(indexRaisedKnuckleRightHandHalfTurn.canSwitchToNormalArrows());
		assertFalse(indexRaisedKnuckleLeftHandHalfTurn.canSwitchToNormalArrows());
		assertFalse(indexRaisedKnuckleRightHandFullTurn.canSwitchToNormalArrows());
		assertFalse(indexRaisedKnuckleLeftHandFullTurn.canSwitchToNormalArrows());
		assertFalse(indexRaisedKnuckleRightHandPitched.canSwitchToNormalArrows());
		assertFalse(indexRaisedKnuckleLeftHandPitched.canSwitchToNormalArrows());
		assertFalse(indexRaisedKnuckleRightHandHalfTurnPitched.canSwitchToNormalArrows());
		assertFalse(indexRaisedKnuckleLeftHandHalfTurnPitched.canSwitchToNormalArrows());
		assertFalse(indexRaisedKnuckleRightHandFullTurnPitched.canSwitchToNormalArrows());
		assertFalse(indexRaisedKnuckleLeftHandFullTurnPitched.canSwitchToNormalArrows());

		assertFalse(indexCupRightHand.canSwitchToNormalArrows());
		assertFalse(indexCupLeftHand.canSwitchToNormalArrows());
		assertFalse(indexCupRightHandHalfTurn.canSwitchToNormalArrows());
		assertFalse(indexCupLeftHandHalfTurn.canSwitchToNormalArrows());
		assertFalse(indexCupRightHandFullTurn.canSwitchToNormalArrows());
		assertFalse(indexCupLeftHandFullTurn.canSwitchToNormalArrows());
		assertFalse(indexCupRightHandPitched.canSwitchToNormalArrows());
		assertFalse(indexCupLeftHandPitched.canSwitchToNormalArrows());
		assertFalse(indexCupRightHandHalfTurnPitched.canSwitchToNormalArrows());
		assertFalse(indexCupLeftHandHalfTurnPitched.canSwitchToNormalArrows());
		assertFalse(indexCupRightHandFullTurnPitched.canSwitchToNormalArrows());
		assertFalse(indexCupLeftHandFullTurnPitched.canSwitchToNormalArrows());

		assertFalse(indexHingeOnFistRightHand.canSwitchToNormalArrows());
		assertFalse(indexHingeOnFistLeftHand.canSwitchToNormalArrows());
		assertFalse(indexHingeOnFistRightHandHalfTurn.canSwitchToNormalArrows());
		assertFalse(indexHingeOnFistLeftHandHalfTurn.canSwitchToNormalArrows());
		assertFalse(indexHingeOnFistRightHandFullTurn.canSwitchToNormalArrows());
		assertFalse(indexHingeOnFistLeftHandFullTurn.canSwitchToNormalArrows());
		assertFalse(indexHingeOnFistRightHandPitched.canSwitchToNormalArrows());
		assertFalse(indexHingeOnFistLeftHandPitched.canSwitchToNormalArrows());
		assertFalse(indexHingeOnFistRightHandHalfTurnPitched.canSwitchToNormalArrows());
		assertFalse(indexHingeOnFistLeftHandHalfTurnPitched.canSwitchToNormalArrows());
		assertFalse(indexHingeOnFistRightHandFullTurnPitched.canSwitchToNormalArrows());
		assertFalse(indexHingeOnFistLeftHandFullTurnPitched.canSwitchToNormalArrows());

		assertFalse(indexHingeOnFistLowRightHand.canSwitchToNormalArrows());
		assertFalse(indexHingeOnFistLowLeftHand.canSwitchToNormalArrows());
		assertFalse(indexHingeOnFistLowRightHandHalfTurn.canSwitchToNormalArrows());
		assertFalse(indexHingeOnFistLowLeftHandHalfTurn.canSwitchToNormalArrows());
		assertFalse(indexHingeOnFistLowRightHandFullTurn.canSwitchToNormalArrows());
		assertFalse(indexHingeOnFistLowLeftHandFullTurn.canSwitchToNormalArrows());
		assertFalse(indexHingeOnFistLowRightHandPitched.canSwitchToNormalArrows());
		assertFalse(indexHingeOnFistLowLeftHandPitched.canSwitchToNormalArrows());
		assertFalse(indexHingeOnFistLowRightHandHalfTurnPitched.canSwitchToNormalArrows());
		assertFalse(indexHingeOnFistLowLeftHandHalfTurnPitched.canSwitchToNormalArrows());
		assertFalse(indexHingeOnFistLowRightHandFullTurnPitched.canSwitchToNormalArrows());
		assertFalse(indexHingeOnFistLowLeftHandFullTurnPitched.canSwitchToNormalArrows());

		assertFalse(indexHingeOnCircleRightHand.canSwitchToNormalArrows());
		assertFalse(indexHingeOnCircleLeftHand.canSwitchToNormalArrows());
		assertFalse(indexHingeOnCircleRightHandHalfTurn.canSwitchToNormalArrows());
		assertFalse(indexHingeOnCircleLeftHandHalfTurn.canSwitchToNormalArrows());
		assertFalse(indexHingeOnCircleRightHandFullTurn.canSwitchToNormalArrows());
		assertFalse(indexHingeOnCircleLeftHandFullTurn.canSwitchToNormalArrows());
		assertFalse(indexHingeOnCircleRightHandPitched.canSwitchToNormalArrows());
		assertFalse(indexHingeOnCircleLeftHandPitched.canSwitchToNormalArrows());
		assertFalse(indexHingeOnCircleRightHandHalfTurnPitched.canSwitchToNormalArrows());
		assertFalse(indexHingeOnCircleLeftHandHalfTurnPitched.canSwitchToNormalArrows());
		assertFalse(indexHingeOnCircleRightHandFullTurnPitched.canSwitchToNormalArrows());
		assertFalse(indexHingeOnCircleLeftHandFullTurnPitched.canSwitchToNormalArrows());

	}

	@Override
	public void testSwitchToNormalArrows() {

	}

	@Override
	public void testCanSwitchToAlternatingArrows() {

		assertFalse(indexRightHand.canSwitchToAlternatingArrows());
		assertFalse(indexLeftHand.canSwitchToAlternatingArrows());
		assertFalse(indexRightHandHalfTurn.canSwitchToAlternatingArrows());
		assertFalse(indexLeftHandHalfTurn.canSwitchToAlternatingArrows());
		assertFalse(indexRightHandFullTurn.canSwitchToAlternatingArrows());
		assertFalse(indexLeftHandFullTurn.canSwitchToAlternatingArrows());
		assertFalse(indexRightHandPitched.canSwitchToAlternatingArrows());
		assertFalse(indexLeftHandPitched.canSwitchToAlternatingArrows());
		assertFalse(indexRightHandHalfTurnPitched.canSwitchToAlternatingArrows());
		assertFalse(indexLeftHandHalfTurnPitched.canSwitchToAlternatingArrows());
		assertFalse(indexRightHandFullTurnPitched.canSwitchToAlternatingArrows());
		assertFalse(indexLeftHandFullTurnPitched.canSwitchToAlternatingArrows());

		assertFalse(indexOnCircleRightHand.canSwitchToAlternatingArrows());
		assertFalse(indexOnCircleLeftHand.canSwitchToAlternatingArrows());
		assertFalse(indexOnCircleRightHandHalfTurn.canSwitchToAlternatingArrows());
		assertFalse(indexOnCircleLeftHandHalfTurn.canSwitchToAlternatingArrows());
		assertFalse(indexOnCircleRightHandFullTurn.canSwitchToAlternatingArrows());
		assertFalse(indexOnCircleLeftHandFullTurn.canSwitchToAlternatingArrows());
		assertFalse(indexOnCircleRightHandPitched.canSwitchToAlternatingArrows());
		assertFalse(indexOnCircleLeftHandPitched.canSwitchToAlternatingArrows());
		assertFalse(indexOnCircleRightHandHalfTurnPitched.canSwitchToAlternatingArrows());
		assertFalse(indexOnCircleLeftHandHalfTurnPitched.canSwitchToAlternatingArrows());
		assertFalse(indexOnCircleRightHandFullTurnPitched.canSwitchToAlternatingArrows());
		assertFalse(indexOnCircleLeftHandFullTurnPitched.canSwitchToAlternatingArrows());

		assertFalse(indexOnCupRightHand.canSwitchToAlternatingArrows());
		assertFalse(indexOnCupLeftHand.canSwitchToAlternatingArrows());
		assertFalse(indexOnCupRightHandHalfTurn.canSwitchToAlternatingArrows());
		assertFalse(indexOnCupLeftHandHalfTurn.canSwitchToAlternatingArrows());
		assertFalse(indexOnCupRightHandFullTurn.canSwitchToAlternatingArrows());
		assertFalse(indexOnCupLeftHandFullTurn.canSwitchToAlternatingArrows());
		assertFalse(indexOnCupRightHandPitched.canSwitchToAlternatingArrows());
		assertFalse(indexOnCupLeftHandPitched.canSwitchToAlternatingArrows());
		assertFalse(indexOnCupRightHandHalfTurnPitched.canSwitchToAlternatingArrows());
		assertFalse(indexOnCupLeftHandHalfTurnPitched.canSwitchToAlternatingArrows());
		assertFalse(indexOnCupRightHandFullTurnPitched.canSwitchToAlternatingArrows());
		assertFalse(indexOnCupLeftHandFullTurnPitched.canSwitchToAlternatingArrows());

		assertFalse(indexOnOvalRightHand.canSwitchToAlternatingArrows());
		assertFalse(indexOnOvalLeftHand.canSwitchToAlternatingArrows());
		assertFalse(indexOnOvalRightHandHalfTurn.canSwitchToAlternatingArrows());
		assertFalse(indexOnOvalLeftHandHalfTurn.canSwitchToAlternatingArrows());
		assertFalse(indexOnOvalRightHandFullTurn.canSwitchToAlternatingArrows());
		assertFalse(indexOnOvalLeftHandFullTurn.canSwitchToAlternatingArrows());
		assertFalse(indexOnOvalRightHandPitched.canSwitchToAlternatingArrows());
		assertFalse(indexOnOvalLeftHandPitched.canSwitchToAlternatingArrows());
		assertFalse(indexOnOvalRightHandHalfTurnPitched.canSwitchToAlternatingArrows());
		assertFalse(indexOnOvalLeftHandHalfTurnPitched.canSwitchToAlternatingArrows());
		assertFalse(indexOnOvalRightHandFullTurnPitched.canSwitchToAlternatingArrows());
		assertFalse(indexOnOvalLeftHandFullTurnPitched.canSwitchToAlternatingArrows());

		assertFalse(indexOnHingeRightHand.canSwitchToAlternatingArrows());
		assertFalse(indexOnHingeLeftHand.canSwitchToAlternatingArrows());
		assertFalse(indexOnHingeRightHandHalfTurn.canSwitchToAlternatingArrows());
		assertFalse(indexOnHingeLeftHandHalfTurn.canSwitchToAlternatingArrows());
		assertFalse(indexOnHingeRightHandFullTurn.canSwitchToAlternatingArrows());
		assertFalse(indexOnHingeLeftHandFullTurn.canSwitchToAlternatingArrows());
		assertFalse(indexOnHingeRightHandPitched.canSwitchToAlternatingArrows());
		assertFalse(indexOnHingeLeftHandPitched.canSwitchToAlternatingArrows());
		assertFalse(indexOnHingeRightHandHalfTurnPitched.canSwitchToAlternatingArrows());
		assertFalse(indexOnHingeLeftHandHalfTurnPitched.canSwitchToAlternatingArrows());
		assertFalse(indexOnHingeRightHandFullTurnPitched.canSwitchToAlternatingArrows());
		assertFalse(indexOnHingeLeftHandFullTurnPitched.canSwitchToAlternatingArrows());

		assertFalse(indexOnAngleRightHand.canSwitchToAlternatingArrows());
		assertFalse(indexOnAngleLeftHand.canSwitchToAlternatingArrows());
		assertFalse(indexOnAngleRightHandHalfTurn.canSwitchToAlternatingArrows());
		assertFalse(indexOnAngleLeftHandHalfTurn.canSwitchToAlternatingArrows());
		assertFalse(indexOnAngleRightHandFullTurn.canSwitchToAlternatingArrows());
		assertFalse(indexOnAngleLeftHandFullTurn.canSwitchToAlternatingArrows());
		assertFalse(indexOnAngleRightHandPitched.canSwitchToAlternatingArrows());
		assertFalse(indexOnAngleLeftHandPitched.canSwitchToAlternatingArrows());
		assertFalse(indexOnAngleRightHandHalfTurnPitched.canSwitchToAlternatingArrows());
		assertFalse(indexOnAngleLeftHandHalfTurnPitched.canSwitchToAlternatingArrows());
		assertFalse(indexOnAngleRightHandFullTurnPitched.canSwitchToAlternatingArrows());
		assertFalse(indexOnAngleLeftHandFullTurnPitched.canSwitchToAlternatingArrows());

		assertFalse(indexBentRightHand.canSwitchToAlternatingArrows());
		assertFalse(indexBentLeftHand.canSwitchToAlternatingArrows());
		assertFalse(indexBentRightHandHalfTurn.canSwitchToAlternatingArrows());
		assertFalse(indexBentLeftHandHalfTurn.canSwitchToAlternatingArrows());
		assertFalse(indexBentRightHandFullTurn.canSwitchToAlternatingArrows());
		assertFalse(indexBentLeftHandFullTurn.canSwitchToAlternatingArrows());
		assertFalse(indexBentRightHandPitched.canSwitchToAlternatingArrows());
		assertFalse(indexBentLeftHandPitched.canSwitchToAlternatingArrows());
		assertFalse(indexBentRightHandHalfTurnPitched.canSwitchToAlternatingArrows());
		assertFalse(indexBentLeftHandHalfTurnPitched.canSwitchToAlternatingArrows());
		assertFalse(indexBentRightHandFullTurnPitched.canSwitchToAlternatingArrows());
		assertFalse(indexBentLeftHandFullTurnPitched.canSwitchToAlternatingArrows());

		assertFalse(indexBentOnCircleRightHand.canSwitchToAlternatingArrows());
		assertFalse(indexBentOnCircleLeftHand.canSwitchToAlternatingArrows());
		assertFalse(indexBentOnCircleRightHandHalfTurn.canSwitchToAlternatingArrows());
		assertFalse(indexBentOnCircleLeftHandHalfTurn.canSwitchToAlternatingArrows());
		assertFalse(indexBentOnCircleRightHandFullTurn.canSwitchToAlternatingArrows());
		assertFalse(indexBentOnCircleLeftHandFullTurn.canSwitchToAlternatingArrows());
		assertFalse(indexBentOnCircleRightHandPitched.canSwitchToAlternatingArrows());
		assertFalse(indexBentOnCircleLeftHandPitched.canSwitchToAlternatingArrows());
		assertFalse(indexBentOnCircleRightHandHalfTurnPitched.canSwitchToAlternatingArrows());
		assertFalse(indexBentOnCircleLeftHandHalfTurnPitched.canSwitchToAlternatingArrows());
		assertFalse(indexBentOnCircleRightHandFullTurnPitched.canSwitchToAlternatingArrows());
		assertFalse(indexBentOnCircleLeftHandFullTurnPitched.canSwitchToAlternatingArrows());

		assertFalse(indexBentOnFistThumbUnderRightHand.canSwitchToAlternatingArrows());
		assertFalse(indexBentOnFistThumbUnderLeftHand.canSwitchToAlternatingArrows());
		assertFalse(indexBentOnFistThumbUnderRightHandHalfTurn.canSwitchToAlternatingArrows());
		assertFalse(indexBentOnFistThumbUnderLeftHandHalfTurn.canSwitchToAlternatingArrows());
		assertFalse(indexBentOnFistThumbUnderRightHandFullTurn.canSwitchToAlternatingArrows());
		assertFalse(indexBentOnFistThumbUnderLeftHandFullTurn.canSwitchToAlternatingArrows());
		assertFalse(indexBentOnFistThumbUnderRightHandPitched.canSwitchToAlternatingArrows());
		assertFalse(indexBentOnFistThumbUnderLeftHandPitched.canSwitchToAlternatingArrows());
		assertFalse(indexBentOnFistThumbUnderRightHandHalfTurnPitched.canSwitchToAlternatingArrows());
		assertFalse(indexBentOnFistThumbUnderLeftHandHalfTurnPitched.canSwitchToAlternatingArrows());
		assertFalse(indexBentOnFistThumbUnderRightHandFullTurnPitched.canSwitchToAlternatingArrows());
		assertFalse(indexBentOnFistThumbUnderLeftHandFullTurnPitched.canSwitchToAlternatingArrows());

		assertFalse(indexRaisedKnuckleRightHand.canSwitchToAlternatingArrows());
		assertFalse(indexRaisedKnuckleLeftHand.canSwitchToAlternatingArrows());
		assertFalse(indexRaisedKnuckleRightHandHalfTurn.canSwitchToAlternatingArrows());
		assertFalse(indexRaisedKnuckleLeftHandHalfTurn.canSwitchToAlternatingArrows());
		assertFalse(indexRaisedKnuckleRightHandFullTurn.canSwitchToAlternatingArrows());
		assertFalse(indexRaisedKnuckleLeftHandFullTurn.canSwitchToAlternatingArrows());
		assertFalse(indexRaisedKnuckleRightHandPitched.canSwitchToAlternatingArrows());
		assertFalse(indexRaisedKnuckleLeftHandPitched.canSwitchToAlternatingArrows());
		assertFalse(indexRaisedKnuckleRightHandHalfTurnPitched.canSwitchToAlternatingArrows());
		assertFalse(indexRaisedKnuckleLeftHandHalfTurnPitched.canSwitchToAlternatingArrows());
		assertFalse(indexRaisedKnuckleRightHandFullTurnPitched.canSwitchToAlternatingArrows());
		assertFalse(indexRaisedKnuckleLeftHandFullTurnPitched.canSwitchToAlternatingArrows());

		assertFalse(indexCupRightHand.canSwitchToAlternatingArrows());
		assertFalse(indexCupLeftHand.canSwitchToAlternatingArrows());
		assertFalse(indexCupRightHandHalfTurn.canSwitchToAlternatingArrows());
		assertFalse(indexCupLeftHandHalfTurn.canSwitchToAlternatingArrows());
		assertFalse(indexCupRightHandFullTurn.canSwitchToAlternatingArrows());
		assertFalse(indexCupLeftHandFullTurn.canSwitchToAlternatingArrows());
		assertFalse(indexCupRightHandPitched.canSwitchToAlternatingArrows());
		assertFalse(indexCupLeftHandPitched.canSwitchToAlternatingArrows());
		assertFalse(indexCupRightHandHalfTurnPitched.canSwitchToAlternatingArrows());
		assertFalse(indexCupLeftHandHalfTurnPitched.canSwitchToAlternatingArrows());
		assertFalse(indexCupRightHandFullTurnPitched.canSwitchToAlternatingArrows());
		assertFalse(indexCupLeftHandFullTurnPitched.canSwitchToAlternatingArrows());

		assertFalse(indexHingeOnFistRightHand.canSwitchToAlternatingArrows());
		assertFalse(indexHingeOnFistLeftHand.canSwitchToAlternatingArrows());
		assertFalse(indexHingeOnFistRightHandHalfTurn.canSwitchToAlternatingArrows());
		assertFalse(indexHingeOnFistLeftHandHalfTurn.canSwitchToAlternatingArrows());
		assertFalse(indexHingeOnFistRightHandFullTurn.canSwitchToAlternatingArrows());
		assertFalse(indexHingeOnFistLeftHandFullTurn.canSwitchToAlternatingArrows());
		assertFalse(indexHingeOnFistRightHandPitched.canSwitchToAlternatingArrows());
		assertFalse(indexHingeOnFistLeftHandPitched.canSwitchToAlternatingArrows());
		assertFalse(indexHingeOnFistRightHandHalfTurnPitched.canSwitchToAlternatingArrows());
		assertFalse(indexHingeOnFistLeftHandHalfTurnPitched.canSwitchToAlternatingArrows());
		assertFalse(indexHingeOnFistRightHandFullTurnPitched.canSwitchToAlternatingArrows());
		assertFalse(indexHingeOnFistLeftHandFullTurnPitched.canSwitchToAlternatingArrows());

		assertFalse(indexHingeOnFistLowRightHand.canSwitchToAlternatingArrows());
		assertFalse(indexHingeOnFistLowLeftHand.canSwitchToAlternatingArrows());
		assertFalse(indexHingeOnFistLowRightHandHalfTurn.canSwitchToAlternatingArrows());
		assertFalse(indexHingeOnFistLowLeftHandHalfTurn.canSwitchToAlternatingArrows());
		assertFalse(indexHingeOnFistLowRightHandFullTurn.canSwitchToAlternatingArrows());
		assertFalse(indexHingeOnFistLowLeftHandFullTurn.canSwitchToAlternatingArrows());
		assertFalse(indexHingeOnFistLowRightHandPitched.canSwitchToAlternatingArrows());
		assertFalse(indexHingeOnFistLowLeftHandPitched.canSwitchToAlternatingArrows());
		assertFalse(indexHingeOnFistLowRightHandHalfTurnPitched.canSwitchToAlternatingArrows());
		assertFalse(indexHingeOnFistLowLeftHandHalfTurnPitched.canSwitchToAlternatingArrows());
		assertFalse(indexHingeOnFistLowRightHandFullTurnPitched.canSwitchToAlternatingArrows());
		assertFalse(indexHingeOnFistLowLeftHandFullTurnPitched.canSwitchToAlternatingArrows());

		assertFalse(indexHingeOnCircleRightHand.canSwitchToAlternatingArrows());
		assertFalse(indexHingeOnCircleLeftHand.canSwitchToAlternatingArrows());
		assertFalse(indexHingeOnCircleRightHandHalfTurn.canSwitchToAlternatingArrows());
		assertFalse(indexHingeOnCircleLeftHandHalfTurn.canSwitchToAlternatingArrows());
		assertFalse(indexHingeOnCircleRightHandFullTurn.canSwitchToAlternatingArrows());
		assertFalse(indexHingeOnCircleLeftHandFullTurn.canSwitchToAlternatingArrows());
		assertFalse(indexHingeOnCircleRightHandPitched.canSwitchToAlternatingArrows());
		assertFalse(indexHingeOnCircleLeftHandPitched.canSwitchToAlternatingArrows());
		assertFalse(indexHingeOnCircleRightHandHalfTurnPitched.canSwitchToAlternatingArrows());
		assertFalse(indexHingeOnCircleLeftHandHalfTurnPitched.canSwitchToAlternatingArrows());
		assertFalse(indexHingeOnCircleRightHandFullTurnPitched.canSwitchToAlternatingArrows());
		assertFalse(indexHingeOnCircleLeftHandFullTurnPitched.canSwitchToAlternatingArrows());

	}

	@Override
	public void testSwitchToAlternatingArrows() {

	}

	@Override
	public void testCanSwitchStartingPoint() {

		assertFalse(indexRightHand.canSwitchStartingPoint());
		assertFalse(indexLeftHand.canSwitchStartingPoint());
		assertFalse(indexRightHandHalfTurn.canSwitchStartingPoint());
		assertFalse(indexLeftHandHalfTurn.canSwitchStartingPoint());
		assertFalse(indexRightHandFullTurn.canSwitchStartingPoint());
		assertFalse(indexLeftHandFullTurn.canSwitchStartingPoint());
		assertFalse(indexRightHandPitched.canSwitchStartingPoint());
		assertFalse(indexLeftHandPitched.canSwitchStartingPoint());
		assertFalse(indexRightHandHalfTurnPitched.canSwitchStartingPoint());
		assertFalse(indexLeftHandHalfTurnPitched.canSwitchStartingPoint());
		assertFalse(indexRightHandFullTurnPitched.canSwitchStartingPoint());
		assertFalse(indexLeftHandFullTurnPitched.canSwitchStartingPoint());

		assertFalse(indexOnCircleRightHand.canSwitchStartingPoint());
		assertFalse(indexOnCircleLeftHand.canSwitchStartingPoint());
		assertFalse(indexOnCircleRightHandHalfTurn.canSwitchStartingPoint());
		assertFalse(indexOnCircleLeftHandHalfTurn.canSwitchStartingPoint());
		assertFalse(indexOnCircleRightHandFullTurn.canSwitchStartingPoint());
		assertFalse(indexOnCircleLeftHandFullTurn.canSwitchStartingPoint());
		assertFalse(indexOnCircleRightHandPitched.canSwitchStartingPoint());
		assertFalse(indexOnCircleLeftHandPitched.canSwitchStartingPoint());
		assertFalse(indexOnCircleRightHandHalfTurnPitched.canSwitchStartingPoint());
		assertFalse(indexOnCircleLeftHandHalfTurnPitched.canSwitchStartingPoint());
		assertFalse(indexOnCircleRightHandFullTurnPitched.canSwitchStartingPoint());
		assertFalse(indexOnCircleLeftHandFullTurnPitched.canSwitchStartingPoint());

		assertFalse(indexOnCupRightHand.canSwitchStartingPoint());
		assertFalse(indexOnCupLeftHand.canSwitchStartingPoint());
		assertFalse(indexOnCupRightHandHalfTurn.canSwitchStartingPoint());
		assertFalse(indexOnCupLeftHandHalfTurn.canSwitchStartingPoint());
		assertFalse(indexOnCupRightHandFullTurn.canSwitchStartingPoint());
		assertFalse(indexOnCupLeftHandFullTurn.canSwitchStartingPoint());
		assertFalse(indexOnCupRightHandPitched.canSwitchStartingPoint());
		assertFalse(indexOnCupLeftHandPitched.canSwitchStartingPoint());
		assertFalse(indexOnCupRightHandHalfTurnPitched.canSwitchStartingPoint());
		assertFalse(indexOnCupLeftHandHalfTurnPitched.canSwitchStartingPoint());
		assertFalse(indexOnCupRightHandFullTurnPitched.canSwitchStartingPoint());
		assertFalse(indexOnCupLeftHandFullTurnPitched.canSwitchStartingPoint());

		assertFalse(indexOnOvalRightHand.canSwitchStartingPoint());
		assertFalse(indexOnOvalLeftHand.canSwitchStartingPoint());
		assertFalse(indexOnOvalRightHandHalfTurn.canSwitchStartingPoint());
		assertFalse(indexOnOvalLeftHandHalfTurn.canSwitchStartingPoint());
		assertFalse(indexOnOvalRightHandFullTurn.canSwitchStartingPoint());
		assertFalse(indexOnOvalLeftHandFullTurn.canSwitchStartingPoint());
		assertFalse(indexOnOvalRightHandPitched.canSwitchStartingPoint());
		assertFalse(indexOnOvalLeftHandPitched.canSwitchStartingPoint());
		assertFalse(indexOnOvalRightHandHalfTurnPitched.canSwitchStartingPoint());
		assertFalse(indexOnOvalLeftHandHalfTurnPitched.canSwitchStartingPoint());
		assertFalse(indexOnOvalRightHandFullTurnPitched.canSwitchStartingPoint());
		assertFalse(indexOnOvalLeftHandFullTurnPitched.canSwitchStartingPoint());

		assertFalse(indexOnHingeRightHand.canSwitchStartingPoint());
		assertFalse(indexOnHingeLeftHand.canSwitchStartingPoint());
		assertFalse(indexOnHingeRightHandHalfTurn.canSwitchStartingPoint());
		assertFalse(indexOnHingeLeftHandHalfTurn.canSwitchStartingPoint());
		assertFalse(indexOnHingeRightHandFullTurn.canSwitchStartingPoint());
		assertFalse(indexOnHingeLeftHandFullTurn.canSwitchStartingPoint());
		assertFalse(indexOnHingeRightHandPitched.canSwitchStartingPoint());
		assertFalse(indexOnHingeLeftHandPitched.canSwitchStartingPoint());
		assertFalse(indexOnHingeRightHandHalfTurnPitched.canSwitchStartingPoint());
		assertFalse(indexOnHingeLeftHandHalfTurnPitched.canSwitchStartingPoint());
		assertFalse(indexOnHingeRightHandFullTurnPitched.canSwitchStartingPoint());
		assertFalse(indexOnHingeLeftHandFullTurnPitched.canSwitchStartingPoint());

		assertFalse(indexOnAngleRightHand.canSwitchStartingPoint());
		assertFalse(indexOnAngleLeftHand.canSwitchStartingPoint());
		assertFalse(indexOnAngleRightHandHalfTurn.canSwitchStartingPoint());
		assertFalse(indexOnAngleLeftHandHalfTurn.canSwitchStartingPoint());
		assertFalse(indexOnAngleRightHandFullTurn.canSwitchStartingPoint());
		assertFalse(indexOnAngleLeftHandFullTurn.canSwitchStartingPoint());
		assertFalse(indexOnAngleRightHandPitched.canSwitchStartingPoint());
		assertFalse(indexOnAngleLeftHandPitched.canSwitchStartingPoint());
		assertFalse(indexOnAngleRightHandHalfTurnPitched.canSwitchStartingPoint());
		assertFalse(indexOnAngleLeftHandHalfTurnPitched.canSwitchStartingPoint());
		assertFalse(indexOnAngleRightHandFullTurnPitched.canSwitchStartingPoint());
		assertFalse(indexOnAngleLeftHandFullTurnPitched.canSwitchStartingPoint());

		assertFalse(indexBentRightHand.canSwitchStartingPoint());
		assertFalse(indexBentLeftHand.canSwitchStartingPoint());
		assertFalse(indexBentRightHandHalfTurn.canSwitchStartingPoint());
		assertFalse(indexBentLeftHandHalfTurn.canSwitchStartingPoint());
		assertFalse(indexBentRightHandFullTurn.canSwitchStartingPoint());
		assertFalse(indexBentLeftHandFullTurn.canSwitchStartingPoint());
		assertFalse(indexBentRightHandPitched.canSwitchStartingPoint());
		assertFalse(indexBentLeftHandPitched.canSwitchStartingPoint());
		assertFalse(indexBentRightHandHalfTurnPitched.canSwitchStartingPoint());
		assertFalse(indexBentLeftHandHalfTurnPitched.canSwitchStartingPoint());
		assertFalse(indexBentRightHandFullTurnPitched.canSwitchStartingPoint());
		assertFalse(indexBentLeftHandFullTurnPitched.canSwitchStartingPoint());

		assertFalse(indexBentOnCircleRightHand.canSwitchStartingPoint());
		assertFalse(indexBentOnCircleLeftHand.canSwitchStartingPoint());
		assertFalse(indexBentOnCircleRightHandHalfTurn.canSwitchStartingPoint());
		assertFalse(indexBentOnCircleLeftHandHalfTurn.canSwitchStartingPoint());
		assertFalse(indexBentOnCircleRightHandFullTurn.canSwitchStartingPoint());
		assertFalse(indexBentOnCircleLeftHandFullTurn.canSwitchStartingPoint());
		assertFalse(indexBentOnCircleRightHandPitched.canSwitchStartingPoint());
		assertFalse(indexBentOnCircleLeftHandPitched.canSwitchStartingPoint());
		assertFalse(indexBentOnCircleRightHandHalfTurnPitched.canSwitchStartingPoint());
		assertFalse(indexBentOnCircleLeftHandHalfTurnPitched.canSwitchStartingPoint());
		assertFalse(indexBentOnCircleRightHandFullTurnPitched.canSwitchStartingPoint());
		assertFalse(indexBentOnCircleLeftHandFullTurnPitched.canSwitchStartingPoint());

		assertFalse(indexBentOnFistThumbUnderRightHand.canSwitchStartingPoint());
		assertFalse(indexBentOnFistThumbUnderLeftHand.canSwitchStartingPoint());
		assertFalse(indexBentOnFistThumbUnderRightHandHalfTurn.canSwitchStartingPoint());
		assertFalse(indexBentOnFistThumbUnderLeftHandHalfTurn.canSwitchStartingPoint());
		assertFalse(indexBentOnFistThumbUnderRightHandFullTurn.canSwitchStartingPoint());
		assertFalse(indexBentOnFistThumbUnderLeftHandFullTurn.canSwitchStartingPoint());
		assertFalse(indexBentOnFistThumbUnderRightHandPitched.canSwitchStartingPoint());
		assertFalse(indexBentOnFistThumbUnderLeftHandPitched.canSwitchStartingPoint());
		assertFalse(indexBentOnFistThumbUnderRightHandHalfTurnPitched.canSwitchStartingPoint());
		assertFalse(indexBentOnFistThumbUnderLeftHandHalfTurnPitched.canSwitchStartingPoint());
		assertFalse(indexBentOnFistThumbUnderRightHandFullTurnPitched.canSwitchStartingPoint());
		assertFalse(indexBentOnFistThumbUnderLeftHandFullTurnPitched.canSwitchStartingPoint());

		assertFalse(indexRaisedKnuckleRightHand.canSwitchStartingPoint());
		assertFalse(indexRaisedKnuckleLeftHand.canSwitchStartingPoint());
		assertFalse(indexRaisedKnuckleRightHandHalfTurn.canSwitchStartingPoint());
		assertFalse(indexRaisedKnuckleLeftHandHalfTurn.canSwitchStartingPoint());
		assertFalse(indexRaisedKnuckleRightHandFullTurn.canSwitchStartingPoint());
		assertFalse(indexRaisedKnuckleLeftHandFullTurn.canSwitchStartingPoint());
		assertFalse(indexRaisedKnuckleRightHandPitched.canSwitchStartingPoint());
		assertFalse(indexRaisedKnuckleLeftHandPitched.canSwitchStartingPoint());
		assertFalse(indexRaisedKnuckleRightHandHalfTurnPitched.canSwitchStartingPoint());
		assertFalse(indexRaisedKnuckleLeftHandHalfTurnPitched.canSwitchStartingPoint());
		assertFalse(indexRaisedKnuckleRightHandFullTurnPitched.canSwitchStartingPoint());
		assertFalse(indexRaisedKnuckleLeftHandFullTurnPitched.canSwitchStartingPoint());

		assertFalse(indexCupRightHand.canSwitchStartingPoint());
		assertFalse(indexCupLeftHand.canSwitchStartingPoint());
		assertFalse(indexCupRightHandHalfTurn.canSwitchStartingPoint());
		assertFalse(indexCupLeftHandHalfTurn.canSwitchStartingPoint());
		assertFalse(indexCupRightHandFullTurn.canSwitchStartingPoint());
		assertFalse(indexCupLeftHandFullTurn.canSwitchStartingPoint());
		assertFalse(indexCupRightHandPitched.canSwitchStartingPoint());
		assertFalse(indexCupLeftHandPitched.canSwitchStartingPoint());
		assertFalse(indexCupRightHandHalfTurnPitched.canSwitchStartingPoint());
		assertFalse(indexCupLeftHandHalfTurnPitched.canSwitchStartingPoint());
		assertFalse(indexCupRightHandFullTurnPitched.canSwitchStartingPoint());
		assertFalse(indexCupLeftHandFullTurnPitched.canSwitchStartingPoint());

		assertFalse(indexHingeOnFistRightHand.canSwitchStartingPoint());
		assertFalse(indexHingeOnFistLeftHand.canSwitchStartingPoint());
		assertFalse(indexHingeOnFistRightHandHalfTurn.canSwitchStartingPoint());
		assertFalse(indexHingeOnFistLeftHandHalfTurn.canSwitchStartingPoint());
		assertFalse(indexHingeOnFistRightHandFullTurn.canSwitchStartingPoint());
		assertFalse(indexHingeOnFistLeftHandFullTurn.canSwitchStartingPoint());
		assertFalse(indexHingeOnFistRightHandPitched.canSwitchStartingPoint());
		assertFalse(indexHingeOnFistLeftHandPitched.canSwitchStartingPoint());
		assertFalse(indexHingeOnFistRightHandHalfTurnPitched.canSwitchStartingPoint());
		assertFalse(indexHingeOnFistLeftHandHalfTurnPitched.canSwitchStartingPoint());
		assertFalse(indexHingeOnFistRightHandFullTurnPitched.canSwitchStartingPoint());
		assertFalse(indexHingeOnFistLeftHandFullTurnPitched.canSwitchStartingPoint());

		assertFalse(indexHingeOnFistLowRightHand.canSwitchStartingPoint());
		assertFalse(indexHingeOnFistLowLeftHand.canSwitchStartingPoint());
		assertFalse(indexHingeOnFistLowRightHandHalfTurn.canSwitchStartingPoint());
		assertFalse(indexHingeOnFistLowLeftHandHalfTurn.canSwitchStartingPoint());
		assertFalse(indexHingeOnFistLowRightHandFullTurn.canSwitchStartingPoint());
		assertFalse(indexHingeOnFistLowLeftHandFullTurn.canSwitchStartingPoint());
		assertFalse(indexHingeOnFistLowRightHandPitched.canSwitchStartingPoint());
		assertFalse(indexHingeOnFistLowLeftHandPitched.canSwitchStartingPoint());
		assertFalse(indexHingeOnFistLowRightHandHalfTurnPitched.canSwitchStartingPoint());
		assertFalse(indexHingeOnFistLowLeftHandHalfTurnPitched.canSwitchStartingPoint());
		assertFalse(indexHingeOnFistLowRightHandFullTurnPitched.canSwitchStartingPoint());
		assertFalse(indexHingeOnFistLowLeftHandFullTurnPitched.canSwitchStartingPoint());

		assertFalse(indexHingeOnCircleRightHand.canSwitchStartingPoint());
		assertFalse(indexHingeOnCircleLeftHand.canSwitchStartingPoint());
		assertFalse(indexHingeOnCircleRightHandHalfTurn.canSwitchStartingPoint());
		assertFalse(indexHingeOnCircleLeftHandHalfTurn.canSwitchStartingPoint());
		assertFalse(indexHingeOnCircleRightHandFullTurn.canSwitchStartingPoint());
		assertFalse(indexHingeOnCircleLeftHandFullTurn.canSwitchStartingPoint());
		assertFalse(indexHingeOnCircleRightHandPitched.canSwitchStartingPoint());
		assertFalse(indexHingeOnCircleLeftHandPitched.canSwitchStartingPoint());
		assertFalse(indexHingeOnCircleRightHandHalfTurnPitched.canSwitchStartingPoint());
		assertFalse(indexHingeOnCircleLeftHandHalfTurnPitched.canSwitchStartingPoint());
		assertFalse(indexHingeOnCircleRightHandFullTurnPitched.canSwitchStartingPoint());
		assertFalse(indexHingeOnCircleLeftHandFullTurnPitched.canSwitchStartingPoint());

	}

	@Override
	public void testSwitchStartingPoint() {

	}

}
