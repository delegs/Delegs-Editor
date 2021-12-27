package de.signWritingEditor.shared.model.domainValue;

public class CursorPosition {

	private final Id tokenId;
	private final int positionInToken;

	public CursorPosition(Id tokenId, int positionInToken) {
		assert tokenId != null : "Precondition failed: tokenId != null";
		assert positionInToken >= -1 : "Precondition failed: positionInToken >= -1";

		this.tokenId = tokenId;
		this.positionInToken = positionInToken;
	}

	public Id getTokenId() {
		return tokenId;
	}

	public int getPositionInToken() {
		return positionInToken;
	}

	@Override
	public String toString() {
		return "TokenId: " + tokenId + ", pos: " + positionInToken;
	}

	@Override
	public boolean equals(Object other) {
		boolean result = other != null && getClass().equals(other.getClass());

		if (result) {
			CursorPosition otherCursorPosition = (CursorPosition) other;

			result = positionInToken == otherCursorPosition.getPositionInToken()
					&& tokenId.equals(otherCursorPosition.getTokenId());
		}

		return result;
	}
}
