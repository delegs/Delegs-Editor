package de.signWritingEditor.client.model.material;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;

import org.junit.Test;

import de.signWritingEditor.shared.model.domainValue.DocumentIndex;

public class DocumentIndexTest {

	@Test
	public void testDocumentIndex() {
		DocumentIndex documentIndex;

		try {
			documentIndex = new DocumentIndex(-1, 0, 0);
			fail("invalid sectionIndex parameter");
		} catch (AssertionError e) {
		}
		try {
			documentIndex = new DocumentIndex(0, -1, 0);
			fail("invalid paragraphIndex parameter");
		} catch (AssertionError e) {
		}
		try {
			documentIndex = new DocumentIndex(0, 0, -1);
			fail("invalid tokenIndex parameter");
		} catch (AssertionError e) {
		}

		documentIndex = new DocumentIndex(1, 2, 3);

		assertEquals(1, documentIndex.getSectionIndex());
		assertEquals(2, documentIndex.getParagraphIndex());
		assertEquals(3, documentIndex.getTokenIndex());

		DocumentIndex same = new DocumentIndex(1, 2, 3);
		DocumentIndex other1 = new DocumentIndex(2, 2, 3);
		DocumentIndex other2 = new DocumentIndex(1, 1, 3);
		DocumentIndex other3 = new DocumentIndex(1, 2, 2);

		assertEquals(documentIndex, same);
		assertFalse(documentIndex.equals(other1));
		assertFalse(documentIndex.equals(other2));
		assertFalse(documentIndex.equals(other3));

		assertEquals(documentIndex.hashCode(), same.hashCode());
		assertFalse(documentIndex.hashCode() == other1.hashCode());
		assertFalse(documentIndex.hashCode() == other2.hashCode());
		assertFalse(documentIndex.hashCode() == other3.hashCode());
	}
}
