package de.signWritingEditor.shared.model.material;

import java.util.Objects;

import de.signWritingEditor.shared.model.domainValue.Color;
import de.signWritingEditor.shared.model.domainValue.Id;

public class FreeTextToken extends TextbasedToken {
	private static final long serialVersionUID = 1L;

	private static final int FLEXIBLE_WIDTH = -1;

	private String freeText;
	private int width;
	private boolean fixedWidth;
	private boolean isFreeTextLine;
	private boolean visible;
	private boolean lockedLayout;
	private boolean lockedContent;

	/**
	 * @deprecated only for serialization
	 */
	@Deprecated
	protected FreeTextToken() {
	}

	public FreeTextToken(Id id, ReadOnlyTextbasedTokenStyle tokenStyle) {
		this(id, new String(), tokenStyle, false, false);
	}

	public FreeTextToken(Id id, String freeText, ReadOnlyTextbasedTokenStyle tokenStyle) {
		this(id, freeText, tokenStyle, false, false);
	}

	public FreeTextToken(Id id, String freeText, ReadOnlyTextbasedTokenStyle tokenStyle, boolean isLockedLayout,
			boolean isLockedContent) {
		super(id, tokenStyle);
		this.freeText = freeText;
		this.width = FLEXIBLE_WIDTH;
		this.fixedWidth = false;
		this.isFreeTextLine = false;
		this.visible = true;
		this.lockedLayout = isLockedLayout;
		this.lockedContent = isLockedContent;
	}

	@Override
	public String toString() {
		return "token[id=" + getId() + ", style=" + getStyle() + ", FreeText:\"" + freeText + "\"]";
	}

	@Override
	public String getText() {
		return this.freeText;
	}

	@Override
	public void setText(String text) {
		assert text != null : "Precondition failed: text != null";
		if (!lockedContent) {
			this.freeText = text;
		}
	}

	public int getWidth() {
		assert width >= -1 : "Postcondition failed: result >= -1";
		// -1 means a flexible FreeTextToken width
		return width;
	}

	public void setWidth(int width) {
		assert width >= -1 : "Precondition failed: result >= -1";
		// -1 means a flexible FreeTextToken width

		if (!this.fixedWidth) {
			if (!lockedLayout) {
				this.width = width;
			}
		}
	}

	public Boolean hasFixedWidth() {
		return this.fixedWidth;
	}

	public void setFixedWidth(Boolean fixedWidth, int width) {
		this.width = width;
		this.fixedWidth = fixedWidth;
	}

	@Override
	public boolean isEmpty() {
		return freeText.equals("") || freeText == null;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public boolean isFreeTextLine() {
		return isFreeTextLine;
	}

	public void setIsFreeTextLine(boolean isLine) {
		if (!lockedContent) {
			this.isFreeTextLine = isLine;
		}
	}

	@Override
	public Color getBackgroundColor() {
		return super.getTextBackgroundColor();
	}

	@Override
	public void setBackgroundColor(Color backgroundColor) {
		if (!lockedLayout) {
			TextbasedTokenStyle style = (TextbasedTokenStyle) super.getStyle();
			style.setTextBackgroundColor(backgroundColor);
		}
	}

	@Override
	public long contentHashCode() {
		return Objects.hash(super.contentHashCode(), freeText, fixedWidth, isFreeTextLine, visible);
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), freeText, width, fixedWidth, isFreeTextLine, visible);
	}

	@Override
	public boolean equals(Object obj) {
		if (!super.equals(obj))
			return false;

		FreeTextToken other = (FreeTextToken) obj;
		if (fixedWidth != other.fixedWidth)
			return false;
		if (freeText == null) {
			if (other.freeText != null)
				return false;
		} else if (!freeText.equals(other.freeText))
			return false;

		if (isFreeTextLine != other.isFreeTextLine)
			return false;
		if (visible != other.visible)
			return false;
		if (width != other.width)
			return false;
		return true;
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
