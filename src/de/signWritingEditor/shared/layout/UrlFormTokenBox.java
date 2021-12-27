package de.signWritingEditor.shared.layout;

import de.signWritingEditor.client.service.FontSizeService;
import de.signWritingEditor.shared.model.material.UrlFormToken;

public class UrlFormTokenBox extends FormTokenBox {

	public UrlFormTokenBox(UrlFormToken urlFormToken, FontSizeService fontSizeService) {
		super(urlFormToken, fontSizeService);
	}

	public String getShortenedLink() {
		return ((UrlFormToken) formToken).getShortenedLink();
	}

	public String getDefaultPattern() {
		return formToken.getDefaultPattern();
	}
}
