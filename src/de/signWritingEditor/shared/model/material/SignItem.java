package de.signWritingEditor.shared.model.material;

import java.io.Serializable;
import java.util.Objects;

import de.signWritingEditor.shared.model.domainValue.SignId;

public class SignItem implements Serializable {

	private static final long serialVersionUID = 8153568373800188748L;

	public static final SignItem emptySignItem = new SignItem(SignId.emptySignId, 0);

	private SignId signId;
	private int signWidth;
	private long revision;
	private SimpleSign localSign;

	public SignItem(SignId signId, int signWidth) {
		assert signId != null : "Precondition failed: signId != null";
		assert signWidth >= 0 : "Precondition failed: signWidth >= 0";

		this.signId = signId;
		this.signWidth = signWidth;
		this.localSign = null;
	}

	public SignItem(SimpleSign localSign) {
		assert localSign != null : "Precondition failed: localSign != null";

		this.localSign = localSign;
		this.signId = localSign.getSignId();
		this.signWidth = localSign.getWidth();
	}

	public SignId getSignId() {
		return signId;
	}

	public SimpleSign getLocalSign() {
		return localSign;
	}

	public int getSignWidth() {
		return signWidth;
	}

	public long getRevision() {
		long result = 0;

		if (hasLocalSign()) {
			result = localSign.getRevision();
		} else if (revision != -1) {
			result = revision;
		}

		return result;
	}

	public void setLocalSign(SimpleSign localSign) {
		assert localSign != null : "Precondition failed: localSign != null";

		this.localSign = localSign;
		this.signWidth = localSign.getWidth();
	}

	public void setSignWidth(int signWidth) {
		assert signWidth >= 0 : "Precondition failed: signWidth >= 0";

		this.signWidth = signWidth;
	}

	public void setRevision(long revision) {
		if (hasLocalSign()) {
			getLocalSign().setRevision(revision);
		} else {
			this.revision = revision;
		}
	}

	public boolean hasLocalSign() {
		return localSign != null;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((signId == null) ? 0 : signId.hashCode());
		result = prime * result + (localSign == null ? 0 : localSign.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null) {
			return false;
		}
		if (!getClass().equals(obj.getClass())) {
			return false;
		}
		SignItem other = (SignItem) obj;
		if (!Objects.equals(this.signId, other.signId)) {
			return false;
		} else if (!Objects.equals(this.localSign, other.localSign)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "SignItem [signId=" + signId + ", localSign=" + localSign + "]";
	}

	@Deprecated
	protected SignItem() {
	}

	public static int getSignHeight_PX() {

		return SimpleSign.SIGN_HEIGHT_PX;
	}

}
