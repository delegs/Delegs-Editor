package de.signWritingEditor.client.service;

import java.io.Serializable;

public class QueryResult<T extends Enum<?>> implements Serializable {

	private static final long serialVersionUID = 571885667996622432L;

	private boolean result;
	private T reason;

	public QueryResult(boolean result, T reason) {
		this.result = result;
		this.reason = reason;
	}

	public boolean getResult() {
		return result;
	}

	public T getReason() {
		return reason;
	}

	@Deprecated
	public QueryResult() {
	}
}
