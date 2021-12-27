package de.signWritingEditor.client.GWTClient.infrastructure;

import com.google.gwt.http.client.URL;

import de.signWritingEditor.shared.infrastructure.URLConverter;

public class URLConverterClientImpl implements URLConverter {

	@Override
	public String decode(String url) {
		return URL.decode(url);
	}

	@Override
	public String encode(String url) {
		String newURL = URL.encode(url);
		return newURL;
	}

	@Override
	public String encodeQueryString(String url) {
		assert url != null : "Precondition failed: url != null";
		String result = URL.encodeQueryString(URL.encodeQueryString(url));
		assert result != null : "Postcondition failed: result != null";
		return result;
	}

}
