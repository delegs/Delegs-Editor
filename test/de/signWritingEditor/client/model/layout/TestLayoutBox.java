package de.signWritingEditor.client.model.layout;

import de.signWritingEditor.shared.layout.Box;

class TestLayoutBox implements Box {

	private int width;
	private int height;
	private final int testId;

	public TestLayoutBox(int width, int height) {
		this(width, height, 0);
	}

	public TestLayoutBox(int width, int height, int testId) {
		this.testId = testId;
		assert width >= 0 : "Precondition failed: width >= 0";
		assert height >= 0 : "Precondition failed: height >= 0";

		this.width = width;
		this.height = height;

		assert getWidth_PX() == width : "Postcondition failed: getWidth() == width";
		assert getHeight_PX() == height : "Postcondition failed: getHeight() == height";
	}

	public int getTestId() {
		return testId;
	}

	@Override
	public float getWidth_PX() {
		assert width >= 0 : "Postcondition failed: result >= 0";
		return width;
	}

	@Override
	public int getHeight_PX() {
		assert height >= 0 : "Postcondition failed: result >= 0";
		return height;
	}

	@Override
	public String toString() {
		return "TestBoxId " + testId;
	}
}