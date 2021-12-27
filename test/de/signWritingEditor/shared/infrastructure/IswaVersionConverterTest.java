package de.signWritingEditor.shared.infrastructure;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class IswaVersionConverterTest {

	@Test
	public void testConvertIswa2008To2010() {
		IswaVersionConverter iswaConverter = new IswaVersionConverter();

		assertEquals("01-01-001-01-01-01", iswaConverter.convertIswa2008To2010("01-01-001-01-01-01"));
		assertEquals("01-02-009-01-05-16", iswaConverter.convertIswa2008To2010("01-02-007-02-05-16"));
	}

	@Test
	public void testConvertIswa2010To2008() {
		IswaVersionConverter iswaConverter = new IswaVersionConverter();

		assertEquals("01-01-001-01-01-01", iswaConverter.convertIswa2010To2008("01-01-001-01-01-01"));
		assertEquals("01-02-007-02-06-01", iswaConverter.convertIswa2010To2008("01-02-009-01-06-01"));
		assertEquals("03-01-007-01-01-01", iswaConverter.convertIswa2010To2008("04-02-007-01-01-01"));
	}

	@Test
	public void testIsValidIswa2008() {
		IswaVersionConverter iswaConverter = new IswaVersionConverter();

		assertTrue(iswaConverter.isValidIswa2008("01-01-001-01-01-01"));
		assertTrue(iswaConverter.isValidIswa2008("01-02-009-01-06-01"));
		assertTrue(iswaConverter.isValidIswa2008("03-01-007-01-01-01"));
		assertFalse(iswaConverter.isValidIswa2008("04-02-007-01-01-15"));
	}
}
