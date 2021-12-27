package de.signWritingEditor.shared.model.material;

import java.util.Date;

import de.signWritingEditor.shared.model.domainValue.FileItemColorLabel;
import de.signWritingEditor.shared.model.domainValue.FileTitle;
import de.signWritingEditor.shared.model.domainValue.Id;

public class DocumentItem extends FileItem {

	private static final long serialVersionUID = -8309557217354861485L;

	public DocumentItem(Id id, String owner, FileTitle fileTitle, Date creation, Date change,
			FileItemColorLabel colorLabel) {
		super(id, owner, fileTitle, creation, change, colorLabel);
	}

	@Deprecated
	protected DocumentItem() {
	}

}
