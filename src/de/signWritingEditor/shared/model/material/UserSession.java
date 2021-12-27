package de.signWritingEditor.shared.model.material;

import java.io.Serializable;

public class UserSession implements Serializable {

	private static final long serialVersionUID = 1709374318627109000L;
	private User user;
	private SessionKey sessionKey;
	private ExpiryDate expiryTime;

	protected UserSession() {
	}

	public UserSession(User user, SessionKey sessionKey, ExpiryDate expiryTime) {
		assert user != null : "Precondition failed: user != null";
		assert sessionKey != null : "Precondition failed: sessionKey != null";
		assert expiryTime != null : "Precondition failed: expiryTime != null";

		this.user = user;
		this.sessionKey = sessionKey;
		this.expiryTime = expiryTime;
	}

	public User getUser() {
		assert user != null : "Postcondition failed: result != null";
		return user;
	}

	public SessionKey getSessionKey() {
		assert sessionKey != null : "Postcondition failed: result != null";
		return sessionKey;
	}

	public void setUserToUnknownUser() {
		user = User.getUnknownUser();
	}

	public ExpiryDate getExpiryTime() {
		assert expiryTime != null : "Postcondition failed: result != null";
		return expiryTime;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + expiryTime.hashCode();
		result = prime * result + sessionKey.hashCode();
		result = prime * result + user.hashCode();
		return result;
	}

	@Override
	public boolean equals(Object other) {
		boolean result = other != null && other.getClass().equals(this.getClass());

		if (result) {
			UserSession otherUserSession = (UserSession) other;
			result = sessionKey.equals(otherUserSession.sessionKey) && user.equals(otherUserSession.user)
					&& expiryTime.equals(otherUserSession.expiryTime);
		}

		return result;
	}

	@Override
	public String toString() {
		return "UserSession [user=" + user + ", sessionKey=" + sessionKey + ", expiryTime=" + expiryTime + "]";
	}
}
