package de.signWritingEditor.shared.model.material;

import java.io.Serializable;
import java.util.Date;

public class ExpiryDate implements Serializable {

	private static final long serialVersionUID = 66578278627L;
	private static final long MILLISECONDS_PER_HOUR = 3_600_000L;
	private static final ExpiryDate ENDLESS = new ExpiryDate(Long.MAX_VALUE);
	private Date _expiryDate;

	protected ExpiryDate() {
	}

	private ExpiryDate(Date expiryDate) {
		_expiryDate = expiryDate;
	}

	private ExpiryDate(long milliseconds) {
		_expiryDate = new Date(milliseconds);
	}

	public boolean isInFuture() {
		return _expiryDate.after(new Date());
	}

	public static ExpiryDate endless() {
		return ENDLESS;
	}

	public long getMillisecondsSinceUnixEpoch() {
		return _expiryDate.getTime();
	}

	public static ExpiryDate fromDate(Date date) {
		return new ExpiryDate(date);
	}

	public static ExpiryDate fromMilliseconds(long milliseconds) {
		return new ExpiryDate(milliseconds);
	}

	public static ExpiryDate now() {
		return new ExpiryDate(new Date());
	}

	public ExpiryDate plusMilliseconds(long milliseconds) {
		assert milliseconds > 0 : "Precondition failed: milliseconds > 0";

		if ((Long.MAX_VALUE - _expiryDate.getTime()) < milliseconds) {
			throw new UnsupportedOperationException("Overflow of Long");
		}

		long current = _expiryDate.getTime();
		long sum = current + milliseconds;
		return new ExpiryDate(sum);
	}

	public ExpiryDate plusHours(int hours) {
		return plusMilliseconds(hours * MILLISECONDS_PER_HOUR);
	}

	@Override
	public String toString() {
		return "ExpiryDate [_expiryDate=" + _expiryDate + "]";
	}

}
