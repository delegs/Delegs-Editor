package de.signWritingEditor.client.service;

import java.util.Comparator;

import de.signWritingEditor.client.GWTClient.ui.general.textHandling.UniversalLocaleCollator;
import de.signWritingEditor.shared.model.domainValue.SortCriteria;
import de.signWritingEditor.shared.model.material.DocumentItem;
import de.signWritingEditor.shared.model.material.FileItem;
import de.signWritingEditor.shared.model.material.FolderItem;
import de.signWritingEditor.shared.model.material.RecycleBinItem;
import de.signWritingEditor.shared.model.material.RoomItem;
import de.signWritingEditor.shared.model.material.TemplateItem;

public class FileItemComparator implements Comparator<FileItem> {

	SortCriteria criteria;

	public FileItemComparator(SortCriteria criteria) {
		this.criteria = criteria;
	}

	@Override
	public int compare(FileItem o1, FileItem o2) {

		if (compareType(o1, o2) == 0) {
			switch (criteria) {
			case FILE_TITLE:
				return compareFileTitle(o1, o2);
			case AUTHOR:
				return compareAuthor(o1, o2);
			case CREATION_DATE:
				return compareCreationDate(o1, o2);
			case CHANGE_DATE:
				return compareChangeDate(o1, o2);
			case COLOR:
				return compareColor(o1, o2);
			default:
				return compareType(o1, o2);
			}
		} else {
			return compareType(o1, o2);
		}
	}

	private int compareColor(FileItem o1, FileItem o2) {
		switch (o1.getColorLabel().toString()) {
		case "GREEN":
			if (o2.getColorLabel().toString().equals("GREEN")) {
				return 0;
			} else {
				return 1;
			}

		case "YELLOW":
			if (o2.getColorLabel().toString().equals("GREEN")) {
				return -1;
			} else if (o2.getColorLabel().toString().equals("YELLOW")) {
				return 0;
			} else {
				return 1;
			}

		case "BLUE":
			if (o2.getColorLabel().toString().equals("GREEN") || o2.getColorLabel().toString().equals("YELLOW")) {
				return -1;
			} else if (o2.getColorLabel().toString().equals("BLUE")) {
				return 0;
			} else {
				return 1;
			}
		case "RED":
			if (o2.getColorLabel().toString().equals("GREEN") || o2.getColorLabel().toString().equals("YELLOW")
					|| o2.getColorLabel().toString().equals("BLUE")) {
				return -1;
			} else if (o2.getColorLabel().toString().equals("RED")) {
				return 0;
			} else {
				return 1;
			}
		default:
			if (o2.getColorLabel().toString().equals("NONE")) {
				return 0;
			} else {
				return -1;
			}
		}
	}

	private int compareChangeDate(FileItem o1, FileItem o2) {
		return o1.getChangeDate().compareTo(o2.getChangeDate());
	}

	private int compareCreationDate(FileItem o1, FileItem o2) {
		return o1.getCreationDate().compareTo(o2.getCreationDate());
	}

	private int compareFileTitle(FileItem o1, FileItem o2) {
		return UniversalLocaleCollator.compareTo(o1.getFileTitle().getTitleString(),
				o2.getFileTitle().getTitleString());
	}

	private int compareAuthor(FileItem o1, FileItem o2) {
		return o1.getOwner().compareToIgnoreCase(o2.getOwner());
	}

	private int compareType(FileItem o1, FileItem o2) {
		int result = 0;

		if (o1 instanceof RecycleBinItem) {
			result -= 8;
		} else if (o1 instanceof RoomItem) {
			if (o1.getId().equals(FolderItem.PUBLIC_FOLDER_ID)) {
				result -= 7;
			} else if (o1.getId().equals(FolderItem.SHOWROOM_FOLDER_ID)) {
				result -= 6;
			} else {
				result -= 5;
			}
		} else if (o1 instanceof FolderItem) {
			result -= 4;
		} else if (o1 instanceof TemplateItem) {
			if (!((TemplateItem) o1).isValid()) {
				result -= 3;
			} else {
				result -= 2;
			}
		} else if (o1 instanceof DocumentItem) {
			result -= 1;
		}

		if (o2 instanceof RecycleBinItem) {
			result += 8;
		} else if (o2 instanceof RoomItem) {
			if (o2.getId().equals(FolderItem.PUBLIC_FOLDER_ID)) {
				result += 7;
			} else if (o2.getId().equals(FolderItem.SHOWROOM_FOLDER_ID)) {
				result += 6;
			} else {
				result += 5;
			}
		} else if (o2 instanceof FolderItem) {
			result += 4;
		} else if (o2 instanceof TemplateItem) {
			if (!((TemplateItem) o2).isValid()) {
				result += 3;
			} else {
				result += 2;
			}
		} else if (o2 instanceof DocumentItem) {
			result += 1;
		}

		return result;
	}
}
