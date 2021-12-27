package de.signWritingEditor.infrastructure;

import com.google.gwt.user.client.rpc.AsyncCallback;

import de.signWritingEditor.client.service.VideoServiceAsync;

public class VideoServiceAsyncMock implements VideoServiceAsync {

	@Override
	public void loadVideoFromUrl(String url, AsyncCallback<Boolean> callback) {
	}

	@Override
	public void urlEncode(String url, AsyncCallback<String> callback) {
	}

}
