package de.signWritingEditor.shared.model.material;

import java.io.Serializable;
import java.util.Date;

import de.signWritingEditor.shared.model.domainValue.FileItemColorLabel;
import de.signWritingEditor.shared.model.domainValue.FileTitle;
import de.signWritingEditor.shared.model.domainValue.Id;

public class FileItem implements Serializable, Cloneable {

	private static final long serialVersionUID = 4960519428661646832L;

	private Id id;
	protected String owner;
	protected FileTitle fileTitle;
	protected Date creationDate;
	protected Date changeDate;
	private FileItemColorLabel colorLabel;

	public FileItem(Id id, String owner, FileTitle fileTitle, Date creation, Date change,
			FileItemColorLabel colorLabel) {
		assert id != null : "Precondition failed: id != null";
		assert owner != null : "Precondition failed: owner != null";
		assert fileTitle != null : "Precondition failed: fileTitle != null";
		assert creation != null : "Precondition failed: creation != null";
		assert change != null : "Precondition failed: change != null";
		assert colorLabel != null : "Precondition failed: colorLabel != null";

		this.id = id;
		this.owner = owner;
		this.fileTitle = fileTitle;
		this.creationDate = creation;
		this.changeDate = change;
		this.colorLabel = colorLabel;
	}

	@Deprecated
	public FileItem() {
	}

	public Id getId() {
		assert id != null : "Postcondition failed: result != null";
		return id;
	}

	public String getOwner() {
		assert owner != null : "Postcondition failed: result != null";
		return owner;
	}

	public FileTitle getFileTitle() {
		assert fileTitle != null : "Postcondition failed: result != null";
		return fileTitle;
	}

	public Date getCreationDate() {
		assert creationDate != null : "Postcondition failed: result != null";
		return creationDate;
	}

	public Date getChangeDate() {
		assert changeDate != null : "Postcondition failed: result != null";
		return changeDate;
	}

	public FileItemColorLabel getColorLabel() {
		assert colorLabel != null : "Postcondition failed: result != null";
		return colorLabel;
	}

	@Override
	public int hashCode() {
		return id.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		boolean result = obj == this;
		if (!result && obj != null && obj instanceof FileItem) {
			FileItem other = (FileItem) obj;

			result = this.id.equals(other.id);
		}

		return result;
	}

	@Override
	public String toString() {
		return "FileItem [id=" + id + ", fileTitle=" + fileTitle + ", owner=" + owner + "]";
	}

	public void setChangeDate(Date changeDate) {
		this.changeDate = changeDate;
	}

}