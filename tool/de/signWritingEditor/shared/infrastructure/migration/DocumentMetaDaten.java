package de.signWritingEditor.shared.infrastructure.migration;

import de.signWritingEditor.shared.model.domainValue.FileItemColorLabel;
import de.signWritingEditor.shared.model.domainValue.Id;

public class DocumentMetaDaten {
	private String title;
	private String author;
	private Id id;
	private FileItemColorLabel color;

	public DocumentMetaDaten(String title, String author, long upperId, long lowerId, String color) {
		this.title = title;
		this.author = author;
		this.id = new Id(upperId, lowerId);
		this.color = FileItemColorLabel.valueOf(color);
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public Id getId() {
		return id;
	}

	public FileItemColorLabel getColor() {
		return color;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof DocumentMetaDaten) {
			DocumentMetaDaten that = (DocumentMetaDaten) obj;
			return this.author.equals(that.author) && this.color.equals(that.color) && this.id.equals(that.id)
					&& this.title.equals(that.title);
		}
		return false;
	}
}
