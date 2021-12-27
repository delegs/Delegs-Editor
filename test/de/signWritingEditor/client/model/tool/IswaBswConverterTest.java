package de.signWritingEditor.client.model.tool;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.signWritingEditor.shared.infrastructure.IswaBswConverter;

public class IswaBswConverterTest {
	@Test
	public void testAll() {
		IswaBswConverter iswaBswConverter = new IswaBswConverter();

		String iswaString1 = "01-01-001-01-01-01";
		String iswaString2 = "01-01-001-01-02-02";
		String iswaString3 = "04-02-007-01-01-01";

		assertEquals(iswaString1, iswaBswConverter.convertBswToIswa(0x100, 0, 0));
		assertEquals(iswaString2, iswaBswConverter.convertBswToIswa(0x100, 1, 1));
		assertEquals(iswaString3, iswaBswConverter.convertBswToIswa(0x321, 0, 0));

		assertEquals("10000", iswaBswConverter.convertIswaToBsw(iswaString1));
		assertEquals("10011", iswaBswConverter.convertIswaToBsw(iswaString2));
		assertEquals("32100", iswaBswConverter.convertIswaToBsw(iswaString3));
	}
}
