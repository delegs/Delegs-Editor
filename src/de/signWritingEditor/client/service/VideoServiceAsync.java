package de.signWritingEditor.client.service;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface VideoServiceAsync {
	void loadVideoFromUrl(String url, AsyncCallback<Boolean> callback);

	void urlEncode(String url, AsyncCallback<String> callback);
}
