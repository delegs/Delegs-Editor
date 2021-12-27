package de.signWritingEditor.client;

import junit.framework.TestCase;

import org.junit.Test;

import de.signWritingEditor.client.GWTClient.ui.general.textHandling.UniversalLocaleCollator;

public class UniversalLocaleCollatorTest extends TestCase {

	@Test
	public void testAll() {
		assertEquals(0, UniversalLocaleCollator.compareTo(null, null));
		assertEquals(0, UniversalLocaleCollator.compareTo(null, ""));
		assertEquals(0, UniversalLocaleCollator.compareTo("", null));
		assertEquals(0, UniversalLocaleCollator.compareTo("", ""));
		assertEquals(0, UniversalLocaleCollator.compareTo("abc", "abc"));
		assertEquals(0, UniversalLocaleCollator.compareTo("abc", "ABC"));
		assertEquals(0, UniversalLocaleCollator.compareTo("abc", "äbc"));
		assertEquals(-1, UniversalLocaleCollator.compareTo("abc", "abcd"));
		assertEquals(-1, UniversalLocaleCollator.compareTo("abc", "bcd"));
		assertEquals(-1, UniversalLocaleCollator.compareTo("abc", "abd"));
		assertEquals(-1, UniversalLocaleCollator.compareTo("Österreich", "Zypern"));
		assertEquals(1, UniversalLocaleCollator.compareTo("abcd", "abc"));
		assertEquals(1, UniversalLocaleCollator.compareTo("bcd", "abc"));
		assertEquals(1, UniversalLocaleCollator.compareTo("abd", "abc"));
		assertEquals(1, UniversalLocaleCollator.compareTo("Zypern", "Österreich"));
	}

}
