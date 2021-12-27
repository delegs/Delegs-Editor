package de.signWritingEditor.shared.model.material;

import java.io.Serializable;
import java.util.Date;

import de.signWritingEditor.shared.model.domainValue.SignId;

public class SignHistoryItem implements Serializable {

	private static final long serialVersionUID = 8489129337596021337L;

	private SignId signId;
	private String authorname;
	private String comment;
	private Date date;
	private long revision;

	public SignHistoryItem(SignId signId, String authorname, String comment, Date date, long revision) {
		assert signId != null : "Precondition failed: signId != null";
		assert authorname != null : "Precondition failed: authorname != null";
		assert comment != null : "Precondition failed: comment != null";
		assert date != null : "Precondition failed: date != null";

		this.signId = signId;
		this.authorname = authorname;
		this.comment = comment;
		this.date = date;
		this.revision = revision;
	}

	public SignId getSignId() {
		return signId;
	}

	public Date getDate() {
		return date;
	}

	public String getAuthorname() {
		return authorname;
	}

	public String getComment() {
		return comment;
	}

	public long getRevision() {
		return revision;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (revision ^ (revision >>> 32));
		result = prime * result + ((signId == null) ? 0 : signId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!getClass().equals(obj.getClass()))
			return false;
		SignHistoryItem other = (SignHistoryItem) obj;
		if (revision != other.revision)
			return false;
		if (signId == null) {
			if (other.signId != null)
				return false;
		} else if (!signId.equals(other.signId))
			return false;
		if (!comment.equals(other.comment)) {
			return false;
		}
		return true;
	}

	// For serialization only
	@Deprecated
	public SignHistoryItem() {
	}
}
