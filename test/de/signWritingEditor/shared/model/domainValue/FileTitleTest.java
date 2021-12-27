package de.signWritingEditor.shared.model.domainValue;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class FileTitleTest {

	@Test
	public void testIsValidTitle() {
		assertTrue(FileTitle.isValidTitle("Hallo"));
		assertTrue(FileTitle.isValidTitle("Hallo du"));
		assertTrue(FileTitle.isValidTitle("Hallo du Hallo du Hallo du"));
		assertTrue(FileTitle.isValidTitle("Hallo du Hallo du Hallo"));
		assertTrue(FileTitle.isValidTitle("öüäÖÜÄß"));
		assertTrue(FileTitle.isValidTitle("1234567890"));
		assertTrue(FileTitle.isValidTitle("àâáèêéìîíòôóùûúÀÂÁÈÊÉÌÎÍÒÔÓÙÛÚ"));
		assertTrue(FileTitle.isValidTitle("f"));
		assertTrue(FileTitle.isValidTitle("1"));
		assertTrue(FileTitle.isValidTitle("_"));
		assertTrue(FileTitle.isValidTitle("!"));
		assertTrue(FileTitle.isValidTitle("\""));
		assertTrue(FileTitle.isValidTitle("§"));
		assertTrue(FileTitle.isValidTitle("$"));
		assertTrue(FileTitle.isValidTitle("%"));
		assertTrue(FileTitle.isValidTitle("&"));
		assertTrue(FileTitle.isValidTitle("()"));
		assertTrue(FileTitle.isValidTitle("[]"));
		assertTrue(FileTitle.isValidTitle("{}"));
		assertTrue(FileTitle.isValidTitle("="));
		assertTrue(FileTitle.isValidTitle("?"));
		assertTrue(FileTitle.isValidTitle("@"));
		assertTrue(FileTitle.isValidTitle("€"));
		assertTrue(FileTitle.isValidTitle("*"));
		assertTrue(FileTitle.isValidTitle("+"));
		assertTrue(FileTitle.isValidTitle("~"));
		assertTrue(FileTitle.isValidTitle("#"));
		assertTrue(FileTitle.isValidTitle("-"));
		assertTrue(FileTitle.isValidTitle("|"));
		assertTrue(FileTitle.isValidTitle("."));
		assertTrue(FileTitle.isValidTitle(":"));
		assertTrue(FileTitle.isValidTitle(","));
		assertTrue(FileTitle.isValidTitle("<"));
		assertTrue(FileTitle.isValidTitle(">"));
		assertTrue(FileTitle.isValidTitle("!\"§$%&()[]{}=?@€*+~#_-|.:,<>"));
		assertTrue(FileTitle.isValidTitle("xxxx'xxxx"));
		assertTrue(FileTitle.isValidTitle("xxxx°xxxx"));

		assertFalse(FileTitle.isValidTitle(null));
		assertFalse(FileTitle.isValidTitle(""));
		assertFalse(FileTitle.isValidTitle(" "));
		assertFalse(FileTitle.isValidTitle("    "));
		assertFalse(FileTitle.isValidTitle(" xxxx"));
		assertFalse(FileTitle.isValidTitle("xxx  xxx"));
		assertFalse(FileTitle.isValidTitle("xxx xxx xxx xxx "));
		assertFalse(FileTitle.isValidTitle("xxxxx "));
		assertFalse(FileTitle.isValidTitle("xxxx\txxx"));
		assertFalse(FileTitle.isValidTitle("xxxx/xxxxx"));
		assertFalse(FileTitle.isValidTitle("xxxx\\xxxx"));
		assertFalse(FileTitle.isValidTitle("xxxx^xxxxx"));
		assertFalse(FileTitle.isValidTitle("xxxx´xxxx"));
		assertFalse(FileTitle.isValidTitle("xxxx`xxxx"));
		assertFalse(FileTitle.isValidTitle(";"));
	}

	@Test
	public void testEquals() {
		FileTitle documentTitle1a = new FileTitle("title 1");
		FileTitle documentTitle1b = new FileTitle("title 1");
		FileTitle documentTitle2 = new FileTitle("title 2");
		FileTitle documentTitle2b = new FileTitle("TiTlE 2");

		assertTrue(documentTitle1a.equals(documentTitle1a));
		assertTrue(documentTitle1b.equals(documentTitle1a));
		assertFalse(documentTitle2.equals(documentTitle1a));
		assertTrue(documentTitle2b.equals(documentTitle2));

	}
}
