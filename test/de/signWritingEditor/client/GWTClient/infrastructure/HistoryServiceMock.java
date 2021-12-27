package de.signWritingEditor.client.GWTClient.infrastructure;

import de.signWritingEditor.client.service.HistoryService;
import de.signWritingEditor.client.service.HistoryState;

public class HistoryServiceMock extends HistoryService {

	public HistoryServiceMock() {
		super(new HistoryListener() {

			@Override
			public void onOpenSystemState(HistoryState historyState) {
				

			}

			@Override
			public void onHistoryChange() {
				

			}
		});
	}

}
