package de.delegs.memo.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>MemoService</code>.
 */
public interface MemoServiceAsync {
	void memoServer(String input, AsyncCallback<String> callback)
			throws IllegalArgumentException;
}
