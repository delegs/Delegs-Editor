package de.signWritingEditor.shared.model.material;

@Deprecated
public class DatabasePositionedSymbol {

	public int signidupper;
	public String symbolid;
	public int x;
	public int y;
	public int z;
	public String signword;
	public String language;
	public String source;
	public int width;

	public DatabasePositionedSymbol(int signidupper, String symbolid, int x, int y, int z, String signword,
			String language, String source, int width) {
		this.signidupper = signidupper;
		this.symbolid = symbolid;
		this.x = x;
		this.y = y;
		this.z = z;
		this.signword = signword;
		this.language = language;
		this.source = source;
		this.width = width;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((language == null) ? 0 : language.hashCode());
		result = prime * result + signidupper;
		result = prime * result + ((signword == null) ? 0 : signword.hashCode());
		result = prime * result + ((source == null) ? 0 : source.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!getClass().equals(obj.getClass()))
			return false;
		DatabasePositionedSymbol other = (DatabasePositionedSymbol) obj;
		if (language == null) {
			if (other.language != null)
				return false;
		} else if (!language.equals(other.language))
			return false;
		if (signidupper != other.signidupper)
			return false;
		if (signword == null) {
			if (other.signword != null)
				return false;
		} else if (!signword.equals(other.signword))
			return false;
		if (source == null) {
			if (other.source != null)
				return false;
		} else if (!source.equals(other.source))
			return false;
		return true;
	}

}
