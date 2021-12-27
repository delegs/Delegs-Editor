package de.signWritingEditor.shared.model.material;

import de.signWritingEditor.shared.model.domainValue.Id;

public class UrlFormToken extends FormToken {

	private static final long serialVersionUID = 1430117315051452551L;

	/**
	 * @deprecated only for serialization
	 */
	@Deprecated
	protected UrlFormToken() {
	}

	public UrlFormToken(Id id, ReadOnlyTextbasedTokenStyle tokenStyle, String description, String pattern) {
		super(id, tokenStyle, description, "", pattern);
	}

	public UrlFormToken(Id id, ReadOnlyTextbasedTokenStyle tokenStyle, String description, String inputContent,
			String pattern) {
		super(id, tokenStyle, description, inputContent, pattern);
	}

	public String getShortenedLink() {
		String[] segments = getText().split("/");
		for (int i = segments.length - 1; i >= 0; i--) {
			String currentSegment = segments[i];
			if (isNotNumeric(currentSegment)) {
				return currentSegment;
			}
		}
		return segments[segments.length - 1];
	}

	private boolean isNotNumeric(String s) {
		try {
			Integer.parseInt(s);
		} catch (NumberFormatException e) {
			return true;
		}
		return false;
	}

}
