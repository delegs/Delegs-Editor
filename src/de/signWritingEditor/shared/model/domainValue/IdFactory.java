package de.signWritingEditor.shared.model.domainValue;

public class IdFactory {

	private final long uniqueNumber;
	private long counter;

	public IdFactory(long uniqueNum) {
		this.uniqueNumber = uniqueNum;
		this.counter = 0;
	}

	public Id createId() {
		return new Id(uniqueNumber, getNextLowerIdPart());
	}

	/**
	 * Only for persisted ids
	 */
	public Id reconstructId(long upperIdPart, long lowerIdPart) {
		return new Id(upperIdPart, lowerIdPart);
	}

	private long getNextLowerIdPart() {
		return this.counter += 1;
	}
}
