package de.signWritingEditor.client.service;

import java.util.ArrayList;
import java.util.List;

/**
 * Diese Klasse realisiert eine Rückgängig-Funktion für die Editoren der
 * Anwendung. Die Benutzung ist:
 * <ul>
 * <li>Direkt nach dem Öffnen des ersten Editors muss der Zustand einmal
 * gesichert werden</li>
 * <li>Nach jeder Änderung muss der Zustand gesichert werden.</li>
 * </ul>
 */
public class HistoryService {

	private final List<HistoryState> history = new ArrayList<HistoryState>();
	private int historyPositionIndex = -1;
	private final HistoryListener historyListener;

	public HistoryService(HistoryListener historyListener) {
		this.historyListener = historyListener;
	}

	/**
	 * Adds the current state to the historyService
	 * 
	 * @param historyState
	 *            The historyState to add to the service
	 */
	public void registerHistoryEvent(HistoryState historyState) {
		assert historyState != null : "Precondition failed: historyState != null";

		removeOldHistoryFuture();
		history.add(historyState);
		historyPositionIndex++;

		historyListener.onHistoryChange();
	}

	/**
	 * Puts the system in the previous state, if there is any.
	 */
	public void undo() {
		if (hasPreviousHistoryEntry()) {
			historyPositionIndex--;
			openSystemState(history.get(historyPositionIndex));

			historyListener.onHistoryChange();
		}
	}

	/**
	 * Puts the system in the next state, if there is any (requires at least one
	 * UNDO before).
	 */
	public void redo() {
		if (hasNextHistoryEntry()) {
			historyPositionIndex++;
			openSystemState(history.get(historyPositionIndex));

			historyListener.onHistoryChange();
		}
	}

	/**
	 * This method should be handled with care! It should become deprecated when
	 * all editors support undo/redo behavior. Currently, it resets the history
	 * in order to prevent overwriting different tokens (2 signs edited one
	 * after the other). In the future, this method will not be needed, since
	 * changing the current tool is a history event on its own.
	 */
	public void clearHistory() {
		historyPositionIndex = -1;
		history.clear();

		historyListener.onHistoryChange();
	}

	public boolean hasNextHistoryEntry() {
		return historyPositionIndex + 1 < history.size();
	}

	public boolean hasPreviousHistoryEntry() {
		return historyPositionIndex > 0;
	}

	private void openSystemState(HistoryState historyState) {
		assert historyState != null : "Precondition failed: historyState != null";

		historyListener.onOpenSystemState(historyState);
	}

	/**
	 * Maybe there were some UNDOs already. If the next step is not a REDO, the
	 * old history has to be deleted to be replaced by the new one
	 */
	private void removeOldHistoryFuture() {
		if (hasNextHistoryEntry()) {
			for (int i = history.size() - 1; i > historyPositionIndex; i--) {
				history.remove(i);
			}
		}
	}

	public interface HistoryListener {
		/**
		 * Opens the corresponding editor with the given historyState
		 * 
		 * @param historyState
		 *            The state to establish in the editor
		 */
		void onOpenSystemState(HistoryState historyState);

		void onHistoryChange();
	}
}
