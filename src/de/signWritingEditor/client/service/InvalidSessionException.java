package de.signWritingEditor.client.service;

import static de.signWritingEditor.shared.i18n.I18NAccess.I18N;

public class InvalidSessionException extends Exception {

	private static final long serialVersionUID = 2350042850643926174L;

	public InvalidSessionException() {
		super(I18N.getLoginFailed());
	}
}
