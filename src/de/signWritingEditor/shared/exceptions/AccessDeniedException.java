package de.signWritingEditor.shared.exceptions;

import static de.signWritingEditor.shared.i18n.I18NAccess.I18N;

public class AccessDeniedException extends Exception {

	private static final long serialVersionUID = -6333152856371694437L;

	public AccessDeniedException(String string) {
		super(string);
	}

	public AccessDeniedException() {
		super(I18N.getAccessDeniedTitle());
	}
}
