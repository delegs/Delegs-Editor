package de.signWritingEditor.client.service;

import static de.signWritingEditor.shared.i18n.I18NAccess.I18N;

public class InvalidUsernameException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5986435658912573640L;

	public InvalidUsernameException() {
		super(I18N.getInvalidUsername());
	}

}
