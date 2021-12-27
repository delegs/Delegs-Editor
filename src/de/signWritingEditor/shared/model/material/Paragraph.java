package de.signWritingEditor.shared.model.material;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import de.signWritingEditor.shared.model.domainValue.Id;

public class Paragraph implements Serializable, Template {

	private static final long serialVersionUID = 5667182802895137288L;

	private Id paragraphId;

	private List<Token> tokens;
	private boolean isFreeTextLineVisible;
	private boolean isSearchWordsLineVisible;
	private boolean isSignLineVisible;
	private int width;
	// position of left upper corner
	private int positionX;
	private int positionY;

	private boolean automaticResize;
	private int zIndex;

	private boolean lockedLayout;
	private boolean lockedContent;

	public Paragraph(Id paragraphId, int width, int positionX, int positionY, int zIndex) {
		this(paragraphId, width, positionX, positionY, zIndex, false, false);
	}

	public Paragraph(Id paragraphId, int width, int positionX, int positionY, int zIndex, boolean lockedLayout,
			boolean lockedContent) {
		this(paragraphId);
		this.width = width;
		this.positionX = positionX;
		this.positionY = positionY;
		this.zIndex = zIndex;
		setAutomaticResizeActive(true);
		this.lockedLayout = lockedLayout;
		this.lockedContent = lockedContent;
	}

	public Paragraph(Id paragraphId) {
		assert paragraphId != null : "Precondition failed: paragraphId != null";

		this.paragraphId = paragraphId;

		tokens = new ArrayList<Token>();

		isSearchWordsLineVisible = true;
		isFreeTextLineVisible = true;
		isSignLineVisible = true;
		zIndex = 0;
	}

	public Id getParagraphId() {
		return paragraphId;
	}

	public boolean isSearchWordLineVisible() {
		return isSearchWordsLineVisible;
	}

	public void setSearchWordLineVisible(boolean searchWordsRowVisible) {
		this.isSearchWordsLineVisible = searchWordsRowVisible;
		assert isSearchWordLineVisible() == searchWordsRowVisible : "Postcondition failed: isSearchWordsRowVisible() == searchWordsRowVisible";
	}

	public void setSignLineVisible(boolean visible) {
		this.isSignLineVisible = visible;
		assert isSignLineVisible() == isSignLineVisible : "Postcondition failed: isSearchWordsRowVisible() == searchWordsRowVisible";
	}

	public boolean isSignLineVisible() {
		return isSignLineVisible;
	}

	public boolean isFreeTextLineVisible() {
		return isFreeTextLineVisible;
	}

	public void setFreeTextLineVisible(boolean freeTextLineVisible) {
		this.isFreeTextLineVisible = freeTextLineVisible;
		assert isFreeTextLineVisible() == freeTextLineVisible : "Postcondition failed: isFreeTextLineVisible() == freeTextLineVisible";
	}

	public int getTokenCount() {
		int result = tokens.size();
		assert result >= 0 : "result >= 0";
		return result;
	}

	public List<Token> getTokens() {
		return Collections.unmodifiableList(tokens);
	}

	public Token getToken(int index) {
		assert index >= 0 : "index >= 0";
		assert index < getTokenCount() : "index < getTokenCount()";

		Token result = tokens.get(index);

		assert result != null : "result != null";
		return result;
	}

	public void addToken(Token token) {
		assert token != null : "token != null";
		if (!lockedLayout) {
			insertToken(token, getTokenCount());
		}
	}

	public void insertToken(Token token, int index) {
		assert token != null : "Precondition failed: token != null";
		assert index >= 0 : "Precondition failed: index >= 0";
		assert index <= getTokenCount() : "Precondition failed: index[" + index + "] <= getTokenCount()["
				+ getTokenCount() + "] ";

		if (!lockedLayout) {
			tokens.add(index, token);
		}
	}

	public void insertTokens(List<Token> tokensToInsert, int index) {
		assert tokensToInsert != null : "Precondition failed: tokensToInsert != null";
		assert !tokensToInsert.isEmpty() : "Precondition failed: !tokensToInsert.isEmpty()";
		assert index >= 0 : "Precondition failed: index [" + index + "] >= 0";
		assert index <= getTokenCount() : "Precondition failed: index [" + index + "] <= getTokenCount() ["
				+ getTokenCount() + "]";

		if (!lockedLayout) {
			tokens.addAll(index, tokensToInsert);
		}
	}

	public void removeToken(int index) {
		assert index >= 0 : "Precondition failed: index >= 0";
		assert index < getTokenCount() : "Precondition failed: index < getTokenCount()";

		if (!(lockedLayout || tokens.get(index).isLayoutLocked())) {
			tokens.remove(index);
		}
	}

	public void moveTokensToParagraph(Paragraph toParagraph, int firstTokenIndex) {
		assert toParagraph != null : "Precondition failed: toParagraph != null";
		assert firstTokenIndex >= 0 : "Precondition failed: tokenIndex [" + firstTokenIndex + "] >= 0";
		assert firstTokenIndex < getTokenCount() : "Precondition failed: tokenIndex [" + firstTokenIndex
				+ "] < getTokenCount() [" + getTokenCount() + "]";

		if (!lockedLayout) {
			while (getTokenCount() > firstTokenIndex) {
				int lastIndex = getTokenCount() - 1;
				toParagraph.insertToken(getToken(lastIndex), 0);
				removeToken(lastIndex);
			}
		}
	}

	public boolean isEmpty() {
		return tokens.isEmpty();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		for (Token token : tokens) {
			result = prime * result + ((token == null) ? 0 : token.hashCode());
		}
		result = prime * result + (isFreeTextLineVisible ? 1 : 2);
		result = prime * result + (isSearchWordsLineVisible ? 1 : 2);
		result = prime * result + (isSignLineVisible ? 1 : 2);
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
		Paragraph otherParagraph = (Paragraph) other;

		if (otherParagraph.isFreeTextLineVisible() != isFreeTextLineVisible()) {
			return false;
		}
		if (otherParagraph.isSearchWordLineVisible() != isSearchWordLineVisible()) {
			return false;
		}
		if (otherParagraph.getTokenCount() != getTokenCount()) {
			return false;
		}
		for (int i = 0, n = getTokenCount(); i < n; i++) {
			if (!otherParagraph.getToken(i).equals(getToken(i))) {
				String tokenKind;
				if (getToken(i) instanceof ImageToken) {
					tokenKind = "ImageToken";
				} else if (getToken(i) instanceof VideoToken) {
					tokenKind = "VideoToken";
				} else if (getToken(i) instanceof FreeTextToken) {
					tokenKind = "FreeTextToken";
				} else if (getToken(i) instanceof SignItemToken) {
					tokenKind = "SignItemToken";
				} else if (getToken(i) instanceof FrameToken) {
					tokenKind = "FrameToken";
				} else {
					tokenKind = "unknown Token";
				}

				return false;
			}
		}

		return true;
	}

	public long contentHashCode() {
		final int prime = 31;
		long result = 1;
		for (Token token : tokens) {
			result = prime * result + ((token == null) ? 0 : token.contentHashCode());
		}
		result = prime * result + (isFreeTextLineVisible ? 1 : 2);
		result = prime * result + (isSearchWordsLineVisible ? 1 : 2);
		result = prime * result + (isSignLineVisible ? 1 : 2);
		return result;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getPositionX() {
		return positionX;
	}

	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}

	public int getPositionY() {
		return positionY;
	}

	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}

	@Override
	public String toString() {
		return "paragraph(id: " + paragraphId + ", tokens: " + tokens + "\")";
	}

	public void setAutomaticResizeActive(boolean activate) {
		this.automaticResize = activate;
	}

	public boolean isAutomaticResize() {
		return automaticResize;
	}

	/**
	 * Serializer only!
	 */
	@Deprecated
	protected Paragraph() {
	}

	public int getZIndex() {
		return zIndex;
	}

	public void setZIndex(int zIndex) {
		this.zIndex = zIndex;
	}

	public Token getFirstTokenInParagraph() {
		assert tokens != null : "Precondition failed: tokens != null";

		Token result = null;
		if (tokens.size() > 0) {
			result = tokens.get(0);
		}

		return result;
	}

	public Token getLastTokenInParagraph() {
		assert tokens != null : "Precondition failed: tokens != null";

		Token result = null;
		if (tokens.size() > 0) {
			result = tokens.get(tokens.size() - 1);
		}

		return result;
	}

	public boolean containsToken(Id currentCursorTokenId) {
		assert currentCursorTokenId != null : "Precondition failed: currentCursorTokenId != null";
		boolean result = false;

		for (int i = 0; i < getTokenCount() && !result; i++) {
			result = getToken(i).getId().equals(currentCursorTokenId);
		}
		return result;
	}

	public FreeTextToken getFreeTextLineTokenAfter(Token token) {
		assert token != null : "Precondition failed: token != null";
		if (tokens.contains(token)) {
			int nextTokenIndex = tokens.indexOf(token) + 1;
			for (; nextTokenIndex < tokens.size(); nextTokenIndex++) {
				if (tokens.get(nextTokenIndex) instanceof FreeTextToken) {
					FreeTextToken freeTextToken = (FreeTextToken) tokens.get(nextTokenIndex);
					if (freeTextToken.isFreeTextLine()) {
						return freeTextToken;
					}
				}
			}
		}
		return null;
	}

	@Override
	public void lockLayout(boolean isLockedLayout) {
		this.lockedLayout = isLockedLayout;
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
