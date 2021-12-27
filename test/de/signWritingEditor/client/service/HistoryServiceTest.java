package de.signWritingEditor.client.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class HistoryServiceTest {

	private HistoryState globalHistoryState;
	private HistoryService historyService;

	@Before
	public void setup() {
		historyService = new HistoryService(new HistoryService.HistoryListener() {
			@Override
			public void onOpenSystemState(HistoryState historyState) {
				globalHistoryState = historyState;
			}

			@Override
			public void onHistoryChange() {
			}
		});
	}

	@Test
	public void testBasicFuncionality() {
		// 0/0
		assertFalse(historyService.hasNextHistoryEntry());
		assertFalse(historyService.hasPreviousHistoryEntry());
		// 1/1
		historyService.registerHistoryEvent(createNewHistoryState());

		assertFalse(historyService.hasNextHistoryEntry());
		assertFalse(historyService.hasPreviousHistoryEntry());
		// 2/2
		historyService.registerHistoryEvent(createNewHistoryState());

		assertFalse(historyService.hasNextHistoryEntry());
		assertTrue(historyService.hasPreviousHistoryEntry());
		// 1/2
		historyService.undo();

		assertTrue(historyService.hasNextHistoryEntry());
		assertFalse(historyService.hasPreviousHistoryEntry());

		// This does not change anything, since there is no further state to go
		// back to
		historyService.undo();

		assertTrue(historyService.hasNextHistoryEntry());
		assertFalse(historyService.hasPreviousHistoryEntry());
		// 2/2
		historyService.redo();

		assertFalse(historyService.hasNextHistoryEntry());
		assertTrue(historyService.hasPreviousHistoryEntry());
		// 2/2
		// This does not change anything, since there is no further state to go
		// back to
		historyService.redo();

		assertFalse(historyService.hasNextHistoryEntry());
		assertTrue(historyService.hasPreviousHistoryEntry());

		// 3/3
		historyService.registerHistoryEvent(createNewHistoryState());

		assertFalse(historyService.hasNextHistoryEntry());
		assertTrue(historyService.hasPreviousHistoryEntry());

		// 2/3
		historyService.undo();

		assertTrue(historyService.hasNextHistoryEntry());
		assertTrue(historyService.hasPreviousHistoryEntry());

		// 1/3
		historyService.undo();

		assertTrue(historyService.hasNextHistoryEntry());
		assertFalse(historyService.hasPreviousHistoryEntry());

		// 1/3
		historyService.undo();

		assertTrue(historyService.hasNextHistoryEntry());
		assertFalse(historyService.hasPreviousHistoryEntry());

		// 2/3
		historyService.redo();

		assertTrue(historyService.hasNextHistoryEntry());
		assertTrue(historyService.hasPreviousHistoryEntry());

		// 3/3
		historyService.redo();

		assertFalse(historyService.hasNextHistoryEntry());
		assertTrue(historyService.hasPreviousHistoryEntry());

		// 3/3
		historyService.redo();

		assertFalse(historyService.hasNextHistoryEntry());
		assertTrue(historyService.hasPreviousHistoryEntry());

	}

	@Test
	public void testChangingTheFutureOfAnUndoneHistory() {
		HistoryState oldHistory = createNewHistoryState();
		historyService.registerHistoryEvent(oldHistory);
		historyService.registerHistoryEvent(oldHistory);
		historyService.registerHistoryEvent(oldHistory);
		historyService.registerHistoryEvent(oldHistory);

		historyService.undo();
		historyService.undo();

		assertEquals(globalHistoryState, oldHistory);

		assertTrue(historyService.hasPreviousHistoryEntry());

		HistoryState newHistory = createNewHistoryState();
		historyService.registerHistoryEvent(newHistory);

		assertFalse(historyService.hasNextHistoryEntry());

		historyService.registerHistoryEvent(newHistory);
		historyService.undo();
		assertEquals(globalHistoryState, newHistory);
	}

	private HistoryState createNewHistoryState() {
		return new HistoryState() {
		};
	}

}
