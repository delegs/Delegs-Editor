package de.badge.shared.service;

import java.io.Serializable;

public class DataCouldNotBeStoredException extends Exception implements Serializable {

	private static final long serialVersionUID = 6243828624552075662L;

	public DataCouldNotBeStoredException(String cause) {
		super(cause);
	}

	// GWT RPC requirement
	@SuppressWarnings("unused")
	@Deprecated
	private DataCouldNotBeStoredException() {
		super();
	}

}
