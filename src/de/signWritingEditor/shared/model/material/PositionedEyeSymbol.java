package de.signWritingEditor.shared.model.material;

import java.util.ArrayList;
import java.util.List;

import de.signWritingEditor.shared.model.domainValue.EyesBaseSymbol;
import de.signWritingEditor.shared.model.domainValue.Symbol;

public class PositionedEyeSymbol extends PositionedSymbol implements Cloneable, Locatable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Location location;

	public PositionedEyeSymbol(Symbol eyeSymbol, Location location, int x, int y, int z) {
		super(eyeSymbol, x, y, z);
		this.location = location;
	}

	public PositionedEyeSymbol(Symbol symbol, Location location) {
		this(symbol, location, 0, 0, 0);
	}

	@Deprecated
	public PositionedEyeSymbol() {
	}

	@Override
	public PositionedEyeSymbol clone() {
		PositionedEyeSymbol positionedEyeSymbol = new PositionedEyeSymbol(getSymbol(), location, getX(), getY(),
				getZ());
		positionedEyeSymbol.setLineColor(getLineColor());
		positionedEyeSymbol.setFillColor(getFillColor());
		return positionedEyeSymbol;
	}

	public boolean isLeftEye() {
		return Location.LEFT.equals(location);
	}

	public boolean isRightEye() {
		return Location.RIGHT.equals(location);
	}

	public static boolean isValidEyesSymbol(Symbol symbol) {
		assert symbol != null : "Precondition failed: symbol != null";

		return EyesBaseSymbol.isValidEyesSymbol(symbol);
	}

	public static boolean isAnyEyesSymbol(Symbol symbol) {
		assert symbol != null : "Precondition failed: symbol != null";

		return EyesBaseSymbol.isAnyEyesSymbol(symbol);
	}

	public boolean canIncrease() {
		return (getSymbol().getBaseSymbol()
				.equals(EyesBaseSymbol.EYEGAZE_STRAIGHT_WALL_PLANE.getIswaSymbol().getBaseSymbol())
				|| getSymbol().getBaseSymbol()
						.equals(EyesBaseSymbol.EYEGAZE_STRAIGHT_FLOOR_PLANE.getIswaSymbol().getBaseSymbol()));
	}

	public boolean canDecrease() {
		return (getSymbol().getBaseSymbol()
				.equals(EyesBaseSymbol.EYEGAZE_STRAIGHT_WALL_DOUBLE.getIswaSymbol().getBaseSymbol())
				|| getSymbol().getBaseSymbol()
						.equals(EyesBaseSymbol.EYEGAZE_STRAIGHT_FLOOR_DOUBLE.getIswaSymbol().getBaseSymbol()));
	}

	public void increase() {
		assert canIncrease() : "Precondition failed: canIncrease()";

		int oldFillLeftEye = getSymbol().getFill();
		int oldRotationLeftEye = getSymbol().getRotation();

		if (getSymbol().getBaseSymbol()
				.equals(EyesBaseSymbol.EYEGAZE_STRAIGHT_WALL_PLANE.getIswaSymbol().getBaseSymbol())) {
			Symbol increasedSymbol = EyesBaseSymbol.EYEGAZE_STRAIGHT_WALL_DOUBLE.getIswaSymbol();
			setSymbol(increasedSymbol);
		} else if (getSymbol().getBaseSymbol()
				.equals(EyesBaseSymbol.EYEGAZE_STRAIGHT_FLOOR_PLANE.getIswaSymbol().getBaseSymbol())) {
			Symbol increasedSymbol = EyesBaseSymbol.EYEGAZE_STRAIGHT_FLOOR_DOUBLE.getIswaSymbol();
			setSymbol(increasedSymbol);
		}
		setFillAndRotation(oldFillLeftEye, oldRotationLeftEye);

	}

	public void decrease() {
		assert canDecrease() : "Precondition failed: canDecrease()";

		int oldFillLeftEye = getSymbol().getFill();
		int oldRotationLeftEye = getSymbol().getRotation();

		if (getSymbol().getBaseSymbol()
				.equals(EyesBaseSymbol.EYEGAZE_STRAIGHT_WALL_DOUBLE.getIswaSymbol().getBaseSymbol())) {
			Symbol increasedSymbol = EyesBaseSymbol.EYEGAZE_STRAIGHT_WALL_PLANE.getIswaSymbol();
			setSymbol(increasedSymbol);
		} else if (getSymbol().getBaseSymbol()
				.equals(EyesBaseSymbol.EYEGAZE_STRAIGHT_FLOOR_DOUBLE.getIswaSymbol().getBaseSymbol())) {
			Symbol increasedSymbol = EyesBaseSymbol.EYEGAZE_STRAIGHT_FLOOR_PLANE.getIswaSymbol();
			setSymbol(increasedSymbol);
		}
		setFillAndRotation(oldFillLeftEye, oldRotationLeftEye);
	}

	public boolean canRotate() {

		return EyesBaseSymbol.getEyesBaseSymbol(getSymbol().getBaseSymbol()).getValidRotations().size() > 1;
	}

	public boolean canMirrorVertically() {
		return (getSymbol().getBaseSymbol()
				.equals(EyesBaseSymbol.EYEGAZE_STRAIGHT_WALL_ALTERNATE.getIswaSymbol().getBaseSymbol())//
				|| getSymbol().getBaseSymbol()
						.equals(EyesBaseSymbol.EYEGAZE_STRAIGHT_FLOOR_ALTERNATE.getIswaSymbol().getBaseSymbol())//
				|| getSymbol().getBaseSymbol()
						.equals(EyesBaseSymbol.EYEGAZE_CURVED_FLOOR_PLANE.getIswaSymbol().getBaseSymbol())//
				|| getSymbol().getBaseSymbol()
						.equals(EyesBaseSymbol.EYEGAZE_CIRCLES_WALL_PLANE.getIswaSymbol().getBaseSymbol())//
				|| getSymbol().getBaseSymbol()
						.equals(EyesBaseSymbol.EYEGAZE_CURVED_WALL_PLANE.getIswaSymbol().getBaseSymbol()));
	}

	public void mirrorVertically() {
		assert canMirrorVertically() : "Precondition failed: canMirror()";

		int newLeftEyeRotation = (getSymbol().getRotation() + 4);

		if (getSymbol().getBaseSymbol()
				.equals(EyesBaseSymbol.EYEGAZE_CURVED_WALL_PLANE.getIswaSymbol().getBaseSymbol())) {
			newLeftEyeRotation += 4;

			if (newLeftEyeRotation > 16) {
				newLeftEyeRotation -= 16;
			}

		} else {
			if (newLeftEyeRotation > 8) {
				newLeftEyeRotation -= 8;
			}
		}
		setFillAndRotation(getSymbol().getFill(), newLeftEyeRotation);

	}

	public void rotateClockwise() {
		assert canRotate() : "Precondition failed: canRotate()";

		if (getSymbol().getBaseSymbol()
				.equals(EyesBaseSymbol.EYEGAZE_STRAIGHT_WALL_ALTERNATE.getIswaSymbol().getBaseSymbol())) {
			getPreviousRotation();
		} else {
			if ((getSymbol().getBaseSymbol()
					.equals(EyesBaseSymbol.EYEGAZE_CURVED_WALL_PLANE.getIswaSymbol().getBaseSymbol())
					|| getSymbol().getBaseSymbol()
							.equals(EyesBaseSymbol.EYEGAZE_CURVED_FLOOR_PLANE.getIswaSymbol().getBaseSymbol())
					|| getSymbol().getBaseSymbol()
							.equals(EyesBaseSymbol.EYEGAZE_CIRCLES_WALL_PLANE.getIswaSymbol().getBaseSymbol()))
					&& getSymbol().getRotation() > EyesBaseSymbol.getEyesBaseSymbol(getSymbol().getBaseSymbol())
							.getValidRotations().size() / 2) {
				getNextRotation();
			} else {
				getPreviousRotation();
			}
		}
	}

	public void rotateCounterClockwise() {
		assert canRotate() : "Precondition failed: canRotate()";

		if (getSymbol().getBaseSymbol()
				.equals(EyesBaseSymbol.EYEGAZE_STRAIGHT_WALL_ALTERNATE.getIswaSymbol().getBaseSymbol())) {
			getNextRotation();
		} else {
			if ((getSymbol().getBaseSymbol()
					.equals(EyesBaseSymbol.EYEGAZE_CURVED_WALL_PLANE.getIswaSymbol().getBaseSymbol())
					|| getSymbol().getBaseSymbol()
							.equals(EyesBaseSymbol.EYEGAZE_CURVED_FLOOR_PLANE.getIswaSymbol().getBaseSymbol())
					|| getSymbol().getBaseSymbol()
							.equals(EyesBaseSymbol.EYEGAZE_CIRCLES_WALL_PLANE.getIswaSymbol().getBaseSymbol()))
					&& getSymbol().getRotation() > EyesBaseSymbol.getEyesBaseSymbol(getSymbol().getBaseSymbol())
							.getValidRotations().size() / 2) {
				getPreviousRotation();
			} else {
				getNextRotation();
			}
		}
	}

	private void getPreviousRotation() {
		int newLeftEyeRotation = getSymbol().getRotation() - 1;

		if (getSymbol().getBaseSymbol()
				.equals(EyesBaseSymbol.EYEGAZE_STRAIGHT_WALL_ALTERNATE.getIswaSymbol().getBaseSymbol())
				|| getSymbol().getBaseSymbol()
						.equals(EyesBaseSymbol.EYEGAZE_CURVED_FLOOR_PLANE.getIswaSymbol().getBaseSymbol())
				|| getSymbol().getBaseSymbol()
						.equals(EyesBaseSymbol.EYEGAZE_CIRCLES_WALL_PLANE.getIswaSymbol().getBaseSymbol())) {

			if (newLeftEyeRotation == 4) {
				newLeftEyeRotation = 8;
			}

			if (newLeftEyeRotation == 0) {
				newLeftEyeRotation = 4;
			}

		} else {
			if (newLeftEyeRotation == 8) {
				newLeftEyeRotation = 16;
			}

			if (newLeftEyeRotation == 0) {
				newLeftEyeRotation = 8;
			}

		}
		setFillAndRotation(getSymbol().getFill(), newLeftEyeRotation);
	}

	private void getNextRotation() {
		int newLeftEyeRotation = getSymbol().getRotation() + 1;

		if (getSymbol().getBaseSymbol()
				.equals(EyesBaseSymbol.EYEGAZE_STRAIGHT_WALL_ALTERNATE.getIswaSymbol().getBaseSymbol())
				|| getSymbol().getBaseSymbol()
						.equals(EyesBaseSymbol.EYEGAZE_CURVED_FLOOR_PLANE.getIswaSymbol().getBaseSymbol())
				|| getSymbol().getBaseSymbol()
						.equals(EyesBaseSymbol.EYEGAZE_CIRCLES_WALL_PLANE.getIswaSymbol().getBaseSymbol())) {
			if (newLeftEyeRotation == 5) {
				newLeftEyeRotation = 1;
			}

			if (newLeftEyeRotation == 9) {
				newLeftEyeRotation = 5;
			}

		} else {
			if (newLeftEyeRotation == 9) {
				newLeftEyeRotation = 1;
			}

			if (newLeftEyeRotation == 17) {
				newLeftEyeRotation = 9;
			}
		}

		setFillAndRotation(getSymbol().getFill(), newLeftEyeRotation);
	}

	public void setFillAndRotation(int fill, int rotation) {
		assert isValidRotation(getSymbol(), rotation) : "Precondition failed: isValidRotation(leftEye,rotation)";
		assert isValidFill(getSymbol(), fill) : "Precondition failed: isValidFill(leftEye, fill)";

		Symbol result = null;

		for (Symbol symbol : EyesBaseSymbol.getAllVariationsForSymbol(getSymbol())) {
			if (symbol.getFill() == fill && symbol.getRotation() == rotation) {
				result = symbol;
				break;
			}
		}

		assert result != null : "Postcondition failed: result != null";

		setSymbol(result);
	}

	public static List<PositionedEyeSymbol> convertToValidEyeSymbols(Symbol symbol) {
		assert symbol != null : "Precondition failed: symbol != null";
		assert isAnyEyesSymbol(symbol) : "Precondition failed: isAnyEyesSymbol(symbol)";

		List<PositionedEyeSymbol> result = new ArrayList<PositionedEyeSymbol>();

		if (isValidEyesSymbol(symbol)) {
			if (symbol.equals(EyesBaseSymbol.EYE_BLINK_SINGLE.getIswaSymbol())
					|| symbol.equals(EyesBaseSymbol.EYE_BLINKS_MULTIPLE.getIswaSymbol())) {
				// These are two eyes that need the EYES_OPEN Symbol
				// additionally

				Symbol leftEyeSymbol = EyesBaseSymbol.getLeftEyeFor(symbol);
				Symbol leftExtraSymbol = EyesBaseSymbol.getLeftEyeFor(EyesBaseSymbol.EYES_OPEN.getIswaSymbol());
				result.addAll(createSpecialEyeSymbol(leftEyeSymbol, leftExtraSymbol, Location.LEFT));

				Symbol rightEyeSymbol = EyesBaseSymbol.getRightEyeFor(symbol);
				Symbol rightExtraSymbol = EyesBaseSymbol.getRightEyeFor(EyesBaseSymbol.EYES_OPEN.getIswaSymbol());
				result.addAll(createSpecialEyeSymbol(rightEyeSymbol, rightExtraSymbol, Location.RIGHT));
			} else if ((symbol.getFill() == 4 && symbol.getSymbol() < 7)
					|| (symbol.getFill() == 2 && symbol.getSymbol() >= 7)) {
				result.add(new PositionedEyeSymbol(EyesBaseSymbol.getLeftEyeFor(symbol), Location.LEFT));
				result.add(new PositionedEyeSymbol(EyesBaseSymbol.getRightEyeFor(symbol), Location.RIGHT));
			} else {
				result.add(new PositionedEyeSymbol(symbol, Location.UNKNOWN));
			}

		} else {
			int height = symbol.getHeight();
			int width = symbol.getWidth();
			Symbol newSymbol = new Symbol(symbol.getCategory(), symbol.getGroup(), symbol.getSymbol(),
					symbol.getVariation(), EyesBaseSymbol.getFillForSymbolWithoutCircle(symbol), symbol.getRotation(),
					symbol.getWidth(), symbol.getHeight());

			for (Symbol symbolToSet : EyesBaseSymbol.getAllVariationsForSymbol(symbol)) {
				if (symbolToSet.equals(newSymbol)) {
					height = symbolToSet.getHeight();
					width = symbolToSet.getWidth();
					break;
				}
			}

			Symbol newEyeSymbol = new Symbol(symbol.getCategory(), symbol.getGroup(), symbol.getSymbol(),
					symbol.getVariation(), EyesBaseSymbol.getFillForSymbolWithoutCircle(symbol), symbol.getRotation(),
					width, height);

			if (newEyeSymbol.equals(EyesBaseSymbol.EYE_BLINK_SINGLE.getIswaSymbol())
					|| newEyeSymbol.equals(EyesBaseSymbol.EYE_BLINKS_MULTIPLE.getIswaSymbol())) {
				// These are two eyes that need the EYES_OPEN Symbol
				// additionally

				Symbol leftEyeSymbol = EyesBaseSymbol.getLeftEyeFor(newEyeSymbol);
				Symbol leftExtraSymbol = EyesBaseSymbol.getLeftEyeFor(EyesBaseSymbol.EYES_OPEN.getIswaSymbol());
				result.addAll(createSpecialEyeSymbol(leftEyeSymbol, leftExtraSymbol, Location.LEFT));

				Symbol rightEyeSymbol = EyesBaseSymbol.getRightEyeFor(newEyeSymbol);
				Symbol rightExtraSymbol = EyesBaseSymbol.getRightEyeFor(EyesBaseSymbol.EYES_OPEN.getIswaSymbol());
				result.addAll(createSpecialEyeSymbol(rightEyeSymbol, rightExtraSymbol, Location.RIGHT));
			} else if (symbol.getSymbol() < 7) {
				if (symbol.getFill() <= 2) {
					result.add(new PositionedEyeSymbol(EyesBaseSymbol.getRightEyeFor(newEyeSymbol), Location.RIGHT));
				}
				if (symbol.getFill() == 3 || symbol.getFill() == 1) {
					result.add(new PositionedEyeSymbol(EyesBaseSymbol.getLeftEyeFor(newEyeSymbol), Location.LEFT));
				}
				assert result.size() >= 1 : "Postcondition failed: result.size() >= 1";
			} else {
				if (symbol.getFill() <= 2) {
					result.add(new PositionedEyeSymbol(EyesBaseSymbol.getLeftEyeFor(newEyeSymbol), Location.LEFT));
					result.add(new PositionedEyeSymbol(EyesBaseSymbol.getRightEyeFor(newEyeSymbol), Location.RIGHT));
				} else {
					result.add(new PositionedEyeSymbol(newEyeSymbol, Location.UNKNOWN));
				}
			}
		}
		return result;
	}

	private static List<PositionedEyeSymbol> createSpecialEyeSymbol(Symbol upperEyeSymbol, Symbol lowerEyeSymbol,
			Location position) {
		List<PositionedEyeSymbol> result = new ArrayList<PositionedEyeSymbol>();
		int symbolDistance = 6;
		result.add(new PositionedEyeSymbol(upperEyeSymbol, position, 0, symbolDistance / 2, 0));
		result.add(new PositionedEyeSymbol(lowerEyeSymbol, position, 0, -symbolDistance / 2, 0));
		return result;

	}

	private boolean isValidFill(Symbol eye, int fill) {
		assert eye != null : "Precondition failed: eye != null";
		assert fill > 0 : "Precondition failed: fill > 0";

		return EyesBaseSymbol.getEyesBaseSymbol(eye.getBaseSymbol()).getValidFills().contains(fill);
	}

	private boolean isValidRotation(Symbol eye, int rotation) {
		assert eye != null : "Precondition failed: eye != null";
		assert rotation > 0 : "Precondition failed: rotation > 0";

		return EyesBaseSymbol.getEyesBaseSymbol(eye.getBaseSymbol()).getValidRotationValues().contains(rotation);

	}

	@Override
	public Location getLocation() {
		return location;
	}

	@Override
	public void setLocation(Location location) {
		this.location = location;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!getClass().equals(obj.getClass()))
			return false;
		PositionedEyeSymbol other = (PositionedEyeSymbol) obj;
		if (location != other.location)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Symbol(id: " + getSymbol().toString() + ", x: " + getX() + ", y: " + getY() + ", z: " + getZ()
				+ ", Location: " + getLocation() + ")";
	}

}
