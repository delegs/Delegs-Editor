package de.signWritingEditor.shared.model.domainValue;

public enum SortCriteria {
	TYPE("sortCriteriaType"), FILE_TITLE("sortCriteriaFileTitle"), AUTHOR("sortCriteriaAuthor"),
	CREATION_DATE("sortCriteriaCreationDate"), CHANGE_DATE("sortCriteriaChangeDate"), WHITE("sortCriteriaWhite"),
	RED("sortCriteriaRed"), BLUE("sortCriteriaBlue"), YELLOW("sortCriteriaYellow"), GREEN("sortCriteriaGreen"),
	COLOR("sortCriteriaColor");

	private String criteriaName;
	private boolean isCurrentlyAscending;

	private SortCriteria(String criteriaName) {
		assert criteriaName != null : "Precondition failed: criteriaName != null";
		this.criteriaName = criteriaName;
	}

	public String getCriteriaName() {
		assert criteriaName != null : "Precondition failed: criteriaName != null";
		return criteriaName;
	}

	public String getCriteriaNameForLocalStorage() {
		if (isCurrentlyAscending) {
			return name() + "ASC";
		}
		return name();
	}

	public boolean isCurrentlyAscending() {
		return isCurrentlyAscending;
	}

	public void setIsCurrentlyAscending(boolean currentlyAscending) {
		this.isCurrentlyAscending = currentlyAscending;
	}

}
