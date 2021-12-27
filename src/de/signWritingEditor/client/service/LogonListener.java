package de.signWritingEditor.client.service;

public interface LogonListener {
	void onLogin();

	void onLoginFailed(String loginErrorMessage);
}