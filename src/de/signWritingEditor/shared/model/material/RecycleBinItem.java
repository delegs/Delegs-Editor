package de.signWritingEditor.shared.model.material;

import java.util.Date;

import de.signWritingEditor.shared.model.domainValue.FileItemColorLabel;
import de.signWritingEditor.shared.model.domainValue.FileTitle;
import de.signWritingEditor.shared.model.domainValue.Id;
import de.signWritingEditor.shared.model.domainValue.SortCriteria;

public class RecycleBinItem extends FolderItem {

	private static final long serialVersionUID = -8914401562343916808L;

	public RecycleBinItem(Id id, String owner, FileTitle fileTitle, Date creation, Date change) {
		super(id, owner, fileTitle, creation, change, FileItemColorLabel.NONE, SortCriteria.TYPE);
	}

	@Deprecated
	public RecycleBinItem() {
	}
}
