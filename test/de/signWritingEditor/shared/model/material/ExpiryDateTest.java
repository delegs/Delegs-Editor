package de.signWritingEditor.shared.model.material;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

public class ExpiryDateTest {

	@Test
	public void testIsInFuture_createdFromNowByAddingHours_isInFuture() {
		// Prepare
		int hours = 8;

		// Action
		ExpiryDate eightHoursLater = ExpiryDate.now().plusHours(hours);

		// Check
		assertTrue(eightHoursLater.isInFuture());
	}

	@Test
	public void testIsInFuture_threeSecondsLater_isTrue() {
		// Prepare
		long milliseconds = 3000;
		ExpiryDate threeSecondsLater = ExpiryDate.now().plusMilliseconds(milliseconds);

		// Check
		assertTrue(threeSecondsLater.isInFuture());
	}

	@Test
	public void testGetTime_isAsExpected() {
		// Prepare
		Date date = new Date();
		ExpiryDate expiryDate = ExpiryDate.fromDate(date);

		// Action
		long time = expiryDate.getMillisecondsSinceUnixEpoch();

		// Check
		assertEquals(date.getTime(), time);
	}

	@Test
	public void testGetEndless_isInFuture() {
		// Action
		ExpiryDate expiryDate = ExpiryDate.endless();

		// Check
		assertTrue(expiryDate.isInFuture());
	}

	@Test(expected = UnsupportedOperationException.class)
	public void testEndless_addingToEndless_throwsException() {
		// Prepare
		ExpiryDate endless = ExpiryDate.endless();

		// Action
		ExpiryDate next = endless.plusMilliseconds(1);
	}

	@Test
	public void testPlusMilliseconds_isAsExpected() {
		// Prepare
		long milliseconds = 3000;
		ExpiryDate date = ExpiryDate.now();

		// Action
		ExpiryDate threeSecondsLater = date.plusMilliseconds(milliseconds);

		// Check
		assertEquals(milliseconds,
				threeSecondsLater.getMillisecondsSinceUnixEpoch() - date.getMillisecondsSinceUnixEpoch());
	}

	@Test
	public void testFromMilliseconds_isAsExpected() {
		// Prepare
		long milliseconds = 3000;

		// Action
		ExpiryDate date = ExpiryDate.fromMilliseconds(milliseconds);

		// Check
		assertEquals(milliseconds, date.getMillisecondsSinceUnixEpoch());
	}

	@Test
	public void testPlusHours_isAsExpected() {
		// Prepare
		int hours = 10;
		ExpiryDate date = ExpiryDate.now();

		// Action
		ExpiryDate tenHoursLater = date.plusHours(hours);

		// Check
		assertEquals(TimeUnit.HOURS.toMillis(hours),
				tenHoursLater.getMillisecondsSinceUnixEpoch() - date.getMillisecondsSinceUnixEpoch());
	}
}
