package de.signWritingEditor.shared.model.domainValue;

public enum FontWeight {
	NORMAL(""), BOLD("Bold");

	private String weight;

	private FontWeight(String weight) {
		this.weight = weight;
	}

	public String getWeight() {
		return weight;
	}
}
