package de.signWritingEditor.shared.model.material;

import java.io.Serializable;

public class EmailAddress implements Serializable {

	private static final String EMAIL_PATTERN = "^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)*(\\.[a-z]{2,6})$";

	private static final long serialVersionUID = -113455914864737022L;

	private String mailAddressString;

	@Deprecated
	public EmailAddress() {
	}

	public EmailAddress(String mailAddressString) {
		assert mailAddressString != null : "Precondition failed: mailAddressString != null";
		assert EmailAddress.isValidAddressFormat(
				mailAddressString) : "Precondition failed: EmailAddress.isValidEmailFormat(mailAddressString)";

		this.mailAddressString = mailAddressString;
	}

	public static boolean isValidAddressFormat(String mailAddressString) {
		assert mailAddressString != null : "Precondition failed: mailAddressString != null";

		return mailAddressString.toLowerCase().matches(EMAIL_PATTERN);
	}

	public String asString() {
		return mailAddressString;
	}

	@Override
	public String toString() {
		return asString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mailAddressString == null) ? 0 : mailAddressString.hashCode());

		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof EmailAddress))
			return false;
		EmailAddress other = (EmailAddress) obj;
		if (mailAddressString == null) {
			if (other.mailAddressString != null)
				return false;
		} else if (!mailAddressString.equalsIgnoreCase(other.mailAddressString))
			return false;

		return true;
	}

}
