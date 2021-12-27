package de.signWritingEditor.shared.exceptions;

import static de.signWritingEditor.shared.i18n.I18NAccess.I18N;

public class MissingAuthorizationException extends Exception {

	private static final long serialVersionUID = -5591308977820577497L;

	public MissingAuthorizationException(String string) {
		super(string);
	}

	public MissingAuthorizationException() {
		super(I18N.getMissingAuthorization());
	}
}
