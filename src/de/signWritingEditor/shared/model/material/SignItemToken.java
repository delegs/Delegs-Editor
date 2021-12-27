package de.signWritingEditor.shared.model.material;

import java.util.Objects;

import de.signWritingEditor.shared.model.domainValue.Color;
import de.signWritingEditor.shared.model.domainValue.Id;
import de.signWritingEditor.shared.model.domainValue.SignLocale;

public class SignItemToken extends TextbasedToken {

	private static final long serialVersionUID = 1L;

	private String word;
	private SignItem signItem;

	private boolean searchWordVisibility = true;
	private boolean signVisibility = true;

	private boolean lockedLayout;
	private boolean lockedContent;

	private Color backgroundColor;

	private SignLocale locale;

	/**
	 * @deprecated only for serialization
	 */
	@Deprecated
	protected SignItemToken() {
	}

	/**
	 * Constructor
	 * 
	 * @param word
	 * @require word != null
	 */
	public SignItemToken(String word, Id id, ReadOnlyTextbasedTokenStyle textbasedTokenStyle) {
		this(word, null, id, textbasedTokenStyle);

	}

	public SignItemToken(String word, SignItem signItem, Id id, ReadOnlyTextbasedTokenStyle textbasedTokenStyle) {
		this(word, signItem, id, textbasedTokenStyle, false, false);
	}

	public SignItemToken(String word, SignItem signItem, Id id, ReadOnlyTextbasedTokenStyle textbasedTokenStyle,
			boolean lockedLayout, boolean lockedContent) {
		super(id, textbasedTokenStyle);
		assert word != null : "word != null";
		this.word = word;
		this.signItem = signItem;
		this.setBackgroundColor(Color.WHITE);
		this.locale = SignLocale.DGS;
		this.lockedLayout = lockedLayout;
		this.lockedContent = lockedContent;
	}

	public boolean isEmpty() {
		return getText().isEmpty();
	}

	@Override
	public String getText() {
		assert word != null : "Postcondition failed: result != null";
		return word;
	}

	/**
	 * @require word != null
	 */
	@Override
	public void setText(String word) {
		assert word != null : "word != null";
		if (!lockedContent) {
			this.word = word;
		}
	}

	public SignItem getSignItem() {
		return signItem;
	}

	public boolean hasSignItem() {
		return signItem != null;
	}

	public void setSignItem(SignItem signItem) {
		if (!lockedContent) {
			this.signItem = signItem;
		}
	}

	public long contentHashCode() {
		return Objects.hash(super.contentHashCode(), word, signItem, backgroundColor, locale);
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), word, signItem, backgroundColor, locale);
	}

	@Override
	public boolean equals(Object obj) {
		if (!super.equals(obj)) {
			return false;
		}

		SignItemToken other = (SignItemToken) obj;
		if (backgroundColor == null && other.backgroundColor != null
				|| !backgroundColor.equals(other.backgroundColor)) {
			return false;
		}

		if (locale != other.locale)
			return false;
		if (!Objects.equals(signItem, other.signItem)) {
			return false;
		}
		if (word == null && other.word != null || !word.equals(other.word)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "token[id=" + getId() + ", style=" + getStyle() + ", backgroundColor=" + backgroundColor + ", locale="
				+ locale + ", signItem=" + signItem + ", word=" + word + "]";
	}

	public int getSignHeight_PX() {
		return SignItem.getSignHeight_PX();
	}

	public SignLocale getLocale() {
		return this.locale;
	}

	public void setSignLocale(SignLocale dgs) {
		if (!lockedContent) {
			this.locale = dgs;
		}
	}

	@Override
	public Color getBackgroundColor() {
		return backgroundColor;
	}

	@Override
	public void setBackgroundColor(Color backgroundColor) {
		this.backgroundColor = backgroundColor;
	}

	public boolean isSearchWordVisibility() {
		return searchWordVisibility;
	}

	public void setSearchWordVisibility(boolean searchWordVisibility) {
		this.searchWordVisibility = searchWordVisibility;
	}

	public boolean isSignVisibility() {
		return signVisibility;
	}

	public void setSignVisibility(boolean signVisibility) {
		this.signVisibility = signVisibility;
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
