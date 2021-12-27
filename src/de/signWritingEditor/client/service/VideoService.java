package de.signWritingEditor.client.service;

public interface VideoService {

	boolean loadVideoFromUrl(String url);

	String urlEncode(String url);

}