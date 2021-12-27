package de.signWritingEditor.client.GWTClient.ui.tool.general.tool;

import com.google.gwt.user.client.rpc.AsyncCallback;

import de.signWritingEditor.client.GWTClient.ui.tool.general.dialogBox.MessageDialogBox;

public class SignWritingCallback<T> implements AsyncCallback<T> {

	private final String errorMessage;

	/**
	 * SignWritingCallback for errorhandling.
	 * 
	 * @param errorMessage
	 *            message for errorhandling.
	 * 
	 * @require errorMessage != null
	 */
	public SignWritingCallback(String errorMessage) {
		assert errorMessage != null : "errorMessage != null";
		this.errorMessage = errorMessage;
	}

	@SuppressWarnings("all")
	public void onFailure(Throwable caught) {
		String message = errorMessage + "<br>" + caught.getMessage();
		caught.printStackTrace();
		final MessageDialogBox messageDialogBox = new MessageDialogBox("Fehler", message);
		messageDialogBox.center();
	}

	@SuppressWarnings("all")
	public void onSuccess(T result) {
	};

}
