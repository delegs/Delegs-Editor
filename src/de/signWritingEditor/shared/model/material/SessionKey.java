package de.signWritingEditor.shared.model.material;

import java.io.Serializable;

public class SessionKey implements Serializable {

	private static final long serialVersionUID = 2192411824959216596L;

	private long sessionKey;

	@Deprecated
	public SessionKey() {
	}

	public SessionKey(long sessionKey) {
		this.sessionKey = sessionKey;
	}

	public long getValue() {
		return sessionKey;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (sessionKey ^ (sessionKey >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof SessionKey))
			return false;
		SessionKey other = (SessionKey) obj;
		if (sessionKey != other.sessionKey)
			return false;
		return true;
	}
}
