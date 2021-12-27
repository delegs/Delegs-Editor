package de.signWritingEditor.shared.model.material;

import java.util.ArrayList;
import java.util.List;

import de.signWritingEditor.shared.model.domainValue.JawBaseSymbol;
import de.signWritingEditor.shared.model.material.Locatable.Location;

public class PositionedJawSymbolSet extends PositionedSymbol {

	private static final int DISTANCE_TOLERANCE = 1;
	private PositionedSymbol leftSymbol;
	private PositionedSymbol centerSymbol;
	private PositionedSymbol rightSymbol;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Deprecated
	public PositionedJawSymbolSet() {
		super();
		leftSymbol = null;
		centerSymbol = null;
		rightSymbol = null;
	}

	public PositionedJawSymbolSet(PositionedSymbol symbol) {
		super(symbol.getSymbol(), symbol.getX(), symbol.getY(), symbol.getZ());
		assert symbol != null : "Precondition failed: symbol != null";
		assert PositionedJawSymbol.isValidJawSymbol(
				symbol.getSymbol()) : "Precondition failed: PositionedJawSymbol.isValidJawSymbol(symbol.getSymbol())";
		assert !JawBaseSymbol.JAW_PART_HEAD_RIM.getIswaSymbol()
				.equals(symbol.getSymbol()) : "Left Symbol can not be JAW_PART_HEAD_RIM";
		this.leftSymbol = symbol;
		this.centerSymbol = null;
		this.rightSymbol = null;
	}

	public void addSymbol(PositionedSymbol symbol) {
		assert symbol != null : "Precondition failed: symbol != null";
		assert PositionedJawSymbol.isValidJawSymbol(
				symbol.getSymbol()) : "Precondition failed: PositionedJawSymbol.isValidJawSymbol(symbol.getSymbol())";
		if (centerSymbol == null) {
			assert JawBaseSymbol.JAW_PART_HEAD_RIM.getIswaSymbol()
					.equals(symbol.getSymbol()) : "Center Symbol has to be JAW_PART_HEAD_RIM";
			centerSymbol = symbol;
		} else if (rightSymbol == null) {
			assert !JawBaseSymbol.JAW_PART_HEAD_RIM.getIswaSymbol()
					.equals(symbol.getSymbol()) : "Right Symbol can not be JAW_PART_HEAD_RIM";
			rightSymbol = symbol;
		} else {
			throw new RuntimeException("Jaw Symbol Set is full");
		}
	}

	public boolean belongsToSet(PositionedSymbol symbol) {
		assert symbol != null : "Precondition failed: symbol != null";
		assert leftSymbol != null : "Precondition failed: leftSymbol != null";

		boolean result = false;

		if (centerSymbol == null && JawBaseSymbol.JAW_PART_HEAD_RIM.getIswaSymbol().equals(symbol.getSymbol())) {
			result = true;
		} else if (rightSymbol == null && centerSymbol != null && leftSymbol.getSymbol().equals(symbol.getSymbol())) {
			int distanceLeftToCenter = Math.abs(leftSymbol.getX() - centerSymbol.getX()) - leftSymbol.getWidth();
			int distanceDifference = distanceLeftToCenter
					- (Math.abs(centerSymbol.getX() - symbol.getX()) - centerSymbol.getWidth());
			result = distanceDifference <= 0 && distanceDifference >= -DISTANCE_TOLERANCE;
		}

		return result;
	}

	@Override
	public int getWidth() {
		int width = super.getWidth();
		if (rightSymbol != null) {
			width = Math.abs(leftSymbol.getX() - rightSymbol.getX()) + rightSymbol.getWidth();
		} else if (centerSymbol != null) {
			width = Math.abs(leftSymbol.getX() - centerSymbol.getX()) + centerSymbol.getWidth();
		}

		return width;
	}

	public List<PositionedJawSymbol> getPositionedSymbols() {
		List<PositionedJawSymbol> symbols = new ArrayList<PositionedJawSymbol>();
		symbols.add(new PositionedJawSymbol(leftSymbol.getSymbol(), Location.LEFT, leftSymbol.getX(), leftSymbol.getY(),
				leftSymbol.getZ()));
		if (centerSymbol != null) {
			symbols.add(new PositionedJawSymbol(centerSymbol.getSymbol(), Location.BOTH, centerSymbol.getX(),
					centerSymbol.getY(), centerSymbol.getZ()));
		}
		if (rightSymbol != null) {
			symbols.add(new PositionedJawSymbol(rightSymbol.getSymbol(), Location.RIGHT, rightSymbol.getX(),
					rightSymbol.getY(), rightSymbol.getZ()));
		}
		return symbols;
	}

}
