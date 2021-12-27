package de.signWritingEditor.shared.model.material;

import java.util.Objects;

import de.signWritingEditor.shared.model.domainValue.Id;

public class DateFormToken extends FormToken {
	private static final long serialVersionUID = 1L;
	private boolean valid;

	public DateFormToken() {
		valid = true;
	}

	public DateFormToken(Id id, ReadOnlyTextbasedTokenStyle tokenStyle, String description) {
		super(id, tokenStyle, description);
		valid = true;
	}

	public DateFormToken(Id id, ReadOnlyTextbasedTokenStyle tokenStyle, String description, String inputContent) {
		super(id, tokenStyle, description, inputContent, "");
		valid = true;
	}

	@Override
	public boolean hasValidContent() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}

	@Override
	public long contentHashCode() {
		return Objects.hash(super.contentHashCode(), valid);
	}

}
