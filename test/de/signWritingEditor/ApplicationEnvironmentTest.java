package de.signWritingEditor;

import org.junit.Test;

public class ApplicationEnvironmentTest {

	@Test
	public void testAssertionsEnabled() {
		try {
			assert false;
			throw new RuntimeException("Assertions not enabled. Use '-ea' in your vm arguments.");
		} catch (AssertionError e) {
			// ignore
		}
	}
}
