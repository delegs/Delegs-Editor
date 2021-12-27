package de.signWritingEditor.shared.model.material;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import de.signWritingEditor.shared.model.domainValue.DictionaryIndex;

public class DictionaryStructure implements Serializable {

	private static final long serialVersionUID = -2430057020557375877L;
	public static final DictionaryIndex DICTIONARY_INDEX_REMAINING_ENTRIES = new DictionaryIndex('$');
	public static final DictionaryIndex[] DEFAULT_DICTIONARY_INDICES = { new DictionaryIndex('a'),
			new DictionaryIndex('b'), new DictionaryIndex('c'), new DictionaryIndex('d'), new DictionaryIndex('e'),
			new DictionaryIndex('f'), new DictionaryIndex('g'), new DictionaryIndex('h'), new DictionaryIndex('i'),
			new DictionaryIndex('j'), new DictionaryIndex('k'), new DictionaryIndex('l'), new DictionaryIndex('m'),
			new DictionaryIndex('n'), new DictionaryIndex('o'), new DictionaryIndex('p'), new DictionaryIndex('q'),
			new DictionaryIndex('r'), new DictionaryIndex('s'), new DictionaryIndex('t'), new DictionaryIndex('u'),
			new DictionaryIndex('v'), new DictionaryIndex('w'), new DictionaryIndex('x'), new DictionaryIndex('y'),
			new DictionaryIndex('z') };

	private long revision;

	private Map<DictionaryIndex, Integer> dictionaryIndexToSignCount;

	public DictionaryStructure() {
		dictionaryIndexToSignCount = new HashMap<DictionaryIndex, Integer>();
		revision = 0;
	}

	public long getRevision() {
		return revision;
	}

	public void setRevision(long revision) {
		this.revision = revision;
	}

	public boolean containsDictionaryIndex(DictionaryIndex dictionaryIndex) {
		assert dictionaryIndex != null : "Precondition failed: dictionaryIndex != null";

		return dictionaryIndexToSignCount.containsKey(dictionaryIndex);
	}

	public int getDictionaryIndexCount(DictionaryIndex dictionaryIndex) {
		assert dictionaryIndex != null : "Precondition failed: dictionaryIndex != null";
		assert containsDictionaryIndex(
				dictionaryIndex) : "Precondition failed: containsDictionaryIndex(dictionaryIndex)";

		return dictionaryIndexToSignCount.get(dictionaryIndex);
	}

	public Set<DictionaryIndex> getDictionaryIndices() {
		return dictionaryIndexToSignCount.keySet();
	}

	public Map<DictionaryIndex, Integer> getDictionaryIndexToSignCount() {
		return dictionaryIndexToSignCount;
	}

	public void addDictionaryIndex(DictionaryIndex dictionaryIndex, int count) {
		assert dictionaryIndex != null : "Precondition failed: dictionaryIndex != null";
		assert count >= 0 : "Precondition failed: count >= 0";
		assert !containsDictionaryIndex(
				dictionaryIndex) : "Precondition failed: !containsDictionaryIndex(dictionaryIndex)";

		dictionaryIndexToSignCount.put(dictionaryIndex, count);
	}
}
