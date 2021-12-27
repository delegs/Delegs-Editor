package de.signWritingEditor.shared.model.domainValue;

public class BoxIndex implements Comparable<BoxIndex> {
	private final int pageIndex;
	private final int snippetIndex;
	private final int lineIndex;
	private final int boxIndex;

	public BoxIndex(int pageIndex, int lineIndex, int boxIndex) {
		assert pageIndex >= 0 : "Precondition failed: pageIndex >= 0";
		assert lineIndex >= 0 : "Precondition failed: lineIndex >= 0";
		assert boxIndex >= 0 : "Precondition failed: boxIndex >= 0";

		this.pageIndex = pageIndex;
		this.snippetIndex = -1;
		this.lineIndex = lineIndex;
		this.boxIndex = boxIndex;
	}

	public BoxIndex(int pageIndex, int snippetIndex, int lineIndex, int boxIndex) {
		assert pageIndex >= 0 : "Precondition failed: pageIndex >= 0";
		assert snippetIndex >= 0 : "Precondition failed: snippetIndex >= 0";
		assert lineIndex >= 0 : "Precondition failed: lineIndex >= 0";
		assert boxIndex >= 0 : "Precondition failed: boxIndex >= 0";

		this.pageIndex = pageIndex;
		this.snippetIndex = snippetIndex;
		this.lineIndex = lineIndex;
		this.boxIndex = boxIndex;
	}

	public BoxIndex(LineIndex lineIndex, int boxIndex) {
		assert lineIndex != null : "Precondition failed: lineIndex != null";
		assert boxIndex >= 0 : "Precondition failed: boxIndex >= 0";

		this.pageIndex = lineIndex.getPageIndex();
		this.snippetIndex = lineIndex.getSnippetIndex();
		this.lineIndex = lineIndex.getLineIndex();
		this.boxIndex = boxIndex;
	}

	public int getSnippetIndex() {
		return snippetIndex;
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public int getLineIndex() {
		return lineIndex;
	}

	public int getBoxIndex() {
		return boxIndex;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + boxIndex;
		result = prime * result + lineIndex;
		result = prime * result + pageIndex;
		result = prime * result + snippetIndex;
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
		BoxIndex other = (BoxIndex) obj;
		if (boxIndex != other.boxIndex)
			return false;
		if (lineIndex != other.lineIndex)
			return false;
		if (pageIndex != other.pageIndex)
			return false;
		if (snippetIndex != other.snippetIndex)
			return false;
		return true;
	}

	@Override
	public int compareTo(BoxIndex otherBoxIndex) {
		int result = Integer.compare(pageIndex, otherBoxIndex.getPageIndex());
		if (result == 0) {
			result = Integer.compare(snippetIndex, otherBoxIndex.getSnippetIndex());
			if (result == 0) {
				result = Integer.compare(lineIndex, otherBoxIndex.getLineIndex());
				if (result == 0) {
					result = Integer.compare(boxIndex, otherBoxIndex.getBoxIndex());
				}
			}
		}
		return result;
	}

	public static BoxIndex MAX(BoxIndex left, BoxIndex right) {
		assert left != null : "Precondition failed: left != null";
		assert right != null : "Precondition failed: right != null";
		return (left.compareTo(right) > 0) ? left : right;
	}

	public static BoxIndex MIN(BoxIndex left, BoxIndex right) {
		assert left != null : "Precondition failed: left != null";
		assert right != null : "Precondition failed: right != null";
		return (left.compareTo(right) < 0) ? left : right;
	}

	public boolean isCollageBoxIndex() {
		return snippetIndex >= 0;
	}

	public LineIndex getLineIndexObject() {
		LineIndex lineIndexObject;
		if (snippetIndex >= 0) {
			lineIndexObject = new LineIndex(pageIndex, snippetIndex, lineIndex);
		} else {
			lineIndexObject = new LineIndex(pageIndex, lineIndex);
		}
		return lineIndexObject;
	}

}