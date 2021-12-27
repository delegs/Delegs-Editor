package de.signWritingEditor.shared.model.domainValue;

public class ParagraphIndex implements Comparable<ParagraphIndex> {
	private final int sectionIndex;
	private final int paragraphIndex;

	public ParagraphIndex(int sectionIndex, int paragraphIndex) {
		assert sectionIndex >= 0 : "Precondition failed: sectionIndex >= 0";
		assert paragraphIndex >= 0 : "Precondition failed: paragraphIndex >= 0";

		this.sectionIndex = sectionIndex;
		this.paragraphIndex = paragraphIndex;

		assert getSectionIndex() == sectionIndex : "Postcondition failed: getPageIndex() == sectionIndex";
		assert getParagraphIndex() == paragraphIndex : "Postcondition failed: getLineIndex() == paragraphIndex";
	}

	public int getSectionIndex() {
		return sectionIndex;
	}

	public int getParagraphIndex() {
		return paragraphIndex;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + paragraphIndex;
		result = prime * result + sectionIndex;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		boolean result = obj == this;
		if (!result && obj != null && obj instanceof ParagraphIndex) {
			ParagraphIndex other = (ParagraphIndex) obj;

			result = this.sectionIndex == other.sectionIndex && this.paragraphIndex == other.paragraphIndex;
		}
		return result;

	}

	@Override
	public int compareTo(ParagraphIndex otherDocumentIndex) {
		int result = this.getSectionIndex() - otherDocumentIndex.getSectionIndex();
		if (result == 0) {
			result = this.getParagraphIndex() - otherDocumentIndex.getParagraphIndex();
		}
		return result;
	}
}
