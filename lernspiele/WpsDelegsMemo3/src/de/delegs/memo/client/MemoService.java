package de.delegs.memo.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("memo")
public interface MemoService extends RemoteService {
	String memoServer(String name) throws IllegalArgumentException;
}
