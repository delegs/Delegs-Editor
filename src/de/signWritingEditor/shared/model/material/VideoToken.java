package de.signWritingEditor.shared.model.material;

import java.util.Objects;

import de.signWritingEditor.shared.model.domainValue.Color;
import de.signWritingEditor.shared.model.domainValue.Id;

public class VideoToken implements Token {

	public static final String VIDEO_TOKEN_URL = "videoTokenUrl";
	public static final String VIDEO_TOKEN_BACKGROUND_COLOR = "videoTokenBackgroundColor";
	private static final long serialVersionUID = 1L;
	private Id id;
	private String url;
	private int width;
	private int height;
	private Color backgroundColor;
	private Color textBackgroundColor;
	private boolean urlVisible;
	private boolean lockedLayout;
	private boolean lockedContent;

	/**
	 * @deprecated only for serialization
	 */
	@Deprecated
	public VideoToken() {
	}

	public VideoToken(Id id) {
		this(id, false, false);
	}

	public VideoToken(Id id, boolean lockedLayout, boolean lockedContent) {
		this.id = id;
		this.width = 220;
		this.height = 207;
		this.backgroundColor = Color.LIGHT_GREY;
		this.urlVisible = true;
		this.url = "";
		this.lockedLayout = lockedLayout;
		this.lockedContent = lockedContent;
		updateTextBackgroundcolor();
	}

	@Override
	public Id getId() {
		return id;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public void setWidth(int width) {
		if (!lockedLayout) {
			this.width = width;
		}
	}

	public void setHeight(int height) {
		if (!lockedLayout) {
			this.height = height;
		}
	}

	@Override
	public String toString() {
		return "videoToken(id: " + getId() + "\")";
	}

	@Override
	public Color getBackgroundColor() {
		return backgroundColor;
	}

	@Override
	public void setBackgroundColor(Color backgroundColor) {
		this.backgroundColor = backgroundColor;
	}

	public Color getTextBackgroundColor() {
		return textBackgroundColor;
	}

	public void setTextBackgroundColor(Color backgroundColor) {
		this.textBackgroundColor = backgroundColor;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		if (!lockedContent) {
			this.url = url;
		}
	}

	@Override
	public boolean isEmpty() {
		return url == null || url.isEmpty();
	}

	public boolean isUrlVisible() {
		return urlVisible;
	}

	public void setUrlVisible(boolean urlVisible) {
		this.urlVisible = urlVisible;
	}

	@Override
	public long contentHashCode() {
		return Objects.hash(url, backgroundColor, urlVisible);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, url, width, height, backgroundColor, urlVisible);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!getClass().equals(obj.getClass()))
			return false;
		VideoToken other = (VideoToken) obj;
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
		if (urlVisible != other.urlVisible)
			return false;
		if (width != other.width)
			return false;
		return true;
	}

	private void updateTextBackgroundcolor() {
		Color color = lockedLayout && !lockedContent ? Color.WHITE : Color.GREY;
		setTextBackgroundColor(color);
	}

	@Override
	public void lockLayout(boolean isLockedLayout) {
		lockedLayout = isLockedLayout;
		updateTextBackgroundcolor();
	}

	@Override
	public boolean isLayoutLocked() {
		return lockedLayout;
	}

	@Override
	public void lockContent(boolean isLockedContent) {
		lockedContent = isLockedContent;
		updateTextBackgroundcolor();
	}

	@Override
	public boolean isContentLocked() {
		return lockedContent;
	}
}
