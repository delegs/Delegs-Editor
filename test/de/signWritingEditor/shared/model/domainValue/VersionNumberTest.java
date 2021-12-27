package de.signWritingEditor.shared.model.domainValue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import de.signWritingEditor.shared.model.domainValue.VersionNumber;

public class VersionNumberTest {

	@Test
	public void testAll() {
		VersionNumber versionNumber = new VersionNumber(1, 2, 3);
		assertEquals("1.2.3", versionNumber.toString());
		assertEquals(1, versionNumber.getMajorVersion());
		assertEquals(2, versionNumber.getMinorVersion());
		assertEquals(3, versionNumber.getSpecialVersion());

		VersionNumber versionNumber2 = new VersionNumber(4, 5);
		assertEquals("4.5", versionNumber2.toString());
		assertEquals(4, versionNumber2.getMajorVersion());
		assertEquals(5, versionNumber2.getMinorVersion());
		assertEquals(0, versionNumber2.getSpecialVersion());

		VersionNumber versionNumber3 = new VersionNumber(6, 7, 0);
		assertEquals("6.7", versionNumber3.toString());

		VersionNumber versionNumber4 = new VersionNumber("8.9.10");
		assertEquals("8.9.10", versionNumber4.toString());
		assertEquals(8, versionNumber4.getMajorVersion());
		assertEquals(9, versionNumber4.getMinorVersion());
		assertEquals(10, versionNumber4.getSpecialVersion());

		VersionNumber versionNumber5 = new VersionNumber("11.12");
		assertEquals("11.12", versionNumber5.toString());
		assertEquals(11, versionNumber5.getMajorVersion());
		assertEquals(12, versionNumber5.getMinorVersion());
		assertEquals(0, versionNumber5.getSpecialVersion());

		VersionNumber versionNumber6 = new VersionNumber(11, 12);

		assertTrue(versionNumber.compareTo(versionNumber2) < 0);
		assertTrue(versionNumber4.compareTo(versionNumber3) > 0);
		assertTrue(versionNumber6.compareTo(versionNumber5) == 0);

		assertEquals(versionNumber6, versionNumber5);
		assertEquals(versionNumber6.hashCode(), versionNumber5.hashCode());
		assertFalse(versionNumber4.equals(versionNumber2));

		assertFalse(VersionNumber.isValidVersionString("aGsdSgagagaa"));
		assertFalse(VersionNumber.isValidVersionString("fs.fs.as"));
		assertFalse(VersionNumber.isValidVersionString("9.5."));
		assertFalse(VersionNumber.isValidVersionString("9.5.6."));
		assertFalse(VersionNumber.isValidVersionString("9.5.6.8"));

		assertTrue(VersionNumber.isValidVersionString("1456.2983917.151515234"));
		assertTrue(VersionNumber.isValidVersionString("1456.2983917." + Integer.MAX_VALUE));
		assertTrue(VersionNumber.isValidVersionString("17585.56757"));
	}

}
