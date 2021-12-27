package de.signWritingEditor.shared.model.domainValue;

import java.io.Serializable;
import java.util.List;

import de.signWritingEditor.shared.model.material.FileItem;
import de.signWritingEditor.shared.model.material.FolderItem;

public class FolderContentAndPath implements Serializable {
	private static final long serialVersionUID = -1097886083167793148L;

	private List<FolderItem> folderPath;
	private List<FileItem> fileItemsInFolder;

	public FolderContentAndPath(List<FolderItem> folderPath, List<FileItem> fileItemsInFolder) {
		assert fileItemsInFolder != null : "Precondition failed: fileItemsInFolder != null";
		assert folderPath != null : "Precondition failed: folderPath != null";

		this.folderPath = folderPath;
		this.fileItemsInFolder = fileItemsInFolder;
	}

	public List<FolderItem> getFolderPath() {
		return folderPath;
	}

	public List<FileItem> getFileItemsInFolder() {
		return fileItemsInFolder;
	}

	@Deprecated
	protected FolderContentAndPath() {
	}
}
