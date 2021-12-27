package de.signWritingEditor.client.service;

import static de.signWritingEditor.shared.i18n.I18NAccess.I18N;

public class RoomnameCollisionException extends Exception {

	public RoomnameCollisionException() {
		super(I18N.getRoomnameCollision());
	}
}
