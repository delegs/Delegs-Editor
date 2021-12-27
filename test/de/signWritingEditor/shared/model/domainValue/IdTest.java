package de.signWritingEditor.shared.model.domainValue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import de.signWritingEditor.shared.model.domainValue.Id;

public class IdTest {

	@Test
	public void testAll() {
		Id id1 = new Id(2, 1);

		assertEquals(2, id1.getUpperIdPart());
		assertEquals(1, id1.getLowerIdPart());

		Id id2 = new Id(3, 1);

		assertEquals(3, id2.getUpperIdPart());
		assertEquals(1, id2.getLowerIdPart());

		assertFalse(id1.equals(id2));

		Id id3 = new Id(2, 2);

		assertEquals(2, id3.getUpperIdPart());
		assertEquals(2, id3.getLowerIdPart());

		assertFalse(id1.equals(id3));

		Id id4 = new Id(2, 1);

		assertEquals(2, id4.getUpperIdPart());
		assertEquals(1, id4.getLowerIdPart());

		assertTrue(id1.equals(id4));
	}
}
