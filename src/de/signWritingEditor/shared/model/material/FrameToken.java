package de.signWritingEditor.shared.model.material;

import java.util.Objects;

import de.signWritingEditor.shared.model.domainValue.Color;
import de.signWritingEditor.shared.model.domainValue.Id;

public class FrameToken implements Token {

	private static final long serialVersionUID = 1L;
	private Id id;
	private int borderWidth_PX;
	private int width;
	private int height;
	private Color frameColor;
	private Color backgroundColor;
	private boolean lockedLayout;
	private boolean lockedContent;

	/**
	 * @deprecated only for serialization
	 */
	@Deprecated
	public FrameToken() {
	}

	public FrameToken(Id id) {
		this(id, false, false);
	}

	public FrameToken(Id id, boolean lockedLayout, boolean lockedContent) {
		this.id = id;
		this.borderWidth_PX = 2;
		this.width = 150;
		this.height = 190;
		this.frameColor = Color.BLACK;
		this.backgroundColor = Color.WHITE;
		this.lockedLayout = lockedLayout;
		this.lockedContent = lockedContent;
	}

	@Override
	public Id getId() {
		return id;
	}

	public int getBorderWidth_PX() {
		return borderWidth_PX;
	}

	public Color getFrameColor() {
		return frameColor;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public void setFrameColor(Color frameColor) {
		this.frameColor = frameColor;
	}

	public void setBorderWidth(int borderWidth) {
		this.borderWidth_PX = borderWidth;
	}

	@Override
	public String toString() {
		return "frameToken(id: " + getId() + "\")";
	}

	@Override
	public Color getBackgroundColor() {
		return backgroundColor;
	}

	@Override
	public void setBackgroundColor(Color backgroundColor) {
		this.backgroundColor = backgroundColor;
	}

	/**
	 * A frame token is always empty.
	 */
	@Override
	public boolean isEmpty() {
		return true;
	}

	@Override
	public long contentHashCode() {
		return Objects.hash(frameColor, borderWidth_PX);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, borderWidth_PX, width, height, frameColor, backgroundColor);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!getClass().equals(obj.getClass()))
			return false;
		FrameToken other = (FrameToken) obj;
		if (backgroundColor == null) {
			if (other.backgroundColor != null)
				return false;
		} else if (!backgroundColor.equals(other.backgroundColor))
			return false;
		if (borderWidth_PX != other.borderWidth_PX)
			return false;
		if (frameColor == null) {
			if (other.frameColor != null)
				return false;
		} else if (!frameColor.equals(other.frameColor))
			return false;
		if (height != other.height)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
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
		lockedContent = isLockedContent;
	}

	@Override
	public boolean isContentLocked() {
		return lockedContent;
	}
}
