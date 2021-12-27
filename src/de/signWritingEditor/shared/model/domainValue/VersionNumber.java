package de.signWritingEditor.shared.model.domainValue;

import java.io.Serializable;

public class VersionNumber implements Comparable<VersionNumber>, Serializable {
	private static final long serialVersionUID = 5316067555253551826L;

	public static final VersionNumber EMPTY_VERSION = new VersionNumber(0, 0);

	private int minorVersion;
	private int majorVersion;
	private int specialVersion;

	public static boolean isValidVersionString(String string) {
		return string.matches("\\d+\\.\\d+(\\.\\d+)?");
	}

	public VersionNumber(String versionString) {
		assert isValidVersionString(versionString) : "Precondition failed: isValidVersionString(versionString)";

		String[] versionNumberStrings = versionString.split("\\.");

		this.majorVersion = Integer.parseInt(versionNumberStrings[0]);
		this.minorVersion = Integer.parseInt(versionNumberStrings[1]);
		this.specialVersion = versionNumberStrings.length == 3 ? Integer.parseInt(versionNumberStrings[2]) : 0;
	}

	public VersionNumber(int majorVersion, int minorVersion, int specialVersion) {
		assert majorVersion >= 0 : "Precondition failed: majorVersion >= 0";
		assert minorVersion >= 0 : "Precondition failed: minorVersion >= 0";
		assert specialVersion >= 0 : "Precondition failed: specialVersion >= 0";

		this.majorVersion = majorVersion;
		this.minorVersion = minorVersion;
		this.specialVersion = specialVersion;
	}

	public VersionNumber(int majorVersion, int minorVersion) {
		this(majorVersion, minorVersion, 0);
	}

	public int getMinorVersion() {
		return minorVersion;
	}

	public int getMajorVersion() {
		return majorVersion;
	}

	public int getSpecialVersion() {
		return specialVersion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 42;
		result = prime * result + majorVersion;
		result = prime * result + minorVersion;
		result = prime * result + specialVersion;
		return result;
	}

	@Override
	public boolean equals(Object other) {
		boolean result = other == this;
		if (!result && other != null && other.getClass().equals(getClass())) {
			VersionNumber otherVersionNumber = (VersionNumber) other;

			result = this.majorVersion == otherVersionNumber.majorVersion
					&& this.minorVersion == otherVersionNumber.minorVersion
					&& this.specialVersion == otherVersionNumber.specialVersion;
		}
		return result;
	}

	@Override
	public int compareTo(VersionNumber other) {
		assert other != null : "Precondition failed: other != null";

		int result = this.majorVersion - other.majorVersion;

		if (result == 0) {
			result = this.minorVersion - other.minorVersion;

			if (result == 0) {
				result = this.specialVersion - other.specialVersion;
			}
		}

		return result;
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();

		result.append(majorVersion);
		result.append(".");
		result.append(minorVersion);

		if (specialVersion > 0) {
			result.append(".");
			result.append(specialVersion);
		}

		return result.toString();
	}

	@Deprecated
	protected VersionNumber() {
	}
}
