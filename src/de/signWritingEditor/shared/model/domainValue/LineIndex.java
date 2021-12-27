package de.signWritingEditor.shared.model.domainValue;

public class LineIndex implements Comparable<LineIndex> {
	private final int pageIndex;
	private final int snippetIndex;
	private final int lineIndex;

	public LineIndex(int pageIndex, int lineIndex) {
		this(pageIndex, -1, lineIndex);
	}

	public LineIndex(int pageIndex, int snippetIndex, int lineIndex) {
		assert pageIndex >= 0 : "Precondition failed: pageIndex >= 0";
		assert snippetIndex >= -1 : "Precondition failed: snippetIndex >= -1";
		assert lineIndex >= -1 : "Precondition failed: lineIndex >= 0";

		this.pageIndex = pageIndex;
		this.snippetIndex = snippetIndex;
		this.lineIndex = lineIndex;
	}

	public int getPageIndex() {
		assert pageIndex >= 0 : "Postcondition failed: result >= 0";
		return pageIndex;
	}

	public boolean isCollageLineIndex() {
		return getSnippetIndex() >= 0;
	}

	public int getSnippetIndex() {
		assert snippetIndex >= -1 : "Postcondition failed: result >= -1";
		return snippetIndex;
	}

	public int getLineIndex() {
		assert lineIndex >= 0 : "Postcondition failed: result >= 0";
		return lineIndex;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		final int prime2 = 67;
		final int prime3 = 41;
		return (prime * (lineIndex + 1)) + (prime2 * (pageIndex + 1) + (prime3 * (snippetIndex + 1)));
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!getClass().equals(obj.getClass()))
			return false;
		LineIndex other = (LineIndex) obj;
		if (lineIndex != other.lineIndex)
			return false;
		if (pageIndex != other.pageIndex)
			return false;
		if (snippetIndex != other.snippetIndex)
			return false;
		return true;
	}

	@Override
	public int compareTo(LineIndex otherLineIndex) {
		int result = this.getPageIndex() - otherLineIndex.getPageIndex();
		if (result == 0) {
			result = this.getSnippetIndex() - otherLineIndex.getSnippetIndex();
			if (result == 0) {
				result = this.getLineIndex() - otherLineIndex.getLineIndex();
			}
		}
		return result;
	}

	@Override
	public String toString() {
		return "LineIndex(" + this.pageIndex + "," + this.snippetIndex + "," + this.lineIndex + ")";
	}

}
