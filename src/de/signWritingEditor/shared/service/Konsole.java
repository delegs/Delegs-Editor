package de.signWritingEditor.shared.service;

public class Konsole {

	public static native void log(String message) /*-{
		console.log(message);
	}-*/;

}
