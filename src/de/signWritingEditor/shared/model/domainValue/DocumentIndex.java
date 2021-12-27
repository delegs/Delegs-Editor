package de.signWritingEditor.shared.model.domainValue;

public class DocumentIndex implements Comparable<DocumentIndex> {
	private final int tokenIndex;

	private final ParagraphIndex paragraphIndex;

	public DocumentIndex(int sectionIndex, int paragraphIndex, int tokenIndex) {
		assert sectionIndex >= 0 : "Precondition failed: sectionIndex >= 0";
		assert paragraphIndex >= 0 : "Precondition failed: paragraphIndex >= 0";
		assert tokenIndex >= 0 : "Precondition failed: tokenIndex >= 0";

		this.paragraphIndex = new ParagraphIndex(sectionIndex, paragraphIndex);
		this.tokenIndex = tokenIndex;

		assert getSectionIndex() == sectionIndex : "Postcondition failed: getPageIndex() == sectionIndex";
		assert getParagraphIndex() == paragraphIndex : "Postcondition failed: getLineIndex() == paragraphIndex";
		assert getTokenIndex() == tokenIndex : "Postcondition failed: getBoxIndex() == tokenIndex";
	}

	public int getSectionIndex() {
		return paragraphIndex.getSectionIndex();
	}

	public int getParagraphIndex() {
		return paragraphIndex.getParagraphIndex();
	}

	public int getTokenIndex() {
		return tokenIndex;
	}

	public ParagraphIndex getParagraphIndexObject() {
		return paragraphIndex;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = paragraphIndex.hashCode();
		result = prime * result + tokenIndex;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		boolean result = obj == this;
		if (!result && obj != null && obj instanceof DocumentIndex) {
			DocumentIndex other = (DocumentIndex) obj;

			result = paragraphIndex.equals(other.paragraphIndex) && this.tokenIndex == other.tokenIndex;
		}
		return result;

	}

	@Override
	public int compareTo(DocumentIndex otherDocumentIndex) {
		int result = this.paragraphIndex.compareTo(otherDocumentIndex.paragraphIndex);
		if (result == 0) {
			result = this.getTokenIndex() - otherDocumentIndex.getTokenIndex();
		}
		return result;
	}
}
