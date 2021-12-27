package de.signWritingEditor.client.service;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface MediaUrlServiceAsync {
	void getMediaUrl(AsyncCallback<String> callback);
}
