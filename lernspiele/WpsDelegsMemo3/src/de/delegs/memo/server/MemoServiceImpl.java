package de.delegs.memo.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import de.delegs.memo.client.MemoService;

@SuppressWarnings("serial")
public class MemoServiceImpl extends RemoteServiceServlet implements MemoService {

	@Override
	public String memoServer(String input) throws IllegalArgumentException {
		return "Wurst";
	}

}
