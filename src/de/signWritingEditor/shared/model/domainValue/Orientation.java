package de.signWritingEditor.shared.model.domainValue;

/**
 * The orientation describes how lines are arranged on a page (rows: vertical,
 * columns: horizontal) - NOT the page orientation (landscape / portrait)
 */
public enum Orientation {

	HORIZONTAL, VERTICAL;

	public Orientation toggle() {
		return values()[(ordinal() + 1) % values().length];
	}
}
