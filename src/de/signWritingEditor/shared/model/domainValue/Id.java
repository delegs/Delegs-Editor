package de.signWritingEditor.shared.model.domainValue;

import java.io.Serializable;

public class Id implements Serializable {

	private static final long serialVersionUID = 6295510760704260210L;

	private static final String ID_SEPERATOR = ":";

	private long upperIdPart;
	private long lowerIdPart;

	public Id(long upperIdPart, long lowerIdPart) {
		this.upperIdPart = upperIdPart;
		this.lowerIdPart = lowerIdPart;
	}

	public Id(String idString) {
		String[] idParts = idString.split(ID_SEPERATOR);

		assert idParts.length == 2 : "Assertion failed: idParts.length == 2";

		this.upperIdPart = Long.parseLong(idParts[0]);
		this.lowerIdPart = Long.parseLong(idParts[1]);
	}

	public long getUpperIdPart() {
		return upperIdPart;
	}

	public long getLowerIdPart() {
		return lowerIdPart;
	}

	@Override
	public boolean equals(Object obj) {
		boolean result = obj == this;
		if (!result && obj != null && obj instanceof Id) {
			result = ((Id) obj).upperIdPart == this.upperIdPart && ((Id) obj).lowerIdPart == this.lowerIdPart;
		}
		return result;
	}

	@Override
	public int hashCode() {
		long value = upperIdPart * 31 + lowerIdPart;
		return (int) (value ^ (value >>> 32));
	}

	@Override
	public String toString() {
		return upperIdPart + ID_SEPERATOR + lowerIdPart;
	}

	/**
	 * Serializer only!
	 */
	@Deprecated
	protected Id() {
	}
}
