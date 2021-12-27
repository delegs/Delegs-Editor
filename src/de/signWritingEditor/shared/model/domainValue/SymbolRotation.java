package de.signWritingEditor.shared.model.domainValue;

public enum SymbolRotation {

	// right Hand
	NORTH(1), //
	NORTH_WEST(2), //
	WEST(3), //
	SOUTH_WEST(4), //
	SOUTH(5), //
	SOUTH_EAST(6), //
	EAST(7), //
	NORTH_EAST(8), //
	// left Hand
	MIRRORED_NORTH(9), //
	MIRRORED_NORTH_WEST(10), //
	MIRRORED_WEST(11), //
	MIRRORED_SOUTH_WEST(12), //
	MIRRORED_SOUTH(13), //
	MIRRORED_SOUTH_EAST(14), //
	MIRRORED_EAST(15), //
	MIRRORED_NORTH_EAST(16),;

	private final int rotation;

	private SymbolRotation(int rotation) {
		this.rotation = rotation;
	}

	public int getRotationValue() {
		return rotation;
	}

}
