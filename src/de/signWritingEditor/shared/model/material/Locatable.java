package de.signWritingEditor.shared.model.material;

public interface Locatable {

	public Location getLocation();

	public void setLocation(Location location);

	public enum Location {
		LEFT, RIGHT, BOTH, UNKNOWN
	}
}
