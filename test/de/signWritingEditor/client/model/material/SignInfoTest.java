package de.signWritingEditor.client.model.material;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import de.signWritingEditor.shared.model.material.SignInfo;

public class SignInfoTest {

	@Test
	public void testAll() {
		SignInfo signInfo = new SignInfo("TestSignInfo 1", "noImage", 100, 170);
		assertEquals(100, signInfo.getWidth());
		assertEquals(170, signInfo.getHeight());
		assertEquals("noImage", signInfo.getImageName());

		assertFalse(signInfo.isEmpty());

		// equals() depends on contentId
		SignInfo equalSignInfo = new SignInfo("TestSignInfo 1", "alsoNoImage", 13, 9);
		assertEquals(signInfo, equalSignInfo);
		assertEquals(signInfo.hashCode(), equalSignInfo.hashCode());

		SignInfo differentSignInfo = new SignInfo("DifferentInfoID 1", equalSignInfo.getImageName(),
				equalSignInfo.getWidth(), equalSignInfo.getHeight());
		assertFalse(signInfo.equals(differentSignInfo));
		assertFalse(equalSignInfo.equals(differentSignInfo));

		SignInfo hugeWidthSignInfo = new SignInfo("HugeWidthInfo", "stillNoImageName", 31 + SignInfo.MAX_IMAGE_HEIGHT,
				13);
		assertEquals(SignInfo.MAX_IMAGE_HEIGHT + 31, hugeWidthSignInfo.getWidth());
		assertEquals(13, hugeWidthSignInfo.getHeight());

		int testWidth = 51;
		int hugeHeight = 137 + SignInfo.MAX_IMAGE_HEIGHT;
		double ratio = 1.0 * testWidth / hugeHeight;
		SignInfo hugeHeightSignInfo = new SignInfo("HugeHeightInfo", "stillNoImageName", testWidth, hugeHeight);
		int expectedWidth = (int) (ratio * SignInfo.MAX_IMAGE_HEIGHT);
		assertEquals(expectedWidth, hugeHeightSignInfo.getWidth());
		assertEquals(SignInfo.MAX_IMAGE_HEIGHT, hugeHeightSignInfo.getHeight());

		SignInfo emptySignInfo1 = new SignInfo("EmptyHeight", "nope", 100, 0);
		SignInfo emptySignInfo2 = new SignInfo("EmptyWidth", "nope", 0, 10);
		SignInfo emptySignInfo3 = new SignInfo("EmptyImage", "", 13, 10);
		assertTrue(emptySignInfo1.isEmpty());
		assertTrue(emptySignInfo2.isEmpty());
		assertTrue(emptySignInfo3.isEmpty());
	}
}
