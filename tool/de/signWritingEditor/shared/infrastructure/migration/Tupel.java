package de.signWritingEditor.shared.infrastructure.migration;

public class Tupel<T, K> {
	public T content;
	public K data;

	public Tupel(T content, K daten) {
		this.content = content;
		this.data = daten;
	}
}
