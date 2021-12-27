package de.signWritingEditor.shared.model.domainValue;

import static de.signWritingEditor.shared.i18n.I18NAccess.I18N;

import java.io.Serializable;

public class FileTitle implements Serializable {

	private static final String PUBLIC_FOLDER_NAME = "Playground";
	private static final String ROOT_FOLDER_NAME = "Home";
	private static final String SHOWROOM_FOLDER_NAME = "Showroom";

	private static final long serialVersionUID = 787826956470562895L;

	private static final String EURO_SPECIALS = "¡¿ÄÀÁÂÃäàáâãÇçÈÉÊËèéêëÌÍÎìíîïÑñÖÒÓÔÕöòóôõøßŠšÜÙÚÛüùúûÝýÿŸŽž'";

	private static final String VALID_CHARACTERS = "[\\w" + EURO_SPECIALS + "°\\!\"§$%&()\\[\\]{}=?@€*+~#_\\-|.:,<>]";

	private static final int MAX_LENGTH = 100;

	private String title;

	public FileTitle(String title) {
		assert isValidTitle(title) : "Precondition failed: isValidTitle(title) (" + title + ")";

		this.title = title;
	}

	public String getTitleString() {
		return title;
	}

	public String getDisplayTitleString() {
		String result = title;
		if (PUBLIC_FOLDER_NAME.equals(title)) {
			result = I18N.getPublicRoomName();
		} else if (ROOT_FOLDER_NAME.equals(title)) {
			result = I18N.getRootFolderName();
		} else if (SHOWROOM_FOLDER_NAME.equals(title)) {
			result = I18N.getShowRoomName();
		}
		return result;
	}

	public static boolean isValidTitle(String title) {
		return title != null && title.length() <= MAX_LENGTH
				&& title.matches("\\/|" + VALID_CHARACTERS + "+" + "( " + VALID_CHARACTERS + "+)*");
	}

	public static boolean isValidUserTitle(String title) {
		return title != null && title.length() <= MAX_LENGTH
				&& title.matches(VALID_CHARACTERS + "+" + "( " + VALID_CHARACTERS + "+)*")
				&& !title.equals("Papierkorb");
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object other) {
		boolean result = other != null && other.getClass().equals(this.getClass());

		if (result) {
			FileTitle otherFileTitle = (FileTitle) other;
			result = this.getTitleString().equalsIgnoreCase(otherFileTitle.getTitleString());
		}

		return result;
	}

	/**
	 * @deprecated only for serialization
	 */
	@Deprecated
	protected FileTitle() {
	}

	@Override
	public String toString() {
		return "FileTitle [title=" + title + "]";
	}
}
