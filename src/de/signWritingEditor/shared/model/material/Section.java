package de.signWritingEditor.shared.model.material;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;

import de.signWritingEditor.shared.model.domainValue.Id;

public class Section implements Serializable, Template {

	private static final long serialVersionUID = 354182449619877406L;
	private List<Paragraph> paragraphs;
	private boolean isCollage;
	private Id collageId;
	private boolean lockedLayout;
	private boolean lockedContent;

	public Section() {
		this(false, false);
	}

	public Section(boolean lockedLayout, boolean lockedContent) {
		paragraphs = new ArrayList<Paragraph>();
		setIsCollage(false, null);
		this.lockedLayout = lockedLayout;
		this.lockedContent = lockedContent;
	}

	public boolean isEmpty() {
		return paragraphs.isEmpty();
	}

	public int getParagraphCount() {
		int result = paragraphs.size();
		assert result >= 0 : "Postcondition failed: result >= 0";
		return result;
	}

	public Paragraph getParagraph(int index) {
		assert index >= 0 : "Precondition failed: index >= 0";
		assert index < getParagraphCount() : "Precondition failed: index < getParagraphCount()";

		Paragraph result = paragraphs.get(index);

		assert result != null : "result != null";
		return result;
	}

	public void addParagraph(Paragraph paragraph) {
		assert paragraph != null : "Precondition failed: paragraph != null";

		if (!lockedLayout) {
			insertParagraph(paragraph, getParagraphCount());
		}
	}

	/**
	 * @require paragraphIndex >= 0
	 * @require paragraphIndex < getParagraphCount()
	 * @require paragraph != null
	 * @ensure getParagraph(paragraphIndex) == paragraph
	 */
	public void insertParagraph(Paragraph paragraph, int paragraphIndex) {
		assert paragraphIndex >= 0 : "Precondition failed: paragraphIndex >= 0";
		assert paragraphIndex <= getParagraphCount() : "Precondition failed: paragraphIndex <= getParagraphCount()";
		assert paragraph != null : "Precondition failed: paragraph != null";

		if (!lockedLayout) {
			paragraphs.add(paragraphIndex, paragraph);

			assert getParagraph(
					paragraphIndex) == paragraph : "Postcondition failed: getParagraph(paragraphIndex) == paragraph";
		}
	}

	/**
	 * @param paragraphIndex
	 * @require paragraphIndex >= 0
	 * @require paragraphIndex < getParagraphCount()
	 */
	public void removeParagraph(int paragraphIndex) {
		assert paragraphIndex >= 0 : "Precondition failed: paragraphIndex >= 0";
		assert paragraphIndex < getParagraphCount() : "Precondition failed: paragraphIndex < getParagraphCount()";

		if (!lockedLayout) {
			paragraphs.remove(paragraphIndex);
		}
	}

	public void moveParagraphsToSection(Section toSection, int firstParagraphIndex) {
		assert toSection != null : "Precondition failed: toSection != null";
		assert this != toSection : "Precondition failed: this != toSection";
		assert firstParagraphIndex >= 0 : "Precondition failed: paragraphIndex [" + firstParagraphIndex + "] >= 0";
		assert firstParagraphIndex < getParagraphCount() : "Precondition failed: paragraphIndex [" + firstParagraphIndex
				+ "] < getParagraphCount() [" + getParagraphCount() + "]";

		if (!lockedLayout) {
			while (getParagraphCount() > firstParagraphIndex) {
				int lastIndex = getParagraphCount() - 1;
				toSection.insertParagraph(getParagraph(lastIndex), 0);
				removeParagraph(lastIndex);
			}
		}
	}

	public void mergeParagraphWithNext(int paragraphIndex) {
		assert paragraphIndex >= 0 : "Precondition failed: paragraphIndex >= 0";
		assert paragraphIndex < getParagraphCount()
				- 1 : "Precondition failed: paragraphIndex < getParagraphCount() - 1";

		if (!lockedLayout) {
			int nextParagraphIndex = paragraphIndex + 1;
			Paragraph paragraph = getParagraph(paragraphIndex);
			Paragraph nextParagraph = getParagraph(nextParagraphIndex);

			for (int i = 0, size = nextParagraph.getTokenCount(); i < size; i++) {
				paragraph.addToken(nextParagraph.getToken(i));
			}

			removeParagraph(nextParagraphIndex);
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		for (Paragraph paragraph : paragraphs) {
			result = prime * result + ((paragraph == null) ? 0 : paragraph.hashCode());
		}
		return result;
	}

	@Override
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (other == null) {
			return false;
		}
		if (!other.getClass().equals(getClass())) {
			return false;
		}

		Section otherSection = (Section) other;
		if (otherSection.getParagraphCount() != getParagraphCount()) {
			return false;
		}
		for (int i = 0; i < getParagraphCount(); i++) {
			if (!otherSection.getParagraph(i).equals(getParagraph(i))) {
				return false;
			}
		}
		return true;
	}

	public long contentHashCode() {
		final int prime = 31;
		long result = 1;
		for (Paragraph paragraph : paragraphs) {
			result = prime * result + ((paragraph == null) ? 0 : paragraph.contentHashCode());
		}
		return result;
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("section(paragraphs: [\n");

		for (Paragraph paragraph : paragraphs) {
			stringBuilder.append("    ");
			stringBuilder.append(paragraph);
			stringBuilder.append("\n");
		}

		stringBuilder.append("  ])");

		return stringBuilder.toString();
	}

	public void removeToken(int paragraphIndex, int tokenIndex) {
		if (!lockedLayout) {
			getParagraph(paragraphIndex).removeToken(tokenIndex);
		}
	}

	public boolean isCollage() {
		return isCollage;
	}

	public void setIsCollage(boolean isCollage, Id collageId) {
		this.isCollage = isCollage;
		setCollageId(collageId);
	}

	public List<Paragraph> getParagraphs() {
		return Collections.unmodifiableList(paragraphs);
	}

	public Id getCollageId() {
		return collageId;
	}

	private void setCollageId(Id collageId) {
		this.collageId = collageId;
	}

	public Token getFirstTokenInSection() {
		assert paragraphs != null : "Precondition failed: paragraphs != null";

		Token result = null;
		if (paragraphs.size() > 0) {
			result = paragraphs.get(0).getFirstTokenInParagraph();
		}

		return result;
	}

	public Token getLastTokenInSection() {
		assert paragraphs != null : "Precondition failed: paragraphs != null";

		Token result = null;
		if (paragraphs.size() > 0) {
			result = paragraphs.get(paragraphs.size() - 1).getLastTokenInParagraph();
		}

		return result;
	}

	public boolean containsToken(Id currentCursorTokenId) {
		assert currentCursorTokenId != null : "Precondition failed: currentCursorTokenId != null";
		boolean result = false;

		for (int i = 0; i < getParagraphCount() && !result; i++) {
			result = getParagraph(i).containsToken(currentCursorTokenId);
		}

		return result;
	}

	public void sendSelectedParagraphsToFront(LinkedHashSet<Id> selectedIds) {
		List<Paragraph> notSelectedParagraphs = getNotSelectedParagraphs(selectedIds);
		List<Paragraph> selectedParagraphs = getSelectedParagraphs(selectedIds);

		if (!notSelectedParagraphs.isEmpty()) {
			Collections.sort(notSelectedParagraphs, new ParagraphZComparator());
			Collections.sort(selectedParagraphs, new ParagraphZComparator());

			int zIndex = 0;
			for (Paragraph paragraph : notSelectedParagraphs) {
				paragraph.setZIndex(zIndex);
				zIndex++;
			}

			for (Paragraph paragraph : selectedParagraphs) {
				paragraph.setZIndex(zIndex);
				zIndex++;
			}
		}
	}

	public void sendSelectedParagraphsToBack(LinkedHashSet<Id> selectedIds) {
		List<Paragraph> notSelectedParagraphs = getNotSelectedParagraphs(selectedIds);
		List<Paragraph> selectedParagraphs = getSelectedParagraphs(selectedIds);

		if (!notSelectedParagraphs.isEmpty()) {
			Collections.sort(notSelectedParagraphs, new ParagraphZComparator());
			Collections.sort(selectedParagraphs, new ParagraphZComparator());

			int zIndex = 0;
			for (Paragraph paragraph : selectedParagraphs) {
				paragraph.setZIndex(zIndex);
				zIndex++;
			}

			for (Paragraph paragraph : notSelectedParagraphs) {
				paragraph.setZIndex(zIndex);
				zIndex++;
			}

		}
	}

	private List<Paragraph> getSelectedParagraphs(LinkedHashSet<Id> selectedParagraphsIds) {
		List<Paragraph> selectedParagraphs = new ArrayList<Paragraph>();
		for (Paragraph paragraph : this.paragraphs) {
			if (selectedParagraphsIds.contains(paragraph.getParagraphId())) {
				selectedParagraphs.add(paragraph);
			}
		}
		return selectedParagraphs;
	}

	private List<Paragraph> getNotSelectedParagraphs(LinkedHashSet<Id> selectedParagraphsIds) {
		List<Paragraph> notSelectedParagraphs = new ArrayList<Paragraph>();
		for (Paragraph paragraph : this.paragraphs) {
			if (!selectedParagraphsIds.contains(paragraph.getParagraphId())) {
				notSelectedParagraphs.add(paragraph);
			}
		}
		return notSelectedParagraphs;
	}

	private class ParagraphZComparator implements Comparator<Paragraph> {
		@Override
		public int compare(Paragraph o1, Paragraph o2) {
			return Integer.compare(o1.getZIndex(), o2.getZIndex());
		}
	}

	@Override
	public void lockLayout(boolean isLockedLayout) {
		lockedLayout = isLockedLayout;
	}

	@Override
	public boolean isLayoutLocked() {
		return lockedLayout;
	}

	@Override
	public void lockContent(boolean isLockedContent) {
		this.lockedContent = isLockedContent;
	}

	@Override
	public boolean isContentLocked() {
		return lockedContent;
	}
}
