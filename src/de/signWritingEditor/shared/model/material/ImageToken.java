package de.signWritingEditor.shared.model.material;

import java.util.Objects;

import de.signWritingEditor.shared.model.domainValue.Color;
import de.signWritingEditor.shared.model.domainValue.Id;

public class ImageToken implements Token {

	private static final long serialVersionUID = 1296203681082773060L;
	private Id id;
	private Color backgroundColor;
	private int width;
	private int height;
	private String url;
	private boolean lockedLayout;
	private boolean lockedContent;

	/**
	 * @deprecated only for serialization
	 */
	@Deprecated
	public ImageToken() {
	}

	public ImageToken(Id id) {
		this(id, false, false);
	}

	public ImageToken(Id id, boolean lockedLayout, boolean lockedContent) {
		this.id = id;
		this.backgroundColor = Color.LIGHT_GREY;
		this.width = 220;
		this.height = 207;
		this.url = "";
		this.lockedLayout = lockedLayout;
		this.lockedContent = lockedContent;
	}

	@Override
	public Id getId() {
		return id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		if (!lockedContent) {
			this.url = url;
		}
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		if (!lockedLayout) {
			this.width = width;
		}
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		if (!lockedLayout) {
			this.height = height;
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

	@Override
	public boolean isEmpty() {
		return url.isEmpty();
	}

	@Override
	public long contentHashCode() {
		return Objects.hash(url, backgroundColor);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, backgroundColor, width, height, url);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!getClass().equals(obj.getClass()))
			return false;
		ImageToken other = (ImageToken) obj;
		if (backgroundColor == null) {
			if (other.backgroundColor != null)
				return false;
		} else if (!backgroundColor.equals(other.backgroundColor))
			return false;
		if (height != other.height)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
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
