package de.signWritingEditor.shared.layout;

import java.util.ArrayList;
import java.util.List;

import de.signWritingEditor.shared.model.domainValue.Orientation;

public abstract class OverflowListLayout implements Box, Margin {

	public static final Orientation HORIZONTAL = Orientation.HORIZONTAL;
	public static final Orientation VERTICAL = Orientation.VERTICAL;

	private Orientation orientation;
	private int overflowThreshold;
	private boolean canCompensate;

	private List<Box> boxes;

	public OverflowListLayout(Orientation orientation, int overflowThreshold) {
		assert orientation != null : "Precondition failed: orientation != null";
		assert overflowThreshold >= 0 : "Precondition failed: overflowThreshold >= 0";

		this.orientation = orientation;
		this.overflowThreshold = overflowThreshold;
		this.canCompensate = false;
		this.boxes = new ArrayList<Box>();

		assert getOrientation().equals(orientation) : "Postcondition failed: getOrientation().equals(orientation)";
		assert !canCompensate() : "Postcondition failed: !canCompensate()";
	}

	public Orientation getOrientation() {
		assert orientation != null : "Postcondition failed: result != null";
		return orientation;
	}

	public int getOverflowThreshold() {
		assert overflowThreshold >= 0 : "Postcondition failed: result >= 0";
		return overflowThreshold;
	}

	public void setOverflowThreshold(int overflowThreshold) {
		assert overflowThreshold >= 0 : "Precondition failed: overflowThreshold >= 0";
		this.overflowThreshold = overflowThreshold;
		assert getOverflowThreshold() == overflowThreshold : "Postcondition failed: getOverflowThreshold() == overflowThreshold";
	}

	public boolean isEmpty() {
		return getBoxCount() < 1;
	}

	public int getBoxCount() {
		int result = boxes.size();
		assert result >= 0 : "Postcondition failed: result >= 0";
		return result;
	}

	public int getBoxIndex(Box box) {
		assert box != null : "Precondition failed: box != null";

		int result = boxes.indexOf(box);

		assert result >= -1 : "Postcondition failed: result >= -1";
		assert result < getBoxCount() : "Postcondition failed: result < getBoxCount()";
		return result;
	}

	public Box getBox(int boxIndex) {
		assert boxIndex >= 0 : "Precondition failed: boxIndex >= 0";
		assert boxIndex < getBoxCount() : "Precondition failed: boxIndex < getBoxCount()";

		Box result = boxes.get(boxIndex);

		assert result != null : "Postcondition failed: result != null";
		return result;
	}

	protected List<Box> getBox() {
		return boxes;
	}

	public void setBox(Box box, int boxIndex) {
		assert box != null : "Precondition failed: box != null";
		assert boxIndex >= 0 : "Precondition failed: boxIndex >= 0";
		assert boxIndex < getBoxCount() : "Precondition failed: boxIndex < getBoxCount()";

		boxes.set(boxIndex, box);

		assert getBox(boxIndex) == box : "Postcondition failed: getBox(boxIndex) == box";
	}

	public void addBox(Box box) {
		assert box != null : "Precondition failed: box != null";
		boxes.add(box);
		assert getBox(getBoxCount() - 1) == box : "Postcondition failed: getBox(getBoxCount() - 1) == box";
	}

	public void insertBox(Box box, int boxIndex) {
		assert box != null : "Precondition failed: box != null";
		assert boxIndex >= 0 : "Precondition failed: boxIndex >= 0";
		assert boxIndex <= getBoxCount() : "Precondition failed: boxIndex <= getBoxCount()";

		boxes.add(boxIndex, box);

		assert getBox(boxIndex) == box : "Postcondition failed: getBox(boxIndex) == box";
	}

	public void removeBox(int boxIndex) {
		assert boxIndex >= 0 : "Precondition failed: boxIndex >= 0";
		assert boxIndex < getBoxCount() : "Precondition failed: boxIndex < getBoxCount()";

		boxes.remove(boxIndex);
	}

	public void moveTail(OverflowListLayout targetOverflowListLayout, int firstBoxIndex) {
		assert targetOverflowListLayout != null : "Precondition failed: targetOverflowListLayout != null";
		assert targetOverflowListLayout != this : "Precondition failed: targetOverflowListLayout != this";
		assert firstBoxIndex >= 0 : "Precondition failed: firstBoxIndex >= 0";
		assert firstBoxIndex <= getBoxCount() : "Precondition failed: firstBoxIndex <= getBoxCount()";

		int lastBoxIndex;
		do {
			lastBoxIndex = boxes.size() - 1;
			if (firstBoxIndex <= lastBoxIndex) {
				Box box = getBox(lastBoxIndex);
				removeBox(lastBoxIndex);
				targetOverflowListLayout.insertBox(box, 0);
			}
		} while (firstBoxIndex <= lastBoxIndex);

		assert getBoxCount() == firstBoxIndex : "Postcondition failed: getBoxCount() == firstBoxIndex";
	}

	public void moveHead(OverflowListLayout targetOverflowListLayout, int lastBoxIndex) {
		assert targetOverflowListLayout != null : "Precondition failed: targetOverflowListLayout != null";
		assert targetOverflowListLayout != this : "Precondition failed: targetOverflowListLayout != this";
		assert lastBoxIndex >= 0 : "Precondition failed: lastBoxIndex >= 0";
		assert lastBoxIndex < getBoxCount() : "Precondition failed: lastBoxIndex < getBoxCount()";

		int beforeBoxCount = getBoxCount();

		int counter = 0;
		while (counter <= lastBoxIndex) {
			Box box = getBox(0);
			removeBox(0);
			targetOverflowListLayout.addBox(box);
			counter++;
		}

		assert getBoxCount() == beforeBoxCount - (lastBoxIndex + 1) : "Postcondition failed: getBoxCount() ["
				+ getBoxCount() + "] == beforeBoxCount [" + beforeBoxCount + "] - (lastBoxIndex + 1) ["
				+ (lastBoxIndex + 1) + "]";
	}

	public float getOverflow() {
		float result = 0;
		if (Orientation.HORIZONTAL.equals(getOrientation())) {
			result = getWidth_PX() - overflowThreshold;
		} else {
			result = getHeight_PX() - overflowThreshold;
		}
		return result;
	}

	public boolean canCompensate() {
		return canCompensate;
	}

	public void setCanCompensate(boolean canCompensate) {
		this.canCompensate = canCompensate;

		assert canCompensate() == canCompensate : "Postcondition failed: canCompensate() == canCompensate";
	}

	public int getOverflowStartIndex() {
		return getOutlierStartIndex(overflowThreshold);
	}

	public int getOutlierStartIndex(float maxDimension) {
		assert maxDimension >= 0 : "Precondition failed: maxDimension >= 0";

		int result = 0;

		float dimension = 0;
		while (result < boxes.size() && dimension <= maxDimension) {
			if (orientation.equals(HORIZONTAL)) {
				dimension += boxes.get(result).getWidth_PX();
			} else {
				dimension += boxes.get(result).getHeight_PX();
			}
			if (dimension <= maxDimension) {
				result++;
			}
		}

		assert result >= 0 : "Postcondition failed: result >= 0";
		assert result <= getBoxCount() : "Postcondition failed: result <= getBoxCount()";
		return result;
	}

	@Override
	public float getWidth_PX() {
		float result = 0;
		if (orientation.equals(HORIZONTAL)) {
			for (Box box : boxes) {
				result += box.getWidth_PX();
			}
		} else {
			for (Box box : boxes) {
				result = Math.max(result, box.getWidth_PX());
			}
		}
		assert result >= 0 : "Postcondition failed: result >= 0";
		return result;
	}

	@Override
	public int getHeight_PX() {
		int result_PX = 0;
		if (orientation.equals(VERTICAL)) {
			for (Box box : boxes) {
				result_PX += box.getHeight_PX();
			}
		} else {
			for (Box box : boxes) {
				if (box instanceof VideoTokenBox) {
					result_PX = Math.max(result_PX, ((VideoTokenBox) box).getHeightWithMargin_PX());
				} else if (box instanceof ImageTokenBox) {
					result_PX = Math.max(result_PX, ((ImageTokenBox) box).getHeightWithMargin_PX());
				} else {
					result_PX = Math.max(result_PX, box.getHeight_PX());
				}
			}
		}
		assert result_PX >= 0 : "Postcondition failed: result >= 0";
		return result_PX;
	}

	@Override
	public String toString() {
		StringBuffer result = new StringBuffer(
				"Orientation: " + orientation + ", compensate: " + canCompensate + ", boxes: ");
		if (boxes.isEmpty()) {
			result.append("none");
		} else {
			result.append("[");
			for (Box box : boxes) {
				result.append(box + ", ");
			}
			result.replace(result.length() - 2, result.length(), "]");

		}
		return result.toString();
	}

	public int getMaxSignItemTokenBoxHeight_PX() {
		int result_PX = 0;
		if (orientation.equals(VERTICAL)) {
			for (Box box : boxes) {
				result_PX += box.getHeight_PX();
			}
		} else {
			for (Box box : boxes) {
				if (box instanceof SignItemTokenBox) {
					result_PX = Math.max(result_PX, ((SignItemTokenBox) box).getTextHeight_PX());
				}
			}
		}
		assert result_PX >= 0 : "Postcondition failed: result >= 0";
		return result_PX;
	}

	public int getInnerWidth_PX() {
		return overflowThreshold;
	}

}