package de.signWritingEditor.shared.model.material;

public interface Template {

	void lockLayout(boolean isLockedLayout);

	boolean isLayoutLocked();

	void lockContent(boolean isLockedContent);

	boolean isContentLocked();
}
