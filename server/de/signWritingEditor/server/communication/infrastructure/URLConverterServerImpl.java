package de.signWritingEditor.server.communication.infrastructure;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import de.signWritingEditor.shared.infrastructure.URLConverter;

public class URLConverterServerImpl implements URLConverter {

	@Override
	public String decode(String url) {
		assert url != null : "Precondition failed: url != null";
		String result = null;
		try {
			result = URLDecoder.decode(url, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException("URL decoding failed", e);
		}
		assert result != null : "Postcondition failed: result != null";
		return result;
	}

	@Override
	public String encode(String url) {
		assert url != null : "Precondition failed: url != null";
		String result = null;
		try {
			result = URLEncoder.encode(url, "UTF-8");
		} catch (UnsupportedEncodingException ignored) {
		}
		assert result != null : "Postcondition failed: result != null";
		return result;
	}

	@Override
	public String encodeQueryString(String url) {
		throw new RuntimeException(
				"Equivalent method to com.google.gwt.http.client.URL.encodeQueryString() is not known.");
	}
}
