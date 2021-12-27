package de.signWritingEditor.client.GWTClient.ui.tool.subtools.signEditor;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class SelectionTool<T> {
	private Set<T> selectedItems;

	public SelectionTool() {
		this.selectedItems = new HashSet<T>();
	}

	public Set<T> getSelectedItems() {
		return Collections.unmodifiableSet(selectedItems);
	}

	public void clearSelection() {
		selectedItems.clear();
	}

	public boolean isSelected(T item) {
		assert item != null : "Precondition failed: item != null";
		return selectedItems.contains(item);
	}

	public void select(T item) {
		assert item != null : "Precondition failed: item != null";
		selectedItems.add(item);
	}

	public void deselect(T item) {
		assert item != null : "Precondition failed: item != null";
		selectedItems.remove(item);

	}

	public boolean hasAnySelection() {
		return !selectedItems.isEmpty();
	}
}
