package de.signWritingEditor.shared.model.material;

import java.io.Serializable;

import de.signWritingEditor.shared.model.domainValue.SignLocale;

public abstract class AuthoredObject implements Serializable {

	private static final long serialVersionUID = -8497030998156389075L;

	private User author;
	private SignLocale signLocale;

	/**
	 * Return the owner.
	 * 
	 * @return The owner.
	 * 
	 * @ensure result != null
	 */
	public User getAuthor() {
		return author;
	}

	public SignLocale getSignLocale() {
		return signLocale;
	}

	public void setAuthor(User author) {
		assert author != null : "owner != null";
		this.author = author;
	}

	public void setRegion(SignLocale language) {
		assert language != null : "signLocale != null";
		this.signLocale = language;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((signLocale == null) ? 0 : signLocale.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		boolean result = obj.getClass().equals(this.getClass());
		if (result) {
			AuthoredObject other = (AuthoredObject) obj;
			result &= other.author.equals(this.author);
			result &= other.signLocale.equals(this.signLocale);
		}
		return result;
	}

	// protected

	public AuthoredObject(User author, SignLocale language) {
		assert author != null : "author != null";
		assert language != null : "signLocale != null";

		this.author = author;
		this.signLocale = language;
	}

	/**
	 * Constructor.
	 * 
	 * @deprecated Only for serialization.
	 */
	@Deprecated
	protected AuthoredObject() {
	}

}
