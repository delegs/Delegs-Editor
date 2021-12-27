package de.signWritingEditor.client.model.material;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import de.signWritingEditor.shared.model.domainValue.DictionaryIndex;
import de.signWritingEditor.shared.model.material.DictionaryStructure;

public class DictionaryStructureTest {

	@Test
	public void testAll() {
		DictionaryStructure dictionaryStructure = new DictionaryStructure();
		dictionaryStructure.addDictionaryIndex(new DictionaryIndex('a'), 2);
		dictionaryStructure.addDictionaryIndex(new DictionaryIndex('A'), 0);
		dictionaryStructure.addDictionaryIndex(new DictionaryIndex('c'), Integer.MAX_VALUE);
		dictionaryStructure.addDictionaryIndex(new DictionaryIndex('b'), 109);
		dictionaryStructure.addDictionaryIndex(new DictionaryIndex('ü'), 1);
		dictionaryStructure.addDictionaryIndex(new DictionaryIndex('ß'), 10);

		assertTrue(dictionaryStructure.containsDictionaryIndex(new DictionaryIndex('a')));
		assertEquals(2, dictionaryStructure.getDictionaryIndexCount(new DictionaryIndex('a')));

		assertTrue(dictionaryStructure.containsDictionaryIndex(new DictionaryIndex('A')));
		assertEquals(0, dictionaryStructure.getDictionaryIndexCount(new DictionaryIndex('A')));

		assertTrue(dictionaryStructure.containsDictionaryIndex(new DictionaryIndex('c')));
		assertEquals(Integer.MAX_VALUE, dictionaryStructure.getDictionaryIndexCount(new DictionaryIndex('c')));

		assertTrue(dictionaryStructure.containsDictionaryIndex(new DictionaryIndex('b')));
		assertEquals(109, dictionaryStructure.getDictionaryIndexCount(new DictionaryIndex('b')));

		assertTrue(dictionaryStructure.containsDictionaryIndex(new DictionaryIndex('ü')));
		assertEquals(1, dictionaryStructure.getDictionaryIndexCount(new DictionaryIndex('ü')));

		assertTrue(dictionaryStructure.containsDictionaryIndex(new DictionaryIndex('ß')));
		assertEquals(10, dictionaryStructure.getDictionaryIndexCount(new DictionaryIndex('ß')));

		assertFalse(dictionaryStructure.containsDictionaryIndex(new DictionaryIndex(' ')));
		assertFalse(dictionaryStructure.containsDictionaryIndex(new DictionaryIndex('\\')));
		assertFalse(dictionaryStructure.containsDictionaryIndex(new DictionaryIndex('g')));
		assertFalse(dictionaryStructure.containsDictionaryIndex(new DictionaryIndex('9')));

	}
}
