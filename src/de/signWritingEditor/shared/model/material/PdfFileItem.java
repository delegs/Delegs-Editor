package de.signWritingEditor.shared.model.material;

import java.util.Date;

import de.signWritingEditor.shared.model.domainValue.FileItemColorLabel;
import de.signWritingEditor.shared.model.domainValue.FileTitle;
import de.signWritingEditor.shared.model.domainValue.Id;

public class PdfFileItem extends DocumentItem {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String path;

	public PdfFileItem(Id id, String owner, FileTitle fileTitle, FileItemColorLabel colorLabel, String path,
			Date createDate, Date changeDate) {
		super(id, owner, fileTitle, createDate, changeDate, colorLabel);
		this.path = path;
	}

	public String getPath() {
		return path;
	}

	@Deprecated
	protected PdfFileItem() {
	}
}