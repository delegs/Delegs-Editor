package de.signWritingEditor.client.GWTClient.infrastructure;

import de.signWritingEditor.client.GWTClient.ui.tool.subtools.signEditor.SignEditor.SignEditorListener;
import de.signWritingEditor.shared.model.material.SimpleSign;

public class SignEditorListenerMock implements SignEditorListener {

	@Override
	public void onChangeTool(SimpleSign sign) {
	}

	@Override
	public void onInvalidSessionExceptionCaught() {
	}

	@Override
	public void onMissingAuthorizationExceptionCaught(String message) {
	}
}
