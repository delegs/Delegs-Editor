package de.signWritingEditor.shared.infrastructure;

public interface URLConverter {

	public String decode(String url);

	public String encode(String url);

	@Deprecated
	public String encodeQueryString(String url);
}
