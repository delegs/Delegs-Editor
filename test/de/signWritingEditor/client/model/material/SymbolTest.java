package de.signWritingEditor.client.model.material;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

import de.signWritingEditor.shared.model.domainValue.Symbol;

public class SymbolTest {

	@Test
	public void testConstructor() {
		Symbol id = new Symbol(1, 2, 3, 4, 5, 6, 7, 8);
		assertEquals(1, id.getCategory());
		assertEquals(2, id.getGroup());
		assertEquals(3, id.getSymbol());
		assertEquals(4, id.getVariation());
		assertEquals(5, id.getFill());
		assertEquals(6, id.getRotation());
		assertEquals(7, id.getWidth());
		assertEquals(8, id.getHeight());
	}

	@Test
	public void testGetIswaId() {
		assertEquals("01-01-001-01-01-01", new Symbol(1, 1, 1, 1, 1, 1, 0, 0).getIswaId());
		assertEquals("99-99-999-99-06-16", new Symbol(99, 99, 999, 99, 6, 16, 0, 0).getIswaId());
	}

	@Test
	public void testToString() {
		assertEquals("01-01-001-01-01-01", new Symbol(1, 1, 1, 1, 1, 1, 0, 0).toString());
		assertEquals("99-99-999-99-06-16", new Symbol(99, 99, 999, 99, 6, 16, 0, 0).toString());
	}

	@Test
	public void testEquals() {
		Symbol symbol = new Symbol(1, 1, 1, 1, 1, 1, 0, 0);
		Symbol same = new Symbol(1, 1, 1, 1, 1, 1, 0, 0);
		Symbol same2 = new Symbol(1, 1, 1, 1, 1, 1, 30, 40);

		Symbol other1 = new Symbol(2, 1, 1, 1, 1, 1, 0, 0);
		Symbol other2 = new Symbol(1, 2, 1, 1, 1, 1, 0, 0);
		Symbol other3 = new Symbol(1, 1, 2, 1, 1, 1, 0, 0);
		Symbol other4 = new Symbol(1, 1, 1, 2, 1, 1, 0, 0);
		Symbol other5 = new Symbol(1, 1, 1, 1, 2, 1, 0, 0);
		Symbol other6 = new Symbol(1, 1, 1, 1, 1, 2, 0, 0);

		assertEquals(symbol, same);
		assertEquals(symbol, same2);
		assertEquals(symbol.hashCode(), same.hashCode());
		assertEquals(symbol.hashCode(), same2.hashCode());

		assertFalse(symbol.equals(other1));
		assertFalse(symbol.equals(other2));
		assertFalse(symbol.equals(other3));
		assertFalse(symbol.equals(other4));
		assertFalse(symbol.equals(other5));
		assertFalse(symbol.equals(other6));

		assertFalse(symbol.hashCode() == other1.hashCode());
		assertFalse(symbol.hashCode() == other2.hashCode());
		assertFalse(symbol.hashCode() == other3.hashCode());
		assertFalse(symbol.hashCode() == other4.hashCode());
		assertFalse(symbol.hashCode() == other5.hashCode());
		assertFalse(symbol.hashCode() == other6.hashCode());
	}

}
