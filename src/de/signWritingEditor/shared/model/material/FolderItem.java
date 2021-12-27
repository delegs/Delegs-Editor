package de.signWritingEditor.shared.model.material;

import java.util.Date;

import de.signWritingEditor.shared.model.domainValue.FileItemColorLabel;
import de.signWritingEditor.shared.model.domainValue.FileTitle;
import de.signWritingEditor.shared.model.domainValue.Id;
import de.signWritingEditor.shared.model.domainValue.SortCriteria;

public class FolderItem extends FileItem {

	private static final long serialVersionUID = 8536895892507442487L;

	public static final Id ROOT_FOLDER_ID = new Id(0, 0);
	public static final Id SYSTEM_FOLDER_ID = new Id(0, 1);
	public static final Id PUBLIC_FOLDER_ID = new Id(0, 2);
	public static final Id COPY_CACHE_FOLDER_ID = new Id(0, 3);
	public static final Id SHOWROOM_FOLDER_ID = new Id(0, 4);
	public static final Id QUIZ_FOLDER_ID = new Id(0, 5);
	public SortCriteria currentSortCriteria = SortCriteria.TYPE;

	public FolderItem(Id id, String ownername, FileTitle fileTitle, Date creation, Date change,
			FileItemColorLabel colorLabel, SortCriteria criteria) {
		super(id, ownername, fileTitle, creation, change, colorLabel);
		this.currentSortCriteria = criteria;
	}

	public SortCriteria getCurrentSortCriteria() {
		return currentSortCriteria;
	}

	public void setCurrentSortCriteria(SortCriteria currentSortCriteria) {
		this.currentSortCriteria = currentSortCriteria;
	}

	@Deprecated
	public FolderItem() {
	}
}
