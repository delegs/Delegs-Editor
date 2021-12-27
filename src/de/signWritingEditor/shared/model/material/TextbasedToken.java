package de.signWritingEditor.shared.model.material;

import java.util.Objects;

import de.signWritingEditor.shared.model.domainValue.Color;
import de.signWritingEditor.shared.model.domainValue.Id;

public abstract class TextbasedToken implements Token {

	private static final long serialVersionUID = 1L;

	private Id id;
	private ReadOnlyTextbasedTokenStyle style;

	@Deprecated
	protected TextbasedToken() {
		super();
	}

	public TextbasedToken(Id id, ReadOnlyTextbasedTokenStyle style) {
		assert id != null : "Precondition failed: id != null";
		assert style != null : "Precondition failed: tokenStyle != null";
		this.id = id;
		this.style = style;
	}

	@Override
	public Id getId() {
		return this.id;
	}

	public ReadOnlyTextbasedTokenStyle getStyle() {
		return style;
	}

	public Color getFontColor() {
		return getStyle().getFontColor();
	}

	public Color getTextBackgroundColor() {
		return getStyle().getTextBackgroundColor();
	}

	public abstract String getText();

	public abstract void setText(String text);

	@Override
	public long contentHashCode() {
		return Objects.hashCode(style);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, style);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null) {
			return false;
		}
		if (!getClass().equals(obj.getClass())) {
			return false;
		}
		TextbasedToken other = (TextbasedToken) obj;
		if (!Objects.equals(id, other.id)) {
			return false;
		}
		if (!Objects.equals(style, other.style)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "TextbasedToken [id=" + id + ", style=" + style + "]";
	}
}
