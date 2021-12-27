package de.signWritingEditor.shared.model.domainValue;

import java.io.Serializable;

public class SignId implements Serializable {

	private static final long serialVersionUID = 9195759316257332718L;

	public static final String EMPTY_SIGN_LOWER_ID = "!_EMPTY_LOWER_ID_!";
	public static final SignId emptySignId = new SignId(0, EMPTY_SIGN_LOWER_ID, SignLocale.DGS, SignSource.SYSTEM);
	private long upperIdPart;
	private String lowerIdPart;
	private SignLocale signLocale;
	private SignSource signSource;

	public SignId(long upperIdPart, String lowerIdPart, SignLocale signLocale, SignSource signSource) {
		assert lowerIdPart != null : "Precondition failed: lowerIdPart != null";
		assert !lowerIdPart.isEmpty() : "Precondition failed: !lowerIdPart.isEmpty()";
		assert !lowerIdPart.contains(" ") : "Precondition failed: lowerIdPart.contains(\" \") [" + lowerIdPart + "]";
		assert signLocale != null : "Precondition failed: signLocale != null";
		assert signSource != null : "Precondition failed: signSource != null";

		this.upperIdPart = upperIdPart;
		this.lowerIdPart = lowerIdPart;
		this.signLocale = signLocale;
		this.signSource = signSource;
	}

	public SignId withSource(SignSource source) {
		return new SignId(upperIdPart, lowerIdPart, signLocale, source);
	}

	public String getLowerIdPart() {
		assert lowerIdPart != null : "Postcondition failed: result != null";
		assert !lowerIdPart.isEmpty() : "Postcondition failed: !result.isEmpty()";
		return lowerIdPart;
	}

	public long getUpperIdPart() {
		return upperIdPart;
	}

	public SignLocale getSignLocale() {
		return signLocale;
	}

	public SignSource getSignSource() {
		return signSource;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((lowerIdPart == null) ? 0 : lowerIdPart.hashCode());
		result = prime * result + ((signLocale == null) ? 0 : signLocale.hashCode());
		result = prime * result + ((signSource == null) ? 0 : signSource.hashCode());
		result = prime * result + (int) (upperIdPart ^ (upperIdPart >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		assert obj instanceof SignId;

		boolean result = false;
		if (this == obj && obj != null) {
			result = true;
		} else if (getClass() == obj.getClass()) {
			SignId other = (SignId) obj;
			if (lowerIdPart.equals(other.lowerIdPart) && signLocale == other.signLocale
					&& upperIdPart == other.upperIdPart && signSource == other.signSource) {
				result = true;
			}
		}
		return result;
	}

	@Override
	public String toString() {
		return "SignId(upperIdPart: " + upperIdPart + ", lowerIdPart: " + lowerIdPart + ", signLocale: " + signLocale
				+ ", source: " + signSource + ")";
	}

	/**
	 * Constructor.
	 * 
	 * @deprecated Only for serialization.
	 */
	@Deprecated
	protected SignId() {
	}
}
