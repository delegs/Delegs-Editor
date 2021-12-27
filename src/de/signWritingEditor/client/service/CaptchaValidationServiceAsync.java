package de.signWritingEditor.client.service;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface CaptchaValidationServiceAsync {

	void validateCaptcha(String captcha, AsyncCallback<Boolean> callback);

}
