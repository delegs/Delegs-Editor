package de.signWritingEditor.shared.model.material;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import de.signWritingEditor.shared.model.domainValue.DocumentIndex;
import de.signWritingEditor.shared.model.domainValue.FileTitle;
import de.signWritingEditor.shared.model.domainValue.Id;
import de.signWritingEditor.shared.model.domainValue.PageFormat;
import de.signWritingEditor.shared.model.domainValue.ParagraphIndex;
import de.signWritingEditor.shared.model.domainValue.SignLocale;

public class Document extends AuthoredObject implements Template {

	private static final long serialVersionUID = -1287357448387467408L;

	public static final Float CURRENT_DOCUMENT_VERSION = 1.6f;
	public static final float CURRENT_TEMPLATE_VERSION = 1.3f;
	private static final float NOT_TEMPLATE = -1.0f;
	private float templateVersion;

	private FileTitle fileTitle;
	private List<Section> sections;
	private LocalDictionary localDictionary;
	private PageFormat pageFormat;
	private boolean underlinesVisible;
	private boolean isGlossWritingActive;
	private boolean automaticFreeTextLineEnabled;
	private boolean showCollageGrid;
	private boolean lockedLayout;
	private boolean lockedContent;
	private String templateName;

	public Document(User author, SignLocale signLocale, FileTitle fileTitle, PageFormat pageFormat) {
		super(author, signLocale);
		assert pageFormat != null : "Precondition failed: pageFormat != null";
		assert fileTitle != null : "fileTitle != null";

		this.fileTitle = fileTitle;
		this.sections = new ArrayList<Section>();
		this.localDictionary = new LocalDictionary();
		this.pageFormat = pageFormat;
		this.underlinesVisible = true;
		this.isGlossWritingActive = true;
		this.automaticFreeTextLineEnabled = true;
		this.showCollageGrid = true;
		this.lockedLayout = false;
		this.lockedContent = false;
		this.templateVersion = NOT_TEMPLATE;
		this.templateName = "";
	}

	public PageFormat getPageFormat() {
		return pageFormat;
	}

	public void setPageFormat(PageFormat pageFormat) {
		assert pageFormat != null : "Precondition failed: pageFormat != null";

		this.pageFormat = pageFormat;
	}

	public FileTitle getDocumentTitle() {
		assert fileTitle != null : "Postcondition failed: result != null";

		return fileTitle;
	}

	public void setDocumentTitle(FileTitle fileTitle) {
		assert fileTitle != null : "fileTitle != null";

		this.fileTitle = fileTitle;
	}

	public void setGlossWritingActive(boolean active) {
		isGlossWritingActive = active;
	}

	public boolean isGlossWritingActive() {
		return isGlossWritingActive;
	}

	public boolean isAutomaticFreeTextLineEnabled() {
		return automaticFreeTextLineEnabled;
	}

	public void setAutomaticFreeTextLineEnabled(boolean automaticFreeTextLineEnabled) {
		this.automaticFreeTextLineEnabled = automaticFreeTextLineEnabled;
	}

	public LocalDictionary getLocalDictionary() {
		return localDictionary;
	}

	public void setLocalDictionary(LocalDictionary localDictionary) {
		this.localDictionary = localDictionary;
	}

	public void setUnderlinesVisible(boolean underlinesVisible) {
		if (!lockedLayout) {
			this.underlinesVisible = underlinesVisible;
		} else {
			this.underlinesVisible = false;
		}
	}

	public void setTemplateName(String templateName) {
		if (lockedLayout) {
			this.templateName = templateName;
		}
	}

	public String getTemplateName() {
		return this.templateName;
	}

	public boolean areAllSearchWordLinesVisible() {
		boolean result = true;

		for (int sectionIndex = 0, sectionCount = getSectionCount(); sectionIndex < sectionCount
				&& result; sectionIndex++) {
			for (int paragraphIndex = 0, paragraphCount = getParagraphCount(
					sectionIndex); paragraphIndex < paragraphCount && result; paragraphIndex++) {
				result = getParagraph(sectionIndex, paragraphIndex).isSearchWordLineVisible();
			}
		}

		return result;
	}

	public boolean areAllFreeTextLinesVisible() {
		boolean result = true;

		for (int sectionIndex = 0, sectionCount = getSectionCount(); sectionIndex < sectionCount
				&& result; sectionIndex++) {
			for (int paragraphIndex = 0, paragraphCount = getParagraphCount(
					sectionIndex); paragraphIndex < paragraphCount && result; paragraphIndex++) {
				result = getParagraph(sectionIndex, paragraphIndex).isFreeTextLineVisible();
			}
		}

		return result;
	}

	public boolean areAllSignLinesVisible() {
		boolean result = true;

		for (int sectionIndex = 0, sectionCount = getSectionCount(); sectionIndex < sectionCount
				&& result; sectionIndex++) {
			for (int paragraphIndex = 0, paragraphCount = getParagraphCount(
					sectionIndex); paragraphIndex < paragraphCount && result; paragraphIndex++) {
				result = getParagraph(sectionIndex, paragraphIndex).isSignLineVisible();
			}
		}

		return result;
	}

	public boolean areUnderlinesVisible() {
		return underlinesVisible;
	}

	public boolean isEmpty() {
		return sections.isEmpty();
	}

	public boolean containsToken(Id tokenId) {
		assert tokenId != null : "Precondition failed: tokenId != null";

		boolean result = false;

		for (int sectionIndex = 0, sectionCount = getSectionCount(); sectionIndex < sectionCount
				&& !result; sectionIndex++) {
			for (int paragraphIndex = 0, paragraphCount = getParagraphCount(
					sectionIndex); paragraphIndex < paragraphCount && !result; paragraphIndex++) {
				for (int tokenIndex = 0, tokenCount = getTokenCount(sectionIndex,
						paragraphIndex); tokenIndex < tokenCount && !result; tokenIndex++) {
					result = getToken(sectionIndex, paragraphIndex, tokenIndex).getId().equals(tokenId);
				}
			}
		}

		return result;
	}

	public void insertTokenAfter(Id tokenId, Token token) {
		assert token != null : "Precondition failed: token != null";
		assert tokenId != null : "Precondition failed: tokenId != null";
		assert !containsToken(token.getId()) : "Precondition failed: !containsToken(token.getId())";
		assert containsToken(tokenId) : "Precondition failed: containsToken(tokenId)";

		if (!lockedLayout) {
			DocumentIndex documentIndex = getDocumentIndex(tokenId);

			insertTokenAt(documentIndex.getSectionIndex(), documentIndex.getParagraphIndex(),
					documentIndex.getTokenIndex() + 1, token);
		}
	}

	public void insertTokenBefore(Token token, Id tokenId) {
		assert token != null : "Precondition failed: token != null";
		assert tokenId != null : "Precondition failed: tokenId != null";
		assert !containsToken(token.getId()) : "Precondition failed: !containsToken(token.getId())";
		assert containsToken(tokenId) : "Precondition failed: containsToken(tokenId)";

		if (!lockedLayout) {
			DocumentIndex documentIndex = getDocumentIndex(tokenId);

			insertTokenAt(documentIndex.getSectionIndex(), documentIndex.getParagraphIndex(),
					documentIndex.getTokenIndex(), token);
		}
	}

	public void addToken(Token token) {
		assert token != null : "Precondition failed: token != null";
		assert !containsToken(token.getId()) : "Precondition failed: !containsToken(token.getId())";
		assert getSectionCount() > 0 : "Precondition failed: getSectionCount() > 0";
		assert getParagraphCount(
				getSectionCount() - 1) > 0 : "Precondition failed: getParagraphCount(getSectionCount()-1) > 0";

		if (!lockedLayout) {
			int lastSectionIndex = getSectionCount() - 1;
			int lastParagraphIndex = getParagraphCount(lastSectionIndex) - 1;
			int tokensInLastParagraph = getTokenCount(lastSectionIndex, lastParagraphIndex);

			insertTokenAt(lastSectionIndex, lastParagraphIndex, tokensInLastParagraph, token);
		}
	}

	public Token getToken(int sectionIndex, int paragraphIndex, int tokenIndex) {
		assert paragraphIndex >= 0 : "Precondition failed: paragraphIndex >= 0";
		assert paragraphIndex < getParagraphCount(
				sectionIndex) : "Precondition failed: paragraphIndex < getParagraphCount(sectionIndex)";
		assert sectionIndex >= 0 : "Precondition failed: sectionIndex >= 0";
		assert sectionIndex < getSectionCount() : "Precondition failed: sectionIndex < getSectionCount()";
		assert tokenIndex >= 0 : "Precondition failed: tokenIndex >= 0";
		assert tokenIndex < getTokenCount(sectionIndex,
				paragraphIndex) : "Precondition failed: tokenIndex < getTokenCount(sectionIndex, paragraphIndex)";

		return getParagraph(sectionIndex, paragraphIndex).getToken(tokenIndex);
	}

	public Token getToken(Id tokenId) {
		assert tokenId != null : "Precondition failed: tokenId != null";
		assert containsToken(tokenId) : "Precondition failed: containsToken(tokenId)";

		DocumentIndex documentIndex = getDocumentIndex(tokenId);

		return getToken(documentIndex.getSectionIndex(), documentIndex.getParagraphIndex(),
				documentIndex.getTokenIndex());
	}

	public int getTokenCount(int sectionIndex, int paragraphIndex) {
		assert paragraphIndex >= 0 : "Precondition failed: paragraphIndex >= 0";
		assert paragraphIndex < getParagraphCount(
				sectionIndex) : "Precondition failed: paragraphIndex < getParagraphCount(sectionIndex)";
		assert sectionIndex >= 0 : "Precondition failed: sectionIndex >= 0";
		assert sectionIndex < getSectionCount() : "Precondition failed: sectionIndex < getSectionCount()";

		return getParagraph(sectionIndex, paragraphIndex).getTokenCount();
	}

	public int getTokenCount() {
		int result = 0;
		int sectionCount = getSectionCount();

		for (int s = 0; s < sectionCount; ++s) {
			int paragraphCount = getParagraphCount(s);
			for (int p = 0; p < paragraphCount; ++p) {
				result += getTokenCount(s, p);
			}
		}
		return result;
	}

	public boolean containsParagraph(Id paragraphId) {
		assert paragraphId != null : "Precondition failed: paragraphId != null";

		boolean result = false;

		for (int sectionIndex = 0, sectionCount = getSectionCount(); sectionIndex < sectionCount
				&& !result; sectionIndex++) {
			for (int paragraphIndex = 0, paragraphCount = getParagraphCount(
					sectionIndex); paragraphIndex < paragraphCount && !result; paragraphIndex++) {
				result = getSection(sectionIndex).getParagraph(paragraphIndex).getParagraphId().equals(paragraphId);
			}
		}

		return result;
	}

	public Paragraph getParagraph(Id paragraphId) {
		assert paragraphId != null : "Precondition failed: paragraphId != null";
		assert containsParagraph(paragraphId) : "Precondition failed: containsParagraph(paragraphId)";

		Paragraph result = getParagraph(getParagraphIndex(paragraphId));

		assert result != null : "Postcondition failed: result != null";
		return result;
	}

	public Paragraph getParagraph(int sectionIndex, int paragraphIndex) {
		assert paragraphIndex >= 0 : "Precondition failed: paragraphIndex >= 0";
		assert paragraphIndex < getParagraphCount(
				sectionIndex) : "Precondition failed: paragraphIndex < getParagraphCount(sectionIndex)";
		assert sectionIndex >= 0 : "Precondition failed: sectionIndex >= 0";
		assert sectionIndex < getSectionCount() : "Precondition failed: sectionIndex < getSectionCount()";

		Paragraph paragraph = getSection(sectionIndex).getParagraph(paragraphIndex);

		assert paragraph != null : "Postcondition failed: result != null";
		return paragraph;
	}

	public Paragraph getParagraph(ParagraphIndex paragraphIndex) {
		assert paragraphIndex != null : "Precondition failed: paragraphIndex != null";

		return getParagraph(paragraphIndex.getSectionIndex(), paragraphIndex.getParagraphIndex());
	}

	public ParagraphIndex getParagraphIndex(Id paragraphId) {
		assert paragraphId != null : "Precondition failed: paragraphId != null";
		assert containsParagraph(paragraphId) : "Precondition failed: containsParagraph(paragraphId)";

		ParagraphIndex result = null;

		for (int sectionIndex = 0, sectionCount = getSectionCount(); sectionIndex < sectionCount
				&& result == null; sectionIndex++) {
			for (int paragraphIndex = 0, paragraphCount = getParagraphCount(
					sectionIndex); paragraphIndex < paragraphCount && result == null; paragraphIndex++) {
				if (getSection(sectionIndex).getParagraph(paragraphIndex).getParagraphId().equals(paragraphId)) {
					result = new ParagraphIndex(sectionIndex, paragraphIndex);
				}
			}
		}

		assert result != null : "Postcondition failed: result != null";
		return result;
	}

	public int getParagraphCount(int sectionIndex) {
		assert sectionIndex >= 0 : "Precondition failed: sectionIndex >= 0";
		assert sectionIndex < getSectionCount() : "Precondition failed: sectionIndex < getSectionCount()";

		return getSection(sectionIndex).getParagraphCount();
	}

	public int getSectionCount() {
		int result = sections.size();
		assert result >= 0 : "result >= 0";
		return result;
	}

	public Section getSection(int index) {
		assert index >= 0 : "index >= 0";
		assert index < getSectionCount() : "index < getSectionCount()";

		Section result = sections.get(index);

		assert result != null : "result != null";
		return result;
	}

	public void addSection(Section section) {
		assert section != null : "Precondition failed: section != null";

		if (!lockedLayout) {
			insertSection(section, getSectionCount());
		}
	}

	/**
	 * @require sectionIndex >= 0
	 * @require sectionIndex < getSectionCount()
	 * @require section != null
	 * @ensure getSection(sectionIndex) == section
	 */
	public void insertSection(Section section, int sectionIndex) {
		assert sectionIndex >= 0 : "sectionIndex >= 0";
		assert sectionIndex <= getSectionCount() : "sectionIndex <= getSectionCount()";
		assert section != null : "Precondition failed: section != null";

		if (!lockedLayout) {
			sections.add(sectionIndex, section);

			assert getSection(sectionIndex) == section : "Postcondition failed: getSection(sectionIndex) == section";
		}
	}

	/**
	 * @param sectionIndex
	 * @require sectionIndex >= 0
	 * @require sectionIndex < getSectionCount()
	 */
	public void removeSection(int sectionIndex) {
		assert sectionIndex >= 0 : "sectionIndex >= 0";
		assert sectionIndex < getSectionCount() : "sectionIndex < getSectionCount()";

		if (!lockedLayout) {
			sections.remove(sectionIndex);
		}
	}

	public void mergeSectionWithNext(int sectionIndex) {
		assert sectionIndex >= 0 : "Precondition failed: sectionIndex >= 0";
		assert sectionIndex < getSectionCount() - 1 : "Precondition failed: sectionIndex < getSectionCount() - 1";

		if (!lockedLayout) {
			int nextSectionIndex = sectionIndex + 1;
			Section section = getSection(sectionIndex);
			Section nextSection = getSection(nextSectionIndex);

			for (int i = 0, size = nextSection.getParagraphCount(); i < size; i++) {
				section.addParagraph(nextSection.getParagraph(i));
			}

			removeSection(nextSectionIndex);
		}
	}

	public ParagraphIndex getPreviousParagraphIndex(ParagraphIndex paragraphIndex) {
		assert paragraphIndex != null : "Precondition failed: paragraphIndex != null";
		assert !isFirstParagraphIndex(paragraphIndex) : "Precondition failed: !isFirstParagraphIndex(paragraphIndex)";

		int previousSectionIndex = paragraphIndex.getSectionIndex();
		int previousParagraphIndex = paragraphIndex.getParagraphIndex() - 1;

		if (previousParagraphIndex < 0) {
			previousSectionIndex--;
			previousParagraphIndex = getParagraphCount(previousSectionIndex) - 1;
		}

		return new ParagraphIndex(previousSectionIndex, previousParagraphIndex);
	}

	public ParagraphIndex getNextParagraphIndex(ParagraphIndex paragraphIndex) {
		assert paragraphIndex != null : "Precondition failed: paragraphIndex != null";
		assert !isLastParagraphIndex(paragraphIndex) : "Precondition failed: !isLastParagraphIndex(paragraphIndex)";

		int nextSectionIndex = paragraphIndex.getSectionIndex();
		int nextParagraphIndex = paragraphIndex.getParagraphIndex() + 1;

		if (nextParagraphIndex >= getSection(nextSectionIndex).getParagraphCount()) {
			nextSectionIndex++;
			nextParagraphIndex = 0;
		}

		return new ParagraphIndex(nextSectionIndex, nextParagraphIndex);
	}

	public DocumentIndex getPreviousDocumentIndex(DocumentIndex documentIndex) {
		assert documentIndex != null : "Precondition failed: documentIndex != null";
		assert !isFirstDocumentIndex(documentIndex) : "Precondition failed: !isFirstDocumentIndex(documentIndex)";

		int sectionIndex = documentIndex.getSectionIndex();
		int paragraphIndex = documentIndex.getParagraphIndex();
		int tokenIndex = documentIndex.getTokenIndex() - 1;

		if (tokenIndex < 0) {
			paragraphIndex--;
			if (paragraphIndex < 0) {
				do {
					sectionIndex--;
					paragraphIndex = getParagraphCount(sectionIndex) - 1;
				} while (paragraphIndex < 0 && sectionIndex >= 0);
			}
			tokenIndex = getTokenCount(sectionIndex, paragraphIndex) - 1;
		}

		return new DocumentIndex(sectionIndex, paragraphIndex, tokenIndex);
	}

	public boolean isLastDocumentIndex(DocumentIndex documentIndex) {
		assert documentIndex != null : "Precondition failed: documentIndex != null";

		int lastSectionIndex = getSectionCount() - 1;
		int lastParagraphIndex = getParagraphCount(lastSectionIndex) - 1;
		if (lastParagraphIndex < 0) {
			// If last page is an empty free positioned page
			return documentIndex.getSectionIndex() == lastSectionIndex;
		}

		int lastTokenIndex = getTokenCount(lastSectionIndex, lastParagraphIndex) - 1;
		return documentIndex.getSectionIndex() == lastSectionIndex
				&& documentIndex.getParagraphIndex() == lastParagraphIndex
				&& documentIndex.getTokenIndex() == lastTokenIndex;
	}

	public boolean isFirstDocumentIndex(DocumentIndex documentIndex) {
		assert documentIndex != null : "Precondition failed: documentIndex != null";

		return documentIndex.getSectionIndex() == 0 && documentIndex.getParagraphIndex() == 0
				&& documentIndex.getTokenIndex() == 0;
	}

	public boolean isFirstParagraphIndex(ParagraphIndex paragraphIndex) {
		assert paragraphIndex != null : "Precondition failed: paragraphIndex != null";

		return paragraphIndex.getSectionIndex() == 0 && paragraphIndex.getParagraphIndex() == 0;
	}

	public boolean isLastParagraphIndex(ParagraphIndex paragraphIndex) {
		assert paragraphIndex != null : "Precondition failed: paragraphIndex != null";
		boolean isLastParagraphInDocument = true;

		int paragraphSectionIndex = paragraphIndex.getSectionIndex();
		int lastSectionIndex = getSectionCount() - 1;

		for (int sectionIndex = lastSectionIndex; sectionIndex > paragraphSectionIndex; sectionIndex--) {
			if (getSection(sectionIndex).getParagraphCount() > 0) {
				isLastParagraphInDocument = false;
				break;
			}
		}

		if (getSection(paragraphSectionIndex).getParagraphCount() - 1 > paragraphIndex.getParagraphIndex()) {
			isLastParagraphInDocument = false;
		}
		return isLastParagraphInDocument;
	}

	public DocumentIndex getNextDocumentIndex(DocumentIndex documentIndex) {
		assert documentIndex != null : "Precondition failed: documentIndex != null";
		assert !isLastDocumentIndex(documentIndex) : "Precondition failed: !isLastDocumentIndex(documentIndex)";

		int sectionIndex = documentIndex.getSectionIndex();
		int paragraphIndex = documentIndex.getParagraphIndex();
		int tokenIndex = documentIndex.getTokenIndex() + 1;
		Section section = getSection(sectionIndex);

		if (tokenIndex >= section.getParagraph(paragraphIndex).getTokenCount()) {
			tokenIndex = 0;
			paragraphIndex++;
			if (paragraphIndex >= section.getParagraphCount()) {
				paragraphIndex = 0;
				do {
					sectionIndex++;
					if (sectionIndex >= getSectionCount()) {
						return null;
					}
				} while (getParagraphCount(sectionIndex) <= 0);
			}
		}

		return new DocumentIndex(sectionIndex, paragraphIndex, tokenIndex);
	}

	public DocumentIndex getDocumentIndex(Id tokenId) {
		assert tokenId != null : "Precondition failed: tokenId != null";
		assert containsToken(tokenId) : "Precondition failed: containsToken(tokenId)";

		DocumentIndex result = null;

		for (int sectionIndex = 0, sectionCount = getSectionCount(); sectionIndex < sectionCount
				&& result == null; sectionIndex++) {
			for (int paragraphIndex = 0, paragraphCount = getParagraphCount(
					sectionIndex); paragraphIndex < paragraphCount && result == null; paragraphIndex++) {
				for (int tokenIndex = 0, tokenCount = getTokenCount(sectionIndex,
						paragraphIndex); tokenIndex < tokenCount && result == null; tokenIndex++) {
					if (getToken(sectionIndex, paragraphIndex, tokenIndex).getId().equals(tokenId)) {
						result = new DocumentIndex(sectionIndex, paragraphIndex, tokenIndex);
					}
				}
			}
		}

		assert result != null : "Postcondition failed: result != null";
		return result;
	}

	@Override
	public String toString() {
		StringBuffer result = new StringBuffer();
		result.append("document(title: ");
		result.append(fileTitle.getTitleString());
		result.append(", sections: [\n");
		for (Section section : sections) {
			result.append("  ");
			result.append(section);
			result.append("\n");
		}
		result.append("], pageFormat: " + pageFormat + ", localDictionary: " + localDictionary + ")");
		String s = result.toString();
		try {
			MessageDigest sha1 = MessageDigest.getInstance("SHA");
			byte[] text = s.getBytes("UTF-8");
			byte[] hash = sha1.digest(text);
			char[] hex = new char[40];
			for (int i = 0; i < 20; ++i) {
				hex[2 * i] = "0123456789ABCDEF".charAt((hash[i] >>> 4) & 15);
				hex[2 * i + 1] = "0123456789ABCDEF".charAt(hash[i] & 15);
			}
			return new String(hex) + " %%% " + s;
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			e.printStackTrace();
			return s;
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((fileTitle == null) ? 0 : fileTitle.hashCode());
		result = prime * result + ((pageFormat == null) ? 0 : pageFormat.hashCode());
		result = prime * result + ((localDictionary == null) ? 0 : localDictionary.hashCode());
		for (Section section : sections) {
			result = prime * result + ((section == null) ? 0 : section.hashCode());
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
		Document otherDocument = (Document) other;
		if (!otherDocument.getDocumentTitle().equals(getDocumentTitle())) {
			return false;
		}
		if (!otherDocument.getPageFormat().equals(this.getPageFormat())) {
			return false;
		}
		if (!otherDocument.getLocalDictionary().equals(this.getLocalDictionary())) {
			return false;
		}
		if (otherDocument.getSectionCount() != getSectionCount()) {
			return false;
		}
		for (int i = 0; i < getSectionCount(); i++) {
			if (!otherDocument.getSection(i).equals(getSection(i))) {
				return false;
			}
		}
		return true;
	}

	public long contentHashCode() {
		final int prime = 31;
		long result = super.hashCode();
		result = prime * result + ((fileTitle == null) ? 0 : fileTitle.hashCode());
		result = prime * result + ((pageFormat == null) ? 0 : pageFormat.hashCode());
		result = prime * result + ((localDictionary == null) ? 0 : localDictionary.hashCode());
		for (Section section : sections) {
			result = prime * result + ((section == null) ? 0 : section.contentHashCode());
		}
		return result;
	}

	protected void insertTokenAt(int sectionIndex, int paragraphIndex, int tokenIndex, Token token) {
		assert token != null : "Precondition failed: token != null";
		assert !containsToken(token.getId()) : "Precondition failed: !containsToken(token.getId())";
		assert sectionIndex >= 0 : "Precondition failed: sectionIndex >= 0";
		assert sectionIndex < getSectionCount() : "Precondition failed: sectionIndex < getSectionCount()";
		assert paragraphIndex >= 0 : "Precondition failed: paragraphIndex >= 0";
		assert paragraphIndex < getParagraphCount(
				sectionIndex) : "Precondition failed: paragraphIndex < getParagraphCount(sectionIndex)";
		assert tokenIndex >= 0 : "Precondition failed: tokenIndex >= 0";
		assert tokenIndex <= getTokenCount(sectionIndex,
				paragraphIndex) : "Precondition failed: tokenIndex <= getTokenCount(sectionIndex, paragraphIndex)";

		if (!lockedLayout) {
			getParagraph(sectionIndex, paragraphIndex).insertToken(token, tokenIndex);
		}
	}

	/**
	 * For GWT serialization only.
	 */
	@Deprecated
	protected Document() {
	}

	public Paragraph findParagraphForToken(Id tokenId) {

		Paragraph result = null;

		for (Section currentSection : this.sections) {
			for (int paragraphIndex = 0; paragraphIndex < currentSection.getParagraphCount(); paragraphIndex++) {
				Paragraph currentParagraph = currentSection.getParagraph(paragraphIndex);
				for (int tokenIndex = 0; tokenIndex < currentParagraph.getTokenCount(); tokenIndex++) {
					if (tokenId.equals(currentParagraph.getToken(tokenIndex).getId())) {
						result = currentParagraph;
					}
				}
			}
		}

		assert result != null : "Postcondition failed: result!= null";
		return result;
	}

	public void removeToken(DocumentIndex index) {
		if (!lockedLayout) {
			getSection(index.getSectionIndex()).removeToken(index.getParagraphIndex(), index.getTokenIndex());
		}
	}

	public void removeToken(Id tokenId) {
		if (!lockedLayout) {
			removeToken(this.getDocumentIndex(tokenId));
		}
	}

	public Token getFirstTokenInDocument() {
		return getToken(0, 0, 0);
	}

	public Token getLastTokenInDocument() {
		int lastSectionIndex = getSectionCount() - 1;
		int lastParagraphIndex = getParagraphCount(lastSectionIndex) - 1;
		int lastTokenIndex = getTokenCount(lastSectionIndex, lastParagraphIndex) - 1;
		return getToken(lastSectionIndex, lastParagraphIndex, lastTokenIndex);
	}

	public int getSectionIndexForCollageId(Id collageId) {

		for (int i = 0; i < getSectionCount(); i++) {
			if (collageId.equals(getSection(i).getCollageId())) {
				return i;
			}
		}

		return -1;
	}

	public Token getToken(DocumentIndex documentIndex) {
		return getToken(documentIndex.getSectionIndex(), documentIndex.getParagraphIndex(),
				documentIndex.getTokenIndex());
	}

	public List<Token> getTokensFromTo(Id from, Id to) {
		assert from != null : "Precondition failed: from != null";
		assert to != null : "Precondition failed: to != null";
		assert containsToken(from) : "Precondition failed: containsToken(from)";
		assert containsToken(to) : "Precondition failed: containsToken(to)";

		List<Token> result = new ArrayList<Token>();

		DocumentIndex leftIndex = getDocumentIndex(from);
		DocumentIndex rightIndex = getDocumentIndex(to);

		if (leftIndex.compareTo(rightIndex) > 0) {
			DocumentIndex tempIndex = rightIndex;
			rightIndex = leftIndex;
			leftIndex = tempIndex;
		}

		int rightSectionIndex = rightIndex.getSectionIndex();
		int rightParagraphIndex = rightIndex.getParagraphIndex();

		while (leftIndex.compareTo(rightIndex) < 0) {
			int leftSectionIndex = leftIndex.getSectionIndex();
			int leftParagraphIndex = leftIndex.getParagraphIndex();

			boolean takeAllTokensInParagraphInTheLastSection = leftSectionIndex == rightSectionIndex
					&& leftParagraphIndex < rightParagraphIndex;
			boolean takeAllTokensInSection = leftSectionIndex < rightSectionIndex;
			boolean isFirstTokenInParagraphIndex = leftIndex.getTokenIndex() == 0;
			boolean takeWholeParagraph = isFirstTokenInParagraphIndex
					&& (takeAllTokensInParagraphInTheLastSection || takeAllTokensInSection);

			if (takeWholeParagraph) {
				result.addAll(getParagraph(leftSectionIndex, leftParagraphIndex).getTokens());
				if (leftParagraphIndex < getSection(leftSectionIndex).getParagraphCount() - 1) {
					leftIndex = new DocumentIndex(leftSectionIndex, leftParagraphIndex + 1, 0);
				} else {
					leftIndex = new DocumentIndex(leftSectionIndex + 1, 0, 0);
				}
			} else {
				result.add(getToken(leftIndex));
				leftIndex = getNextDocumentIndex(leftIndex);
			}
		}
		result.add(getToken(leftIndex));

		assert result != null : "Postcondition failed: result != null";
		assert result.size() > 0 : "Postcondition failed: result.size()>0";
		return result;
	}

	public boolean isTokenBetween(Id tokenId, Id startTokenId, Id endTokenId) {
		boolean result = false;
		DocumentIndex leftSelectionIndex = getDocumentIndex(startTokenId);
		DocumentIndex rightSelectionIndex = getDocumentIndex(startTokenId);
		if (leftSelectionIndex.compareTo(rightSelectionIndex) > 0) {
			DocumentIndex temp = leftSelectionIndex;
			leftSelectionIndex = rightSelectionIndex;
			rightSelectionIndex = temp;
		}
		DocumentIndex tokenIndex = getDocumentIndex(startTokenId);
		if (leftSelectionIndex.compareTo(tokenIndex) <= 0 && rightSelectionIndex.compareTo(tokenIndex) >= 0) {
			result = true;
		}
		return result;
	}

	public boolean isOnlyTokenInParagraph(Id tokenId) {
		DocumentIndex tokenIndex = getDocumentIndex(tokenId);
		return !(getParagraph(tokenIndex.getSectionIndex(), tokenIndex.getParagraphIndex()).getTokenCount() > 1);
	}

	public void setCollageGridVisibility(boolean showGrid) {
		this.showCollageGrid = showGrid;
	}

	public boolean showCollageGrid() {
		return this.showCollageGrid;
	}

	public List<Id> getAllCollageIds() {
		List<Id> result = new ArrayList<Id>();

		for (Section section : sections) {
			if (section.isCollage()) {
				result.add(section.getCollageId());
			}
		}

		return result;
	}

	public boolean hasCollage() {
		boolean result = false;
		for (Section section : sections) {
			if (section.isCollage()) {
				result = true;
				break;
			}
		}
		return result;
	}

	@Override
	public void lockLayout(boolean isLockedLayout) {
		lockedLayout = isLockedLayout;
		this.templateVersion = isLockedLayout ? templateVersion : NOT_TEMPLATE;
	}

	public void setTemplateVersion(float templateVersion) {
		assert templateVersion > NOT_TEMPLATE : "Precondition failed: templateVersion > NOT_TEMPLATE";
		assert templateVersion <= CURRENT_TEMPLATE_VERSION : "Precondition failed: templateVersion <= CURRENT_TEMPLATE_VERSION";
		this.templateVersion = templateVersion;
	}

	public Float getTemplateVersion() {
		return templateVersion;
	}

	@Override
	public boolean isLayoutLocked() {
		return lockedLayout;
	}

	@Override
	public void lockContent(boolean isLockedContent) {
		this.lockedContent = isLockedContent;
		setUnderlinesVisible(!isLockedContent);
	}

	@Override
	public boolean isContentLocked() {
		return lockedContent;
	}

	public List<Token> getAllTokens() {
		return getTokensFromTo(getFirstTokenInDocument().getId(), getLastTokenInDocument().getId());
	}

	public Boolean isValid() {
		return getAllTokens().stream()//
				.filter(token -> token instanceof FormToken)//
				.allMatch(token -> ((FormToken) token).hasValidContent());
	}

}