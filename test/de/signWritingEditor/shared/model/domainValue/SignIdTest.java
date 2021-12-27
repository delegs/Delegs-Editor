package de.signWritingEditor.shared.model.domainValue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class SignIdTest {

	private SignSource source1;
	private SignSource source2;
	private SignId signId;
	private SignId signIdEqual;
	private SignId signIdNotEqualUpperID;
	private SignId signIdNotEqualLowerID;
	private SignId signIdNotEqualLocale;
	private SignId signIdNotEqualSource;
	private SignId signIdNotEqualAll;
	private SignId signIdEqualButOtherRevision;

	@Before
	public void setup() {
		source1 = SignSource.DELEGS;
		source2 = SignSource.IMPORTED;
		signId = new SignId(12, "23", SignLocale.DGS, source1);
		signIdEqual = new SignId(12, "23", SignLocale.DGS, source1);
		signIdNotEqualUpperID = new SignId(99, "23", SignLocale.DGS, source1);
		signIdNotEqualLowerID = new SignId(12, "99", SignLocale.DGS, source1);
		signIdNotEqualLocale = new SignId(12, "23", SignLocale.ASL, source1);
		signIdNotEqualSource = new SignId(12, "23", SignLocale.DGS, source2);
		signIdNotEqualAll = new SignId(56, "78", SignLocale.ASL, source2);
		signIdEqualButOtherRevision = new SignId(12, "23", SignLocale.DGS, source1);
	}

	@Test
	public void testEquals() {

		assertTrue(signId.equals(signIdEqual));
		assertTrue(signId.equals(signIdEqualButOtherRevision));
		assertFalse(signId.equals(signIdNotEqualUpperID));
		assertFalse(signId.equals(signIdNotEqualLowerID));
		assertFalse(signId.equals(signIdNotEqualLocale));
		assertFalse(signId.equals(signIdNotEqualAll));
		assertFalse(signId.equals(signIdNotEqualSource));
	}

	@Test
	public void testToString() {
		assertEquals(signId.toString(), "SignId(upperIdPart: 12, lowerIdPart: 23, signLocale: DGS, source: DELEGS)");
	}

}
